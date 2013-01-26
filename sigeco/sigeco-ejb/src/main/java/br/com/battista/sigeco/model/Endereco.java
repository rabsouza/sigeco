package br.com.battista.sigeco.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>ENDERECO</CODE>.
 * <ul>
 * <li>ID</li>
 * <li>TIPO_LOGRADOURO</li>
 * <li>LOGRADOURO</li>
 * <li>NUMERO</li>
 * <li>COMPLEMENTO</li>
 * <li>BAIRRO</li>
 * <li>CIDADE</li>
 * <li>UF</li>
 * <li>PAIS</li>
 * <li>CEP</li>
 * <li>DESCRICAO</li>
 * <li>FK_PESSOA</li>
 * <li>STATUS</li>
 * <li>PADRAO</li>
 * <li>TIPO_ENDERECO</li>
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
@Table(name = "ENDERECO")
public class Endereco extends BaseEntityImpl implements BaseEntity {

	private static final long serialVersionUID = -2585234399241265137L;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "BAIRRO", length = 50, nullable = false)
	private String bairro;

	@Column(name = "CEP", length = 14, nullable = false)
	@NotNull
	@Size(min = 1, max = 14)
	@Pattern(regexp = "\\d\\d.\\d\\d\\d-\\d\\d\\d", message = "Deve está no formato 99.999-999")
	private String cep;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "CIDADE", length = 50, nullable = false)
	private String cidade;

	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "COMPLEMENTO", length = 20, nullable = true)
	private String complemento;

	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "DESCRICAO", length = 150, nullable = true)
	private String descricao;

	@Id
	@SequenceGenerator(name = "SEQUENCE_ENDERECO_ID", sequenceName = "SEQUENCE_ENDERECO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ENDERECO_ID")
	@Column(name = "ID", nullable = false)
	@NotNull
	private Integer id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "LOGRADOURO", length = 100, nullable = false)
	private String logradoudo;

	@Column(name = "NUMERO", nullable = false)
	private Integer numero;

	@NotNull
	@Column(name = "PADRAO", nullable = false)
	private Boolean padrao;

	@Column(name = "PAIS", length = 50, nullable = false)
	@NotNull
	@Size(min = 1, max = 50)
	private String pais = "BRASIL";

	@Transient
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "FK_PESSOA", nullable = false)
	private Pessoa pessoa;

	@NotNull
	@Column(name = "STATUS", nullable = false)
	private Boolean status = Boolean.FALSE;

	@Column(name = "TIPO_ENDERECO", length = 30, nullable = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[A-Z-]*", message = "Pode ser digitado letras e o silbolo '-' e tamanho máximo de 30 caracteres.")
	private String tipoEndereco;

	@Column(name = "TIPO_LOGRADOURO", length = 3, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLogradouroEnum tipoLogradouro;

	@Column(name = "UF", length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private UFEnum uf;

	/**
	 * Construtor para a classe Endereco.
	 *
	 */
	public Endereco() {
		super();
	}

	/**
	 * Construtor para a classe Endereco.
	 *
	 * @param map
	 * @throws SigecoException
	 */
	public Endereco(Map<String, Object> map) throws SigecoException {
		super(map);
	}

	/**
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return complemento
	 */
	public String getComplemento() {
		return complemento;
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
	 * @return logradoudo
	 */
	public String getLogradoudo() {
		return logradoudo;
	}

	/**
	 * @return numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @return padrao
	 */
	public Boolean getPadrao() {
		return padrao;
	}

	/**
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @return pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
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
	 * @return tipoEndereco
	 */
	public String getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * @return tipoLogradouro
	 */
	public TipoLogradouroEnum getTipoLogradouro() {
		return tipoLogradouro;
	}

	/**
	 * @return uf
	 */
	public UFEnum getUf() {
		return uf;
	}

	/**
	 * @param bairro String
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @param cep String
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade String
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param complemento String
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @param descricao String
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param id Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param logradoudo String
	 */
	public void setLogradoudo(String logradoudo) {
		this.logradoudo = logradoudo;
	}

	/**
	 * @param numero Integer
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @param padrao Boolean
	 */
	public void setPadrao(Boolean padrao) {
		this.padrao = padrao;
	}

	/**
	 * @param pais String
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @param pessoa Pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @param status Boolean
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @param tipoEndereco String
	 */
	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	/**
	 * @param tipoLogradouro TipoLogradouroEnum
	 */
	public void setTipoLogradouro(TipoLogradouroEnum tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	/**
	 * @param uf UFEnum
	 */
	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

}
