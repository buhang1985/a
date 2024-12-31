package iih.ci.rcm.reportcarddocfs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.reportcarddocfs.d.desc.ReportCardDocFsDoDesc;
import java.math.BigDecimal;

/**
 * 报卡文书流DO DO数据 
 * 
 */
public class ReportCardDocFsDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RCM_RD_FS= "Id_rcm_rd_fs";
	public static final String ID_CI_RCM_RD= "Id_ci_rcm_rd";
	public static final String FS= "Fs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rcm_rd_fs() {
		return ((String) getAttrVal("Id_rcm_rd_fs"));
	}	
	public void setId_rcm_rd_fs(String Id_rcm_rd_fs) {
		setAttrVal("Id_rcm_rd_fs", Id_rcm_rd_fs);
	}
	public String getId_ci_rcm_rd() {
		return ((String) getAttrVal("Id_ci_rcm_rd"));
	}	
	public void setId_ci_rcm_rd(String Id_ci_rcm_rd) {
		setAttrVal("Id_ci_rcm_rd", Id_ci_rcm_rd);
	}
	public byte[] getFs() {
		return ((byte[]) getAttrVal("Fs"));
	}	
	public void setFs(byte[] Fs) {
		setAttrVal("Fs", Fs);
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
		return "Id_rcm_rd_fs";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_rd_fs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReportCardDocFsDoDesc.class);
	}
	
}