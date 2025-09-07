import java.util.ArrayList;
import java.util.List;

public class Banco {
    private ColaAtencion caja;
    private ColaAtencion plataforma;

    // Contadores de atención
    private int atendidosCaja = 0;
    private int preferencialesCaja = 0;
    private int atendidosPlataforma = 0;
    private int preferencialesPlataforma = 0;

    // --- NUEVAS PROPIEDADES ---
    private List<PuestoAtencion> puestosCaja;
    private List<PuestoAtencion> puestosPlataforma;
    private static final int NUMERO_CAJAS = 3;
    private static final int NUMERO_PLATAFORMAS = 2;

    public Banco() {
        caja = new ColaAtencion();
        plataforma = new ColaAtencion();
        
        // --- INICIALIZAR PUESTOS DE ATENCIÓN ---
        puestosCaja = new ArrayList<>();
        for (int i = 1; i <= NUMERO_CAJAS; i++) {
            puestosCaja.add(new PuestoAtencion(i, "Caja"));
        }

        puestosPlataforma = new ArrayList<>();
        for (int i = 1; i <= NUMERO_PLATAFORMAS; i++) {
            puestosPlataforma.add(new PuestoAtencion(i, "Plataforma"));
        }
    }

    public void agregarClienteCaja(Cliente cliente) {
        caja.encolar(cliente);
    }

    public void agregarClientePlataforma(Cliente cliente) {
        plataforma.encolar(cliente);
    }

    // --- METODO MODIFICADO PARA ASIGNAR UN PUESTO ---
    public String atenderCaja() {
        PuestoAtencion puestoDisponible = obtenerPuestoDisponible(puestosCaja);
        if (puestoDisponible == null) {
            return "Todas las cajas están ocupadas. Espere por favor.";
        }

        Cliente c = caja.desencolar();
        if (c != null) {
            atendidosCaja++;
            if (c.preferencial) preferencialesCaja++;
            puestoDisponible.setOcupado(true);
            return "Atendiendo en " + puestoDisponible.getNombre() + ": " + "[T-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)");
        }
        return "No hay clientes en Caja.";
    }
    // --- METODO MODIFICADO PARA ASIGNAR UN PUESTO ---
    public String atenderPlataforma() {
        PuestoAtencion puestoDisponible = obtenerPuestoDisponible(puestosPlataforma);
        if (puestoDisponible == null) {
            return "Todas las plataformas están ocupadas. Espere por favor.";
        }
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidosPlataforma++;
            if (c.preferencial) preferencialesPlataforma++;
            puestoDisponible.setOcupado(true);
            return "Atendiendo en " + puestoDisponible.getNombre() + ": " + "[T-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)");
        }
        return "No hay clientes en Plataforma.";
    }

    // --- NUEVO METODO PARA ENCONTRAR UN PUESTO LIBRE ---
    private PuestoAtencion obtenerPuestoDisponible(List<PuestoAtencion> puestos) {
        for (PuestoAtencion puesto : puestos) {
            if (!puesto.isOcupado()) {
                return puesto;
            }
        }
        return null; // Si todos los puestos están ocupados
    }

    // --- NUEVO MÉTODO PARA TRANSFERIR CLIENTES ---
    public String transferirCliente(int numeroTicket, String origen, String destino) {
        Cliente clienteAtransferir = null;
        if (origen.equalsIgnoreCase("caja") && destino.equalsIgnoreCase("plataforma")) {
            clienteAtransferir = caja.buscarYTransferir(numeroTicket);
            if (clienteAtransferir != null) {
                plataforma.encolar(clienteAtransferir);
                return "Cliente [T-" + numeroTicket + "] transferido de Caja a Plataforma.";
            }
        } else if (origen.equalsIgnoreCase("plataforma") && destino.equalsIgnoreCase("caja")) {
            clienteAtransferir = plataforma.buscarYTransferir(numeroTicket);
            if (clienteAtransferir != null) {
                caja.encolar(clienteAtransferir);
                return "Cliente [T-" + numeroTicket + "] transferido de Plataforma a Caja.";
            }
        }
        return "Error: No se pudo realizar la transferencia. Verifique el número de ticket y las colas de origen y destino.";
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

    // --- NUEVA CLASE INTERNA PARA GESTIONAR PUESTOS ---
    private class PuestoAtencion {
        private int numero;
        private String tipo;
        private boolean ocupado;

        public PuestoAtencion(int numero, String tipo) {
            this.numero = numero;
            this.tipo = tipo;
            this.ocupado = false;
        }

        public String getNombre() {
            return tipo + " " + numero;
        }

        public boolean isOcupado() {
            return ocupado;
        }

        public void setOcupado(boolean ocupado) {
            this.ocupado = ocupado;
        }
    }
}