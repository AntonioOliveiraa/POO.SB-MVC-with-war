/* Classe que será um controller para o usuário
 * @ author Walysson  Cruz
 * @ see javax / org.springframework
 * @ since 1.0
 * @ Criada em 30/05/2022 ás 20:19
 *
 */
package br.com.devmedia.curso.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;

@Controller
/*anotação para definir a classe como controller*/
@RequestMapping("usuario")//anotação que pegará o valor do usuario(string)
public class UsuarioController {

	@Autowired//retornar o objeto do usuario DAO
	private UsuarioDao dao;
	//acesso
	@RequestMapping(value = "/todos", method = RequestMethod.GET)//retorna os atributos da lista para página
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("usuarios", dao.getTodos());//lista adcionada a variavel de usuarios que será enviada para a página
		return new ModelAndView("/user/list", model);//diz qual página os dados dessa lista serão enviados
	}
	
	@GetMapping("/cadastro")//cadastro de usuaários
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		model.addAttribute("sexos", TipoSexo.values());
		return "/user/add";//quando acessar esse método(url cadastro). ele abre a página add
	}
	
	@PostMapping("/save")//salvar usuários
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {//@valid(anotaçaõ para validar o save)
		if (result.hasErrors()) {//se nos resultados ocorrer um erro
			return "/user/add";//ele retorna para a página add
		}
		dao.salvar(usuario);//salvar os dados que estão sendo informados
		attr.addFlashAttribute("message", "Usuário salvo com sucesso.");//mensagem informando
		return "redirect:/usuario/todos";//retorna a lista(redirect)
	}
	
	@GetMapping("/update/{id}")//id a ser localizado na lista para alterção do objeto
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {//captura a informação id, e adciona a um objeto(posição path)
		Usuario usuario = dao.getId(id);//pega o id do pre update  e passa para a variavel usuario
		model.addAttribute("usuario", usuario);//passa usuario pro model
		return new ModelAndView("/user/add", model);//retorna a lista add
	}
	
	@PostMapping("/update")//atualização de usuarios
	public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {//@valid(anotaçaõ para validar o update)
		if (result.hasErrors()) {//se nos resultados ocorrer um erro
			return new ModelAndView("/user/add");//ele retorna para a página add
		}
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usuário alterado com sucesso.");//mensagem confirmando o uptadte
		return new ModelAndView("redirect:/usuario/todos");//retorna a lista de usuarios
	}
	
	@GetMapping("/delete/{id}")//método para deletar
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {//localiza o id através do path
		dao.excluir(id);//apaga os valores correspondestes ao id recsitado
		attr.addFlashAttribute("message", "Usuário excluído com sucesso.");//mensagem confirmando a exlusão do usuarios
		return "redirect:/usuario/todos";//redirect para usuario todos
	}
}
