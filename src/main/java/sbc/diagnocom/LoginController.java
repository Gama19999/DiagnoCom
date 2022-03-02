package sbc.diagnocom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class LoginController {
    private Connection baseD;
    
    @FXML
    TextField usuario;
    
    @FXML
    TextField contras;
    
    @FXML
    Label info;
    
    @FXML
    Button volver;
    
    @FXML
    Button registrar;
    
    @FXML
    Button salir;
    
    @FXML
    Rectangle rectangle;

    @FXML
    private void volverPressed() throws IOException {
        App.setRoot("cover", 800, 500, "DiagnoCom");
    }
    
    @FXML
    private void passwordActived() throws SQLException {
        Statement st;
        ResultSet rs;
        String user = usuario.getText();
        String pswrd = contras.getText();
        
        if (user.isBlank() || user.isEmpty()) {
            rectangle.setVisible(true);
            info.setText("¡USUARIO VACÍO!");
            info.setVisible(true);
            return;
        }
        
        var con = new Conexion();
        baseD = con.getCNX();
        
        st = baseD.createStatement();
        rs = st.executeQuery("select id_user, password from credencial where id_user=" +  user);
        
        while (rs.next()) {
            if (!rs.getString(2).equals(pswrd)) {
                rectangle.setVisible(true);
                info.setText("¡DATOS NO RECONOCIDOS!");
                info.setVisible(true);
            }
        }
        
        rs.close();
        st.close();
    }
    
    @FXML
    private void registrarPressed() throws IOException {
        App.setRoot("register", 300, 300, "Registering");
    }
    
    @FXML
    private void usrPswrSelected() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }
    
    @FXML
    private void salirPressed() {
        System.exit(0);
    }
    
    @FXML
    void initialize() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }
}