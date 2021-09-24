import java.util.*;

public class Ejercicio2 {

    public static void main(String[] args) {

		System.out.println("Bienido al conversor de notas. Introdude un valor numérico y te diremos que nota has sacado, o usa \"x\" para salir:");

        while (true) {

            Scanner in = new Scanner(System.in);

            var userInput = in.next();

            if (userInput.toLowerCase().equals("x")){

                break;


            }

            String resultado = "";
            
            switch (userInput.toLowerCase()) {

                case "insuficiente": resultado = "menor a 50.";
                                     break;

                case "suficiente": resultado = "de 50 a 69.";
                                   break;

                case "bien": resultado = "de 60 a 79.";
                             break;

                case "notable": resultado = "de 70 a 89.";
                                break;

                case "sobresaliente": resultado = "de 90 a 100.";
                                      break;

                default: System.out.println("Por favor, introduzca una nota valida (insuficiente, suficiente, bien, notable o sobresaliente)");
                                 break;
                                
            }
		
            //TODO Esto se dispara con el default, no tendría que.	
            System.out.println("Su puntuacion es de " + resultado);

        }
    }

}
