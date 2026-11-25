
public class Destinatario {

    String nombre;
    String apellido;
    String direccion;
    String ciudad;

    public Destinatario(String nombre, String apellido, String direccion, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Destinatario copiar() {
        return new Destinatario(nombre, apellido, direccion, ciudad);
    }
}
