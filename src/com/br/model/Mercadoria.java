package com.br.model;

import java.util.ArrayList;
import java.util.Map;

import com.br.model.dao.MercadoriaDAO;
import com.br.model.to.MercadoriaTO;

public class Mercadoria {
    private int iDMercadoria;
    private String tipoMercadoria;
    private String nomeMercadoria;
    private int quantidade;
    private double preco;
    private String tipoNegocio;
    
    public Mercadoria(){}
    public Mercadoria(int iDMercadoria, String tipoMercadoria, String nomeMercadoria, int quantidade, double preco, String tipoNegocio) {
        this.iDMercadoria = iDMercadoria;
        this.tipoMercadoria = tipoMercadoria;
        this.nomeMercadoria = nomeMercadoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tipoNegocio = tipoNegocio;
    }
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
    
    private MercadoriaDAO getMercadoriaDAO(){
    	return new MercadoriaDAO();
    }
    public MercadoriaTO getMercadoriaTO(){
    	return new MercadoriaTO();
    }
    
    public int cadastrarMercadoria( MercadoriaTO mercadoriaTO ){
    	return this.getMercadoriaDAO().inserirMercadoria(mercadoriaTO);
    }
    public ArrayList<String> getTiposMercadorias(){
    	return this.getMercadoriaDAO().carregaTipoMercadoria();
    }
    public ArrayList<String> getTiposMercadorias(String pesquisa){
    	return this.getMercadoriaDAO().carregaTipoMercadoria(pesquisa);
    }
    public double getMediaPreco(String tipo,String nome){
    	return  this.getMercadoriaDAO().getMediaPreco(tipo, nome);
    }
    public int deletarMercadoria(int id){
    	return this.getMercadoriaDAO().deletarMecadoria(id);
    }
    public ArrayList<MercadoriaTO> carregarFiltros(Map<String,String> filtros){
    	return this.getMercadoriaDAO().carregarFiltros(filtros);
    }
    
    
    
    
}
