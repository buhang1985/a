package iih.nm.nbd.nbdntpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nbd.nbdntpl.d.desc.NbdNtplDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_指标模板 DO数据 
 * 
 */
public class NbdNtplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NBD_NTPL= "Id_nbd_ntpl";
	public static final String ID_NBD_KPI= "Id_nbd_kpi";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String CONTENT= "Content";
	public static final String ID_NBD_NTPLTP= "Id_nbd_ntpltp";
	public static final String SD_NBD_NTPLTP= "Sd_nbd_ntpltp";
	public static final String ID_OWNTP= "Id_owntp";
	public static final String SD_OWNTP= "Sd_owntp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String FG_DEFAULT= "Fg_default";
	public static final String VERSION= "Version";
	public static final String ID_CRT_PSN= "Id_crt_psn";
	public static final String DT_CRT= "Dt_crt";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NBD_KPI= "Name_nbd_kpi";
	public static final String NAME_NBD_NTPLTP= "Name_nbd_ntpltp";
	public static final String NAME_OWNTP= "Name_owntp";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_STATUS= "Name_status";
	public static final String NAME_CTR_PSN= "Name_ctr_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nbd_ntpl() {
		return ((String) getAttrVal("Id_nbd_ntpl"));
	}	
	public void setId_nbd_ntpl(String Id_nbd_ntpl) {
		setAttrVal("Id_nbd_ntpl", Id_nbd_ntpl);
	}
	public String getId_nbd_kpi() {
		return ((String) getAttrVal("Id_nbd_kpi"));
	}	
	public void setId_nbd_kpi(String Id_nbd_kpi) {
		setAttrVal("Id_nbd_kpi", Id_nbd_kpi);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	public String getId_nbd_ntpltp() {
		return ((String) getAttrVal("Id_nbd_ntpltp"));
	}	
	public void setId_nbd_ntpltp(String Id_nbd_ntpltp) {
		setAttrVal("Id_nbd_ntpltp", Id_nbd_ntpltp);
	}
	public String getSd_nbd_ntpltp() {
		return ((String) getAttrVal("Sd_nbd_ntpltp"));
	}	
	public void setSd_nbd_ntpltp(String Sd_nbd_ntpltp) {
		setAttrVal("Sd_nbd_ntpltp", Sd_nbd_ntpltp);
	}
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public FBoolean getFg_default() {
		return ((FBoolean) getAttrVal("Fg_default"));
	}	
	public void setFg_default(FBoolean Fg_default) {
		setAttrVal("Fg_default", Fg_default);
	}
	public String getVersion() {
		return ((String) getAttrVal("Version"));
	}	
	public void setVersion(String Version) {
		setAttrVal("Version", Version);
	}
	public String getId_crt_psn() {
		return ((String) getAttrVal("Id_crt_psn"));
	}	
	public void setId_crt_psn(String Id_crt_psn) {
		setAttrVal("Id_crt_psn", Id_crt_psn);
	}
	public FDateTime getDt_crt() {
		return ((FDateTime) getAttrVal("Dt_crt"));
	}	
	public void setDt_crt(FDateTime Dt_crt) {
		setAttrVal("Dt_crt", Dt_crt);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_nbd_kpi() {
		return ((String) getAttrVal("Name_nbd_kpi"));
	}	
	public void setName_nbd_kpi(String Name_nbd_kpi) {
		setAttrVal("Name_nbd_kpi", Name_nbd_kpi);
	}
	public String getName_nbd_ntpltp() {
		return ((String) getAttrVal("Name_nbd_ntpltp"));
	}	
	public void setName_nbd_ntpltp(String Name_nbd_ntpltp) {
		setAttrVal("Name_nbd_ntpltp", Name_nbd_ntpltp);
	}
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	public String getName_ctr_psn() {
		return ((String) getAttrVal("Name_ctr_psn"));
	}	
	public void setName_ctr_psn(String Name_ctr_psn) {
		setAttrVal("Name_ctr_psn", Name_ctr_psn);
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
		return "Id_nbd_ntpl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NBD_NTPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NbdNtplDODesc.class);
	}
	
}