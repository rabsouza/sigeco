package br.com.battista.sigeco.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>PARAMETRO</CODE>.
 * <ul>
 * <li>ID</li>
 * <li>NOME</li>
 * <li>TIPO</li>
 * <li>DESCRICAO</li>
 * <li>STATUS</li>
 * <li>VALOR</li>
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
@Table(name = "PARAMETRO")
public class Parametro extends BaseEntityImpl implements BaseEntity {

	private static final long serialVersionUID = -8780106130038023803L;

	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "DESCRICAO", length = 150, nullable = true)
	private String descricao;

	@Id
	@SequenceGenerator(name = "SEQUENCE_PARAMETRO_ID", sequenceName = "SEQUENCE_PARAMETRO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PARAMETRO_ID")
	@Column(name = "ID", nullable = false)
	@NotNull
	private Integer id;

	@Column(name = "NOME", length = 35, unique = true, nullable = false)
	@NotNull
	@Size(min = 1, max = 35)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "Pode ser digitado letras, números e espaços somente e tamanho máximo de 25 caracteres.")
	private String nome;

	@NotNull
	@Column(name = "STATUS", nullable = false)
	private Boolean status = Boolean.FALSE;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "TIPO", length = 10, nullable = true)
	private TipoParametroEnum tipo;

	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "VALOR", length = 150, nullable = true)
	private String valor;

	/**
	 * Construtor para a classe Parametro.
	 *
	 */
	public Parametro() {
		super();
	}

	/**
	 * Construtor para a classe Parametro.
	 *
	 * @param map
	 * @throws SigecoException
	 */
	public Parametro(Map<String, Object> map) throws SigecoException {
		super(map);
	}

	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
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
	 * @return status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @return tipo
	 */
	public TipoParametroEnum getTipo() {
		return tipo;
	}

	/**
	 * @return valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param descricao
	 *            String
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param id
	 *            Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param nome
	 *            String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param status
	 *            Boolean
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @param tipo
	 *            TipoParametroEnum
	 */
	public void setTipo(TipoParametroEnum tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param valor
	 *            String
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
