package br.iftm.prova3;

public class Jogos extends Produto{
	private String genero;

	public Jogos() {}

	public Jogos(String nome, int preco,String genero) 
	{
		super(nome, preco);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() 
	{
		String msg = "\nGênero: " + this.getGenero();
		return msg;
	}
	
	public static void cadastrar(Jogos j)
	{
		DBConnection.getInstance().getEm().getTransaction().begin();
		DBConnection.getInstance().getEm().persist(j);
		DBConnection.getInstance().getEm().getTransaction().commit();
		
		System.out.println("Jogo cadastrado com sucesso!");
	}
	public static void buscar(int id)
	{
		try 
		{
			Jogos j = DBConnection.getInstance().getEm().find(Jogos.class, id);
			
		} catch (Exception e) 
		{
			System.out.println("Jogo não encontrado!");
		}
				
	}
	
	public static void excluir(int id)
	{
		try 
		{
			Jogos j = new Jogos();
			
			DBConnection.getInstance().getEm().getTransaction().begin();
			DBConnection.getInstance().getEm().remove(j);
			DBConnection.getInstance().getEm().getTransaction().commit();
			
			System.out.println("Jogo Excluído com sucesso!");
			
		} catch (Exception e) 
		{
			System.out.println("Não foi possível excluir o Jogo, pois ele não foi encontrado!");			
		}
	}
	

}
