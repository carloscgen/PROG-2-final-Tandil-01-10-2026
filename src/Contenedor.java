
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Contenedor implements Elemento {

    private ArrayList<Elemento> elementos;
    private Comparator<Compra> comparador;

    public Contenedor(Comparator<Compra> comparador) {
        this.elementos = new ArrayList<>();
        this.comparador = comparador;
    }

    protected Comparator<Compra> getComparador() {
        return this.comparador;
    }

    @Override
    public boolean isEntregado() {
        for (Elemento elemento : elementos) {
            if (!elemento.isEntregado()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCiudadDestino() {
        if (elementos.isEmpty()) {
            return null;
        }

        return elementos.get(0).getCiudadDestino();
    }

    @Override
    public double getTiempoEstimadoEntrega() {
        double tiempoMaximo = 0;

        for (Elemento elemento : elementos) {
            if (elemento.getTiempoEstimadoEntrega() > tiempoMaximo) {
                tiempoMaximo = elemento.getTiempoEstimadoEntrega();
            }
        }

        return tiempoMaximo;
    }

    public void agregarElemento(Elemento elemento) {
        if (elementos.isEmpty()) {
            elementos.add(elemento);
            return;
        }

        if (!elemento.getCiudadDestino().equals(getCiudadDestino())) {
            throw new IllegalArgumentException(
                    "Todos los elementos deben tener la misma ciudad de destino.");
        }

        elementos.add(elemento);
    }

    @Override
    public List<Compra> getComprasPendientes() {
        List<Compra> resultado = new ArrayList<>();

        for (Elemento elemento : elementos) {
            resultado.addAll(elemento.getComprasPendientes());
        }

        return resultado;
    }

    public Compra getSiguienteCompra() {
        List<Compra> comprasPendientes = getComprasPendientes();

        if (comprasPendientes.isEmpty()) {
            return null;
        }

        return Collections.min(comprasPendientes, comparador);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    protected Contenedor crearCopia() {
        return new Contenedor(this.comparador);
    }

    @Override
    public Contenedor copiar(Criterio criterio) {

        Contenedor copia = crearCopia();

        for (Elemento elemento : elementos) {

            Elemento copiaElemento = elemento.copiar(criterio);

            if (copiaElemento != null) {
                copia.agregarElemento(copiaElemento);
            }
        }

        if (copia.isEmpty()) {
            return null;
        }

        return copia;
    }
}
