import java.util.ArrayList;
import java.util.List;

// 1. INTERFAZ
interface Promocionable {
    void aplicarDescuento(double porcentaje);
}

// 2. CLASE ABSTRACTA
abstract class Producto {
    private String id;
    private String nombre;
    protected double precio;
    private int stock;

    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public abstract double calcularPrecioFinal();

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public void mostrarDetalles() {
        System.out.println("[" + id + "] " + nombre + " | Stock: " + stock + " | Precio Base: $" + precio);
    }
}

// 3. SUBCLASE ELECTRONICO
class ProductoElectronico extends Producto {
    private int mesesGarantia;

    public ProductoElectronico(String id, String nombre, double precio, int stock, int mesesGarantia) {
        super(id, nombre, precio, stock);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precio * 1.16; // +16% IVA
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("-> Tipo: Electrónico | Garantía: " + mesesGarantia + " meses | Con IVA: $" + calcularPrecioFinal());
    }
}

// 4. SUBCLASE PERECEDERO
class ProductoPerecedero extends Producto implements Promocionable {
    private int diasParaCaducar;

    public ProductoPerecedero(String id, String nombre, double precio, int stock, int diasParaCaducar) {
        super(id, nombre, precio, stock);
        this.diasParaCaducar = diasParaCaducar;
    }

    @Override
    public double calcularPrecioFinal() {
        if (diasParaCaducar <= 3) {
            return this.precio * 0.5; // 50% descuento si va a caducar
        }
        return this.precio;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precio -= (this.precio * (porcentaje / 100));
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("-> Tipo: Perecedero | Días para caducar: " + diasParaCaducar + " | Precio Final: $" + calcularPrecioFinal());
    }
}

// 5. GESTIÓN DE INVENTARIO
class Inventario {
    private List<Producto> listaProductos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void mostrarInventario() {
        System.out.println("=== INVENTARIO COMPLETO ===");
        for (Producto p : listaProductos) {
            p.mostrarDetalles();
            System.out.println("-----------------------------------");
        }
    }
}

// 6. CLASE PRINCIPAL (Única pública, el archivo DEBE llamarse Main.java)
public class Main {
    public static void main(String[] args) {
        Inventario miInventario = new Inventario();

        Producto laptop = new ProductoElectronico("E101", "Laptop Gamer", 15000.0, 5, 12);
        Producto leche = new ProductoPerecedero("P201", "Leche 1L", 25.0, 20, 2);

        miInventario.agregarProducto(laptop);
        miInventario.agregarProducto(leche);

        miInventario.mostrarInventario();
    }
}