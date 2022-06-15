/**
 * Interface para a Classe usuarioDAO
 * @ author Walysson  Cruz
 * @ see java.util
 * @ since 1.0
 * @ Criada em 28/05/2022 ás 19: 50
 *
 */
package br.com.devmedia.curso.dao;

import java.util.List;

import br.com.devmedia.curso.domain.Usuario;

public interface UsuarioDao {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario getId(Long id);
	
	List<Usuario> getTodos(); 
}
