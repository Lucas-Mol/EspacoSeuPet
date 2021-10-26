/*
 * Classe ControlesAgendamento
 * Função: classe designada para controle e manipulação dos dados de Agendamento no MySQL
 * Métodos: inserir, lista, buscar, atualizar e deletar
 *
*/
package models;

import beanclasses.DFViewBean;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import connections.ConnectionDataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Lucas Mol
 */
public class ControlesAgendamento {

    DFViewBean dfvb = new DFViewBean();//Instância da classe DFViewBean para Dialogs PopUp
    
    
    /** Método para inserir dados no MySQL
     * 
     * @param agend 
     */
    public void inserir(Agendamento agend){
        
        /** String a ser lida pela QUERY do MySQL
         * OBS: STR_TO_DATE: captura o valor inserido apontando 
         * para os respectivios dias, meses, anos, horas e minutos
        */
        String sql = "INSERT INTO tb_agendamento (dataAgendamento, nomeAnimal, tipoAnimal, nomeDono, telefone, observacoes) VALUES (STR_TO_DATE(?,'%d/%m/%Y %H:%i'), ?, ?, ?, ?, ?)";
        
        //Instânciando varíavel de conexão e capturando o método conectar
        Connection conn = ConnectionDataBase.conectar(); 
        PreparedStatement stmt = null;//Instânciando o PreparedStatement
        
        
        try {
            //PreparedStatement captura a linha QUERY a ser lida no MySQL
            //e relaciona com os valores preenchidos do objeto da clase Agendamento
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, agend.getDataAgendamento());
            stmt.setString(2, agend.getNomeAnimal());
            stmt.setString(3, agend.getTipoAnimal());
            stmt.setString(4, agend.getNomeDono());
            stmt.setString(5, agend.getTelefone());
            stmt.setString(6, agend.getObservacoes());
            
            //executando a QUERY
            stmt.execute();
            dfvb.mensagemAgendar();//chamando mensagem de concluído
            
            
        } catch (SQLException e) {
            dfvb.mensagemErroAgendar(e.getMessage());//chamando mensagem de erro
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);//desconectando do MySQL
        }
    }
    
    
    /** Método para ler e listar os dados do MySQl
     * 
     * @return List tipo Agendamento
     */
    public List<Agendamento> lista(){
        
        //String a ser lida pela QUERY do MySQL
        String sql = "SELECT * FROM tb_agendamento";
        
        //Declaração da varíavel List que receberá 
        //e retornará todos os dados de agendamento
        List<Agendamento> retorno = new ArrayList<>();
        Connection conn = ConnectionDataBase.conectar();//Instânciando varíavel de conexão e capturando o método conectar
        PreparedStatement stmt = null;//Instânciando o PreparedStatement
        
        
        try {
            stmt = conn.prepareStatement(sql);//PreparedStatement captura a linha QUERY a ser lida no MySQL
            ResultSet resultado = stmt.executeQuery();//Instânciando ResultSet para pegar os valores dos atributos
                                                      //vindos da execução da QUERY
            
                                                      
            /**
             * While até ter linha para ler, onde captura o valor vindos o ResultSet
             * e atribui aos atributos de um Objeto Agenda
             */                                          
            while(resultado.next()){
                Agendamento agend = new Agendamento();
                agend.setId_tb_agendamento(resultado.getInt("id_tb_agendamento"));
                //varíavel dataAgendamento recebe, de dataAgendamentoFormatada,
                //a data do MySQl em String já formatada para o Brasil
                agend.setDataAgendamento(agend.getDataAgendamentoFormatada().format(resultado.getTimestamp("dataAgendamento")));
                //varíavel dataAgendamentoStringOrdenada recebe, de dataAgendamentoDFormatORdenada
                //a data do MySQL em String já formatada para listagem ordenada
                agend.setDataAgendamentoStringOrdenada(agend.getDataAgendamentoDFormatOrdenada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setNomeAnimal(resultado.getString("nomeAnimal"));
                agend.setTipoAnimal(resultado.getString("tipoAnimal"));
                agend.setNomeDono(resultado.getString("nomeDono"));
                agend.setTelefone(resultado.getString("telefone"));
                agend.setObservacoes(resultado.getString("observacoes"));
                
                retorno.add(agend);//List do tipo Agendamento captura linha por linha dos agend
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());//erro no console
        }finally{
            ConnectionDataBase.desconectar(conn, stmt);//desconectando do MySQL
        }
        return retorno;// retorna a List do tipo Agendamento
    }
    
    /** Método para buscar pelo nome do animal no MySQl
     * 
     * @param a - varíavel com texto para busca em tempo real
     * @return List tipo Agendamento
     */
    public List<Agendamento> buscar(String a){
        
        //String a ser lida pela QUERY do MySQL
        String sql = "SELECT * FROM tb_agendamento WHERE nomeAnimal LIKE ?";
        
        //Declaração da varíavel List que receberá 
        //e retornará todos os dados de agendamento
        List<Agendamento> retorno = new ArrayList<>();
        Connection conn = ConnectionDataBase.conectar();//Instânciando varíavel de conexão e capturando o método conectar
        PreparedStatement stmt = null;//Instânciando o PreparedStatement
        
        
        try {
            stmt = conn.prepareStatement(sql);//PreparedStatement captura a linha QUERY a ser lida no MySQL
            
            /**PreparedStatement captura a linha QUERY adicionando o '%'
             * para simbolizar "qualquer coisa" após o que for inserido
             */
            stmt.setString(1, a+"%");
            ResultSet resultado = stmt.executeQuery();//Instânciando ResultSet para pegar os valores dos atributos
                                                      //vindos da execução da QUERY

            /**
             * While até ter linha para ler, onde captura o valor vindos o ResultSet
             * e atribui aos atributos de um Objeto Agenda
             */ 
            while(resultado.next()){
                Agendamento agend = new Agendamento();
                agend.setId_tb_agendamento(resultado.getInt("id_tb_agendamento"));
                //varíavel dataAgendamento recebe, de dataAgendamentoFormatada,
                //a data do MySQl em String já formatada para o Brasil
                agend.setDataAgendamento(agend.getDataAgendamentoFormatada().format(resultado.getTimestamp("dataAgendamento")));
                //varíavel dataAgendamentoStringOrdenada recebe, de dataAgendamentoDFormatORdenada
                //a data do MySQL em String já formatada para listagem ordenada
                agend.setDataAgendamentoStringOrdenada(agend.getDataAgendamentoDFormatOrdenada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setNomeAnimal(resultado.getString("nomeAnimal"));
                agend.setTipoAnimal(resultado.getString("tipoAnimal"));
                agend.setNomeDono(resultado.getString("nomeDono"));
                agend.setTelefone(resultado.getString("telefone"));
                agend.setObservacoes(resultado.getString("observacoes"));
                
                retorno.add(agend);//List do tipo Agendamento captura linha por linha dos agend
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());//erro no console
        }finally{
            ConnectionDataBase.desconectar(conn, stmt);//desconectando do MySQL
        }
        return retorno;//retorna a List do tipo Agendamento
    }
    
    /**Método para atualizar os dados no MySQL
     * 
     * @param agend 
     */
    public void atualizar(Agendamento agend){

        /** String a ser lida pela QUERY do MySQL
         * OBS: STR_TO_DATE: captura o valor inserido apontando 
         * para os respectivios dias, meses, anos, horas e minutos
        */
        String sql = "UPDATE tb_agendamento SET dataAgendamento = STR_TO_DATE(?,'%d/%m/%Y %H:%i'), nomeAnimal = ?, tipoAnimal = ?, nomeDono = ?, telefone = ?, observacoes = ? WHERE id_tb_agendamento = ?";
        
        Connection conn = ConnectionDataBase.conectar();//Instânciando varíavel de conexão e capturando o método conectar
        PreparedStatement stmt = null;//Instânciando o PreparedStatement
        
        try {
            //PreparedStatement captura a linha QUERY a ser lida no MySQL
            //e relaciona com os valores preenchidos do objeto da clase Agendamento
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, agend.getDataAgendamento());
            stmt.setString(2, agend.getNomeAnimal());
            stmt.setString(3, agend.getTipoAnimal());
            stmt.setString(4, agend.getNomeDono());
            stmt.setString(5, agend.getTelefone());
            stmt.setString(6, agend.getObservacoes());
            stmt.setInt(7, agend.getId_tb_agendamento());
            
            stmt.executeUpdate();//executando a QUERY
            dfvb.mensagemEditar();//chamando mensagem de concluído
            
        } catch (Exception e) {
            dfvb.mensagemErroEditar(e.getMessage());//chamando mensagem de erro
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);//desconectando do MySQL
        }
    }
    
    /** Método para deletar um agendamento inteiro do MySQL
     * 
     * @param agend 
     */
    public void deletar(Agendamento agend){
        
        //String a ser lida pela QUERY do MySQL
        String sql = "DELETE FROM tb_agendamento WHERE id_tb_agendamento = ?";
        Connection conn = ConnectionDataBase.conectar();//Instânciando varíavel de conexão e capturando o método conectar
        PreparedStatement stmt = null;//Instânciando o PreparedStatement
        
        try {
            
            stmt = conn.prepareStatement(sql);//PreparedStatement captura a linha QUERY a ser lida no MySQL
            stmt.setInt(1, agend.getId_tb_agendamento());// e relaciona a chave id
            
            stmt.execute();//executando a QUERY
            dfvb.mensagemDeletar();//chamando mensagem de concluído
            
        } catch (Exception e) {
            dfvb.mensagemErroDeletar(e.getMessage());//chamando mensagem de erro
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);//desconectando do MySQL
        }  
    } 
}
