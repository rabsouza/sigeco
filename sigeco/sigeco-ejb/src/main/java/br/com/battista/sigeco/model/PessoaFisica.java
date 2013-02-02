package br.com.battista.sigeco.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>PESSOA_FISICA</CODE>.
 * <ul>
 * <li>CPF</li>
 * <li>DATA_NASCIMENTO</li>
 * <li>NOME_PAI</li>
 * <li>NOME_MAE</li>
 * <li>SEXO</li>
 * <li>ESTADO_CIVIL</li>
 * </ul>
 *
 * @author Rafael
 * @version 1.0.0
 * @since 18/07/2010
 * @see Pessoa
 */
@Entity
@XmlRootElement
@DiscriminatorColumn(name = "TIPO")
@DiscriminatorValue(value = "FIS")
@Table(name = "PESSOA_FISICA")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = -6159044912671290432L;

	@NotBlank
	@Size(min = 13, max = 13)
	@Column(name = "CPF", length = 13, nullable = false, unique = true)
	@Pattern(regexp = "\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d", message = "Deve está no formato: 999.999.999-99")
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;

	@Size(min = 1, max = 100)
	@Column(name = "NOME_PAI", length = 100, nullable = true)
	private String nomePai;

	@Size(min = 1, max = 100)
	@Column(name = "NOME_MAE", length = 100, nullable = true)
	private String nomeMae;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "SEXO", length = 10, nullable = true)
	private SexoEnum sexo;

	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_CIVIL", length = 10, nullable = true)
	private EstadoCivilEnum estadoCivil;

	/**
	 * Construtor para a classe PessoaFisica.
	 *
	 */
	public PessoaFisica() {
		super();
	}

	/**
	 * Construtor para a classe PessoaFisica.
	 *
	 * @param map
	 * @throws SigecoException
	 */
	public PessoaFisica(Map<String, Object> map) throws SigecoException {
		super(map);
	}

	/**
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            String
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 *            Date
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai
	 *            String
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae
	 *            String
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return sexo
	 */
	public SexoEnum getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            SexoEnum
	 */
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return estadoCivil
	 */
	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil
	 *            EstadoCivilEnum
	 */
	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
