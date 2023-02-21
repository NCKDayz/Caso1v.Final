public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("INICIO");
        
        int cantidadProcesos = 3;
        int cantidadProductos = 5;
        int tamanioBuffer = 5;

        Buffer bufferNaranjaE1 = new Buffer(tamanioBuffer);
        Buffer bufferNaranjaE2 = new Buffer(tamanioBuffer);
        

        Buffer bufferAzulE1 = new Buffer(tamanioBuffer);
        Buffer bufferAzulE2 = new Buffer(tamanioBuffer);
        
        Buffer bufferRojo = new Buffer(200);

        Proceso procesoNaranja = new Proceso(1, "naranja", cantidadProductos, bufferNaranjaE1, bufferNaranjaE2, bufferRojo);
        Proceso procesoAzul = new Proceso(1, "azul", cantidadProductos, bufferAzulE1, bufferAzulE2, bufferRojo);

        procesoNaranja.start();
        procesoAzul.start();
    }
}
