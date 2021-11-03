package negocio;

public class Odotologo {
    private String matricula;


    public  Odotologo(){

    }

    public Odotologo(String matricula)
    {
        this.matricula = matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
