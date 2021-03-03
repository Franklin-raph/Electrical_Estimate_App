package kraft.app.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Optional;

public class Handlers {
    private String defaultColorLabel_X;
    private final Alert alert;
    private static Handlers mInstance;

    public static Handlers getInstance(){
        if (mInstance == null) {
            mInstance = new Handlers();
        }
        return mInstance;
    }


    /*
     * A private constructor to ensure that an instance of this class cannot be created
     * outside this class
     */
    private Handlers(){
//    Create the alert object to handle onAction close
        alert = new Alert(Alert.AlertType.NONE,"Are you sure you want to exit?",ButtonType.YES,  ButtonType.CANCEL);
        alert.setTitle("Exit");
    }

    public ButtonType handleClose(){

        DialogPane dialogPane = alert.getDialogPane();

        ButtonType buttonType = null;
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.YES)) {
            buttonType = result.get();
            Platform.exit();
        }else if(result.isPresent() && (result.get() == ButtonType.CANCEL)){
            buttonType = result.get();
        }
        return buttonType;
    }
    /*
     * Method to change the background color of the close and minimize button when
     * a mouse enters the Label
     */
    public void handleMouseEntered(Label closeLabel) {
        defaultColorLabel_X = closeLabel.getStyle();
        closeLabel.setStyle("-fx-background-color: #a80000; -fx-text-fill: white");
    }

    /*
     * Method to change the background color of the close and minimize button when
     * a mouse leaves the Label to default color of the Label
     */
    public void handleMouseExited(Label closeLabel) {
        if(defaultColorLabel_X != null) {
            closeLabel.setStyle(defaultColorLabel_X);
        }
    }

    //    Method to handle minimize
    public void handleMinimize(Stage stage){
        if(stage != null){
            stage.setIconified(true);
        }
    }

    public void handleMaximize(Stage stage) {
        if (stage != null) {
            stage.setIconified(false);
        }
    }
}
