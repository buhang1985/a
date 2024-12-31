package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊历史查询条件 DTO数据 
 * 
 */
public class EnHisQryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}
	/**
	 * 证件号码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 医生id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 医生id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_b() {
		return ((FDate) getAttrVal("Dt_b"));
	}
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDate Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_e() {
		return ((FDate) getAttrVal("Dt_e"));
	}
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDate Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 是否只包含诊毕就诊
	 * @return FBoolean
	 */
	public FBoolean getFg_onlydiagend() {
		return ((FBoolean) getAttrVal("Fg_onlydiagend"));
	}
	/**
	 * 是否只包含诊毕就诊
	 * @param Fg_onlydiagend
	 */
	public void setFg_onlydiagend(FBoolean Fg_onlydiagend) {
		setAttrVal("Fg_onlydiagend", Fg_onlydiagend);
	}
	/**
	 * 是否包含诊断明细
	 * @return FBoolean
	 */
	public FBoolean getFg_withdideail() {
		return ((FBoolean) getAttrVal("Fg_withdideail"));
	}
	/**
	 * 是否包含诊断明细
	 * @param Fg_withdideail
	 */
	public void setFg_withdideail(FBoolean Fg_withdideail) {
		setAttrVal("Fg_withdideail", Fg_withdideail);
	}
	/**
	 * 患者卡类型
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}
	/**
	 * 患者卡类型
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 患者卡号
	 * @return String
	 */
	public String getCode_patcard() {
		return ((String) getAttrVal("Code_patcard"));
	}
	/**
	 * 患者卡号
	 * @param Code_patcard
	 */
	public void setCode_patcard(String Code_patcard) {
		setAttrVal("Code_patcard", Code_patcard);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getCiorder_status() {
		return ((String) getAttrVal("Ciorder_status"));
	}
	/**
	 * 医嘱状态
	 * @param Ciorder_status
	 */
	public void setCiorder_status(String Ciorder_status) {
		setAttrVal("Ciorder_status", Ciorder_status);
	}
}