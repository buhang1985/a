package iih.crm.conm.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 营销方案验证介质dto DTO数据 
 * 
 */
public class CmpMarChkDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 营销方案验证介质id
	 * @return String
	 */
	public String getId_marplanchk() {
		return ((String) getAttrVal("Id_marplanchk"));
	}
	/**
	 * 营销方案验证介质id
	 * @param Id_marplanchk
	 */
	public void setId_marplanchk(String Id_marplanchk) {
		setAttrVal("Id_marplanchk", Id_marplanchk);
	}
	/**
	 * 营销方案id
	 * @return String
	 */
	public String getId_marplan() {
		return ((String) getAttrVal("Id_marplan"));
	}
	/**
	 * 营销方案id
	 * @param Id_marplan
	 */
	public void setId_marplan(String Id_marplan) {
		setAttrVal("Id_marplan", Id_marplan);
	}
	/**
	 * 验证介质类型id
	 * @return String
	 */
	public String getId_keytp() {
		return ((String) getAttrVal("Id_keytp"));
	}
	/**
	 * 验证介质类型id
	 * @param Id_keytp
	 */
	public void setId_keytp(String Id_keytp) {
		setAttrVal("Id_keytp", Id_keytp);
	}
	/**
	 * 验证介质类型编码
	 * @return String
	 */
	public String getSd_keytp() {
		return ((String) getAttrVal("Sd_keytp"));
	}
	/**
	 * 验证介质类型编码
	 * @param Sd_keytp
	 */
	public void setSd_keytp(String Sd_keytp) {
		setAttrVal("Sd_keytp", Sd_keytp);
	}
	/**
	 * 验证介质类型名称
	 * @return String
	 */
	public String getName_keytp() {
		return ((String) getAttrVal("Name_keytp"));
	}
	/**
	 * 验证介质类型名称
	 * @param Name_keytp
	 */
	public void setName_keytp(String Name_keytp) {
		setAttrVal("Name_keytp", Name_keytp);
	}
	/**
	 * 验证介质实物编码
	 * @return String
	 */
	public String getCode_key() {
		return ((String) getAttrVal("Code_key"));
	}
	/**
	 * 验证介质实物编码
	 * @param Code_key
	 */
	public void setCode_key(String Code_key) {
		setAttrVal("Code_key", Code_key);
	}
}