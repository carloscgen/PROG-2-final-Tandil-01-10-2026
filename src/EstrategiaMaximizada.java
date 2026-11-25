import java.util.Comparator;

public class EstrategiaMaximizada implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2) {
        return Integer.compare(
                c2.cantidadProductos(),
                c1.cantidadProductos());
    }
}
