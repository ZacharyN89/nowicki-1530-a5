package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsManager {
    private ObservableList<Item> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList(){
        return itemsList;
    }

    public boolean addItem(String serialNumber, String name, String value){
        //Make sure the item does not already exist.
        for(Item item: itemsList){
            if(serialNumber.equals(item.getSerialNumber())){
                return false;
            }
        }

        //Make sure the input variables are acceptable.
        try {
            Item newItem = new Item(serialNumber, name, value);
            itemsList.add(newItem);
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public void removeItem(String serial){
        //Search the list for the item and remove it.
        for(Item item: itemsList){
            if(serial.equals(item.getSerialNumber())){
                itemsList.remove(item);
                break;
            }
        }
    }

    public Item getItemByName(String searchName){
        //Search for and return a reference to an item by its name.
        for(Item item: itemsList){
            if(searchName.equals(item.getName())){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    public Item getItemBySerial(String searchSerial){
        //Search for and return a reference to an item by its serial number.
        for(Item item: itemsList){
            if(searchSerial.equals(item.getSerialNumber())){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean setItem(String curItemSerial, String newSerial, String newName, String newValue){
        //Find the item n the list. Exit if it does not exist.
        for(Item item: itemsList){
            if(newSerial.equals(item.getSerialNumber()) && !curItemSerial.equals(newSerial)){
                return false;
            }
        }

        //See if the input variables are acceptable.
        try {
            for (Item item : itemsList) {
                //Find the item then do the replacement.
                if (curItemSerial.equals(item.getSerialNumber())) {
                    item.setSerialNumber(newSerial);
                    item.setName(newName);
                    item.setValue(newValue);

                    //Refresh the list in the MainScreen.
                    ObservableList<Item> copyList = itemsList;
                    itemsList.removeAll();
                    FXCollections.copy(itemsList,copyList);

                    return true;
                }
            }
            return false;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
