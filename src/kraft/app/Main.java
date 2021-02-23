package kraft.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kraft.app.util.ResizeHelper;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.initStyle( StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("MainAppStage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/kraft/app/image/kr.png")));
        ResizeHelper.addResizeListener(primaryStage, 600, 450, Double.MAX_VALUE, Double.MAX_VALUE);
        //WindowStyle.allowDrag(root, primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
