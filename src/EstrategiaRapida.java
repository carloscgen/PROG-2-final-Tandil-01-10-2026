import java.util.Comparator;

public class EstrategiaRapida implements Comparator<Compra> {
    @Override
    public int compare(Compra c1, Compra c2) {
        return Double.compare(
                c1.getTiempoEstimadoEntrega(),
                c2.getTiempoEstimadoEntrega());
    }
}
