package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatLabDODesc;
import java.math.BigDecimal;

/**
 * 患者关键检验指标 DO数据 
 * 
 */
public class PiPatLabDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATLAB= "Id_patlab";
	public static final String ID_PAT= "Id_pat";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String VAL_LAB= "Val_lab";
	public static final String U_LAB= "U_lab";
	public static final String DT_LAB= "Dt_lab";
	public static final String SD_YMD_LAB= "Sd_ymd_lab";
	public static final String ID_YMD_LAB= "Id_ymd_lab";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patlab() {
		return ((String) getAttrVal("Id_patlab"));
	}	
	public void setId_patlab(String Id_patlab) {
		setAttrVal("Id_patlab", Id_patlab);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	public FDouble getVal_lab() {
		return ((FDouble) getAttrVal("Val_lab"));
	}	
	public void setVal_lab(FDouble Val_lab) {
		setAttrVal("Val_lab", Val_lab);
	}
	public String getU_lab() {
		return ((String) getAttrVal("U_lab"));
	}	
	public void setU_lab(String U_lab) {
		setAttrVal("U_lab", U_lab);
	}
	public FDateTime getDt_lab() {
		return ((FDateTime) getAttrVal("Dt_lab"));
	}	
	public void setDt_lab(FDateTime Dt_lab) {
		setAttrVal("Dt_lab", Dt_lab);
	}
	public String getSd_ymd_lab() {
		return ((String) getAttrVal("Sd_ymd_lab"));
	}	
	public void setSd_ymd_lab(String Sd_ymd_lab) {
		setAttrVal("Sd_ymd_lab", Sd_ymd_lab);
	}
	public Integer getId_ymd_lab() {
		return ((Integer) getAttrVal("Id_ymd_lab"));
	}	
	public void setId_ymd_lab(Integer Id_ymd_lab) {
		setAttrVal("Id_ymd_lab", Id_ymd_lab);
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
		return "Id_patlab";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_LAB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatLabDODesc.class);
	}
	
}