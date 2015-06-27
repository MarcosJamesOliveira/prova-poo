package br.iftm.prova3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	private static DBConnection instance;
	private EntityManagerFactory factory;
	private EntityManager em;
	
	private DBConnection(){
		 factory = Persistence.createEntityManagerFactory("lojadb"); 
		 em = factory.createEntityManager();
		
	}
	
	public EntityManager getEm() {
		return em;
	}

	public static DBConnection getInstance(){
		if(DBConnection.instance == null) {
			DBConnection.instance = new DBConnection(); 
		}
			return DBConnection.instance;
	}
}
