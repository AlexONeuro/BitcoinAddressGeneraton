package com.alex_acelerator.bitaddress.EntropySource;

import java.security.SecureRandom;

public class EntropyGenerator {
   SecureRandom random = new SecureRandom();
   byte[] randomNumber = random.generateSeed(16);
   StringBuilder stringBuilder = new StringBuilder();

   public String getEntropy(){
      for (int i = 0; i < randomNumber.length; i++) {
         stringBuilder.append(Integer.toHexString(randomNumber[i]*randomNumber[i]));
      }
      return stringBuilder.toString();
   }

}

