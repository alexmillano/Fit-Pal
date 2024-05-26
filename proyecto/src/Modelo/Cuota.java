package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Cuota {
	private int ID_Cuota;
	private Double valor;
	private String metodo;
	private LocalDate vencimiento;
	
	//Lista donde se agregan todas las cuotas creadas
	static LinkedList<Cuota> cuotas_general = new LinkedList<>();
	
	public Cuota(String metodo, LocalDate vencimiento) {
		super();
		this.valor = 5000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	
	public int getID_Cuota() {
		return ID_Cuota;
	}
	public void setID_Cuota(int iD_Cuota) {
		ID_Cuota = iD_Cuota;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public LocalDate getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	@Override
	public String toString() {
		return "Cuota [ID_Cuota=" + ID_Cuota + ", valor=" + valor + ", metodo=" + metodo + ", vencimiento="
				+ vencimiento + "]";
	}
	
	

	
	
}
