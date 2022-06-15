/**
 * Classe que será a configuração do meu spring
 * @ author Walysson  Cruz
 * @ see  org.springframework.context.annotation.ComponentScan; / org.springframework.context.annotation.Configuration;org.springframework.web.servlet.config.annotation.EnableWebMvc;
 * @ since 1.0
 * @ Criada em 28/05 ás 18:51
 *
 */
package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //anotação informa ao spring que essa classe é uma anotação de configuração
@ComponentScan("br.com.devmedia.curso")//anotação que receberá aonde as ficam as classes que ele devem gerenciar
@EnableWebMvc
public class RootConfig {

}
