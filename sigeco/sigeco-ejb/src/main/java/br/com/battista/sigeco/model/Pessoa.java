package br.com.battista.sigeco.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>PESSOA</CODE>.
 * <ul>
 * <li>ID</li>
 * <li>NOME</li>
 * <li>TIPO</li>
 * <li>INFORMACOES</li>
 * <li>FK_USUARIO</li>
 * </ul>
 * 
 * @author Rafael
 * @version 1.0.0
 * @since 24/07/2010
 * @see BaseEntityImpl
 * @see BaseEntity
 */
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Pessoa extends BaseEntityImpl implements BaseEntity {
	
	private static final long serialVersionUID = -4068770933570959860L;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Contato> contatos;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Endereco> enderecos;
	
	@Id
	@SequenceGenerator(name = "SEQUENCE_PESSOA_ID", sequenceName = "SEQUENCE_PESSOA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PESSOA_ID")
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Size(min = 1, max = 250)
	@Column(name = "INFORMACAO", length = 250, nullable = true)
	private String informacao;
	
	@NotBlank
	@Size(min = 1, max = 150)
	@Column(name = "NOME", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "TIPO", length = 3, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPessoaEnum tipo;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_USUARIO", nullable = false)
	private Usuario usuario;
	
	/**
	 * Construtor para a classe Pessoa.
	 * 
	 */
	public Pessoa() {
		super();
	}
	
	/**
	 * Construtor para a classe Pessoa.
	 * 
	 * @param map
	 * @throws SigecoException
	 */
	public Pessoa(Map<String, Object> map) throws SigecoException {
		super(map);
	}
	
	/**
	 * @return contatos
	 */
	public List<Contato> getContatos() {
		return contatos;
	}
	
	/**
	 * @return enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return informacao
	 */
	public String getInformacao() {
		return informacao;
	}
	
	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	@Override
	public Object getPk() {
		return getId();
	}
	
	/**
	 * @return tipo
	 */
	public TipoPessoaEnum getTipo() {
		return tipo;
	}
	
	/**
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * @param contatos
	 *            List<Contato>
	 */
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	/**
	 * @param enderecos
	 *            List<Endereco>
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	/**
	 * @param id
	 *            Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @param informacao
	 *            String
	 */
	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	
	/**
	 * @param nome
	 *            String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @param tipo
	 *            TipoPessoaEnum
	 */
	public void setTipo(TipoPessoaEnum tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * @param usuario
	 *            Usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
