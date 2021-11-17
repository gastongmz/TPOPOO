package negocio;

public class Estado {

    private Integer id;
    private String nombre;
    private String descripcion;

    /**
     * Constructor por Defecto.
     */
    public Estado() {
    }

    /**
     * Constructor con parámetros.
     * @param nombre
     * @param descripcion
     */
    public Estado(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}