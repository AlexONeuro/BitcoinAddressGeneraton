package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.ConvertToBinary.convertToBinary;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.HexToBytes.hexToBytes;
import com.alex_acelerator.bitaddress.BitcoinAddressCreator.SHA256_HASH.SHA256;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public final class BIP39Converter {
    private static List<String>wordListBIP39;
    static
    {
        try {
            wordListBIP39 = Files.readAllLines(Paths.get("src/Recourses/words.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList getWordsFromKey(String privateKey){
        ArrayList<String> words = new ArrayList<>();
        String binaryPrivateKey = String.valueOf(convertToBinary(hexToBytes(privateKey)));
        String checksum = SHA256.getHash(hexToBytes(privateKey)).substring(0,2);
        String binaryChecksum =  Integer.toBinaryString(Integer.parseInt(checksum,16));
        //заменить на String.format?
        binaryChecksum = "00000000".substring(0,8-binaryChecksum.length()) + binaryChecksum;
        String binaryWords = binaryPrivateKey + binaryChecksum;
        int wordIndex;
        for (int i = 0; i < binaryWords.length(); i+=11) {
          wordIndex = Integer.parseInt(binaryWords.substring(i,i+11),2);
            words.add(wordListBIP39.get(wordIndex));
        }
        return words;
    }

    public static String getKeyFromWords(List<String> words){
        int wordIndex;
        StringBuilder result = new StringBuilder();
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            wordIndex = wordListBIP39.indexOf(words.get(i));
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(wordIndex));
            //noinspection Since15
            binaryString.append("0".repeat(11-binary.length()));
            binaryString.append(binary);
        }
        binaryString = new StringBuilder(binaryString.substring(0, binaryString.length() - 8));
        for (int i = 0; i < binaryString.length(); i+=4) {
            result.append(Integer.toHexString(Integer.parseInt(String.valueOf(binaryString.substring(i,i+4)),2)));
        }
        return result.toString();
    }
    public static void main(String[] args) {

        String privateKey ="0C28FCA386C7A227600B2FE50B7CAE11EC86D3BF1FBE471BE89827E19D72AA1D";
       // String privateKey ="a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
        System.out.println(privateKey.length());
        ArrayList<String> list = getWordsFromKey(privateKey);
        System.out.println(list);
        for (String word: list
             ) {
            System.out.print(word + " ");
        }
        System.out.println("");
        String restoredKey = getKeyFromWords(list);
        System.out.println(restoredKey);
    }
}
