package iih.pe.pitm.perulecombine.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perulecombine.d.desc.PeRuleCombineItemDODesc;
import java.math.BigDecimal;

/**
 * 体检组合规则定义明细 DO数据 
 * 
 */
public class PeRuleCombineItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检规则组合明细主键标识
	public static final String ID_PERULECOMBINEITEM= "Id_perulecombineitem";
	//体检规则组合ID
	public static final String ID_PERULECOMBINE= "Id_perulecombine";
	//体检规则ID
	public static final String ID_PERULEDEF= "Id_peruledef";
	//规则编码
	public static final String CODE_RULE= "Code_rule";
	//规则名称
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检规则组合明细主键标识
	 * @return String
	 */
	public String getId_perulecombineitem() {
		return ((String) getAttrVal("Id_perulecombineitem"));
	}	
	/**
	 * 体检规则组合明细主键标识
	 * @param Id_perulecombineitem
	 */
	public void setId_perulecombineitem(String Id_perulecombineitem) {
		setAttrVal("Id_perulecombineitem", Id_perulecombineitem);
	}
	/**
	 * 体检规则组合ID
	 * @return String
	 */
	public String getId_perulecombine() {
		return ((String) getAttrVal("Id_perulecombine"));
	}	
	/**
	 * 体检规则组合ID
	 * @param Id_perulecombine
	 */
	public void setId_perulecombine(String Id_perulecombine) {
		setAttrVal("Id_perulecombine", Id_perulecombine);
	}
	/**
	 * 体检规则ID
	 * @return String
	 */
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	/**
	 * 体检规则ID
	 * @param Id_peruledef
	 */
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	/**
	 * 规则编码
	 * @return String
	 */
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	/**
	 * 规则编码
	 * @param Code_rule
	 */
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	/**
	 * 规则名称
	 * @param Name_rule
	 */
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
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
		return "Id_perulecombineitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_rulecombineitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRuleCombineItemDODesc.class);
	}
	
}