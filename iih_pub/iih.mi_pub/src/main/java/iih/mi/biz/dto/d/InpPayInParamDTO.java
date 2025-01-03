package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保结算入参 DTO数据 
 * 
 */
public class InpPayInParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public static final String REDEEMORGNO= "Redeemorgno";
	public static final String CHAREACODE= "Chareacode";
	public static final String INPNO= "Inpno";
	public static final String REDEEMDATE= "Redeemdate";
	public static final String PREINPPAYID= "Preinppayid";
	public static final String INPPAYDATA= "Inppaydata";
	public static final String OPERATOR= "Operator";
	
	/**
	 * 患者参合地区编码
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 患者参合地区编码
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
	/**
	 * 患者住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 患者住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作人
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 兑付日期
	 * @return FDateTime
	 */
	public FDateTime getRedeemdate() {
		return ((FDateTime) getAttrVal("Redeemdate"));
	}
	/**
	 * 兑付日期
	 * @param Redeemdate
	 */
	public void setRedeemdate(FDateTime Redeemdate) {
		setAttrVal("Redeemdate", Redeemdate);
	}
	/**
	 * 补偿机构编码
	 * @return String
	 */
	public String getRedeemorgno() {
		return ((String) getAttrVal("Redeemorgno"));
	}
	/**
	 * 补偿机构编码
	 * @param Redeemorgno
	 */
	public void setRedeemorgno(String Redeemorgno) {
		setAttrVal("Redeemorgno", Redeemorgno);
	}
	/**
	 * 结算入参数据集
	 * @return FArrayList
	 */
	public FArrayList getInppaydata() {
		return ((FArrayList) getAttrVal("Inppaydata"));
	}
	/**
	 * 结算入参数据集
	 * @param Inppaydata
	 */
	public void setInppaydata(FArrayList Inppaydata) {
		setAttrVal("Inppaydata", Inppaydata);
	}
	/**
	 * 预结算流水号（结算确认用）
	 * @return String
	 */
	public String getPreinppayid() {
		return ((String) getAttrVal("Preinppayid"));
	}
	/**
	 * 预结算流水号（结算确认用）
	 * @param Preinppayid
	 */
	public void setPreinppayid(String Preinppayid) {
		setAttrVal("Preinppayid", Preinppayid);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 结算id
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
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
	 * 明细条数
	 * @return Integer
	 */
	public Integer getDetailnums() {
		return ((Integer) getAttrVal("Detailnums"));
	}
	/**
	 * 明细条数
	 * @param Detailnums
	 */
	public void setDetailnums(Integer Detailnums) {
		setAttrVal("Detailnums", Detailnums);
	}
	/**
	 * 明细总金额
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}
	/**
	 * 明细总金额
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 是否使用个人账户
	 * @return FBoolean
	 */
	public FBoolean getPsnacc_flag() {
		return ((FBoolean) getAttrVal("Psnacc_flag"));
	}
	/**
	 * 是否使用个人账户
	 * @param Psnacc_flag
	 */
	public void setPsnacc_flag(FBoolean Psnacc_flag) {
		setAttrVal("Psnacc_flag", Psnacc_flag);
	}
}