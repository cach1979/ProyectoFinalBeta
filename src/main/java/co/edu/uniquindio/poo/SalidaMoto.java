package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SalidaMoto {
    
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public SalidaMoto(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = LocalDateTime.now();
    }

    public void mostrarInformacion() {
        
        System.out.println("Hora de entrada: " + horaEntrada);
        System.out.println("Hora de salida: " + horaSalida);
        long minutosEstadia = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        System.out.println("Tiempo en el parqueadero: " + minutosEstadia + " minutos");

        if (validarInformacionPropietario()) {
            System.out.println("Moto entregada al propietario correctamente.");

        } else {
            System.out.println("Información del propietario incorrecta. No se puede entregar la moto.");

        }
    }

    private boolean validarInformacionPropietario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPor favor, confirme la información del propietario:");
        System.out.print("Placa de la moto: ");
        String placa = scanner.nextLine().trim();

        System.out.print("Modelo de la moto: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Nombre completo del propietario: ");
        String nombrePropietario = scanner.nextLine().trim();

        boolean informacionCorrecta = validarInformacionCorrecta(placa, modelo, nombrePropietario);

        scanner.close(); 

        return informacionCorrecta;
    }

    private boolean validarInformacionCorrecta(String placa, String modelo, String nombrePropietario) {
 
        return placa.equalsIgnoreCase("XYZ789") &&
               modelo.equalsIgnoreCase("Honda CB500") &&
               nombrePropietario.equalsIgnoreCase("María López");
    }
}