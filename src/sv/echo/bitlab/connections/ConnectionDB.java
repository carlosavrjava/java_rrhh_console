/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cvasquez
 */
public class ConnectionDB {
    
    private static final String URL = "jdbc:mariadb://34.69.131.61:3306/RECURSOS";
    private static final String USER = "recursos";
    private static final String PASSWORD = "admin";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    
    
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
         Class.forName(DRIVER);
         return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void closeConnection(Connection con) throws SQLException{
        if(con!=null && !con.isClosed())
            con.close();
    }
    
}
