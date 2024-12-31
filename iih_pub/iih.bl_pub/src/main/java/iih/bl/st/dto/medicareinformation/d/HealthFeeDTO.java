package iih.bl.st.dto.medicareinformation.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class HealthFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病历号
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 病历号
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 流水号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 流水号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getCuretype() {
		return ((String) getAttrVal("Curetype"));
	}
	/**
	 * 类型
	 * @param Curetype
	 */
	public void setCuretype(String Curetype) {
		setAttrVal("Curetype", Curetype);
	}
	/**
	 * 交易流水号
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}
	/**
	 * 交易流水号
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * 收费单据号
	 * @return String
	 */
	public String getInvoiceno() {
		return ((String) getAttrVal("Invoiceno"));
	}
	/**
	 * 收费单据号
	 * @param Invoiceno
	 */
	public void setInvoiceno(String Invoiceno) {
		setAttrVal("Invoiceno", Invoiceno);
	}
	/**
	 * 交易日期
	 * @return FDate
	 */
	public FDate getTradedate() {
		return ((FDate) getAttrVal("Tradedate"));
	}
	/**
	 * 交易日期
	 * @param Tradedate
	 */
	public void setTradedate(FDate Tradedate) {
		setAttrVal("Tradedate", Tradedate);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getFeeall() {
		return ((FDouble) getAttrVal("Feeall"));
	}
	/**
	 * 总金额
	 * @param Feeall
	 */
	public void setFeeall(FDouble Feeall) {
		setAttrVal("Feeall", Feeall);
	}
	/**
	 * 基金支付
	 * @return FDouble
	 */
	public FDouble getFund() {
		return ((FDouble) getAttrVal("Fund"));
	}
	/**
	 * 基金支付
	 * @param Fund
	 */
	public void setFund(FDouble Fund) {
		setAttrVal("Fund", Fund);
	}
	/**
	 * 现金支付
	 * @return FDouble
	 */
	public FDouble getCash() {
		return ((FDouble) getAttrVal("Cash"));
	}
	/**
	 * 现金支付
	 * @param Cash
	 */
	public void setCash(FDouble Cash) {
		setAttrVal("Cash", Cash);
	}
	/**
	 * 个人账户支付
	 * @return FDouble
	 */
	public FDouble getAccpay() {
		return ((FDouble) getAttrVal("Accpay"));
	}
	/**
	 * 个人账户支付
	 * @param Accpay
	 */
	public void setAccpay(FDouble Accpay) {
		setAttrVal("Accpay", Accpay);
	}
	/**
	 * 个人账户余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 个人账户余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 费用总金额
	 * @return FDouble
	 */
	public FDouble getMzfee() {
		return ((FDouble) getAttrVal("Mzfee"));
	}
	/**
	 * 费用总金额
	 * @param Mzfee
	 */
	public void setMzfee(FDouble Mzfee) {
		setAttrVal("Mzfee", Mzfee);
	}
	/**
	 * 医保内
	 * @return FDouble
	 */
	public FDouble getMzfeein() {
		return ((FDouble) getAttrVal("Mzfeein"));
	}
	/**
	 * 医保内
	 * @param Mzfeein
	 */
	public void setMzfeein(FDouble Mzfeein) {
		setAttrVal("Mzfeein", Mzfeein);
	}
	/**
	 * 医保外
	 * @return FDouble
	 */
	public FDouble getMzfeeout() {
		return ((FDouble) getAttrVal("Mzfeeout"));
	}
	/**
	 * 医保外
	 * @param Mzfeeout
	 */
	public void setMzfeeout(FDouble Mzfeeout) {
		setAttrVal("Mzfeeout", Mzfeeout);
	}
	/**
	 * 本次付起付线
	 * @return FDouble
	 */
	public FDouble getMzpayfirst() {
		return ((FDouble) getAttrVal("Mzpayfirst"));
	}
	/**
	 * 本次付起付线
	 * @param Mzpayfirst
	 */
	public void setMzpayfirst(FDouble Mzpayfirst) {
		setAttrVal("Mzpayfirst", Mzpayfirst);
	}
	/**
	 * 个人自付2
	 * @return FDouble
	 */
	public FDouble getMzselfpay2() {
		return ((FDouble) getAttrVal("Mzselfpay2"));
	}
	/**
	 * 个人自付2
	 * @param Mzselfpay2
	 */
	public void setMzselfpay2(FDouble Mzselfpay2) {
		setAttrVal("Mzselfpay2", Mzselfpay2);
	}
	/**
	 * 门诊大额支付金额
	 * @return FDouble
	 */
	public FDouble getMzbigpay() {
		return ((FDouble) getAttrVal("Mzbigpay"));
	}
	/**
	 * 门诊大额支付金额
	 * @param Mzbigpay
	 */
	public void setMzbigpay(FDouble Mzbigpay) {
		setAttrVal("Mzbigpay", Mzbigpay);
	}
	/**
	 * 门诊大额自付金额
	 * @return FDouble
	 */
	public FDouble getMzbigselfpay() {
		return ((FDouble) getAttrVal("Mzbigselfpay"));
	}
	/**
	 * 门诊大额自付金额
	 * @param Mzbigselfpay
	 */
	public void setMzbigselfpay(FDouble Mzbigselfpay) {
		setAttrVal("Mzbigselfpay", Mzbigselfpay);
	}
	/**
	 * 超大额自付金额
	 * @return FDouble
	 */
	public FDouble getMzoutofbig() {
		return ((FDouble) getAttrVal("Mzoutofbig"));
	}
	/**
	 * 超大额自付金额
	 * @param Mzoutofbig
	 */
	public void setMzoutofbig(FDouble Mzoutofbig) {
		setAttrVal("Mzoutofbig", Mzoutofbig);
	}
	/**
	 * 补充保险支付金额
	 * @return FDouble
	 */
	public FDouble getBcpay() {
		return ((FDouble) getAttrVal("Bcpay"));
	}
	/**
	 * 补充保险支付金额
	 * @param Bcpay
	 */
	public void setBcpay(FDouble Bcpay) {
		setAttrVal("Bcpay", Bcpay);
	}
	/**
	 * 军残补助保险金额
	 * @return FDouble
	 */
	public FDouble getJcbz() {
		return ((FDouble) getAttrVal("Jcbz"));
	}
	/**
	 * 军残补助保险金额
	 * @param Jcbz
	 */
	public void setJcbz(FDouble Jcbz) {
		setAttrVal("Jcbz", Jcbz);
	}
	/**
	 * 西药
	 * @return FDouble
	 */
	public FDouble getMedicine() {
		return ((FDouble) getAttrVal("Medicine"));
	}
	/**
	 * 西药
	 * @param Medicine
	 */
	public void setMedicine(FDouble Medicine) {
		setAttrVal("Medicine", Medicine);
	}
	/**
	 * 中成药
	 * @return FDouble
	 */
	public FDouble getTmedicine() {
		return ((FDouble) getAttrVal("Tmedicine"));
	}
	/**
	 * 中成药
	 * @param Tmedicine
	 */
	public void setTmedicine(FDouble Tmedicine) {
		setAttrVal("Tmedicine", Tmedicine);
	}
	/**
	 * 中草药
	 * @return FDouble
	 */
	public FDouble getTherb() {
		return ((FDouble) getAttrVal("Therb"));
	}
	/**
	 * 中草药
	 * @param Therb
	 */
	public void setTherb(FDouble Therb) {
		setAttrVal("Therb", Therb);
	}
	/**
	 * 化验
	 * @return FDouble
	 */
	public FDouble getLabexam() {
		return ((FDouble) getAttrVal("Labexam"));
	}
	/**
	 * 化验
	 * @param Labexam
	 */
	public void setLabexam(FDouble Labexam) {
		setAttrVal("Labexam", Labexam);
	}
	/**
	 * 治疗
	 * @return FDouble
	 */
	public FDouble getTreatment() {
		return ((FDouble) getAttrVal("Treatment"));
	}
	/**
	 * 治疗
	 * @param Treatment
	 */
	public void setTreatment(FDouble Treatment) {
		setAttrVal("Treatment", Treatment);
	}
	/**
	 * 诊查
	 * @return FDouble
	 */
	public FDouble getDiagnosis() {
		return ((FDouble) getAttrVal("Diagnosis"));
	}
	/**
	 * 诊查
	 * @param Diagnosis
	 */
	public void setDiagnosis(FDouble Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	/**
	 * 检查
	 * @return FDouble
	 */
	public FDouble getExamine() {
		return ((FDouble) getAttrVal("Examine"));
	}
	/**
	 * 检查
	 * @param Examine
	 */
	public void setExamine(FDouble Examine) {
		setAttrVal("Examine", Examine);
	}
	/**
	 * 手术
	 * @return FDouble
	 */
	public FDouble getOperation() {
		return ((FDouble) getAttrVal("Operation"));
	}
	/**
	 * 手术
	 * @param Operation
	 */
	public void setOperation(FDouble Operation) {
		setAttrVal("Operation", Operation);
	}
	/**
	 * 卫生材料
	 * @return FDouble
	 */
	public FDouble getMaterial() {
		return ((FDouble) getAttrVal("Material"));
	}
	/**
	 * 卫生材料
	 * @param Material
	 */
	public void setMaterial(FDouble Material) {
		setAttrVal("Material", Material);
	}
	/**
	 * 药事服务
	 * @return FDouble
	 */
	public FDouble getMedicalservice() {
		return ((FDouble) getAttrVal("Medicalservice"));
	}
	/**
	 * 药事服务
	 * @param Medicalservice
	 */
	public void setMedicalservice(FDouble Medicalservice) {
		setAttrVal("Medicalservice", Medicalservice);
	}
	/**
	 * 一般诊疗
	 * @return FDouble
	 */
	public FDouble getCommonservice() {
		return ((FDouble) getAttrVal("Commonservice"));
	}
	/**
	 * 一般诊疗
	 * @param Commonservice
	 */
	public void setCommonservice(FDouble Commonservice) {
		setAttrVal("Commonservice", Commonservice);
	}
	/**
	 * 挂号
	 * @return FDouble
	 */
	public FDouble getRegistfee() {
		return ((FDouble) getAttrVal("Registfee"));
	}
	/**
	 * 挂号
	 * @param Registfee
	 */
	public void setRegistfee(FDouble Registfee) {
		setAttrVal("Registfee", Registfee);
	}
	/**
	 * 其他
	 * @return FDouble
	 */
	public FDouble getOther() {
		return ((FDouble) getAttrVal("Other"));
	}
	/**
	 * 其他
	 * @param Other
	 */
	public void setOther(FDouble Other) {
		setAttrVal("Other", Other);
	}
}