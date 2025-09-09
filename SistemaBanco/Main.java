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
            System.out.println("3. Agregar cliente a Credito");
            System.out.println("4. Agregar cliente a Informaciones");
            System.out.println("5. Atender cliente en Caja");
            System.out.println("6. Atender cliente en Plataforma");
            System.out.println("7. Atender cliente en Credito");
            System.out.println("8. Atender cliente en Informaciones");
            System.out.println("9. Liberar puesto de atención");
            System.out.println("10. Mostrar colas");
            System.out.println("11. Resumen del dia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCaja = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefCaja = sc.nextLine().equalsIgnoreCase("s");
                    System.out.println("Seleccione caja: (1 o 2)");
                    int opcionCaja = sc.nextInt();
                    banco.agregarClienteCaja(new Cliente(nombreCaja, prefCaja), opcionCaja);
                    break;


                case 2:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombrePlat = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefPlat = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarClientePlataforma(new Cliente(nombrePlat, prefPlat));
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCred = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefCred = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarClienteCredito(new Cliente(nombreCred, prefCred));
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreInf = sc.nextLine();
                    System.out.print("¿Es preferencial? (s/n): ");
                    boolean prefInf = sc.nextLine().equalsIgnoreCase("s");
                    banco.agregarClienteInformaciones(new Cliente(nombreInf, prefInf));
                    break;

                case 5:
                    System.out.println("Seleccione caja: (1 o 2)");
                    int opCaja = sc.nextInt();
                    banco.atenderCaja(opCaja);
                    break;

                case 6:
                    System.out.println(banco.atenderPlataforma());
                    break;
                case 7:
                    System.out.println(banco.atenderCredito());
                    break;
                case 8: 
                    System.out.println(banco.atenderInformaciones());
                    break;
                case 9:
                    System.out.println("\n--- Finalizar Atención ---");
                    System.out.print("Ingrese el tipo de puesto a liberar (caja/plataforma/creditos/informaciones): ");
                    String tipoPuesto = sc.nextLine();
                    System.out.print("Ingrese el número del puesto: ");
                    int numeroPuesto = sc.nextInt();
                    sc.nextLine();
                    System.out.println(banco.finalizarAtencion(tipoPuesto, numeroPuesto));
                    break;
                case 10:
                    banco.mostrarColas();
                    break;
                case 11:
                    banco.imprimirResumen();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}