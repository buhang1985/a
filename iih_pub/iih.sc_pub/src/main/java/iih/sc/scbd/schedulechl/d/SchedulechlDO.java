package iih.sc.scbd.schedulechl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import java.math.BigDecimal;

/**
 * 排班预约渠道 DO数据 
 * 
 */
public class SchedulechlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCCHL= "Id_scchl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_SCCHLTP= "Sd_scchltp";
	public static final String ID_SCCHLTP= "Id_scchltp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String DAYS= "Days";
	public static final String BEGIN_TIME= "Begin_time";
	public static final String FG_HOLIDAY_EXCL= "Fg_holiday_excl";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PTTP= "Id_pttp";
	public static final String SD_PTTP= "Sd_pttp";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_SCCHLTP= "Name_scchltp";
	public static final String CODE_SCCHLTP= "Code_scchltp";
	public static final String NAME_PTTP= "Name_pttp";
	public static final String CODE_PTTP= "Code_pttp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
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
	public String getSd_scchltp() {
		return ((String) getAttrVal("Sd_scchltp"));
	}	
	public void setSd_scchltp(String Sd_scchltp) {
		setAttrVal("Sd_scchltp", Sd_scchltp);
	}
	public String getId_scchltp() {
		return ((String) getAttrVal("Id_scchltp"));
	}	
	public void setId_scchltp(String Id_scchltp) {
		setAttrVal("Id_scchltp", Id_scchltp);
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
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}	
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
	public Integer getBegin_time() {
		return ((Integer) getAttrVal("Begin_time"));
	}	
	public void setBegin_time(Integer Begin_time) {
		setAttrVal("Begin_time", Begin_time);
	}
	public FBoolean getFg_holiday_excl() {
		return ((FBoolean) getAttrVal("Fg_holiday_excl"));
	}	
	public void setFg_holiday_excl(FBoolean Fg_holiday_excl) {
		setAttrVal("Fg_holiday_excl", Fg_holiday_excl);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getId_pttp() {
		return ((String) getAttrVal("Id_pttp"));
	}	
	public void setId_pttp(String Id_pttp) {
		setAttrVal("Id_pttp", Id_pttp);
	}
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_scchltp() {
		return ((String) getAttrVal("Name_scchltp"));
	}	
	public void setName_scchltp(String Name_scchltp) {
		setAttrVal("Name_scchltp", Name_scchltp);
	}
	public String getCode_scchltp() {
		return ((String) getAttrVal("Code_scchltp"));
	}	
	public void setCode_scchltp(String Code_scchltp) {
		setAttrVal("Code_scchltp", Code_scchltp);
	}
	public String getName_pttp() {
		return ((String) getAttrVal("Name_pttp"));
	}	
	public void setName_pttp(String Name_pttp) {
		setAttrVal("Name_pttp", Name_pttp);
	}
	public String getCode_pttp() {
		return ((String) getAttrVal("Code_pttp"));
	}	
	public void setCode_pttp(String Code_pttp) {
		setAttrVal("Code_pttp", Code_pttp);
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
		return "Id_scchl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_chl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SchedulechlDODesc.class);
	}
	
}