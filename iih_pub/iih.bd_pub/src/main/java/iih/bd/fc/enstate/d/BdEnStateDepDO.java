package iih.bd.fc.enstate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.enstate.d.desc.BdEnStateDepDODesc;
import java.math.BigDecimal;

/**
 * 科室就诊状况DO DO数据 
 * 
 */
public class BdEnStateDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENSTATEDEP= "Id_enstatedep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String SORTNO= "Sortno";
	public static final String ID_ENSTATE= "Id_enstate";
	public static final String ID_ENSTATETP= "Id_enstatetp";
	public static final String SD_ENSTATETP= "Sd_enstatetp";
	public static final String VAL= "Val";
	public static final String LABEL= "Label";
	public static final String FG_SHOWICON= "Fg_showicon";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_STATE= "Name_state";
	public static final String NAME_ENSTATETP= "Name_enstatetp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_enstatedep() {
		return ((String) getAttrVal("Id_enstatedep"));
	}	
	public void setId_enstatedep(String Id_enstatedep) {
		setAttrVal("Id_enstatedep", Id_enstatedep);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_enstate() {
		return ((String) getAttrVal("Id_enstate"));
	}	
	public void setId_enstate(String Id_enstate) {
		setAttrVal("Id_enstate", Id_enstate);
	}
	public String getId_enstatetp() {
		return ((String) getAttrVal("Id_enstatetp"));
	}	
	public void setId_enstatetp(String Id_enstatetp) {
		setAttrVal("Id_enstatetp", Id_enstatetp);
	}
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}	
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public String getLabel() {
		return ((String) getAttrVal("Label"));
	}	
	public void setLabel(String Label) {
		setAttrVal("Label", Label);
	}
	public FBoolean getFg_showicon() {
		return ((FBoolean) getAttrVal("Fg_showicon"));
	}	
	public void setFg_showicon(FBoolean Fg_showicon) {
		setAttrVal("Fg_showicon", Fg_showicon);
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
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}	
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	public String getName_enstatetp() {
		return ((String) getAttrVal("Name_enstatetp"));
	}	
	public void setName_enstatetp(String Name_enstatetp) {
		setAttrVal("Name_enstatetp", Name_enstatetp);
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
		return "Id_enstatedep";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_en_state_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdEnStateDepDODesc.class);
	}
	
}