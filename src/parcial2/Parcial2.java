
package parcial2;
import java.util.Scanner;

public class Parcial2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] adn = new String[6][6];
        int j=0;
        for (int i = 0; i < 6; i++) {
            while(j<6){
                System.out.println("Ingrese la muestra en la posicion ["+i+"] ["+j+"]");
                adn[i][j]=sc.next();
                //si ingresan en minuscula se convierte en mayuscula 
                adn[i][j]=adn[i][j].toUpperCase();
                //Compruebo que se ingresen los datos correctamente, si se ingresan bien sigue el ciclo, sino vuelve a pedir la misma posicion
                if ((adn[i][j].equals("A"))||(adn[i][j].equals("G"))||(adn[i][j].equals("C"))||(adn[i][j].equals("T"))){
                    j++;
                }else{
                    System.out.println("Los valores permitidos son 'A', 'C', 'G', 'T'");
                }
            }
            j=0;
        }
        //muestro la matriz
        for (int i = 0; i < adn.length; i++){
            for (int k = 0; k < adn.length; k++){
                System.out.print(adn[i][k]+" ");
            }
            System.out.println("");
        }
        //llamo a la funcion para saber si es humano o mutante
        if (isMutant(adn)) {
            System.out.println("Es un mutante");
        } else {
            System.out.println("Es un humano");
        }
    }
     public static boolean isMutant(String[][] adn) {
        // Sacar las filas
        int contador=0;
        String filas="";
        for (int i = 0; i < adn.length; i++) {
            for (int k = 0; k < adn.length; k++) {
                filas=filas.concat(adn[i][k]);
            }
            // Compruebo que hayan 4 bases iguales
            if (filas.contains("AAAA")||(filas.contains("TTTT"))||(filas.contains("GGGG"))||(filas.contains("CCCC"))){
                contador++;
            }
            filas="";
        }

        // Sacar las columnas 
        String columna="";
        for (int col = 0; col < adn.length; col++) {
            for (int i = 0; i < adn.length; i++) {
                for (int k = 0; k < adn.length; k++) {
                    if(k==col){
                        columna=columna.concat(adn[i][k]);
                    }
                }
            }
            // Compruebo que hayan 4 bases iguales
            if (columna.contains("AAAA")||(columna.contains("TTTT"))||(columna.contains("GGGG"))||(columna.contains("CCCC"))) {
                contador++;
            }
            columna="";
        }

        // Sacar las diagonales
        String diagonal="";
        for (int i = 0; i < adn.length - 3; i++) {
            for (int j = 0; j < adn.length - 3; j++) {
                for (int k = 0; k < 4; k++) {
                    diagonal=diagonal.concat(adn[i+k][j+k]);
                }
            }
            // Compruebo que hayan 4 bases iguales
            if ((diagonal.contains("AAAA"))||(diagonal.contains("TTTT"))||(diagonal.contains("GGGG"))||(diagonal.contains("CCCC"))) {
                contador++;
            }
            diagonal="";
        }
        String diagonal_2="";
        for (int i = 3; i < adn.length; i++) {
            for (int j = 0; j < adn.length - 3; j++) {
                for (int k = 0; k < 4; k++) {
                    diagonal_2=diagonal_2.concat(adn[i-k][j+k]);
                }
            }
            // Compruebo que hayan 4 bases iguales
            if ((diagonal_2.contains("AAAA"))||(diagonal_2.contains("TTTT"))||(diagonal_2.contains("GGGG"))||(diagonal_2.contains("CCCC"))) {
                contador++;
            }
            diagonal_2="";
        }

        return contador>1;
    }
     /*
     #Muestra de humano
     ['A', 'T', 'G', 'C', 'C', 'T']
     ['C', 'G', 'T', 'C', 'A', 'G']
     ['T', 'G', 'G', 'C', 'A', 'T']
     ['T', 'C', 'G', 'G', 'T', 'A'] 
     ['A', 'A', 'T', 'C', 'G', 'T']
     ['C', 'C', 'T', 'A', 'T', 'C']
     
     Muestra de mutante
     ['T', 'C', 'G', 'A', 'C', 'T']
     ['T', 'G', 'C', 'T', 'A', 'G']
     ['T', 'G', 'A', 'C', 'A', 'T']
     ['T', 'C', 'G', 'G', 'C', 'A'] 
     ['A', 'A', 'A', 'A', 'G', 'T']
     ['C', 'C', 'T', 'A', 'T', 'C']
     */
}
