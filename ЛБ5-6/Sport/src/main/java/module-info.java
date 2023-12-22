//module com.example.sport {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires javafx.web;
//
//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
////    requires eu.hansolo.tilesfx;
//    requires com.almasb.fxgl.all;
//
//    opens com.example.sport to javafx.fxml;
//    exports com.example.sport;
//}
module com.example.sport {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//            requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.sport to javafx.fxml;
    exports com.example.sport;
    exports com.example.sport.Contoller;
    opens com.example.sport.Contoller to javafx.fxml;
    opens com.example.sport.Model to javafx.base;
}
