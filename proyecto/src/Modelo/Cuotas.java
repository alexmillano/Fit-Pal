package Modelo;

import java.time.LocalDateTime;

public class Cuotas {

	private Double valor;
	private String metodo;
	private LocalDateTime vencimiento;
	public Cuotas(Double valor, String metodo, LocalDateTime vencimiento) {
		super();
		this.valor = 5000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
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
	
	
}
