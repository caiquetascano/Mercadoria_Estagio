package com.br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Mercadoria;
import com.br.model.to.MercadoriaTO;
import com.google.gson.Gson;

/**
 * Servlet implementation class mercadoriaController
 */
@WebServlet("/mercadoriaController")
public class mercadoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public mercadoriaController() {

    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Tipo Busca verifica qual função usaremos, se for nula ela fara a busca dos filtros da pagina de pesquisa*/
		String tipoBusca = request.getParameter("tipo_busca");
		Mercadoria mercado = new Mercadoria();
		PrintWriter out = response.getWriter();
		String json = "";
		System.out.println(tipoBusca);
		if( tipoBusca == null ){
		
			String tipoMercadoria = request.getParameter("tipo_mercadoria");
			String nomeMercadoria = request.getParameter("nome_mercadoria");
			String tipoNegocio = request.getParameter("tipo_negocio");
			
			Map<String,String> filtros = new HashMap<String,String>();
			filtros.put("tipo_mercadoria", tipoMercadoria);
			filtros.put("nome_mercadoria", nomeMercadoria);
			filtros.put("tipo_negocio", tipoNegocio);
			
			ArrayList<MercadoriaTO> mercadoriaTO = mercado.carregarFiltros(filtros);
			
			 json = new Gson().toJson(mercadoriaTO);
			 System.out.println(json);
		}else if( tipoBusca.equals( "categoria" ) ){
			System.out.println(request.getParameter("tipo_busca"));
			ArrayList<String> tipos = mercado.getTiposMercadorias(request.getParameter("data"));

			json = new Gson().toJson(tipos);
		   // System.out.println(json);
		}else{
			double media = mercado.getMediaPreco(request.getParameter("tipo"),request.getParameter("nome"));
			json = new Gson().toJson(media);
		}
		


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF8-8");
		out.print(json);
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoBusca = request.getParameter("tipo_busca");
		System.out.println(tipoBusca);
		
		if( tipoBusca.equals("cadastro") ){
		
			String tipoMercadoria = request.getParameter("tipo_mercadoria");
			String nomeMercadoria = request.getParameter("nome_mercadoria");
			String tipoNegocio = request.getParameter("tipo_negocio");
			
			int quantidade = Integer.parseInt(request.getParameter("quantidade"));
			double preco = Double.parseDouble(request.getParameter("preco"));
			
			Mercadoria mercadoria = new Mercadoria();
			MercadoriaTO mercadoriaTO = mercadoria.getMercadoriaTO();
			
			mercadoriaTO.setTipoMercadoria(tipoMercadoria);
			mercadoriaTO.setNomeMercadoria(nomeMercadoria);
			mercadoriaTO.setTipoNegocio(tipoNegocio);
			mercadoriaTO.setQuantidade(quantidade);
			mercadoriaTO.setPreco(preco);
			int iDMercadoria = mercadoria.cadastrarMercadoria(mercadoriaTO);
			
			mercadoriaTO.setiDMercadoria(iDMercadoria);
			
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(mercadoriaTO);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF8-8");
			out.print(json);
			

		}else{
	    	Mercadoria mercadoria = new Mercadoria();
	    	int id = Integer.parseInt( request.getParameter("id") );
	    	System.out.println("oi");
	    	int resultado = mercadoria.deletarMercadoria( id );
	    	PrintWriter out = response.getWriter();
	    	out.print(resultado);
		}
	    	
		
		
	}

}
