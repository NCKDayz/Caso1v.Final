public class Proceso extends Thread {
    private int id = 0;
    private Buffer bufferEtapa1;
    private Buffer bufferEtapa2;
    private Buffer bufferEtapaFinal;
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

    private void etapa2()
    {
        while (bufferEtapa1.getTamanio() > 0)
        {
            if (tipo == "naranja")
            {
                Producto productoExtraido;
                while((productoExtraido = bufferEtapa1.extraerNaranja()) == null)
                {
                    Thread.yield();
                }
                bufferEtapa2.almacenarNaranja(productoExtraido);
            }
            else if (tipo == "azul")
            {
                Producto productoExtraido;
                productoExtraido = bufferEtapa1.extraerAzul();
                bufferEtapa2.almacenarAzul(productoExtraido);
            }
            else
            {
                System.out.println("ERROR: Tipo de producto no reconocido");
            }
        }
    }

    private void etapa3()
    {
        
    }

    public void run() {
        etapa1();
        etapa2();
        System.out.println("FIN PROCESO, tamaño del buffer " + tipo +" 1 es: " + bufferEtapa1.getTamanio());
        System.out.println("FIN PROCESO, tamaño del buffer " + tipo +" 2 es: " + bufferEtapa2.getTamanio());
    }
}
