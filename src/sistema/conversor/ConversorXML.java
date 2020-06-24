package sistema.conversor;

import java.lang.reflect.Field;
import java.util.Collection;

import sistema.anotacao.NomeNoXml;

public class ConversorXML {

	private static final String TAG_LISTA = "<lista>";
	private static final String TAG_LISTA_FECHAMENTO = "</lista>";
	private static final String TAG_ABERTURA = "<";
	private static final String TAG_FECHAMENTO = ">";
	private static final String TAG_ABERTURA_FECHA_TAG = "</";

	public String converte(Object objeto) {
		try {
			Class<?> classeObjeto = objeto.getClass();
			StringBuffer xml = new StringBuffer();

			// CASO RECEBA UMA LISTA, A TAG DO XML MUDA
			if (objeto instanceof Collection) {
				trataListaDeObjetoParaXml(objeto, xml);
			} else {
				trataObjetoParaXml(objeto, classeObjeto, xml);
			}

			return xml.toString();

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na geração do XML!");

		}
	}

	private void trataObjetoParaXml(Object objeto, Class<?> classeObjeto, StringBuffer xml)
			throws IllegalAccessException {
		String nomeClasse = nomeDoAtributoPersonalizado(classeObjeto);
		xml.append(TAG_ABERTURA + nomeClasse + TAG_FECHAMENTO);

		for (Field atributo : classeObjeto.getDeclaredFields()) {
			atributo.setAccessible(true);

			String nomeAtributo = atributo.getName();

			Object valorAtributo = atributo.get(objeto);

			xml.append(TAG_ABERTURA + nomeAtributo + TAG_FECHAMENTO);
			xml.append(valorAtributo);
			xml.append(TAG_ABERTURA_FECHA_TAG + nomeAtributo + TAG_FECHAMENTO);
		}

		xml.append(TAG_ABERTURA_FECHA_TAG + nomeClasse + TAG_FECHAMENTO);
	}

	private String nomeDoAtributoPersonalizado(Class<?> classeObjeto) {
		NomeNoXml anotacao = classeObjeto.getDeclaredAnnotation(NomeNoXml.class);
		if (anotacao != null) {
			return !anotacao.value().isEmpty() ? anotacao.value() : classeObjeto.getName();
		}
		return classeObjeto.getName();
	}

	private void trataListaDeObjetoParaXml(Object objeto, StringBuffer xml) {
		Collection<?> listaDeObjeto = (Collection<?>) objeto;
		xml.append(TAG_LISTA);
		for (Object umObjeto : listaDeObjeto) {
			String xmlDeUmObjeto = converte(umObjeto);
			xml.append(xmlDeUmObjeto);
		}
		xml.append(TAG_LISTA_FECHAMENTO);
	}

}
