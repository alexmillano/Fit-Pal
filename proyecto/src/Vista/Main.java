package Vista;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Modelo.Cliente;
import Modelo.Cuota;
import Modelo.MenuIniciarSesion;
import Modelo.Persona;
import Modelo.Profesor;
import Modelo.Recepcion;
import Validaciones.Validaciones_Interface;

public class Main implements MenuIniciarSesion , Validaciones_Interface{

	public static void main(String[] args) {

		
		try {				
			Persona persona = new Persona();
			
			String correoTF = JOptionPane.showInputDialog("Ingrese su correo");
			String contraseñaTF = JOptionPane.showInputDialog("Ingrese su contraseñ");
			String iniciarsesion= persona.IniciarSesion(correoTF, contraseñaTF);

		
			if (iniciarsesion.equals("Email correcto cliente" ) ||  iniciarsesion.equals("Email correcto recepcion" ) || iniciarsesion.equals("Email correcto profesor" )) {
				JOptionPane.showMessageDialog(null, iniciarsesion);
				ClienteControlador clientecontrolador = new ClienteControlador();
				clientecontrolador.getClienteById(0);
				
			}else if (iniciarsesion.equals("Ingrese correctamente el mail") || iniciarsesion.equals("Ocurrió un error inesperado con su mail") || iniciarsesion.equals("Ocurrió un error inesperado en su contraseña")) {
				JOptionPane.showMessageDialog(null, iniciarsesion);
			}else	{
				JOptionPane.showMessageDialog(null, iniciarsesion);
			}
							
			System.out.println("Resultado del inicio de sesión: " + iniciarsesion);
		} catch (Exception e2) {
			System.out.println(e2.getStackTrace());
		}
		
		
		
		
		
		PantallaInicio ventana = new PantallaInicio();

		
		
		/*
		Recepcion recepcion1= new Recepcion("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar",1);
		Profesor profesor1= new Profesor("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar",1);
		Cliente cliente1= new Cliente("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar","Intermedio",1,1124655611);
		String devolucion= recepcion1.IniciarSesion();
		
		switch (devolucion) {
		case "profesor":
			
			profesor1.Menu();
			
			break;
			
		case "cliente":
			
			cliente1.Menu();
					
			break;

		case "recepcion":
			
			recepcion1.Menu();
									
			break;
		}
		*/

	}

	@Override
	public void Menu() {
		// TODO Auto-generated method stub
		
	}



}
