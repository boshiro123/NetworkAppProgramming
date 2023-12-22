package com.example.sport.Contoller;

import javafx.fxml.FXML;
import com.example.sport.DoorInWindow;
import javafx.scene.control.Button;

public class HelloViewController extends DoorInWindow {

    @FXML
    private Button buy;
    @FXML
    private Button sell;

    public void openBuy(){
        buy.getScene().getWindow().hide();
        OpenWindow("View1.fxml");

    }
    public void openCell(){
        sell.getScene().getWindow().hide();
        OpenWindow("View2.fxml");

    }
}