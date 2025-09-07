public class Nodo {
    public Cliente cliente;
    public Nodo siguiente;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}