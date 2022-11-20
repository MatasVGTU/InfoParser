package model;

import Global.GlobalData;
import Global.Settings;
import UIElements.TextFields;
import model.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {

    private int page;
    private Set<String> uniqueWords = new HashSet<>();
    private float matchRate;
    public String resultTitle;

    public Result(int page) {
        this.page = page;
    }

    public void setUniqueWords(){
        uniqueWords.clear();
        for (Word word: GlobalData.pdfdocument.page_data.get(page).words) {
            if (word.getMatch() >= Settings.acceptanceValue)
                uniqueWords.add(word.text);
        }
    }

    public float getMatchRate() {
        matchRate = (float) (uniqueWords.size() * 100 / 100);

        return matchRate;
    }

    public boolean compare(String text) {
        return uniqueWords.contains(text);
    }

    public String getResultTitle(){
        if (getMatchRate() != 0){
            resultTitle =  "page: " + String.valueOf(page+1)  + ". Found:" + String.valueOf(getMatchRate()) + " Words = {";
            for (String str: uniqueWords){

                resultTitle += str + ",";
            }
            resultTitle = resultTitle.substring(0,resultTitle.length()-1);
            resultTitle += "}";
            //System.out.println(resultTitle);
            return  resultTitle;
        }
        else
            return "";
    }


}
