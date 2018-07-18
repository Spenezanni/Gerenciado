package br.com.caelum.gerenciado.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.gerenciado.Usuario;

public class UsuarioDAO {

	
	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("guilherme.silveira@alura.com.br", new Usuario("guilherme.silveira@alura.com.br","silveira"));
		USUARIOS.put("rodrigo.turini@alura.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
		USUARIOS.put("luiz.gustavo@alura.com.br", new Usuario("luiz.gustavo@alura.com.br", "gustavo"));
		USUARIOS.put("vanessa.morais@alura.com.br", new Usuario("vanessa.morais@alura.com.br", "morais"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}
}
	