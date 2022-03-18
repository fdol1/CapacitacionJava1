package views;

import controllers.Master;
import models.Electrodomestico;

public class Ejecutable {
    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = Master.crearArrayElectrodomesticos();

        double precios[] = Master.calcularPrecios(electrodomesticos);

        System.out.println("El precio total es --> " + (precios[0] + precios[1] + precios[2]));
        System.out.println("Donde el precio de los Electrodomesticos es: " + precios[0]);
        System.out.println("Donde el precio de las Lavadoras es: " + precios[2]);
        System.out.println("Donde el precio de los Televisores es: " + precios[1]);
    }
}
