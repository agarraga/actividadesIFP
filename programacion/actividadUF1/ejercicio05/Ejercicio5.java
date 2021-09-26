// TODO verificador de input, x pa salir etc ...
import java.util.*;

public class Ejercicio5 {

    public static void main(String[] args){

        
        Scanner in = new Scanner(System.in);
        String userInput = in.next();

        int numero = Integer.parseInt(userInput);

        for (int i = 1; i <= 10 ; i++){

            System.out.println(numero + " x " + i + " = " + i*numero);

        }

    }

}
