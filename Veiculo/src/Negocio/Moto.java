package Negocio;

public class Moto extends Veiculo {
	
	private boolean ApoioAcionado;
			
	public Moto (String n,String f,int a,int v){
		super(n, f, a, v);
		if (v == 0)
			ApoioAcionado = true;
		else
			ApoioAcionado = false;
	}
	
	@Override
	public void acelerar(){
		if (ApoioAcionado)
		{
			ApoioAcionado = false;
			System.out.println("Apoio desacionado");
		}
		super.acelerar();
	}
	
	@Override
	public void desacelerar(){
		super.desacelerar();
		if (getVelocidade()==0)
		{
			ApoioAcionado = true;
			System.out.println("Apoio acionado");
		}
	}
	
	@Override
	public void parar(){
		super.parar();
		ApoioAcionado = true;
		System.out.println("Apoio acionado");
	}
}
