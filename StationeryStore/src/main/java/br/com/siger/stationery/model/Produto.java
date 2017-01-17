package br.com.siger.stationery.model;

import java.io.Serializable;

import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.siger.stationery.converter.MonetaryAmountConverter;
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRD_ID")
	private Long id;
	
	@Column(name = "PRD_DESCRICAO", length = 64, nullable = false)
	private String descricao = null;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "STR_ID")
	private Setor setor;
	
	@Column(name = "PRD_FABRICANTE", length = 64, nullable = false)
	private String fabricante = null;
	
	@Column(name = "PRD_COMPLEMENTO", length = 192)
	private String complemento = null;
	
	@Column(name = "PRD_PRECO")
	@Convert(converter = MonetaryAmountConverter.class)
	private MonetaryAmount preco;
	
	@Column(name = "PRD_EM_OFERTA")
	private boolean oferta = false;
	
	@Deprecated
	public Produto() {
		
	}
	
	
	public Produto(Long id, String descricao, Setor setor, String fabricante, String complemento, MonetaryAmount preco,
			boolean oferta) {
		this.id = id;
		this.descricao = descricao;
		this.setor = setor;
		this.fabricante = fabricante;
		this.complemento = complemento;
		this.preco = preco;
		this.oferta = oferta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
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

	

	public MonetaryAmount getPreco() {
		return preco;
	}

	public void setPreco(MonetaryAmount preco) {
		this.preco = preco;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
	

}
