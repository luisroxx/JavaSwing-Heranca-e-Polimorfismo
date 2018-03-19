package Viewe;

import javax.swing.JOptionPane;
import Negocio.Veiculo;
import Negocio.Carro;
import Negocio.Moto;

public class Principal {
	
	public static void main(String args[]){
		
		int opCriar;
		String nome;
		String fab;
		int ano;
		int vel;		
		
		opCriar = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite 1 para criar um carro \n"+
				"Digite 2 para criar uma moto"));
		
			nome = (JOptionPane.showInputDialog(
					"Digite o nome do veiculo"));
			
			fab = (JOptionPane.showInputDialog(
					"Digite o nome do fabricante"));
			
			ano = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite o ano do veiculo"));
			
			do{
				vel = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite a velocidade do veiculo"));
				
				if (vel>220)
					System.out.println("Velocidade não pode ser acima de 220");
				if (vel<0)
					System.out.println("Velocidade não pode ser abaixo de 0");
				
			}while ((vel < 0) || (vel > 220));
					
			if (opCriar == 1)
			{
				int QtPortas = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite a quantidade de portas do veiculo"));
				Carro V1 = new Carro(nome, fab, ano, vel, QtPortas);
				Dirige(V1);				
			}
			else
			{
				Moto V1 = new Moto(nome, fab, ano, vel);
				Dirige(V1);	
			}
	}
		
	public static void Dirige(Veiculo V1)
	{
		int op;
		
		do{
			
			op = Integer.parseInt(JOptionPane.showInputDialog(
					"Informe a operação desejada \n\n" + 
					" 1 - Acelerar \n" +
					" 2 - Desacelerar \n" +
					" 3 - Parar \n" +
					" 4 - Sair do veiculo \n"
					));			
			
			switch (op){			
				case 1: V1.acelerar(); break;
				case 2: V1.desacelerar(); break;
				case 3: V1.parar(); break;
				case 4: break;
			}
			
		} while(op != 4);
	}

}
