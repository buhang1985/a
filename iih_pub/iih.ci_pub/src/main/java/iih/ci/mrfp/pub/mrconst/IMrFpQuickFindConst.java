package iih.ci.mrfp.pub.mrconst;

/**
 * 病案首页快速查询-常量维护文件
 * @author YanSu
 */
public class IMrFpQuickFindConst {
	
	// ci_mr_fp所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpArr = new String[] {
		"id_mrfp", "id_org", "id_grp", "sd_mrfptp", "id_pat", "id_ent", "createdtime", "createdby", 
		"modifiedtime", "modifiedby", "id_author", "dt_create"
	};
	
	// ci_mr_fp_pat所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpPatArr = new String[] {
		"id_cimrfppat", "id_ent", "id_pat", "name_pat", "id_entp", "code_entp", "id_sex", "dt_birth_pat", 
		"age", "id_addr_born", "id_addr_origin", "id_addr_now", "tel_addr_now", "zip_addr_now", "id_addr_cencus", "zip_addr_cencus", 
		"id_workunit", "id_addr_work", "del_addr_work", "zip_addr_work", "name_cont", "id_conttp", "id_addr_cont", "tel_cont", 
		"code_amr_ip", "id_pay_method", "n_times_inhospital", "id_country", "id_nation", "id_marry", "id_idtp", "id_code", 
		"id_occu", "age_month", "birth_weight", "addmission_weight", "id_referalsrc", "dt_acpt", "id_dep_phyadm", "id_dep_trans", 
		"dt_end", "id_dep_phydisc", "hosdays", "in_id_bed", "out_id_bed", "id_outp_emer_di", "id_curecategory", "id_outp_cm_di", 
		"def0", "def1", "def2", "def3", "def4", "def5", "def6", "def7", 
		"def8", "def9", "health_card_id", "modifiedtime", "modifiedby", "createdtime", "createdby", "code_pat_ie", 
		"code_ent_ie", "id_mrfp", "name_otherinst", "birth_weight_one", "birth_weight_two", "id_certificates_reason", "dlb_socre_in", "dlb_socre_out", 
		"id_doct_op", "id_cm_symptom"
	};
	
	// ci_mr_fp_other所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpOtherArr = new String[] {
		"id_cimrfpother", "id_ent", "id_pat", "id_mrtp", "id_drug_allergy", "name_drug_allergy", "allergic_drugs", "id_blood_type", 
		"name_blood_type", "id_rh_type", "name_rh_type", "id_dirofdept", "id_zr_doc", "id_emp_phy", "id_emp_nur", "id_zz_doc", 
		"id_zy_doc", "id_learn_doc", "id_intern_doc", "id_qcp_doc", "id_qcp_nur", "id_coder", "id_qom_record", "name_qom_record", 
		"qc_date", "num_patho", "out_hos_mode", "name_med_in_1", "name_med_in_2", "id_aut_dead_pat", "name_aut_dead_pat", "id_is_have_inhos_plan", 
		"name_is_have_inhos_plan", "goal_inhos_plan", "coma_time_bef_inhos_days", "coma_time_bef_inhos_hours", "coma_time_bef_inhos_mins", "coma_time_inhos_days", "coma_time_inhos_hours", "coma_time_inhos_mins", 
		"ventilator_use_time", "tumor_grade_t", "tumor_grade_n", "tumor_grade_m", "dlb_score_in", "dlb_score_out", "id_cipathtype", "id_usecmp", 
		"id_usecme", "id_usecmdt", "id_dnur", "id_iioutreason", "sd_iioutreason", "name_iioutreason", "id_dipathology", "def0", 
		"def1", "def2", "def3", "def4", "def5", "def6", "def7", "def8", 
		"def9", "createdby", "modifiedby", "createdtime", "modifiedtime", "id_hightestdi", "id_nur_lev", "name_nur_lev", 
		"id_inpathstatus", "id_completestatus", "id_variationstaus", "id_team_doc", "superlev_nur_days", "onelev_nur_days", "twolev_nur_days", "threelev_nur_days", 
		"code_icdo3", "id_byediag", "id_cm_mainill", "id_cm_mainsym"
	};
	
	// ci_mr_fp_other_t所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpOtherTArr = new String[] {
		"id_cimrfpothert", "id_ent", "id_pat", "id_transferway", "dlb_socre_in", "dlb_socre_out", "id_cipathstatus", "id_ant_using", 
		"id_ant_purpose", "id_ant_plan", "days_drugcmb", "id_ctg_report", "days_cinur", "id_nur_lev", "id_hascill", "id_hasupsecsur", 
		"id_has_inicu", "name_icu", "date_in_icu", "date_out_icu", "id_dic_hos", "id_dic_surgery", "id_dic_ci", "id_maindi_outhos", 
		"def1", "def2", "def3", "def4", "def5", "def6", "def7", "def8", 
		"def9", "def10", "modifiedtime", "modifiedby", "createdtime", "createdby", "id_mrtp", "id_dic_outpa", 
		"id_dic_radiation", "rescue", "rescue_success", "id_critical_case", "id_difficult_case", "id_mdt_case", "id_drgs_case", "id_time_case", 
		"id_teaching_case", "sd_pat", "name_pat", "code_amr_ip", "id_inpathstatus", "id_completestatus", "id_variationstaus", "quit_reason", 
		"variation_reason", "id_ant_sug_using", "id_ant_sug_plan", "days_sug_drugcmb", "id_has_infu", "id_infu_reac", "id_has_tran", "id_tran_reac", 
		"id_has_ps", "id_has_fall", "id_has_pc", "hours_pc", "id_has_aaout", "id_has_inicu_again", "id_has_death_insug", "id_has_death_aftersug", 
		"id_dirofdept", "id_qcp_doc", "id_qcp_nur", "qc_date", "id_has_samedi", "id_between_inhosdays", "id_ps_begintime", "id_ps_stage", 
		"id_fall_hurtlvl", "id_fall_reason", "id_pc_method", "id_pc_tool", "id_pc_reason", "id_baby_outhos_reason", "id_between_inicuhours", "id_mrcasetype"
	};
	
	// ci_mr_fp_bl所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpBlArr = new String[] {
		"id_mrfpbl", "id_mrfp", "sortno", "id_srv_bl", "name_srv_bl", "amount", "id_ent", "id_pat", 
		"cms_gmsfee", "cms_gtofee", "cms_nurfee", "cms_otherfee", "cms_spamount", "di_pdifee", "di_ldifee", "di_idifee", 
		"di_cdifee", "tc_nstpfee", "tc_cptfee", "tc_stfee", "tc_anfee", "tc_opfee", "rc_rcfee", "tcm_cmtfee", 
		"wm_wmfee", "wm_agfee", "tcmt_cpmfee", "tcmt_chmfee", "babp_bfee", "babp_apfee", "babp_gpfee", "babp_bcffee", 
		"babp_cflfee", "sc_dmmfifee", "sc_dmmftfee", "sc_dmmfsfee", "oc_ocfee", "cms_decnfee", "cms_decfee", "tcm_difee", 
		"tcm_etfee", "tcm_bffee", "tcm_tcmfee", "tcm_mnpfee", "tcm_anrfee", "tcm_spcialfee", "tcm_otherfee", "tcm_allocationfee", 
		"tcm_dcfee", "tcmt_ppafee", "modifiedtime", "createdby", "createdtime", "modifiedby"
	};
	
	// ci_mr_fp_sug所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpSugArr = new String[] {
		"id_mrfpsug", "id_mrfp", "sortno", "id_ent", "id_pat", "id_sug", "id_lvlsug", "dt_start_sug", 
		"dt_end_sug", "id_emp_sug", "id_emp_asst1", "id_emp_asst2", "id_emp_anes", "id_incitp", "id_anestp", "id_incicondi", 
		"id_fg_complication", "createdby", "createdtime", "modifiedby", "modifiedtime", "id_method_sug"
	};
	
	// ci_mr_fp_di所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpDiArr = new String[] {
		"id_mrfpdi", "id_mrfp", "id_ent", "id_pat", "createdby", "createdtime", "modifiedby", "modifiedtime"
	};
	
	// ci_mr_fp_xydi所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpXyDiArr = new String[] {
		"id_mrfpxydi", "sortno", "id_di", "id_dislvl_inp", "name_dislvl_inp", "id_di_type", "id_mrfpdi", "fg_maindi", 
		"id_treatment_outcome", "id_hpdi"
	};
	
	// ci_mr_fp_zydi所用字段数组(字段顺序不可修改，不可随意添加)
	private static String[] mrFpZyDiArr = new String[] {
		"id_mrfpzydi", "sortno", "id_di", "id_dislvl_inp", "name_dislvl_inp", "id_di_type", "id_mrfpdi", "id_syndrome", 
		"fg_maindi", "id_treatment_outcome", "id_hpdi"
	};
	
	/**
	 * 病案首页-主表 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP = mrFpArr;
	/**
	 * 病案首页-患者信息 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_PAT = mrFpPatArr;
	/**
	 * 病案首页-其他信息 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_OTHER = mrFpOtherArr;
	/**
	 * 病案首页-附页信息 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_OTHER_T = mrFpOtherTArr;
	/**
	 * 病案首页-费用信息 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_BL = mrFpBlArr;
	/**
	 * 病案首页-手术信息 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_SUG = mrFpSugArr;
	/**
	 * 病案首页-诊断主表 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_DI = mrFpDiArr;
	/**
	 * 病案首页-西医诊断 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_XYDI = mrFpXyDiArr;
	/**
	 * 病案首页-中医诊断 所用字段
	 */
	public static final String[] MRFP_COL_MR_FP_ZYDI = mrFpZyDiArr;
	
	/**
	 * 病案首页快速查询-主表起始编号
	 */
	public static final Integer MR_FP_START_NUM = 1;
	/**
	 * 病案首页快速查询-主表结束编号
	 */
	public static final Integer MR_FP_END_NUM = 12;
	/**
	 * 病案首页快速查询-患者信息起始编号
	 */
	public static final Integer MR_FP_PAT_START_NUM = 13;
	/**
	 * 病案首页快速查询-患者信息结束编号
	 */
	public static final Integer MR_FP_PAT_END_NUM = 86;
	/**
	 * 病案首页快速查询-其他信息起始编号
	 */
	public static final Integer MR_FP_OTHER_START_NUM = 87;
	/**
	 * 病案首页快速查询-其他信息结束编号
	 */
	public static final Integer MR_FP_OTHER_END_NUM = 170;
	/**
	 * 病案首页快速查询-附页信息起始编号
	 */
	public static final Integer MR_FP_OTHER_T_START_NUM = 171;
	/**
	 * 病案首页快速查询-附页信息结束编号
	 */
	public static final Integer MR_FP_OTHER_T_END_NUM = 258;
	/**
	 * 病案首页快速查询-费用信息起始编号
	 */
	public static final Integer MR_FP_BL_START_NUM = 259;
	/**
	 * 病案首页快速查询-费用信息结束编号
	 */
	public static final Integer MR_FP_BL_END_NUM = 312;
	/**
	 * 病案首页快速查询-手术信息-起始编号
	 */
	public static final Integer MR_FP_SUG_START_NUM = 313;
	/**
	 * 病案首页快速查询-手术信息-结束编号
	 */
	public static final Integer MR_FP_SUG_END_NUM = 488;
	/**
	 * 病案首页快速查询-诊断主表-起始编号
	 */
	public static final Integer MR_FP_DI_START_NUM = 489;
	/**
	 * 病案首页快速查询-诊断主表-结束编号
	 */
	public static final Integer MR_FP_DI_END_NUM = 496;
	/**
	 * 病案首页快速查询-西医诊断-起始编号
	 */
	public static final Integer MR_FP_XYDI_START_NUM = 497;
	/**
	 * 病案首页快速查询-西医诊断-结束编号
	 */
	public static final Integer MR_FP_XYDI_END_NUM = 616;
	/**
	 * 病案首页快速查询-中医诊断-起始编号
	 */
	public static final Integer MR_FP_ZYDI_START_NUM = 617;
	/**
	 * 病案首页快速查询-中医诊断-结束编号
	 */
	public static final Integer MR_FP_ZYDI_END_NUM = 748;
	
	/**
	 * 病案首页快速查询-字段名前缀
	 */
	public static final String COL_NAME = "Col";
	
}
