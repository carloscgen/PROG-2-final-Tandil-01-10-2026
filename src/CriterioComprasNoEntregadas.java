
public class CriterioComprasNoEntregadas implements Criterio {

    @Override
    public boolean cumple(Compra compra) {
        return !compra.isEntregado();
    }
}
