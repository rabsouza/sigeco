package br.com.battista.sigeco.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>PERFIL</CODE>.
 * <ul>
 * <li>NOME</li>
 * <li>STATUS</li>
 * <li>PERMISSAO</li>
 * <li>PRIORIDADE</li>
 * <li>DESCRICAO</li>
 * </ul>
 *
 * @author Rafael
 * @version 1.0.0
 * @since 18/07/2010
 * @see BaseEntityImpl
 * @see BaseEntity
 */
@Entity
@XmlRootElement
@Table(name = "PERFIL")
public class Perfil extends BaseEntityImpl implements BaseEntity {

	private static final long serialVersionUID = -8873279548667015197L;

	@NotNull
	@Size(min = 1, max = 350)
	@Column(name = "DESCRICAO", length = 350, nullable = true)
	private String descricao;

	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private List<Usuario> listUsuarios;

	@Id
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "NOME", length = 150, nullable = false, unique = true)
	@Pattern(regexp = "[A-Z-]*", message = "Pode ser digitado letras e o silbolo '-' e tamanho máximo de 30 caracteres.")
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "PERMISSAO", nullable = false)
	private PermissaoEnum permissao;

	@Enumerated(EnumType.STRING)
	@Column(name = "PRIORIDADE", nullable = true)
	private PrioridadeEnum prioridade;

	@NotNull
	@Column(name = "STATUS", nullable = false)
	private Boolean status = Boolean.FALSE;

	/**
	 * Construtor para a classe Perfil.
	 *
	 */
	public Perfil() {
		super();
	}

	/**
	 * Construtor para a classe Perfil.
	 *
	 * @param map
	 * @throws SigecoException
	 */
	public Perfil(Map<String, Object> map) throws SigecoException {
		super(map);
	}

	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return listUsuarios
	 */
	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return permissao
	 */
	public PermissaoEnum getPermissao() {
		return permissao;
	}

	@Override
	public Object getPk() {
		return getNome();
	}

	/**
	 * @return prioridade
	 */
	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	/**
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param descricao String
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param listUsuarios List<Usuario>
	 */
	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	/**
	 * @param nome String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param permissao PermissaoEnum
	 */
	public void setPermissao(PermissaoEnum permissao) {
		this.permissao = permissao;
	}

	/**
	 * @param prioridade PrioridadeEnum
	 */
	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * @param status Boolean
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

}

