package iih.mp.nr.mporplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mporplan.d.desc.MpOrPlanDODesc;
import java.math.BigDecimal;

/**
 * 医嘱执行点 DO数据 
 * 
 */
public class MpOrPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱执行记录ID
	public static final String ID_OR_PR= "Id_or_pr";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医嘱
	public static final String ID_OR= "Id_or";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//用法
	public static final String ID_ROUTE= "Id_route";
	//医嘱频次
	public static final String ID_FREQ= "Id_freq";
	//条码号
	public static final String NO_BAR= "No_bar";
	//打印次数
	public static final String CT_PRN= "Ct_prn";
	//计划执行时间
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	//执行状态
	public static final String EU_SU= "Eu_su";
	//可取消标志
	public static final String FG_CANCELABLE= "Fg_cancelable";
	//可退费标识
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	//执行确认时间
	public static final String DT_MP_CONFIRM= "Dt_mp_confirm";
	//执行确认人
	public static final String ID_EMP_CONFIRM= "Id_emp_confirm";
	//执行确认科室
	public static final String ID_DEP_CONFIRM= "Id_dep_confirm";
	//不执行原因ID
	public static final String ID_SKIP_REASON= "Id_skip_reason";
	//不执行原因编码
	public static final String SD_SKIP_REASON= "Sd_skip_reason";
	//不执行原因描述
	public static final String SKIP_REASON= "Skip_reason";
	//最新医嘱执行闭环子状态ID
	public static final String ID_ORPLTPSTA= "Id_orpltpsta";
	//最新医嘱执行闭环子状态执行时间
	public static final String DT_MP_ORPLTPSTA= "Dt_mp_orpltpsta";
	//最新医嘱执行闭环子状态执行人
	public static final String ID_EMP_ORPLTPSTA= "Id_emp_orpltpsta";
	//最新医嘱执行闭环子状态执行科室
	public static final String ID_DEP_ORPLTPSTA= "Id_dep_orpltpsta";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//扩展字段1
	public static final String DEF1= "Def1";
	//是否PDA执行
	public static final String FG_PDA= "Fg_pda";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	//状态名称
	public static final String NAME= "Name";
	//医嘱闭环
	public static final String ID_ORPLTP= "Id_orpltp";
	//序号
	public static final String SORTNO= "Sortno";
	//用户名称
	public static final String CREAT_NAME= "Creat_name";
	//用户编码
	public static final String CREAT_CODE= "Creat_code";
	//用户名称
	public static final String MODIFY_NAME= "Modify_name";
	//用户编码
	public static final String MODIFY_CODE= "Modify_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱执行记录ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	/**
	 * 医嘱执行记录ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
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
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 条码号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCt_prn() {
		return ((Integer) getAttrVal("Ct_prn"));
	}	
	/**
	 * 打印次数
	 * @param Ct_prn
	 */
	public void setCt_prn(Integer Ct_prn) {
		setAttrVal("Ct_prn", Ct_prn);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}	
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 可取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cancelable() {
		return ((FBoolean) getAttrVal("Fg_cancelable"));
	}	
	/**
	 * 可取消标志
	 * @param Fg_cancelable
	 */
	public void setFg_cancelable(FBoolean Fg_cancelable) {
		setAttrVal("Fg_cancelable", Fg_cancelable);
	}
	/**
	 * 可退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 执行确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_confirm() {
		return ((FDateTime) getAttrVal("Dt_mp_confirm"));
	}	
	/**
	 * 执行确认时间
	 * @param Dt_mp_confirm
	 */
	public void setDt_mp_confirm(FDateTime Dt_mp_confirm) {
		setAttrVal("Dt_mp_confirm", Dt_mp_confirm);
	}
	/**
	 * 执行确认人
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}	
	/**
	 * 执行确认人
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 执行确认科室
	 * @return String
	 */
	public String getId_dep_confirm() {
		return ((String) getAttrVal("Id_dep_confirm"));
	}	
	/**
	 * 执行确认科室
	 * @param Id_dep_confirm
	 */
	public void setId_dep_confirm(String Id_dep_confirm) {
		setAttrVal("Id_dep_confirm", Id_dep_confirm);
	}
	/**
	 * 不执行原因ID
	 * @return String
	 */
	public String getId_skip_reason() {
		return ((String) getAttrVal("Id_skip_reason"));
	}	
	/**
	 * 不执行原因ID
	 * @param Id_skip_reason
	 */
	public void setId_skip_reason(String Id_skip_reason) {
		setAttrVal("Id_skip_reason", Id_skip_reason);
	}
	/**
	 * 不执行原因编码
	 * @return String
	 */
	public String getSd_skip_reason() {
		return ((String) getAttrVal("Sd_skip_reason"));
	}	
	/**
	 * 不执行原因编码
	 * @param Sd_skip_reason
	 */
	public void setSd_skip_reason(String Sd_skip_reason) {
		setAttrVal("Sd_skip_reason", Sd_skip_reason);
	}
	/**
	 * 不执行原因描述
	 * @return String
	 */
	public String getSkip_reason() {
		return ((String) getAttrVal("Skip_reason"));
	}	
	/**
	 * 不执行原因描述
	 * @param Skip_reason
	 */
	public void setSkip_reason(String Skip_reason) {
		setAttrVal("Skip_reason", Skip_reason);
	}
	/**
	 * 最新医嘱执行闭环子状态ID
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}	
	/**
	 * 最新医嘱执行闭环子状态ID
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 最新医嘱执行闭环子状态执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_orpltpsta() {
		return ((FDateTime) getAttrVal("Dt_mp_orpltpsta"));
	}	
	/**
	 * 最新医嘱执行闭环子状态执行时间
	 * @param Dt_mp_orpltpsta
	 */
	public void setDt_mp_orpltpsta(FDateTime Dt_mp_orpltpsta) {
		setAttrVal("Dt_mp_orpltpsta", Dt_mp_orpltpsta);
	}
	/**
	 * 最新医嘱执行闭环子状态执行人
	 * @return String
	 */
	public String getId_emp_orpltpsta() {
		return ((String) getAttrVal("Id_emp_orpltpsta"));
	}	
	/**
	 * 最新医嘱执行闭环子状态执行人
	 * @param Id_emp_orpltpsta
	 */
	public void setId_emp_orpltpsta(String Id_emp_orpltpsta) {
		setAttrVal("Id_emp_orpltpsta", Id_emp_orpltpsta);
	}
	/**
	 * 最新医嘱执行闭环子状态执行科室
	 * @return String
	 */
	public String getId_dep_orpltpsta() {
		return ((String) getAttrVal("Id_dep_orpltpsta"));
	}	
	/**
	 * 最新医嘱执行闭环子状态执行科室
	 * @param Id_dep_orpltpsta
	 */
	public void setId_dep_orpltpsta(String Id_dep_orpltpsta) {
		setAttrVal("Id_dep_orpltpsta", Id_dep_orpltpsta);
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
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 是否PDA执行
	 * @return FBoolean
	 */
	public FBoolean getFg_pda() {
		return ((FBoolean) getAttrVal("Fg_pda"));
	}	
	/**
	 * 是否PDA执行
	 * @param Fg_pda
	 */
	public void setFg_pda(FBoolean Fg_pda) {
		setAttrVal("Fg_pda", Fg_pda);
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
	/**
	 * 状态名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 状态名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医嘱闭环
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	/**
	 * 医嘱闭环
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreat_name() {
		return ((String) getAttrVal("Creat_name"));
	}	
	/**
	 * 用户名称
	 * @param Creat_name
	 */
	public void setCreat_name(String Creat_name) {
		setAttrVal("Creat_name", Creat_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreat_code() {
		return ((String) getAttrVal("Creat_code"));
	}	
	/**
	 * 用户编码
	 * @param Creat_code
	 */
	public void setCreat_code(String Creat_code) {
		setAttrVal("Creat_code", Creat_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModify_name() {
		return ((String) getAttrVal("Modify_name"));
	}	
	/**
	 * 用户名称
	 * @param Modify_name
	 */
	public void setModify_name(String Modify_name) {
		setAttrVal("Modify_name", Modify_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModify_code() {
		return ((String) getAttrVal("Modify_code"));
	}	
	/**
	 * 用户编码
	 * @param Modify_code
	 */
	public void setModify_code(String Modify_code) {
		setAttrVal("Modify_code", Modify_code);
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
		return "Id_or_pr";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OR_PR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrPlanDODesc.class);
	}
	
}