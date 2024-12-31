package iih.hp.cp.inf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.inf.d.desc.HpCpInterfaceDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划接口定义表 DO数据 
 * 
 */
public class HpCpInterfaceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_IF= "Id_if";
	public static final String ID_IFTP= "Id_iftp";
	public static final String SD_IFTP= "Sd_iftp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String IF_CONTENT= "If_content";
	public static final String SYSID= "Sysid";
	public static final String FG_MULTI= "Fg_multi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_if() {
		return ((String) getAttrVal("Id_if"));
	}	
	public void setId_if(String Id_if) {
		setAttrVal("Id_if", Id_if);
	}
	public String getId_iftp() {
		return ((String) getAttrVal("Id_iftp"));
	}	
	public void setId_iftp(String Id_iftp) {
		setAttrVal("Id_iftp", Id_iftp);
	}
	public String getSd_iftp() {
		return ((String) getAttrVal("Sd_iftp"));
	}	
	public void setSd_iftp(String Sd_iftp) {
		setAttrVal("Sd_iftp", Sd_iftp);
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
	public String getIf_content() {
		return ((String) getAttrVal("If_content"));
	}	
	public void setIf_content(String If_content) {
		setAttrVal("If_content", If_content);
	}
	public String getSysid() {
		return ((String) getAttrVal("Sysid"));
	}	
	public void setSysid(String Sysid) {
		setAttrVal("Sysid", Sysid);
	}
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}	
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
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
		return "Id_if";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_IF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpInterfaceDODesc.class);
	}
	
}