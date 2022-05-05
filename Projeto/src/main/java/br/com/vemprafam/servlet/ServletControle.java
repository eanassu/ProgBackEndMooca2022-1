package br.com.vemprafam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.logica.Logica;
import br.com.vemprafam.logica.LogicaExclusao;

/**
 * Servlet implementation class ServletControle
 */
@WebServlet("/controle")
public class ServletControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		Class classe;
		try {
			classe = Class.forName("br.com.vemprafam.logica.Logica"+op);
			Logica logica = (Logica) classe.getDeclaredConstructors()[0].newInstance();
			String destino = logica.executar(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(destino);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
