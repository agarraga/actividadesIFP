import java.util.*;

public class Ejercicio10 {

    public static void main(String[] args){

        String userInput;
        Double altura;
        Scanner in = new Scanner(System.in).useDelimiter("\\n");  

        userInput = in.next();
        altura = Double.parseDouble(userInput);
        System.out.println(calcularAreaCampo(altura));
    }

    public static double calcularAreaCampo(double altura){
        return (Math.PI * (( 5 * Math.pow(altura, 2)) / 4));
        /*
         * Pasando (n/2)^2 + n^2 por wolfram alpha me lo simplifico a 5n^2/4,
         * que me parece un poco más elegante.
         * Tambien me sobran lo parentesis de Math.PI(...), ya que por el orden 
         * de operadores, dividiría antes de multiplicar, pero me parece que 
         * queda más facil de leer con los paréntesis.
         */
   }
}
