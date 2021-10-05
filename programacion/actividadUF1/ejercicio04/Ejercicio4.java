import java.util.*;

public class Ejercicio4 {

    static int[] calcularNumerosDivisibles(int min, int max, int[] numeros) {
        SortedSet<Integer> numerosDivisibles = new TreeSet<Integer>();
        int cantidadDeNumeros = numeros.length;
        int contador;
        for (int i = min; i <= max; i++) {
            contador = cantidadDeNumeros;
            for (int j = 0; j < cantidadDeNumeros; j++) {
                if (i % numeros[j] == 0) {
                    contador--;
                }
            }
            if (contador == 0) {
                numerosDivisibles.add(i);
            }
        }
        return numerosDivisibles.stream().mapToInt(Integer::intValue).toArray();
    }

    static void imprimirNumerosDivisibles(int min, int max, int[] numeros) {
        String numerosADividirString = Arrays.toString(numeros);
        /* TODO Mejorar presentación de numeros. Ej Entre 2 y 3, o Entre 2, 5, y 4 */
        System.out.println("Los numeros entre " + min + " y " + max +
                " divisible entre \n" + numerosADividirString + " son:");
        int[] numerosDivisibles = calcularNumerosDivisibles(min, max, numeros);
        for (int numero : numerosDivisibles) {
            System.out.print(numero + " ");
        }
    }
 
    static int[] convertirStringEnIntArray(String str) {
        String[] strArr = str.split(" ");
        int size = strArr.length;
        int[] intArr = new int [size];
        for (int i = 0; i < size; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr);
        return intArr;
    }
 
    public static void main(String[] args) {
        
        String userInput;
        String notValidInput = "\n¡No es una entrada valida! " +
                "Por favor, lea las instrucciones detalladamente.\n";
        Scanner in = new Scanner(System.in).useDelimiter("\\n");

        while (true) {
            System.out.println("\nBienvenido al calculador de divsibilidad. " +
                    " Elige una opcion: \n\n" +
                    "1. Ver los numeros del 1 al 100 divisibles entre 2 y 3." +
                    "\n2. Elige tus numeros.\nO 'x' para salir.");
            userInput = in.next();

            if (userInput.toLowerCase().equals("x")) {
                break;
            }
            
            if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println(notValidInput);
                continue;
            }
            
            if (userInput.equals("1")) {
                int[] numeros = {2, 3};
                imprimirNumerosDivisibles(1, 100, numeros);
                continue;
            }
            
            System.out.println("Primero, elige el rango que quieres testear, " +
                    "separando el mininimo y el maximo entre un espacio. " +
                    "Por ejenmplo \"1 100\"");
            userInput = in.next();
            
            if (!userInput.matches("^\\d+\\s\\d+$")) {
                System.out.println(notValidInput);
                continue;
            }
            
            int[] minMax = convertirStringEnIntArray(userInput);
            int min = minMax[0];
            int max = minMax[1];

            System.out.println("Ahora elige los numeros por los que quieres " +
                    "dividir el rango, separados por un espacio. " +
                    "Por ejemplo \"2 3 7\".");
            userInput = in.next();
            
            /* TODO el regex que busca que no se input un 0 no funciona :( */
            if (!userInput.matches("^(\\d+\\s)*\\d+$")
                    || (userInput.matches("^0+\\s*|\\s0+\\s|\\s0+$"))) {
                System.out.println(notValidInput);
                continue;
            }
            int[] numeros = convertirStringEnIntArray(userInput);
            imprimirNumerosDivisibles(min, max, numeros);
        }
    }
}
