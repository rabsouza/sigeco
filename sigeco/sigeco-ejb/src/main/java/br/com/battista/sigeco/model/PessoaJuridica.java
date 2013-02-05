package br.com.battista.sigeco.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Representa as informações da entidade <code>PESSOA_JURIDICA</CODE>.
 * <ul>
 * <li>CNPJ</li>
 * <li>NOME_FANTASIA</li>
 * <li>INSCRICAO_ESTADUAL</li>
 * <li>DATA_FUNDACAO</li>
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
@DiscriminatorValue(value = "JUR")
@Table(name = "PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {
	
	private static final long serialVersionUID = 1714794870349832721L;
	
	@NotBlank
	@Size(min = 1, max = 20)
	@Column(name = "CNPJ", length = 20, nullable = false, unique = true)
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FUNDACAO", nullable = true)
	private Date dataFundacao;
	
	@Size(min = 0, max = 30)
	@Column(name = "INSCRICAO_ESTADUAL", length = 30, nullable = true)
	private String inscricaoEstadual;
	
	@Size(min = 0, max = 150)
	@Column(name = "NOME_FANTASIA", length = 150, nullable = true)
	private String nomeFantasia;
	
	/**
	 * Construtor para a classe PessoaJuridica.
	 * 
	 */
	public PessoaJuridica() {
		super();
	}
	
	/**
	 * Construtor para a classe PessoaJuridica.
	 * 
	 * @param map
	 * @throws SigecoException
	 */
	public PessoaJuridica(Map<String, Object> map) throws SigecoException {
		super(map);
	}
	
	/**
	 * @return cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	
	/**
	 * @return dataFundacao
	 */
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	/**
	 * @return inscricaoEstadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	/**
	 * @return nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	/**
	 * @param cnpj
	 *            String
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	/**
	 * @param dataFundacao
	 *            Date
	 */
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	/**
	 * @param inscricaoEstadual
	 *            String
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	/**
	 * @param nomeFantasia
	 *            String
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
