/**
 * Classe AgendamentoBean
 * Função: Classe do tipo Bean para ligação dos atributos Agendamento e
 * métodos de ControlesAgendamento com JSF
 * Métodos: inserir, listarAgendamento, buscar, selecionar, atualizar, deletar 
 * 
 */
package beanclasses;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Agendamento;
import models.ControlesAgendamento;

/**
 *
 * @author Lucas Mol
 */
@ManagedBean
@SessionScoped
public class AgendamentoBean {
    
    //Instância dos objetos das classes Agendamento e ControlesAgendamentos
    private Agendamento agend = new Agendamento();
    private final ControlesAgendamento cAgend = new ControlesAgendamento();
    
    //varíavel List do tipo Agendamento para trabalhar com preenchimento da Table
    private List<Agendamento> listAgend = new ArrayList<>();
    //varíavel para pegar o texto do 'Buscar' em tempo real
    private String varBusca;

    
    //Getter e Setter
    public Agendamento getAgend() {
        return agend;
    }

    public void setAgend(Agendamento agend) {
        this.agend = agend;
    }

    public List<Agendamento> getListAgend() {
        return listAgend;
    }

    public void setListAgend(List<Agendamento> listAgend) {
        this.listAgend = listAgend;
    }
    
    public String getVarBusca() {
        return varBusca;
    }

    public void setVarBusca(String varBusca) {
        this.varBusca = varBusca;
    }
   
    //-----------------------------------------------------------------------
    //-------------------------------Métodos---------------------------------
    
    /** Método para inserir dados no MySQL na classe Bean
     * 
     */
    public void inserir(){
        cAgend.inserir(agend);//Método para inserir dados no MySQL
        agend = new Agendamento();//limpando agend da memória
    }
    
    /** Método para ler e listar os dados do MySQl na classe Bean
     * 
     */
    public void listarAgendamento(){
        //varíavel List tipo Agendamento recebendo a lista de agendamento
        //do método para ler e listar os dados do MySQl
        listAgend = cAgend.lista(); 
    }
    
    /** Método para buscar pelo nome do animal no MySQl na classe Bean
     * 
     * @param vBusca 
     */
    public void buscar(String vBusca){
        listAgend = cAgend.buscar(vBusca);//Método para buscar pelo nome do animal no MySQl
    }
    
    /** Método para selecionar um agendamento expecífico na lista
     * 
     * @param a 
     */
    public void selecionar(Agendamento a){
        agend = a;//varíavel agend recebe o novo valor do Objeto de Agendamento
    }
    
    /** Método para atualizar os dados no MySQL na classe Bean
     * 
     */
    public void atualizar(){
        cAgend.atualizar(agend);//Método para atualizar os dados no MySQL
        agend = new Agendamento();//limpando agend da memória
    }
    
    /** Método para deletar um agendamento inteiro do MySQL na classe Bean
     * 
     */
    public void deletar(){
        cAgend.deletar(agend);//Método para deletar um agendamento inteiro do MySQL
        agend = new Agendamento();//limpando agend da memória
    }  
}
