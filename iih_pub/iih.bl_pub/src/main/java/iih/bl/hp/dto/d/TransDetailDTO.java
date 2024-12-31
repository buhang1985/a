package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保交易主表 DTO数据 
 * 
 */
public class TransDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易编号
	 * @return String
	 */
	public String getCode_business() {
		return ((String) getAttrVal("Code_business"));
	}
	/**
	 * 交易编号
	 * @param Code_business
	 */
	public void setCode_business(String Code_business) {
		setAttrVal("Code_business", Code_business);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 交易状态
	 * @return String
	 */
	public String getTrans_status() {
		return ((String) getAttrVal("Trans_status"));
	}
	/**
	 * 交易状态
	 * @param Trans_status
	 */
	public void setTrans_status(String Trans_status) {
		setAttrVal("Trans_status", Trans_status);
	}
	/**
	 * 交易时间
	 * @return FDateTime
	 */
	public FDateTime getDt_transact() {
		return ((FDateTime) getAttrVal("Dt_transact"));
	}
	/**
	 * 交易时间
	 * @param Dt_transact
	 */
	public void setDt_transact(FDateTime Dt_transact) {
		setAttrVal("Dt_transact", Dt_transact);
	}
	/**
	 * 操作人员主键
	 * @return String
	 */
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}
	/**
	 * 操作人员主键
	 * @param Id_emp_opr
	 */
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
	}
	/**
	 * 操作人员名称
	 * @return String
	 */
	public String getName_emp_opr() {
		return ((String) getAttrVal("Name_emp_opr"));
	}
	/**
	 * 操作人员名称
	 * @param Name_emp_opr
	 */
	public void setName_emp_opr(String Name_emp_opr) {
		setAttrVal("Name_emp_opr", Name_emp_opr);
	}
	/**
	 * 操作人员编码
	 * @return String
	 */
	public String getCode_name_opr() {
		return ((String) getAttrVal("Code_name_opr"));
	}
	/**
	 * 操作人员编码
	 * @param Code_name_opr
	 */
	public void setCode_name_opr(String Code_name_opr) {
		setAttrVal("Code_name_opr", Code_name_opr);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getBill_code() {
		return ((String) getAttrVal("Bill_code"));
	}
	/**
	 * 单据号
	 * @param Bill_code
	 */
	public void setBill_code(String Bill_code) {
		setAttrVal("Bill_code", Bill_code);
	}
	/**
	 * 就诊流水号医保相关
	 * @return String
	 */
	public String getEnt_no() {
		return ((String) getAttrVal("Ent_no"));
	}
	/**
	 * 就诊流水号医保相关
	 * @param Ent_no
	 */
	public void setEnt_no(String Ent_no) {
		setAttrVal("Ent_no", Ent_no);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Code_medkind
	 */
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	/**
	 * 医疗类别名称
	 * @return String
	 */
	public String getName_medkind() {
		return ((String) getAttrVal("Name_medkind"));
	}
	/**
	 * 医疗类别名称
	 * @param Name_medkind
	 */
	public void setName_medkind(String Name_medkind) {
		setAttrVal("Name_medkind", Name_medkind);
	}
	/**
	 * 交易主表主键
	 * @return String
	 */
	public String getId_transactneusoftah() {
		return ((String) getAttrVal("Id_transactneusoftah"));
	}
	/**
	 * 交易主表主键
	 * @param Id_transactneusoftah
	 */
	public void setId_transactneusoftah(String Id_transactneusoftah) {
		setAttrVal("Id_transactneusoftah", Id_transactneusoftah);
	}
}