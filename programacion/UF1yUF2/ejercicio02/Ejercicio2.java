import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        String userInput;
        Scanner in = new Scanner(System.in);
        /*
         * Intento que cada linea no sea >= 80 y sin utilizar lectura de 
         * archivos externos este es el metodo para multiline strings más
         * legible que he encotrado.
         */
        System.out.println("Bienido al conversor a la inversa de notas." +
                           "Introdude una nota y te diremos el rango de " +
                           "la puntuación numerica que hayas sacado," +
                           "o usa \"x\" para salir:");

        while (true) {
            userInput = in.next();
            if (userInput.toLowerCase().equals("x"))
                break;
            System.out.println(convertirNotaNumerica(userInput));
        }
    }

    public static String convertirNotaNumerica(String nota) {
        String mensaje;
        switch (nota.toLowerCase()) {
            case "insuficiente": 
                mensaje = "Su puntuación es menor a 50.";
                break;
            case "suficiente": 
                mensaje = "Su puntuación es de 50 a 69.";
                break;
            case "bien": 
                mensaje = "Su puntuación es de 60 a 79.";
                break;
            case "notable": 
                mensaje = "Su puntuación es de 70 a 89.";
                break;
            case "sobresaliente": 
                mensaje = "Su puntuación es de 90 a 100.";
                break;
            default: 
                mensaje = ("Por favor, introduzca una nota válida " +
                           "(insuficiente, suficiente, bien, " +
                           "notable o sobresaliente)");
                break;
        }
        return mensaje;
    }
}
