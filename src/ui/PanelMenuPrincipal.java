package ui;

import negocio.Paciente;
import negocio.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenuPrincipal extends JPanel {

    private JLabel label;
    private JLabel labelHeader;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;
    private JPanel loginPanel;
    private JFrame loginFrame;
    private JButton salirButton;
    private JButton TurnoButton;
    private JButton ConsultaButton;
    private PanelManager panelManager;
    private JPanel header;
    private Paciente _paciente = new Paciente();

    public PanelMenuPrincipal(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armaHeader(Paciente paciente){
        if(paciente != null){

            _paciente = paciente;
            header = new JPanel();
            labelHeader = new JLabel("Bienvenido, " + paciente.getNombre() + " "+ paciente.getApellido(), SwingConstants.RIGHT);
            labelHeader.setFont(new Font("Serif", Font.PLAIN, 15));
            salirButton = new JButton("Salir");
            salirButton.setHorizontalAlignment(SwingConstants.RIGHT);
            salirButton.setBounds(20,250,170,30);
            header.add(labelHeader);
            header.add(salirButton);
            add(header,BorderLayout.NORTH);

            salirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelManager.mostrarLogin();
                }
            });
        }
    }

    public void armarPaneMenuPrincipal(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(178, 189, 189));
        loginFrame = new JFrame();
        loginFrame.setTitle("Seleccione la accion que desea realisar");
        loginFrame.setLocation(new Point(100,500));
        loginFrame.add(loginPanel);
        TurnoButton = new JButton("Solictar Turno");
        ConsultaButton = new JButton("Consultar Disponibilidad");
        //salirButton = new JButton("Salir");

        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();

        ///TurnoButton.setBounds(20,250,170,30);
        TurnoButton.setBounds(60,50,170,30);
        ConsultaButton.setBounds(230,50,170,30);

        loginPanel.add(TurnoButton);
        loginPanel.add(ConsultaButton);
        //loginPanel.add(salirButton);

        //add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(loginPanel,BorderLayout.CENTER);

        this.setVisible(true);

        TurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarRegistroTurno( _paciente);
            }
        });



        ConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarConsultaTurno();
            }
        });




}}
