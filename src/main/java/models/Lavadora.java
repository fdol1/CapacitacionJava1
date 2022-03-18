package models;

import controllers.Master;

public class Lavadora extends Electrodomestico {

    //Variables
    int carga;

    //Constructores
    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(int precioBase, int peso) {
        super();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Lavadora(double precioBase, double peso, String color, char miconsumo, int carga) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.miConsumo = Master.comprobarConsumoEnergetico(miconsumo);
        this.color = Master.comprobarColor(color);
        this.carga = carga;
    }

    public double precioFinal() {

        double preciofinal = super.precioFinal();

        if (getCarga() > 30) {
            preciofinal += 50;
        }

        return preciofinal;
    }

    //Geters & Seters
    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }


}