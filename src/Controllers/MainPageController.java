package Controllers;

import Services.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainPageController {

    private static long T1;
    private static long T2;
    private static long T3;
    private static long T4;

    @FXML
    private TextField FirstPiTxt;

    @FXML
    private TextField SecondPiTxt;

    @FXML
    private TextField FirstCramerTxt;

    @FXML
    private TextField SecondCramerTxt;

    @FXML
    private TextField DigitsTxt;

    @FXML
    private Label TimeTxt;

    @FXML
    private Label PiTxt;

    @FXML
    private Label CramerTxt;

    @FXML
    private Button ShowButton;

    @FXML
    private Button MoreDetails;

    @FXML
    private TextField NoCorestxt;

    @FXML
    void NoCoresAction(ActionEvent event) {

    }


    @FXML
    void DigitsTxtAction(ActionEvent event) {

    }

    @FXML
    void FirstCramerTxtAction(ActionEvent event) {

    }

    @FXML
    void MoreDetailsAction(ActionEvent event) {

    }

    @FXML
    void FirstPiTxtAction(ActionEvent event) {

    }

    @FXML
    void SecondCramerTxtAction(ActionEvent event) {

    }

    @FXML
    void SecondPiTxtAction(ActionEvent event) {

    }

    @FXML
    void ShowButtonAction(ActionEvent event) {

    }

    public void FirstPiTxtAction(javafx.event.ActionEvent actionEvent) {
    }

    public void SecondPiTxtAction(javafx.event.ActionEvent actionEvent) {
    }

    public void FirstCramerTxtAction(javafx.event.ActionEvent actionEvent) {

    }

    public void SecondCramerTxtAction(javafx.event.ActionEvent actionEvent) {
    }

    public void DigitsTxtAction(javafx.event.ActionEvent actionEvent) {

        Pi1Service obj=new Pi1Service();
        int digits=Integer.parseInt(DigitsTxt.getText());
        obj.run(digits);
        T2=obj.getTimeout();
        String Time=Long.toString((T2));
        FirstPiTxt.setText(Time);


        Pi2Service obj2=new Pi2Service();
        int decimal=Integer.parseInt(DigitsTxt.getText());
        obj2.getDecimal(decimal);
        T4=obj2.getTimeout();
        String T=Long.toString(T4);
        SecondPiTxt.setText(T);
        //System.out.println("> " + time + " ms");
    }

    public void ShowButtonAction(javafx.event.ActionEvent actionEvent) {
        
    }

    public void MoreDetailsAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent New = FXMLLoader.load(getClass().getResource("/MoreDetails.fxml"));
        Scene NewScene = new Scene(New);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewScene);
        window.show();
    }

        public static long getTime2(){ return T2;}
        public static long getTime3(){ return T3;}
        public static long getTime4(){ return T4;}

    public void NoCoresAction(javafx.event.ActionEvent actionEvent) {
        try {
            Threads1Service obj3= new Threads1Service();
            String x=NoCorestxt.getText();
            int y=Integer.parseInt(x);
            obj3.Threads(y);
            T3=obj3.getTimeout();
            String TIME=Long.toString(T3);
            SecondCramerTxt.setText(TIME);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
}