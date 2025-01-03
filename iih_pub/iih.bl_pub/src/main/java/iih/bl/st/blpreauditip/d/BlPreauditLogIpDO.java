package iih.bl.st.blpreauditip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blpreauditip.d.desc.BlPreauditLogIpDODesc;
import java.math.BigDecimal;

/**
 * 费用预审核日志_住院 DO数据 
 * 
 */
public class BlPreauditLogIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院费用预审核日志主键
	public static final String ID_PREAUDITLOGIP= "Id_preauditlogip";
	//住院医保预审核主键
	public static final String ID_PREAUDITIP= "Id_preauditip";
	//审核活动
	public static final String EU_ACT= "Eu_act";
	//活动发生时间
	public static final String DT_ACT= "Dt_act";
	//活动操作人员
	public static final String ID_EMP_ACT= "Id_emp_act";
	//操作人
	public static final String NAME_EMPACT= "Name_empact";
	//操作人员编码
	public static final String CODE_EMPACT= "Code_empact";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院费用预审核日志主键
	 * @return String
	 */
	public String getId_preauditlogip() {
		return ((String) getAttrVal("Id_preauditlogip"));
	}	
	/**
	 * 住院费用预审核日志主键
	 * @param Id_preauditlogip
	 */
	public void setId_preauditlogip(String Id_preauditlogip) {
		setAttrVal("Id_preauditlogip", Id_preauditlogip);
	}
	/**
	 * 住院医保预审核主键
	 * @return String
	 */
	public String getId_preauditip() {
		return ((String) getAttrVal("Id_preauditip"));
	}	
	/**
	 * 住院医保预审核主键
	 * @param Id_preauditip
	 */
	public void setId_preauditip(String Id_preauditip) {
		setAttrVal("Id_preauditip", Id_preauditip);
	}
	/**
	 * 审核活动
	 * @return String
	 */
	public String getEu_act() {
		return ((String) getAttrVal("Eu_act"));
	}	
	/**
	 * 审核活动
	 * @param Eu_act
	 */
	public void setEu_act(String Eu_act) {
		setAttrVal("Eu_act", Eu_act);
	}
	/**
	 * 活动发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	/**
	 * 活动发生时间
	 * @param Dt_act
	 */
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	/**
	 * 活动操作人员
	 * @return String
	 */
	public String getId_emp_act() {
		return ((String) getAttrVal("Id_emp_act"));
	}	
	/**
	 * 活动操作人员
	 * @param Id_emp_act
	 */
	public void setId_emp_act(String Id_emp_act) {
		setAttrVal("Id_emp_act", Id_emp_act);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getName_empact() {
		return ((String) getAttrVal("Name_empact"));
	}	
	/**
	 * 操作人
	 * @param Name_empact
	 */
	public void setName_empact(String Name_empact) {
		setAttrVal("Name_empact", Name_empact);
	}
	/**
	 * 操作人员编码
	 * @return String
	 */
	public String getCode_empact() {
		return ((String) getAttrVal("Code_empact"));
	}	
	/**
	 * 操作人员编码
	 * @param Code_empact
	 */
	public void setCode_empact(String Code_empact) {
		setAttrVal("Code_empact", Code_empact);
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
		return "Id_preauditlogip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_preaudit_log_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPreauditLogIpDODesc.class);
	}
	
}