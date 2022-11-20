package rendering;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Page;
import model.Word;

import java.util.ArrayList;
import java.util.List;

public class RenderFromWord {

    public static AnchorPane renderPage(Page page){

        List<Label> labels = new ArrayList<>();

        AnchorPane retPane = new AnchorPane();
        retPane.setPrefSize(page.size.width / 2, page.size.height / 2);

        for (Word word: page.words){

            Label templbl = new Label();

            templbl.setText(word.getText());
            templbl.setLayoutX(word.xmin/ 2);
            templbl.setLayoutY(word.ymin/ 2);

            if (word.getMatch() > 10)
                templbl.setTextFill(Color.GREEN);
            else
                templbl.setTextFill(Color.BLACK);
            templbl.setFont(new Font("Arial", 29));
            //templbl.setPrefSize((word.xmax - word.xmin),(word.ymax - word.ymin));

            labels.add(templbl);
        }

        retPane.getChildren().addAll(labels);

        return retPane;
    }

}
