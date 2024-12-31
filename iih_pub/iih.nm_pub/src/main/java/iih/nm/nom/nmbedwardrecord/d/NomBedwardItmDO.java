package iih.nm.nom.nmbedwardrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nmbedwardrecord.d.desc.NomBedwardItmDODesc;
import java.math.BigDecimal;

/**
 * 病区患者项目统计 DO数据 
 * 
 */
public class NomBedwardItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BEDWARDITM= "Id_bedwarditm";
	public static final String ID_NOM_WKITM= "Id_nom_wkitm";
	public static final String ID_BEDWARD_RECORD= "Id_bedward_record";
	public static final String COUNT= "Count";
	public static final String DATA_STATUS= "Data_status";
	public static final String FG_COMFIRM= "Fg_comfirm";
	public static final String CTR_1= "Ctr_1";
	public static final String CTR_2= "Ctr_2";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_WKITM= "Name_wkitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bedwarditm() {
		return ((String) getAttrVal("Id_bedwarditm"));
	}	
	public void setId_bedwarditm(String Id_bedwarditm) {
		setAttrVal("Id_bedwarditm", Id_bedwarditm);
	}
	public String getId_nom_wkitm() {
		return ((String) getAttrVal("Id_nom_wkitm"));
	}	
	public void setId_nom_wkitm(String Id_nom_wkitm) {
		setAttrVal("Id_nom_wkitm", Id_nom_wkitm);
	}
	public String getId_bedward_record() {
		return ((String) getAttrVal("Id_bedward_record"));
	}	
	public void setId_bedward_record(String Id_bedward_record) {
		setAttrVal("Id_bedward_record", Id_bedward_record);
	}
	public Integer getCount() {
		return ((Integer) getAttrVal("Count"));
	}	
	public void setCount(Integer Count) {
		setAttrVal("Count", Count);
	}
	public Integer getData_status() {
		return ((Integer) getAttrVal("Data_status"));
	}	
	public void setData_status(Integer Data_status) {
		setAttrVal("Data_status", Data_status);
	}
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
	public String getCtr_1() {
		return ((String) getAttrVal("Ctr_1"));
	}	
	public void setCtr_1(String Ctr_1) {
		setAttrVal("Ctr_1", Ctr_1);
	}
	public String getCtr_2() {
		return ((String) getAttrVal("Ctr_2"));
	}	
	public void setCtr_2(String Ctr_2) {
		setAttrVal("Ctr_2", Ctr_2);
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
	public String getName_wkitm() {
		return ((String) getAttrVal("Name_wkitm"));
	}	
	public void setName_wkitm(String Name_wkitm) {
		setAttrVal("Name_wkitm", Name_wkitm);
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
		return "Id_bedwarditm";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_nom_bedward_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomBedwardItmDODesc.class);
	}
	
}