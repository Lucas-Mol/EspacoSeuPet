/**
 * Classe DFViewBean
 * Função: Classe do tipo Bean para comunicação com o usuário chamando os Dialog em PopUp Centrais
 * Métodos: mensagemAgendar, mensagemDeletar, mensagemEditar, mensagemErroAgendar,
 *          mensagemErroDeletar, mensagemErroEditar, mensagemErroConectar
 * 
 */
package beanclasses;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Lucas Mol
 */
@ManagedBean
@RequestScoped
public class DFViewBean {
    
    
    /**
     * Método para chamar mensagem de Agendamento concluído em um Dialog PopUp Lateral
     */
    public void mensagemAgendar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AGENDADO", "Agendamento realizado com sucesso.");
        
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Remoção concluída em um Dialog PopUp Lateral
     */
    public void mensagemDeletar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "DELETADO", " Agendamento deletado com sucesso.");
        
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Edição concluído em um Dialog PopUp Lateral
     */
    public void mensagemEditar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO", " Agendamento editado com sucesso.");
        
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Erro ao Agendar em um Dialog PopUp 
     * @param e
     */
    public void mensagemErroAgendar(String e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", " Falha ao agendar. Erro: "+e);

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Erro ao Deletar em um Dialog PopUp 
     * @param e
     */
    public void mensagemErroDeletar(String e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", " Falha ao deletar. Erro: "+e);

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Erro ao Editar em um Dialog PopUp 
     * @param e
     */
    public void mensagemErroEditar(String e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", " Falha ao editar. Erro: "+e);

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    /**
     * Método para chamar mensagem de Erro ao Conectar em um Dialog PopUp 
     * @param e
     */
    public void mensagemErroConectar(String e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", " Falha ao tentar conectar. Erro: "+e);

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }  
}
