package ui;

import negocio.Combos;
import negocio.Paciente;
import negocio.Turno;
import servicio.PacienteService;
import servicio.TurnoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelListaConsulta extends JPanel {

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
    private  JPanel panelListConsulta;
    private Paciente _paciente = new Paciente();

    public PanelListaConsulta(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armaHeader(Paciente paciente){
        if(paciente != null){

            _paciente = paciente;
        }
    }

    public void armarPanelLista(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("LISTADO TURNOS",  SwingConstants.CENTER);
        botonera = new JPanel();
        botonera.setBackground(new Color(178, 189, 189));
        //altaButton = new JButton("Reservar");
        eliminarButton = new JButton("Cancelar Turno");
        //modificarButton = new JButton("Modificar");
        menuButton = new JButton("Menu");
        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();
        jtable = new JTable(contenidoTabla);
        jtable.setBackground(new Color(178, 189, 189));

        List<Turno> lista = ObtenerLista();

        //Columnas
        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("Odontologo");
        contenidoTabla.addColumn("Paciente");
        contenidoTabla.addColumn("Dia");
        contenidoTabla.addColumn("Hora");
        //Filas
        for(Object o:lista) {
            Turno p = (Turno) o;
            Object[] row = {p.getId(),p.getOdontologo().getApellido() +" "+ p.getOdontologo().getNombre(),p.getPaciente().getApellido()+" "+p.getPaciente().getNombre(),bindingDias( p.getDia()), bindingHora(p.getHora())};
            contenidoTabla.addRow(row);
        }
        jtable.setAutoCreateColumnsFromModel(true);
        scrollPane.setViewportView(jtable);


        //botonera.add(altaButton);
        botonera.add(eliminarButton);
        //botonera.add(modificarButton);
        botonera.add(menuButton);

        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(botonera,BorderLayout.SOUTH);

        this.setVisible(true);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                panelManager.mostrarMenuPrincipal(new Paciente());
            }
        });

       /* altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                //panelManager.mostrarPanelPacienteFormulario();

            }
        });
            */
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar por el id
                if (jtable.getSelectedRow() > 0) {
                    long id = (long) jtable.getValueAt(jtable.getSelectedRow(), 0);
                    TurnoService turnoService = new TurnoService();
                    turnoService.eliminar(id);

                    panelManager.mostrarConsultaTurno(_paciente);
                }else{
                    JOptionPane.showMessageDialog(panelListConsulta, "Debe seleccionar un registro.");
                }

            }
        });
        /*
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario, buscar a la persona por id pasarle una persona
                if (jtable.getSelectedRow() > 0) {
                    int id = (int) jtable.getValueAt(jtable.getSelectedRow(), 0);
                    PacienteService pacienteService = new PacienteService();
                    Paciente paciente = pacienteService.buscar(id);

                    panelManager.mostrarPanelPacienteFormulario(paciente);
                }else{
                    JOptionPane.showMessageDialog(panelListPaciente, "Debe seleccionar un registro.");
                }

            }
        });*/

    }
    private String bindingHora(int id){
        ArrayList<Combos> combosList = new ArrayList<Combos>();

        combosList.add(new Combos(1,"08:00"));
        combosList.add(new Combos(2,"08:30"));
        combosList.add(new Combos(3,"09:00"));
        combosList.add(new Combos(4,"09:30"));
        combosList.add(new Combos(5,"10:00"));
        combosList.add(new Combos(6,"10:30"));
        combosList.add(new Combos(7,"11:00"));
        combosList.add(new Combos(8,"11:30"));
        combosList.add(new Combos(9,"12:00"));
        combosList.add(new Combos(10,"12:30"));
        combosList.add(new Combos(11,"13:00"));
        combosList.add(new Combos(12,"13:30"));
        combosList.add(new Combos(13,"14:00"));
        combosList.add(new Combos(14,"14:30"));
        combosList.add(new Combos(15,"15:00"));

        for (Combos c: combosList){
            if (c.getId() == id)
                return c.getDescripcion();
        }
        return "N/A";
    }

    private String bindingDias(int id){
        ArrayList<Combos> combosList = new ArrayList<Combos>();

        combosList.add(new Combos(1,"Lunes"));
        combosList.add(new Combos(2,"Martes"));
        combosList.add(new Combos(3,"Miercoles"));
        combosList.add(new Combos(4,"Jueves"));
        combosList.add(new Combos(5,"Viernes"));
        combosList.add(new Combos(6,"Sabado"));

        for (Combos c: combosList){
            if (c.getId() == id)
                return c.getDescripcion();
        }
        return "N/A";
    }
    private List<Turno> ObtenerLista() {
        TurnoService turnoService = new TurnoService();
        return turnoService.listar();

    }

}
