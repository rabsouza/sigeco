package br.com.battista.sigeco.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import br.com.battista.sigeco.exception.SigecoException;
import br.com.battista.sigeco.model.BaseEntity;
import br.com.battista.sigeco.model.BaseEntityImpl;
import br.com.battista.sigeco.utils.Constant;
import br.com.battista.sigeco.utils.LoggerUtil;
import br.com.battista.sigeco.utils.PackageLog;

/**
 * <strong>Util</strong> possui a função de criar as funções que serão uteis em
 * todos os projetos.
 * 
 * @author rafael.batista
 * @version 1.0
 * @since 28/12/2010
 */
public class Util {
	
	private static final Logger LOGGER = LoggerUtil.getLogger(Util.class,
			PackageLog.UTIL);
	
	private static XMLOutputter out = new XMLOutputter();
	
	/**
	 * Método<strong>fillBeanFromMap(mapValue, obj)</strong> possui a função de
	 * preencher os atributos de um <em>{@link BaseEntity}</em> a partir de um <em>{@link Map}</em>.
	 * 
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param mapValue
	 *            {@link Map} contendo os valores dos atributos que serão
	 *            preenchidos automaticamente do {@link BaseEntity}.
	 * @param obj
	 *            {@link BaseEntity} que será preenchido pelo {@link Map}.
	 * @throws SigecoException
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void fillBeanFromMap(Map<String, Object> mapValue,
			BaseEntity obj) throws SigecoException {
		
		if ((mapValue == null) || (obj == null)) {
			throw new SigecoException(
					"Os paramêtros mapValue e/ou obj não pode ser nulos!");
		}
		LOGGER.info("Preenchendo o obj=" + obj.getClass().getSimpleName()
				+ " através do map=" + String.valueOf(mapValue));
		
		Class<? extends BaseEntity> objClass = obj.getClass();
		
		while (true) {
			
			Method[] listMethods = objClass.getDeclaredMethods();
			for (Method method : listMethods) {
				if (method.getName()
						.startsWith(Constant.PREFIX_NAME_SET_METHOD)) {
					String nameAttr = method.getName().substring(3);
					String inicialName = String.valueOf(nameAttr.charAt(0))
							.toLowerCase();
					nameAttr = inicialName + nameAttr.substring(1);
					
					try {
						if (mapValue.containsKey(nameAttr)) {
							method.invoke(obj, mapValue.get(nameAttr));
						} else {
							method.invoke(obj);
						}
					} catch (Exception e) {
					}
				}
			}
			objClass = (Class<? extends BaseEntity>) objClass.getSuperclass();
			if (objClass.isInstance(new BaseEntityImpl())
					|| objClass.isInstance(new Object())) {
				break;
			}
		}
		
		obj.setUiId((Long) mapValue.get(Constant.ID_NODE_XML));
		obj.setVersao((Integer) mapValue.get(Constant.VERSAO_NODE_XML));
		
	}
	
	/**
	 * Método<strong>getElementContent(obj)</strong> possui a função de retorna
	 * o nodo xml para um <em>{@link BaseEntity}</em>
	 * 
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param obj
	 *            {@link BaseEntity} que será convertido no formato XML.
	 * @return <strong>element</strong> {@link Element} que representa um nodo
	 *         XML.
	 */
	@SuppressWarnings("unchecked")
	private static Element getElementContent(BaseEntity obj) {
		
		if (obj == null) {
			return null;
		}
		
		Class<? extends BaseEntity> objClass = obj.getClass();
		
		Element classNodo = new Element(Constant.XML_NODO_CLASS,
				Constant.XML_NODO_CLASS);
		classNodo.setAttribute(Constant.XML_NODO_NAME, objClass.getSimpleName()
				.replaceAll(Constant.SUFIX_CLASS_NAME, "").toUpperCase());
		
		Element id = new Element(Constant.ID_NODE_XML, Constant.XML_NODO_FIELD);
		id.setText(String.valueOf(obj.getUiId()));
		classNodo.addContent(id);
		
		while (true) {
			Method[] listMethods = objClass.getDeclaredMethods();
			for (Method method : listMethods) {
				
				if (!method.isAnnotationPresent(Transient.class)) {
					if (method.getName().startsWith(
							Constant.PREFIX_NAME_GET_METHOD)) {
						String nameAttr = method.getName().substring(3);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						
						nameAttr = inicialName + nameAttr.substring(1);
						Element element = new Element(nameAttr,
								Constant.XML_NODO_FIELD);
						try {
							
							Object newObj = method.invoke(obj);
							if (newObj instanceof BaseEntity) {
								element.addContent(getElementContent((BaseEntity) newObj));
							} else {
								element.setText(String.valueOf(method
										.invoke(obj)));
							}
						} catch (Exception e) {
							element.setText(String.valueOf(null));
						}
						classNodo.addContent(element);
						
					} else if (method.getName().startsWith(
							Constant.PREFIX_NAME_IS_METHOD)) {
						
						String nameAttr = method.getName().substring(2);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						
						nameAttr = inicialName + nameAttr.substring(1);
						Element element = new Element(nameAttr,
								Constant.XML_NODO_FIELD);
						try {
							
							Object newObj = method.invoke(obj);
							if (newObj instanceof BaseEntity) {
								element.addContent(getElementContent((BaseEntity) newObj));
							} else {
								element.setText(String.valueOf(method
										.invoke(obj)));
							}
						} catch (Exception e) {
							element.setText(String.valueOf(null));
						}
						classNodo.addContent(element);
						
					}
				}
			}
			
			objClass = (Class<? extends BaseEntity>) objClass.getSuperclass();
			if (objClass.isInstance(new BaseEntityImpl())
					|| objClass.isInstance(new Object())) {
				break;
			}
			
		}
		
		return classNodo;
	}
	
