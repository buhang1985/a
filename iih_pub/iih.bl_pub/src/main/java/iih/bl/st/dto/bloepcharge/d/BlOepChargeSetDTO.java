package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费配置dto DTO数据 
 * 
 */
public class BlOepChargeSetDTO extends BaseDTO {
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
	 * 医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 医保结算类型id
	 * @return String
	 */
	public String getId_hpsttp() {
		return ((String) getAttrVal("Id_hpsttp"));
	}
	/**
	 * 医保结算类型id
	 * @param Id_hpsttp
	 */
	public void setId_hpsttp(String Id_hpsttp) {
		setAttrVal("Id_hpsttp", Id_hpsttp);
	}
	/**
	 * 医保结算类型sd
	 * @return String
	 */
	public String getSd_hpsttp() {
		return ((String) getAttrVal("Sd_hpsttp"));
	}
	/**
	 * 医保结算类型sd
	 * @param Sd_hpsttp
	 */
	public void setSd_hpsttp(String Sd_hpsttp) {
		setAttrVal("Sd_hpsttp", Sd_hpsttp);
	}
	/**
	 * 是否计算服务价格
	 * @return FBoolean
	 */
	public FBoolean getFg_calprice() {
		return ((FBoolean) getAttrVal("Fg_calprice"));
	}
	/**
	 * 是否计算服务价格
	 * @param Fg_calprice
	 */
	public void setFg_calprice(FBoolean Fg_calprice) {
		setAttrVal("Fg_calprice", Fg_calprice);
	}
	/**
	 * 收费人员
	 * @return String
	 */
	public String getId_emp_charge() {
		return ((String) getAttrVal("Id_emp_charge"));
	}
	/**
	 * 收费人员
	 * @param Id_emp_charge
	 */
	public void setId_emp_charge(String Id_emp_charge) {
		setAttrVal("Id_emp_charge", Id_emp_charge);
	}
	/**
	 * 费用来源
	 * @return Integer
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}
	/**
	 * 费用来源
	 * @param Eu_srctp
	 */
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Id_medkind
	 */
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}
}