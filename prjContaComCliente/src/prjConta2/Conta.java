package prjConta2;

public class Conta {
	private static int contador=0;
	private int numero;
	private double saldo;
	private double limite;
	private Cliente cliente;
	private String tipo;
	
	public Conta(Cliente cliente, String tipo, double saldo, double limite){
		this.numero=++contador;
		this.cliente = cliente;
		this.tipo = tipo;
		this.saldo = saldo;
		this.limite = limite;	
	}
	
	public void deposito(double valor){
			saldo+= valor;
	}
	
	public void retirada(double valor){
			saldo-=valor;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	public double getLimite(){
		return limite;
	}
	
	public void setLimite(double l){
		limite = l;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void setCliente(Cliente c){
		cliente = c;
	}
	
	public String getTipoConta(){
		return tipo;
	}
	
	public int getNumero(){
		return numero;
	}

}
