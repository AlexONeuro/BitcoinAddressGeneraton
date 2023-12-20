package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

import java.util.Arrays;

public final class HexToBytes {

    public static void main(String[] args) {
        String s = "12131415";
        byte[] b = hexToBytes(s);
        String r = Arrays.toString(b);
        System.out.println(r);
    }

    public static byte[] hexToBytes(String msg) {
        StringBuilder str = new StringBuilder(msg);
        if(msg.equals("")) return new byte[1];
        if(msg.length()%2 !=0 ) str.insert(0,"0");
        byte[] bytes = new byte[str.length()/2];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(str.substring(i*2,i*2+2),16);
        }
        return bytes;
    }
}
