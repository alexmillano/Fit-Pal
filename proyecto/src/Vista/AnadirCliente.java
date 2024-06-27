package Vista;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controladores.ClienteControlador;
import Modelo.Cliente;
import Modelo.Recepcion;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Color;

public class AnadirCliente extends JFrame {

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
					AnadirCliente frame = new AnadirCliente(null);
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
	public AnadirCliente(Recepcion recepcion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializar controlador
		ClienteControlador controlador = new ClienteControlador();
		Cliente seleccionado = new Cliente();

		// Crear el modelo de la tabla
		String[] columnNames = { "ID", "Nombre", "Apellido", "DNI" , "Correo"};
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
		

		// Botón para crear un nuevo cliente
		JButton btnCrearCliente = new JButton("Añadir");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente clientenuevo = new CrearCliente(recepcion);
				clientenuevo.setVisible(true);
				dispose();
			}
		});
		btnCrearCliente.setBounds(58, 260, 120, 38);  // Ajustar tamaño para mejorar la visualización
		contentPane.add(btnCrearCliente);
		
		

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
							String apellido = (String) table.getValueAt(selectedRow, 2);
							int dni = (int) table.getValueAt(selectedRow, 3);
							String correo = (String) table.getValueAt(selectedRow, 4);

							elemento.setText("Seleccionado: ID= " + id + ", Nombre= " + nombre + ", Apellido= " + apellido + ", DNI= " + dni + ", Correo= " + correo);
							seleccionado.setID_Cliente(id);
							seleccionado.setNombre(nombre);
							seleccionado.setApellido(apellido);
							seleccionado.setDni(dni);
							seleccionado.setCorreo(correo);
						}
					}
				});
		
		
				JButton btnEliminar = new JButton("Eliminar");
		        btnEliminar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                if (seleccionado.getID_Cliente() != 0) {
		                    controlador.deleteCliente(seleccionado.getID_Cliente());
		                    lvlResultado.setText("Eliminaste al cliente correctamente");
		                    lvlResultado.setVisible(true);
		                    lvlError.setVisible(false);
		                    actualizarTabla();
		                    seleccionado.setID_Cliente(0);
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
        ClienteControlador controlador = new ClienteControlador();

        // Agregar los datos al modelo
        for (Cliente cliente : controlador.getAllCliente()) {
            model.addRow(new Object[] { cliente.getID_Cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getCorreo() });
        }
	}
	
	
	private void Filtrar(String criterio) {
		// Limpiar el modelo de la tabla
		 if (!criterio.isEmpty()) {
	            model.setRowCount(0);

	            ClienteControlador controlador = new ClienteControlador();
	            criterio = criterio.toLowerCase();

	            for (Cliente cliente : controlador.getAllCliente()) {
	                String nombreCliente = cliente.getNombre().toLowerCase();
	                String apellidoCliente = cliente.getApellido().toLowerCase();
	                String dniCliente = String.valueOf(cliente.getDni());
	                String correoCliente = cliente.getCorreo().toLowerCase();

	                if (nombreCliente.contains(criterio) || apellidoCliente.contains(criterio) || dniCliente.contains(criterio) || correoCliente.contains(criterio)) {
	                    model.addRow(new Object[] { cliente.getID_Cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getCorreo() });
	                }
	            }
	        }
	    }
}
