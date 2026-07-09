class Videojuego {
    protected String titulo;
    protected String plataforma;
    protected double precio;

    public Videojuego(String titulo, String plataforma, double precio) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public void mostrarInformation() {
        System.out.println("Juego: " + this.titulo + " | " + this.plataforma + " | $" + this.precio);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precio -= this.precio * (porcentaje / 100);
        }
    }
}

class VideojuegoDigital extends Videojuego {
    private double tamanoGB;

    public VideojuegoDigital(String titulo, String plataforma, double precio, double tamanoGB) {
        super(titulo, plataforma, precio);
        this.tamanoGB = tamanoGB;
    }

    public void descargarJuego() {
        System.out.println("Descargando " + this.titulo + " (" + this.tamanoGB + " GB)");
    }

    @Override
    public void mostrarInformation() {
        super.mostrarInformation();
        System.out.println("Formato: Digital");
    }
}

class VideojuegoFisico extends Videojuego {
    private String condicion;

    public VideojuegoFisico(String titulo, String plataforma, double precio, String condicion) {
        super(titulo, plataforma, precio);
        this.condicion = condicion;
    }

    public void prepararEnvio() {
        System.out.println("Empaquetando disco de " + this.titulo);
    }

    @Override
    public void mostrarInformation() {
        super.mostrarInformation();
        System.out.println("Formato: Fisico | Condicion: " + this.condicion);
    }
}

public class Main {
    public static void main(String[] args) {
        VideojuegoDigital juego1 = new VideojuegoDigital("Fortnite", "PS5", 450.0, 48.5);
        VideojuegoFisico juego2 = new VideojuegoFisico("MLB The Show 24", "PS5", 1400.0, "Nuevo");

        juego1.mostrarInformation();
        juego1.descargarJuego();

        juego2.mostrarInformation();
        juego2.aplicarDescuento(20);
        juego2.mostrarInformation();
    }
}