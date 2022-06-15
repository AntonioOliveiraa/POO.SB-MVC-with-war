/**
 * Classe CONTROLLER
 * @ author Walysson  Cruz
 * @ see org.springframework
 * @ since 1.0
 * @ Criada em 28/05/2022 ás 18:55
 *
 */
package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //anotação que dira� ao spring que essa classe é um controler
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		//return "welcome";
		return "redirect:/usuario/todos";//redirecionar o acesso para o controller usuario
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("teste", "Ola�, eu sou o spring MVC.");
		return view;
	}
}
