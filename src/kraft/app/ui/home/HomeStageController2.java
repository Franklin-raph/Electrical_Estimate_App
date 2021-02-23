package kraft.app.ui.home;

import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import kraft.app.util.Handlers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;

public class HomeStageController2 {
    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            topPane.prefWidthProperty().bindBidirectional(mainPane.prefWidthProperty());
            //topPane.fitWidthProperty().bind(videoPane.widthProperty());
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
        public void CreateNewProject(){
            Dialog dialog = new Dialog();
            dialog.setTitle("Create new project");
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
