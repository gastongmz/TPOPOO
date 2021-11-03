package ui;

import negocio.Persona;
import servicio.PersonaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormulario extends JPanel {

    private JButton botonGuardar;
    private JButton botonCancelar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblEdad;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JLabel lblId;
    private JTextField txtId;


    private PanelManager panelManager;

    public PanelFormulario(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void llenarFormulario(Persona persona)
    {

        txtNombre.setText(persona.getNombre());
        txtApellido.setText(persona.getApellido());
        txtEdad.setText(Integer.toString(persona.getEdad()));
        txtId.setText(Long.toString(persona.getId()));

    }

    public void armarPanelFormulario(){
        setLayout(new BorderLayout());
        JPanel panelComponentes = new JPanel();
        LayoutManager layout = new SpringLayout();
        panelComponentes.setLayout(layout);

        lblId = new JLabel("Id: ");
        txtId = new JTextField(3);

        lblId = new JLabel("Id: ");
        txtId = new JTextField(3);
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(5);
        lblNombre.setLabelFor(txtNombre);
        lblApellido = new JLabel("Apellido: ");
        txtApellido = new JTextField(5);
        lblApellido.setLabelFor(txtApellido);
        lblEdad = new JLabel("Edad: ");
        txtEdad = new JTextField(5);
        lblEdad.setLabelFor(txtEdad);


        botonGuardar = new JButton("Guardar");
        botonCancelar = new JButton("Cancelar");


        panelComponentes.add(lblId);
        panelComponentes.add(txtId);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblEdad);
        panelComponentes.add(txtEdad);

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

                Persona persona = new Persona();
                if(!txtId.getText().equals(""))
                    persona.setId(Long.parseLong(txtId.getText()));
                persona.setNombre(txtNombre.getText());
                persona.setApellido(txtApellido.getText());
                persona.setEdad(Integer.parseInt(txtEdad.getText()));

                PersonaService personaService = new PersonaService();
                personaService.guardar(persona);

                //2-mostrar listado
                panelManager.mostrarPanelLista();
            }
        });


        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar listado
                panelManager.mostrarPanelLista();
            }
        });
    }
}
