package iih.hp.cp.extdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 无效属性项 DTO数据 
 * 
 */
public class HpCpElePropInvalidDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常属性Id
	 * @return String
	 */
	public String getId_ppe() {
		return ((String) getAttrVal("Id_ppe"));
	}
	/**
	 * 异常属性Id
	 * @param Id_ppe
	 */
	public void setId_ppe(String Id_ppe) {
		setAttrVal("Id_ppe", Id_ppe);
	}
	/**
	 * 值异常类型Id
	 * @return String
	 */
	public String getId_invalid_type() {
		return ((String) getAttrVal("Id_invalid_type"));
	}
	/**
	 * 值异常类型Id
	 * @param Id_invalid_type
	 */
	public void setId_invalid_type(String Id_invalid_type) {
		setAttrVal("Id_invalid_type", Id_invalid_type);
	}
	/**
	 * 值异常类型Code
	 * @return String
	 */
	public String getSd_invalid_type() {
		return ((String) getAttrVal("Sd_invalid_type"));
	}
	/**
	 * 值异常类型Code
	 * @param Sd_invalid_type
	 */
	public void setSd_invalid_type(String Sd_invalid_type) {
		setAttrVal("Sd_invalid_type", Sd_invalid_type);
	}
	/**
	 * 值异常类型Name
	 * @return String
	 */
	public String getName_invalid_type() {
		return ((String) getAttrVal("Name_invalid_type"));
	}
	/**
	 * 值异常类型Name
	 * @param Name_invalid_type
	 */
	public void setName_invalid_type(String Name_invalid_type) {
		setAttrVal("Name_invalid_type", Name_invalid_type);
	}
}