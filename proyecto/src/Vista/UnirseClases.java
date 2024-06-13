package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import Controladores.ClaseControlador;
import Modelo.Clase;
import Modelo.Cliente;
import Modelo.Usuario;

public class UnirseClases extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private ClaseControlador controlador;
    private JLabel elemento;
    private Clase seleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnirseClases frame = new UnirseClases(null);
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
	public UnirseClases(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Inicializar controlador y usuario seleccionado
		ClaseControlador controlador = new ClaseControlador();
		Clase seleccionado = new Clase();

	    // Crear la tabla y el modelo
	    String[] columnNames = {"ID", "Nombre", "Inicio","Fin", "Profesor", "Nivel"};
	    model = new DefaultTableModel(columnNames, 0);
	    table = new JTable(model);
	    actualizarTabla(cliente);
	    contentPane.setLayout(null);

	    // Crear el JScrollPane y agregar la tabla
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(5, 19, 911, 190);
	    contentPane.add(scrollPane);
	    

	    // Crear el JLabel para mostrar la selección
	    elemento = new JLabel("Seleccionado:");
	    elemento.setBounds(5, 5, 911, 14);
	    contentPane.add(elemento);
	    
	    JButton btnUnirse = new JButton("Unirse");
	    btnUnirse.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if (seleccionado.getID_Clases()!=0) {
	    			/*Se uniria a la clase*/
	    			cliente.UnirseClase(seleccionado);    			
	    			 System.out.println("Te uniste a la clase");
	    			 actualizarTabla(cliente);
				} else {
					 System.out.println("No te uniste a la clase");
				}
	
	    	}
	    });
	    
	    btnUnirse.setBounds(198, 220, 166, 38);
	    contentPane.add(btnUnirse);
	    
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setBounds(15, 220, 101, 22);
	    contentPane.add(menuBar);
	   
	   
	    // Configurar el modelo de selección
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
	                LocalDateTime inicio = (LocalDateTime) table.getValueAt(selectedRow, 2);
	                LocalDateTime fin = (LocalDateTime) table.getValueAt(selectedRow, 3);
	                int profesor = (int) table.getValueAt(selectedRow, 4);
	                int nivel = (int) table.getValueAt(selectedRow, 5);

	                elemento.setText("Seleccionado: ID= " + id + ", Nombre= " + nombre + ", Inicio= " + inicio + " Fin= " + fin + " Profesor= " + profesor + " Nivel= " + nivel );

	                seleccionado.setID_Clases(id);
	                seleccionado.setNombre(nombre);
	                seleccionado.setInicio(inicio);
	                seleccionado.setFin(fin);
	                seleccionado.setID_Profesor(profesor);
	                seleccionado.setNivel(nivel);
	                }
			     }	 
	    });
	}
	
		
		private void actualizarTabla(Cliente cliente) {
		    // Limpiar el modelo de la tabla
		    model.setRowCount(0);
		
		    // Obtener la lista actualizada de usuarios
		    cliente.ClaseSegunNivel();
	    	
		    // Agregar los datos al modelo
		    for (Clase clase : cliente.ClaseSegunNivel()) {
		        model.addRow(
		        		new Object[]
		        				{
		        						clase.getID_Clases()
		        						, clase.getNombre()
		        						, clase.getInicio()
		        						, clase.getFin()
		        						, clase.getID_Profesor()
		        						, clase.getNivel()
		        						}
		        		);
		    }
		}
		
	
		
		
		
}
