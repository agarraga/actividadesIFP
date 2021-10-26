import java.util.*;

public class Ejercicio9 {

    public static void main(String[] args) {

        String userInput;
        Scanner in = new Scanner(System.in).useDelimiter("\\n");

        while (true) {
        /*
         * TODO Hacer que el mensaje de bienvenida no aparezca imediatamente 
         * despues de presentar las vocales.
         * Por ejemplo "Su frase tiene 3 vocales. Pulse Enter para continuar."
         *  --------------
         * Despues de muchos intentos no consigo implementar la idea del TODO.
         * ej. Un try catch y un next() seguido de un if (userInput.empty())
         * pero he tenido muchos problemas con next() dentro del try
         * y con mas de un Scanner(System.in)
         */
            System.out.println("\nBienvenido al contador de vocales. Elige una opcion:" +
                    "\n\n1. Ver las vocales en la frase " +
                    "\"La lluvia en Sevilla es una maravilla.\"" +
                    "\n2. Elige tu frase.\nO 'x' para salir.");
            userInput = in.next();
            if (userInput.toLowerCase().equals("x"))
                break;
            if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println("Por favor introduzca una opción valida");
                continue;
            }
            if (userInput.equals("1")) {
                System.out.println("\n" + contarVocales("La lluvia en Sevilla " +
                                   "es una maravilla.") + " vocales");
                continue;
            }
            /*
             * Todo el codigo que sigue este comentario técnicamente tendría
             * que estar en un else if(userInput.equals("2"){...}. 
             * Como no lo necesito dejo que vaya directamente si ninguno
             * de los ifs ha saltado. No se si esto es un smell 
             * o si poner un if{} o un else{} inecesario sería un smell.
             */
            System.out.println("Introduzca su frase para contar " +
                               "vocales seguido de Enter");
            userInput = in.next();
            System.out.println("\n" + userInput + " contiene " + 
                               contarVocales(userInput) + " vocal/es");
        }
    }

    public static int contarVocales(String frase){
        int totalVocales = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' 
                    || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' 
                    || frase.charAt(i) == 'u') {
            /* Tiene que haber una forma mejor de hacer esto, pero no la encuentro.*/
                totalVocales++;
            }
        }
        return totalVocales;
    }
}
