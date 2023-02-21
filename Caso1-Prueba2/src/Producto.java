public class Producto {
    Identificador id;
    String tipo;

    public Producto(Identificador id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id.getId();
    }

    public String getTipo() {
        return tipo;
    }
}
