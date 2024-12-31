package iih.pe.pitm.pechrodisedef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pechrodisedef.d.desc.PeChroDiseRuleDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病规则定义 DO数据 
 * 
 */
public class PeChroDiseRuleDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHRODISERULEDEF= "Id_pechrodiseruledef";
	public static final String ID_PECHRODISEDEF= "Id_pechrodisedef";
	public static final String ID_PERULEDEF= "Id_peruledef";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_RULE= "Code_rule";
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechrodiseruledef() {
		return ((String) getAttrVal("Id_pechrodiseruledef"));
	}	
	public void setId_pechrodiseruledef(String Id_pechrodiseruledef) {
		setAttrVal("Id_pechrodiseruledef", Id_pechrodiseruledef);
	}
	public String getId_pechrodisedef() {
		return ((String) getAttrVal("Id_pechrodisedef"));
	}	
	public void setId_pechrodisedef(String Id_pechrodisedef) {
		setAttrVal("Id_pechrodisedef", Id_pechrodisedef);
	}
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
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
		return "Id_pechrodiseruledef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pechrodiseruledef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseRuleDefDODesc.class);
	}
	
}