import java.util.*;

public class Ejercicio8 {

    public static void main(String[] args) {

        String userInput; 
        List<String> listaAInvertir = new ArrayList<String>();
        Scanner in = new Scanner(System.in).useDelimiter("\\n");

        System.out.println("Introduzca 5 numeros, " +
                           "cada uno seguido de Enter y se los invertiremos");
        for (int i = 0; i < 5; i++) {
            userInput = in.next();
            listaAInvertir.add(userInput);
        }
        //Collections.reverse(listaAInvertir); Un método fácil fácil fácil.
        invertirLista(listaAInvertir);
        System.out.println(listaAInvertir); 
    }

    public static void invertirLista(List<String> listaAInvertir) {
        String elemento; 
        if (listaAInvertir.size() <= 1 || listaAInvertir == null)
            return;
        elemento = listaAInvertir.remove(0);
        invertirLista(listaAInvertir);
        listaAInvertir.add(elemento);
    }
}
