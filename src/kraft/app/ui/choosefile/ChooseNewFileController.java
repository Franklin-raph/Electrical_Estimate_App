package kraft.app.ui.choosefile;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kraft.app.ui.apartmentvalues.ApartmentValuesController;
import kraft.app.util.FileManager;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.File;
import java.io.IOException;

public class ChooseNewFileController {
    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private Button cancel, continu;

    @FXML
    private TextField pathText;

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

    public void minimizeLabelPressed(MouseEvent mouseEvent) {
        Handlers.getInstance().handleMinimize((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
    }


    public void addHandlersForCancelAndContinue() {
        Handlers.getInstance().onHoverHandlers(cancel, continu);
    }

    @FXML
    public void onFolderClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Create File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Kraft Files", "*.kr"
        ));
        File selectedFile = fileChooser.showSaveDialog(mainPane.getScene().getWindow());
        if (selectedFile != null) {
            pathText.setText(selectedFile.getAbsolutePath());
        }
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
        String path = pathText.getText();
        if (path != null) {
            FileManager.getInstance().setSelectedFile(new File(path));

            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/apartmentvalues/ApartmentValues.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
        }
    }
}























