package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente(null);
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
	public MenuCliente(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button clasesbtn = new Button("Clases");
		clasesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClasesCliente clasesclientes= new ClasesCliente(cliente);
				clasesclientes.setVisible(true);
				dispose();
			}
		});
		clasesbtn.setSize(70, 31);
		clasesbtn.setLocation(10, 133);
		contentPane.add(clasesbtn);
		
		JLabel lblNewLabel = new JLabel("Esto es menu de cliente");
		lblNewLabel.setSize(237, 31);
		lblNewLabel.setLocation(92, 11);
		contentPane.add(lblNewLabel);
		
		Button clasesrealizadasbtn = new Button("Clases Realizadas");
		clasesrealizadasbtn.setBounds(90, 133, 97, 31);
		contentPane.add(clasesrealizadasbtn);
		
		Button rutinasbtn = new Button("Rutinas");
		rutinasbtn.setBounds(195, 133, 70, 31);
		contentPane.add(rutinasbtn);
		
		Button perfilbtn = new Button("Perfil");
		perfilbtn.setBounds(271, 133, 70, 31);
		contentPane.add(perfilbtn);
		
		Button cerrarsesionbtn = new Button("Cerrar sesion");
		cerrarsesionbtn.setBounds(347, 133, 77, 31);
		contentPane.add(cerrarsesionbtn);
	}
}
