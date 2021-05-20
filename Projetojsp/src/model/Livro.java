package model;

import control.LivroControl;

public class Livro {

		
		
		private String nome;
		 private String autor;
		 private String editora;
		 private int nrPaginas;
	 private double preco;
		
	public Livro (String nome, String autor, String editora,int nr_paginas,double preco) {
	this.nome= nome;
	this.autor=autor;
	this.editora=editora;
	this.nrPaginas=nrPaginas;
	this.preco=preco;
	
	}
	public Livro(Livro livro) {
		this.nome = livro.getNome();
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.nrPaginas = livro.getNrPaginas();
		this.preco = livro.getPreco();
	}
	
		public Livro() {
		// TODO Auto-generated constructor stub
	}
		public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getAutor() {
		return autor;
	}




	public void setAutor(String autor) {
		this.autor = autor;
	}




	public String getEditora() {
		return editora;
	}




	public void setEditora(String editora) {
		this.editora = editora;
	}




	public int getNrPaginas() {
		return nrPaginas;
	}




	public void setNrPaginas(int nrPaginas) {
		this.nrPaginas = nrPaginas;
	}




	public double getPreco() {
		return preco;
	}




	public void setPreco(double preco) {
		this.preco = preco;
	}




		@Override
		public String toString() {
			return "Livro [nome=" + nome + ", autor=" + autor + ", editora=" + editora + ", nrPaginas=" + nrPaginas
					+ ", preco=" + preco + "]";
		}
	
		}
		
		
		
	


