
public class CriterioCiudad implements Criterio {

    private String ciudad;

    public CriterioCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean cumple(Compra compra) {
        return compra.getCiudadDestino().equalsIgnoreCase(ciudad);
    }

}
