package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


import Controladores.ClienteControlador;
import Controladores.CuotaControlador;

import Modelo.Cuota;
import Modelo.Recepcion;
import java.awt.Label;
import java.awt.Button;


public class CrearCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDNI;
    private JTextField txtCorreo;
    private JTextField txtContrasena;
    private JTextField txtNivel;
    private JTextField txtTelefono;
    private JLabel lblResultadoPositivo;
    private JLabel lblResultadoNegativo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente(null);
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
	public CrearCliente(Recepcion recepcion) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 368);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Complete los datos");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(155, 11, 163, 14);
        contentPane.add(lblNewLabel_3);

        txtNombre = new JTextField();
        txtNombre.setBounds(10, 57, 122, 22);
        contentPane.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(164, 57, 122, 22);
        contentPane.add(txtApellido);

        txtDNI = new JTextField();
        txtDNI.setBounds(315, 57, 109, 22);
        contentPane.add(txtDNI);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(10, 120, 122, 22);
        contentPane.add(txtContrasena);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(164, 120, 122, 22);
        contentPane.add(txtCorreo);

        txtNivel = new JTextField();
        txtNivel.setBounds(315, 121, 109, 22);
        contentPane.add(txtNivel);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(10, 188, 122, 22);
        contentPane.add(txtTelefono);

        Label label = new Label("Nombre");
        label.setBounds(10, 37, 62, 22);
        contentPane.add(label);

        Label label_1 = new Label("Apellido");
        label_1.setBounds(164, 37, 62, 22);
        contentPane.add(label_1);

        Label label_2 = new Label("DNI");
        label_2.setBounds(315, 37, 62, 22);
        contentPane.add(label_2);

        Label label_3 = new Label("Contraseña");
        label_3.setBounds(10, 101, 62, 22);
        contentPane.add(label_3);

        Label label_4 = new Label("Correo");
        label_4.setBounds(164, 101, 62, 22);
        contentPane.add(label_4);

        Label label_5 = new Label("Nivel");
        label_5.setBounds(315, 101, 62, 22);
        contentPane.add(label_5);

        Label label_6 = new Label("Telefono");
        label_6.setBounds(10, 167, 62, 22);
        contentPane.add(label_6);

        lblResultadoPositivo = new JLabel("");
        lblResultadoPositivo.setBounds(10, 220, 414, 14);
        contentPane.add(lblResultadoPositivo);

        lblResultadoNegativo = new JLabel("");
        lblResultadoNegativo.setBounds(10, 240, 414, 14);
        contentPane.add(lblResultadoNegativo);

        // Botón para añadir a nuevo cliente
        Button buttonCrearCliente = new Button("Crear Cliente");
        buttonCrearCliente.setBounds(95, 280, 96, 22);
        contentPane.add(buttonCrearCliente);
        buttonCrearCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                if (nombre.isEmpty()) {
                    lblResultadoNegativo.setText("El nombre no puede estar vacío");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                String apellido = txtApellido.getText();
                if (apellido.isEmpty()) {
                    lblResultadoNegativo.setText("El apellido no puede estar vacío");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                int dni;
                try {
                    dni = Integer.parseInt(txtDNI.getText());
                } catch (NumberFormatException ex) {
                    lblResultadoNegativo.setText("El DNI debe ser un número");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                String contrasena = txtContrasena.getText();
                if (contrasena.isEmpty()) {
                    lblResultadoNegativo.setText("La contraseña no puede estar vacía");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                String correo = txtCorreo.getText();
                if (correo.isEmpty()) {
                    lblResultadoNegativo.setText("El correo no puede estar vacío");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                int nivel;
                try {
                    nivel = Integer.parseInt(txtNivel.getText());
                } catch (NumberFormatException ex) {
                    lblResultadoNegativo.setText("Nivel debe ser un número");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                int telefono;
                try {
                    telefono = Integer.parseInt(txtTelefono.getText());
                } catch (NumberFormatException ex) {
                    lblResultadoNegativo.setText("El teléfono debe ser un número");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                // Controlador de cliente y cuota
                ClienteControlador controlador = new ClienteControlador();
                CuotaControlador controladorC = new CuotaControlador();

                // Llamar al método para crear un nuevo cliente
                controlador.addCliente(nombre, apellido, dni, contrasena, correo, nivel, telefono, null);

                // Obtener el ID del cliente recién insertado
                int clienteID = controlador.getLastInsertedClientId();
                if (clienteID > 0) {
                    int metodo = 3;
                    LocalDate vencimiento = LocalDate.now().plusMonths(1);
                    Cuota cuotanueva = new Cuota(metodo, vencimiento);
                    controladorC.addCuota(cuotanueva, clienteID);

                    lblResultadoPositivo.setText("Cliente creado correctamente");
                    lblResultadoPositivo.setVisible(true);
                    lblResultadoNegativo.setVisible(false);
                    dispose();
                    
                    // Abrir la ventana de AnadirCliente
                    AnadirCliente menuatras = new AnadirCliente(recepcion);
                    menuatras.setVisible(true);
                } else {
                    lblResultadoNegativo.setText("Error al crear el cliente");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                }
            }
        });

        Button buttonSalir = new Button("Salir");
        buttonSalir.setBounds(217, 280, 101, 22);
        contentPane.add(buttonSalir);
        buttonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnadirCliente menuatras = new AnadirCliente(recepcion);
                menuatras.setVisible(true);
                dispose();
            }
        });
    }
}
