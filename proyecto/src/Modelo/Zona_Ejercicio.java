package Modelo;

public class Zona_Ejercicio {
	
	private int ID_Zona_Ejercicio;
	private String Zona;
	
	
	public Zona_Ejercicio(String zona) {
		super();
		this.Zona = zona;
	}

	public int getID_Zona_Ejercicio() {
		return ID_Zona_Ejercicio;
	}
	

	public void setID_Zona_Ejercicio(int iD_Zona_Ejercicio) {
		ID_Zona_Ejercicio = iD_Zona_Ejercicio;
	}
	public String getZona() {
		return Zona;
	}
	public void setZona(String zona) {
		Zona = zona;
	}
	@Override
	public String toString() {
		return "Zona_Ejercicio [ID_Zona_Ejercicio=" + ID_Zona_Ejercicio + ", Zona=" + Zona + "]";
	}
	
	
	

}
