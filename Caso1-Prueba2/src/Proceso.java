public class Proceso extends Thread {
    private int id = 0;
    static private Buffer bufferEtapa1;
    static private Buffer bufferEtapa2;
    static private Buffer bufferEtapaFinal;
    private String tipo;
    static private int cantidadProductos;

    public Proceso(int id, String tipo, int cantidadProductos, Buffer bufferEtapa1, Buffer bufferEtapa2, Buffer bufferEtapaFinal) {
        this.id = id;
        this.tipo = tipo;
        this.cantidadProductos = cantidadProductos;
        this.bufferEtapa1 = bufferEtapa1;
        this.bufferEtapa2 = bufferEtapa2;
        this.bufferEtapaFinal = bufferEtapaFinal;
    }

    private void etapa1() {
        for (Integer i = 0; i < cantidadProductos; i++) {
            Producto productoNuevo = new Producto(new Identificador(id), tipo);
            if (tipo == "naranja") {
                while (!bufferEtapa1.almacenarNaranja(productoNuevo)) 
                {
                    Thread.yield();
                }
            } else if (tipo == "azul") 
            {
                bufferEtapa1.almacenarAzul(productoNuevo);
            }
            else 
            {
                System.out.println("ERROR: Tipo de producto no reconocido");
            }
        }
    }

    public void run() {
        etapa1();
    }
}
