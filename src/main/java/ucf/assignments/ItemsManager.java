package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsManager {
    private ObservableList<Item> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList(){
        return itemsList;
    }

    public boolean addItem(String serialNumber, String name, String value){
        try {
            Item newItem = new Item(serialNumber, name, value);
            itemsList.add(newItem);
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }
}
