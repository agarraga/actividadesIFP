import java.util.*;

public class Ejercicio10 {

    public static double calculcadorAreaCampo(double altura){

        return (Math.PI * Math.pow((altura/2), 2) + (altura * altura));

    }

    public static void main(String[] args){

        //TODO verificador, while
        Scanner in = new Scanner(System.in).useDelimiter("\\n");  
        String userInput = in.next();
        Double altura = Double.parseDouble(userInput);
        System.out.println(calculcadorAreaCampo(altura));

    }

}
