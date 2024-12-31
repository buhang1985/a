package iih.sc.sch.scticks.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_号段 DO数据 
 * 
 */
public class ScSchTicksDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TICKS= "Id_ticks";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SCH= "Id_sch";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String QUECN= "Quecn";
	public static final String QUECN_USED= "Quecn_used";
	public static final String QUECN_APPT= "Quecn_appt";
	public static final String QUENO_B= "Queno_b";
	public static final String ID_APPTRU= "Id_apptru";
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String T_B= "T_b";
	public static final String T_E= "T_e";
	public static final String FG_USED= "Fg_used";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FG_ADD= "Fg_add";
	public static final String PRJFLD1= "Prjfld1";
	public static final String PRJFLD2= "Prjfld2";
	public static final String PRJFLD3= "Prjfld3";
	public static final String PRJFLD4= "Prjfld4";
	public static final String PRJFLD5= "Prjfld5";
	public static final String PRJFLD6= "Prjfld6";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String IDS_KINDITM= "Ids_kinditm";
	public static final String ID_SCAPT= "Id_scapt";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_KINDITM= "Code_kinditm";
	public static final String NAME_KINDITM= "Name_kinditm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
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
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
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
	public Integer getQuecn() {
		return ((Integer) getAttrVal("Quecn"));
	}	
	public void setQuecn(Integer Quecn) {
		setAttrVal("Quecn", Quecn);
	}
	public Integer getQuecn_used() {
		return ((Integer) getAttrVal("Quecn_used"));
	}	
	public void setQuecn_used(Integer Quecn_used) {
		setAttrVal("Quecn_used", Quecn_used);
	}
	public Integer getQuecn_appt() {
		return ((Integer) getAttrVal("Quecn_appt"));
	}	
	public void setQuecn_appt(Integer Quecn_appt) {
		setAttrVal("Quecn_appt", Quecn_appt);
	}
	public Integer getQueno_b() {
		return ((Integer) getAttrVal("Queno_b"));
	}	
	public void setQueno_b(Integer Queno_b) {
		setAttrVal("Queno_b", Queno_b);
	}
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}	
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	public FTime getT_b() {
		return ((FTime) getAttrVal("T_b"));
	}	
	public void setT_b(FTime T_b) {
		setAttrVal("T_b", T_b);
	}
	public FTime getT_e() {
		return ((FTime) getAttrVal("T_e"));
	}	
	public void setT_e(FTime T_e) {
		setAttrVal("T_e", T_e);
	}
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}	
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	public String getPrjfld1() {
		return ((String) getAttrVal("Prjfld1"));
	}	
	public void setPrjfld1(String Prjfld1) {
		setAttrVal("Prjfld1", Prjfld1);
	}
	public String getPrjfld2() {
		return ((String) getAttrVal("Prjfld2"));
	}	
	public void setPrjfld2(String Prjfld2) {
		setAttrVal("Prjfld2", Prjfld2);
	}
	public String getPrjfld3() {
		return ((String) getAttrVal("Prjfld3"));
	}	
	public void setPrjfld3(String Prjfld3) {
		setAttrVal("Prjfld3", Prjfld3);
	}
	public String getPrjfld4() {
		return ((String) getAttrVal("Prjfld4"));
	}	
	public void setPrjfld4(String Prjfld4) {
		setAttrVal("Prjfld4", Prjfld4);
	}
	public String getPrjfld5() {
		return ((String) getAttrVal("Prjfld5"));
	}	
	public void setPrjfld5(String Prjfld5) {
		setAttrVal("Prjfld5", Prjfld5);
	}
	public String getPrjfld6() {
		return ((String) getAttrVal("Prjfld6"));
	}	
	public void setPrjfld6(String Prjfld6) {
		setAttrVal("Prjfld6", Prjfld6);
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
	public String getIds_kinditm() {
		return ((String) getAttrVal("Ids_kinditm"));
	}	
	public void setIds_kinditm(String Ids_kinditm) {
		setAttrVal("Ids_kinditm", Ids_kinditm);
	}
	public String getId_scapt() {
		return ((String) getAttrVal("Id_scapt"));
	}	
	public void setId_scapt(String Id_scapt) {
		setAttrVal("Id_scapt", Id_scapt);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getCode_kinditm() {
		return ((String) getAttrVal("Code_kinditm"));
	}	
	public void setCode_kinditm(String Code_kinditm) {
		setAttrVal("Code_kinditm", Code_kinditm);
	}
	public String getName_kinditm() {
		return ((String) getAttrVal("Name_kinditm"));
	}	
	public void setName_kinditm(String Name_kinditm) {
		setAttrVal("Name_kinditm", Name_kinditm);
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
		return "Id_ticks";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_ticks";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchTicksDODesc.class);
	}
	
}