package br.com.siger.stationery;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javamoney.moneta.format.MonetaryAmountDecimalFormatBuilder;

import br.com.siger.stationery.converter.MonetaryAmountConverter;
import br.com.siger.stationery.db.JPAUtil;
import br.com.siger.stationery.model.Carrinho;
import br.com.siger.stationery.model.ItemCarrinho;
import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.repository.Produtos;

/**
 * Servlet implementation class ServletCarrinho
 */
public class ServletCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CARRINHO_KEY = "stationary.carrinho";

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
		EntityManager manager = JPAUtil.getEntityManager();
		Produtos repositorio = new Produtos(manager);

		/*
		 * Produto produto = null; String idProduto =
		 * request.getParameter("Remove"); if(idProduto != null) { produto =
		 * db.getProdutoPorId(idProduto); carrinho.remove(idProduto); } else if
		 * (request.getParameter("Clear") != null) { carrinho.clear(); }
		 * 
		 * out.println("<p><a href=\"" +
		 * response.encodeURL("/stationery/catalogo") +
		 * "\">Limpar carrinho</a></p><p><a href=\"" +
		 * response.encodeURL("/stationery/caixa") + "\">Caixa</a></p></td>");
		 * 
		 * if(produto != null) {
		 * out.println("<td bgcolor=\"#BFFFBF\">Foi removido de seu carrinho:" +
		 * "<br><i>" + produto.getDescricao() + "</i></td>");
		 * 
		 * } else if (request.getParameter("Clear") != null) { out.
		 * println("<tdbgcolor=\"#BFFFBF\"><i>Seu carrinho foi esvaziado!</i></td>"
		 * );
		 * 
		 * }
		 */
		Produto produto = null;
		String msg = null;
		String idProduto = request.getParameter("remove");
		String clearCarrinho = request.getParameter("clear");
		
		//lista
		int totalItens = carrinho.getTotalIntens();
		List<Produto> listaProdutos = new ArrayList<>();
		MonetaryAmount total = new MonetaryAmountConverter().convertToEntityAttribute(new BigDecimal(0));
		
		if (totalItens != 0) {
			for (ItemCarrinho<Produto> item : carrinho.getConteudo()) {
				listaProdutos.add(item.getItem());
				total = total.add(item.getItem().getPreco());
			}
		} else {
			// out.println("<p><br><br><b>Carrinho vazio.</b></p>");
		}
		//remove
		if(idProduto != null) {
			produto = repositorio.porId(Long.parseLong(idProduto));
			listaProdutos.remove(produto);
			carrinho.remove(produto);
			total = total.subtract(produto.getPreco());
			msg = "produto removido com sucesso";
		}
		//clear
		if(clearCarrinho != null) {
			carrinho.clear();
			listaProdutos.clear();
			total = total.multiply(0);
			msg = "Todos os itens foram removidos do carrinho ";
			
		}
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/WEB-INF/templates/carrinho.jsp");
		request.setAttribute("Produtos", listaProdutos);
		request.setAttribute("total", total);
		request.setAttribute("msg", msg);
		dispatcher.forward(request, response);
	}

	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " + "que tambem permite exclusão deitens";
	}

}
