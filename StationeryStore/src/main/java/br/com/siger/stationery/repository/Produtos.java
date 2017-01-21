package br.com.siger.stationery.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.siger.stationery.model.Produto;

public class Produtos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private EntityManager manager;
	
	public Produtos(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Produto> todos() {
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}
}
