package iih.bd.srv.emsobsindex.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emsobsindex.d.desc.EmsObsIndexDODesc;
import java.math.BigDecimal;

/**
 * 医疗单观测指标定义 DO数据 
 * 
 */
public class EmsObsIndexDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVOFDYNVITM= "Id_srvofdynvitm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVOF= "Id_srvof";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvofdynvitm() {
		return ((String) getAttrVal("Id_srvofdynvitm"));
	}	
	public void setId_srvofdynvitm(String Id_srvofdynvitm) {
		setAttrVal("Id_srvofdynvitm", Id_srvofdynvitm);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
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
		return "Id_srvofdynvitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvof_viewitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsObsIndexDODesc.class);
	}
	
}