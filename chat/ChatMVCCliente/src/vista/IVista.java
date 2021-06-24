package vista;

import controlador.ControladorCliente;

public interface IVista {

	final String ENVIAR = "ENVIAR";
	
	public void habilitarEnviar();
	public void deshabilitarEnviar();
	public void agregarMensajeTrasiego(String mensaje);
	public void vaciarTextField();
	public void setControlador(ControladorCliente c);
	public void hacerVisible();
	public void inicializar();
	public String getMensaje();
	
}
