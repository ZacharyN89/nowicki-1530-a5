package ucf.assignments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            SceneManager sceneManager = new SceneManager();
            sceneManager.loadAllScenes();

            Scene scene = sceneManager.getScene("MainScreen");

            primaryStage.setScene(scene);
            primaryStage.setTitle("Item Lister");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
