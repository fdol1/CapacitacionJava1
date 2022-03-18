import java.util.Scanner;

public class EquiposYResultados {

    public static String[] arregloEquipos;
    public static int[] arreglopuntajes;

    public static void main(String[] args){

        int n;

        System.out.println("Ingrese la cantidad de equipos deportivos");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        n = Integer.parseInt(entradaEscaner.nextLine());

        arregloEquipos = new String[n];
        arreglopuntajes = new int[n];

        llenarArreglo(n);
        menu();


    }

    public static void menu(){

        System.out.println("Por favor seleccione el numero de opcion que desea ejecutar\n" +
                "1) ordenar por burbuja.\n" +
                "2) ordenar por insersion.\n" +
                "3) ver el equipo ganador");

        Scanner entradaEquipos = new Scanner (System.in);
        String opcion = entradaEquipos.nextLine();

        if(opcion.equals("1")){
            ordenarPorBurbuja();
            menu();
        }else if(opcion.equals("2")){
            ordenarPorInsersion();
            menu();
        }else{
            encontrarEquipoConMejorPuntaje();
            menu();
        }
    }

    public static void llenarArreglo(int n){

        for(int i = 0; i<n; i++)
        {
            System.out.println("por favor ingrese el equipo # " + (i+1) +" del arreglo");
            Scanner entradaEquipos = new Scanner (System.in);
            arregloEquipos[i] = entradaEquipos.nextLine();

            System.out.println("por favor ingrese el puntaje del equipo: " + arregloEquipos[i]);
            Scanner entradaPuntajes = new Scanner (System.in);
            arreglopuntajes[i] = Integer.parseInt(entradaPuntajes.nextLine());
        }
    }


    public static void encontrarEquipoConMejorPuntaje(){

        int mejorPuntaje= arreglopuntajes[0];
        String nombreEquipo="";
        for(int i = 0; i<arreglopuntajes.length; i++) {
            if (arreglopuntajes[i] > mejorPuntaje) {
                mejorPuntaje = arreglopuntajes[i];
                nombreEquipo = arregloEquipos[i];
            }
        }
        System.out.println("El equipo ganador es: " + nombreEquipo + " con un puntaje de: " + mejorPuntaje);

    }

    public static void ordenarPorBurbuja() {

        for(int i=0; i < arreglopuntajes.length - 1 ;i++) {

            for(int j = i + 1; j < arreglopuntajes.length; j++) {

                if ( arreglopuntajes[i] > arreglopuntajes [j]) {
                    int Aux;
                    String auxnombre;

                    Aux = arreglopuntajes[i];
                    arreglopuntajes [i] = arreglopuntajes [j];
                    arreglopuntajes[j] = Aux;

                    auxnombre = arregloEquipos[i];
                    arregloEquipos [i] = arregloEquipos [j];
                    arregloEquipos[j] = auxnombre;

                }
            }
        }
        mostrarPuntajes("El arreglo ordenado por burbuja es: ");
    }

    public static void ordenarPorInsersion(){

        for(int i=0; i< arreglopuntajes.length; i++){
            int aux = arreglopuntajes[i];
            String auxnombre = arregloEquipos[i];
            int j = i -1;
            while ((j >= 0) && (aux < arreglopuntajes[j])){
                arreglopuntajes[j+1] = arreglopuntajes[j];
                j--;
            }
            arreglopuntajes[j+1]= aux;
            arregloEquipos[j+1] = auxnombre;
        }
        mostrarPuntajes("El arreglo ordenado por insersion es: ");
    }

    public static void mostrarPuntajes(String mensaje){

        String cadenaDeArreglo="";
        for(int i = 0; i< arreglopuntajes.length; i++) {
            cadenaDeArreglo += arregloEquipos[i] + ": " + arreglopuntajes[i] + "\n";
        }
        System.out.println(mensaje + "\n" + cadenaDeArreglo);
    }
}
