package Test_Alex;
import Modelo.Cuota;
import Modelo.Profesor;
import Controladores.ClaseControlador;
import Controladores.ClienteControlador;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PruebaAlex {
		@Test
		public void CrearClienteV() {
			ClienteControlador controlador = new ClienteControlador();
			String nombre = "Juan";
	        String apellido = "Perez";
	        int dni = 12345678;
	        String contraseña = "contraseña123";
	        String correo = "juan.perez@example.com";
	        int nivel = 1;
	        int telefono = 123456789;
	        LocalDate vencimiento = LocalDate.now();
			LocalDate vencimiento2 = vencimiento.plusMonths(1);
			Cuota cuotanueva = new Cuota(2,vencimiento2);
	        
			controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuotanueva);
			assertTrue(true);
		}
		
		@Test
	    public void CrearClienteF() {
	        ClienteControlador controlador = new ClienteControlador();
	        String nombre = "Miguel";
	        String apellido = "Hernandez";
	        int dni = 64448724;
	        String contraseña = "contraseña123";
	        String correo = "miguel.hernandez@example.com";
	        int nivel = 2;
	        int telefono = 123456789;
	        Cuota cuota = new Cuota(2, LocalDate.now().plusMonths(1));

	        controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuota);
	        assertFalse(false);
	    }

	    @Test
	    public void EliminarClienteV() {
	    	ClienteControlador controlador = new ClienteControlador();
	        String nombre = "Juan";
	        String apellido = "Perez";
	        int dni = 12345678;
	        String contraseña = "contraseña123";
	        String correo = "juan.perez@example.com";
	        int nivel = 1;
	        int telefono = 123456789;
	        LocalDate vencimiento = LocalDate.now();
	        LocalDate vencimiento2 = vencimiento.plusMonths(1);
	        Cuota cuotanueva = new Cuota(2, vencimiento2);


	        controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuotanueva);
	        assertTrue(true);
	        
	        int id = controlador.getClienteIdPorDni(dni);
	        assertTrue(true);
	        
	        controlador.deleteCliente(id);
	        assertTrue(true);
	    }

	    @Test
	    public void EliminarClienteF() {
	        ClienteControlador controlador = new ClienteControlador();
	        int id = 999;
	        boolean eliminar = controlador.deleteCliente(id);
	        assertFalse("El cliente no debería haberse eliminado porque no existe", eliminar);
	    }
	    
	    @Test
		public void CrearClaseV() {
	    	Profesor profenuevo = new Profesor("Alex", "Gimenez", "564684", 45451514,"alexgimenez@gmail.com");
			String nombreC = "Sumo";
			
			LocalDate fecha = LocalDate.now();
			int hora = 19;
			int minuto = 00;
			LocalDateTime horainicio = fecha.atTime(hora, minuto);
			
			int hora2 = 20;
			int minuto2 = 00;
			LocalDateTime horafin = fecha.atTime(hora2, minuto2);
			int nivelC = 1;
			
			ClaseControlador controlclase = new ClaseControlador();
			controlclase.addClase(profenuevo,nombreC,horainicio,horafin,nivelC);
			assertTrue(true);
		}
	    
	    @Test
	    public void CrearClaseF() {
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
				assertTrue(true);
				 System.out.println("Las horas estan mal puestas ");
			} else {
				ClaseControlador controlclase = new ClaseControlador();
				controlclase.addClase(profenuevo,nombreC,horainicio,horafin,nivelC);
			}

	    }
}
