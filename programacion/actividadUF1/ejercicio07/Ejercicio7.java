//TODO verificador de input y while.
import java.util.*;

public class Ejercicio7 {

    public static void main(String[] args){

        String userInput; 
        int anchura;
        int altura;
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Bienvenido al dibujador de rectangulos." +
                           "\nIntroduce el ancho seguido de Enter " +
                           "y despues la altura seguido de Enter."+
                           "\nPara calcular un cuadrado introducce " +
                           "un lado y dale a Enter dos veces.");
        userInput = in.next();
        anchura = Integer.parseInt(userInput);
        userInput = in.next();
        if (userInput.isEmpty())
            altura = anchura;
        else
            altura = Integer.parseInt(userInput);
        System.out.println(hacerRectangulo(anchura, altura)); 
    }

    public static String hacerRectangulo(int x, int y) {
        String cuadrado = "";
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++)
                cuadrado.concat("  *");
            cuadrado.concat("\\n");
        }
        return cuadrado;
    }
}
