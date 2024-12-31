package iih.bl.inc.dto.blecinctrasinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 电子发票显示信息DTO DTO数据 
 * 
 */
public class BlecinctrasInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 电子发票交易记录主键
	 * @return String
	 */
	public String getId_ecinctras() {
		return ((String) getAttrVal("Id_ecinctras"));
	}
	/**
	 * 电子发票交易记录主键
	 * @param Id_ecinctras
	 */
	public void setId_ecinctras(String Id_ecinctras) {
		setAttrVal("Id_ecinctras", Id_ecinctras);
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
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 电子发票类型
	 * @return String
	 */
	public String getEu_inctype() {
		return ((String) getAttrVal("Eu_inctype"));
	}
	/**
	 * 电子发票类型
	 * @param Eu_inctype
	 */
	public void setEu_inctype(String Eu_inctype) {
		setAttrVal("Eu_inctype", Eu_inctype);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getEu_transtype() {
		return ((String) getAttrVal("Eu_transtype"));
	}
	/**
	 * 交易类型
	 * @param Eu_transtype
	 */
	public void setEu_transtype(String Eu_transtype) {
		setAttrVal("Eu_transtype", Eu_transtype);
	}
	/**
	 * 异常信息
	 * @return String
	 */
	public String getErrormsg() {
		return ((String) getAttrVal("Errormsg"));
	}
	/**
	 * 异常信息
	 * @param Errormsg
	 */
	public void setErrormsg(String Errormsg) {
		setAttrVal("Errormsg", Errormsg);
	}
	/**
	 * 选择
	 * @return FBoolean
	 */
	public FBoolean getFg_choose() {
		return ((FBoolean) getAttrVal("Fg_choose"));
	}
	/**
	 * 选择
	 * @param Fg_choose
	 */
	public void setFg_choose(FBoolean Fg_choose) {
		setAttrVal("Fg_choose", Fg_choose);
	}
}