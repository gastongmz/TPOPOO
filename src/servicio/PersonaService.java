package servicio;

import dao.PersonaDAO;
import dao.PersonaDAOArchivo;
import negocio.Persona;

import java.util.List;

public class PersonaService {

    private PersonaDAO personaDAO;

    public PersonaService()
    {
        personaDAO = new PersonaDAOArchivo();
    }

    public void guardar(Persona persona)
    {
        personaDAO.guardar(persona);
    }

    public void eliminar(long id)
    {
        personaDAO.eliminar(id);
    }

    public Persona buscar(long id)
    {
        return personaDAO.buscar(id);
    }

    public List<Persona> listar()
    {
        return personaDAO.listar();
    }
}
