package ucf.assignments;

public class Item {
    private String serialNumber;
    private String name;
    private String value;

    public Item(String newSerial, String newName, String newValue){
        //Make sure the new values are acceptable.
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
        //A serial number should only have letters and numbers. If any other character is found it is an invalid serial number.
        for (char c : testSerial.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                // found invalid char
                return false;
            }
        }
        return true;
    }

    public boolean valueTest(String testValue){
        //A value should only have numbers, periods, and dollar signs.
        for (char c : testValue.toCharArray()) {
            if (!Character.isDigit(c) && (c != '.') && (c != '$')) {
                // found invalid char
                return false;
            }
        }
        //There should only be two numbers after the period.
        //There should be a dollar sign at the beginning of the value.
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
        //Name should only be 2-256characters in length inclusive.
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
