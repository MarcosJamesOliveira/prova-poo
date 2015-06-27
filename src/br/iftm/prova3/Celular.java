package br.iftm.prova3;

public class Celular extends Produto{
	private String fabricante;

	public Celular() {}

	public Celular(String nome, int preco,String fabricante) 
	{
		super(nome, preco);
		this.fabricante = fabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() 
	{
		String msg = "\nFabricante: " + this.getFabricante();
		return msg;
	}
	
	public static void cadastrar(Celular c)
	{
		DBConnection.getInstance().getEm().getTransaction().begin();
		DBConnection.getInstance().getEm().persist(c);
		DBConnection.getInstance().getEm().getTransaction().commit();
		
		System.out.println("Celular cadastrado com sucesso!");
	}
	public static void buscar(int id)
	{
		try 
		{
			Celular c = DBConnection.getInstance().getEm().find(Celular.class, id);
			
		} catch (Exception e) 
		{
			System.out.println("Celular não encontrado!");
		}
				
	}
	
	public static void excluir(int id)
	{
		try 
		{
			Celular c = new Celular();
			
			DBConnection.getInstance().getEm().getTransaction().begin();
			DBConnection.getInstance().getEm().remove(c);
			DBConnection.getInstance().getEm().getTransaction().commit();
			
			System.out.println("Celular Excluído com sucesso!");
			
		} catch (Exception e) 
		{
			System.out.println("Não foi possível excluir o Celular, pois ele não foi encontrado!");			
		}
	}
	

}
