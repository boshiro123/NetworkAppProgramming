module javafx.realestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;


    requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
//            requires eu.hansolo.tilesfx;
            requires com.almasb.fxgl.all;
    requires java.sql;

    opens javafx.realestate to javafx.fxml;
    exports javafx.realestate;
    exports javafx.realestate.Contoller;
    opens javafx.realestate.Contoller to javafx.fxml;
    opens javafx.realestate.Model to javafx.base;

}

