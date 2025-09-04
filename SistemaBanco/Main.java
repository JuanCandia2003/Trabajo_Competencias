import java.util.Scanner;

public class Main {
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
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}