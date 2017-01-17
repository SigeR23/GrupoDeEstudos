package br.com.siger.stationery.db;

import javax.persistence.Persistence;

public class CriarTabelas {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("stationery");
	}
}
