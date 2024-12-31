package iih.ci.ord.dws.ip.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术人员 DTO数据 
 * 
 */
public class EmsOprEmpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 手术人员主键标识
	 * @return String
	 */
	public String getId_apopemp() {
		return ((String) getAttrVal("Id_apopemp"));
	}
	/**
	 * 手术人员主键标识
	 * @param Id_apopemp
	 */
	public void setId_apopemp(String Id_apopemp) {
		setAttrVal("Id_apopemp", Id_apopemp);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 人员id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 人员
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}
	/**
	 * 角色
	 * @param Name_role
	 */
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
	}
	/**
	 * 角色id
	 * @return String
	 */
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}
	/**
	 * 角色id
	 * @param Id_role
	 */
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	/**
	 * 角色编码
	 * @return String
	 */
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}
	/**
	 * 角色编码
	 * @param Sd_role
	 */
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
	}
	/**
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
}