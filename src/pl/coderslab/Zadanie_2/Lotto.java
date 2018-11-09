package pl.coderslab.Zadanie_2;

import java.util.*;

public class Lotto {

    private static int[] userNumbers = new int[6];
    private static int[] drawNumbers = new int[6];

    public static void main(String[] args) {

        System.out.println("Chcesz podać swoje liczby czy mam je wylosować? Naciśnij \"l\" by losować lub \"s\" by podać swoje:");
        Scanner scann = new Scanner(System.in);


        while (true) {
            String wpis = scann.nextLine();
            if (wpis.equals("s")){
                takeUserNumbers();
                drawMachine();
                compare();
            } else if (wpis.equals("l")) {
                drawUserNumbers();
                drawMachine();
                compare();
            } else if (wpis.equals("w")){
                System.out.println("Cześć");
                break;
            } else {
                System.out.println("Wpisane zostało coś innego. Wpisz coś jeszcze raz.");
            }
            System.out.println("Chcesz podać swoje liczby czy mam je wylosować? Naciśnij \"l\" by losować, lub \"s\" by podać swoje, \"w\" kończy zabawę:");


        }

    }

    public static void takeUserNumbers() {

        System.out.println("Podaj swoje liczby z zakresu 1-49: ");


        int place = 0;
        Scanner scan = new Scanner(System.in);


        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                if (place > 5) {
                    place = 0;
                    System.out.println("Zostało podane więcej niż 6 liczb, wczytałem pierwszych 6.");
                    break;
                }
                int num = scan.nextInt();
                boolean repeat = false;

                for (int i=0; i<place+1; i++){
                    if (userNumbers[i] == num){
                        System.out.println(num + " już było. Podaj inną liczbę.");
                        repeat = true;
                    }
                }
                if (!repeat) {
                    if (num > 0 && num < 50) {
                        userNumbers[place] = num;
                        place += 1;
                        System.out.println(num + " dodałem");
                    } else {
                        System.out.println("Liczba " + num + " jest z poza zakresu 1-49.");
                    }
                }
            } else {
                    System.out.println("Podany wpis nie jest liczbą");
                    scan.nextLine();
            }
            if (place == 6) {
                break;
            }
        }
        Arrays.sort(userNumbers);
        System.out.println("Oto Twoje liczby: " + Arrays.toString(userNumbers));

    }

    public static void drawMachine(){

        List<Integer> randomisingMachine = new LinkedList<>();
        for (int i=0; i<49; i++) {
            randomisingMachine.add(i+1);
        }
        int check = 0;

        Collections.shuffle(randomisingMachine);
        for (Integer n : randomisingMachine) {

            if (check < 6) {
                drawNumbers[check] = n;
                ++check;
            } else {
                break;
            }
        }
        Arrays.sort(drawNumbers);
        System.out.println("\nWylosowanie liczby to: " + Arrays.toString(drawNumbers));

    }

    public static void compare(){

        int match =0;

        for (int i=0; i<userNumbers.length; i++){
            for (int j=0; j<userNumbers.length; j++){
                if (userNumbers[i] == drawNumbers[j]) {
                    ++match;
                }
            }
        }
        if (match < 3) {
            System.out.println("Twój wynik to: " + match + ".\nJak widzisz nie zgadzają się conajmniej 3 liczby, więc nie ma żadnej wygranej dla Ciebie. Może innym razem.");
        } else if (match == 3) {
            System.out.println("\nPokryły się " + match + " liczby. Gratulacje, to rzadkość :)");
        } else if (match == 4) {
            System.out.println("\nPokryły się " + match + " liczby. SZOK! Nie możliwe, to bardzo bardzo rzadka sytuacja!");
        } else if (match == 5) {
            System.out.println("\nPokryło się " + match + " liczb. SUUUUPER, istny cud, prawie max! :)");
        } else {
            System.out.println("\nŁAAAAAAAAAAAAAAAAAAAAAŁ!!! MILIONY SĄ TWOJE !!! Pokryło się " + match + " liczb!");
        }

    }

    public static void drawUserNumbers() {
        List<Integer> randomisingMachine = new LinkedList<>();
        for (int i=0; i<49; i++) {
            randomisingMachine.add(i+1);
        }
        int check = 0;

        Collections.shuffle(randomisingMachine);

        for (Integer n : randomisingMachine) {
            if (check < 6) {
                userNumbers[check] = n;
                ++check;
            } else {
                break;
            }
        }

        Arrays.sort(userNumbers);
        System.out.println("\nWylosowanie liczby to: " + Arrays.toString(userNumbers));
    }
}