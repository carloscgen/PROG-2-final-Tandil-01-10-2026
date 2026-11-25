
public class CriterioCombinado implements Criterio {

    private Criterio criterio1;
    private Criterio criterio2;

    public CriterioCombinado(Criterio criterio1, Criterio criterio2) {
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
    }

    @Override
    public boolean cumple(Compra compra) {
        return criterio1.cumple(compra) && criterio2.cumple(compra);
    }

}
