package iih.bd.srv.srvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包 DO数据 
 * 
 */
public class SrvPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String ID_SRVPKGCA= "Id_srvpkgca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String NOTE= "Note";
	public static final String CN_VALID= "Cn_valid";
	public static final String ID_VALIDU= "Id_validu";
	public static final String SD_VALIDU= "Sd_validu";
	public static final String DT_EFFE= "Dt_effe";
	public static final String DT_END= "Dt_end";
	public static final String ID_SRVPKGBLTP= "Id_srvpkgbltp";
	public static final String SD_SRVPKGBLTP= "Sd_srvpkgbltp";
	public static final String FG_MULTIEN= "Fg_multien";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String FG_ACVTIVE= "Fg_acvtive";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	public String getId_srvpkgca() {
		return ((String) getAttrVal("Id_srvpkgca"));
	}	
	public void setId_srvpkgca(String Id_srvpkgca) {
		setAttrVal("Id_srvpkgca", Id_srvpkgca);
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
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public Integer getCn_valid() {
		return ((Integer) getAttrVal("Cn_valid"));
	}	
	public void setCn_valid(Integer Cn_valid) {
		setAttrVal("Cn_valid", Cn_valid);
	}
	public String getId_validu() {
		return ((String) getAttrVal("Id_validu"));
	}	
	public void setId_validu(String Id_validu) {
		setAttrVal("Id_validu", Id_validu);
	}
	public String getSd_validu() {
		return ((String) getAttrVal("Sd_validu"));
	}	
	public void setSd_validu(String Sd_validu) {
		setAttrVal("Sd_validu", Sd_validu);
	}
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_srvpkgbltp() {
		return ((String) getAttrVal("Id_srvpkgbltp"));
	}	
	public void setId_srvpkgbltp(String Id_srvpkgbltp) {
		setAttrVal("Id_srvpkgbltp", Id_srvpkgbltp);
	}
	public String getSd_srvpkgbltp() {
		return ((String) getAttrVal("Sd_srvpkgbltp"));
	}	
	public void setSd_srvpkgbltp(String Sd_srvpkgbltp) {
		setAttrVal("Sd_srvpkgbltp", Sd_srvpkgbltp);
	}
	public FBoolean getFg_multien() {
		return ((FBoolean) getAttrVal("Fg_multien"));
	}	
	public void setFg_multien(FBoolean Fg_multien) {
		setAttrVal("Fg_multien", Fg_multien);
	}
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	public FBoolean getFg_acvtive() {
		return ((FBoolean) getAttrVal("Fg_acvtive"));
	}	
	public void setFg_acvtive(FBoolean Fg_acvtive) {
		setAttrVal("Fg_acvtive", Fg_acvtive);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_srvpkg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgDODesc.class);
	}
	
}