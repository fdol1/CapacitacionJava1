public class Nodo {

    public int dato;
    public int direccion;
    public Nodo liga;
    public int vdir[] = new int[200];        // VECTOR PARA GUARDAR LAS DIRECCIONES UTILIZADAS
    int ndir;

    public Nodo(int d) {
        dato = d;
        direccion = pedirDireccion();
    }

    public Nodo obtenerLiga() {
        return liga;
    }

    public int obtenerDato() {
        return dato;
    }

    public void asignarLiga(Nodo d) {
        liga = d;
    }

    public int pedirDireccion() {
        int n;
        do {
            n = (int) (Math.random() * 900);
        } while (dirUtilizada(n) == true);
        vdir[ndir++] = n;
        return n;
    }

    public boolean dirUtilizada(int x) {
        boolean respuesta = false;
        int i = 0;
        while (i < ndir && respuesta == false) {
            if (vdir[i] == x) {
                respuesta = true;
            }
            i = i + 1;
        }
        return respuesta;
    }
}
