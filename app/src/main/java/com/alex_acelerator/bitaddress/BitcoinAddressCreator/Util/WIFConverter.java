package com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util;

import com.alex_acelerator.bitaddress.BitcoinAddressCreator.SHA256_HASH.SHA256;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.HexToBytes.*;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BytesToString.*;
public final class WIFConverter {
    public static String keyToWIF(String privateKey){
        String WIF = "80" + privateKey;
        String checksum = SHA256.getHash(hexToBytes(SHA256.getHash(hexToBytes(WIF)))).substring(0,8);
        WIF += checksum;
        return Base58.encode(hexToBytes(WIF));
    }
    public static String WIFtoKey(String WIF){
        String privateKey = getString(Base58.decode(WIF));
        return privateKey.substring(0,privateKey.length()-8).substring(2);
    }
    public static void main(String[] args) {
        System.out.println(keyToWIF("0C28FCA386C7A227600B2FE50B7CAE11EC86D3BF1FBE471BE89827E19D72AA1D"));
        System.out.println(WIFtoKey("5HueCGU8rMjxEXxiPuD5BDku4MkFqeZyd4dZ1jvhTVqvbTLvyTJ"));
    }
}
