package iih.bl.inc.blincquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门急诊住院发票明细查询dto DTO数据 
 * 
 */
public class BlincitmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票明细主键
	 * @return String
	 */
	public String getId_incitm() {
		return ((String) getAttrVal("Id_incitm"));
	}
	/**
	 * 发票明细主键
	 * @param Id_incitm
	 */
	public void setId_incitm(String Id_incitm) {
		setAttrVal("Id_incitm", Id_incitm);
	}
	/**
	 * 发票
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}
	/**
	 * 发票
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
	}
	/**
	 * 票据项目类型编码
	 * @return String
	 */
	public String getId_incitmtp() {
		return ((String) getAttrVal("Id_incitmtp"));
	}
	/**
	 * 票据项目类型编码
	 * @param Id_incitmtp
	 */
	public void setId_incitmtp(String Id_incitmtp) {
		setAttrVal("Id_incitmtp", Id_incitmtp);
	}
	/**
	 * 票据项目类型
	 * @return String
	 */
	public String getSd_incitmtp() {
		return ((String) getAttrVal("Sd_incitmtp"));
	}
	/**
	 * 票据项目类型
	 * @param Sd_incitmtp
	 */
	public void setSd_incitmtp(String Sd_incitmtp) {
		setAttrVal("Sd_incitmtp", Sd_incitmtp);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 项目金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 项目金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 项目金额_个人支付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 项目金额_个人支付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBlincitmtpname() {
		return ((String) getAttrVal("Blincitmtpname"));
	}
	/**
	 * 名称
	 * @param Blincitmtpname
	 */
	public void setBlincitmtpname(String Blincitmtpname) {
		setAttrVal("Blincitmtpname", Blincitmtpname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBlincitmtpcode() {
		return ((String) getAttrVal("Blincitmtpcode"));
	}
	/**
	 * 编码
	 * @param Blincitmtpcode
	 */
	public void setBlincitmtpcode(String Blincitmtpcode) {
		setAttrVal("Blincitmtpcode", Blincitmtpcode);
	}
}