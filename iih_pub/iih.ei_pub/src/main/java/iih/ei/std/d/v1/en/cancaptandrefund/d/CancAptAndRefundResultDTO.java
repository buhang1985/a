package iih.ei.std.d.v1.en.cancaptandrefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取消预约并退费出参DTO DTO数据 
 * 
 */
public class CancAptAndRefundResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算id
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 结算流水号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算流水号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 结算时间
	 * @return String
	 */
	public String getDt_st() {
		return ((String) getAttrVal("Dt_st"));
	}
	/**
	 * 结算时间
	 * @param Dt_st
	 */
	public void setDt_st(String Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
}