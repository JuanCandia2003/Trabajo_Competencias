import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Banco {
    // Colas para caja
    private Queue<String> cajaPreferencial = new LinkedList<>();
    private Queue<String> cajaCorriente = new LinkedList<>();

    // Colas para plataforma
    private Queue<String> plataformaPreferencial = new LinkedList<>();
    private Queue<String> plataformaCorriente = new LinkedList<>();

    // Método para agregar clientes
    public void agregarCliente(String cliente, boolean esPreferencial, boolean esCaja) {
        if (esCaja) {
            if (esPreferencial) {
                cajaPreferencial.add(cliente);
            } else {
                cajaCorriente.add(cliente);
            }
        } else {
            if (esPreferencial) {
                plataformaPreferencial.add(cliente);
            } else {
                plataformaCorriente.add(cliente);
            }
        }
    }

    // Método para atender clientes en caja
    public String atenderCaja() {
        if (!cajaPreferencial.isEmpty()) {
            return "Atendiendo en Caja (Preferencial): " + cajaPreferencial.poll();
        } else if (!cajaCorriente.isEmpty()) {
            return "Atendiendo en Caja (Corriente): " + cajaCorriente.poll();
        } else {
            return "No hay clientes en Caja.";
        }
    }

    // Método para atender clientes en plataforma
    public String atenderPlataforma() {
        if (!plataformaPreferencial.isEmpty()) {
            return "Atendiendo en Plataforma (Preferencial): " + plataformaPreferencial.poll();
        } else if (!plataformaCorriente.isEmpty()) {
            return "Atendiendo en Plataforma (Corriente): " + plataformaCorriente.poll();
        } else {
            return "No hay clientes en Plataforma.";
        }
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Fichero del Banco ===");
            System.out.println("1. Agregar cliente a Caja");
            System.out.println("2. Agregar cliente a Plataforma");
            System.out.println("3. Atender cliente en Caja");
            System.out.println("4. Atender cliente en Plataforma");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String clienteCaja = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefCaja = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarCliente(clienteCaja, prefCaja, true);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String clientePlat = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefPlat = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarCliente(clientePlat, prefPlat, false);
                    break;

                case 3:
                    System.out.println(banco.atenderCaja());
                    break;

                case 4:
                    System.out.println(banco.atenderPlataforma());
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}