package ui;

import negocio.Combos;
import negocio.Odontologo;
import negocio.Paciente;
import negocio.Turno;
import servicio.OdontologoService;
import servicio.TurnoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PanelTurnoFormulario extends JPanel {

    private JButton botonGuardar;
    private JButton botonCancelar;
    private JLabel lblOdontologo,lblDia, lblHora;
    private JLabel labelHeader;
    private JComboBox cboOdontologos, cboDia , cboHora;;
    private JLabel lblId;
    private JTextField txtId;
    private JPanel header;
    private Paciente _paciente = new Paciente();


    private PanelManager panelManager;

    public PanelTurnoFormulario(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }


    public void armaHeader(Paciente paciente){
        if(paciente != null){

            _paciente = paciente;
            header = new JPanel();
            labelHeader = new JLabel("Hola, " + paciente.getNombre() + " "+ paciente.getApellido());
            labelHeader.setFont(new Font("Serif", Font.PLAIN, 20));
            header.add(labelHeader);
            add(header,BorderLayout.NORTH);
        }
    }

    public void llenarFormulario(Turno turno)
    {
        /*txtNombre.setText(turno.ge());
        txtApellido.setText(turno.getApellido());
        txtMatricula.setText(turno.getNroMatricula());
        txtId.setText(Long.toString(odontologo.getNroOdontologo()));*/
    }

    private void llenarComboOdontologos(){
        OdontologoService odontologoService = new OdontologoService();
        List<Odontologo>  odontologoList = odontologoService.listar();

        List<Combos> combosList = new ArrayList<>();

        for (Odontologo o : odontologoList){
            Combos a = new Combos(o.getNroOdontologo(), o.getApellido());
            combosList.add(a);
        }

        for (Combos c: combosList){
            cboOdontologos.addItem(c);
        }

    }

    private void llenarComboDias(){
        ArrayList<Combos> combosList = new ArrayList<Combos>();

        combosList.add(new Combos(1,"Lunes"));
        combosList.add(new Combos(2,"Martes"));
        combosList.add(new Combos(3,"Miercoles"));
        combosList.add(new Combos(4,"Jueves"));
        combosList.add(new Combos(5,"Viernes"));
        combosList.add(new Combos(6,"Sabado"));

        for (Combos c: combosList){
            cboDia.addItem(c);
        }

    }

    private void llenarComboHoras(){
        ArrayList<Combos> combosList = new ArrayList<Combos>();

        combosList.add(new Combos(1,"8:00"));
        combosList.add(new Combos(2,"8:30"));
        combosList.add(new Combos(3,"9:00"));
        combosList.add(new Combos(4,"9:30"));
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
            cboHora.addItem(c);
        }

    }


    public void armarPanelTurnoFormulario(){


        setLayout(new BorderLayout());
        JPanel panelComponentes = new JPanel();
        LayoutManager layout = new SpringLayout();
        panelComponentes.setLayout(layout);


        lblId = new JLabel("Id: ");
        txtId = new JTextField(3);
        txtId.setEnabled(false);
        lblOdontologo = new JLabel("Odontologo: ");
        cboOdontologos = new JComboBox();
        lblOdontologo.setLabelFor(cboOdontologos);
        lblDia = new JLabel("Dia: ");
        cboDia = new JComboBox();
        lblDia.setLabelFor(cboDia);
        lblHora = new JLabel("Hora: ");
        cboHora = new JComboBox();
        lblHora.setLabelFor(cboHora);

        botonGuardar = new JButton("Reservar");
        botonCancelar = new JButton("Cancelar");


        panelComponentes.add(lblId);
        panelComponentes.add(txtId);
        panelComponentes.add(lblOdontologo);
        panelComponentes.add(cboOdontologos);
        panelComponentes.add(lblDia);
        panelComponentes.add(cboDia);
        panelComponentes.add(lblHora);
        panelComponentes.add(cboHora);

        panelComponentes.setBackground(new Color(178, 189, 189));

        SpringUtilities.makeCompactGrid(panelComponentes , 4, 2);

        JPanel botonera = new JPanel();
        botonera.add(botonGuardar);
        botonera.add(botonCancelar);

        llenarComboOdontologos();
        llenarComboDias();
        llenarComboHoras();

        add(panelComponentes, BorderLayout.CENTER);
        add(botonera, BorderLayout.SOUTH);
        this.setVisible(true);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1-Guardar una persona, odontologo o paciente o un turno

                Combos odonto = (Combos) cboOdontologos.getSelectedItem();
                Combos dia = (Combos) cboDia.getSelectedItem();
                Combos hora = (Combos) cboHora.getSelectedItem();

                Turno turno = new Turno();

                if (turnoResrvado(odonto.getId(), dia.getId(), hora.getId())){
                    JOptionPane.showMessageDialog(header, "El turno ra fue reservado..");
                }else{
                if(_paciente.getNroPaciente()  != 0) {
                    turno.setNroOdontologo(odonto.getId());
                    turno.setDia(dia.getId());
                    turno.setHora(hora.getId());
                    turno.setNroPaciente(_paciente.getNroPaciente());

                    TurnoService turnoService = new TurnoService();
                    turnoService.reservar(turno);
                }}

                //2-mostrar listado
                panelManager.mostrarConsultaTurno(_paciente);
            }
        });


        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mostrar listado
                panelManager.mostrarConsultaTurno(_paciente);
            }
        });
    }

    public boolean turnoResrvado (int odonto, int dia, int hora){
        TurnoService turnoService = new TurnoService();
        if (turnoService.validarTurno( odonto,  dia,  hora)){
            return true;
        }
        return false;
    }
}
