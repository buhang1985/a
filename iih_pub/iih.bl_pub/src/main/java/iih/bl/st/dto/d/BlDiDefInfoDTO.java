package iih.bl.st.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者诊断信息 DTO数据 
 * 
 */
public class BlDiDefInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * his诊断编码
	 * @return String
	 */
	public String getHis_di_code() {
		return ((String) getAttrVal("His_di_code"));
	}
	/**
	 * his诊断编码
	 * @param His_di_code
	 */
	public void setHis_di_code(String His_di_code) {
		setAttrVal("His_di_code", His_di_code);
	}
	/**
	 * his诊断名称
	 * @return String
	 */
	public String getHis_di_name() {
		return ((String) getAttrVal("His_di_name"));
	}
	/**
	 * his诊断名称
	 * @param His_di_name
	 */
	public void setHis_di_name(String His_di_name) {
		setAttrVal("His_di_name", His_di_name);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getHp_di_code() {
		return ((String) getAttrVal("Hp_di_code"));
	}
	/**
	 * 医保诊断编码
	 * @param Hp_di_code
	 */
	public void setHp_di_code(String Hp_di_code) {
		setAttrVal("Hp_di_code", Hp_di_code);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getHp_di_name() {
		return ((String) getAttrVal("Hp_di_name"));
	}
	/**
	 * 医保诊断名称
	 * @param Hp_di_name
	 */
	public void setHp_di_name(String Hp_di_name) {
		setAttrVal("Hp_di_name", Hp_di_name);
	}
	/**
	 * 主要诊断标识
	 * @return FBoolean
	 */
	public FBoolean getFg_maj() {
		return ((FBoolean) getAttrVal("Fg_maj"));
	}
	/**
	 * 主要诊断标识
	 * @param Fg_maj
	 */
	public void setFg_maj(FBoolean Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}
	/**
	 * 诊断类型
	 * @param Sd_ditp
	 */
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
}