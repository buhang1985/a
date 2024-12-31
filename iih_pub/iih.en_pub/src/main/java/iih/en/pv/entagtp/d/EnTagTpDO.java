package iih.en.pv.entagtp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.entagtp.d.desc.EnTagTpDODesc;
import java.math.BigDecimal;

/**
 * 就诊标签 DO数据 
 * 
 */
public class EnTagTpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTTAGTP= "Id_enttagtp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_TAGTP= "Id_tagtp";
	public static final String CODE_TAGTP= "Code_tagtp";
	public static final String NAME_TAGTP= "Name_tagtp";
	public static final String DT_TAG= "Dt_tag";
	public static final String ID_EMP_TAG= "Id_emp_tag";
	public static final String DT_END= "Dt_end";
	public static final String SHORTNAME= "Shortname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_enttagtp() {
		return ((String) getAttrVal("Id_enttagtp"));
	}	
	public void setId_enttagtp(String Id_enttagtp) {
		setAttrVal("Id_enttagtp", Id_enttagtp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_tagtp() {
		return ((String) getAttrVal("Id_tagtp"));
	}	
	public void setId_tagtp(String Id_tagtp) {
		setAttrVal("Id_tagtp", Id_tagtp);
	}
	public String getCode_tagtp() {
		return ((String) getAttrVal("Code_tagtp"));
	}	
	public void setCode_tagtp(String Code_tagtp) {
		setAttrVal("Code_tagtp", Code_tagtp);
	}
	public String getName_tagtp() {
		return ((String) getAttrVal("Name_tagtp"));
	}	
	public void setName_tagtp(String Name_tagtp) {
		setAttrVal("Name_tagtp", Name_tagtp);
	}
	public FDateTime getDt_tag() {
		return ((FDateTime) getAttrVal("Dt_tag"));
	}	
	public void setDt_tag(FDateTime Dt_tag) {
		setAttrVal("Dt_tag", Dt_tag);
	}
	public String getId_emp_tag() {
		return ((String) getAttrVal("Id_emp_tag"));
	}	
	public void setId_emp_tag(String Id_emp_tag) {
		setAttrVal("Id_emp_tag", Id_emp_tag);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
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
		return "Id_enttagtp";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ENT_TAGTP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnTagTpDODesc.class);
	}
	
}