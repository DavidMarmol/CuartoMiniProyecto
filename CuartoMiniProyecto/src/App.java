public class App {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Menu menu = new Menu(inventario);
        menu.mostrarMenu();
    }
}
