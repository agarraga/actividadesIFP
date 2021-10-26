/*
 * Incluyo esta versión del ejercicio sobre todo para los compis y tener
 * algo por si no funciona la versión normal, ya que creo que es el ejercicio
 * con más lineas y más complicado en su lógica que presento en esta actividad
 */
import java.util.*;

public class Ejercicio4simple {

    public static void main(String[] args) {
        System.out.println("Los numeros entre 1 y 100 divisibles entre 2 y 3 son:"); 
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i % 3 == 0)
                System.out.print(i + " ");
        }
    }
}
