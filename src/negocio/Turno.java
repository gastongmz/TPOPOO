package negocio;

import java.io.Serializable;
import java.util.Date;

public class Turno implements Serializable {

    private long id;
    private Date fechaHora;
    private int dia;
    private int hora;
    private Estado estado;
    private Consulta consulta;
    private Paciente paciente;
    private Odontologo Odontologo;
    private int nroOdontologo;
    private int nroPaciente;

    /**
     * Constructor por Defecto.
     */
    public Turno() {
    }

    /**
     * Constructor con parámetros, con todos los atributos de la clase Turno.
     * @param fechaHora
     * @param estado
     * @param consulta
     * @param paciente
     */
    public Turno(Date fechaHora, int dia, int hora, Estado estado, Consulta consulta, Paciente paciente, Odontologo odontologo,int nroPaciente, int nroOdontologo) {
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.consulta = consulta;
        this.paciente = paciente;
        this.Odontologo = odontologo;
        this.dia = dia;
        this.hora = hora;
        this.nroPaciente = nroPaciente;
        this.nroOdontologo = nroOdontologo;
    }

    public Turno(Date fechaHora, Estado estado) {
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getNroOdontologo() {
        return nroOdontologo;
    }

    public void setNroOdontologo(int nroOdontologo) {
        this.nroOdontologo = nroOdontologo;
    }

    public Odontologo getOdontologo() {
        return Odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.Odontologo = odontologo;
    }

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}