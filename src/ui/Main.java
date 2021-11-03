package ui;

import ui.PanelManager;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Propuesta Arquitectura Swing");


	   	PanelManager panelManager = new PanelManager();
	    panelManager.armarManager();
		panelManager.mostrarLogin();
	    //panelManager.mostrarPanelLista();
	    panelManager.showFrame();




    }
}
