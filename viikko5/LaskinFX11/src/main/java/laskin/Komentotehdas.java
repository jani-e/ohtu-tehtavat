/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Jani
 */
public class Komentotehdas {
    private Sovelluslogiikka sovellus;
    private Map<Button, Komento> komennot;
    
    public Komentotehdas(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Summa(tuloskentta, syotekentta, nollaa, sovellus, undo));
        this.komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, sovellus, undo));
        this.komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, sovellus, undo));
    }
    
    public Komento hae(Button button) {
        return this.komennot.get(button);
    }
}
