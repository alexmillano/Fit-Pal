package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Rutinas_Ejercicios;
import Modelo.Profesor;
import Modelo.Rutina;
import Modelo.Ejercicio;
import Modelo.Zona_Ejercicio;
import Controladores.RutinaControlador;
import Controladores.EjercicioControlador;
import Controladores.Rutina_EjerciciosControlador;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.List;
import javax.swing.JComboBox;

public class AnadirRutina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirRutina frame = new AnadirRutina(null,null);
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
	public AnadirRutina(Rutina rutina,Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Cree su ejercicio");
		label.setBounds(139, 10, 214, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Nivel");
		label_1.setBounds(50, 60, 113, 22);
		contentPane.add(label_1);
		
		Label lvlResultadoPositivo = new Label("");
		lvlResultadoPositivo.setBackground(SystemColor.control);
		lvlResultadoPositivo.setForeground(new Color(0, 255, 0));
		lvlResultadoPositivo.setBounds(50, 244, 316, 22);
		contentPane.add(lvlResultadoPositivo);
		lvlResultadoPositivo.setVisible(false);

		
		Label lvlResultadoNegativo = new Label("");
		lvlResultadoNegativo.setForeground(new Color(255, 0, 0));
		lvlResultadoNegativo.setBounds(50, 244, 316, 22);
		contentPane.add(lvlResultadoNegativo);
		lvlResultadoNegativo.setVisible(false);
		
		Label label_1_1 = new Label("Nombre");
		label_1_1.setBounds(219, 60, 205, 22);
		contentPane.add(label_1_1);
		
		TextField txtNombre = new TextField();
		txtNombre.setBounds(216, 88, 113, 22);
		contentPane.add(txtNombre);
		
		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setBounds(50, 88, 141, 22);
		contentPane.add(comboBox);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		
		JComboBox<String> comboBoxEj1 = new JComboBox<String>();
		comboBoxEj1.setBounds(50, 155, 141, 22);
		contentPane.add(comboBoxEj1);
		EjercicioControlador controladorejercicio = new EjercicioControlador();
		
		Label label_1_2 = new Label("Ejercicio 1");
		label_1_2.setBounds(50, 127, 113, 22);
		contentPane.add(label_1_2);
		
		JComboBox<String> comboBoxEj2 = new JComboBox<String>();
		comboBoxEj2.setBounds(212, 155, 141, 22);
		contentPane.add(comboBoxEj2);
		
		Label label_1_2_1 = new Label("Ejercicio 2");
		label_1_2_1.setBounds(212, 127, 113, 22);
		contentPane.add(label_1_2_1);
		
		for (Ejercicio ejercicio : controladorejercicio.getAllEjercicio()) {
			comboBoxEj1.addItem(ejercicio.getNombre());
			comboBoxEj2.addItem(ejercicio.getNombre());
		}
		
		
		Button btnCrear = new Button("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					RutinaControlador controladorComprobacion = new RutinaControlador();
					String flag = controladorComprobacion.getRutinaByNombre(txtNombre.getText());
					String combo1=(String)comboBoxEj1.getSelectedItem();
					String combo2=(String)comboBoxEj2.getSelectedItem();
					
					if (!txtNombre.getText().isEmpty() && flag.contains("No hay una rutina con ese nombre") && !combo1.equals(combo2)) {
						
						
						RutinaControlador controlador = new RutinaControlador();
						Rutina rutinanueva = new Rutina(profesor.getID_Profesor(),(int)comboBox.getSelectedItem(), txtNombre.getText());
						controlador.addRutina(rutinanueva);
						lvlResultadoPositivo.setText("Su rutina se creo correctamente");
						lvlResultadoPositivo.setVisible(true);
						//Rutina
						
						//Clase intermedia
						int IdEjercicio1=0;
						int IdEjercicio2=0;
						
						EjercicioControlador controladorejercicio = new EjercicioControlador();
						
						for (Ejercicio ejercicio : controladorejercicio.getAllEjercicio()) {
							if (ejercicio.getNombre().equals(combo1)) {
								IdEjercicio1=ejercicio.getID_Ejercicios();
								System.out.println("ej1");
							}
							if (ejercicio.getNombre().equals(combo2)) {
								IdEjercicio2=ejercicio.getID_Ejercicios();
								System.out.println("ej2");
							}
							
						}
						
						
						for (Rutina rutina : controlador.getAllRutina()) {
							if (rutina.getID_Profesor()==profesor.getID_Profesor() && rutina.getNivel()==(int)comboBox.getSelectedItem() && rutina.getNombre().contains(txtNombre.getText())) {
								System.out.println("si");
								Rutina_EjerciciosControlador intermedia = new Rutina_EjerciciosControlador();
								Rutinas_Ejercicios RutinayEjercicio1 = new Rutinas_Ejercicios(rutina.getID_Rutinas(),IdEjercicio1);
								Rutinas_Ejercicios RutinayEjercicio2 = new Rutinas_Ejercicios(rutina.getID_Rutinas(),IdEjercicio2);
								intermedia.addRutinaEjercicio(RutinayEjercicio1);
								intermedia.addRutinaEjercicio(RutinayEjercicio2);
								
							}
							
						}
						
						
								
						RutinaTabla menuatras = new RutinaTabla(profesor);
						menuatras.setVisible(true);
						dispose();
					}else if (flag.contains("Ya hay una rutina con ese nombre")) {
						lvlResultadoNegativo.setText("Ya existe una rutina con ese nombre");
						lvlResultadoNegativo.setVisible(true);
					}else if (combo1.equals(combo2)) {
						lvlResultadoNegativo.setText("Elija ejercicios distintos");
						lvlResultadoNegativo.setVisible(true);
					} else {
						lvlResultadoNegativo.setText("Complete el nombre de su rutina");
						lvlResultadoNegativo.setVisible(true);
					}
					
				} catch (Exception e2) {
					lvlResultadoNegativo.setText("Error al crear su rutina");
					lvlResultadoNegativo.setVisible(true);
				}
		
				
			}
		});
		
		
		btnCrear.setBounds(139, 204, 70, 22);
		contentPane.add(btnCrear);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RutinaTabla menuatras = new RutinaTabla(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(237, 204, 70, 22);
		contentPane.add(btnSalir);

	}
}
