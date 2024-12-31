package iih.bd.fc.orpltpstafunc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orpltpstafunc.d.desc.OrpltpStaFuncDODesc;
import java.math.BigDecimal;

/**
 * 闭环状态点配置 DO数据 
 * 
 */
public class OrpltpStaFuncDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPLTPSTAFUNC= "Id_orpltpstafunc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORPLTP= "Id_orpltp";
	public static final String SD_ORPLTP= "Sd_orpltp";
	public static final String ID_FUN= "Id_fun";
	public static final String FUN_CODE= "Fun_code";
	public static final String ID_ORPLTPSTA= "Id_orpltpsta";
	public static final String SD_ORPLTPSTA= "Sd_orpltpsta";
	public static final String ID_OPER= "Id_oper";
	public static final String SD_OPER= "Sd_oper";
	public static final String FG_SYS= "Fg_sys";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ORPLTP= "Name_orpltp";
	public static final String FUN_NAME= "Fun_name";
	public static final String NAME_ORPLTPSTA= "Name_orpltpsta";
	public static final String SORTNO= "Sortno";
	public static final String NAME_OPER= "Name_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orpltpstafunc() {
		return ((String) getAttrVal("Id_orpltpstafunc"));
	}	
	public void setId_orpltpstafunc(String Id_orpltpstafunc) {
		setAttrVal("Id_orpltpstafunc", Id_orpltpstafunc);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	public String getSd_orpltp() {
		return ((String) getAttrVal("Sd_orpltp"));
	}	
	public void setSd_orpltp(String Sd_orpltp) {
		setAttrVal("Sd_orpltp", Sd_orpltp);
	}
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}	
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}	
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}	
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	public String getSd_orpltpsta() {
		return ((String) getAttrVal("Sd_orpltpsta"));
	}	
	public void setSd_orpltpsta(String Sd_orpltpsta) {
		setAttrVal("Sd_orpltpsta", Sd_orpltpsta);
	}
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	public String getSd_oper() {
		return ((String) getAttrVal("Sd_oper"));
	}	
	public void setSd_oper(String Sd_oper) {
		setAttrVal("Sd_oper", Sd_oper);
	}
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
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
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}	
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
	}
	public String getFun_name() {
		return ((String) getAttrVal("Fun_name"));
	}	
	public void setFun_name(String Fun_name) {
		setAttrVal("Fun_name", Fun_name);
	}
	public String getName_orpltpsta() {
		return ((String) getAttrVal("Name_orpltpsta"));
	}	
	public void setName_orpltpsta(String Name_orpltpsta) {
		setAttrVal("Name_orpltpsta", Name_orpltpsta);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
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
		return "Id_orpltpstafunc";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_ORPLTPSTA_FUNC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrpltpStaFuncDODesc.class);
	}
	
}