package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分诊级别DTO DTO数据 
 * 
 */
public class TriageLevelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分诊级别明细id
	 * @return String
	 */
	public String getId_triagelevel_itm() {
		return ((String) getAttrVal("Id_triagelevel_itm"));
	}
	/**
	 * 分诊级别明细id
	 * @param Id_triagelevel_itm
	 */
	public void setId_triagelevel_itm(String Id_triagelevel_itm) {
		setAttrVal("Id_triagelevel_itm", Id_triagelevel_itm);
	}
	/**
	 * 检伤分级id
	 * @return String
	 */
	public String getId_scale() {
		return ((String) getAttrVal("Id_scale"));
	}
	/**
	 * 检伤分级id
	 * @param Id_scale
	 */
	public void setId_scale(String Id_scale) {
		setAttrVal("Id_scale", Id_scale);
	}
	/**
	 * 检伤分级编码
	 * @return String
	 */
	public String getSd_scale() {
		return ((String) getAttrVal("Sd_scale"));
	}
	/**
	 * 检伤分级编码
	 * @param Sd_scale
	 */
	public void setSd_scale(String Sd_scale) {
		setAttrVal("Sd_scale", Sd_scale);
	}
	/**
	 * 级别描述
	 * @return String
	 */
	public String getLevel_des() {
		return ((String) getAttrVal("Level_des"));
	}
	/**
	 * 级别描述
	 * @param Level_des
	 */
	public void setLevel_des(String Level_des) {
		setAttrVal("Level_des", Level_des);
	}
	/**
	 * 分级类型
	 * @return String
	 */
	public String getSd_scaletp() {
		return ((String) getAttrVal("Sd_scaletp"));
	}
	/**
	 * 分级类型
	 * @param Sd_scaletp
	 */
	public void setSd_scaletp(String Sd_scaletp) {
		setAttrVal("Sd_scaletp", Sd_scaletp);
	}
}