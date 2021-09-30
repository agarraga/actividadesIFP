import java.util.*;

public class Ejercicio4simple {

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

    public static void main(String[] args) {
        
        imprimirNumerosDivisbles(1, 100, 2);
        imprimirNumerosDivisbles(1, 100, 3);
    }
}
