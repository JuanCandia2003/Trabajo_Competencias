// Implementación la cola (preferencial y corriente
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


}