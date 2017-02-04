package br.com.siger.stationery.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-02-04T15:47:52.040-0200")
@StaticMetamodel(Produto.class)
public class Produto_ {
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> descricao;
	public static volatile SingularAttribute<Produto, Setor> setor;
	public static volatile SingularAttribute<Produto, String> fabricante;
	public static volatile SingularAttribute<Produto, String> complemento;
	public static volatile SingularAttribute<Produto, Boolean> oferta;
}
