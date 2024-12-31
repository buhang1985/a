package iih.bl.hp.hpblllitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hpblllitm.d.desc.BlHpCgItmIpDoDesc;
import java.math.BigDecimal;

/**
 * 医保交易明细 DO数据 
 * 
 */
public class BlHpCgItmIpDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPBLLLITM= "Id_hpblllitm";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_CGIP= "Id_cgip";
	public static final String AMT= "Amt";
	public static final String AMT_PAYZL= "Amt_payzl";
	public static final String AMT_PAYZF= "Amt_payzf";
	public static final String AMT_CXJ_PAYZF= "Amt_cxj_payzf";
	public static final String AMT_CZL_PAYZF= "Amt_czl_payzf";
	public static final String CODE_CA= "Code_ca";
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	public static final String FG_SELFPAY= "Fg_selfpay";
	public static final String RATE_PAYZL= "Rate_payzl";
	public static final String LIMITED_PRI= "Limited_pri";
	public static final String DES= "Des";
	public static final String NAME_HPSRVTP= "Name_hpsrvtp";
	public static final String HP_SRVCODE= "Hp_srvcode";
	public static final String SENDER_FLOW_NO= "Sender_flow_no";
	public static final String FAIL_CNT= "Fail_cnt";
	public static final String PRESAUTH_SELF= "Presauth_self";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpblllitm() {
		return ((String) getAttrVal("Id_hpblllitm"));
	}	
	public void setId_hpblllitm(String Id_hpblllitm) {
		setAttrVal("Id_hpblllitm", Id_hpblllitm);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}	
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getAmt_payzl() {
		return ((FDouble) getAttrVal("Amt_payzl"));
	}	
	public void setAmt_payzl(FDouble Amt_payzl) {
		setAttrVal("Amt_payzl", Amt_payzl);
	}
	public FDouble getAmt_payzf() {
		return ((FDouble) getAttrVal("Amt_payzf"));
	}	
	public void setAmt_payzf(FDouble Amt_payzf) {
		setAttrVal("Amt_payzf", Amt_payzf);
	}
	public FDouble getAmt_cxj_payzf() {
		return ((FDouble) getAttrVal("Amt_cxj_payzf"));
	}	
	public void setAmt_cxj_payzf(FDouble Amt_cxj_payzf) {
		setAttrVal("Amt_cxj_payzf", Amt_cxj_payzf);
	}
	public FDouble getAmt_czl_payzf() {
		return ((FDouble) getAttrVal("Amt_czl_payzf"));
	}	
	public void setAmt_czl_payzf(FDouble Amt_czl_payzf) {
		setAttrVal("Amt_czl_payzf", Amt_czl_payzf);
	}
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	public FDouble getRate_payzl() {
		return ((FDouble) getAttrVal("Rate_payzl"));
	}	
	public void setRate_payzl(FDouble Rate_payzl) {
		setAttrVal("Rate_payzl", Rate_payzl);
	}
	public FDouble getLimited_pri() {
		return ((FDouble) getAttrVal("Limited_pri"));
	}	
	public void setLimited_pri(FDouble Limited_pri) {
		setAttrVal("Limited_pri", Limited_pri);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}	
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	public String getHp_srvcode() {
		return ((String) getAttrVal("Hp_srvcode"));
	}	
	public void setHp_srvcode(String Hp_srvcode) {
		setAttrVal("Hp_srvcode", Hp_srvcode);
	}
	public String getSender_flow_no() {
		return ((String) getAttrVal("Sender_flow_no"));
	}	
	public void setSender_flow_no(String Sender_flow_no) {
		setAttrVal("Sender_flow_no", Sender_flow_no);
	}
	public Integer getFail_cnt() {
		return ((Integer) getAttrVal("Fail_cnt"));
	}	
	public void setFail_cnt(Integer Fail_cnt) {
		setAttrVal("Fail_cnt", Fail_cnt);
	}
	public String getPresauth_self() {
		return ((String) getAttrVal("Presauth_self"));
	}	
	public void setPresauth_self(String Presauth_self) {
		setAttrVal("Presauth_self", Presauth_self);
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
		return "Id_hpblllitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_cgitm_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpCgItmIpDoDesc.class);
	}
	
}