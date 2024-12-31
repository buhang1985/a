package iih.mp.nr.dto.dbsignval.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行双签 DTO数据 
 * 
 */
public class DbSignDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 双签人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 双签人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 双签人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 双签人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 密码
	 * @return String
	 */
	public String getPwd() {
		return ((String) getAttrVal("Pwd"));
	}
	/**
	 * 密码
	 * @param Pwd
	 */
	public void setPwd(String Pwd) {
		setAttrVal("Pwd", Pwd);
	}
}