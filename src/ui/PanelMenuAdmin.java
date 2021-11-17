package ui;

import negocio.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenuAdmin extends JPanel {

    private JLabel label,labelHeader;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;
    private JPanel loginPanel, header;
    private JFrame loginFrame;
    private JButton loginButton,salirButton;
    private JButton resetButton;
    private PanelManager panelManager;

    public PanelMenuAdmin(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }


    public void armaHeader(){

            header = new JPanel();
            labelHeader = new JLabel("Bienvenido, Administrador" , SwingConstants.RIGHT);
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

    public void armarPaneMenuAdmin(){

        this.removeAll();

        this.setLayout(new BorderLayout());

        label = new JLabel("Ingrese sus credenciales");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginFrame = new JFrame();
        loginFrame.setTitle("Seleccione la accion que desea realisar");
        loginFrame.setLocation(new Point(200,500));
        loginPanel.setBackground(new Color(178, 189, 189));
        loginFrame.add(loginPanel);
        loginButton = new JButton("Admin. de Pacientes");
        resetButton = new JButton("Admin. de Odontologos");

        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();

        loginButton.setBounds(60,50,170,30);
        resetButton.setBounds(230,50,170,30);

       // loginPanel.add(salirButton);
        loginPanel.add(loginButton);
        loginPanel.add(resetButton);


        //add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(loginPanel,BorderLayout.CENTER);

        this.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPanelListaPaciente();
            }
        });



        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPanelListaOdontologo();
            }
        });


}}
