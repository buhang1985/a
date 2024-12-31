package iih.ei.std.d.v1.bl.oppaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收款入参 DTO数据 
 * 
 */
public class OpPayParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 身份证号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 医院编码
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}	
	/**
	 * 医院编码
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 支付方式
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 交易凭证号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 交易凭证号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 订单流水号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单流水号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getBankcardno() {
		return ((String) getAttrVal("Bankcardno"));
	}	
	/**
	 * 银行卡号
	 * @param Bankcardno
	 */
	public void setBankcardno(String Bankcardno) {
		setAttrVal("Bankcardno", Bankcardno);
	}
	/**
	 * 收款金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}	
	/**
	 * 收款金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 终端编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 终端编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 票据类型
	 * @return String
	 */
	public String getInc_type() {
		return ((String) getAttrVal("Inc_type"));
	}	
	/**
	 * 票据类型
	 * @param Inc_type
	 */
	public void setInc_type(String Inc_type) {
		setAttrVal("Inc_type", Inc_type);
	}
	/**
	 * 计算机标识
	 * @return String
	 */
	public String getPcid() {
		return ((String) getAttrVal("Pcid"));
	}	
	/**
	 * 计算机标识
	 * @param Pcid
	 */
	public void setPcid(String Pcid) {
		setAttrVal("Pcid", Pcid);
	}
	/**
	 * 医保产品编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保产品编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 支付顺序号
	 * @return String
	 */
	public String getPayno() {
		return ((String) getAttrVal("Payno"));
	}	
	/**
	 * 支付顺序号
	 * @param Payno
	 */
	public void setPayno(String Payno) {
		setAttrVal("Payno", Payno);
	}
	/**
	 * 门诊收款医保信息
	 * @return String
	 */
	public FArrayList getHpinfo() {
		return ((FArrayList) getAttrVal("Hpinfo"));
	}	
	/**
	 * 门诊收款医保信息
	 * @param Hpinfo
	 */
	public void setHpinfo(FArrayList Hpinfo) {
		setAttrVal("Hpinfo", Hpinfo);
	}
}