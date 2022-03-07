package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private String host;
    private String db;
    private String port;
    private String user;
    private String pass;
    private Connection conn;
    
    public DatabaseConnection() {
        host = "localhost";
        db = "tanar_bikerent";
        port = "3306";
        user = "root";
        pass = "";
        conn = null;
    }
    
    public void setConnection() {
        
        try {
            //jdbc://localhost:3306/tanar_bikerent
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            conn = DriverManager.getConnection( url, user, pass );
                
        } catch ( SQLException e ) {
            
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return conn;
    }
}

