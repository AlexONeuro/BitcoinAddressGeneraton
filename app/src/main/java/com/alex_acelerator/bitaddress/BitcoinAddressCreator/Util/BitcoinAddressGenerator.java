package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.HexToBytes.hexToBytes;

import com.alex_acelerator.bitaddress.BitcoinAddressCreator.SHA256_HASH.SHA256;

import com.alex_acelerator.bitaddress.BitcoinAddressCreator.EllipticCrypto.CountPoint;
import java.math.BigInteger;



public final class BitcoinAddressGenerator {

    public static String generatePrivateKey(String seed) {
        return SHA256.getHash(seed.getBytes());
    }

    public static String getPublicKey(String privateKey) throws Exception {
        BigInteger big = null;
        try {
            big = new BigInteger(privateKey, 16);
        } catch (NumberFormatException e) {
            System.out.println("The seed must be hexadecimal");
        }
        assert big != null;

        return CountPoint.count(big);
    }

    public static String getCompressedPublicKey(String privateKey) throws Exception {
        String publicKey = getPublicKey(privateKey);
        String parityByte = Integer.parseInt(String.valueOf(publicKey.charAt(publicKey.length() - 1)), 16) % 2 == 0 ? "02" : "03";
        publicKey = parityByte + publicKey.substring(2, 66);
        return publicKey;
    }
    public static String getBitcoinAddress(String publicKey){

        String encryptedKey = "00" + Ripemd160.getHash(hexToBytes(SHA256.getHash(hexToBytes(publicKey))));
        String checksum = SHA256.getHash(hexToBytes(SHA256.getHash(hexToBytes(encryptedKey)))).substring(0, 8);
        String bitcoinAddress = encryptedKey + checksum;
        bitcoinAddress = Base58.encode(hexToBytes(bitcoinAddress));
        return bitcoinAddress;
    }

    public static void main(String[] args) throws Exception {
        String seed = "Grenadierfierstherabbitholeintthefield";
        String privateKey = generatePrivateKey(seed);
        System.out.println(privateKey);
        System.out.println("PublicKey: " + getPublicKey(privateKey));
        String result = getBitcoinAddress(getPublicKey(privateKey));
        System.out.println(result);
    }
}

