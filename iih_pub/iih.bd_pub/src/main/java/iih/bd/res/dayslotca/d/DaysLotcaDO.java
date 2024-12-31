package iih.bd.res.dayslotca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.dayslotca.d.desc.DaysLotcaDODesc;
import java.math.BigDecimal;

/**
 * 日期分组分类 DO数据 
 * 
 */
public class DaysLotcaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DAYSLOTCA= "Id_dayslotca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_DAYSLOTCATP= "Id_dayslotcatp";
	public static final String SD_DAYSLOTCATP= "Sd_dayslotcatp";
	public static final String DAYSLOTCATP_CODE= "Dayslotcatp_code";
	public static final String DAYSLOTCATP_NAME= "Dayslotcatp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dayslotca() {
		return ((String) getAttrVal("Id_dayslotca"));
	}	
	public void setId_dayslotca(String Id_dayslotca) {
		setAttrVal("Id_dayslotca", Id_dayslotca);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getId_dayslotcatp() {
		return ((String) getAttrVal("Id_dayslotcatp"));
	}	
	public void setId_dayslotcatp(String Id_dayslotcatp) {
		setAttrVal("Id_dayslotcatp", Id_dayslotcatp);
	}
	public String getSd_dayslotcatp() {
		return ((String) getAttrVal("Sd_dayslotcatp"));
	}	
	public void setSd_dayslotcatp(String Sd_dayslotcatp) {
		setAttrVal("Sd_dayslotcatp", Sd_dayslotcatp);
	}
	public String getDayslotcatp_code() {
		return ((String) getAttrVal("Dayslotcatp_code"));
	}	
	public void setDayslotcatp_code(String Dayslotcatp_code) {
		setAttrVal("Dayslotcatp_code", Dayslotcatp_code);
	}
	public String getDayslotcatp_name() {
		return ((String) getAttrVal("Dayslotcatp_name"));
	}	
	public void setDayslotcatp_name(String Dayslotcatp_name) {
		setAttrVal("Dayslotcatp_name", Dayslotcatp_name);
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
		return "Id_dayslotca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dayslotca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DaysLotcaDODesc.class);
	}
	
}