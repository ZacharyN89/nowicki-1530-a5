package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsManager {
    private ObservableList<Item> itemsList = FXCollections.observableArrayList();

    public ObservableList<Item> getItemsList(){
        return itemsList;
    }

    public boolean addItem(String serialNumber, String name, String value){
        for(Item item: itemsList){
            if(serialNumber.equals(item.getSerialNumber())){
                return false;
            }
        }

        try {
            Item newItem = new Item(serialNumber, name, value);
            itemsList.add(newItem);
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public void removeItem(String serial){
        for(Item item: itemsList){
            if(serial.equals(item.getSerialNumber())){
                itemsList.remove(item);
                break;
            }
        }
    }

    public Item getItemByName(String searchName){
        for(Item item: itemsList){
            if(searchName.equals(item.getName())){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    public Item getItemBySerial(String searchSerial){
        for(Item item: itemsList){
            if(searchSerial.equals(item.getSerialNumber())){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean setItem(String curItemSerial, String newSerial, String newName, String newValue){
        for(Item item: itemsList){
            if(newSerial.equals(item.getSerialNumber()) && !curItemSerial.equals(newSerial)){
                return false;
            }
        }

        try {
            for (Item item : itemsList) {
                if (curItemSerial.equals(item.getSerialNumber())) {
                    item.setSerialNumber(newSerial);
                    item.setName(newName);
                    item.setValue(newValue);

                    //Refresh the List in the MainScreen
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
