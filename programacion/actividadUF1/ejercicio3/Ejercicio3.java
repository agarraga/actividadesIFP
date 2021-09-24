import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args){

        System.out.println("Introduce la radio y te diremos el area del circulo, o \"x\" para salir.");

        while(true){

			Scanner in = new Scanner(System.in);

			var userInput = in.next();

            if (userInput.toLowerCase().equals("x")) {
                
                break;

            }
            
            if (!userInput.matches("\\d+\\.\\d+") && !userInput.matches("\\d+")){

                System.out.println("Por favor, introduce un número");

                continue;

            }
	
            double radio = Double.parseDouble(userInput);

            double resultado = Math.pow(radio, 2) * (Math.PI);

            System.out.println("El area de un circulo de radio " + radio + " es " + resultado) ;
            
        }

    }
}
