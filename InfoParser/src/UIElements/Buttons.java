package UIElements;

import Global.GlobalData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Phrase;
import searchLogic.Searcher;

import java.util.ArrayList;
import java.util.List;

public class Buttons {

    public List<Button> allButtons = new ArrayList<>();

    public List<Button> getAllButtons(){
        allButtons.add(searchButton());
        allButtons.add(prevButton());
        allButtons.add(nextButt());
        allButtons.add(goButton());

        return allButtons;
    }

    public Button searchButton(){
        Button buttonSearch = new Button("Search");
        buttonSearch.setLayoutX(810);
        buttonSearch.setPrefWidth(100);
        buttonSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String phraseText = TextFields.allTextFields.get(0).getText();
                Phrase phrase = new Phrase(phraseText);
                Searcher.search(phrase);
                AnchorMain.updateAnchorPanePage();

            }
        });
        return buttonSearch;
    }

    public Button prevButton(){
        Button buttonPrev = new Button("Prev");
        buttonPrev.setLayoutX(10);
        buttonPrev.setPrefWidth(50);

        buttonPrev.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                GlobalData.currentPage--;
                System.out.println(GlobalData.currentPage);
                AnchorMain.updateAnchorPanePage();

            }
        });

        return buttonPrev;
    }

    public Button nextButt(){

        Button buttonNext = new Button("Next");
        buttonNext.setLayoutX(70);
        buttonNext.setPrefWidth(50);
        buttonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                GlobalData.currentPage++;
                System.out.println(GlobalData.currentPage);
                AnchorMain.updateAnchorPanePage();

            }
        });

        return buttonNext;
    }

    public Button goButton(){
        Button buttonGo = new Button("Go");
        buttonGo.setLayoutX(250);
        buttonGo.setPrefWidth(50);

        buttonGo.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                GlobalData.currentPage = Integer.parseInt(TextFields.allTextFields.get(1).getText()) - 1;
                System.out.println(GlobalData.currentPage);
                AnchorMain.updateAnchorPanePage();

            }
        });
        return buttonGo;
    }

}
