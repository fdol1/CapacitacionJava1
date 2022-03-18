package controllers;

import models.Electrodomestico;
import models.Lavadora;
import models.Televisor;

import java.util.ArrayList;

public class Master {

    public static Electrodomestico.ConsumoElectronico comprobarConsumoEnergetico(char letra) {
        String consumos = "ABCDEF";
        if (!(consumos.contains(String.valueOf(letra)))) {
            return Electrodomestico.ConsumoElectronico.B;
        } else {
            return Electrodomestico.ConsumoElectronico.valueOf(Character.toString(letra));
        }
    }

    public static Electrodomestico.Colores comprobarColor(String color) {
        ArrayList<String> colores = new ArrayList<>();
        colores.add("BLANCO");
        colores.add("METAL");
        colores.add("ROJO");
        colores.add("VERDE");
        colores.add("AZUL");

        if (!(colores.contains(color))) {
            return Electrodomestico.Colores.BLANCO;
        }
        return Electrodomestico.Colores.valueOf(color);
    }

    public static Electrodomestico[] crearArrayElectrodomesticos() {

        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        electrodomesticos[0] = new Electrodomestico();
        electrodomesticos[1] = new Electrodomestico(100, 20, "ROJO", 'A');
        electrodomesticos[2] = new Electrodomestico(200, 30, "VERDE", 'B');
        electrodomesticos[3] = new Lavadora(300, 20, "ROJO", 'F', 35);
        electrodomesticos[4] = new Electrodomestico(400, 50, "METAL", 'D');
        electrodomesticos[5] = new Lavadora(200, 20, "AZUL", 'E', 45);
        electrodomesticos[6] = new Electrodomestico(300, 40, "BLANCO", 'C');
        electrodomesticos[7] = new Televisor(400, 5, "METAL", 'A', 30, false);
        electrodomesticos[8] = new Electrodomestico(100, 20, "ROJO", 'G');
        electrodomesticos[9] = new Televisor(350, 5, "VERDE", 'C', 30, true);

        return electrodomesticos;
    }

    public static double[] calcularPrecios(Electrodomestico[] electrodomesticos) {
        double electrodomesticosPrecio = 0;
        double televisorPrecio = 0;
        double lavadoraPrecio = 0;

        //  private static ArrayList<Electrodomestico> electrodomesticos ArrayList<>
        double[] precios = new double[3];

        for (int i = 0; i < 10; i++) {
            if (electrodomesticos[i] instanceof Televisor) {
                televisorPrecio += electrodomesticos[i].precioFinal();
                //System.out.println("Televisor "+televisorPrecio);
            } else if (electrodomesticos[i] instanceof Lavadora) {
                lavadoraPrecio += electrodomesticos[i].precioFinal();
                //System.out.println("Lavadora "+lavadoraPrecio);
            } else if (!(electrodomesticos[i] instanceof Televisor) && !(electrodomesticos[i] instanceof Lavadora)) {
                electrodomesticosPrecio += electrodomesticos[i].precioFinal();
                //System.out.println("electrodomestico "+electrodomesticosPrecio);
            }
        }

        precios[0] = electrodomesticosPrecio;
        precios[1] = televisorPrecio;
        precios[2] = lavadoraPrecio;

        return precios;
    }
}
