package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ClienteControlador;
import Modelo.Cliente;
import Modelo.Persona;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Color;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label correoLvl = new Label("Correo");
		correoLvl.setBounds(113, 50, 62, 22);
		contentPane.add(correoLvl);
				
		Label contraseñaLvl = new Label("Contraseña");
		contraseñaLvl.setBounds(113, 117, 95, 22);
		contentPane.add(contraseñaLvl);
		
		
		Label sesioniniciada = new Label("Sesion Iniciada");
		sesioniniciada.setForeground(new Color(0, 255, 0));
		sesioniniciada.setBounds(108, 218, 211, 20); 
		contentPane.add(sesioniniciada);
		sesioniniciada.setVisible(false);
		
		
		Label error = new Label("Error en el inicio de sesion");
		error.setForeground(new Color(255, 0, 0));
		error.setBounds(108, 218, 313, 20); 
		contentPane.add(error);
		error.setVisible(false);

		
		TextField correoTF = new TextField();
		correoTF.setBounds(113, 78, 195, 22);
		contentPane.add(correoTF);
		
		TextField contraseñaTF = new TextField();
		contraseñaTF.setBounds(113, 146, 195, 22);
		contentPane.add(contraseñaTF);
		
		Button button = new Button("Ingresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				try {		
					
					Persona persona = new Persona();			
					String iniciarsesion= persona.IniciarSesion(correoTF.getText(), contraseñaTF.getText());
				
					if (iniciarsesion.equals("Email correcto cliente" ) ||  iniciarsesion.equals("Email correcto recepcion" ) || iniciarsesion.equals("Email correcto profesor" )) {
						sesioniniciada.setVisible(true);
					}else if (iniciarsesion.equals("Ingrese correctamente el mail") || iniciarsesion.equals("Ocurrió un error inesperado con su mail") || iniciarsesion.equals("Error. Debe ingresar una contraseña numerica valida") || iniciarsesion.equals("Ocurrió un error inesperado en su contraseña")) {
						error.setText(iniciarsesion);
						error.setVisible(true);
					}else	{
						error.setText(iniciarsesion);
						error.setVisible(true);
					}
									
					System.out.println("Resultado del inicio de sesión: " + iniciarsesion);
				} catch (Exception e2) {
					System.out.println(e2.getStackTrace());
				}
			}		
		});
		
		button.setBounds(185, 189, 70, 22);
		contentPane.add(button);
		


	}
}
