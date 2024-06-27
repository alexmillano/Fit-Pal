package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Recepcion;

import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuRecepcion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRecepcion frame = new MenuRecepcion(null);
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
	public MenuRecepcion(Recepcion recepcion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Principal");
		lblNewLabel.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		lblNewLabel.setSize(233, 37);
		lblNewLabel.setLocation(150, 11);
		contentPane.add(lblNewLabel);
		
		Button cuotasbtn = new Button("Cuotas");
		cuotasbtn.setBounds(94, 110, 70, 22);
		contentPane.add(cuotasbtn);
		
		Button clasesbtn = new Button("Clientes");
		clasesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirClase anadirclase = new AnadirClase(recepcion);
				anadirclase.setVisible(true);
				dispose();
				
			}
		});
		clasesbtn.setBounds(246, 110, 70, 22);
		contentPane.add(clasesbtn);
		
		Button cronogramabtn = new Button("Cronograma");
		cronogramabtn.setBounds(94, 138, 70, 22);
		contentPane.add(cronogramabtn);
		
		Button perfilbtn = new Button("Perfil");
		perfilbtn.setBounds(170, 138, 70, 22);
		contentPane.add(perfilbtn);
		
		Button cerrarsesionbtn = new Button("Cerrar Sesión");
		cerrarsesionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cerrarsesionbtn.setBounds(246, 138, 70, 22);
		contentPane.add(cerrarsesionbtn);
		cerrarsesionbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		        System.exit(0);
		    }
		});
		
		Button clientesbtn = new Button("Clientes");
		clientesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirCliente anadircliente = new AnadirCliente(recepcion);
				anadircliente.setVisible(true);
				dispose();
				
			}
		});
		clientesbtn.setBounds(170, 110, 70, 22);
		contentPane.add(clientesbtn);
		
	}

}
