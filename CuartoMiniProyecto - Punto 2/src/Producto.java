public class Producto {
    private String codigo;
    private int cantidad;
    private String ubicacion;

    public Producto(String codigo, int cantidad, String ubicacion) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
