package UIElements;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class TextFields {

    public static List<TextField> allTextFields = new ArrayList<>();
    public List<TextField> getAllTextFields(){
        allTextFields.add(searchTextField());
        allTextFields.add(goToPageTextField());

        return allTextFields;
    }

    public TextField searchTextField(){
        TextField textField = new TextField();
        textField.setPromptText("Search");
        textField.setLayoutX(400);
        textField.setPrefWidth(400);
        return textField;
    }

    public TextField goToPageTextField(){
        TextField textField = new TextField();
        textField.setPromptText("page number");
        textField.setLayoutX(140);
        textField.setPrefWidth(100);
        return textField;
    }

}
