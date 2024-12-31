package iih.bd.fc.dto.matchdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询卡条件 DTO数据 
 * 
 */
public class CardQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 部门ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 部门ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_udiddm() {
		return ((String) getAttrVal("Id_udiddm"));
	}
	/**
	 * 领药方式ID
	 * @param Id_udiddm
	 */
	public void setId_udiddm(String Id_udiddm) {
		setAttrVal("Id_udiddm", Id_udiddm);
	}
	/**
	 * 领药方式
	 * @return String
	 */
	public String getName_udiddm() {
		return ((String) getAttrVal("Name_udiddm"));
	}
	/**
	 * 领药方式
	 * @param Name_udiddm
	 */
	public void setName_udiddm(String Name_udiddm) {
		setAttrVal("Name_udiddm", Name_udiddm);
	}
	/**
	 * 关键字
	 * @return String
	 */
	public String getKey() {
		return ((String) getAttrVal("Key"));
	}
	/**
	 * 关键字
	 * @param Key
	 */
	public void setKey(String Key) {
		setAttrVal("Key", Key);
	}
	/**
	 * 数据类型
	 * @return Integer
	 */
	public Integer getEu_datatp() {
		return ((Integer) getAttrVal("Eu_datatp"));
	}
	/**
	 * 数据类型
	 * @param Eu_datatp
	 */
	public void setEu_datatp(Integer Eu_datatp) {
		setAttrVal("Eu_datatp", Eu_datatp);
	}
	/**
	 * 已选择ID集合
	 * @return String
	 */
	public String getId_keys() {
		return ((String) getAttrVal("Id_keys"));
	}
	/**
	 * 已选择ID集合
	 * @param Id_keys
	 */
	public void setId_keys(String Id_keys) {
		setAttrVal("Id_keys", Id_keys);
	}
}