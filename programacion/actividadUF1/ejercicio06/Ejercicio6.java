import java.util.*;

public class Ejercicio6 {

    public static void main(String[] args){

        int totalPares = 1;
        String userInput;

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\nIntroduce un numero y te diremos si es par o impar." +
                               "\nO pulsa 0 para saber el numero total de pares y salir.");
            userInput = in.next();
            if (!userInput.matches("^-*\\d+$")) { /* TODO Asegurarse que userInput solo pueda ser un numero y no varios */
             /*
             * Estoy intentando hacerlo con try catch o con hasNextInt()
             * pero no lo consigo por ahora :(
             * Más que nada por variar que siempre utilizo el if userInput.matches(regex)
             */
                System.out.println("El valor introducido no es válido. " +
                        "Por favor, introduzca un numero entero.");
                continue;
            }

            int numero = Integer.parseInt(userInput);

            if (numero == 0) {
                System.out.println("\nEl total numero de pares a sido: " + totalPares +
                                   " (incluyendo el cero, que tambien es par!).");
                break;
            } else if (numero % 2 == 0) {
                System.out.println("Es par!");
                totalPares++;
            } else {
                System.out.println("Es impar!");
            }
        }
    }
}
