package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cc.blcc.d.desc.BlCcDODesc;
import java.math.BigDecimal;

/**
 * 结账 DO数据 
 * 
 */
public class BlCcDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结账主键
	public static final String ID_CC= "Id_cc";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//结帐号
	public static final String CODE_CC= "Code_cc";
	//结账类型
	public static final String ID_CCTP= "Id_cctp";
	//记账类型编码
	public static final String SD_CCTP= "Sd_cctp";
	//操作员
	public static final String ID_EMP= "Id_emp";
	//记账开始日期
	public static final String DT_B= "Dt_b";
	//结账结束日期
	public static final String DT_E= "Dt_e";
	//收款总金额
	public static final String AMT= "Amt";
	//退款总金额
	public static final String AMT_RETURN= "Amt_return";
	//使用结算发票号信息串
	public static final String INCNOS= "Incnos";
	//发票张数
	public static final String INCCN= "Inccn";
	//退费发票张数
	public static final String INCCN_RE= "Inccn_re";
	//退费发票信息串
	public static final String INCNOS_RE= "Incnos_re";
	//作废结算发票号信息串
	public static final String INCNOS_CANC= "Incnos_canc";
	//作废结算发票张数
	public static final String INCCN_CANC= "Inccn_canc";
	//支票张数
	public static final String CHQCN= "Chqcn";
	//支票号信息串
	public static final String CHQNOS= "Chqnos";
	//结账取消标志
	public static final String FG_CANC= "Fg_canc";
	//结账取消时间
	public static final String DT_CANC= "Dt_canc";
	//结算_收款
	public static final String AMT_ST= "Amt_st";
	//结算_退款
	public static final String AMT_ST_RET= "Amt_st_ret";
	//住院押金_收款
	public static final String AMT_PVPREPAY= "Amt_pvprepay";
	//住院押金_退款
	public static final String AMT_PVPREPAY_RET= "Amt_pvprepay_ret";
	//患者预交金_收款
	public static final String AMT_ENTPREPAY= "Amt_entprepay";
	//患者预交金_退款
	public static final String AMT_ENTPREPAY_RET= "Amt_entprepay_ret";
	//住院押金收据使用号码串
	public static final String INCNOS_PVPREPAY= "Incnos_pvprepay";
	//住院押金收据收回号码串
	public static final String INCNOS_PVPREPAY_RET= "Incnos_pvprepay_ret";
	//住院押金收据发出张数
	public static final String INCCN_PVPREPAY= "Inccn_pvprepay";
	//住院押金收据收回张数
	public static final String INCCN_PVPREPAY_RET= "Inccn_pvprepay_ret";
	//记账日期时间
	public static final String DT_CC= "Dt_cc";
	//财务交割标志
	public static final String FG_FI= "Fg_fi";
	//财务交割日期
	public static final String DT_FI= "Dt_fi";
	//财务交割
	public static final String ID_FI= "Id_fi";
	//打印时间
	public static final String DT_PT= "Dt_pt";
	//结账差额
	public static final String AMT_DIF= "Amt_dif";
	//使用解算纸质发票号信息
	public static final String INCNOS_PAPER= "Incnos_paper";
	//纸质发票张数
	public static final String INCCN_PAPER= "Inccn_paper";
	//纸质退费发票张数
	public static final String INCCN_RE_PAPER= "Inccn_re_paper";
	//纸质退费发票信息
	public static final String INCNOS_RE_PAPER= "Incnos_re_paper";
	//纸质作废发票号信息
	public static final String INCNOS_CANC_PAPER= "Incnos_canc_paper";
	//纸质作废发票张数
	public static final String INCCN_CANC_PAPER= "Inccn_canc_paper";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//编码
	public static final String CCTP_CODE= "Cctp_code";
	//名称
	public static final String CCTP_NAME= "Cctp_name";
	//人员编码
	public static final String EMP_CODE= "Emp_code";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结账主键
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 结账主键
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 结帐号
	 * @return String
	 */
	public String getCode_cc() {
		return ((String) getAttrVal("Code_cc"));
	}	
	/**
	 * 结帐号
	 * @param Code_cc
	 */
	public void setCode_cc(String Code_cc) {
		setAttrVal("Code_cc", Code_cc);
	}
	/**
	 * 结账类型
	 * @return String
	 */
	public String getId_cctp() {
		return ((String) getAttrVal("Id_cctp"));
	}	
	/**
	 * 结账类型
	 * @param Id_cctp
	 */
	public void setId_cctp(String Id_cctp) {
		setAttrVal("Id_cctp", Id_cctp);
	}
	/**
	 * 记账类型编码
	 * @return String
	 */
	public String getSd_cctp() {
		return ((String) getAttrVal("Sd_cctp"));
	}	
	/**
	 * 记账类型编码
	 * @param Sd_cctp
	 */
	public void setSd_cctp(String Sd_cctp) {
		setAttrVal("Sd_cctp", Sd_cctp);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 操作员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 记账开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 记账开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结账结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结账结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 收款总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 收款总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 退款总金额
	 * @return FDouble
	 */
	public FDouble getAmt_return() {
		return ((FDouble) getAttrVal("Amt_return"));
	}	
	/**
	 * 退款总金额
	 * @param Amt_return
	 */
	public void setAmt_return(FDouble Amt_return) {
		setAttrVal("Amt_return", Amt_return);
	}
	/**
	 * 使用结算发票号信息串
	 * @return String
	 */
	public String getIncnos() {
		return ((String) getAttrVal("Incnos"));
	}	
	/**
	 * 使用结算发票号信息串
	 * @param Incnos
	 */
	public void setIncnos(String Incnos) {
		setAttrVal("Incnos", Incnos);
	}
	/**
	 * 发票张数
	 * @return Integer
	 */
	public Integer getInccn() {
		return ((Integer) getAttrVal("Inccn"));
	}	
	/**
	 * 发票张数
	 * @param Inccn
	 */
	public void setInccn(Integer Inccn) {
		setAttrVal("Inccn", Inccn);
	}
	/**
	 * 退费发票张数
	 * @return Integer
	 */
	public Integer getInccn_re() {
		return ((Integer) getAttrVal("Inccn_re"));
	}	
	/**
	 * 退费发票张数
	 * @param Inccn_re
	 */
	public void setInccn_re(Integer Inccn_re) {
		setAttrVal("Inccn_re", Inccn_re);
	}
	/**
	 * 退费发票信息串
	 * @return String
	 */
	public String getIncnos_re() {
		return ((String) getAttrVal("Incnos_re"));
	}	
	/**
	 * 退费发票信息串
	 * @param Incnos_re
	 */
	public void setIncnos_re(String Incnos_re) {
		setAttrVal("Incnos_re", Incnos_re);
	}
	/**
	 * 作废结算发票号信息串
	 * @return String
	 */
	public String getIncnos_canc() {
		return ((String) getAttrVal("Incnos_canc"));
	}	
	/**
	 * 作废结算发票号信息串
	 * @param Incnos_canc
	 */
	public void setIncnos_canc(String Incnos_canc) {
		setAttrVal("Incnos_canc", Incnos_canc);
	}
	/**
	 * 作废结算发票张数
	 * @return Integer
	 */
	public Integer getInccn_canc() {
		return ((Integer) getAttrVal("Inccn_canc"));
	}	
	/**
	 * 作废结算发票张数
	 * @param Inccn_canc
	 */
	public void setInccn_canc(Integer Inccn_canc) {
		setAttrVal("Inccn_canc", Inccn_canc);
	}
	/**
	 * 支票张数
	 * @return Integer
	 */
	public Integer getChqcn() {
		return ((Integer) getAttrVal("Chqcn"));
	}	
	/**
	 * 支票张数
	 * @param Chqcn
	 */
	public void setChqcn(Integer Chqcn) {
		setAttrVal("Chqcn", Chqcn);
	}
	/**
	 * 支票号信息串
	 * @return String
	 */
	public String getChqnos() {
		return ((String) getAttrVal("Chqnos"));
	}	
	/**
	 * 支票号信息串
	 * @param Chqnos
	 */
	public void setChqnos(String Chqnos) {
		setAttrVal("Chqnos", Chqnos);
	}
	/**
	 * 结账取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 结账取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 结账取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 结账取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 结算_收款
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}	
	/**
	 * 结算_收款
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
	/**
	 * 结算_退款
	 * @return FDouble
	 */
	public FDouble getAmt_st_ret() {
		return ((FDouble) getAttrVal("Amt_st_ret"));
	}	
	/**
	 * 结算_退款
	 * @param Amt_st_ret
	 */
	public void setAmt_st_ret(FDouble Amt_st_ret) {
		setAttrVal("Amt_st_ret", Amt_st_ret);
	}
	/**
	 * 住院押金_收款
	 * @return FDouble
	 */
	public FDouble getAmt_pvprepay() {
		return ((FDouble) getAttrVal("Amt_pvprepay"));
	}	
	/**
	 * 住院押金_收款
	 * @param Amt_pvprepay
	 */
	public void setAmt_pvprepay(FDouble Amt_pvprepay) {
		setAttrVal("Amt_pvprepay", Amt_pvprepay);
	}
	/**
	 * 住院押金_退款
	 * @return FDouble
	 */
	public FDouble getAmt_pvprepay_ret() {
		return ((FDouble) getAttrVal("Amt_pvprepay_ret"));
	}	
	/**
	 * 住院押金_退款
	 * @param Amt_pvprepay_ret
	 */
	public void setAmt_pvprepay_ret(FDouble Amt_pvprepay_ret) {
		setAttrVal("Amt_pvprepay_ret", Amt_pvprepay_ret);
	}
	/**
	 * 患者预交金_收款
	 * @return FDouble
	 */
	public FDouble getAmt_entprepay() {
		return ((FDouble) getAttrVal("Amt_entprepay"));
	}	
	/**
	 * 患者预交金_收款
	 * @param Amt_entprepay
	 */
	public void setAmt_entprepay(FDouble Amt_entprepay) {
		setAttrVal("Amt_entprepay", Amt_entprepay);
	}
	/**
	 * 患者预交金_退款
	 * @return FDouble
	 */
	public FDouble getAmt_entprepay_ret() {
		return ((FDouble) getAttrVal("Amt_entprepay_ret"));
	}	
	/**
	 * 患者预交金_退款
	 * @param Amt_entprepay_ret
	 */
	public void setAmt_entprepay_ret(FDouble Amt_entprepay_ret) {
		setAttrVal("Amt_entprepay_ret", Amt_entprepay_ret);
	}
	/**
	 * 住院押金收据使用号码串
	 * @return String
	 */
	public String getIncnos_pvprepay() {
		return ((String) getAttrVal("Incnos_pvprepay"));
	}	
	/**
	 * 住院押金收据使用号码串
	 * @param Incnos_pvprepay
	 */
	public void setIncnos_pvprepay(String Incnos_pvprepay) {
		setAttrVal("Incnos_pvprepay", Incnos_pvprepay);
	}
	/**
	 * 住院押金收据收回号码串
	 * @return String
	 */
	public String getIncnos_pvprepay_ret() {
		return ((String) getAttrVal("Incnos_pvprepay_ret"));
	}	
	/**
	 * 住院押金收据收回号码串
	 * @param Incnos_pvprepay_ret
	 */
	public void setIncnos_pvprepay_ret(String Incnos_pvprepay_ret) {
		setAttrVal("Incnos_pvprepay_ret", Incnos_pvprepay_ret);
	}
	/**
	 * 住院押金收据发出张数
	 * @return Integer
	 */
	public Integer getInccn_pvprepay() {
		return ((Integer) getAttrVal("Inccn_pvprepay"));
	}	
	/**
	 * 住院押金收据发出张数
	 * @param Inccn_pvprepay
	 */
	public void setInccn_pvprepay(Integer Inccn_pvprepay) {
		setAttrVal("Inccn_pvprepay", Inccn_pvprepay);
	}
	/**
	 * 住院押金收据收回张数
	 * @return Integer
	 */
	public Integer getInccn_pvprepay_ret() {
		return ((Integer) getAttrVal("Inccn_pvprepay_ret"));
	}	
	/**
	 * 住院押金收据收回张数
	 * @param Inccn_pvprepay_ret
	 */
	public void setInccn_pvprepay_ret(Integer Inccn_pvprepay_ret) {
		setAttrVal("Inccn_pvprepay_ret", Inccn_pvprepay_ret);
	}
	/**
	 * 记账日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cc() {
		return ((FDateTime) getAttrVal("Dt_cc"));
	}	
	/**
	 * 记账日期时间
	 * @param Dt_cc
	 */
	public void setDt_cc(FDateTime Dt_cc) {
		setAttrVal("Dt_cc", Dt_cc);
	}
	/**
	 * 财务交割标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fi() {
		return ((FBoolean) getAttrVal("Fg_fi"));
	}	
	/**
	 * 财务交割标志
	 * @param Fg_fi
	 */
	public void setFg_fi(FBoolean Fg_fi) {
		setAttrVal("Fg_fi", Fg_fi);
	}
	/**
	 * 财务交割日期
	 * @return FDateTime
	 */
	public FDateTime getDt_fi() {
		return ((FDateTime) getAttrVal("Dt_fi"));
	}	
	/**
	 * 财务交割日期
	 * @param Dt_fi
	 */
	public void setDt_fi(FDateTime Dt_fi) {
		setAttrVal("Dt_fi", Dt_fi);
	}
	/**
	 * 财务交割
	 * @return String
	 */
	public String getId_fi() {
		return ((String) getAttrVal("Id_fi"));
	}	
	/**
	 * 财务交割
	 * @param Id_fi
	 */
	public void setId_fi(String Id_fi) {
		setAttrVal("Id_fi", Id_fi);
	}
	/**
	 * 打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pt() {
		return ((FDateTime) getAttrVal("Dt_pt"));
	}	
	/**
	 * 打印时间
	 * @param Dt_pt
	 */
	public void setDt_pt(FDateTime Dt_pt) {
		setAttrVal("Dt_pt", Dt_pt);
	}
	/**
	 * 结账差额
	 * @return FDouble
	 */
	public FDouble getAmt_dif() {
		return ((FDouble) getAttrVal("Amt_dif"));
	}	
	/**
	 * 结账差额
	 * @param Amt_dif
	 */
	public void setAmt_dif(FDouble Amt_dif) {
		setAttrVal("Amt_dif", Amt_dif);
	}
	/**
	 * 使用解算纸质发票号信息
	 * @return String
	 */
	public String getIncnos_paper() {
		return ((String) getAttrVal("Incnos_paper"));
	}	
	/**
	 * 使用解算纸质发票号信息
	 * @param Incnos_paper
	 */
	public void setIncnos_paper(String Incnos_paper) {
		setAttrVal("Incnos_paper", Incnos_paper);
	}
	/**
	 * 纸质发票张数
	 * @return Integer
	 */
	public Integer getInccn_paper() {
		return ((Integer) getAttrVal("Inccn_paper"));
	}	
	/**
	 * 纸质发票张数
	 * @param Inccn_paper
	 */
	public void setInccn_paper(Integer Inccn_paper) {
		setAttrVal("Inccn_paper", Inccn_paper);
	}
	/**
	 * 纸质退费发票张数
	 * @return Integer
	 */
	public Integer getInccn_re_paper() {
		return ((Integer) getAttrVal("Inccn_re_paper"));
	}	
	/**
	 * 纸质退费发票张数
	 * @param Inccn_re_paper
	 */
	public void setInccn_re_paper(Integer Inccn_re_paper) {
		setAttrVal("Inccn_re_paper", Inccn_re_paper);
	}
	/**
	 * 纸质退费发票信息
	 * @return String
	 */
	public String getIncnos_re_paper() {
		return ((String) getAttrVal("Incnos_re_paper"));
	}	
	/**
	 * 纸质退费发票信息
	 * @param Incnos_re_paper
	 */
	public void setIncnos_re_paper(String Incnos_re_paper) {
		setAttrVal("Incnos_re_paper", Incnos_re_paper);
	}
	/**
	 * 纸质作废发票号信息
	 * @return String
	 */
	public String getIncnos_canc_paper() {
		return ((String) getAttrVal("Incnos_canc_paper"));
	}	
	/**
	 * 纸质作废发票号信息
	 * @param Incnos_canc_paper
	 */
	public void setIncnos_canc_paper(String Incnos_canc_paper) {
		setAttrVal("Incnos_canc_paper", Incnos_canc_paper);
	}
	/**
	 * 纸质作废发票张数
	 * @return Integer
	 */
	public Integer getInccn_canc_paper() {
		return ((Integer) getAttrVal("Inccn_canc_paper"));
	}	
	/**
	 * 纸质作废发票张数
	 * @param Inccn_canc_paper
	 */
	public void setInccn_canc_paper(Integer Inccn_canc_paper) {
		setAttrVal("Inccn_canc_paper", Inccn_canc_paper);
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCctp_code() {
		return ((String) getAttrVal("Cctp_code"));
	}	
	/**
	 * 编码
	 * @param Cctp_code
	 */
	public void setCctp_code(String Cctp_code) {
		setAttrVal("Cctp_code", Cctp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCctp_name() {
		return ((String) getAttrVal("Cctp_name"));
	}	
	/**
	 * 名称
	 * @param Cctp_name
	 */
	public void setCctp_name(String Cctp_name) {
		setAttrVal("Cctp_name", Cctp_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
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
		return "Id_cc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCcDODesc.class);
	}
	
}