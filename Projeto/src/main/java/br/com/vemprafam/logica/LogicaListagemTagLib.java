package br.com.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogicaListagemTagLib implements Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/jsp/Funcionarios1.jsp";
	}

}
