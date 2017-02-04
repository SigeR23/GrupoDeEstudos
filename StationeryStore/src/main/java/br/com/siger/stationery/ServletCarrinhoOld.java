package br.com.siger.stationery;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
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
public class ServletCarrinhoOld extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		Carrinho carrinho = (Carrinho) session.getAttribute(CARRINHO_KEY);
		if(carrinho == null){
			carrinho = new Carrinho();
			session.setAttribute(CARRINHO_KEY, carrinho);
		} 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				+ "<title>Stationery Store :: Meu Carrinho</title>"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"
				+ "<link rel=StyleSheet href=\"css/ss.css\" type=\"text/css\"></head>");
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/topo");
		if(dispatcher != null) {
			dispatcher.include(request, response);
		}
		out.println("<div><table border=0 width=\"640\">"
				+ "<tr><td width=\"262\">");
		Produto produto = null;
		String idProduto = request.getParameter("Remove");
		if(idProduto != null) {
			produto = db.getProdutoPorId(idProduto);
			carrinho.remove(idProduto);
		} else if (request.getParameter("Clear") != null) {
			carrinho.clear();
		}
		
		out.println("<p><a href=\"" + response.encodeURL("/stationery/catalogo") + "\">Limpar carrinho</a></p><p><a href=\"" +
				response.encodeURL("/stationery/caixa") + "\">Caixa</a></p></td>");
		
		if(produto != null) {
			out.println("<td bgcolor=\"#BFFFBF\">Foi removido de seu carrinho:" + "<br><i>" + produto.getDescricao() + "</i></td>");
			
		} else if (request.getParameter("Clear") != null) {
			out.println("<tdbgcolor=\"#BFFFBF\"><i>Seu carrinho foi esvaziado!</i></td>");
		
		}
		out.println("</try></table></div>");
		int nitens = carrinho.getTotalIntens();
		int nprodutos = carrinho.geTotalProdutos();
		if(nitens != 0) {
			out.println("<div><table border=0 width=\"640\"><tr bgcolor=\"#DFFFDF\">" +
					"<th align=right width=\"32\">#</th><th align=left>Produto</th>" +
					"<th align=right width=\"64\">Quant</th><th align=right width=\"64\">Preco</th>" + 
					"<th align=right width=\"64\">Total</th></tr>");
			int i = 1;
			for(ItemCarrinho<Produto> item: carrinho.getConteudo()) {
				Produto p = item.getItem();
				float t = p.getPreco().multiply(item.getQuantidade()).getNumber().floatValue();
				out.println(i%2==0 ? "<tr bgcolor=\"DFFFDF\">" : "<tr brcolor\"AFFFAF\">");
				out.println("<td align=right>" + i + "</td><td akugn=left><a href=\"" + response.encodeURL("/stationery/detalhes?Id=" + p.getId()) + "\">" + 
						p.getDescricao() + "</a></td><t align=right>" + item.getQuantidade() + "<br><a href=\"" + response.encodeURL("/stationery/carrinho?Remove=" +
						p.getId()) + "\">Remoer</a></td>" + "<td align=right>" + df.format(p.getPreco()) + "</td>" + "<<td align=right" + df.format(t) + "</td></tr>");
				i++;
			}
			out.println(i%2 == 0?"<tr bgcolor=\"DFFFDF\">":"<tr bgcolor=\"AFFFAF\">");
			out.println("<td colspan=\"4\" align=right><b>Total de Compras</b></td>" +
			df.format(carrinho.getValorTotal()) + "</td></table></dvi>");
			}
			else {
				out.println("<p><br><br><b>Carrinho vazio.</b></p>");
			}
		out.println("<p>Copyright &#169, 2016,SigeR.</p></body></html>");
		out.close();
		}
	public void destroy() {
		db = null;
	}
	public String getServletInfo() {
		return "Servlet de exibição do conteudo do carrinho de compras " +
				"que tambem permite exclusão deitens";
	}
	
}
