package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询补费关联数据条件 DTO数据 
 * 
 */
public class MpOtFeeParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 价格分类id
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_pkgu() {
		return ((String) getAttrVal("Id_pkgu"));
	}
	/**
	 * 包装单位
	 * @param Id_pkgu
	 */
	public void setId_pkgu(String Id_pkgu) {
		setAttrVal("Id_pkgu", Id_pkgu);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_usage() {
		return ((String) getAttrVal("Id_usage"));
	}
	/**
	 * 用法
	 * @param Id_usage
	 */
	public void setId_usage(String Id_usage) {
		setAttrVal("Id_usage", Id_usage);
	}
	/**
	 * 长临标识
	 * @return String
	 */
	public String getRecurstr() {
		return ((String) getAttrVal("Recurstr"));
	}
	/**
	 * 长临标识
	 * @param Recurstr
	 */
	public void setRecurstr(String Recurstr) {
		setAttrVal("Recurstr", Recurstr);
	}
	/**
	 * 星期几
	 * @return String
	 */
	public String getWeekno() {
		return ((String) getAttrVal("Weekno"));
	}
	/**
	 * 星期几
	 * @param Weekno
	 */
	public void setWeekno(String Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	/**
	 * 时间
	 * @return FTime
	 */
	public FTime getTimestr() {
		return ((FTime) getAttrVal("Timestr"));
	}
	/**
	 * 时间
	 * @param Timestr
	 */
	public void setTimestr(FTime Timestr) {
		setAttrVal("Timestr", Timestr);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dept_en() {
		return ((String) getAttrVal("Id_dept_en"));
	}
	/**
	 * 就诊科室
	 * @param Id_dept_en
	 */
	public void setId_dept_en(String Id_dept_en) {
		setAttrVal("Id_dept_en", Id_dept_en);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dept_ns() {
		return ((String) getAttrVal("Id_dept_ns"));
	}
	/**
	 * 病区
	 * @param Id_dept_ns
	 */
	public void setId_dept_ns(String Id_dept_ns) {
		setAttrVal("Id_dept_ns", Id_dept_ns);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dept_or() {
		return ((String) getAttrVal("Id_dept_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dept_or
	 */
	public void setId_dept_or(String Id_dept_or) {
		setAttrVal("Id_dept_or", Id_dept_or);
	}
	/**
	 * 服务分类内编码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内编码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 流向类型
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}
	/**
	 * 流向类型
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 毒麻类型
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻类型
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
}