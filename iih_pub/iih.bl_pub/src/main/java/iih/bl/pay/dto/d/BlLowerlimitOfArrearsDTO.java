package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 欠费下限展示dto DTO数据 
 * 
 */
public class BlLowerlimitOfArrearsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 住院科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 住院科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getMr_no() {
		return ((String) getAttrVal("Mr_no"));
	}
	/**
	 * 病历号
	 * @param Mr_no
	 */
	public void setMr_no(String Mr_no) {
		setAttrVal("Mr_no", Mr_no);
	}
	/**
	 * 是否欠费
	 * @return FBoolean
	 */
	public FBoolean getFg_arrears() {
		return ((FBoolean) getAttrVal("Fg_arrears"));
	}
	/**
	 * 是否欠费
	 * @param Fg_arrears
	 */
	public void setFg_arrears(FBoolean Fg_arrears) {
		setAttrVal("Fg_arrears", Fg_arrears);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getPatca() {
		return ((String) getAttrVal("Patca"));
	}
	/**
	 * 患者分类
	 * @param Patca
	 */
	public void setPatca(String Patca) {
		setAttrVal("Patca", Patca);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 当前押金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay_remain() {
		return ((FDouble) getAttrVal("Amt_prepay_remain"));
	}
	/**
	 * 当前押金
	 * @param Amt_prepay_remain
	 */
	public void setAmt_prepay_remain(FDouble Amt_prepay_remain) {
		setAttrVal("Amt_prepay_remain", Amt_prepay_remain);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getAmt_avale() {
		return ((FDouble) getAttrVal("Amt_avale"));
	}
	/**
	 * 可用余额
	 * @param Amt_avale
	 */
	public void setAmt_avale(FDouble Amt_avale) {
		setAttrVal("Amt_avale", Amt_avale);
	}
	/**
	 * 欠款
	 * @return FDouble
	 */
	public FDouble getArrears() {
		return ((FDouble) getAttrVal("Arrears"));
	}
	/**
	 * 欠款
	 * @param Arrears
	 */
	public void setArrears(FDouble Arrears) {
		setAttrVal("Arrears", Arrears);
	}
	/**
	 * 欠费下限
	 * @return FDouble
	 */
	public FDouble getArrearslower() {
		return ((FDouble) getAttrVal("Arrearslower"));
	}
	/**
	 * 欠费下限
	 * @param Arrearslower
	 */
	public void setArrearslower(FDouble Arrearslower) {
		setAttrVal("Arrearslower", Arrearslower);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}