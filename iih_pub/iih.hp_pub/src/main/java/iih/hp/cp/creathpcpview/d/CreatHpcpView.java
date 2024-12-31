package iih.hp.cp.creathpcpview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.creathpcpview.d.desc.CreatHpcpViewDesc;
import java.math.BigDecimal;

/**
 * 待建路径信息 DO数据 
 * 
 */
public class CreatHpcpView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CP= "Id_cp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CP_NAME= "Cp_name";
	public static final String CP_CODE= "Cp_code";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CP_NUM= "Cp_num";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
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
	public String getCp_name() {
		return ((String) getAttrVal("Cp_name"));
	}	
	public void setCp_name(String Cp_name) {
		setAttrVal("Cp_name", Cp_name);
	}
	public String getCp_code() {
		return ((String) getAttrVal("Cp_code"));
	}	
	public void setCp_code(String Cp_code) {
		setAttrVal("Cp_code", Cp_code);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public Integer getCp_num() {
		return ((Integer) getAttrVal("Cp_num"));
	}	
	public void setCp_num(Integer Cp_num) {
		setAttrVal("Cp_num", Cp_num);
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
		return "Id_cp";
	}
	
	@Override
	public String getTableName() {	  
		return "CREAT_HPCP_VIEW";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CreatHpcpViewDesc.class);
	}
	
}