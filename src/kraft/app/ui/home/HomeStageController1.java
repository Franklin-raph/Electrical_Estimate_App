package kraft.app.ui.home;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kraft.app.util.FileManager;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;
import java.io.File;
import java.io.IOException;

public class HomeStageController1 {
    @FXML
    private Label closeLabel;

    @FXML
    private Button maxButton;

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

    public void minimizeLabelPressed(MouseEvent mouseEvent) {
        Handlers.getInstance().handleMinimize((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }



        @FXML
        public void CreateNewProject() throws IOException {
            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/template/TemplatePage.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
            primaryStage.setX(300);
            primaryStage.setY(0);
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
            if (selectedFile != null) {
                FileManager.getInstance().setSelectedFile(selectedFile);
            }
        }
}
