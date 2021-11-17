package servicio;

import dao.OdontologoDAO;
import dao.OdontologoDAOArchivo;
import dao.PersonaDAO;
import dao.PersonaDAOArchivo;
import negocio.Odontologo;
import negocio.Persona;

import java.util.List;

public class OdontologoService {

    private OdontologoDAO odontologoDAO;

    public OdontologoService()
    {
        odontologoDAO = new OdontologoDAOArchivo();
    }

    public void guardar(Odontologo odontologo)
    {
        odontologoDAO.guardar(odontologo);
    }

    public void eliminar(long id)
    {
        odontologoDAO.eliminar(id);
    }

    public Odontologo buscar(long id)
    {
        return odontologoDAO.buscar(id);
    }

    public List<Odontologo> listar()
    {
        return odontologoDAO.listar();
    }
}
