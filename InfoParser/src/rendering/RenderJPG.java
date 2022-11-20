package rendering;

import Global.GlobalData;
import UIElements.AnchorMain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Page;
import model.Result;
import model.Word;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RenderJPG {

    ;

    public static AnchorPane renderPageJPG(Page page){

        AnchorPane retPane = new AnchorPane();

        String imagePath = "C:\\Workspace\\U\\InfoParser\\InfoParser\\src\\Downloads\\page" + String.valueOf(page.page+1) + ".jpg";
        FileInputStream inputstream = null;
        try {
            inputstream = new FileInputStream(imagePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(inputstream);

        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(image.getHeight()/2);
        imageView.setFitWidth(image.getWidth()/2);

        retPane.getChildren().add(imageView);

        List<Rectangle> rectangles = new ArrayList<>();

        Result result = null;
        if (GlobalData.resultList.size() > page.page)
            result = GlobalData.resultList.get(page.page);

        for (Word word: page.words){
            if (result != null){
                if (result.compare(word.text)){
                    Rectangle rectangle = new Rectangle(word.xmin/2, word.ymin/2, (word.xmax/2 - word.xmin/2), (word.ymax/2 - word.ymin/2));
                    rectangle.setFill(Color.color(0,1,0,0.4));
                    rectangles.add(rectangle);
                }
            }

        }


        retPane.getChildren().addAll(rectangles);

        return retPane;
    }

}
