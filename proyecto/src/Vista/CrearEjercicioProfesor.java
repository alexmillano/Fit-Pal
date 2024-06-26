package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controladores.EjercicioControlador;
import Controladores.ZonaControlador;
import Modelo.Ejercicio;
import Modelo.Profesor;
import Modelo.Zona_Ejercicio;
import java.awt.Label;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextField;


public class CrearEjercicioProfesor extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTable table;
		private DefaultTableModel model;
		private JLabel elemento;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CrearEjercicioProfesor frame = new CrearEjercicioProfesor(null);
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
		public CrearEjercicioProfesor(Profesor profesor) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 602, 390);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			// Inicializar controlador
			EjercicioControlador controlador = new EjercicioControlador();
			Ejercicio seleccionado = new Ejercicio();

			// Crear el modelo de la tabla
			String[] columnNames = { "ID", "Nombre", "Series" , "Repeticiones" , "Zona"};
			model = new DefaultTableModel(columnNames, 0);
			table = new JTable(model);

			// Actualizar la tabla con datos
			actualizarTabla();

			// Crear el JScrollPane y agregar la tabla
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(5, 19, 571, 190);
			contentPane.add(scrollPane);

			// Crear el JLabel para mostrar la selección
			elemento = new JLabel("Seleccionado:");
			elemento.setBounds(5, 5, 571, 14);  // Ajustar el ancho para que no se superponga con otros componentes
			contentPane.add(elemento);
			
			
			Label lvlResultado = new Label("New label");
			lvlResultado.setForeground(new Color(0, 255, 0));
			lvlResultado.setBackground(SystemColor.control);
			lvlResultado.setBounds(167, 305, 301, 22);
			contentPane.add(lvlResultado);
			lvlResultado.setVisible(false);
			
			
			Label lvlError = new Label("New label");
			lvlError.setForeground(new Color(255, 0, 0));
			lvlError.setBackground(SystemColor.control);
			lvlError.setVisible(false);
			lvlError.setBounds(167, 305, 301, 22);
			contentPane.add(lvlError);
			

			// Botón para crear una nueva zona
			JButton btnCrearZona = new JButton("Añadir");
			btnCrearZona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AnadirEjercicio anadirejercicio = new AnadirEjercicio(profesor);
					anadirejercicio.setVisible(true);
					dispose();
				}
			});
			btnCrearZona.setBounds(37, 260, 120, 38);  // Ajustar tamaño para mejorar la visualización
			contentPane.add(btnCrearZona);
			
			
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (seleccionado.getID_Ejercicios()!=0) {				
						EditarEjercicio editar = new EditarEjercicio(profesor,seleccionado);
						editar.setVisible(true);
						dispose();
					}		
				}
			});
			
			
			btnEditar.setBounds(167, 260, 120, 38);
			contentPane.add(btnEditar);
			

			// Configurar el modelo de selección de la tabla
			ListSelectionModel selectionModel = table.getSelectionModel();
			selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// Agregar un escuchador de selección
			selectionModel.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
						int selectedRow = table.getSelectedRow();
						int id = (int) table.getValueAt(selectedRow, 0);
						String nombre = (String) table.getValueAt(selectedRow, 1);
						int repeticiones = (int) table.getValueAt(selectedRow, 2);
						int series = (int) table.getValueAt(selectedRow, 3);
						int idzona =0 ;
						ZonaControlador controladorZona = new ZonaControlador();
						
						for (Zona_Ejercicio zona : controladorZona.getAllZonas()) {
							if (zona.getNombre().equals(table.getValueAt(selectedRow, 4))) {
								idzona=zona.getID_Zona_Ejercicio();
							}
						}
						
						elemento.setText("Seleccionado: ID= " + id + ", Nombre= " + nombre + ", Repeticiones= " + repeticiones + ", Series= " + series + ", ID_Zona_Ejercicio= " + idzona);
						seleccionado.setID_Ejercicios(id);
						seleccionado.setNombre(nombre);
						seleccionado.setRepeticion(repeticiones);
						seleccionado.setSeries(series);
						seleccionado.setID_Zona_Ejercicio(idzona); 	
					}
				}
			});
			
			
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
		    		if (seleccionado.getID_Ejercicios()!=0) {
						controlador.deleteEjercicio(seleccionado.getID_Ejercicios());;
						System.out.println("Eliminaste el ejercicio");
						lvlResultado.setText("Eliminaste el ejercicio correctamente");
						lvlResultado.setVisible(true);
						actualizarTabla();
						seleccionado.setID_Ejercicios(0);
					}else {
						lvlResultado.setText("");
					}
		    						
				}
			});
			
			btnEliminar.setBounds(297, 260, 120, 38);
			contentPane.add(btnEliminar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuEjerciciosProfesor menuatras= new MenuEjerciciosProfesor(profesor);
					menuatras.setVisible(true);
					dispose();
				}
			});
			btnSalir.setBounds(422, 260, 120, 38);
			contentPane.add(btnSalir);
			
			TextField txtFiltro = new TextField();
			txtFiltro.setBounds(95, 211, 119, 22);
			contentPane.add(txtFiltro);
			
			JButton btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					Filtrar(txtFiltro.getText());			
				}
			});
			btnFiltrar.setBounds(15, 211, 73, 22);
			contentPane.add(btnFiltrar);
			
			JButton btnRestablecer = new JButton("Restablecer");
			btnRestablecer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarTabla();
					txtFiltro.setText("");
				}
			});
			btnRestablecer.setBounds(220, 211, 120, 22);
			contentPane.add(btnRestablecer);
				
		}
				

		private void actualizarTabla() {
			// Limpiar el modelo de la tabla
			model.setRowCount(0);

			// Obtener la lista actualizada de zonas de ejercicio
			EjercicioControlador controlador = new EjercicioControlador();
			ZonaControlador controladorZona = new ZonaControlador();
			String nombreZona = "";

			// Agregar los datos al modelo
			for (Ejercicio ejercicio : controlador.getAllEjercicio()) {
				for (Zona_Ejercicio zona : controladorZona.getAllZonas()) {
					if (zona.getID_Zona_Ejercicio()==ejercicio.getID_Zona_Ejercicio()) {
						nombreZona = zona.getNombre();
					}
				}
				
				model.addRow(new Object[] { ejercicio.getID_Ejercicios() , ejercicio.getNombre() , ejercicio.getRepeticion() , ejercicio.getSeries() , nombreZona });
			}
		}
		
		
		private void Filtrar(String criterio) {
			// Limpiar el modelo de la tabla
			if (!criterio.isEmpty()) {
				
				model.setRowCount(0);
				
				// Obtener la lista actualizada de zonas de ejercicio
				EjercicioControlador controlador = new EjercicioControlador();
				ZonaControlador controladorZona = new ZonaControlador();
				String nombreZona = "";
				criterio = criterio.toLowerCase();
				
				
				for (Ejercicio ejercicio : controlador.getAllEjercicio()) {
					
					for (Zona_Ejercicio zona : controladorZona.getAllZonas()) {
						if (zona.getID_Zona_Ejercicio()==ejercicio.getID_Zona_Ejercicio()) {
							nombreZona = zona.getNombre();
						}
					}
					String nombreEjercicio = ejercicio.getNombre().toLowerCase();
					String nombreZonaMinusculas = nombreZona.toLowerCase();
					
					
					if (nombreEjercicio.contains(criterio) || nombreZonaMinusculas.contains(criterio)){
						model.addRow(new Object[] { ejercicio.getID_Ejercicios() , ejercicio.getNombre() , ejercicio.getRepeticion() , ejercicio.getSeries() , nombreZona });
					}		
				}
			}
			
		}
	}