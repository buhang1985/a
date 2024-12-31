package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 社商结算信息表 DTO数据 
 * 
 */
public class BusSt4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 保险交易流水号
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}
	/**
	 * 保险交易流水号
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * 医保应用号
	 * @return String
	 */
	public String getHealthcardno() {
		return ((String) getAttrVal("Healthcardno"));
	}
	/**
	 * 医保应用号
	 * @param Healthcardno
	 */
	public void setHealthcardno(String Healthcardno) {
		setAttrVal("Healthcardno", Healthcardno);
	}
	/**
	 * 医保是否已结算
	 * @return String
	 */
	public String getHascalculated() {
		return ((String) getAttrVal("Hascalculated"));
	}
	/**
	 * 医保是否已结算
	 * @param Hascalculated
	 */
	public void setHascalculated(String Hascalculated) {
		setAttrVal("Hascalculated", Hascalculated);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatientname() {
		return ((String) getAttrVal("Patientname"));
	}
	/**
	 * 患者姓名
	 * @param Patientname
	 */
	public void setPatientname(String Patientname) {
		setAttrVal("Patientname", Patientname);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 社保号/商保号
	 * @return String
	 */
	public String getSscardno() {
		return ((String) getAttrVal("Sscardno"));
	}
	/**
	 * 社保号/商保号
	 * @param Sscardno
	 */
	public void setSscardno(String Sscardno) {
		setAttrVal("Sscardno", Sscardno);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getMedicaltype() {
		return ((String) getAttrVal("Medicaltype"));
	}
	/**
	 * 医疗类别
	 * @param Medicaltype
	 */
	public void setMedicaltype(String Medicaltype) {
		setAttrVal("Medicaltype", Medicaltype);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getCardtype() {
		return ((String) getAttrVal("Cardtype"));
	}
	/**
	 * 证件类型
	 * @param Cardtype
	 */
	public void setCardtype(String Cardtype) {
		setAttrVal("Cardtype", Cardtype);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCardno() {
		return ((String) getAttrVal("Cardno"));
	}
	/**
	 * 证件号码
	 * @param Cardno
	 */
	public void setCardno(String Cardno) {
		setAttrVal("Cardno", Cardno);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdate() {
		return ((FDate) getAttrVal("Birthdate"));
	}
	/**
	 * 出生日期
	 * @param Birthdate
	 */
	public void setBirthdate(FDate Birthdate) {
		setAttrVal("Birthdate", Birthdate);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getYydm() {
		return ((String) getAttrVal("Yydm"));
	}
	/**
	 * 医疗机构编码
	 * @param Yydm
	 */
	public void setYydm(String Yydm) {
		setAttrVal("Yydm", Yydm);
	}
	/**
	 * 医院名称
	 * @return String
	 */
	public String getYymc() {
		return ((String) getAttrVal("Yymc"));
	}
	/**
	 * 医院名称
	 * @param Yymc
	 */
	public void setYymc(String Yymc) {
		setAttrVal("Yymc", Yymc);
	}
	/**
	 * 就诊方式
	 * @return String
	 */
	public String getJzfs() {
		return ((String) getAttrVal("Jzfs"));
	}
	/**
	 * 就诊方式
	 * @param Jzfs
	 */
	public void setJzfs(String Jzfs) {
		setAttrVal("Jzfs", Jzfs);
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
	 * 就诊/住院开始日期
	 * @return FDateTime
	 */
	public FDateTime getJzstartdate() {
		return ((FDateTime) getAttrVal("Jzstartdate"));
	}
	/**
	 * 就诊/住院开始日期
	 * @param Jzstartdate
	 */
	public void setJzstartdate(FDateTime Jzstartdate) {
		setAttrVal("Jzstartdate", Jzstartdate);
	}
	/**
	 * 就诊/住院结束日期
	 * @return FDateTime
	 */
	public FDateTime getJzenddate() {
		return ((FDateTime) getAttrVal("Jzenddate"));
	}
	/**
	 * 就诊/住院结束日期
	 * @param Jzenddate
	 */
	public void setJzenddate(FDateTime Jzenddate) {
		setAttrVal("Jzenddate", Jzenddate);
	}
	/**
	 * 收费员
	 * @return String
	 */
	public String getCollector() {
		return ((String) getAttrVal("Collector"));
	}
	/**
	 * 收费员
	 * @param Collector
	 */
	public void setCollector(String Collector) {
		setAttrVal("Collector", Collector);
	}
	/**
	 * 收费时间
	 * @return FDateTime
	 */
	public FDateTime getCharge_time() {
		return ((FDateTime) getAttrVal("Charge_time"));
	}
	/**
	 * 收费时间
	 * @param Charge_time
	 */
	public void setCharge_time(FDateTime Charge_time) {
		setAttrVal("Charge_time", Charge_time);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getBatchno() {
		return ((String) getAttrVal("Batchno"));
	}
	/**
	 * 批次号
	 * @param Batchno
	 */
	public void setBatchno(String Batchno) {
		setAttrVal("Batchno", Batchno);
	}
	/**
	 * 费用总金额
	 * @return String
	 */
	public String getTotalpayamount() {
		return ((String) getAttrVal("Totalpayamount"));
	}
	/**
	 * 费用总金额
	 * @param Totalpayamount
	 */
	public void setTotalpayamount(String Totalpayamount) {
		setAttrVal("Totalpayamount", Totalpayamount);
	}
	/**
	 * 责任代码
	 * @return String
	 */
	public String getDutycode() {
		return ((String) getAttrVal("Dutycode"));
	}
	/**
	 * 责任代码
	 * @param Dutycode
	 */
	public void setDutycode(String Dutycode) {
		setAttrVal("Dutycode", Dutycode);
	}
	/**
	 * 个人账户支付金额
	 * @return FDouble
	 */
	public FDouble getPersonalpayamount() {
		return ((FDouble) getAttrVal("Personalpayamount"));
	}
	/**
	 * 个人账户支付金额
	 * @param Personalpayamount
	 */
	public void setPersonalpayamount(FDouble Personalpayamount) {
		setAttrVal("Personalpayamount", Personalpayamount);
	}
	/**
	 * 个人账户余额
	 * @return FDouble
	 */
	public FDouble getRemainamount() {
		return ((FDouble) getAttrVal("Remainamount"));
	}
	/**
	 * 个人账户余额
	 * @param Remainamount
	 */
	public void setRemainamount(FDouble Remainamount) {
		setAttrVal("Remainamount", Remainamount);
	}
	/**
	 * 门诊大额支付金额
	 * @return FDouble
	 */
	public FDouble getOpbigpaymount() {
		return ((FDouble) getAttrVal("Opbigpaymount"));
	}
	/**
	 * 门诊大额支付金额
	 * @param Opbigpaymount
	 */
	public void setOpbigpaymount(FDouble Opbigpaymount) {
		setAttrVal("Opbigpaymount", Opbigpaymount);
	}
	/**
	 * 门诊大额自付金额（自付一）
	 * @return FDouble
	 */
	public FDouble getOpselfpayamount() {
		return ((FDouble) getAttrVal("Opselfpayamount"));
	}
	/**
	 * 门诊大额自付金额（自付一）
	 * @param Opselfpayamount
	 */
	public void setOpselfpayamount(FDouble Opselfpayamount) {
		setAttrVal("Opselfpayamount", Opselfpayamount);
	}
	/**
	 * 超大额自付金额
	 * @return FDouble
	 */
	public FDouble getBigselfpayamount() {
		return ((FDouble) getAttrVal("Bigselfpayamount"));
	}
	/**
	 * 超大额自付金额
	 * @param Bigselfpayamount
	 */
	public void setBigselfpayamount(FDouble Bigselfpayamount) {
		setAttrVal("Bigselfpayamount", Bigselfpayamount);
	}
	/**
	 * 医保内总金额
	 * @return FDouble
	 */
	public FDouble getInsuranceamount() {
		return ((FDouble) getAttrVal("Insuranceamount"));
	}
	/**
	 * 医保内总金额
	 * @param Insuranceamount
	 */
	public void setInsuranceamount(FDouble Insuranceamount) {
		setAttrVal("Insuranceamount", Insuranceamount);
	}
	/**
	 * 医保外总金额
	 * @return FDouble
	 */
	public FDouble getOutinsuranceamount() {
		return ((FDouble) getAttrVal("Outinsuranceamount"));
	}
	/**
	 * 医保外总金额
	 * @param Outinsuranceamount
	 */
	public void setOutinsuranceamount(FDouble Outinsuranceamount) {
		setAttrVal("Outinsuranceamount", Outinsuranceamount);
	}
	/**
	 * 补充保险支付金额
	 * @return FDouble
	 */
	public FDouble getAddinsurancepayayamount() {
		return ((FDouble) getAttrVal("Addinsurancepayayamount"));
	}
	/**
	 * 补充保险支付金额
	 * @param Addinsurancepayayamount
	 */
	public void setAddinsurancepayayamount(FDouble Addinsurancepayayamount) {
		setAttrVal("Addinsurancepayayamount", Addinsurancepayayamount);
	}
	/**
	 * 军残补助保险金额
	 * @return FDouble
	 */
	public FDouble getResidualpayamount() {
		return ((FDouble) getAttrVal("Residualpayamount"));
	}
	/**
	 * 军残补助保险金额
	 * @param Residualpayamount
	 */
	public void setResidualpayamount(FDouble Residualpayamount) {
		setAttrVal("Residualpayamount", Residualpayamount);
	}
	/**
	 * 个人自付二
	 * @return FDouble
	 */
	public FDouble getSelfpayamount2() {
		return ((FDouble) getAttrVal("Selfpayamount2"));
	}
	/**
	 * 个人自付二
	 * @param Selfpayamount2
	 */
	public void setSelfpayamount2(FDouble Selfpayamount2) {
		setAttrVal("Selfpayamount2", Selfpayamount2);
	}
	/**
	 * 本次付起付线金额
	 * @return FDouble
	 */
	public FDouble getBeginpayamount() {
		return ((FDouble) getAttrVal("Beginpayamount"));
	}
	/**
	 * 本次付起付线金额
	 * @param Beginpayamount
	 */
	public void setBeginpayamount(FDouble Beginpayamount) {
		setAttrVal("Beginpayamount", Beginpayamount);
	}
	/**
	 * 是否按照单病种结算
	 * @return String
	 */
	public String getIssingleill() {
		return ((String) getAttrVal("Issingleill"));
	}
	/**
	 * 是否按照单病种结算
	 * @param Issingleill
	 */
	public void setIssingleill(String Issingleill) {
		setAttrVal("Issingleill", Issingleill);
	}
	/**
	 * 基金支付金额
	 * @return String
	 */
	public String getFundpayamount() {
		return ((String) getAttrVal("Fundpayamount"));
	}
	/**
	 * 基金支付金额
	 * @param Fundpayamount
	 */
	public void setFundpayamount(String Fundpayamount) {
		setAttrVal("Fundpayamount", Fundpayamount);
	}
	/**
	 * 个人支付金额
	 * @return String
	 */
	public String getCashpayamount() {
		return ((String) getAttrVal("Cashpayamount"));
	}
	/**
	 * 个人支付金额
	 * @param Cashpayamount
	 */
	public void setCashpayamount(String Cashpayamount) {
		setAttrVal("Cashpayamount", Cashpayamount);
	}
	/**
	 * 自费
	 * @return String
	 */
	public String getSelfpay() {
		return ((String) getAttrVal("Selfpay"));
	}
	/**
	 * 自费
	 * @param Selfpay
	 */
	public void setSelfpay(String Selfpay) {
		setAttrVal("Selfpay", Selfpay);
	}
	/**
	 * 医院减免
	 * @return String
	 */
	public String getHospitalbreaks() {
		return ((String) getAttrVal("Hospitalbreaks"));
	}
	/**
	 * 医院减免
	 * @param Hospitalbreaks
	 */
	public void setHospitalbreaks(String Hospitalbreaks) {
		setAttrVal("Hospitalbreaks", Hospitalbreaks);
	}
	/**
	 * 西药
	 * @return String
	 */
	public String getXyao() {
		return ((String) getAttrVal("Xyao"));
	}
	/**
	 * 西药
	 * @param Xyao
	 */
	public void setXyao(String Xyao) {
		setAttrVal("Xyao", Xyao);
	}
	/**
	 * 中成药
	 * @return String
	 */
	public String getZchyao() {
		return ((String) getAttrVal("Zchyao"));
	}
	/**
	 * 中成药
	 * @param Zchyao
	 */
	public void setZchyao(String Zchyao) {
		setAttrVal("Zchyao", Zchyao);
	}
	/**
	 * 中草药
	 * @return String
	 */
	public String getZcyao() {
		return ((String) getAttrVal("Zcyao"));
	}
	/**
	 * 中草药
	 * @param Zcyao
	 */
	public void setZcyao(String Zcyao) {
		setAttrVal("Zcyao", Zcyao);
	}
	/**
	 * 检查费
	 * @return String
	 */
	public String getExaminecost() {
		return ((String) getAttrVal("Examinecost"));
	}
	/**
	 * 检查费
	 * @param Examinecost
	 */
	public void setExaminecost(String Examinecost) {
		setAttrVal("Examinecost", Examinecost);
	}
	/**
	 * 放射
	 * @return String
	 */
	public String getRadiate() {
		return ((String) getAttrVal("Radiate"));
	}
	/**
	 * 放射
	 * @param Radiate
	 */
	public void setRadiate(String Radiate) {
		setAttrVal("Radiate", Radiate);
	}
	/**
	 * B超
	 * @return String
	 */
	public String getBultrasonic() {
		return ((String) getAttrVal("Bultrasonic"));
	}
	/**
	 * B超
	 * @param Bultrasonic
	 */
	public void setBultrasonic(String Bultrasonic) {
		setAttrVal("Bultrasonic", Bultrasonic);
	}
	/**
	 * 核磁
	 * @return String
	 */
	public String getNmr() {
		return ((String) getAttrVal("Nmr"));
	}
	/**
	 * 核磁
	 * @param Nmr
	 */
	public void setNmr(String Nmr) {
		setAttrVal("Nmr", Nmr);
	}
	/**
	 * 治疗费
	 * @return String
	 */
	public String getTestcost() {
		return ((String) getAttrVal("Testcost"));
	}
	/**
	 * 治疗费
	 * @param Testcost
	 */
	public void setTestcost(String Testcost) {
		setAttrVal("Testcost", Testcost);
	}
	/**
	 * 材料费
	 * @return String
	 */
	public String getMaterialscost() {
		return ((String) getAttrVal("Materialscost"));
	}
	/**
	 * 材料费
	 * @param Materialscost
	 */
	public void setMaterialscost(String Materialscost) {
		setAttrVal("Materialscost", Materialscost);
	}
	/**
	 * 手术费
	 * @return String
	 */
	public String getOperationcost() {
		return ((String) getAttrVal("Operationcost"));
	}
	/**
	 * 手术费
	 * @param Operationcost
	 */
	public void setOperationcost(String Operationcost) {
		setAttrVal("Operationcost", Operationcost);
	}
	/**
	 * 输氧费
	 * @return String
	 */
	public String getOxygencost() {
		return ((String) getAttrVal("Oxygencost"));
	}
	/**
	 * 输氧费
	 * @param Oxygencost
	 */
	public void setOxygencost(String Oxygencost) {
		setAttrVal("Oxygencost", Oxygencost);
	}
	/**
	 * 输血费
	 * @return String
	 */
	public String getBloodcost() {
		return ((String) getAttrVal("Bloodcost"));
	}
	/**
	 * 输血费
	 * @param Bloodcost
	 */
	public void setBloodcost(String Bloodcost) {
		setAttrVal("Bloodcost", Bloodcost);
	}
	/**
	 * 正畸费
	 * @return String
	 */
	public String getOrthodonticcost() {
		return ((String) getAttrVal("Orthodonticcost"));
	}
	/**
	 * 正畸费
	 * @param Orthodonticcost
	 */
	public void setOrthodonticcost(String Orthodonticcost) {
		setAttrVal("Orthodonticcost", Orthodonticcost);
	}
	/**
	 * 镶牙费
	 * @return String
	 */
	public String getInserttoothcost() {
		return ((String) getAttrVal("Inserttoothcost"));
	}
	/**
	 * 镶牙费
	 * @param Inserttoothcost
	 */
	public void setInserttoothcost(String Inserttoothcost) {
		setAttrVal("Inserttoothcost", Inserttoothcost);
	}
	/**
	 * 司法鉴定
	 * @return String
	 */
	public String getSfjdcost() {
		return ((String) getAttrVal("Sfjdcost"));
	}
	/**
	 * 司法鉴定
	 * @param Sfjdcost
	 */
	public void setSfjdcost(String Sfjdcost) {
		setAttrVal("Sfjdcost", Sfjdcost);
	}
	/**
	 * 其他项目
	 * @return String
	 */
	public String getOthercost() {
		return ((String) getAttrVal("Othercost"));
	}
	/**
	 * 其他项目
	 * @param Othercost
	 */
	public void setOthercost(String Othercost) {
		setAttrVal("Othercost", Othercost);
	}
	/**
	 * 诊察费
	 * @return String
	 */
	public String getDiagnosticcost() {
		return ((String) getAttrVal("Diagnosticcost"));
	}
	/**
	 * 诊察费
	 * @param Diagnosticcost
	 */
	public void setDiagnosticcost(String Diagnosticcost) {
		setAttrVal("Diagnosticcost", Diagnosticcost);
	}
	/**
	 * 化验费
	 * @return String
	 */
	public String getTreatcost() {
		return ((String) getAttrVal("Treatcost"));
	}
	/**
	 * 化验费
	 * @param Treatcost
	 */
	public void setTreatcost(String Treatcost) {
		setAttrVal("Treatcost", Treatcost);
	}
	/**
	 * 医事服务费
	 * @return String
	 */
	public String getMedicalservcost() {
		return ((String) getAttrVal("Medicalservcost"));
	}
	/**
	 * 医事服务费
	 * @param Medicalservcost
	 */
	public void setMedicalservcost(String Medicalservcost) {
		setAttrVal("Medicalservcost", Medicalservcost);
	}
	/**
	 * 一般诊疗费
	 * @return String
	 */
	public String getConsultationcost() {
		return ((String) getAttrVal("Consultationcost"));
	}
	/**
	 * 一般诊疗费
	 * @param Consultationcost
	 */
	public void setConsultationcost(String Consultationcost) {
		setAttrVal("Consultationcost", Consultationcost);
	}
	/**
	 * 挂号费
	 * @return String
	 */
	public String getRegistrationcost() {
		return ((String) getAttrVal("Registrationcost"));
	}
	/**
	 * 挂号费
	 * @param Registrationcost
	 */
	public void setRegistrationcost(String Registrationcost) {
		setAttrVal("Registrationcost", Registrationcost);
	}
	/**
	 * 其他门诊收费
	 * @return String
	 */
	public String getOthermzcost() {
		return ((String) getAttrVal("Othermzcost"));
	}
	/**
	 * 其他门诊收费
	 * @param Othermzcost
	 */
	public void setOthermzcost(String Othermzcost) {
		setAttrVal("Othermzcost", Othermzcost);
	}
	/**
	 * 是否退费
	 * @return String
	 */
	public String getIsbackcost() {
		return ((String) getAttrVal("Isbackcost"));
	}
	/**
	 * 是否退费
	 * @param Isbackcost
	 */
	public void setIsbackcost(String Isbackcost) {
		setAttrVal("Isbackcost", Isbackcost);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreateuserid() {
		return ((String) getAttrVal("Createuserid"));
	}
	/**
	 * 创建人
	 * @param Createuserid
	 */
	public void setCreateuserid(String Createuserid) {
		setAttrVal("Createuserid", Createuserid);
	}
	/**
	 * 创建时间
	 * @return String
	 */
	public String getCreatedate() {
		return ((String) getAttrVal("Createdate"));
	}
	/**
	 * 创建时间
	 * @param Createdate
	 */
	public void setCreatedate(String Createdate) {
		setAttrVal("Createdate", Createdate);
	}
	/**
	 * 更新人
	 * @return String
	 */
	public String getUpdateuserid() {
		return ((String) getAttrVal("Updateuserid"));
	}
	/**
	 * 更新人
	 * @param Updateuserid
	 */
	public void setUpdateuserid(String Updateuserid) {
		setAttrVal("Updateuserid", Updateuserid);
	}
	/**
	 * 更新时间
	 * @return String
	 */
	public String getUpdatedate() {
		return ((String) getAttrVal("Updatedate"));
	}
	/**
	 * 更新时间
	 * @param Updatedate
	 */
	public void setUpdatedate(String Updatedate) {
		setAttrVal("Updatedate", Updatedate);
	}
	/**
	 * 更新状态
	 * @return String
	 */
	public String getUpflag() {
		return ((String) getAttrVal("Upflag"));
	}
	/**
	 * 更新状态
	 * @param Upflag
	 */
	public void setUpflag(String Upflag) {
		setAttrVal("Upflag", Upflag);
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