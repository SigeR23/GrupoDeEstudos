package br.com.siger.stationery.db;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javamoney.moneta.Money;

import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.model.Setor;

public class CriaProdutos {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		CurrencyUnit CURRENCY = Monetary.getCurrency("BRL");
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		Setor setor1 = manager.find(Setor.class, 1L);
		BigDecimal valor = new BigDecimal(13.99);
		Produto p = new Produto(null, "Minas grafite 0.5 mm/HB", setor1, "Faber Castell", "CX 12 ET", Money.of(valor, CURRENCY), false);
		
		valor = new BigDecimal(20.40);
		Produto p2 = new Produto(null, "Caneta Esferográfica Cristal vermelha", setor1, "BIC", "CX 50 un", Money.of(valor, CURRENCY), true);
		
		valor = new BigDecimal(5.12);
		Setor setor2 = manager.find(Setor.class, 2L);
		Produto p3 = new Produto(null, "Pasta plástica em L", setor2, "Plastpark", "pp 0.15, 220x330 mm varias cores, pacote 10 un", Money.of(valor, CURRENCY), false);
		
		valor = new BigDecimal(13.9);
		Produto p4 = new Produto(null, "Papel sulfite A4", setor2, "Chamex", "Alcalino 90g, pacote 500 fl", Money.of(valor, CURRENCY), false);
		
		Setor setor3  = manager.find(Setor.class, 3L);
		valor = new BigDecimal(65.2);
		Produto p5 = new Produto(null, "Envelope comercial 114x162", setor3, "Celucat", "S/rpc 90g, aba ades. 135 sf", Money.of(valor, CURRENCY), false);
		
		valor = new BigDecimal(28.0);
		Produto p6 = new Produto(null, "Etiqueta adesiva glossy para inqui-jet 127x88,9 mm", setor3, "Pimaco", "A4100g, pt 10 fl", Money.of(valor, CURRENCY), false);
		
		Setor setor4 = manager.find(Setor.class, 4L);
		valor = new BigDecimal(9.38);
		Produto p7 = new Produto(null, "Tinta p/ tecido metalica conj. c/ 6 cores glitter", setor4, "Squizz", "BT 1 CJ", Money.of(valor, CURRENCY), false);
		
		
		valor = new BigDecimal(18.1);
		Produto p8 = new Produto(null, "Pincel chato n.14 amarelo 815", setor4, "Tigre", "SC 12 un", Money.of(valor, CURRENCY), false);
		
		Setor setor5 = manager.find(Setor.class, 5L);
		valor = new BigDecimal(19.3);
		Produto p9 = new Produto(null, "Caderno universitário 10x1 200 fl moranguinho", setor5, "Spiral mo", "pacote 3 un", Money.of(valor, CURRENCY), false);
		
		valor = new BigDecimal(12.5);
		Produto p10 = new Produto(null, "Grampeador de mesa grande 26/6", setor5, "Genmes", "cx 1 un", Money.of(valor, CURRENCY), true);
		
		Setor setor6 = manager.find(Setor.class, 6L);
		valor = new BigDecimal(200.99);
		Produto p11 = new Produto(null, "Monitor convencional 15\" T530S", setor6, "LG", "Fletron Tela Plana", Money.of(valor, CURRENCY), true);
		
		valor = new BigDecimal(1170.0);
		Produto p12 = new Produto(null, "Computador Celrom b315", setor6, "Semptoshiba", "HD 40gb, 256 mb RAM, CD-RW", Money.of(valor, CURRENCY), false);
		
		Setor setor7 = manager.find(Setor.class, 7L);
		valor = new BigDecimal(10.9);
		Produto p13 = new Produto(null, "Estojo de laminas Olfa asb-10", setor7, "Microservice", "BT 1 un", Money.of(valor, CURRENCY), false);
		
		valor = new BigDecimal(8.33);
		Produto p14 = new Produto(null, "Fita Adesiva Polisil 10x30 polipropileno amarela", setor7, "Atel Bras", "PT 10 rl", Money.of(valor, CURRENCY), false);
		
		manager.persist(p);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		manager.persist(p5);
		manager.persist(p6);
		manager.persist(p7);
		manager.persist(p8);
		manager.persist(p9);
		manager.persist(p10);
		manager.persist(p11);
		manager.persist(p12);
		manager.persist(p13);
		manager.persist(p14);
		
		tx.commit();
		manager.close();
	}
}
