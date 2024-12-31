package iih.mi.biz.dto.miorderrecorddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保订单dto DTO数据 
 * 
 */
public class MiOrderRecordDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单id
	 * @return String
	 */
	public String getId_orderrecord() {
		return ((String) getAttrVal("Id_orderrecord"));
	}
	/**
	 * 订单id
	 * @param Id_orderrecord
	 */
	public void setId_orderrecord(String Id_orderrecord) {
		setAttrVal("Id_orderrecord", Id_orderrecord);
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
	 * 医保卡号
	 * @return String
	 */
	public String getHp_no() {
		return ((String) getAttrVal("Hp_no"));
	}
	/**
	 * 医保卡号
	 * @param Hp_no
	 */
	public void setHp_no(String Hp_no) {
		setAttrVal("Hp_no", Hp_no);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	 * 医保登记流水号
	 * @return String
	 */
	public String getRegister_no() {
		return ((String) getAttrVal("Register_no"));
	}
	/**
	 * 医保登记流水号
	 * @param Register_no
	 */
	public void setRegister_no(String Register_no) {
		setAttrVal("Register_no", Register_no);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}
	/**
	 * 医保交易流水号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 是否锁定
	 * @return FBoolean
	 */
	public FBoolean getFg_lock() {
		return ((FBoolean) getAttrVal("Fg_lock"));
	}
	/**
	 * 是否锁定
	 * @param Fg_lock
	 */
	public void setFg_lock(FBoolean Fg_lock) {
		setAttrVal("Fg_lock", Fg_lock);
	}
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 业务状态
	 * @return Integer
	 */
	public Integer getEu_business() {
		return ((Integer) getAttrVal("Eu_business"));
	}
	/**
	 * 业务状态
	 * @param Eu_business
	 */
	public void setEu_business(Integer Eu_business) {
		setAttrVal("Eu_business", Eu_business);
	}
}