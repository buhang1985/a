package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊发票 DO数据 
 * 
 */
public class BlIncOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//发票主键
	public static final String ID_INCOEP= "Id_incoep";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//收退费方向
	public static final String EU_DIRECT= "Eu_direct";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//票据包编号
	public static final String CODE_INCPKG= "Code_incpkg";
	//发票号码
	public static final String INCNO= "Incno";
	//发票日期
	public static final String DT_INC= "Dt_inc";
	//金额_合计
	public static final String AMT= "Amt";
	//金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//总金额_标准
	public static final String AMT_STD= "Amt_std";
	//金额_价格比例
	public static final String AMT_RATIO= "Amt_ratio";
	//总金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//减免方式
	public static final String EU_FREEMD= "Eu_freemd";
	//减免金额
	public static final String AMT_FREE= "Amt_free";
	//医保自付减免金额
	public static final String AMT_HP_FREE= "Amt_hp_free";
	//项目减免金额
	public static final String AMT_PAT_FREE= "Amt_pat_free";
	//发票金额描述信息
	public static final String NOTE= "Note";
	//发票开立人员
	public static final String ID_EMP_INC= "Id_emp_inc";
	//发票打印次数
	public static final String TIMES_PRN= "Times_prn";
	//发票作废标志
	public static final String FG_CANC= "Fg_canc";
	//发票作废原因
	public static final String ID_REASON_CANC= "Id_reason_canc";
	//发票作废原因编码
	public static final String SD_REASON_CANC= "Sd_reason_canc";
	//发票作废原因描述
	public static final String DES_REASON_CANC= "Des_reason_canc";
	//发票作废日期
	public static final String DT_CANC= "Dt_canc";
	//发票作废操作人
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属结算
	public static final String ID_STOEP= "Id_stoep";
	//已打印标志
	public static final String FG_PRINT= "Fg_print";
	//结账标志_出票
	public static final String FG_CC_OUT= "Fg_cc_out";
	//操作员结账_出票
	public static final String ID_CC_OUT= "Id_cc_out";
	//结账标志_退票
	public static final String FG_CC_IN= "Fg_cc_in";
	//操作员结账_退票
	public static final String ID_CC_IN= "Id_cc_in";
	//发票开立科室
	public static final String ID_DEP_INC= "Id_dep_inc";
	//发票退票科室
	public static final String ID_DEP_CANC= "Id_dep_canc";
	//医保基金支付标志
	public static final String FG_FUNDPAY= "Fg_fundpay";
	//是否持卡标志
	public static final String FG_HP_CARD= "Fg_hp_card";
	//计算机
	public static final String ID_PC= "Id_pc";
	//出票方式
	public static final String EU_PRINTMD= "Eu_printmd";
	//电子发票标志
	public static final String FG_EC_INC= "Fg_ec_inc";
	//电子票据代码
	public static final String EC_INC_CODE= "Ec_inc_code";
	//电子票据校验码
	public static final String EC_INC_CHECKNO= "Ec_inc_checkno";
	//电子票据url
	public static final String EC_URL= "Ec_url";
	//电子票据外网url
	public static final String EC_NET_URL= "Ec_net_url";
	//患者编码
	public static final String PATCODE= "Patcode";
	//患者姓名
	public static final String PATNAME= "Patname";
	//票据分类编码
	public static final String INCCA_CODE= "Incca_code";
	//票据分类名称
	public static final String INCCA_NAME= "Incca_name";
	//票据包编号
	public static final String OEP_CODEINCPKG= "Oep_codeincpkg";
	//姓名
	public static final String ID_EMP_INC_NAME= "Id_emp_inc_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 发票主键
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}	
	/**
	 * 发票主键
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 收退费方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 收退费方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 票据分类
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	/**
	 * 票据包编号
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}	
	/**
	 * 发票号码
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}	
	/**
	 * 发票日期
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
	/**
	 * 金额_合计
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 金额_合计
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 金额_患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 金额_患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 总金额_标准
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	/**
	 * 总金额_标准
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 金额_价格比例
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 金额_价格比例
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 总金额_医保计划
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 总金额_医保计划
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 减免方式
	 * @return Integer
	 */
	public Integer getEu_freemd() {
		return ((Integer) getAttrVal("Eu_freemd"));
	}	
	/**
	 * 减免方式
	 * @param Eu_freemd
	 */
	public void setEu_freemd(Integer Eu_freemd) {
		setAttrVal("Eu_freemd", Eu_freemd);
	}
	/**
	 * 减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}	
	/**
	 * 减免金额
	 * @param Amt_free
	 */
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 医保自付减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp_free() {
		return ((FDouble) getAttrVal("Amt_hp_free"));
	}	
	/**
	 * 医保自付减免金额
	 * @param Amt_hp_free
	 */
	public void setAmt_hp_free(FDouble Amt_hp_free) {
		setAttrVal("Amt_hp_free", Amt_hp_free);
	}
	/**
	 * 项目减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat_free() {
		return ((FDouble) getAttrVal("Amt_pat_free"));
	}	
	/**
	 * 项目减免金额
	 * @param Amt_pat_free
	 */
	public void setAmt_pat_free(FDouble Amt_pat_free) {
		setAttrVal("Amt_pat_free", Amt_pat_free);
	}
	/**
	 * 发票金额描述信息
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 发票金额描述信息
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 发票开立人员
	 * @return String
	 */
	public String getId_emp_inc() {
		return ((String) getAttrVal("Id_emp_inc"));
	}	
	/**
	 * 发票开立人员
	 * @param Id_emp_inc
	 */
	public void setId_emp_inc(String Id_emp_inc) {
		setAttrVal("Id_emp_inc", Id_emp_inc);
	}
	/**
	 * 发票打印次数
	 * @return Integer
	 */
	public Integer getTimes_prn() {
		return ((Integer) getAttrVal("Times_prn"));
	}	
	/**
	 * 发票打印次数
	 * @param Times_prn
	 */
	public void setTimes_prn(Integer Times_prn) {
		setAttrVal("Times_prn", Times_prn);
	}
	/**
	 * 发票作废标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 发票作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 发票作废原因
	 * @return String
	 */
	public String getId_reason_canc() {
		return ((String) getAttrVal("Id_reason_canc"));
	}	
	/**
	 * 发票作废原因
	 * @param Id_reason_canc
	 */
	public void setId_reason_canc(String Id_reason_canc) {
		setAttrVal("Id_reason_canc", Id_reason_canc);
	}
	/**
	 * 发票作废原因编码
	 * @return String
	 */
	public String getSd_reason_canc() {
		return ((String) getAttrVal("Sd_reason_canc"));
	}	
	/**
	 * 发票作废原因编码
	 * @param Sd_reason_canc
	 */
	public void setSd_reason_canc(String Sd_reason_canc) {
		setAttrVal("Sd_reason_canc", Sd_reason_canc);
	}
	/**
	 * 发票作废原因描述
	 * @return String
	 */
	public String getDes_reason_canc() {
		return ((String) getAttrVal("Des_reason_canc"));
	}	
	/**
	 * 发票作废原因描述
	 * @param Des_reason_canc
	 */
	public void setDes_reason_canc(String Des_reason_canc) {
		setAttrVal("Des_reason_canc", Des_reason_canc);
	}
	/**
	 * 发票作废日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 发票作废日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 发票作废操作人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 发票作废操作人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
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
	/**
	 * 所属结算
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	/**
	 * 所属结算
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 已打印标志
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}	
	/**
	 * 已打印标志
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 结账标志_出票
	 * @return FBoolean
	 */
	public FBoolean getFg_cc_out() {
		return ((FBoolean) getAttrVal("Fg_cc_out"));
	}	
	/**
	 * 结账标志_出票
	 * @param Fg_cc_out
	 */
	public void setFg_cc_out(FBoolean Fg_cc_out) {
		setAttrVal("Fg_cc_out", Fg_cc_out);
	}
	/**
	 * 操作员结账_出票
	 * @return String
	 */
	public String getId_cc_out() {
		return ((String) getAttrVal("Id_cc_out"));
	}	
	/**
	 * 操作员结账_出票
	 * @param Id_cc_out
	 */
	public void setId_cc_out(String Id_cc_out) {
		setAttrVal("Id_cc_out", Id_cc_out);
	}
	/**
	 * 结账标志_退票
	 * @return FBoolean
	 */
	public FBoolean getFg_cc_in() {
		return ((FBoolean) getAttrVal("Fg_cc_in"));
	}	
	/**
	 * 结账标志_退票
	 * @param Fg_cc_in
	 */
	public void setFg_cc_in(FBoolean Fg_cc_in) {
		setAttrVal("Fg_cc_in", Fg_cc_in);
	}
	/**
	 * 操作员结账_退票
	 * @return String
	 */
	public String getId_cc_in() {
		return ((String) getAttrVal("Id_cc_in"));
	}	
	/**
	 * 操作员结账_退票
	 * @param Id_cc_in
	 */
	public void setId_cc_in(String Id_cc_in) {
		setAttrVal("Id_cc_in", Id_cc_in);
	}
	/**
	 * 发票开立科室
	 * @return String
	 */
	public String getId_dep_inc() {
		return ((String) getAttrVal("Id_dep_inc"));
	}	
	/**
	 * 发票开立科室
	 * @param Id_dep_inc
	 */
	public void setId_dep_inc(String Id_dep_inc) {
		setAttrVal("Id_dep_inc", Id_dep_inc);
	}
	/**
	 * 发票退票科室
	 * @return String
	 */
	public String getId_dep_canc() {
		return ((String) getAttrVal("Id_dep_canc"));
	}	
	/**
	 * 发票退票科室
	 * @param Id_dep_canc
	 */
	public void setId_dep_canc(String Id_dep_canc) {
		setAttrVal("Id_dep_canc", Id_dep_canc);
	}
	/**
	 * 医保基金支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}	
	/**
	 * 医保基金支付标志
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 是否持卡标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}	
	/**
	 * 是否持卡标志
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 计算机
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	/**
	 * 计算机
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	/**
	 * 出票方式
	 * @return String
	 */
	public String getEu_printmd() {
		return ((String) getAttrVal("Eu_printmd"));
	}	
	/**
	 * 出票方式
	 * @param Eu_printmd
	 */
	public void setEu_printmd(String Eu_printmd) {
		setAttrVal("Eu_printmd", Eu_printmd);
	}
	/**
	 * 电子发票标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ec_inc() {
		return ((FBoolean) getAttrVal("Fg_ec_inc"));
	}	
	/**
	 * 电子发票标志
	 * @param Fg_ec_inc
	 */
	public void setFg_ec_inc(FBoolean Fg_ec_inc) {
		setAttrVal("Fg_ec_inc", Fg_ec_inc);
	}
	/**
	 * 电子票据代码
	 * @return String
	 */
	public String getEc_inc_code() {
		return ((String) getAttrVal("Ec_inc_code"));
	}	
	/**
	 * 电子票据代码
	 * @param Ec_inc_code
	 */
	public void setEc_inc_code(String Ec_inc_code) {
		setAttrVal("Ec_inc_code", Ec_inc_code);
	}
	/**
	 * 电子票据校验码
	 * @return String
	 */
	public String getEc_inc_checkno() {
		return ((String) getAttrVal("Ec_inc_checkno"));
	}	
	/**
	 * 电子票据校验码
	 * @param Ec_inc_checkno
	 */
	public void setEc_inc_checkno(String Ec_inc_checkno) {
		setAttrVal("Ec_inc_checkno", Ec_inc_checkno);
	}
	/**
	 * 电子票据url
	 * @return String
	 */
	public String getEc_url() {
		return ((String) getAttrVal("Ec_url"));
	}	
	/**
	 * 电子票据url
	 * @param Ec_url
	 */
	public void setEc_url(String Ec_url) {
		setAttrVal("Ec_url", Ec_url);
	}
	/**
	 * 电子票据外网url
	 * @return String
	 */
	public String getEc_net_url() {
		return ((String) getAttrVal("Ec_net_url"));
	}	
	/**
	 * 电子票据外网url
	 * @param Ec_net_url
	 */
	public void setEc_net_url(String Ec_net_url) {
		setAttrVal("Ec_net_url", Ec_net_url);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
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
	 * 票据分类编码
	 * @return String
	 */
	public String getIncca_code() {
		return ((String) getAttrVal("Incca_code"));
	}	
	/**
	 * 票据分类编码
	 * @param Incca_code
	 */
	public void setIncca_code(String Incca_code) {
		setAttrVal("Incca_code", Incca_code);
	}
	/**
	 * 票据分类名称
	 * @return String
	 */
	public String getIncca_name() {
		return ((String) getAttrVal("Incca_name"));
	}	
	/**
	 * 票据分类名称
	 * @param Incca_name
	 */
	public void setIncca_name(String Incca_name) {
		setAttrVal("Incca_name", Incca_name);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getOep_codeincpkg() {
		return ((String) getAttrVal("Oep_codeincpkg"));
	}	
	/**
	 * 票据包编号
	 * @param Oep_codeincpkg
	 */
	public void setOep_codeincpkg(String Oep_codeincpkg) {
		setAttrVal("Oep_codeincpkg", Oep_codeincpkg);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getId_emp_inc_name() {
		return ((String) getAttrVal("Id_emp_inc_name"));
	}	
	/**
	 * 姓名
	 * @param Id_emp_inc_name
	 */
	public void setId_emp_inc_name(String Id_emp_inc_name) {
		setAttrVal("Id_emp_inc_name", Id_emp_inc_name);
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
		return "Id_incoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncOepDODesc.class);
	}
	
}