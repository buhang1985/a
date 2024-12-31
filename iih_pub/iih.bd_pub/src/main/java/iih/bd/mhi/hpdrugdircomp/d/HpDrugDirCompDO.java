package iih.bd.mhi.hpdrugdircomp.d;

import iih.bd.mhi.hpdrugdircomp.d.desc.HpDrugDirCompDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 医保产品_药品对照 DO数据
 * 
 */
public class HpDrugDirCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_COMP_DRUG = "Id_comp_drug";
	public static final String ID_GRP = "Id_grp";
	public static final String ID_ORG = "Id_org";
	public static final String ID_HP = "Id_hp";
	public static final String ID_DRUG = "Id_drug";
	public static final String CODE = "Code";
	public static final String EU_STATUS = "Eu_status";
	public static final String DT_APPROVED = "Dt_approved";
	public static final String CREATEDBY = "Createdby";
	public static final String CREATEDTIME = "Createdtime";
	public static final String MODIFIEDBY = "Modifiedby";
	public static final String MODIFIEDTIME = "Modifiedtime";
	public static final String HP_NAME = "Hp_name";
	public static final String DRUG_NAME = "Drug_name";
	public static final String DRUG_CODE = "Drug_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";

	public String getId_comp_drug() {
		return ((String) getAttrVal("Id_comp_drug"));
	}

	public void setId_comp_drug(String Id_comp_drug) {
		setAttrVal("Id_comp_drug", Id_comp_drug);
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

	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}

	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}

	public String getId_drug() {
		return ((String) getAttrVal("Id_drug"));
	}

	public void setId_drug(String Id_drug) {
		setAttrVal("Id_drug", Id_drug);
	}

	public String getCode() {
		return ((String) getAttrVal("Code"));
	}

	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}

	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}

	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}

	public FDateTime getDt_approved() {
		return ((FDateTime) getAttrVal("Dt_approved"));
	}

	public void setDt_approved(FDateTime Dt_approved) {
		setAttrVal("Dt_approved", Dt_approved);
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

	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}

	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}

	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}

	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
	}

	public String getDrug_code() {
		return ((String) getAttrVal("Drug_code"));
	}

	public void setDrug_code(String Drug_code) {
		setAttrVal("Drug_code", Drug_code);
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

	// @Override
	// public java.lang.String getParentPKFieldName() {
	// return null;
	// }

	@Override
	public String getPKFieldName() {
		return "Id_comp_drug";
	}

	@Override
	public String getTableName() {
		return "BD_HP_COMP_DRUG";
	}

	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpDrugDirCompDODesc.class);
	}

}