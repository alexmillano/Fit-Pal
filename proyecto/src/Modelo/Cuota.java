package Modelo;

import java.time.LocalDate;


public class Cuota {

	private int ID_Cuota;
	private Double valor;
	private String metodo;
	private LocalDate vencimiento;
	public Cuota(int ID_Cuota,String metodo, LocalDate vencimiento) {
		super();
		this.ID_Cuota = ID_Cuota;
		this.valor = 25000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	public Cuota(String metodo, LocalDate vencimiento) {
		super();
		this.valor = 25000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	
	public void setID_Cuota(int iD_Cuota) {
	}

	public int getID_Cuota() {
		return ID_Cuota;
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
		return "Cuotas: " + valor + "\nMetodo: " + metodo + "\nVencimiento: " + vencimiento;
	}
	
	
	public void VerInformacionCuotas() {
		
	}
	
}
