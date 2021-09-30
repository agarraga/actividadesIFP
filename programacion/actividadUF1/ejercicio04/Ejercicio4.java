import java.util.*;

public class Ejercicio4 {

    public static Integer[] calcularNumerosDivisibles(int min, int max, int numero) {
        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = min; i <= max; i++) {
            if (i % numero == 0){
                numeros.add(i);
            }
        }
        Integer[] output = new Integer[numeros.size()];
        return numeros.toArray(output);
    }

    public static void imprimirNumerosDivisbles(int min, int max, int numero) {
        System.out.println("Los numeros divisibles entre " + numero + " son:");
        Integer[] numeros = calcularNumerosDivisibles(min, max, numero);
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] convertirStringEnIntArray(String str) {
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
                imprimirNumerosDivisbles(1, 100, 2);
                imprimirNumerosDivisbles(1, 100, 3);
                continue;
            }
            
            System.out.println("Primero, elige el rango que quieres testear, " +
                    "separando el mininimo y el maximo entre un espacio. " +
                    "Por ejenmplo \"1 100\"");
            userInput = in.next();
            
            if (!userInput.matches("^-*\\d+\\s-*\\d+$")) {
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
            for (int numero : numeros) {
                imprimirNumerosDivisbles(min, max, numero);
            }
        }
    }
}
