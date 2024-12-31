package iih.bd.pp.prisrvsetmu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.prisrvsetmu.d.desc.PriSrvSetMuDODesc;
import java.math.BigDecimal;

/**
 * 服务套数量加收 DO数据 
 * 
 */
public class PriSrvSetMuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRISRVSETMU= "Id_prisrvsetmu";
	public static final String ID_SRVSET= "Id_srvset";
	public static final String SORTNO= "Sortno";
	public static final String QUAN_MIN= "Quan_min";
	public static final String QUAN_MAX= "Quan_max";
	public static final String ID_SRVADD= "Id_srvadd";
	public static final String PRICE= "Price";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prisrvsetmu() {
		return ((String) getAttrVal("Id_prisrvsetmu"));
	}	
	public void setId_prisrvsetmu(String Id_prisrvsetmu) {
		setAttrVal("Id_prisrvsetmu", Id_prisrvsetmu);
	}
	public String getId_srvset() {
		return ((String) getAttrVal("Id_srvset"));
	}	
	public void setId_srvset(String Id_srvset) {
		setAttrVal("Id_srvset", Id_srvset);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDouble getQuan_min() {
		return ((FDouble) getAttrVal("Quan_min"));
	}	
	public void setQuan_min(FDouble Quan_min) {
		setAttrVal("Quan_min", Quan_min);
	}
	public FDouble getQuan_max() {
		return ((FDouble) getAttrVal("Quan_max"));
	}	
	public void setQuan_max(FDouble Quan_max) {
		setAttrVal("Quan_max", Quan_max);
	}
	public String getId_srvadd() {
		return ((String) getAttrVal("Id_srvadd"));
	}	
	public void setId_srvadd(String Id_srvadd) {
		setAttrVal("Id_srvadd", Id_srvadd);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
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
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_prisrvsetmu";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_srv_setmu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriSrvSetMuDODesc.class);
	}
	
}