package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perules.d.desc.PeRuleDiagDODesc;
import java.math.BigDecimal;

/**
 * 体检规则关联诊断 DO数据 
 * 
 */
public class PeRuleDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检规则诊断主键标识
	public static final String ID_PERULEDIAG= "Id_perulediag";
	//体检异常判断规则ID
	public static final String ID_PERULEDEF= "Id_peruledef";
	//诊断定义主键
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//类型
	public static final String OPERATION_TYPE= "Operation_type";
	//规则编码
	public static final String SD_RULE= "Sd_rule";
	//诊断编码
	public static final String SD_DIAG= "Sd_diag";
	//关联编码
	public static final String SD_LINK= "Sd_link";
	//诊断名称
	public static final String NAME_DIAG= "Name_diag";
	//直连建议
	public static final String ADVICE_DIAG= "Advice_diag";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检规则诊断主键标识
	 * @return String
	 */
	public String getId_perulediag() {
		return ((String) getAttrVal("Id_perulediag"));
	}	
	/**
	 * 体检规则诊断主键标识
	 * @param Id_perulediag
	 */
	public void setId_perulediag(String Id_perulediag) {
		setAttrVal("Id_perulediag", Id_perulediag);
	}
	/**
	 * 体检异常判断规则ID
	 * @return String
	 */
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	/**
	 * 体检异常判断规则ID
	 * @param Id_peruledef
	 */
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	/**
	 * 诊断定义主键
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 诊断定义主键
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	/**
	 * 类型
	 * @return Integer
	 */
	public Integer getOperation_type() {
		return ((Integer) getAttrVal("Operation_type"));
	}	
	/**
	 * 类型
	 * @param Operation_type
	 */
	public void setOperation_type(Integer Operation_type) {
		setAttrVal("Operation_type", Operation_type);
	}
	/**
	 * 规则编码
	 * @return String
	 */
	public String getSd_rule() {
		return ((String) getAttrVal("Sd_rule"));
	}	
	/**
	 * 规则编码
	 * @param Sd_rule
	 */
	public void setSd_rule(String Sd_rule) {
		setAttrVal("Sd_rule", Sd_rule);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getSd_diag() {
		return ((String) getAttrVal("Sd_diag"));
	}	
	/**
	 * 诊断编码
	 * @param Sd_diag
	 */
	public void setSd_diag(String Sd_diag) {
		setAttrVal("Sd_diag", Sd_diag);
	}
	/**
	 * 关联编码
	 * @return String
	 */
	public String getSd_link() {
		return ((String) getAttrVal("Sd_link"));
	}	
	/**
	 * 关联编码
	 * @param Sd_link
	 */
	public void setSd_link(String Sd_link) {
		setAttrVal("Sd_link", Sd_link);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 直连建议
	 * @return String
	 */
	public String getAdvice_diag() {
		return ((String) getAttrVal("Advice_diag"));
	}	
	/**
	 * 直连建议
	 * @param Advice_diag
	 */
	public void setAdvice_diag(String Advice_diag) {
		setAttrVal("Advice_diag", Advice_diag);
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
		return "Id_perulediag";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perulediag";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRuleDiagDODesc.class);
	}
	
}