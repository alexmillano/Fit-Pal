package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Profesor;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuEjerciciosProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEjerciciosProfesor frame = new MenuEjerciciosProfesor(null);
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
	public MenuEjerciciosProfesor(Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Ejercicios");
		label.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		label.setBounds(164, 34, 121, 22);
		contentPane.add(label);
		
		Button btnCrearEjercicio = new Button("Ejercicio");
		btnCrearEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEjercicioProfesor crearejercicio = new CrearEjercicioProfesor(profesor);
				crearejercicio.setVisible(true);
				dispose();
			}
		});
		btnCrearEjercicio.setBounds(55, 113, 88, 22);
		contentPane.add(btnCrearEjercicio);
		
		Button btnZonaEjercicio = new Button("Zona Ejercicio");
		btnZonaEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZonaEjercicioVista zonaejercicio = new ZonaEjercicioVista(profesor);
				zonaejercicio.setVisible(true);
				dispose();
				
			}
		});
		btnZonaEjercicio.setBounds(149, 113, 121, 22);
		contentPane.add(btnZonaEjercicio);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfesor menuatras = new MenuProfesor(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(276, 113, 121, 22);
		contentPane.add(btnSalir);
	}
}
