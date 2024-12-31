package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatCbhindDODesc;
import java.math.BigDecimal;

/**
 * 生育史指标 DO数据 
 * 
 */
public class PiPatCbhindDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATCBHIND= "Id_patcbhind";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String SD_CBHIND= "Sd_cbhind";
	public static final String ID_CBHIND= "Id_cbhind";
	public static final String VAL= "Val";
	public static final String UNITS= "Units";
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patcbhind() {
		return ((String) getAttrVal("Id_patcbhind"));
	}	
	public void setId_patcbhind(String Id_patcbhind) {
		setAttrVal("Id_patcbhind", Id_patcbhind);
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
	public String getSd_cbhind() {
		return ((String) getAttrVal("Sd_cbhind"));
	}	
	public void setSd_cbhind(String Sd_cbhind) {
		setAttrVal("Sd_cbhind", Sd_cbhind);
	}
	public String getId_cbhind() {
		return ((String) getAttrVal("Id_cbhind"));
	}	
	public void setId_cbhind(String Id_cbhind) {
		setAttrVal("Id_cbhind", Id_cbhind);
	}
	public Integer getVal() {
		return ((Integer) getAttrVal("Val"));
	}	
	public void setVal(Integer Val) {
		setAttrVal("Val", Val);
	}
	public String getUnits() {
		return ((String) getAttrVal("Units"));
	}	
	public void setUnits(String Units) {
		setAttrVal("Units", Units);
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
		return "Id_patcbhind";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_CBHIND";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatCbhindDODesc.class);
	}
	
}