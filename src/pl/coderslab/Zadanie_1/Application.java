package pl.coderslab.Zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        gra1();

    }

    static void gra1() {
        Random random = new Random();

        int l = random.nextInt(100) + 1;

        System.out.println(" Zabawmy się, ha ha! Ja wymyślam liczbę, a Ty ją zgadujesz, co Ty na to? Podaj jakąś propozycję liczby z zakresu 1-100: ");



        Scanner scan = new Scanner(System.in);
        int ml = 0;
        while (true) {
            while (!scan.hasNextInt()) {
                scan.nextLine();

                System.out.println("Musisz podac liczbe calkowita.");

            }

            ml = scan.nextInt();
            if (ml > 100 || ml < 1) {

                System.out.println("Musisz podac liczbe calkowita z zakresu 1-100.");
            } else {
                if (ml<l) {
                    System.out.println("Za mało!");
                } else if (ml>l) {
                    System.out.println("Za dużo!");
                } else {
                    System.out.println("Doskonale, jesteś zwycięzcą! \nNa początku pomyślałem sobie o liczbie: " + l + "\n\nDzięki za miło spędzony czas. Dobrze się z Tobą bawiłem :)");
                    break;
                }

            }
        }

    }
}
