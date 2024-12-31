package iih.mp.ne.mptb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ne.mptb.d.desc.MpTbDODesc;
import java.math.BigDecimal;

/**
 * 住院执行_取血单 DO数据 
 * 
 */
public class MpTbDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TB= "Id_tb";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String TB_CODE= "Tb_code";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String PAT_BT= "Pat_bt";
	public static final String PAT_RHB= "Pat_rhb";
	public static final String ID_OR_BT= "Id_or_bt";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_OR_BU= "Id_or_bu";
	public static final String DT_BU_PL= "Dt_bu_pl";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_UNIT= "Id_unit";
	public static final String ID_EMP_TB= "Id_emp_tb";
	public static final String ID_EMP_SB= "Id_emp_sb";
	public static final String DT_OUT= "Dt_out";
	public static final String CT_PRN= "Ct_prn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String WBCODE_PAT= "Wbcode_pat";
	public static final String PYCODE_PAT= "Pycode_pat";
	public static final String MNECODE_PAT= "Mnecode_pat";
	public static final String CODE_PAT= "Code_pat";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_SRV= "Name_srv";
	public static final String NAME_EMP_TB= "Name_emp_tb";
	public static final String NAME_EMP_SB= "Name_emp_sb";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_tb() {
		return ((String) getAttrVal("Id_tb"));
	}	
	public void setId_tb(String Id_tb) {
		setAttrVal("Id_tb", Id_tb);
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
	public String getTb_code() {
		return ((String) getAttrVal("Tb_code"));
	}	
	public void setTb_code(String Tb_code) {
		setAttrVal("Tb_code", Tb_code);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getPat_bt() {
		return ((String) getAttrVal("Pat_bt"));
	}	
	public void setPat_bt(String Pat_bt) {
		setAttrVal("Pat_bt", Pat_bt);
	}
	public String getPat_rhb() {
		return ((String) getAttrVal("Pat_rhb"));
	}	
	public void setPat_rhb(String Pat_rhb) {
		setAttrVal("Pat_rhb", Pat_rhb);
	}
	public String getId_or_bt() {
		return ((String) getAttrVal("Id_or_bt"));
	}	
	public void setId_or_bt(String Id_or_bt) {
		setAttrVal("Id_or_bt", Id_or_bt);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_or_bu() {
		return ((String) getAttrVal("Id_or_bu"));
	}	
	public void setId_or_bu(String Id_or_bu) {
		setAttrVal("Id_or_bu", Id_or_bu);
	}
	public FDateTime getDt_bu_pl() {
		return ((FDateTime) getAttrVal("Dt_bu_pl"));
	}	
	public void setDt_bu_pl(FDateTime Dt_bu_pl) {
		setAttrVal("Dt_bu_pl", Dt_bu_pl);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getId_emp_tb() {
		return ((String) getAttrVal("Id_emp_tb"));
	}	
	public void setId_emp_tb(String Id_emp_tb) {
		setAttrVal("Id_emp_tb", Id_emp_tb);
	}
	public String getId_emp_sb() {
		return ((String) getAttrVal("Id_emp_sb"));
	}	
	public void setId_emp_sb(String Id_emp_sb) {
		setAttrVal("Id_emp_sb", Id_emp_sb);
	}
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}	
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	public Integer getCt_prn() {
		return ((Integer) getAttrVal("Ct_prn"));
	}	
	public void setCt_prn(Integer Ct_prn) {
		setAttrVal("Ct_prn", Ct_prn);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getWbcode_pat() {
		return ((String) getAttrVal("Wbcode_pat"));
	}	
	public void setWbcode_pat(String Wbcode_pat) {
		setAttrVal("Wbcode_pat", Wbcode_pat);
	}
	public String getPycode_pat() {
		return ((String) getAttrVal("Pycode_pat"));
	}	
	public void setPycode_pat(String Pycode_pat) {
		setAttrVal("Pycode_pat", Pycode_pat);
	}
	public String getMnecode_pat() {
		return ((String) getAttrVal("Mnecode_pat"));
	}	
	public void setMnecode_pat(String Mnecode_pat) {
		setAttrVal("Mnecode_pat", Mnecode_pat);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getName_emp_tb() {
		return ((String) getAttrVal("Name_emp_tb"));
	}	
	public void setName_emp_tb(String Name_emp_tb) {
		setAttrVal("Name_emp_tb", Name_emp_tb);
	}
	public String getName_emp_sb() {
		return ((String) getAttrVal("Name_emp_sb"));
	}	
	public void setName_emp_sb(String Name_emp_sb) {
		setAttrVal("Name_emp_sb", Name_emp_sb);
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
		return "Id_tb";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_TB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpTbDODesc.class);
	}
	
}