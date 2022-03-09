package sbc.diagnocom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String url = "jdbc:mysql://localhost:3306/diagnocom";
    private final Connection CNX;
    
    Conexion() throws SQLException {
        CNX = DriverManager.getConnection(url, "external", "12345");
    }
    
    public Connection getCNX() {
        return CNX;
    }
    
    public void closeCNX() throws SQLException {
        CNX.close();
    }
}
