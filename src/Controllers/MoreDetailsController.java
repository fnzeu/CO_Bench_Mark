package Controllers;

import Services.Pi1Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class MoreDetailsController {

    private ObservableList<String> List;

    @FXML
    private BarChart<?, ?> BarChart;

    @FXML
    private CategoryAxis CategoryAxis;

    @FXML
    private NumberAxis NumberAxis;

    @FXML
    private Button Show;

    @FXML
    private Button ReturnButton;

    @FXML
    void ReturnButtonAction(ActionEvent event) {

    }


    @FXML
    void ShowButtonAction(ActionEvent event) {

    }

    @FXML
    private ListView<String> ListView;

    @FXML
    private Button ShowDetailsButton;

    @FXML
    void ShowDetailsButton(ActionEvent event) {

    }

    @FXML
    void Showaction(ActionEvent event) {

    }


    public void Showaction(javafx.event.ActionEvent actionEvent) {

        XYChart.Series set1= new XYChart.Series();

        set1.getData().add(new XYChart.Data("Pi1", MainPageController.getTime2()));
        set1.getData().add(new XYChart.Data("C1", MainPageController.getTime1()));


        BarChart.getData().addAll(set1);
    }

    public void ShowDetailsButton(javafx.event.ActionEvent actionEvent) {

        List = FXCollections.observableArrayList();
        /* Total number of processors or cores available to the JVM */
        //System.out.println("Available processors (cores): " +
                //Runtime.getRuntime().availableProcessors());
        int x=Runtime.getRuntime().availableProcessors();
        String s= Integer.toString(x);
        List.addAll("Available Processors (cores): ",s);



        /* Total amount of free memory available to the JVM */
        //System.out.println("Free memory (bytes): " +
                //Runtime.getRuntime().freeMemory());

        Long x2=Runtime.getRuntime().freeMemory();
        String s2= Long.toString(x2);
        List.addAll("Free memory (bytes): ",s2);

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        //System.out.println("Maximum memory (bytes): " +
                //(maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        String s3= Long.toString(maxMemory);
        List.addAll("Maximum Memory (bytes): ",s3);

        /* Total memory currently available to the JVM */
        //System.out.println("Total memory available to JVM (bytes): " +
                //Runtime.getRuntime().totalMemory());
        long x4=Runtime.getRuntime().totalMemory();
        String s4= Long.toString(x4);
        List.addAll("Total Memory available to JVM (bytes): ",s4);


        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File r : roots) {
            //System.out.println("File system root: " + r.getAbsolutePath());
            List.addAll("File System root ",r.getAbsolutePath());
            //System.out.println("Total space (bytes): " + r.getTotalSpace());
            long x5=r.getTotalSpace();
            String s5= Long.toString(x5);
            List.addAll("Total space (bytes): ",s5);
            //System.out.println("Free space (bytes): " + r.getFreeSpace());
            long x6=r.getFreeSpace();
            String s6=Long.toString(x6);
            List.addAll("Free space (bytes): ",s6);
            //System.out.println("Usable space (bytes): " + r.getUsableSpace());
            long x7=r.getUsableSpace();
            String s7=Long.toString(x7);
            List.addAll("Usable space (bytes): ",s7);
        }

        ListView.setItems(List);

    }

    public void ReturnButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent New = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
        Scene NewScene = new Scene(New);

        //Here we get the stage information
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(NewScene);
        window.show();
    }
}
