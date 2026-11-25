
import java.util.List;

public interface Elemento {

    boolean isEntregado();

    String getCiudadDestino();

    double getTiempoEstimadoEntrega();

    List<Compra> getComprasPendientes();

    Elemento copiar(Criterio criterio);
}
