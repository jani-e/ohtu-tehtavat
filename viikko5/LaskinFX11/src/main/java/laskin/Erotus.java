/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Jani
 */
public class Erotus extends Komento {
    private int edellinen;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Sovelluslogiikka sovellus, Button undo) {
        super(tuloskentta, syotekentta, nollaa, sovellus, undo);
    }

    @Override
    public void suorita() {
        this.edellinen = Integer.parseInt(tuloskentta.getText());
        sovellus.miinus(super.haeSyotekentanArvo());
        super.asetaTulos(sovellus.tulos());
    }
    
    @Override
    public void peru() {
        System.out.println("undo pressed");
        sovellus.nollaa();
        sovellus.plus(this.edellinen);
        super.asetaTulos(this.edellinen);
    }

}
