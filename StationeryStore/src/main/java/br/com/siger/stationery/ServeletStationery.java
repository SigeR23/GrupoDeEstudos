package br.com.siger.stationery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServeletStationery
 */
public class ServeletStationery extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/index.html");
		if (dispatcher == null) {
			System.out.println("[StationeryServlet] dispatcher == null");
			response.sendError(response.SC_NO_CONTENT);
		} else {
			System.out.println("[StationeryServlet] dispatcher ok");
			HttpSession session = request.getSession();
			dispatcher.forward(request, response);
		}
	}
	@Override
	public String getServletInfo() {
		return "Servlet que direciona cliente para página de abertura da loja.";
	}

}
