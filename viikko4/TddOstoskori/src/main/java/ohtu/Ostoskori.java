package ohtu;

import java.util.List;

public class Ostoskori {
    
    private int tavaroita;
    private Ostos ostos;
    
    public Ostoskori() {
        this.tavaroita = 0;
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
 
        return 0;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        this.ostos = new Ostos(lisattava);
        this.tavaroita++;
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
