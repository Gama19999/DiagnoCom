package sbc.diagnocom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CoverController {
    
    @FXML
    Label fecha;
    
    @FXML
    Button sistemaEx;
    
    @FXML
    Button metodo;

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login", 400, 480, "Login");
    }
    
    @FXML
    private void switchToMethod() {
        
    }
    
    @FXML
    void initialize() {
        fecha.setText(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()));
    }
}
