
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        System.out.println("Recu Prog 2");

        // =========================
        // DESTINATARIOS
        // =========================
        Destinatario juan = new Destinatario(
                "Juan",
                "Perez",
                "San Martin 500",
                "Tandil"
        );

        Destinatario ana = new Destinatario(
                "Ana",
                "Gomez",
                "Pinto 1200",
                "Tandil"
        );

        Destinatario pedro = new Destinatario(
                "Pedro",
                "Lopez",
                "Belgrano 300",
                "Azul"
        );

        // =========================
        // PRODUCTOS
        // =========================
        ArrayList<String> productos1 = new ArrayList<>();
        productos1.add("P001");
        productos1.add("P002");

        ArrayList<String> productos2 = new ArrayList<>();
        productos2.add("P003");
        productos2.add("P004");
        productos2.add("P005");
        productos2.add("P006");
        productos2.add("P007");
        productos2.add("P008");

        ArrayList<String> productos3 = new ArrayList<>();
        productos3.add("P009");

        // =========================
        // COMPRAS
        // =========================
        Compra compra1 = new Compra(
                juan,
                10,
                productos1,
                8
        );

        Compra compra2 = new Compra(
                ana,
                5,
                productos2,
                12
        );

        Compra compra3 = new Compra(
                pedro,
                3,
                productos3,
                4
        );

        // =========================
        // CONTENEDOR TANDIL
        // =========================
        Contenedor contenedorTandil
                = new Contenedor(new EstrategiaRapida());

        contenedorTandil.agregarElemento(compra1);
        contenedorTandil.agregarElemento(compra2);

        System.out.println("\n--- CONTENEDOR TANDIL ---");

        System.out.println(
                "Ciudad: "
                + contenedorTandil.getCiudadDestino()
        );

        System.out.println(
                "Tiempo estimado: "
                + contenedorTandil.getTiempoEstimadoEntrega()
        );

        System.out.println(
                "Entregado: "
                + contenedorTandil.isEntregado()
        );

        // =========================
        // ESTRATEGIA RAPIDA
        // =========================
        Compra siguiente
                = contenedorTandil.getSiguienteCompra();

        System.out.println("\n--- ESTRATEGIA RAPIDA ---");

        System.out.println(
                "Tiempo de la siguiente compra: "
                + siguiente.getTiempoEstimadoEntrega()
        );

        // =========================
        // CONTENEDOR ANIDADO
        // =========================
        Contenedor contenedorInterno
                = new Contenedor(new EstrategiaRapida());

        ArrayList<String> productos4 = new ArrayList<>();
        productos4.add("P010");

        Compra compra4 = new Compra(
                juan,
                2,
                productos4,
                3
        );

        contenedorInterno.agregarElemento(compra4);

        contenedorTandil.agregarElemento(contenedorInterno);

        System.out.println("\n--- RECURSIVIDAD ---");

        System.out.println(
                "Compras pendientes: "
                + contenedorTandil.getComprasPendientes().size()
        );

        System.out.println(
                "Siguiente compra (tiempo): "
                + contenedorTandil
                        .getSiguienteCompra()
                        .getTiempoEstimadoEntrega()
        );

        // =========================
        // COPIA CON CRITERIO
        // =========================
        Criterio masDe5Productos
                = new CriterioCantidad(5);

        Contenedor copia
                = contenedorTandil.copiar(masDe5Productos);

        System.out.println("\n--- COPIA: MAS DE 5 PRODUCTOS ---");

        System.out.println(
                "Compras en la copia: "
                + copia.getComprasPendientes().size()
        );

        // =========================
        // CRITERIO COMBINADO
        // =========================
        Criterio criterioCombinado
                = new CriterioCombinado(
                        new CriterioCiudad("Tandil"),
                        new CriterioComprasNoEntregadas()
                );

        Contenedor copiaCombinada
                = contenedorTandil.copiar(criterioCombinado);

        System.out.println("\n--- COPIA COMBINADA ---");

        System.out.println(
                "Compras Tandil no entregadas: "
                + copiaCombinada.getComprasPendientes().size()
        );

        // =========================
        // CIUDAD INCORRECTA
        // =========================
        System.out.println("\n--- PRUEBA CIUDAD INCORRECTA ---");

        try {
            contenedorTandil.agregarElemento(compra3);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "No se pudo agregar compra de Azul: "
                    + e.getMessage()
            );
        }

        // =========================
        // CONTENEDOR EXPRESS
        // =========================
        ContenedorExpress express
                = new ContenedorExpress(new EstrategiaRapida());

        express.agregarElemento(compra1);
        express.agregarElemento(compra2);

        System.out.println("\n--- EXPRESS ---");

        System.out.println(
                "Tiempo normal esperado: 12"
        );

        System.out.println(
                "Tiempo express esperado: 7"
        );

        System.out.println(
                "Tiempo express obtenido: "
                + express.getTiempoEstimadoEntrega()
        );
    }
}
