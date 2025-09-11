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

    // Heapsort aplicado a la lista de clientes
    public List<Cliente> ordenarCliente() {
    List<Cliente> lista = aLista();
    heapSort(lista);
    return lista;
}

private void heapSort(List<Cliente> lista) {
    int n = lista.size();

    // Construir el heap (reordenar lista)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(lista, n, i);
    }

    // Extraer elementos del heap uno por uno
    for (int i = n - 1; i > 0; i--) {
        // Intercambiar el primero (máximo) con el último
        Cliente temp = lista.get(0);
        lista.set(0, lista.get(i));
        lista.set(i, temp);

        // Llamar heapify al heap reducido
        heapify(lista, i, 0);
    }
}

private void heapify(List<Cliente> lista, int n, int i) {
    int largest = i;      // Inicializar el mayor como raíz
    int left = 2 * i + 1; // hijo izquierdo
    int right = 2 * i + 2;// hijo derecho

    // Comparar hijos con el mayor (por nombre)
    if (left < n && lista.get(left).getNombre()
            .compareToIgnoreCase(lista.get(largest).getNombre()) > 0) {
        largest = left;
    }

    if (right < n && lista.get(right).getNombre()
            .compareToIgnoreCase(lista.get(largest).getNombre()) > 0) {
        largest = right;
    }

    // Si el mayor no es la raíz
    if (largest != i) {
        Cliente swap = lista.get(i);
        lista.set(i, lista.get(largest));
        lista.set(largest, swap);

        // Recursivamente heapify el subárbol afectado
        heapify(lista, n, largest);
    }
}


    // Mostrar clientes ordenados
    public void mostrarOrdenados() {
        List<Cliente> lista = ordenarCliente();
        for (Cliente c : lista) {
            System.out.println(c.getNombre() + " [Ficha: " + c.numero + "]" +
                               (c.preferencial ? " (Preferencial)" : " (Corriente)"));
        }
    }
}

 

