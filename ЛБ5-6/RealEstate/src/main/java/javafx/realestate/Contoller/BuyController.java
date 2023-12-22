package javafx.realestate.Contoller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.realestate.DoorInWindow;
import javafx.realestate.Model.House;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyController extends DoorInWindow {
    @FXML
    private Button Close_Button;
    @FXML
    private TableColumn<House, String> adressColumn;

    @FXML
    private TableColumn<House, Integer> roomsColumn;

    @FXML
    private TableColumn<House, Integer> squareColumn;

    @FXML
    private TableColumn<House, Integer> costColumn;

    @FXML
    private TableView<House> houseTable;

    public DataBaseController dbHandler = new DataBaseController();
    ObservableList<House> houseList = FXCollections.observableArrayList();

    @FXML
    void CloseWindow() {
        Close_Button.getScene().getWindow().hide();
        OpenWindow("helloView.fxml");
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        updateTable();
    }
    public void updateTable() throws SQLException, ClassNotFoundException {
        houseList.clear();
        ResultSet resSet = dbHandler.getHouses();
        while (resSet.next()) {
            houseList.add(new House(resSet.getInt(1),resSet.getString(2),resSet.getString(3),
                    resSet.getInt(4),resSet.getInt(5),resSet.getInt(6),resSet.getInt(7)));
        }
        System.out.println(houseList.size());
        adressColumn.setCellValueFactory(cellData -> {
            House house = cellData.getValue();
            String address = "г."+ house.getCity()+", ул." + house.getStreetName() + " д." + house.getHomeNumber();
            return new SimpleStringProperty(address);
        });
        roomsColumn.setCellValueFactory(new PropertyValueFactory<>("rooms"));
        squareColumn.setCellValueFactory(new PropertyValueFactory<>("square"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        houseTable.setItems(houseList);
    }
    public void deleteHouse() throws SQLException, ClassNotFoundException {
        dbHandler.deleteHouse(houseTable.getSelectionModel().getSelectedItem().getId());
        updateTable();
    }

}
