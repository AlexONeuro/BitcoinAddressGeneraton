package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

public final class BytesToString {

    public static String getString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            result.append(String.format("%02x", bytes[i]));
        }
        return result.toString();
    }
}
