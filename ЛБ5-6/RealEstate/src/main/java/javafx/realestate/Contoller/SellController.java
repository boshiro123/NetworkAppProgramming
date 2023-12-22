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

public class SellController extends DoorInWindow {
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

    @FXML
    private TextField cityField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField numberHField;
    @FXML
    private TextField roomsField;
    @FXML
    private TextField squareField;
    @FXML
    private TextField costField;
    @FXML
    private Button clearInfoButton;


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

        houseTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && !houseTable.getSelectionModel().isEmpty()) {
                // Получение выбранной строки
                House selectedItem = houseTable.getSelectionModel().getSelectedItem();

                // Вызов нужного метода для выбранного объекта
                showInfo(selectedItem);
            }
        });
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

    public void addHouse() throws SQLException, ClassNotFoundException {
        House house = new House(cityField.getText(),streetField.getText(), Integer.valueOf(numberHField.getText()),
                Integer.valueOf(roomsField.getText()),Integer.valueOf(squareField.getText()),
                Integer.valueOf(costField.getText()));
        if(houseTable.getSelectionModel().isEmpty()){
            dbHandler.registerHouse(house);
            clearInfo();
        }
        else {
            house.setId(houseTable.getSelectionModel().getSelectedItem().getId());
            updateHouse(house);
        }
        updateTable();
    }


    public void updateHouse(House house) throws SQLException, ClassNotFoundException {
        dbHandler.updateHouse(house);
    }


    public void showInfo(House house){
        System.out.println(house.getId());
        cityField.setText(house.getCity());
        streetField.setText(house.getStreetName());
        numberHField.setText(String.valueOf(house.getHomeNumber()));
        roomsField.setText(String.valueOf(house.getRooms()));
        squareField.setText(String.valueOf(house.getSquare()));
        costField.setText(String.valueOf(house.getCost()));
    }

    public void clearInfo(){
        houseTable.getSelectionModel().clearSelection();
        cityField.setText("");
        streetField.setText("");
        numberHField.setText("");
        roomsField.setText("");
        squareField.setText("");
        costField.setText("");
    }




}
