class Cliente {

    public static int contadorTickets = 1;
    public int numero;
    public String nombre;
    public boolean preferencial;

    public Cliente(String nombre, boolean preferencial) {
        this.nombre = nombre;
        this.preferencial = preferencial;
        this.numero = contadorTickets++;
    }
}