package ui;

import negocio.Paciente;
import negocio.Persona;
import servicio.PacienteService;
import servicio.PersonaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListaPaciente extends JPanel {

    private JLabel label;
    private JTable jtable;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;
    private JPanel botonera;
    private JButton altaButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton menuButton;
    private PanelManager panelManager;
    private  JPanel panelListPaciente;

    public PanelListaPaciente(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armarPanelLista(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("LISTADO PACIENTES",  SwingConstants.CENTER);
        botonera = new JPanel();
        botonera.setBackground(new Color(178, 189, 189));
        altaButton = new JButton("Registrar");
        eliminarButton = new JButton("Eliminar");
        modificarButton = new JButton("Modificar");
        menuButton = new JButton("Menu");
        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();
        jtable = new JTable(contenidoTabla);
        jtable.setBackground(new Color(178, 189, 189));

        List<Paciente> lista = ObtenerLista();
        //Columnas
        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("Nombre");
        contenidoTabla.addColumn("Apellido");
        contenidoTabla.addColumn("Domicilio");
        contenidoTabla.addColumn("DNI");
        contenidoTabla.addColumn("Fecha alta");
        contenidoTabla.addColumn("Usuario");
        contenidoTabla.addColumn("Password");

        //Filas
        for(Object o:lista) {
            Paciente p = (Paciente) o;
            Object[] row = {p.getNroPaciente(), p.getNombre(), p.getApellido(), p.getDomicilio(), p.getNroDocumento(), p.getFechaAlta(), p.getUsuario(), p.getPassword()};
            contenidoTabla.addRow(row);
        }
        jtable.setAutoCreateColumnsFromModel(true);
        scrollPane.setViewportView(jtable);


        botonera.add(altaButton);
        botonera.add(eliminarButton);
        botonera.add(modificarButton);
        botonera.add(menuButton);

        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(botonera,BorderLayout.SOUTH);

        this.setVisible(true);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                panelManager.mostrarMenuAdmin();
            }
        });

        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                panelManager.mostrarPanelPacienteFormulario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar por el id
                if (jtable.getSelectedRow() > -1) {
                int id = (int)jtable.getValueAt(jtable.getSelectedRow(),0);
                PacienteService pacienteService = new PacienteService();
                pacienteService.eliminar(id);

                panelManager.mostrarPanelListaPaciente();
                }else{
                    JOptionPane.showMessageDialog(panelListPaciente, "Debe seleccionar un registro.");
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario, buscar a la persona por id pasarle una persona

                if (jtable.getSelectedRow() > -1) {
                    int id = (int) jtable.getValueAt(jtable.getSelectedRow(), 0);
                    PacienteService pacienteService = new PacienteService();
                    Paciente paciente = pacienteService.buscar(id);

                    panelManager.mostrarPanelPacienteFormulario(paciente);
                }else{
                    JOptionPane.showMessageDialog(panelListPaciente, "Debe seleccionar un registro.");
                }

            }
        });

    }

    private List<Paciente> ObtenerLista() {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.listar();

    }

}
