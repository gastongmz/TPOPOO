package servicio;

import dao.PacienteDAO;
import dao.PacienteDAOArchivo;
import negocio.Paciente;

import java.util.List;

public class PacienteService {

    private PacienteDAO pacienteDAO;

    public PacienteService()
    {
        pacienteDAO = new PacienteDAOArchivo();
    }

    public void guardar(Paciente pacientea)
    {
        pacienteDAO.guardar(pacientea);
    }

    public void eliminar(long id)
    {
        pacienteDAO.eliminar(id);
    }

    public Paciente buscar(long id)
    {
        return pacienteDAO.buscar(id);
    }

    public Paciente buscarPorUsuario(String usuario)
    {
        return pacienteDAO.buscarPorUsuario(usuario);
    }

    public List<Paciente> listar()
    {
        return pacienteDAO.listar();
    }
}
