package model;

import control.FuncionarioControl;

public class Funcionario {
	// tem os atributos e metodos da entidade
	// ele tb faz o tratamento dos dados, tratamento mais projunto.

	private String nome;
	private String cpf;
	private String tel;
	private String cel;
	private String idt;
	private String email;
private  String senha;
private String usuario;
	public Funcionario() {// construtor vazio

	}
	
	public Funcionario(Funcionario funcionario) {
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.tel = funcionario.getCel();
		this.idt = funcionario.getIdt();
		this.email = funcionario.getEmail();
		
	}


	public Funcionario(String nome, String cpf, String tel, String cel, String idt, String email) {
		// construtor cheio
		this.nome = nome;
		this.cpf = cpf;
		this.tel = tel;
		this.cel = cel;
		this.idt = idt;
		this.email = email;
		
	}
	public void login(String usuario , String senha) {
		this.usuario=usuario;
		this.senha=senha;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getIdt() {
		return idt;
	}

	public void setIdt(String idt) {
		this.idt = idt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", tel=" + tel + ", cel=" + cel + ", idt=" + idt
				+ ", email=" + email + "]";
	}

}


