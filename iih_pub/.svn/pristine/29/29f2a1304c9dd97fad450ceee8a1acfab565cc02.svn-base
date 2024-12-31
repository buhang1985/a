package iih.pi.patsrvpkg.pipatsrvpkggr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.patsrvpkg.pipatsrvpkggr.d.desc.PiPatSrvPkggrDODesc;
import java.math.BigDecimal;

/**
 * 患者服务包分组 DO数据 
 * 
 */
public class PiPatSrvPkggrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATSRVPKGGR= "Id_patsrvpkggr";
	public static final String ID_PATSRVPKG= "Id_patsrvpkg";
	public static final String SORTNO= "Sortno";
	public static final String NAME= "Name";
	public static final String ID_SRVPKGGR= "Id_srvpkggr";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patsrvpkggr() {
		return ((String) getAttrVal("Id_patsrvpkggr"));
	}	
	public void setId_patsrvpkggr(String Id_patsrvpkggr) {
		setAttrVal("Id_patsrvpkggr", Id_patsrvpkggr);
	}
	public String getId_patsrvpkg() {
		return ((String) getAttrVal("Id_patsrvpkg"));
	}	
	public void setId_patsrvpkg(String Id_patsrvpkg) {
		setAttrVal("Id_patsrvpkg", Id_patsrvpkg);
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
	public String getId_srvpkggr() {
		return ((String) getAttrVal("Id_srvpkggr"));
	}	
	public void setId_srvpkggr(String Id_srvpkggr) {
		setAttrVal("Id_srvpkggr", Id_srvpkggr);
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
		return "Id_patsrvpkggr";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_srv_pkg_gr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatSrvPkggrDODesc.class);
	}
	
}