package dao;

import negocio.*;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAOArchivo implements TurnoDAO {

    @Override
    public void reservar(Turno turno) {

        //1 recuperar de un archivo todo el listado de personas
        List<Turno> lista = listar();

        if(lista == null)
            lista = new ArrayList<>();

        long idMax = 0;
        //2 preguntar si id de la persona es igual a cero
        if(turno.getId() == 0)
        {
            for(Turno p:lista) {
                if (p.getId() > idMax)
                    idMax = p.getId();
            }
            //3 agregar a persona dentro de la lista de personas
            turno.setId(idMax + 1);
            lista.add(turno);
        }else
        {
            //4 si el id es difernte de cero tengo que modificar los atributos de la persona con ese id
            for(Turno p:lista) {
                if(p.getId() == turno.getId())
                {
                    p.setNroOdontologo(turno.getNroOdontologo());
                    p.setNroPaciente(turno.getNroPaciente());
                    p.setHora(turno.getHora());
                    p.setDia(turno.getDia());
                }
            }
        }
        //5 guardar el listado en el archivo
        Archivo archivoTurnos = new Archivo("turnos.txt");
        archivoTurnos.guardar(lista);
    }

    @Override
    public void eliminar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Turno> listado = listar();
        //2 buscar en el listado de personas una persona con el id que viene por parametro

        int i = 0;
        boolean encontro = false;
        while(i < listado.size() && !encontro)
        {
            //3 si lo encontre lo elimino de la lista
            Turno p = listado.get(i);
            if(p.getId() == id)
            {
                listado.remove(p);
                encontro = true;
            }
            i++;
        }

        //4 guardar el listado en el archivo
        Archivo archivoPersonas = new Archivo("turnos.txt");
        archivoPersonas.guardar(listado);

    }

    @Override
    public List<Turno> listar() {
        //1 recuperar de un archivo todo el listado de turnos
        Archivo archivoTurnos = new Archivo("turnos.txt");
        List<Turno> lista = archivoTurnos.recuperar();



        if(lista == null) {
            lista = new ArrayList<>();
        }else{
            for (Turno t :lista){
                t.setPaciente(buscarPacientes(t.getNroPaciente()));
                t.setOdontologo(buscarOdontologos(t.getNroOdontologo()));
            }
        }
        //2 retornar ese listado*/
        return lista;
    }

    @Override
    public Turno buscar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Turno> listado = listar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Turno p : listado) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getId() == id)
                return p;
        }
        return null;
    }



    public Paciente buscarPacientes(long id) {
        //1 recuperar de un archivo todo el listado de personas
        Archivo archivoPacientes = new Archivo("pacientes.txt");
        List<Paciente> listaPacientes = archivoPacientes.recuperar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Paciente p : listaPacientes) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getNroPaciente() == id)
                return p;
        }
        return null;
    }

    public Odontologo buscarOdontologos(long id) {
        //1 recuperar de un archivo todo el listado de personas
        Archivo archivoOdontologos = new Archivo("odontologos.txt");
        List<Odontologo> listaOdontologos = archivoOdontologos.recuperar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Odontologo p : listaOdontologos) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getNroOdontologo() == id)
                return p;
        }
        return null;
    }

    @Override
    public Boolean validarTurno(int odonto, int dia, int hora) {

        Archivo archivoTurnos = new Archivo("turnos.txt");
        List<Turno> lista = archivoTurnos.recuperar();

        if(lista != null) {
        for(Turno p : lista) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getNroOdontologo() == odonto && p.getDia() == dia && p.getHora() == hora)
                return true;
        }}

        return false;
    }
}
