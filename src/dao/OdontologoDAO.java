package dao;

import negocio.Odontologo;

import java.util.List;

public interface OdontologoDAO {

    public void guardar(Odontologo odontologo);
    public void eliminar(long id);
    public List<Odontologo> listar();
    public Odontologo buscar(long id);

}
