package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.appele.d.desc.HpCpAppElemStageDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用元素_计划阶段 DO数据 
 * 
 */
public class HpCpAppElemStageDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应用元素计划阶段ID
	public static final String ID_APPELE_STAGE= "Id_appele_stage";
	//诊疗计划应用元素ID
	public static final String ID_APPELE= "Id_appele";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//实际进入计划阶段日期
	public static final String DT_ENTER= "Dt_enter";
	//实际离开计划阶段日期
	public static final String DT_EXIT= "Dt_exit";
	//备注
	public static final String REMARKS= "Remarks";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应用元素计划阶段ID
	 * @return String
	 */
	public String getId_appele_stage() {
		return ((String) getAttrVal("Id_appele_stage"));
	}	
	/**
	 * 应用元素计划阶段ID
	 * @param Id_appele_stage
	 */
	public void setId_appele_stage(String Id_appele_stage) {
		setAttrVal("Id_appele_stage", Id_appele_stage);
	}
	/**
	 * 诊疗计划应用元素ID
	 * @return String
	 */
	public String getId_appele() {
		return ((String) getAttrVal("Id_appele"));
	}	
	/**
	 * 诊疗计划应用元素ID
	 * @param Id_appele
	 */
	public void setId_appele(String Id_appele) {
		setAttrVal("Id_appele", Id_appele);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 实际进入计划阶段日期
	 * @return FDateTime
	 */
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}	
	/**
	 * 实际进入计划阶段日期
	 * @param Dt_enter
	 */
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	/**
	 * 实际离开计划阶段日期
	 * @return FDateTime
	 */
	public FDateTime getDt_exit() {
		return ((FDateTime) getAttrVal("Dt_exit"));
	}	
	/**
	 * 实际离开计划阶段日期
	 * @param Dt_exit
	 */
	public void setDt_exit(FDateTime Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}	
	/**
	 * 备注
	 * @param Remarks
	 */
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
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
		return "Id_appele_stage";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ELE_STAGE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppElemStageDODesc.class);
	}
	
}