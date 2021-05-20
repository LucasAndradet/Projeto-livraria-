package model;

import control.ClienteControl;

public class Cliente {
	private String nome, cpf, sexo;
	private int idade;
private String usuario;
private String senha;
	 
	public Cliente(String nome, String cpf, String sexo, int idade) {
		// construtor cheio
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	
		
	}
	public void login(String usuario , String senha) {
		this.usuario=usuario;
		this.senha=senha;
	}
public Cliente (Cliente Cliente) {
	this.nome = Cliente.getNome();
	this.cpf = Cliente.getCpf();
	this.sexo = Cliente.getSexo();
	this.idade = Cliente.getIdade();
}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", idade=" + idade + "]";
	}

}
