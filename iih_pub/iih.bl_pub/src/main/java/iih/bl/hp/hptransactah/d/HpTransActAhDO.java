package iih.bl.hp.hptransactah.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hptransactah.d.desc.HpTransActAhDODesc;
import java.math.BigDecimal;

/**
 * 安徽医保交易记录 DO数据 
 * 
 */
public class HpTransActAhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRANSACTNEUSOFTAH= "Id_transactneusoftah";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String BUSINESS_CODE= "Business_code";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ENT= "Id_ent";
	public static final String ENT_CODE= "Ent_code";
	public static final String HP_ENT_SERIAL_NO= "Hp_ent_serial_no";
	public static final String DT_TRANSACT= "Dt_transact";
	public static final String ID_EMP_OPR= "Id_emp_opr";
	public static final String CODE_HIS= "Code_his";
	public static final String CODE_HP= "Code_hp";
	public static final String FG_CANCEL= "Fg_cancel";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String ID_PAR= "Id_par";
	public static final String ID_PAT= "Id_pat";
	public static final String TRANS_STATUS= "Trans_status";
	public static final String SRCFUNC_DES= "Srcfunc_des";
	public static final String ID_MEDKIND= "Id_medkind";
	public static final String CODE_MEDKIND= "Code_medkind";
	public static final String INPUTINFO= "Inputinfo";
	public static final String OUTPUTINFO= "Outputinfo";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_transactneusoftah() {
		return ((String) getAttrVal("Id_transactneusoftah"));
	}	
	public void setId_transactneusoftah(String Id_transactneusoftah) {
		setAttrVal("Id_transactneusoftah", Id_transactneusoftah);
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
	public String getBusiness_code() {
		return ((String) getAttrVal("Business_code"));
	}	
	public void setBusiness_code(String Business_code) {
		setAttrVal("Business_code", Business_code);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	public String getHp_ent_serial_no() {
		return ((String) getAttrVal("Hp_ent_serial_no"));
	}	
	public void setHp_ent_serial_no(String Hp_ent_serial_no) {
		setAttrVal("Hp_ent_serial_no", Hp_ent_serial_no);
	}
	public FDateTime getDt_transact() {
		return ((FDateTime) getAttrVal("Dt_transact"));
	}	
	public void setDt_transact(FDateTime Dt_transact) {
		setAttrVal("Dt_transact", Dt_transact);
	}
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}	
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
	}
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}	
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public FBoolean getFg_cancel() {
		return ((FBoolean) getAttrVal("Fg_cancel"));
	}	
	public void setFg_cancel(FBoolean Fg_cancel) {
		setAttrVal("Fg_cancel", Fg_cancel);
	}
	public String getEu_direct() {
		return ((String) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(String Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getTrans_status() {
		return ((String) getAttrVal("Trans_status"));
	}	
	public void setTrans_status(String Trans_status) {
		setAttrVal("Trans_status", Trans_status);
	}
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}	
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}	
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}	
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
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
		return "Id_transactneusoftah";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_transact_neusoft_ah";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTransActAhDODesc.class);
	}
	
}