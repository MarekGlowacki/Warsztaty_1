package pl.coderslab.Zadanie_2;

import java.util.Arrays;
import java.util.Collections;

public class Application2 {


    public static void main(String[] args) {



    }

    static void lotto() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        Collections.shuffle(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));


    }


}
