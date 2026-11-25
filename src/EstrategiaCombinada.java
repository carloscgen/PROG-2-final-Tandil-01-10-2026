
import java.util.Comparator;

public class EstrategiaCombinada implements Comparator<Compra> {

    private Comparator<Compra> principal;
    private Comparator<Compra> desempate;

    public EstrategiaCombinada(Comparator<Compra> principal, Comparator<Compra> desempate) {
        this.principal = principal;
        this.desempate = desempate;
    }

    @Override
    public int compare(Compra compra1, Compra compra2) {
        int resultado = principal.compare(compra1, compra2);

        if (resultado != 0) {
            return resultado;
        }

        return desempate.compare(compra1, compra2);
    }
}
