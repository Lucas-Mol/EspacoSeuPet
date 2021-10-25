
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
    
    Animais an = new Animais();

    public Animais getAn() {
        return an;
    }

    
    
    
}
