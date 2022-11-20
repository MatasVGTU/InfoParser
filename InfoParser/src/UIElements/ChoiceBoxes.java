package UIElements;



import Global.GlobalData;
import javafx.scene.control.ChoiceBox;
import model.Result;

import java.util.ArrayList;
import java.util.List;

public class ChoiceBoxes {
    public static List<ChoiceBox<String>> choiceBoxList = new ArrayList<ChoiceBox<String>>();

    public List<ChoiceBox<String>> getAllChoiceBoxes(){
        choiceBoxList.add(resultChoiceBox());

        return choiceBoxList;
    }

    public ChoiceBox<String> resultChoiceBox(){
        ChoiceBox<String> choiceBoxResult = new ChoiceBox<>();
        choiceBoxResult.setLayoutX(920);
        choiceBoxResult.setPrefWidth(400);

        choiceBoxResult.setOnAction((event) -> {
            int selectedIndex = choiceBoxResult.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBoxResult.getSelectionModel().getSelectedItem();

            String choiceBoxValue = choiceBoxResult.getValue();
            if (choiceBoxValue != null){
                choiceBoxValue = choiceBoxValue.substring(6,choiceBoxValue.length());
                int firstIndex = choiceBoxValue.indexOf('.');
                String pageValue = choiceBoxValue.substring(0,firstIndex);


                GlobalData.currentPage = Integer.parseInt(pageValue) -1;

                System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
                System.out.println("   ChoiceBox.getValue(): " + choiceBoxResult.getValue());

                AnchorMain.updateAnchorPanePage();
            }

        });

        return choiceBoxResult;
    }

    public static void addResults(){
        choiceBoxList.get(0).getItems().removeAll(choiceBoxList.get(0).getItems());
        for (Result result: GlobalData.resultList){
            if (result.getResultTitle() != "")
                choiceBoxList.get(0).getItems().add(result.getResultTitle());
        }

    }



}
