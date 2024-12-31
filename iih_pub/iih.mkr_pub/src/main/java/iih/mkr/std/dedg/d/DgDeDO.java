package iih.mkr.std.dedg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.std.dedg.d.desc.DgDeDODesc;
import java.math.BigDecimal;

/**
 * 数据组数据元 DO数据 
 * 
 */
public class DgDeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGDE= "Id_dgde";
	public static final String ID_DG= "Id_dg";
	public static final String ID_DE= "Id_de";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String DE_NAME= "De_name";
	public static final String DE_CODE= "De_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgde() {
		return ((String) getAttrVal("Id_dgde"));
	}	
	public void setId_dgde(String Id_dgde) {
		setAttrVal("Id_dgde", Id_dgde);
	}
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}	
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getDe_name() {
		return ((String) getAttrVal("De_name"));
	}	
	public void setDe_name(String De_name) {
		setAttrVal("De_name", De_name);
	}
	public String getDe_code() {
		return ((String) getAttrVal("De_code"));
	}	
	public void setDe_code(String De_code) {
		setAttrVal("De_code", De_code);
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
		return "Id_dgde";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dg_de";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DgDeDODesc.class);
	}
	
}