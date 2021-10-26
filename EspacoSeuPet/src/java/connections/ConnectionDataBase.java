/*
 * Classe ConnectionDataBase
 * Função: classe designada para a criação dos métodos de conexão e desconexão
 *
 */
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
    
    //Declarando as constantes com os dados para conectar com o MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_veterinario?autoReconnect=true&useSSL=false";
    private static final String USER = DadosMySQL.getUSER();
    private static final String PASS = DadosMySQL.getPASS();
    
    /** Método para conectar e retornar a conexão com o MySQL
     * 
     * @return Connection
     */
    public static Connection conectar(){
        try{
            Class.forName(DRIVER);
            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Algo aconteceu de errado com a conexão com o banco, veja: "+ ex);
        }
    }
    
    /** Método para desconectar com o MySQL
     * 
     * @param conn 
     */
    public static void desconectar(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException ex){
                throw new RuntimeException("Algo aconteceu de errado com a desconexão com o banco, veja: "+ex);
            }
        }
    }
    
    /** Método para desconectar com o MySQL
     * 
     * @param conn
     * @param stmt 
     */
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
    
    /** Método para desconectar com o MySQL
     * 
     * @param conn
     * @param stmt
     * @param rs 
     */
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
