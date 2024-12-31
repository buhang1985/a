package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预约属性 DTO数据 
 * 
 */
public class AptIpAttrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院预约属性
	 * @return String
	 */
	public String getId_aptipattr() {
		return ((String) getAttrVal("Id_aptipattr"));
	}
	/**
	 * 住院预约属性
	 * @param Id_aptipattr
	 */
	public void setId_aptipattr(String Id_aptipattr) {
		setAttrVal("Id_aptipattr", Id_aptipattr);
	}
	/**
	 * 床位特征类型
	 * @return String
	 */
	public String getId_bedattr_tp() {
		return ((String) getAttrVal("Id_bedattr_tp"));
	}
	/**
	 * 床位特征类型
	 * @param Id_bedattr_tp
	 */
	public void setId_bedattr_tp(String Id_bedattr_tp) {
		setAttrVal("Id_bedattr_tp", Id_bedattr_tp);
	}
	/**
	 * 床位特征类型sd
	 * @return String
	 */
	public String getSd_bedattr_tp() {
		return ((String) getAttrVal("Sd_bedattr_tp"));
	}
	/**
	 * 床位特征类型sd
	 * @param Sd_bedattr_tp
	 */
	public void setSd_bedattr_tp(String Sd_bedattr_tp) {
		setAttrVal("Sd_bedattr_tp", Sd_bedattr_tp);
	}
	/**
	 * 床位特征类型name
	 * @return String
	 */
	public String getName_bedattr_tp() {
		return ((String) getAttrVal("Name_bedattr_tp"));
	}
	/**
	 * 床位特征类型name
	 * @param Name_bedattr_tp
	 */
	public void setName_bedattr_tp(String Name_bedattr_tp) {
		setAttrVal("Name_bedattr_tp", Name_bedattr_tp);
	}
	/**
	 * 特征值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 特征值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
}