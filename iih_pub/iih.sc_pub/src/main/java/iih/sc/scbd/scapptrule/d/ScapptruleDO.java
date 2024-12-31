package iih.sc.scbd.scapptrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scapptrule.d.desc.ScapptruleDODesc;
import java.math.BigDecimal;

/**
 * 排班开放规则 DO数据 
 * 
 */
public class ScapptruleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APPTRU= "Id_apptru";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_SCTP= "Sd_sctp";
	public static final String ID_SCTP= "Id_sctp";
	public static final String ID_SCCA= "Id_scca";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SD_SCHRULE= "Sd_schrule";
	public static final String ID_SCHRULE= "Id_schrule";
	public static final String NO_B= "No_b";
	public static final String NO_E= "No_e";
	public static final String TICS= "Tics";
	public static final String ID_FUNC= "Id_func";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CODE_SCTP= "Code_sctp";
	public static final String NAME_SCTP= "Name_sctp";
	public static final String NAME_SCCA= "Name_scca";
	public static final String CODE_SCCA= "Code_scca";
	public static final String ID_SCTP_RULE= "Id_sctp_rule";
	public static final String SD_SCTP_RULE= "Sd_sctp_rule";
	public static final String CODE_SCHRULE= "Code_schrule";
	public static final String NAME_SCHRULE= "Name_schrule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}	
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
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
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getSd_schrule() {
		return ((String) getAttrVal("Sd_schrule"));
	}	
	public void setSd_schrule(String Sd_schrule) {
		setAttrVal("Sd_schrule", Sd_schrule);
	}
	public String getId_schrule() {
		return ((String) getAttrVal("Id_schrule"));
	}	
	public void setId_schrule(String Id_schrule) {
		setAttrVal("Id_schrule", Id_schrule);
	}
	public Integer getNo_b() {
		return ((Integer) getAttrVal("No_b"));
	}	
	public void setNo_b(Integer No_b) {
		setAttrVal("No_b", No_b);
	}
	public Integer getNo_e() {
		return ((Integer) getAttrVal("No_e"));
	}	
	public void setNo_e(Integer No_e) {
		setAttrVal("No_e", No_e);
	}
	public String getTics() {
		return ((String) getAttrVal("Tics"));
	}	
	public void setTics(String Tics) {
		setAttrVal("Tics", Tics);
	}
	public String getId_func() {
		return ((String) getAttrVal("Id_func"));
	}	
	public void setId_func(String Id_func) {
		setAttrVal("Id_func", Id_func);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getCode_sctp() {
		return ((String) getAttrVal("Code_sctp"));
	}	
	public void setCode_sctp(String Code_sctp) {
		setAttrVal("Code_sctp", Code_sctp);
	}
	public String getName_sctp() {
		return ((String) getAttrVal("Name_sctp"));
	}	
	public void setName_sctp(String Name_sctp) {
		setAttrVal("Name_sctp", Name_sctp);
	}
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	public String getId_sctp_rule() {
		return ((String) getAttrVal("Id_sctp_rule"));
	}	
	public void setId_sctp_rule(String Id_sctp_rule) {
		setAttrVal("Id_sctp_rule", Id_sctp_rule);
	}
	public String getSd_sctp_rule() {
		return ((String) getAttrVal("Sd_sctp_rule"));
	}	
	public void setSd_sctp_rule(String Sd_sctp_rule) {
		setAttrVal("Sd_sctp_rule", Sd_sctp_rule);
	}
	public String getCode_schrule() {
		return ((String) getAttrVal("Code_schrule"));
	}	
	public void setCode_schrule(String Code_schrule) {
		setAttrVal("Code_schrule", Code_schrule);
	}
	public String getName_schrule() {
		return ((String) getAttrVal("Name_schrule"));
	}	
	public void setName_schrule(String Name_schrule) {
		setAttrVal("Name_schrule", Name_schrule);
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
		return "Id_apptru";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apptrule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScapptruleDODesc.class);
	}
	
}