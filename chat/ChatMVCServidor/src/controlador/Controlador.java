package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloServidor;
import vista.IVista;

public class Controlador implements ActionListener {
	
	IVista vista;
	ModeloServidor modelo;
	
	public Controlador(IVista vistaa, ModeloServidor modeloo) {
		vista = vistaa;
		modelo = modeloo;
	}
	
	public void empezar() {
		vista.hacerVisible();
		vista.inicializar();
		vista.agregarMensajeTrasiego("abriendo el puerto");
		modelo.abrirPuerto();
		vista.agregarMensajeTrasiego("esperando al cliente");
		modelo.esperarCliente();
		modelo.crearFlujos();
		modelo.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case IVista.ENVIAR:
				vista.agregarMensajeTrasiego("enviando mensaje al cliente");
				vista.deshabilitarEnviar();
				modelo.enviarMensaje(vista.getMensaje());
				vista.habilitarEnviar();
				vista.agregarMensajeTrasiego("mensaje enviado al cliente");
				vista.vaciarTextField();
				break;
			
		}
	}

	public void agregarMensajeTrasiego(String mensaje) {
		vista.agregarMensajeTrasiego(mensaje);
	}
}
