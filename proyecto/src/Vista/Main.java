package Vista;

import static org.junit.Assert.assertEquals;

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

	/*public static void main(String[] args) {
		
		/*boolean flag = true;
		ClienteControlador controlador = new ClienteControlador();
		int idCliente = 7;
		String nombre = "Juan";
        String apellido = "Perez";
        int dni = 12345678;
        String contraseña = "contraseña123";
        String correo = "juan.perez@example.com";
        int nivel = 1;
        int telefono = 123456789;
        
		List<Object> chequeado = Arrays.asList(idCliente,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);

		for (Object field : chequeado) {
	        if (isInvalid(field)) {
	        	System.out.println("Todos los campos deben estar completos");
	        	flag = false;
	        	break;
	        } else {
	        	controlador.addCliente(idCliente,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);
	        }
	    }
	    assertEquals(flag, true);
	}

	private static boolean isInvalid(Object field) {
	    if (field instanceof String) {
	        return ((String) field).trim().isEmpty();
	    } else if (field instanceof Integer) {
	        return (Integer) field <= 0;
	    } else if (field == null) {
	        return true;
	    }
	    return false;
	}/*
		
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



	@Override
	public void Menu() {
		// TODO Auto-generated method stub
		
	}



}
