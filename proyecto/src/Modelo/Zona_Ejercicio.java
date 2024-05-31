package Modelo;

public class Zona_Ejercicio {
	
	private int ID_Zona_Ejercicio;
	private String Nombre;
	
	
	public Zona_Ejercicio(String Nombre) {
		super();
		this.Nombre = Nombre;
	}

	public int getID_Zona_Ejercicio() {
		return ID_Zona_Ejercicio;
	}
	

	public void setID_Zona_Ejercicio(int iD_Zona_Ejercicio) {
		ID_Zona_Ejercicio = iD_Zona_Ejercicio;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
	

}
