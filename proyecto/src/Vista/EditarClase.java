package Vista;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ClaseControlador;
import Controladores.ProfesorControlador;
import Modelo.Recepcion;
import Modelo.Profesor;
import Modelo.Clase;


public class EditarClase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Choice choiceProfesor;
    private TextField textFieldNivel;
    private TextField textFieldNombre;
    private TextField textFieldHoraInicio;
    private TextField textFieldHoraFin;
    private JLabel lblResultadoPositivo;
    private JLabel lblResultadoNegativo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarClase frame = new EditarClase(null,null);
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
	public EditarClase(Recepcion recepcion, Clase seleccionado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Edite la clase");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(155, 11, 163, 14);
        contentPane.add(lblNewLabel_3);
        
        Label label = new Label("Profesor");
        label.setBounds(27, 47, 62, 22);
        contentPane.add(label);
        
        choiceProfesor = new Choice();
        choiceProfesor.setBounds(27, 75, 131, 20);
        contentPane.add(choiceProfesor);
        cargarProfesores();
        
        Label label_1 = new Label("Nivel");
        label_1.setBounds(27, 117, 62, 22);
        contentPane.add(label_1);
        
        textFieldNivel = new TextField();
        textFieldNivel.setBounds(27, 145, 131, 22);
        contentPane.add(textFieldNivel);
        
        Label label_2 = new Label("Nombre");
        label_2.setBounds(27, 189, 62, 22);
        contentPane.add(label_2);
        
        textFieldNombre = new TextField();
        textFieldNombre.setBounds(27, 217, 131, 22);
        contentPane.add(textFieldNombre);
        
        Label label_3 = new Label("Hora de inicio(formato HH:mm)");
        label_3.setBounds(27, 260, 163, 22);
        contentPane.add(label_3);
        
        textFieldHoraInicio = new TextField();
        textFieldHoraInicio.setBounds(27, 284, 131, 22);
        contentPane.add(textFieldHoraInicio);
        
        Label label_3_1 = new Label("Hora de fin(formato HH:mm)");
        label_3_1.setBounds(27, 320, 148, 22);
        contentPane.add(label_3_1);
        
        textFieldHoraFin = new TextField();
        textFieldHoraFin.setBounds(27, 344, 131, 22);
        contentPane.add(textFieldHoraFin);
        
        Button buttonGuardar = new Button("Guardar");
        buttonGuardar.setBounds(107, 405, 90, 22);
        contentPane.add(buttonGuardar);

        Button buttonSalir = new Button("Salir");
        buttonSalir.setBounds(213, 405, 90, 22);
        contentPane.add(buttonSalir);

        lblResultadoPositivo = new JLabel("");
        lblResultadoPositivo.setForeground(new Color(0, 128, 0));
        lblResultadoPositivo.setBounds(27, 375, 300, 22);
        contentPane.add(lblResultadoPositivo);

        lblResultadoNegativo = new JLabel("");
        lblResultadoNegativo.setForeground(new Color(255, 0, 0));
        lblResultadoNegativo.setBounds(27, 375, 300, 22);
        contentPane.add(lblResultadoNegativo);

        buttonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                if (nombre.isEmpty()) {
                    lblResultadoNegativo.setText("El nombre no puede estar vacío");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                int nivel;
                try {
                    nivel = Integer.parseInt(textFieldNivel.getText());
                } catch (NumberFormatException ex) {
                    lblResultadoNegativo.setText("El nivel debe ser un número");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime horaInicio;
                try {
                    horaInicio = LocalTime.parse(textFieldHoraInicio.getText(), formatter);
                } catch (DateTimeParseException ex) {
                    lblResultadoNegativo.setText("Hora de inicio no válida (formato HH:mm)");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                LocalTime horaFin;
                try {
                    horaFin = LocalTime.parse(textFieldHoraFin.getText(), formatter);
                } catch (DateTimeParseException ex) {
                    lblResultadoNegativo.setText("Hora de fin no válida (formato HH:mm)");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                if (!horaFin.isAfter(horaInicio)) {
                    lblResultadoNegativo.setText("La hora de fin debe ser después de la hora de inicio");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                int profesorIndex = choiceProfesor.getSelectedIndex();
                if (profesorIndex == -1) {
                    lblResultadoNegativo.setText("Debe seleccionar un profesor");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                    return;
                }

                ProfesorControlador profesorControlador = new ProfesorControlador();
                List<Profesor> profesores = profesorControlador.getAllProfesor();
                int profesorId = profesores.get(profesorIndex).getID_Profesor();

                ClaseControlador claseControlador = new ClaseControlador();
                boolean claseActualizada = claseControlador.updateClase(profesorId, nombre, horaInicio, horaFin, nivel,seleccionado.getID_Clases());

                if (claseActualizada) {
                    lblResultadoPositivo.setText("Clase actualizada correctamente");
                    lblResultadoPositivo.setVisible(true);
                    lblResultadoNegativo.setVisible(false);
                    dispose();

                    AnadirClase menuatras = new AnadirClase(recepcion);
                    menuatras.setVisible(true);
                } else {
                    lblResultadoNegativo.setText("Error al actualizar la clase");
                    lblResultadoNegativo.setVisible(true);
                    lblResultadoPositivo.setVisible(false);
                }
            }
        });

        buttonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}
    private void cargarProfesores() {
        ProfesorControlador profesorControlador = new ProfesorControlador();
        List<Profesor> profesores = profesorControlador.getAllProfesor();
        for (Profesor profesor : profesores) {
            choiceProfesor.add(profesor.getNombre());
        }
    }
}
