package br.iftm.prova3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Produto {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private int preco;
	
	public Produto() {}
	
	public Produto(String nome, int preco) 
	{
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	@Override
	public String toString() 
	{
		String msg = "\nNome: " + this.getNome() + "\nPreço: " + this.getPreco();
		return msg;
	}
	
	
}
