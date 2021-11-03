package ui;

import negocio.Persona;

import javax.swing.*;

public class PanelManager {

    private JFrame frame;
    private PanelLista panelLista;
    private PanelLogin panelLogin;
    private PanelFormulario panelFormulario;

    public void armarManager()
    {
        frame = new JFrame();
        frame.setBounds(100,100,500,500);

        panelLogin = new PanelLogin(this);
        panelLogin.armarPanelLogin();

        panelLista = new PanelLista(this);
        panelLista.armarPanelLista();

        panelFormulario = new PanelFormulario(this);
        panelFormulario.armarPanelFormulario();
    }

    public void mostrarLogin()
    {

        frame.getContentPane().removeAll();
        panelLogin.armarPanelLogin();
        frame.getContentPane().add(panelLogin);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelLista()
    {
        frame.getContentPane().removeAll();
        panelLista.armarPanelLista();
        frame.getContentPane().add(panelLista);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelFormulario()
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelFormulario(Persona p)
    {
        panelFormulario.llenarFormulario(p);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void showFrame()
    {
        frame.setVisible(true);
    }

}
