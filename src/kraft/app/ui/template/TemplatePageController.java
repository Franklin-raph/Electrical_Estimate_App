package kraft.app.ui.template;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import kraft.app.util.Handlers;


public class TemplatePageController {
    @FXML
    private Label closeLabel;

    @FXML
    private Button cancel, Continue;

    @FXML
    private AnchorPane topPane, mainPane;

    @FXML
    private AnchorPane empty, bungalow, duplex, apartment;

    public void initialize() {
        Platform.runLater(() -> {
            addHandlersForClose();
            addHandlersForCancelAndContinue();
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

    @FXML
    public void OnEmptySelected(){
        empty.setStyle("-fx-background-color:  #ffffff");
    }
    @FXML
    public void OnBungalowSelected(){
        bungalow.setStyle("-fx-background-color:  #ffffff");
    }
    @FXML
    public void OnApartmentSelected(){
        apartment.setStyle("-fx-background-color:  #ffffff");
    }
    @FXML
    public void OnDuplexSelected(){
        duplex.setStyle("-fx-background-color:  #ffffff");
    }
}
