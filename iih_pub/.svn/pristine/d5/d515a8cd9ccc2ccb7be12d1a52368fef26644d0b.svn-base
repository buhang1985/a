package iih.pe.pitm.pechrodisedef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pechrodisedef.d.desc.PeChroDiseDiDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病诊断定义 DO数据 
 * 
 */
public class PeChroDiseDiDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHRODISEDIDEF= "Id_pechrodisedidef";
	public static final String ID_PECHRODISEDEF= "Id_pechrodisedef";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	public static final String CODE_DI= "Code_di";
	public static final String NAME_DI= "Name_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechrodisedidef() {
		return ((String) getAttrVal("Id_pechrodisedidef"));
	}	
	public void setId_pechrodisedidef(String Id_pechrodisedidef) {
		setAttrVal("Id_pechrodisedidef", Id_pechrodisedidef);
	}
	public String getId_pechrodisedef() {
		return ((String) getAttrVal("Id_pechrodisedef"));
	}	
	public void setId_pechrodisedef(String Id_pechrodisedef) {
		setAttrVal("Id_pechrodisedef", Id_pechrodisedef);
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
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_pechrodisedidef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pechrodisedidef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseDiDefDODesc.class);
	}
	
}