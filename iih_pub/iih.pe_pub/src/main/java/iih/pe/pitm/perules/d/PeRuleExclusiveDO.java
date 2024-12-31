package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perules.d.desc.PeRuleExclusiveDODesc;
import java.math.BigDecimal;

/**
 * 体检规则排他性定义 DO数据 
 * 
 */
public class PeRuleExclusiveDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检规则排他定义主键标识
	public static final String ID_PERULEEXCLUSIVE= "Id_peruleexclusive";
	//体检异常判断规则ID
	public static final String ID_PERULEDEF= "Id_peruledef";
	//排他规则编码
	public static final String ID_PERULEDEF_EX= "Id_peruledef_ex";
	//规则名称
	public static final String NAME_RULEEX= "Name_ruleex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检规则排他定义主键标识
	 * @return String
	 */
	public String getId_peruleexclusive() {
		return ((String) getAttrVal("Id_peruleexclusive"));
	}	
	/**
	 * 体检规则排他定义主键标识
	 * @param Id_peruleexclusive
	 */
	public void setId_peruleexclusive(String Id_peruleexclusive) {
		setAttrVal("Id_peruleexclusive", Id_peruleexclusive);
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
	 * 排他规则编码
	 * @return String
	 */
	public String getId_peruledef_ex() {
		return ((String) getAttrVal("Id_peruledef_ex"));
	}	
	/**
	 * 排他规则编码
	 * @param Id_peruledef_ex
	 */
	public void setId_peruledef_ex(String Id_peruledef_ex) {
		setAttrVal("Id_peruledef_ex", Id_peruledef_ex);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getName_ruleex() {
		return ((String) getAttrVal("Name_ruleex"));
	}	
	/**
	 * 规则名称
	 * @param Name_ruleex
	 */
	public void setName_ruleex(String Name_ruleex) {
		setAttrVal("Name_ruleex", Name_ruleex);
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
		return "Id_peruleexclusive";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peruleexclusive";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRuleExclusiveDODesc.class);
	}
	
}