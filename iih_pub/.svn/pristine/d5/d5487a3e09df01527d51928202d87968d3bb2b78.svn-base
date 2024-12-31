package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnBedDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_床位 DO数据 
 * 
 */
public class EnBedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTBED= "Id_entbed";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_DEP_WRD= "Id_dep_wrd";
	public static final String ID_BED= "Id_bed";
	public static final String NAME_BED= "Name_bed";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String ID_USETYPE= "Id_usetype";
	public static final String SD_USETYPE= "Sd_usetype";
	public static final String DT_CHG_BILL= "Dt_chg_bill";
	public static final String NUMBER= "Number";
	public static final String DEP_NAME= "Dep_name";
	public static final String BED_NAME= "Bed_name";
	public static final String ROOM= "Room";
	public static final String USETYPE_NAME= "Usetype_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entbed() {
		return ((String) getAttrVal("Id_entbed"));
	}	
	public void setId_entbed(String Id_entbed) {
		setAttrVal("Id_entbed", Id_entbed);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_dep_wrd() {
		return ((String) getAttrVal("Id_dep_wrd"));
	}	
	public void setId_dep_wrd(String Id_dep_wrd) {
		setAttrVal("Id_dep_wrd", Id_dep_wrd);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	public String getId_usetype() {
		return ((String) getAttrVal("Id_usetype"));
	}	
	public void setId_usetype(String Id_usetype) {
		setAttrVal("Id_usetype", Id_usetype);
	}
	public String getSd_usetype() {
		return ((String) getAttrVal("Sd_usetype"));
	}	
	public void setSd_usetype(String Sd_usetype) {
		setAttrVal("Sd_usetype", Sd_usetype);
	}
	public FDateTime getDt_chg_bill() {
		return ((FDateTime) getAttrVal("Dt_chg_bill"));
	}	
	public void setDt_chg_bill(FDateTime Dt_chg_bill) {
		setAttrVal("Dt_chg_bill", Dt_chg_bill);
	}
	public Integer getNumber() {
		return ((Integer) getAttrVal("Number"));
	}	
	public void setNumber(Integer Number) {
		setAttrVal("Number", Number);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}	
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}	
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	public String getUsetype_name() {
		return ((String) getAttrVal("Usetype_name"));
	}	
	public void setUsetype_name(String Usetype_name) {
		setAttrVal("Usetype_name", Usetype_name);
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
		return "Id_entbed";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_bed";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnBedDODesc.class);
	}
	
}