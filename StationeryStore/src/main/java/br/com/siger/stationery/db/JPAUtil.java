package br.com.siger.stationery.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("stationery");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
