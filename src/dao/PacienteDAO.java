package dao;

import negocio.Odontologo;
import negocio.Paciente;

import java.util.List;

public interface PacienteDAO {

    public void guardar(Paciente paciente);
    public void eliminar(long id);
    public List<Paciente> listar();
    public Paciente buscar(long id);
    public Paciente buscarPorUsuario(String usuario);

}
