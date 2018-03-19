package Negocio;

public class Carro extends Veiculo {
	
	private int QtdePortas;
	
	public Carro(String n,String f,int a,int v, int p){
		super(n, f, a, v);
		QtdePortas = p;
	}
	
	@Override
	public void acelerar(){
		velocidade+=10;
		limitarVelocidade();
		System.out.println(super.retornarVeiculo());
	}
}
