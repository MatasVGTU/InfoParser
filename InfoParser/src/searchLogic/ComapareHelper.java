package searchLogic;

import model.Word;

import java.util.*;

import static java.lang.Math.max;

public class ComapareHelper {

    public static float SameCharacters (String wordPDF, String wordPhrase){
        int match = 0;

        Set<Character> charPDFList = new HashSet<>();
        Set<Character> charPhraseList = new HashSet<>();

        for (int i = 0; i < wordPDF.length(); i++){
            charPDFList.add(wordPDF.charAt(i));
        }

        for (int i = 0; i < wordPhrase.length(); i++){
            charPhraseList.add(wordPhrase.charAt(i));
        }


        int max_chars = max(charPDFList.size(), charPhraseList.size());

        if (charPDFList.size() > charPhraseList.size()){
            for (Character ch: charPDFList){
                if (charPhraseList.contains(ch))
                    match++;
            }
        }
        else{
            for (Character ch: charPhraseList){
                if (charPDFList.contains(ch))
                    match++;
            }
        }

        return (float) ((match * 100 / max_chars));
    }

    public static boolean perfectMatch(String wordPDF, String wordPhrase){
        wordPDF = wordPDF.toLowerCase();
        return wordPDF.compareTo(wordPhrase) == 0;

    }

    public static float partialMatch(String wordPDF, String phrase){
        wordPDF = wordPDF.toLowerCase();

        int contains = wordPDF.indexOf(phrase);

        if (contains != -1)
            return 79;
        else return 0;
    }

    public static float missTypeMatch(String wordPDF, String phrase){
        wordPDF = wordPDF.toLowerCase();

        if (wordPDF.length() != phrase.length())
            return 0;
        else{
            float sum = 0;

            for (int i = 0; i < wordPDF.length(); i++){
                if (wordPDF.charAt(i) == phrase.charAt(i)){
                    sum++;
                }
            }

            return sum * 100 / wordPDF.length();
        }
    }

    public static void checkAllWordsInPhrase(Word wordPDF, String phrase){

        String[] wordsPhrase;
        wordsPhrase = phrase.split(" ");

        for (String wordPhrase: wordsPhrase){
            float score;

            if (perfectMatch(wordPDF.getText(), wordPhrase)){
                wordPDF.setMatch(100);
                break;
            }
            score = SameCharacters(wordPDF.getText(),wordPhrase) / 5;
            score += partialMatch(wordPDF.getText(),wordPhrase);
            score += missTypeMatch(wordPDF.getText(),wordPhrase) * 0.9;
            wordPDF.setMatch(score);
        }


    }
}
