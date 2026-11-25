import java.util.Comparator;

public class EstrategiaEcologica implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2) {
        return Double.compare(
                c1.getDistancia(),
                c2.getDistancia());
    }
}
