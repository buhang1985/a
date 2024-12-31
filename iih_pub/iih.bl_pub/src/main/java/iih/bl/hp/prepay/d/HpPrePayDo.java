package iih.bl.hp.prepay.d;

import iih.bl.hp.prepay.d.desc.HpPrePayDoDesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 医保预结算 DO数据 
 * 
 */
public class HpPrePayDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保预结算主键
	public static final String ID_HPPREPAY= "Id_hpprepay";
	//组织主键
	public static final String ID_ORG= "Id_org";
	//集团主键
	public static final String ID_GRP= "Id_grp";
	//登记流水号
	public static final String REGISTNO= "Registno";
	//就诊主键
	public static final String ID_ENT= "Id_ent";
	//就诊编码
	public static final String CODE_ENT= "Code_ent";
	//患者主键
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//定点医疗机构编号
	public static final String CODE_HOSP= "Code_hosp";
	//个人编号
	public static final String PERSONCODE= "Personcode";
	//单据号
	public static final String CODE_BILL= "Code_bill";
	//交易类型
	public static final String TRADETP= "Tradetp";
	//医院交易流水号
	public static final String CODE_HIS= "Code_his";
	//中心交易流水号
	public static final String CODE_HP= "Code_hp";
	//医疗费总额
	public static final String AMT_ALL= "Amt_all";
	//基本医疗账户支付
	public static final String AMT_PSN= "Amt_psn";
	//医保基金
	public static final String AMT_HP= "Amt_hp";
	//现金支付
	public static final String AMT_CASH= "Amt_cash";
	//医保定点支付
	public static final String AMT_HOSBEAR= "Amt_hosbear";
	//住院次数
	public static final String IP_TIMES= "Ip_times";
	//预结算时间
	public static final String DT_PREST= "Dt_prest";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保预结算主键
	 * @return String
	 */
	public String getId_hpprepay() {
		return ((String) getAttrVal("Id_hpprepay"));
	}	
	/**
	 * 医保预结算主键
	 * @param Id_hpprepay
	 */
	public void setId_hpprepay(String Id_hpprepay) {
		setAttrVal("Id_hpprepay", Id_hpprepay);
	}
	/**
	 * 组织主键
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织主键
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团主键
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团主键
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 登记流水号
	 * @return String
	 */
	public String getRegistno() {
		return ((String) getAttrVal("Registno"));
	}	
	/**
	 * 登记流水号
	 * @param Registno
	 */
	public void setRegistno(String Registno) {
		setAttrVal("Registno", Registno);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 定点医疗机构编号
	 * @return String
	 */
	public String getCode_hosp() {
		return ((String) getAttrVal("Code_hosp"));
	}	
	/**
	 * 定点医疗机构编号
	 * @param Code_hosp
	 */
	public void setCode_hosp(String Code_hosp) {
		setAttrVal("Code_hosp", Code_hosp);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}	
	/**
	 * 个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode_bill() {
		return ((String) getAttrVal("Code_bill"));
	}	
	/**
	 * 单据号
	 * @param Code_bill
	 */
	public void setCode_bill(String Code_bill) {
		setAttrVal("Code_bill", Code_bill);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTradetp() {
		return ((String) getAttrVal("Tradetp"));
	}	
	/**
	 * 交易类型
	 * @param Tradetp
	 */
	public void setTradetp(String Tradetp) {
		setAttrVal("Tradetp", Tradetp);
	}
	/**
	 * 医院交易流水号
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}	
	/**
	 * 医院交易流水号
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * 中心交易流水号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 中心交易流水号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医疗费总额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}	
	/**
	 * 医疗费总额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 基本医疗账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}	
	/**
	 * 基本医疗账户支付
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 医保基金
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 医保基金
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}	
	/**
	 * 现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 医保定点支付
	 * @return FDouble
	 */
	public FDouble getAmt_hosbear() {
		return ((FDouble) getAttrVal("Amt_hosbear"));
	}	
	/**
	 * 医保定点支付
	 * @param Amt_hosbear
	 */
	public void setAmt_hosbear(FDouble Amt_hosbear) {
		setAttrVal("Amt_hosbear", Amt_hosbear);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getIp_times() {
		return ((Integer) getAttrVal("Ip_times"));
	}	
	/**
	 * 住院次数
	 * @param Ip_times
	 */
	public void setIp_times(Integer Ip_times) {
		setAttrVal("Ip_times", Ip_times);
	}
	/**
	 * 预结算时间
	 * @return FDateTime
	 */
	public FDateTime getDt_prest() {
		return ((FDateTime) getAttrVal("Dt_prest"));
	}	
	/**
	 * 预结算时间
	 * @param Dt_prest
	 */
	public void setDt_prest(FDateTime Dt_prest) {
		setAttrVal("Dt_prest", Dt_prest);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_hpprepay";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_prepay";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpPrePayDoDesc.class);
	}
	
}