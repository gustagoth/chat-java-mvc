package vista;

import controlador.Controlador;

public interface IVista {

	final String ENVIAR = "ENVIAR";
	
	public void habilitarEnviar();
	public void deshabilitarEnviar();
	public void agregarMensajeTrasiego(String mensaje);
	public void vaciarTextField();
	public void setControlador(Controlador c);
	public void hacerVisible();
	public void inicializar();
	public String getMensaje();
	
}
