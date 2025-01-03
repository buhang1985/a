package iih.sc.scbd.bdsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.bdsrv.d.desc.Sc_BdsrvDODesc;
import java.math.BigDecimal;

/**
 * 排班计划_医疗服务 DO数据 
 * 
 */
public class Sc_BdsrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCBDSRV= "Id_scbdsrv";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SCCA= "Id_scca";
	public static final String SRVSLOT= "Srvslot";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PRI= "Pri";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_SCCA= "Code_scca";
	public static final String NAME_SCCA= "Name_scca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scbdsrv() {
		return ((String) getAttrVal("Id_scbdsrv"));
	}	
	public void setId_scbdsrv(String Id_scbdsrv) {
		setAttrVal("Id_scbdsrv", Id_scbdsrv);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}	
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
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
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
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
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
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
		return "Id_scbdsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_bd_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(Sc_BdsrvDODesc.class);
	}
	
}