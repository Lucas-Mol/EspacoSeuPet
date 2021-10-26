/**
 * Classe AnimaisBean
 * Função: Classe do tipo Bean para ligação dos atributos animais com o JSF
 * Método: getAnimais
 * 
 */
package beanclasses;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import models.Animais;

/**
 *
 * @author Lucas Mol
 */
@ManagedBean
@SessionScoped
public class AnimaisBean {
    
    //instânciando Objeto do tipo Animais 
    Animais an = new Animais();
    
    
    /** Método da Classe Bean para linkar os atributos da classe Animais com o JSF
     * 
     * @return Animais
     */
    public Animais getAnimais() {
        return an;
    }

    
    
    
}
