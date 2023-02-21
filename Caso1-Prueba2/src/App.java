public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("INICIO");
        
        int cantidadProcesos = 3;
        int cantidadProductos = 10;
        int tamanioBuffer = 5;

        Buffer bufferNaranjaE1 = new Buffer(tamanioBuffer);
        Buffer bufferNaranjaE2 = new Buffer(tamanioBuffer);
        Buffer bufferNaranjaFinal = new Buffer(tamanioBuffer);

        Buffer bufferAzulE1 = new Buffer(tamanioBuffer);
        Buffer bufferAzulE2 = new Buffer(tamanioBuffer);
        Buffer bufferAzulFinal = new Buffer(tamanioBuffer);

        Proceso procesoNaranja1 = new Proceso(1, "naranja", cantidadProductos, bufferNaranjaE1, bufferNaranjaE2, bufferNaranjaFinal);
    }
}
