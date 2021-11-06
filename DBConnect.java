package RevatureBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


// Allows for JDBC to the localhost MySQL server using the credentials of dbConfig.

public class DBConnect{

    private static Connection connection = null;

    private DBConnect(){}

    public static Connection getConnection(){
        if(connection == null){
            ResourceBundle bundle = ResourceBundle.getBundle("RevatureBank/dbConfig");
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password = bundle.getString("password");

            try{
                connection = DriverManager.getConnection(url, username, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
