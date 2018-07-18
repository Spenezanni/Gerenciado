package br.com.caelum.gerenciado.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciado.Empresa;
import br.com.caelum.gerenciado.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/NovaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);

		new EmpresaDAO().adiciona(empresa);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa adicionada com Sucesso: " + empresa.getNome() + "</body></html>");
	}

}
