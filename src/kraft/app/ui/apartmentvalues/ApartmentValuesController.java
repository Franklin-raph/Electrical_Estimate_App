package kraft.app.ui.apartmentvalues;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kraft.app.util.Handlers;

public class ApartmentValuesController {
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


}
