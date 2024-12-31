package iih.nm.net.examchkpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examchkpl.d.desc.ExamChkPlPsnDODesc;
import java.math.BigDecimal;

/**
 * 考核计划参与人员 DO数据 
 * 
 */
public class ExamChkPlPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//考核人员主键
	public static final String ID_EXAM_CHK_PL_PSN= "Id_exam_chk_pl_psn";
	//考核计划外键
	public static final String ID_EXAM_CHK_PL= "Id_exam_chk_pl";
	//人员外键
	public static final String ID_NUR= "Id_nur";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//场次主键
	public static final String ID_NET_MEET= "Id_net_meet";
	//是否报名
	public static final String FG_APPLY= "Fg_apply";
	//姓名
	public static final String NAME_NUR= "Name_nur";
	//人员id
	public static final String ID_PSNDOC= "Id_psndoc";
	//工号
	public static final String JOB_NO= "Job_no";
	//护理单元
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//名称
	public static final String NAME_MEET= "Name_meet";
	//编码
	public static final String CODE_MEET= "Code_meet";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//结束时间
	public static final String DT_END= "Dt_end";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 考核人员主键
	 * @return String
	 */
	public String getId_exam_chk_pl_psn() {
		return ((String) getAttrVal("Id_exam_chk_pl_psn"));
	}	
	/**
	 * 考核人员主键
	 * @param Id_exam_chk_pl_psn
	 */
	public void setId_exam_chk_pl_psn(String Id_exam_chk_pl_psn) {
		setAttrVal("Id_exam_chk_pl_psn", Id_exam_chk_pl_psn);
	}
	/**
	 * 考核计划外键
	 * @return String
	 */
	public String getId_exam_chk_pl() {
		return ((String) getAttrVal("Id_exam_chk_pl"));
	}	
	/**
	 * 考核计划外键
	 * @param Id_exam_chk_pl
	 */
	public void setId_exam_chk_pl(String Id_exam_chk_pl) {
		setAttrVal("Id_exam_chk_pl", Id_exam_chk_pl);
	}
	/**
	 * 人员外键
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 人员外键
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 场次主键
	 * @return String
	 */
	public String getId_net_meet() {
		return ((String) getAttrVal("Id_net_meet"));
	}	
	/**
	 * 场次主键
	 * @param Id_net_meet
	 */
	public void setId_net_meet(String Id_net_meet) {
		setAttrVal("Id_net_meet", Id_net_meet);
	}
	/**
	 * 是否报名
	 * @return FBoolean
	 */
	public FBoolean getFg_apply() {
		return ((FBoolean) getAttrVal("Fg_apply"));
	}	
	/**
	 * 是否报名
	 * @param Fg_apply
	 */
	public void setFg_apply(FBoolean Fg_apply) {
		setAttrVal("Fg_apply", Fg_apply);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 工号
	 * @return String
	 */
	public String getJob_no() {
		return ((String) getAttrVal("Job_no"));
	}	
	/**
	 * 工号
	 * @param Job_no
	 */
	public void setJob_no(String Job_no) {
		setAttrVal("Job_no", Job_no);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_meet() {
		return ((String) getAttrVal("Name_meet"));
	}	
	/**
	 * 名称
	 * @param Name_meet
	 */
	public void setName_meet(String Name_meet) {
		setAttrVal("Name_meet", Name_meet);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_meet() {
		return ((String) getAttrVal("Code_meet"));
	}	
	/**
	 * 编码
	 * @param Code_meet
	 */
	public void setCode_meet(String Code_meet) {
		setAttrVal("Code_meet", Code_meet);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
		return "Id_exam_chk_pl_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_CHK_PL_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamChkPlPsnDODesc.class);
	}
	
}