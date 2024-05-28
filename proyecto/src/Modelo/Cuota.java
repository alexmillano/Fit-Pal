package Modelo;


import java.time.LocalDate;
import java.util.LinkedList;

public class Cuota {
	private int ID_Cuota;
	private int ID_cliente;
	private Double valor;
	private int metodo;
	private LocalDate vencimiento;
	
	//Lista donde se agregan todas las cuotas creadas
	static LinkedList<Cuota> cuotas_general = new LinkedList<>();
	
	public Cuota(int metodo, LocalDate vencimiento) {
		super();
		this.valor = 5000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	public Cuota(int ID_cliente, Double valor, int metodo, LocalDate vencimiento) {
		super();
		this.ID_cliente = ID_cliente;
		this.valor = 5000.00;
		this.metodo = metodo;
		this.vencimiento = vencimiento;
	}
	
	
	public int getCliente() {
		return ID_cliente;
	}
	public void setCliente(int ID_cliente) {
		this.ID_cliente = ID_cliente;
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
	public int getMetodo() {
		return metodo;
	}
	public void setMetodo(int metodo) {
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
