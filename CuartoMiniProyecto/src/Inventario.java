import java.util.HashMap;

class Inventario {
    private HashMap<String, Producto> inventario;

    public Inventario() {
        this.inventario = new HashMap<>();
    }

    public void agregarProducto(String codigo, int cantidad) {
        if (inventario.containsKey(codigo)) {
            Producto productoExistente = inventario.get(codigo);
            productoExistente.setCantidad(productoExistente.getCantidad() + cantidad);
        } else {
            Producto nuevoProducto = new Producto(codigo, cantidad);
            inventario.put(codigo, nuevoProducto);
        }
    }

    public Producto buscarProducto(String codigo) {
        return inventario.get(codigo);
    }

    public void mostrarInventario() {
        for (Producto producto : inventario.values()) {
            System.out.println("Código: " + producto.getCodigo() + ", Cantidad: " + producto.getCantidad());
        }
    }
}