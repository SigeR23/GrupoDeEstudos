package br.com.siger.stationery.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.siger.stationery.model.Setor;

public class CriaSetores {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Setor setor = new Setor(null, "Escrita e marcadores");
		Setor setor2 = new Setor(null, "Papeis e pastas");
		Setor setor3 = new Setor(null, "Envelopes e Entiquetas");
		Setor setor4 = new Setor(null, "Artesanato e cultura");
		Setor setor5 = new Setor(null, "Escolar e escritorio");
		Setor setor6 = new Setor(null, "Informática");
		Setor setor7 = new Setor(null, "Embalagens");
		
		manager.persist(setor);
		manager.persist(setor2);
		manager.persist(setor3);
		manager.persist(setor4);
		manager.persist(setor5);
		manager.persist(setor6);
		manager.persist(setor7);
		
		tx.commit();
		manager.close();
		
	}
}
