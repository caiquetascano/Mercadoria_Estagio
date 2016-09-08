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
import javax.servlet.http.HttpSession;

import com.br.model.Mercadoria;
import com.br.model.to.MercadoriaTO;
import com.google.gson.Gson;

@WebServlet("/pesquisaController")
public class pesquisaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public pesquisaController() {

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mercadoria mercadoria = new Mercadoria();
		ArrayList<String> tipoMercadoria = mercadoria.getTiposMercadorias();
		HttpSession session= request.getSession();
		session.setAttribute("tipoMercadorias", tipoMercadoria);
		response.sendRedirect("pesquisa.jsp");
 		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("oi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		
	}

}
