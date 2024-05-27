package Modelo;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente extends Persona implements MenuIniciarSesion {
	

	private int nivel;
	private int ID_Cliente;
	private int telefono;
	private Cuota cuota;
	private int ID_Cuota;
	
	//Lista static para agregar a todos los clientes que se crean
	static LinkedList<Cliente> clientes_general = new LinkedList<>();
	
	//Lista de las clases a las que se une el cliente
	private LinkedList<Clase> mis_clases = new LinkedList<>();
	
	//Lista de las clases que hizo el cliente
	private LinkedList<Clase> clases_realizadas= new LinkedList<>();
	
	//Lista de las rutinas que hizo el cliente
	private LinkedList<Rutina> mis_rutinas= new LinkedList<>();
	
	
	//Lista de clases disponibles(falta hacerla)

	
	public Cliente(String nombre, String apellido, String contraseña, int dNI, String correo, int nivel,
			int telefono) {
		super(nombre, apellido, contraseña, dNI, correo);
		this.nivel = nivel;
		this.telefono = telefono;

		
		//Creamos la cuota
		String metodo=JOptionPane.showInputDialog("Ingrese forma de pago");
		LocalDate vencimiento = LocalDate.now().plusMonths(1);
		Cuota cuota1 = new Cuota(metodo,vencimiento);
		
		//Agregamos la Cuota y el ID_Cuota a los atributos cuota e ID_Cuota de Cliente
		this.cuota=cuota1;
		this.ID_Cuota=cuota.getID_Cuota();
		
		//Falta que se cree la cuota automaticamente en la base de datos
	}
	
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getID_Cliente() {
		return ID_Cliente;
	}

	public void setID_Cliente(int iD_Cliente) {
		ID_Cliente = iD_Cliente;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
	
	public int getID_Cuota() {
		return ID_Cuota;
	}

	public void setID_Cuota(int iD_Cuota) {
		ID_Cuota = iD_Cuota;
	}

	public static LinkedList<Cliente> getClientes_general() {
		return clientes_general;
	}

	public static void setClientes_general(LinkedList<Cliente> clientes_general) {
		Cliente.clientes_general = clientes_general;
	}

	public LinkedList<Clase> getMis_clases() {
		return mis_clases;
	}

	public void setMis_clases(LinkedList<Clase> mis_clases) {
		this.mis_clases = mis_clases;
	}


	public LinkedList<Clase> getClases_realizadas() {
		return clases_realizadas;
	}


	public void setClases_realizadas(LinkedList<Clase> clases_realizadas) {
		this.clases_realizadas = clases_realizadas;
	}


	@Override
	public String toString() {
		return "Cliente [nivel=" + nivel + ", ID_Cliente=" + ID_Cliente + ", telefono=" + telefono + ", cuota=" + cuota
				+ ", ID_Cuota=" + ID_Cuota + ", mis_clases=" + mis_clases + ", clases_realizadas=" + clases_realizadas
				+ "]";
	}


	@Override
	public void Menu() {
		int contswitchgeneral=0; //Contador para salir del do general, es decir para cerrar sesion.
		do {
			
			String [] opcionesRol={"Clases", "Clases realizadas", "Rutinas", "Perfil", "Cerrar sesion"};
			int opcionRol= JOptionPane.showOptionDialog(null, "Seleccione su rol", "Menú Cliente", 0, 0, null, opcionesRol, opcionesRol[0]);
			
			switch (opcionRol) {
			
			case 0://Clases
				
				int cont=0;//Contador para salir de clases y volver al menu principal de Cliente
				do {
					
					String [] opcionesClases={"Informacion", "Inscribirse", "Volver"};
					int opcionClases= JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Menú Cliente", 0, 0, null, opcionesClases, opcionesClases[0]);
					
					switch (opcionClases) {
					case 0://Informacion
						
						break;
						
					case 1: //Inscribirse
						
						break;
		
					case 2://Salir
			
						cont++;
						break;
					}
					
				} while (cont==0);
				
				
				break;
				
			case 1://Clases realizadas
				
				break;
				
				
			case 2: //Rutinas
				
				break;
				
				
			case 3: //Perfil
				
				
				int cont4=0;//Contador para salir de perfil y volver al menu principal de Cliente
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
				
				
			case 4: //Cerrar sesión
				contswitchgeneral++;
				break;
	
			}
					
		} while (contswitchgeneral==0);
			
	}
		
	

}
