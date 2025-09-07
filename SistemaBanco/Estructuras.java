// Nodo de la cola
class Nodo {
     Cliente cliente;
     Nodo siguiente;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}

// Clase Cliente
class Cliente {
    String nombre;
    boolean preferencial;

    public Cliente(String nombre, boolean preferencial) {
        this.nombre = nombre;
        this.preferencial = preferencial;
    }
}

// Implementación la cola (preferencial y corriente)
class ColaAtencion {
    private Nodo frentePref;
    private Nodo finPref;   
    private Nodo frenteCorr;
    private Nodo finCorr;      

    public ColaAtencion() {
        frentePref = finPref = null;
        frenteCorr = finCorr = null;
    }

    // Agregar cliente
    public void encolar(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (cliente.preferencial) { //Si el cliente es preferencial va primero 
            if (finPref == null) {
                frentePref = finPref = nuevo;
            } else {
                finPref.siguiente = nuevo;
                finPref = nuevo;
            }
        } else { // si no es preferencial entonces procede a agregarlo a la fila
            if (finCorr == null) {
                frenteCorr = finCorr = nuevo;
            } else {
                finCorr.siguiente = nuevo;
                finCorr = nuevo;
            }
        }
    }

    // Atender cliente (preferenciales primero)
    public Cliente desencolar() {
        if (frentePref != null) { //revisa si hay clientes prefetenciales
            Cliente c = frentePref.cliente;
            frentePref = frentePref.siguiente;
            if (frentePref == null) finPref = null;
            return c;
        } else if (frenteCorr != null) { // empieza a atender a los clientes corrientes
            Cliente c = frenteCorr.cliente;
            frenteCorr = frenteCorr.siguiente;
            if (frenteCorr == null) finCorr = null;
            return c;
        }
        return null;
    }

    // Verificar si no hay clientes
    public boolean estaVacia() {
        return frentePref == null && frenteCorr == null;
    }
}

// Crea el Banco
class Banco {
    private ColaAtencion caja;
    private ColaAtencion plataforma;

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
            return "Atendiendo en Caja: " + c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Caja.";
    }

    public String atenderPlataforma() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            return "Atendiendo en Plataforma: " + c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)"); // ?-> es como un if para mostrar si es preferencial o no
        }
        return "No hay clientes en Plataforma.";
    }
}