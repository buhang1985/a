package iih.mp.orm.surgappconfirm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surgappconfirm.d.desc.SurgAppConfirmDODesc;
import java.math.BigDecimal;

/**
 * 手术申请单确认 DO数据 
 * 
 */
public class SurgAppConfirmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPCF= "Id_apopcf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_APOP= "Id_apop";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_OR= "Id_or";
	public static final String ID_DI= "Id_di";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DI= "Str_code_di";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String DT_APOP= "Dt_apop";
	public static final String DT_B_PLAN= "Dt_b_plan";
	public static final String DT_E_PLAN= "Dt_e_plan";
	public static final String SUGPLANDATE= "Sugplandate";
	public static final String ID_LVLSUG= "Id_lvlsug";
	public static final String SD_LVLSUG= "Sd_lvlsug";
	public static final String ID_ANESTP= "Id_anestp";
	public static final String SD_ANESTP= "Sd_anestp";
	public static final String ID_INCITP= "Id_incitp";
	public static final String SD_INCITP= "Sd_incitp";
	public static final String ID_INCIHEALTP= "Id_incihealtp";
	public static final String SD_INCIHEALTP= "Sd_incihealtp";
	public static final String ID_SURGICAL_SITE= "Id_surgical_site";
	public static final String SD_SURGICAL_SITE= "Sd_surgical_site";
	public static final String FG_ALLERGY= "Fg_allergy";
	public static final String FG_NEW= "Fg_new";
	public static final String FG_PATHO= "Fg_patho";
	public static final String ID_GRDASPT= "Id_grdaspt";
	public static final String SD_GRDASPT= "Sd_grdaspt";
	public static final String ID_SU_OP= "Id_su_op";
	public static final String SD_SU_OP= "Sd_su_op";
	public static final String ANNOUNCEMENTS= "Announcements";
	public static final String ID_SRV= "Id_srv";
	public static final String QUAN_BT_PALN= "Quan_bt_paln";
	public static final String FG_SELF= "Fg_self";
	public static final String REPLANT= "Replant";
	public static final String ID_SUGBODY= "Id_sugbody";
	public static final String SD_SUGBODY= "Sd_sugbody";
	public static final String ID_SPECIALREQ= "Id_specialreq";
	public static final String ID_SPECIALINSTRUMENT= "Id_specialinstrument";
	public static final String SPECIALDES= "Specialdes";
	public static final String ID_ASA= "Id_asa";
	public static final String SD_ASA= "Sd_asa";
	public static final String FG_ER_SUG= "Fg_er_sug";
	public static final String FG_XQ_SUG= "Fg_xq_sug";
	public static final String FG_ZQ_SUG= "Fg_zq_sug";
	public static final String FG_PRN= "Fg_prn";
	public static final String FG_DAYSUG= "Fg_daysug";
	public static final String ID_DIITMAF= "Id_diitmaf";
	public static final String ID_STATIC= "Id_static";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String ID_OPT= "Id_opt";
	public static final String NUM_OPT= "Num_opt";
	public static final String STAT_APOP= "Stat_apop";
	public static final String ID_DEPT_APP= "Id_dept_app";
	public static final String ID_DEPT_EXEC= "Id_dept_exec";
	public static final String ID_EMP_CONF= "Id_emp_conf";
	public static final String DT_CONF= "Dt_conf";
	public static final String DT_ARV_DCT= "Dt_arv_dct";
	public static final String DT_ARV_PAT= "Dt_arv_pat";
	public static final String DT_LV_PAT= "Dt_lv_pat";
	public static final String DT_ST_ATS= "Dt_st_ats";
	public static final String DT_ED_ATS= "Dt_ed_ats";
	public static final String DT_ST_OP= "Dt_st_op";
	public static final String DT_ED_OP= "Dt_ed_op";
	public static final String FG_PAT_OUT= "Fg_pat_out";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String CODE_ENT= "Code_ent";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE_OR= "Code_or";
	public static final String CONTENT_OR= "Content_or";
	public static final String LVLSUG_CODE= "Lvlsug_code";
	public static final String LVLSUG_NAME= "Lvlsug_name";
	public static final String ANE_CODE= "Ane_code";
	public static final String ANE_NAME= "Ane_name";
	public static final String INCI_CODE= "Inci_code";
	public static final String INCI_NAME= "Inci_name";
	public static final String INCIHEAL_CODE= "Inciheal_code";
	public static final String INCIHEAL_NAME= "Inciheal_name";
	public static final String NAME_SURGICAL_SITE= "Name_surgical_site";
	public static final String CODE_SURGICAL_SITE= "Code_surgical_site";
	public static final String GRDASPT_CODE= "Grdaspt_code";
	public static final String GRDASPT_NAME= "Grdaspt_name";
	public static final String SU_OP_CODE= "Su_op_code";
	public static final String SU_OP_NAME= "Su_op_name";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String SUGBODY_CODE= "Sugbody_code";
	public static final String SUGBODY_NAME= "Sugbody_name";
	public static final String SPECIALREQ_CODE= "Specialreq_code";
	public static final String SPECIALREQ_NAME= "Specialreq_name";
	public static final String SPECIALINSTRUMENT_CODE= "Specialinstrument_code";
	public static final String SPECIALINSTRUMENT_NAME= "Specialinstrument_name";
	public static final String ASA_NAME= "Asa_name";
	public static final String DIAF_CODE= "Diaf_code";
	public static final String DIAF_NAME= "Diaf_name";
	public static final String OPT_CODE= "Opt_code";
	public static final String OPT_NAME= "Opt_name";
	public static final String DEP_APP_CODE= "Dep_app_code";
	public static final String DEP_APP_NAME= "Dep_app_name";
	public static final String DEP_EXEC_CODE= "Dep_exec_code";
	public static final String DEP_EXEC_NAME= "Dep_exec_name";
	public static final String EMP_CONF_CODE= "Emp_conf_code";
	public static final String EMP_CONF_NAME= "Emp_conf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopcf() {
		return ((String) getAttrVal("Id_apopcf"));
	}	
	public void setId_apopcf(String Id_apopcf) {
		setAttrVal("Id_apopcf", Id_apopcf);
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
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}	
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	public FDateTime getDt_apop() {
		return ((FDateTime) getAttrVal("Dt_apop"));
	}	
	public void setDt_apop(FDateTime Dt_apop) {
		setAttrVal("Dt_apop", Dt_apop);
	}
	public FTime getDt_b_plan() {
		return ((FTime) getAttrVal("Dt_b_plan"));
	}	
	public void setDt_b_plan(FTime Dt_b_plan) {
		setAttrVal("Dt_b_plan", Dt_b_plan);
	}
	public FTime getDt_e_plan() {
		return ((FTime) getAttrVal("Dt_e_plan"));
	}	
	public void setDt_e_plan(FTime Dt_e_plan) {
		setAttrVal("Dt_e_plan", Dt_e_plan);
	}
	public FDate getSugplandate() {
		return ((FDate) getAttrVal("Sugplandate"));
	}	
	public void setSugplandate(FDate Sugplandate) {
		setAttrVal("Sugplandate", Sugplandate);
	}
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	public String getId_incihealtp() {
		return ((String) getAttrVal("Id_incihealtp"));
	}	
	public void setId_incihealtp(String Id_incihealtp) {
		setAttrVal("Id_incihealtp", Id_incihealtp);
	}
	public String getSd_incihealtp() {
		return ((String) getAttrVal("Sd_incihealtp"));
	}	
	public void setSd_incihealtp(String Sd_incihealtp) {
		setAttrVal("Sd_incihealtp", Sd_incihealtp);
	}
	public String getId_surgical_site() {
		return ((String) getAttrVal("Id_surgical_site"));
	}	
	public void setId_surgical_site(String Id_surgical_site) {
		setAttrVal("Id_surgical_site", Id_surgical_site);
	}
	public String getSd_surgical_site() {
		return ((String) getAttrVal("Sd_surgical_site"));
	}	
	public void setSd_surgical_site(String Sd_surgical_site) {
		setAttrVal("Sd_surgical_site", Sd_surgical_site);
	}
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	public FBoolean getFg_new() {
		return ((FBoolean) getAttrVal("Fg_new"));
	}	
	public void setFg_new(FBoolean Fg_new) {
		setAttrVal("Fg_new", Fg_new);
	}
	public FBoolean getFg_patho() {
		return ((FBoolean) getAttrVal("Fg_patho"));
	}	
	public void setFg_patho(FBoolean Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	public String getId_grdaspt() {
		return ((String) getAttrVal("Id_grdaspt"));
	}	
	public void setId_grdaspt(String Id_grdaspt) {
		setAttrVal("Id_grdaspt", Id_grdaspt);
	}
	public String getSd_grdaspt() {
		return ((String) getAttrVal("Sd_grdaspt"));
	}	
	public void setSd_grdaspt(String Sd_grdaspt) {
		setAttrVal("Sd_grdaspt", Sd_grdaspt);
	}
	public String getId_su_op() {
		return ((String) getAttrVal("Id_su_op"));
	}	
	public void setId_su_op(String Id_su_op) {
		setAttrVal("Id_su_op", Id_su_op);
	}
	public String getSd_su_op() {
		return ((String) getAttrVal("Sd_su_op"));
	}	
	public void setSd_su_op(String Sd_su_op) {
		setAttrVal("Sd_su_op", Sd_su_op);
	}
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}	
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public FDouble getQuan_bt_paln() {
		return ((FDouble) getAttrVal("Quan_bt_paln"));
	}	
	public void setQuan_bt_paln(FDouble Quan_bt_paln) {
		setAttrVal("Quan_bt_paln", Quan_bt_paln);
	}
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	public String getReplant() {
		return ((String) getAttrVal("Replant"));
	}	
	public void setReplant(String Replant) {
		setAttrVal("Replant", Replant);
	}
	public String getId_sugbody() {
		return ((String) getAttrVal("Id_sugbody"));
	}	
	public void setId_sugbody(String Id_sugbody) {
		setAttrVal("Id_sugbody", Id_sugbody);
	}
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	public String getId_specialreq() {
		return ((String) getAttrVal("Id_specialreq"));
	}	
	public void setId_specialreq(String Id_specialreq) {
		setAttrVal("Id_specialreq", Id_specialreq);
	}
	public String getId_specialinstrument() {
		return ((String) getAttrVal("Id_specialinstrument"));
	}	
	public void setId_specialinstrument(String Id_specialinstrument) {
		setAttrVal("Id_specialinstrument", Id_specialinstrument);
	}
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	public String getId_asa() {
		return ((String) getAttrVal("Id_asa"));
	}	
	public void setId_asa(String Id_asa) {
		setAttrVal("Id_asa", Id_asa);
	}
	public String getSd_asa() {
		return ((String) getAttrVal("Sd_asa"));
	}	
	public void setSd_asa(String Sd_asa) {
		setAttrVal("Sd_asa", Sd_asa);
	}
	public FBoolean getFg_er_sug() {
		return ((FBoolean) getAttrVal("Fg_er_sug"));
	}	
	public void setFg_er_sug(FBoolean Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	public FBoolean getFg_xq_sug() {
		return ((FBoolean) getAttrVal("Fg_xq_sug"));
	}	
	public void setFg_xq_sug(FBoolean Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	public FBoolean getFg_zq_sug() {
		return ((FBoolean) getAttrVal("Fg_zq_sug"));
	}	
	public void setFg_zq_sug(FBoolean Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	public FBoolean getFg_daysug() {
		return ((FBoolean) getAttrVal("Fg_daysug"));
	}	
	public void setFg_daysug(FBoolean Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	public String getId_diitmaf() {
		return ((String) getAttrVal("Id_diitmaf"));
	}	
	public void setId_diitmaf(String Id_diitmaf) {
		setAttrVal("Id_diitmaf", Id_diitmaf);
	}
	public String getId_static() {
		return ((String) getAttrVal("Id_static"));
	}	
	public void setId_static(String Id_static) {
		setAttrVal("Id_static", Id_static);
	}
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public String getNum_opt() {
		return ((String) getAttrVal("Num_opt"));
	}	
	public void setNum_opt(String Num_opt) {
		setAttrVal("Num_opt", Num_opt);
	}
	public FBoolean getStat_apop() {
		return ((FBoolean) getAttrVal("Stat_apop"));
	}	
	public void setStat_apop(FBoolean Stat_apop) {
		setAttrVal("Stat_apop", Stat_apop);
	}
	public String getId_dept_app() {
		return ((String) getAttrVal("Id_dept_app"));
	}	
	public void setId_dept_app(String Id_dept_app) {
		setAttrVal("Id_dept_app", Id_dept_app);
	}
	public String getId_dept_exec() {
		return ((String) getAttrVal("Id_dept_exec"));
	}	
	public void setId_dept_exec(String Id_dept_exec) {
		setAttrVal("Id_dept_exec", Id_dept_exec);
	}
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	public FDateTime getDt_arv_dct() {
		return ((FDateTime) getAttrVal("Dt_arv_dct"));
	}	
	public void setDt_arv_dct(FDateTime Dt_arv_dct) {
		setAttrVal("Dt_arv_dct", Dt_arv_dct);
	}
	public FDateTime getDt_arv_pat() {
		return ((FDateTime) getAttrVal("Dt_arv_pat"));
	}	
	public void setDt_arv_pat(FDateTime Dt_arv_pat) {
		setAttrVal("Dt_arv_pat", Dt_arv_pat);
	}
	public FDateTime getDt_lv_pat() {
		return ((FDateTime) getAttrVal("Dt_lv_pat"));
	}	
	public void setDt_lv_pat(FDateTime Dt_lv_pat) {
		setAttrVal("Dt_lv_pat", Dt_lv_pat);
	}
	public FDateTime getDt_st_ats() {
		return ((FDateTime) getAttrVal("Dt_st_ats"));
	}	
	public void setDt_st_ats(FDateTime Dt_st_ats) {
		setAttrVal("Dt_st_ats", Dt_st_ats);
	}
	public FDateTime getDt_ed_ats() {
		return ((FDateTime) getAttrVal("Dt_ed_ats"));
	}	
	public void setDt_ed_ats(FDateTime Dt_ed_ats) {
		setAttrVal("Dt_ed_ats", Dt_ed_ats);
	}
	public FDateTime getDt_st_op() {
		return ((FDateTime) getAttrVal("Dt_st_op"));
	}	
	public void setDt_st_op(FDateTime Dt_st_op) {
		setAttrVal("Dt_st_op", Dt_st_op);
	}
	public FDateTime getDt_ed_op() {
		return ((FDateTime) getAttrVal("Dt_ed_op"));
	}	
	public void setDt_ed_op(FDateTime Dt_ed_op) {
		setAttrVal("Dt_ed_op", Dt_ed_op);
	}
	public FBoolean getFg_pat_out() {
		return ((FBoolean) getAttrVal("Fg_pat_out"));
	}	
	public void setFg_pat_out(FBoolean Fg_pat_out) {
		setAttrVal("Fg_pat_out", Fg_pat_out);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	public String getLvlsug_code() {
		return ((String) getAttrVal("Lvlsug_code"));
	}	
	public void setLvlsug_code(String Lvlsug_code) {
		setAttrVal("Lvlsug_code", Lvlsug_code);
	}
	public String getLvlsug_name() {
		return ((String) getAttrVal("Lvlsug_name"));
	}	
	public void setLvlsug_name(String Lvlsug_name) {
		setAttrVal("Lvlsug_name", Lvlsug_name);
	}
	public String getAne_code() {
		return ((String) getAttrVal("Ane_code"));
	}	
	public void setAne_code(String Ane_code) {
		setAttrVal("Ane_code", Ane_code);
	}
	public String getAne_name() {
		return ((String) getAttrVal("Ane_name"));
	}	
	public void setAne_name(String Ane_name) {
		setAttrVal("Ane_name", Ane_name);
	}
	public String getInci_code() {
		return ((String) getAttrVal("Inci_code"));
	}	
	public void setInci_code(String Inci_code) {
		setAttrVal("Inci_code", Inci_code);
	}
	public String getInci_name() {
		return ((String) getAttrVal("Inci_name"));
	}	
	public void setInci_name(String Inci_name) {
		setAttrVal("Inci_name", Inci_name);
	}
	public String getInciheal_code() {
		return ((String) getAttrVal("Inciheal_code"));
	}	
	public void setInciheal_code(String Inciheal_code) {
		setAttrVal("Inciheal_code", Inciheal_code);
	}
	public String getInciheal_name() {
		return ((String) getAttrVal("Inciheal_name"));
	}	
	public void setInciheal_name(String Inciheal_name) {
		setAttrVal("Inciheal_name", Inciheal_name);
	}
	public String getName_surgical_site() {
		return ((String) getAttrVal("Name_surgical_site"));
	}	
	public void setName_surgical_site(String Name_surgical_site) {
		setAttrVal("Name_surgical_site", Name_surgical_site);
	}
	public String getCode_surgical_site() {
		return ((String) getAttrVal("Code_surgical_site"));
	}	
	public void setCode_surgical_site(String Code_surgical_site) {
		setAttrVal("Code_surgical_site", Code_surgical_site);
	}
	public String getGrdaspt_code() {
		return ((String) getAttrVal("Grdaspt_code"));
	}	
	public void setGrdaspt_code(String Grdaspt_code) {
		setAttrVal("Grdaspt_code", Grdaspt_code);
	}
	public String getGrdaspt_name() {
		return ((String) getAttrVal("Grdaspt_name"));
	}	
	public void setGrdaspt_name(String Grdaspt_name) {
		setAttrVal("Grdaspt_name", Grdaspt_name);
	}
	public String getSu_op_code() {
		return ((String) getAttrVal("Su_op_code"));
	}	
	public void setSu_op_code(String Su_op_code) {
		setAttrVal("Su_op_code", Su_op_code);
	}
	public String getSu_op_name() {
		return ((String) getAttrVal("Su_op_name"));
	}	
	public void setSu_op_name(String Su_op_name) {
		setAttrVal("Su_op_name", Su_op_name);
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
	public String getSugbody_code() {
		return ((String) getAttrVal("Sugbody_code"));
	}	
	public void setSugbody_code(String Sugbody_code) {
		setAttrVal("Sugbody_code", Sugbody_code);
	}
	public String getSugbody_name() {
		return ((String) getAttrVal("Sugbody_name"));
	}	
	public void setSugbody_name(String Sugbody_name) {
		setAttrVal("Sugbody_name", Sugbody_name);
	}
	public String getSpecialreq_code() {
		return ((String) getAttrVal("Specialreq_code"));
	}	
	public void setSpecialreq_code(String Specialreq_code) {
		setAttrVal("Specialreq_code", Specialreq_code);
	}
	public String getSpecialreq_name() {
		return ((String) getAttrVal("Specialreq_name"));
	}	
	public void setSpecialreq_name(String Specialreq_name) {
		setAttrVal("Specialreq_name", Specialreq_name);
	}
	public String getSpecialinstrument_code() {
		return ((String) getAttrVal("Specialinstrument_code"));
	}	
	public void setSpecialinstrument_code(String Specialinstrument_code) {
		setAttrVal("Specialinstrument_code", Specialinstrument_code);
	}
	public String getSpecialinstrument_name() {
		return ((String) getAttrVal("Specialinstrument_name"));
	}	
	public void setSpecialinstrument_name(String Specialinstrument_name) {
		setAttrVal("Specialinstrument_name", Specialinstrument_name);
	}
	public String getAsa_name() {
		return ((String) getAttrVal("Asa_name"));
	}	
	public void setAsa_name(String Asa_name) {
		setAttrVal("Asa_name", Asa_name);
	}
	public String getDiaf_code() {
		return ((String) getAttrVal("Diaf_code"));
	}	
	public void setDiaf_code(String Diaf_code) {
		setAttrVal("Diaf_code", Diaf_code);
	}
	public String getDiaf_name() {
		return ((String) getAttrVal("Diaf_name"));
	}	
	public void setDiaf_name(String Diaf_name) {
		setAttrVal("Diaf_name", Diaf_name);
	}
	public String getOpt_code() {
		return ((String) getAttrVal("Opt_code"));
	}	
	public void setOpt_code(String Opt_code) {
		setAttrVal("Opt_code", Opt_code);
	}
	public String getOpt_name() {
		return ((String) getAttrVal("Opt_name"));
	}	
	public void setOpt_name(String Opt_name) {
		setAttrVal("Opt_name", Opt_name);
	}
	public String getDep_app_code() {
		return ((String) getAttrVal("Dep_app_code"));
	}	
	public void setDep_app_code(String Dep_app_code) {
		setAttrVal("Dep_app_code", Dep_app_code);
	}
	public String getDep_app_name() {
		return ((String) getAttrVal("Dep_app_name"));
	}	
	public void setDep_app_name(String Dep_app_name) {
		setAttrVal("Dep_app_name", Dep_app_name);
	}
	public String getDep_exec_code() {
		return ((String) getAttrVal("Dep_exec_code"));
	}	
	public void setDep_exec_code(String Dep_exec_code) {
		setAttrVal("Dep_exec_code", Dep_exec_code);
	}
	public String getDep_exec_name() {
		return ((String) getAttrVal("Dep_exec_name"));
	}	
	public void setDep_exec_name(String Dep_exec_name) {
		setAttrVal("Dep_exec_name", Dep_exec_name);
	}
	public String getEmp_conf_code() {
		return ((String) getAttrVal("Emp_conf_code"));
	}	
	public void setEmp_conf_code(String Emp_conf_code) {
		setAttrVal("Emp_conf_code", Emp_conf_code);
	}
	public String getEmp_conf_name() {
		return ((String) getAttrVal("Emp_conf_name"));
	}	
	public void setEmp_conf_name(String Emp_conf_name) {
		setAttrVal("Emp_conf_name", Emp_conf_name);
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
		return "Id_apopcf";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_ORM_APP_SUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgAppConfirmDODesc.class);
	}
	
}