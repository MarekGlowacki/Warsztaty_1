package pl.coderslab.Zadanie_3;


import java.util.Scanner;

public class gra_2 {

    static Scanner scanner;
    public static void main(String[] args) {


        scanner = new Scanner(System.in);
        gra2();

        scanner.close();
    }

    static void gra2 () {
        System.out.println("Pomyśl liczbę z zakresu 1-1000, a ja zgadnę ją w max 10 ruchach. ");
        System.out.println("Gdy już wymyślisz, napisz cokolwiek, żebym wiedział, że już masz i zaczynamy!.");

       String odp = scanner.nextLine();



      int min = 0;
      int max = 1000;

      int guess = ((max - min) / 2) + min;

        System.out.println("\nZgaduję: " + guess);
        System.out.println("\nDobrze? Wpisz niżej: \n\"w\" - jeśli Twoja liczba jest większa,\n\"m\" - jeśli Twoja liczba jest mniejsza,\n\"tak\" - jeśli zgadłem:");


        int co = 0;


        while (true) {
            co += 1;
            odp = scanner.nextLine();
            if (odp.equals("w")) {
                min = guess;
                guess = ((max - min) / 2) + min;
                System.out.println(guess);
            } else if (odp.equals("m")) {
                max = guess;
                guess = ((max - min) / 2) + min;
                System.out.println(guess);
            } else if (odp.equals("tak")) {
                System.out.println("No i dobra ;) Nieźle zgaduje co?");
                System.out.println("Dzięki za grę.");
                break;
            } else if (co % 10 == 0){
                guess = ((max - min) / 2) + min;
                System.out.println("Mów prawdę! :) Zaczynamy od nowa: " + guess);
            } else {
                System.out.println("Nic z tych rzeczy");
            }
        }



    }





}
