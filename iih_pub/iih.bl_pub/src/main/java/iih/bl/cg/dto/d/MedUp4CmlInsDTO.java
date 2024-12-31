package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗费用上传信息表 DTO数据 
 * 
 */
public class MedUp4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * HIS费用明细ID
	 * @return String
	 */
	public String getHisfymxid() {
		return ((String) getAttrVal("Hisfymxid"));
	}
	/**
	 * HIS费用明细ID
	 * @param Hisfymxid
	 */
	public void setHisfymxid(String Hisfymxid) {
		setAttrVal("Hisfymxid", Hisfymxid);
	}
	/**
	 * 付款方类别
	 * @return String
	 */
	public String getPay_type() {
		return ((String) getAttrVal("Pay_type"));
	}
	/**
	 * 付款方类别
	 * @param Pay_type
	 */
	public void setPay_type(String Pay_type) {
		setAttrVal("Pay_type", Pay_type);
	}
	/**
	 * 保险地区代码
	 * @return String
	 */
	public String getRegion_code() {
		return ((String) getAttrVal("Region_code"));
	}
	/**
	 * 保险地区代码
	 * @param Region_code
	 */
	public void setRegion_code(String Region_code) {
		setAttrVal("Region_code", Region_code);
	}
	/**
	 * 保险机构代码
	 * @return String
	 */
	public String getOrganization_id() {
		return ((String) getAttrVal("Organization_id"));
	}
	/**
	 * 保险机构代码
	 * @param Organization_id
	 */
	public void setOrganization_id(String Organization_id) {
		setAttrVal("Organization_id", Organization_id);
	}
	/**
	 * 保险交易流水号
	 * @return String
	 */
	public String getBxtradeno() {
		return ((String) getAttrVal("Bxtradeno"));
	}
	/**
	 * 保险交易流水号
	 * @param Bxtradeno
	 */
	public void setBxtradeno(String Bxtradeno) {
		setAttrVal("Bxtradeno", Bxtradeno);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPid() {
		return ((String) getAttrVal("Pid"));
	}
	/**
	 * 患者ID
	 * @param Pid
	 */
	public void setPid(String Pid) {
		setAttrVal("Pid", Pid);
	}
	/**
	 * 医保项目类别
	 * @return String
	 */
	public String getItemtype() {
		return ((String) getAttrVal("Itemtype"));
	}
	/**
	 * 医保项目类别
	 * @param Itemtype
	 */
	public void setItemtype(String Itemtype) {
		setAttrVal("Itemtype", Itemtype);
	}
	/**
	 * 医保收费类别
	 * @return String
	 */
	public String getChargetype() {
		return ((String) getAttrVal("Chargetype"));
	}
	/**
	 * 医保收费类别
	 * @param Chargetype
	 */
	public void setChargetype(String Chargetype) {
		setAttrVal("Chargetype", Chargetype);
	}
	/**
	 * 医保项目编码
	 * @return String
	 */
	public String getYbitemcode() {
		return ((String) getAttrVal("Ybitemcode"));
	}
	/**
	 * 医保项目编码
	 * @param Ybitemcode
	 */
	public void setYbitemcode(String Ybitemcode) {
		setAttrVal("Ybitemcode", Ybitemcode);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getYbitemname() {
		return ((String) getAttrVal("Ybitemname"));
	}
	/**
	 * 医保项目名称
	 * @param Ybitemname
	 */
	public void setYbitemname(String Ybitemname) {
		setAttrVal("Ybitemname", Ybitemname);
	}
	/**
	 * 费用分组
	 * @return String
	 */
	public String getCharge_group() {
		return ((String) getAttrVal("Charge_group"));
	}
	/**
	 * 费用分组
	 * @param Charge_group
	 */
	public void setCharge_group(String Charge_group) {
		setAttrVal("Charge_group", Charge_group);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 数量
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getToatlamount() {
		return ((FDouble) getAttrVal("Toatlamount"));
	}
	/**
	 * 金额
	 * @param Toatlamount
	 */
	public void setToatlamount(FDouble Toatlamount) {
		setAttrVal("Toatlamount", Toatlamount);
	}
	/**
	 * 上传人
	 * @return String
	 */
	public String getSend_opera() {
		return ((String) getAttrVal("Send_opera"));
	}
	/**
	 * 上传人
	 * @param Send_opera
	 */
	public void setSend_opera(String Send_opera) {
		setAttrVal("Send_opera", Send_opera);
	}
	/**
	 * 上传时间
	 * @return FDateTime
	 */
	public FDateTime getSenddate() {
		return ((FDateTime) getAttrVal("Senddate"));
	}
	/**
	 * 上传时间
	 * @param Senddate
	 */
	public void setSenddate(FDateTime Senddate) {
		setAttrVal("Senddate", Senddate);
	}
	/**
	 * 保险内金额
	 * @return FDouble
	 */
	public FDouble getInsurance_amount() {
		return ((FDouble) getAttrVal("Insurance_amount"));
	}
	/**
	 * 保险内金额
	 * @param Insurance_amount
	 */
	public void setInsurance_amount(FDouble Insurance_amount) {
		setAttrVal("Insurance_amount", Insurance_amount);
	}
	/**
	 * 保险外金额
	 * @return FDouble
	 */
	public FDouble getOut_insurance_amount() {
		return ((FDouble) getAttrVal("Out_insurance_amount"));
	}
	/**
	 * 保险外金额
	 * @param Out_insurance_amount
	 */
	public void setOut_insurance_amount(FDouble Out_insurance_amount) {
		setAttrVal("Out_insurance_amount", Out_insurance_amount);
	}
	/**
	 * 个人自付二
	 * @return FDouble
	 */
	public FDouble getPersonal_pay_two() {
		return ((FDouble) getAttrVal("Personal_pay_two"));
	}
	/**
	 * 个人自付二
	 * @param Personal_pay_two
	 */
	public void setPersonal_pay_two(FDouble Personal_pay_two) {
		setAttrVal("Personal_pay_two", Personal_pay_two);
	}
	/**
	 * 分解状态
	 * @return String
	 */
	public String getAnalyze_stute() {
		return ((String) getAttrVal("Analyze_stute"));
	}
	/**
	 * 分解状态
	 * @param Analyze_stute
	 */
	public void setAnalyze_stute(String Analyze_stute) {
		setAttrVal("Analyze_stute", Analyze_stute);
	}
	/**
	 * 项目号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}
	/**
	 * 项目号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getRecipeno() {
		return ((String) getAttrVal("Recipeno"));
	}
	/**
	 * 处方号
	 * @param Recipeno
	 */
	public void setRecipeno(String Recipeno) {
		setAttrVal("Recipeno", Recipeno);
	}
	/**
	 * HIS项目编码
	 * @return String
	 */
	public String getHiscode() {
		return ((String) getAttrVal("Hiscode"));
	}
	/**
	 * HIS项目编码
	 * @param Hiscode
	 */
	public void setHiscode(String Hiscode) {
		setAttrVal("Hiscode", Hiscode);
	}
	/**
	 * HIS项目名称
	 * @return String
	 */
	public String getHisname() {
		return ((String) getAttrVal("Hisname"));
	}
	/**
	 * HIS项目名称
	 * @param Hisname
	 */
	public void setHisname(String Hisname) {
		setAttrVal("Hisname", Hisname);
	}
	/**
	 * HIS交易流水号(一次结算的唯一号）
	 * @return String
	 */
	public String getHistradeno() {
		return ((String) getAttrVal("Histradeno"));
	}
	/**
	 * HIS交易流水号(一次结算的唯一号）
	 * @param Histradeno
	 */
	public void setHistradeno(String Histradeno) {
		setAttrVal("Histradeno", Histradeno);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getVisit_no() {
		return ((String) getAttrVal("Visit_no"));
	}
	/**
	 * 就诊号
	 * @param Visit_no
	 */
	public void setVisit_no(String Visit_no) {
		setAttrVal("Visit_no", Visit_no);
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
}