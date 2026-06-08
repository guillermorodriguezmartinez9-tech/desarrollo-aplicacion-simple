class Videojuego {
    // 1. Atributos privados
    private String titulo;
    private String plataforma;
    private double precio;

    // 2. Constructor (Las asignaciones van DENTRO de las llaves)
    public Videojuego(String titulo, String plataforma, double precio) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    // 3. Métodos de comportamiento
    public void mostrarInformation() {
        System.out.println("-----------------------------------");
        System.out.println("Título: " + this.titulo);
        System.out.println("Plataforma: " + this.plataforma);
        System.out.println("Precio: $" + this.precio);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            double descuento = this.precio * (porcentaje / 100);
            this.precio -= descuento;
            System.out.println("¡Se aplicó un descuento del " + porcentaje + "% a " + this.titulo + "!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE VIDEOJUEGOS ===");

        // 4. Instanciación de objetos independientes
        Videojuego juego1 = new Videojuego("Pokémon Scarlet", "Nintendo Switch", 1200.00);
        Videojuego juego2 = new Videojuego("MLB The Show 24", "PlayStation 5", 1400.00);
        Videojuego juego3 = new Videojuego("WWE 2K24", "Xbox Series X", 1500.00);

        juego1.mostrarInformation();
        juego2.mostrarInformation();
        juego3.mostrarInformation();

        System.out.println("\n=== APLICANDO OFERTAS ESPECIALES ===");
        juego3.aplicarDescuento(15); 
        juego3.mostrarInformation();
    }
}