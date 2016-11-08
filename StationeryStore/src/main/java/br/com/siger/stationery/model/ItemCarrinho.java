package br.com.siger.stationery.model;

public class ItemCarrinho <T> {
	private T item;
	private int quantidade;
	
	public ItemCarrinho(T item) {
		this.item = item;
		this.quantidade = 1;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public T getItem() {
		return item;
	}
}
