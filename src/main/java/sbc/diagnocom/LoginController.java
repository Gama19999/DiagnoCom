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
    private TextField usuario;
    
    @FXML
    private TextField contras;
    
    @FXML
    private Label info;
    
    @FXML
    private Button volver;
    
    @FXML
    private Button registrar;
    
    @FXML
    private Button salir;
    
    @FXML
    private Rectangle rectangle;

    @FXML
    private void volverPressed() throws IOException {
        App.setRoot("cover", 800, 500, "DiagnoCom");
    }
    
    @FXML
    private void passwordActived() throws SQLException, IOException {
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
        rs = st.executeQuery("select * from credencial where id_user=" +  user);
        
        if (rs.next()) {
            do {
                if (!rs.getString(2).equals(pswrd)) {
                    rectangle.setVisible(true);
                    info.setText("¡DATOS NO RECONOCIDOS!");
                    info.setVisible(true);
                } else {
                    sistemaExperto();
                }
            } while (rs.next());
        } else {
            rectangle.setVisible(true);
            info.setText("¡REGISTRARSE!");
            info.setVisible(true);
        }
        
        rs.close();
        st.close();
        con.closeCNX();
    }
    
    @FXML
    public void registrarPressed() throws IOException {
        App.setRoot("register", 400, 480, "Registering");
    }
    
    @FXML
    public void usrPswrSelected() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }
    
    @FXML
    public void salirPressed() {
        System.exit(0);
    }
    
    private void sistemaExperto() throws IOException {
        App.setRoot("se1F", 800, 500, "LUGAR DE LA AFECCIÓN");
    }
    
    @FXML
    void initialize() {
        rectangle.setVisible(false);
        info.setVisible(false);
    }
}