package Modelo;

import java.time.LocalDateTime;


public class Cuota {

	private Double valor;
	private String metodo;
	private LocalDateTime vencimiento;
	public Cuota(int ID_Cuota,Double valor, String metodo, LocalDateTime vencimiento) {
		super();
		this.valor = valor;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	
	public void setID_Cuota(int iD_Cuota) {
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
	public LocalDateTime getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(LocalDateTime vencimiento) {
		this.vencimiento = vencimiento;
	}
	@Override
	public String toString() {
		return "Cuotas: " + valor + "\nMetodo: " + metodo + "\nVencimiento: " + vencimiento;
	}
	
	
	public void VerInformacionCuotas() {
		
	}
	
}
