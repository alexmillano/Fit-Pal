package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Profesor;

import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuProfesor frame = new MenuProfesor(null);
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
	public MenuProfesor(Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Esto es menu profesor");
		lblNewLabel.setSize(175, 32);
		lblNewLabel.setLocation(130, 11);
		contentPane.add(lblNewLabel);
		
		Button rutinasbtn = new Button("Rutinas");
		rutinasbtn.setBounds(84, 100, 70, 22);
		contentPane.add(rutinasbtn);
		
		Button ejerciciosbtn = new Button("Ejercicios");
		ejerciciosbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEjerciciosProfesor menuejercicios = new MenuEjerciciosProfesor(profesor);
				menuejercicios.setVisible(true);
				dispose();
				
			}
		});
		ejerciciosbtn.setBounds(160, 100, 70, 22);
		contentPane.add(ejerciciosbtn);
		
		Button clasesbtn = new Button("Clases");
		clasesbtn.setBounds(238, 100, 70, 22);
		contentPane.add(clasesbtn);
		
		Button clientesbtn = new Button("Clientes");
		clientesbtn.setBounds(85, 135, 70, 22);
		contentPane.add(clientesbtn);
		
		Button perfilbtn = new Button("Perfil");
		perfilbtn.setBounds(160, 135, 70, 22);
		contentPane.add(perfilbtn);
		
		Button cerrarsesionbtn = new Button("Cerrar Sesion");
		cerrarsesionbtn.setBounds(238, 135, 81, 22);
		contentPane.add(cerrarsesionbtn);
	}

}
