package ucf.assignments;

public class Item {
    private String serialNumber;
    private String name;
    private String value;

    public Item(String newSerial, String newName, String newValue){
        if(!nameTest(newName)){
            throw new IllegalArgumentException();
        }
        if(!serialTest(newSerial)){
            throw new IllegalArgumentException();
        }
        if(!valueTest(newValue)){
            throw new IllegalArgumentException();
        }

        this.serialNumber = newSerial;
        this.name = newName;
        this.value = newValue;
    }

    public boolean serialTest(String testSerial){
        for (char c : testSerial.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                // found invalid char
                return false;
            }
        }
        return true;
    }

    public boolean valueTest(String testValue){
        for (char c : testValue.toCharArray()) {
            if (!Character.isDigit(c) && (c != '.') && (c != '$')) {
                // found invalid char
                return false;
            }
        }
        String[] split = testValue.split("\\.");
        try {
            if (split[0].charAt(0) != '$' || split[1].length() != 2) {
                return false;
            }
            return true;

        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public boolean nameTest(String testName){
        if((testName.length() > 1 && testName.length() < 257) || testName.isBlank()){
            return true;
        }
        return false;
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
        if(!serialTest(newSerialNumber)){
            throw new IllegalArgumentException();
        }
        serialNumber = newSerialNumber;
    }

    public void setName(String newName){
        if(!nameTest(newName)){
            throw new IllegalArgumentException();
        }
        name = newName;
    }

    public void setValue(String newValue){
        if(!valueTest(newValue)){
            throw new IllegalArgumentException();
        }
        value = newValue;
    }
}
