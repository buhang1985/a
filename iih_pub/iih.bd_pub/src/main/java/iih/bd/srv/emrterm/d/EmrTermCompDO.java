package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrTermCompDODesc;
import java.math.BigDecimal;

/**
 * 病历辅助录入组件 DO数据 
 * 
 */
public class EmrTermCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRACOMP= "Id_mracomp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String QRYSCHEME= "Qryscheme";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_USE_ER1= "Fg_use_er1";
	public static final String FG_USE_ER2= "Fg_use_er2";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String FUNCCLASS= "Funcclass";
	public static final String COMPLAYOUT= "Complayout";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_GRP_CODE= "Mr_grp_code";
	public static final String MR_GRP_NAME= "Mr_grp_name";
	public static final String MR_ORG_CODE= "Mr_org_code";
	public static final String MR_ORG_NAME= "Mr_org_name";
	public static final String MR_CREAT_CODE= "Mr_creat_code";
	public static final String MR_CREAT_NAME= "Mr_creat_name";
	public static final String MR_MODIFY_NAME= "Mr_modify_name";
	public static final String MR_MODIFY_CODE= "Mr_modify_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mracomp() {
		return ((String) getAttrVal("Id_mracomp"));
	}	
	public void setId_mracomp(String Id_mracomp) {
		setAttrVal("Id_mracomp", Id_mracomp);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getQryscheme() {
		return ((String) getAttrVal("Qryscheme"));
	}	
	public void setQryscheme(String Qryscheme) {
		setAttrVal("Qryscheme", Qryscheme);
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
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
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
	public String getFuncclass() {
		return ((String) getAttrVal("Funcclass"));
	}	
	public void setFuncclass(String Funcclass) {
		setAttrVal("Funcclass", Funcclass);
	}
	public String getComplayout() {
		return ((String) getAttrVal("Complayout"));
	}	
	public void setComplayout(String Complayout) {
		setAttrVal("Complayout", Complayout);
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
	public String getMr_grp_code() {
		return ((String) getAttrVal("Mr_grp_code"));
	}	
	public void setMr_grp_code(String Mr_grp_code) {
		setAttrVal("Mr_grp_code", Mr_grp_code);
	}
	public String getMr_grp_name() {
		return ((String) getAttrVal("Mr_grp_name"));
	}	
	public void setMr_grp_name(String Mr_grp_name) {
		setAttrVal("Mr_grp_name", Mr_grp_name);
	}
	public String getMr_org_code() {
		return ((String) getAttrVal("Mr_org_code"));
	}	
	public void setMr_org_code(String Mr_org_code) {
		setAttrVal("Mr_org_code", Mr_org_code);
	}
	public String getMr_org_name() {
		return ((String) getAttrVal("Mr_org_name"));
	}	
	public void setMr_org_name(String Mr_org_name) {
		setAttrVal("Mr_org_name", Mr_org_name);
	}
	public String getMr_creat_code() {
		return ((String) getAttrVal("Mr_creat_code"));
	}	
	public void setMr_creat_code(String Mr_creat_code) {
		setAttrVal("Mr_creat_code", Mr_creat_code);
	}
	public String getMr_creat_name() {
		return ((String) getAttrVal("Mr_creat_name"));
	}	
	public void setMr_creat_name(String Mr_creat_name) {
		setAttrVal("Mr_creat_name", Mr_creat_name);
	}
	public String getMr_modify_name() {
		return ((String) getAttrVal("Mr_modify_name"));
	}	
	public void setMr_modify_name(String Mr_modify_name) {
		setAttrVal("Mr_modify_name", Mr_modify_name);
	}
	public String getMr_modify_code() {
		return ((String) getAttrVal("Mr_modify_code"));
	}	
	public void setMr_modify_code(String Mr_modify_code) {
		setAttrVal("Mr_modify_code", Mr_modify_code);
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
		return "Id_mracomp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_comp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrTermCompDODesc.class);
	}
	
}