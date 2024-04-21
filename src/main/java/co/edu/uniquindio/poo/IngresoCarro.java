package co.edu.uniquindio.poo;

import java.util.Arrays;
import java.util.Scanner;

public class IngresoCarro {
    
    Scanner scanner;
    private String [][] carrosInicial;
    private int contadorCarros;

    public void ingresoCarro() {
        this.carrosInicial = new String[8][8];
        this.contadorCarros = 0;
        for (String[] fila : carrosInicial) {
            Arrays.fill(fila, "Vacío");
        }
    }

    public void parqueaderoCupos() {
        try {
            this.scanner = new Scanner(System.in);
            System.out.println("Ingrese placa del carro");
            String placa = scanner.nextLine();

            if(placa.length() == 6) {
                String letras = placa.substring(0,3).toUpperCase();
                String numeros = placa.substring(3);

                Boolean letrasV = letras.matches("[a-zA-Z]+");
                Boolean numerosV = numeros.matches("\\d{3}");
                
                if(letrasV && numerosV) {
                    System.out.println("Se agrego el carro correctamente");
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
