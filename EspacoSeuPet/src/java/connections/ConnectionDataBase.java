package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lucas Mol
 */
public class ConnectionDataBase {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_veterinario?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    public static Connection conectar(){
        try{
            Class.forName(DRIVER);
            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Algo aconteceu de errado com a conexão com o banco, veja: "+ ex);
        }
    }
    
    public static void desconectar(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException ex){
                throw new RuntimeException("Algo aconteceu de errado com a desconexão com o banco, veja: "+ex);
            }
        }
    }
    
    public static void desconectar(Connection conn, PreparedStatement stmt){
        if (stmt != null){
            try{
                stmt.close();
            }catch(SQLException ex){
                throw new RuntimeException("Algo aconteceu de errado com a desconexão com o banco, veja: " +ex);
            }
        }
        desconectar(conn);
    }
    
    public static void desconectar(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException ex){
                throw new RuntimeException("Algo aconteceu de errado com a desconexão com o banco, veja: " +ex);
            }
        }
        desconectar(conn, stmt);
    }
    
}
