package ucf.assignments;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
    @FXML private TableView<Item> itemsTable;
    @FXML private TableColumn<Item, String> serialColumn;
    @FXML private TableColumn<Item, String> nameColumn;
    @FXML private TableColumn<Item, String> valueColumn;


    private ItemsManager listOfItems = new ItemsManager();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        serialColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("value"));

        listOfItems.addItem("1223","Chucky Doll","15.00");
        listOfItems.addItem("1233","Barbie Doll","14.00");
        listOfItems.addItem("1243","Ken Doll","16.50");

        itemsTable.setItems(listOfItems.getItemsList());
    }
}
