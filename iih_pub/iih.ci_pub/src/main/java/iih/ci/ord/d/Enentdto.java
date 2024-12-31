package iih.ci.ord.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 练习enentdto DTO数据 
 * 
 */
public class Enentdto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 名字
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名字
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getEnentdept() {
		return ((String) getAttrVal("Enentdept"));
	}
	/**
	 * 就诊科室
	 * @param Enentdept
	 */
	public void setEnentdept(String Enentdept) {
		setAttrVal("Enentdept", Enentdept);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 就诊医生
	 * @return String
	 */
	public String getEnentdoctor() {
		return ((String) getAttrVal("Enentdoctor"));
	}
	/**
	 * 就诊医生
	 * @param Enentdoctor
	 */
	public void setEnentdoctor(String Enentdoctor) {
		setAttrVal("Enentdoctor", Enentdoctor);
	}
}