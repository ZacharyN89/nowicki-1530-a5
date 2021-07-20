package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsManager {
    private ObservableList<Item> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList(){
        return itemsList;
    }

    public boolean addItem(String serialNumber, String name, String value){
        //Throw an exception if bad name and use a try catch in the controller.

        Item newItem = new Item();
        newItem.setSerialNumber(serialNumber);
        newItem.setName(name);
        newItem.setValue(value);

        itemsList.add(newItem);
        return true;
    }
}
