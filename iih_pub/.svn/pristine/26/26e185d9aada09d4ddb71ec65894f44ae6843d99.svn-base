package iih.ei.std.d.v1.ci.base;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import java.math.BigDecimal;

/**
 * 医嘱服务项目 DO数据 
 * 
 */
public class OrdSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PRES= "Id_pres";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME= "Name";
	public static final String FG_DOSE_ANOMA= "Fg_dose_anoma";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_MEDU= "Id_medu";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String ID_FREQ= "Id_freq";
	public static final String DT_LAST_BL= "Dt_last_bl";
	public static final String ID_ORG_SRV= "Id_org_srv";
	public static final String ID_DEP_SRV= "Id_dep_srv";
	public static final String ID_WG_OR= "Id_wg_or";
	public static final String ID_EMP_SRV= "Id_emp_srv";
	public static final String ID_ORG_MP= "Id_org_mp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String SD_SU_MP= "Sd_su_mp";
	public static final String SD_SU_BL= "Sd_su_bl";
	public static final String DT_LAST_MP= "Dt_last_mp";
	public static final String ID_SU_BL= "Id_su_bl";
	public static final String ID_SU_MP= "Id_su_mp";
	public static final String FG_OR= "Fg_or";
	public static final String EU_BLMD= "Eu_blmd";
	public static final String FG_MM= "Fg_mm";
	public static final String PRI= "Pri";
	public static final String FG_SET= "Fg_set";
	public static final String NOTE_SRV= "Note_srv";
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	public static final String FG_INDIC= "Fg_indic";
	public static final String FG_PROPC= "Fg_propc";
	public static final String FG_SELF= "Fg_self";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String FG_BL= "Fg_bl";
	public static final String CODE_SRV= "Code_srv";
	public static final String ID_DEP_NUR_SRV= "Id_dep_nur_srv";
	public static final String EU_SOURCEMD= "Eu_sourcemd";
	public static final String ID_HP= "Id_hp";
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	public static final String FG_SKINTEST= "Fg_skintest";
	public static final String SD_SKINTEST_SKIP_REASON= "Sd_skintest_skip_reason";
	public static final String ID_SKINTEST_SKIP_REASON= "Id_skintest_skip_reason";
	public static final String ID_RELTP= "Id_reltp";
	public static final String SD_RELTP= "Sd_reltp";
	public static final String ID_OR_REL= "Id_or_rel";
	public static final String DT_LAST_CG= "Dt_last_cg";
	public static final String FG_SKINTEST_RST= "Fg_skintest_rst";
	public static final String FG_SELFSRV= "Fg_selfsrv";
	public static final String ID_SRV_SRC= "Id_srv_src";
	public static final String QUAN_TOTAL_MEDU= "Quan_total_medu";
	public static final String ID_PRIMD= "Id_primd";
	public static final String FG_SELFPAY= "Fg_selfpay";
	public static final String ID_DEP_WH= "Id_dep_wh";
	public static final String INNERCODE_SRVCA= "Innercode_srvca";
	public static final String FG_BASE= "Fg_base";
	public static final String PRIBY= "Priby";
	public static final String DES_HPLIMIT= "Des_hplimit";
	public static final String FG_HPINDICJUDGED= "Fg_hpindicjudged";
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	public static final String EU_HPDOCTORJUDGE= "Eu_hpdoctorjudge";
	public static final String FG_SPECILL= "Fg_specill";
	public static final String FG_EXTDISPENSE= "Fg_extdispense";
	public static final String PRI_STD= "Pri_std";
	public static final String PRI_RATIO= "Pri_ratio";
	public static final String ID_PRIPAT= "Id_pripat";
	public static final String EU_FEEREVERSETP= "Eu_feereversetp";
	public static final String ID_MM= "Id_mm";
	public static final String INDICITEMID= "Indicitemid";
	public static final String EU_HPINDICJUDGE= "Eu_hpindicjudge";
	public static final String EU_HPSRVCTRTP= "Eu_hpsrvctrtp";
	public static final String FG_NOTHINGWITHORDERS= "Fg_nothingwithorders";
	public static final String FG_RESEARCH= "Fg_research";
	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	public static final String CODE_RESEARCHPROJECT= "Code_researchproject";
	public static final String ID_ANTIPURPOSE= "Id_antipurpose";
	public static final String SD_ANTIPURPOSE= "Sd_antipurpose";
	public static final String ID_PREPURPOSE= "Id_prepurpose";
	public static final String SD_PREPURPOSE= "Sd_prepurpose";
	public static final String ID_PREINCITP= "Id_preincitp";
	public static final String SD_PREINCITP= "Sd_preincitp";
	public static final String ID_PREDRUGREASON= "Id_predrugreason";
	public static final String SD_PREDRUGREASON= "Sd_predrugreason";
	public static final String NAME_PREDRUGREASON= "Name_predrugreason";
	public static final String FG_PAY_UNIT= "Fg_pay_unit";
	public static final String FG_HIGHRISK= "Fg_highrisk";
	public static final String ID_NODISPENSE= "Id_nodispense";
	public static final String SD_NODISPENSE= "Sd_nodispense";
	public static final String FG_SECADMT= "Fg_secadmt";
	public static final String OR_NAME= "Or_name";
	public static final String PRES_NAME= "Pres_name";
	public static final String PAT_NAME= "Pat_name";
	public static final String ENTP_NAME= "Entp_name";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String NAME_SRV= "Name_srv";
	public static final String MEDU_NAME= "Medu_name";
	public static final String ROUTE_NAME= "Route_name";
	public static final String ROUTEDES_NAME= "Routedes_name";
	public static final String BOIL_NAME= "Boil_name";
	public static final String BOILDES_NAME= "Boildes_name";
	public static final String FREQ_NAME= "Freq_name";
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	public static final String FREQCT= "Freqct";
	public static final String ORG_NAME= "Org_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String EMP_NAME= "Emp_name";
	public static final String ORG_MP_NAME= "Org_mp_name";
	public static final String DEP_MP_NAME= "Dep_mp_name";
	public static final String SU_BL_NAME= "Su_bl_name";
	public static final String SU_NAME= "Su_name";
	public static final String NAME_HPSRVTP= "Name_hpsrvtp";
	public static final String RELTP_NAME= "Reltp_name";
	public static final String OR_REL_NAME= "Or_rel_name";
	public static final String NAME_DEP_WH= "Name_dep_wh";
	public static final String NAME_RESEARCHPROJECT= "Name_researchproject";
	public static final String NAME_ANTIPURPOSE= "Name_antipurpose";
	public static final String NAME_PREPURPOSE= "Name_prepurpose";
	public static final String NAME_PREINCITP= "Name_preincitp";
	public static final String NAME_NODISPENSE= "Name_nodispense";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}	
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}	
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	public String getId_org_srv() {
		return ((String) getAttrVal("Id_org_srv"));
	}	
	public void setId_org_srv(String Id_org_srv) {
		setAttrVal("Id_org_srv", Id_org_srv);
	}
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}	
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}	
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}	
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}	
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}	
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	public String getNote_srv() {
		return ((String) getAttrVal("Note_srv"));
	}	
	public void setNote_srv(String Note_srv) {
		setAttrVal("Note_srv", Note_srv);
	}
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}	
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}	
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
		if(FBoolean.TRUE.equals(Fg_self)){
			this.setAttrVal(FG_BL, FBoolean.FALSE);
		}
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", new FBoolean(!FBoolean.TRUE.equals(this.getFg_self())&&FBoolean.TRUE.equals(Fg_bl)));
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getId_dep_nur_srv() {
		return ((String) getAttrVal("Id_dep_nur_srv"));
	}	
	public void setId_dep_nur_srv(String Id_dep_nur_srv) {
		setAttrVal("Id_dep_nur_srv", Id_dep_nur_srv);
	}
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}	
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}	
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}	
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	public FDateTime getDt_last_cg() {
		return ((FDateTime) getAttrVal("Dt_last_cg"));
	}	
	public void setDt_last_cg(FDateTime Dt_last_cg) {
		setAttrVal("Dt_last_cg", Dt_last_cg);
	}
	public FBoolean getFg_skintest_rst() {
		return ((FBoolean) getAttrVal("Fg_skintest_rst"));
	}	
	public void setFg_skintest_rst(FBoolean Fg_skintest_rst) {
		setAttrVal("Fg_skintest_rst", Fg_skintest_rst);
	}
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}	
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}	
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}	
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}	
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}	
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	public Integer getFg_hpindicjudged() {
		return ((Integer) getAttrVal("Fg_hpindicjudged"));
	}	
	public void setFg_hpindicjudged(Integer Fg_hpindicjudged) {
		setAttrVal("Fg_hpindicjudged", Fg_hpindicjudged);
	}
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	public Integer getEu_hpdoctorjudge() {
		return ((Integer) getAttrVal("Eu_hpdoctorjudge"));
	}	
	public void setEu_hpdoctorjudge(Integer Eu_hpdoctorjudge) {
		setAttrVal("Eu_hpdoctorjudge", Eu_hpdoctorjudge);
	}
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}	
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}	
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	public Integer getEu_feereversetp() {
		return ((Integer) getAttrVal("Eu_feereversetp"));
	}	
	public void setEu_feereversetp(Integer Eu_feereversetp) {
		setAttrVal("Eu_feereversetp", Eu_feereversetp);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}	
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}	
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}	
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}	
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	public String getId_antipurpose() {
		return ((String) getAttrVal("Id_antipurpose"));
	}	
	public void setId_antipurpose(String Id_antipurpose) {
		setAttrVal("Id_antipurpose", Id_antipurpose);
	}
	public String getSd_antipurpose() {
		return ((String) getAttrVal("Sd_antipurpose"));
	}	
	public void setSd_antipurpose(String Sd_antipurpose) {
		setAttrVal("Sd_antipurpose", Sd_antipurpose);
	}
	public String getId_prepurpose() {
		return ((String) getAttrVal("Id_prepurpose"));
	}	
	public void setId_prepurpose(String Id_prepurpose) {
		setAttrVal("Id_prepurpose", Id_prepurpose);
	}
	public String getSd_prepurpose() {
		return ((String) getAttrVal("Sd_prepurpose"));
	}	
	public void setSd_prepurpose(String Sd_prepurpose) {
		setAttrVal("Sd_prepurpose", Sd_prepurpose);
	}
	public String getId_preincitp() {
		return ((String) getAttrVal("Id_preincitp"));
	}	
	public void setId_preincitp(String Id_preincitp) {
		setAttrVal("Id_preincitp", Id_preincitp);
	}
	public String getSd_preincitp() {
		return ((String) getAttrVal("Sd_preincitp"));
	}	
	public void setSd_preincitp(String Sd_preincitp) {
		setAttrVal("Sd_preincitp", Sd_preincitp);
	}
	public String getId_predrugreason() {
		return ((String) getAttrVal("Id_predrugreason"));
	}	
	public void setId_predrugreason(String Id_predrugreason) {
		setAttrVal("Id_predrugreason", Id_predrugreason);
	}
	public String getSd_predrugreason() {
		return ((String) getAttrVal("Sd_predrugreason"));
	}	
	public void setSd_predrugreason(String Sd_predrugreason) {
		setAttrVal("Sd_predrugreason", Sd_predrugreason);
	}
	public String getName_predrugreason() {
		return ((String) getAttrVal("Name_predrugreason"));
	}	
	public void setName_predrugreason(String Name_predrugreason) {
		setAttrVal("Name_predrugreason", Name_predrugreason);
	}
	public FBoolean getFg_pay_unit() {
		return ((FBoolean) getAttrVal("Fg_pay_unit"));
	}	
	public void setFg_pay_unit(FBoolean Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}	
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	public String getId_nodispense() {
		return ((String) getAttrVal("Id_nodispense"));
	}	
	public void setId_nodispense(String Id_nodispense) {
		setAttrVal("Id_nodispense", Id_nodispense);
	}
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}	
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	public FBoolean getFg_secadmt() {
		return ((FBoolean) getAttrVal("Fg_secadmt"));
	}	
	public void setFg_secadmt(FBoolean Fg_secadmt) {
		setAttrVal("Fg_secadmt", Fg_secadmt);
	}
	public String getOr_name() {
		return ((String) getAttrVal("Or_name"));
	}	
	public void setOr_name(String Or_name) {
		setAttrVal("Or_name", Or_name);
	}
	public String getPres_name() {
		return ((String) getAttrVal("Pres_name"));
	}	
	public void setPres_name(String Pres_name) {
		setAttrVal("Pres_name", Pres_name);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}	
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	public String getOrg_mp_name() {
		return ((String) getAttrVal("Org_mp_name"));
	}	
	public void setOrg_mp_name(String Org_mp_name) {
		setAttrVal("Org_mp_name", Org_mp_name);
	}
	public String getDep_mp_name() {
		return ((String) getAttrVal("Dep_mp_name"));
	}	
	public void setDep_mp_name(String Dep_mp_name) {
		setAttrVal("Dep_mp_name", Dep_mp_name);
	}
	public String getSu_bl_name() {
		return ((String) getAttrVal("Su_bl_name"));
	}	
	public void setSu_bl_name(String Su_bl_name) {
		setAttrVal("Su_bl_name", Su_bl_name);
	}
	public String getSu_name() {
		return ((String) getAttrVal("Su_name"));
	}	
	public void setSu_name(String Su_name) {
		setAttrVal("Su_name", Su_name);
	}
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}	
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	public String getReltp_name() {
		return ((String) getAttrVal("Reltp_name"));
	}	
	public void setReltp_name(String Reltp_name) {
		setAttrVal("Reltp_name", Reltp_name);
	}
	public String getOr_rel_name() {
		return ((String) getAttrVal("Or_rel_name"));
	}	
	public void setOr_rel_name(String Or_rel_name) {
		setAttrVal("Or_rel_name", Or_rel_name);
	}
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}	
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	public String getName_researchproject() {
		return ((String) getAttrVal("Name_researchproject"));
	}	
	public void setName_researchproject(String Name_researchproject) {
		setAttrVal("Name_researchproject", Name_researchproject);
	}
	public String getName_antipurpose() {
		return ((String) getAttrVal("Name_antipurpose"));
	}	
	public void setName_antipurpose(String Name_antipurpose) {
		setAttrVal("Name_antipurpose", Name_antipurpose);
	}
	public String getName_prepurpose() {
		return ((String) getAttrVal("Name_prepurpose"));
	}	
	public void setName_prepurpose(String Name_prepurpose) {
		setAttrVal("Name_prepurpose", Name_prepurpose);
	}
	public String getName_preincitp() {
		return ((String) getAttrVal("Name_preincitp"));
	}	
	public void setName_preincitp(String Name_preincitp) {
		setAttrVal("Name_preincitp", Name_preincitp);
	}
	public String getName_nodispense() {
		return ((String) getAttrVal("Name_nodispense"));
	}	
	public void setName_nodispense(String Name_nodispense) {
		setAttrVal("Name_nodispense", Name_nodispense);
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
}