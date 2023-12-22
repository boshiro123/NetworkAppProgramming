package javafx.realestate.Contoller;

import javafx.fxml.FXML;
import javafx.realestate.DoorInWindow;
import javafx.scene.control.Button;

public class HelloViewController extends DoorInWindow {

    @FXML
    private Button buy;
    @FXML
    private Button sell;

    public void openBuy(){
        buy.getScene().getWindow().hide();
        OpenWindow("newView.fxml");

    }
    public void openCell(){
        sell.getScene().getWindow().hide();
        OpenWindow("newView2.fxml");

    }
}