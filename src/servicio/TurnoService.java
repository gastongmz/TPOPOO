package servicio;

import dao.PacienteDAO;
import dao.PacienteDAOArchivo;
import dao.TurnoDAO;
import dao.TurnoDAOArchivo;
import negocio.Paciente;
import negocio.Turno;

import java.util.List;

public class TurnoService {

    private TurnoDAO turnoDAO;

    public TurnoService()
    {
        turnoDAO = new TurnoDAOArchivo();
    }

    public void reservar(Turno turno)
    {
        turnoDAO.reservar(turno);
    }

    public void eliminar(long id)
    {
        turnoDAO.eliminar(id);
    }

    public Turno buscar(long id)
    {
        return turnoDAO.buscar(id);
    }

    public List<Turno> listar()
    {
        return turnoDAO.listar();
    }
}
