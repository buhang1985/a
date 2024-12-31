package iih.pi.concern.concern.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.concern.concern.d.desc.PiPatIndDODesc;
import java.math.BigDecimal;

/**
 * 患者关注指标 DO数据 
 * 
 */
public class PiPatIndDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATIND= "Id_patind";
	public static final String ID_PAT= "Id_pat";
	public static final String SRVCODE= "Srvcode";
	public static final String ID_SRV= "Id_srv";
	public static final String SORTNO= "Sortno";
	public static final String CONCERN_CODE= "Concern_code";
	public static final String CONCERN_NAME= "Concern_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patind() {
		return ((String) getAttrVal("Id_patind"));
	}	
	public void setId_patind(String Id_patind) {
		setAttrVal("Id_patind", Id_patind);
	}
	
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}	
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	
	public String getConcern_code() {
		return ((String) getAttrVal("Concern_code"));
	}	
	public void setConcern_code(String Concern_code) {
		setAttrVal("Concern_code", Concern_code);
	}
	
	public String getConcern_name() {
		return ((String) getAttrVal("Concern_name"));
	}	
	public void setConcern_name(String Concern_name) {
		setAttrVal("Concern_name", Concern_name);
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
		return "Id_patind";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_ind";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(PiPatIndDODesc.class);
	}
	
}