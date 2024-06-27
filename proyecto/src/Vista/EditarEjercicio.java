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
import Modelo.Zona_Ejercicio;
import java.awt.Font;

public class EditarEjercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarEjercicio frame = new EditarEjercicio(null,null);
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
	public EditarEjercicio(Profesor profesor, Ejercicio seleccionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Editar Ejercicio");
		label.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		label.setBounds(137, 23, 214, 22);
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
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(53, 293, 141, 22);
		contentPane.add(comboBox);
		
		Label label_1_1_1_1 = new Label("Seleccione la zona de su ejercicio");
		label_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1_1.setBounds(50, 265, 205, 22);
		contentPane.add(label_1_1_1_1);
		
		ZonaControlador controlador = new ZonaControlador();
		for (Zona_Ejercicio zona : controlador.getAllZonas()) {
			comboBox.addItem(zona.getNombre());
		}
		
		
		Label label_1_1 = new Label("Repeticiones");
		label_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1.setBounds(50, 129, 205, 22);
		contentPane.add(label_1_1);

		
		TextField txtRepeticiones = new TextField();
		txtRepeticiones.setText(Integer.toString(seleccionado.getRepeticion()));
		txtRepeticiones.setBounds(53, 157, 113, 22);
		contentPane.add(txtRepeticiones);
		
		Label label_1_1_1 = new Label("Series");
		label_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1_1_1.setBounds(53, 197, 205, 22);
		contentPane.add(label_1_1_1);
		
		TextField txtSeries = new TextField();
		txtSeries.setText(Integer.toString(seleccionado.getSeries()));
		txtSeries.setBounds(53, 225, 113, 22);
		contentPane.add(txtSeries);
		
		
		
		Button btnGuardar = new Button("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNombre.getText().equals("") || !txtNombre.getText().chars().allMatch(Character::isLetter) ) {
					lvlResultadoNegativo.setText("Complete los datos correctamente");
					lvlResultadoNegativo.setVisible(true);
				}else if (txtRepeticiones.getText().equals("") || !txtRepeticiones.getText().chars().allMatch(Character::isDigit) ) {
					lvlResultadoNegativo.setText("Complete las repeticiones correctamente");
					lvlResultadoNegativo.setVisible(true);
				}else if (txtSeries.getText().equals("") || !txtSeries.getText().chars().allMatch(Character::isDigit)) {
					lvlResultadoNegativo.setText("Complete las series correctamente");
					lvlResultadoNegativo.setVisible(true);
				}else {
					EjercicioControlador controlador = new EjercicioControlador();
					seleccionado.setNombre(txtNombre.getText());
					seleccionado.setRepeticion(Integer.parseInt(txtRepeticiones.getText()));
					seleccionado.setSeries(Integer.parseInt(txtSeries.getText()));
					
					String ID_Zona =(String) comboBox.getSelectedItem();
					int Id_Zona_Numerico = 0;
					ZonaControlador controladorZona = new ZonaControlador();
					
					for (Zona_Ejercicio zona : controladorZona.getAllZonas()) {
						if (zona.getNombre().equals(ID_Zona)) {
							Id_Zona_Numerico=zona.getID_Zona_Ejercicio();
						}
					}
					
					seleccionado.setID_Zona_Ejercicio(Id_Zona_Numerico);				
					controlador.updateEjercicio(seleccionado);
					lvlResultadoPositivo.setText("Se actualizo su ejercicio correctamente");
					lvlResultadoPositivo.setVisible(true);
					
					CrearEjercicioProfesor menuatras = new CrearEjercicioProfesor(profesor);
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
				CrearEjercicioProfesor menuatras = new CrearEjercicioProfesor(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(237, 384, 70, 22);
		contentPane.add(btnSalir);
		
	
		

	
	}
}
