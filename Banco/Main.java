import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Gestión de Banco ===");
            System.out.println("1. Agregar cliente a Caja");
            System.out.println("2. Agregar cliente a Plataforma");
            System.out.println("3. Atender cliente en Caja");
            System.out.println("4. Atender cliente en Plataforma");
            System.out.println("5. Transferir cliente");
            System.out.println("6. Finalizar atención"); // Nueva opción para liberar puestos
            System.out.println("7. Mostrar colas");
            System.out.println("8. Resumen del dia");
            System.out.println("9. Salir"); // La opción de salida ha cambiado
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCaja = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefCaja = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarClienteCaja(new Cliente(nombreCaja, prefCaja));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombrePlat = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefPlat = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarClientePlataforma(new Cliente(nombrePlat, prefPlat));
                    break;
                case 3:
                    System.out.println(banco.atenderCaja());
                    break;
                case 4:
                    System.out.println(banco.atenderPlataforma());
                    break;
                case 5:
                    System.out.println("\n--- Transferir Cliente ---");
                    System.out.print("Ingrese el número de ticket del cliente a transferir: ");
                    int ticketTransferir = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la cola de origen (caja/plataforma): ");
                    String origen = sc.nextLine();
                    System.out.print("Ingrese la cola de destino (caja/plataforma): ");
                    String destino = sc.nextLine();
                    System.out.println(banco.transferirCliente(ticketTransferir, origen, destino));
                    break;
                case 6:
                    System.out.println("\n--- Finalizar Atención ---");
                    System.out.print("Ingrese el tipo de puesto a liberar (caja/plataforma): ");
                    String tipoPuesto = sc.nextLine();
                    System.out.print("Ingrese el número del puesto: ");
                    int numeroPuesto = sc.nextInt();
                    sc.nextLine();
                    System.out.println(banco.finalizarAtencion(tipoPuesto, numeroPuesto));
                    break;
                case 7:
                    banco.mostrarColas();
                    break;
                case 8:
                    banco.imprimirResumen();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        sc.close();
    }
}