// Implementación la cola (preferencial y corriente
// Implementación de la cola (preferencial y corriente)
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
            if (frentePref == null)
                finPref = null;
            return c;
        } else if (frenteCorr != null) {
            Cliente c = frenteCorr.cliente;
            frenteCorr = frenteCorr.siguiente;
            if (frenteCorr == null)
                finCorr = null;
            return c;
        }
        return null;
    }

    // Verificar si no hay clientes
    public boolean estaVacia() {
        return frentePref == null && frenteCorr == null;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo actual = frentePref;
        while (actual != null) {
            String sufijo = actual.cliente.preferencial ? "P" : "";
            System.out.print("[T-" + actual.cliente.numero + sufijo + "] " + actual.cliente.nombre + " -> ");
            actual = actual.siguiente;
        }
        actual = frenteCorr;
        while (actual != null) {
            String sufijo = actual.cliente.preferencial ? "P" : "";
            System.out.print("[T-" + actual.cliente.numero + sufijo + "] " + actual.cliente.nombre + " -> ");
            actual = actual.siguiente;
        }
    }

    // --- NUEVO MÉTODO PARA TRANSFERIR CLIENTES ---
    public Cliente buscarYTransferir(int numeroTicket) {
        // Busca en la cola de preferenciales
        if (frentePref != null) {
            if (frentePref.cliente.numero == numeroTicket) {
                Cliente c = frentePref.cliente;
                frentePref = frentePref.siguiente;
                if (frentePref == null)
                    finPref = null;
                return c;
            }
            Nodo actual = frentePref;
            while (actual.siguiente != null && actual.siguiente.cliente.numero != numeroTicket) {
                actual = actual.siguiente;
            }
            if (actual.siguiente != null) {
                Cliente c = actual.siguiente.cliente;
                actual.siguiente = actual.siguiente.siguiente;
                return c;
            }
        }

        // Si no está, busca en la cola de corrientes
        if (frenteCorr != null) {
            if (frenteCorr.cliente.numero == numeroTicket) {
                Cliente c = frenteCorr.cliente;
                frenteCorr = frenteCorr.siguiente;
                if (frenteCorr == null)
                    finCorr = null;
                return c;
            }
            Nodo actual = frenteCorr;
            while (actual.siguiente != null && actual.siguiente.cliente.numero != numeroTicket) {
                actual = actual.siguiente;
            }
            if (actual.siguiente != null) {
                Cliente c = actual.siguiente.cliente;
                actual.siguiente = actual.siguiente.siguiente;
                return c;
            }
        }
        return null;
    }
}