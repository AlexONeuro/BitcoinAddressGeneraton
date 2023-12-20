package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

public final class ConvertToBinary {
    public static StringBuilder convertToBinary(byte[] input) {
        StringBuilder result = new StringBuilder();
        for (Byte b : input) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                result.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return result;
    }
}
