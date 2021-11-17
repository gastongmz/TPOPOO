package dao;

import negocio.Paciente;
import negocio.Turno;

import java.util.List;

public interface TurnoDAO {

    public void reservar(Turno turno);
    public void eliminar(long id);
    public List<Turno> listar();
    public Turno buscar(long id);
    public Boolean validarTurno(int odonto, int dia, int hora);

}
