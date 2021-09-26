import java.util.*;

public class Ejercicio4simple {

    public static void main(String[] args) {

        System.out.print("Los numeros divisibles entre dos son: ");

        for (int i = 1; i <=100; i++){

            if (i % 2 == 0){
            
                System.out.print(i + " ");

            }

        }

        System.out.println();

        System.out.print("Los numeros divisibles entre tres son: ");

        for (int i = 1; i <=100; i++){

            if (i % 3 == 0){
            
                System.out.print(i + " ");


            }

        }

    }

}
