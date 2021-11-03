import java.util.*;

public class Ejercicio5 {

    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        String numero = in.nextInt();
        for (int i = 1; i <= 10 ; i++)
            System.out.println(numero + " x " + i + " = " + i*numero);
    }
}
