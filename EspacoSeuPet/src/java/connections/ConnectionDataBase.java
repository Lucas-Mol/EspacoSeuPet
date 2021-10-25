/*
 * Classe ConnectionDataBase
 * Função: Classe designada para os métodos de conexão com o Banco de Dados - MySQL
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
    
    //Declaração do Objeto para capturar os dados do DataBase - MySQL
    DadosMySQL dadosDataBase = new DadosMySQL();
    
    //Declaração das constantes para iniciar conexão
    private static final String DRIVER = DadosMySQL.getDRIVER();
    private static final String URL = DadosMySQL.getURL();
    private static final String USER = DadosMySQL.getUSER();
    private static final String PASS = DadosMySQL.getPASS();
    
    //método para iniciar e retornar conexão
    public static Connection conectar(){
        try{
            Class.forName(DRIVER);
            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Algo aconteceu de errado com a conexão com o banco, veja: "+ ex);
        }
    }
    
    //método para desconectar
    public static void desconectar(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException ex){
                throw new RuntimeException("Algo aconteceu de errado com a desconexão com o banco, veja: "+ex);
            }
        }
    }
    
    //método para desconectar com o PreparedStatement
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
    
    //método para desconectar com o PreparedStatement e o ResultSet
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
