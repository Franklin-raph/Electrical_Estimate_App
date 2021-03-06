package kraft.app.ui.design;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kraft.app.util.Handlers;

public class design {

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
