module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.apache.poi.poi;
    requires org.seleniumhq.selenium.devtools_v117;
    requires org.seleniumhq.selenium.json;
//    requires org.seleniumhq.selenium.devtools;
    requires org.seleniumhq.selenium.edge_driver;
    requires dev.failsafe;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}