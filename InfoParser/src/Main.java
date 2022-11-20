
import UIElements.AnchorMain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Global.GlobalData;
import model.Page;
import model.Word;

import java.util.*;
import java.util.List;

public class Main extends Application {




    public void loadPDF(){
        GlobalData.pdfdocument = JsonToObjectHelper.readJson();


    }

    public void downloadPDF(){
        LinkDownloader linkDownloader = new LinkDownloader();
        linkDownloader.downloadAll(GlobalData.pdfdocument);
    }


    @Override
    public void start(Stage stage) throws Exception {

        GlobalData.initData();
        loadPDF();
        GlobalData.stage = stage;

        AnchorMain anchorMain = new AnchorMain();
        anchorMain.initAnchorMain();
        anchorMain.updateAnchorPanePage();

        GlobalData.scene = new Scene(anchorMain.getAnchorPaneMain());
        GlobalData.stage.setTitle("searchLogic.Searcher");
        GlobalData.stage.setScene(GlobalData.scene);
        GlobalData.stage.show();
    }

}