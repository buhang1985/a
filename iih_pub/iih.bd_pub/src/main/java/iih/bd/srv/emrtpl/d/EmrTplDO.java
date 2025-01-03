package iih.bd.srv.emrtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrtpl.d.desc.EmrTplDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录模板 DO数据 
 * 
 */
public class EmrTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗记录模板主键标识
	public static final String ID_MRTPL= "Id_mrtpl";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//版本
	public static final String VER= "Ver";
	//医疗记录模板编码
	public static final String CODE= "Code";
	//医疗记录模板国家编码
	public static final String CODE_STD= "Code_std";
	//医疗记录模板名称
	public static final String NAME= "Name";
	//关联基础模板
	public static final String ID_BASEMRTPL= "Id_basemrtpl";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//医疗记录模板描述
	public static final String DES= "Des";
	//编辑器
	public static final String ID_MRED= "Id_mred";
	//编辑器启动函数参数
	public static final String FUNC_EDITOR_ARGU= "Func_editor_argu";
	//医疗记录模板所属类型
	public static final String ID_OWTP= "Id_owtp";
	//医疗记录模板所属类型编码
	public static final String SD_OWTP= "Sd_owtp";
	//所属个人
	public static final String ID_EMP= "Id_emp";
	//所属科室
	public static final String ID_DEPT= "Id_dept";
	//医疗记录模板状态
	public static final String ID_SU_MRPTL= "Id_su_mrptl";
	//医疗记录模板状态编码
	public static final String SD_SU_MRPTL= "Sd_su_mrptl";
	//启用状态
	public static final String ACTIVESTATE= "Activestate";
	//提交人
	public static final String ID_EMP_SUBMIT= "Id_emp_submit";
	//提交时间
	public static final String DT_SUBMIT= "Dt_submit";
	//审核人
	public static final String ID_EMP_REVIEW= "Id_emp_review";
	//审核时间
	public static final String DT_REVIEW= "Dt_review";
	//启用人
	public static final String ID_EMP_ACTIVE= "Id_emp_active";
	//启用时间
	public static final String DT_ACTIVE= "Dt_active";
	//停用人
	public static final String ID_EMP_STOP= "Id_emp_stop";
	//停用时间
	public static final String DT_STOP= "Dt_stop";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//标题表达式
	public static final String TITLE_EXP= "Title_exp";
	//打印名称
	public static final String NAME_PRN= "Name_prn";
	//模板关键字
	public static final String KEYWORDS= "Keywords";
	//适用条件
	public static final String CRITERIAXML= "Criteriaxml";
	//任务编码
	public static final String TASK_ID= "Task_id";
	//流程类型
	public static final String ID_WF_TYPE= "Id_wf_type";
	//流程定义
	public static final String WF_PRODEF= "Wf_prodef";
	//诊断
	public static final String ID_DI= "Id_di";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	//审签级别类型
	public static final String ID_MR_SIGN_LVL= "Id_mr_sign_lvl";
	//全院ID
	public static final String ID_OWNORG= "Id_ownorg";
	//前新起一页
	public static final String NEWTOP= "Newtop";
	//后新起一页
	public static final String NEWEND= "Newend";
	//审签意见
	public static final String SIGN_SUGGESTION= "Sign_suggestion";
	//默认模板
	public static final String ISDEFAULT= "Isdefault";
	//集团ID
	public static final String ID_GROUP= "Id_group";
	//所属名称
	public static final String NAME_OWN= "Name_own";
	//顺序号
	public static final String ORDERID= "Orderid";
	//召回原因
	public static final String RECALLREASON= "Recallreason";
	//审签等级id
	public static final String ID_MR_SIGNLVL= "Id_mr_signlvl";
	//审签登记sd
	public static final String SD_MR_SIGNLVL= "Sd_mr_signlvl";
	//病历签名模板
	public static final String ID_MRSIGNTPL= "Id_mrsigntpl";
	//患者签署
	public static final String FG_NEED_PAT_SIGN= "Fg_need_pat_sign";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//集团名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	//基础模板编码
	public static final String BASE_CODE= "Base_code";
	//基础模板名称
	public static final String BASE_NAME= "Base_name";
	//编辑器
	public static final String BASE_IDMRED= "Base_idmred";
	//医疗记录模板存储模式
	public static final String BASE_ID_MRTPLSTMD= "Base_id_mrtplstmd";
	//医疗记录模板存储模式编码
	public static final String BASE_SD_MRTPLSTMD= "Base_sd_mrtplstmd";
	//编辑器编码
	public static final String EDIT_CODE= "Edit_code";
	//编辑器名称
	public static final String EDIT_NAME= "Edit_name";
	//编辑器启动函数
	public static final String FUNC_EDITOR= "Func_editor";
	//编辑器记录格式类型
	public static final String SD_MRFMTP= "Sd_mrfmtp";
	//编辑器记录存储模
	public static final String SD_MRTPLSTMD= "Sd_mrtplstmd";
	//编辑器函数类名
	public static final String NAME_CLASS= "Name_class";
	//DLL全路径
	public static final String DLL_PATH= "Dll_path";
	//所属类型编码
	public static final String OWTP_CODE= "Owtp_code";
	//所属类型名称
	public static final String OWTP_NAME= "Owtp_name";
	//用户名称
	public static final String EMP_NAME= "Emp_name";
	//用户编码
	public static final String EMP_CODE= "Emp_code";
	//部门编码
	public static final String DEPT_CODE= "Dept_code";
	//部门名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String MRTPL_CODE= "Mrtpl_code";
	//模板状态名称
	public static final String MRTPL_NAME= "Mrtpl_name";
	//用户名称
	public static final String EMP_SUB_NAME= "Emp_sub_name";
	//用户编码
	public static final String EMP_SUB_CODE= "Emp_sub_code";
	//用户名称
	public static final String EMP_REV_NAME= "Emp_rev_name";
	//用户编码
	public static final String EMP_REV_CODE= "Emp_rev_code";
	//用户名称
	public static final String EMP_ACTIVE_NAME= "Emp_active_name";
	//用户编码
	public static final String EMP_ACTIVE_CODE= "Emp_active_code";
	//用户名称
	public static final String EMP_STOP_NAME= "Emp_stop_name";
	//用户编码
	public static final String EMP_STOP_CODE= "Emp_stop_code";
	//用户名称
	public static final String CREBY_NAME= "Creby_name";
	//用户编码
	public static final String CREBY_CODE= "Creby_code";
	//用户名称
	public static final String MODTI_NAME= "Modti_name";
	//用户编码
	public static final String MODTI_CODE= "Modti_code";
	//类型编码
	public static final String WF_TYPECODE= "Wf_typecode";
	//类型名称
	public static final String WF_TYPENAME= "Wf_typename";
	//诊断编码
	public static final String DI_CODE= "Di_code";
	//诊断名称
	public static final String DI_NAME= "Di_name";
	//编码
	public static final String SIGN_CODE= "Sign_code";
	//名称
	public static final String SIGN_NAME= "Sign_name";
	//审批流类型
	public static final String SIGN_FLOWTYPE= "Sign_flowtype";
	//编码
	public static final String GROUP_CODE= "Group_code";
	//名称
	public static final String GROUP_NAME= "Group_name";
	//编码
	public static final String MR_SIGNLVL_CODE= "Mr_signlvl_code";
	//名称
	public static final String MR_SIGNLVL_NAME= "Mr_signlvl_name";
	//片段模板编码
	public static final String MRSIGNTPL_CODE= "Mrsigntpl_code";
	//片段模板名称
	public static final String MRSIGNTPL_NAME= "Mrsigntpl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录模板主键标识
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	/**
	 * 医疗记录模板主键标识
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
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
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 版本
	 * @return Integer
	 */
	public Integer getVer() {
		return ((Integer) getAttrVal("Ver"));
	}	
	/**
	 * 版本
	 * @param Ver
	 */
	public void setVer(Integer Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 医疗记录模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 医疗记录模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医疗记录模板国家编码
	 * @return String
	 */
	public String getCode_std() {
		return ((String) getAttrVal("Code_std"));
	}	
	/**
	 * 医疗记录模板国家编码
	 * @param Code_std
	 */
	public void setCode_std(String Code_std) {
		setAttrVal("Code_std", Code_std);
	}
	/**
	 * 医疗记录模板名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医疗记录模板名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 关联基础模板
	 * @return String
	 */
	public String getId_basemrtpl() {
		return ((String) getAttrVal("Id_basemrtpl"));
	}	
	/**
	 * 关联基础模板
	 * @param Id_basemrtpl
	 */
	public void setId_basemrtpl(String Id_basemrtpl) {
		setAttrVal("Id_basemrtpl", Id_basemrtpl);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 医疗记录模板描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 医疗记录模板描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 编辑器
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	/**
	 * 编辑器
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 编辑器启动函数参数
	 * @return String
	 */
	public String getFunc_editor_argu() {
		return ((String) getAttrVal("Func_editor_argu"));
	}	
	/**
	 * 编辑器启动函数参数
	 * @param Func_editor_argu
	 */
	public void setFunc_editor_argu(String Func_editor_argu) {
		setAttrVal("Func_editor_argu", Func_editor_argu);
	}
	/**
	 * 医疗记录模板所属类型
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	/**
	 * 医疗记录模板所属类型
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 医疗记录模板所属类型编码
	 * @return String
	 */
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	/**
	 * 医疗记录模板所属类型编码
	 * @param Sd_owtp
	 */
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	/**
	 * 所属个人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 所属个人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 所属科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 医疗记录模板状态
	 * @return String
	 */
	public String getId_su_mrptl() {
		return ((String) getAttrVal("Id_su_mrptl"));
	}	
	/**
	 * 医疗记录模板状态
	 * @param Id_su_mrptl
	 */
	public void setId_su_mrptl(String Id_su_mrptl) {
		setAttrVal("Id_su_mrptl", Id_su_mrptl);
	}
	/**
	 * 医疗记录模板状态编码
	 * @return String
	 */
	public String getSd_su_mrptl() {
		return ((String) getAttrVal("Sd_su_mrptl"));
	}	
	/**
	 * 医疗记录模板状态编码
	 * @param Sd_su_mrptl
	 */
	public void setSd_su_mrptl(String Sd_su_mrptl) {
		setAttrVal("Sd_su_mrptl", Sd_su_mrptl);
	}
	/**
	 * 启用状态
	 * @return Integer
	 */
	public Integer getActivestate() {
		return ((Integer) getAttrVal("Activestate"));
	}	
	/**
	 * 启用状态
	 * @param Activestate
	 */
	public void setActivestate(Integer Activestate) {
		setAttrVal("Activestate", Activestate);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}	
	/**
	 * 提交人
	 * @param Id_emp_submit
	 */
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	/**
	 * 提交时间
	 * @return FDateTime
	 */
	public FDateTime getDt_submit() {
		return ((FDateTime) getAttrVal("Dt_submit"));
	}	
	/**
	 * 提交时间
	 * @param Dt_submit
	 */
	public void setDt_submit(FDateTime Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_review() {
		return ((String) getAttrVal("Id_emp_review"));
	}	
	/**
	 * 审核人
	 * @param Id_emp_review
	 */
	public void setId_emp_review(String Id_emp_review) {
		setAttrVal("Id_emp_review", Id_emp_review);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_review() {
		return ((FDateTime) getAttrVal("Dt_review"));
	}	
	/**
	 * 审核时间
	 * @param Dt_review
	 */
	public void setDt_review(FDateTime Dt_review) {
		setAttrVal("Dt_review", Dt_review);
	}
	/**
	 * 启用人
	 * @return String
	 */
	public String getId_emp_active() {
		return ((String) getAttrVal("Id_emp_active"));
	}	
	/**
	 * 启用人
	 * @param Id_emp_active
	 */
	public void setId_emp_active(String Id_emp_active) {
		setAttrVal("Id_emp_active", Id_emp_active);
	}
	/**
	 * 启用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_active() {
		return ((FDateTime) getAttrVal("Dt_active"));
	}	
	/**
	 * 启用时间
	 * @param Dt_active
	 */
	public void setDt_active(FDateTime Dt_active) {
		setAttrVal("Dt_active", Dt_active);
	}
	/**
	 * 停用人
	 * @return String
	 */
	public String getId_emp_stop() {
		return ((String) getAttrVal("Id_emp_stop"));
	}	
	/**
	 * 停用人
	 * @param Id_emp_stop
	 */
	public void setId_emp_stop(String Id_emp_stop) {
		setAttrVal("Id_emp_stop", Id_emp_stop);
	}
	/**
	 * 停用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	/**
	 * 停用时间
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
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
	 * 标题表达式
	 * @return String
	 */
	public String getTitle_exp() {
		return ((String) getAttrVal("Title_exp"));
	}	
	/**
	 * 标题表达式
	 * @param Title_exp
	 */
	public void setTitle_exp(String Title_exp) {
		setAttrVal("Title_exp", Title_exp);
	}
	/**
	 * 打印名称
	 * @return String
	 */
	public String getName_prn() {
		return ((String) getAttrVal("Name_prn"));
	}	
	/**
	 * 打印名称
	 * @param Name_prn
	 */
	public void setName_prn(String Name_prn) {
		setAttrVal("Name_prn", Name_prn);
	}
	/**
	 * 模板关键字
	 * @return String
	 */
	public String getKeywords() {
		return ((String) getAttrVal("Keywords"));
	}	
	/**
	 * 模板关键字
	 * @param Keywords
	 */
	public void setKeywords(String Keywords) {
		setAttrVal("Keywords", Keywords);
	}
	/**
	 * 适用条件
	 * @return String
	 */
	public String getCriteriaxml() {
		return ((String) getAttrVal("Criteriaxml"));
	}	
	/**
	 * 适用条件
	 * @param Criteriaxml
	 */
	public void setCriteriaxml(String Criteriaxml) {
		setAttrVal("Criteriaxml", Criteriaxml);
	}
	/**
	 * 任务编码
	 * @return String
	 */
	public String getTask_id() {
		return ((String) getAttrVal("Task_id"));
	}	
	/**
	 * 任务编码
	 * @param Task_id
	 */
	public void setTask_id(String Task_id) {
		setAttrVal("Task_id", Task_id);
	}
	/**
	 * 流程类型
	 * @return String
	 */
	public String getId_wf_type() {
		return ((String) getAttrVal("Id_wf_type"));
	}	
	/**
	 * 流程类型
	 * @param Id_wf_type
	 */
	public void setId_wf_type(String Id_wf_type) {
		setAttrVal("Id_wf_type", Id_wf_type);
	}
	/**
	 * 流程定义
	 * @return String
	 */
	public String getWf_prodef() {
		return ((String) getAttrVal("Wf_prodef"));
	}	
	/**
	 * 流程定义
	 * @param Wf_prodef
	 */
	public void setWf_prodef(String Wf_prodef) {
		setAttrVal("Wf_prodef", Wf_prodef);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	/**
	 * 诊断
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 审签级别类型
	 * @return String
	 */
	public String getId_mr_sign_lvl() {
		return ((String) getAttrVal("Id_mr_sign_lvl"));
	}	
	/**
	 * 审签级别类型
	 * @param Id_mr_sign_lvl
	 */
	public void setId_mr_sign_lvl(String Id_mr_sign_lvl) {
		setAttrVal("Id_mr_sign_lvl", Id_mr_sign_lvl);
	}
	/**
	 * 全院ID
	 * @return String
	 */
	public String getId_ownorg() {
		return ((String) getAttrVal("Id_ownorg"));
	}	
	/**
	 * 全院ID
	 * @param Id_ownorg
	 */
	public void setId_ownorg(String Id_ownorg) {
		setAttrVal("Id_ownorg", Id_ownorg);
	}
	/**
	 * 前新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewtop() {
		return ((FBoolean) getAttrVal("Newtop"));
	}	
	/**
	 * 前新起一页
	 * @param Newtop
	 */
	public void setNewtop(FBoolean Newtop) {
		setAttrVal("Newtop", Newtop);
	}
	/**
	 * 后新起一页
	 * @return FBoolean
	 */
	public FBoolean getNewend() {
		return ((FBoolean) getAttrVal("Newend"));
	}	
	/**
	 * 后新起一页
	 * @param Newend
	 */
	public void setNewend(FBoolean Newend) {
		setAttrVal("Newend", Newend);
	}
	/**
	 * 审签意见
	 * @return String
	 */
	public String getSign_suggestion() {
		return ((String) getAttrVal("Sign_suggestion"));
	}	
	/**
	 * 审签意见
	 * @param Sign_suggestion
	 */
	public void setSign_suggestion(String Sign_suggestion) {
		setAttrVal("Sign_suggestion", Sign_suggestion);
	}
	/**
	 * 默认模板
	 * @return FBoolean
	 */
	public FBoolean getIsdefault() {
		return ((FBoolean) getAttrVal("Isdefault"));
	}	
	/**
	 * 默认模板
	 * @param Isdefault
	 */
	public void setIsdefault(FBoolean Isdefault) {
		setAttrVal("Isdefault", Isdefault);
	}
	/**
	 * 集团ID
	 * @return String
	 */
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 集团ID
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	/**
	 * 所属名称
	 * @return String
	 */
	public String getName_own() {
		return ((String) getAttrVal("Name_own"));
	}	
	/**
	 * 所属名称
	 * @param Name_own
	 */
	public void setName_own(String Name_own) {
		setAttrVal("Name_own", Name_own);
	}
	/**
	 * 顺序号
	 * @return Integer
	 */
	public Integer getOrderid() {
		return ((Integer) getAttrVal("Orderid"));
	}	
	/**
	 * 顺序号
	 * @param Orderid
	 */
	public void setOrderid(Integer Orderid) {
		setAttrVal("Orderid", Orderid);
	}
	/**
	 * 召回原因
	 * @return String
	 */
	public String getRecallreason() {
		return ((String) getAttrVal("Recallreason"));
	}	
	/**
	 * 召回原因
	 * @param Recallreason
	 */
	public void setRecallreason(String Recallreason) {
		setAttrVal("Recallreason", Recallreason);
	}
	/**
	 * 审签等级id
	 * @return String
	 */
	public String getId_mr_signlvl() {
		return ((String) getAttrVal("Id_mr_signlvl"));
	}	
	/**
	 * 审签等级id
	 * @param Id_mr_signlvl
	 */
	public void setId_mr_signlvl(String Id_mr_signlvl) {
		setAttrVal("Id_mr_signlvl", Id_mr_signlvl);
	}
	/**
	 * 审签登记sd
	 * @return String
	 */
	public String getSd_mr_signlvl() {
		return ((String) getAttrVal("Sd_mr_signlvl"));
	}	
	/**
	 * 审签登记sd
	 * @param Sd_mr_signlvl
	 */
	public void setSd_mr_signlvl(String Sd_mr_signlvl) {
		setAttrVal("Sd_mr_signlvl", Sd_mr_signlvl);
	}
	/**
	 * 病历签名模板
	 * @return String
	 */
	public String getId_mrsigntpl() {
		return ((String) getAttrVal("Id_mrsigntpl"));
	}	
	/**
	 * 病历签名模板
	 * @param Id_mrsigntpl
	 */
	public void setId_mrsigntpl(String Id_mrsigntpl) {
		setAttrVal("Id_mrsigntpl", Id_mrsigntpl);
	}
	/**
	 * 患者签署
	 * @return FBoolean
	 */
	public FBoolean getFg_need_pat_sign() {
		return ((FBoolean) getAttrVal("Fg_need_pat_sign"));
	}	
	/**
	 * 患者签署
	 * @param Fg_need_pat_sign
	 */
	public void setFg_need_pat_sign(FBoolean Fg_need_pat_sign) {
		setAttrVal("Fg_need_pat_sign", Fg_need_pat_sign);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 集团名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_code
	 */
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_name
	 */
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	/**
	 * 基础模板编码
	 * @return String
	 */
	public String getBase_code() {
		return ((String) getAttrVal("Base_code"));
	}	
	/**
	 * 基础模板编码
	 * @param Base_code
	 */
	public void setBase_code(String Base_code) {
		setAttrVal("Base_code", Base_code);
	}
	/**
	 * 基础模板名称
	 * @return String
	 */
	public String getBase_name() {
		return ((String) getAttrVal("Base_name"));
	}	
	/**
	 * 基础模板名称
	 * @param Base_name
	 */
	public void setBase_name(String Base_name) {
		setAttrVal("Base_name", Base_name);
	}
	/**
	 * 编辑器
	 * @return String
	 */
	public String getBase_idmred() {
		return ((String) getAttrVal("Base_idmred"));
	}	
	/**
	 * 编辑器
	 * @param Base_idmred
	 */
	public void setBase_idmred(String Base_idmred) {
		setAttrVal("Base_idmred", Base_idmred);
	}
	/**
	 * 医疗记录模板存储模式
	 * @return String
	 */
	public String getBase_id_mrtplstmd() {
		return ((String) getAttrVal("Base_id_mrtplstmd"));
	}	
	/**
	 * 医疗记录模板存储模式
	 * @param Base_id_mrtplstmd
	 */
	public void setBase_id_mrtplstmd(String Base_id_mrtplstmd) {
		setAttrVal("Base_id_mrtplstmd", Base_id_mrtplstmd);
	}
	/**
	 * 医疗记录模板存储模式编码
	 * @return String
	 */
	public String getBase_sd_mrtplstmd() {
		return ((String) getAttrVal("Base_sd_mrtplstmd"));
	}	
	/**
	 * 医疗记录模板存储模式编码
	 * @param Base_sd_mrtplstmd
	 */
	public void setBase_sd_mrtplstmd(String Base_sd_mrtplstmd) {
		setAttrVal("Base_sd_mrtplstmd", Base_sd_mrtplstmd);
	}
	/**
	 * 编辑器编码
	 * @return String
	 */
	public String getEdit_code() {
		return ((String) getAttrVal("Edit_code"));
	}	
	/**
	 * 编辑器编码
	 * @param Edit_code
	 */
	public void setEdit_code(String Edit_code) {
		setAttrVal("Edit_code", Edit_code);
	}
	/**
	 * 编辑器名称
	 * @return String
	 */
	public String getEdit_name() {
		return ((String) getAttrVal("Edit_name"));
	}	
	/**
	 * 编辑器名称
	 * @param Edit_name
	 */
	public void setEdit_name(String Edit_name) {
		setAttrVal("Edit_name", Edit_name);
	}
	/**
	 * 编辑器启动函数
	 * @return String
	 */
	public String getFunc_editor() {
		return ((String) getAttrVal("Func_editor"));
	}	
	/**
	 * 编辑器启动函数
	 * @param Func_editor
	 */
	public void setFunc_editor(String Func_editor) {
		setAttrVal("Func_editor", Func_editor);
	}
	/**
	 * 编辑器记录格式类型
	 * @return String
	 */
	public String getSd_mrfmtp() {
		return ((String) getAttrVal("Sd_mrfmtp"));
	}	
	/**
	 * 编辑器记录格式类型
	 * @param Sd_mrfmtp
	 */
	public void setSd_mrfmtp(String Sd_mrfmtp) {
		setAttrVal("Sd_mrfmtp", Sd_mrfmtp);
	}
	/**
	 * 编辑器记录存储模
	 * @return String
	 */
	public String getSd_mrtplstmd() {
		return ((String) getAttrVal("Sd_mrtplstmd"));
	}	
	/**
	 * 编辑器记录存储模
	 * @param Sd_mrtplstmd
	 */
	public void setSd_mrtplstmd(String Sd_mrtplstmd) {
		setAttrVal("Sd_mrtplstmd", Sd_mrtplstmd);
	}
	/**
	 * 编辑器函数类名
	 * @return String
	 */
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	/**
	 * 编辑器函数类名
	 * @param Name_class
	 */
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	/**
	 * DLL全路径
	 * @return String
	 */
	public String getDll_path() {
		return ((String) getAttrVal("Dll_path"));
	}	
	/**
	 * DLL全路径
	 * @param Dll_path
	 */
	public void setDll_path(String Dll_path) {
		setAttrVal("Dll_path", Dll_path);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getOwtp_code() {
		return ((String) getAttrVal("Owtp_code"));
	}	
	/**
	 * 所属类型编码
	 * @param Owtp_code
	 */
	public void setOwtp_code(String Owtp_code) {
		setAttrVal("Owtp_code", Owtp_code);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	/**
	 * 所属类型名称
	 * @param Owtp_name
	 */
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 部门编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 部门编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 部门名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMrtpl_code() {
		return ((String) getAttrVal("Mrtpl_code"));
	}	
	/**
	 * 编码
	 * @param Mrtpl_code
	 */
	public void setMrtpl_code(String Mrtpl_code) {
		setAttrVal("Mrtpl_code", Mrtpl_code);
	}
	/**
	 * 模板状态名称
	 * @return String
	 */
	public String getMrtpl_name() {
		return ((String) getAttrVal("Mrtpl_name"));
	}	
	/**
	 * 模板状态名称
	 * @param Mrtpl_name
	 */
	public void setMrtpl_name(String Mrtpl_name) {
		setAttrVal("Mrtpl_name", Mrtpl_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_sub_name() {
		return ((String) getAttrVal("Emp_sub_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_sub_name
	 */
	public void setEmp_sub_name(String Emp_sub_name) {
		setAttrVal("Emp_sub_name", Emp_sub_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_sub_code() {
		return ((String) getAttrVal("Emp_sub_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_sub_code
	 */
	public void setEmp_sub_code(String Emp_sub_code) {
		setAttrVal("Emp_sub_code", Emp_sub_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_rev_name() {
		return ((String) getAttrVal("Emp_rev_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_rev_name
	 */
	public void setEmp_rev_name(String Emp_rev_name) {
		setAttrVal("Emp_rev_name", Emp_rev_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_rev_code() {
		return ((String) getAttrVal("Emp_rev_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_rev_code
	 */
	public void setEmp_rev_code(String Emp_rev_code) {
		setAttrVal("Emp_rev_code", Emp_rev_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_active_name() {
		return ((String) getAttrVal("Emp_active_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_active_name
	 */
	public void setEmp_active_name(String Emp_active_name) {
		setAttrVal("Emp_active_name", Emp_active_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_active_code() {
		return ((String) getAttrVal("Emp_active_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_active_code
	 */
	public void setEmp_active_code(String Emp_active_code) {
		setAttrVal("Emp_active_code", Emp_active_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_stop_name() {
		return ((String) getAttrVal("Emp_stop_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_stop_name
	 */
	public void setEmp_stop_name(String Emp_stop_name) {
		setAttrVal("Emp_stop_name", Emp_stop_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_stop_code() {
		return ((String) getAttrVal("Emp_stop_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_stop_code
	 */
	public void setEmp_stop_code(String Emp_stop_code) {
		setAttrVal("Emp_stop_code", Emp_stop_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreby_name() {
		return ((String) getAttrVal("Creby_name"));
	}	
	/**
	 * 用户名称
	 * @param Creby_name
	 */
	public void setCreby_name(String Creby_name) {
		setAttrVal("Creby_name", Creby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreby_code() {
		return ((String) getAttrVal("Creby_code"));
	}	
	/**
	 * 用户编码
	 * @param Creby_code
	 */
	public void setCreby_code(String Creby_code) {
		setAttrVal("Creby_code", Creby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModti_name() {
		return ((String) getAttrVal("Modti_name"));
	}	
	/**
	 * 用户名称
	 * @param Modti_name
	 */
	public void setModti_name(String Modti_name) {
		setAttrVal("Modti_name", Modti_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModti_code() {
		return ((String) getAttrVal("Modti_code"));
	}	
	/**
	 * 用户编码
	 * @param Modti_code
	 */
	public void setModti_code(String Modti_code) {
		setAttrVal("Modti_code", Modti_code);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getWf_typecode() {
		return ((String) getAttrVal("Wf_typecode"));
	}	
	/**
	 * 类型编码
	 * @param Wf_typecode
	 */
	public void setWf_typecode(String Wf_typecode) {
		setAttrVal("Wf_typecode", Wf_typecode);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getWf_typename() {
		return ((String) getAttrVal("Wf_typename"));
	}	
	/**
	 * 类型名称
	 * @param Wf_typename
	 */
	public void setWf_typename(String Wf_typename) {
		setAttrVal("Wf_typename", Wf_typename);
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
	 * 编码
	 * @return String
	 */
	public String getSign_code() {
		return ((String) getAttrVal("Sign_code"));
	}	
	/**
	 * 编码
	 * @param Sign_code
	 */
	public void setSign_code(String Sign_code) {
		setAttrVal("Sign_code", Sign_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSign_name() {
		return ((String) getAttrVal("Sign_name"));
	}	
	/**
	 * 名称
	 * @param Sign_name
	 */
	public void setSign_name(String Sign_name) {
		setAttrVal("Sign_name", Sign_name);
	}
	/**
	 * 审批流类型
	 * @return String
	 */
	public String getSign_flowtype() {
		return ((String) getAttrVal("Sign_flowtype"));
	}	
	/**
	 * 审批流类型
	 * @param Sign_flowtype
	 */
	public void setSign_flowtype(String Sign_flowtype) {
		setAttrVal("Sign_flowtype", Sign_flowtype);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGroup_code() {
		return ((String) getAttrVal("Group_code"));
	}	
	/**
	 * 编码
	 * @param Group_code
	 */
	public void setGroup_code(String Group_code) {
		setAttrVal("Group_code", Group_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGroup_name() {
		return ((String) getAttrVal("Group_name"));
	}	
	/**
	 * 名称
	 * @param Group_name
	 */
	public void setGroup_name(String Group_name) {
		setAttrVal("Group_name", Group_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMr_signlvl_code() {
		return ((String) getAttrVal("Mr_signlvl_code"));
	}	
	/**
	 * 编码
	 * @param Mr_signlvl_code
	 */
	public void setMr_signlvl_code(String Mr_signlvl_code) {
		setAttrVal("Mr_signlvl_code", Mr_signlvl_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMr_signlvl_name() {
		return ((String) getAttrVal("Mr_signlvl_name"));
	}	
	/**
	 * 名称
	 * @param Mr_signlvl_name
	 */
	public void setMr_signlvl_name(String Mr_signlvl_name) {
		setAttrVal("Mr_signlvl_name", Mr_signlvl_name);
	}
	/**
	 * 片段模板编码
	 * @return String
	 */
	public String getMrsigntpl_code() {
		return ((String) getAttrVal("Mrsigntpl_code"));
	}	
	/**
	 * 片段模板编码
	 * @param Mrsigntpl_code
	 */
	public void setMrsigntpl_code(String Mrsigntpl_code) {
		setAttrVal("Mrsigntpl_code", Mrsigntpl_code);
	}
	/**
	 * 片段模板名称
	 * @return String
	 */
	public String getMrsigntpl_name() {
		return ((String) getAttrVal("Mrsigntpl_name"));
	}	
	/**
	 * 片段模板名称
	 * @param Mrsigntpl_name
	 */
	public void setMrsigntpl_name(String Mrsigntpl_name) {
		setAttrVal("Mrsigntpl_name", Mrsigntpl_name);
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
		return "Id_mrtpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrTplDODesc.class);
	}
	
}