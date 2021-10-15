import java.util.*;

public class Ejercicio10 {

    public static void main(String[] args){

        //TODO verificador, while
        String userInput;
        Double altura;
        Scanner in = new Scanner(System.in).useDelimiter("\\n");  

        userInput = in.next();
        altura = Double.parseDouble(userInput);
        System.out.println(calcularAreaCampo(altura));
    }

    public static double calcularAreaCampo(double altura){
        return (Math.PI * Math.pow((altura/2), 2) + (altura * altura));
    }
}
