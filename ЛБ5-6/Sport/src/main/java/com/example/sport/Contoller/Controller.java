package com.example.sport.Contoller;

import com.example.sport.Model.Sport;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import com.example.sport.DoorInWindow;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller extends DoorInWindow {
    @FXML
    private Button Close_Button;
    @FXML
    private TableColumn<Sport, String> FIOColumn;

    @FXML
    private TableColumn<Sport, Integer> ageColumn;

    @FXML
    private TableColumn<Sport, Integer> heightColumn;

    @FXML
    private TableColumn<Sport, Integer> weightColumn;

    @FXML
    private TableView<Sport> Table;

    @FXML
    private TextField surnameF;
    @FXML
    private TextField firstNameF;
    @FXML
    private TextField secondNameF;
    @FXML
    private TextField ageF;
    @FXML
    private TextField heightF;
    @FXML
    private TextField weightF;
    @FXML
    private Button clearInfoButton;


    public DataBaseController dbHandler = new DataBaseController();
    ObservableList<Sport> List = FXCollections.observableArrayList();

    @FXML
    void CloseWindow() {
        Close_Button.getScene().getWindow().hide();
        OpenWindow("helloView.fxml");
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        updateTable();

        Table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && !Table.getSelectionModel().isEmpty()) {
                // Получение выбранной строки
                Sport selectedItem = Table.getSelectionModel().getSelectedItem();

                // Вызов нужного метода для выбранного объекта
                showInfo(selectedItem);
            }
        });
    }
    public void updateTable() throws SQLException, ClassNotFoundException {
        List.clear();
        ResultSet resSet = dbHandler.findAll();
        while (resSet.next()) {
            List.add(new Sport(resSet.getInt(1),resSet.getString(2),resSet.getString(3),
                    resSet.getString(4),resSet.getInt(5),resSet.getInt(6),resSet.getInt(7)));
        }
        System.out.println(List.size());
        FIOColumn.setCellValueFactory(cellData -> {
            Sport sport = cellData.getValue();
            String FIO = sport.getSurname()+" " + sport.getFirst_name() + " " + sport.getSecond_name();
            return new SimpleStringProperty(FIO);
        });
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        Table.setItems(List);
    }

    public void add() throws SQLException, ClassNotFoundException {
        Sport sport = new Sport(surnameF.getText(),firstNameF.getText(), secondNameF.getText(),
                Integer.valueOf(ageF.getText()),Integer.valueOf(heightF.getText()),
                Integer.valueOf(weightF.getText()));
        if(Table.getSelectionModel().isEmpty()){
            dbHandler.save(sport);
            clearInfo();
        }
        else {
            sport.setId(Table.getSelectionModel().getSelectedItem().getId());
            update(sport);
        }
        updateTable();
    }

    public void update(Sport sport) throws SQLException, ClassNotFoundException {
        dbHandler.update(sport);
    }
    public void delete() throws SQLException, ClassNotFoundException {
        dbHandler.delete(Table.getSelectionModel().getSelectedItem().getId());
        updateTable();
    }


    public void showInfo(Sport sport){
        System.out.println(sport.getId());
        surnameF.setText(sport.getSurname());
        firstNameF.setText(sport.getFirst_name());
        secondNameF.setText(sport.getSecond_name());
        ageF.setText(String.valueOf(sport.getAge()));
        heightF.setText(String.valueOf(sport.getHeight()));
        weightF.setText(String.valueOf(sport.getWeight()));
    }

    public void clearInfo(){
        Table.getSelectionModel().clearSelection();
        surnameF.setText("");
        firstNameF.setText("");
        secondNameF.setText("");
        ageF.setText("");
        heightF.setText("");
        weightF.setText("");
    }




}
