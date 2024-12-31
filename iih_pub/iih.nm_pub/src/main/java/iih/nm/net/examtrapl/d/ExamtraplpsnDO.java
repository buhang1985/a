package iih.nm.net.examtrapl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examtrapl.d.desc.ExamtraplpsnDODesc;
import java.math.BigDecimal;

/**
 * 培训计划参加人员 DO数据 
 * 
 */
public class ExamtraplpsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//培训计划主键
	public static final String ID_EXAM_TRAPL_PSN= "Id_exam_trapl_psn";
	//课程名称
	public static final String ID_EXAM_TRAPL= "Id_exam_trapl";
	//人员
	public static final String ID_PSNDOC= "Id_psndoc";
	//人员名称
	public static final String NAME= "Name";
	//工号
	public static final String EMPNO= "Empno";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//场次主键
	public static final String ID_NET_MEET= "Id_net_meet";
	//是否报名
	public static final String FG_APPLY= "Fg_apply";
	//姓名
	public static final String NAME_PSNDOC= "Name_psndoc";
	//人员编码
	public static final String CODE_PSNDOC= "Code_psndoc";
	//名称
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
	 * 培训计划主键
	 * @return String
	 */
	public String getId_exam_trapl_psn() {
		return ((String) getAttrVal("Id_exam_trapl_psn"));
	}	
	/**
	 * 培训计划主键
	 * @param Id_exam_trapl_psn
	 */
	public void setId_exam_trapl_psn(String Id_exam_trapl_psn) {
		setAttrVal("Id_exam_trapl_psn", Id_exam_trapl_psn);
	}
	/**
	 * 课程名称
	 * @return String
	 */
	public String getId_exam_trapl() {
		return ((String) getAttrVal("Id_exam_trapl"));
	}	
	/**
	 * 课程名称
	 * @param Id_exam_trapl
	 */
	public void setId_exam_trapl(String Id_exam_trapl) {
		setAttrVal("Id_exam_trapl", Id_exam_trapl);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 人员名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 工号
	 * @return String
	 */
	public String getEmpno() {
		return ((String) getAttrVal("Empno"));
	}	
	/**
	 * 工号
	 * @param Empno
	 */
	public void setEmpno(String Empno) {
		setAttrVal("Empno", Empno);
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
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
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
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_psndoc() {
		return ((String) getAttrVal("Code_psndoc"));
	}	
	/**
	 * 人员编码
	 * @param Code_psndoc
	 */
	public void setCode_psndoc(String Code_psndoc) {
		setAttrVal("Code_psndoc", Code_psndoc);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
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
		return "Id_exam_trapl_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_exam_trapl_psn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamtraplpsnDODesc.class);
	}
	
}