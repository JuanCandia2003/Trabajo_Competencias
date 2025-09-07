public class Banco {
    private ColaAtencion caja;
    private ColaAtencion plataforma;

     // Contadores de atención
    private int atendidosCaja = 0;
    private int preferencialesCaja = 0;
    private int atendidosPlataforma = 0;
    private int preferencialesPlataforma = 0;

    public Banco() {
        caja = new ColaAtencion();
        plataforma = new ColaAtencion();
    }

    public void agregarClienteCaja(Cliente cliente) {
        caja.encolar(cliente);
    }

    public void agregarClientePlataforma(Cliente cliente) {
        plataforma.encolar(cliente);
    }

    public String atenderCaja() {
        Cliente c = caja.desencolar();
        if (c != null) {
            atendidosCaja++;
            if (c.preferencial) preferencialesCaja++;
            return "Atendiendo en Caja: " + "[T-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Caja.";
    }

    public String atenderPlataforma() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidosPlataforma++;
            if (c.preferencial) preferencialesPlataforma++;
            return "Atendiendo en Plataforma: " + "[T-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Plataforma.";
    }

    public void mostrarColas() {
        System.out.println("Cola de Caja:");
        caja.mostrarCola();
        System.out.println("\nCola de Plataforma:");
        plataforma.mostrarCola();
    }
    public void imprimirResumen() {
        System.out.println("\n Resumen del día:");
        System.out.println("- Caja atendió " + atendidosCaja + " clientes (" + preferencialesCaja + " preferenciales).");
        System.out.println("- Plataforma atendió " + atendidosPlataforma + " clientes (" + preferencialesPlataforma + " preferenciales).");
        System.out.println("════════════════════════════════════");
    }
}

