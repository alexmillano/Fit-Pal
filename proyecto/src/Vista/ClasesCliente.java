package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Cliente;


import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClasesCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClasesCliente frame = new ClasesCliente(null);
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
	public ClasesCliente(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button informacionbtn = new Button("Informacion");
		informacionbtn.setBounds(42, 87, 70, 22);
		contentPane.add(informacionbtn);
		

		
		Button volverbtn = new Button("Volver");
		volverbtn.setBounds(194, 87, 70, 22);
		contentPane.add(volverbtn);
		
		Label claseslbl = new Label("Clases");
		claseslbl.setBounds(118, 22, 62, 22);
		contentPane.add(claseslbl);
		
		Button inscribirsebtn = new Button("Inscribirse");
		inscribirsebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnirseClases unirseclases = new UnirseClases(cliente);
				unirseclases.setVisible(true);
				dispose();
			}
		});
		
		
		
		inscribirsebtn.setBounds(118, 87, 70, 22);
		contentPane.add(inscribirsebtn);

	}
}
