package iih.valueobject.country.ruralcooperinsure.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记信息查询请求DTO DTO数据 
 * 
 */
public class InpRegisterSeekReqDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 参合地区编码
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}
	/**
	 * 参合地区编码
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 患者新农合个人代码
	 * @return String
	 */
	public String getMembercode() {
		return ((String) getAttrVal("Membercode"));
	}
	/**
	 * 患者新农合个人代码
	 * @param Membercode
	 */
	public void setMembercode(String Membercode) {
		setAttrVal("Membercode", Membercode);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 住院号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
}