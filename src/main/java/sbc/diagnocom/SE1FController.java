package sbc.diagnocom;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SE1FController {
    private DiagnoComBR obj;
    
    @FXML
    private Button showResult;
    @FXML
    private Button next;
    @FXML
    private Button reiniciar;
    @FXML
    private Button salir;
    
    @FXML
    private CheckBox afeccionCabeza;
    @FXML
    private CheckBox afeccionRespiratoria;
    @FXML
    private CheckBox afeccionDigestiva;
    @FXML
    private CheckBox afeccionInterna;
    @FXML
    private CheckBox afeccionUrinaria;
    @FXML
    private CheckBox afeccionPiel;
    
    @FXML
    private Label resultado;
    
    
    @FXML
    private void encadenar() {
        String afCab, afRes, afDig, afInt, afUri, afPiel, res;
        
        afCab = afeccionCabeza.isSelected() ? "si" : "no";
        afRes = afeccionRespiratoria.isSelected() ? "si" : "no";
        afDig = afeccionDigestiva.isSelected() ? "si" : "no";
        afInt = afeccionInterna.isSelected() ? "si" : "no";
        afUri = afeccionUrinaria.isSelected() ? "si" : "no";
        afPiel = afeccionPiel.isSelected() ? "si" : "no";
        
        res = obj.getAfeccion(afCab, afRes, afDig, afInt, afUri, afPiel);
        resultado.setText("Su afeción es: " + res);
    }
    
    @FXML
    private void nextPressed() throws IOException {
        App.setRoot("se2F", 800, 500, "ENFERMEDAD");
    }
    
    @FXML
    private void reiniciarPressed() throws IOException {
        App.setRoot("cover", 800, 500, "DiagnoCom");
    }
    
    @FXML
    private void salirPressed() {
        System.exit(0);
    }
    
    @FXML
    void initialize() {
        obj = new DiagnoComBR();
    }
}
