class Cliente {
    
    public String nombre;
    public boolean preferencial;
    public static int contadorTickets = 1;
    public int numero;

    public Cliente(String nombre, boolean preferencial) {
        this.nombre = nombre;
        this.preferencial = preferencial;
        this.numero = contadorTickets++;
    }

    public String getNombre() {
        return nombre;
    }
}

