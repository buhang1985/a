package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mkrms.d.desc.MkrMsMrtplDODesc;
import java.math.BigDecimal;

/**
 * 组套与医疗记录模板关系 DO数据 
 * 
 */
public class MkrMsMrtplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MSMRTPL= "Id_msmrtpl";
	public static final String ID_MS= "Id_ms";
	public static final String ID_MRTPL= "Id_mrtpl";
	public static final String OWTP_NAME= "Owtp_name";
	public static final String OWN_NAME= "Own_name";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String MRTPL_NAME= "Mrtpl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_msmrtpl() {
		return ((String) getAttrVal("Id_msmrtpl"));
	}	
	public void setId_msmrtpl(String Id_msmrtpl) {
		setAttrVal("Id_msmrtpl", Id_msmrtpl);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
	}
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
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
	public String getMrtpl_name() {
		return ((String) getAttrVal("Mrtpl_name"));
	}	
	public void setMrtpl_name(String Mrtpl_name) {
		setAttrVal("Mrtpl_name", Mrtpl_name);
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
		return "Id_msmrtpl";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MS_MRTPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMsMrtplDODesc.class);
	}
	
}