package iih.hr.hsc.hscpsnlv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hsc.hscpsnlv.d.desc.HscPsnLvDODesc;
import java.math.BigDecimal;

/**
 * 人员请假记录 DO数据 
 * 
 */
public class HscPsnLvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HSC_PSNLV= "Id_hsc_psnlv";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DAYS_LV= "Days_lv";
	public static final String ID_LV_VA= "Id_lv_va";
	public static final String SD_LV_VA= "Sd_lv_va";
	public static final String REASON= "Reason";
	public static final String TEL= "Tel";
	public static final String ID_PSN_APPROVE= "Id_psn_approve";
	public static final String DEPSUGGEST= "Depsuggest";
	public static final String IPPFSUGGEST= "Ippfsuggest";
	public static final String ID_DIV_HEAD= "Id_div_head";
	public static final String ID_DEAN= "Id_dean";
	public static final String DT_CANCEL= "Dt_cancel";
	public static final String ID_PSN_REG= "Id_psn_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_CANCEL_PSN_REG= "Id_cancel_psn_reg";
	public static final String DT_CANCEL_REG= "Dt_cancel_reg";
	public static final String FG_PM= "Fg_pm";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SORTNO= "Sortno";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String CODE_PSNDOC= "Code_psndoc";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_LV_VA= "Name_lv_va";
	public static final String NAME_PSN_APPROVE= "Name_psn_approve";
	public static final String NAME_DIV_HEAD= "Name_div_head";
	public static final String NAME_DEAN= "Name_dean";
	public static final String NAME_PSN_REG= "Name_psn_reg";
	public static final String NAME_CANCEL_REG= "Name_cancel_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hsc_psnlv() {
		return ((String) getAttrVal("Id_hsc_psnlv"));
	}	
	public void setId_hsc_psnlv(String Id_hsc_psnlv) {
		setAttrVal("Id_hsc_psnlv", Id_hsc_psnlv);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDouble getDays_lv() {
		return ((FDouble) getAttrVal("Days_lv"));
	}	
	public void setDays_lv(FDouble Days_lv) {
		setAttrVal("Days_lv", Days_lv);
	}
	public String getId_lv_va() {
		return ((String) getAttrVal("Id_lv_va"));
	}	
	public void setId_lv_va(String Id_lv_va) {
		setAttrVal("Id_lv_va", Id_lv_va);
	}
	public String getSd_lv_va() {
		return ((String) getAttrVal("Sd_lv_va"));
	}	
	public void setSd_lv_va(String Sd_lv_va) {
		setAttrVal("Sd_lv_va", Sd_lv_va);
	}
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getId_psn_approve() {
		return ((String) getAttrVal("Id_psn_approve"));
	}	
	public void setId_psn_approve(String Id_psn_approve) {
		setAttrVal("Id_psn_approve", Id_psn_approve);
	}
	public String getDepsuggest() {
		return ((String) getAttrVal("Depsuggest"));
	}	
	public void setDepsuggest(String Depsuggest) {
		setAttrVal("Depsuggest", Depsuggest);
	}
	public String getIppfsuggest() {
		return ((String) getAttrVal("Ippfsuggest"));
	}	
	public void setIppfsuggest(String Ippfsuggest) {
		setAttrVal("Ippfsuggest", Ippfsuggest);
	}
	public String getId_div_head() {
		return ((String) getAttrVal("Id_div_head"));
	}	
	public void setId_div_head(String Id_div_head) {
		setAttrVal("Id_div_head", Id_div_head);
	}
	public String getId_dean() {
		return ((String) getAttrVal("Id_dean"));
	}	
	public void setId_dean(String Id_dean) {
		setAttrVal("Id_dean", Id_dean);
	}
	public FDate getDt_cancel() {
		return ((FDate) getAttrVal("Dt_cancel"));
	}	
	public void setDt_cancel(FDate Dt_cancel) {
		setAttrVal("Dt_cancel", Dt_cancel);
	}
	public String getId_psn_reg() {
		return ((String) getAttrVal("Id_psn_reg"));
	}	
	public void setId_psn_reg(String Id_psn_reg) {
		setAttrVal("Id_psn_reg", Id_psn_reg);
	}
	public FDate getDt_reg() {
		return ((FDate) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDate Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getId_cancel_psn_reg() {
		return ((String) getAttrVal("Id_cancel_psn_reg"));
	}	
	public void setId_cancel_psn_reg(String Id_cancel_psn_reg) {
		setAttrVal("Id_cancel_psn_reg", Id_cancel_psn_reg);
	}
	public FDateTime getDt_cancel_reg() {
		return ((FDateTime) getAttrVal("Dt_cancel_reg"));
	}	
	public void setDt_cancel_reg(FDateTime Dt_cancel_reg) {
		setAttrVal("Dt_cancel_reg", Dt_cancel_reg);
	}
	public FBoolean getFg_pm() {
		return ((FBoolean) getAttrVal("Fg_pm"));
	}	
	public void setFg_pm(FBoolean Fg_pm) {
		setAttrVal("Fg_pm", Fg_pm);
	}
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	public String getCode_psndoc() {
		return ((String) getAttrVal("Code_psndoc"));
	}	
	public void setCode_psndoc(String Code_psndoc) {
		setAttrVal("Code_psndoc", Code_psndoc);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_lv_va() {
		return ((String) getAttrVal("Name_lv_va"));
	}	
	public void setName_lv_va(String Name_lv_va) {
		setAttrVal("Name_lv_va", Name_lv_va);
	}
	public String getName_psn_approve() {
		return ((String) getAttrVal("Name_psn_approve"));
	}	
	public void setName_psn_approve(String Name_psn_approve) {
		setAttrVal("Name_psn_approve", Name_psn_approve);
	}
	public String getName_div_head() {
		return ((String) getAttrVal("Name_div_head"));
	}	
	public void setName_div_head(String Name_div_head) {
		setAttrVal("Name_div_head", Name_div_head);
	}
	public String getName_dean() {
		return ((String) getAttrVal("Name_dean"));
	}	
	public void setName_dean(String Name_dean) {
		setAttrVal("Name_dean", Name_dean);
	}
	public String getName_psn_reg() {
		return ((String) getAttrVal("Name_psn_reg"));
	}	
	public void setName_psn_reg(String Name_psn_reg) {
		setAttrVal("Name_psn_reg", Name_psn_reg);
	}
	public String getName_cancel_reg() {
		return ((String) getAttrVal("Name_cancel_reg"));
	}	
	public void setName_cancel_reg(String Name_cancel_reg) {
		setAttrVal("Name_cancel_reg", Name_cancel_reg);
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
		return "Id_hsc_psnlv";
	}
	
	@Override
	public String getTableName() {	  
		return "hr_hsc_psnlv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HscPsnLvDODesc.class);
	}
	
}