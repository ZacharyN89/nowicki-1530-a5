package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsManagerTest {

    @Test
    void addItem() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");

        Item testItem = list.getItemBySerial("1223");
        assertEquals("Chucky Doll",testItem.getName());
    }

    @Test
    void removeItem() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");

        list.removeItem("1223");
        try{
            list.getItemBySerial("1223");
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    void getItemBySerial() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");

        Item testItem = list.getItemBySerial("1223");
        assertEquals("Chucky Doll",testItem.getName());
    }

    @Test
    void getItemByName() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");

        Item testItem = list.getItemByName("Chucky Doll");
        assertEquals("1223",testItem.getSerialNumber());
    }

    @Test
    void setItem() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");
        list.setItem("1223","1224","Hello Doll","$15.00");

        Item testItem = list.getItemByName("Hello Doll");
        assertEquals("1224",testItem.getSerialNumber());
    }
}