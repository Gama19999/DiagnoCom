package sbc.diagnocom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SE2FController {
    // Afeccion: CABEZA
    @FXML
    private CheckBox dolorCabeza;
    @FXML
    private CheckBox presionArtAlta;
    @FXML
    private CheckBox fiebre;
    @FXML
    private CheckBox zumbidoOidos;
    @FXML
    private CheckBox nauseas;
    @FXML
    private CheckBox dolorGarganta;
    @FXML
    private CheckBox dolorOido;
    
    // Afeccion: RESPIRATORIO
    @FXML
    private CheckBox tos;
    @FXML
    private CheckBox dolorPecho;
    @FXML
    private CheckBox escurrNasal;
    @FXML
    private CheckBox fatiga;
    @FXML
    private CheckBox congestNasal;
    @FXML
    private CheckBox dolorCorpor;
    @FXML
    private CheckBox dificRespir;
    @FXML
    private CheckBox estornudos;
    @FXML
    private CheckBox dolorArticu;
    @FXML
    private CheckBox dolorEspalda;
    
    // Afeccion: DIGESTIVO
    @FXML
    private CheckBox dolorAbdomin;
    @FXML
    private CheckBox evacuConstan;
    @FXML
    private CheckBox acidezEstom;
    @FXML
    private CheckBox vomito;
    @FXML
    private CheckBox hemorRectal;
    @FXML
    private CheckBox diarrea;
    @FXML
    private CheckBox evacuConDolor;
    
    // Afeccion: INTERNO
    
    // Afeccion: URINARIO
    @FXML
    private CheckBox dolorAlOrin;
    @FXML
    private CheckBox sangradoAlOrin;
    
    // Afeccion: CUTANEO
    @FXML
    private CheckBox pielEnrogeci;
    @FXML
    private CheckBox inflamZonaPiel;
    @FXML
    private CheckBox altaSensibZona;
    
    // Botones de accion
    @FXML
    private Button encadenar;
    @FXML
    private Button next;
    @FXML
    private Button reiniciar;
    @FXML
    private Button limpiarCeldas;
    @FXML
    private Button salir;
    
    // Labels de informacion
    @FXML
    private Label resultado;
    @FXML
    private Label info;
    
    private ArrayList<CheckBox> checkboxes;
    
    @FXML
    private void encadenarPressed() {
        if (App.encadenamientos.size() == 2) {
            var s = new StringBuilder("Por favor presione el botón \"SIGUIENTE\"");
            s.append(" o limpie las celdas para responder a diferentes\nsintomas.");
            s.append("\nLuego presione el boton \"RESULTADO\"");
            
            info.setText(s.toString());
            info.setVisible(true);
            return;
        }
        
        String afeccion = App.encadenamientos.peek().toString();
        String enfermedad = "";
        
        info.setText("");
        info.setVisible(false);
        
        switch(afeccion) {
            case "D.CABEZA" -> {
                enfermedad = App.br.getD_Cabeza(
                        afeccion, dolorCabeza.isSelected() ? "si" : "no",
                        presionArtAlta.isSelected() ? "si" : "no",
                        fiebre.isSelected() ? "si" : "no",
                        zumbidoOidos.isSelected() ? "si" : "no",
                        nauseas.isSelected() ? "si" : "no",
                        dolorGarganta.isSelected() ? "si" : "no",
                        dolorOido.isSelected() ? "si" : "no"
                );
            }
            case "D.RESPIRATORIO" -> {
                enfermedad = App.br.getD_Respiratorio(
                        afeccion, tos.isSelected() ? "si" : "no",
                        fiebre.isSelected() ? "si" : "no",
                        dolorGarganta.isSelected() ? "si" : "no",
                        dolorPecho.isSelected() ? "si" : "no",
                        escurrNasal.isSelected() ? "si" : "no",
                        fatiga.isSelected() ? "si" : "no",
                        congestNasal.isSelected() ? "si" : "no",
                        dolorCabeza.isSelected() ? "si" : "no",
                        dolorCorpor.isSelected() ? "si" : "no",
                        dificRespir.isSelected() ? "si" : "no",
                        estornudos.isSelected() ? "si" : "no",
                        dolorArticu.isSelected() ? "si" : "no",
                        dolorEspalda.isSelected() ? "si" : "no"
                );
            }
            case "D.DIGESTIVO" -> {
                enfermedad = App.br.getD_Digestivo(
                        afeccion,fiebre.isSelected() ? "si" : "no",
                        dolorAbdomin.isSelected() ? "si" : "no",
                        evacuConstan.isSelected() ? "si" : "no",
                        nauseas.isSelected() ? "si" : "no",
                        acidezEstom.isSelected() ? "si" : "no",
                        vomito.isSelected() ? "si" : "no",
                        fatiga.isSelected() ? "si" : "no",
                        hemorRectal.isSelected() ? "si" : "no",
                        diarrea.isSelected() ? "si" : "no",
                        evacuConDolor.isSelected() ? "si" : "no",
                        dolorPecho.isSelected() ? "si" : "no"
                );
            }
            case "D.INTERNO" -> {
                enfermedad = App.br.getD_Interno(
                        afeccion, fiebre.isSelected() ? "si" : "no",
                        dolorAbdomin.isSelected() ? "si" : "no",
                        nauseas.isSelected() ? "si" : "no",
                        vomito.isSelected() ? "si" : "no",
                        tos.isSelected() ? "si" : "no",
                        dolorPecho.isSelected() ? "si" : "no",
                        acidezEstom.isSelected() ? "si" : "no",
                        dolorEspalda.isSelected() ? "si" : "no",
                        dificRespir.isSelected() ? "si" : "no",
                        fatiga.isSelected() ? "si" : "no",
                        evacuConstan.isSelected() ? "si" : "no",
                        dolorGarganta.isSelected() ? "si" : "no",
                        hemorRectal.isSelected() ? "si" : "no",
                        diarrea.isSelected() ? "si" : "no"
                );
            }
            case "D.URINARIO" -> {
                enfermedad = App.br.getD_Urinario(
                        afeccion, nauseas.isSelected() ? "si" : "no",
                        dolorAlOrin.isSelected() ? "si" : "no",
                        sangradoAlOrin.isSelected() ? "si" : "no",
                        dolorEspalda.isSelected() ? "si" : "no",
                        fiebre.isSelected() ? "si" : "no"
                );
            }
            case "D.CUTANEO" -> {
                enfermedad = App.br.getD_Cutaneo(
                        afeccion, pielEnrogeci.isSelected() ? "si" : "no",
                        inflamZonaPiel.isSelected() ? "si" : "no",
                        altaSensibZona.isSelected() ? "si" : "no"
                );
            }
        }
        
        if (Objects.isNull(enfermedad)) {
            resultado.setText("¡Los datos no figuran con algún resultado conocido!");
            resultado.setVisible(true);
        } else {
            resultado.setText("Dados sus sintomas, su enfermedad es: " +
                        enfermedad + " categorizada en el: " + afeccion);
            resultado.setVisible(true);
            App.encadenamientos.push(enfermedad);
        }
    }
    
    @FXML
    private void nextPressed() {
        if (App.encadenamientos.size() < 2) {
            var s = new StringBuilder("Por favor marque sus respuestas a las");
            s.append(" preguntas y presione el boton \"RESULTADO\"");
            
            info.setText(s.toString());
            info.setVisible(true);
        }
    }
    
    @FXML
    private void reiniciarPressed() throws IOException {
        App.setRoot("se1F", 840, 580, "LUGAR DE LA AFECCIÓN");
        App.encadenamientos.removeAllElements();
    }
    
    @FXML
    private void limpiarCeldasPressed() {
        checkboxes.forEach(i -> {
            if (!Objects.isNull(i)) i.setSelected(false);
        });
        
        info.setText("");
        info.setVisible(false);
        resultado.setText("");
        resultado.setVisible(false);
        
        if (App.encadenamientos.size() == 2) App.encadenamientos.pop();
    }
    
    @FXML
    private void salirPressed() {
        System.exit(0);
    }
    
    
    @FXML
    void initialize() {
        checkboxes = new ArrayList(Arrays.asList(
            dolorCabeza, presionArtAlta, fiebre, zumbidoOidos, nauseas, dolorGarganta,
            dolorOido, tos, dolorPecho, escurrNasal, fatiga, congestNasal, dolorCorpor,
            dificRespir, estornudos, dolorArticu, dolorEspalda, dolorAbdomin, evacuConstan,
            acidezEstom, vomito, hemorRectal, diarrea, evacuConDolor, dolorAlOrin,
            sangradoAlOrin, pielEnrogeci, inflamZonaPiel, altaSensibZona
        ));
        
        info.setVisible(false);
        resultado.setVisible(false);
    }
}
