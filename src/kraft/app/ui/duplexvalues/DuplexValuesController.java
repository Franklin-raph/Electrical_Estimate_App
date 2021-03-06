package kraft.app.ui.duplexvalues;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kraft.app.models.enums.StairCase;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.IOException;

public class DuplexValuesController {
    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private Button cancel, continu;

    @FXML
    private TextField numOfRoomsGrnd, numOfRoomsUpp;



    @FXML
    private CheckBox hasDiningBox, kitchenHasStoreBox, allIsMasterBox;

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
        Parent root = FXMLLoader.load(getClass().getResource("/kraft/app/ui/project/ProjectPage.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        WindowStyle.allowDrag(root, primaryStage);

    }
}
