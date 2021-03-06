package kraft.app.ui.template;

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
import kraft.app.models.enums.Projects;
import kraft.app.util.FileManager;
import kraft.app.util.Handlers;
import kraft.app.util.WindowStyle;

import java.io.IOException;


public class TemplatePageController {
    @FXML
    private Label closeLabel;

    @FXML
    private Label minimizeLabel;

    @FXML
    private Button cancel, continu;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private AnchorPane empty, bungalow, duplex, apartment;

    private boolean isSelected = false;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            Handlers.getInstance().onHoverHandlers(cancel, continu);
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
    public void OnEmptySelected(){
        changeBackgroundStyle(bungalow);
        changeBackgroundStyle(apartment);
        changeBackgroundStyle(duplex);
        empty.setStyle("-fx-background-color:  #123456");
        FileManager.getInstance().setSelectedProject(Projects.EMPTY);
        isSelected = true;
    }

    @FXML
    public void OnBungalowSelected(){
        changeBackgroundStyle(empty);
        changeBackgroundStyle(apartment);
        changeBackgroundStyle(duplex);
        bungalow.setStyle("-fx-background-color:  #123456");
        FileManager.getInstance().setSelectedProject(Projects.BUNGALOW);
        isSelected = true;
    }

    @FXML
    public void OnApartmentSelected(){
        changeBackgroundStyle(empty);
        changeBackgroundStyle(bungalow);
        changeBackgroundStyle(duplex);
        apartment.setStyle("-fx-background-color:  #123456");
        FileManager.getInstance().setSelectedProject(Projects.APARTMENT);
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
            Parent root = createRoot();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            WindowStyle.allowDrag(root, primaryStage);
        }
    }

    private Parent createRoot() throws IOException{

        int ordinal = FileManager.getInstance().getSelectedProject().ordinal();
        switch (ordinal) {
            case 1:
                    return FXMLLoader.load(getClass().getResource("/kraft/app/ui/bungalowvalues" +
                            "/BungalowValues.fxml"));

            case 2:
                return FXMLLoader.load(getClass().getResource("/kraft/app/ui/apartmentvalues" +
                        "/ApartmentValues.fxml"));

            case 3:
                return FXMLLoader.load(getClass().getResource("/kraft/app/ui/duplexvalues" +
                        "/DuplexValues.fxml"));

            default:
                return FXMLLoader.load(getClass().getResource("/kraft/app/ui/project" +
                        "/ProjectPage.fxml"));

        }

    }

}

