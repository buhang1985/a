package iih.nm.nom.nmbedwardrecord.d;

import iih.nm.nom.nmbedwardrecord.d.desc.NomBedwardRecordDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 病区患者统计 DO数据 
 * 
 */
public class NomBedwardRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BEDWARD_RECORD= "Id_bedward_record";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String DT_RECORD= "Dt_record";
	public static final String FG_COMFIRM= "Fg_comfirm";
	public static final String CTRL_1= "Ctrl_1";
	public static final String CTRL_2= "Ctrl_2";
	public static final String CTRL_3= "Ctrl_3";
	public static final String CTRL_4= "Ctrl_4";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NURDEP= "Name_nurdep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bedward_record() {
		return ((String) getAttrVal("Id_bedward_record"));
	}	
	public void setId_bedward_record(String Id_bedward_record) {
		setAttrVal("Id_bedward_record", Id_bedward_record);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FDate getDt_record() {
		return ((FDate) getAttrVal("Dt_record"));
	}	
	public void setDt_record(FDate Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
	public String getCtrl_1() {
		return ((String) getAttrVal("Ctrl_1"));
	}	
	public void setCtrl_1(String Ctrl_1) {
		setAttrVal("Ctrl_1", Ctrl_1);
	}
	public String getCtrl_2() {
		return ((String) getAttrVal("Ctrl_2"));
	}	
	public void setCtrl_2(String Ctrl_2) {
		setAttrVal("Ctrl_2", Ctrl_2);
	}
	public FBoolean getCtrl_3() {
		return ((FBoolean) getAttrVal("Ctrl_3"));
	}	
	public void setCtrl_3(FBoolean Ctrl_3) {
		setAttrVal("Ctrl_3", Ctrl_3);
	}
	public FBoolean getCtrl_4() {
		return ((FBoolean) getAttrVal("Ctrl_4"));
	}	
	public void setCtrl_4(FBoolean Ctrl_4) {
		setAttrVal("Ctrl_4", Ctrl_4);
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
	public String getName_nurdep() {
		return ((String) getAttrVal("Name_nurdep"));
	}	
	public void setName_nurdep(String Name_nurdep) {
		setAttrVal("Name_nurdep", Name_nurdep);
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
		return "Id_bedward_record";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_nom_bedward_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomBedwardRecordDODesc.class);
	}
	
}