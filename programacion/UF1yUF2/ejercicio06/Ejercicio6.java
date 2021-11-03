import java.util.*;

public class Ejercicio6 {

    public static void main(String[] args){

        int totalPares = 1;
        String userInput;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\nIntroduce un numero y te diremos " +
                               "si es par o impar." +
                               "\nO pulsa 0 para saber el numero " +
                               "total de pares y salir.");
            userInput = in.next();
            if (!userInput.matches("^-*\\d+$")) {
                System.out.println("El valor introducido no es válido. " +
                        "Por favor, introduzca un numero entero.");
                continue;
            }

            int numero = Integer.parseInt(userInput);
            if (numero == 0) {
                System.out.println("\nEl total numero de pares a sido: " + totalPares +
                                   " (incluyendo el cero, que tambien es par!).");
                break;
            }
            if (esPar(numero))
                totalPares++;
            imprimirEsPar(numero);
        }
    }
    /*
     * Como mencioné en el ejercicio 4, aunque sea un método muy corto,
     * si creo que se va a llamar más de una vez, hago método,
     * y me aseguro que solo haga UNA tarea
     */
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    public static void imprimirEsPar(int n) {
        if (esPar(n))
            System.out.println("Es par!");
        else
            System.out.println("Es impar!");
    }
}
