package kraft.app.ui.template;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kraft.app.models.enums.Projects;
import kraft.app.util.FileManager;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.IOException;


public class TemplatePageController {
    @FXML
    private Label closeLabel;

    @FXML
    private Button cancel, Continue;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private AnchorPane empty, bungalow, duplex, apartment;

    private boolean isSelected = false;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            addHandlersForCancelAndContinue();
            topPane.prefWidthProperty().bindBidirectional(mainPane.prefWidthProperty());
        });
    }

    private void addHandlersForClose() {
        closeLabel.setOnMouseEntered(event -> {
            Handlers.getInstance().handleMouseEntered(closeLabel);
        });

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
        Continue.setOnMouseEntered(event -> {
            Continue.setStyle("-fx-background-color: #028a8a; -fx-text-fill: white");
        });
        Continue.setOnMouseExited(event -> {
            Continue.setStyle("-fx-background-color:  #00b9b9; -fx-text-fill: white");
        });
    }

    @FXML
    public void OnEmptySelected(){
        changeBackgroundStyle(bungalow);
        changeBackgroundStyle(apartment);
        changeBackgroundStyle(duplex);
        empty.setStyle("-fx-background-color:  #123456");
        isSelected = true;
    }

    @FXML
    public void OnBungalowSelected(){
        changeBackgroundStyle(empty);
        changeBackgroundStyle(apartment);
        changeBackgroundStyle(duplex);
        bungalow.setStyle("-fx-background-color:  #123456");
        isSelected = true;
    }

    @FXML
    public void OnApartmentSelected(){
        changeBackgroundStyle(empty);
        changeBackgroundStyle(bungalow);
        changeBackgroundStyle(duplex);
        apartment.setStyle("-fx-background-color:  #123456");
        isSelected = true;
    }

    @FXML
    public void OnDuplexSelected(){
        changeBackgroundStyle(empty);
        changeBackgroundStyle(apartment);
        changeBackgroundStyle(bungalow);
        duplex.setStyle("-fx-background-color:  #123456");
        FileManager.getInstance().setSelectedProject(Projects.DUPLEX);
        isSelected = true;
    }

    private void changeBackgroundStyle(AnchorPane pane) {
        pane.setStyle("-fx-background-color:   #028a8a");
    }

    @FXML
    public void onCancel() throws IOException {
        Stage primaryStage = (Stage) mainPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/home/HomeStage1.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        WindowStyle.allowDrag(root, primaryStage);
    }

    @FXML
    public void onContinue() throws IOException {
        if (isSelected) {
            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/choosefile/ChooseNewFile.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
        }
    }

}

