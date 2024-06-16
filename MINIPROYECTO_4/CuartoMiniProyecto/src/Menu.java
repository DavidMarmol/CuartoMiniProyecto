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
                System.out.println("4. Salir.");
                System.out.print("Ingrese La Opcion: ");

                int opcion;
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                } catch (InputMismatchException e) {
                    System.out.println("ERROR - ingrese Un Numero Valido.");
                    scanner.nextLine();  // Limpiar el buffer de entrada
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese El Código Del Producto: ");
                        String codigo = scanner.nextLine();
                        System.out.print("Ingrese La Cantidad Del Producto: ");
                        int cantidad = scanner.nextInt();
                        inventario.agregarProducto(codigo, cantidad);
                        break;
                    case 2:
                        System.out.print("Ingrese El Codigo Del Producto A Buscar: ");
                        String codigoBuscar = scanner.nextLine();
                        Producto producto = inventario.buscarProducto(codigoBuscar);
                        if (producto != null) {
                            System.out.println("Producto Encontrado - Codigo: " + producto.getCodigo() + ", Cantidad: " + producto.getCantidad());
                        } else {
                            System.out.println("Producto NO Encontrado.");
                        }
                        break;
                    case 3:
                        inventario.mostrarInventario();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opcion Invalida. Intente De nuevo.");
                }
            }
        }
    }
}
