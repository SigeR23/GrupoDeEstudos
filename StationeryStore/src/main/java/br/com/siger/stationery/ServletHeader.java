package br.com.siger.stationery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHeader
 */
public class ServletHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[ServletHeader] HTTP GET");
		writeContent(response);
	}

	private void writeContent(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String html = "<body bgcolor=\"#FFFFFF\">" +
			"<div>" +
				"<table border=0 cellspacing=0 cellpadding=0>"+ 
					"<tr>" +
						"<td><img border=\"0\" src=\"imagens/main01.png\" width=\"131\"" +
							"height=\"131\"></td>" +
						"<td><img border=\"0\" src=\"imagens/main02.png\" width=\"131\"" +
							"height=\"131\"></td>" +
						"<td><img border=\"0\" src=\"imagens/main03.png\" width=\"131\"" +
							"height=\"131\"></td>" +
						"<td><h1>" +
								"<font color=\"#0000ff\" face=\"Arial\">Stationery</font><font" +
									"color=\"#000080\" face=\"Arial\">Store</font></td>" +
						"</h1>" +
						"<td><img border=\"0\" src=\"imagens/main04.png\" width=\"66\"" +
							"height=\"131\"></td>" +
					"</tr>" +
				"</table>" +
			"</div>";
		out.println(html);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[ServletHeader] HTTP POST");
		writeContent(response);
	}

}
