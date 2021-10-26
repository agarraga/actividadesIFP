import java.util.*;

public class Ejercicio4 {

    static int[] calcularNumerosDivisibles(int min, int max, int[] numeros) {
        SortedSet<Integer> numerosDivisibles = new TreeSet<Integer>();
        /*
         * Utilizo un SortedSet<> para asegurarme de que
         * los valores sean únicos y esten ordenados automáticamente.
         */
        int cantidadDeNumeros = numeros.length;
        int contador;
        for (int i = min; i <= max; i++) {
        /* 
         * Este for loop itera numeros[] para ver si % número = 0,
         * si todos los son -> contador = 0 y añade el resultado al SortedSet<>
         */
            contador = cantidadDeNumeros;
            for (int j = 0; j < cantidadDeNumeros; j++) {
                if (i % numeros[j] == 0)
                    contador--;
            }
            if (contador == 0) 
                numerosDivisibles.add(i);
        }
        return numerosDivisibles.stream().mapToInt(Integer::intValue).toArray();
        /*
         * Convierto el SortedSet<> a int[] ya que no voy a necesitar
         * que la lista sea mutable. Instintivamente me parece que es
         * mejor devolver un Array mas simple.
         */
    }
    static void imprimirNumerosDivisibles(int min, int max, int[] numeros) {
    /*
     * Aunque nunca utilizo calcularNumerosDivisibles() en main()
     * y podría meter esa función en esta, sigo la filosofía que me 
     * recomendo un amigo programador la cual dice que una función
     * hace UNA y solo UNA cosa. Parece también que es más apta a la
     * programación modular.
     */
        String numerosADividirString = Arrays.toString(numeros);
        System.out.println("Los numeros entre " + min + " y " + max +
                " divisible entre \n" + numerosADividirString + " son:");
        int[] numerosDivisibles = calcularNumerosDivisibles(min, max, numeros);
        for (int numero : numerosDivisibles)
            System.out.print(numero + " ");
    }
    static int[] convertirStringEnIntArray(String str) {
    /* Esta función convierte userInput a int[] para numeros[] */ 
        String[] strArr = str.split(" ");
        int size = strArr.length;
        int[] intArr = new int [size];
        /* 
         * Tengo algo de experincia con python
         * y hecho mucho de menos los comprehensive lists XD
         * que podrían hacer esta función entera en una línea
         * return [int(numero) for numero in str.split()]
         * Aunque seguramente hay una forma más corta de hacer esto
         * en Java con alguna librería que desconzco
         */
        for (int i = 0; i < size; i++)
            intArr[i] = Integer.parseInt(strArr[i]);
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
            if (userInput.toLowerCase().equals("x"))
                break;
            if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println(notValidInput);
                continue;
            }
            if (userInput.equals("1")) {
            /* Este if sería el ejercicio en su forma mas simple */
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
            /* 
             * El regex que busca que no se input un 0 no funciona :( 
             * Si funcionase no dejaría que el usuario introduzca un 0
             * en numeros[], para no dividir entre cero. Intenté hacerlo con
             * un try catch ya que dividir entre zero es su propio error en java.
             * Pero se queda un poco desordenado y si esto funcionase 
             * quedaría el codigo más bonito.
             */
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
