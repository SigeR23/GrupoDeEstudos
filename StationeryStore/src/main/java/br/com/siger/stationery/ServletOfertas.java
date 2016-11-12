package br.com.siger.stationery;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.siger.stationery.db.Database;
import br.com.siger.stationery.model.Carrinho;
import br.com.siger.stationery.model.Produto;

/**
 * Servlet implementation class ServletCarrinho
 */
public class ServletOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DecimalFormat df = new DecimalFormat("0.00");
	private Database db;
	private static final String DB_KEY = "stationary.db";
	private static final String CARRINHO_KEY = "stationary.carrinho";

	public void init() throws ServletException {
		db = (Database) getServletContext().getAttribute(DB_KEY);
		if (db == null) {
			db = Database.getInstance();
			getServletContext().setAttribute(DB_KEY, db);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Carrinho carrinho = (Carrinho) session.getAttribute(CARRINHO_KEY);
		if (carrinho == null) {
			carrinho = new Carrinho();
			session.setAttribute(CARRINHO_KEY, carrinho);
		}
		List<Produto> produtos = db.getProdutos(0);
		
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/ofertas.jsp");
		request.setAttribute("Produtos", produtos);
		dispatcher.forward(request, response);
		
		
	}

	public void destroy() {
		db = null;
	}

	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " + "que tambem permite exclusão deitens";
	}

}
