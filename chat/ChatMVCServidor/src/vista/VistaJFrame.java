package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VistaJFrame extends JFrame implements IVista {

	Controlador controlador;
	
	 JPanel contentPane;
	 JTextField textField_TextoEnviar;
	 JTextArea textAreaTrasiego;
	 JButton Button_Enviar;
	 JLabel JLabel_TextoEnviar;


	public VistaJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaTrasiego = new JTextArea();
		textAreaTrasiego.setBackground(Color.PINK);
		textAreaTrasiego.setForeground(Color.BLACK);
		textAreaTrasiego.setBounds(10, 11, 414, 177);
		contentPane.add(textAreaTrasiego);
		
		JLabel_TextoEnviar = new JLabel("Texto a enviar:");
		JLabel_TextoEnviar.setBounds(10, 202, 89, 14);
		contentPane.add(JLabel_TextoEnviar);
		
		textField_TextoEnviar = new JTextField();
		textField_TextoEnviar.setBounds(109, 199, 315, 20);
		contentPane.add(textField_TextoEnviar);
		textField_TextoEnviar.setColumns(10);
		
		Button_Enviar = new JButton("Enviar");
		Button_Enviar.setBounds(335, 230, 89, 23);
		contentPane.add(Button_Enviar);
		
		
	}

	@Override
	public void habilitarEnviar() {
		Button_Enviar.setEnabled(true);
		
	}

	@Override
	public void deshabilitarEnviar() {
		Button_Enviar.setEnabled(false);
	}

	@Override
	public void agregarMensajeTrasiego(String mensaje) {
		textAreaTrasiego.append(mensaje + "\n");
		
	}

	@Override
	public void vaciarTextField() {
		textField_TextoEnviar.setText("");
		
	}

	@Override
	public void setControlador(Controlador c) {
		this.controlador = c;
		
	}

	@Override
	public void hacerVisible() {
		// TODO Auto-generated method stub
		setVisible(true);
	}

	@Override
	public void inicializar() {
		Button_Enviar.setActionCommand(ENVIAR);
		Button_Enviar.addActionListener(controlador);
	}

	@Override
	public String getMensaje() {
		return textField_TextoEnviar.getText();
	}

}
