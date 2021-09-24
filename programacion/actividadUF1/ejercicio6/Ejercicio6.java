import java.util.*;

public class Ejercicio6 {

    public static void main(String[] args){

        int totalPares = 1;

        Scanner in = new Scanner(System.in);
        String userInput;

        while (true) {

            System.out.println("\nIntroduce un numero y te diremos si es par o impar.\nO pulsa 0 para saber el numero total de pares y salir.");

            userInput = in.next();
            int numero = Integer.parseInt(userInput);

            if (numero == 0){

                System.out.println("\nEl total numero de pares a sido: " + totalPares + " (incluyendo el cero, que tambien es par!).");
                break;

            }

            else if (numero % 2 == 0) {

                System.out.println("Es par!");
                totalPares++;

            }

            else {

                System.out.println("Es impar!");

            } 

        }

    }

}
