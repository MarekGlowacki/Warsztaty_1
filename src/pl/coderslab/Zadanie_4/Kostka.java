package pl.coderslab.Zadanie_4;

import java.util.Random;
import java.util.Scanner;

public class Kostka {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        kostka();

    }


    static void kostka() {
        System.out.println("Podaj kod rzutów kośćmi: "); // pokazuje na ekranie co ma wpisać użytkownik

        String kod = scanner.nextLine().trim(); // zbiera dane od użytkownika.

        int pwt = 1; //Powtórzenia rzutu - standardowo na 1, w razie jakby go nie było.

        String rks = ""; //rodzaj kostki string - tu jest jaka to kostka w formie string.

        int mod = 0; //modyfikator, który należy dodać do rzutów kośćmi.


        if (!(kod.charAt(0) == 'D')) {

            pwt = Integer.parseInt(String.valueOf(kod.charAt(0)));

            for (int i = 0; i < kod.length(); i++) {

                rks += String.valueOf(kod.charAt(i + 2));

                try {
                    if ((String.valueOf(kod.charAt(i + 3)).equals("+")) || (String.valueOf(kod.charAt(i + 3)).equals("-"))) {
                        i = kod.length();
                    }
                } catch (IndexOutOfBoundsException e) {
                    i = kod.length();
                }
            }


        } else {
            for (int i = 0; i < kod.length(); i++) {

                rks += String.valueOf(kod.charAt(i + 1));

                try {
                    if ((String.valueOf(kod.charAt(i + 2)).equals("+")) || (String.valueOf(kod.charAt(i + 2)).equals("-"))) {
                        i = kod.length();
                    }
                } catch (IndexOutOfBoundsException e) {
                    i = kod.length();
                }

            }
        }
        int rk = Integer.parseInt(String.valueOf(rks)); // rodzaj kostki int - tu jest już liczba z rodzajem kostki.


        String mo = "";
        for (int i = 0; i < kod.length(); i++) {

            if ((String.valueOf(kod.charAt(i)).equals("+")) || (String.valueOf(kod.charAt(i)).equals("-"))) {
                mo += String.valueOf(kod.substring(i + 1));

            }

        }
        try {
            mod = Integer.parseInt(String.valueOf(mo));
        } catch (NumberFormatException ne) {
            mod = 0;
        }

        Random r = new Random();

        int liczba = 0;

        for (int i=0; i<pwt; i++) {

            if (kod.contains("+")) {
                liczba += r.nextInt(rk) + mod + 1;
            } else {
                liczba += r.nextInt(rk) - mod + 1;
            }
        }

        System.out.println(liczba);



    }
}
