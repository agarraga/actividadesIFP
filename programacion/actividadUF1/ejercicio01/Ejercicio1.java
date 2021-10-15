import java.util.*;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        String userInput;
        Scanner in = new Scanner(System.in);
        System.out.println("Bienido al conversor de notas. " +
                "Introdude un valor numérico y te diremos que nota has sacado, " +
                "o usa \"x\" para salir:");

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
