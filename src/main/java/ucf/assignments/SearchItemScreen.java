package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchItemScreen {
    @FXML public TextField searchSerialField;
    @FXML public TextField searchNameField;
    @FXML public TextField serialField;
    @FXML public TextField nameField;
    @FXML public TextField valueField;

    private SceneManager sceneManager;
    private ItemsManager listOfItems;
    private Item curItem;

    public SearchItemScreen(ItemsManager newItemList, SceneManager newSceneManager){
        sceneManager = newSceneManager;
        listOfItems = newItemList;
    }

    public void searchSerialButton(ActionEvent actionEvent) {
        //Set values to searched item.
        try {
            curItem = listOfItems.getItemBySerial(searchSerialField.getText());

            serialField.setText(curItem.getSerialNumber());
            nameField.setText(curItem.getName());
            valueField.setText(curItem.getValue());
        } catch(Exception e){
            clear();
        }
    }

    public void searchNameButton(ActionEvent actionEvent) {
        //Set values to searched item.
        try {
            curItem = listOfItems.getItemByName(searchNameField.getText());

            searchSerialField.setText(curItem.getSerialNumber());
            serialField.setText(curItem.getSerialNumber());
            nameField.setText(curItem.getName());
            valueField.setText(curItem.getValue());
        } catch(Exception e){
            clear();
        }
    }

    public void removeButton(ActionEvent actionEvent) {
        listOfItems.removeItem(searchSerialField.getText());
    }

    public void setNewButton(ActionEvent actionEvent) {
        //Edit an item and flush the input fields.
        try {
            if(listOfItems.setItem(searchSerialField.getText(),serialField.getText(),nameField.getText(),valueField.getText())){
                curItem = listOfItems.getItemBySerial(serialField.getText());

                serialField.setText(curItem.getSerialNumber());
                nameField.setText(curItem.getName());
                valueField.setText(curItem.getValue());

                clear();
            }

        } catch (IllegalArgumentException e){
            clear();
        }
    }

    public void clear(){
        //Clear all fields.
        curItem = null;
        searchNameField.clear();
        searchSerialField.clear();
        serialField.clear();
        nameField.clear();
        valueField.clear();
    }
}
