package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.RegularOrRelSrvDODesc;
import java.math.BigDecimal;

/**
 * 常规医嘱关联服务 DO数据 
 * 
 */
public class RegularOrRelSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REGULARORREL= "Id_regularorrel";
	public static final String ID_REGULARORCA= "Id_regularorca";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String NOTE= "Note";
	public static final String FG_SET= "Fg_set";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_CA= "Code_ca";
	public static final String NAME_CA= "Name_ca";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRVTPL= "Name_srvtpl";
	public static final String CODE_SRVTPL= "Code_srvtpl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_regularorrel() {
		return ((String) getAttrVal("Id_regularorrel"));
	}	
	public void setId_regularorrel(String Id_regularorrel) {
		setAttrVal("Id_regularorrel", Id_regularorrel);
	}
	public String getId_regularorca() {
		return ((String) getAttrVal("Id_regularorca"));
	}	
	public void setId_regularorca(String Id_regularorca) {
		setAttrVal("Id_regularorca", Id_regularorca);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
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
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srvtpl() {
		return ((String) getAttrVal("Name_srvtpl"));
	}	
	public void setName_srvtpl(String Name_srvtpl) {
		setAttrVal("Name_srvtpl", Name_srvtpl);
	}
	public String getCode_srvtpl() {
		return ((String) getAttrVal("Code_srvtpl"));
	}	
	public void setCode_srvtpl(String Code_srvtpl) {
		setAttrVal("Code_srvtpl", Code_srvtpl);
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
		return "Id_regularorrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_regularor_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RegularOrRelSrvDODesc.class);
	}
	
}