package ui;

import negocio.Odontologo;
import negocio.Paciente;
import negocio.Persona;

import javax.swing.*;
import java.awt.*;

public class PanelManager {

    private JFrame frame;
    private PanelLista panelLista;
    private PanelListaPaciente panelListaPaciente;
    private PanelListaOdontologo panelListaOdontologo;
    private PanelListaConsulta panelListaConsulta;
    private PanelMenuAdmin menuAdmin;
    private PanelMenuPrincipal menuPrincipal;
    private PanelLogin panelLogin;
    private PanelTurnoFormulario panelTurnoFormulario;
    private PanelFormulario panelFormulario;
    private PanelPacienteFormulario panelPacienteFormulario;
    private PanelOdontologoFormulario panelOdontologoFormulario;

    public void armarManager()
    {
        frame = new JFrame();
        frame.setBounds(100,100,500,500);

        panelLogin = new PanelLogin(this);
        panelLogin.armarPanelLogin();

        panelTurnoFormulario = new PanelTurnoFormulario(this);
        panelTurnoFormulario.armarPanelTurnoFormulario();

        panelLista = new PanelLista(this);
        panelLista.armarPanelLista();

        panelListaPaciente = new PanelListaPaciente(this);
        panelListaPaciente.armarPanelLista();

        panelListaOdontologo = new PanelListaOdontologo(this);
        panelListaOdontologo.armarPanelLista();

        panelListaConsulta = new PanelListaConsulta(this);
        panelListaConsulta.armarPanelLista();

        menuAdmin = new PanelMenuAdmin((this));
        menuAdmin.armarPaneMenuAdmin();

        menuPrincipal = new PanelMenuPrincipal((this));
        menuPrincipal.armarPaneMenuPrincipal();

        panelFormulario = new PanelFormulario(this);
        panelFormulario.armarPanelFormulario();

        panelPacienteFormulario = new PanelPacienteFormulario(this);
        panelPacienteFormulario.armarPanelPacienteFormulario();

        panelOdontologoFormulario = new PanelOdontologoFormulario(this);
        panelOdontologoFormulario.armarPanelPacienteFormulario();
    }

    public void mostrarLogin()
    {
        frame.getContentPane().removeAll();
        panelLogin.armarPanelLogin();
        frame.getContentPane().add(panelLogin);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarRegistroTurno(Paciente paciente)
    {
        frame.getContentPane().removeAll();
        panelTurnoFormulario.armaHeader(paciente);
        frame.getContentPane().add(panelTurnoFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarConsultaTurno()
    {

        frame.getContentPane().removeAll();
        panelListaConsulta.armarPanelLista();
        frame.getContentPane().add(panelListaConsulta);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarMenuAdmin()
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(menuAdmin);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarMenuPrincipal(Paciente paciente)
    {
        frame.getContentPane().removeAll();
        menuPrincipal.armaHeader(paciente);
        frame.getContentPane().add(menuPrincipal);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelListaPaciente()
    {
        frame.getContentPane().removeAll();
        panelListaPaciente.armarPanelLista();
        frame.getContentPane().add(panelListaPaciente);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelListaOdontologo()
    {
        frame.getContentPane().removeAll();
        panelListaOdontologo.armarPanelLista();
        frame.getContentPane().add(panelListaOdontologo);
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

    public void mostrarPanelPacienteFormulario()
    {
        panelPacienteFormulario.limpiaFormulario();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelPacienteFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }


    public void mostrarPanelPacienteFormulario(Paciente p)
    {
        panelPacienteFormulario.llenarFormulario(p);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelPacienteFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelOdontologoFormulario()
    {
        panelOdontologoFormulario.limpiaFormulario();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelOdontologoFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }


    public void mostrarPanelOdontologoFormulario(Odontologo p)
    {
        panelOdontologoFormulario.llenarFormulario(p);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelOdontologoFormulario);
        frame.getContentPane().validate(); //refrezcar ventana
        frame.getContentPane().repaint(); //refrezcar ventana
    }

    public void mostrarPanelFormulario()
    {

        frame.getContentPane().add(panelFormulario);
        frame.getContentPane().removeAll();
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
