package iih.bd.fc.orpltpmtpara.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orpltpmtpara.d.desc.OrpltpmtParaDODesc;
import java.math.BigDecimal;

/**
 * 医嘱执行闭环类型匹配参数 DO数据 
 * 
 */
public class OrpltpmtParaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPLTPMT_PARA= "Id_orpltpmt_para";
	public static final String ID_ORPLTP= "Id_orpltp";
	public static final String ID_ENTPS= "Id_entps";
	public static final String SD_ENTPS= "Sd_entps";
	public static final String ID_SRVTPS= "Id_srvtps";
	public static final String SD_SRVTPS= "Sd_srvtps";
	public static final String ID_SRVS= "Id_srvs";
	public static final String ID_ROUTES= "Id_routes";
	public static final String EU_SKINTEST= "Eu_skintest";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORPLTP_DES= "Orpltp_des";
	public static final String CODE_ORPLTP= "Code_orpltp";
	public static final String NAME_ORPLTP= "Name_orpltp";
	public static final String NAME_ENTP= "Name_entp";
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_ROUTE= "Code_route";
	public static final String NAME_ROUTE= "Name_route";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orpltpmt_para() {
		return ((String) getAttrVal("Id_orpltpmt_para"));
	}	
	public void setId_orpltpmt_para(String Id_orpltpmt_para) {
		setAttrVal("Id_orpltpmt_para", Id_orpltpmt_para);
	}
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	public String getId_entps() {
		return ((String) getAttrVal("Id_entps"));
	}	
	public void setId_entps(String Id_entps) {
		setAttrVal("Id_entps", Id_entps);
	}
	public String getSd_entps() {
		return ((String) getAttrVal("Sd_entps"));
	}	
	public void setSd_entps(String Sd_entps) {
		setAttrVal("Sd_entps", Sd_entps);
	}
	public String getId_srvtps() {
		return ((String) getAttrVal("Id_srvtps"));
	}	
	public void setId_srvtps(String Id_srvtps) {
		setAttrVal("Id_srvtps", Id_srvtps);
	}
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}	
	public void setSd_srvtps(String Sd_srvtps) {
		setAttrVal("Sd_srvtps", Sd_srvtps);
	}
	public String getId_srvs() {
		return ((String) getAttrVal("Id_srvs"));
	}	
	public void setId_srvs(String Id_srvs) {
		setAttrVal("Id_srvs", Id_srvs);
	}
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}	
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	public Integer getEu_skintest() {
		return ((Integer) getAttrVal("Eu_skintest"));
	}	
	public void setEu_skintest(Integer Eu_skintest) {
		setAttrVal("Eu_skintest", Eu_skintest);
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
	public String getOrpltp_des() {
		return ((String) getAttrVal("Orpltp_des"));
	}	
	public void setOrpltp_des(String Orpltp_des) {
		setAttrVal("Orpltp_des", Orpltp_des);
	}
	public String getCode_orpltp() {
		return ((String) getAttrVal("Code_orpltp"));
	}	
	public void setCode_orpltp(String Code_orpltp) {
		setAttrVal("Code_orpltp", Code_orpltp);
	}
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}	
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
	}
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}	
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
		return "Id_orpltpmt_para";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_ORPLTPMT_PARA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrpltpmtParaDODesc.class);
	}
	
}