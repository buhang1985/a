package iih.bd.srv.srvortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvortpl.d.desc.SrvOrdTplDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务医嘱模板 DO数据 
 * 
 */
public class SrvOrdTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVORTPL= "Id_srvortpl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVORTPLCA= "Id_srvortplca";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String ID_SRVORRT= "Id_srvorrt";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String NOTE= "Note";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_SRVPESETITM= "Id_srvpesetitm";
	public static final String ID_USAGE= "Id_usage";
	public static final String ID_FREG= "Id_freg";
	public static final String ID_UNIT= "Id_unit";
	public static final String QUAN_MED= "Quan_med";
	public static final String DI_NAME= "Di_name";
	public static final String SD_SRVORRT= "Sd_srvorrt";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String CATE_NAME= "Cate_name";
	public static final String CATE_CODE= "Cate_code";
	public static final String SRVORRT_CODE= "Srvorrt_code";
	public static final String SRVORRT_NAME= "Srvorrt_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvortpl() {
		return ((String) getAttrVal("Id_srvortpl"));
	}	
	public void setId_srvortpl(String Id_srvortpl) {
		setAttrVal("Id_srvortpl", Id_srvortpl);
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
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srvortplca() {
		return ((String) getAttrVal("Id_srvortplca"));
	}	
	public void setId_srvortplca(String Id_srvortplca) {
		setAttrVal("Id_srvortplca", Id_srvortplca);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}	
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getId_srvpesetitm() {
		return ((String) getAttrVal("Id_srvpesetitm"));
	}	
	public void setId_srvpesetitm(String Id_srvpesetitm) {
		setAttrVal("Id_srvpesetitm", Id_srvpesetitm);
	}
	public String getId_usage() {
		return ((String) getAttrVal("Id_usage"));
	}	
	public void setId_usage(String Id_usage) {
		setAttrVal("Id_usage", Id_usage);
	}
	public String getId_freg() {
		return ((String) getAttrVal("Id_freg"));
	}	
	public void setId_freg(String Id_freg) {
		setAttrVal("Id_freg", Id_freg);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(String Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}	
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getCate_name() {
		return ((String) getAttrVal("Cate_name"));
	}	
	public void setCate_name(String Cate_name) {
		setAttrVal("Cate_name", Cate_name);
	}
	public String getCate_code() {
		return ((String) getAttrVal("Cate_code"));
	}	
	public void setCate_code(String Cate_code) {
		setAttrVal("Cate_code", Cate_code);
	}
	public String getSrvorrt_code() {
		return ((String) getAttrVal("Srvorrt_code"));
	}	
	public void setSrvorrt_code(String Srvorrt_code) {
		setAttrVal("Srvorrt_code", Srvorrt_code);
	}
	public String getSrvorrt_name() {
		return ((String) getAttrVal("Srvorrt_name"));
	}	
	public void setSrvorrt_name(String Srvorrt_name) {
		setAttrVal("Srvorrt_name", Srvorrt_name);
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
		return "Id_srvortpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_or_tpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvOrdTplDODesc.class);
	}
	
}