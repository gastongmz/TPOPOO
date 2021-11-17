package ui;

import negocio.Odontologo;
import servicio.OdontologoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListaOdontologo extends JPanel {

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
    private JPanel panelListaOdontologo;

    public PanelListaOdontologo(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armarPanelLista(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("LISTADO ODONTOLOGOS");
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

        List<Odontologo> lista = ObtenerLista();


        //Columnas
        contenidoTabla.addColumn("ID");
        contenidoTabla.addColumn("Nombre");
        contenidoTabla.addColumn("Apellido");
        contenidoTabla.addColumn("Matricula");

        //Filas
        for(Object o:lista) {
            Odontologo p = (Odontologo) o;
            Object[] row = {p.getNroOdontologo(), p.getNombre(), p.getApellido(), p.getNroMatricula()};
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
                panelManager.mostrarPanelOdontologoFormulario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar por el id
                if (jtable.getSelectedRow() > 0) {
                int id = (int)jtable.getValueAt(jtable.getSelectedRow(),0);
                OdontologoService odontologoService = new OdontologoService();
                odontologoService.eliminar(id);

                panelManager.mostrarPanelListaOdontologo();
                }else{
                    JOptionPane.showMessageDialog(panelListaOdontologo, "Debe seleccionar un registro.");
                }
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
                if (jtable.getSelectedRow() > 0) {
                    int id = (int) jtable.getValueAt(jtable.getSelectedRow(), 0);
                    OdontologoService odontologoService = new OdontologoService();
                    Odontologo odontologo = odontologoService.buscar(id);

                    panelManager.mostrarPanelOdontologoFormulario(odontologo);
                }else{
                    JOptionPane.showMessageDialog(panelListaOdontologo, "Debe seleccionar un registro.");
                }
            }
        });

    }

    private List<Odontologo> ObtenerLista() {
        OdontologoService odontologoService = new OdontologoService();
        return odontologoService.listar();

    }

}
