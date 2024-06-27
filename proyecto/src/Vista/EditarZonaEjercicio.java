package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Zona_Ejercicio;
import Modelo.Profesor;
import Controladores.ZonaControlador;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class EditarZonaEjercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarZonaEjercicio frame = new EditarZonaEjercicio(null, null);
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
	public EditarZonaEjercicio(Zona_Ejercicio seleccionado, Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Editar Zona Ejercicio");
		label.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		label.setBounds(139, 20, 214, 22);
		contentPane.add(label);
		
		TextField txtNombre = new TextField();
		txtNombre.setBounds(53, 88, 113, 22);
		contentPane.add(txtNombre);
		txtNombre.setText(seleccionado.getNombre());
		
		Label label_1 = new Label("Nombre");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
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
		
		
		Button btnGuardar = new Button("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (txtNombre.getText().equals("") || !txtNombre.getText().chars().allMatch(Character::isLetter)) {
					lvlResultadoNegativo.setText("Escriba un nombre correcto para editar su zona");
					lvlResultadoNegativo.setVisible(true);
				}
				else {
					ZonaControlador controlador = new ZonaControlador();
					seleccionado.setNombre(txtNombre.getText());
					controlador.updateZona(seleccionado);
					lvlResultadoPositivo.setText("Se actualizo su zona correctamente");
					lvlResultadoPositivo.setVisible(true);
				} 
				
				
			}
		});
		
		
		btnGuardar.setBounds(139, 176, 70, 22);
		contentPane.add(btnGuardar);
		
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
