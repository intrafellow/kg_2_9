module com.example.interpolation {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.math3;


    opens com.example.interpolation to javafx.fxml;
    exports com.example.interpolation;
    exports com.example.interpolation.math;
    opens com.example.interpolation.math to javafx.fxml;
    exports com.example.interpolation.controllers;
    opens com.example.interpolation.controllers to javafx.fxml;
}