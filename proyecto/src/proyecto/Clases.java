package proyecto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;

public class Clases {
	private LocalDate inicio;
	private Duration duracion;
	private int inscritos; //Misma lista que cuando los clientes se unen//
	private String nivel;
	private String metodologia;
	private LinkedList<Rutinas> rutinas = new LinkedList<>();
	public Clases(LocalDate inicio, Duration duracion, int inscritos, String nivel, String metodologia,
			LinkedList<Rutinas> rutinas) {
		super();
		this.inicio = inicio;
		this.duracion = duracion;
		this.inscritos = inscritos;
		this.nivel = nivel;
		this.metodologia = metodologia;
		this.rutinas = rutinas;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	public int getInscritos() {
		return inscritos;
	}
	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}
	public LinkedList<Rutinas> getRutinas() {
		return rutinas;
	}
	public void setRutinas(LinkedList<Rutinas> rutinas) {
		this.rutinas = rutinas;
	}
	@Override
	public String toString() {
		return "Clases de inicio: " + inicio + "\nDuracion: " + duracion + "\nInscritos: " + inscritos + "\nNivel: " + nivel
				+ "\nMetodologia: " + metodologia + "\nRutinas: " + rutinas;
	}
	
	
	
}
