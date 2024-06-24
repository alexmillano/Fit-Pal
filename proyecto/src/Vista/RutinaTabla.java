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
import Controladores.ProfesorControlador;
import Controladores.RutinaControlador;
import Controladores.ZonaControlador;
import Modelo.Clase;
import Modelo.Ejercicio;
import Modelo.Profesor;
import Modelo.Rutina;
import Modelo.Zona_Ejercicio;
import java.awt.Label;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextField;


public class RutinaTabla extends JFrame {

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
						RutinaTabla frame = new RutinaTabla(null);
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
		public RutinaTabla(Profesor profesor) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 602, 390);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			// Inicializar controlador.
			RutinaControlador controlador = new RutinaControlador();
			Rutina seleccionado = new Rutina();

			// Crear el modelo de la tabla
			String[] columnNames = { "ID", "Nombre", "Profesor" , "Nivel"};
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
					if (seleccionado.getID_Rutinas()!=0) {				
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
						int idRutina = (int) table.getValueAt(selectedRow, 0);
						String nombre = (String) table.getValueAt(selectedRow, 1);
						String profesor = (String) table.getValueAt(selectedRow, 2);
						int idnivel = (int) table.getValueAt(selectedRow, 3);
									
			             int idprofesor = 0;
			             String profesorNombreyApellido = "";
			             
			             ProfesorControlador controladorprofesor = new ProfesorControlador();
							
						for (Profesor profesoreach : controladorprofesor.getAllProfesorConIDProfesor()) {
							profesorNombreyApellido = profesoreach.getNombre() +" " + profesoreach.getApellido();
							if (profesorNombreyApellido.equals(table.getValueAt(selectedRow, 2))) {
								idprofesor=profesoreach.getID_Profesor();
							}
						}

						elemento.setText("Seleccionado: ID_Rutina= " + idRutina + ", Nombre= " + nombre + ", Profesor= " + idprofesor + ", Nivel= " + idnivel );
			            
			             seleccionado.setID_Profesor(idprofesor);
			             seleccionado.setNombre(nombre);
			             seleccionado.setID_Rutinas(idRutina);;
			             seleccionado.setNivel(idnivel);
					}
				}
			});
			
			
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
		    		if (seleccionado.getID_Rutinas()!=0) {
						controlador.deleteRutina(seleccionado.getID_Rutinas());;
						System.out.println("Eliminaste la rutina");
						lvlResultado.setText("Eliminaste la rutina correctamente");
						lvlResultado.setVisible(true);
						actualizarTabla();
						seleccionado.setID_Rutinas(0);
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
					MenuProfesor menuatras= new MenuProfesor(profesor);
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
			    	    
			RutinaControlador controlador = new RutinaControlador();
			ProfesorControlador profesorcontrolador = new ProfesorControlador();
			String nombreProfesor = "";
	    	
		    // Agregar los datos al modelo
		    for (Rutina rutina : controlador.getAllRutina()) {
		    	
		    	for (Profesor profesor : profesorcontrolador.getAllProfesorConIDProfesor()) {
					if (profesor.getID_Profesor()==rutina.getID_Profesor()) {
						nombreProfesor = profesor.getNombre() +" " + profesor.getApellido();
					}
					model.addRow(
							new Object[]
									{
											rutina.getID_Rutinas()
											, rutina.getNombre()
											, nombreProfesor
											, rutina.getNivel()
											
									}
							);
				} 	
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
					if (criterio.contains(nombreEjercicio) || criterio.contains(nombreZonaMinusculas)){
						model.addRow(new Object[] { ejercicio.getID_Ejercicios() , ejercicio.getNombre() , ejercicio.getRepeticion() , ejercicio.getSeries() , nombreZona });
					}		
				}
			}
		
		}
}