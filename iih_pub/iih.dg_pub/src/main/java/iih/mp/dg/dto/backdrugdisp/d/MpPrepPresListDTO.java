package iih.mp.dg.dto.backdrugdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药处方列表 DTO数据 
 * 
 */
public class MpPrepPresListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否已打印
	 * @return FBoolean
	 */
	public FBoolean getFg_printed() {
		return ((FBoolean) getAttrVal("Fg_printed"));
	}
	/**
	 * 是否已打印
	 * @param Fg_printed
	 */
	public void setFg_printed(FBoolean Fg_printed) {
		setAttrVal("Fg_printed", Fg_printed);
	}
	/**
	 * 病人ID
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人ID
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 病人姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}
	/**
	 * 处方类型
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 开方科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开方科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开方医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开方医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInvoice_no() {
		return ((String) getAttrVal("Invoice_no"));
	}
	/**
	 * 发票号
	 * @param Invoice_no
	 */
	public void setInvoice_no(String Invoice_no) {
		setAttrVal("Invoice_no", Invoice_no);
	}
	/**
	 * 缴费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 缴费时间
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getName_pharm() {
		return ((String) getAttrVal("Name_pharm"));
	}
	/**
	 * 药房
	 * @param Name_pharm
	 */
	public void setName_pharm(String Name_pharm) {
		setAttrVal("Name_pharm", Name_pharm);
	}
	/**
	 * 发药窗口
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 发药窗口
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 配药状态
	 * @return String
	 */
	public String getStatus_pres() {
		return ((String) getAttrVal("Status_pres"));
	}
	/**
	 * 配药状态
	 * @param Status_pres
	 */
	public void setStatus_pres(String Status_pres) {
		setAttrVal("Status_pres", Status_pres);
	}
	/**
	 * 处方明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 处方明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 数据产生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inse() {
		return ((FDateTime) getAttrVal("Dt_inse"));
	}
	/**
	 * 数据产生日期
	 * @param Dt_inse
	 */
	public void setDt_inse(FDateTime Dt_inse) {
		setAttrVal("Dt_inse", Dt_inse);
	}
	/**
	 * 打印日期
	 * @return FDateTime
	 */
	public FDateTime getDt_prin() {
		return ((FDateTime) getAttrVal("Dt_prin"));
	}
	/**
	 * 打印日期
	 * @param Dt_prin
	 */
	public void setDt_prin(FDateTime Dt_prin) {
		setAttrVal("Dt_prin", Dt_prin);
	}
	/**
	 * 摆药完成的日期
	 * @return FDateTime
	 */
	public FDateTime getDt_fin() {
		return ((FDateTime) getAttrVal("Dt_fin"));
	}
	/**
	 * 摆药完成的日期
	 * @param Dt_fin
	 */
	public void setDt_fin(FDateTime Dt_fin) {
		setAttrVal("Dt_fin", Dt_fin);
	}
	/**
	 * 数据产生操作员
	 * @return String
	 */
	public String getId_emp_inse() {
		return ((String) getAttrVal("Id_emp_inse"));
	}
	/**
	 * 数据产生操作员
	 * @param Id_emp_inse
	 */
	public void setId_emp_inse(String Id_emp_inse) {
		setAttrVal("Id_emp_inse", Id_emp_inse);
	}
	/**
	 * 计划发药窗口
	 * @return String
	 */
	public String getId_quesite_pl() {
		return ((String) getAttrVal("Id_quesite_pl"));
	}
	/**
	 * 计划发药窗口
	 * @param Id_quesite_pl
	 */
	public void setId_quesite_pl(String Id_quesite_pl) {
		setAttrVal("Id_quesite_pl", Id_quesite_pl);
	}
	/**
	 * 打印操作员
	 * @return String
	 */
	public String getId_emp_prin() {
		return ((String) getAttrVal("Id_emp_prin"));
	}
	/**
	 * 打印操作员
	 * @param Id_emp_prin
	 */
	public void setId_emp_prin(String Id_emp_prin) {
		setAttrVal("Id_emp_prin", Id_emp_prin);
	}
	/**
	 * 摆药完成操作员
	 * @return String
	 */
	public String getId_emp_fin() {
		return ((String) getAttrVal("Id_emp_fin"));
	}
	/**
	 * 摆药完成操作员
	 * @param Id_emp_fin
	 */
	public void setId_emp_fin(String Id_emp_fin) {
		setAttrVal("Id_emp_fin", Id_emp_fin);
	}
	/**
	 * 摆药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_by() {
		return ((FBoolean) getAttrVal("Fg_by"));
	}
	/**
	 * 摆药标志
	 * @param Fg_by
	 */
	public void setFg_by(FBoolean Fg_by) {
		setAttrVal("Fg_by", Fg_by);
	}
	/**
	 * 处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	 * 发药状态
	 * @return Integer
	 */
	public Integer getEu_su_mpdgop() {
		return ((Integer) getAttrVal("Eu_su_mpdgop"));
	}
	/**
	 * 发药状态
	 * @param Eu_su_mpdgop
	 */
	public void setEu_su_mpdgop(Integer Eu_su_mpdgop) {
		setAttrVal("Eu_su_mpdgop", Eu_su_mpdgop);
	}
}