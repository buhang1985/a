package iih.bd.pp.bdpriadm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdpriadm.d.desc.BDPriAdmDODesc;
import java.math.BigDecimal;

/**
 * 入院登记收费项目配置表 DO数据 
 * 
 */
public class BDPriAdmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRIADM= "Id_priadm";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OWTP= "Id_owtp";
	public static final String SD_OWTP= "Sd_owtp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_SRV= "Id_srv";
	public static final String QUAN= "Quan";
	public static final String FG_PAY_FIRSTADM= "Fg_pay_firstadm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OWTP= "Name_owtp";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String FG_MM= "Fg_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_priadm() {
		return ((String) getAttrVal("Id_priadm"));
	}	
	public void setId_priadm(String Id_priadm) {
		setAttrVal("Id_priadm", Id_priadm);
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
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}	
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	public FBoolean getFg_pay_firstadm() {
		return ((FBoolean) getAttrVal("Fg_pay_firstadm"));
	}	
	public void setFg_pay_firstadm(FBoolean Fg_pay_firstadm) {
		setAttrVal("Fg_pay_firstadm", Fg_pay_firstadm);
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
	public String getName_owtp() {
		return ((String) getAttrVal("Name_owtp"));
	}	
	public void setName_owtp(String Name_owtp) {
		setAttrVal("Name_owtp", Name_owtp);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
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
		return "Id_priadm";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_PRI_ADM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BDPriAdmDODesc.class);
	}
	
}