package br.com.battista.sigeco.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import br.com.battista.sigeco.exception.SigecoException;
import br.com.battista.sigeco.util.Util;

/**
 * Representa os atributos padrões que todas as entidades possui.
 * <ul>
 * <li>ID</li>
 * <li>VERSAO</li>
 * <li>DATA_CRIACAO</li>
 * <li>DATA_ALTERACAO</li>
 * </ul>
 *
 * @author Rafael
 * @since 18/07/2010
 * @version 1.0.0
 * @see BaseEntity
 */
@MappedSuperclass
public class BaseEntityImpl implements BaseEntity {

	private static final long serialVersionUID = 4893550776382617802L;

	@Version
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ALTERACAO", nullable = false)
	private Date dataAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CRIACAO", nullable = false)
	private Date dataCriacao = Calendar.getInstance().getTime();

	@Column(name = "UIID", nullable = false, unique = true)
	private Long uiId = Calendar.getInstance().getTimeInMillis();

	@Version
	@Column(name = "VERSAO", nullable = false)
	private Integer versao;

	/**
	 * Construtor para a classe BaseEntityImpl.
	 *
	 */
	public BaseEntityImpl() {
		super();
	}

	/**
	 * Construtor para a classe <strong>BaseEntityImpl</strong>
	 *
	 * @param map
	 *            {@link Map} contendo os valores dos atributos que ser�o
	 *            preenchidos automaticamente do {@link BaseEntity}.
	 * @throws SigecoException
	 */
	public BaseEntityImpl(Map<String, Object> map) throws SigecoException {
		super();
		Util.fillBeanFromMap(map, this);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int compareTo(BaseEntity obj) {
		if (obj == null) {
			return -1;
		}

		CompareToBuilder compareTo = new CompareToBuilder();
		compareTo.append(getUiId(), obj.getUiId());
		compareTo.append(getPk(), obj.getPk());

		return compareTo.toComparison();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BaseEntityImpl other = (BaseEntityImpl) obj;

		EqualsBuilder equals = new EqualsBuilder();
		equals.append(getUiId(), other.getUiId());
		equals.append(getPk(), other.getPk());

		return equals.isEquals();
	}

	@Override
	public void fillBeanFromMap(Map<String, Object> map) throws SigecoException {
		Util.fillBeanFromMap(map, this);
	}

	@Override
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	@Override
	public Date getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public Object getPk() {
		return getUiId();
	}

	@Override
	public Long getUiId() {
		return uiId;
	}

	@Override
	public Integer getVersao() {
		return versao;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCode = new HashCodeBuilder();
		hashCode.append(getUiId());
		hashCode.append(getPk());

		return hashCode.toHashCode();
	}

	@Override
	@Deprecated
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	@Deprecated
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	@Deprecated
	public void setUiId(Long uiId) {
		this.uiId = uiId;
	}

	@Override
	@Deprecated
	public void setVersao(Integer versao) {
		this.versao = versao;
	}

	@Override
	public Map<String, Object> toMap() {
		return Util.toMap(this);
	}

	@Override
	public String toString() {
		return Util.toString(this);
	}

	@Override
	public String toXml() {
		return Util.toXml(this);
	}
}
