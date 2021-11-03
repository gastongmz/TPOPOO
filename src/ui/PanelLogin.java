package ui;

import negocio.Persona;
import servicio.PersonaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelLogin extends JPanel {

    private JLabel label;
    private JLabel usuarioLabel;
    private JLabel passwordLabel;
    private DefaultTableModel contenidoTabla;
    private JScrollPane scrollPane;
    private JPanel loginPanel;
    private JFrame loginFrame;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton loginButton;
    private JButton resetButton;
    private JCheckBox showPassword;
    private PanelManager panelManager;

    public PanelLogin(PanelManager panelManager)
    {
        this.panelManager = panelManager;
    }

    public void armarPanelLogin(){

        this.removeAll();

        this.setLayout(new BorderLayout());
        label = new JLabel("Ingrese sus credenciales");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginFrame = new JFrame();
        loginFrame.setTitle("Ingrese sus credenciales");
        loginFrame.setLocation(new Point(200,500));
        loginFrame.add(loginPanel);
        loginButton = new JButton("INGRESAR");
        resetButton = new JButton("RESET");
        usuarioLabel=new JLabel("USUARIO");
        passwordLabel=new JLabel("CONTRASEÑA");
        txtUsuario = new JTextField("",10);
        txtPassword = new JPasswordField("",10);
        showPassword=new JCheckBox("Mostrar");
        scrollPane = new JScrollPane();
        contenidoTabla = new DefaultTableModel();

        label.setBounds(120,70,200,30);
        usuarioLabel.setBounds(100,150,100,30);
        passwordLabel.setBounds(100,220,150,30);
        txtUsuario.setBounds(180,150,150,30);
        txtPassword.setBounds(180,220,150,30);
        showPassword.setBounds(190,250,150,30);
        loginButton.setBounds(110,300,100,30);
        resetButton.setBounds(230,300,100,30);

        loginPanel.add(label);
        loginPanel.add(usuarioLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(txtUsuario);
        loginPanel.add(txtPassword);
        loginPanel.add(showPassword);
        loginPanel.add(loginButton);
        loginPanel.add(resetButton);


        //add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(loginPanel,BorderLayout.CENTER);

        this.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
                String user =txtUsuario.getText();
                String pass = txtPassword.getText();

                if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")) {
                    JOptionPane.showMessageDialog(loginPanel, "Login correcto");
                    panelManager.mostrarPanelLista();
                }else{
                    JOptionPane.showMessageDialog(loginPanel, "Usuario o password incorrecto.");
                }
            }
        });

        showPassword.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showPassword) {
                if (showPassword.isSelected()) {
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('*');
                }
            }
        }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == resetButton) {
                    txtUsuario.setText("");
                    txtPassword.setText("");
                }
            }
        });


}}
