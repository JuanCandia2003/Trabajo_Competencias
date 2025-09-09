
public class Banco {
    public ColaAtencion caja1;
    public ColaAtencion caja2;
    private ColaAtencion plataforma;
    private ColaAtencion credito;
    private ColaAtencion informaciones;

     // Contadores de atención
    private int atendidosCaja = 0;
    private int preferencialesCaja = 0;
    private int atendidosPlataforma = 0;
    private int preferencialesPlataforma = 0;
    private int atendidosCredito = 0;
    private int preferencialesCredito = 0;
    private int atendidosInformaciones = 0;
    private int preferencialesInformaciones = 0;

    public Banco() {
        caja1 = new ColaAtencion();
        caja2 = new ColaAtencion();
        plataforma = new ColaAtencion();
        credito = new ColaAtencion();
        informaciones = new ColaAtencion();

        }
    

    public void agregarClienteCaja(Cliente cliente, int numCaja) {
        if (numCaja == 1){
            caja1.encolar(cliente);
        } else {
            caja2.encolar(cliente);
        }
    }

    public void agregarClientePlataforma(Cliente cliente) {
        plataforma.encolar(cliente);
    }
    public void agregarClienteCredito(Cliente cliente) {
        credito.encolar(cliente);
    }

    public void agregarClienteInformaciones(Cliente cliente) {
        informaciones.encolar(cliente);
    }

    public String atenderCaja(int numCaja) {
        Cliente c;
        if (numCaja == 1){
            c = caja1.desencolar();
        } else {
            c = caja2.desencolar();
        }
        if (c != null) {
            atendidosCaja++;
            if (c.preferencial) preferencialesCaja++;
            return "Atendiendo en Caja: " + numCaja + "[CA-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Caja.";
    }

    public String atenderPlataforma() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidosPlataforma++;
            if (c.preferencial) preferencialesPlataforma++;
            return "Atendiendo en Plataforma: " + "[PT-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Plataforma.";
    }

     public String atenderCredito() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidosCredito++;
            if (c.preferencial) preferencialesCredito++;
            return "Atendiendo en Plataforma: " + "[CR-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Creadito.";
    }

     public String atenderInformaciones() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidosInformaciones++;
            if (c.preferencial) preferencialesInformaciones++;
            return "Atendiendo en Plataforma: " + "[IF-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Creadito.";
    }

    public String finalizarAtencion(String tipoPuesto, int numeroPuesto) {
        return "Puesto " + tipoPuesto + " número " + numeroPuesto + " liberado.";
    }
    public void mostrarColas() {
        System.out.println("Cola de Caja 1:");
        caja1.mostrarCola();
        System.out.println("Cola de Caja 2:");
        caja2.mostrarCola();
        System.out.println("\nCola de Plataforma:");
        plataforma.mostrarCola();
        System.out.println("\nCola de Credito:");
        credito.mostrarCola();
        System.out.println("\nCola de Informaciones:");
        informaciones.mostrarCola();
    }
    public void imprimirResumen() {
        System.out.println("\n Resumen del día:");
        System.out.println("- Caja atendió " + atendidosCaja + " clientes (" + preferencialesCaja + " preferenciales).");
        System.out.println("- Plataforma atendió " + atendidosPlataforma + " clientes (" + preferencialesPlataforma + " preferenciales).");
        System.out.println("- Credito atendió " + atendidosCredito + " clientes (" + preferencialesCredito + " preferenciales).");
        System.out.println("- Informaciones atendió " + atendidosInformaciones + " clientes (" + preferencialesInformaciones + " preferenciales).");
        System.out.println("════════════════════════════════════");
    }
}

