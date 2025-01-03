package iih.ei.bl.ecinc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 电子票据红冲票据入参 DTO数据 
 * 
 */
public class EcIncBlFlowRedInvoiceInDTO extends BaseDTO {
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
	 * 原结算id
	 * @return String
	 */
	public String getId_st_old() {
		return ((String) getAttrVal("Id_st_old"));
	}
	/**
	 * 原结算id
	 * @param Id_st_old
	 */
	public void setId_st_old(String Id_st_old) {
		setAttrVal("Id_st_old", Id_st_old);
	}
	/**
	 * 原发票id
	 * @return String
	 */
	public String getId_inc_old() {
		return ((String) getAttrVal("Id_inc_old"));
	}
	/**
	 * 原发票id
	 * @param Id_inc_old
	 */
	public void setId_inc_old(String Id_inc_old) {
		setAttrVal("Id_inc_old", Id_inc_old);
	}
	/**
	 * 红冲结算id
	 * @return String
	 */
	public String getId_st_red() {
		return ((String) getAttrVal("Id_st_red"));
	}
	/**
	 * 红冲结算id
	 * @param Id_st_red
	 */
	public void setId_st_red(String Id_st_red) {
		setAttrVal("Id_st_red", Id_st_red);
	}
	/**
	 * 红冲发票id
	 * @return String
	 */
	public String getId_inc_red() {
		return ((String) getAttrVal("Id_inc_red"));
	}
	/**
	 * 红冲发票id
	 * @param Id_inc_red
	 */
	public void setId_inc_red(String Id_inc_red) {
		setAttrVal("Id_inc_red", Id_inc_red);
	}
	/**
	 * 电子发票代码
	 * @return String
	 */
	public String getEcinc_code() {
		return ((String) getAttrVal("Ecinc_code"));
	}
	/**
	 * 电子发票代码
	 * @param Ecinc_code
	 */
	public void setEcinc_code(String Ecinc_code) {
		setAttrVal("Ecinc_code", Ecinc_code);
	}
	/**
	 * 电子发票号
	 * @return String
	 */
	public String getEcincno() {
		return ((String) getAttrVal("Ecincno"));
	}
	/**
	 * 电子发票号
	 * @param Ecincno
	 */
	public void setEcincno(String Ecincno) {
		setAttrVal("Ecincno", Ecincno);
	}
	/**
	 * 红冲原因
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}
	/**
	 * 红冲原因
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 票据类型
	 * @return String
	 */
	public String getInctype() {
		return ((String) getAttrVal("Inctype"));
	}
	/**
	 * 票据类型
	 * @param Inctype
	 */
	public void setInctype(String Inctype) {
		setAttrVal("Inctype", Inctype);
	}
}