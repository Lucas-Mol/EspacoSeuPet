/*
 * Classe DadosMySQL
 * Função: Classe designada para criação das constante que serão usadas para conexão com o Banco de Dados - MySQL
 *
 */
package connections;

/**
 *
 * @author Lucas Mol
 */
public class DadosMySQL {
    
    //-------------------------------------------------------------------------------------
    //---------ALTERE OS DADOS CORRESPONDENTES AO SEU MYSQL AQUI---------------------------
    //-------------------------------------------------------------------------------------
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_veterinario?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "1234";
    
    
    //Getters
    public static String getDRIVER() {
        return DRIVER;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }
    
    
    
}
