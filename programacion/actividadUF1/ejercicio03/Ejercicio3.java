import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args){

        String userInput;
        Scanner in = new Scanner(System.in);

        System.out.println("Introduce la radio y te diremos el area del circulo, o \"x\" para salir.");

        while(true){

			userInput = in.next();

            if (userInput.toLowerCase().equals("x")) {
                break;
            }
		
            //TODO Hay un regex que no necesite &&, también que se pueda escribir ej. .3 .6559 etc, sin el 0 delante.
            if (!userInput.matches("\\d+\\.\\d+") && !userInput.matches("\\d+")){
                System.out.println("Por favor, introduce un número");
                continue;
            }
	
            //TODO Corto, pero puede ser un metodo
            double radio = Double.parseDouble(userInput);
            double resultado = Math.pow(radio, 2) * (Math.PI);

            System.out.println("El area de un circulo de radio " + radio + " es " + resultado) ;
        }
    }
}
