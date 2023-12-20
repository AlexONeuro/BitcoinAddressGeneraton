package com.alex_acelerator.bitaddress.BitcoinAddressCreator.SHA256_HASH;

public class Word {
    StringBuilder wordValue;

    public Word (StringBuilder stringBuilder){
        this.wordValue  = stringBuilder;
    }
    public Word(String string){
        this.wordValue = new StringBuilder(string);
    }

    public Word() {
        this.wordValue = new StringBuilder();
    }

    public Word(long number){
        StringBuilder word;
        word = new StringBuilder(Long.toBinaryString(number));
        if (word.length()<32){
            StringBuilder appendString = new StringBuilder();
            for (int i = 0; i < 32- word.length(); i++) {
                appendString.append("0");
            }
            word = appendString.append(word);
        }
        this.wordValue = word;
    }
    public int length(){
        return wordValue.length();
    }
    public char charAt(int index){
        return wordValue.charAt(index);
    }

    public String toString(){
        return wordValue.toString();
    }

    public Word rightRotate(int number){
        StringBuilder result = new StringBuilder(wordValue);
        for (int i = 0; i < number; i++) {
            StringBuilder temp = new StringBuilder(result);
          char firstChar = result.charAt(result.length()-1);
             for (int j = 1; j < wordValue.length(); j++) {
                  temp.replace(j,j+1, String.valueOf(result.charAt(j-1)));
        }
        temp.replace(0,1, String.valueOf(firstChar));
        result = new StringBuilder(temp);
        }
        return new Word(result);
    }

    public Word rightShift(int number){

       StringBuilder result = new StringBuilder(this.wordValue.substring(0, 32-number));
       StringBuilder appendString = new StringBuilder();
        for (int i = 0; i < number; i++) {
            appendString.append("0");
        }

       result = appendString.append(result);
    return new Word(result);
    }

    public Word xor(Word word){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            result.append(this.wordValue.charAt(i) ^ word.charAt(i));
        }
        return new Word(result);
    }

    public Word and(Word word){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            result.append(
                    Integer.parseInt(String.valueOf(this.wordValue.charAt(i)))
                    & Integer.parseInt(String.valueOf(word.charAt(i))));
        }
        return new Word(result);
    }

    public Word not(){
        StringBuilder result = new StringBuilder(this.wordValue);

        for (int i = 0; i < wordValue.length(); i++) {
         if(result.charAt(i)=='0')
             result.replace(i,i+1,"1");
         else  result.replace(i,i+1,"0");
        }
        return new Word(result);
    }

    /**
     * public Word add(Word word)
     * Сложение по модулю 2^32
     */
    public Word add(Word word){
        StringBuilder secondWord = new StringBuilder(word.wordValue);
        StringBuilder result = new StringBuilder(this.wordValue);
        StringBuilder appendStr = new StringBuilder();
        long number = Long.parseLong(String.valueOf(result),2)+Long.parseLong(String.valueOf(secondWord),2);
        result = new StringBuilder(Long.toBinaryString(number));
        int appendInteger = 32 - result.length();
        if (appendInteger>0){
            for (int i = 0; i < appendInteger; i++) {
                appendStr.append("0");
            }
        }
        result = appendStr.append(result);
        result = new StringBuilder(result.substring(result.length() - 32, result.length()));

        return new Word(result);
    }



    public static void main(String[] args) {

        Word firstWord =  new Word(new StringBuilder("10000110110100001100000000110001"));
        Word secondWord = new Word(new StringBuilder("10000110110100001100000000110001"));
      //  System.out.println(firstWord.xor(secondWord));
      //  System.out.println(firstWord.and(secondWord));
       // System.out.println(firstWord.not().add(secondWord));

        //Word h1 = new Word( 0xbb67ae85);
        Long l = 0xbb67ae85L;
        System.out.println(l);

    }
}
