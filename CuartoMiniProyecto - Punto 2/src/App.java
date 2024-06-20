public class App {
    public static void main(String[] args) {
        String nombreArchivo = "inventario.txt";
        Inventario inventario = new Inventario(nombreArchivo);
        Menu menu = new Menu(inventario);
        menu.mostrarMenu();
    }
}
