package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Recepcion;

import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblNewLabel = new JLabel("Esto es menu recepcion");
		lblNewLabel.setSize(233, 37);
		lblNewLabel.setLocation(97, 11);
		contentPane.add(lblNewLabel);
		
		Button cuotasbtn = new Button("Cuotas");
		cuotasbtn.setBounds(94, 110, 70, 22);
		contentPane.add(cuotasbtn);
		
		Button usuariosbtn = new Button("Usuarios");
		usuariosbtn.setBounds(170, 110, 70, 22);
		contentPane.add(usuariosbtn);
		
		Button clasesbtn = new Button("Clases");
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
	}

}