	/**
	 * Método<strong>toMap(obj)</strong> possui a função de retorna uma <em>{@link Map}</em> que representa o <em>{@link BaseEntity}</em>.
	 * 
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param obj
	 *            {@link BaseEntity} que será convertido para {@link Map}.
	 * @return <strong>map</strong> {@link Map} contendo os valores dos
	 *         atributos do {@link BaseEntity}.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(BaseEntity obj) {
		
		LOGGER.info("Convertendo para map o obj=" + String.valueOf(obj));
		Map<String, Object> mapValue = new HashMap<String, Object>();
		if (obj == null) {
			return mapValue;
		}
		
		mapValue.put(Constant.ID_NODE_XML, obj.getUiId());
		mapValue.put(Constant.VERSAO_NODE_XML, obj.getVersao());
		
		Class<? extends BaseEntity> objClass = obj.getClass();
		
		while (true) {
			Method[] listMethods = objClass.getDeclaredMethods();
			for (Method method : listMethods) {
				
				if (!method.isAnnotationPresent(Transient.class)) {
					if (method.getName().startsWith(
							Constant.PREFIX_NAME_GET_METHOD)) {
						
						String nameAttr = method.getName().substring(3);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						nameAttr = inicialName + nameAttr.substring(1);
						
						try {
							mapValue.put(nameAttr, method.invoke(obj));
						} catch (Exception e) {
							mapValue.put(nameAttr, null);
						}
					} else if (method.getName().startsWith(
							Constant.PREFIX_NAME_IS_METHOD)) {
						
						String nameAttr = method.getName().substring(2);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						nameAttr = inicialName + nameAttr.substring(1);
						try {
							mapValue.put(nameAttr, method.invoke(obj));
						} catch (Exception e) {
							mapValue.put(nameAttr, null);
						}
					}
				}
			}
			
			objClass = (Class<? extends BaseEntity>) objClass.getSuperclass();
			if (objClass.isInstance(new BaseEntityImpl())
					|| objClass.isInstance(new Object())) {
				break;
			}
			
		}
		return mapValue;
	}
	
	/**
	 * Método<strong>toString(obj)</strong> possui a função de retorna uma <em>{@link String}</em> que representa o <em>{@link BaseEntity}</em>.
	 * 
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param obj
	 *            {@link BaseEntity} que será convertido para {@link String}.
	 * @return <strong>str</strong> {@link String} contendo os valores dos
	 *         atributos do {@link BaseEntity}.
	 */
	@SuppressWarnings("unchecked")
	public static String toString(BaseEntity obj) {
		LOGGER.info("Convertendo para toString o obj=" + String.valueOf(obj));
		if (obj == null) {
			return "";
		}
		
		Class<? extends BaseEntity> objClass = obj.getClass();
		StringBuilder strObj = new StringBuilder();
		
		strObj.append(
				objClass.getSimpleName().replaceAll(Constant.SUFIX_CLASS_NAME,
						"")).append("[");
		strObj.append("uiId=").append(obj.getUiId()).append(", ");
		
		while (true) {
			Method[] listMethods = objClass.getDeclaredMethods();
			for (Method method : listMethods) {
				
				if (!method.isAnnotationPresent(Transient.class)) {
					if (method.getName().startsWith(
							Constant.PREFIX_NAME_GET_METHOD)) {
						
						String nameAttr = method.getName().substring(3);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						nameAttr = inicialName + nameAttr.substring(1);
						
						try {
							strObj.append(nameAttr).append("=")
									.append(method.invoke(obj));
						} catch (Exception e) {
							strObj.append(nameAttr).append("=").append("null");
						}
						strObj.append(", ");
						
					} else if (method.getName().startsWith(
							Constant.PREFIX_NAME_IS_METHOD)) {
						
						String nameAttr = method.getName().substring(2);
						String inicialName = String.valueOf(nameAttr.charAt(0))
								.toLowerCase();
						nameAttr = inicialName + nameAttr.substring(1);
						
						try {
							strObj.append(nameAttr).append("=")
									.append(method.invoke(obj));
						} catch (Exception e) {
							strObj.append(nameAttr).append("=").append("null");
						}
						strObj.append(", ");
					}
				}
			}
			objClass = (Class<? extends BaseEntity>) objClass.getSuperclass();
			if (objClass.isInstance(new BaseEntityImpl())
					|| objClass.isInstance(new Object())) {
				break;
			}
		}
		
		if (strObj.charAt(strObj.length() - 2) == ',') {
			strObj.delete(strObj.length() - 2, strObj.length());
		}
		strObj.append("]");
		
		return strObj.toString();
	}
	
	/**
	 * Metodo <b>toXml(obj)</b> possui a função de retorna uma <em>{@link String}</em> que representa o {@link BaseEntity} no formato
	 * XML.
	 * 
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param obj
	 *            {@link BaseEntity} que será convertido para {@link String} no
	 *            formato XML.
	 * @return <strong>xml</strong> {@link String} contendo os valores dos
	 *         atributos do {@link BaseEntity} no formato XML.
	 */
	public static String toXml(BaseEntity obj) {
		LOGGER.info("Convertendo para xml o obj=" + String.valueOf(obj));
		
		Document doc = new Document();
		if (obj != null) {
			doc.addContent(getElementContent(obj));
		}
		return out.outputString(doc);
	}
}
