package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloCliente;
import vista.IVista;

public class ControladorCliente implements ActionListener {
	
	IVista vista;
	ModeloCliente modelo;
	
	public ControladorCliente (IVista vistaa, ModeloCliente modeloo) {
		vista = vistaa;
		modelo = modeloo;
	}
	
	public void empezar() {
		vista.hacerVisible();
		vista.inicializar();
		vista.agregarMensajeTrasiego("conectando al server");
		modelo.conectarServidor();
		vista.agregarMensajeTrasiego("conectado");
		modelo.crearFlujos();
		modelo.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case IVista.ENVIAR:
				vista.agregarMensajeTrasiego("enviando mensaje al servidor");
				vista.deshabilitarEnviar();
				modelo.enviarMensaje(vista.getMensaje());
				vista.habilitarEnviar();
				vista.agregarMensajeTrasiego("mensaje enviado");
				vista.vaciarTextField();
				break;
			
		}
	}

	public void agregarMensajeTrasiego(String mensaje) {
		vista.agregarMensajeTrasiego(mensaje);
	}
}
