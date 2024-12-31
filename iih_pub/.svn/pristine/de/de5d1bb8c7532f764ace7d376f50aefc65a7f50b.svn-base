package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemDiagRuleDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_诊断规则 DO数据 
 * 
 */
public class HpCpElemDiagRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊断规则ID
	public static final String ID_ELE_DIAGRULE= "Id_ele_diagrule";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//准入ICD编码ID列表
	public static final String ID_INCODELIST= "Id_incodelist";
	//准入ICD编码列表
	public static final String INCODELIST= "Incodelist";
	//排斥ICD编码ID列表
	public static final String ID_EXCODELIST= "Id_excodelist";
	//排斥ICD编码列表
	public static final String EXCODELIST= "Excodelist";
	//诊断名称
	public static final String INNAMELIST= "Innamelist";
	//诊断名称
	public static final String EXNAMELIST= "Exnamelist";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊断规则ID
	 * @return String
	 */
	public String getId_ele_diagrule() {
		return ((String) getAttrVal("Id_ele_diagrule"));
	}	
	/**
	 * 诊断规则ID
	 * @param Id_ele_diagrule
	 */
	public void setId_ele_diagrule(String Id_ele_diagrule) {
		setAttrVal("Id_ele_diagrule", Id_ele_diagrule);
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
	 * 准入ICD编码ID列表
	 * @return String
	 */
	public String getId_incodelist() {
		return ((String) getAttrVal("Id_incodelist"));
	}	
	/**
	 * 准入ICD编码ID列表
	 * @param Id_incodelist
	 */
	public void setId_incodelist(String Id_incodelist) {
		setAttrVal("Id_incodelist", Id_incodelist);
	}
	/**
	 * 准入ICD编码列表
	 * @return String
	 */
	public String getIncodelist() {
		return ((String) getAttrVal("Incodelist"));
	}	
	/**
	 * 准入ICD编码列表
	 * @param Incodelist
	 */
	public void setIncodelist(String Incodelist) {
		setAttrVal("Incodelist", Incodelist);
	}
	/**
	 * 排斥ICD编码ID列表
	 * @return String
	 */
	public String getId_excodelist() {
		return ((String) getAttrVal("Id_excodelist"));
	}	
	/**
	 * 排斥ICD编码ID列表
	 * @param Id_excodelist
	 */
	public void setId_excodelist(String Id_excodelist) {
		setAttrVal("Id_excodelist", Id_excodelist);
	}
	/**
	 * 排斥ICD编码列表
	 * @return String
	 */
	public String getExcodelist() {
		return ((String) getAttrVal("Excodelist"));
	}	
	/**
	 * 排斥ICD编码列表
	 * @param Excodelist
	 */
	public void setExcodelist(String Excodelist) {
		setAttrVal("Excodelist", Excodelist);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getInnamelist() {
		return ((String) getAttrVal("Innamelist"));
	}	
	/**
	 * 诊断名称
	 * @param Innamelist
	 */
	public void setInnamelist(String Innamelist) {
		setAttrVal("Innamelist", Innamelist);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getExnamelist() {
		return ((String) getAttrVal("Exnamelist"));
	}	
	/**
	 * 诊断名称
	 * @param Exnamelist
	 */
	public void setExnamelist(String Exnamelist) {
		setAttrVal("Exnamelist", Exnamelist);
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
		return "Id_ele_diagrule";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_DIAGRULE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemDiagRuleDODesc.class);
	}
	
}