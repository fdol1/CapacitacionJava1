import java.util.InputMismatchException;
import java.util.Scanner;

public class ArregloSimple {

    public static int[] arregloSimple;

    public static void main(String[] args){

        int n, nI, nF;

        System.out.println("Ingrese el tamaño del arreglo");
        Scanner entradaEscaner = new Scanner (System.in);
        n = Integer.parseInt(entradaEscaner.nextLine());

        System.out.println("Ingrese desde va a inciar del arreglo");
        Scanner inico = new Scanner (System.in);
        nI = Integer.parseInt(entradaEscaner.nextLine());

        System.out.println("Ingrese hasta donde va ir el arreglo");
        Scanner fin = new Scanner (System.in); //Creación de un objeto Scanner
        nF = Integer.parseInt(entradaEscaner.nextLine());

        arregloSimple = new int[n];

        llenarArreglo(n, nI,nF);
        mostrarArregloSimple("Arreglo inicial");
        invertir();
        ordenar();
        invertirDigito();
        encontrarDatoMayor();
        mostrarNumerosPrimos();

    }

    public static void llenarArreglo(int n, int nI, int nF){

        for(int i=0; i< arregloSimple.length;i++){
            arregloSimple[i] = (int) (Math.random()*nF)+nI;
        }


    }

    public static void mostrarArregloSimple(String mensaje){

        String cadenaDeArreglo="";
        for(int i = 0; i< arregloSimple.length; i++) {
            cadenaDeArreglo += arregloSimple[i] + ", ";
        }
        System.out.println(mensaje + "\n" + cadenaDeArreglo);
    }

    public static void encontrarDatoMayor(){

        int mayor= arregloSimple[0];
        int Cont = 0;
        for(int i = 0; i<arregloSimple.length; i++) {
            if (arregloSimple[i] > mayor) {
                mayor = arregloSimple[i];
            }
        }
        System.out.println("el dato mayor es: " + mayor);

    }

    public static void ordenar() {

        for(int i=0; i < arregloSimple.length - 1 ;i++) {

            for(int j = i + 1; j < arregloSimple.length; j++) {

                if ( arregloSimple[i] > arregloSimple [j]) {
                    int Aux;
                    Aux = arregloSimple[i];
                    arregloSimple [i] = arregloSimple [j];
                    arregloSimple[j] = Aux;
                }
            }
        }
        mostrarArregloSimple("El arreglo ordenado es el siguiente: ");
    }

    public static void invertir() {
        int aux;
        int i =0;
        int j = arregloSimple.length-1;
        while(i < j)
        {
            aux = arregloSimple[i];
            arregloSimple[i] = arregloSimple[j];
            arregloSimple[j] = aux;
            i++;
            j--;
        }
        mostrarArregloSimple("El arreglo invertido es: ");
    }

    public static void invertirDigito () {
        int i, d =0;
        StringBuilder s = new StringBuilder(" , ");
        for (i = 0; i < arregloSimple.length ; i++) {
            d = operarDigito (arregloSimple [i]);
            s.append(d).append(" , ");
            arregloSimple[i] = d;
        }
        mostrarArregloSimple("Los digitos invertidos del arreglo son: ");
    }


    public static int operarDigito(int x) {

        int digito =0;
        int n1 =0;
        while ( x > 0) {
            digito = x % 10;
            x = x / 10;
            n1= n1 *10 + digito;
        }
        return n1;
    }

    public static void mostrarNumerosPrimos(){

        String respuesta ="Los numeros aleatorios que resultaron ser primos son: \n";
        int contador=0;
        for (int i=0; i<arregloSimple.length;i++){
            if(arregloSimple[i] % 2 == 0){
                contador++;
                respuesta += "-) " + arregloSimple[i] + "\n";
            }
        }
        System.out.println(respuesta + "TOTAL NUMEROS PRIMOS: " + contador);
    }
}
