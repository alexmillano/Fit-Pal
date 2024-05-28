package Modelo;

import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import Controladores.ClienteControlador;
import Controladores.ClaseControlador;
import Controladores.ProfesorControlador;



public class Recepcion extends Persona implements MenuIniciarSesion {

		private int ID_recepcion;
		
		//Lista de todas las cuotas. Ya esta hecha en cuotas. ES LA STATIC EN cuotas_general
		
		//Lista de todos los clientes. Ya esta hecha en cliente. ES LA STATIC clientes_general

		public Recepcion(String nombre, String apellido, String contraseña, int dNI, String correo, int iD_recepcion) {
			super(nombre, apellido, contraseña, dNI, correo);
			
		}

		public int getID_recepcion() {
			return ID_recepcion;
		}

		public void setID_recepcion(int iD_recepcion) {
			ID_recepcion = iD_recepcion;
		}
		
	
		@Override
		public String toString() {
			return "ID Recepcion: " + ID_recepcion;
		}

		
		
		@Override
		public void Menu() {
			int contswitchgeneral=0;////Contador para salir del do general, es decir para cerrar sesion.
			do {
							
				String [] opcionesRol={"Cuotas", "Usuarios", "Clases", "Cronograma", "Perfil" ,"Cerrar sesion"};
				int opcionRol= JOptionPane.showOptionDialog(null, "Seleccione su rol", "Menú recepcion", 0, 0, null, opcionesRol, opcionesRol[0]);
				
				switch (opcionRol) {
				case 0://Cuotas
									
					int cont0=0;//Contador para salir de Cuotas y volver al menu principal de Recepcion
					do {
						
						String [] opcionesCuotas={"Asignar valor a cuotas", "Ver cuotas socios", "Volver"};
						int opcionCuota= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesCuotas, opcionesCuotas[0]);
						
						switch (opcionCuota) {
						case 0://Asignar valor a cuotas
							
							
							break;
							
						case 1://Ver cuota socios
							
							break;
			
						case 2://Volver
							cont0++;
							break;
						}
						
					} while (cont0==0);
					
					break;
		
				
				
				
				
				case 1://Usuarios
					
					int cont1=0;//Contador para salir de Usuarios y volver al menu principal de Recepcion
					do {
						
						String [] opcionesUsuarios={"Dar de alta a cliente", "Dar de baja a cliente", "Socios registrados" , "Dar de alta a profesor", "Dar de baja a profesor", "Volver"};
						int opcionUsuario= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesUsuarios, opcionesUsuarios[0]);
						
						switch (opcionUsuario) {
						case 0://Dar de alta
							
							String nombre=JOptionPane.showInputDialog("Ingrese el nombre");
							String apellido=JOptionPane.showInputDialog("Ingrese el apellido");
							int dni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la contraseña"));
							String contraseña = Integer.toString(dni);
							String correo=JOptionPane.showInputDialog("Ingrese el correo");
							int nivel=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel"));
							int telefono=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono"));
							
							
							String metodo=JOptionPane.showInputDialog("Ingrese forma de pago");
							LocalDate vencimiento = LocalDate.now();
							vencimiento = vencimiento.plusMonths(1);
							
							Cuota cuotanueva = new Cuota(metodo,vencimiento);
							
							ClienteControlador controlador = new ClienteControlador();
							controlador.addCliente(nombre, apellido, dni, contraseña, correo, nivel, telefono, cuotanueva);
							
							break;
							
						case 1: //Dar de baja a un cliente
							int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a dar de baja"));
							ClienteControlador controlador2 = new ClienteControlador();
							controlador2.deleteCliente(id);
							
							break;
			
						case 2://Socios registrados
							
							break;
						case 3://Dar de alta a profesor
							String nombreP=JOptionPane.showInputDialog("Ingrese el nombre");
							String apellidoP=JOptionPane.showInputDialog("Ingrese el apellido");
							int dniP=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la contraseña"));
							String contraseñaP = Integer.toString(dniP);
							String correoP=JOptionPane.showInputDialog("Ingrese el correo");
							
							ProfesorControlador controlador3 = new ProfesorControlador();
							controlador3.addProfesor(nombreP, apellidoP, contraseñaP, dniP, correoP);;
							
							break;
						case 4://Dar de baja a profesor
							int idProfesor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del profesor a dar de baja"));
							ProfesorControlador controlador4 = new ProfesorControlador();
							controlador4.deleteProfesor(idProfesor);
							break;
												
						case 5://Volver
							cont1++;
							break;
						}
						
					} while (cont1==0);
					
					break;
					
					
				
				case 2://Clase
					
					int cont2=0;//Contador para salir de Clase y volver al menu principal de Recepcion
					do {
						
						String [] opcionesClases={"Crear clase", "Ver informacion", "Volver"};
						int opcionClases= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesClases, opcionesClases[0]);
						
						switch (opcionClases) {
						case 0://Crear clase
							Profesor profenuevo = new Profesor("Alex", "Gimenez", "564684", 45451514,"alexgimenez@gmail.com");
							String nombreC = JOptionPane.showInputDialog("Ingrese el nombre de la clase");
							
							LocalDate fecha = LocalDate.now();
							int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora del inicio de la clase"));
							int minuto = Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese los minutos de inicio de la clase"));
							LocalDateTime horainicio = fecha.atTime(hora, minuto);
							
							int hora2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora de fin de la clase"));
							int minuto2 = Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese los minutos de fin de la clase"));
							LocalDateTime horafin = fecha.atTime(hora2, minuto2);
							int nivelC = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de la clase"));
							
							ClaseControlador controlclase = new ClaseControlador();
							controlclase.addClase(profenuevo,nombreC,horainicio,horafin,nivelC);
							
							
							break;
							
						case 1://Ver informacion
							
							break;
			
						case 2://Volver
							cont2++;
							break;
						}
						
					} while (cont2==0);
					
					break;
					
					
					
				case 3://Cronograma
					
					break;	
					
					
				case 4://Perfil
					
					int cont4=0;//Contador para salir de Perfil y volver al menu principal de Recepcion
					do {
						
						String [] opcionesPerfil={"Cambiar contraseña", "Volver"};
						int opcionPerfil= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesPerfil, opcionesPerfil[0]);
						
						switch (opcionPerfil) {
						case 0://Cambiar contraseña
							
							break;
							
						case 1://Volver
							cont4++;
							break;
						}
						
					} while (cont4==0);
					
					break;
					
					
				case 5://Cerrar sesion
					contswitchgeneral++;
					break;
				}
				
			} while (contswitchgeneral==0);
		}
	
		
}
