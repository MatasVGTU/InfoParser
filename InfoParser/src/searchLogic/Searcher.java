package searchLogic;

import Global.GlobalData;
import UIElements.ChoiceBoxes;
import model.Page;
import model.Phrase;
import model.Result;
import model.Word;

public class Searcher {

    public static void search(Phrase phrase) {
        GlobalData.resultList.clear();
        for (Page page : GlobalData.pdfdocument.page_data) {
            for (Word wr : page.words) {
                wr.resetMatch();
                ComapareHelper.checkAllWordsInPhrase(wr, phrase.text);
            }

            Result result = new Result(page.page);
            result.setUniqueWords();
            GlobalData.resultList.add(result);
        }
        ChoiceBoxes.addResults();

    }

}
