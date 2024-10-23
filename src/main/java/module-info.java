module com.assignment.tictactoe.service.tictactoecoursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment.tictactoe.service.controller to javafx.fxml;
    exports com.assignment.tictactoe.service;
}