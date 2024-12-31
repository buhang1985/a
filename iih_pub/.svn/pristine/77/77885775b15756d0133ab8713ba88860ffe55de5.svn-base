package iih.bd.res.opt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.opt.d.desc.OptEntpDODesc;
import java.math.BigDecimal;

/**
 * 手术台与就诊类型关系 DO数据 
 * 
 */
public class OptEntpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPTENTP= "Id_optentp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_OPT= "Id_opt";
	public static final String ID_ENTP= "Id_entp";
	public static final String ENTP_NAME= "Entp_name";
	public static final String ENTP_CODE= "Entp_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_optentp() {
		return ((String) getAttrVal("Id_optentp"));
	}	
	public void setId_optentp(String Id_optentp) {
		setAttrVal("Id_optentp", Id_optentp);
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
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
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
		return "Id_optentp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_opt_entp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OptEntpDODesc.class);
	}
	
}