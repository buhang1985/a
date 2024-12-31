package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院召回DTO DTO数据 
 * 
 */
public class HosRecallQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 病区ID
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getD_begin() {
		return ((FDate) getAttrVal("D_begin"));
	}
	/**
	 * 开始日期
	 * @param D_begin
	 */
	public void setD_begin(FDate D_begin) {
		setAttrVal("D_begin", D_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getD_ent() {
		return ((FDate) getAttrVal("D_ent"));
	}
	/**
	 * 结束日期
	 * @param D_ent
	 */
	public void setD_ent(FDate D_ent) {
		setAttrVal("D_ent", D_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getIp_code() {
		return ((String) getAttrVal("Ip_code"));
	}
	/**
	 * 住院号
	 * @param Ip_code
	 */
	public void setIp_code(String Ip_code) {
		setAttrVal("Ip_code", Ip_code);
	}
}