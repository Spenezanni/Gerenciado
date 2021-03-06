package br.com.caelum.gerenciado.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciado.Empresa;
import br.com.caelum.gerenciado.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		writer.println("<html><body>");
		writer.println("Resultado da Busca:<br/>");
		String filtro = req.getParameter("filtro");

		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ":" + empresa.getNome() + "</li>");
		}

		writer.println("<html><body>");

	}

}
