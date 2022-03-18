package models;

import controllers.Master;

public class Electrodomestico {

    //Variables
    protected double precioBase;
    protected double peso;
    protected Colores color;
    protected ConsumoElectronico miConsumo;


    //Constructores
    public Electrodomestico() {
        this.precioBase = 200;
        this.peso = 5;
        this.color = Colores.BLANCO;
        this.miConsumo = ConsumoElectronico.B;
    }

    public Electrodomestico(double precioBase, double peso) {
        this.color = Colores.BLANCO;
        this.miConsumo = ConsumoElectronico.B;
    }

    public Electrodomestico(double precioBase, double peso, String color, char miconsumo) {

        this.precioBase = precioBase;
        this.peso = peso;
        this.miConsumo = Master.comprobarConsumoEnergetico(miconsumo);
        this.color = Master.comprobarColor(color);
    }

    //metodos get and set
    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public ConsumoElectronico getMiConsumo() {
        return miConsumo;
    }

    public void setMiConsumo(ConsumoElectronico miConsumo) {
        this.miConsumo = miConsumo;
    }

    //Metodo Precio Final
    public double precioFinal() {

        double precioFinal = 0.0;

        switch (getMiConsumo()) {
            case A:
                precioFinal = getPrecioBase() + 100;
                break;
            case B:
                precioFinal = getPrecioBase() + 85;
                break;
            case C:
                precioFinal = getPrecioBase() + 60;
                break;
            case D:
                precioFinal = getPrecioBase() + 50;
                break;
            case E:
                precioFinal = getPrecioBase() + 30;
                break;
            case F:
                precioFinal = getPrecioBase() + 10;
                break;
        }

        if (getPeso() <= 19) {
            precioFinal += 10;
        } else if (getPeso() <= 49) {
            precioFinal += 50;
        } else if (peso <= 79) {
            precioFinal += 80;
        } else {
            precioFinal += 100;
        }
        return precioFinal;
    }


    //Enums
    public enum Colores {
        BLANCO, METAL, ROJO, VERDE, AZUL
    }

    public enum ConsumoElectronico {A, B, C, D, E, F}
}
