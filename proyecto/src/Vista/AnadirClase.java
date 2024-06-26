package Vista;

import java.time.LocalDateTime;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controladores.ClaseControlador;
import Controladores.ProfesorControlador;
import Modelo.Clase;
import Modelo.Profesor;
import Modelo.Recepcion;

import javax.swing.JComboBox;
import javax.swing.JTree;

import javax.swing.JTextField;
import java.awt.ScrollPane;

public class AnadirClase extends JFrame {

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
					AnadirClase frame = new AnadirClase(null);
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
	public AnadirClase(Recepcion recepcion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializar controlador
		ClaseControlador controlador = new ClaseControlador();
		Clase seleccionado = new Clase();

		// Crear el modelo de la tabla
		String[] columnNames = { "ID_Clases", "ID_Profesor", "ID_Nivel", "Nombre" , "Inicio","Fin"};
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
		

		// Botón para crear una nueva clase
		JButton btnCrearClase = new JButton("Añadir");
		btnCrearClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearClase clasenueva = new CrearClase(recepcion);
				clasenueva.setVisible(true);
				dispose();
			}
		});
		btnCrearClase.setBounds(58, 260, 120, 38);  // Ajustar tamaño para mejorar la visualización
		contentPane.add(btnCrearClase);
		
		

		// Configurar el modelo de selección de la tabla
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Agregar un escuchador de selección
				selectionModel.addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
							int selectedRow = table.getSelectedRow();
							int idClases = (int) table.getValueAt(selectedRow, 0);
							int idProfesor = (int) table.getValueAt(selectedRow, 1);
							int idNivel = (int) table.getValueAt(selectedRow, 2);
							String nombre = (String) table.getValueAt(selectedRow, 3);
							LocalDateTime inicio = (LocalDateTime) table.getValueAt(selectedRow, 4);
							LocalDateTime fin = (LocalDateTime) table.getValueAt(selectedRow, 5);

							elemento.setText("Seleccionado: ID = " + idClases + ", ID_Profesor = " + idProfesor + ", ID_Nivel = " + idNivel + ", Nombre= " + nombre + ", Inicio= " + inicio
									+ ", Fin= " + fin);
							seleccionado.setID_Clases(idClases);
							seleccionado.setID_Profesor(idProfesor);
							seleccionado.setNivel(idNivel);
							seleccionado.setNombre(nombre);
							seleccionado.setInicio(inicio);
							seleccionado.setFin(fin);
						}
					}
				});
		
		
				JButton btnEliminar = new JButton("Eliminar");
		        btnEliminar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                if (seleccionado.getID_Clases() != 0) {
		                    controlador.deleteClase(seleccionado.getID_Clases());
		                    lvlResultado.setText("Eliminaste al cliente correctamente");
		                    lvlResultado.setVisible(true);
		                    lvlError.setVisible(false);
		                    actualizarTabla();
		                    seleccionado.setID_Clases(0);
		                } else {
		                    lvlError.setText("Selecciona un cliente para eliminar");
		                    lvlError.setVisible(true);
		                    lvlResultado.setVisible(false);
		                }
		            }
		        });

		        btnEliminar.setBounds(237, 260, 120, 38);
		        contentPane.add(btnEliminar);
		
		btnEliminar.setBounds(237, 260, 120, 38);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuRecepcion menuatras= new MenuRecepcion(recepcion);
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

        // Obtener la lista actualizada de los clientes
        ClaseControlador controlador = new ClaseControlador();

        // Agregar los datos al modelo
        for (Clase clase: controlador.getAllClase()) {
            model.addRow(new Object[] { clase.getID_Clases(), clase.getID_Profesor(), clase.getNivel(), clase.getNombre(), clase.getInicio(),clase.getFin() });
        }
	}
	
	
	private void Filtrar(String criterio) {
		// Limpiar el modelo de la tabla
		 if (!criterio.isEmpty()) {
	            model.setRowCount(0);

	            ClaseControlador controlador = new ClaseControlador();
	            criterio = criterio.toLowerCase();

	            for (Clase clase : controlador.getAllClase()) {
	                String nombreClase = clase.getNombre().toLowerCase();
	                String nivelClase = String.valueOf(clase.getNivel());

	                if (nombreClase.contains(criterio) || nivelClase.contains(criterio)) {
	                    model.addRow(new Object[] { clase.getID_Clases(), clase.getNombre(), clase.getNivel() });
	                }
	            }
	        }
	    }
}


