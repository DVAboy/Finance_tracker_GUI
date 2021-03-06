package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Tracker tracker = new Tracker();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Finance Tracker");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        tracker.userInterface();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
