package br.com.siger.stationery;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.siger.stationery.db.Database;
import br.com.siger.stationery.model.Carrinho;
import br.com.siger.stationery.model.ItemCarrinho;
import br.com.siger.stationery.model.Produto;

/**
 * Servlet implementation class ServletCarrinho
 */
public class ServletCarrinho2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DecimalFormat df = new DecimalFormat("0.00");
	private Database db;
	private static final String DB_KEY = "stationary.db";
	private static final String CARRINHO_KEY = "stationary.carrinho";
	public void init() throws ServletException {
		db = (Database) getServletContext().getAttribute(DB_KEY);
		if(db == null) {
			db = Database.getInstance();
			getServletContext().setAttribute(DB_KEY, db);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/carrinho.jsp");
		String[] filmes = {
			"It",  "Harry Potter: E as reliquias da morte parte 2", "Harry Potter: E as reliquias da morte parte 1" 
		};
		request.setAttribute("Movies", filmes);
		dispatcher.forward(request, response);
		
	}
	public void destroy() {
		db = null;
	}
	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " +
				"que tambem permite exclusão deitens";
	}
	
}
