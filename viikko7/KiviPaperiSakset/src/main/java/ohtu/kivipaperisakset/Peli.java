package ohtu.kivipaperisakset;

public class Peli {
    private KiviPaperiSakset KPS;

    public static Peli luoKaksinpeli() {
        return new Peli(new KPSPelaajaVsPelaaja());
    }

    public static Peli luoHelppoYksinpeli() {
        return new Peli(new KPSTekoaly());
    }

    public static Peli luoVaikeaYksinpeli() {
        return new Peli(new KPSParempiTekoaly());
    }

    protected Peli(KiviPaperiSakset KPS) {
        this.KPS = KPS;
    }

    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        this.KPS.pelaa();
    }

}
