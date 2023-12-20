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
    public static String entropy;
    public static String privateKey;
    public static String privateKeyWIF;
    public static String publicKey;
    public static String publicKeyCompressed;
    public static String bitcoinAddress;
    public static String bitcoinAddressCompressed;
    public static ArrayList<String> wordsSecret;


    public static void main(String[] args) throws Exception {
        EntropyGenerator entropyGenerator = new EntropyGenerator();
        entropy = entropyGenerator.getEntropy();
        System.out.println("entropy : " + entropy);
        privateKey = generatePrivateKey(entropy);
        System.out.println("Private key: " + privateKey);
        privateKeyWIF = keyToWIF(privateKey);
        System.out.println("Private key WIF: " + privateKeyWIF);
        publicKey = getPublicKey(privateKey);
        System.out.println("Public key: " + publicKey);
        bitcoinAddress = getBitcoinAddress(publicKey);
        System.out.println("Bitcoin address: " + bitcoinAddress);
        publicKeyCompressed = getCompressedPublicKey(privateKey);
        System.out.println("Public key compressed: " + publicKeyCompressed);
        bitcoinAddressCompressed = getBitcoinAddress(publicKeyCompressed);
        System.out.println("Bitcoin compressed address: " + bitcoinAddressCompressed);
        wordsSecret = getWordsFromKey(privateKey);
        System.out.println(wordsSecret);
        privateKey = getKeyFromWords(wordsSecret);
        System.out.println(entropy.length());
    }
}
    