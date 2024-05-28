package Test_Alex;
import Modelo.Cuota;
import Controladores.ClienteControlador;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class PruebaAlex {
		@Test
		public void CrearClienteV() {
			ClienteControlador controlador = new ClienteControlador();
			boolean flag =true;
			String nombre = "Juan";
	        String apellido = "Perez";
	        int dni = 12345678;
	        String contraseña = "contraseña123";
	        String correo = "juan.perez@example.com";
	        int nivel = 1;
	        int telefono = 123456789;
	        Cuota cuota = new Cuota("Efectivo", LocalDate.now().plusMonths(1));
	        
	        controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuota);
			assertEquals(true,flag);
		}
		
		@Test
		public void CrearClienteF() {
			ClienteControlador controlador = new ClienteControlador();
			boolean flag =false;
			String nombre = "Miguel";
	        String apellido = "Hernandez";
	        int dni = 64448724;
	        String contraseña = "contraseña123";
	        String correo = "miguel.hernandez@example.com";
	        int nivel = 2;
	        int telefono = 123456789;
	        Cuota cuota = new Cuota("Tarjeta", LocalDate.now().plusMonths(1));
	        
	        controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuota);
			assertEquals(false,flag);
		}
		
		@Test
		public void EliminarClienteV() {
			ClienteControlador controlador2 = new ClienteControlador();
			boolean flag = true;
			int id = 1;
			controlador2.deleteCliente(id);
			assertEquals(true,flag);
		}
}
