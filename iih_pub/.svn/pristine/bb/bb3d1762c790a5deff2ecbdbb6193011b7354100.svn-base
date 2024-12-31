package iih.en.pv.enbeditem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enbeditem.d.desc.EnbeditemDesc;
import java.math.BigDecimal;

/**
 * 床位占用明细 DO数据 
 * 
 */
public class Enbeditem extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BEDITEM= "Id_beditem";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_BED= "Name_bed";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String WEIGHT_NB= "Weight_nb";
	public static final String DT_BRITH_NB= "Dt_brith_nb";
	public static final String CREATETIME= "Createtime";
	public static final String CODE_ENT= "Code_ent";
	public static final String CODE_NUR= "Code_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String AMT_PREPAY= "Amt_prepay";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_beditem() {
		return ((String) getAttrVal("Id_beditem"));
	}	
	public void setId_beditem(String Id_beditem) {
		setAttrVal("Id_beditem", Id_beditem);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getWeight_nb() {
		return ((String) getAttrVal("Weight_nb"));
	}	
	public void setWeight_nb(String Weight_nb) {
		setAttrVal("Weight_nb", Weight_nb);
	}
	public String getDt_brith_nb() {
		return ((String) getAttrVal("Dt_brith_nb"));
	}	
	public void setDt_brith_nb(String Dt_brith_nb) {
		setAttrVal("Dt_brith_nb", Dt_brith_nb);
	}
	public String getCreatetime() {
		return ((String) getAttrVal("Createtime"));
	}	
	public void setCreatetime(String Createtime) {
		setAttrVal("Createtime", Createtime);
	}
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getAmt_prepay() {
		return ((String) getAttrVal("Amt_prepay"));
	}	
	public void setAmt_prepay(String Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
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
		return "Id_beditem";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_bed_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnbeditemDesc.class);
	}
	
}