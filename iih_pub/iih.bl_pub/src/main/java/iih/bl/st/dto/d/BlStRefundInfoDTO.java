package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlStRefundInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 原收费流水号
	 * @return String
	 */
	public String getId_stoep_old() {
		return ((String) getAttrVal("Id_stoep_old"));
	}
	/**
	 * 原收费流水号
	 * @param Id_stoep_old
	 */
	public void setId_stoep_old(String Id_stoep_old) {
		setAttrVal("Id_stoep_old", Id_stoep_old);
	}
	/**
	 * 新收费流水号
	 * @return String
	 */
	public String getId_stoep_now() {
		return ((String) getAttrVal("Id_stoep_now"));
	}
	/**
	 * 新收费流水号
	 * @param Id_stoep_now
	 */
	public void setId_stoep_now(String Id_stoep_now) {
		setAttrVal("Id_stoep_now", Id_stoep_now);
	}
	/**
	 * 退费日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st_rund() {
		return ((FDateTime) getAttrVal("Dt_st_rund"));
	}
	/**
	 * 退费日期
	 * @param Dt_st_rund
	 */
	public void setDt_st_rund(FDateTime Dt_st_rund) {
		setAttrVal("Dt_st_rund", Dt_st_rund);
	}
	/**
	 * 操作员姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 操作员姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 原收费流水号编码
	 * @return String
	 */
	public String getCode_stoep_old() {
		return ((String) getAttrVal("Code_stoep_old"));
	}
	/**
	 * 原收费流水号编码
	 * @param Code_stoep_old
	 */
	public void setCode_stoep_old(String Code_stoep_old) {
		setAttrVal("Code_stoep_old", Code_stoep_old);
	}
	/**
	 * 新收费流水号编码
	 * @return String
	 */
	public String getCode_stoep_now() {
		return ((String) getAttrVal("Code_stoep_now"));
	}
	/**
	 * 新收费流水号编码
	 * @param Code_stoep_now
	 */
	public void setCode_stoep_now(String Code_stoep_now) {
		setAttrVal("Code_stoep_now", Code_stoep_now);
	}
}