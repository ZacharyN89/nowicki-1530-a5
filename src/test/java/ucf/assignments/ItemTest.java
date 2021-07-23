package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void all_correct_values_Test() {
        ItemsManager list = new ItemsManager();
        assertTrue(list.addItem("1223","Chucky Doll","$15.00"));
    }

    @Test
    void serialTest_same_serial() {
        ItemsManager list = new ItemsManager();
        list.addItem("1223","Chucky Doll","$15.00");
        assertFalse(list.addItem("1223","Hello Doll","$15.00"));
    }

    @Test
    void serialTest_special_characters() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("$$$","Chucky Doll","$15.00"));
    }

    @Test
    void valueTest_no_$() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("1223","Chucky Doll","15.00"));
    }

    @Test
    void valueTest_no_period() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("1223","Chucky Doll","$1500"));
    }

    @Test
    void valueTest_not_digits() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("1223","Chucky Doll","$ab.00"));
    }

    @Test
    void valueTest_bad_spacing() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("1223","Chucky Doll","$15.0"));
    }

    @Test
    void nameTest_less_characters() {
        ItemsManager list = new ItemsManager();
        assertFalse(list.addItem("1223","C","$15.00"));
    }
}