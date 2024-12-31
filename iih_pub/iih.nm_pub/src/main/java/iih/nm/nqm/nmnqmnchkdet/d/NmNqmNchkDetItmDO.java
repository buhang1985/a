package iih.nm.nqm.nmnqmnchkdet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmnchkdet.d.desc.NmNqmNchkDetItmDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_夜查房检查病区_督导项 DO数据 
 * 
 */
public class NmNqmNchkDetItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_NCHK_DET_ITM= "Id_nqm_nchk_det_itm";
	public static final String ID_NQM_NCHK_DET= "Id_nqm_nchk_det";
	public static final String ID_NQM_SUPER= "Id_nqm_super";
	public static final String ID_NQM_SUPER_ITM= "Id_nqm_super_itm";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NQM_SUPER_NAME= "Nqm_super_name";
	public static final String NQM_SUPER_ITM_NAME= "Nqm_super_itm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_nchk_det_itm() {
		return ((String) getAttrVal("Id_nqm_nchk_det_itm"));
	}	
	public void setId_nqm_nchk_det_itm(String Id_nqm_nchk_det_itm) {
		setAttrVal("Id_nqm_nchk_det_itm", Id_nqm_nchk_det_itm);
	}
	public String getId_nqm_nchk_det() {
		return ((String) getAttrVal("Id_nqm_nchk_det"));
	}	
	public void setId_nqm_nchk_det(String Id_nqm_nchk_det) {
		setAttrVal("Id_nqm_nchk_det", Id_nqm_nchk_det);
	}
	public String getId_nqm_super() {
		return ((String) getAttrVal("Id_nqm_super"));
	}	
	public void setId_nqm_super(String Id_nqm_super) {
		setAttrVal("Id_nqm_super", Id_nqm_super);
	}
	public String getId_nqm_super_itm() {
		return ((String) getAttrVal("Id_nqm_super_itm"));
	}	
	public void setId_nqm_super_itm(String Id_nqm_super_itm) {
		setAttrVal("Id_nqm_super_itm", Id_nqm_super_itm);
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
	public String getNqm_super_name() {
		return ((String) getAttrVal("Nqm_super_name"));
	}	
	public void setNqm_super_name(String Nqm_super_name) {
		setAttrVal("Nqm_super_name", Nqm_super_name);
	}
	public String getNqm_super_itm_name() {
		return ((String) getAttrVal("Nqm_super_itm_name"));
	}	
	public void setNqm_super_itm_name(String Nqm_super_itm_name) {
		setAttrVal("Nqm_super_itm_name", Nqm_super_itm_name);
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
		return "Id_nqm_nchk_det_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_NCHK_DET_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmNchkDetItmDODesc.class);
	}
	
}