package co.edu.uniquindio.poo;

import java.util.Arrays;
import java.util.Scanner;

public class IngresoMoto {

    Scanner scanner;
    private String[][] motosInicial;
    private int contadorMotos; 

    public void ingresoMoto() {
        this.motosInicial = new String[10][10];
        this.contadorMotos = 0;
        for (String[] fila : motosInicial) {
            Arrays.fill(fila, "Vacío");
        }
    }

    public void parqueaderoCupos() {
        try {
            this.scanner = new Scanner(System.in);
            System.out.println("Ingrese placa de la moto");
            String placa = scanner.nextLine();

            if (placa.length() == 6) {
                String letra = placa.substring(0,3).toUpperCase();
                String numeros = placa.substring(3);
                String letraU = placa.substring(5).toUpperCase();

                Boolean letraV = letra.matches("[a-zA-Z]+");
                Boolean numerosV = numeros.matches("\\d{2}");
                Boolean letraUV = letraU.matches("[a-zA-Z]+");

                if(letraV && numerosV && letraUV) {
                    System.out.print("Se agrego la moto correctamente");
                } else {
                    throw new IllegalAccessException("Placa mal ingresada");
                }
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
            parqueaderoCupos();
        }
    }
}
