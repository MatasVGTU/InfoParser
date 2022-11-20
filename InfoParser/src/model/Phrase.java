package model;

import java.util.ArrayList;
import java.util.List;

public class Phrase {

    public String text;
    public List<String> words;

    public Phrase(String str) {
        this.text = str.toLowerCase();
        this.words = SeperateWords();
    }

    public List<String> SeperateWords(){

        List<String> retVal = new ArrayList<>();
        String[] strArr;

        strArr = text.split(" *");

        for (String s: strArr){
            retVal.add(s);
        }

        return retVal;
    }





}
