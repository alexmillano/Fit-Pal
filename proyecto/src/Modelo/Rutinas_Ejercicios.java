package Modelo;

public class Rutinas_Ejercicios {
	private int ID_Rutinas;
	private int ID_Ejercicios;
	
	
	public Rutinas_Ejercicios(int iD_Rutinas, int iD_Ejercicios) {
		super();
		this.ID_Rutinas = iD_Rutinas;
		this.ID_Ejercicios = iD_Ejercicios;
	}
	
	public int getID_Rutinas() {
		return ID_Rutinas;
	}
	public void setID_Rutinas(int iD_Rutinas) {
		ID_Rutinas = iD_Rutinas;
	}
	public int getID_Ejercicios() {
		return ID_Ejercicios;
	}
	public void setID_Ejercicios(int iD_Ejercicios) {
		ID_Ejercicios = iD_Ejercicios;
	}
	
	
}
