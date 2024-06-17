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

import Controladores.ZonaControlador;
import Modelo.Clase;
import Modelo.Profesor;
import Modelo.Zona_Ejercicio;
import java.awt.Label;
import java.awt.Color;
import java.awt.SystemColor;


public class ZonaEjercicioVista extends JFrame {

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
						ZonaEjercicioVista frame = new ZonaEjercicioVista(null);
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
		public ZonaEjercicioVista(Profesor profesor) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 602, 390);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			// Inicializar controlador
			ZonaControlador controlador = new ZonaControlador();
			Zona_Ejercicio seleccionado = new Zona_Ejercicio();

			// Crear el modelo de la tabla
			String[] columnNames = { "ID", "Nombre" };
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
			lvlResultado.setBounds(157, 290, 301, 22);
			contentPane.add(lvlResultado);
			lvlResultado.setVisible(false);
			
			
			Label lvlError = new Label("New label");
			lvlError.setForeground(new Color(255, 0, 0));
			lvlError.setBackground(SystemColor.control);
			lvlError.setVisible(false);
			lvlError.setBounds(157, 290, 301, 22);
			contentPane.add(lvlError);
			

			// Botón para crear una nueva zona
			JButton btnCrearZona = new JButton("Añadir");
			btnCrearZona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CrearZonaEjercicio crearzonaejercicio = new CrearZonaEjercicio(profesor);
					crearzonaejercicio.setVisible(true);
					dispose();
				}
			});
			btnCrearZona.setBounds(37, 229, 120, 38);  // Ajustar tamaño para mejorar la visualización
			contentPane.add(btnCrearZona);
			
			
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditarZonaEjercicio editarzonaejercicio = new EditarZonaEjercicio(seleccionado,profesor);
					editarzonaejercicio.setVisible(true);
					dispose();
					
				}
			});
			btnEditar.setBounds(167, 229, 120, 38);
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

						elemento.setText("Seleccionado: ID= " + id + ", Nombre= " + nombre);
						seleccionado.setID_Zona_Ejercicio(id);
						seleccionado.setNombre(nombre);
					}
				}
			});
			
			
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
		    		if (seleccionado.getID_Zona_Ejercicio()!=0) {
						controlador.deleteZona(seleccionado.getID_Zona_Ejercicio());
						System.out.println("Eliminaste la zona");
						lvlResultado.setText("Eliminaste la zona correctamente");
						lvlResultado.setVisible(true);
						actualizarTabla();
						seleccionado.setID_Zona_Ejercicio(0);
					} else {
						 System.out.println("No pudiste eliminar la zona");
						 lvlResultado.setVisible(false);
						 lvlError.setText("Selecciona una zona para eliminar");
						 lvlError.setVisible(true);
					}
		    						
				}
			});
			
			btnEliminar.setBounds(297, 229, 120, 38);
			contentPane.add(btnEliminar);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuEjerciciosProfesor menuatras= new MenuEjerciciosProfesor(profesor);
					menuatras.setVisible(true);
					dispose();
				}
			});
			btnSalir.setBounds(422, 229, 120, 38);
			contentPane.add(btnSalir);
			

			
			
		}
		
		
		
		

		private void actualizarTabla() {
			// Limpiar el modelo de la tabla
			model.setRowCount(0);

			// Obtener la lista actualizada de zonas de ejercicio
			ZonaControlador controlador = new ZonaControlador();

			// Agregar los datos al modelo
			for (Zona_Ejercicio zona : controlador.getAllZonas()) {
				model.addRow(new Object[] { zona.getID_Zona_Ejercicio(), zona.getNombre() });
			}
		}
	}