package iih.mp.dg.oepdgappdt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.oepdgappdt.d.desc.OepDgAppDtDODesc;
import java.math.BigDecimal;

/**
 * 药品门诊请领 DO数据 
 * 
 */
public class OepDgAppDtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOEPDT= "Id_dgoepdt";
	public static final String ID_CGOEPITM= "Id_cgoepitm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_PRESTP= "Id_prestp";
	public static final String SD_PRESTP= "Sd_prestp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PRES= "Id_pres";
	public static final String CODE_PRES= "Code_pres";
	public static final String NAME_PRES= "Name_pres";
	public static final String ID_OR= "Id_or";
	public static final String SORTNO= "Sortno";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String FG_MM= "Fg_mm";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String CODE_MM= "Code_mm";
	public static final String NAME_MM= "Name_mm";
	public static final String CODE_BATCH= "Code_batch";
	public static final String ID_PKGU_BASE= "Id_pkgu_base";
	public static final String ID_PKGU_CUR= "Id_pkgu_cur";
	public static final String FACTOR= "Factor";
	public static final String QUAN_BASE= "Quan_base";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String PRICE= "Price";
	public static final String QUAN_OR= "Quan_or";
	public static final String QUAN= "Quan";
	public static final String QUAN_PAIR_MP= "Quan_pair_mp";
	public static final String QUAN_MP= "Quan_mp";
	public static final String QUAN_PAIR_BK= "Quan_pair_bk";
	public static final String QUAN_BK= "Quan_bk";
	public static final String AMT_STD= "Amt_std";
	public static final String AMT= "Amt";
	public static final String QUAN_MEDU= "Quan_medu";
	public static final String ID_UNIT_MEDU= "Id_unit_medu";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String ID_FREQ= "Id_freq";
	public static final String FG_BOIL= "Fg_boil";
	public static final String QUAN_ORDERS_BOIL= "Quan_orders_boil";
	public static final String DT_OR= "Dt_or";
	public static final String ID_ORG_OR= "Id_org_or";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_EMP_OR= "Id_emp_or";
	public static final String ID_ORG_MP= "Id_org_mp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_QUESITE_PL= "Id_quesite_pl";
	public static final String EU_SU_MP= "Eu_su_mp";
	public static final String FG_BY= "Fg_by";
	public static final String DT_BL= "Dt_bl";
	public static final String DT_ST= "Dt_st";
	public static final String FG_OTC= "Fg_otc";
	public static final String ID_VAL= "Id_val";
	public static final String SD_VAL= "Sd_val";
	public static final String ID_ST= "Id_st";
	public static final String CHARACTER= "Character";
	public static final String ONLYCODE= "Onlycode";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_JY_FIN= "Fg_jy_fin";
	public static final String FG_INFU_REG= "Fg_infu_reg";
	public static final String ORG_NAME= "Org_name";
	public static final String ORG_CODE= "Org_code";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String ENTP_CODE= "Entp_code";
	public static final String ENTP_NAME= "Entp_name";
	public static final String ENTP_DES= "Entp_des";
	public static final String PRES_CODE= "Pres_code";
	public static final String PRES_NAME= "Pres_name";
	public static final String NAME_OR= "Name_or";
	public static final String DES_OR= "Des_or";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String UNIT_BASE_CODE= "Unit_base_code";
	public static final String UNIT_BASE_NAME= "Unit_base_name";
	public static final String UNIT_CUR_CODE= "Unit_cur_code";
	public static final String UNIT_CUR_NAME= "Unit_cur_name";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ROUTE_CODE= "Route_code";
	public static final String ROUTE_NAME= "Route_name";
	public static final String ROUTEDES_CODE= "Routedes_code";
	public static final String ROUTEDES_NAME= "Routedes_name";
	public static final String BOIL_CODE= "Boil_code";
	public static final String BOIL_NAME= "Boil_name";
	public static final String BOILDES_CODE= "Boildes_code";
	public static final String BOILDES_NAME= "Boildes_name";
	public static final String FREQ_CODE= "Freq_code";
	public static final String FREQ_NAME= "Freq_name";
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	public static final String FREQUNITCT= "Frequnitct";
	public static final String FG_LONG= "Fg_long";
	public static final String FREQ_DES= "Freq_des";
	public static final String ORG_OR_CODE= "Org_or_code";
	public static final String ORG_OR_NAME= "Org_or_name";
	public static final String DEP_OR_CODE= "Dep_or_code";
	public static final String DEP_OR_NAME= "Dep_or_name";
	public static final String EMP_OR_CODE= "Emp_or_code";
	public static final String EMP_OR_NAME= "Emp_or_name";
	public static final String ORG_MP_NAME= "Org_mp_name";
	public static final String INNERCODE= "Innercode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgoepdt() {
		return ((String) getAttrVal("Id_dgoepdt"));
	}	
	public void setId_dgoepdt(String Id_dgoepdt) {
		setAttrVal("Id_dgoepdt", Id_dgoepdt);
	}
	public String getId_cgoepitm() {
		return ((String) getAttrVal("Id_cgoepitm"));
	}	
	public void setId_cgoepitm(String Id_cgoepitm) {
		setAttrVal("Id_cgoepitm", Id_cgoepitm);
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
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}	
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}	
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}	
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getCode_batch() {
		return ((String) getAttrVal("Code_batch"));
	}	
	public void setCode_batch(String Code_batch) {
		setAttrVal("Code_batch", Code_batch);
	}
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}	
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}	
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}	
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}	
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public Integer getQuan_pair_mp() {
		return ((Integer) getAttrVal("Quan_pair_mp"));
	}	
	public void setQuan_pair_mp(Integer Quan_pair_mp) {
		setAttrVal("Quan_pair_mp", Quan_pair_mp);
	}
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}	
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	public Integer getQuan_pair_bk() {
		return ((Integer) getAttrVal("Quan_pair_bk"));
	}	
	public void setQuan_pair_bk(Integer Quan_pair_bk) {
		setAttrVal("Quan_pair_bk", Quan_pair_bk);
	}
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	public String getId_unit_medu() {
		return ((String) getAttrVal("Id_unit_medu"));
	}	
	public void setId_unit_medu(String Id_unit_medu) {
		setAttrVal("Id_unit_medu", Id_unit_medu);
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
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	public Integer getQuan_orders_boil() {
		return ((Integer) getAttrVal("Quan_orders_boil"));
	}	
	public void setQuan_orders_boil(Integer Quan_orders_boil) {
		setAttrVal("Quan_orders_boil", Quan_orders_boil);
	}
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}	
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}	
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
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
	public String getId_quesite_pl() {
		return ((String) getAttrVal("Id_quesite_pl"));
	}	
	public void setId_quesite_pl(String Id_quesite_pl) {
		setAttrVal("Id_quesite_pl", Id_quesite_pl);
	}
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}	
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	public FBoolean getFg_by() {
		return ((FBoolean) getAttrVal("Fg_by"));
	}	
	public void setFg_by(FBoolean Fg_by) {
		setAttrVal("Fg_by", Fg_by);
	}
	public FDateTime getDt_bl() {
		return ((FDateTime) getAttrVal("Dt_bl"));
	}	
	public void setDt_bl(FDateTime Dt_bl) {
		setAttrVal("Dt_bl", Dt_bl);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}	
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}	
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}	
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}	
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public FBoolean getFg_jy_fin() {
		return ((FBoolean) getAttrVal("Fg_jy_fin"));
	}	
	public void setFg_jy_fin(FBoolean Fg_jy_fin) {
		setAttrVal("Fg_jy_fin", Fg_jy_fin);
	}
	public FBoolean getFg_infu_reg() {
		return ((FBoolean) getAttrVal("Fg_infu_reg"));
	}	
	public void setFg_infu_reg(FBoolean Fg_infu_reg) {
		setAttrVal("Fg_infu_reg", Fg_infu_reg);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getEntp_des() {
		return ((String) getAttrVal("Entp_des"));
	}	
	public void setEntp_des(String Entp_des) {
		setAttrVal("Entp_des", Entp_des);
	}
	public String getPres_code() {
		return ((String) getAttrVal("Pres_code"));
	}	
	public void setPres_code(String Pres_code) {
		setAttrVal("Pres_code", Pres_code);
	}
	public String getPres_name() {
		return ((String) getAttrVal("Pres_name"));
	}	
	public void setPres_name(String Pres_name) {
		setAttrVal("Pres_name", Pres_name);
	}
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getUnit_base_code() {
		return ((String) getAttrVal("Unit_base_code"));
	}	
	public void setUnit_base_code(String Unit_base_code) {
		setAttrVal("Unit_base_code", Unit_base_code);
	}
	public String getUnit_base_name() {
		return ((String) getAttrVal("Unit_base_name"));
	}	
	public void setUnit_base_name(String Unit_base_name) {
		setAttrVal("Unit_base_name", Unit_base_name);
	}
	public String getUnit_cur_code() {
		return ((String) getAttrVal("Unit_cur_code"));
	}	
	public void setUnit_cur_code(String Unit_cur_code) {
		setAttrVal("Unit_cur_code", Unit_cur_code);
	}
	public String getUnit_cur_name() {
		return ((String) getAttrVal("Unit_cur_name"));
	}	
	public void setUnit_cur_name(String Unit_cur_name) {
		setAttrVal("Unit_cur_name", Unit_cur_name);
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
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	public String getRoutedes_code() {
		return ((String) getAttrVal("Routedes_code"));
	}	
	public void setRoutedes_code(String Routedes_code) {
		setAttrVal("Routedes_code", Routedes_code);
	}
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	public String getBoil_code() {
		return ((String) getAttrVal("Boil_code"));
	}	
	public void setBoil_code(String Boil_code) {
		setAttrVal("Boil_code", Boil_code);
	}
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
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
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	public String getFreq_des() {
		return ((String) getAttrVal("Freq_des"));
	}	
	public void setFreq_des(String Freq_des) {
		setAttrVal("Freq_des", Freq_des);
	}
	public String getOrg_or_code() {
		return ((String) getAttrVal("Org_or_code"));
	}	
	public void setOrg_or_code(String Org_or_code) {
		setAttrVal("Org_or_code", Org_or_code);
	}
	public String getOrg_or_name() {
		return ((String) getAttrVal("Org_or_name"));
	}	
	public void setOrg_or_name(String Org_or_name) {
		setAttrVal("Org_or_name", Org_or_name);
	}
	public String getDep_or_code() {
		return ((String) getAttrVal("Dep_or_code"));
	}	
	public void setDep_or_code(String Dep_or_code) {
		setAttrVal("Dep_or_code", Dep_or_code);
	}
	public String getDep_or_name() {
		return ((String) getAttrVal("Dep_or_name"));
	}	
	public void setDep_or_name(String Dep_or_name) {
		setAttrVal("Dep_or_name", Dep_or_name);
	}
	public String getEmp_or_code() {
		return ((String) getAttrVal("Emp_or_code"));
	}	
	public void setEmp_or_code(String Emp_or_code) {
		setAttrVal("Emp_or_code", Emp_or_code);
	}
	public String getEmp_or_name() {
		return ((String) getAttrVal("Emp_or_name"));
	}	
	public void setEmp_or_name(String Emp_or_name) {
		setAttrVal("Emp_or_name", Emp_or_name);
	}
	public String getOrg_mp_name() {
		return ((String) getAttrVal("Org_mp_name"));
	}	
	public void setOrg_mp_name(String Org_mp_name) {
		setAttrVal("Org_mp_name", Org_mp_name);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
		return "Id_dgoepdt";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_OEP_DT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OepDgAppDtDODesc.class);
	}
	
}