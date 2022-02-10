package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    
    private int tavaroita;
    private int hinta;
    private List<Ostos> ostokset;
    
    public Ostoskori() {
        this.tavaroita = 0;
        this.hinta = 0;
        this.ostokset = new ArrayList<>(); 
    }
 
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   

        return this.tavaroita;
    }
 
    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
 
        return this.hinta;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        this.tavaroita++;
        this.hinta += lisattava.getHinta();
        for (Ostos ostos : this.ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        this.ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return this.ostokset;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
