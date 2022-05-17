package sbc.diagnocom;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Border;

import java.io.IOException;
import java.util.*;

import apriori.Apriori;

public class AprioriController {
    private List<Set<String>> sets;
    private Apriori obj;
    private ObservableList<ObservableList<String>> data;

    @FXML
    private Button btnSemanal;
    @FXML
    private Button btnVolver;

    @FXML
    private TableView<ObservableList<StringProperty>> tabla;

    @FXML
    private TextArea textApriori;


    @FXML
    private void btnSemanalPressed() {
        if (tabla.getItems().isEmpty()) {
            for (var i : sets) {
                data.add(FXCollections.observableArrayList()); // Agrega una tupla

                int index = data.size() - 1;
                data.get(index).add(String.valueOf(index));   // Agrega el numero de DIA
                data.get(index).add(i.toString());            // Agrega el CONJUNTO
            }

            fillTable(data);

            textApriori.setText(obj.getText().replaceAll("Escanear", "NuevoItemSet"));
        }
    }

    @FXML
    private void btnVolverPressed() throws IOException {
        App.setRoot("cover", 800, 500, "DiagnoCom");
    }

    private void fillTable(ObservableList<ObservableList<String>> info) {
        // Crear y agregar columnas a la tabla
        ObservableList<String> names = info.remove(0);
        for (var i = 0; i < names.size(); ++i) {
            int indice = i;
            TableColumn<ObservableList<StringProperty>, String> col = new TableColumn<>(names.get(i));
            col.setCellValueFactory(celda -> celda.getValue().get(indice));
            col.setEditable(false);
            if (i == 0) {
                col.setPrefWidth(50.0);
                col.setStyle("-fx-alignment: center; -fx-font-weight: bold;");
            }
            col.setStyle("-fx-font-weight: bold;");
            tabla.getColumns().add(col);
        }

        // Agregar los datos a la tabla
        for (var fila : info) {
            ObservableList<StringProperty> tuplas = FXCollections.observableArrayList();
            for (var cell : fila) {
                tuplas.add(new SimpleStringProperty(cell));
            }
            tabla.getItems().add(tuplas);
        }
    }

    @FXML
    void initialize() {
        data = FXCollections.observableArrayList();
        data.add(FXCollections.observableArrayList());
        data.get(0).add("DÍA");
        data.get(0).add("ENFERMEDADES PRESENTADAS");

        var label = new Label("Presione botón \"Análisis Semanal\"");
        label.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill: white;");
        tabla.setPlaceholder(label);
        tabla.setBorder(Border.EMPTY);


        sets = new ArrayList<>();
        ArrayList<String> e = new ArrayList<>(Arrays.asList(
                "Migrania","Infeccion Oido",
                "Gripe Comun","Bronquitis","Tos Flema","Sinusitis","Influenza","Sinusitis Bacteriana","Neumonia","Fibrosis Pulmonar","Bronquilitis",
                "Infeccion Estomago","Estrenimiento","Indigestion","Gastritis","Colitis",
                "Apendicitis","Esofagitis","Pancreatitis","Anemia",
                "Infeccion Urinaria",
                "Infeccion Piel"
        ));

        Random r = new Random();

        for (var i = 0; i < 7; i++) {
            var v = r.nextInt(7, 13);
            ArrayList<String> tempE = new ArrayList<>(e);

            switch (v) {
                case 7 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
                case 8 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
                case 9 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
                case 10 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
                case 11 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
                case 12 -> sets.add(Set.of(
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size())),
                        tempE.remove(r.nextInt(tempE.size()))
                ));
            }
        }

        obj = new Apriori(sets, 0.5, 0.8);
    }
}
