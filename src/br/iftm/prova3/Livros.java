package br.iftm.prova3;

public class Livros extends Produto{
	private String autor;

	public Livros() {}

	public Livros(String nome, int preco, String autor) 
	{
		super(nome, preco);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() 
	{
		String msg = "\nAutor: " + this.getAutor();
		return msg;
	}
	
	public static void cadastrar(Livros l)
	{
		DBConnection.getInstance().getEm().getTransaction().begin();
		DBConnection.getInstance().getEm().persist(l);
		DBConnection.getInstance().getEm().getTransaction().commit();
		
		System.out.println("Livro cadastrado com sucesso!");
	}
	public static void buscar(int id)
	{
		try 
		{
			Livros l = DBConnection.getInstance().getEm().find(Livros.class, id);
			
		} catch (Exception e) 
		{
			System.out.println("Livro não encontrado!");
		}
				
	}
	
	public static void excluir(int id)
	{
		try 
		{
			Livros l = new Livros();
			
			DBConnection.getInstance().getEm().getTransaction().begin();
			DBConnection.getInstance().getEm().remove(l);
			DBConnection.getInstance().getEm().getTransaction().commit();
			
			System.out.println("Livro Excluído com sucesso!");
			
		} catch (Exception e) 
		{
			System.out.println("Não foi possível excluir o Livro, pois ele não foi encontrado!");			
		}
	}
	
}
