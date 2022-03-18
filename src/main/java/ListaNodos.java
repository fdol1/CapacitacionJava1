import java.util.Scanner;

public class ListaNodos {

    static String nombre;
    static Nodo punta;
    static String estructuraLista="";
    static ListaNodos l1;

    public static void main(String[] args){
        l1 = new ListaNodos("Lista enlazada simple");
        lanzarMenu();
    }

    public static void lanzarMenu(){
        System.out.println("Selecciona una opcion\n" +
                "1) Insertar al inicio.\n" +
                "2) Insertar al final.\n" +
                "3) Borrar dato.\n");

        Scanner opcion = new Scanner (System.in);
        int opcionSeleccionada = Integer.parseInt(opcion.nextLine());

        if(opcionSeleccionada == 1){
            for(int i=0; i<50;i++){
                l1.insertarAdelante((int)(Math.random()*100));
            }
        }
        else if (opcionSeleccionada == 2){
            for(int i=0; i<50;i++){
                l1.insertarAtras((int)(Math.random()*100));
            }
        }else if (opcionSeleccionada == 3){
            mostrarLista();
        }
        else{
            System.out.println("Opcion invalida");
        }

        lanzarMenu();
    }

    public ListaNodos(String x) {
        nombre = x;
        punta = null;
    }

    public void insertarAdelante(int d) {
        String estructuraLista="";
        Nodo q;
        q = new Nodo(d);
        if (punta == null) {
            punta = q;
            estructuraLista += "Nodo: " + punta.direccion + "---Dato--> |" + d + "|";
        } else {
            q.asignarLiga(punta);
            punta = q;
            estructuraLista += "Nodo: " + punta.direccion + "\n" + punta.direccion + "---------Dato--> |" + punta.dato + "|";
        }
        mostrarEstructura(estructuraLista);
    }

    public void insertarAtras(int d) {

        Nodo q, p, ant;
        q = new Nodo(d);
        estructuraLista = "";
        if (punta == null) {
            punta = q;
            estructuraLista += "Nodo: " + punta.direccion + "---Dato--> |" + d + "|";
        } else {
            p = punta;
            ant = null;
            while (p != null) {
                ant = p;
                p = p.obtenerLiga();
            }
            ant.asignarLiga(q);
            estructuraLista += "Nodo: " + punta.direccion + "\n" + punta.direccion + "---------Dato--> |" + d + "|";
        }
        mostrarEstructura(estructuraLista);
    }

    public static void mostrarLista() {

        Nodo p;
        p = punta;
        estructuraLista = "Lista\n";
        boolean bandera = false;
        int contador=0;
        System.out.println("¿Que dato desea eliminar\n");
        Scanner opcion = new Scanner (System.in);

        int dato = Integer.parseInt(opcion.nextLine());

        while (p != null) {
            if(dato == p.obtenerDato()){
                punta = p.obtenerLiga();
                bandera = true;
                contador ++;
            }
            estructuraLista +=  + p.obtenerDato() + "\n";
            p = p.obtenerLiga();
        }
        if(bandera){
            System.out.println("Se eliminó el numero " + dato + " " + contador + " veces");
        }
        else{
            System.out.println("El dato ingresado no se encuentra en la lista\n");
        }
    }

    public static void mostrarEstructura(String estructuraLista){
        System.out.println(estructuraLista);
    }
}
