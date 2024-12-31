package iih.mp.dg.dto.druguseqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用药查询明细 DTO数据 
 * 
 */
public class MpDrugUseDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
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
	 * 频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单位id
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}
	/**
	 * 单位id
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_pkgu() {
		return ((String) getAttrVal("Name_pkgu"));
	}
	/**
	 * 单位
	 * @param Name_pkgu
	 */
	public void setName_pkgu(String Name_pkgu) {
		setAttrVal("Name_pkgu", Name_pkgu);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 请领单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 发药状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}
	/**
	 * 发药状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_dp() {
		return ((String) getAttrVal("Name_emp_dp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_dp
	 */
	public void setName_emp_dp(String Name_emp_dp) {
		setAttrVal("Name_emp_dp", Name_emp_dp);
	}
	/**
	 * 发药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dp() {
		return ((FDateTime) getAttrVal("Dt_dp"));
	}
	/**
	 * 发药时间
	 * @param Dt_dp
	 */
	public void setDt_dp(FDateTime Dt_dp) {
		setAttrVal("Dt_dp", Dt_dp);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 请领处理状态
	 * @return Integer
	 */
	public Integer getEn_opap() {
		return ((Integer) getAttrVal("En_opap"));
	}
	/**
	 * 请领处理状态
	 * @param En_opap
	 */
	public void setEn_opap(Integer En_opap) {
		setAttrVal("En_opap", En_opap);
	}
	/**
	 * 发放处理状态
	 * @return Integer
	 */
	public Integer getEn_opde() {
		return ((Integer) getAttrVal("En_opde"));
	}
	/**
	 * 发放处理状态
	 * @param En_opde
	 */
	public void setEn_opde(Integer En_opde) {
		setAttrVal("En_opde", En_opde);
	}
	/**
	 * 请领单状态
	 * @return Integer
	 */
	public Integer getSd_dgap() {
		return ((Integer) getAttrVal("Sd_dgap"));
	}
	/**
	 * 请领单状态
	 * @param Sd_dgap
	 */
	public void setSd_dgap(Integer Sd_dgap) {
		setAttrVal("Sd_dgap", Sd_dgap);
	}
}