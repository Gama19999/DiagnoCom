package sbc.diagnocom;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SE1FController {
    
    @FXML
    private Button encadenar;
    @FXML
    private Button next;
    @FXML
    private Button limpiarCeldas;
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
    private Label info;
    
    
    @FXML
    private void encadenarPressed() {
        String afCab, afRes, afDig, afInt, afUri, afPiel, afeccion;
        
        info.setText("");
        info.setVisible(false);
        
        afCab = afeccionCabeza.isSelected() ? "si" : "no";
        afRes = afeccionRespiratoria.isSelected() ? "si" : "no";
        afDig = afeccionDigestiva.isSelected() ? "si" : "no";
        afInt = afeccionInterna.isSelected() ? "si" : "no";
        afUri = afeccionUrinaria.isSelected() ? "si" : "no";
        afPiel = afeccionPiel.isSelected() ? "si" : "no";
        
        afeccion = App.br.getAfeccion(afCab, afRes, afDig, afInt, afUri, afPiel);
        
        if (Objects.isNull(afeccion)) {
            resultado.setText("¡Los datos no figuran con algún resultado conocido!");
            resultado.setVisible(true);
        } else {
            resultado.setText("Su afeción se categoriza como: " + afeccion);
            resultado.setVisible(true);
            App.encadenamientos.push(afeccion);
        }
    }
    
    @FXML
    private void nextPressed() throws IOException {
        if (App.encadenamientos.isEmpty()) {
            var s = new StringBuilder("Por favor marque sus respuestas a las");
            s.append(" preguntas y presione el boton \"RESULTADO\"");
            
            info.setText(s.toString());
            info.setVisible(true);
            return;
        }
        
        String frame = App.encadenamientos.peek().toString();
        switch (frame) {
            case "D.CABEZA" -> App.setRoot("se2Fcabeza", 840, 580, "ENFERMEDAD EN LA CABEZA");
            case "D.RESPIRATORIO" -> App.setRoot("se2Frespiratorio", 840, 580, "ENFERMEDAD RESPIRATORIA");
            case "D.DIGESTIVO" -> App.setRoot("se2Fdigestivo", 840, 580, "ENFERMEDAD DIGESTIVA");
            case "D.INTERNO" -> App.setRoot("se2Finterno", 840, 580, "ENFERMEDAD INTERNA");
            case "D.URINARIO" -> App.setRoot("se2Furinario", 840, 580, "ENFERMEDAD URINARIA");
            case "D.CUTANEO" -> App.setRoot("se2Fcutaneo", 840, 580, "ENFERMEDAD CUTÁNEA");
        }
    }
    
    @FXML
    private void limpiarCeldasPressed() {
        afeccionCabeza.setSelected(false);
        afeccionRespiratoria.setSelected(false);
        afeccionDigestiva.setSelected(false);
        afeccionInterna.setSelected(false);
        afeccionUrinaria.setSelected(false);
        afeccionPiel.setSelected(false);
        
        resultado.setText("");
        resultado.setVisible(false);
        
        App.encadenamientos.removeAllElements();
    }
    
    @FXML
    private void salirPressed() {
        System.exit(0);
    }
    
    @FXML
    void initialize() {
        info.setVisible(false);
        resultado.setVisible(false);
    }
}
