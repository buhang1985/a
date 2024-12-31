package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mkrms.d.desc.MkrMsOrtplDesc;
import java.math.BigDecimal;

/**
 * 组套与医嘱模板关系 DO数据 
 * 
 */
public class MkrMsOrtpl extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MSORTPL= "Id_msortpl";
	public static final String ID_MS= "Id_ms";
	public static final String ID_SRVORTPL= "Id_srvortpl";
	public static final String OWTP_NAME= "Owtp_name";
	public static final String OWN_NAME= "Own_name";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ORTPL_NAME= "Ortpl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_msortpl() {
		return ((String) getAttrVal("Id_msortpl"));
	}	
	public void setId_msortpl(String Id_msortpl) {
		setAttrVal("Id_msortpl", Id_msortpl);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
	}
	public String getId_srvortpl() {
		return ((String) getAttrVal("Id_srvortpl"));
	}	
	public void setId_srvortpl(String Id_srvortpl) {
		setAttrVal("Id_srvortpl", Id_srvortpl);
	}
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	public String getOwn_name() {
		return ((String) getAttrVal("Own_name"));
	}	
	public void setOwn_name(String Own_name) {
		setAttrVal("Own_name", Own_name);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getOrtpl_name() {
		return ((String) getAttrVal("Ortpl_name"));
	}	
	public void setOrtpl_name(String Ortpl_name) {
		setAttrVal("Ortpl_name", Ortpl_name);
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
		return "Id_msortpl";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MS_ORTPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMsOrtplDesc.class);
	}
	
}