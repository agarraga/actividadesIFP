//TODO verificador de input y while.
import java.util.*;

public class Ejercicio7 {

    public static void main(String[] args){

        System.out.println("Bienvenido al dibujador de rectangulos." +
                           "\nIntroduce el ancho seguido de Enter y despues la altura seguido de Enter."+
                           "\nPara calcular un cuadrado introducce un lado y dale a Enter dos veces.");
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        String userInput = in.next();
        int anchura = Integer.parseInt(userInput);
        userInput = in.next();
        int altura;
        
        if (userInput.isEmpty()) {
            altura = anchura;
        }
        else {
            altura = Integer.parseInt(userInput);
        }

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                System.out.print("  *");
            }
            
            System.out.println();
        }
    }
}
