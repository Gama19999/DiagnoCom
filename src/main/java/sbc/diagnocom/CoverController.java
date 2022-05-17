package sbc.diagnocom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CoverController {
    
    @FXML
    private Label fecha;
    
    @FXML
    private Button sistemaEx;
    
    @FXML
    private Button metodo;

    @FXML
    public void switchToLogin() throws IOException {
        App.setRoot("login", 400, 480, "Login");
    }
    
    @FXML
    public void switchToMethod() throws IOException {
        App.setRoot("inteligente", 1010, 630, "Algoritmo Apriori");
    }
    
    @FXML
    void initialize() {
        fecha.setText(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()));
    }
}
