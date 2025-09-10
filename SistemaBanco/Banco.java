
public class Banco {
    public ColaAtencion caja1;
    public ColaAtencion caja2;
    public ColaAtencion plataforma;
    public ColaAtencion credito;
    public ColaAtencion informaciones;



     // Contadores de atención
    private int[] atendidos = new int[4];        // 0=caja, 1=plataforma, 2=credito, 3=informaciones
    private int[] preferenciales = new int[4];


    public Banco() {
        caja1 = new ColaAtencion();
        caja2 = new ColaAtencion();
        plataforma = new ColaAtencion();
        credito = new ColaAtencion();
        informaciones = new ColaAtencion();

        caja1.encolar(new Cliente("Ana", false));
        caja1.encolar(new Cliente("Carlos", true));

        caja2.encolar(new Cliente("Beatriz", false));

        plataforma.encolar(new Cliente("David", true));
        plataforma.encolar(new Cliente("Elena", false));

        credito.encolar(new Cliente("Fernando", false));

        informaciones.encolar(new Cliente("Gabriela", false));
        informaciones.encolar(new Cliente("Hugo", true));


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
            atendidos[0]++;
            if (c.preferencial) preferenciales[0]++;
            return "Atendiendo en Caja: " + numCaja + "[CA-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Caja.";
    }

    public String atenderPlataforma() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            atendidos[1]++;
            if (c.preferencial) preferenciales[1]++;
            return "Atendiendo en Plataforma: " + "[PT-" + c.numero +"] "+ c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Plataforma.";
    }

    public String atenderCredito() {
    Cliente c = credito.desencolar();
    if (c != null) {
        atendidos[2]++;
        if (c.preferencial) preferenciales[2]++;
        return "Atendiendo en Crédito: [CR-" + c.numero + "] " + c.nombre +
               (c.preferencial ? " (Preferencial)" : " (Corriente)");
    }
    return "No hay clientes en Crédito.";
}

    public String atenderInformaciones() {
    Cliente c = informaciones.desencolar();
    if (c != null) {
        atendidos[3]++;
        if (c.preferencial) preferenciales[3]++;
        return "Atendiendo en Informaciones: [IF-" + c.numero + "] " + c.nombre +
               (c.preferencial ? " (Preferencial)" : " (Corriente)");
    }
    return "No hay clientes en Informaciones.";
}


    public String finalizarAtencion(String tipoPuesto, int numeroPuesto) {
    return "Puesto " + tipoPuesto + " número " + numeroPuesto + " liberado.";
    }

    public void mostrarColas() {
    System.out.println("Cola de Caja 1:");
    caja1.mostrarCola();
    System.out.println("\nCola de Caja 2:");
    caja2.mostrarCola();
    System.out.println("\nCola de Plataforma:");
    plataforma.mostrarCola();
    System.out.println("\nCola de Crédito:");
    credito.mostrarCola();
    System.out.println("\nCola de Informaciones:");
    informaciones.mostrarCola();
}

    public void imprimirResumen() {
    String[] nombres = {"Caja", "Plataforma", "Crédito", "Informaciones"};
    imprimirResumenRecursivo(nombres, 0);
    System.out.println("════════════════════════════════════");
}

    public void imprimirResumenRecursivo(String[] nombres, int index) {
    if (index >= nombres.length) return; // caso base (ya recorrimos todos)

    System.out.println("- " + nombres[index] + " atendió " + atendidos[index] + 
                       " clientes (" + preferenciales[index] + " preferenciales).");

    imprimirResumenRecursivo(nombres, index + 1); // llamada recursiva
}


    
}



