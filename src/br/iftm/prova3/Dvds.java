package br.iftm.prova3;

public class Dvds extends Produto{
	private int duracao;
	

	public Dvds() {}

	public Dvds(String nome, int preco,int duracao) 
	{
		super(nome, preco);
		this.duracao = duracao;	
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() 
	{
		String msg = "\nDura��o: " + this.getDuracao();
		return msg;
	}
	
	public static void cadastrar(Dvds d)
	{
		DBConnection.getInstance().getEm().getTransaction().begin();
		DBConnection.getInstance().getEm().persist(d);
		DBConnection.getInstance().getEm().getTransaction().commit();
		
		System.out.println("Dvd cadastrado com sucesso!");
	}
	public static void buscar(int id)
	{
		try 
		{
			Dvds d = DBConnection.getInstance().getEm().find(Dvds.class, id);
			
		} catch (Exception e) 
		{
			System.out.println("Dvd n�o encontrado!");
		}
				
	}
	
	public static void excluir(int id)
	{
		try 
		{
			Dvds d = new Dvds();
			
			DBConnection.getInstance().getEm().getTransaction().begin();
			DBConnection.getInstance().getEm().remove(d);
			DBConnection.getInstance().getEm().getTransaction().commit();
			
			System.out.println("Dvd Exclu�do com sucesso!");
			
		} catch (Exception e) 
		{
			System.out.println("N�o foi poss�vel excluir o Dvd, pois ele n�o foi encontrado!");			
		}
	}
	

}
