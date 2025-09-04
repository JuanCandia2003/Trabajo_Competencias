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

// Implementación manual de una cola con prioridad (preferencial y corriente)
class ColaAtencion {
    private Nodo frentePref;   // frente de preferenciales
    private Nodo finPref;      // fin de preferenciales
    private Nodo frenteCorr;   // frente de corrientes
    private Nodo finCorr;      // fin de corrientes

    public ColaAtencion() {
        frentePref = finPref = null;
        frenteCorr = finCorr = null;
    }

    // Agregar cliente
    public void encolar(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (cliente.preferencial) {
            if (finPref == null) {
                frentePref = finPref = nuevo;
            } else {
                finPref.siguiente = nuevo;
                finPref = nuevo;
            }
        } else {
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
        if (frentePref != null) {
            Cliente c = frentePref.cliente;
            frentePref = frentePref.siguiente;
            if (frentePref == null) finPref = null;
            return c;
        } else if (frenteCorr != null) {
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

// Clase Banco
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
                   (c.preferencial ? " (Preferencial)" : " (Corriente)");
        }
        return "No hay clientes en Caja.";
    }

    public String atenderPlataforma() {
        Cliente c = plataforma.desencolar();
        if (c != null) {
            return "Atendiendo en Plataforma: " + c.nombre + 
                   (c.preferencial ? " (Preferencial)" : " (Corriente)");
        }
        return "No hay clientes en Plataforma.";
    }
}