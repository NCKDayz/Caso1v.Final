import java.util.ArrayList;

public class Buffer {
    private ArrayList<Producto> buff;
    private int tamanio;

    public Buffer(int tamanio) {
        this.tamanio = tamanio;
        this.buff = new ArrayList<Producto>();
    }
    
    public synchronized Boolean almacenarNaranja(Producto p) {
        System.out.println("INICIO ALMACENAR NARANJA - Buffer naranja es " + buff.size());
        if (buff.size() == tamanio) {
            return false;
        }
        buff.add(p);
        System.out.println("FIN ALMACENAR NARANJA - Buffer naranja es " + buff.size());
        return true;
    }

    public synchronized void almacenarAzul(Producto p) {
        System.out.println("INICIO ALMACENAR AZUL - Buffer naranja es " + buff.size());
        while (buff.size() == tamanio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buff.add(p);
        notify();
        System.out.println("FIN ALMACENAR AZUL - Buffer naranja es " + buff.size());
    }

    public synchronized void almacenarRojo(Producto p) {
    }

}
