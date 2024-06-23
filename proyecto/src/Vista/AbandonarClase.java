package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;
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
import Controladores.EjercicioControlador;
import Controladores.ProfesorControlador;
import Controladores.ZonaControlador;
import Modelo.Clase;
import Modelo.Cliente;
import Modelo.Ejercicio;
import Modelo.Profesor;
import Modelo.Usuario;
import Modelo.Zona_Ejercicio;

public class AbandonarClase extends JFrame {

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
	public AbandonarClase(Cliente cliente) {
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
	    
		Label lvlResultadoPositivo = new Label("");
		lvlResultadoPositivo.setBackground(SystemColor.control);
		lvlResultadoPositivo.setForeground(new Color(0, 255, 0));
		lvlResultadoPositivo.setBounds(53, 289, 516, 22);
		contentPane.add(lvlResultadoPositivo);
		lvlResultadoPositivo.setVisible(false);

		
		Label lvlResultadoNegativo = new Label("");
		lvlResultadoNegativo.setForeground(new Color(255, 0, 0));
		lvlResultadoNegativo.setBounds(53, 289, 516, 22);
		contentPane.add(lvlResultadoNegativo);
		lvlResultadoNegativo.setVisible(false);
		
	    
	    
		JButton btnSalir = new JButton("Volver");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnirseClases atras = new UnirseClases(cliente);
				atras.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(468, 220, 120, 38);
		contentPane.add(btnSalir);
		
		JButton btnAbandonar = new JButton("Abandonar");
		btnAbandonar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	    		if (seleccionado.getID_Clases()!=0) {
	    			 cliente.AbandonarClase(seleccionado, cliente); 			
	    			 lvlResultadoPositivo.setText("Abandonaste la clase correctamente");
	    			 lvlResultadoPositivo.setVisible(true);
	    			 actualizarTabla(cliente);
	    			 
				} else {
					 System.out.println("Error al abandonar una clase");
				}
			
			}
		});
		btnAbandonar.setBounds(338, 220, 120, 38);
		contentPane.add(btnAbandonar);
	    
	   
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
	             // int profesor = (int) table.getValueAt(selectedRow, 4);
	               int nivel = (int) table.getValueAt(selectedRow, 5);
	                
	               int idprofesor = 0;
	               String profesorNombreyApellido = "";
	               ProfesorControlador controladorprofesor = new ProfesorControlador();
					
					for (Profesor profesor : controladorprofesor.getAllProfesorConIDProfesor()) {
						profesorNombreyApellido = profesor.getNombre() +" " + profesor.getApellido();
						if (profesorNombreyApellido.equals(table.getValueAt(selectedRow, 4))) {
							idprofesor=profesor.getID_Profesor();
						}
					}

	                elemento.setText("Seleccionado: ID= " + id + ", Nombre= " + nombre + ", Inicio= " + inicio + " Fin= " + fin + " Profesor= " + idprofesor + " Nivel= " + nivel );

	                seleccionado.setID_Clases(id);
	                seleccionado.setNombre(nombre);
	                seleccionado.setInicio(inicio);
	                seleccionado.setFin(fin);
	                seleccionado.setID_Profesor(idprofesor);
	                seleccionado.setNivel(nivel);
	                }
			     }	 
	    });
	}
	
		
		private void actualizarTabla(Cliente cliente) {
		    // Limpiar el modelo de la tabla
		    model.setRowCount(0);
			    	    
			EjercicioControlador controlador = new EjercicioControlador();
			ProfesorControlador profesorcontrolador = new ProfesorControlador();
			String nombreProfesor = "";
	    	
		    // Agregar los datos al modelo
		    for (Clase clase : cliente.ClaseSegunNivelABorrar()) {
		    	
		    	for (Profesor profesor : profesorcontrolador.getAllProfesorConIDProfesor()) {
					if (profesor.getID_Profesor()==clase.getID_Profesor()) {
						nombreProfesor = profesor.getNombre() +" " + profesor.getApellido();
					}
					model.addRow(
							new Object[]
									{
											clase.getID_Clases()
											, clase.getNombre()
											, clase.getInicio()
											, clase.getFin()
											, nombreProfesor
											, clase.getNivel()
									}
							);
				} 	
		    }
		}
}
