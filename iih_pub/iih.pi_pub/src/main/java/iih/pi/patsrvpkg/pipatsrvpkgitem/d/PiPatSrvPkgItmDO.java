package iih.pi.patsrvpkg.pipatsrvpkgitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc.PiPatSrvPkgItmDODesc;
import java.math.BigDecimal;

/**
 * 患者服务包项目 DO数据 
 * 
 */
public class PiPatSrvPkgItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATSRVPKGITM= "Id_patsrvpkgitm";
	public static final String ID_PATSRVPKG= "Id_patsrvpkg";
	public static final String ID_PATSRVPKGGR= "Id_patsrvpkggr";
	public static final String ID_SRVPKGITM= "Id_srvpkgitm";
	public static final String SORTNO= "Sortno";
	public static final String NAME= "Name";
	public static final String ID_ITMTP= "Id_itmtp";
	public static final String SD_ITMTP= "Sd_itmtp";
	public static final String ID_OPTIONAL= "Id_optional";
	public static final String SD_OPTIONAL= "Sd_optional";
	public static final String ID_COMPTP= "Id_comptp";
	public static final String SD_COMPTP= "Sd_comptp";
	public static final String ID_RELTP= "Id_reltp";
	public static final String SD_RELTP= "Sd_reltp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patsrvpkgitm() {
		return ((String) getAttrVal("Id_patsrvpkgitm"));
	}	
	public void setId_patsrvpkgitm(String Id_patsrvpkgitm) {
		setAttrVal("Id_patsrvpkgitm", Id_patsrvpkgitm);
	}
	public String getId_patsrvpkg() {
		return ((String) getAttrVal("Id_patsrvpkg"));
	}	
	public void setId_patsrvpkg(String Id_patsrvpkg) {
		setAttrVal("Id_patsrvpkg", Id_patsrvpkg);
	}
	public String getId_patsrvpkggr() {
		return ((String) getAttrVal("Id_patsrvpkggr"));
	}	
	public void setId_patsrvpkggr(String Id_patsrvpkggr) {
		setAttrVal("Id_patsrvpkggr", Id_patsrvpkggr);
	}
	public String getId_srvpkgitm() {
		return ((String) getAttrVal("Id_srvpkgitm"));
	}	
	public void setId_srvpkgitm(String Id_srvpkgitm) {
		setAttrVal("Id_srvpkgitm", Id_srvpkgitm);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_itmtp() {
		return ((String) getAttrVal("Id_itmtp"));
	}	
	public void setId_itmtp(String Id_itmtp) {
		setAttrVal("Id_itmtp", Id_itmtp);
	}
	public String getSd_itmtp() {
		return ((String) getAttrVal("Sd_itmtp"));
	}	
	public void setSd_itmtp(String Sd_itmtp) {
		setAttrVal("Sd_itmtp", Sd_itmtp);
	}
	public String getId_optional() {
		return ((String) getAttrVal("Id_optional"));
	}	
	public void setId_optional(String Id_optional) {
		setAttrVal("Id_optional", Id_optional);
	}
	public String getSd_optional() {
		return ((String) getAttrVal("Sd_optional"));
	}	
	public void setSd_optional(String Sd_optional) {
		setAttrVal("Sd_optional", Sd_optional);
	}
	public String getId_comptp() {
		return ((String) getAttrVal("Id_comptp"));
	}	
	public void setId_comptp(String Id_comptp) {
		setAttrVal("Id_comptp", Id_comptp);
	}
	public String getSd_comptp() {
		return ((String) getAttrVal("Sd_comptp"));
	}	
	public void setSd_comptp(String Sd_comptp) {
		setAttrVal("Sd_comptp", Sd_comptp);
	}
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
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
		return "Id_patsrvpkgitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_srv_pkg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatSrvPkgItmDODesc.class);
	}
	
}