package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatVsDODesc;
import java.math.BigDecimal;

/**
 * 患者关键生命体征 DO数据 
 * 
 */
public class PiPatVsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATVS= "Id_patvs";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String VAL_VS= "Val_vs";
	public static final String U_VS= "U_vs";
	public static final String DT_VS= "Dt_vs";
	public static final String SD_YMD_VS= "Sd_ymd_vs";
	public static final String ID_YMD_VS= "Id_ymd_vs";
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patvs() {
		return ((String) getAttrVal("Id_patvs"));
	}	
	public void setId_patvs(String Id_patvs) {
		setAttrVal("Id_patvs", Id_patvs);
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
	public FDouble getVal_vs() {
		return ((FDouble) getAttrVal("Val_vs"));
	}	
	public void setVal_vs(FDouble Val_vs) {
		setAttrVal("Val_vs", Val_vs);
	}
	public String getU_vs() {
		return ((String) getAttrVal("U_vs"));
	}	
	public void setU_vs(String U_vs) {
		setAttrVal("U_vs", U_vs);
	}
	public FDateTime getDt_vs() {
		return ((FDateTime) getAttrVal("Dt_vs"));
	}	
	public void setDt_vs(FDateTime Dt_vs) {
		setAttrVal("Dt_vs", Dt_vs);
	}
	public String getSd_ymd_vs() {
		return ((String) getAttrVal("Sd_ymd_vs"));
	}	
	public void setSd_ymd_vs(String Sd_ymd_vs) {
		setAttrVal("Sd_ymd_vs", Sd_ymd_vs);
	}
	public Integer getId_ymd_vs() {
		return ((Integer) getAttrVal("Id_ymd_vs"));
	}	
	public void setId_ymd_vs(Integer Id_ymd_vs) {
		setAttrVal("Id_ymd_vs", Id_ymd_vs);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Id_patvs";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_VS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatVsDODesc.class);
	}
	
}