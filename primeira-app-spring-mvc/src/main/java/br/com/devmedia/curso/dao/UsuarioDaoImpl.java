/**
 * Classe que armazenará os dados dos Usuarios em tempo de execução através de uma lista estática
 * @ author Walysson  Cruz
 * @ see java.util / java.time / org.springframework
 * @ since 1.0
 * @ Criada em 28/05/2022 ás 20:13
 *
 */
package br.com.devmedia.curso.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.devmedia.curso.domain.Usuario;

@Repository//um bin(anotação quer ira fazer a classe ser gerenciada pelo spring)
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> us;
	
	public UsuarioDaoImpl() {
		createUserList();
	}
	
    private List<Usuario> createUserList() {//lista que irá armazenar os usários em tempo de execução(irá começar com 6 usuarios cadastrados)
		//se a lista estiver vazia então ele cadastrará o seguintes usuários
        if (us == null) {
            us = new LinkedList<>();
        }
        return us;
    }

	@Override
	public void salvar(Usuario usuario) {//método para salvar(recebe o usuario como parâmetro e seta um iD=data no momento da execução)
		usuario.setId(System.currentTimeMillis());//retorna a data em formato de um long para usar como id
		us.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {//metodo para editar
		//usando um filter que irá localizar dentro da minha lista, qual o usuario que tem o id igual ao usuario que esta sendo enviado como parâmetro nesse método
		us.stream()
			.filter((u) -> u.getId().equals(usuario.getId()))
			.forEach((u) -> {//localizar usuario filtado e add as novas informações
				u.setNome(usuario.getNome());
				u.setSobrenome(usuario.getSobrenome());
				u.setDtNascimento(usuario.getDtNascimento());
				u.setSexo(usuario.getSexo());
			});		
	}

	@Override
	public void excluir(Long id) {
		us.removeIf((u) -> u.getId().equals(id));		
	}//método para excluir
	//recebe o id como parâmetro  e remove através do método removeIf(através de uma expressão lambida, para que ele localize dentro da lista o usuário para remover

	@Override
	public Usuario getId(Long id) {//recebe um parâmetro do tipo id
		//localiza e coleta esse usuário(retorna)
		return us.stream()
				.filter((u) -> u.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		return us;
	}	//método que irá retornar a lista completa
}
