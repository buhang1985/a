package iih.mm.po.purchase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.po.purchase.d.desc.PurchaseOrderDODesc;
import java.math.BigDecimal;

/**
 * 库存采购 DO数据 
 * 
 */
public class PurchaseOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存采购主键
	public static final String ID_PO= "Id_po";
	//采购计划主键
	public static final String ID_PL= "Id_pl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//采购编码
	public static final String CODE= "Code";
	//采购名称
	public static final String NAME= "Name";
	//采购描述
	public static final String DES= "Des";
	//采购部门
	public static final String ID_DEP= "Id_dep";
	//采购供应商
	public static final String ID_SUP= "Id_sup";
	//采购经办人
	public static final String ID_EMP_PO= "Id_emp_po";
	//采购状态
	public static final String ID_SU_PO= "Id_su_po";
	//采购状态编码
	public static final String SD_SU_PO= "Sd_su_po";
	//可用标记
	public static final String FG_ACTIVE= "Fg_active";
	//采购审核人
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//采购审核日期
	public static final String DT_CHECK= "Dt_check";
	//审核意见
	public static final String OPINION_CHECK= "Opinion_check";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//需要日期
	public static final String DATE_REQR= "Date_reqr";
	//仓库
	public static final String ID_WH= "Id_wh";
	//制单时间（创建时间）
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//采购总金额
	public static final String AMT= "Amt";
	//流程任务ID
	public static final String TASK_ID= "Task_id";
	//流程定义ID
	public static final String PRO_DEF_ID= "Pro_def_id";
	//流程实例ID
	public static final String PRO_INS_ID= "Pro_ins_id";
	//采购部门
	public static final String DEP_NAME= "Dep_name";
	//采购供应商
	public static final String SUP_NAME= "Sup_name";
	//经办人姓名
	public static final String PO_EMP_NAME= "Po_emp_name";
	//采购状态
	public static final String SU_PO_NAME= "Su_po_name";
	//审核人姓名
	public static final String CHECK_EMP_NAME= "Check_emp_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//姓名
	public static final String ST_EMP_NAME= "St_emp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存采购主键
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 库存采购主键
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
	}
	/**
	 * 采购计划主键
	 * @return String
	 */
	public String getId_pl() {
		return ((String) getAttrVal("Id_pl"));
	}	
	/**
	 * 采购计划主键
	 * @param Id_pl
	 */
	public void setId_pl(String Id_pl) {
		setAttrVal("Id_pl", Id_pl);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 采购编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 采购编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 采购名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 采购名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 采购描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 采购描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 采购部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 采购部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 采购供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 采购供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 采购经办人
	 * @return String
	 */
	public String getId_emp_po() {
		return ((String) getAttrVal("Id_emp_po"));
	}	
	/**
	 * 采购经办人
	 * @param Id_emp_po
	 */
	public void setId_emp_po(String Id_emp_po) {
		setAttrVal("Id_emp_po", Id_emp_po);
	}
	/**
	 * 采购状态
	 * @return String
	 */
	public String getId_su_po() {
		return ((String) getAttrVal("Id_su_po"));
	}	
	/**
	 * 采购状态
	 * @param Id_su_po
	 */
	public void setId_su_po(String Id_su_po) {
		setAttrVal("Id_su_po", Id_su_po);
	}
	/**
	 * 采购状态编码
	 * @return String
	 */
	public String getSd_su_po() {
		return ((String) getAttrVal("Sd_su_po"));
	}	
	/**
	 * 采购状态编码
	 * @param Sd_su_po
	 */
	public void setSd_su_po(String Sd_su_po) {
		setAttrVal("Sd_su_po", Sd_su_po);
	}
	/**
	 * 可用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 可用标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 采购审核人
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 采购审核人
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 采购审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 采购审核日期
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getOpinion_check() {
		return ((String) getAttrVal("Opinion_check"));
	}	
	/**
	 * 审核意见
	 * @param Opinion_check
	 */
	public void setOpinion_check(String Opinion_check) {
		setAttrVal("Opinion_check", Opinion_check);
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
	 * 需要日期
	 * @return FDate
	 */
	public FDate getDate_reqr() {
		return ((FDate) getAttrVal("Date_reqr"));
	}	
	/**
	 * 需要日期
	 * @param Date_reqr
	 */
	public void setDate_reqr(FDate Date_reqr) {
		setAttrVal("Date_reqr", Date_reqr);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 制单时间（创建时间）
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 制单时间（创建时间）
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 制单日期
	 * @return FDate
	 */
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	/**
	 * 制单日期
	 * @param Dt_st_short
	 */
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 制单人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 采购总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 采购总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 流程任务ID
	 * @return String
	 */
	public String getTask_id() {
		return ((String) getAttrVal("Task_id"));
	}	
	/**
	 * 流程任务ID
	 * @param Task_id
	 */
	public void setTask_id(String Task_id) {
		setAttrVal("Task_id", Task_id);
	}
	/**
	 * 流程定义ID
	 * @return String
	 */
	public String getPro_def_id() {
		return ((String) getAttrVal("Pro_def_id"));
	}	
	/**
	 * 流程定义ID
	 * @param Pro_def_id
	 */
	public void setPro_def_id(String Pro_def_id) {
		setAttrVal("Pro_def_id", Pro_def_id);
	}
	/**
	 * 流程实例ID
	 * @return String
	 */
	public String getPro_ins_id() {
		return ((String) getAttrVal("Pro_ins_id"));
	}	
	/**
	 * 流程实例ID
	 * @param Pro_ins_id
	 */
	public void setPro_ins_id(String Pro_ins_id) {
		setAttrVal("Pro_ins_id", Pro_ins_id);
	}
	/**
	 * 采购部门
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 采购部门
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 采购供应商
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 采购供应商
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 经办人姓名
	 * @return String
	 */
	public String getPo_emp_name() {
		return ((String) getAttrVal("Po_emp_name"));
	}	
	/**
	 * 经办人姓名
	 * @param Po_emp_name
	 */
	public void setPo_emp_name(String Po_emp_name) {
		setAttrVal("Po_emp_name", Po_emp_name);
	}
	/**
	 * 采购状态
	 * @return String
	 */
	public String getSu_po_name() {
		return ((String) getAttrVal("Su_po_name"));
	}	
	/**
	 * 采购状态
	 * @param Su_po_name
	 */
	public void setSu_po_name(String Su_po_name) {
		setAttrVal("Su_po_name", Su_po_name);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getCheck_emp_name() {
		return ((String) getAttrVal("Check_emp_name"));
	}	
	/**
	 * 审核人姓名
	 * @param Check_emp_name
	 */
	public void setCheck_emp_name(String Check_emp_name) {
		setAttrVal("Check_emp_name", Check_emp_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getSt_emp_name() {
		return ((String) getAttrVal("St_emp_name"));
	}	
	/**
	 * 姓名
	 * @param St_emp_name
	 */
	public void setSt_emp_name(String St_emp_name) {
		setAttrVal("St_emp_name", St_emp_name);
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
		return "Id_po";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_PO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PurchaseOrderDODesc.class);
	}
	
}