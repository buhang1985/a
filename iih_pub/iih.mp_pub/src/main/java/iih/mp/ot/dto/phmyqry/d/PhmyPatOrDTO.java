package iih.mp.ot.dto.phmyqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发药患者处方信息 DTO数据 
 * 
 */
public class PhmyPatOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 发药日期
	 * @return FDateTime
	 */
	public FDateTime getDt_phym() {
		return ((FDateTime) getAttrVal("Dt_phym"));
	}
	/**
	 * 发药日期
	 * @param Dt_phym
	 */
	public void setDt_phym(FDateTime Dt_phym) {
		setAttrVal("Dt_phym", Dt_phym);
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
	 * 数量
	 * @return FDouble
	 */
	public FDouble getNum() {
		return ((FDouble) getAttrVal("Num"));
	}
	/**
	 * 数量
	 * @param Num
	 */
	public void setNum(FDouble Num) {
		setAttrVal("Num", Num);
	}
	/**
	 * 单位ID
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位ID
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
	 * 发药人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 发药人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 发药人编码
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 发药人编码
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	 * 科室名称
	 * @return String
	 */
	public String getName_depphy() {
		return ((String) getAttrVal("Name_depphy"));
	}
	/**
	 * 科室名称
	 * @param Name_depphy
	 */
	public void setName_depphy(String Name_depphy) {
		setAttrVal("Name_depphy", Name_depphy);
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
	 * 病区名称
	 * @return String
	 */
	public String getName_depnur() {
		return ((String) getAttrVal("Name_depnur"));
	}
	/**
	 * 病区名称
	 * @param Name_depnur
	 */
	public void setName_depnur(String Name_depnur) {
		setAttrVal("Name_depnur", Name_depnur);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 药品执行主表id
	 * @return String
	 */
	public String getId_dgop() {
		return ((String) getAttrVal("Id_dgop"));
	}
	/**
	 * 药品执行主表id
	 * @param Id_dgop
	 */
	public void setId_dgop(String Id_dgop) {
		setAttrVal("Id_dgop", Id_dgop);
	}
	/**
	 * 是否有退药
	 * @return FBoolean
	 */
	public FBoolean getFg_rtn() {
		return ((FBoolean) getAttrVal("Fg_rtn"));
	}
	/**
	 * 是否有退药
	 * @param Fg_rtn
	 */
	public void setFg_rtn(FBoolean Fg_rtn) {
		setAttrVal("Fg_rtn", Fg_rtn);
	}
}