package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todas as permiss�o do sistema.
 * 
 * @author Rafael
 * @version 1.0.0
 * @since 31/07/2010
 */
@SuppressWarnings("javadoc")
public enum PermissaoEnum {
	
	ADMIN("Administrador", PrioridadeEnum.ALTA), DENEID(
			"Sem acesso", PrioridadeEnum.BAIXO), DEVELOPER(
			"Desenvolvedor", PrioridadeEnum.ALTA), EDITOR("Editor", PrioridadeEnum.MEDIA), GUEST("Invisivel", PrioridadeEnum.PADRAO), MANAGER("Gerenciador",
			PrioridadeEnum.MEDIA), USER("Usuário",
			PrioridadeEnum.PADRAO);
	
	private static final Map<String, PermissaoEnum> LOOK_UP = new HashMap<String, PermissaoEnum>();
	
	private String label;
	
	private PrioridadeEnum prioridade;
	
	static {
		for (PermissaoEnum permissao : PermissaoEnum.values()) {
			LOOK_UP.put(permissao.getLabel(), permissao);
		}
	}
	
	/**
	 * Construtor para <em>PermissaoEnum</em>
	 * 
	 * @param label
	 *            Nome da permiss�o.
	 * @param prioridade
	 *            Niv�l de importancia da permiss�o (0=Maior, 9=Menor)
	 * 
	 */
	private PermissaoEnum(String label, PrioridadeEnum prioridade) {
		this.label = label;
		this.prioridade = prioridade;
	}
	
	/**
	 * Retorna o enum.
	 * 
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static PermissaoEnum get(String label) {
		return LOOK_UP.get(label);
	}
	
	/**
	 * Retorna o valor do atributo label.
	 * 
	 * @return label String
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Retorna o valor do atributo prioridade.
	 * 
	 * @return prioridade PrioridadeEnum
	 */
	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}
	
}
