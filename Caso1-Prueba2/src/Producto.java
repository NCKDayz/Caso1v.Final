public class Producto {
    Identificador id;
    String tipo;

    public Producto(Identificador id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Identificador getId() {
        return id;
    }

    public void setId(Identificador id) {
        this.id = id;
    }
}
