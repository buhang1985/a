package iih.bl.hp.hptransactip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hptransactip.d.desc.HpTransactIpDODesc;
import java.math.BigDecimal;

/**
 * 住院交易记录 DO数据 
 * 
 */
public class HpTransactIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRANS_IP= "Id_trans_ip";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String BUSINESS_CODE= "Business_code";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ENT_CODE= "Ent_code";
	public static final String ID_ENT= "Id_ent";
	public static final String HP_ENT_SERIAL_NO= "Hp_ent_serial_no";
	public static final String DT_TRANSACT= "Dt_transact";
	public static final String ID_EMP_OPR= "Id_emp_opr";
	public static final String CODE_HIS= "Code_his";
	public static final String CODE_HP= "Code_hp";
	public static final String FG_CANCEL= "Fg_cancel";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String ID_PAR= "Id_par";
	public static final String ID_PAT= "Id_pat";
	public static final String STATUS_TRANS= "Status_trans";
	public static final String SRCFUNC_DES= "Srcfunc_des";
	public static final String INPUTINFO= "Inputinfo";
	public static final String OUTPUTINFO= "Outputinfo";
	public static final String CODE_MEDKIND= "Code_medkind";
	public static final String RCPT_NO= "Rcpt_no";
	public static final String FG_SPECIAL= "Fg_special";
	public static final String ID_HP= "Id_hp";
	public static final String FG_ROLLBACK= "Fg_rollback";
	public static final String HIS_BUSINESS_CODE= "His_business_code";
	public static final String ORGIN_CODEST= "Orgin_codest";
	public static final String REINPUTINFO= "Reinputinfo";
	public static final String REOUTPUTINFO= "Reoutputinfo";
	public static final String HP_BUSINESS_CODE= "Hp_business_code";
	public static final String DT_END= "Dt_end";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_trans_ip() {
		return ((String) getAttrVal("Id_trans_ip"));
	}	
	public void setId_trans_ip(String Id_trans_ip) {
		setAttrVal("Id_trans_ip", Id_trans_ip);
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
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
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
	public String getStatus_trans() {
		return ((String) getAttrVal("Status_trans"));
	}	
	public void setStatus_trans(String Status_trans) {
		setAttrVal("Status_trans", Status_trans);
	}
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}	
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
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
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}	
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	public String getRcpt_no() {
		return ((String) getAttrVal("Rcpt_no"));
	}	
	public void setRcpt_no(String Rcpt_no) {
		setAttrVal("Rcpt_no", Rcpt_no);
	}
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public FBoolean getFg_rollback() {
		return ((FBoolean) getAttrVal("Fg_rollback"));
	}	
	public void setFg_rollback(FBoolean Fg_rollback) {
		setAttrVal("Fg_rollback", Fg_rollback);
	}
	public String getHis_business_code() {
		return ((String) getAttrVal("His_business_code"));
	}	
	public void setHis_business_code(String His_business_code) {
		setAttrVal("His_business_code", His_business_code);
	}
	public String getOrgin_codest() {
		return ((String) getAttrVal("Orgin_codest"));
	}	
	public void setOrgin_codest(String Orgin_codest) {
		setAttrVal("Orgin_codest", Orgin_codest);
	}
	public String getReinputinfo() {
		return ((String) getAttrVal("Reinputinfo"));
	}	
	public void setReinputinfo(String Reinputinfo) {
		setAttrVal("Reinputinfo", Reinputinfo);
	}
	public String getReoutputinfo() {
		return ((String) getAttrVal("Reoutputinfo"));
	}	
	public void setReoutputinfo(String Reoutputinfo) {
		setAttrVal("Reoutputinfo", Reoutputinfo);
	}
	public String getHp_business_code() {
		return ((String) getAttrVal("Hp_business_code"));
	}	
	public void setHp_business_code(String Hp_business_code) {
		setAttrVal("Hp_business_code", Hp_business_code);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
		return "Id_trans_ip";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_transact_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTransactIpDODesc.class);
	}
	
}