package kraft.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kraft.app.util.WindowStyle;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("ui/home/HomeStage1.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/kr.png")));
        WindowStyle.allowDrag(root, primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
