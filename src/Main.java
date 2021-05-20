

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.channels.UnresolvedAddressException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HelloPage.fxml"));


        primaryStage.setTitle("Benchmark");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root, 902, 522));
        primaryStage.setResizable(false);

        primaryStage.show();


    }



}
