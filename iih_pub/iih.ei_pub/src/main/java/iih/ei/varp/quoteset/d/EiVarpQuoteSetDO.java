package iih.ei.varp.quoteset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ei.varp.quoteset.d.desc.EiVarpQuoteSetDODesc;
import java.math.BigDecimal;

/**
 * 评价器设置 DO数据 
 * 
 */
public class EiVarpQuoteSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QUOTESET= "Id_quoteset";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PC= "Id_pc";
	public static final String EU_BIZTP= "Eu_biztp";
	public static final String FACTORY= "Factory";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PC= "Name_pc";
	public static final String CODE_PC= "Code_pc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_quoteset() {
		return ((String) getAttrVal("Id_quoteset"));
	}	
	public void setId_quoteset(String Id_quoteset) {
		setAttrVal("Id_quoteset", Id_quoteset);
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
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}	
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
	public Integer getEu_biztp() {
		return ((Integer) getAttrVal("Eu_biztp"));
	}	
	public void setEu_biztp(Integer Eu_biztp) {
		setAttrVal("Eu_biztp", Eu_biztp);
	}
	public String getFactory() {
		return ((String) getAttrVal("Factory"));
	}	
	public void setFactory(String Factory) {
		setAttrVal("Factory", Factory);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_pc() {
		return ((String) getAttrVal("Name_pc"));
	}	
	public void setName_pc(String Name_pc) {
		setAttrVal("Name_pc", Name_pc);
	}
	public String getCode_pc() {
		return ((String) getAttrVal("Code_pc"));
	}	
	public void setCode_pc(String Code_pc) {
		setAttrVal("Code_pc", Code_pc);
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
		return "Id_quoteset";
	}
	
	@Override
	public String getTableName() {	  
		return "ei_varp_quote_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EiVarpQuoteSetDODesc.class);
	}
	
}