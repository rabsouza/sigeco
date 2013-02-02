package br.com.battista.sigeco.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>USUARIO</CODE>.
 * <ul>
 * <li>NOME</li>
 * <li>SENHA</li>
 * <li>IDIOMA</li>
 * <li>DATA_ATIVACAO</li>
 * <li>ULTIMO_ACESSO</li>
 * <li>STATUS</li>
 * <li>FK_PESSOA</li>
 * <li>FK_PERFIL</li>
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
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
public class Usuario extends BaseEntityImpl implements BaseEntity {

	private static final long serialVersionUID = 8284457724131974226L;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ATIVACAO", nullable = true)
	private Date dataAtivacao;

	@NotNull
	@NotBlank
	@Email(message = "E-mail invalido!")
	@Column(name = "EMAIL", nullable = false, unique = true, length = 150)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "IDIOMA", length = 5, nullable = true)
	private IdiomaEnum idioma;

	@Id
	@Column(name = "NOME", length = 25, unique = true, nullable = false)
	@NotNull
	@NotBlank
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z0-9]*", message = "Nome invalido. Tamanho[min=1, max=25]. Caracteres[A-Za-z0-9]")
	private String nome;

	@NotNull
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PERFIL", nullable = false)
	private Perfil perfil;

	@Transient
	@OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Pessoa pessoa;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z0-9_\\-]*", message = "Senha invalida. Tamanho[min=1, max=25]. Caracteres[A-Za-z0-9_\\-]")
	@Column(name = "SENHA", length = 25, nullable = false)
	private String senha;

	@NotNull
	@Column(name = "STATUS", nullable = false)
	private Boolean status = Boolean.FALSE;

	@Temporal(TemporalType.DATE)
	@Column(name = "ULTIMO_ACESSO", nullable = true)
	private Date ultimoAcesso;

	/**
	 * Construtor para a classe Usuario.
	 *
	 */
	public Usuario() {
		super();
	}

	/**
	 * Construtor para a classe Usuario.
	 *
	 * @param map
	 * @throws SigecoException
	 */
	public Usuario(Map<String, Object> map) throws SigecoException {
		super(map);
	}

	/**
	 * @return dataAtivacao
	 */
	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return idioma
	 */
	public IdiomaEnum getIdioma() {
		return idioma;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @return pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	@Override
	public Object getPk() {
		return getNome();
	}

	/**
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @return ultimoAcesso
	 */
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	/**
	 * Verifica se o usuário está ativo!
	 *
	 * @return true usuário ativo.
	 */
	public boolean isAtivo() {
		return getStatus();
	}

	/**
	 * @param dataAtivacao
	 *            Date
	 */
	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	/**
	 * @param email
	 *            String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param idioma
	 *            String
	 */
	public void setIdioma(IdiomaEnum idioma) {
		this.idioma = idioma;
	}

	/**
	 * @param nome
	 *            String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param perfil
	 *            Perfil
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/**
	 * @param pessoa
	 *            Pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @param senha
	 *            String
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @param status
	 *            Boolean
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @param ultimoAcesso
	 *            Date
	 */
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

}
