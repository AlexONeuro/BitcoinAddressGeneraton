package com.alex_acelerator.bitaddress.BitcoinAddressCreator.SHA256_HASH;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.ConvertToBinary.convertToBinary;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.HexToBytes.hexToBytes;

public final class SHA256 {
    static Word h0 = new Word(0x6a09e667L);
    static Word h1 = new Word(0xbb67ae85L);
    static Word h2 = new Word(0x3c6ef372L);
    static Word h3 = new Word(0xa54ff53aL);
    static Word h4 = new Word(0x510e527fL);
    static Word h5 = new Word(0x9b05688cL);
    static Word h6 = new Word(0x1f83d9abL);
    static Word h7 = new Word(0x5be0cd19L);

    public static String getSHA256Hash(byte[] bytes) {

        StringBuilder resultHash = new StringBuilder();
        StringBuilder temptHash;
        StringBuilder str = convertToBinary(bytes);
        bufferBuild(str);
        for (int i = 0; i < str.length(); i += 512) {
            hashAndRotate(new StringBuilder(str.substring(i, i + 512)));
        }

        temptHash = new StringBuilder();
        temptHash.append(h0).append(h1).append(h2).append(h3)
                .append(h4).append(h5).append(h6).append(h7);

        for (int i = 0; i <= temptHash.length() - 4; i += 4) {
            resultHash.append(Long.toHexString(Long.parseLong(temptHash.substring(i, i + 4), 2)));
        }

        h0 = new Word(0x6a09e667L);
        h1 = new Word(0xbb67ae85L);
        h2 = new Word(0x3c6ef372L);
        h3 = new Word(0xa54ff53aL);
        h4 = new Word(0x510e527fL);
        h5 = new Word(0x9b05688cL);
        h6 = new Word(0x1f83d9abL);
        h7 = new Word(0x5be0cd19L);

        return resultHash.toString();
    }


    private static StringBuilder bufferBuild(StringBuilder str) {
        int initialLength = str.length();
        str.append(1);
        int length = str.length();
        int appendLength = 0;
        int floorMod = Math.floorMod(length, 512);

        if (floorMod == 0) {
            if (length <= 448) appendLength = 448 - length;
            if (length > 448) appendLength = 512 - floorMod + 448;
            if (length == 512) appendLength = 448;
        }

        if (floorMod != 0) {
            if (floorMod <= 448) appendLength = 448 - floorMod;
            if (floorMod > 448) appendLength = 512 - floorMod + 448;
        }

        for (int i = 0; i < appendLength; i++) {
            str.append(0);
        }

        StringBuilder bigEndian = new StringBuilder();
        appendLength = 64 - Integer.toBinaryString(initialLength).length();
        for (int i = 0; i < appendLength; i++) {
            bigEndian.append("0");
        }
        bigEndian.append(Integer.toBinaryString(initialLength));
        str.append(bigEndian);

        return str;
    }

