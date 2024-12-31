package iih.mp.dg.intelcabinetdetail;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

public class IntelCabinetDetailDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 药品名
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	
	/**
	 * 单号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 单号
	 * @param Spec
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	
	
	/**
	 * 药量
	 * @return Quan_mp
	 */
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}
	/**
	 * 药量
	 * @param FDouble
	 */
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	
	
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}

	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_mr() {
		return ((String) getAttrVal("Code_mr"));
	}
	/**
	 * 病历号
	 * @param Code_mr
	 */
	public void setCode_mr(String Code_mr) {
		setAttrVal("Code_mr", Code_mr);
	}
	
	
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDate_plan() {
		return ((FDateTime) getAttrVal("Date_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Date_plan
	 */
	public void setDate_plan(FDateTime Date_plan) {
		setAttrVal("Date_plan", Date_plan);
	}
	
	
	/**
	 * 药师确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dp() {
		return ((FDateTime) getAttrVal("Dt_dp"));
	}
	/**
	 * 药师确认时间
	 * @param Date_sure
	 */
	public void setDt_dp(FDateTime Dt_dp) {
		setAttrVal("Dt_dp", Dt_dp);
	}
}
