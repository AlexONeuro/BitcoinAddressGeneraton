package com.alex_acelerator.bitaddress.BitcoinAddressCreator.MainGenerators;

import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BIP39Converter.getKeyFromWords;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BIP39Converter.getWordsFromKey;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BitcoinAddressGenerator.generatePrivateKey;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BitcoinAddressGenerator.getBitcoinAddress;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BitcoinAddressGenerator.getCompressedPublicKey;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.BitcoinAddressGenerator.getPublicKey;
import static com.alex_acelerator.bitaddress.BitcoinAddressCreator.Util.WIFConverter.keyToWIF;

import java.util.ArrayList;

public class AddressGenerators {
    public String entropy;
    public String privateKey;
    public String privateKeyWIF;
    public String publicKey;
    public String publicKeyCompressed;
    public String bitcoinAddress;
    public String bitcoinAddressCompressed;
    public ArrayList<String> wordsSecret;

}
