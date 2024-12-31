package iih.pe.pqn.pesrvrecmcond.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pesrvrecmcond.d.desc.PeSrvRecmCondDODesc;
import java.math.BigDecimal;

/**
 * 体检项目推荐条件定义 DO数据 
 * 
 */
public class PeSrvRecmCondDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVRECMCOND= "Id_pesrvrecmcond";
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_INCLUDE= "Fg_include";
	public static final String CODE_QAKEY= "Code_qakey";
	public static final String NAME_QAKEY= "Name_qakey";
	public static final String CODE_SRVITM= "Code_srvitm";
	public static final String NAME_SRVITM= "Name_srvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvrecmcond() {
		return ((String) getAttrVal("Id_pesrvrecmcond"));
	}	
	public void setId_pesrvrecmcond(String Id_pesrvrecmcond) {
		setAttrVal("Id_pesrvrecmcond", Id_pesrvrecmcond);
	}
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
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
	public FBoolean getFg_include() {
		return ((FBoolean) getAttrVal("Fg_include"));
	}	
	public void setFg_include(FBoolean Fg_include) {
		setAttrVal("Fg_include", Fg_include);
	}
	public String getCode_qakey() {
		return ((String) getAttrVal("Code_qakey"));
	}	
	public void setCode_qakey(String Code_qakey) {
		setAttrVal("Code_qakey", Code_qakey);
	}
	public String getName_qakey() {
		return ((String) getAttrVal("Name_qakey"));
	}	
	public void setName_qakey(String Name_qakey) {
		setAttrVal("Name_qakey", Name_qakey);
	}
	public String getCode_srvitm() {
		return ((String) getAttrVal("Code_srvitm"));
	}	
	public void setCode_srvitm(String Code_srvitm) {
		setAttrVal("Code_srvitm", Code_srvitm);
	}
	public String getName_srvitm() {
		return ((String) getAttrVal("Name_srvitm"));
	}	
	public void setName_srvitm(String Name_srvitm) {
		setAttrVal("Name_srvitm", Name_srvitm);
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
		return "Id_pesrvrecmcond";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pesrvrecmcond";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvRecmCondDODesc.class);
	}
	
}