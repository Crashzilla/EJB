package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.interfaces.Galera;

@WebServlet("/index")
public class ServletGalera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	Galera galerinha;
	public ServletGalera() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<ul>");
		
		for (String str : galerinha.buscarNomes()) {
			out.println("<li> " + str + "</li>");
		}
		
		out.println("</ul>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			String nome = request.getParameter("nome");
			galerinha.incluirNome(nome);
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
