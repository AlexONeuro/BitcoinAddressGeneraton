package com.alex_acelerator.bitaddress.BitcoinAddressCreator.MainGenerators;

import java.security.SecureRandom;

public class EntropyGenerator {
    private SecureRandom random = new SecureRandom();
    private byte[] randomNumber = random.generateSeed(32);
    private StringBuilder stringBuilder = new StringBuilder();

    public String getEntropy() {
        for (int i = 0; i < randomNumber.length; i++) {

            if (randomNumber[i]<0) randomNumber[i] *= -1;
            stringBuilder.append(Integer.toHexString(randomNumber[i]));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        EntropyGenerator entropy = new EntropyGenerator();
        System.out.println(entropy.getEntropy());
        System.out.println();
    }
}

