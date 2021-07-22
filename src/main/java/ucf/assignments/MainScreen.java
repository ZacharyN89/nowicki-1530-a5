package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {
    @FXML private TableView<Item> itemsTable;
    @FXML private TableColumn<Item, String> serialColumn;
    @FXML private TableColumn<Item, String> nameColumn;
    @FXML private TableColumn<Item, String> valueColumn;

    private SceneManager sceneManager;
    private ItemsManager listOfItems;

    public MainScreen(ItemsManager newItemList, SceneManager newSceneManager){
        listOfItems = newItemList;
        sceneManager = newSceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        serialColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("value"));

        listOfItems.addItem("1223","Chucky Doll","$15.00");
        listOfItems.addItem("1233","Barbie Doll","$14.00");
        listOfItems.addItem("1243","Ken Doll","$16.50");

        itemsTable.setItems(listOfItems.getItemsList());
    }

    public void addItemClicked(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("Add an Item");
        stage.setScene(sceneManager.getScene("AddItemScreen"));
        stage.show();
    }

    public void searchClicked(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("Search for an Item");
        stage.setScene(sceneManager.getScene("SearchItemScreen"));
        stage.show();
    }
}
