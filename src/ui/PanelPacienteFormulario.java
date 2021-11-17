package ui;

import negocio.Paciente;
import negocio.Persona;
import servicio.PacienteService;
import servicio.PersonaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

public class PanelPacienteFormulario extends JPanel {

    private JButton botonGuardar;
    private JButton botonCancelar;
    private JLabel label;
    private JLabel lblNombre,lblApellido, lblDomicilio, lblNroDocumento, lblUsuario,lblPassword;
    private JTextField txtNombre,txtApellido , txtDomicilio, txtNroDocumento, txtUsuario, txtPassword;
    private JLabel lblId, label2;
    private JTextField txtId;


    private PanelManager panelManager;

    public PanelPacienteFormulario(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }


    public void limpiaFormulario()
    {

        txtNombre.setText("");
        txtApellido.setText("");
        txtDomicilio.setText("");
        txtNroDocumento.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        txtId.setText("");
        txtId.setEnabled(false);

    }

    public void llenarFormulario(Paciente paciente)
    {

        txtNombre.setText(paciente.getNombre());
        txtApellido.setText(paciente.getApellido());
        txtDomicilio.setText(paciente.getDomicilio());
        txtNroDocumento.setText(paciente.getNroDocumento());
        txtUsuario.setText(paciente.getUsuario());
        txtPassword.setText(paciente.getPassword());
        txtId.setText(Long.toString(paciente.getNroPaciente()));
        txtId.setEnabled(false);

    }

    public void armarPanelPacienteFormulario(){
        setLayout(new BorderLayout());
        JPanel panelComponentes = new JPanel();
        LayoutManager layout = new SpringLayout();
        panelComponentes.setLayout(layout);

        label = new JLabel("FORMULARIO PACIENTE",  SwingConstants.CENTER);
        label2 = new JLabel("");
        lblId = new JLabel("Id: ");
        txtId = new JTextField(3);
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(3);
        lblNombre.setLabelFor(txtNombre);
        lblApellido = new JLabel("Apellido: ");
        txtApellido = new JTextField(3);
        lblApellido.setLabelFor(txtApellido);
        lblDomicilio = new JLabel("Domicilio: ");
        txtDomicilio = new JTextField(3);
        lblNroDocumento = new JLabel("DNI: ");
        txtNroDocumento = new JTextField(3);
        lblDomicilio.setLabelFor(txtDomicilio);
        lblUsuario = new JLabel("Usuario: ");
        txtUsuario = new JTextField(3);
        lblUsuario.setLabelFor(txtUsuario);
        lblPassword = new JLabel("Password: ");
        txtPassword = new JTextField(3);
        lblPassword.setLabelFor(txtPassword);




        botonGuardar = new JButton("Guardar");
        botonCancelar = new JButton("Cancelar");

        panelComponentes.add(label, BorderLayout.NORTH);
        panelComponentes.add(label2, BorderLayout.NORTH);


        panelComponentes.add(label);
        panelComponentes.add(label2);

        if(!txtId.getText().equals("")){
        panelComponentes.add(lblId);
        panelComponentes.add(txtId);
        }

        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblDomicilio);
        panelComponentes.add(txtDomicilio);
        panelComponentes.add(lblNroDocumento);
        panelComponentes.add(txtNroDocumento);
        panelComponentes.add(lblUsuario);
        panelComponentes.add(txtUsuario);
        panelComponentes.add(lblPassword);
        panelComponentes.add(txtPassword);

        panelComponentes.setBackground(new Color(178, 189, 189));

        if(!txtId.getText().equals("")) {
            SpringUtilities.makeCompactGrid(panelComponentes, 8, 2);
        }else{
            SpringUtilities.makeCompactGrid(panelComponentes, 7, 2);
        }

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

                Paciente paciente = new Paciente();
                if(!txtId.getText().equals(""))
                    paciente.setNroPaciente(Integer.parseInt(txtId.getText()));
                    paciente.setNombre(txtNombre.getText());
                    paciente.setApellido(txtApellido.getText());
                    paciente.setDomicilio(txtDomicilio.getText());
                    paciente.setNroDocumento(txtNroDocumento.getText());
                    paciente.setUsuario(txtUsuario.getText());
                    paciente.setPassword(txtPassword.getText());
                    paciente.setFechaAlta(LocalDateTime.now());

                //paciente.setEdad(Integer.parseInt(txtEdad.getText()));

                PacienteService pacienteService = new PacienteService();
                pacienteService.guardar(paciente);

                //2-mostrar listado
                panelManager.mostrarPanelListaPaciente();
            }
        });


        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar listado
                panelManager.mostrarPanelListaPaciente();
            }
        });
    }
}
