package iih.ci.mr.cimr.d;

import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 临床医疗记录 DO数据 
 * 
 */
public class CiMrDO extends BaseDO implements WfFormInfoCtx{
	private static final long serialVersionUID = 1L;

	//医疗记录主键标识
	public static final String ID_MR= "Id_mr";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//医疗记录模板
	public static final String ID_MRTPL= "Id_mrtpl";
	//医疗记录编辑器
	public static final String ID_MRED= "Id_mred";
	//编辑器启动函数参数
	public static final String STARTPARAED= "Startparaed";
	//数据流存储方式
	public static final String ID_MRTPLSTMD= "Id_mrtplstmd";
	//数据流存储方式编码
	public static final String SD_MRTPLSTMD= "Sd_mrtplstmd";
	//医疗记录录入日期
	public static final String DT_RD= "Dt_rd";
	//录入人员
	public static final String ID_EMP= "Id_emp";
	//医疗记录科室
	public static final String ID_DEP= "Id_dep";
	//逻辑签署时间
	public static final String DT_SIGN= "Dt_sign";
	//最后医疗记录签署日期
	public static final String DT_SIGN_LAT= "Dt_sign_lat";
	//最后签署人员
	public static final String ID_EMP_LAT= "Id_emp_lat";
	//最后医疗记录审核日期
	public static final String DT_AUDIT_LAT= "Dt_audit_lat";
	//最后审核人员
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	//最近质控分数
	public static final String SCOREQALAT= "Scoreqalat";
	//医疗记录状态
	public static final String ID_SU_MR= "Id_su_mr";
	//医疗记录状态编码
	public static final String SD_SU_MR= "Sd_su_mr";
	//是否编辑
	public static final String FG_EDIT= "Fg_edit";
	//是否驳回
	public static final String FG_REJECT= "Fg_reject";
	//完成标志
	public static final String FG_COMPLETE= "Fg_complete";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否封存
	public static final String FG_SEAL= "Fg_seal";
	//是否归档
	public static final String FG_ARC= "Fg_arc";
	//医疗记录名称
	public static final String NAME= "Name";
	//上级责任医师
	public static final String ID_EMP_HIGHER= "Id_emp_higher";
	//提交标识
	public static final String FG_SUBMIT= "Fg_submit";
	//打印标识
	public static final String FG_PRN= "Fg_prn";
	//审签级别类型
	public static final String ID_REVIEWTP= "Id_reviewtp";
	//审签级别类型编码
	public static final String SD_REVIEWTP= "Sd_reviewtp";
	//文件标识
	public static final String URL_FILE= "Url_file";
	//提交人
	public static final String ID_EMP_SUBMIT= "Id_emp_submit";
	//提交时间
	public static final String DATE_SUBMIT= "Date_submit";
	//显示提交时间
	public static final String DATE_TIME_SHOW= "Date_time_show";
	//提交人所在科室
	public static final String ID_SUBMIT_DEPT= "Id_submit_dept";
	//患者当前科室编码
	public static final String CODE_DEPT_PAT= "Code_dept_pat";
	//经治医师
	public static final String ID_TREAT_DOCTOR= "Id_treat_doctor";
	//主治医师
	public static final String ID_MAST_DOCTOR= "Id_mast_doctor";
	//主治医师审签时间
	public static final String MAST_DOCTOR_DATE= "Mast_doctor_date";
	//主任医师
	public static final String ID_DIR_DOCTOR= "Id_dir_doctor";
	//主任医师审签时间
	public static final String DIR_DOCTOR_DATE= "Dir_doctor_date";
	//值班医生标识
	public static final String FG_DUTY_DOCTOR= "Fg_duty_doctor";
	//任务ID
	public static final String TASK_ID= "Task_id";
	//患者当前科室
	public static final String ID_DEP_PAT= "Id_dep_pat";
	//审批流类型
	public static final String ID_FLOWTYPE= "Id_flowtype";
	//病区
	public static final String ID_DEP_NURADM= "Id_dep_nuradm";
	//床位
	public static final String ID_BED= "Id_bed";
	//性别
	public static final String ID_SEX= "Id_sex";
	//年龄
	public static final String PAT_AGE= "Pat_age";
	//前新起一页
	public static final String NEWTOP= "Newtop";
	//后新起一页
	public static final String NEWEND= "Newend";
	//审签意见
	public static final String SIGN_SUGGESTION= "Sign_suggestion";
	//医疗记录自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//是否签名
	public static final String FG_SIGN= "Fg_sign";
	//删除原因
	public static final String DELETE_REASION= "Delete_reasion";
	//病历业务分类
	public static final String ID_MR_BT= "Id_mr_bt";
	//最后审签人
	public static final String ID_EMP_SIGN_LAST= "Id_emp_sign_last";
	//最后审签时间
	public static final String DT_EMP_SIGN_LAST= "Dt_emp_sign_last";
	//审签等级id
	public static final String ID_MR_SIGNLVL= "Id_mr_signlvl";
	//审签等级sd
	public static final String SD_MR_SIGNLVL= "Sd_mr_signlvl";
	//病历签名模板
	public static final String ID_MRSIGNTPL= "Id_mrsigntpl";
	//手术资料分类
	public static final String ID_SURDATA_CLASSI= "Id_surdata_classi";
	//displaynam72
	public static final String DEF1= "Def1";
	//displaynam73
	public static final String DEF2= "Def2";
	//displaynam74
	public static final String DEF3= "Def3";
	//displaynam75
	public static final String DEF4= "Def4";
	//displaynam76
	public static final String DEF5= "Def5";
	//displaynam77
	public static final String DEF6= "Def6";
	//displaynam78
	public static final String DEF7= "Def7";
	//displaynam79
	public static final String DEF8= "Def8";
	//displaynam80
	public static final String DEF9= "Def9";
	//displaynam81
	public static final String DEF10= "Def10";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//就诊类型编码
	public static final String ENTP_CODE= "Entp_code";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	//医疗记录模板编码
	public static final String MRTPL_CODE= "Mrtpl_code";
	//医疗记录模板名称
	public static final String MRTPL_NAME= "Mrtpl_name";
	//编辑器编码
	public static final String MRED_CODE= "Mred_code";
	//编辑器名称
	public static final String MRED_NAME= "Mred_name";
	//DLL全路径
	public static final String DLL_PATH= "Dll_path";
	//编辑器函数类名
	public static final String NAME_CLASS= "Name_class";
	//编码
	public static final String MRTPLSTMD_CODE= "Mrtplstmd_code";
	//名称
	public static final String MRTPLSTMD_NAME= "Mrtplstmd_name";
	//用户名称
	public static final String EMP_NAME= "Emp_name";
	//用户编码
	public static final String EMP_CODE= "Emp_code";
	//编码
	public static final String DEP_CODE= "Dep_code";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//用户名称
	public static final String EMP_LAT_NAME= "Emp_lat_name";
	//用户编码
	public static final String EMP_LAT_CODE= "Emp_lat_code";
	//用户名称
	public static final String EMP_AUDIT_NAME= "Emp_audit_name";
	//用户编码
	public static final String EMP_AUDIT_CODE= "Emp_audit_code";
	//编码
	public static final String SU_MR_CODE= "Su_mr_code";
	//名称
	public static final String SU_MR_NAME= "Su_mr_name";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	//用户名称
	public static final String CREATEBY_NAME= "Createby_name";
	//用户编码
	public static final String CREATEBY_CODE= "Createby_code";
	//用户名称
	public static final String EMP_HIGHER_NAME= "Emp_higher_name";
	//用户编码
	public static final String EMP_HIGHER_CODE= "Emp_higher_code";
	//审签编码
	public static final String REVIEWTP_CODE= "Reviewtp_code";
	//审签名称
	public static final String REVIEWTP_NAME= "Reviewtp_name";
	//完成状态
	public static final String ID_MR_FINISH_STATUS= "Id_mr_finish_status";
	//提交人名称
	public static final String EMP_SUBMIT_NAME= "Emp_submit_name";
	//提交人编码
	public static final String EMP_SUBMIT_CODE= "Emp_submit_code";
	//编码
	public static final String SUBMIT_DEPT_CODE= "Submit_dept_code";
	//名称
	public static final String SUBMIT_DEPT_NAME= "Submit_dept_name";
	//用户名称
	public static final String TREAT_NAME= "Treat_name";
	//用户编码
	public static final String TREAT_CODE= "Treat_code";
	//用户名称
	public static final String MAST_NAME= "Mast_name";
	//用户编码
	public static final String MAST_CODE= "Mast_code";
	//用户名称
	public static final String DIR_NAME= "Dir_name";
	//用户编码
	public static final String DIR_CODE= "Dir_code";
	//编码
	public static final String DEP_PAT_CODE= "Dep_pat_code";
	//名称
	public static final String DEP_PAT_NAME= "Dep_pat_name";
	//类型编码
	public static final String FLOWTYPE_TYPECODE= "Flowtype_typecode";
	//类型名称
	public static final String FLOWTYPE_TYPENAME= "Flowtype_typename";
	//业务线编码
	public static final String DEPTLINE_CODE= "Deptline_code";
	//业务线名称
	public static final String DEPTLINE_NAME= "Deptline_name";
	//床位编码
	public static final String BED_CODE= "Bed_code";
	//床位名称
	public static final String BED_NAME= "Bed_name";
	//编码
	public static final String MRCACTM_CODE= "Mrcactm_code";
	//名称
	public static final String MRCACTM_NAME= "Mrcactm_name";
	//用户名称
	public static final String EMP_SIGN_LAST_NAME= "Emp_sign_last_name";
	//用户编码
	public static final String EMP_SIGN_LAST_CODE= "Emp_sign_last_code";
	//名称
	public static final String MR_SIGNLVL_NAME= "Mr_signlvl_name";
	//编码
	public static final String MR_SIGNLVL_CODE= "Mr_signlvl_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗记录主键标识
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 医疗记录主键标识
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 医疗记录模板
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	/**
	 * 医疗记录模板
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 医疗记录编辑器
	 * @return String
	 */
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	/**
	 * 医疗记录编辑器
	 * @param Id_mred
	 */
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	/**
	 * 编辑器启动函数参数
	 * @return String
	 */
	public String getStartparaed() {
		return ((String) getAttrVal("Startparaed"));
	}	
	/**
	 * 编辑器启动函数参数
	 * @param Startparaed
	 */
	public void setStartparaed(String Startparaed) {
		setAttrVal("Startparaed", Startparaed);
	}
	/**
	 * 数据流存储方式
	 * @return String
	 */
	public String getId_mrtplstmd() {
		return ((String) getAttrVal("Id_mrtplstmd"));
	}	
	/**
	 * 数据流存储方式
	 * @param Id_mrtplstmd
	 */
	public void setId_mrtplstmd(String Id_mrtplstmd) {
		setAttrVal("Id_mrtplstmd", Id_mrtplstmd);
	}
	/**
	 * 数据流存储方式编码
	 * @return String
	 */
	public String getSd_mrtplstmd() {
		return ((String) getAttrVal("Sd_mrtplstmd"));
	}	
	/**
	 * 数据流存储方式编码
	 * @param Sd_mrtplstmd
	 */
	public void setSd_mrtplstmd(String Sd_mrtplstmd) {
		setAttrVal("Sd_mrtplstmd", Sd_mrtplstmd);
	}
	/**
	 * 医疗记录录入日期
	 * @return FDateTime
	 */
	public FDateTime getDt_rd() {
		return ((FDateTime) getAttrVal("Dt_rd"));
	}	
	/**
	 * 医疗记录录入日期
	 * @param Dt_rd
	 */
	public void setDt_rd(FDateTime Dt_rd) {
		setAttrVal("Dt_rd", Dt_rd);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 录入人员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 医疗记录科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 医疗记录科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 逻辑签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	/**
	 * 逻辑签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 最后医疗记录签署日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sign_lat() {
		return ((FDateTime) getAttrVal("Dt_sign_lat"));
	}	
	/**
	 * 最后医疗记录签署日期
	 * @param Dt_sign_lat
	 */
	public void setDt_sign_lat(FDateTime Dt_sign_lat) {
		setAttrVal("Dt_sign_lat", Dt_sign_lat);
	}
	/**
	 * 最后签署人员
	 * @return String
	 */
	public String getId_emp_lat() {
		return ((String) getAttrVal("Id_emp_lat"));
	}	
	/**
	 * 最后签署人员
	 * @param Id_emp_lat
	 */
	public void setId_emp_lat(String Id_emp_lat) {
		setAttrVal("Id_emp_lat", Id_emp_lat);
	}
	/**
	 * 最后医疗记录审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_audit_lat() {
		return ((FDateTime) getAttrVal("Dt_audit_lat"));
	}	
	/**
	 * 最后医疗记录审核日期
	 * @param Dt_audit_lat
	 */
	public void setDt_audit_lat(FDateTime Dt_audit_lat) {
		setAttrVal("Dt_audit_lat", Dt_audit_lat);
	}
	/**
	 * 最后审核人员
	 * @return String
	 */
	public String getId_emp_audit() {
		return ((String) getAttrVal("Id_emp_audit"));
	}	
	/**
	 * 最后审核人员
	 * @param Id_emp_audit
	 */
	public void setId_emp_audit(String Id_emp_audit) {
		setAttrVal("Id_emp_audit", Id_emp_audit);
	}
	/**
	 * 最近质控分数
	 * @return FDouble
	 */
	public FDouble getScoreqalat() {
		return ((FDouble) getAttrVal("Scoreqalat"));
	}	
	/**
	 * 最近质控分数
	 * @param Scoreqalat
	 */
	public void setScoreqalat(FDouble Scoreqalat) {
		setAttrVal("Scoreqalat", Scoreqalat);
	}
	/**
	 * 医疗记录状态
	 * @return String
	 */
	public String getId_su_mr() {
		return ((String) getAttrVal("Id_su_mr"));
	}	
	/**
	 * 医疗记录状态
	 * @param Id_su_mr
	 */
	public void setId_su_mr(String Id_su_mr) {
		setAttrVal("Id_su_mr", Id_su_mr);
	}
	/**
	 * 医疗记录状态编码
	 * @return String
	 */
	public String getSd_su_mr() {
		return ((String) getAttrVal("Sd_su_mr"));
	}	
	/**
	 * 医疗记录状态编码
	 * @param Sd_su_mr
	 */
	public void setSd_su_mr(String Sd_su_mr) {
		setAttrVal("Sd_su_mr", Sd_su_mr);
	}
	/**
	 * 是否编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	/**
	 * 是否编辑
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 是否驳回
	 * @return FBoolean
	 */
	public FBoolean getFg_reject() {
		return ((FBoolean) getAttrVal("Fg_reject"));
	}	
	/**
	 * 是否驳回
	 * @param Fg_reject
	 */
	public void setFg_reject(FBoolean Fg_reject) {
		setAttrVal("Fg_reject", Fg_reject);
	}
	/**
	 * 完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_complete() {
		return ((FBoolean) getAttrVal("Fg_complete"));
	}	
	/**
	 * 完成标志
	 * @param Fg_complete
	 */
	public void setFg_complete(FBoolean Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
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
	 * 是否封存
	 * @return FBoolean
	 */
	public FBoolean getFg_seal() {
		return ((FBoolean) getAttrVal("Fg_seal"));
	}	
	/**
	 * 是否封存
	 * @param Fg_seal
	 */
	public void setFg_seal(FBoolean Fg_seal) {
		setAttrVal("Fg_seal", Fg_seal);
	}
	/**
	 * 是否归档
	 * @return FBoolean
	 */
	public FBoolean getFg_arc() {
		return ((FBoolean) getAttrVal("Fg_arc"));
	}	
	/**
	 * 是否归档
	 * @param Fg_arc
	 */
	public void setFg_arc(FBoolean Fg_arc) {
		setAttrVal("Fg_arc", Fg_arc);
	}
	/**
	 * 医疗记录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医疗记录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 上级责任医师
	 * @return String
	 */
	public String getId_emp_higher() {
		return ((String) getAttrVal("Id_emp_higher"));
	}	
	/**
	 * 上级责任医师
	 * @param Id_emp_higher
	 */
	public void setId_emp_higher(String Id_emp_higher) {
		setAttrVal("Id_emp_higher", Id_emp_higher);
	}
	/**
	 * 提交标识
	 * @return FBoolean
	 */
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}	
	/**
	 * 提交标识
	 * @param Fg_submit
	 */
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	/**
	 * 打印标识
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 审签级别类型
	 * @return String
	 */
	public String getId_reviewtp() {
		return ((String) getAttrVal("Id_reviewtp"));
	}	
	/**
	 * 审签级别类型
	 * @param Id_reviewtp
	 */
	public void setId_reviewtp(String Id_reviewtp) {
		setAttrVal("Id_reviewtp", Id_reviewtp);
	}
	/**
	 * 审签级别类型编码
	 * @return String
	 */
	public String getSd_reviewtp() {
		return ((String) getAttrVal("Sd_reviewtp"));
	}	
	/**
	 * 审签级别类型编码
	 * @param Sd_reviewtp
	 */
	public void setSd_reviewtp(String Sd_reviewtp) {
		setAttrVal("Sd_reviewtp", Sd_reviewtp);
	}
	/**
	 * 文件标识
	 * @return String
	 */
	public String getUrl_file() {
		return ((String) getAttrVal("Url_file"));
	}	
	/**
	 * 文件标识
	 * @param Url_file
	 */
	public void setUrl_file(String Url_file) {
		setAttrVal("Url_file", Url_file);
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
	public FDateTime getDate_submit() {
		return ((FDateTime) getAttrVal("Date_submit"));
	}	
	/**
	 * 提交时间
	 * @param Date_submit
	 */
	public void setDate_submit(FDateTime Date_submit) {
		setAttrVal("Date_submit", Date_submit);
	}
	/**
	 * 显示提交时间
	 * @return String
	 */
	public String getDate_time_show() {
		return ((String) getAttrVal("Date_time_show"));
	}	
	/**
	 * 显示提交时间
	 * @param Date_time_show
	 */
	public void setDate_time_show(String Date_time_show) {
		setAttrVal("Date_time_show", Date_time_show);
	}
	/**
	 * 提交人所在科室
	 * @return String
	 */
	public String getId_submit_dept() {
		return ((String) getAttrVal("Id_submit_dept"));
	}	
	/**
	 * 提交人所在科室
	 * @param Id_submit_dept
	 */
	public void setId_submit_dept(String Id_submit_dept) {
		setAttrVal("Id_submit_dept", Id_submit_dept);
	}
	/**
	 * 患者当前科室编码
	 * @return String
	 */
	public String getCode_dept_pat() {
		return ((String) getAttrVal("Code_dept_pat"));
	}	
	/**
	 * 患者当前科室编码
	 * @param Code_dept_pat
	 */
	public void setCode_dept_pat(String Code_dept_pat) {
		setAttrVal("Code_dept_pat", Code_dept_pat);
	}
	/**
	 * 经治医师
	 * @return String
	 */
	public String getId_treat_doctor() {
		return ((String) getAttrVal("Id_treat_doctor"));
	}	
	/**
	 * 经治医师
	 * @param Id_treat_doctor
	 */
	public void setId_treat_doctor(String Id_treat_doctor) {
		setAttrVal("Id_treat_doctor", Id_treat_doctor);
	}
	/**
	 * 主治医师
	 * @return String
	 */
	public String getId_mast_doctor() {
		return ((String) getAttrVal("Id_mast_doctor"));
	}	
	/**
	 * 主治医师
	 * @param Id_mast_doctor
	 */
	public void setId_mast_doctor(String Id_mast_doctor) {
		setAttrVal("Id_mast_doctor", Id_mast_doctor);
	}
	/**
	 * 主治医师审签时间
	 * @return FDateTime
	 */
	public FDateTime getMast_doctor_date() {
		return ((FDateTime) getAttrVal("Mast_doctor_date"));
	}	
	/**
	 * 主治医师审签时间
	 * @param Mast_doctor_date
	 */
	public void setMast_doctor_date(FDateTime Mast_doctor_date) {
		setAttrVal("Mast_doctor_date", Mast_doctor_date);
	}
	/**
	 * 主任医师
	 * @return String
	 */
	public String getId_dir_doctor() {
		return ((String) getAttrVal("Id_dir_doctor"));
	}	
	/**
	 * 主任医师
	 * @param Id_dir_doctor
	 */
	public void setId_dir_doctor(String Id_dir_doctor) {
		setAttrVal("Id_dir_doctor", Id_dir_doctor);
	}
	/**
	 * 主任医师审签时间
	 * @return FDateTime
	 */
	public FDateTime getDir_doctor_date() {
		return ((FDateTime) getAttrVal("Dir_doctor_date"));
	}	
	/**
	 * 主任医师审签时间
	 * @param Dir_doctor_date
	 */
	public void setDir_doctor_date(FDateTime Dir_doctor_date) {
		setAttrVal("Dir_doctor_date", Dir_doctor_date);
	}
	/**
	 * 值班医生标识
	 * @return FBoolean
	 */
	public FBoolean getFg_duty_doctor() {
		return ((FBoolean) getAttrVal("Fg_duty_doctor"));
	}	
	/**
	 * 值班医生标识
	 * @param Fg_duty_doctor
	 */
	public void setFg_duty_doctor(FBoolean Fg_duty_doctor) {
		setAttrVal("Fg_duty_doctor", Fg_duty_doctor);
	}
	/**
	 * 任务ID
	 * @return String
	 */
	public String getTask_id() {
		return ((String) getAttrVal("Task_id"));
	}	
	/**
	 * 任务ID
	 * @param Task_id
	 */
	public void setTask_id(String Task_id) {
		setAttrVal("Task_id", Task_id);
	}
	/**
	 * 患者当前科室
	 * @return String
	 */
	public String getId_dep_pat() {
		return ((String) getAttrVal("Id_dep_pat"));
	}	
	/**
	 * 患者当前科室
	 * @param Id_dep_pat
	 */
	public void setId_dep_pat(String Id_dep_pat) {
		setAttrVal("Id_dep_pat", Id_dep_pat);
	}
	/**
	 * 审批流类型
	 * @return String
	 */
	public String getId_flowtype() {
		return ((String) getAttrVal("Id_flowtype"));
	}	
	/**
	 * 审批流类型
	 * @param Id_flowtype
	 */
	public void setId_flowtype(String Id_flowtype) {
		setAttrVal("Id_flowtype", Id_flowtype);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	/**
	 * 病区
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 床位
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getId_sex() {
		return ((Integer) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(Integer Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
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
	 * 医疗记录自定义分类
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录自定义分类
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 是否签名
	 * @return FBoolean
	 */
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	/**
	 * 是否签名
	 * @param Fg_sign
	 */
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 删除原因
	 * @return String
	 */
	public String getDelete_reasion() {
		return ((String) getAttrVal("Delete_reasion"));
	}	
	/**
	 * 删除原因
	 * @param Delete_reasion
	 */
	public void setDelete_reasion(String Delete_reasion) {
		setAttrVal("Delete_reasion", Delete_reasion);
	}
	/**
	 * 病历业务分类
	 * @return String
	 */
	public String getId_mr_bt() {
		return ((String) getAttrVal("Id_mr_bt"));
	}	
	/**
	 * 病历业务分类
	 * @param Id_mr_bt
	 */
	public void setId_mr_bt(String Id_mr_bt) {
		setAttrVal("Id_mr_bt", Id_mr_bt);
	}
	/**
	 * 最后审签人
	 * @return String
	 */
	public String getId_emp_sign_last() {
		return ((String) getAttrVal("Id_emp_sign_last"));
	}	
	/**
	 * 最后审签人
	 * @param Id_emp_sign_last
	 */
	public void setId_emp_sign_last(String Id_emp_sign_last) {
		setAttrVal("Id_emp_sign_last", Id_emp_sign_last);
	}
	/**
	 * 最后审签时间
	 * @return FDateTime
	 */
	public FDateTime getDt_emp_sign_last() {
		return ((FDateTime) getAttrVal("Dt_emp_sign_last"));
	}	
	/**
	 * 最后审签时间
	 * @param Dt_emp_sign_last
	 */
	public void setDt_emp_sign_last(FDateTime Dt_emp_sign_last) {
		setAttrVal("Dt_emp_sign_last", Dt_emp_sign_last);
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
	 * 审签等级sd
	 * @return String
	 */
	public String getSd_mr_signlvl() {
		return ((String) getAttrVal("Sd_mr_signlvl"));
	}	
	/**
	 * 审签等级sd
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
	 * 手术资料分类
	 * @return String
	 */
	public String getId_surdata_classi() {
		return ((String) getAttrVal("Id_surdata_classi"));
	}	
	/**
	 * 手术资料分类
	 * @param Id_surdata_classi
	 */
	public void setId_surdata_classi(String Id_surdata_classi) {
		setAttrVal("Id_surdata_classi", Id_surdata_classi);
	}
	/**
	 * displaynam72
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * displaynam72
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * displaynam73
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * displaynam73
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * displaynam74
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * displaynam74
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * displaynam75
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * displaynam75
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * displaynam76
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * displaynam76
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * displaynam77
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * displaynam77
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * displaynam78
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * displaynam78
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * displaynam79
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * displaynam79
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * displaynam80
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * displaynam80
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * displaynam81
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * displaynam81
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
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
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	/**
	 * 就诊类型编码
	 * @param Entp_code
	 */
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
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
	 * 医疗记录模板编码
	 * @return String
	 */
	public String getMrtpl_code() {
		return ((String) getAttrVal("Mrtpl_code"));
	}	
	/**
	 * 医疗记录模板编码
	 * @param Mrtpl_code
	 */
	public void setMrtpl_code(String Mrtpl_code) {
		setAttrVal("Mrtpl_code", Mrtpl_code);
	}
	/**
	 * 医疗记录模板名称
	 * @return String
	 */
	public String getMrtpl_name() {
		return ((String) getAttrVal("Mrtpl_name"));
	}	
	/**
	 * 医疗记录模板名称
	 * @param Mrtpl_name
	 */
	public void setMrtpl_name(String Mrtpl_name) {
		setAttrVal("Mrtpl_name", Mrtpl_name);
	}
	/**
	 * 编辑器编码
	 * @return String
	 */
	public String getMred_code() {
		return ((String) getAttrVal("Mred_code"));
	}	
	/**
	 * 编辑器编码
	 * @param Mred_code
	 */
	public void setMred_code(String Mred_code) {
		setAttrVal("Mred_code", Mred_code);
	}
	/**
	 * 编辑器名称
	 * @return String
	 */
	public String getMred_name() {
		return ((String) getAttrVal("Mred_name"));
	}	
	/**
	 * 编辑器名称
	 * @param Mred_name
	 */
	public void setMred_name(String Mred_name) {
		setAttrVal("Mred_name", Mred_name);
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
	 * 编码
	 * @return String
	 */
	public String getMrtplstmd_code() {
		return ((String) getAttrVal("Mrtplstmd_code"));
	}	
	/**
	 * 编码
	 * @param Mrtplstmd_code
	 */
	public void setMrtplstmd_code(String Mrtplstmd_code) {
		setAttrVal("Mrtplstmd_code", Mrtplstmd_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMrtplstmd_name() {
		return ((String) getAttrVal("Mrtplstmd_name"));
	}	
	/**
	 * 名称
	 * @param Mrtplstmd_name
	 */
	public void setMrtplstmd_name(String Mrtplstmd_name) {
		setAttrVal("Mrtplstmd_name", Mrtplstmd_name);
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
	 * 编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	/**
	 * 编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_lat_name() {
		return ((String) getAttrVal("Emp_lat_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_lat_name
	 */
	public void setEmp_lat_name(String Emp_lat_name) {
		setAttrVal("Emp_lat_name", Emp_lat_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_lat_code() {
		return ((String) getAttrVal("Emp_lat_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_lat_code
	 */
	public void setEmp_lat_code(String Emp_lat_code) {
		setAttrVal("Emp_lat_code", Emp_lat_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_audit_name() {
		return ((String) getAttrVal("Emp_audit_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_audit_name
	 */
	public void setEmp_audit_name(String Emp_audit_name) {
		setAttrVal("Emp_audit_name", Emp_audit_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_audit_code() {
		return ((String) getAttrVal("Emp_audit_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_audit_code
	 */
	public void setEmp_audit_code(String Emp_audit_code) {
		setAttrVal("Emp_audit_code", Emp_audit_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSu_mr_code() {
		return ((String) getAttrVal("Su_mr_code"));
	}	
	/**
	 * 编码
	 * @param Su_mr_code
	 */
	public void setSu_mr_code(String Su_mr_code) {
		setAttrVal("Su_mr_code", Su_mr_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSu_mr_name() {
		return ((String) getAttrVal("Su_mr_name"));
	}	
	/**
	 * 名称
	 * @param Su_mr_name
	 */
	public void setSu_mr_name(String Su_mr_name) {
		setAttrVal("Su_mr_name", Su_mr_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createby_name
	 */
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createby_code
	 */
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_higher_name() {
		return ((String) getAttrVal("Emp_higher_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_higher_name
	 */
	public void setEmp_higher_name(String Emp_higher_name) {
		setAttrVal("Emp_higher_name", Emp_higher_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_higher_code() {
		return ((String) getAttrVal("Emp_higher_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_higher_code
	 */
	public void setEmp_higher_code(String Emp_higher_code) {
		setAttrVal("Emp_higher_code", Emp_higher_code);
	}
	/**
	 * 审签编码
	 * @return String
	 */
	public String getReviewtp_code() {
		return ((String) getAttrVal("Reviewtp_code"));
	}	
	/**
	 * 审签编码
	 * @param Reviewtp_code
	 */
	public void setReviewtp_code(String Reviewtp_code) {
		setAttrVal("Reviewtp_code", Reviewtp_code);
	}
	/**
	 * 审签名称
	 * @return String
	 */
	public String getReviewtp_name() {
		return ((String) getAttrVal("Reviewtp_name"));
	}	
	/**
	 * 审签名称
	 * @param Reviewtp_name
	 */
	public void setReviewtp_name(String Reviewtp_name) {
		setAttrVal("Reviewtp_name", Reviewtp_name);
	}
	/**
	 * 完成状态
	 * @return String
	 */
	public String getId_mr_finish_status() {
		return ((String) getAttrVal("Id_mr_finish_status"));
	}	
	/**
	 * 完成状态
	 * @param Id_mr_finish_status
	 */
	public void setId_mr_finish_status(String Id_mr_finish_status) {
		setAttrVal("Id_mr_finish_status", Id_mr_finish_status);
	}
	/**
	 * 提交人名称
	 * @return String
	 */
	public String getEmp_submit_name() {
		return ((String) getAttrVal("Emp_submit_name"));
	}	
	/**
	 * 提交人名称
	 * @param Emp_submit_name
	 */
	public void setEmp_submit_name(String Emp_submit_name) {
		setAttrVal("Emp_submit_name", Emp_submit_name);
	}
	/**
	 * 提交人编码
	 * @return String
	 */
	public String getEmp_submit_code() {
		return ((String) getAttrVal("Emp_submit_code"));
	}	
	/**
	 * 提交人编码
	 * @param Emp_submit_code
	 */
	public void setEmp_submit_code(String Emp_submit_code) {
		setAttrVal("Emp_submit_code", Emp_submit_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSubmit_dept_code() {
		return ((String) getAttrVal("Submit_dept_code"));
	}	
	/**
	 * 编码
	 * @param Submit_dept_code
	 */
	public void setSubmit_dept_code(String Submit_dept_code) {
		setAttrVal("Submit_dept_code", Submit_dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSubmit_dept_name() {
		return ((String) getAttrVal("Submit_dept_name"));
	}	
	/**
	 * 名称
	 * @param Submit_dept_name
	 */
	public void setSubmit_dept_name(String Submit_dept_name) {
		setAttrVal("Submit_dept_name", Submit_dept_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getTreat_name() {
		return ((String) getAttrVal("Treat_name"));
	}	
	/**
	 * 用户名称
	 * @param Treat_name
	 */
	public void setTreat_name(String Treat_name) {
		setAttrVal("Treat_name", Treat_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getTreat_code() {
		return ((String) getAttrVal("Treat_code"));
	}	
	/**
	 * 用户编码
	 * @param Treat_code
	 */
	public void setTreat_code(String Treat_code) {
		setAttrVal("Treat_code", Treat_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getMast_name() {
		return ((String) getAttrVal("Mast_name"));
	}	
	/**
	 * 用户名称
	 * @param Mast_name
	 */
	public void setMast_name(String Mast_name) {
		setAttrVal("Mast_name", Mast_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getMast_code() {
		return ((String) getAttrVal("Mast_code"));
	}	
	/**
	 * 用户编码
	 * @param Mast_code
	 */
	public void setMast_code(String Mast_code) {
		setAttrVal("Mast_code", Mast_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getDir_name() {
		return ((String) getAttrVal("Dir_name"));
	}	
	/**
	 * 用户名称
	 * @param Dir_name
	 */
	public void setDir_name(String Dir_name) {
		setAttrVal("Dir_name", Dir_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getDir_code() {
		return ((String) getAttrVal("Dir_code"));
	}	
	/**
	 * 用户编码
	 * @param Dir_code
	 */
	public void setDir_code(String Dir_code) {
		setAttrVal("Dir_code", Dir_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDep_pat_code() {
		return ((String) getAttrVal("Dep_pat_code"));
	}	
	/**
	 * 编码
	 * @param Dep_pat_code
	 */
	public void setDep_pat_code(String Dep_pat_code) {
		setAttrVal("Dep_pat_code", Dep_pat_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_pat_name() {
		return ((String) getAttrVal("Dep_pat_name"));
	}	
	/**
	 * 名称
	 * @param Dep_pat_name
	 */
	public void setDep_pat_name(String Dep_pat_name) {
		setAttrVal("Dep_pat_name", Dep_pat_name);
	}
	/**
	 * 类型编码
	 * @return String
	 */
	public String getFlowtype_typecode() {
		return ((String) getAttrVal("Flowtype_typecode"));
	}	
	/**
	 * 类型编码
	 * @param Flowtype_typecode
	 */
	public void setFlowtype_typecode(String Flowtype_typecode) {
		setAttrVal("Flowtype_typecode", Flowtype_typecode);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getFlowtype_typename() {
		return ((String) getAttrVal("Flowtype_typename"));
	}	
	/**
	 * 类型名称
	 * @param Flowtype_typename
	 */
	public void setFlowtype_typename(String Flowtype_typename) {
		setAttrVal("Flowtype_typename", Flowtype_typename);
	}
	/**
	 * 业务线编码
	 * @return String
	 */
	public String getDeptline_code() {
		return ((String) getAttrVal("Deptline_code"));
	}	
	/**
	 * 业务线编码
	 * @param Deptline_code
	 */
	public void setDeptline_code(String Deptline_code) {
		setAttrVal("Deptline_code", Deptline_code);
	}
	/**
	 * 业务线名称
	 * @return String
	 */
	public String getDeptline_name() {
		return ((String) getAttrVal("Deptline_name"));
	}	
	/**
	 * 业务线名称
	 * @param Deptline_name
	 */
	public void setDeptline_name(String Deptline_name) {
		setAttrVal("Deptline_name", Deptline_name);
	}
	/**
	 * 床位编码
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}	
	/**
	 * 床位编码
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}	
	/**
	 * 床位名称
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	/**
	 * 编码
	 * @param Mrcactm_code
	 */
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	/**
	 * 名称
	 * @param Mrcactm_name
	 */
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_sign_last_name() {
		return ((String) getAttrVal("Emp_sign_last_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_sign_last_name
	 */
	public void setEmp_sign_last_name(String Emp_sign_last_name) {
		setAttrVal("Emp_sign_last_name", Emp_sign_last_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_sign_last_code() {
		return ((String) getAttrVal("Emp_sign_last_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_sign_last_code
	 */
	public void setEmp_sign_last_code(String Emp_sign_last_code) {
		setAttrVal("Emp_sign_last_code", Emp_sign_last_code);
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
		return "Id_mr";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrDODesc.class);
	}
	@Override
	public Object getAllLevelAttributeValue(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getAttributeNames() {
		return getAttrNames();
	}
	@Override
	public Object getAttributeValue(String arg0) {
		return getAttrVal(arg0);
	}
	@Override
	public String getBillMakeDateField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getBillMakeDeptField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getBillMakeNumbField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getBillMakeUserField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFrmAuditDateField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFrmAuditUserField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFrmInsPk() {
		return getId_mr();
	}
	@Override
	public String getFrmStateField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getFrmTaskPkField() {
		return TASK_ID;
	}
	@Override
	public String getFrmTitileField() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAttributeValue(String arg0, Object arg1) {
		if(arg0 == null || arg1 == null) return;
	    this.setAttrVal(arg0, arg1);
		
	}
	
}