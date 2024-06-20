import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Inventario inventario;

    public Menu(Inventario inventario) {
        this.inventario = inventario;
    }

    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n========== MENU ==========");
                System.out.println("1. Agregar Producto.");
                System.out.println("2. Buscar Producto.");
                System.out.println("3. Mostrar Inventario.");
                System.out.println("4. Eliminar Producto.");
                System.out.println("5. Salir.");
                System.out.print("Seleccione Una Opción: ");

                int opcion;
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                } catch (InputMismatchException e) {
                    System.out.println("ERROR - Ingrese Un Número Válido.");
                    scanner.nextLine();  // Limpiar el buffer de entrada
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese El Código Del Producto: ");
                        String codigo = scanner.nextLine();

                        int cantidad;
                        while (true) {
                            System.out.print("Ingrese La Cantidad Del Producto: ");
                            try {
                                cantidad = scanner.nextInt();
                                scanner.nextLine();  // Consumir la nueva línea
                                if (cantidad <= 0) {
                                    System.out.println("Ingrese una cantidad correcta (mayor que 0).");
                                    continue;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Ingrese una cantidad correcta.");
                                scanner.nextLine();  // Limpiar el buffer de entrada
                            }
                        }

                        System.out.print("Ingrese La Ubicación Del Producto: ");
                        String ubicacion = scanner.nextLine();
                        inventario.agregarProducto(codigo, cantidad, ubicacion);
                        break;
                    case 2:
                        System.out.print("Ingrese El Código Del Producto A Buscar: ");
                        String codigoBuscar = scanner.nextLine().trim(); // Trim para eliminar espacios en blanco
                        if (codigoBuscar.isEmpty()) {
                            System.out.println("Error: El código del producto no puede estar vacío.");
                            break;
                        }
                        Producto producto = inventario.buscarProducto(codigoBuscar);
                        if (producto != null) {
                            System.out.println("Producto Encontrado - Código: " + producto.getCodigo() + ", Cantidad: " + producto.getCantidad() + ", Ubicación: " + producto.getUbicacion());
                        } else {
                            System.out.println("Producto NO Encontrado.");
                        }
                        break;
                    case 3:
                        inventario.mostrarInventario();
                        break;
                    case 4:
                        System.out.print("Ingrese El Código Del Producto A Eliminar: ");
                        String codigoEliminar = scanner.nextLine().trim(); // Trim para eliminar espacios en blanco
                        if (codigoEliminar.isEmpty()) {
                            System.out.println("Error: El código del producto no puede estar vacío.");
                            break;
                        }
                        inventario.eliminarProducto(codigoEliminar);
                        break;
                    case 5:
                        inventario.guardarInventarioEnArchivo();
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción Inválida. Intente De Nuevo.");
                }
            }
        }
    }
}
