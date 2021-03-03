package kraft.app.ui.projectqueries;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kraft.app.util.FileManager;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.File;
import java.io.IOException;

public class DuplexQueriesController {
    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private Button cancel, continu;



    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            addHandlersForCancelAndContinue();
            topPane.prefWidthProperty().bindBidirectional(mainPane.prefWidthProperty());
        });
    }

    private void addHandlersForClose() {
        closeLabel.setOnMouseEntered(event -> Handlers.getInstance().handleMouseEntered(closeLabel));

        closeLabel.setOnMouseExited(event -> {
            Handlers.getInstance().handleMouseExited(closeLabel);
        });

        closeLabel.setOnMouseClicked(event -> {
            Handlers.getInstance().handleClose();
        });
    }


    public void addHandlersForCancelAndContinue() {
        cancel.setOnMouseEntered(event -> {
            cancel.setStyle("-fx-background-color: #028a8a; -fx-text-fill: white");
        });
        cancel.setOnMouseExited(event -> {
            cancel.setStyle("-fx-background-color:  #00b9b9; -fx-text-fill: white");
        });
        continu.setOnMouseEntered(event -> {
            continu.setStyle("-fx-background-color: #028a8a; -fx-text-fill: white");
        });
        continu.setOnMouseExited(event -> {
            continu.setStyle("-fx-background-color:  #00b9b9; -fx-text-fill: white");
        });
    }


    @FXML
    public void onCancel() throws IOException {
        Stage primaryStage = (Stage) mainPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/template/TemplatePage.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        WindowStyle.allowDrag(root, primaryStage);
    }

    @FXML
    public void onContinue() throws IOException {

            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/choosefile/ChooseNewFile.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
    }
}