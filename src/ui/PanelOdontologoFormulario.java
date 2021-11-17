package ui;

import negocio.Odontologo;
import negocio.Paciente;
import servicio.OdontologoService;
import servicio.PacienteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class PanelOdontologoFormulario extends JPanel {

    private JButton botonGuardar;
    private JButton botonCancelar;
    private JLabel lblNombre,lblApellido, lblMatricula;
    private JTextField txtNombre,txtApellido , txtMatricula;
    private JLabel lblId, label,label2;
    private JTextField txtId;


    private PanelManager panelManager;

    public PanelOdontologoFormulario(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }


    public void limpiaFormulario()
    {
        txtNombre.setText("");
        txtApellido.setText("");
        txtMatricula.setText("");
        txtId.setText("");
        txtId.setEnabled(false);
    }

    public void llenarFormulario(Odontologo odontologo)
    {
        txtNombre.setText(odontologo.getNombre());
        txtApellido.setText(odontologo.getApellido());
        txtMatricula.setText(odontologo.getNroMatricula());
        txtId.setText(Long.toString(odontologo.getNroOdontologo()));
        txtId.setEnabled(false);
    }

    public void armarPanelPacienteFormulario(){
        setLayout(new BorderLayout());
        JPanel panelComponentes = new JPanel();
        LayoutManager layout = new SpringLayout();
        panelComponentes.setLayout(layout);


        label = new JLabel("FORMULARIO ODONTOLOGO",  SwingConstants.CENTER);
        label2 = new JLabel("",  SwingConstants.CENTER);
        lblId = new JLabel("Id: ");
        txtId = new JTextField(3);
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(5);
        lblNombre.setLabelFor(txtNombre);
        lblApellido = new JLabel("Apellido: ");
        txtApellido = new JTextField(5);
        lblApellido.setLabelFor(txtApellido);
        lblMatricula = new JLabel("Nro Matricula: ");
        txtMatricula = new JTextField(5);

        botonGuardar = new JButton("Guardar");
        botonCancelar = new JButton("Cancelar");

        panelComponentes.add(label, BorderLayout.NORTH);
        panelComponentes.add(label2, BorderLayout.NORTH);


        //panelComponentes.add(lblId);
        //panelComponentes.add(txtId);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblMatricula);
        panelComponentes.add(txtMatricula);

        panelComponentes.setBackground(new Color(178, 189, 189));

        SpringUtilities.makeCompactGrid(panelComponentes , 4, 2);

        JPanel botonera = new JPanel();
        botonera.add(botonGuardar);
        botonera.add(botonCancelar);

        add(panelComponentes, BorderLayout.CENTER);
        add(botonera, BorderLayout.SOUTH);
        this.setVisible(true);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1-Guardar una persona, odontologo o paciente o un turno

                Odontologo odontologo = new Odontologo();
                if(!txtId.getText().equals(""))
                    odontologo.setNroOdontologo(Integer.parseInt(txtId.getText()));
                    odontologo.setNombre(txtNombre.getText());
                    odontologo.setApellido(txtApellido.getText());
                    odontologo.setNroMatricula(txtMatricula.getText());


                //paciente.setEdad(Integer.parseInt(txtEdad.getText()));

                OdontologoService odontologoService = new OdontologoService();
                odontologoService.guardar(odontologo);

                //2-mostrar listado
                panelManager.mostrarPanelListaOdontologo();
            }
        });


        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar listado
                panelManager.mostrarPanelListaOdontologo();
            }
        });
    }
}
