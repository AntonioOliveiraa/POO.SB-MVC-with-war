/**
 * Classe que fará a conversão dos dados de String para TipoSexo
 * @ author Walysson  Cruz
 * @ see java.time / javax.validation / org.hibernat / org.springframework
 * @ since 1.0
 * @ Criada em 28/05/2022 ás 19:15
 *
 */
package br.com.devmedia.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;
import br.com.devmedia.curso.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String, TipoSexo> {//implemetnação da interface do java, que irá converter os meus dados de String para TipoSexo

	@Override
	public TipoSexo convert(String texto) {
		char tipo = texto.charAt(0);
		return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;//retorna(converte) para masculino ou feminino
	}

}
