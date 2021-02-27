package kraft.app.ui.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kraft.app.util.Handlers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kraft.app.util.WindowStyle;

import java.io.File;
import java.io.IOException;

public class HomeStageController2 {
    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
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

        @FXML
        public void CreateNewProject() throws IOException {
            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/template/TemplatePage.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
        }

        @FXML
        public void About(){

        }

        @FXML
        public void OpenProject(){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Create File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Kraft Files", "*.kr"
            ));
            File selectedFile = fileChooser.showOpenDialog(
                    mainPane.getScene().getWindow()
            );
        }
}
