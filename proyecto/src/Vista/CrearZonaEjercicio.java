package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Profesor;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class CrearZonaEjercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearZonaEjercicio frame = new CrearZonaEjercicio(null);
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
	public CrearZonaEjercicio(Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Cree su zona ejercicio");
		label.setBounds(139, 10, 214, 22);
		contentPane.add(label);
		
		TextField txtNombre = new TextField();
		txtNombre.setBounds(53, 88, 113, 22);
		contentPane.add(txtNombre);
		
		Label label_1 = new Label("Ingrese el nombre de la zona");
		label_1.setBounds(50, 60, 205, 22);
		contentPane.add(label_1);
		
		Label lvlResultadoPositivo = new Label("");
		lvlResultadoPositivo.setBackground(SystemColor.control);
		lvlResultadoPositivo.setForeground(new Color(0, 255, 0));
		lvlResultadoPositivo.setBounds(51, 129, 256, 22);
		contentPane.add(lvlResultadoPositivo);
		lvlResultadoPositivo.setVisible(false);

		
		Label lvlResultadoNegativo = new Label("");
		lvlResultadoNegativo.setForeground(new Color(255, 0, 0));
		lvlResultadoNegativo.setBounds(51, 129, 158, 22);
		contentPane.add(lvlResultadoNegativo);
		lvlResultadoNegativo.setVisible(false);
		
		
		Button btnCrear = new Button("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = profesor.CrearZona(txtNombre.getText());
				
				if (resultado.equals("")) {
					lvlResultadoNegativo.setText("Escriba un nombre correcto para su crear su zona");
					lvlResultadoNegativo.setVisible(true);
				}
				else if (resultado.equals("Su zona fue creada correctamente")) {
					lvlResultadoPositivo.setText(resultado);
					lvlResultadoPositivo.setVisible(true);
				} else if (resultado.equals("Error al crear su zona")) {
					lvlResultadoNegativo.setText(resultado);
					lvlResultadoNegativo.setVisible(true);
				} else {
					lvlResultadoNegativo.setText("Ingrese un nombre correcto");
					lvlResultadoNegativo.setVisible(true);
				}
				
			}
		});
		
		
		btnCrear.setBounds(139, 176, 70, 22);
		contentPane.add(btnCrear);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZonaEjercicioVista menuatras = new ZonaEjercicioVista(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(220, 176, 70, 22);
		contentPane.add(btnSalir);
		

	}
}
