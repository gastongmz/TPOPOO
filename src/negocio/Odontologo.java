package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Odontologo  implements Serializable {

    private int nroOdontologo;
    private String apellido;
    private String domicilio;
    private String nombre;
    private Date fechaNacimiento;
    private int nroDocumento;
    private String nroMatricula;
    private List<DefinicionAgenda> definicionesAgenda;
    private List<Agenda> agendas;
    private TipoDoc tipoDoc;

    /**
     * Constructor por Defecto.
     */
    public Odontologo() {
        this.agendas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros, sin incluir atributos referenciales.
     * @param apellido
     * @param domicilio
     * @param nombre
     * @param fechaNacimiento
     * @param nroDocumento
     * @param nroMatricula
     * @param tipoDoc
     */
    public Odontologo(int nroOdontologo, String apellido, String domicilio, String nombre, Date fechaNacimiento, int nroDocumento, String nroMatricula, TipoDoc tipoDoc) {
        this.nroOdontologo = nroOdontologo;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.nroMatricula = nroMatricula;
        this.tipoDoc = tipoDoc;

        this.agendas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros, con todos los atributos de la clase Odontologo.
     * @param apellido
     * @param domicilio
     * @param nombre
     * @param fechaNacimiento
     * @param nroDocumento
     * @param nroMatricula
     * @param definicionesAgenda
     * @param agenda
     */
    public Odontologo(int nroOdontologo,String apellido, String domicilio, String nombre, Date fechaNacimiento, int nroDocumento, String nroMatricula, List<DefinicionAgenda> definicionesAgenda, List<Agenda> agenda) {
        this.nroOdontologo = nroOdontologo;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.nroMatricula = nroMatricula;
        this.definicionesAgenda = definicionesAgenda;
        this.agendas = agenda;
    }

    public int getNroOdontologo() {
        return nroOdontologo;
    }

    public void setNroOdontologo(Integer nroOdontologo) {
        this.nroOdontologo = nroOdontologo;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public List<DefinicionAgenda> getDefinicionesAgenda() {
        return definicionesAgenda;
    }

    public void setDefinicionesAgenda(List<DefinicionAgenda> definicionesAgenda) {
        this.definicionesAgenda = definicionesAgenda;
    }

    public List<Agenda> getAgenda() {
        return agendas;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agendas = agenda;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void agregarAgenda(Agenda agenda) {
        this.agendas.add(agenda);
    }

    public DefinicionAgenda getDefinicionAgendaVigente() {
        DefinicionAgenda vigente = null;

        Iterator<DefinicionAgenda> iter = definicionesAgenda.iterator();
        while (iter.hasNext()) {
            DefinicionAgenda actual = iter.next();

            if (actual.estaVigente()) {
                vigente = actual;
            }
        }

        return vigente;
    }

    @Override
    public String toString() {
        return this.apellido + ", " + this.nombre;
    }

}
