/*
 * Classe Animais
 * Função: classe designada para a criação dos tipos de Animais
 */
package models;

/**
 *
 * @author Lucas Mol
 */
public class Animais {
    
    //Declaração da Array do tipo String para ser usado no menu de seleção
    private final String[] arrayTipoAnimal = new String[]{" ","Cachorro","Gato","Coelho","Hamster","Pássaros","Cavalo", "Cobra"};
    
    //Getter
    public String[] getArrayTipoAnimal() {
        return arrayTipoAnimal;
    }
     
}
