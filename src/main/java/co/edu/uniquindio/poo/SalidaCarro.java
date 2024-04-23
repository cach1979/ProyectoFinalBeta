package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SalidaCarro {
    
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public SalidaCarro(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = LocalDateTime.now();
    }

    public void mostrarInformacion() {

        System.out.println("Hora de entrada: " + horaEntrada);
        System.out.println("Hora de salida: " + horaSalida);
        long minutosEstadia = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
        System.out.println("Tiempo en el parqueadero: " + minutosEstadia + " minutos");

        if (validarInformacionPropietario()) {
            System.out.println("Carro entregado al propietario correctamente.");

        } else {
            System.out.println("Información del propietario incorrecta. No se puede entregar el carro.");

        }
    }

    private boolean validarInformacionPropietario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPor favor, confirme la información del propietario:");
        System.out.print("Matrícula del carro: ");
        String matricula = scanner.nextLine().trim();

        System.out.print("Modelo del carro: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Nombre completo del propietario: ");
        String nombrePropietario = scanner.nextLine().trim();

        boolean informacionCorrecta = validarInformacionCorrecta(matricula, modelo, nombrePropietario);

        scanner.close(); 

        return informacionCorrecta;
    }

    private boolean validarInformacionCorrecta(String matricula, String modelo, String nombrePropietario) {

        return matricula.equalsIgnoreCase("ABC123") &&
               modelo.equalsIgnoreCase("Toyota Corolla") &&
               nombrePropietario.equalsIgnoreCase("Juan Pérez");
    }
}