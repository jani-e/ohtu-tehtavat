package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            
            if (vastaus.endsWith("a")) {
                Peli kaksinpeli = Peli.luoKaksinpeli();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                Peli yksinpeli = Peli.luoHelppoYksinpeli();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                Peli pahaYksinpeli = Peli.luoVaikeaYksinpeli();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }
}
