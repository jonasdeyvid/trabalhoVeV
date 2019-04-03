package models;

import java.sql.Date;

public class Conta {
	private double valor;
	private String descricao;
	private int idConta;
	private int idBoleto;
	private int idRecebedor;
	private int idUsuario;
	private Date dataVencimento;
	private Date dataPagamento;
	private boolean pagamento;
	
	
	
	public Conta(double valor, String descricao, int idConta, int idBoleto, int idRecebedor, int idUsuario,
			Date dataVencimento, boolean pagamento,Date dataPagamento) {
		super();
		this.valor = valor;
		this.descricao = descricao;
		this.idConta = idConta;
		this.idBoleto = idBoleto;
		this.idRecebedor = idRecebedor;
		this.idUsuario = idUsuario;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.pagamento = pagamento;
	}
	public double getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getIdConta() {
		return idConta;
	}
	public int getIdBoleto() {
		return idBoleto;
	}
	public int getIdRecebedor() {
		return idRecebedor;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	public boolean getPagamento() {
		return pagamento;
	}
}
