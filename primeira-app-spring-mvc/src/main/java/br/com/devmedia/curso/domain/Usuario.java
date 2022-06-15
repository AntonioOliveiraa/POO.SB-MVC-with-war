/**
 * Classe que armazenará os dados do meu usuario
 * @ author Antonio Oliveira
 * @ see java.time / javax.validation / org.hibernat / org.springframework
 * @ since 1.0
 * @ Criada em 13/06/2022 ás 19:15
 *
 */
package br.com.devmedia.curso.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("deprecation")
public class Usuario {

	private Long id;
	
	@NotBlank//anotação para validação(ex: sem espaços em branco)
	@Size(min = 3, max = 50)//anotação para validação de tamanho
	private String nome;
	
	@NotBlank//anotação para validação(ex: sem espaços em branco)
	@Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres.")	//anotação para validação de tamanho(com uma mensagem ao usuário)
	private String sobrenome;
	
	@NotNull(message = "O campo 'data de nascimento' é requerido.")//anotaação para validar a data(não pode ser null, e mensagem transmitida a usuário)
	@DateTimeFormat(iso = ISO.DATE)//anotação para converter a sting do formário em formato date do jav
	private LocalDate dtNascimento;//atributo para armazenar a string de data que vem do site
	
	private TipoSexo sexo;//tipo para armenzar um enum
	
	public Usuario() {
		super();
	}	
//contrutor padrão que será usado pelo spring
	public Usuario(Long id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}	
	
	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
	}
	
	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento, TipoSexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
	}

	//métodos acessores dos meus atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	//método para testar objetos(não obrigatório)
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}
}
