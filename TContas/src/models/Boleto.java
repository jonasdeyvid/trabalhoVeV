package models;

public class Boleto {
	private int idBoleto;
	private String numeroBoleto;
	public Boleto(int idBoleto, String numeroBoleto) {
		super();
		this.idBoleto = idBoleto;
		this.numeroBoleto = numeroBoleto;
	}
	public int getIdBoleto() {
		return idBoleto;
	}
	public String getNumeroBoleto() {
		return numeroBoleto;
	}
	
	
	
	
}
