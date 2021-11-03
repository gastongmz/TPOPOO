package negocio;

public class Paciente extends  Persona{
    private String domicilio;
    private String dni;

    public Paciente(){

    }

    public Paciente(String domicilio, String dni){
        this.domicilio = domicilio;
        this.dni = dni;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDni() { return dni;
    }
}
