package br.com.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

/**
 * Servlet implementation class ServletFuncionarios
 */
@WebServlet("/funcionarios")
public class ServletFuncionarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFuncionarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		DaoFuncionario dao = new DaoFuncionario();
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Funcionários</title>\r\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<table border='1'>\n"
				+ "<tr>\n");
		out.print("<th>RE</th><th>nome</th><th>salario</th><th>data de nascimento</th></tr>");
		List<Funcionario> funcionarios = dao.getFuncionarios();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		for( Funcionario f: funcionarios ) {
			out.println("<tr><td>"+f.getRe()+
					    "</td><td>"+f.getNome()+
					    "</td><td>"+ currencyFormat.format(f.getSalario())+
					    "</td><td>"+ dateFormat.format(f.getDataNascimento())+"</td></tr>"
					    );
		}
		out.print("</table>\r\n"
				+ "<a href=\"/Projeto\">voltar</a>"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
