
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        taulukko = new int[KAPASITEETTI];
        apuKonstruktori();
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        taulukko = new int[kapasiteetti];
        apuKonstruktori();
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        taulukko = new int[kapasiteetti];   
        apuKonstruktori();
        this.kasvatuskoko = kasvatuskoko;
    }
    
    private void apuKonstruktori() {
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        alkioidenLkm = 0;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            taulukko[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % taulukko.length == 0) {
                luoUusiTaulukko();
            }
            return true;
        }
        return false;
    }
    
    private void luoUusiTaulukko() {
        int[] vanhaTaulukko = taulukko;
        kopioiTaulukko(taulukko, vanhaTaulukko);
        taulukko = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(vanhaTaulukko, taulukko);
    }

    public boolean kuuluu(int luku) {
        return loydettyjenLukujenMaara(luku) > 0;
    }
    
    private int loydettyjenLukujenMaara(int luku) {
        int loydetyt = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                loydetyt++;
            }
        }
        return loydetyt;
    }

    public boolean poista(int luku) {
        int luvunIndeksi = haeLuvunIndeksi(luku);
        if (luvunIndeksi != -1) {
            for (int i = luvunIndeksi; i < alkioidenLkm - 1; i++) {
                int tilapainenTaulukko = taulukko[i];
                taulukko[i] = taulukko[i + 1];
                taulukko[i + 1] = tilapainenTaulukko;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    private int haeLuvunIndeksi(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                indeksi = i;
                taulukko[indeksi] = 0;
                return indeksi;
            }
        }
        return indeksi;
    }

    private void kopioiTaulukko(int[] vanhaTaulukko, int[] uusiTaulukko) {
        for (int i = 0; i < vanhaTaulukko.length; i++) {
            uusiTaulukko[i] = vanhaTaulukko[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String merkkijono;
        if (alkioidenLkm == 0) {
            merkkijono = "{}";
        } else if (alkioidenLkm == 1) {
            merkkijono = "{" + taulukko[0] + "}";
        } else {
            merkkijono = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                merkkijono += taulukko[i];
                merkkijono += ", ";
            }
            merkkijono += taulukko[alkioidenLkm - 1];
            merkkijono += "}";
        }
        return merkkijono;
    }

    public int[] toIntArray() {
        int[] uusiTaulukko = new int[alkioidenLkm];
        for (int i = 0; i < uusiTaulukko.length; i++) {
            uusiTaulukko[i] = taulukko[i];
        }
        return uusiTaulukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            uusiTaulukko.lisaa(aTaulukko[i]);
        }
        for (int i = 0; i < bTaulukko.length; i++) {
            uusiTaulukko.lisaa(bTaulukko[i]);
        }
        return uusiTaulukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            for (int j = 0; j < bTaulukko.length; j++) {
                if (aTaulukko[i] == bTaulukko[j]) {
                    uusiTaulukko.lisaa(bTaulukko[j]);
                }
            }
        }
        return uusiTaulukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko uusiTaulukko = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        int[] bTaulukko = b.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            uusiTaulukko.lisaa(aTaulukko[i]);
        }
        for (int i = 0; i < bTaulukko.length; i++) {
            uusiTaulukko.poista(bTaulukko[i]);
        }
        return uusiTaulukko;
    }
        
}
