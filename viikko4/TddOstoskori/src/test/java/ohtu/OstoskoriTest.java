package ohtu;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
    }
    
    //step 2
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        assertEquals(1, kori.tavaroitaKorissa());
    }
    
    //step 3
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorinHintaOnSamaKuinTuotteen() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        assertEquals(3, kori.hinta());
    }
    
    //step 4
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaOnKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        Tuote murot = new Tuote("murot", 7);
        kori.lisaaTuote(murot);
        assertEquals(2, kori.tavaroitaKorissa());
    }
    
    //step 5
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorinSummaOnSamanVerran() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        Tuote murot = new Tuote("murot", 7);
        kori.lisaaTuote(murot);
        assertEquals(10, kori.hinta());
    }
    
    //step 6
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaOnKaksiTavaraa() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(2, kori.tavaroitaKorissa());
    }
    
    //step 7
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorinHintaSamaKuinKaksiKertaaTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(6, kori.hinta());
    }
    
    //step 8
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        Tuote tuote1 = new Tuote("tuote1", 5);
        kori.lisaaTuote(tuote1);
 
        List<Ostos> ostokset = kori.ostokset();
 
        // testaa ett‰ metodin palauttamin listan pituus 1
        assertEquals(1, kori.ostokset().size());
    }
    
    //step 9
    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
 
        Ostos ostos = kori.ostokset().get(0);
        // testaa t‰‰ll‰, ett‰ palautetun listan ensimm‰inen ostos on halutunkaltainen.
        assertEquals(1, kori.ostokset().size());
        assertEquals("maito", kori.ostokset().get(0).tuotteenNimi());
    }
    
    //step 10
    @Test
    public void kahdenEriTuottenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        Tuote murot = new Tuote("murot", 7);
        kori.lisaaTuote(murot);
        assertEquals(2, kori.ostokset().size());
    }
    
    //step 11
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenOstoskorissaYksiOstos() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(1, kori.ostokset().size());
    }
}
