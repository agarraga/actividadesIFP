import java.util.*;

public class Ejercicio4 {

    public static Set<Integer> calcularNumerosDivisibles(int min, int max, List<Integer> numeros){

        List<Integer> resultado = new ArrayList<Integer>();

        for (int i = min; i <= max; i++) {
            for (int j = 0; j < numeros.size(); j++) {
               if (i % numeros.get(j)  == 0) {
                   resultado.add(i);
               }
            }
        }
        TreeSet<Integer> resultadoTreeSet = new TreeSet<Integer>(resultado); // lista con elementos unicos y ordenados
        return resultadoTreeSet;
        }
 
	public static void main(String[] args) {
		
        String userInput;
        String notValidInput = "\n¡No es una entrada valida! " +
                               "Por favor, lea las instrucciones detalladamente.\n";
        Scanner in = new Scanner(System.in).useDelimiter("\\n");

		while (true) {
            System.out.println("\nBienvenido al calculador de divsibilidad. Elige una opcion:" +
                               "\n\n1. Ver los numeros del 1 al 100 divisibles entre 2 y 3." +
                               "\n2. Elige tus numeros.\nO 'x' para salir.");
			userInput = in.next();

            if (userInput.toLowerCase().equals("x")) {
                break;
            }
            
            if (!userInput.equals("1") && !userInput.equals("2")) {
                System.out.println(notValidInput);
                continue;
            }
            
            if (userInput.equals("1")) {
                List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(2, 3));
                System.out.println(calcularNumerosDivisibles(1, 100, numeros));
                continue;
            }
            
            System.out.println("Primero, elige el rango que quieres testear, " +
                               "separando el mininimo y el maximo entre un espacio. " +
                               "Por ejenmplo \"1 100\"");
            userInput = in.next();
            
            // TODO fix regex.
            if (!userInput.matches("\\d+\\s\\d+")) {
                System.out.println(notValidInput + "este es el problema");
                //continue;
            }
            
            // Estoy seguro que hay una forma mucho mas fácil de hacer esto, pero no la he encontrado o entendido. 
            String[] minMaxStr = userInput.split(" ");
            List<String> minMaxStrList = Arrays.asList(minMaxStr);
            List<Integer> minMax = new ArrayList<Integer>();
            for (String s: minMaxStrList) minMax.add(Integer.valueOf(s));
            
            Collections.sort(minMax);
            
            int min = minMax.get(0);
            int max = minMax.get(1);

            System.out.println("Ahora elige los numeros por los que quieres dividir el rango, " +
                               "separados por un espacio. Por ejemplo \"2 3 7\".");
            userInput = in.next();
            
            //TODO asegurarse que no puedan meter un " 0 ", pa no dividir entre 0. a lo mejor un try/catch?
            if (!userInput.matches("[0-9 ]+")) {
                System.out.println(notValidInput);
                continue;
            }
            
            //TODO Este bloque es casi exactamente igual al anterior, podría hacer un metodo para los dos.
            String[] numeroStr = userInput.trim().split(" ");
            List<String> numerosStrList = Arrays.asList(numeroStr);
            List<Integer> numeros = new ArrayList<Integer>();
            for(String s : numerosStrList) numeros.add(Integer.valueOf(s)); 

            System.out.print(calcularNumerosDivisibles(min, max, numeros)); 
        }
    }
}
