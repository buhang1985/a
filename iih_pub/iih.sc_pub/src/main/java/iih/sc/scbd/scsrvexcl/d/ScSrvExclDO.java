package iih.sc.scbd.scsrvexcl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scsrvexcl.d.desc.ScSrvExclDODesc;
import java.math.BigDecimal;

/**
 * 服务互斥DO DO数据 
 * 
 */
public class ScSrvExclDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCSRVEXCL= "Id_scsrvexcl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_SCSRV_A= "Id_scsrv_a";
	public static final String ID_SCSRV_B= "Id_scsrv_b";
	public static final String PERIOD= "Period";
	public static final String ID_MEASDOC_PERIOD= "Id_measdoc_period";
	public static final String NOTE= "Note";
	public static final String TIMES= "Times";
	public static final String FG_DIRECT= "Fg_direct";
	public static final String SD_SCSRVEXCLTP= "Sd_scsrvexcltp";
	public static final String ID_SCSRVEXCLTP= "Id_scsrvexcltp";
	public static final String FG_HP= "Fg_hp";
	public static final String ID_SCCA_A= "Id_scca_a";
	public static final String ID_SCCA_B= "Id_scca_b";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_SRV= "Id_srv";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NAME_SCSRV_A= "Name_scsrv_a";
	public static final String CODE_SCSRV_A= "Code_scsrv_a";
	public static final String NAME_SCSRV_B= "Name_scsrv_b";
	public static final String CODE_SCSRV_B= "Code_scsrv_b";
	public static final String NAME_MEASDOC= "Name_measdoc";
	public static final String CODE_MEASDOC= "Code_measdoc";
	public static final String CODE_SCSRVEXCLTP= "Code_scsrvexcltp";
	public static final String NAME_SCSRVEXCLTP= "Name_scsrvexcltp";
	public static final String NAME_SCCA_A= "Name_scca_a";
	public static final String NAME_SCCA_B= "Name_scca_b";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scsrvexcl() {
		return ((String) getAttrVal("Id_scsrvexcl"));
	}	
	public void setId_scsrvexcl(String Id_scsrvexcl) {
		setAttrVal("Id_scsrvexcl", Id_scsrvexcl);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_scsrv_a() {
		return ((String) getAttrVal("Id_scsrv_a"));
	}	
	public void setId_scsrv_a(String Id_scsrv_a) {
		setAttrVal("Id_scsrv_a", Id_scsrv_a);
	}
	public String getId_scsrv_b() {
		return ((String) getAttrVal("Id_scsrv_b"));
	}	
	public void setId_scsrv_b(String Id_scsrv_b) {
		setAttrVal("Id_scsrv_b", Id_scsrv_b);
	}
	public Integer getPeriod() {
		return ((Integer) getAttrVal("Period"));
	}	
	public void setPeriod(Integer Period) {
		setAttrVal("Period", Period);
	}
	public String getId_measdoc_period() {
		return ((String) getAttrVal("Id_measdoc_period"));
	}	
	public void setId_measdoc_period(String Id_measdoc_period) {
		setAttrVal("Id_measdoc_period", Id_measdoc_period);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}	
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	public FBoolean getFg_direct() {
		return ((FBoolean) getAttrVal("Fg_direct"));
	}	
	public void setFg_direct(FBoolean Fg_direct) {
		setAttrVal("Fg_direct", Fg_direct);
	}
	public String getSd_scsrvexcltp() {
		return ((String) getAttrVal("Sd_scsrvexcltp"));
	}	
	public void setSd_scsrvexcltp(String Sd_scsrvexcltp) {
		setAttrVal("Sd_scsrvexcltp", Sd_scsrvexcltp);
	}
	public String getId_scsrvexcltp() {
		return ((String) getAttrVal("Id_scsrvexcltp"));
	}	
	public void setId_scsrvexcltp(String Id_scsrvexcltp) {
		setAttrVal("Id_scsrvexcltp", Id_scsrvexcltp);
	}
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}	
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	public String getId_scca_a() {
		return ((String) getAttrVal("Id_scca_a"));
	}	
	public void setId_scca_a(String Id_scca_a) {
		setAttrVal("Id_scca_a", Id_scca_a);
	}
	public String getId_scca_b() {
		return ((String) getAttrVal("Id_scca_b"));
	}	
	public void setId_scca_b(String Id_scca_b) {
		setAttrVal("Id_scca_b", Id_scca_b);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getName_scsrv_a() {
		return ((String) getAttrVal("Name_scsrv_a"));
	}	
	public void setName_scsrv_a(String Name_scsrv_a) {
		setAttrVal("Name_scsrv_a", Name_scsrv_a);
	}
	public String getCode_scsrv_a() {
		return ((String) getAttrVal("Code_scsrv_a"));
	}	
	public void setCode_scsrv_a(String Code_scsrv_a) {
		setAttrVal("Code_scsrv_a", Code_scsrv_a);
	}
	public String getName_scsrv_b() {
		return ((String) getAttrVal("Name_scsrv_b"));
	}	
	public void setName_scsrv_b(String Name_scsrv_b) {
		setAttrVal("Name_scsrv_b", Name_scsrv_b);
	}
	public String getCode_scsrv_b() {
		return ((String) getAttrVal("Code_scsrv_b"));
	}	
	public void setCode_scsrv_b(String Code_scsrv_b) {
		setAttrVal("Code_scsrv_b", Code_scsrv_b);
	}
	public String getName_measdoc() {
		return ((String) getAttrVal("Name_measdoc"));
	}	
	public void setName_measdoc(String Name_measdoc) {
		setAttrVal("Name_measdoc", Name_measdoc);
	}
	public String getCode_measdoc() {
		return ((String) getAttrVal("Code_measdoc"));
	}	
	public void setCode_measdoc(String Code_measdoc) {
		setAttrVal("Code_measdoc", Code_measdoc);
	}
	public String getCode_scsrvexcltp() {
		return ((String) getAttrVal("Code_scsrvexcltp"));
	}	
	public void setCode_scsrvexcltp(String Code_scsrvexcltp) {
		setAttrVal("Code_scsrvexcltp", Code_scsrvexcltp);
	}
	public String getName_scsrvexcltp() {
		return ((String) getAttrVal("Name_scsrvexcltp"));
	}	
	public void setName_scsrvexcltp(String Name_scsrvexcltp) {
		setAttrVal("Name_scsrvexcltp", Name_scsrvexcltp);
	}
	public String getName_scca_a() {
		return ((String) getAttrVal("Name_scca_a"));
	}	
	public void setName_scca_a(String Name_scca_a) {
		setAttrVal("Name_scca_a", Name_scca_a);
	}
	public String getName_scca_b() {
		return ((String) getAttrVal("Name_scca_b"));
	}	
	public void setName_scca_b(String Name_scca_b) {
		setAttrVal("Name_scca_b", Name_scca_b);
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
		return "Id_scsrvexcl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_srv_excl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSrvExclDODesc.class);
	}
	
}