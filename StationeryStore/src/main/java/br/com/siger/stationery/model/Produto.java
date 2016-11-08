package br.com.siger.stationery.model;

public class Produto implements Comparable{
	private String id = null;
	private String descricao = null;
	private int setor = 0;
	private String fabricante = null;
	private String complemento = null;
	private float preco = 0.0F;
	private boolean oferta = false;
	
	
	public Produto(String id, String descricao, int setor, String fabricante, String complemento, float preco,
			boolean oferta) {
		this.id = id;
		this.descricao = descricao;
		this.setor = setor;
		this.fabricante = fabricante;
		this.complemento = complemento;
		this.preco = preco;
		this.oferta = oferta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	public int compareTo(Object o) {
		Produto p = (Produto) o;
		
		return descricao.compareTo(p.descricao);
	}
	
}
