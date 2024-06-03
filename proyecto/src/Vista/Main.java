package Vista;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import Controladores.ClienteControlador;
import Modelo.Cliente;
import Modelo.Cuota;
import Modelo.MenuIniciarSesion;
import Modelo.Profesor;
import Modelo.Recepcion;
import Validaciones.Validaciones_Interface;

public class Main implements MenuIniciarSesion , Validaciones_Interface{

	public static void main(String[] args) {

		Cliente cliente1= new Cliente("Franco", "Jarc", "franco123",45415444,"franco.jarc@davinci.edu.ar",1,1124655611);
		
		cliente1.UnirseClase();
		
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

	@Override
	public boolean IniciarSesion(String mail, String contrasena) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
