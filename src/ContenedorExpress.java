
import java.util.Comparator;

public class ContenedorExpress extends Contenedor {

    public ContenedorExpress(Comparator<Compra> estrategia) {
        super(estrategia);
    }

    protected ContenedorExpress crearCopia() {
        return new ContenedorExpress(super.getComparador());
    }

    @Override
    public double getTiempoEstimadoEntrega() {
        double tiempoNormal = super.getTiempoEstimadoEntrega();
        double tiempoExpress = tiempoNormal - 5;

        if (tiempoExpress < 1) {
            return 1;
        }

        return tiempoExpress;
    }
}
