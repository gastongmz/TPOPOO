package dao;

import negocio.Odontologo;
import negocio.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAOArchivo implements PacienteDAO{

    @Override
    public void guardar(Paciente persona) {

        //1 recuperar de un archivo todo el listado de personas
        List<Paciente> lista = listar();

        if(lista == null)
            lista = new ArrayList<>();

        int idMax = 0;
        //2 preguntar si id de la persona es igual a cero
        if(persona.getNroPaciente() == 0)
        {
            for(Paciente p:lista) {
                if (p.getNroPaciente() > idMax)
                    idMax = p.getNroPaciente();
            }
            //3 agregar a persona dentro de la lista de personas
            persona.setNroPaciente(idMax + 1);
            lista.add(persona);
        }else
        {
            //4 si el id es difernte de cero tengo que modificar los atributos de la persona con ese id
            for(Paciente p:lista) {
                if(p.getNroPaciente() == persona.getNroPaciente())
                {
                    p.setApellido(persona.getApellido());
                    p.setNombre(persona.getNombre());
                    p.setDomicilio(persona.getDomicilio());
                    p.setNroDocumento(persona.getNroDocumento());
                    p.setFechaAlta(persona.getFechaAlta());
                    p.setUsuario(persona.getUsuario());
                    p.setPassword(persona.getPassword());
                }
            }
        }
        //5 guardar el listado en el archivo
        Archivo archivoPersonas = new Archivo("pacientes.txt");
        archivoPersonas.guardar(lista);
    }

    @Override
    public void eliminar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Paciente> listado = listar();
        //2 buscar en el listado de personas una persona con el id que viene por parametro

        int i = 0;
        boolean encontro = false;
        while(i < listado.size() && !encontro)
        {
            //3 si lo encontre lo elimino de la lista
            Paciente p = listado.get(i);
            if(p.getNroPaciente() == id)
            {
                listado.remove(p);
                encontro = true;
            }
            i++;
        }

        //4 guardar el listado en el archivo
        Archivo archivoPersonas = new Archivo("pacientes.txt");
        archivoPersonas.guardar(listado);

    }

    @Override
    public List<Paciente> listar() {
        //1 recuperar de un archivo todo el listado de personas
        Archivo archivoPeronas = new Archivo("pacientes.txt");
        List lista = archivoPeronas.recuperar();

        if(lista == null)
            lista = new ArrayList<>();
        //2 retornar ese listado*/
        return lista;
    }

    @Override
    public Paciente buscar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Paciente> listado = listar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Paciente p : listado) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getNroPaciente() == id)
                return p;
        }
        return null;
    }

    @Override
    public Paciente buscarPorUsuario(String usuario) {
        //1 recuperar de un archivo todo el listado de personas
        List<Paciente> listado = listar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Paciente p : listado) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getUsuario().equals(usuario))
                return p;
        }
        return null;
    }
}
