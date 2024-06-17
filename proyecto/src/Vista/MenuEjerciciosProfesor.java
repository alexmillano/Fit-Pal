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
		setBounds(100, 100, 490, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Ejercicios");
		label.setBounds(149, 33, 62, 22);
		contentPane.add(label);
		
		Button btnCrearEjercicio = new Button("Crear Ejercicio");
		btnCrearEjercicio.setBounds(10, 114, 88, 22);
		contentPane.add(btnCrearEjercicio);
		
		Button btnVerEjercicios = new Button("Ver Ejercicios");
		btnVerEjercicios.setBounds(104, 114, 84, 22);
		contentPane.add(btnVerEjercicios);
		
		Button btnZonaEjercicio = new Button("Zona Ejercicio");
		btnZonaEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZonaEjercicioVista zonaejercicio = new ZonaEjercicioVista(profesor);
				zonaejercicio.setVisible(true);
				dispose();
				
			}
		});
		btnZonaEjercicio.setBounds(194, 114, 121, 22);
		contentPane.add(btnZonaEjercicio);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfesor menuatras = new MenuProfesor(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(321, 114, 121, 22);
		contentPane.add(btnSalir);
	}
}
