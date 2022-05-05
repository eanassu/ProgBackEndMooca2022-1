package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vemprafam.dao.DaoFuncionario;

public class LogicaExclusao implements Logica {

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int re = Integer.parseInt(request.getParameter("re"));
		DaoFuncionario dao = new DaoFuncionario();
		dao.excluirFuncionario(re);
		return "/Funcionarios1.jsp";
	}
	
}
