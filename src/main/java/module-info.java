module sbc.diagnocom.diagnocom {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    requires rule;
    requires itextpdf;
    requires java.desktop;


    opens sbc.diagnocom to javafx.fxml;
    exports sbc.diagnocom;
}