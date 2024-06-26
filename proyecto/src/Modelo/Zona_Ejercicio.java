package Modelo;

public class Zona_Ejercicio {
	
	private int ID_Zona_Ejercicio;
	private String Nombre;
	
	
	public Zona_Ejercicio(String Nombre) {
		super();
		this.Nombre = Nombre;
	}
	
	public Zona_Ejercicio() {
		super();

	}
	
	public Zona_Ejercicio(int ID_Zona_Ejercicio,String Nombre) {
		super();
		this.ID_Zona_Ejercicio=ID_Zona_Ejercicio;
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

	@Override
	public String toString() {
		return "Zona_Ejercicio [ID_Zona_Ejercicio=" + ID_Zona_Ejercicio + ", Nombre=" + Nombre + "]";
	}

	
	
	

}
