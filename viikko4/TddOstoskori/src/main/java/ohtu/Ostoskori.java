package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    
    private List<Ostos> ostokset;
    
    public Ostoskori() {
        this.ostokset = new ArrayList<>(); 
    }
 
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   
        int maara = 0;
        for (Ostos ostos : this.ostokset) {
            maara += ostos.lukumaara();
        }
        return maara;
    }
 
    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        int hinta = 0;
        for (Ostos ostos : this.ostokset) {
            hinta += ostos.hinta();
        }
        return hinta;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        for (Ostos ostos : this.ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        this.ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        for (Ostos ostos : this.ostokset) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                ostos.muutaLukumaaraa(-1);
                if (ostos.lukumaara() == 0) {
                    int index = this.ostokset.indexOf(ostos);
                    this.ostokset.remove(index);
                    return;
                }
            }
        }
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return this.ostokset;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
