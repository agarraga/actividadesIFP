import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args){

        String userInput;
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce la radio y te diremos " +
                           "el area del circulo, o \"x\" para salir.");

        while(true){
            userInput = in.next();
            if (userInput.toLowerCase().equals("x"))
                break;
            if (!userInput.matches("^\\d*\\.*\\d+$")) {
                System.out.println("Por favor, introduce un número");
                continue;
            }
            double radio = Double.parseDouble(userInput);
            double area = calacularAreaCirculo(radio);
            System.out.println("El area de un circulo de radio " + 
                               radio + " es " + area) ;
        }
    }

    public static Double calacularAreaCirculo(Double radio){
        return Math.pow(radio, 2) * Math.PI;
    }
}
