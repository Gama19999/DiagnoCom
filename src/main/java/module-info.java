module sbc.diagnocom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires rule;

    opens sbc.diagnocom to javafx.fxml;
    exports sbc.diagnocom;
}
