package iih.ei.std.d.v1.bl.oppricingdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊划价入参 DTO数据 
 * 
 */
public class OpPricingParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 身份证号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 医院编码
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}	
	/**
	 * 医院编码
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 医保产品编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保产品编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 门诊划价就诊信息
	 * @return String
	 */
	public FArrayList getEntinfo() {
		return ((FArrayList) getAttrVal("Entinfo"));
	}	
	/**
	 * 门诊划价就诊信息
	 * @param Entinfo
	 */
	public void setEntinfo(FArrayList Entinfo) {
		setAttrVal("Entinfo", Entinfo);
	}
	/**
	 * 门诊划价医保信息
	 * @return String
	 */
	public FArrayList getHpinfo() {
		return ((FArrayList) getAttrVal("Hpinfo"));
	}	
	/**
	 * 门诊划价医保信息
	 * @param Hpinfo
	 */
	public void setHpinfo(FArrayList Hpinfo) {
		setAttrVal("Hpinfo", Hpinfo);
	}
}