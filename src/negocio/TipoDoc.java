package negocio;

public class TipoDoc {

    private Integer id;
    private String nombre;
    private String abreviatura;

    /**
     * Constructor por Defecto.
     */
    public TipoDoc() {
    }

    /**
     * Constructor con parametros.
     * @param nombre
     * @param abreviatura
     */
    public TipoDoc(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }


}
