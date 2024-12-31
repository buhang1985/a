package iih.bd.srv.srvselfcaitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvselfcaitm.d.desc.SrvSelfCaItmRelDODesc;
import java.math.BigDecimal;

/**
 * 服务自定义分类项目关系 DO数据 
 * 
 */
public class SrvSelfCaItmRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVCACTMITMREL= "Id_srvcactmitmrel";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRVCACTMITM= "Id_srvcactmitm";
	public static final String EU_SRVCATP= "Eu_srvcatp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String SRVNAME= "Srvname";
	public static final String SRVCA_NAME= "Srvca_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvcactmitmrel() {
		return ((String) getAttrVal("Id_srvcactmitmrel"));
	}	
	public void setId_srvcactmitmrel(String Id_srvcactmitmrel) {
		setAttrVal("Id_srvcactmitmrel", Id_srvcactmitmrel);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_srvcactmitm() {
		return ((String) getAttrVal("Id_srvcactmitm"));
	}	
	public void setId_srvcactmitm(String Id_srvcactmitm) {
		setAttrVal("Id_srvcactmitm", Id_srvcactmitm);
	}
	public String getEu_srvcatp() {
		return ((String) getAttrVal("Eu_srvcatp"));
	}	
	public void setEu_srvcatp(String Eu_srvcatp) {
		setAttrVal("Eu_srvcatp", Eu_srvcatp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
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
		return "Id_srvcactmitmrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srvca_ctm_itm_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvSelfCaItmRelDODesc.class);
	}
	
}