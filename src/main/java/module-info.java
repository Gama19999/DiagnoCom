module sbc.diagnocom.diagnocom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires rule;
    requires itextpdf;


    opens sbc.diagnocom to javafx.fxml;
    exports sbc.diagnocom;
}