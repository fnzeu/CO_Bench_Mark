package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloPageController {

    @FXML
    private Text WelcomeText;

    @FXML
    private Button StartButton;

    @FXML
    private HBox Hbox;

    @FXML
    private Text BabaYagaTxt;

    @FXML
    void StartButtonAction(ActionEvent event) {

    }

    public void StartButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent Next = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
        Scene NextScene = new Scene(Next);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NextScene);
        window.show();

    }
}