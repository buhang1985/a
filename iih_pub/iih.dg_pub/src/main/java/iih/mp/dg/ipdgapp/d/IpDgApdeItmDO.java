package iih.mp.dg.ipdgapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.ipdgapp.d.desc.IpDgApdeItmDODesc;
import java.math.BigDecimal;

/**
 * 住院药品请领发放明细 DO数据 
 * 
 */
public class IpDgApdeItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGIPDT= "Id_dgipdt";
	public static final String ID_DGIPAP= "Id_dgipap";
	public static final String ID_DGIPDE= "Id_dgipde";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_OR= "Id_or";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String FG_MM= "Fg_mm";
	public static final String ID_UNIT_SRV= "Id_unit_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String CHARACTER= "Character";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String CODE_MM= "Code_mm";
	public static final String ONLYCODE= "Onlycode";
	public static final String NAME_MM= "Name_mm";
	public static final String BATCHNO= "Batchno";
	public static final String ID_PKGU_BASE= "Id_pkgu_base";
	public static final String ID_PKGU_CUR= "Id_pkgu_cur";
	public static final String FACTOR= "Factor";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String PRI_PO= "Pri_po";
	public static final String PRICE= "Price";
	public static final String QUAN_AP= "Quan_ap";
	public static final String AMT= "Amt";
	public static final String ID_UNIT_MED= "Id_unit_med";
	public static final String QUAN_MED= "Quan_med";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_ROUTEDES= "Id_routedes";
	public static final String FG_BOIL= "Fg_boil";
	public static final String ID_BOIL= "Id_boil";
	public static final String ID_BOILDES= "Id_boildes";
	public static final String ID_FREQ= "Id_freq";
	public static final String FG_LONG= "Fg_long";
	public static final String FG_PRES_OUTTP= "Fg_pres_outtp";
	public static final String FG_WHOLEPACK= "Fg_wholepack";
	//退药医嘱标识
	public static final String FG_OR_BACK= "Fg_or_back";
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	public static final String ORDERS_OR= "Orders_or";
	public static final String ORDERS_BOIL= "Orders_boil";
	public static final String AMT_STD= "Amt_std";
	public static final String DT_OR= "Dt_or";
	public static final String ID_ORG_OR= "Id_org_or";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_EMP_OR= "Id_emp_or";
	public static final String ID_ORG_MP= "Id_org_mp";
	public static final String ID_DEP_WH= "Id_dep_wh";
	public static final String FG_BB= "Fg_bb";
	public static final String NO_BB= "No_bb";
	public static final String QUAN_MP= "Quan_mp";
	public static final String QUAN_BK= "Quan_bk";
	public static final String ID_IPCG_REL= "Id_ipcg_rel";
	public static final String EU_SU_MP= "Eu_su_mp";
	public static final String ID_EMP_DISPENSE= "Id_emp_dispense";
	public static final String EU_CG_BL= "Eu_cg_bl";
	public static final String ID_IPCG= "Id_ipcg";
	public static final String DT_BL= "Dt_bl";
	public static final String DT_ST= "Dt_st";
	public static final String FG_OTC= "Fg_otc";
	public static final String ID_VAL= "Id_val";
	public static final String SD_VAL= "Sd_val";
	public static final String CODE_DGIPAP= "Code_dgipap";
	public static final String NOTE= "Note";
        //减免标识
	public static final String FG_FREE= "Fg_free";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String QUAN_NUM_BASE= "Quan_num_base";
	public static final String QUAN_DEN_BASE= "Quan_den_base";
	public static final String ID_OUT= "Id_out";
	public static final String DT_MM_OUT_CONF= "Dt_mm_out_conf";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_PKGU_AP= "Id_pkgu_ap";
	public static final String FACTOR_MB= "Factor_mb";
	public static final String PKUROUNDMODE= "Pkuroundmode";
	public static final String QUAN_ADD_MED= "Quan_add_med";
	public static final String EN_OPAP= "En_opap";
	public static final String EN_OPDE= "En_opde";
	public static final String FG_INVALID= "Fg_invalid";
	//需退药标识
	public static final String FG_NEED_OPBK= "Fg_need_opbk";
	public static final String FG_BASE= "Fg_base";
	public static final String ID_OUT_KEY= "Id_out_key";
	public static final String ID_OR_PR_SRV= "Id_or_pr_srv";
	public static final String SPEC= "Spec";
	public static final String ID_DGPRESST= "Id_dgpresst";
	public static final String ID_DGIPDT_RET= "Id_dgipdt_ret";
	//退药医嘱主键
	public static final String ID_OR_BACK= "Id_or_back";
	//退药医嘱服务执行点主键
	public static final String ID_OR_PR_SRV_BACK= "Id_or_pr_srv_back";
	//退药医嘱计划执行时间
	public static final String DT_MP_PLAN_BACK= "Dt_mp_plan_back";
	public static final String ID_OR_PR_SRV_CG= "Id_or_pr_srv_cg";
	public static final String ID_FDDGIPAP= "Id_fddgipap";
	public static final String SD_FDDGIPAP= "Sd_fddgipap";
	public static final String EN_SEND= "En_send";
	public static final String ID_CHKTYPE= "Id_chktype";
	public static final String SD_CHKTYPE= "Sd_chktype";
	public static final String FG_IP= "Fg_ip";
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	public static final String SD_SU_BL= "Sd_su_bl";
	public static final String FDDGIPAP_CODE= "Fddgipap_code";
	public static final String FDDGIPAP_NAME= "Fddgipap_name";
	public static final String CHKTYPE_CODE= "Chktype_code";
	public static final String CHKTYPE_NAME= "Chktype_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgipdt() {
		return ((String) getAttrVal("Id_dgipdt"));
	}	
	public void setId_dgipdt(String Id_dgipdt) {
		setAttrVal("Id_dgipdt", Id_dgipdt);
	}
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}	
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
	}
	public String getId_dgipde() {
		return ((String) getAttrVal("Id_dgipde"));
	}	
	public void setId_dgipde(String Id_dgipde) {
		setAttrVal("Id_dgipde", Id_dgipde);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	public String getId_unit_srv() {
		return ((String) getAttrVal("Id_unit_srv"));
	}	
	public void setId_unit_srv(String Id_unit_srv) {
		setAttrVal("Id_unit_srv", Id_unit_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}	
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
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
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getBatchno() {
		return ((String) getAttrVal("Batchno"));
	}	
	public void setBatchno(String Batchno) {
		setAttrVal("Batchno", Batchno);
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
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public FDouble getPri_po() {
		return ((FDouble) getAttrVal("Pri_po"));
	}	
	public void setPri_po(FDouble Pri_po) {
		setAttrVal("Pri_po", Pri_po);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public FDouble getQuan_ap() {
		return ((FDouble) getAttrVal("Quan_ap"));
	}	
	public void setQuan_ap(FDouble Quan_ap) {
		setAttrVal("Quan_ap", Quan_ap);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
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
	public String getFg_boil() {
		return ((String) getAttrVal("Fg_boil"));
	}	
	public void setFg_boil(String Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
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
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	public FBoolean getFg_pres_outtp() {
		return ((FBoolean) getAttrVal("Fg_pres_outtp"));
	}	
	public void setFg_pres_outtp(FBoolean Fg_pres_outtp) {
		setAttrVal("Fg_pres_outtp", Fg_pres_outtp);
	}
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 退药医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_back() {
		return ((FBoolean) getAttrVal("Fg_or_back"));
	}	
	/**
	 * 退药医嘱标识
	 * @param Fg_or_back
	 */
	public void setFg_or_back(FBoolean Fg_or_back) {
		setAttrVal("Fg_or_back", Fg_or_back);
	}
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	public Integer getOrders_or() {
		return ((Integer) getAttrVal("Orders_or"));
	}	
	public void setOrders_or(Integer Orders_or) {
		setAttrVal("Orders_or", Orders_or);
	}
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
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
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}	
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	public String getId_ipcg_rel() {
		return ((String) getAttrVal("Id_ipcg_rel"));
	}	
	public void setId_ipcg_rel(String Id_ipcg_rel) {
		setAttrVal("Id_ipcg_rel", Id_ipcg_rel);
	}
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}	
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	public String getId_emp_dispense() {
		return ((String) getAttrVal("Id_emp_dispense"));
	}	
	public void setId_emp_dispense(String Id_emp_dispense) {
		setAttrVal("Id_emp_dispense", Id_emp_dispense);
	}
	public Integer getEu_cg_bl() {
		return ((Integer) getAttrVal("Eu_cg_bl"));
	}	
	public void setEu_cg_bl(Integer Eu_cg_bl) {
		setAttrVal("Eu_cg_bl", Eu_cg_bl);
	}
	public String getId_ipcg() {
		return ((String) getAttrVal("Id_ipcg"));
	}	
	public void setId_ipcg(String Id_ipcg) {
		setAttrVal("Id_ipcg", Id_ipcg);
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
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}	
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
        /**
	 * 减免标识
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}	
	/**
	 * 减免标识
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
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
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}	
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}	
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	public FDateTime getDt_mm_out_conf() {
		return ((FDateTime) getAttrVal("Dt_mm_out_conf"));
	}	
	public void setDt_mm_out_conf(FDateTime Dt_mm_out_conf) {
		setAttrVal("Dt_mm_out_conf", Dt_mm_out_conf);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_pkgu_ap() {
		return ((String) getAttrVal("Id_pkgu_ap"));
	}	
	public void setId_pkgu_ap(String Id_pkgu_ap) {
		setAttrVal("Id_pkgu_ap", Id_pkgu_ap);
	}
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	public String getPkuroundmode() {
		return ((String) getAttrVal("Pkuroundmode"));
	}	
	public void setPkuroundmode(String Pkuroundmode) {
		setAttrVal("Pkuroundmode", Pkuroundmode);
	}
	public FDouble getQuan_add_med() {
		return ((FDouble) getAttrVal("Quan_add_med"));
	}	
	public void setQuan_add_med(FDouble Quan_add_med) {
		setAttrVal("Quan_add_med", Quan_add_med);
	}
	public Integer getEn_opap() {
		return ((Integer) getAttrVal("En_opap"));
	}	
	public void setEn_opap(Integer En_opap) {
		setAttrVal("En_opap", En_opap);
	}
	public Integer getEn_opde() {
		return ((Integer) getAttrVal("En_opde"));
	}	
	public void setEn_opde(Integer En_opde) {
		setAttrVal("En_opde", En_opde);
	}
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}	
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
	}
	/**
	 * 需退药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_need_opbk() {
		return ((FBoolean) getAttrVal("Fg_need_opbk"));
	}	
	/**
	 * 需退药标识
	 * @param Fg_need_opbk
	 */
	public void setFg_need_opbk(FBoolean Fg_need_opbk) {
		setAttrVal("Fg_need_opbk", Fg_need_opbk);
	}
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	public String getId_out_key() {
		return ((String) getAttrVal("Id_out_key"));
	}	
	public void setId_out_key(String Id_out_key) {
		setAttrVal("Id_out_key", Id_out_key);
	}
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}	
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}	
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	public String getId_dgipdt_ret() {
		return ((String) getAttrVal("Id_dgipdt_ret"));
	}	
	public void setId_dgipdt_ret(String Id_dgipdt_ret) {
		setAttrVal("Id_dgipdt_ret", Id_dgipdt_ret);
	}
	/**
	 * 退药医嘱主键
	 * @return String
	 */
	public String getId_or_back() {
		return ((String) getAttrVal("Id_or_back"));
	}	
	/**
	 * 退药医嘱主键
	 * @param Id_or_back
	 */
	public void setId_or_back(String Id_or_back) {
		setAttrVal("Id_or_back", Id_or_back);
	}
	/**
	 * 退药医嘱服务执行点主键
	 * @return String
	 */
	public String getId_or_pr_srv_back() {
		return ((String) getAttrVal("Id_or_pr_srv_back"));
	}	
	/**
	 * 退药医嘱服务执行点主键
	 * @param Id_or_pr_srv_back
	 */
	public void setId_or_pr_srv_back(String Id_or_pr_srv_back) {
		setAttrVal("Id_or_pr_srv_back", Id_or_pr_srv_back);
	}
	/**
	 * 退药医嘱计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan_back() {
		return ((FDateTime) getAttrVal("Dt_mp_plan_back"));
	}	
	/**
	 * 退药医嘱计划执行时间
	 * @param Dt_mp_plan_back
	 */
	public void setDt_mp_plan_back(FDateTime Dt_mp_plan_back) {
		setAttrVal("Dt_mp_plan_back", Dt_mp_plan_back);
	}
	public String getId_or_pr_srv_cg() {
		return ((String) getAttrVal("Id_or_pr_srv_cg"));
	}	
	public void setId_or_pr_srv_cg(String Id_or_pr_srv_cg) {
		setAttrVal("Id_or_pr_srv_cg", Id_or_pr_srv_cg);
	}
	public String getId_fddgipap() {
		return ((String) getAttrVal("Id_fddgipap"));
	}	
	public void setId_fddgipap(String Id_fddgipap) {
		setAttrVal("Id_fddgipap", Id_fddgipap);
	}
	public String getSd_fddgipap() {
		return ((String) getAttrVal("Sd_fddgipap"));
	}	
	public void setSd_fddgipap(String Sd_fddgipap) {
		setAttrVal("Sd_fddgipap", Sd_fddgipap);
	}
	public Integer getEn_send() {
		return ((Integer) getAttrVal("En_send"));
	}	
	public void setEn_send(Integer En_send) {
		setAttrVal("En_send", En_send);
	}
	public String getId_chktype() {
		return ((String) getAttrVal("Id_chktype"));
	}	
	public void setId_chktype(String Id_chktype) {
		setAttrVal("Id_chktype", Id_chktype);
	}
	public String getSd_chktype() {
		return ((String) getAttrVal("Sd_chktype"));
	}	
	public void setSd_chktype(String Sd_chktype) {
		setAttrVal("Sd_chktype", Sd_chktype);
	}
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	public String getFddgipap_code() {
		return ((String) getAttrVal("Fddgipap_code"));
	}	
	public void setFddgipap_code(String Fddgipap_code) {
		setAttrVal("Fddgipap_code", Fddgipap_code);
	}
	public String getFddgipap_name() {
		return ((String) getAttrVal("Fddgipap_name"));
	}	
	public void setFddgipap_name(String Fddgipap_name) {
		setAttrVal("Fddgipap_name", Fddgipap_name);
	}
	public String getChktype_code() {
		return ((String) getAttrVal("Chktype_code"));
	}	
	public void setChktype_code(String Chktype_code) {
		setAttrVal("Chktype_code", Chktype_code);
	}
	public String getChktype_name() {
		return ((String) getAttrVal("Chktype_name"));
	}	
	public void setChktype_name(String Chktype_name) {
		setAttrVal("Chktype_name", Chktype_name);
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
		return "Id_dgipdt";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_ip_apde_dt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IpDgApdeItmDODesc.class);
	}
	
}