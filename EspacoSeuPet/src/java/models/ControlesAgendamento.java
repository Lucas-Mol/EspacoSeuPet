/*
 * Classe ControlesAgendamento
 * Função: Classe designada para gerenciamento das ações com o MySQL, 
 * com métodos de inserir, lista, buscar, atualizar e deletar.
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
    
    //Declaração da variável usada para Conexão
    private Connection connection;

    //Getter e Setter
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    //método para inserir dados no MySQL
    public void inserir(Agendamento agend){
        
        //String em SQL para inserir dados na tabela "tb_agendamento" em todas os atributos. 
        //OBS: usado STR_TO_DATE para transformar a String de "dataAgendamento" em tipo Date,
        //apontando os devidos lugares de dia, mês, ano, hora e minuto
        String sql = "INSERT INTO tb_agendamento (dataAgendamento, nomeAnimal, tipoAnimal, nomeDono, telefone, observacoes) VALUES (STR_TO_DATE(?,'%d/%m/%Y %H:%i'), ?, ?, ?, ?, ?)";
        
        Connection conn = ConnectionDataBase.conectar(); //iniciando conexão
        PreparedStatement stmt = null;//iniciando a variável do PreparedStatement
        
        try {
            
            //variável do PreparedStatement capturando a String de SQL
            //e atribuindo os valores da variável tipo Agendamento
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, agend.getDataAgendamento());
            stmt.setString(2, agend.getNomeAnimal());
            stmt.setString(3, agend.getTipoAnimal());
            stmt.setString(4, agend.getNomeDono());
            stmt.setString(5, agend.getTelefone());
            stmt.setString(6, agend.getObservacoes());
            
            stmt.execute();//execução da query no MySQL
            DFViewBean dfvb = new DFViewBean();//declaração do objeto da Classe DFViewBean, responsável por mostrar blocos de mensagens utilizando o framework do PrimeFaces
            dfvb.mensagemAgendar();//utilização do método de chamar um bloco de mensagem de Agendamento concluído
            
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco de dados. Erro: "+ e);
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);//utilização do método de desconectar com o MySQL
        }
    }
    
    //método para listar e retorna os dados do MySQL
    public List<Agendamento> lista(){
        
        String sql = "SELECT * FROM tb_agendamento";
        
        List<Agendamento> retorno = new ArrayList<>();
        Connection conn = ConnectionDataBase.conectar();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                Agendamento agend = new Agendamento();
                agend.setId_tb_agendamento(resultado.getInt("id_tb_agendamento"));
                agend.setDataAgendamento(agend.getDataAgendamentoFormatada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setDataAgendamentoStringOrdenada(agend.getDataAgendamentoDFormatOrdenada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setNomeAnimal(resultado.getString("nomeAnimal"));
                agend.setTipoAnimal(resultado.getString("tipoAnimal"));
                agend.setNomeDono(resultado.getString("nomeDono"));
                agend.setTelefone(resultado.getString("telefone"));
                agend.setObservacoes(resultado.getString("observacoes"));
                
                retorno.add(agend);
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            ConnectionDataBase.desconectar(conn, stmt);
        }
        return retorno;
        
    }
    
    public List<Agendamento> buscar(String a){
        
        String sql = "SELECT * FROM tb_agendamento WHERE nomeAnimal LIKE ?";
        
        List<Agendamento> retorno = new ArrayList<>();
        Connection conn = ConnectionDataBase.conectar();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, a+"%");
            ResultSet resultado = stmt.executeQuery();

            
            while(resultado.next()){
                Agendamento agend = new Agendamento();
                agend.setId_tb_agendamento(resultado.getInt("id_tb_agendamento"));
                agend.setDataAgendamento(agend.getDataAgendamentoFormatada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setDataAgendamentoStringOrdenada(agend.getDataAgendamentoDFormatOrdenada().format(resultado.getTimestamp("dataAgendamento")));
                agend.setNomeAnimal(resultado.getString("nomeAnimal"));
                agend.setTipoAnimal(resultado.getString("tipoAnimal"));
                agend.setNomeDono(resultado.getString("nomeDono"));
                agend.setTelefone(resultado.getString("telefone"));
                agend.setObservacoes(resultado.getString("observacoes"));
                
                retorno.add(agend);
                System.out.println(agend.getNomeAnimal()+" "+agend.getNomeDono());
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            ConnectionDataBase.desconectar(conn, stmt);
        }
        return retorno;
        
    }
    
    public void atualizar(Agendamento agend){
        String sql = "UPDATE tb_agendamento SET dataAgendamento = STR_TO_DATE(?,'%d/%m/%Y %H:%i'), nomeAnimal = ?, tipoAnimal = ?, nomeDono = ?, telefone = ?, observacoes = ? WHERE id_tb_agendamento = ?";
        Connection conn = ConnectionDataBase.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, agend.getDataAgendamento());
            stmt.setString(2, agend.getNomeAnimal());
            stmt.setString(3, agend.getTipoAnimal());
            stmt.setString(4, agend.getNomeDono());
            stmt.setString(5, agend.getTelefone());
            stmt.setString(6, agend.getObservacoes());
            stmt.setInt(7, agend.getId_tb_agendamento());
            
            stmt.executeUpdate();
            DFViewBean dfvb = new DFViewBean();
            dfvb.mensagemEditar();
            
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar, veja:"+ e.getMessage());
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);
        }
    }
    
    public void deletar(Agendamento agend){
        String sql = "DELETE FROM tb_agendamento WHERE id_tb_agendamento = ?";
        Connection conn = ConnectionDataBase.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, agend.getId_tb_agendamento());
            
            stmt.execute();
            DFViewBean dfvb = new DFViewBean();
            dfvb.mensagemDeletar();
            
        } catch (Exception e) {
            System.out.println("Não foi possível deletar, veja:"+ e.getMessage());
        }
        finally{
            ConnectionDataBase.desconectar(conn, stmt);
        }
        
    }
    
}
