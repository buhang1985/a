package iih.ci.mr.thirdopen.pkuih.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * mrfpoperationtohisemrforpkudto DTO数据 
 * 
 */
public class MrFpOperationToHisEmrForPkuDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院流水号
	 * @return String
	 */
	public String getIpid() {
		return ((String) getAttrVal("Ipid"));
	}
	/**
	 * 住院流水号
	 * @param Ipid
	 */
	public void setIpid(String Ipid) {
		setAttrVal("Ipid", Ipid);
	}
	/**
	 * 手术及操作编码
	 * @return String
	 */
	public String getOperation_code() {
		return ((String) getAttrVal("Operation_code"));
	}
	/**
	 * 手术及操作编码
	 * @param Operation_code
	 */
	public void setOperation_code(String Operation_code) {
		setAttrVal("Operation_code", Operation_code);
	}
	/**
	 * 手术开始时间
	 * @return FDateTime
	 */
	public FDateTime getOperation_start_time() {
		return ((FDateTime) getAttrVal("Operation_start_time"));
	}
	/**
	 * 手术开始时间
	 * @param Operation_start_time
	 */
	public void setOperation_start_time(FDateTime Operation_start_time) {
		setAttrVal("Operation_start_time", Operation_start_time);
	}
	/**
	 * 手术结束时间
	 * @return FDateTime
	 */
	public FDateTime getOperation_end_time() {
		return ((FDateTime) getAttrVal("Operation_end_time"));
	}
	/**
	 * 手术结束时间
	 * @param Operation_end_time
	 */
	public void setOperation_end_time(FDateTime Operation_end_time) {
		setAttrVal("Operation_end_time", Operation_end_time);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getOp_level() {
		return ((String) getAttrVal("Op_level"));
	}
	/**
	 * 手术级别
	 * @param Op_level
	 */
	public void setOp_level(String Op_level) {
		setAttrVal("Op_level", Op_level);
	}
	/**
	 * 手术及操作名称
	 * @return String
	 */
	public String getOperation_comm() {
		return ((String) getAttrVal("Operation_comm"));
	}
	/**
	 * 手术及操作名称
	 * @param Operation_comm
	 */
	public void setOperation_comm(String Operation_comm) {
		setAttrVal("Operation_comm", Operation_comm);
	}
	/**
	 * 术者
	 * @return String
	 */
	public String getOperator_code() {
		return ((String) getAttrVal("Operator_code"));
	}
	/**
	 * 术者
	 * @param Operator_code
	 */
	public void setOperator_code(String Operator_code) {
		setAttrVal("Operator_code", Operator_code);
	}
	/**
	 * Ⅰ助
	 * @return String
	 */
	public String getFirst_asis() {
		return ((String) getAttrVal("First_asis"));
	}
	/**
	 * Ⅰ助
	 * @param First_asis
	 */
	public void setFirst_asis(String First_asis) {
		setAttrVal("First_asis", First_asis);
	}
	/**
	 * Ⅱ助
	 * @return String
	 */
	public String getSecond_asis() {
		return ((String) getAttrVal("Second_asis"));
	}
	/**
	 * Ⅱ助
	 * @param Second_asis
	 */
	public void setSecond_asis(String Second_asis) {
		setAttrVal("Second_asis", Second_asis);
	}
	/**
	 * 切口愈合等级
	 * @return String
	 */
	public String getCut_heal_grade() {
		return ((String) getAttrVal("Cut_heal_grade"));
	}
	/**
	 * 切口愈合等级
	 * @param Cut_heal_grade
	 */
	public void setCut_heal_grade(String Cut_heal_grade) {
		setAttrVal("Cut_heal_grade", Cut_heal_grade);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getAnaesthesia_methn() {
		return ((String) getAttrVal("Anaesthesia_methn"));
	}
	/**
	 * 麻醉方式
	 * @param Anaesthesia_methn
	 */
	public void setAnaesthesia_methn(String Anaesthesia_methn) {
		setAttrVal("Anaesthesia_methn", Anaesthesia_methn);
	}
	/**
	 * 麻醉师
	 * @return String
	 */
	public String getAnaesthesia_doct() {
		return ((String) getAttrVal("Anaesthesia_doct"));
	}
	/**
	 * 麻醉师
	 * @param Anaesthesia_doct
	 */
	public void setAnaesthesia_doct(String Anaesthesia_doct) {
		setAttrVal("Anaesthesia_doct", Anaesthesia_doct);
	}
	/**
	 * 手术、操作的标志
	 * @return String
	 */
	public String getFlag() {
		return ((String) getAttrVal("Flag"));
	}
	/**
	 * 手术、操作的标志
	 * @param Flag
	 */
	public void setFlag(String Flag) {
		setAttrVal("Flag", Flag);
	}
}