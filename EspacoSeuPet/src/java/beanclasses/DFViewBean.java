
package beanclasses;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Lucas Mol
 */
@ManagedBean
@RequestScoped
public class DFViewBean {
    
    public void mensagemAgendar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "AGENDADO", " Agendamento realizado com sucesso.");

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    public void mensagemDeletar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "DELETADO", " Agendamento deletado com sucesso.");

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    public void mensagemEditar() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO", " Agendamento editado com sucesso.");

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    

   
}
