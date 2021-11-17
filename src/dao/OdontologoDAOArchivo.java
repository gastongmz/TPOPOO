package dao;

import negocio.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArchivo implements OdontologoDAO{

    @Override
    public void guardar(Odontologo odontologo) {

        //1 recuperar de un archivo todo el listado de personas
        List<Odontologo> lista = listar();

        if(lista == null)
            lista = new ArrayList<>();

        int idMax = 0;
        //2 preguntar si id de la persona es igual a cero
        if(odontologo.getNroOdontologo() == 0)
        {
            for(Odontologo p:lista) {
                if (p.getNroOdontologo() > idMax)
                    idMax = p.getNroOdontologo();
            }
            //3 agregar a persona dentro de la lista de personas
            odontologo.setNroOdontologo(idMax + 1);
            lista.add(odontologo);
        }else
        {
            //4 si el id es difernte de cero tengo que modificar los atributos de la persona con ese id
            for(Odontologo p:lista) {
                if(p.getNroOdontologo() == odontologo.getNroOdontologo())
                {
                    p.setApellido(odontologo.getApellido());
                    p.setNombre(odontologo.getNombre());
                    p.setNroMatricula(odontologo.getNroMatricula());

                }
            }
        }
        //5 guardar el listado en el archivo
        Archivo archivoOdontologos = new Archivo("odontologos.txt");
        archivoOdontologos.guardar(lista);
    }

    @Override
    public void eliminar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Odontologo> listado = listar();
        //2 buscar en el listado de personas una persona con el id que viene por parametro

        int i = 0;
        boolean encontro = false;
        while(i < listado.size() && !encontro)
        {
            //3 si lo encontre lo elimino de la lista
            Odontologo p = listado.get(i);
            if(p.getNroOdontologo() == id)
            {
                listado.remove(p);
                encontro = true;
            }
            i++;
        }

        //4 guardar el listado en el archivo
        Archivo archivoPersonas = new Archivo("odontologos.txt");
        archivoPersonas.guardar(listado);

    }

    @Override
    public List<Odontologo> listar() {
        //1 recuperar de un archivo todo el listado de personas
        Archivo archivoOdontologos = new Archivo("odontologos.txt");
        List lista = archivoOdontologos.recuperar();

        if(lista == null)
            lista = new ArrayList<>();
        //2 retornar ese listado*/
        return lista;
    }

    @Override
    public Odontologo buscar(long id) {
        //1 recuperar de un archivo todo el listado de personas
        List<Odontologo> listado = listar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(Odontologo p : listado) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getNroOdontologo() == id)
                return p;
        }
        return null;
    }
}
