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
public abstract class Komento {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Sovelluslogiikka sovellus;
    protected Button undo;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Sovelluslogiikka sovellus, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.sovellus = sovellus;
        this.undo = undo;
    }

    public int haeSyotekentanArvo() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }

    public void asetaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        if (tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    public abstract void suorita();
    
    public abstract void peru();
}
