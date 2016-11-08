package br.com.siger.stationery.model;

public class Setor implements Comparable {
	private int id = 0;
	private String descricao = null;
	
	public Setor(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int compareTo(Object o) {
		Setor s = (Setor) o;
		return descricao.compareTo(s.descricao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
