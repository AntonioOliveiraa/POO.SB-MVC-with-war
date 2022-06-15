package br.com.devmedia.curso.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.devmedia.curso.web.conversor.TipoSexoConverter;

@SuppressWarnings("deprecation")
@Configuration //classe de configuracao
public class SpringMvcConfig extends WebMvcConfigurerAdapter {//

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/bootstrap/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {//classe para dizer ao spring como ele irá resolver as páginas
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();//instância(objeto)
		resolver.setPrefix("/WEB-INF/views/");//prefixo onde o spring irá procurar as nossas páginas
		resolver.setSuffix(".jsp");//tipo de arquivo que iremos utilizar como página
		resolver.setViewClass(JstlView.class);//tipo de recurso que minhas páginas serão utilizadas(JSTL)
		return resolver;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new TipoSexoConverter());
	}//quando spring encontrar um formato tipo sexo, ele fará a conversão(sem isso ele não faz)
	
	@Bean//anotação para gerenciar um método SPRING
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}
}
