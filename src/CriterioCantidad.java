
public class CriterioCantidad implements Criterio {

    private int cantidad;

    public CriterioCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean cumple(Compra compra) {
        return compra.cantidadProductos() > cantidad;
    }

}
