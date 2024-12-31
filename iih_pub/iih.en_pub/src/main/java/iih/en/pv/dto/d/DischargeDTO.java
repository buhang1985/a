package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退院DTO DTO数据 
 * 
 */
public class DischargeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区ID
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
	 * 科室ID
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室ID
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 床位ID
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位ID
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 责任护士姓名
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 责任护士姓名
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 预付费
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预付费
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 入院标识
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 检查医嘱校验信息
	 * @return String
	 */
	public String getError_or() {
		return ((String) getAttrVal("Error_or"));
	}
	/**
	 * 检查医嘱校验信息
	 * @param Error_or
	 */
	public void setError_or(String Error_or) {
		setAttrVal("Error_or", Error_or);
	}
	/**
	 * 检查费用校验信息
	 * @return String
	 */
	public String getError_bl() {
		return ((String) getAttrVal("Error_bl"));
	}
	/**
	 * 检查费用校验信息
	 * @param Error_bl
	 */
	public void setError_bl(String Error_bl) {
		setAttrVal("Error_bl", Error_bl);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 医疗类别id
	 * @return String
	 */
	public String getId_hpmedkind() {
		return ((String) getAttrVal("Id_hpmedkind"));
	}
	/**
	 * 医疗类别id
	 * @param Id_hpmedkind
	 */
	public void setId_hpmedkind(String Id_hpmedkind) {
		setAttrVal("Id_hpmedkind", Id_hpmedkind);
	}
	/**
	 * 医疗类别名称
	 * @return String
	 */
	public String getName_hpmedkind() {
		return ((String) getAttrVal("Name_hpmedkind"));
	}
	/**
	 * 医疗类别名称
	 * @param Name_hpmedkind
	 */
	public void setName_hpmedkind(String Name_hpmedkind) {
		setAttrVal("Name_hpmedkind", Name_hpmedkind);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 新生儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标志
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 新生儿数量
	 * @return Integer
	 */
	public Integer getNum_newborn() {
		return ((Integer) getAttrVal("Num_newborn"));
	}
	/**
	 * 新生儿数量
	 * @param Num_newborn
	 */
	public void setNum_newborn(Integer Num_newborn) {
		setAttrVal("Num_newborn", Num_newborn);
	}
}