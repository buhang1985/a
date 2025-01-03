package iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice;

import java.io.Serializable;
import java.util.List;

/**
 * 电子票据开具门诊发票信息
 * @author ly 2019/12/31
 *
 */
public class EcInvoiceOpParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String busNo;//业务流水号
	private String busType;//业务标识
	private String payer;//患者姓名
	private String busDateTime;//业务发生时间
	private String placeCode;//开票点编码
	private String payee;//收费员
	private String author;//票据编制人
	private Double totalAmt;//开票总金额
	private String remark;//备注
	private String alipayCode;//患者支付宝账户
	private String weChatOrderNo;//微信支付订单号
	private String tel;//患者手机号码
	private String email;//患者邮箱地址
	private String idCardNo;//患者身份证号码
	private String cardType;//卡类型
	private String cardNo;//卡号
	private String medicalInstitution;//医疗机构类型
	private String medCareInstitution;//医保机构编码
	private String medicalCareType;//医保类型名称
	private String medCareTypeCode;//医保类型编码
	private String medicalInsuranceID;//患者医保编号
	private String consultationDate;//就诊日期
	private String category;//就诊科室
	private String patientCategoryCode;//就诊科室编码
	private String patientNo;//患者门诊号
	private String patientId;//患者唯一ID
	private String sex;//性别
	private String age;//年龄
	private String caseNumber;//病历号
	private String specialDiseasesName;//特殊病种名称
	private Double accountPay;//个人账户支付
	private Double fundPay;//医保统筹基金支付
	private Double otherfundPay;//其它医保支付
	private Double ownPay;//自费金额
	private Double selfConceitedAmt;//个人自负
	private Double selfPayAmt;//个人自付
	private Double selfCashPay;//个人现金支付
	private Double cashPay;//现金预交款金额
	private Double chequePay;//支票预交款金额
	private Double transferAccountPay;//转账预交款金额
	private Double cashRecharge;//补交金额(现金)
	private Double chequeRecharge;//补交金额(支票)
	private Double transferRecharge;//补交金额（转账）
	private Double cashRefund;//退还金额(现金)
	private Double chequeRefund;//退交金额(支票)
	private Double transferRefund;//退交金额(转账)
	private Double ownAcBalance;//个人账户余额
	
	private List<EcInvoiceOtherInfoParam> otherInfo;//其它扩展信息列表
	private List<EcInvoiceHpInfoParam> otherMedicalList;//其它医保信息列表
	private List<EcInvoicePayInfoParam> payChannelDetail;//交费渠道列表
	private String eBillRelateNo;//业务票据关联号
	private String isArrears;//是否可流通
	private String arrearsReason;//不可流通原因
	private List<EcInvoiceIncItmParam> chargeDetail;//收费项目明细
	private List<EcInvoiceCgItmParam> listDetail;//清单项目明细
	
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getBusDateTime() {
		return busDateTime;
	}
	public void setBusDateTime(String busDateTime) {
		this.busDateTime = busDateTime;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAlipayCode() {
		return alipayCode;
	}
	public void setAlipayCode(String alipayCode) {
		this.alipayCode = alipayCode;
	}
	public String getWeChatOrderNo() {
		return weChatOrderNo;
	}
	public void setWeChatOrderNo(String weChatOrderNo) {
		this.weChatOrderNo = weChatOrderNo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getMedicalInstitution() {
		return medicalInstitution;
	}
	public void setMedicalInstitution(String medicalInstitution) {
		this.medicalInstitution = medicalInstitution;
	}
	public String getMedCareInstitution() {
		return medCareInstitution;
	}
	public void setMedCareInstitution(String medCareInstitution) {
		this.medCareInstitution = medCareInstitution;
	}
	public String getMedicalCareType() {
		return medicalCareType;
	}
	public void setMedicalCareType(String medicalCareType) {
		this.medicalCareType = medicalCareType;
	}
	public String getMedCareTypeCode() {
		return medCareTypeCode;
	}
	public void setMedCareTypeCode(String medCareTypeCode) {
		this.medCareTypeCode = medCareTypeCode;
	}
	public String getMedicalInsuranceID() {
		return medicalInsuranceID;
	}
	public void setMedicalInsuranceID(String medicalInsuranceID) {
		this.medicalInsuranceID = medicalInsuranceID;
	}
	public String getConsultationDate() {
		return consultationDate;
	}
	public void setConsultationDate(String consultationDate) {
		this.consultationDate = consultationDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPatientCategoryCode() {
		return patientCategoryCode;
	}
	public void setPatientCategoryCode(String patientCategoryCode) {
		this.patientCategoryCode = patientCategoryCode;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getSpecialDiseasesName() {
		return specialDiseasesName;
	}
	public void setSpecialDiseasesName(String specialDiseasesName) {
		this.specialDiseasesName = specialDiseasesName;
	}
	public Double getAccountPay() {
		return accountPay;
	}
	public void setAccountPay(Double accountPay) {
		this.accountPay = accountPay;
	}
	public Double getFundPay() {
		return fundPay;
	}
	public void setFundPay(Double fundPay) {
		this.fundPay = fundPay;
	}
	public Double getOtherfundPay() {
		return otherfundPay;
	}
	public void setOtherfundPay(Double otherfundPay) {
		this.otherfundPay = otherfundPay;
	}
	public Double getOwnPay() {
		return ownPay;
	}
	public void setOwnPay(Double ownPay) {
		this.ownPay = ownPay;
	}
	public Double getSelfConceitedAmt() {
		return selfConceitedAmt;
	}
	public void setSelfConceitedAmt(Double selfConceitedAmt) {
		this.selfConceitedAmt = selfConceitedAmt;
	}
	public Double getSelfPayAmt() {
		return selfPayAmt;
	}
	public void setSelfPayAmt(Double selfPayAmt) {
		this.selfPayAmt = selfPayAmt;
	}
	public Double getSelfCashPay() {
		return selfCashPay;
	}
	public void setSelfCashPay(Double selfCashPay) {
		this.selfCashPay = selfCashPay;
	}
	public Double getCashPay() {
		return cashPay;
	}
	public void setCashPay(Double cashPay) {
		this.cashPay = cashPay;
	}
	public Double getChequePay() {
		return chequePay;
	}
	public void setChequePay(Double chequePay) {
		this.chequePay = chequePay;
	}
	public Double getTransferAccountPay() {
		return transferAccountPay;
	}
	public void setTransferAccountPay(Double transferAccountPay) {
		this.transferAccountPay = transferAccountPay;
	}
	public Double getCashRecharge() {
		return cashRecharge;
	}
	public void setCashRecharge(Double cashRecharge) {
		this.cashRecharge = cashRecharge;
	}
	public Double getChequeRecharge() {
		return chequeRecharge;
	}
	public void setChequeRecharge(Double chequeRecharge) {
		this.chequeRecharge = chequeRecharge;
	}
	public Double getTransferRecharge() {
		return transferRecharge;
	}
	public void setTransferRecharge(Double transferRecharge) {
		this.transferRecharge = transferRecharge;
	}
	public Double getCashRefund() {
		return cashRefund;
	}
	public void setCashRefund(Double cashRefund) {
		this.cashRefund = cashRefund;
	}
	public Double getChequeRefund() {
		return chequeRefund;
	}
	public void setChequeRefund(Double chequeRefund) {
		this.chequeRefund = chequeRefund;
	}
	public Double getTransferRefund() {
		return transferRefund;
	}
	public void setTransferRefund(Double transferRefund) {
		this.transferRefund = transferRefund;
	}
	public Double getOwnAcBalance() {
		return ownAcBalance;
	}
	public void setOwnAcBalance(Double ownAcBalance) {
		this.ownAcBalance = ownAcBalance;
	}
	public List<EcInvoiceOtherInfoParam> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<EcInvoiceOtherInfoParam> otherInfo) {
		this.otherInfo = otherInfo;
	}
	public List<EcInvoiceHpInfoParam> getOtherMedicalList() {
		return otherMedicalList;
	}
	public void setOtherMedicalList(List<EcInvoiceHpInfoParam> otherMedicalList) {
		this.otherMedicalList = otherMedicalList;
	}
	public List<EcInvoicePayInfoParam> getPayChannelDetail() {
		return payChannelDetail;
	}
	public void setPayChannelDetail(List<EcInvoicePayInfoParam> payChannelDetail) {
		this.payChannelDetail = payChannelDetail;
	}
	public String geteBillRelateNo() {
		return eBillRelateNo;
	}
	public void seteBillRelateNo(String eBillRelateNo) {
		this.eBillRelateNo = eBillRelateNo;
	}
	public String getIsArrears() {
		return isArrears;
	}
	public void setIsArrears(String isArrears) {
		this.isArrears = isArrears;
	}
	public String getArrearsReason() {
		return arrearsReason;
	}
	public void setArrearsReason(String arrearsReason) {
		this.arrearsReason = arrearsReason;
	}
	public List<EcInvoiceIncItmParam> getChargeDetail() {
		return chargeDetail;
	}
	public void setChargeDetail(List<EcInvoiceIncItmParam> chargeDetail) {
		this.chargeDetail = chargeDetail;
	}
	public List<EcInvoiceCgItmParam> getListDetail() {
		return listDetail;
	}
	public void setListDetail(List<EcInvoiceCgItmParam> listDetail) {
		this.listDetail = listDetail;
	}
}
