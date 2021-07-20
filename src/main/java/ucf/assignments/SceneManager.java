package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Item Lister");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Map<String, Scene> scenes = new HashMap<>();

    public void loadAllScenes(){
        //Use a list of our items.
    }

    public Scene getScene(String name){
        return scenes.get(name);
    }
}
