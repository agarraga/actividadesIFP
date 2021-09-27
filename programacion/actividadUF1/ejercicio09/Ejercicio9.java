import java.util.*;

public class Ejercicio9 {

    public static int contarVocales(String frase){
        int totalVocales = 0;

        // Por aqui van los tiros
        //Set<Character> vocales = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < frase.length(); i++) {
            //TODO tiene que haber una forma mejor de hacer esto, pero no la encuentro.
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' 
                    || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' 
                    || frase.charAt(i) == 'u') {
                totalVocales++;
            }
        }
        return totalVocales;
    }

    public static void main(String[] args) {

        while (true) {
            //TODO Hacer que el mensaje no aparezca imediatamente despues de presentar las vocales
            // Por ejemplo "Su frase tiene 3 vocales. Pulse Enter para continuar."
            System.out.println("\nBienvenido al contador de vocales. Elige una opcion:" +
                    "\n\n1. Ver las vocales en la frase \"La lluvia en Sevilla es una maravilla.\"" +
                    "\n2. Elige tu frase.\nO 'x' para salir.");
            Scanner in = new Scanner(System.in).useDelimiter("\\n");
            var userInput = in.next();

            if (userInput.toLowerCase().equals("x")) {
                break;
            }
            
            if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println("Por favor introduzca una opción valida");
                continue;
            }
            
            if (userInput.equals("1")) {
                System.out.println("\n" + contarVocales("La lluvia en Sevilla es una maravilla.") + " vocales");
                continue;
            }
            
            System.out.println("Introduzca su frase para contar vocales seguido de Enter");
            userInput = in.next();
            System.out.println("\n" + userInput + " contiene " + contarVocales(userInput) + " vocal/es");
        }
    }
}