    private static void hashAndRotate(StringBuilder str) {
        /**
         * Запускаем основной цикл для каждой 512-битной части сообщения
         *
         *
         * Создадим 8 значений хеша. Это константы, представляющие
         *  первые 32 бита дробных частей квадратных корней первых
         *  8 простых чисел: 2, 3, 5, 7, 11, 13, 17, 19.
         */


        /**
         * Создадим массив округленных констант k.
         * Каждое значение — это первые 32 бита дробных
         * частей кубических корней первых 64 простых чисел (2–311).
         */

        long[] k = {
                0x428a2f98L, 0x71374491L, 0xb5c0fbcfL, 0xe9b5dba5L, 0x3956c25bL, 0x59f111f1L, 0x923f82a4L, 0xab1c5ed5L,
                0xd807aa98L, 0x12835b01L, 0x243185beL, 0x550c7dc3L, 0x72be5d74L, 0x80deb1feL, 0x9bdc06a7L, 0xc19bf174L,
                0xe49b69c1L, 0xefbe4786L, 0x0fc19dc6L, 0x240ca1ccL, 0x2de92c6fL, 0x4a7484aaL, 0x5cb0a9dcL, 0x76f988daL,
                0x983e5152L, 0xa831c66dL, 0xb00327c8L, 0xbf597fc7L, 0xc6e00bf3L, 0xd5a79147L, 0x06ca6351L, 0x14292967L,
                0x27b70a85L, 0x2e1b2138L, 0x4d2c6dfcL, 0x53380d13L, 0x650a7354L, 0x766a0abbL, 0x81c2c92eL, 0x92722c85L,
                0xa2bfe8a1L, 0xa81a664bL, 0xc24b8b70L, 0xc76c51a3L, 0xd192e819L, 0xd6990624L, 0xf40e3585L, 0x106aa070L,
                0x19a4c116L, 0x1e376c08L, 0x2748774cL, 0x34b0bcb5L, 0x391c0cb3L, 0x4ed8aa4aL, 0x5b9cca4fL, 0x682e6ff3L,
                0x748f82eeL, 0x78a5636fL, 0x84c87814L, 0x8cc70208L, 0x90befffaL, 0xa4506cebL, 0xbef9a3f7L, 0xc67178f2L
        };

        Word[] w = new Word[64];
        for (int i = 0; i < 64; i++) {
            w[i] = new Word("00000000000000000000000000000000");
        }


        ArrayList<Word> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i += 32) {
            list.add(new Word(str.substring(i, i + 32)));
        }

        for (int i = 0; i < list.size(); i++) {
            w[i] = list.get(i);
        }

        Word s0;
        Word s1;
        for (int i = 16; i < w.length; i++) {

            s0 = w[i - 15].rightRotate(7).xor(w[i - 15].rightRotate(18).xor(w[i - 15].rightShift(3)));

            s1 = w[i - 2].rightRotate(17).xor(w[i - 2].rightRotate(19).xor(w[i - 2].rightShift(10)));

            w[i] = w[i - 16].add(s0).add(w[i - 7]).add(s1);

        }
/**
 * Начнем цикл сжатия
 */

        /**
         *Еще немного переменных
         */

        Word a = new Word(h0.wordValue);
        Word b = new Word(h1.wordValue);
        Word c = new Word(h2.wordValue);
        Word d = new Word(h3.wordValue);
        Word e = new Word(h4.wordValue);
        Word f = new Word(h5.wordValue);
        Word g = new Word(h6.wordValue);
        Word h = new Word(h7.wordValue);

        for (int i = 0; i < 64; i++) {
            Word S1 = e.rightRotate(6).xor(e.rightRotate(11)).xor(e.rightRotate(25));
            Word ch = e.and(f).xor(e.not().and(g));
            Word temp1 = h.add(S1).add(ch).add(new Word(k[i])).add(w[i]);
            Word S0 = a.rightRotate(2).xor(a.rightRotate(13)).xor(a.rightRotate(22));
            Word maj = (a.and(b)).xor(a.and(c)).xor(b.and(c));
            Word temp2 = S0.add(maj);
            h = new Word(g.wordValue);
            g = new Word(f.wordValue);
            f = new Word(e.wordValue);
            e = d.add(temp1);
            d = new Word(c.wordValue);
            c = new Word(b.wordValue);
            b = new Word(a.wordValue);
            a = temp1.add(temp2);
        }

        h0 = h0.add(a);
        h1 = h1.add(b);
        h2 = h2.add(c);
        h3 = h3.add(d);
        h4 = h4.add(e);
        h5 = h5.add(f);
        h6 = h6.add(g);
        h7 = h7.add(h);

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s = "042ac571520643b585beb6bdd7ce7ae8fea8566face743f2fb991ae0e9a055f3987bd40caf1f3bb7f88bd1d522b2244b7caba80d018c02de819a25ea7e99309a4";

        System.out.println(getSHA256Hash(hexToBytes(s)));
        System.out.println(getSHA256Hash(s.getBytes()));
        System.out.println("ac8a9fa3c12b209ee321e5e39f37a803da619b55ff4ca5b44bd3214b8ac167c7");

    }

}


