package iih.en.pv.entdi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.entdi.d.desc.EntDiDODesc;
import java.math.BigDecimal;

/**
 * 就诊临床诊断 DO数据 
 * 
 */
public class EntDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTDI= "Id_entdi";
	public static final String ID_ENT= "Id_ent";
	public static final String SORTNO= "Sortno";
	public static final String ID_CDSYSTP= "Id_cdsystp";
	public static final String SD_CDSYSTP= "Sd_cdsystp";
	public static final String ID_DIDEF_DIS= "Id_didef_dis";
	public static final String NAME_DIDEF_DIS= "Name_didef_dis";
	public static final String CODE_DIDEF_DIS= "Code_didef_dis";
	public static final String SUPPLEMENT= "Supplement";
	public static final String INNERCODE= "Innercode";
	public static final String FG_MAJ= "Fg_maj";
	public static final String DT_DIAG= "Dt_diag";
	public static final String ID_EMP_PHY= "Id_emp_phy";
	public static final String FG_CURED= "Fg_cured";
	public static final String ID_DITP= "Id_ditp";
	public static final String SD_DITP= "Sd_ditp";
	public static final String FG_SUSPDI= "Fg_suspdi";
	public static final String ID_DIDEF_SYN= "Id_didef_syn";
	public static final String NAME_DIDEF_SYN= "Name_didef_syn";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_DI= "Id_di";
	public static final String ID_DIITM= "Id_diitm";
	public static final String ID_PARENT= "Id_parent";
	public static final String FG_SELF= "Fg_self";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_CHRONIC= "Fg_chronic";
	public static final String FG_SPECIAL= "Fg_special";
	public static final String ID_INFECTIONTP= "Id_infectiontp";
	public static final String SD_INFECTIONTP= "Sd_infectiontp";
	public static final String FG_UR= "Fg_ur";
	public static final String CODE_DISUNJTP= "Code_disunjtp";
	public static final String NAME_DISUNJTP= "Name_disunjtp";
	public static final String NAME_BDDI= "Name_bddi";
	public static final String CODE_BDDI= "Code_bddi";
	public static final String CODE_EMP= "Code_emp";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_DIPROCSTA= "Name_diprocsta";
	public static final String CODE_DIPROCSTA= "Code_diprocsta";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entdi() {
		return ((String) getAttrVal("Id_entdi"));
	}	
	public void setId_entdi(String Id_entdi) {
		setAttrVal("Id_entdi", Id_entdi);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
	}
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
	}
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}	
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	public String getCode_didef_dis() {
		return ((String) getAttrVal("Code_didef_dis"));
	}	
	public void setCode_didef_dis(String Code_didef_dis) {
		setAttrVal("Code_didef_dis", Code_didef_dis);
	}
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}	
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public FBoolean getFg_maj() {
		return ((FBoolean) getAttrVal("Fg_maj"));
	}	
	public void setFg_maj(FBoolean Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	public FDateTime getDt_diag() {
		return ((FDateTime) getAttrVal("Dt_diag"));
	}	
	public void setDt_diag(FDateTime Dt_diag) {
		setAttrVal("Dt_diag", Dt_diag);
	}
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	public FBoolean getFg_cured() {
		return ((FBoolean) getAttrVal("Fg_cured"));
	}	
	public void setFg_cured(FBoolean Fg_cured) {
		setAttrVal("Fg_cured", Fg_cured);
	}
	public String getId_ditp() {
		return ((String) getAttrVal("Id_ditp"));
	}	
	public void setId_ditp(String Id_ditp) {
		setAttrVal("Id_ditp", Id_ditp);
	}
	public String getSd_ditp() {
		return ((String) getAttrVal("Sd_ditp"));
	}	
	public void setSd_ditp(String Sd_ditp) {
		setAttrVal("Sd_ditp", Sd_ditp);
	}
	public FBoolean getFg_suspdi() {
		return ((FBoolean) getAttrVal("Fg_suspdi"));
	}	
	public void setFg_suspdi(FBoolean Fg_suspdi) {
		setAttrVal("Fg_suspdi", Fg_suspdi);
	}
	public String getId_didef_syn() {
		return ((String) getAttrVal("Id_didef_syn"));
	}	
	public void setId_didef_syn(String Id_didef_syn) {
		setAttrVal("Id_didef_syn", Id_didef_syn);
	}
	public String getName_didef_syn() {
		return ((String) getAttrVal("Name_didef_syn"));
	}	
	public void setName_didef_syn(String Name_didef_syn) {
		setAttrVal("Name_didef_syn", Name_didef_syn);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
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
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}	
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	public String getId_infectiontp() {
		return ((String) getAttrVal("Id_infectiontp"));
	}	
	public void setId_infectiontp(String Id_infectiontp) {
		setAttrVal("Id_infectiontp", Id_infectiontp);
	}
	public String getSd_infectiontp() {
		return ((String) getAttrVal("Sd_infectiontp"));
	}	
	public void setSd_infectiontp(String Sd_infectiontp) {
		setAttrVal("Sd_infectiontp", Sd_infectiontp);
	}
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}	
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	public String getCode_disunjtp() {
		return ((String) getAttrVal("Code_disunjtp"));
	}	
	public void setCode_disunjtp(String Code_disunjtp) {
		setAttrVal("Code_disunjtp", Code_disunjtp);
	}
	public String getName_disunjtp() {
		return ((String) getAttrVal("Name_disunjtp"));
	}	
	public void setName_disunjtp(String Name_disunjtp) {
		setAttrVal("Name_disunjtp", Name_disunjtp);
	}
	public String getName_bddi() {
		return ((String) getAttrVal("Name_bddi"));
	}	
	public void setName_bddi(String Name_bddi) {
		setAttrVal("Name_bddi", Name_bddi);
	}
	public String getCode_bddi() {
		return ((String) getAttrVal("Code_bddi"));
	}	
	public void setCode_bddi(String Code_bddi) {
		setAttrVal("Code_bddi", Code_bddi);
	}
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_diprocsta() {
		return ((String) getAttrVal("Name_diprocsta"));
	}	
	public void setName_diprocsta(String Name_diprocsta) {
		setAttrVal("Name_diprocsta", Name_diprocsta);
	}
	public String getCode_diprocsta() {
		return ((String) getAttrVal("Code_diprocsta"));
	}	
	public void setCode_diprocsta(String Code_diprocsta) {
		setAttrVal("Code_diprocsta", Code_diprocsta);
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
		return "Id_entdi";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntDiDODesc.class);
	}
	
}