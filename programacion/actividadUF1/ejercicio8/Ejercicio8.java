import java.util.*;

public class Ejercicio8 {

    public static void inversor(List<String> listaAInvertir){

        if (listaAInvertir.size() <= 1 || listaAInvertir == null){

            return;

        }

        String elemento = listaAInvertir.remove(0);

        inversor(listaAInvertir);

        listaAInvertir.add(elemento);

    }

    //TODO verificador, while, a lo mejor que se introduzcan 5 nums separados por espacios de una.
    public static void main(String[] args){

        System.out.println("Introduzca 5 numeros, cada uno seguido de Enter y se los invertiremos");

        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        String userInput; 

        List<String> listaAInvertir = new ArrayList<String>();

        for (int i = 0; i < 5; i++){
            
            userInput = in.next();
            listaAInvertir.add(userInput);

        }

        //Collections.reverse(listaAInvertir); Un método fácil fácil fácil.

        inversor(listaAInvertir);
        System.out.println(listaAInvertir); 

    }

}
