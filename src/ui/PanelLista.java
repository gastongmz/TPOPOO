package ui;

import negocio.Persona;
import servicio.PersonaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PanelLista extends JPanel {

    private JLabel label;
    private JTable jtable;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;
    private JPanel botonera;
    private JButton altaButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private PanelManager panelManager;

    public PanelLista(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armarPanelLista(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("Aca iría una JTable para mostrar los odontologos o pacientes o turnos");
        botonera = new JPanel();
        altaButton = new JButton("Crear nuevo");
        eliminarButton = new JButton("Eliminar");
        modificarButton = new JButton("Modificar");
        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();
        jtable = new JTable(contenidoTabla);

        List<Persona> lista = ObtenerLista();


        //Columnas
        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("Nombre");
        contenidoTabla.addColumn("Apellido");
        contenidoTabla.addColumn("Edad");
        //Filas
        for(Object o:lista) {
            Persona p = (Persona) o;
            Object[] row = {p.getId(), p.getNombre(), p.getApellido(), p.getEdad()};
            contenidoTabla.addRow(row);
        }
        jtable.setAutoCreateColumnsFromModel(true);
        scrollPane.setViewportView(jtable);


        botonera.add(altaButton);
        botonera.add(eliminarButton);
        botonera.add(modificarButton);

        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(botonera,BorderLayout.SOUTH);

        this.setVisible(true);

        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                panelManager.mostrarPanelFormulario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar por el id
                long id = (long)jtable.getValueAt(jtable.getSelectedRow(),0);
                PersonaService personaService = new PersonaService();
                personaService.eliminar(id);

                panelManager.mostrarPanelLista();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario, buscar a la persona por id pasarle una persona

                /*Persona persona = new Persona();
                persona.setId((long)jtable.getValueAt(jtable.getSelectedRow(),0));
                persona.setNombre(jtable.getValueAt(jtable.getSelectedRow(),1).toString());
                persona.setApellido(jtable.getValueAt(jtable.getSelectedRow(),2).toString());
                persona.setEdad((int)jtable.getValueAt(jtable.getSelectedRow(),3));*/

                long id = (long)jtable.getValueAt(jtable.getSelectedRow(),0);
                PersonaService personaService = new PersonaService();
                Persona persona = personaService.buscar(id);

                panelManager.mostrarPanelFormulario(persona);

            }
        });

    }

    private List<Persona> ObtenerLista() {
        PersonaService personaService = new PersonaService();
        return personaService.listar();

    }

}
