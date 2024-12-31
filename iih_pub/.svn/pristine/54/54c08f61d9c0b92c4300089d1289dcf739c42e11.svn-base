package iih.mi.bd.miudidoclist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.bd.miudidoclist.d.desc.MiUdidoclistDODesc;
import java.math.BigDecimal;

/**
 * 医保档案类型 DO数据 
 * 
 */
public class MiUdidoclistDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MIUDIDOCLIST= "Id_miudidoclist";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String FG_NEEDCOMP= "Fg_needcomp";
	public static final String COMP_TABLENAME= "Comp_tablename";
	public static final String COMP_CODECOLUMN= "Comp_codecolumn";
	public static final String COMP_NAMECOLUMN= "Comp_namecolumn";
	public static final String COMP_CONDITION= "Comp_condition";
	public static final String DOCCLASS= "Docclass";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_miudidoclist() {
		return ((String) getAttrVal("Id_miudidoclist"));
	}	
	public void setId_miudidoclist(String Id_miudidoclist) {
		setAttrVal("Id_miudidoclist", Id_miudidoclist);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FBoolean getFg_needcomp() {
		return ((FBoolean) getAttrVal("Fg_needcomp"));
	}	
	public void setFg_needcomp(FBoolean Fg_needcomp) {
		setAttrVal("Fg_needcomp", Fg_needcomp);
	}
	public String getComp_tablename() {
		return ((String) getAttrVal("Comp_tablename"));
	}	
	public void setComp_tablename(String Comp_tablename) {
		setAttrVal("Comp_tablename", Comp_tablename);
	}
	public String getComp_codecolumn() {
		return ((String) getAttrVal("Comp_codecolumn"));
	}	
	public void setComp_codecolumn(String Comp_codecolumn) {
		setAttrVal("Comp_codecolumn", Comp_codecolumn);
	}
	public String getComp_namecolumn() {
		return ((String) getAttrVal("Comp_namecolumn"));
	}	
	public void setComp_namecolumn(String Comp_namecolumn) {
		setAttrVal("Comp_namecolumn", Comp_namecolumn);
	}
	public String getComp_condition() {
		return ((String) getAttrVal("Comp_condition"));
	}	
	public void setComp_condition(String Comp_condition) {
		setAttrVal("Comp_condition", Comp_condition);
	}
	public Integer getDocclass() {
		return ((Integer) getAttrVal("Docclass"));
	}	
	public void setDocclass(Integer Docclass) {
		setAttrVal("Docclass", Docclass);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_miudidoclist";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_udidoclist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiUdidoclistDODesc.class);
	}
	
}