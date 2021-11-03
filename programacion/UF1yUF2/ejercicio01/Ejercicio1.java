import java.util.*;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        String userInput;
        Scanner in = new Scanner(System.in);
        /* 
         * Molaría que todos los mensajes de System.out.print() 
         * estuvieran en un archivo de texto separado 
         * pero despues de mucho intento no consigo hacer funcionar
         * ninguno de los posibles IO buffers
         */
        System.out.println("Bienido al conversor de notas. " +
                "Introdude un valor numérico y te diremos que nota has sacado, " +
                "o usa \"x\" para salir:");
        /*
         * Si entediese más de como funcionan los paquetes de java
         * haría un solo main() para todos los ejercicios con este while() 
         * que aceptase un arg[] que sería un regex a dar por cada ejercicio
         * para verificar el input. Desafordunadamente, 
         * despues de muchos intentos no lo he conseguido hacer funcionar.
         */
        while (true) {
            userInput = in.next();
            if (userInput.toLowerCase().equals("x"))
                break;
            if (!userInput.matches("\\d+")) {
                notValidInput();
                continue;
            }
            int nota = Integer.parseInt(userInput); 
            System.out.println(convertirNota(nota));
        }
    }

    /* Soy muy fan de la programación modular */
    public static String convertirNota(int nota) {
        String mensaje;
        if (nota < 0 || nota > 100) {
            notValidInput();
            return null;
        } else if (nota >= 90) {
            mensaje = "Sobresaliente";
        } else if (nota >= 70) {
            mensaje = "Notable";
        } else if (nota >= 60) {
            mensaje = "Bien";
        } else if (nota >= 50) {
            mensaje = "Suficiente";
        } else {
            mensaje = "Insuficiente";
        }
        return mensaje;
    }

    public static void notValidInput() {
        String notValidInput = "Por favor, introduzca un numero entro 0 y 100.";
        System.out.println(notValidInput);
    }
}
