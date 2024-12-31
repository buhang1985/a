package iih.sc.apt.aptip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.aptip.d.desc.AptIpMatchDODesc;
import java.math.BigDecimal;

/**
 * 住院预约匹配 DO数据 
 * 
 */
public class AptIpMatchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTIPMATCH= "Id_aptipmatch";
	public static final String CODE_SESSION= "Code_session";
	public static final String ID_SCAPTIP= "Id_scaptip";
	public static final String ID_BED= "Id_bed";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptipmatch() {
		return ((String) getAttrVal("Id_aptipmatch"));
	}	
	public void setId_aptipmatch(String Id_aptipmatch) {
		setAttrVal("Id_aptipmatch", Id_aptipmatch);
	}
	public String getCode_session() {
		return ((String) getAttrVal("Code_session"));
	}	
	public void setCode_session(String Code_session) {
		setAttrVal("Code_session", Code_session);
	}
	public String getId_scaptip() {
		return ((String) getAttrVal("Id_scaptip"));
	}	
	public void setId_scaptip(String Id_scaptip) {
		setAttrVal("Id_scaptip", Id_scaptip);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
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
		return "Id_aptipmatch";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_ip_match";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptIpMatchDODesc.class);
	}
	
}