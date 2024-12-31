package iih.ci.mr.nu.bgm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.bgm.d.desc.BgmRecDODesc;
import java.math.BigDecimal;

/**
 * 血糖监测记录表 DO数据 
 * 
 */
public class BgmRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_PATINFO= "Id_patinfo";
	public static final String NUM_CHECK= "Num_check";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String ID_TP_CHECK= "Id_tp_check";
	public static final String SD_TP_CHECK= "Sd_tp_check";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String NAME_TPCHK= "Name_tpchk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
	}
	public String getId_patinfo() {
		return ((String) getAttrVal("Id_patinfo"));
	}	
	public void setId_patinfo(String Id_patinfo) {
		setAttrVal("Id_patinfo", Id_patinfo);
	}
	public FDouble getNum_check() {
		return ((FDouble) getAttrVal("Num_check"));
	}	
	public void setNum_check(FDouble Num_check) {
		setAttrVal("Num_check", Num_check);
	}
	public String getId_signature() {
		return ((String) getAttrVal("Id_signature"));
	}	
	public void setId_signature(String Id_signature) {
		setAttrVal("Id_signature", Id_signature);
	}
	public String getId_tp_check() {
		return ((String) getAttrVal("Id_tp_check"));
	}	
	public void setId_tp_check(String Id_tp_check) {
		setAttrVal("Id_tp_check", Id_tp_check);
	}
	public String getSd_tp_check() {
		return ((String) getAttrVal("Sd_tp_check"));
	}	
	public void setSd_tp_check(String Sd_tp_check) {
		setAttrVal("Sd_tp_check", Sd_tp_check);
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
	public String getName_signature() {
		return ((String) getAttrVal("Name_signature"));
	}	
	public void setName_signature(String Name_signature) {
		setAttrVal("Name_signature", Name_signature);
	}
	public String getName_tpchk() {
		return ((String) getAttrVal("Name_tpchk"));
	}	
	public void setName_tpchk(String Name_tpchk) {
		setAttrVal("Name_tpchk", Name_tpchk);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_BGM_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BgmRecDODesc.class);
	}
	
}