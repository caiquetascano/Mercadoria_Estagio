package com.br.model.to;

public class MercadoriaTO {

	private int iDMercadoria;
	private String tipoMercadoria;
	private String nomeMercadoria;
	private int quantidade;
	private double preco;
	private String tipoNegocio;

	public int getiDMercadoria() {
		return iDMercadoria;
	}

	public void setiDMercadoria(int iDMercadoria) {
		this.iDMercadoria = iDMercadoria;
	}

	public String getTipoMercadoria() {
		return tipoMercadoria;
	}

	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public String getNomeMercadoria() {
		return nomeMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
}
