package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


import controlador.ControladorCliente;

public class ModeloCliente extends Thread {
	ControladorCliente controlador;
	final int PUERTO = 4080;
	final String HOST = "localhost";

	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	
	public void setControlador(ControladorCliente controlador) {
		this.controlador = controlador;
	}
	

	
	public void conectarServidor() {
		try {
			socket = new Socket(HOST, PUERTO);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void crearFlujos() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osr = new OutputStreamWriter(os);
			bw = new BufferedWriter(osr);
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void enviarMensaje(String mensaje) {
		try {
			bw.write(mensaje);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String recibirMensaje() {
		try {
			String mensaje = br.readLine();
			return mensaje;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	public void run() {
		while(true) {
			String mensaje = recibirMensaje();
			controlador.agregarMensajeTrasiego("server dice :" + mensaje);
		}
	}
}
