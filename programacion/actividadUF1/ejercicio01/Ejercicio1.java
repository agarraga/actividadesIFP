import java.util.*;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		System.out.println("Bienido al conversor de notas. Introdude un valor numérico y te diremos que nota has sacado, o usa \"x\" para salir:");

		while (true) {

			Scanner in = new Scanner(System.in);

			var userInput = in.next();
			var notValidInput = "Por favor, introduzca un numero entro 0 y 100.";

            if (userInput.toLowerCase().equals("x")){

				break;

			}

			if (!userInput.matches("\\d+")) {

				System.out.println(notValidInput);
				continue;

			}

			int nota = Integer.parseInt(userInput);	
			
			if (nota < 0 || nota > 100) {

				System.out.println(notValidInput);

			}

			else if (nota >= 90){
				
				System.out.println("Sobresaliente");

			}

			else if (nota >= 70){

				System.out.println("Notable");

			}

			else if (nota >= 60){

				System.out.println("Bien");

			}

			else if (nota >= 50){

				System.out.println("Suficiente");

			}

			else {

				System.out.println("Insuficiente");

			}

		}			

	}

}
