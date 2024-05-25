package Modelo;

import javax.swing.JOptionPane;

public class Cliente extends Persona implements MenuIniciarSesion {
	
	private int nivel;
	private int ID_Cliente;
	private int telefono;
	private int ID_Cliente_Rutina;
	//private Cuotas cuota;
	
	//Lista de clases disponibles
	//Lista de clases realizadas (vacia)
	//Lista de rutinas (vacia);
	//Falta poner cuota en el constructor;
	
	public Cliente(String nombre, String apellido, String contraseña, int dNI, String correo, int nivel, int iD_Cliente,
			int telefono, int ID_Cliente_Rutina) {
		super(nombre, apellido, contraseña, dNI, correo);
		this.nivel = nivel;
		ID_Cliente = iD_Cliente;
		this.telefono = telefono;
		ID_Cliente_Rutina = ID_Cliente_Rutina;
		//this.cuota=cuota;
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
	
	/*
	public Cuotas getCuota() {
		return cuota;
	}
	public void setCuota(Cuotas cuota) {
		this.cuota = cuota;
	}*/
	@Override
	public String toString() {
		return "Nivel del cliente: " + nivel + "\nID_Cliente: " + ID_Cliente + "\nTelefono: " + telefono;
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
