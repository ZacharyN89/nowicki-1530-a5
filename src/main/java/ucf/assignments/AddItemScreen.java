package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddItemScreen {
    @FXML private TextField serialNumberField;
    @FXML private TextArea nameArea;
    @FXML private TextField valueField;

    private SceneManager sceneManager;
    private ItemsManager listOfItems;

    public AddItemScreen(ItemsManager newItemList, SceneManager newSceneManager){
        sceneManager = newSceneManager;
        listOfItems = newItemList;
    }

    public void closeButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) nameArea.getScene().getWindow();
        stage.close();
    }

    public void addItemButtonClicked(ActionEvent actionEvent) {
        String serialNum = serialNumberField.getText();
        String name = nameArea.getText();
        String value = valueField.getText();
        if(listOfItems.addItem(serialNum,name,value)){

            serialNumberField.clear();
            nameArea.clear();
            valueField.clear();

            Stage stage = (Stage) nameArea.getScene().getWindow();
            stage.close();
        } else {
            serialNumberField.clear();
            nameArea.clear();
            valueField.clear();
            nameArea.setPromptText("Please only type in accepted characters and values.");
        }
    }
}
