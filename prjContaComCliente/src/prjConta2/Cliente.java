package prjConta2;

public class Cliente {

	private String cpf;
	private String nome;
	private String endereco;
	private String email;
	
	
	public Cliente(String cpf, String nome, String endereco, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public String getNome() {
		return nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getEmail() {
		return email;
	}
	
}
