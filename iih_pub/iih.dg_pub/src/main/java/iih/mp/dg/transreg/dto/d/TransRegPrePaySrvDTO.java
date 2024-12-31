package iih.mp.dg.transreg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液登记预付费项目 DTO数据 
 * 
 */
public class TransRegPrePaySrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getOr_code() {
		return ((String) getAttrVal("Or_code"));
	}
	/**
	 * 医嘱编码
	 * @param Or_code
	 */
	public void setOr_code(String Or_code) {
		setAttrVal("Or_code", Or_code);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOr_name() {
		return ((String) getAttrVal("Or_name"));
	}
	/**
	 * 医嘱名称
	 * @param Or_name
	 */
	public void setOr_name(String Or_name) {
		setAttrVal("Or_name", Or_name);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱服务项目编码
	 * @return String
	 */
	public String getOrsrv_code() {
		return ((String) getAttrVal("Orsrv_code"));
	}
	/**
	 * 医嘱服务项目编码
	 * @param Orsrv_code
	 */
	public void setOrsrv_code(String Orsrv_code) {
		setAttrVal("Orsrv_code", Orsrv_code);
	}
	/**
	 * 医嘱服务项目名称
	 * @return String
	 */
	public String getOrsrv_name() {
		return ((String) getAttrVal("Orsrv_name"));
	}
	/**
	 * 医嘱服务项目名称
	 * @param Orsrv_name
	 */
	public void setOrsrv_name(String Orsrv_name) {
		setAttrVal("Orsrv_name", Orsrv_name);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}
	/**
	 * 标准价
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}
	/**
	 * 价格系数
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}
	/**
	 * 剂量单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 剂量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}
	/**
	 * 剂量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_srv
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getDep_srv_name() {
		return ((String) getAttrVal("Dep_srv_name"));
	}
	/**
	 * 开立科室名称
	 * @param Dep_srv_name
	 */
	public void setDep_srv_name(String Dep_srv_name) {
		setAttrVal("Dep_srv_name", Dep_srv_name);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getEmp_srv_name() {
		return ((String) getAttrVal("Emp_srv_name"));
	}
	/**
	 * 开立医生名称
	 * @param Emp_srv_name
	 */
	public void setEmp_srv_name(String Emp_srv_name) {
		setAttrVal("Emp_srv_name", Emp_srv_name);
	}
	/**
	 * 签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}
	/**
	 * 签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 记账状态名称
	 * @return String
	 */
	public String getSu_bl_name() {
		return ((String) getAttrVal("Su_bl_name"));
	}
	/**
	 * 记账状态名称
	 * @param Su_bl_name
	 */
	public void setSu_bl_name(String Su_bl_name) {
		setAttrVal("Su_bl_name", Su_bl_name);
	}
	/**
	 * 医保目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 医保目录类型名称
	 * @return String
	 */
	public String getHpsrvtp_name() {
		return ((String) getAttrVal("Hpsrvtp_name"));
	}
	/**
	 * 医保目录类型名称
	 * @param Hpsrvtp_name
	 */
	public void setHpsrvtp_name(String Hpsrvtp_name) {
		setAttrVal("Hpsrvtp_name", Hpsrvtp_name);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
}