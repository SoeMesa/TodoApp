
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pelu
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "admin";
    public static final String PASS = "wasaloko";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
                  
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
        }
        
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null) {
                connection.close();
            }
            
            if (statement != null){
                statement.close();
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
        }
        
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            
            if (statement != null){
                statement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
        }
        
    }
    
}
