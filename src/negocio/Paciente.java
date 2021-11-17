package negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente  implements Serializable {
    private String apellido;
    private String domicilio;
    private LocalDateTime fechaAlta;
    private String nombre;
    private String nroDocumento;
    private int nroPaciente;
    private String usuario;
    private String password;
    private Odontologo odontologCabecera;
    private List<Consulta> consultas;

    /**
     * Constructor por Defecto.
     */
    public Paciente() {
        consultas= new ArrayList<>();
    }

    /**
     * Constructor con parámetros, sin incluir atributos referenciales.
     * @param apellido
     * @param domicilio
     * @param fechaAlta
     * @param nombre
     * @param nroDocumento
     * @param usuario
     * @param password
     */
    public Paciente(String apellido, String domicilio, LocalDateTime fechaAlta, String nombre, String nroDocumento, int nroPaciente, String usuario, String password) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.nroPaciente = nroPaciente;
        this.usuario = usuario;
        this.password = password;
        consultas = new ArrayList<>();
    }

    /**
     * Constructor con parámetros, con todos los atributos de la clase Paciente.
     * @param apellido
     * @param domicilio
     * @param fechaAlta
     * @param nombre
     * @param nroDocumento
     * @param nroPaciente
     * @param odontologCabecera
     * @param consultas
     */
    public Paciente(String apellido, String domicilio, LocalDateTime fechaAlta, String nombre, String nroDocumento, int nroPaciente, Odontologo odontologCabecera, List<Consulta> consultas) {
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.nroDocumento = nroDocumento;
        this.nroPaciente = nroPaciente;
        this.odontologCabecera = odontologCabecera;
        this.consultas = consultas;
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

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getNroPaciente() {
        return nroPaciente;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public Odontologo getOdontologCabecera() {
        return odontologCabecera;
    }

    public void setOdontologCabecera(Odontologo odontologCabecera) {
        this.odontologCabecera = odontologCabecera;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
