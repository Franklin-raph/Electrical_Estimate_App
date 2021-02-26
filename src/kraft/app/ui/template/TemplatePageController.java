package kraft.app.ui.template;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import kraft.app.util.Handlers;


public class TemplatePageController {
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
}
