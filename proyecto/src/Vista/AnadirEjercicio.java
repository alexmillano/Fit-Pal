package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Profesor;
import Modelo.Zona_Ejercicio;
import Controladores.ZonaControlador;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.List;
import javax.swing.JComboBox;

public class AnadirEjercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirEjercicio frame = new AnadirEjercicio(null);
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
	public AnadirEjercicio(Profesor profesor) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Cree su ejercicio");
		label.setBounds(139, 10, 214, 22);
		contentPane.add(label);
		
		TextField txtNombre = new TextField();
		txtNombre.setBounds(53, 88, 113, 22);
		contentPane.add(txtNombre);
		
		Label label_1 = new Label("Ingrese el nombre del ejercicio");
		label_1.setBounds(50, 60, 205, 22);
		contentPane.add(label_1);
		
		Label lvlResultadoPositivo = new Label("");
		lvlResultadoPositivo.setBackground(SystemColor.control);
		lvlResultadoPositivo.setForeground(new Color(0, 255, 0));
		lvlResultadoPositivo.setBounds(53, 317, 316, 22);
		contentPane.add(lvlResultadoPositivo);
		lvlResultadoPositivo.setVisible(false);

		
		Label lvlResultadoNegativo = new Label("");
		lvlResultadoNegativo.setForeground(new Color(255, 0, 0));
		lvlResultadoNegativo.setBounds(53, 317, 316, 22);
		contentPane.add(lvlResultadoNegativo);
		lvlResultadoNegativo.setVisible(false);
		
		Label label_1_1 = new Label("Ingrese la cantidad de repeticiones");
		label_1_1.setBounds(53, 120, 205, 22);
		contentPane.add(label_1_1);
		
		TextField txtRepeticiones = new TextField();
		txtRepeticiones.setBounds(56, 148, 113, 22);
		contentPane.add(txtRepeticiones);
		
		TextField txtSeries = new TextField();
		txtSeries.setBounds(56, 208, 113, 22);
		contentPane.add(txtSeries);
		
		Label label_1_1_1 = new Label("Ingrese la cantidad de series");
		label_1_1_1.setBounds(53, 180, 205, 22);
		contentPane.add(label_1_1_1);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(53, 273, 141, 22);
		contentPane.add(comboBox);
		
		Label label_1_1_1_1 = new Label("Seleccione la zona de su ejercicio");
		label_1_1_1_1.setBounds(53, 236, 205, 22);
		contentPane.add(label_1_1_1_1);
		
		ZonaControlador controlador = new ZonaControlador();
		for (Zona_Ejercicio zona : controlador.getAllZonas()) {
			comboBox.addItem(zona.getNombre());
		}
		
		Button btnCrear = new Button("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID_Zona =(String) comboBox.getSelectedItem();
				String resultado = profesor.CrearEjercicio(txtNombre.getText(), txtRepeticiones.getText(), txtSeries.getText(), ID_Zona);
				
				if (resultado.equals("Su ejercicio fue creado correctamente")) {
					lvlResultadoPositivo.setText(resultado);
					lvlResultadoPositivo.setVisible(true);
					CrearEjercicioProfesor menuatras = new CrearEjercicioProfesor(profesor);
					menuatras.setVisible(true);
					dispose();
				}else {
					lvlResultadoNegativo.setText(resultado);
					lvlResultadoNegativo.setVisible(true);
				}
				
			}
		});
		
		
		btnCrear.setBounds(150, 361, 70, 22);
		contentPane.add(btnCrear);
		
		Button btnSalir = new Button("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEjercicioProfesor menuatras = new CrearEjercicioProfesor(profesor);
				menuatras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(231, 361, 70, 22);
		contentPane.add(btnSalir);
		

	}
}
