package dao;

import negocio.Persona;

import java.util.List;

public interface PersonaDAO {

    public void guardar(Persona persona);
    public void eliminar(long id);
    public List<Persona> listar();
    public Persona buscar(long id);

}
