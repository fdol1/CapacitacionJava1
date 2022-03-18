import java.util.LinkedList;

public class Colas {

    public static LinkedList colaPrincipal;
    public static LinkedList colaPrimeraMitad;
    public static LinkedList colaSegundaMitad;
    public static int tamanioColaPrincipal=10;

    public static void main(String[] args){

        colaPrincipal = new LinkedList();
        colaPrimeraMitad = new LinkedList();
        colaSegundaMitad = new LinkedList();
        llenarCola();
        desencolarColaPrincipal();
        mostrarColas();
    }

    public static void llenarCola(){

        for (int i=0; i<tamanioColaPrincipal; i++) {
            colaPrincipal.push(i);
        }
    }

    public static void desencolarColaPrincipal(){

        String respuesta = "Los datos de la cola principal antes de desencolar son: \n";
        for(int i=1; i<=tamanioColaPrincipal; i++){

            int dato = (int) colaPrincipal.poll();
            respuesta += dato + "\n";

            if(i <= (tamanioColaPrincipal/2)){
                colaPrimeraMitad.push(dato);
            }else{
                colaSegundaMitad.push(dato);
            }
        }
        System.out.println(respuesta);
    }

    public static void mostrarColas(){

        String r1 = "Los datos de la primera mitad de la cola son: \n";
        String r2 = "Los datos de la segunda mitad de la cola son: \n";

        while (colaPrimeraMitad.peek() != null && colaSegundaMitad.peek() != null){
            r1 += colaPrimeraMitad.poll() + "\n";
            r2 += colaSegundaMitad.poll() + "\n";
        }

        System.out.println(r1 + r2);
    }
}
