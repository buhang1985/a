package iih.pe.phm.peeduplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peeduplan.d.desc.PeEduPlanDtlDODesc;
import java.math.BigDecimal;

/**
 * 健康群体教育计划明细 DO数据 
 * 
 */
public class PeEduPlanDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康群体教育计划明细主键标识
	public static final String ID_PEEDUPLANDEL= "Id_peeduplandel";
	//健康群体教育计划ID
	public static final String ID_PEEDUPLAN= "Id_peeduplan";
	//健康教育处方ID
	public static final String ID_EDURECIPE= "Id_edurecipe";
	//教育内容
	public static final String CONT= "Cont";
	//教育目标
	public static final String GOAL= "Goal";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//截止日期
	public static final String DT_END= "Dt_end";
	//负责人
	public static final String DIRECTOR= "Director";
	//预算
	public static final String BUDGET= "Budget";
	//说明
	public static final String NOTE= "Note";
	//完成标识
	public static final String FG_FINISH= "Fg_finish";
	//完成日期
	public static final String DT_FINISH= "Dt_finish";
	//编码
	public static final String CODE_RECIPE= "Code_recipe";
	//名单
	public static final String NAME_RECIPE= "Name_recipe";
	//解释
	public static final String EXPLAIN_RECIPE= "Explain_recipe";
	//症状
	public static final String SYMPTOM_RECIPE= "Symptom_recipe";
	//主要危险因素
	public static final String MAINRISKS_RECIPE= "Mainrisks_recipe";
	//保健要点
	public static final String KEYPOINT_RECIPE= "Keypoint_recipe";
	//特别说明
	public static final String NOTE_RECIPE= "Note_recipe";
	//人员编码
	public static final String CODE_PSN= "Code_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康群体教育计划明细主键标识
	 * @return String
	 */
	public String getId_peeduplandel() {
		return ((String) getAttrVal("Id_peeduplandel"));
	}	
	/**
	 * 健康群体教育计划明细主键标识
	 * @param Id_peeduplandel
	 */
	public void setId_peeduplandel(String Id_peeduplandel) {
		setAttrVal("Id_peeduplandel", Id_peeduplandel);
	}
	/**
	 * 健康群体教育计划ID
	 * @return String
	 */
	public String getId_peeduplan() {
		return ((String) getAttrVal("Id_peeduplan"));
	}	
	/**
	 * 健康群体教育计划ID
	 * @param Id_peeduplan
	 */
	public void setId_peeduplan(String Id_peeduplan) {
		setAttrVal("Id_peeduplan", Id_peeduplan);
	}
	/**
	 * 健康教育处方ID
	 * @return String
	 */
	public String getId_edurecipe() {
		return ((String) getAttrVal("Id_edurecipe"));
	}	
	/**
	 * 健康教育处方ID
	 * @param Id_edurecipe
	 */
	public void setId_edurecipe(String Id_edurecipe) {
		setAttrVal("Id_edurecipe", Id_edurecipe);
	}
	/**
	 * 教育内容
	 * @return String
	 */
	public String getCont() {
		return ((String) getAttrVal("Cont"));
	}	
	/**
	 * 教育内容
	 * @param Cont
	 */
	public void setCont(String Cont) {
		setAttrVal("Cont", Cont);
	}
	/**
	 * 教育目标
	 * @return String
	 */
	public String getGoal() {
		return ((String) getAttrVal("Goal"));
	}	
	/**
	 * 教育目标
	 * @param Goal
	 */
	public void setGoal(String Goal) {
		setAttrVal("Goal", Goal);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 负责人
	 * @return String
	 */
	public String getDirector() {
		return ((String) getAttrVal("Director"));
	}	
	/**
	 * 负责人
	 * @param Director
	 */
	public void setDirector(String Director) {
		setAttrVal("Director", Director);
	}
	/**
	 * 预算
	 * @return FDouble
	 */
	public FDouble getBudget() {
		return ((FDouble) getAttrVal("Budget"));
	}	
	/**
	 * 预算
	 * @param Budget
	 */
	public void setBudget(FDouble Budget) {
		setAttrVal("Budget", Budget);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 说明
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}	
	/**
	 * 完成标识
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 完成日期
	 * @return FDate
	 */
	public FDate getDt_finish() {
		return ((FDate) getAttrVal("Dt_finish"));
	}	
	/**
	 * 完成日期
	 * @param Dt_finish
	 */
	public void setDt_finish(FDate Dt_finish) {
		setAttrVal("Dt_finish", Dt_finish);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_recipe() {
		return ((String) getAttrVal("Code_recipe"));
	}	
	/**
	 * 编码
	 * @param Code_recipe
	 */
	public void setCode_recipe(String Code_recipe) {
		setAttrVal("Code_recipe", Code_recipe);
	}
	/**
	 * 名单
	 * @return String
	 */
	public String getName_recipe() {
		return ((String) getAttrVal("Name_recipe"));
	}	
	/**
	 * 名单
	 * @param Name_recipe
	 */
	public void setName_recipe(String Name_recipe) {
		setAttrVal("Name_recipe", Name_recipe);
	}
	/**
	 * 解释
	 * @return String
	 */
	public String getExplain_recipe() {
		return ((String) getAttrVal("Explain_recipe"));
	}	
	/**
	 * 解释
	 * @param Explain_recipe
	 */
	public void setExplain_recipe(String Explain_recipe) {
		setAttrVal("Explain_recipe", Explain_recipe);
	}
	/**
	 * 症状
	 * @return String
	 */
	public String getSymptom_recipe() {
		return ((String) getAttrVal("Symptom_recipe"));
	}	
	/**
	 * 症状
	 * @param Symptom_recipe
	 */
	public void setSymptom_recipe(String Symptom_recipe) {
		setAttrVal("Symptom_recipe", Symptom_recipe);
	}
	/**
	 * 主要危险因素
	 * @return String
	 */
	public String getMainrisks_recipe() {
		return ((String) getAttrVal("Mainrisks_recipe"));
	}	
	/**
	 * 主要危险因素
	 * @param Mainrisks_recipe
	 */
	public void setMainrisks_recipe(String Mainrisks_recipe) {
		setAttrVal("Mainrisks_recipe", Mainrisks_recipe);
	}
	/**
	 * 保健要点
	 * @return String
	 */
	public String getKeypoint_recipe() {
		return ((String) getAttrVal("Keypoint_recipe"));
	}	
	/**
	 * 保健要点
	 * @param Keypoint_recipe
	 */
	public void setKeypoint_recipe(String Keypoint_recipe) {
		setAttrVal("Keypoint_recipe", Keypoint_recipe);
	}
	/**
	 * 特别说明
	 * @return String
	 */
	public String getNote_recipe() {
		return ((String) getAttrVal("Note_recipe"));
	}	
	/**
	 * 特别说明
	 * @param Note_recipe
	 */
	public void setNote_recipe(String Note_recipe) {
		setAttrVal("Note_recipe", Note_recipe);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 人员编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
		return "Id_peeduplandel";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_eduplandtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEduPlanDtlDODesc.class);
	}
	
}