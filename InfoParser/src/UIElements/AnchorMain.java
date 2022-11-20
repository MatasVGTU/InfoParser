package UIElements;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import Global.GlobalData;
import rendering.RenderJPG;

public class AnchorMain {

    private static AnchorPane anchorPaneMain = null;
    private static AnchorPane anchorPaneUIElements = null;
    private static AnchorPane anchorPanePage = null;

    public void initAnchorMain(){
        anchorPaneUIElements = new AnchorPane();

        TextFields textFields = new TextFields();
        textFields.getAllTextFields();

        Buttons buttons = new Buttons();
        buttons.getAllButtons();

        ChoiceBoxes choiceBoxes= new ChoiceBoxes();
        choiceBoxes.getAllChoiceBoxes();


        anchorPaneUIElements.getChildren().addAll(textFields.allTextFields);
        anchorPaneUIElements.getChildren().addAll(buttons.allButtons);
        anchorPaneUIElements.getChildren().addAll(choiceBoxes.choiceBoxList);
        anchorPaneUIElements.setPrefHeight(50);
    }

    public AnchorPane getAnchorPaneMain() {
        anchorPaneMain.getChildren().clear();
        anchorPaneMain.getChildren().add(anchorPaneUIElements);
        anchorPanePage.setLayoutY(anchorPaneUIElements.getPrefHeight());
        anchorPaneMain.getChildren().add(anchorPanePage);

        return anchorPaneMain;
    }

    public AnchorMain() {
        this.anchorPaneMain = new AnchorPane();
        this.anchorPaneMain.setBackground(Background.fill(Color.GRAY));
    }

    public static void updateAnchorPanePage(){
        //anchorPanePage.getChildren().clear();

        anchorPaneMain.getChildren().clear();

        anchorPanePage = RenderJPG.renderPageJPG(GlobalData.pdfdocument.page_data.get(GlobalData.currentPage));

        anchorPaneMain.getChildren().clear();
        anchorPaneMain.getChildren().add(anchorPaneUIElements);
        anchorPanePage.setLayoutY(anchorPaneUIElements.getPrefHeight());
        anchorPaneMain.getChildren().add(anchorPanePage);

        GlobalData.stage.show();
    }


}
