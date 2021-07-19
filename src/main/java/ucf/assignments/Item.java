package ucf.assignments;

public class Item {
    private String serialNumber;
    private String name;
    private String value;

    Item(String newSerialNumber, String newName, String newValue){
        serialNumber = newSerialNumber;
        name = newName;
        value = newValue;
    }

    public String getSerialNumber(){
        return serialNumber;
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    public void setSerialNumber(String newSerialNumber){
        serialNumber = newSerialNumber;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setValue(String newValue){
        value = newValue;
    }
}
