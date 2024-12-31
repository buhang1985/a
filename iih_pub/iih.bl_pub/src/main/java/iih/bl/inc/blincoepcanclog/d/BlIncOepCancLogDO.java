package iih.bl.inc.blincoepcanclog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincoepcanclog.d.desc.BlIncOepCancLogDODesc;
import java.math.BigDecimal;

/**
 * 门诊发票作废日志 DO数据 
 * 
 */
public class BlIncOepCancLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊发票作废日志主键
	public static final String ID_INCOEPCANCLOG= "Id_incoepcanclog";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//收退费方向
	public static final String EU_DIRECT= "Eu_direct";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//原始票据包
	public static final String CODE_INCPKG= "Code_incpkg";
	//原始发票号
	public static final String INCNO= "Incno";
	//新票据包
	public static final String CODE_INCPKG_NEW= "Code_incpkg_new";
	//新发票号
	public static final String INCNO_NEW= "Incno_new";
	//总金额_标准
	public static final String AMT_STD= "Amt_std";
	//金额_折扣
	public static final String AMT_RATIO= "Amt_ratio";
	//医保支付
	public static final String AMT_HP= "Amt_hp";
	//患者自付
	public static final String AMT_PAT= "Amt_pat";
	//减免方式
	public static final String EU_FREEMD= "Eu_freemd";
	//减免金额
	public static final String AMT_FREE= "Amt_free";
	//总金额
	public static final String AMT= "Amt";
	//发票金额描述信息
	public static final String NOTE= "Note";
	//原始发票开立人员
	public static final String ID_EMP_INC= "Id_emp_inc";
	//原始发票开票科室
	public static final String ID_DEP_INC= "Id_dep_inc";
	//新发票开立人员
	public static final String ID_EMP_INC_NEW= "Id_emp_inc_new";
	//新发票开立科室
	public static final String ID_DEP_INC_NEW= "Id_dep_inc_new";
	//所属结算
	public static final String ID_STOEP= "Id_stoep";
	//是否持卡标志
	public static final String FG_HP_CARD= "Fg_hp_card";
	//医保基金支付标志
	public static final String FG_FUNDPAY= "Fg_fundpay";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//原始发票日期
	public static final String DT_INC= "Dt_inc";
	//新发票日期
	public static final String DT_INC_NEW= "Dt_inc_new";
	//发票打印次数
	public static final String TIMES_PRN= "Times_prn";
	//出票方式
	public static final String EU_PRINTMD= "Eu_printmd";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊发票作废日志主键
	 * @return String
	 */
	public String getId_incoepcanclog() {
		return ((String) getAttrVal("Id_incoepcanclog"));
	}	
	/**
	 * 门诊发票作废日志主键
	 * @param Id_incoepcanclog
	 */
	public void setId_incoepcanclog(String Id_incoepcanclog) {
		setAttrVal("Id_incoepcanclog", Id_incoepcanclog);
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 原始票据包
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	/**
	 * 原始票据包
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 原始发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}	
	/**
	 * 原始发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 新票据包
	 * @return String
	 */
	public String getCode_incpkg_new() {
		return ((String) getAttrVal("Code_incpkg_new"));
	}	
	/**
	 * 新票据包
	 * @param Code_incpkg_new
	 */
	public void setCode_incpkg_new(String Code_incpkg_new) {
		setAttrVal("Code_incpkg_new", Code_incpkg_new);
	}
	/**
	 * 新发票号
	 * @return String
	 */
	public String getIncno_new() {
		return ((String) getAttrVal("Incno_new"));
	}	
	/**
	 * 新发票号
	 * @param Incno_new
	 */
	public void setIncno_new(String Incno_new) {
		setAttrVal("Incno_new", Incno_new);
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
	 * 金额_折扣
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 金额_折扣
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 医保支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 医保支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
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
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 原始发票开立人员
	 * @return String
	 */
	public String getId_emp_inc() {
		return ((String) getAttrVal("Id_emp_inc"));
	}	
	/**
	 * 原始发票开立人员
	 * @param Id_emp_inc
	 */
	public void setId_emp_inc(String Id_emp_inc) {
		setAttrVal("Id_emp_inc", Id_emp_inc);
	}
	/**
	 * 原始发票开票科室
	 * @return String
	 */
	public String getId_dep_inc() {
		return ((String) getAttrVal("Id_dep_inc"));
	}	
	/**
	 * 原始发票开票科室
	 * @param Id_dep_inc
	 */
	public void setId_dep_inc(String Id_dep_inc) {
		setAttrVal("Id_dep_inc", Id_dep_inc);
	}
	/**
	 * 新发票开立人员
	 * @return String
	 */
	public String getId_emp_inc_new() {
		return ((String) getAttrVal("Id_emp_inc_new"));
	}	
	/**
	 * 新发票开立人员
	 * @param Id_emp_inc_new
	 */
	public void setId_emp_inc_new(String Id_emp_inc_new) {
		setAttrVal("Id_emp_inc_new", Id_emp_inc_new);
	}
	/**
	 * 新发票开立科室
	 * @return String
	 */
	public String getId_dep_inc_new() {
		return ((String) getAttrVal("Id_dep_inc_new"));
	}	
	/**
	 * 新发票开立科室
	 * @param Id_dep_inc_new
	 */
	public void setId_dep_inc_new(String Id_dep_inc_new) {
		setAttrVal("Id_dep_inc_new", Id_dep_inc_new);
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
	 * 原始发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}	
	/**
	 * 原始发票日期
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
	/**
	 * 新发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc_new() {
		return ((FDateTime) getAttrVal("Dt_inc_new"));
	}	
	/**
	 * 新发票日期
	 * @param Dt_inc_new
	 */
	public void setDt_inc_new(FDateTime Dt_inc_new) {
		setAttrVal("Dt_inc_new", Dt_inc_new);
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
		return "Id_incoepcanclog";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_oep_canc_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncOepCancLogDODesc.class);
	}
	
}