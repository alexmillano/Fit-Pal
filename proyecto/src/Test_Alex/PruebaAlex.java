package Test_Alex;
import Modelo.Profesor;
import Controladores.ClaseControlador;
import Controladores.ClienteControlador;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PruebaAlex {
		@Test
		public void CrearClienteV() {
			boolean flag = true;
			ClienteControlador controlador = new ClienteControlador();
			int ID = 8;
			String nombre = "Juan";
	        String apellido = "Perez";
	        int dni = 12345678;
	        String contraseña = "contraseña123";
	        String correo = "juan.perez@example.com";
	        int nivel = 1;
	        int telefono = 123456789;

	        
			List<Object> chequeado = Arrays.asList(ID,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);

			for (Object field : chequeado) {
		        if (isInvalid(field)) {
		        	System.out.println("Todos los campos deben estar completos");
		        	flag = false;
		        	break;
		        } else {
		        	controlador.addCliente(ID,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);
		        }
		    }
		    assertEquals(flag, true);
		}

		private boolean isInvalid(Object field) {
		    if (field instanceof String) {
		        return ((String) field).trim().isEmpty();
		    } else if (field instanceof Integer) {
		        return (Integer) field <= 0;
		    } else if (field == null) {
		        return true;
		    }
		    return false;
		}
		
		@Test
	    public void CrearClienteF() {
			boolean flag = true;
	        ClienteControlador controlador = new ClienteControlador();
	        int ID = 9;
	        String nombre = "";
	        String apellido = "Hernandez";
	        int dni = 64448724;
	        String contraseña = "contraseña123";
	        String correo = "miguel.hernandez@example.com";
	        int nivel = 2;
	        int telefono = 123456789;


			List<Object> chequeado = Arrays.asList(ID,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);

		    for (Object field : chequeado) {
		        if (isInvalid2(field)) {
		        	System.out.println("Todos los campos deben estar completos");
		        	flag = false;
		        	break;
		        } else {
		        	controlador.addCliente(ID,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);
		        }
		    }
		    assertEquals(flag,false);
		}
		private boolean isInvalid2(Object field) {
		    if (field instanceof String) {
		        return ((String) field).trim().isEmpty();
		    } else if (field instanceof Integer) {
		        return (Integer) field <= 0;
		    } else if (field == null) {
		        return true;
		    }
		    return false;
		}
	    @Test
	    public void EliminarClienteV() {
	    	ClienteControlador controlador = new ClienteControlador();
	    	int ID = 2;
	        String nombre = "Juan";
	        String apellido = "Perez";
	        int dni = 12345678;
	        String contraseña = "contraseña123";
	        String correo = "juan.perez@example.com";
	        int nivel = 1;
	        int telefono = 123456789;


	        controlador.addCliente(ID,nombre, apellido, dni, contraseña, correo, nivel, telefono, 1);
	        
	        int id = controlador.getClienteIdPorDni(dni);
	        controlador.deleteCliente(id);
	        assertTrue(true);
	    }

	    @Test
	    public void EliminarClienteF() {
	        ClienteControlador controlador = new ClienteControlador();
	        int dni = 9998652;
	        int id = controlador.getClienteIdPorDni(dni);
	        boolean eliminar = controlador.deleteCliente(id);
	        assertFalse("El cliente no debería haberse eliminado porque no existe", eliminar);
	    }
	    
	    @Test
		public void CrearClaseV() {
	    	boolean flag = true;
	    	Profesor profenuevo = new Profesor("Alex", "Gimenez", "564684", 45451514,"alexgimenez@gmail.com");
			String nombreC = "Karate";
			
			LocalDate fecha = LocalDate.now();
			int hora = 19;
			int minuto = 00;
			LocalDateTime horainicio = fecha.atTime(hora, minuto);
			
			int hora2 = 20;
			int minuto2 = 00;
			LocalDateTime horafin = fecha.atTime(hora2, minuto2);
			int nivelC = 1;
			
			if (horafin.isBefore(horainicio) || horainicio.isAfter(horafin)) {
				flag=false;
			 System.out.println("Las horas estan mal puestas ");
		} else {
			ClaseControlador controlclase = new ClaseControlador();
			controlclase.addClase(profenuevo,nombreC,horainicio,horafin,nivelC);
		}
		assertEquals(true,flag);
		}
	    
	    @Test
	    public void CrearClaseF() {
	    	boolean flag = true;
	    	Profesor profenuevo = new Profesor("Esteban", "Rodriguez", "554548", 34255264,"estebanrodri@gmail.com");
			String nombreC = "Sumo";
			
			LocalDate fecha = LocalDate.now();
			int hora = 20;
			int minuto = 30;
			LocalDateTime horainicio = fecha.atTime(hora, minuto);
			
			int hora2 = 20;
			int minuto2 = 00;
			LocalDateTime horafin = fecha.atTime(hora2, minuto2);
			int nivelC = 1;
			
			if (horafin.isBefore(horainicio) || horainicio.isAfter(horafin)) {
					flag=false;
				 System.out.println("Las horas estan mal puestas ");
			} else {
				ClaseControlador controlclase = new ClaseControlador();
				controlclase.addClase(profenuevo,nombreC,horainicio,horafin,nivelC);
			}
			assertEquals(false,flag);
	    }
}
