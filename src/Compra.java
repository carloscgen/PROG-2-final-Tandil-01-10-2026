
import java.util.ArrayList;
import java.util.List;

public class Compra implements Elemento {

    private List<String> identificadoresProductos;
    private Destinatario destinatario;
    private boolean entregado = false;
    private double tiempoEstimadoEntrega;
    private double distancia;

    public Compra(Destinatario destinatario, double distancia, List<String> identificadoresProductos, double tiempoEstimadoEntrega) {
        this.destinatario = destinatario;
        this.distancia = distancia;
        this.identificadoresProductos = identificadoresProductos;
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
    }

    public void marcarEntregado() {
        this.entregado = true;
    }

    @Override
    public boolean isEntregado() {
        return entregado;
    }

    @Override
    public double getTiempoEstimadoEntrega() {
        return tiempoEstimadoEntrega;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    @Override
    public String getCiudadDestino() {
        return destinatario.getCiudad();
    }

    public int cantidadProductos() {
        return identificadoresProductos.size();
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public Compra copiar(Criterio criterio) {
        if (!criterio.cumple(this)) {
            return null;
        }

        List<String> copiaIdentificadores
                = new ArrayList<>(identificadoresProductos);

        Compra copia = new Compra(
                destinatario.copiar(),
                distancia,
                copiaIdentificadores,
                tiempoEstimadoEntrega
        );

        if (entregado) {
            copia.marcarEntregado();
        }

        return copia;
    }

    @Override
    public ArrayList<Compra> getComprasPendientes() {
        ArrayList<Compra> resultado = new ArrayList<>();

        if (!isEntregado()) {
            resultado.add(this);
        }

        return resultado;
    }
}
