package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    Map<String, Scene> scenes = new HashMap<>();

    void loadAllScenes(){
        ItemsManager itemList = new ItemsManager();

        //Make instances of all our controllers.
        MainScreen mainScreen = new MainScreen(itemList, this);
        AddItemScreen addItemScreen = new AddItemScreen(itemList, this);

        Parent root;

        //Load the Main Screen.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        loader.setController(mainScreen);
        try{
            root = loader.load();
            scenes.put("MainScreen", new Scene(root));
        } catch(IOException e){
            e.printStackTrace();
        }


        //Load the Add Item Screen.
        loader = new FXMLLoader(getClass().getResource("AddItemScreen.fxml"));
        loader.setController(addItemScreen);
        try{
            root = loader.load();
            scenes.put("AddItemScreen", new Scene(root));
        } catch(Exception e){

        }

    }

    public Scene getScene(String name){
        return scenes.get(name);
    }
}
