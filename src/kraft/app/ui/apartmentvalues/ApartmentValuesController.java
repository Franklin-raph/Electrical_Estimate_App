package kraft.app.ui.apartmentvalues;

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
import javafx.stage.Stage;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.IOException;

public class ApartmentValuesController {

    @FXML
    private AnchorPane mainPane, topPane;

    @FXML
    private Button cancel, Continue;

    @FXML
    private Label closeLabel;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            addHandlersForCancelAndContinue();
            topPane.prefWidthProperty().bindBidirectional(mainPane.prefWidthProperty());
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
    public void onCancel() throws IOException {
        Stage primaryStage = (Stage) mainPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/choosefile/ChooseNewFile.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        WindowStyle.allowDrag(root, primaryStage);
    }

    @FXML
    public void onContinue() throws IOException {

            Stage primaryStage = (Stage) mainPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/design/design.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
    }
}
