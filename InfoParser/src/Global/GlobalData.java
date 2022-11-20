package Global;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PDFdocument;
import model.Result;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {


    public static PDFdocument pdfdocument;
    public static int currentPage;
    public static Stage stage;
    public static Scene scene;
    public static List<Result> resultList = new ArrayList<>();
    public static void initData(){
        currentPage = 0;
    }

}
