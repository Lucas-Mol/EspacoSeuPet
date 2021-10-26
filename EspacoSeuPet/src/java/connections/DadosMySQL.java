/*
 * Classe DadosMySQL
 * Função: classe designada para as constantes qeu serão alteradas pelo usuário
 */
package connections;

/**
 *
 * @author Lucas Mol
 */
public class DadosMySQL {
    
    //-------------------------------------------------------------------------
    //--------------ALTERE SEU USUÁRIO E SENHA DO MYSQL AQUI-------------------
    //-------------------------------------------------------------------------
    private static final String USER = "root";
    private static final String PASS = "1234";
    //---------------Constantes para autenticar no MySQL-----------------------
    
    //Getter
    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }
      
}
