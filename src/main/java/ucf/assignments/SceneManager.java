package ucf.assignments;

import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    Map<String, Scene> scenes = new HashMap<>();

    public void loadAllScenes(){
        //Use a list of our items.
    }

    public Scene getScene(String name){
        return scenes.get(name);
    }
}
