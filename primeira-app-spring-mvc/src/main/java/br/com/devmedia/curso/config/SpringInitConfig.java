/**
 * Classe que será lida pelo servidor(no inicio da execução da minha aplicação)
 * @ author Walysson  Cruz
 * @ see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
 * @ since 1.0
 * @ Criada em 28/05 ás 18:50
 *
 */

package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {//Classe raiz: Diz para o spring que quando o servidor iniciar, ele(servidor) irá subir a aplicação, e essa classe vai ser a...
		// primeira config da aplicação


		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//metodo que ira tratar as classes que contêm o servlet

		return new Class[] {SpringMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {//clase que mapeará os servlet(sempre que a aplicação encontrar na url uma /, ela saberá que é um servlet

		return new String[] {"/"};
	}

}
