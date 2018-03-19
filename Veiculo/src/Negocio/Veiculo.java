package Negocio;

public abstract class Veiculo {

	private final int VELOCIDADEMAXIMA = 220;
	private final int VELOCIDADEMINIMA = 0;
	
	private String nome;
	private String fabricante;
	private int ano;
	protected int velocidade;
	
	public Veiculo(String n,String f,int a,int v){
		nome = n;
		fabricante = f;
		ano = a;
		velocidade = v;
	}  	
	
	public String getNome() {
		return nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public int getAno() {
		return ano;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void acelerar(){
		velocidade+=5;
		limitarVelocidade();
		System.out.println(retornarVeiculo());
	}
	public void desacelerar(){
		velocidade-=5;
		limitarVelocidade();
		System.out.println(retornarVeiculo());
	}
	
	public void parar(){
		velocidade=0;
		System.out.println(retornarVeiculo());
	}
	
	protected String retornarVeiculo(){
		return "A velocidade atual do "+ nome + " " + fabricante + " " + ano + " é :" + velocidade;
	}
	
	protected void limitarVelocidade(){
		if (velocidade > VELOCIDADEMAXIMA)
			velocidade = VELOCIDADEMAXIMA;
		if (velocidade < VELOCIDADEMINIMA)
			velocidade = VELOCIDADEMINIMA;
	}
	
	
	
	
	
}
