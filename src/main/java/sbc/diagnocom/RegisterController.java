package sbc.diagnocom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class RegisterController {
    private String userString;
    private String passwordString;
    private Connection baseD;
    
    @FXML
    private TextField usuario;
    
    @FXML
    private PasswordField contras;

    @FXML
    private Label info;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Button guardar;

    @FXML
    private Button salir;

    @FXML
    private Button volver;
    

    @FXML
    public void guardarPressed() throws SQLException {
        Statement st;        
        userString = usuario.getText();
        passwordString = contras.getText();
        int id_user;
        
        if (userString.isBlank() || userString.isEmpty() || passwordString.isBlank() || passwordString.isEmpty()) {
            rectangle.setVisible(true);
            info.setText("¡USUARIO O CONTRASEÑA VACIOS!");
            info.setVisible(true);
            return;
        }

        try { // Revisa que solo sean numeros en el usuario
            id_user = Integer.parseInt(userString);
        } catch (NumberFormatException n) {
            rectangle.setVisible(true);
            info.setText("¡USUARIO INCORRECTO!");
            info.setVisible(true);
            return;
        }
        
        var cnx = new Conexion();
        baseD = cnx.getCNX();
        
        StringBuilder s = new StringBuilder("insert into credencial values (");
        s.append(id_user).append(", '").append(passwordString);
        s.append("') ");
        
        st = baseD.createStatement();
        st.executeUpdate(new String(s));
        
        st.close();
        cnx.closeCNX();
        
        info.setText("¡DATOS GUARDADOS!");
        rectangle.setVisible(true);
        info.setVisible(true);
    }

    @FXML
    public void salirPressed() {
        System.exit(0);
    }

    @FXML
    public void usrPswrSelected() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }

    @FXML
    public void volverPressed() throws IOException {
        App.setRoot("login", 400, 480, "Login");
    }
    
    @FXML
    void initialize() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }
}
