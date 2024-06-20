import java.io.*;
import java.util.HashMap;

public class Inventario {
    private HashMap<String, Producto> inventario;
    private String archivo;

    public Inventario(String archivo) {
        this.inventario = new HashMap<>();
        this.archivo = archivo;
        cargarInventarioDesdeArchivo();
    }

    public void agregarProducto(String codigo, int cantidad, String ubicacion) {
        if (existeProducto(codigo)) {
            System.out.println("Error: Ya existe un producto con el código " + codigo);
        } else {
            Producto nuevoProducto = new Producto(codigo, cantidad, ubicacion);
            inventario.put(codigo, nuevoProducto);
            guardarInventarioEnArchivo();
        }
    }

    public void eliminarProducto(String codigo) {
        inventario.remove(codigo);
        guardarInventarioEnArchivo();
    }

    public Producto buscarProducto(String codigo) {
        return inventario.get(codigo);
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Inventario Vacío");
        } else {
            for (Producto producto : inventario.values()) {
                System.out.println("Código: " + producto.getCodigo() + ", Cantidad: " + producto.getCantidad() + ", Ubicación: " + producto.getUbicacion());
            }
        }
    }

    private void cargarInventarioDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    String[] partes = linea.split(" , ");
                    if (partes.length == 3) {
                        String codigo = partes[0].split(": ")[1];
                        int cantidad = Integer.parseInt(partes[1].split(": ")[1]);
                        String ubicacion = partes[2].split(": ")[1];
                        if (!existeProducto(codigo)) {
                            inventario.put(codigo, new Producto(codigo, cantidad, ubicacion));
                        } else {
                            System.out.println("Producto duplicado encontrado en el archivo: " + codigo);
                        }
                    } else {
                        System.out.println("Línea con formato incorrecto: " + linea);
                    }
                } catch (Exception e) {
                    System.out.println("Error al procesar la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario desde el archivo: " + e.getMessage());
        }
    }

    public void guardarInventarioEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : inventario.values()) {
                writer.write("codigo: " + producto.getCodigo() + " , cantidad: " + producto.getCantidad() + " , posicion: " + producto.getUbicacion());
                writer.newLine();
            }
            System.out.println("Inventario guardado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    private boolean existeProducto(String codigo) {
        return inventario.containsKey(codigo);
    }
}
