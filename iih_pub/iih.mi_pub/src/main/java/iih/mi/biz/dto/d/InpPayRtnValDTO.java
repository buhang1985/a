package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 住院预结算返回值DTO DTO数据 
 * 
 */
public class InpPayRtnValDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public static final String DT_END= "Dt_end";
	public static final String DT_SUPPLY= "Dt_supply";
	public static final String LAST_LARGETOTAL= "Last_largetotal";
	public static final String BIGILLSUPPLYINSURE_FEE= "Bigillsupplyinsure_fee";
	public static final String BLOOD_FEE= "Blood_fee";
	public static final String SURGERYNAME= "Surgeryname";
	public static final String TOP_AMT= "Top_amt";
	public static final String AMT_INHP= "Amt_inhp";
	public static final String MAINDINAME= "Maindiname";
	public static final String AMT_EXECRXSELF= "Amt_execrxself";
	public static final String ANTIDRUG_FEE= "Antidrug_fee";
	public static final String AMT_DEDUCTIBLEPAYSELF= "Amt_deductiblepayself";
	public static final String AMT_OFFICERSUPPLY= "Amt_officersupply";
	public static final String FAMILYADDRESS= "Familyaddress";
	public static final String SEXCODE= "Sexcode";
	public static final String AMT_ZGDBYLFY= "Amt_zgdbylfy";
	public static final String HOSPLEVELCODE= "Hosplevelcode";
	public static final String AMT_HPSEGSELF= "Amt_hpsegself";
	public static final String CODE_HPPATCA= "Code_hppatca";
	public static final String HOSPLEVELNAME= "Hosplevelname";
	public static final String ENT_CODE= "Ent_code";
	public static final String LAST_HPCHARGETOTAL= "Last_hpchargetotal";
	public static final String HOUSEHOLDER= "Householder";
	public static final String BIGILL_AMT= "Bigill_amt";
	public static final String BILLITEMS= "Billitems";
	public static final String AMT_CIVILSELFPAY= "Amt_civilselfpay";
	public static final String SURGERYCODE= "Surgerycode";
	public static final String AMT_OVERTOPSELF= "Amt_overtopself";
	public static final String AMT_CASH= "Amt_cash";
	public static final String REASON_DEDUC= "Reason_deduc";
	public static final String DI_CODE= "Di_code";
	public static final String AMT_INCIVIL= "Amt_incivil";
	public static final String LOWER_AMT= "Lower_amt";
	public static final String ENTTPCODE= "Enttpcode";
	public static final String AMTALL_DEDUC= "Amtall_deduc";
	public static final String AMT_SELFPAY= "Amt_selfpay";
	public static final String MAINDICODE= "Maindicode";
	public static final String TIMES= "Times";
	public static final String AGENCIESNAME= "Agenciesname";
	public static final String HP_AMTALLACTUAL= "Hp_amtallactual";
	public static final String TJGB_CIVILSUBSIDY= "Tjgb_civilsubsidy";
	public static final String NOTE= "Note";
	public static final String CHAREANAME= "Chareaname";
	public static final String OVERTOP_HOSBURDEN= "Overtop_hosburden";
	public static final String CHRONICBALANCE= "Chronicbalance";
	public static final String BIGILL_AMTACTUAL= "Bigill_amtactual";
	public static final String ENTTPNAME= "Enttpname";
	public static final String SPECSUPPLY= "Specsupply";
	public static final String CIVILAMT= "Civilamt";
	public static final String HP_AMTALL= "Hp_amtall";
	public static final String AMT_HP= "Amt_hp";
	public static final String AMT_OVERLIMITHOS= "Amt_overlimithos";
	public static final String DI_NAME= "Di_name";
	public static final String STUNITCODE= "Stunitcode";
	public static final String PHONE= "Phone";
	public static final String INPNO= "Inpno";
	public static final String AMT_PAT= "Amt_pat";
	public static final String AMT_ADVANCE= "Amt_advance";
	public static final String AMT_INBIGILLCOMPLEALL= "Amt_inbigillcompleall";
	public static final String AMT_YPZL= "Amt_ypzl";
	public static final String SUPPLY_NOTE= "Supply_note";
	public static final String AMT_BASEALL= "Amt_baseall";
	public static final String STUNITNAME= "Stunitname";
	public static final String MEDICALCODE= "Medicalcode";
	public static final String HP_RATIO= "Hp_ratio";
	public static final String BIGILLINSURE_FEE= "Bigillinsure_fee";
	public static final String PATNAME= "Patname";
	public static final String SENDERSERIALNO= "Senderserialno";
	public static final String IDCARD= "Idcard";
	public static final String AMT_CIVILSERVICE= "Amt_civilservice";
	public static final String HPPOLICY= "Hppolicy";
	public static final String AGENCIESCODE= "Agenciescode";
	public static final String WIFEOFMALEWORKER_NAME= "Wifeofmaleworker_name";
	public static final String CHAREACODE= "Chareacode";
	public static final String AMT_PAYSTAND= "Amt_paystand";
	public static final String AMT_HOSLOAD= "Amt_hosload";
	public static final String HOSPNAME= "Hospname";
	public static final String EXAMINEBEAR_FEE= "Examinebear_fee";
	public static final String AREACODE= "Areacode";
	public static final String AMT_OEPOVERHP= "Amt_oepoverhp";
	public static final String AMT_SPECCOMPLE= "Amt_speccomple";
	public static final String AMT_ENTERPRISESUPP= "Amt_enterprisesupp";
	public static final String AMT_ALL= "Amt_all";
	public static final String HOSPCODE= "Hospcode";
	public static final String AMT_PSN= "Amt_psn";
	public static final String AMT_XMZL= "Amt_xmzl";
	public static final String IP_TIMES= "Ip_times";
	public static final String CODE_MEDKIND= "Code_medkind";
	public static final String BILLCODE= "Billcode";
	public static final String AMT_OVERLIMITSELF= "Amt_overlimitself";
	public static final String PREINPPAYID= "Preinppayid";
	public static final String AMT_INBIGILLCOMPLE= "Amt_inbigillcomple";
	public static final String AMT_BIGILLCOMPLEFUNDALL= "Amt_bigillcomplefundall";
	public static final String DRGSAMT= "Drgsamt";
	public static final String AMT_SERIOUSILL= "Amt_seriousill";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String AMT_BIGILLCOMPLEFUND= "Amt_bigillcomplefund";
	public static final String PERSONCODE= "Personcode";
	public static final String AMT_INCOMPLEMEDI= "Amt_incomplemedi";
	public static final String SEXNAME= "Sexname";
	public static final String ACCUMAMT_YEAR= "Accumamt_year";
	public static final String AMT_TJTZZL= "Amt_tjtzzl";
	public static final String NAME_MZJZ= "Name_mzjz";
	
	/**
	 * 原始返回结算数据
	 * @return FArrayList
	 */
	public FArrayList getOripropdata() {
		return ((FArrayList) getAttrVal("Oripropdata"));
	}
	/**
	 * 原始返回结算数据
	 * @param Oripropdata
	 */
	public void setOripropdata(FArrayList Oripropdata) {
		setAttrVal("Oripropdata", Oripropdata);
	}
	
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
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 费用总额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 实际报销总额
	 * @return FDouble
	 */
	public FDouble getHp_amtallactual() {
		return ((FDouble) getAttrVal("Hp_amtallactual"));
	}
	/**
	 * 实际报销总额
	 * @param Hp_amtallactual
	 */
	public void setHp_amtallactual(FDouble Hp_amtallactual) {
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
	 * 单病种费用定额
	 * @return FDouble
	 */
	public FDouble getDrgsamt() {
		return ((FDouble) getAttrVal("Drgsamt"));
	}
	/**
	 * 单病种费用定额
	 * @param Drgsamt
	 */
	public void setDrgsamt(FDouble Drgsamt) {
		setAttrVal("Drgsamt", Drgsamt);
	}
	/**
	 * 可报销总额
	 * @return FDouble
	 */
	public FDouble getHp_amtall() {
		return ((FDouble) getAttrVal("Hp_amtall"));
	}
	/**
	 * 可报销总额
	 * @param Hp_amtall
	 */
	public void setHp_amtall(FDouble Hp_amtall) {
		setAttrVal("Hp_amtall", Hp_amtall);
	}
	/**
	 * 大病保险可补偿额
	 * @return FDouble
	 */
	public FDouble getBigill_amt() {
		return ((FDouble) getAttrVal("Bigill_amt"));
	}
	/**
	 * 大病保险可补偿额
	 * @param Bigill_amt
	 */
	public void setBigill_amt(FDouble Bigill_amt) {
		setAttrVal("Bigill_amt", Bigill_amt);
	}
	/**
	 * 大病保险实际补偿金额
	 * @return FDouble
	 */
	public FDouble getBigill_amtactual() {
		return ((FDouble) getAttrVal("Bigill_amtactual"));
	}
	/**
	 * 大病保险实际补偿金额
	 * @param Bigill_amtactual
	 */
	public void setBigill_amtactual(FDouble Bigill_amtactual) {
		setAttrVal("Bigill_amtactual", Bigill_amtactual);
	}
	/**
	 * 整体报销比例
	 * @return FDouble
	 */
	public FDouble getHp_ratio() {
		return ((FDouble) getAttrVal("Hp_ratio"));
	}
	/**
	 * 整体报销比例
	 * @param Hp_ratio
	 */
	public void setHp_ratio(FDouble Hp_ratio) {
		setAttrVal("Hp_ratio", Hp_ratio);
	}
	/**
	 * 民政补助补偿额
	 * @return FDouble
	 */
	public FDouble getCivilamt() {
		return ((FDouble) getAttrVal("Civilamt"));
	}
	/**
	 * 民政补助补偿额
	 * @param Civilamt
	 */
	public void setCivilamt(FDouble Civilamt) {
		setAttrVal("Civilamt", Civilamt);
	}
	/**
	 * 本年度累计报销金额
	 * @return FDouble
	 */
	public FDouble getAccumamt_year() {
		return ((FDouble) getAttrVal("Accumamt_year"));
	}
	/**
	 * 本年度累计报销金额
	 * @param Accumamt_year
	 */
	public void setAccumamt_year(FDouble Accumamt_year) {
		setAttrVal("Accumamt_year", Accumamt_year);
	}
	/**
	 * 本年度累计报销次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 本年度累计报销次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 起付线
	 * @return FDouble
	 */
	public FDouble getLower_amt() {
		return ((FDouble) getAttrVal("Lower_amt"));
	}
	/**
	 * 起付线
	 * @param Lower_amt
	 */
	public void setLower_amt(FDouble Lower_amt) {
		setAttrVal("Lower_amt", Lower_amt);
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
	 * 封顶线
	 * @return FDouble
	 */
	public FDouble getTop_amt() {
		return ((FDouble) getAttrVal("Top_amt"));
	}
	/**
	 * 封顶线
	 * @param Top_amt
	 */
	public void setTop_amt(FDouble Top_amt) {
		setAttrVal("Top_amt", Top_amt);
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
	 * @return FDouble
	 */
	public FDouble getAmtall_deduc() {
		return ((FDouble) getAttrVal("Amtall_deduc"));
	}
	/**
	 * 扣减总额
	 * @param Amtall_deduc
	 */
	public void setAmtall_deduc(FDouble Amtall_deduc) {
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
	 * @return FDouble
	 */
	public FDouble getAmt_advance() {
		return ((FDouble) getAttrVal("Amt_advance"));
	}
	/**
	 * 垫付总额
	 * @param Amt_advance
	 */
	public void setAmt_advance(FDouble Amt_advance) {
		setAttrVal("Amt_advance", Amt_advance);
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
	 * 补偿日期
	 * @return FDateTime
	 */
	public FDateTime getDt_supply() {
		return ((FDateTime) getAttrVal("Dt_supply"));
	}
	/**
	 * 补偿日期
	 * @param Dt_supply
	 */
	public void setDt_supply(FDateTime Dt_supply) {
		setAttrVal("Dt_supply", Dt_supply);
	}
	/**
	 * 补偿信息说明
	 * @return String
	 */
	public String getSupply_note() {
		return ((String) getAttrVal("Supply_note"));
	}
	/**
	 * 补偿信息说明
	 * @param Supply_note
	 */
	public void setSupply_note(String Supply_note) {
		setAttrVal("Supply_note", Supply_note);
	}
	/**
	 * 医院承担的超出限额部分费用
	 * @return FDouble
	 */
	public FDouble getOvertop_hosburden() {
		return ((FDouble) getAttrVal("Overtop_hosburden"));
	}
	/**
	 * 医院承担的超出限额部分费用
	 * @param Overtop_hosburden
	 */
	public void setOvertop_hosburden(FDouble Overtop_hosburden) {
		setAttrVal("Overtop_hosburden", Overtop_hosburden);
	}
	/**
	 * 特殊补偿标识
	 * @return String
	 */
	public String getSpecsupply() {
		return ((String) getAttrVal("Specsupply"));
	}
	/**
	 * 特殊补偿标识
	 * @param Specsupply
	 */
	public void setSpecsupply(String Specsupply) {
		setAttrVal("Specsupply", Specsupply);
	}
	/**
	 * 抗感染药物费用
	 * @return FDouble
	 */
	public FDouble getAntidrug_fee() {
		return ((FDouble) getAttrVal("Antidrug_fee"));
	}
	/**
	 * 抗感染药物费用
	 * @param Antidrug_fee
	 */
	public void setAntidrug_fee(FDouble Antidrug_fee) {
		setAttrVal("Antidrug_fee", Antidrug_fee);
	}
	/**
	 * 血液制品费用
	 * @return FDouble
	 */
	public FDouble getBlood_fee() {
		return ((FDouble) getAttrVal("Blood_fee"));
	}
	/**
	 * 血液制品费用
	 * @param Blood_fee
	 */
	public void setBlood_fee(FDouble Blood_fee) {
		setAttrVal("Blood_fee", Blood_fee);
	}
	/**
	 * 大病保险补偿费用
	 * @return FDouble
	 */
	public FDouble getBigillinsure_fee() {
		return ((FDouble) getAttrVal("Bigillinsure_fee"));
	}
	/**
	 * 大病保险补偿费用
	 * @param Bigillinsure_fee
	 */
	public void setBigillinsure_fee(FDouble Bigillinsure_fee) {
		setAttrVal("Bigillinsure_fee", Bigillinsure_fee);
	}
	/**
	 * 大病补充保险补偿费用
	 * @return FDouble
	 */
	public FDouble getBigillsupplyinsure_fee() {
		return ((FDouble) getAttrVal("Bigillsupplyinsure_fee"));
	}
	/**
	 * 大病补充保险补偿费用
	 * @param Bigillsupplyinsure_fee
	 */
	public void setBigillsupplyinsure_fee(FDouble Bigillsupplyinsure_fee) {
		setAttrVal("Bigillsupplyinsure_fee", Bigillsupplyinsure_fee);
	}
	/**
	 * 本次账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}
	/**
	 * 本次账户支付
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 统筹支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 统筹支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 大病救助基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_seriousill() {
		return ((FDouble) getAttrVal("Amt_seriousill"));
	}
	/**
	 * 大病救助基金支付
	 * @param Amt_seriousill
	 */
	public void setAmt_seriousill(FDouble Amt_seriousill) {
		setAttrVal("Amt_seriousill", Amt_seriousill);
	}
	/**
	 * 公务员补助金额
	 * @return FDouble
	 */
	public FDouble getAmt_civilservice() {
		return ((FDouble) getAttrVal("Amt_civilservice"));
	}
	/**
	 * 公务员补助金额
	 * @param Amt_civilservice
	 */
	public void setAmt_civilservice(FDouble Amt_civilservice) {
		setAttrVal("Amt_civilservice", Amt_civilservice);
	}
	/**
	 * 企业补充基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_enterprisesupp() {
		return ((FDouble) getAttrVal("Amt_enterprisesupp"));
	}
	/**
	 * 企业补充基金支付
	 * @param Amt_enterprisesupp
	 */
	public void setAmt_enterprisesupp(FDouble Amt_enterprisesupp) {
		setAttrVal("Amt_enterprisesupp", Amt_enterprisesupp);
	}
	/**
	 * 本次现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}
	/**
	 * 本次现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 自费费用
	 * @return FDouble
	 */
	public FDouble getAmt_selfpay() {
		return ((FDouble) getAttrVal("Amt_selfpay"));
	}
	/**
	 * 自费费用
	 * @param Amt_selfpay
	 */
	public void setAmt_selfpay(FDouble Amt_selfpay) {
		setAttrVal("Amt_selfpay", Amt_selfpay);
	}
	/**
	 * 乙类项目自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_xmzl() {
		return ((FDouble) getAttrVal("Amt_xmzl"));
	}
	/**
	 * 乙类项目自理费用
	 * @param Amt_xmzl
	 */
	public void setAmt_xmzl(FDouble Amt_xmzl) {
		setAttrVal("Amt_xmzl", Amt_xmzl);
	}
	/**
	 * 乙类药品自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_ypzl() {
		return ((FDouble) getAttrVal("Amt_ypzl"));
	}
	/**
	 * 乙类药品自理费用
	 * @param Amt_ypzl
	 */
	public void setAmt_ypzl(FDouble Amt_ypzl) {
		setAttrVal("Amt_ypzl", Amt_ypzl);
	}
	/**
	 * 特检特治自理
	 * @return FDouble
	 */
	public FDouble getAmt_tjtzzl() {
		return ((FDouble) getAttrVal("Amt_tjtzzl"));
	}
	/**
	 * 特检特治自理
	 * @param Amt_tjtzzl
	 */
	public void setAmt_tjtzzl(FDouble Amt_tjtzzl) {
		setAttrVal("Amt_tjtzzl", Amt_tjtzzl);
	}
	/**
	 * 超出治疗方案自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_execrxself() {
		return ((FDouble) getAttrVal("Amt_execrxself"));
	}
	/**
	 * 超出治疗方案自付金额
	 * @param Amt_execrxself
	 */
	public void setAmt_execrxself(FDouble Amt_execrxself) {
		setAttrVal("Amt_execrxself", Amt_execrxself);
	}
	/**
	 * 起付标准自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_deductiblepayself() {
		return ((FDouble) getAttrVal("Amt_deductiblepayself"));
	}
	/**
	 * 起付标准自付金额
	 * @param Amt_deductiblepayself
	 */
	public void setAmt_deductiblepayself(FDouble Amt_deductiblepayself) {
		setAttrVal("Amt_deductiblepayself", Amt_deductiblepayself);
	}
	/**
	 * 进入统筹费用
	 * @return FDouble
	 */
	public FDouble getAmt_inhp() {
		return ((FDouble) getAttrVal("Amt_inhp"));
	}
	/**
	 * 进入统筹费用
	 * @param Amt_inhp
	 */
	public void setAmt_inhp(FDouble Amt_inhp) {
		setAttrVal("Amt_inhp", Amt_inhp);
	}
	/**
	 * 统筹分段自付
	 * @return FDouble
	 */
	public FDouble getAmt_hpsegself() {
		return ((FDouble) getAttrVal("Amt_hpsegself"));
	}
	/**
	 * 统筹分段自付
	 * @param Amt_hpsegself
	 */
	public void setAmt_hpsegself(FDouble Amt_hpsegself) {
		setAttrVal("Amt_hpsegself", Amt_hpsegself);
	}
	/**
	 * 进入救助金费用(医疗救助-玉溪)
	 * @return FDouble
	 */
	public FDouble getAmt_incivil() {
		return ((FDouble) getAttrVal("Amt_incivil"));
	}
	/**
	 * 进入救助金费用(医疗救助-玉溪)
	 * @param Amt_incivil
	 */
	public void setAmt_incivil(FDouble Amt_incivil) {
		setAttrVal("Amt_incivil", Amt_incivil);
	}
	/**
	 * 救助金自付
	 * @return FDouble
	 */
	public FDouble getAmt_civilselfpay() {
		return ((FDouble) getAttrVal("Amt_civilselfpay"));
	}
	/**
	 * 救助金自付
	 * @param Amt_civilselfpay
	 */
	public void setAmt_civilselfpay(FDouble Amt_civilselfpay) {
		setAttrVal("Amt_civilselfpay", Amt_civilselfpay);
	}
	/**
	 * 超封顶线自付
	 * @return FDouble
	 */
	public FDouble getAmt_overtopself() {
		return ((FDouble) getAttrVal("Amt_overtopself"));
	}
	/**
	 * 超封顶线自付
	 * @param Amt_overtopself
	 */
	public void setAmt_overtopself(FDouble Amt_overtopself) {
		setAttrVal("Amt_overtopself", Amt_overtopself);
	}
	/**
	 * 符合基本医疗费用总额(符合基本段报销金额-玉溪)
	 * @return FDouble
	 */
	public FDouble getAmt_baseall() {
		return ((FDouble) getAttrVal("Amt_baseall"));
	}
	/**
	 * 符合基本医疗费用总额(符合基本段报销金额-玉溪)
	 * @param Amt_baseall
	 */
	public void setAmt_baseall(FDouble Amt_baseall) {
		setAttrVal("Amt_baseall", Amt_baseall);
	}
	/**
	 * 一般起付标准额
	 * @return FDouble
	 */
	public FDouble getAmt_paystand() {
		return ((FDouble) getAttrVal("Amt_paystand"));
	}
	/**
	 * 一般起付标准额
	 * @param Amt_paystand
	 */
	public void setAmt_paystand(FDouble Amt_paystand) {
		setAttrVal("Amt_paystand", Amt_paystand);
	}
	/**
	 * 住院次数
	 * @return FDouble
	 */
	public FDouble getIp_times() {
		return ((FDouble) getAttrVal("Ip_times"));
	}
	/**
	 * 住院次数
	 * @param Ip_times
	 */
	public void setIp_times(FDouble Ip_times) {
		setAttrVal("Ip_times", Ip_times);
	}
	/**
	 * 师职补助
	 * @return FDouble
	 */
	public FDouble getAmt_officersupply() {
		return ((FDouble) getAttrVal("Amt_officersupply"));
	}
	/**
	 * 师职补助
	 * @param Amt_officersupply
	 */
	public void setAmt_officersupply(FDouble Amt_officersupply) {
		setAttrVal("Amt_officersupply", Amt_officersupply);
	}
	/**
	 * 超限价自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_overlimitself() {
		return ((FDouble) getAttrVal("Amt_overlimitself"));
	}
	/**
	 * 超限价自付金额
	 * @param Amt_overlimitself
	 */
	public void setAmt_overlimitself(FDouble Amt_overlimitself) {
		setAttrVal("Amt_overlimitself", Amt_overlimitself);
	}
	/**
	 * 超限价定点支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_overlimithos() {
		return ((FDouble) getAttrVal("Amt_overlimithos"));
	}
	/**
	 * 超限价定点支付金额
	 * @param Amt_overlimithos
	 */
	public void setAmt_overlimithos(FDouble Amt_overlimithos) {
		setAttrVal("Amt_overlimithos", Amt_overlimithos);
	}
	/**
	 * 进入大病补充费用(符合大病段报销金额-玉溪)
	 * @return FDouble
	 */
	public FDouble getAmt_inbigillcomple() {
		return ((FDouble) getAttrVal("Amt_inbigillcomple"));
	}
	/**
	 * 进入大病补充费用(符合大病段报销金额-玉溪)
	 * @param Amt_inbigillcomple
	 */
	public void setAmt_inbigillcomple(FDouble Amt_inbigillcomple) {
		setAttrVal("Amt_inbigillcomple", Amt_inbigillcomple);
	}
	/**
	 * 大病补充基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_bigillcomplefund() {
		return ((FDouble) getAttrVal("Amt_bigillcomplefund"));
	}
	/**
	 * 大病补充基金支付
	 * @param Amt_bigillcomplefund
	 */
	public void setAmt_bigillcomplefund(FDouble Amt_bigillcomplefund) {
		setAttrVal("Amt_bigillcomplefund", Amt_bigillcomplefund);
	}
	/**
	 * 本年进入大病补充累计（不含本次）
	 * @return FDouble
	 */
	public FDouble getAmt_inbigillcompleall() {
		return ((FDouble) getAttrVal("Amt_inbigillcompleall"));
	}
	/**
	 * 本年进入大病补充累计（不含本次）
	 * @param Amt_inbigillcompleall
	 */
	public void setAmt_inbigillcompleall(FDouble Amt_inbigillcompleall) {
		setAttrVal("Amt_inbigillcompleall", Amt_inbigillcompleall);
	}
	/**
	 * 本年大病补充支付累计(不含本次)
	 * @return FDouble
	 */
	public FDouble getAmt_bigillcomplefundall() {
		return ((FDouble) getAttrVal("Amt_bigillcomplefundall"));
	}
	/**
	 * 本年大病补充支付累计(不含本次)
	 * @param Amt_bigillcomplefundall
	 */
	public void setAmt_bigillcomplefundall(FDouble Amt_bigillcomplefundall) {
		setAttrVal("Amt_bigillcomplefundall", Amt_bigillcomplefundall);
	}
	/**
	 * 统筹部分进入补充医疗自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_incomplemedi() {
		return ((FDouble) getAttrVal("Amt_incomplemedi"));
	}
	/**
	 * 统筹部分进入补充医疗自付费用
	 * @param Amt_incomplemedi
	 */
	public void setAmt_incomplemedi(FDouble Amt_incomplemedi) {
		setAttrVal("Amt_incomplemedi", Amt_incomplemedi);
	}
	/**
	 * 特殊补充医疗报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_speccomple() {
		return ((FDouble) getAttrVal("Amt_speccomple"));
	}
	/**
	 * 特殊补充医疗报销金额
	 * @param Amt_speccomple
	 */
	public void setAmt_speccomple(FDouble Amt_speccomple) {
		setAttrVal("Amt_speccomple", Amt_speccomple);
	}
	/**
	 * 门诊定点超统筹金额
	 * @return FDouble
	 */
	public FDouble getAmt_oepoverhp() {
		return ((FDouble) getAttrVal("Amt_oepoverhp"));
	}
	/**
	 * 门诊定点超统筹金额
	 * @param Amt_oepoverhp
	 */
	public void setAmt_oepoverhp(FDouble Amt_oepoverhp) {
		setAttrVal("Amt_oepoverhp", Amt_oepoverhp);
	}
	/**
	 * 产前检查费(周口用）
	 * @return FDouble
	 */
	public FDouble getExaminebear_fee() {
		return ((FDouble) getAttrVal("Examinebear_fee"));
	}
	/**
	 * 产前检查费(周口用）
	 * @param Examinebear_fee
	 */
	public void setExaminebear_fee(FDouble Examinebear_fee) {
		setAttrVal("Examinebear_fee", Examinebear_fee);
	}
	/**
	 * 定点承担金额
	 * @return FDouble
	 */
	public FDouble getAmt_hosload() {
		return ((FDouble) getAttrVal("Amt_hosload"));
	}
	/**
	 * 定点承担金额
	 * @param Amt_hosload
	 */
	public void setAmt_hosload(FDouble Amt_hosload) {
		setAttrVal("Amt_hosload", Amt_hosload);
	}
	/**
	 * 新乡职工大病报销乙类费用
	 * @return FDouble
	 */
	public FDouble getAmt_zgdbylfy() {
		return ((FDouble) getAttrVal("Amt_zgdbylfy"));
	}
	/**
	 * 新乡职工大病报销乙类费用
	 * @param Amt_zgdbylfy
	 */
	public void setAmt_zgdbylfy(FDouble Amt_zgdbylfy) {
		setAttrVal("Amt_zgdbylfy", Amt_zgdbylfy);
	}
	/**
	 * 上次统筹记账累计
	 * @return FDouble
	 */
	public FDouble getLast_hpchargetotal() {
		return ((FDouble) getAttrVal("Last_hpchargetotal"));
	}
	/**
	 * 上次统筹记账累计
	 * @param Last_hpchargetotal
	 */
	public void setLast_hpchargetotal(FDouble Last_hpchargetotal) {
		setAttrVal("Last_hpchargetotal", Last_hpchargetotal);
	}
	/**
	 * 上次大额累计
	 * @return FDouble
	 */
	public FDouble getLast_largetotal() {
		return ((FDouble) getAttrVal("Last_largetotal"));
	}
	/**
	 * 上次大额累计
	 * @param Last_largetotal
	 */
	public void setLast_largetotal(FDouble Last_largetotal) {
		setAttrVal("Last_largetotal", Last_largetotal);
	}
	/**
	 * 厅级干部公务员补助
	 * @return FDouble
	 */
	public FDouble getTjgb_civilsubsidy() {
		return ((FDouble) getAttrVal("Tjgb_civilsubsidy"));
	}
	/**
	 * 厅级干部公务员补助
	 * @param Tjgb_civilsubsidy
	 */
	public void setTjgb_civilsubsidy(FDouble Tjgb_civilsubsidy) {
		setAttrVal("Tjgb_civilsubsidy", Tjgb_civilsubsidy);
	}
	/**
	 * 男职工配偶姓名
	 * @return String
	 */
	public String getWifeofmaleworker_name() {
		return ((String) getAttrVal("Wifeofmaleworker_name"));
	}
	/**
	 * 男职工配偶姓名
	 * @param Wifeofmaleworker_name
	 */
	public void setWifeofmaleworker_name(String Wifeofmaleworker_name) {
		setAttrVal("Wifeofmaleworker_name", Wifeofmaleworker_name);
	}
	/**
	 * 统筹区号
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}
	/**
	 * 统筹区号
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 门慢月定额余额(慢性病限额剩余-玉溪)
	 * @return FDouble
	 */
	public FDouble getChronicbalance() {
		return ((FDouble) getAttrVal("Chronicbalance"));
	}
	/**
	 * 门慢月定额余额(慢性病限额剩余-玉溪)
	 * @param Chronicbalance
	 */
	public void setChronicbalance(FDouble Chronicbalance) {
		setAttrVal("Chronicbalance", Chronicbalance);
	}
	/**
	 * 发送方交易流水号
	 * @return String
	 */
	public String getSenderserialno() {
		return ((String) getAttrVal("Senderserialno"));
	}
	/**
	 * 发送方交易流水号
	 * @param Senderserialno
	 */
	public void setSenderserialno(String Senderserialno) {
		setAttrVal("Senderserialno", Senderserialno);
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
	 * 诊断编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}
	/**
	 * 诊断编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 医保人员身份
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 医保人员身份
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 意外伤害支付费用
	 * @return FDouble
	 */
	public FDouble getAmt_accident() {
		return ((FDouble) getAttrVal("Amt_accident"));
	}
	/**
	 * 意外伤害支付费用
	 * @param Amt_accident
	 */
	public void setAmt_accident(FDouble Amt_accident) {
		setAttrVal("Amt_accident", Amt_accident);
	}
	/**
	 * 转诊先自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_referalself() {
		return ((FDouble) getAttrVal("Amt_referalself"));
	}
	/**
	 * 转诊先自付金额
	 * @param Amt_referalself
	 */
	public void setAmt_referalself(FDouble Amt_referalself) {
		setAttrVal("Amt_referalself", Amt_referalself);
	}
	/**
	 * 财政支出
	 * @return FDouble
	 */
	public FDouble getAmt_financialaid() {
		return ((FDouble) getAttrVal("Amt_financialaid"));
	}
	/**
	 * 财政支出
	 * @param Amt_financialaid
	 */
	public void setAmt_financialaid(FDouble Amt_financialaid) {
		setAttrVal("Amt_financialaid", Amt_financialaid);
	}
	/**
	 * 离休统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_retiretotal() {
		return ((FDouble) getAttrVal("Amt_retiretotal"));
	}
	/**
	 * 离休统筹支出
	 * @param Amt_retiretotal
	 */
	public void setAmt_retiretotal(FDouble Amt_retiretotal) {
		setAttrVal("Amt_retiretotal", Amt_retiretotal);
	}
	/**
	 * 门诊统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_hpoep() {
		return ((FDouble) getAttrVal("Amt_hpoep"));
	}
	/**
	 * 门诊统筹支出
	 * @param Amt_hpoep
	 */
	public void setAmt_hpoep(FDouble Amt_hpoep) {
		setAttrVal("Amt_hpoep", Amt_hpoep);
	}
	/**
	 * 住院统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_hpip() {
		return ((FDouble) getAttrVal("Amt_hpip"));
	}
	/**
	 * 住院统筹支出
	 * @param Amt_hpip
	 */
	public void setAmt_hpip(FDouble Amt_hpip) {
		setAttrVal("Amt_hpip", Amt_hpip);
	}
	/**
	 * 交易索引号
	 * @return String
	 */
	public String getBankdealindex() {
		return ((String) getAttrVal("Bankdealindex"));
	}
	/**
	 * 交易索引号
	 * @param Bankdealindex
	 */
	public void setBankdealindex(String Bankdealindex) {
		setAttrVal("Bankdealindex", Bankdealindex);
	}
	/**
	 * 参考号
	 * @return String
	 */
	public String getReferenceno() {
		return ((String) getAttrVal("Referenceno"));
	}
	/**
	 * 参考号
	 * @param Referenceno
	 */
	public void setReferenceno(String Referenceno) {
		setAttrVal("Referenceno", Referenceno);
	}
	/**
	 * Pos机交易编号
	 * @return String
	 */
	public String getPosdealcode() {
		return ((String) getAttrVal("Posdealcode"));
	}
	/**
	 * Pos机交易编号
	 * @param Posdealcode
	 */
	public void setPosdealcode(String Posdealcode) {
		setAttrVal("Posdealcode", Posdealcode);
	}
	/**
	 * 原交易日期
	 * @return String
	 */
	public String getOrigin_transdate() {
		return ((String) getAttrVal("Origin_transdate"));
	}
	/**
	 * 原交易日期
	 * @param Origin_transdate
	 */
	public void setOrigin_transdate(String Origin_transdate) {
		setAttrVal("Origin_transdate", Origin_transdate);
	}
	/**
	 * 银行交易成功标志
	 * @return String
	 */
	public String getDealsucc() {
		return ((String) getAttrVal("Dealsucc"));
	}
	/**
	 * 银行交易成功标志
	 * @param Dealsucc
	 */
	public void setDealsucc(String Dealsucc) {
		setAttrVal("Dealsucc", Dealsucc);
	}
	/**
	 * 银行账号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行账号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 民政救助支出
	 * @return FDouble
	 */
	public FDouble getAmt_civilassist() {
		return ((FDouble) getAttrVal("Amt_civilassist"));
	}
	/**
	 * 民政救助支出
	 * @param Amt_civilassist
	 */
	public void setAmt_civilassist(FDouble Amt_civilassist) {
		setAttrVal("Amt_civilassist", Amt_civilassist);
	}
	/**
	 * 民政特大救助支出
	 * @return FDouble
	 */
	public FDouble getAmt_civilbigassist() {
		return ((FDouble) getAttrVal("Amt_civilbigassist"));
	}
	/**
	 * 民政特大救助支出
	 * @param Amt_civilbigassist
	 */
	public void setAmt_civilbigassist(FDouble Amt_civilbigassist) {
		setAttrVal("Amt_civilbigassist", Amt_civilbigassist);
	}
	/**
	 * 商业补充保险支出
	 * @return FDouble
	 */
	public FDouble getAmt_businessinsure() {
		return ((FDouble) getAttrVal("Amt_businessinsure"));
	}
	/**
	 * 商业补充保险支出
	 * @param Amt_businessinsure
	 */
	public void setAmt_businessinsure(FDouble Amt_businessinsure) {
		setAttrVal("Amt_businessinsure", Amt_businessinsure);
	}
	/**
	 * 医疗机构减免
	 * @return FDouble
	 */
	public FDouble getAmt_hospreduce() {
		return ((FDouble) getAttrVal("Amt_hospreduce"));
	}
	/**
	 * 医疗机构减免
	 * @param Amt_hospreduce
	 */
	public void setAmt_hospreduce(FDouble Amt_hospreduce) {
		setAttrVal("Amt_hospreduce", Amt_hospreduce);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCompanycode() {
		return ((String) getAttrVal("Companycode"));
	}
	/**
	 * 单位编码
	 * @param Companycode
	 */
	public void setCompanycode(String Companycode) {
		setAttrVal("Companycode", Companycode);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getCompanyname() {
		return ((String) getAttrVal("Companyname"));
	}
	/**
	 * 单位名称
	 * @param Companyname
	 */
	public void setCompanyname(String Companyname) {
		setAttrVal("Companyname", Companyname);
	}
	/**
	 * 精准扶贫标志
	 * @return String
	 */
	public String getSpecneed_flag() {
		return ((String) getAttrVal("Specneed_flag"));
	}
	/**
	 * 精准扶贫标志
	 * @param Specneed_flag
	 */
	public void setSpecneed_flag(String Specneed_flag) {
		setAttrVal("Specneed_flag", Specneed_flag);
	}
	/**
	 * 民政人员标志
	 * @return String
	 */
	public String getCivil_flag() {
		return ((String) getAttrVal("Civil_flag"));
	}
	/**
	 * 民政人员标志
	 * @param Civil_flag
	 */
	public void setCivil_flag(String Civil_flag) {
		setAttrVal("Civil_flag", Civil_flag);
	}
	/**
	 * 异地结算单
	 * @return String
	 */
	public String getAllo_stsheet() {
		return ((String) getAttrVal("Allo_stsheet"));
	}
	/**
	 * 异地结算单
	 * @param Allo_stsheet
	 */
	public void setAllo_stsheet(String Allo_stsheet) {
		setAttrVal("Allo_stsheet", Allo_stsheet);
	}
	/**
	 * 大病理赔
	 * @return FDouble
	 */
	public FDouble getAmt_majorpath() {
		return ((FDouble) getAttrVal("Amt_majorpath"));
	}
	/**
	 * 大病理赔
	 * @param Amt_majorpath
	 */
	public void setAmt_majorpath(FDouble Amt_majorpath) {
		setAttrVal("Amt_majorpath", Amt_majorpath);
	}
	/**
	 * 照顾人员补助
	 * @return FDouble
	 */
	public FDouble getAmt_caregivers() {
		return ((FDouble) getAttrVal("Amt_caregivers"));
	}
	/**
	 * 照顾人员补助
	 * @param Amt_caregivers
	 */
	public void setAmt_caregivers(FDouble Amt_caregivers) {
		setAttrVal("Amt_caregivers", Amt_caregivers);
	}
	/**
	 * 解放前工作人员补助
	 * @return FDouble
	 */
	public FDouble getAmt_beforelibera() {
		return ((FDouble) getAttrVal("Amt_beforelibera"));
	}
	/**
	 * 解放前工作人员补助
	 * @param Amt_beforelibera
	 */
	public void setAmt_beforelibera(FDouble Amt_beforelibera) {
		setAttrVal("Amt_beforelibera", Amt_beforelibera);
	}
	/**
	 * 起付线剩余
	 * @return FDouble
	 */
	public FDouble getAmt_startlinesurplus() {
		return ((FDouble) getAttrVal("Amt_startlinesurplus"));
	}
	/**
	 * 起付线剩余
	 * @param Amt_startlinesurplus
	 */
	public void setAmt_startlinesurplus(FDouble Amt_startlinesurplus) {
		setAttrVal("Amt_startlinesurplus", Amt_startlinesurplus);
	}
	/**
	 * 医保结算时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sthp() {
		return ((FDateTime) getAttrVal("Dt_sthp"));
	}
	/**
	 * 医保结算时间
	 * @param Dt_sthp
	 */
	public void setDt_sthp(FDateTime Dt_sthp) {
		setAttrVal("Dt_sthp", Dt_sthp);
	}
	/**
	 * 包干标准
	 * @return FDouble
	 */
	public FDouble getAmt_contractstandard() {
		return ((FDouble) getAttrVal("Amt_contractstandard"));
	}
	/**
	 * 包干标准
	 * @param Amt_contractstandard
	 */
	public void setAmt_contractstandard(FDouble Amt_contractstandard) {
		setAttrVal("Amt_contractstandard", Amt_contractstandard);
	}
	/**
	 * 包干结余
	 * @return FDouble
	 */
	public FDouble getAmt_lumpsumsurplus() {
		return ((FDouble) getAttrVal("Amt_lumpsumsurplus"));
	}
	/**
	 * 包干结余
	 * @param Amt_lumpsumsurplus
	 */
	public void setAmt_lumpsumsurplus(FDouble Amt_lumpsumsurplus) {
		setAttrVal("Amt_lumpsumsurplus", Amt_lumpsumsurplus);
	}
	/**
	 * 基本医疗账户
	 * @return FDouble
	 */
	public FDouble getAmt_basehpaccount() {
		return ((FDouble) getAttrVal("Amt_basehpaccount"));
	}
	/**
	 * 基本医疗账户
	 * @param Amt_basehpaccount
	 */
	public void setAmt_basehpaccount(FDouble Amt_basehpaccount) {
		setAttrVal("Amt_basehpaccount", Amt_basehpaccount);
	}
	/**
	 * 公务员医疗账户
	 * @return FDouble
	 */
	public FDouble getAmt_civilservantaccount() {
		return ((FDouble) getAttrVal("Amt_civilservantaccount"));
	}
	/**
	 * 公务员医疗账户
	 * @param Amt_civilservantaccount
	 */
	public void setAmt_civilservantaccount(FDouble Amt_civilservantaccount) {
		setAttrVal("Amt_civilservantaccount", Amt_civilservantaccount);
	}
	/**
	 * 只能审核疑点信息
	 * @return String
	 */
	public String getIntelligentaudit() {
		return ((String) getAttrVal("Intelligentaudit"));
	}
	/**
	 * 只能审核疑点信息
	 * @param Intelligentaudit
	 */
	public void setIntelligentaudit(String Intelligentaudit) {
		setAttrVal("Intelligentaudit", Intelligentaudit);
	}
	/**
	 * DRGs分组规定付费标准
	 * @return FDouble
	 */
	public FDouble getAmt_drgsgrounp() {
		return ((FDouble) getAttrVal("Amt_drgsgrounp"));
	}
	/**
	 * DRGs分组规定付费标准
	 * @param Amt_drgsgrounp
	 */
	public void setAmt_drgsgrounp(FDouble Amt_drgsgrounp) {
		setAttrVal("Amt_drgsgrounp", Amt_drgsgrounp);
	}
	/**
	 * DRGs基金付费标准
	 * @return FDouble
	 */
	public FDouble getAmt_drgsbase() {
		return ((FDouble) getAttrVal("Amt_drgsbase"));
	}
	/**
	 * DRGs基金付费标准
	 * @param Amt_drgsbase
	 */
	public void setAmt_drgsbase(FDouble Amt_drgsbase) {
		setAttrVal("Amt_drgsbase", Amt_drgsbase);
	}
	/**
	 * 兜底保障
	 * @return FDouble
	 */
	public FDouble getAmt_pocketguarantee() {
		return ((FDouble) getAttrVal("Amt_pocketguarantee"));
	}
	/**
	 * 兜底保障
	 * @param Amt_pocketguarantee
	 */
	public void setAmt_pocketguarantee(FDouble Amt_pocketguarantee) {
		setAttrVal("Amt_pocketguarantee", Amt_pocketguarantee);
	}
	/**
	 * 基本医疗统筹支付
	 * @return FDouble
	 */
	public FDouble getAmt_basehppay() {
		return ((FDouble) getAttrVal("Amt_basehppay"));
	}
	/**
	 * 基本医疗统筹支付
	 * @param Amt_basehppay
	 */
	public void setAmt_basehppay(FDouble Amt_basehppay) {
		setAttrVal("Amt_basehppay", Amt_basehppay);
	}
	/**
	 * 中心交易流水号
	 * @return String
	 */
	public String getCenterserialcode() {
		return ((String) getAttrVal("Centerserialcode"));
	}
	/**
	 * 中心交易流水号
	 * @param Centerserialcode
	 */
	public void setCenterserialcode(String Centerserialcode) {
		setAttrVal("Centerserialcode", Centerserialcode);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTranstype() {
		return ((String) getAttrVal("Transtype"));
	}
	/**
	 * 交易类型
	 * @param Transtype
	 */
	public void setTranstype(String Transtype) {
		setAttrVal("Transtype", Transtype);
	}
	/**
	 * 结算前医保账户余额
	 * @return FDouble
	 */
	public FDouble getHpacc_before() {
		return ((FDouble) getAttrVal("Hpacc_before"));
	}
	/**
	 * 结算前医保账户余额
	 * @param Hpacc_before
	 */
	public void setHpacc_before(FDouble Hpacc_before) {
		setAttrVal("Hpacc_before", Hpacc_before);
	}
	/**
	 * 州市统筹区号
	 * @return String
	 */
	public String getCityareacode() {
		return ((String) getAttrVal("Cityareacode"));
	}
	/**
	 * 州市统筹区号
	 * @param Cityareacode
	 */
	public void setCityareacode(String Cityareacode) {
		setAttrVal("Cityareacode", Cityareacode);
	}
	/**
	 * 职工居民标识
	 * @return String
	 */
	public String getIdent_emp() {
		return ((String) getAttrVal("Ident_emp"));
	}
	/**
	 * 职工居民标识
	 * @param Ident_emp
	 */
	public void setIdent_emp(String Ident_emp) {
		setAttrVal("Ident_emp", Ident_emp);
	}
	/**
	 * 结算类型
	 * @return String
	 */
	public String getSt_type() {
		return ((String) getAttrVal("St_type"));
	}
	/**
	 * 结算类型
	 * @param St_type
	 */
	public void setSt_type(String St_type) {
		setAttrVal("St_type", St_type);
	}
	/**
	 * 干部补助
	 * @return FDouble
	 */
	public FDouble getAmt_gbbz() {
		return ((FDouble) getAttrVal("Amt_gbbz"));
	}
	/**
	 * 干部补助
	 * @param Amt_gbbz
	 */
	public void setAmt_gbbz(FDouble Amt_gbbz) {
		setAttrVal("Amt_gbbz", Amt_gbbz);
	}
	/**
	 * 补偿类别
	 * @return String
	 */
	public String getSupplytype() {
		return ((String) getAttrVal("Supplytype"));
	}
	/**
	 * 补偿类别
	 * @param Supplytype
	 */
	public void setSupplytype(String Supplytype) {
		setAttrVal("Supplytype", Supplytype);
	}
	/**
	 * 合理费用
	 * @return FDouble
	 */
	public FDouble getAmt_reasonal() {
		return ((FDouble) getAttrVal("Amt_reasonal"));
	}
	/**
	 * 合理费用
	 * @param Amt_reasonal
	 */
	public void setAmt_reasonal(FDouble Amt_reasonal) {
		setAttrVal("Amt_reasonal", Amt_reasonal);
	}
	/**
	 * 实际补偿费用
	 * @return FDouble
	 */
	public FDouble getAmt_actual() {
		return ((FDouble) getAttrVal("Amt_actual"));
	}
	/**
	 * 实际补偿费用
	 * @param Amt_actual
	 */
	public void setAmt_actual(FDouble Amt_actual) {
		setAttrVal("Amt_actual", Amt_actual);
	}
	/**
	 * 核算补偿费用
	 * @return FDouble
	 */
	public FDouble getAmt_cg() {
		return ((FDouble) getAttrVal("Amt_cg"));
	}
	/**
	 * 核算补偿费用
	 * @param Amt_cg
	 */
	public void setAmt_cg(FDouble Amt_cg) {
		setAttrVal("Amt_cg", Amt_cg);
	}
	/**
	 * 本次起付线
	 * @return FDouble
	 */
	public FDouble getAmt_base() {
		return ((FDouble) getAttrVal("Amt_base"));
	}
	/**
	 * 本次起付线
	 * @param Amt_base
	 */
	public void setAmt_base(FDouble Amt_base) {
		setAttrVal("Amt_base", Amt_base);
	}
	/**
	 * 单次补偿费用
	 * @return FDouble
	 */
	public FDouble getAmt_sigle() {
		return ((FDouble) getAttrVal("Amt_sigle"));
	}
	/**
	 * 单次补偿费用
	 * @param Amt_sigle
	 */
	public void setAmt_sigle(FDouble Amt_sigle) {
		setAttrVal("Amt_sigle", Amt_sigle);
	}
	/**
	 * 计算公式
	 * @return String
	 */
	public String getExpression() {
		return ((String) getAttrVal("Expression"));
	}
	/**
	 * 计算公式
	 * @param Expression
	 */
	public void setExpression(String Expression) {
		setAttrVal("Expression", Expression);
	}
	/**
	 * 大病理赔次数
	 * @return FDouble
	 */
	public FDouble getSupply_times() {
		return ((FDouble) getAttrVal("Supply_times"));
	}
	/**
	 * 大病理赔次数
	 * @param Supply_times
	 */
	public void setSupply_times(FDouble Supply_times) {
		setAttrVal("Supply_times", Supply_times);
	}
	/**
	 * 是否意外伤害
	 * @return String
	 */
	public String getFg_accident() {
		return ((String) getAttrVal("Fg_accident"));
	}
	/**
	 * 是否意外伤害
	 * @param Fg_accident
	 */
	public void setFg_accident(String Fg_accident) {
		setAttrVal("Fg_accident", Fg_accident);
	}
	/**
	 * 是否医院垫付
	 * @return String
	 */
	public String getFg_hosload() {
		return ((String) getAttrVal("Fg_hosload"));
	}
	/**
	 * 是否医院垫付
	 * @param Fg_hosload
	 */
	public void setFg_hosload(String Fg_hosload) {
		setAttrVal("Fg_hosload", Fg_hosload);
	}
	/**
	 * 理赔金额
	 * @return FDouble
	 */
	public FDouble getAmt_claims() {
		return ((FDouble) getAttrVal("Amt_claims"));
	}
	/**
	 * 理赔金额
	 * @param Amt_claims
	 */
	public void setAmt_claims(FDouble Amt_claims) {
		setAttrVal("Amt_claims", Amt_claims);
	}
	/**
	 * 理赔类型
	 * @return String
	 */
	public String getClaims_type() {
		return ((String) getAttrVal("Claims_type"));
	}
	/**
	 * 理赔类型
	 * @param Claims_type
	 */
	public void setClaims_type(String Claims_type) {
		setAttrVal("Claims_type", Claims_type);
	}
	/**
	 * 补偿账户类别
	 * @return String
	 */
	public String getSupplyaccount_type() {
		return ((String) getAttrVal("Supplyaccount_type"));
	}
	/**
	 * 补偿账户类别
	 * @param Supplyaccount_type
	 */
	public void setSupplyaccount_type(String Supplyaccount_type) {
		setAttrVal("Supplyaccount_type", Supplyaccount_type);
	}
	/**
	 * 救助金支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_jz() {
		return ((FDouble) getAttrVal("Amt_jz"));
	}
	/**
	 * 救助金支付金额
	 * @param Amt_jz
	 */
	public void setAmt_jz(FDouble Amt_jz) {
		setAttrVal("Amt_jz", Amt_jz);
	}
	/**
	 * 可报销床位费
	 * @return FDouble
	 */
	public FDouble getAmt_bed() {
		return ((FDouble) getAttrVal("Amt_bed"));
	}
	/**
	 * 可报销床位费
	 * @param Amt_bed
	 */
	public void setAmt_bed(FDouble Amt_bed) {
		setAttrVal("Amt_bed", Amt_bed);
	}
	/**
	 * 乙类自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_yl_zl() {
		return ((FDouble) getAttrVal("Amt_yl_zl"));
	}
	/**
	 * 乙类自理费用
	 * @param Amt_yl_zl
	 */
	public void setAmt_yl_zl(FDouble Amt_yl_zl) {
		setAttrVal("Amt_yl_zl", Amt_yl_zl);
	}
	/**
	 * 基本医疗分段公务员补助
	 * @return FDouble
	 */
	public FDouble getAmt_gwy_fd() {
		return ((FDouble) getAttrVal("Amt_gwy_fd"));
	}
	/**
	 * 基本医疗分段公务员补助
	 * @param Amt_gwy_fd
	 */
	public void setAmt_gwy_fd(FDouble Amt_gwy_fd) {
		setAttrVal("Amt_gwy_fd", Amt_gwy_fd);
	}
	/**
	 * 定点医疗机构支付
	 * @return FDouble
	 */
	public FDouble getAmt_his_pay() {
		return ((FDouble) getAttrVal("Amt_his_pay"));
	}
	/**
	 * 定点医疗机构支付
	 * @param Amt_his_pay
	 */
	public void setAmt_his_pay(FDouble Amt_his_pay) {
		setAttrVal("Amt_his_pay", Amt_his_pay);
	}
	/**
	 * 床位费超限价公务员补助
	 * @return FDouble
	 */
	public FDouble getAmt_gwy_bed() {
		return ((FDouble) getAttrVal("Amt_gwy_bed"));
	}
	/**
	 * 床位费超限价公务员补助
	 * @param Amt_gwy_bed
	 */
	public void setAmt_gwy_bed(FDouble Amt_gwy_bed) {
		setAttrVal("Amt_gwy_bed", Amt_gwy_bed);
	}
	/**
	 * 起付线公务员补助
	 * @return FDouble
	 */
	public FDouble getAmt_gwy_qfx() {
		return ((FDouble) getAttrVal("Amt_gwy_qfx"));
	}
	/**
	 * 起付线公务员补助
	 * @param Amt_gwy_qfx
	 */
	public void setAmt_gwy_qfx(FDouble Amt_gwy_qfx) {
		setAttrVal("Amt_gwy_qfx", Amt_gwy_qfx);
	}
	/**
	 * 乙类自理公务员补助
	 * @return FDouble
	 */
	public FDouble getAmt_wgy_yl() {
		return ((FDouble) getAttrVal("Amt_wgy_yl"));
	}
	/**
	 * 乙类自理公务员补助
	 * @param Amt_wgy_yl
	 */
	public void setAmt_wgy_yl(FDouble Amt_wgy_yl) {
		setAttrVal("Amt_wgy_yl", Amt_wgy_yl);
	}
	/**
	 * 大额段封顶线
	 * @return FDouble
	 */
	public FDouble getAmt_defdx() {
		return ((FDouble) getAttrVal("Amt_defdx"));
	}
	/**
	 * 大额段封顶线
	 * @param Amt_defdx
	 */
	public void setAmt_defdx(FDouble Amt_defdx) {
		setAttrVal("Amt_defdx", Amt_defdx);
	}
	/**
	 * 统筹段封顶线
	 * @return FDouble
	 */
	public FDouble getAmt_tcfdx() {
		return ((FDouble) getAttrVal("Amt_tcfdx"));
	}
	/**
	 * 统筹段封顶线
	 * @param Amt_tcfdx
	 */
	public void setAmt_tcfdx(FDouble Amt_tcfdx) {
		setAttrVal("Amt_tcfdx", Amt_tcfdx);
	}
	/**
	 * 本次账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_zhye() {
		return ((FDouble) getAttrVal("Amt_zhye"));
	}
	/**
	 * 本次账户余额
	 * @param Amt_zhye
	 */
	public void setAmt_zhye(FDouble Amt_zhye) {
		setAttrVal("Amt_zhye", Amt_zhye);
	}
	/**
	 * 医疗待遇类别
	 * @return String
	 */
	public String getYldy() {
		return ((String) getAttrVal("Yldy"));
	}
	/**
	 * 医疗待遇类别
	 * @param Yldy
	 */
	public void setYldy(String Yldy) {
		setAttrVal("Yldy", Yldy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}
	/**
	 * 科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 公补支付累计
	 * @return FDouble
	 */
	public FDouble getAmt_gb_all() {
		return ((FDouble) getAttrVal("Amt_gb_all"));
	}
	/**
	 * 公补支付累计
	 * @param Amt_gb_all
	 */
	public void setAmt_gb_all(FDouble Amt_gb_all) {
		setAttrVal("Amt_gb_all", Amt_gb_all);
	}
	/**
	 * 长期门诊累计
	 * @return FDouble
	 */
	public FDouble getAmt_cqmz_all() {
		return ((FDouble) getAttrVal("Amt_cqmz_all"));
	}
	/**
	 * 长期门诊累计
	 * @param Amt_cqmz_all
	 */
	public void setAmt_cqmz_all(FDouble Amt_cqmz_all) {
		setAttrVal("Amt_cqmz_all", Amt_cqmz_all);
	}
	/**
	 * 特检自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_tjzl() {
		return ((FDouble) getAttrVal("Amt_tjzl"));
	}
	/**
	 * 特检自理费用
	 * @param Amt_tjzl
	 */
	public void setAmt_tjzl(FDouble Amt_tjzl) {
		setAttrVal("Amt_tjzl", Amt_tjzl);
	}
	/**
	 * 特治自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_tzzl() {
		return ((FDouble) getAttrVal("Amt_tzzl"));
	}
	/**
	 * 特治自理费用
	 * @param Amt_tzzl
	 */
	public void setAmt_tzzl(FDouble Amt_tzzl) {
		setAttrVal("Amt_tzzl", Amt_tzzl);
	}
	/**
	 * 大额互助支付（金昌）
	 * @return FDouble
	 */
	public FDouble getAmt_dehz() {
		return ((FDouble) getAttrVal("Amt_dehz"));
	}
	/**
	 * 大额互助支付（金昌）
	 * @param Amt_dehz
	 */
	public void setAmt_dehz(FDouble Amt_dehz) {
		setAttrVal("Amt_dehz", Amt_dehz);
	}
	/**
	 * 异地人员先行自付费用 （省直）
	 * @return FDouble
	 */
	public FDouble getAmt_ydxx_self() {
		return ((FDouble) getAttrVal("Amt_ydxx_self"));
	}
	/**
	 * 异地人员先行自付费用 （省直）
	 * @param Amt_ydxx_self
	 */
	public void setAmt_ydxx_self(FDouble Amt_ydxx_self) {
		setAttrVal("Amt_ydxx_self", Amt_ydxx_self);
	}
	/**
	 * 超封顶线公补支出
	 * @return FDouble
	 */
	public FDouble getAmt_over_fdx() {
		return ((FDouble) getAttrVal("Amt_over_fdx"));
	}
	/**
	 * 超封顶线公补支出
	 * @param Amt_over_fdx
	 */
	public void setAmt_over_fdx(FDouble Amt_over_fdx) {
		setAttrVal("Amt_over_fdx", Amt_over_fdx);
	}
	/**
	 * 乙类自理公务员补助标准
	 * @return FDouble
	 */
	public FDouble getAmt_gwy_yl_self() {
		return ((FDouble) getAttrVal("Amt_gwy_yl_self"));
	}
	/**
	 * 乙类自理公务员补助标准
	 * @param Amt_gwy_yl_self
	 */
	public void setAmt_gwy_yl_self(FDouble Amt_gwy_yl_self) {
		setAttrVal("Amt_gwy_yl_self", Amt_gwy_yl_self);
	}
	/**
	 * 起付线公务员补助标准
	 * @return FDouble
	 */
	public FDouble getAmt_qfx_gwy_bz() {
		return ((FDouble) getAttrVal("Amt_qfx_gwy_bz"));
	}
	/**
	 * 起付线公务员补助标准
	 * @param Amt_qfx_gwy_bz
	 */
	public void setAmt_qfx_gwy_bz(FDouble Amt_qfx_gwy_bz) {
		setAttrVal("Amt_qfx_gwy_bz", Amt_qfx_gwy_bz);
	}
	/**
	 * 统筹分段自付公务员补助 标准
	 * @return FDouble
	 */
	public FDouble getAmt_tcfd_gwy_bz() {
		return ((FDouble) getAttrVal("Amt_tcfd_gwy_bz"));
	}
	/**
	 * 统筹分段自付公务员补助 标准
	 * @param Amt_tcfd_gwy_bz
	 */
	public void setAmt_tcfd_gwy_bz(FDouble Amt_tcfd_gwy_bz) {
		setAttrVal("Amt_tcfd_gwy_bz", Amt_tcfd_gwy_bz);
	}
	/**
	 * 超封顶线公补标准
	 * @return FDouble
	 */
	public FDouble getAmt_over_fdx_gwy_bz() {
		return ((FDouble) getAttrVal("Amt_over_fdx_gwy_bz"));
	}
	/**
	 * 超封顶线公补标准
	 * @param Amt_over_fdx_gwy_bz
	 */
	public void setAmt_over_fdx_gwy_bz(FDouble Amt_over_fdx_gwy_bz) {
		setAttrVal("Amt_over_fdx_gwy_bz", Amt_over_fdx_gwy_bz);
	}
	/**
	 * 床位费超限价公务员补助 标准
	 * @return FDouble
	 */
	public FDouble getAmt_cwf_gwy_bz() {
		return ((FDouble) getAttrVal("Amt_cwf_gwy_bz"));
	}
	/**
	 * 床位费超限价公务员补助 标准
	 * @param Amt_cwf_gwy_bz
	 */
	public void setAmt_cwf_gwy_bz(FDouble Amt_cwf_gwy_bz) {
		setAttrVal("Amt_cwf_gwy_bz", Amt_cwf_gwy_bz);
	}
	/**
	 * 血费报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_xfbx() {
		return ((FDouble) getAttrVal("Amt_xfbx"));
	}
	/**
	 * 血费报销金额
	 * @param Amt_xfbx
	 */
	public void setAmt_xfbx(FDouble Amt_xfbx) {
		setAttrVal("Amt_xfbx", Amt_xfbx);
	}
	/**
	 * 统筹一段报销费用
	 * @return FDouble
	 */
	public FDouble getAmt_tcydbx() {
		return ((FDouble) getAttrVal("Amt_tcydbx"));
	}
	/**
	 * 统筹一段报销费用
	 * @param Amt_tcydbx
	 */
	public void setAmt_tcydbx(FDouble Amt_tcydbx) {
		setAttrVal("Amt_tcydbx", Amt_tcydbx);
	}
	/**
	 * 统筹一段自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_tcydzf() {
		return ((FDouble) getAttrVal("Amt_tcydzf"));
	}
	/**
	 * 统筹一段自付费用
	 * @param Amt_tcydzf
	 */
	public void setAmt_tcydzf(FDouble Amt_tcydzf) {
		setAttrVal("Amt_tcydzf", Amt_tcydzf);
	}
	/**
	 * 统筹二段报销费用
	 * @return FDouble
	 */
	public FDouble getAmt_tcedbx() {
		return ((FDouble) getAttrVal("Amt_tcedbx"));
	}
	/**
	 * 统筹二段报销费用
	 * @param Amt_tcedbx
	 */
	public void setAmt_tcedbx(FDouble Amt_tcedbx) {
		setAttrVal("Amt_tcedbx", Amt_tcedbx);
	}
	/**
	 * 统筹二段自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_tcedzf() {
		return ((FDouble) getAttrVal("Amt_tcedzf"));
	}
	/**
	 * 统筹二段自付费用
	 * @param Amt_tcedzf
	 */
	public void setAmt_tcedzf(FDouble Amt_tcedzf) {
		setAttrVal("Amt_tcedzf", Amt_tcedzf);
	}
	/**
	 * 进入公补费用
	 * @return FDouble
	 */
	public FDouble getAmt_jrgb() {
		return ((FDouble) getAttrVal("Amt_jrgb"));
	}
	/**
	 * 进入公补费用
	 * @param Amt_jrgb
	 */
	public void setAmt_jrgb(FDouble Amt_jrgb) {
		setAttrVal("Amt_jrgb", Amt_jrgb);
	}
	/**
	 * 血费自付
	 * @return FDouble
	 */
	public FDouble getAmt_xfzf() {
		return ((FDouble) getAttrVal("Amt_xfzf"));
	}
	/**
	 * 血费自付
	 * @param Amt_xfzf
	 */
	public void setAmt_xfzf(FDouble Amt_xfzf) {
		setAttrVal("Amt_xfzf", Amt_xfzf);
	}
	/**
	 * 基本医疗进入公补费用
	 * @return FDouble
	 */
	public FDouble getAmt_jbyljrgb() {
		return ((FDouble) getAttrVal("Amt_jbyljrgb"));
	}
	/**
	 * 基本医疗进入公补费用
	 * @param Amt_jbyljrgb
	 */
	public void setAmt_jbyljrgb(FDouble Amt_jbyljrgb) {
		setAttrVal("Amt_jbyljrgb", Amt_jbyljrgb);
	}
	/**
	 * 大病进入公补费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbjrgb() {
		return ((FDouble) getAttrVal("Amt_dbjrgb"));
	}
	/**
	 * 大病进入公补费用
	 * @param Amt_dbjrgb
	 */
	public void setAmt_dbjrgb(FDouble Amt_dbjrgb) {
		setAttrVal("Amt_dbjrgb", Amt_dbjrgb);
	}
	/**
	 * 大病公务员补助
	 * @return FDouble
	 */
	public FDouble getAmt_dbgb() {
		return ((FDouble) getAttrVal("Amt_dbgb"));
	}
	/**
	 * 大病公务员补助
	 * @param Amt_dbgb
	 */
	public void setAmt_dbgb(FDouble Amt_dbgb) {
		setAttrVal("Amt_dbgb", Amt_dbgb);
	}
	/**
	 * 进入大额互助费用
	 * @return FDouble
	 */
	public FDouble getAmt_jrdehz() {
		return ((FDouble) getAttrVal("Amt_jrdehz"));
	}
	/**
	 * 进入大额互助费用
	 * @param Amt_jrdehz
	 */
	public void setAmt_jrdehz(FDouble Amt_jrdehz) {
		setAttrVal("Amt_jrdehz", Amt_jrdehz);
	}
	/**
	 * 大病一段报销费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbydbx() {
		return ((FDouble) getAttrVal("Amt_dbydbx"));
	}
	/**
	 * 大病一段报销费用
	 * @param Amt_dbydbx
	 */
	public void setAmt_dbydbx(FDouble Amt_dbydbx) {
		setAttrVal("Amt_dbydbx", Amt_dbydbx);
	}
	/**
	 * 大病一段自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbydzf() {
		return ((FDouble) getAttrVal("Amt_dbydzf"));
	}
	/**
	 * 大病一段自付费用
	 * @param Amt_dbydzf
	 */
	public void setAmt_dbydzf(FDouble Amt_dbydzf) {
		setAttrVal("Amt_dbydzf", Amt_dbydzf);
	}
	/**
	 * 大病二段报销费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbedbx() {
		return ((FDouble) getAttrVal("Amt_dbedbx"));
	}
	/**
	 * 大病二段报销费用
	 * @param Amt_dbedbx
	 */
	public void setAmt_dbedbx(FDouble Amt_dbedbx) {
		setAttrVal("Amt_dbedbx", Amt_dbedbx);
	}
	/**
	 * 大病二段自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbedzf() {
		return ((FDouble) getAttrVal("Amt_dbedzf"));
	}
	/**
	 * 大病二段自付费用
	 * @param Amt_dbedzf
	 */
	public void setAmt_dbedzf(FDouble Amt_dbedzf) {
		setAttrVal("Amt_dbedzf", Amt_dbedzf);
	}
	/**
	 * 大病三段报销费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbsdbx() {
		return ((FDouble) getAttrVal("Amt_dbsdbx"));
	}
	/**
	 * 大病三段报销费用
	 * @param Amt_dbsdbx
	 */
	public void setAmt_dbsdbx(FDouble Amt_dbsdbx) {
		setAttrVal("Amt_dbsdbx", Amt_dbsdbx);
	}
	/**
	 * 其它基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_qtjjzf() {
		return ((FDouble) getAttrVal("Amt_qtjjzf"));
	}
	/**
	 * 其它基金支付
	 * @param Amt_qtjjzf
	 */
	public void setAmt_qtjjzf(FDouble Amt_qtjjzf) {
		setAttrVal("Amt_qtjjzf", Amt_qtjjzf);
	}
	/**
	 * 大病三段自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_dbsdzf() {
		return ((FDouble) getAttrVal("Amt_dbsdzf"));
	}
	/**
	 * 大病三段自付费用
	 * @param Amt_dbsdzf
	 */
	public void setAmt_dbsdzf(FDouble Amt_dbsdzf) {
		setAttrVal("Amt_dbsdzf", Amt_dbsdzf);
	}
	/**
	 * 扶贫特惠保险金额
	 * @return FDouble
	 */
	public FDouble getAmt_fpthbx() {
		return ((FDouble) getAttrVal("Amt_fpthbx"));
	}
	/**
	 * 扶贫特惠保险金额
	 * @param Amt_fpthbx
	 */
	public void setAmt_fpthbx(FDouble Amt_fpthbx) {
		setAttrVal("Amt_fpthbx", Amt_fpthbx);
	}
	/**
	 * 低保救助金额
	 * @return FDouble
	 */
	public FDouble getAmt_dbzj() {
		return ((FDouble) getAttrVal("Amt_dbzj"));
	}
	/**
	 * 低保救助金额
	 * @param Amt_dbzj
	 */
	public void setAmt_dbzj(FDouble Amt_dbzj) {
		setAttrVal("Amt_dbzj", Amt_dbzj);
	}
	/**
	 * 重特大疾病救助金额
	 * @return FDouble
	 */
	public FDouble getAmt_ztdjbjz() {
		return ((FDouble) getAttrVal("Amt_ztdjbjz"));
	}
	/**
	 * 重特大疾病救助金额
	 * @param Amt_ztdjbjz
	 */
	public void setAmt_ztdjbjz(FDouble Amt_ztdjbjz) {
		setAttrVal("Amt_ztdjbjz", Amt_ztdjbjz);
	}
	/**
	 * 护理天数
	 * @return String
	 */
	public String getDays_ci() {
		return ((String) getAttrVal("Days_ci"));
	}
	/**
	 * 护理天数
	 * @param Days_ci
	 */
	public void setDays_ci(String Days_ci) {
		setAttrVal("Days_ci", Days_ci);
	}
	/**
	 * 护理期内封锁天数
	 * @return String
	 */
	public String getDays_hlqnfs() {
		return ((String) getAttrVal("Days_hlqnfs"));
	}
	/**
	 * 护理期内封锁天数
	 * @param Days_hlqnfs
	 */
	public void setDays_hlqnfs(String Days_hlqnfs) {
		setAttrVal("Days_hlqnfs", Days_hlqnfs);
	}
	/**
	 * 护理定额费用
	 * @return FDouble
	 */
	public FDouble getAmt_ci_ed() {
		return ((FDouble) getAttrVal("Amt_ci_ed"));
	}
	/**
	 * 护理定额费用
	 * @param Amt_ci_ed
	 */
	public void setAmt_ci_ed(FDouble Amt_ci_ed) {
		setAttrVal("Amt_ci_ed", Amt_ci_ed);
	}
	/**
	 * 护理定额内统筹支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_ci_edtc() {
		return ((FDouble) getAttrVal("Amt_ci_edtc"));
	}
	/**
	 * 护理定额内统筹支付金额
	 * @param Amt_ci_edtc
	 */
	public void setAmt_ci_edtc(FDouble Amt_ci_edtc) {
		setAttrVal("Amt_ci_edtc", Amt_ci_edtc);
	}
	/**
	 * 生活照护补助金额
	 * @return FDouble
	 */
	public FDouble getAmt_shzhbz() {
		return ((FDouble) getAttrVal("Amt_shzhbz"));
	}
	/**
	 * 生活照护补助金额
	 * @param Amt_shzhbz
	 */
	public void setAmt_shzhbz(FDouble Amt_shzhbz) {
		setAttrVal("Amt_shzhbz", Amt_shzhbz);
	}
	/**
	 * 特殊人员统筹金支付
	 * @return FDouble
	 */
	public FDouble getAmt_tsrytc() {
		return ((FDouble) getAttrVal("Amt_tsrytc"));
	}
	/**
	 * 特殊人员统筹金支付
	 * @param Amt_tsrytc
	 */
	public void setAmt_tsrytc(FDouble Amt_tsrytc) {
		setAttrVal("Amt_tsrytc", Amt_tsrytc);
	}
	/**
	 * 生育基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_syjj() {
		return ((FDouble) getAttrVal("Amt_syjj"));
	}
	/**
	 * 生育基金支付
	 * @param Amt_syjj
	 */
	public void setAmt_syjj(FDouble Amt_syjj) {
		setAttrVal("Amt_syjj", Amt_syjj);
	}
	/**
	 * 省异地个人账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_syd_psn() {
		return ((FDouble) getAttrVal("Amt_syd_psn"));
	}
	/**
	 * 省异地个人账户支付
	 * @param Amt_syd_psn
	 */
	public void setAmt_syd_psn(FDouble Amt_syd_psn) {
		setAttrVal("Amt_syd_psn", Amt_syd_psn);
	}
	/**
	 * 个人性质
	 * @return String
	 */
	public String getPersontype() {
		return ((String) getAttrVal("Persontype"));
	}
	/**
	 * 个人性质
	 * @param Persontype
	 */
	public void setPersontype(String Persontype) {
		setAttrVal("Persontype", Persontype);
	}
	/**
	 * 是否转人工审核
	 * @return String
	 */
	public String getFg_manual() {
		return ((String) getAttrVal("Fg_manual"));
	}
	/**
	 * 是否转人工审核
	 * @param Fg_manual
	 */
	public void setFg_manual(String Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 是否精准扶贫
	 * @return String
	 */
	public String getFg_poor() {
		return ((String) getAttrVal("Fg_poor"));
	}
	/**
	 * 是否精准扶贫
	 * @param Fg_poor
	 */
	public void setFg_poor(String Fg_poor) {
		setAttrVal("Fg_poor", Fg_poor);
	}
	/**
	 * 基本段补偿比例
	 * @return FDouble
	 */
	public FDouble getAmt_baseratio() {
		return ((FDouble) getAttrVal("Amt_baseratio"));
	}
	/**
	 * 基本段补偿比例
	 * @param Amt_baseratio
	 */
	public void setAmt_baseratio(FDouble Amt_baseratio) {
		setAttrVal("Amt_baseratio", Amt_baseratio);
	}
	/**
	 * 限额标准
	 * @return FDouble
	 */
	public FDouble getAmt_limit() {
		return ((FDouble) getAttrVal("Amt_limit"));
	}
	/**
	 * 限额标准
	 * @param Amt_limit
	 */
	public void setAmt_limit(FDouble Amt_limit) {
		setAttrVal("Amt_limit", Amt_limit);
	}
	/**
	 * 拨付医院金额
	 * @return FDouble
	 */
	public FDouble getAmt_tohos() {
		return ((FDouble) getAttrVal("Amt_tohos"));
	}
	/**
	 * 拨付医院金额
	 * @param Amt_tohos
	 */
	public void setAmt_tohos(FDouble Amt_tohos) {
		setAttrVal("Amt_tohos", Amt_tohos);
	}
	/**
	 * 大写补偿金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp_upper() {
		return ((FDouble) getAttrVal("Amt_hp_upper"));
	}
	/**
	 * 大写补偿金额
	 * @param Amt_hp_upper
	 */
	public void setAmt_hp_upper(FDouble Amt_hp_upper) {
		setAttrVal("Amt_hp_upper", Amt_hp_upper);
	}
	/**
	 * 大病补偿金额(大写)
	 * @return FDouble
	 */
	public FDouble getAmt_bigill_upper() {
		return ((FDouble) getAttrVal("Amt_bigill_upper"));
	}
	/**
	 * 大病补偿金额(大写)
	 * @param Amt_bigill_upper
	 */
	public void setAmt_bigill_upper(FDouble Amt_bigill_upper) {
		setAttrVal("Amt_bigill_upper", Amt_bigill_upper);
	}
	/**
	 * 民政救助
	 * @return FDouble
	 */
	public FDouble getAmt_civil() {
		return ((FDouble) getAttrVal("Amt_civil"));
	}
	/**
	 * 民政救助
	 * @param Amt_civil
	 */
	public void setAmt_civil(FDouble Amt_civil) {
		setAttrVal("Amt_civil", Amt_civil);
	}
	/**
	 * 总补偿金额
	 * @return FDouble
	 */
	public FDouble getAmt_supplyall() {
		return ((FDouble) getAttrVal("Amt_supplyall"));
	}
	/**
	 * 总补偿金额
	 * @param Amt_supplyall
	 */
	public void setAmt_supplyall(FDouble Amt_supplyall) {
		setAttrVal("Amt_supplyall", Amt_supplyall);
	}
	/**
	 * 目录内金额
	 * @return FDouble
	 */
	public FDouble getAmt_incatalog() {
		return ((FDouble) getAttrVal("Amt_incatalog"));
	}
	/**
	 * 目录内金额
	 * @param Amt_incatalog
	 */
	public void setAmt_incatalog(FDouble Amt_incatalog) {
		setAttrVal("Amt_incatalog", Amt_incatalog);
	}
	/**
	 * 目录外金额
	 * @return FDouble
	 */
	public FDouble getAmt_outcatalog() {
		return ((FDouble) getAttrVal("Amt_outcatalog"));
	}
	/**
	 * 目录外金额
	 * @param Amt_outcatalog
	 */
	public void setAmt_outcatalog(FDouble Amt_outcatalog) {
		setAttrVal("Amt_outcatalog", Amt_outcatalog);
	}
	/**
	 * 患者实际补偿比例
	 * @return FDouble
	 */
	public FDouble getRatio_actual() {
		return ((FDouble) getAttrVal("Ratio_actual"));
	}
	/**
	 * 患者实际补偿比例
	 * @param Ratio_actual
	 */
	public void setRatio_actual(FDouble Ratio_actual) {
		setAttrVal("Ratio_actual", Ratio_actual);
	}
	/**
	 * 年度总费用(年度累计）
	 * @return FDouble
	 */
	public FDouble getAmt_year() {
		return ((FDouble) getAttrVal("Amt_year"));
	}
	/**
	 * 年度总费用(年度累计）
	 * @param Amt_year
	 */
	public void setAmt_year(FDouble Amt_year) {
		setAttrVal("Amt_year", Amt_year);
	}
	/**
	 * 基本段年度补偿额（年度累计）
	 * @return FDouble
	 */
	public FDouble getAmt_yearbase() {
		return ((FDouble) getAttrVal("Amt_yearbase"));
	}
	/**
	 * 基本段年度补偿额（年度累计）
	 * @param Amt_yearbase
	 */
	public void setAmt_yearbase(FDouble Amt_yearbase) {
		setAttrVal("Amt_yearbase", Amt_yearbase);
	}
	/**
	 * 大病年度补偿金额
	 * @return FDouble
	 */
	public FDouble getAmt_bigillyear() {
		return ((FDouble) getAttrVal("Amt_bigillyear"));
	}
	/**
	 * 大病年度补偿金额
	 * @param Amt_bigillyear
	 */
	public void setAmt_bigillyear(FDouble Amt_bigillyear) {
		setAttrVal("Amt_bigillyear", Amt_bigillyear);
	}
	/**
	 * 民政救助合规金额
	 * @return FDouble
	 */
	public FDouble getAmt_civil_reasonal() {
		return ((FDouble) getAttrVal("Amt_civil_reasonal"));
	}
	/**
	 * 民政救助合规金额
	 * @param Amt_civil_reasonal
	 */
	public void setAmt_civil_reasonal(FDouble Amt_civil_reasonal) {
		setAttrVal("Amt_civil_reasonal", Amt_civil_reasonal);
	}
	/**
	 * 民政救助历史合规金额
	 * @return FDouble
	 */
	public FDouble getAmt_civil_history() {
		return ((FDouble) getAttrVal("Amt_civil_history"));
	}
	/**
	 * 民政救助历史合规金额
	 * @param Amt_civil_history
	 */
	public void setAmt_civil_history(FDouble Amt_civil_history) {
		setAttrVal("Amt_civil_history", Amt_civil_history);
	}
	/**
	 * 民政救助金额历史合计
	 * @return FDouble
	 */
	public FDouble getAmt_civil_total() {
		return ((FDouble) getAttrVal("Amt_civil_total"));
	}
	/**
	 * 民政救助金额历史合计
	 * @param Amt_civil_total
	 */
	public void setAmt_civil_total(FDouble Amt_civil_total) {
		setAttrVal("Amt_civil_total", Amt_civil_total);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 纳入商业补充保险支出
	 * @return FDouble
	 */
	public FDouble getAmt_inbusinessinsure() {
		return ((FDouble) getAttrVal("Amt_inbusinessinsure"));
	}
	/**
	 * 纳入商业补充保险支出
	 * @param Amt_inbusinessinsure
	 */
	public void setAmt_inbusinessinsure(FDouble Amt_inbusinessinsure) {
		setAttrVal("Amt_inbusinessinsure", Amt_inbusinessinsure);
	}
	/**
	 * 纳入扶贫合规费用
	 * @return FDouble
	 */
	public FDouble getAmt_incivilassist() {
		return ((FDouble) getAttrVal("Amt_incivilassist"));
	}
	/**
	 * 纳入扶贫合规费用
	 * @param Amt_incivilassist
	 */
	public void setAmt_incivilassist(FDouble Amt_incivilassist) {
		setAttrVal("Amt_incivilassist", Amt_incivilassist);
	}
	/**
	 * 民政救助金额(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_civil_years() {
		return ((FDouble) getAttrVal("Amt_civil_years"));
	}
	/**
	 * 民政救助金额(年度累计)
	 * @param Amt_civil_years
	 */
	public void setAmt_civil_years(FDouble Amt_civil_years) {
		setAttrVal("Amt_civil_years", Amt_civil_years);
	}
	/**
	 * 特惠保险金额(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_fpthbx_years() {
		return ((FDouble) getAttrVal("Amt_fpthbx_years"));
	}
	/**
	 * 特惠保险金额(年度累计)
	 * @param Amt_fpthbx_years
	 */
	public void setAmt_fpthbx_years(FDouble Amt_fpthbx_years) {
		setAttrVal("Amt_fpthbx_years", Amt_fpthbx_years);
	}
	/**
	 * 重特大疾病救助金额(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_ztdjbjz_years() {
		return ((FDouble) getAttrVal("Amt_ztdjbjz_years"));
	}
	/**
	 * 重特大疾病救助金额(年度累计)
	 * @param Amt_ztdjbjz_years
	 */
	public void setAmt_ztdjbjz_years(FDouble Amt_ztdjbjz_years) {
		setAttrVal("Amt_ztdjbjz_years", Amt_ztdjbjz_years);
	}
	/**
	 * 纳入统筹额度(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_inhp_years() {
		return ((FDouble) getAttrVal("Amt_inhp_years"));
	}
	/**
	 * 纳入统筹额度(年度累计)
	 * @param Amt_inhp_years
	 */
	public void setAmt_inhp_years(FDouble Amt_inhp_years) {
		setAttrVal("Amt_inhp_years", Amt_inhp_years);
	}
	/**
	 * 纳入大额救助额度(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_inbigillcomple_years() {
		return ((FDouble) getAttrVal("Amt_inbigillcomple_years"));
	}
	/**
	 * 纳入大额救助额度(年度累计)
	 * @param Amt_inbigillcomple_years
	 */
	public void setAmt_inbigillcomple_years(FDouble Amt_inbigillcomple_years) {
		setAttrVal("Amt_inbigillcomple_years", Amt_inbigillcomple_years);
	}
	/**
	 * 纳入商保大病合规费用额度(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_inbusinessinsure_years() {
		return ((FDouble) getAttrVal("Amt_inbusinessinsure_years"));
	}
	/**
	 * 纳入商保大病合规费用额度(年度累计)
	 * @param Amt_inbusinessinsure_years
	 */
	public void setAmt_inbusinessinsure_years(FDouble Amt_inbusinessinsure_years) {
		setAttrVal("Amt_inbusinessinsure_years", Amt_inbusinessinsure_years);
	}
	/**
	 * 商保大病累计理赔金额(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_businessinsure_years() {
		return ((FDouble) getAttrVal("Amt_businessinsure_years"));
	}
	/**
	 * 商保大病累计理赔金额(年度累计)
	 * @param Amt_businessinsure_years
	 */
	public void setAmt_businessinsure_years(FDouble Amt_businessinsure_years) {
		setAttrVal("Amt_businessinsure_years", Amt_businessinsure_years);
	}
	/**
	 * 公务员补助(年度累计)
	 * @return FDouble
	 */
	public FDouble getAmt_civilservice_years() {
		return ((FDouble) getAttrVal("Amt_civilservice_years"));
	}
	/**
	 * 公务员补助(年度累计)
	 * @param Amt_civilservice_years
	 */
	public void setAmt_civilservice_years(FDouble Amt_civilservice_years) {
		setAttrVal("Amt_civilservice_years", Amt_civilservice_years);
	}
	/**
	 * 药品费用
	 * @return FDouble
	 */
	public FDouble getAmt_ypfy() {
		return ((FDouble) getAttrVal("Amt_ypfy"));
	}
	/**
	 * 药品费用
	 * @param Amt_ypfy
	 */
	public void setAmt_ypfy(FDouble Amt_ypfy) {
		setAttrVal("Amt_ypfy", Amt_ypfy);
	}
	/**
	 * 诊疗项目费用
	 * @return FDouble
	 */
	public FDouble getAmt_zlxmfy() {
		return ((FDouble) getAttrVal("Amt_zlxmfy"));
	}
	/**
	 * 诊疗项目费用
	 * @param Amt_zlxmfy
	 */
	public void setAmt_zlxmfy(FDouble Amt_zlxmfy) {
		setAttrVal("Amt_zlxmfy", Amt_zlxmfy);
	}
	/**
	 * 安装器官费用
	 * @return FDouble
	 */
	public FDouble getAmt_azqgfy() {
		return ((FDouble) getAttrVal("Amt_azqgfy"));
	}
	/**
	 * 安装器官费用
	 * @param Amt_azqgfy
	 */
	public void setAmt_azqgfy(FDouble Amt_azqgfy) {
		setAttrVal("Amt_azqgfy", Amt_azqgfy);
	}
	/**
	 * 单位分担金额
	 * @return FDouble
	 */
	public FDouble getAmt_dwfdje() {
		return ((FDouble) getAttrVal("Amt_dwfdje"));
	}
	/**
	 * 单位分担金额
	 * @param Amt_dwfdje
	 */
	public void setAmt_dwfdje(FDouble Amt_dwfdje) {
		setAttrVal("Amt_dwfdje", Amt_dwfdje);
	}
	/**
	 * 门诊诊查费
	 * @return FDouble
	 */
	public FDouble getAmt_mzzcf() {
		return ((FDouble) getAttrVal("Amt_mzzcf"));
	}
	/**
	 * 门诊诊查费
	 * @param Amt_mzzcf
	 */
	public void setAmt_mzzcf(FDouble Amt_mzzcf) {
		setAttrVal("Amt_mzzcf", Amt_mzzcf);
	}
	/**
	 * 公费医疗账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_gfylpsn() {
		return ((FDouble) getAttrVal("Amt_gfylpsn"));
	}
	/**
	 * 公费医疗账户支付
	 * @param Amt_gfylpsn
	 */
	public void setAmt_gfylpsn(FDouble Amt_gfylpsn) {
		setAttrVal("Amt_gfylpsn", Amt_gfylpsn);
	}
	/**
	 * 家庭门诊统筹支付
	 * @return FDouble
	 */
	public FDouble getAmt_familymzhp() {
		return ((FDouble) getAttrVal("Amt_familymzhp"));
	}
	/**
	 * 家庭门诊统筹支付
	 * @param Amt_familymzhp
	 */
	public void setAmt_familymzhp(FDouble Amt_familymzhp) {
		setAttrVal("Amt_familymzhp", Amt_familymzhp);
	}
	/**
	 * 乙类费用
	 * @return FDouble
	 */
	public FDouble getAmt_ylfy() {
		return ((FDouble) getAttrVal("Amt_ylfy"));
	}
	/**
	 * 乙类费用
	 * @param Amt_ylfy
	 */
	public void setAmt_ylfy(FDouble Amt_ylfy) {
		setAttrVal("Amt_ylfy", Amt_ylfy);
	}
	/**
	 * 甲类费用
	 * @return FDouble
	 */
	public FDouble getAmt_jlfy() {
		return ((FDouble) getAttrVal("Amt_jlfy"));
	}
	/**
	 * 甲类费用
	 * @param Amt_jlfy
	 */
	public void setAmt_jlfy(FDouble Amt_jlfy) {
		setAttrVal("Amt_jlfy", Amt_jlfy);
	}
	/**
	 * 丙类费用
	 * @return FDouble
	 */
	public FDouble getAmt_blfy() {
		return ((FDouble) getAttrVal("Amt_blfy"));
	}
	/**
	 * 丙类费用
	 * @param Amt_blfy
	 */
	public void setAmt_blfy(FDouble Amt_blfy) {
		setAttrVal("Amt_blfy", Amt_blfy);
	}
	/**
	 * 非医保自付
	 * @return FDouble
	 */
	public FDouble getAmt_fybzf() {
		return ((FDouble) getAttrVal("Amt_fybzf"));
	}
	/**
	 * 非医保自付
	 * @param Amt_fybzf
	 */
	public void setAmt_fybzf(FDouble Amt_fybzf) {
		setAttrVal("Amt_fybzf", Amt_fybzf);
	}
	/**
	 * 超大额封顶线费用
	 * @return FDouble
	 */
	public FDouble getAmt_overlargetop() {
		return ((FDouble) getAttrVal("Amt_overlargetop"));
	}
	/**
	 * 超大额封顶线费用
	 * @param Amt_overlargetop
	 */
	public void setAmt_overlargetop(FDouble Amt_overlargetop) {
		setAttrVal("Amt_overlargetop", Amt_overlargetop);
	}
	/**
	 * 报销总金额
	 * @return FDouble
	 */
	public FDouble getAmt_total_bx() {
		return ((FDouble) getAttrVal("Amt_total_bx"));
	}
	/**
	 * 报销总金额
	 * @param Amt_total_bx
	 */
	public void setAmt_total_bx(FDouble Amt_total_bx) {
		setAttrVal("Amt_total_bx", Amt_total_bx);
	}
	/**
	 * 人工器官自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_artificialorganself() {
		return ((FDouble) getAttrVal("Amt_artificialorganself"));
	}
	/**
	 * 人工器官自付费用
	 * @param Amt_artificialorganself
	 */
	public void setAmt_artificialorganself(FDouble Amt_artificialorganself) {
		setAttrVal("Amt_artificialorganself", Amt_artificialorganself);
	}
	/**
	 * 本年账户支付累计(不含本次)
	 * @return FDouble
	 */
	public FDouble getAccount_pay_total() {
		return ((FDouble) getAttrVal("Account_pay_total"));
	}
	/**
	 * 本年账户支付累计(不含本次)
	 * @param Account_pay_total
	 */
	public void setAccount_pay_total(FDouble Account_pay_total) {
		setAttrVal("Account_pay_total", Account_pay_total);
	}
	/**
	 * 业务周期号
	 * @return String
	 */
	public String getBizcyclecode() {
		return ((String) getAttrVal("Bizcyclecode"));
	}
	/**
	 * 业务周期号
	 * @param Bizcyclecode
	 */
	public void setBizcyclecode(String Bizcyclecode) {
		setAttrVal("Bizcyclecode", Bizcyclecode);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getBillno() {
		return ((String) getAttrVal("Billno"));
	}
	/**
	 * 单据号
	 * @param Billno
	 */
	public void setBillno(String Billno) {
		setAttrVal("Billno", Billno);
	}
	/**
	 * 有效标志
	 * @return String
	 */
	public String getFg_effe() {
		return ((String) getAttrVal("Fg_effe"));
	}
	/**
	 * 有效标志
	 * @param Fg_effe
	 */
	public void setFg_effe(String Fg_effe) {
		setAttrVal("Fg_effe", Fg_effe);
	}
	/**
	 * 接收方交易流水号
	 * @return String
	 */
	public String getRecieverserialno() {
		return ((String) getAttrVal("Recieverserialno"));
	}
	/**
	 * 接收方交易流水号
	 * @param Recieverserialno
	 */
	public void setRecieverserialno(String Recieverserialno) {
		setAttrVal("Recieverserialno", Recieverserialno);
	}
	/**
	 * 二次补偿金额
	 * @return String
	 */
	public String getAmt_twocompensation() {
		return ((String) getAttrVal("Amt_twocompensation"));
	}
	/**
	 * 二次补偿金额
	 * @param Amt_twocompensation
	 */
	public void setAmt_twocompensation(String Amt_twocompensation) {
		setAttrVal("Amt_twocompensation", Amt_twocompensation);
	}
	/**
	 * 单病种补差
	 * @return FDouble
	 */
	public FDouble getAmt_singlecompen() {
		return ((FDouble) getAttrVal("Amt_singlecompen"));
	}
	/**
	 * 单病种补差
	 * @param Amt_singlecompen
	 */
	public void setAmt_singlecompen(FDouble Amt_singlecompen) {
		setAttrVal("Amt_singlecompen", Amt_singlecompen);
	}
	/**
	 * 二类门慢限额剩余
	 * @return FDouble
	 */
	public FDouble getTwooepchrremain() {
		return ((FDouble) getAttrVal("Twooepchrremain"));
	}
	/**
	 * 二类门慢限额剩余
	 * @param Twooepchrremain
	 */
	public void setTwooepchrremain(FDouble Twooepchrremain) {
		setAttrVal("Twooepchrremain", Twooepchrremain);
	}
	/**
	 * 二类门慢限额支出（景德镇）门慢限额支出（省本级）
	 * @return FDouble
	 */
	public FDouble getOepchronicexp() {
		return ((FDouble) getAttrVal("Oepchronicexp"));
	}
	/**
	 * 二类门慢限额支出（景德镇）门慢限额支出（省本级）
	 * @param Oepchronicexp
	 */
	public void setOepchronicexp(FDouble Oepchronicexp) {
		setAttrVal("Oepchronicexp", Oepchronicexp);
	}
	/**
	 * 居民二次补偿（大病支付）
	 * @return FDouble
	 */
	public FDouble getAmt_jmtwocompen() {
		return ((FDouble) getAttrVal("Amt_jmtwocompen"));
	}
	/**
	 * 居民二次补偿（大病支付）
	 * @param Amt_jmtwocompen
	 */
	public void setAmt_jmtwocompen(FDouble Amt_jmtwocompen) {
		setAttrVal("Amt_jmtwocompen", Amt_jmtwocompen);
	}
	/**
	 * 体检金额
	 * @return FDouble
	 */
	public FDouble getAmt_physicalexam() {
		return ((FDouble) getAttrVal("Amt_physicalexam"));
	}
	/**
	 * 体检金额
	 * @param Amt_physicalexam
	 */
	public void setAmt_physicalexam(FDouble Amt_physicalexam) {
		setAttrVal("Amt_physicalexam", Amt_physicalexam);
	}
	/**
	 * 居民大病一段金额
	 * @return FDouble
	 */
	public FDouble getAmt_jmbigill_one() {
		return ((FDouble) getAttrVal("Amt_jmbigill_one"));
	}
	/**
	 * 居民大病一段金额
	 * @param Amt_jmbigill_one
	 */
	public void setAmt_jmbigill_one(FDouble Amt_jmbigill_one) {
		setAttrVal("Amt_jmbigill_one", Amt_jmbigill_one);
	}
	/**
	 * 居民大病二段金额
	 * @return FDouble
	 */
	public FDouble getAmt_jmbigill_two() {
		return ((FDouble) getAttrVal("Amt_jmbigill_two"));
	}
	/**
	 * 居民大病二段金额
	 * @param Amt_jmbigill_two
	 */
	public void setAmt_jmbigill_two(FDouble Amt_jmbigill_two) {
		setAttrVal("Amt_jmbigill_two", Amt_jmbigill_two);
	}
	/**
	 * 疾病补充范围内费用支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_diseasesuppin() {
		return ((FDouble) getAttrVal("Amt_diseasesuppin"));
	}
	/**
	 * 疾病补充范围内费用支付金额
	 * @param Amt_diseasesuppin
	 */
	public void setAmt_diseasesuppin(FDouble Amt_diseasesuppin) {
		setAttrVal("Amt_diseasesuppin", Amt_diseasesuppin);
	}
	/**
	 * 疾病补充保险本次政策范围外费用支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_diseasesuppout() {
		return ((FDouble) getAttrVal("Amt_diseasesuppout"));
	}
	/**
	 * 疾病补充保险本次政策范围外费用支付金额
	 * @param Amt_diseasesuppout
	 */
	public void setAmt_diseasesuppout(FDouble Amt_diseasesuppout) {
		setAttrVal("Amt_diseasesuppout", Amt_diseasesuppout);
	}
	/**
	 * 美国微笑列车基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_smiletrainpay() {
		return ((FDouble) getAttrVal("Amt_smiletrainpay"));
	}
	/**
	 * 美国微笑列车基金支付
	 * @param Amt_smiletrainpay
	 */
	public void setAmt_smiletrainpay(FDouble Amt_smiletrainpay) {
		setAttrVal("Amt_smiletrainpay", Amt_smiletrainpay);
	}
	/**
	 * 九江居民政策范围外可报销费用
	 * @return FDouble
	 */
	public FDouble getJmpolicyscopeout() {
		return ((FDouble) getAttrVal("Jmpolicyscopeout"));
	}
	/**
	 * 九江居民政策范围外可报销费用
	 * @param Jmpolicyscopeout
	 */
	public void setJmpolicyscopeout(FDouble Jmpolicyscopeout) {
		setAttrVal("Jmpolicyscopeout", Jmpolicyscopeout);
	}
	/**
	 * 免费门诊基金（余江）
	 * @return FDouble
	 */
	public FDouble getFreeopfund() {
		return ((FDouble) getAttrVal("Freeopfund"));
	}
	/**
	 * 免费门诊基金（余江）
	 * @param Freeopfund
	 */
	public void setFreeopfund(FDouble Freeopfund) {
		setAttrVal("Freeopfund", Freeopfund);
	}
	/**
	 * 建档大病补偿本次一段支付金额
	 * @return FDouble
	 */
	public FDouble getBigill_one_zfamt() {
		return ((FDouble) getAttrVal("Bigill_one_zfamt"));
	}
	/**
	 * 建档大病补偿本次一段支付金额
	 * @param Bigill_one_zfamt
	 */
	public void setBigill_one_zfamt(FDouble Bigill_one_zfamt) {
		setAttrVal("Bigill_one_zfamt", Bigill_one_zfamt);
	}
	/**
	 * 建档大病补偿本次二段支付金额
	 * @return FDouble
	 */
	public FDouble getBigill_two_zfamt() {
		return ((FDouble) getAttrVal("Bigill_two_zfamt"));
	}
	/**
	 * 建档大病补偿本次二段支付金额
	 * @param Bigill_two_zfamt
	 */
	public void setBigill_two_zfamt(FDouble Bigill_two_zfamt) {
		setAttrVal("Bigill_two_zfamt", Bigill_two_zfamt);
	}
	/**
	 * 建档大病补偿本次三段支付金额
	 * @return FDouble
	 */
	public FDouble getBigill_three_zfamt() {
		return ((FDouble) getAttrVal("Bigill_three_zfamt"));
	}
	/**
	 * 建档大病补偿本次三段支付金额
	 * @param Bigill_three_zfamt
	 */
	public void setBigill_three_zfamt(FDouble Bigill_three_zfamt) {
		setAttrVal("Bigill_three_zfamt", Bigill_three_zfamt);
	}
	/**
	 * 建档二次补偿本次一段支付金额
	 * @return FDouble
	 */
	public FDouble getTwice_one_zfamt() {
		return ((FDouble) getAttrVal("Twice_one_zfamt"));
	}
	/**
	 * 建档二次补偿本次一段支付金额
	 * @param Twice_one_zfamt
	 */
	public void setTwice_one_zfamt(FDouble Twice_one_zfamt) {
		setAttrVal("Twice_one_zfamt", Twice_one_zfamt);
	}
	/**
	 * 建档二次补偿本次二段支付金额
	 * @return FDouble
	 */
	public FDouble getTwice_two_zfamt() {
		return ((FDouble) getAttrVal("Twice_two_zfamt"));
	}
	/**
	 * 建档二次补偿本次二段支付金额
	 * @param Twice_two_zfamt
	 */
	public void setTwice_two_zfamt(FDouble Twice_two_zfamt) {
		setAttrVal("Twice_two_zfamt", Twice_two_zfamt);
	}
	/**
	 * 建档二次补偿本次三段支付金额
	 * @return FDouble
	 */
	public FDouble getTwice_three_zfamt() {
		return ((FDouble) getAttrVal("Twice_three_zfamt"));
	}
	/**
	 * 建档二次补偿本次三段支付金额
	 * @param Twice_three_zfamt
	 */
	public void setTwice_three_zfamt(FDouble Twice_three_zfamt) {
		setAttrVal("Twice_three_zfamt", Twice_three_zfamt);
	}
	/**
	 * 疾病补充保险本次政策范围内费用一段支付金额
	 * @return FDouble
	 */
	public FDouble getPolicyin_one_zfamt() {
		return ((FDouble) getAttrVal("Policyin_one_zfamt"));
	}
	/**
	 * 疾病补充保险本次政策范围内费用一段支付金额
	 * @param Policyin_one_zfamt
	 */
	public void setPolicyin_one_zfamt(FDouble Policyin_one_zfamt) {
		setAttrVal("Policyin_one_zfamt", Policyin_one_zfamt);
	}
	/**
	 * 疾病补充保险本次政策范围内费用二段支付金额
	 * @return FDouble
	 */
	public FDouble getPolicyin_two_zfamt() {
		return ((FDouble) getAttrVal("Policyin_two_zfamt"));
	}
	/**
	 * 疾病补充保险本次政策范围内费用二段支付金额
	 * @param Policyin_two_zfamt
	 */
	public void setPolicyin_two_zfamt(FDouble Policyin_two_zfamt) {
		setAttrVal("Policyin_two_zfamt", Policyin_two_zfamt);
	}
	/**
	 * 本年政府兜底基金费用累计(不含本次)
	 * @return FDouble
	 */
	public FDouble getGovfundtotal() {
		return ((FDouble) getAttrVal("Govfundtotal"));
	}
	/**
	 * 本年政府兜底基金费用累计(不含本次)
	 * @param Govfundtotal
	 */
	public void setGovfundtotal(FDouble Govfundtotal) {
		setAttrVal("Govfundtotal", Govfundtotal);
	}
	/**
	 * 门慢限额
	 * @return FDouble
	 */
	public FDouble getOepchroniclimit() {
		return ((FDouble) getAttrVal("Oepchroniclimit"));
	}
	/**
	 * 门慢限额
	 * @param Oepchroniclimit
	 */
	public void setOepchroniclimit(FDouble Oepchroniclimit) {
		setAttrVal("Oepchroniclimit", Oepchroniclimit);
	}
	/**
	 * 企业军转干基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_comjzgfound() {
		return ((FDouble) getAttrVal("Amt_comjzgfound"));
	}
	/**
	 * 企业军转干基金支付
	 * @param Amt_comjzgfound
	 */
	public void setAmt_comjzgfound(FDouble Amt_comjzgfound) {
		setAttrVal("Amt_comjzgfound", Amt_comjzgfound);
	}
	/**
	 * 伤残人员医疗保障基金
	 * @return FDouble
	 */
	public FDouble getAmt_disabilityfound() {
		return ((FDouble) getAttrVal("Amt_disabilityfound"));
	}
	/**
	 * 伤残人员医疗保障基金
	 * @param Amt_disabilityfound
	 */
	public void setAmt_disabilityfound(FDouble Amt_disabilityfound) {
		setAttrVal("Amt_disabilityfound", Amt_disabilityfound);
	}
	/**
	 * 丙类自理费用
	 * @return String
	 */
	public String getAmt_blzl() {
		return ((String) getAttrVal("Amt_blzl"));
	}
	/**
	 * 丙类自理费用
	 * @param Amt_blzl
	 */
	public void setAmt_blzl(String Amt_blzl) {
		setAttrVal("Amt_blzl", Amt_blzl);
	}
	/**
	 * 进入大额报销费用
	 * @return String
	 */
	public String getAmt_inlargesupply() {
		return ((String) getAttrVal("Amt_inlargesupply"));
	}
	/**
	 * 进入大额报销费用
	 * @param Amt_inlargesupply
	 */
	public void setAmt_inlargesupply(String Amt_inlargesupply) {
		setAttrVal("Amt_inlargesupply", Amt_inlargesupply);
	}
	/**
	 * 大额分段自付费用
	 * @return String
	 */
	public String getAmt_largesegself() {
		return ((String) getAttrVal("Amt_largesegself"));
	}
	/**
	 * 大额分段自付费用
	 * @param Amt_largesegself
	 */
	public void setAmt_largesegself(String Amt_largesegself) {
		setAttrVal("Amt_largesegself", Amt_largesegself);
	}
	/**
	 * 本年住院次数累计(不含本次)
	 * @return String
	 */
	public String getIp_times_toatal() {
		return ((String) getAttrVal("Ip_times_toatal"));
	}
	/**
	 * 本年住院次数累计(不含本次)
	 * @param Ip_times_toatal
	 */
	public void setIp_times_toatal(String Ip_times_toatal) {
		setAttrVal("Ip_times_toatal", Ip_times_toatal);
	}
	/**
	 * 经办机构编码
	 * @return String
	 */
	public String getHandlecode() {
		return ((String) getAttrVal("Handlecode"));
	}
	/**
	 * 经办机构编码
	 * @param Handlecode
	 */
	public void setHandlecode(String Handlecode) {
		setAttrVal("Handlecode", Handlecode);
	}
	/**
	 * 个人编号管理
	 * @return String
	 */
	public String getPersoncodemag() {
		return ((String) getAttrVal("Personcodemag"));
	}
	/**
	 * 个人编号管理
	 * @param Personcodemag
	 */
	public void setPersoncodemag(String Personcodemag) {
		setAttrVal("Personcodemag", Personcodemag);
	}
	/**
	 * 民政救助理赔金额
	 * @return String
	 */
	public String getClaims_civil_type() {
		return ((String) getAttrVal("Claims_civil_type"));
	}
	/**
	 * 民政救助理赔金额
	 * @param Claims_civil_type
	 */
	public void setClaims_civil_type(String Claims_civil_type) {
		setAttrVal("Claims_civil_type", Claims_civil_type);
	}
	/**
	 * 救助类型
	 * @return String
	 */
	public String getName_mzjz() {
		return ((String) getAttrVal("Name_mzjz"));
	}
	/**
	 * 救助类型
	 * @param Name_mzjz
	 */
	public void setName_mzjz(String Name_mzjz) {
		setAttrVal("Name_mzjz", Name_mzjz);
	}
	/**
	 * his住院结算ID
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * his住院结算ID
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 结算编号
	 * @return String
	 */
	public String getSettlement_code() {
		return ((String) getAttrVal("Settlement_code"));
	}
	/**
	 * 结算编号
	 * @param Settlement_code
	 */
	public void setSettlement_code(String Settlement_code) {
		setAttrVal("Settlement_code", Settlement_code);
	}
	/**
	 * 补充报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_supplyhp() {
		return ((FDouble) getAttrVal("Amt_supplyhp"));
	}
	/**
	 * 补充报销金额
	 * @param Amt_supplyhp
	 */
	public void setAmt_supplyhp(FDouble Amt_supplyhp) {
		setAttrVal("Amt_supplyhp", Amt_supplyhp);
	}
	/**
	 * 离休人员医疗保障基金支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_lxryfund() {
		return ((FDouble) getAttrVal("Amt_lxryfund"));
	}
	/**
	 * 离休人员医疗保障基金支付金额
	 * @param Amt_lxryfund
	 */
	public void setAmt_lxryfund(FDouble Amt_lxryfund) {
		setAttrVal("Amt_lxryfund", Amt_lxryfund);
	}
	/**
	 * 老红军医疗保障基金支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_lhjfund() {
		return ((FDouble) getAttrVal("Amt_lhjfund"));
	}
	/**
	 * 老红军医疗保障基金支付金额
	 * @param Amt_lhjfund
	 */
	public void setAmt_lhjfund(FDouble Amt_lhjfund) {
		setAttrVal("Amt_lhjfund", Amt_lhjfund);
	}
	/**
	 * 二乙医疗专项医疗基金支出
	 * @return FDouble
	 */
	public FDouble getAmt_eyylfund() {
		return ((FDouble) getAttrVal("Amt_eyylfund"));
	}
	/**
	 * 二乙医疗专项医疗基金支出
	 * @param Amt_eyylfund
	 */
	public void setAmt_eyylfund(FDouble Amt_eyylfund) {
		setAttrVal("Amt_eyylfund", Amt_eyylfund);
	}
	/**
	 * 医疗工伤报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_njury() {
		return ((FDouble) getAttrVal("Amt_njury"));
	}
	/**
	 * 医疗工伤报销金额
	 * @param Amt_njury
	 */
	public void setAmt_njury(FDouble Amt_njury) {
		setAttrVal("Amt_njury", Amt_njury);
	}
	/**
	 * 失业基金支出
	 * @return FDouble
	 */
	public FDouble getAmt_unemployment() {
		return ((FDouble) getAttrVal("Amt_unemployment"));
	}
	/**
	 * 失业基金支出
	 * @param Amt_unemployment
	 */
	public void setAmt_unemployment(FDouble Amt_unemployment) {
		setAttrVal("Amt_unemployment", Amt_unemployment);
	}
	/**
	 * 其他待遇报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_other_treatment() {
		return ((FDouble) getAttrVal("Amt_other_treatment"));
	}
	/**
	 * 其他待遇报销金额
	 * @param Amt_other_treatment
	 */
	public void setAmt_other_treatment(FDouble Amt_other_treatment) {
		setAttrVal("Amt_other_treatment", Amt_other_treatment);
	}
	/**
	 * 清算类别
	 * @return String
	 */
	public String getClearing_tp() {
		return ((String) getAttrVal("Clearing_tp"));
	}
	/**
	 * 清算类别
	 * @param Clearing_tp
	 */
	public void setClearing_tp(String Clearing_tp) {
		setAttrVal("Clearing_tp", Clearing_tp);
	}
	/**
	 * 清算分中心
	 * @return String
	 */
	public String getClearingcenter() {
		return ((String) getAttrVal("Clearingcenter"));
	}
	/**
	 * 清算分中心
	 * @param Clearingcenter
	 */
	public void setClearingcenter(String Clearingcenter) {
		setAttrVal("Clearingcenter", Clearingcenter);
	}
	/**
	 * 分级诊疗下浮比例
	 * @return FDouble
	 */
	public FDouble getScalelower_ratio() {
		return ((FDouble) getAttrVal("Scalelower_ratio"));
	}
	/**
	 * 分级诊疗下浮比例
	 * @param Scalelower_ratio
	 */
	public void setScalelower_ratio(FDouble Scalelower_ratio) {
		setAttrVal("Scalelower_ratio", Scalelower_ratio);
	}
	/**
	 * 其他单位报销 
	 * @return FDouble
	 */
	public FDouble getAmt_otherworkunit() {
		return ((FDouble) getAttrVal("Amt_otherworkunit"));
	}
	/**
	 * 其他单位报销 
	 * @param Amt_otherworkunit
	 */
	public void setAmt_otherworkunit(FDouble Amt_otherworkunit) {
		setAttrVal("Amt_otherworkunit", Amt_otherworkunit);
	}
	/**
	 * 亲属账户抵扣金额
	 * @return FDouble
	 */
	public FDouble getAmt_relatives() {
		return ((FDouble) getAttrVal("Amt_relatives"));
	}
	/**
	 * 亲属账户抵扣金额
	 * @param Amt_relatives
	 */
	public void setAmt_relatives(FDouble Amt_relatives) {
		setAttrVal("Amt_relatives", Amt_relatives);
	}
	/**
	 * 单病种编码
	 * @return String
	 */
	public String getCode_singledisease() {
		return ((String) getAttrVal("Code_singledisease"));
	}
	/**
	 * 单病种编码
	 * @param Code_singledisease
	 */
	public void setCode_singledisease(String Code_singledisease) {
		setAttrVal("Code_singledisease", Code_singledisease);
	}
	/**
	 * 单病种名称
	 * @return String
	 */
	public String getName_singledisease() {
		return ((String) getAttrVal("Name_singledisease"));
	}
	/**
	 * 单病种名称
	 * @param Name_singledisease
	 */
	public void setName_singledisease(String Name_singledisease) {
		setAttrVal("Name_singledisease", Name_singledisease);
	}
}