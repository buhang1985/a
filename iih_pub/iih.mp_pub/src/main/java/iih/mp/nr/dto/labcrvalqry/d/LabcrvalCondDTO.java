package iih.mp.nr.dto.labcrvalqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 危急值结果查询条件 DTO数据 
 * 
 */
public class LabcrvalCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询主键
	 * @return String
	 */
	public String getId_qry() {
		return ((String) getAttrVal("Id_qry"));
	}
	/**
	 * 查询主键
	 * @param Id_qry
	 */
	public void setId_qry(String Id_qry) {
		setAttrVal("Id_qry", Id_qry);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医生工号
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}
	/**
	 * 医生工号
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 护士工号
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}
	/**
	 * 护士工号
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 处理状态
	 * @return Integer
	 */
	public Integer getEu_hnd() {
		return ((Integer) getAttrVal("Eu_hnd"));
	}
	/**
	 * 处理状态
	 * @param Eu_hnd
	 */
	public void setEu_hnd(Integer Eu_hnd) {
		setAttrVal("Eu_hnd", Eu_hnd);
	}
	/**
	 * 医生状态
	 * @return Integer
	 */
	public Integer getEu_doc() {
		return ((Integer) getAttrVal("Eu_doc"));
	}
	/**
	 * 医生状态
	 * @param Eu_doc
	 */
	public void setEu_doc(Integer Eu_doc) {
		setAttrVal("Eu_doc", Eu_doc);
	}
	/**
	 * 护士状态
	 * @return Integer
	 */
	public Integer getEu_nur() {
		return ((Integer) getAttrVal("Eu_nur"));
	}
	/**
	 * 护士状态
	 * @param Eu_nur
	 */
	public void setEu_nur(Integer Eu_nur) {
		setAttrVal("Eu_nur", Eu_nur);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
}