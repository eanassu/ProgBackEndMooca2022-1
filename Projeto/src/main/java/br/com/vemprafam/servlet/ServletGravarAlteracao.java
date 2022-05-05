package br.com.vemprafam.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletGravarAlteracao
 */
@WebServlet("/alterarFuncionario")
public class ServletGravarAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGravarAlteracao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int re = Integer.parseInt(request.getParameter("re"));
		String nome = request.getParameter("nome");
		double salario = Double.parseDouble (request.getParameter("salario"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = new Date();
		try {
			dataNascimento = format.parse(request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		Funcionario funcionario = new Funcionario(re,nome,salario,dataNascimento,email);
		DaoFuncionario dao = new DaoFuncionario();
		dao.alterarFuncionario(funcionario);
		RequestDispatcher rd = request.getRequestDispatcher("/Funcionarios1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
