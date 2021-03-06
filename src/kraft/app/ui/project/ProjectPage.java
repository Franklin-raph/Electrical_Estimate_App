package kraft.app.ui.project;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kraft.app.util.Handlers;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectPage {

    @FXML
    private Label closeLabel;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private TreeView<String>tree;

    public void initialize(URL args, ResourceBundle arg) {
        Platform.runLater(() -> {
            addHandlersForClose();
            topPane.prefWidthProperty().bindBidirectional(mainPane.prefWidthProperty());
        });


        TreeItem<String> treeObj = new TreeItem<>("House");
        TreeItem<String> treeObj1 = new TreeItem<>("Flats");
        TreeItem<String> treeObj2 = new TreeItem<>("Rooms");
        treeObj.getChildren().addAll(treeObj1,treeObj2);
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

    public void handleMaxButtonAction(){
        Stage stage = (Stage) mainPane.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }
    }




}
