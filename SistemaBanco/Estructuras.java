// Implementación la cola (preferencial y corriente
import java.util.ArrayList;
import java.util.List;
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
    System.out.println("Clientes preferenciales:");
    mostrarColaRecursiva(frentePref);
    System.out.println("Clientes corrientes:");
    mostrarColaRecursiva(frenteCorr);

}
    public void mostrarColaRecursiva(Nodo nodo) {
    if (nodo == null) return; // caso base
    System.out.println(nodo.cliente.nombre + " [Ficha: " + nodo.cliente.numero + "]" +
                       (nodo.cliente.preferencial ? " (Preferencial)" : " (Corriente)"));
    mostrarColaRecursiva(nodo.siguiente); // llamada recursiva
}

    public List<Cliente> aLista() {
    List<Cliente> lista = new ArrayList<>();
        Nodo actual = frentePref;
        while (actual != null) {
            lista.add(actual.cliente);
            actual = actual.siguiente;
        }
        actual = frenteCorr;
        while (actual != null) {
            lista.add(actual.cliente);
            actual = actual.siguiente;
        }
        return lista;
    }

    // QuickSort aplicado a la lista de clientes
    public List<Cliente> ordenarClientes() {
    List<Cliente> lista = aLista();
    quickSort(lista, 0, lista.size() - 1);
    return lista;
    }

    private void quickSort(List<Cliente> lista, int low, int high) {
        if (low < high) {
            int pi = partition(lista, low, high);
            quickSort(lista, low, pi - 1);
            quickSort(lista, pi + 1, high);
        }
    }

    private int partition(List<Cliente> lista, int low, int high) {
        String pivot = lista.get(high).getNombre();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (lista.get(j).getNombre().compareToIgnoreCase(pivot) <= 0) {
                i++;
                Cliente temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        Cliente temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);

        return i + 1;
    }

    // Mostrar clientes ordenados
    public void mostrarOrdenados() {
        List<Cliente> lista = ordenarClientes();
        for (Cliente c : lista) {
            System.out.println(c.getNombre() + " [Ficha: " + c.numero + "]" +
                               (c.preferencial ? " (Preferencial)" : " (Corriente)"));
        }
    }
}

 

