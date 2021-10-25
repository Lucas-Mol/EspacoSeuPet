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
    
    private Agendamento agend = new Agendamento();
    
    private final ControlesAgendamento cAgend = new ControlesAgendamento();
    
    private List<Agendamento> listAgend = new ArrayList<>();
    
    private String varBusca;

   
    public void limparVarAgend(){
        agend = new Agendamento();
    }
    
    public void inserir(){
        cAgend.inserir(agend);
        agend = new Agendamento();
    }
    
    public void listarAgendamento(){
        listAgend = cAgend.lista();
    }
    
    public void buscar(String a){
        listAgend = cAgend.buscar(a);
    }
    
    public void selecionar(Agendamento a){
        agend = a;
    }
    
    public void atualizar(){
        cAgend.atualizar(agend);
        agend = new Agendamento();
    }
    
    public void deletar(){
        cAgend.deletar(agend);
        agend = new Agendamento();
    }

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
    

    
}
