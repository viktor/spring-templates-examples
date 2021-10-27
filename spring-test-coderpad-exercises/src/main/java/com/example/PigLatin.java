package com.example;

import org.springframework.stereotype.Service;

@Service
public class PigLatin {

    public String pigLatinize(String phrase) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        String words[] = phrase.split(" ");
        StringBuilder results = new StringBuilder("");

        for(String word: words){
            char initChar = word.toCharArray()[0];
            boolean isVowel = java.util.stream.Stream.of(vowels).filter(v -> v.equals(initChar)).findAny().isPresent();

            if(Character.isLetter(initChar) &&  !isVowel){
                results.append(word.substring(1).concat("-ay").concat(" "));
            }else{
                results.append(word.substring(1).concat("-way").concat(" "));
            }
        }
        return results.toString();
    }

    public String pigLatinizeTakeHome(String phrase) {
        char[] vowels = {'a','e','i','o','u', 'A','E','I','O','U'};
        String words[] = phrase.split(" ");
        StringBuilder results = new StringBuilder("");

        for(String word: words){
            char initChar = word.toCharArray()[0];
            boolean isVowel = false;
            // chars are primitive I didn't use filter()
            for (char vowel: vowels) {
                if(vowel == initChar){
                    isVowel = true;
                    break;
                }
            }

            if(!Character.isDigit(initChar)){
                if(Character.isLetter(initChar) &&  !isVowel){
                    results.append(word.substring(1).concat("-").concat(String.valueOf(initChar)).concat("ay").concat(" "));
                }else{
                    results.append(word.concat("-way").concat(" "));
                }
            }else{
                results.append(word.concat(" "));
            }
        }

        return results.toString();
    }

}
