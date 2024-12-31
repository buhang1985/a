package iih.bl.st.dto.blpayoep.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收付款结果dto DTO数据 
 * 
 */
public class BlPayOepRltDTO extends BaseDTO {
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
	 * 就诊id集合
	 * @return FArrayList
	 */
	public FArrayList getId_ent() {
		return ((FArrayList) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id集合
	 * @param Id_ent
	 */
	public void setId_ent(FArrayList Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 发票id
	 * @return FArrayList
	 */
	public FArrayList getId_inc() {
		return ((FArrayList) getAttrVal("Id_inc"));
	}
	/**
	 * 发票id
	 * @param Id_inc
	 */
	public void setId_inc(FArrayList Id_inc) {
		setAttrVal("Id_inc", Id_inc);
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
	 * 收付款id
	 * @return String
	 */
	public String getId_paypatoep() {
		return ((String) getAttrVal("Id_paypatoep"));
	}
	/**
	 * 收付款id
	 * @param Id_paypatoep
	 */
	public void setId_paypatoep(String Id_paypatoep) {
		setAttrVal("Id_paypatoep", Id_paypatoep);
	}
	/**
	 * 预交金找零id
	 * @return String
	 */
	public String getId_prepaypat() {
		return ((String) getAttrVal("Id_prepaypat"));
	}
	/**
	 * 预交金找零id
	 * @param Id_prepaypat
	 */
	public void setId_prepaypat(String Id_prepaypat) {
		setAttrVal("Id_prepaypat", Id_prepaypat);
	}
}