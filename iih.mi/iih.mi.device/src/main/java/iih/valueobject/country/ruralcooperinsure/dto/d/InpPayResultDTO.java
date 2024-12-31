package iih.valueobject.country.ruralcooperinsure.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预结算返回结果数据 DTO数据 
 * 
 */
public class InpPayResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * his系统单据编码
	 * @return String
	 */
	public String getBillcode() {
		return ((String) getAttrVal("Billcode"));
	}
	/**
	 * his系统单据编码
	 * @param Billcode
	 */
	public void setBillcode(String Billcode) {
		setAttrVal("Billcode", Billcode);
	}
	/**
	 * 住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 就医机构代码
	 * @return String
	 */
	public String getHospcode() {
		return ((String) getAttrVal("Hospcode"));
	}
	/**
	 * 就医机构代码
	 * @param Hospcode
	 */
	public void setHospcode(String Hospcode) {
		setAttrVal("Hospcode", Hospcode);
	}
	/**
	 * 就医机构名称
	 * @return String
	 */
	public String getHospname() {
		return ((String) getAttrVal("Hospname"));
	}
	/**
	 * 就医机构名称
	 * @param Hospname
	 */
	public void setHospname(String Hospname) {
		setAttrVal("Hospname", Hospname);
	}
	/**
	 * 就医机构级别代码
	 * @return String
	 */
	public String getHosplevelcode() {
		return ((String) getAttrVal("Hosplevelcode"));
	}
	/**
	 * 就医机构级别代码
	 * @param Hosplevelcode
	 */
	public void setHosplevelcode(String Hosplevelcode) {
		setAttrVal("Hosplevelcode", Hosplevelcode);
	}
	/**
	 * 就医机构级别名称
	 * @return String
	 */
	public String getHosplevelname() {
		return ((String) getAttrVal("Hosplevelname"));
	}
	/**
	 * 就医机构级别名称
	 * @param Hosplevelname
	 */
	public void setHosplevelname(String Hosplevelname) {
		setAttrVal("Hosplevelname", Hosplevelname);
	}
	/**
	 * 参合区代码
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 参合区代码
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
	/**
	 * 参合地区名称
	 * @return String
	 */
	public String getChareaname() {
		return ((String) getAttrVal("Chareaname"));
	}
	/**
	 * 参合地区名称
	 * @param Chareaname
	 */
	public void setChareaname(String Chareaname) {
		setAttrVal("Chareaname", Chareaname);
	}
	/**
	 * 个人参合编码
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人参合编码
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 患者身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 患者身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}
	/**
	 * 电话号码
	 * @param Phone
	 */
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	/**
	 * 患者性别代码
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}
	/**
	 * 患者性别代码
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getSexname() {
		return ((String) getAttrVal("Sexname"));
	}
	/**
	 * 患者性别名称
	 * @param Sexname
	 */
	public void setSexname(String Sexname) {
		setAttrVal("Sexname", Sexname);
	}
	/**
	 * 医疗证/卡号
	 * @return String
	 */
	public String getMedicalcode() {
		return ((String) getAttrVal("Medicalcode"));
	}
	/**
	 * 医疗证/卡号
	 * @param Medicalcode
	 */
	public void setMedicalcode(String Medicalcode) {
		setAttrVal("Medicalcode", Medicalcode);
	}
	/**
	 * 就诊类型代码
	 * @return String
	 */
	public String getEnttpcode() {
		return ((String) getAttrVal("Enttpcode"));
	}
	/**
	 * 就诊类型代码
	 * @param Enttpcode
	 */
	public void setEnttpcode(String Enttpcode) {
		setAttrVal("Enttpcode", Enttpcode);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEnttpname() {
		return ((String) getAttrVal("Enttpname"));
	}
	/**
	 * 就诊类型名称
	 * @param Enttpname
	 */
	public void setEnttpname(String Enttpname) {
		setAttrVal("Enttpname", Enttpname);
	}
	/**
	 * 户主
	 * @return String
	 */
	public String getHouseholder() {
		return ((String) getAttrVal("Householder"));
	}
	/**
	 * 户主
	 * @param Householder
	 */
	public void setHouseholder(String Householder) {
		setAttrVal("Householder", Householder);
	}
	/**
	 * 家庭住址
	 * @return String
	 */
	public String getFamilyaddress() {
		return ((String) getAttrVal("Familyaddress"));
	}
	/**
	 * 家庭住址
	 * @param Familyaddress
	 */
	public void setFamilyaddress(String Familyaddress) {
		setAttrVal("Familyaddress", Familyaddress);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 住院号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 入院日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 出院日期
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 主要诊断代码
	 * @return String
	 */
	public String getMaindicode() {
		return ((String) getAttrVal("Maindicode"));
	}
	/**
	 * 主要诊断代码
	 * @param Maindicode
	 */
	public void setMaindicode(String Maindicode) {
		setAttrVal("Maindicode", Maindicode);
	}
	/**
	 * 主要诊断名称
	 * @return String
	 */
	public String getMaindiname() {
		return ((String) getAttrVal("Maindiname"));
	}
	/**
	 * 主要诊断名称
	 * @param Maindiname
	 */
	public void setMaindiname(String Maindiname) {
		setAttrVal("Maindiname", Maindiname);
	}
	/**
	 * 手术名称代码
	 * @return String
	 */
	public String getSurgerycode() {
		return ((String) getAttrVal("Surgerycode"));
	}
	/**
	 * 手术名称代码
	 * @param Surgerycode
	 */
	public void setSurgerycode(String Surgerycode) {
		setAttrVal("Surgerycode", Surgerycode);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getSurgeryname() {
		return ((String) getAttrVal("Surgeryname"));
	}
	/**
	 * 手术名称
	 * @param Surgeryname
	 */
	public void setSurgeryname(String Surgeryname) {
		setAttrVal("Surgeryname", Surgeryname);
	}
	/**
	 * 新农合经办机构代码
	 * @return String
	 */
	public String getAgenciescode() {
		return ((String) getAttrVal("Agenciescode"));
	}
	/**
	 * 新农合经办机构代码
	 * @param Agenciescode
	 */
	public void setAgenciescode(String Agenciescode) {
		setAttrVal("Agenciescode", Agenciescode);
	}
	/**
	 * 新农合经办机构名称
	 * @return String
	 */
	public String getAgenciesname() {
		return ((String) getAttrVal("Agenciesname"));
	}
	/**
	 * 新农合经办机构名称
	 * @param Agenciesname
	 */
	public void setAgenciesname(String Agenciesname) {
		setAttrVal("Agenciesname", Agenciesname);
	}
	/**
	 * 费用总额
	 * @return String
	 */
	public String getAmt_all() {
		return ((String) getAttrVal("Amt_all"));
	}
	/**
	 * 费用总额
	 * @param Amt_all
	 */
	public void setAmt_all(String Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 自付金额
	 * @return String
	 */
	public String getAmt_pat() {
		return ((String) getAttrVal("Amt_pat"));
	}
	/**
	 * 自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(String Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 实际报销总额
	 * @return String
	 */
	public String getHp_amtallactual() {
		return ((String) getAttrVal("Hp_amtallactual"));
	}
	/**
	 * 实际报销总额
	 * @param Hp_amtallactual
	 */
	public void setHp_amtallactual(String Hp_amtallactual) {
		setAttrVal("Hp_amtallactual", Hp_amtallactual);
	}
	/**
	 * 报销（政策）年度
	 * @return String
	 */
	public String getHppolicy() {
		return ((String) getAttrVal("Hppolicy"));
	}
	/**
	 * 报销（政策）年度
	 * @param Hppolicy
	 */
	public void setHppolicy(String Hppolicy) {
		setAttrVal("Hppolicy", Hppolicy);
	}
	/**
	 * 可报销总额
	 * @return String
	 */
	public String getHp_amtall() {
		return ((String) getAttrVal("Hp_amtall"));
	}
	/**
	 * 可报销总额
	 * @param Hp_amtall
	 */
	public void setHp_amtall(String Hp_amtall) {
		setAttrVal("Hp_amtall", Hp_amtall);
	}
	/**
	 * 单病种费用定额
	 * @return String
	 */
	public String getDrgsamt() {
		return ((String) getAttrVal("Drgsamt"));
	}
	/**
	 * 单病种费用定额
	 * @param Drgsamt
	 */
	public void setDrgsamt(String Drgsamt) {
		setAttrVal("Drgsamt", Drgsamt);
	}
	/**
	 * 大病保险可补偿额
	 * @return String
	 */
	public String getBigill_amt() {
		return ((String) getAttrVal("Bigill_amt"));
	}
	/**
	 * 大病保险可补偿额
	 * @param Bigill_amt
	 */
	public void setBigill_amt(String Bigill_amt) {
		setAttrVal("Bigill_amt", Bigill_amt);
	}
	/**
	 * 大病保险实际补偿金额
	 * @return String
	 */
	public String getBigill_amtactual() {
		return ((String) getAttrVal("Bigill_amtactual"));
	}
	/**
	 * 大病保险实际补偿金额
	 * @param Bigill_amtactual
	 */
	public void setBigill_amtactual(String Bigill_amtactual) {
		setAttrVal("Bigill_amtactual", Bigill_amtactual);
	}
	/**
	 * 民政补助补偿额
	 * @return String
	 */
	public String getCivilamt() {
		return ((String) getAttrVal("Civilamt"));
	}
	/**
	 * 民政补助补偿额
	 * @param Civilamt
	 */
	public void setCivilamt(String Civilamt) {
		setAttrVal("Civilamt", Civilamt);
	}
	/**
	 * 整体报销比例
	 * @return String
	 */
	public String getHp_ratio() {
		return ((String) getAttrVal("Hp_ratio"));
	}
	/**
	 * 整体报销比例
	 * @param Hp_ratio
	 */
	public void setHp_ratio(String Hp_ratio) {
		setAttrVal("Hp_ratio", Hp_ratio);
	}
	/**
	 * 本年度累计报销金额
	 * @return String
	 */
	public String getAccumamt_year() {
		return ((String) getAttrVal("Accumamt_year"));
	}
	/**
	 * 本年度累计报销金额
	 * @param Accumamt_year
	 */
	public void setAccumamt_year(String Accumamt_year) {
		setAttrVal("Accumamt_year", Accumamt_year);
	}
	/**
	 * 本年度累计报销次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}
	/**
	 * 本年度累计报销次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 起付线
	 * @return String
	 */
	public String getLower_amt() {
		return ((String) getAttrVal("Lower_amt"));
	}
	/**
	 * 起付线
	 * @param Lower_amt
	 */
	public void setLower_amt(String Lower_amt) {
		setAttrVal("Lower_amt", Lower_amt);
	}
	/**
	 * 封顶线
	 * @return String
	 */
	public String getTop_amt() {
		return ((String) getAttrVal("Top_amt"));
	}
	/**
	 * 封顶线
	 * @param Top_amt
	 */
	public void setTop_amt(String Top_amt) {
		setAttrVal("Top_amt", Top_amt);
	}
	/**
	 * 备注信息
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注信息
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 结算单元
	 * @return String
	 */
	public String getStunitcode() {
		return ((String) getAttrVal("Stunitcode"));
	}
	/**
	 * 结算单元
	 * @param Stunitcode
	 */
	public void setStunitcode(String Stunitcode) {
		setAttrVal("Stunitcode", Stunitcode);
	}
	/**
	 * 结算单元名称
	 * @return String
	 */
	public String getStunitname() {
		return ((String) getAttrVal("Stunitname"));
	}
	/**
	 * 结算单元名称
	 * @param Stunitname
	 */
	public void setStunitname(String Stunitname) {
		setAttrVal("Stunitname", Stunitname);
	}
	/**
	 * 扣减总额
	 * @return String
	 */
	public String getAmtall_deduc() {
		return ((String) getAttrVal("Amtall_deduc"));
	}
	/**
	 * 扣减总额
	 * @param Amtall_deduc
	 */
	public void setAmtall_deduc(String Amtall_deduc) {
		setAttrVal("Amtall_deduc", Amtall_deduc);
	}
	/**
	 * 扣减原因
	 * @return String
	 */
	public String getReason_deduc() {
		return ((String) getAttrVal("Reason_deduc"));
	}
	/**
	 * 扣减原因
	 * @param Reason_deduc
	 */
	public void setReason_deduc(String Reason_deduc) {
		setAttrVal("Reason_deduc", Reason_deduc);
	}
	/**
	 * 垫付总额
	 * @return String
	 */
	public String getAmt_advance() {
		return ((String) getAttrVal("Amt_advance"));
	}
	/**
	 * 垫付总额
	 * @param Amt_advance
	 */
	public void setAmt_advance(String Amt_advance) {
		setAttrVal("Amt_advance", Amt_advance);
	}
	/**
	 * 预结算流水号
	 * @return String
	 */
	public String getPreinppayid() {
		return ((String) getAttrVal("Preinppayid"));
	}
	/**
	 * 预结算流水号
	 * @param Preinppayid
	 */
	public void setPreinppayid(String Preinppayid) {
		setAttrVal("Preinppayid", Preinppayid);
	}
	/**
	 * 扣减明细集合
	 * @return FArrayList
	 */
	public FArrayList getBillitems() {
		return ((FArrayList) getAttrVal("Billitems"));
	}
	/**
	 * 扣减明细集合
	 * @param Billitems
	 */
	public void setBillitems(FArrayList Billitems) {
		setAttrVal("Billitems", Billitems);
	}
}