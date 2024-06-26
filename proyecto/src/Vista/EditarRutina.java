package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.EjercicioControlador;
import Controladores.ZonaControlador;
import Modelo.Ejercicio;
import Modelo.Profesor;
import Modelo.Rutina;
import Modelo.Rutinas_Ejercicios;
import Modelo.Zona_Ejercicio;
import Controladores.RutinaControlador;
import Controladores.Rutina_EjerciciosControlador;
import java.awt.Font;

public class EditarRutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRutina frame = new EditarRutina(null,null);
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
	public EditarRutina(Profesor profesor, Rutina seleccionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Editar Rutina");
		label.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		label.setBounds(145, 27, 214, 22);
		contentPane.add(label);
		
		Label lvlResultadoPositivo = new Label("");
		lvlResultadoPositivo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lvlResultadoPositivo.setBackground(SystemColor.control);
		lvlResultadoPositivo.setForeground(new Color(0, 255, 0));
		lvlResultadoPositivo.setBounds(51, 340, 256, 22);
		contentPane.add(lvlResultadoPositivo);
		lvlResultadoPositivo.setVisible(false);

		
		Label lvlResultadoNegativo = new Label("");
		lvlResultadoNegativo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lvlResultadoNegativo.setForeground(new Color(255, 0, 0));
		lvlResultadoNegativo.setBounds(51, 340, 256, 22);
		contentPane.add(lvlResultadoNegativo);
		lvlResultadoNegativo.setVisible(false);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setBounds(50, 88, 141, 22);
		contentPane.add(comboBox);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		
		Label label_1_1_1_1 = new Label("Nivel");
		label_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1_1.setBounds(51, 55, 205, 22);
		contentPane.add(label_1_1_1_1);
		
		
		Label label_1_1_1_1_1 = new Label("Nombre");
		label_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1_1_1.setBounds(51, 125, 205, 22);
		contentPane.add(label_1_1_1_1_1);
		
		TextField txtNombre = new TextField();
		txtNombre.setBounds(51, 153, 141, 22);
		contentPane.add(txtNombre);
		txtNombre.setText(seleccionado.getNombre());
		
		JComboBox<String> comboBoxEj1 = new JComboBox<String>();
		comboBoxEj1.setBounds(50, 218, 141, 22);
		contentPane.add(comboBoxEj1);
		
		Label label_1_1_1_1_2 = new Label("Ejercicio 1");
		label_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1_1_2.setBounds(51, 190, 63, 22);
		contentPane.add(label_1_1_1_1_2);
		
		JComboBox<String> comboBoxEj2 = new JComboBox<String>();
		comboBoxEj2.setBounds(50, 294, 141, 22);
		contentPane.add(comboBoxEj2);
		
		Label label_1_1_1_1_2_1 = new Label("Ejercicio 2");
		label_1_1_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1_1_2_1.setBounds(51, 264, 205, 22);
		contentPane.add(label_1_1_1_1_2_1);
		
		
		
		EjercicioControlador controladorejercicio = new EjercicioControlador();
		for (Ejercicio ejercicio : controladorejercicio.getAllEjercicio()) {
			comboBoxEj1.addItem(ejercicio.getNombre());
			comboBoxEj2.addItem(ejercicio.getNombre());
		}
		
		Label anterior1 = new Label("");
		anterior1.setBounds(201, 218, 63, 22);
		contentPane.add(anterior1);
		
		Label anterior2 = new Label("");
		anterior2.setBounds(197, 294, 63, 22);
		contentPane.add(anterior2);
		
		
		Button btnGuardar = new Button("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combo1=(String)comboBoxEj1.getSelectedItem();
				String combo2=(String)comboBoxEj2.getSelectedItem();
				
				if (txtNombre.getText().equals("")) {
					lvlResultadoNegativo.setText("Complete los datos correctamente");
					lvlResultadoNegativo.setVisible(true);
				}else if (combo1.equals(combo2)) {
					lvlResultadoNegativo.setText("Elija ejercicios distintos");
					lvlResultadoNegativo.setVisible(true);
				}else {//Cambios en la tabla rutinas
					RutinaControlador controlador = new RutinaControlador();
					seleccionado.setNombre(txtNombre.getText());
					seleccionado.setNivel((int)comboBox.getSelectedItem());					
					controlador.updateRutina(seleccionado);
					lvlResultadoPositivo.setVisible(true);
					
					
					
					//Cambios en la tabla intermedia
					int IdEjercicio1=0;
					int IdEjercicio2=0;
					EjercicioControlador controladorejercicio = new EjercicioControlador();
					
					for (Ejercicio ejercicio : controladorejercicio.getAllEjercicio()) {
						if (ejercicio.getNombre().equals(combo1)) {
							IdEjercicio1=ejercicio.getID_Ejercicios();
						}
						if (ejercicio.getNombre().equals(combo2)) {
							IdEjercicio2=ejercicio.getID_Ejercicios();
						}
					}
					
					Rutina_EjerciciosControlador controladorintermedia = new Rutina_EjerciciosControlador();
					controladorintermedia.deleteRutinaEjercicio(seleccionado.getID_Rutinas());


					Rutinas_Ejercicios RutinayEjercicio1 = new Rutinas_Ejercicios(seleccionado.getID_Rutinas(),IdEjercicio1);
					Rutinas_Ejercicios RutinayEjercicio2 = new Rutinas_Ejercicios(seleccionado.getID_Rutinas(),IdEjercicio2);
					controladorintermedia.addRutinaEjercicio(RutinayEjercicio1);
					controladorintermedia.addRutinaEjercicio(RutinayEjercicio2);
							
									
					
					RutinaTabla menuatras = new RutinaTabla(profesor);
					menuatras.setVisible(true);
					dispose();
				} 			
			}
		});
		
		
		btnGuardar.setBounds(156, 384, 70, 22);
		contentPane.add(btnGuardar);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RutinaTabla menuatras = new RutinaTabla(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(237, 384, 70, 22);
		contentPane.add(btnSalir);
		


		
	
		

	
	}
}
