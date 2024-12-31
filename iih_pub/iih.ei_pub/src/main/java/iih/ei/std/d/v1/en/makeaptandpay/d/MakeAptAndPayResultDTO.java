package iih.ei.std.d.v1.en.makeaptandpay.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预约且收取费用出参DTO DTO数据 
 * 
 */
public class MakeAptAndPayResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 号位顺序号
	 * @return String
	 */
	public String getCode_ticket() {
		return ((String) getAttrVal("Code_ticket"));
	}	
	/**
	 * 号位顺序号
	 * @param Code_ticket
	 */
	public void setCode_ticket(String Code_ticket) {
		setAttrVal("Code_ticket", Code_ticket);
	}
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊时间
	 * @return String
	 */
	public String getTime_ent() {
		return ((String) getAttrVal("Time_ent"));
	}	
	/**
	 * 就诊时间
	 * @param Time_ent
	 */
	public void setTime_ent(String Time_ent) {
		setAttrVal("Time_ent", Time_ent);
	}
	/**
	 * 建议提前时间（分钟）
	 * @return String
	 */
	public String getSugest_exmint() {
		return ((String) getAttrVal("Sugest_exmint"));
	}	
	/**
	 * 建议提前时间（分钟）
	 * @param Sugest_exmint
	 */
	public void setSugest_exmint(String Sugest_exmint) {
		setAttrVal("Sugest_exmint", Sugest_exmint);
	}
	/**
	 * 就诊地址
	 * @return String
	 */
	public String getOp_place() {
		return ((String) getAttrVal("Op_place"));
	}	
	/**
	 * 就诊地址
	 * @param Op_place
	 */
	public void setOp_place(String Op_place) {
		setAttrVal("Op_place", Op_place);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getD_entry() {
		return ((String) getAttrVal("D_entry"));
	}	
	/**
	 * 就诊日期
	 * @param D_entry
	 */
	public void setD_entry(String D_entry) {
		setAttrVal("D_entry", D_entry);
	}
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