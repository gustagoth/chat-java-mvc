package ChatMVCServidor;

import controlador.Controlador;
import modelo.ModeloServidor;
import vista.IVista;
import vista.VistaJFrame;

public class ChatMVCServidor {

	public static void main(String[] args) {
		IVista vista = new VistaJFrame();
		ModeloServidor modelo = new ModeloServidor();
		
		Controlador controlador = new Controlador(vista, modelo);
		
		vista.setControlador(controlador);
		modelo.setControlador(controlador);
		
		controlador.empezar();
		
	}

}
