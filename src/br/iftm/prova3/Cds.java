package br.iftm.prova3;

public class Cds extends Produto{
	private int qtd_faixas;

	public Cds() {}

	public Cds(String nome, int preco,int qtd_faixas) 
	{
		super(nome, preco);
		this.qtd_faixas = qtd_faixas;
	}

	public int getQtd_faixas() {
		return qtd_faixas;
	}

	public void setQtd_faixas(int qtd_faixas) {
		this.qtd_faixas = qtd_faixas;
	}

	@Override
	public String toString() 
	{
		String msg = "\nQuantidade de Faixas: " + this.getQtd_faixas();
		return msg;
	}
	
	public static void cadastrar(Cds c)
	{
		DBConnection.getInstance().getEm().getTransaction().begin();
		DBConnection.getInstance().getEm().persist(c);
		DBConnection.getInstance().getEm().getTransaction().commit();
		
		System.out.println("Cd cadastrado com sucesso!");
	}
	public static void buscar(int id)
	{
		try 
		{
			Cds c = DBConnection.getInstance().getEm().find(Cds.class, id);
			
		} catch (Exception e) 
		{
			System.out.println("Cd n�o encontrado!");
		}
				
	}
	
	public static void excluir(int id)
	{
		try 
		{
			Cds c = new Cds();
			
			DBConnection.getInstance().getEm().getTransaction().begin();
			DBConnection.getInstance().getEm().remove(c);
			DBConnection.getInstance().getEm().getTransaction().commit();
			
			System.out.println("Cd Exclu�do com sucesso!");
			
		} catch (Exception e) 
		{
			System.out.println("N�o foi poss�vel excluir o Cd, pois ele n�o foi encontrado!");			
		}
	}
	

}
