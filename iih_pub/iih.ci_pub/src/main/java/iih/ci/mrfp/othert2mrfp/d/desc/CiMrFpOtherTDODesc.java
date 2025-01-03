
package iih.ci.mrfp.othert2mrfp.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 病案首页 附页 DO 元数据信息
 */
public class CiMrFpOtherTDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrfp.othert2mrfp.d.CiMrFpOtherTDO";
	public static final String CLASS_DISPALYNAME = "病案首页 附页";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_OTHER_T";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cimrfpothert";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpOtherTDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_cimrfpothertADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cimrfpothertADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_transferwayADesc(tblDesc));
		this.add(getSd_transferwayADesc(tblDesc));
		this.add(getName_transferwayADesc(tblDesc));
		this.add(getDlb_socre_inADesc(tblDesc));
		this.add(getDlb_socre_outADesc(tblDesc));
		this.add(getId_cipathstatusADesc(tblDesc));
		this.add(getName_cipathstatusADesc(tblDesc));
		this.add(getId_ant_usingADesc(tblDesc));
		this.add(getId_ant_purposeADesc(tblDesc));
		this.add(getId_ant_planADesc(tblDesc));
		this.add(getDays_drugcmbADesc(tblDesc));
		this.add(getId_ctg_reportADesc(tblDesc));
		this.add(getDays_cinurADesc(tblDesc));
		this.add(getId_nur_levADesc(tblDesc));
		this.add(getId_hascillADesc(tblDesc));
		this.add(getId_hasupsecsurADesc(tblDesc));
		this.add(getId_has_inicuADesc(tblDesc));
		this.add(getName_icuADesc(tblDesc));
		this.add(getDate_in_icuADesc(tblDesc));
		this.add(getDate_out_icuADesc(tblDesc));
		this.add(getId_dic_hosADesc(tblDesc));
		this.add(getId_dic_surgeryADesc(tblDesc));
		this.add(getId_dic_ciADesc(tblDesc));
		this.add(getId_maindi_outhosADesc(tblDesc));
		this.add(getSd_maindi_outhosADesc(tblDesc));
		this.add(getName_maindi_outhosADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getDef6ADesc(tblDesc));
		this.add(getDef7ADesc(tblDesc));
		this.add(getDef8ADesc(tblDesc));
		this.add(getDef9ADesc(tblDesc));
		this.add(getDef10ADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_dic_outpaADesc(tblDesc));
		this.add(getId_dic_radiationADesc(tblDesc));
		this.add(getRescueADesc(tblDesc));
		this.add(getRescue_successADesc(tblDesc));
		this.add(getId_critical_caseADesc(tblDesc));
		this.add(getId_difficult_caseADesc(tblDesc));
		this.add(getId_mdt_caseADesc(tblDesc));
		this.add(getId_drgs_caseADesc(tblDesc));
		this.add(getId_time_caseADesc(tblDesc));
		this.add(getSd_critical_caseADesc(tblDesc));
		this.add(getId_teaching_caseADesc(tblDesc));
		this.add(getName_critical_caseADesc(tblDesc));
		this.add(getSd_difficult_caseADesc(tblDesc));
		this.add(getName_difficult_caseADesc(tblDesc));
		this.add(getSd_mdt_caseADesc(tblDesc));
		this.add(getName_mdt_caseADesc(tblDesc));
		this.add(getSd_drgs_caseADesc(tblDesc));
		this.add(getName_drgs_caseADesc(tblDesc));
		this.add(getSd_time_caseADesc(tblDesc));
		this.add(getName_time_caseADesc(tblDesc));
		this.add(getSd_teaching_caseADesc(tblDesc));
		this.add(getName_teaching_caseADesc(tblDesc));
		this.add(getSd_dic_hosADesc(tblDesc));
		this.add(getName_dic_hosADesc(tblDesc));
		this.add(getSd_dic_surgeryADesc(tblDesc));
		this.add(getName_dic_surgeryADesc(tblDesc));
		this.add(getSd_dic_ciADesc(tblDesc));
		this.add(getSd_dic_outpaADesc(tblDesc));
		this.add(getName_dic_ciADesc(tblDesc));
		this.add(getName_dic_outpaADesc(tblDesc));
		this.add(getSd_dic_radiationADesc(tblDesc));
		this.add(getName_dic_radiationADesc(tblDesc));
		this.add(getSd_cipathstatusADesc(tblDesc));
		this.add(getSd_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_inpathstatusADesc(tblDesc));
		this.add(getSd_inpathstatusADesc(tblDesc));
		this.add(getName_inpathstatusADesc(tblDesc));
		this.add(getId_completestatusADesc(tblDesc));
		this.add(getSd_completestatusADesc(tblDesc));
		this.add(getName_completestatusADesc(tblDesc));
		this.add(getId_variationstausADesc(tblDesc));
		this.add(getSd_variationstausADesc(tblDesc));
		this.add(getName_variationstausADesc(tblDesc));
		this.add(getQuit_reasonADesc(tblDesc));
		this.add(getVariation_reasonADesc(tblDesc));
		this.add(getId_ant_sug_usingADesc(tblDesc));
		this.add(getId_ant_sug_planADesc(tblDesc));
		this.add(getDays_sug_drugcmbADesc(tblDesc));
		this.add(getId_has_infuADesc(tblDesc));
		this.add(getId_infu_reacADesc(tblDesc));
		this.add(getId_has_tranADesc(tblDesc));
		this.add(getId_tran_reacADesc(tblDesc));
		this.add(getId_has_psADesc(tblDesc));
		this.add(getName_ps_stageADesc(tblDesc));
		this.add(getId_has_fallADesc(tblDesc));
		this.add(getId_has_pcADesc(tblDesc));
		this.add(getHours_pcADesc(tblDesc));
		this.add(getId_has_aaoutADesc(tblDesc));
		this.add(getId_has_inicu_againADesc(tblDesc));
		this.add(getId_has_death_insugADesc(tblDesc));
		this.add(getId_has_death_aftersugADesc(tblDesc));
		this.add(getId_dirofdeptADesc(tblDesc));
		this.add(getSd_dirofdeptADesc(tblDesc));
		this.add(getName_dirofdeptADesc(tblDesc));
		this.add(getId_qcp_docADesc(tblDesc));
		this.add(getSd_qcp_docADesc(tblDesc));
		this.add(getName_qcp_docADesc(tblDesc));
		this.add(getId_qcp_nurADesc(tblDesc));
		this.add(getSd_qcp_nurADesc(tblDesc));
		this.add(getName_qcp_nurADesc(tblDesc));
		this.add(getQc_dateADesc(tblDesc));
		this.add(getId_has_samediADesc(tblDesc));
		this.add(getSd_ant_usingADesc(tblDesc));
		this.add(getName_ant_usingADesc(tblDesc));
		this.add(getSd_ant_planADesc(tblDesc));
		this.add(getName_ant_planADesc(tblDesc));
		this.add(getSd_ant_sug_usingADesc(tblDesc));
		this.add(getName_ant_sug_usingADesc(tblDesc));
		this.add(getSd_ant_sug_planADesc(tblDesc));
		this.add(getName_ant_sug_planADesc(tblDesc));
		this.add(getSd_has_samediADesc(tblDesc));
		this.add(getName_has_samediADesc(tblDesc));
		this.add(getSd_has_infuADesc(tblDesc));
		this.add(getName_has_infuADesc(tblDesc));
		this.add(getSd_infu_reacADesc(tblDesc));
		this.add(getName_infu_reacADesc(tblDesc));
		this.add(getSd_has_tranADesc(tblDesc));
		this.add(getName_has_tranADesc(tblDesc));
		this.add(getSd_tran_reacADesc(tblDesc));
		this.add(getName_tran_reacADesc(tblDesc));
		this.add(getSd_has_psADesc(tblDesc));
		this.add(getName_has_psADesc(tblDesc));
		this.add(getSd_has_fallADesc(tblDesc));
		this.add(getName_has_fallADesc(tblDesc));
		this.add(getSd_has_pcADesc(tblDesc));
		this.add(getName_has_pcADesc(tblDesc));
		this.add(getSd_has_aaoutADesc(tblDesc));
		this.add(getName_has_aaoutADesc(tblDesc));
		this.add(getSd_has_inicu_againADesc(tblDesc));
		this.add(getName_has_inicu_againADesc(tblDesc));
		this.add(getSd_has_death_insugADesc(tblDesc));
		this.add(getName_has_death_insugADesc(tblDesc));
		this.add(getSd_has_death_aftersugADesc(tblDesc));
		this.add(getName_has_death_aftersugADesc(tblDesc));
		this.add(getId_between_inhosdaysADesc(tblDesc));
		this.add(getSd_between_inhosdaysADesc(tblDesc));
		this.add(getName_between_inhosdaysADesc(tblDesc));
		this.add(getId_ps_begintimeADesc(tblDesc));
		this.add(getSd_ps_begintimeADesc(tblDesc));
		this.add(getName_ps_begintimeADesc(tblDesc));
		this.add(getId_ps_stageADesc(tblDesc));
		this.add(getSd_ps_stageADesc(tblDesc));
		this.add(getId_fall_hurtlvlADesc(tblDesc));
		this.add(getSd_fall_hurtlvlADesc(tblDesc));
		this.add(getName_fall_hurtlvlADesc(tblDesc));
		this.add(getId_fall_reasonADesc(tblDesc));
		this.add(getSd_fall_reasonADesc(tblDesc));
		this.add(getName_fall_reasonADesc(tblDesc));
		this.add(getId_pc_methodADesc(tblDesc));
		this.add(getSd_pc_methodADesc(tblDesc));
		this.add(getName_pc_methodADesc(tblDesc));
		this.add(getId_pc_toolADesc(tblDesc));
		this.add(getSd_pc_toolADesc(tblDesc));
		this.add(getName_pc_toolADesc(tblDesc));
		this.add(getId_pc_reasonADesc(tblDesc));
		this.add(getSd_pc_reasonADesc(tblDesc));
		this.add(getName_pc_reasonADesc(tblDesc));
		this.add(getId_baby_outhos_reasonADesc(tblDesc));
		this.add(getSd_baby_outhos_reasonADesc(tblDesc));
		this.add(getName_baby_outhos_reasonADesc(tblDesc));
		this.add(getId_between_inicuhoursADesc(tblDesc));
		this.add(getSd_between_inicuhoursADesc(tblDesc));
		this.add(getName_between_inicuhoursADesc(tblDesc));
		this.add(getSd_ant_purposeADesc(tblDesc));
		this.add(getName_ant_purposeADesc(tblDesc));
		this.add(getSd_hascillADesc(tblDesc));
		this.add(getName_hascillADesc(tblDesc));
		this.add(getId_mrcasetypeADesc(tblDesc));
		this.add(getSd_mrcasetypeADesc(tblDesc));
		this.add(getName_mrcasetypeADesc(tblDesc));
		this.add(getId_sug_complicationADesc(tblDesc));
		this.add(getSd_sug_complicationADesc(tblDesc));
		this.add(getName_sug_complicationADesc(tblDesc));
		this.add(getId_dic_confirmedADesc(tblDesc));
		this.add(getSd_dic_confirmedADesc(tblDesc));
		this.add(getName_dic_confirmedADesc(tblDesc));
		this.add(getAmount_bloodADesc(tblDesc));
		this.add(getAmount_plasmaADesc(tblDesc));
		this.add(getAmount_plateletADesc(tblDesc));
		this.add(getAmount_erythrocyteADesc(tblDesc));
		this.add(getAmount_autolo_transADesc(tblDesc));
		this.add(getId_otherdi_outhosADesc(tblDesc));
		this.add(getSd_otherdi_outhosADesc(tblDesc));
		this.add(getName_otherdi_outhosADesc(tblDesc));
		this.add(getId_icu_typenameADesc(tblDesc));
		this.add(getSd_icu_typenameADesc(tblDesc));
		this.add(getName_icu_typenameADesc(tblDesc));
		this.add(getId_inhos_situationADesc(tblDesc));
		this.add(getSd_inhos_situationADesc(tblDesc));
		this.add(getName_inhos_situationADesc(tblDesc));
		this.add(getId_hbsagADesc(tblDesc));
		this.add(getSd_hbsagADesc(tblDesc));
		this.add(getName_hbsagADesc(tblDesc));
		this.add(getId_hcv_abADesc(tblDesc));
		this.add(getSd_hcv_abADesc(tblDesc));
		this.add(getName_hcv_abADesc(tblDesc));
		this.add(getId_hiv_abADesc(tblDesc));
		this.add(getSd_hiv_abADesc(tblDesc));
		this.add(getName_hiv_abADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getTransferway_codeADesc(tblDesc));
		this.add(getTransferway_nameADesc(tblDesc));
		this.add(getCipathstatus_codeADesc(tblDesc));
		this.add(getCipathstatus_nameADesc(tblDesc));
		this.add(getAnt_using_codeADesc(tblDesc));
		this.add(getAnt_using_nameADesc(tblDesc));
		this.add(getAnt_purpose_codeADesc(tblDesc));
		this.add(getAnt_purpose_nameADesc(tblDesc));
		this.add(getAnt_plan_codeADesc(tblDesc));
		this.add(getAnt_plan_nameADesc(tblDesc));
		this.add(getCtg_report_codeADesc(tblDesc));
		this.add(getCtg_report_nameADesc(tblDesc));
		this.add(getNur_lev_codeADesc(tblDesc));
		this.add(getNur_lev_nameADesc(tblDesc));
		this.add(getHascill_codeADesc(tblDesc));
		this.add(getHascill_nameADesc(tblDesc));
		this.add(getHasupsecsur_codeADesc(tblDesc));
		this.add(getHasupsecsur_nameADesc(tblDesc));
		this.add(getHas_inicu_codeADesc(tblDesc));
		this.add(getHas_inicu_nameADesc(tblDesc));
		this.add(getDic_hos_codeADesc(tblDesc));
		this.add(getDic_hos_nameADesc(tblDesc));
		this.add(getDic_surgery_codeADesc(tblDesc));
		this.add(getDic_surgery_nameADesc(tblDesc));
		this.add(getDic_ci_codeADesc(tblDesc));
		this.add(getDic_ci_nameADesc(tblDesc));
		this.add(getMaindi_outhos_nameADesc(tblDesc));
		this.add(getMaindi_outhos_codeADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getDic_outpa_codeADesc(tblDesc));
		this.add(getDic_outpa_nameADesc(tblDesc));
		this.add(getDic_radiation_codeADesc(tblDesc));
		this.add(getDic_radiation_nameADesc(tblDesc));
		this.add(getCritical_case_codeADesc(tblDesc));
		this.add(getCritical_case_nameADesc(tblDesc));
		this.add(getDifficult_case_codeADesc(tblDesc));
		this.add(getDifficult_case_nameADesc(tblDesc));
		this.add(getMdt_case_codeADesc(tblDesc));
		this.add(getMdt_case_nameADesc(tblDesc));
		this.add(getDrgs_case_codeADesc(tblDesc));
		this.add(getDrgs_case_nameADesc(tblDesc));
		this.add(getTime_case_codeADesc(tblDesc));
		this.add(getTime_case_nameADesc(tblDesc));
		this.add(getTeaching_case_codeADesc(tblDesc));
		this.add(getTeaching_case_nameADesc(tblDesc));
		this.add(getInpath_codeADesc(tblDesc));
		this.add(getInpath_nameADesc(tblDesc));
		this.add(getComplete_codeADesc(tblDesc));
		this.add(getComplete_nameADesc(tblDesc));
		this.add(getVariation_codeADesc(tblDesc));
		this.add(getVariation_nameADesc(tblDesc));
		this.add(getAnt_sug_using_codeADesc(tblDesc));
		this.add(getAnt_sug_using_nameADesc(tblDesc));
		this.add(getAnt_sug_plan_codeADesc(tblDesc));
		this.add(getAnt_sug_plan_nameADesc(tblDesc));
		this.add(getHas_infu_codeADesc(tblDesc));
		this.add(getHas_infu_nameADesc(tblDesc));
		this.add(getInfu_reac_codeADesc(tblDesc));
		this.add(getInfu_reac_nameADesc(tblDesc));
		this.add(getHas_tran_codeADesc(tblDesc));
		this.add(getHas_tran_nameADesc(tblDesc));
		this.add(getTran_reac_codeADesc(tblDesc));
		this.add(getTran_reac_nameADesc(tblDesc));
		this.add(getHas_ps_codeADesc(tblDesc));
		this.add(getHas_ps_nameADesc(tblDesc));
		this.add(getHas_fall_codeADesc(tblDesc));
		this.add(getHas_fall_nameADesc(tblDesc));
		this.add(getHas_pc_codeADesc(tblDesc));
		this.add(getHas_pc_nameADesc(tblDesc));
		this.add(getHas_aaout_codeADesc(tblDesc));
		this.add(getHas_aaout_nameADesc(tblDesc));
		this.add(getHas_inicu_again_codeADesc(tblDesc));
		this.add(getHas_inicu_again_nameADesc(tblDesc));
		this.add(getHas_death_insug_codeADesc(tblDesc));
		this.add(getHas_death_insug_nameADesc(tblDesc));
		this.add(getHas_death_aftersug_codeADesc(tblDesc));
		this.add(getHas_death_aftersug_nameADesc(tblDesc));
		this.add(getHas_samedi_codeADesc(tblDesc));
		this.add(getHas_samedi_nameADesc(tblDesc));
		this.add(getBetween_inhos_codeADesc(tblDesc));
		this.add(getBetween_inhos_nameADesc(tblDesc));
		this.add(getPs_begin_codeADesc(tblDesc));
		this.add(getPs_begin_nameADesc(tblDesc));
		this.add(getPs_stage_codeADesc(tblDesc));
		this.add(getPs_stage_nameADesc(tblDesc));
		this.add(getFall_hurtlvl_codeADesc(tblDesc));
		this.add(getFall_hurtlvl_nameADesc(tblDesc));
		this.add(getFall_reason_codeADesc(tblDesc));
		this.add(getFall_reason_nameADesc(tblDesc));
		this.add(getPc_method_codeADesc(tblDesc));
		this.add(getPc_method_nameADesc(tblDesc));
		this.add(getPc_tool_codeADesc(tblDesc));
		this.add(getPc_tool_nameADesc(tblDesc));
		this.add(getPc_reason_codeADesc(tblDesc));
		this.add(getPc_reason_nameADesc(tblDesc));
		this.add(getBaby_outhos_codeADesc(tblDesc));
		this.add(getBaby_outhos_nameADesc(tblDesc));
		this.add(getBetween_inicu_codeADesc(tblDesc));
		this.add(getBetween_inicu_nameADesc(tblDesc));
		this.add(getSc_codeADesc(tblDesc));
		this.add(getSc_nameADesc(tblDesc));
		this.add(getConfirmed_codeADesc(tblDesc));
		this.add(getConfirmed_nameADesc(tblDesc));
		this.add(getOtherdi_outhos_codeADesc(tblDesc));
		this.add(getOtherdi_outhos_nameADesc(tblDesc));
		this.add(getIcu_typename_codeADesc(tblDesc));
		this.add(getIcu_typename_nameADesc(tblDesc));
		this.add(getInhos_situation_codeADesc(tblDesc));
		this.add(getInhos_situation_nameADesc(tblDesc));
		this.add(getHbsag_codeADesc(tblDesc));
		this.add(getHbsag_nameADesc(tblDesc));
		this.add(getHcv_ab_codeADesc(tblDesc));
		this.add(getHcv_ab_nameADesc(tblDesc));
		this.add(getHiv_ab_codeADesc(tblDesc));
		this.add(getHiv_ab_nameADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_cimrfpothertCDesc(tblDesc));
		tblDesc.add(getId_cimrfpothertCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_transferwayCDesc(tblDesc));
		tblDesc.add(getSd_transferwayCDesc(tblDesc));
		tblDesc.add(getName_transferwayCDesc(tblDesc));
		tblDesc.add(getDlb_socre_inCDesc(tblDesc));
		tblDesc.add(getDlb_socre_outCDesc(tblDesc));
		tblDesc.add(getId_cipathstatusCDesc(tblDesc));
		tblDesc.add(getName_cipathstatusCDesc(tblDesc));
		tblDesc.add(getId_ant_usingCDesc(tblDesc));
		tblDesc.add(getId_ant_purposeCDesc(tblDesc));
		tblDesc.add(getId_ant_planCDesc(tblDesc));
		tblDesc.add(getDays_drugcmbCDesc(tblDesc));
		tblDesc.add(getId_ctg_reportCDesc(tblDesc));
		tblDesc.add(getDays_cinurCDesc(tblDesc));
		tblDesc.add(getId_nur_levCDesc(tblDesc));
		tblDesc.add(getId_hascillCDesc(tblDesc));
		tblDesc.add(getId_hasupsecsurCDesc(tblDesc));
		tblDesc.add(getId_has_inicuCDesc(tblDesc));
		tblDesc.add(getName_icuCDesc(tblDesc));
		tblDesc.add(getDate_in_icuCDesc(tblDesc));
		tblDesc.add(getDate_out_icuCDesc(tblDesc));
		tblDesc.add(getId_dic_hosCDesc(tblDesc));
		tblDesc.add(getId_dic_surgeryCDesc(tblDesc));
		tblDesc.add(getId_dic_ciCDesc(tblDesc));
		tblDesc.add(getId_maindi_outhosCDesc(tblDesc));
		tblDesc.add(getSd_maindi_outhosCDesc(tblDesc));
		tblDesc.add(getName_maindi_outhosCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getDef6CDesc(tblDesc));
		tblDesc.add(getDef7CDesc(tblDesc));
		tblDesc.add(getDef8CDesc(tblDesc));
		tblDesc.add(getDef9CDesc(tblDesc));
		tblDesc.add(getDef10CDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_dic_outpaCDesc(tblDesc));
		tblDesc.add(getId_dic_radiationCDesc(tblDesc));
		tblDesc.add(getRescueCDesc(tblDesc));
		tblDesc.add(getRescue_successCDesc(tblDesc));
		tblDesc.add(getId_critical_caseCDesc(tblDesc));
		tblDesc.add(getId_difficult_caseCDesc(tblDesc));
		tblDesc.add(getId_mdt_caseCDesc(tblDesc));
		tblDesc.add(getId_drgs_caseCDesc(tblDesc));
		tblDesc.add(getId_time_caseCDesc(tblDesc));
		tblDesc.add(getSd_critical_caseCDesc(tblDesc));
		tblDesc.add(getId_teaching_caseCDesc(tblDesc));
		tblDesc.add(getName_critical_caseCDesc(tblDesc));
		tblDesc.add(getSd_difficult_caseCDesc(tblDesc));
		tblDesc.add(getName_difficult_caseCDesc(tblDesc));
		tblDesc.add(getSd_mdt_caseCDesc(tblDesc));
		tblDesc.add(getName_mdt_caseCDesc(tblDesc));
		tblDesc.add(getSd_drgs_caseCDesc(tblDesc));
		tblDesc.add(getName_drgs_caseCDesc(tblDesc));
		tblDesc.add(getSd_time_caseCDesc(tblDesc));
		tblDesc.add(getName_time_caseCDesc(tblDesc));
		tblDesc.add(getSd_teaching_caseCDesc(tblDesc));
		tblDesc.add(getName_teaching_caseCDesc(tblDesc));
		tblDesc.add(getSd_dic_hosCDesc(tblDesc));
		tblDesc.add(getName_dic_hosCDesc(tblDesc));
		tblDesc.add(getSd_dic_surgeryCDesc(tblDesc));
		tblDesc.add(getName_dic_surgeryCDesc(tblDesc));
		tblDesc.add(getSd_dic_ciCDesc(tblDesc));
		tblDesc.add(getSd_dic_outpaCDesc(tblDesc));
		tblDesc.add(getName_dic_ciCDesc(tblDesc));
		tblDesc.add(getName_dic_outpaCDesc(tblDesc));
		tblDesc.add(getSd_dic_radiationCDesc(tblDesc));
		tblDesc.add(getName_dic_radiationCDesc(tblDesc));
		tblDesc.add(getSd_cipathstatusCDesc(tblDesc));
		tblDesc.add(getSd_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_inpathstatusCDesc(tblDesc));
		tblDesc.add(getSd_inpathstatusCDesc(tblDesc));
		tblDesc.add(getName_inpathstatusCDesc(tblDesc));
		tblDesc.add(getId_completestatusCDesc(tblDesc));
		tblDesc.add(getSd_completestatusCDesc(tblDesc));
		tblDesc.add(getName_completestatusCDesc(tblDesc));
		tblDesc.add(getId_variationstausCDesc(tblDesc));
		tblDesc.add(getSd_variationstausCDesc(tblDesc));
		tblDesc.add(getName_variationstausCDesc(tblDesc));
		tblDesc.add(getQuit_reasonCDesc(tblDesc));
		tblDesc.add(getVariation_reasonCDesc(tblDesc));
		tblDesc.add(getId_ant_sug_usingCDesc(tblDesc));
		tblDesc.add(getId_ant_sug_planCDesc(tblDesc));
		tblDesc.add(getDays_sug_drugcmbCDesc(tblDesc));
		tblDesc.add(getId_has_infuCDesc(tblDesc));
		tblDesc.add(getId_infu_reacCDesc(tblDesc));
		tblDesc.add(getId_has_tranCDesc(tblDesc));
		tblDesc.add(getId_tran_reacCDesc(tblDesc));
		tblDesc.add(getId_has_psCDesc(tblDesc));
		tblDesc.add(getName_ps_stageCDesc(tblDesc));
		tblDesc.add(getId_has_fallCDesc(tblDesc));
		tblDesc.add(getId_has_pcCDesc(tblDesc));
		tblDesc.add(getHours_pcCDesc(tblDesc));
		tblDesc.add(getId_has_aaoutCDesc(tblDesc));
		tblDesc.add(getId_has_inicu_againCDesc(tblDesc));
		tblDesc.add(getId_has_death_insugCDesc(tblDesc));
		tblDesc.add(getId_has_death_aftersugCDesc(tblDesc));
		tblDesc.add(getId_dirofdeptCDesc(tblDesc));
		tblDesc.add(getSd_dirofdeptCDesc(tblDesc));
		tblDesc.add(getName_dirofdeptCDesc(tblDesc));
		tblDesc.add(getId_qcp_docCDesc(tblDesc));
		tblDesc.add(getSd_qcp_docCDesc(tblDesc));
		tblDesc.add(getName_qcp_docCDesc(tblDesc));
		tblDesc.add(getId_qcp_nurCDesc(tblDesc));
		tblDesc.add(getSd_qcp_nurCDesc(tblDesc));
		tblDesc.add(getName_qcp_nurCDesc(tblDesc));
		tblDesc.add(getQc_dateCDesc(tblDesc));
		tblDesc.add(getId_has_samediCDesc(tblDesc));
		tblDesc.add(getSd_ant_usingCDesc(tblDesc));
		tblDesc.add(getName_ant_usingCDesc(tblDesc));
		tblDesc.add(getSd_ant_planCDesc(tblDesc));
		tblDesc.add(getName_ant_planCDesc(tblDesc));
		tblDesc.add(getSd_ant_sug_usingCDesc(tblDesc));
		tblDesc.add(getName_ant_sug_usingCDesc(tblDesc));
		tblDesc.add(getSd_ant_sug_planCDesc(tblDesc));
		tblDesc.add(getName_ant_sug_planCDesc(tblDesc));
		tblDesc.add(getSd_has_samediCDesc(tblDesc));
		tblDesc.add(getName_has_samediCDesc(tblDesc));
		tblDesc.add(getSd_has_infuCDesc(tblDesc));
		tblDesc.add(getName_has_infuCDesc(tblDesc));
		tblDesc.add(getSd_infu_reacCDesc(tblDesc));
		tblDesc.add(getName_infu_reacCDesc(tblDesc));
		tblDesc.add(getSd_has_tranCDesc(tblDesc));
		tblDesc.add(getName_has_tranCDesc(tblDesc));
		tblDesc.add(getSd_tran_reacCDesc(tblDesc));
		tblDesc.add(getName_tran_reacCDesc(tblDesc));
		tblDesc.add(getSd_has_psCDesc(tblDesc));
		tblDesc.add(getName_has_psCDesc(tblDesc));
		tblDesc.add(getSd_has_fallCDesc(tblDesc));
		tblDesc.add(getName_has_fallCDesc(tblDesc));
		tblDesc.add(getSd_has_pcCDesc(tblDesc));
		tblDesc.add(getName_has_pcCDesc(tblDesc));
		tblDesc.add(getSd_has_aaoutCDesc(tblDesc));
		tblDesc.add(getName_has_aaoutCDesc(tblDesc));
		tblDesc.add(getSd_has_inicu_againCDesc(tblDesc));
		tblDesc.add(getName_has_inicu_againCDesc(tblDesc));
		tblDesc.add(getSd_has_death_insugCDesc(tblDesc));
		tblDesc.add(getName_has_death_insugCDesc(tblDesc));
		tblDesc.add(getSd_has_death_aftersugCDesc(tblDesc));
		tblDesc.add(getName_has_death_aftersugCDesc(tblDesc));
		tblDesc.add(getId_between_inhosdaysCDesc(tblDesc));
		tblDesc.add(getSd_between_inhosdaysCDesc(tblDesc));
		tblDesc.add(getName_between_inhosdaysCDesc(tblDesc));
		tblDesc.add(getId_ps_begintimeCDesc(tblDesc));
		tblDesc.add(getSd_ps_begintimeCDesc(tblDesc));
		tblDesc.add(getName_ps_begintimeCDesc(tblDesc));
		tblDesc.add(getId_ps_stageCDesc(tblDesc));
		tblDesc.add(getSd_ps_stageCDesc(tblDesc));
		tblDesc.add(getId_fall_hurtlvlCDesc(tblDesc));
		tblDesc.add(getSd_fall_hurtlvlCDesc(tblDesc));
		tblDesc.add(getName_fall_hurtlvlCDesc(tblDesc));
		tblDesc.add(getId_fall_reasonCDesc(tblDesc));
		tblDesc.add(getSd_fall_reasonCDesc(tblDesc));
		tblDesc.add(getName_fall_reasonCDesc(tblDesc));
		tblDesc.add(getId_pc_methodCDesc(tblDesc));
		tblDesc.add(getSd_pc_methodCDesc(tblDesc));
		tblDesc.add(getName_pc_methodCDesc(tblDesc));
		tblDesc.add(getId_pc_toolCDesc(tblDesc));
		tblDesc.add(getSd_pc_toolCDesc(tblDesc));
		tblDesc.add(getName_pc_toolCDesc(tblDesc));
		tblDesc.add(getId_pc_reasonCDesc(tblDesc));
		tblDesc.add(getSd_pc_reasonCDesc(tblDesc));
		tblDesc.add(getName_pc_reasonCDesc(tblDesc));
		tblDesc.add(getId_baby_outhos_reasonCDesc(tblDesc));
		tblDesc.add(getSd_baby_outhos_reasonCDesc(tblDesc));
		tblDesc.add(getName_baby_outhos_reasonCDesc(tblDesc));
		tblDesc.add(getId_between_inicuhoursCDesc(tblDesc));
		tblDesc.add(getSd_between_inicuhoursCDesc(tblDesc));
		tblDesc.add(getName_between_inicuhoursCDesc(tblDesc));
		tblDesc.add(getSd_ant_purposeCDesc(tblDesc));
		tblDesc.add(getName_ant_purposeCDesc(tblDesc));
		tblDesc.add(getSd_hascillCDesc(tblDesc));
		tblDesc.add(getName_hascillCDesc(tblDesc));
		tblDesc.add(getId_mrcasetypeCDesc(tblDesc));
		tblDesc.add(getSd_mrcasetypeCDesc(tblDesc));
		tblDesc.add(getName_mrcasetypeCDesc(tblDesc));
		tblDesc.add(getId_sug_complicationCDesc(tblDesc));
		tblDesc.add(getSd_sug_complicationCDesc(tblDesc));
		tblDesc.add(getName_sug_complicationCDesc(tblDesc));
		tblDesc.add(getId_dic_confirmedCDesc(tblDesc));
		tblDesc.add(getSd_dic_confirmedCDesc(tblDesc));
		tblDesc.add(getName_dic_confirmedCDesc(tblDesc));
		tblDesc.add(getAmount_bloodCDesc(tblDesc));
		tblDesc.add(getAmount_plasmaCDesc(tblDesc));
		tblDesc.add(getAmount_plateletCDesc(tblDesc));
		tblDesc.add(getAmount_erythrocyteCDesc(tblDesc));
		tblDesc.add(getAmount_autolo_transCDesc(tblDesc));
		tblDesc.add(getId_otherdi_outhosCDesc(tblDesc));
		tblDesc.add(getSd_otherdi_outhosCDesc(tblDesc));
		tblDesc.add(getName_otherdi_outhosCDesc(tblDesc));
		tblDesc.add(getId_icu_typenameCDesc(tblDesc));
		tblDesc.add(getSd_icu_typenameCDesc(tblDesc));
		tblDesc.add(getName_icu_typenameCDesc(tblDesc));
		tblDesc.add(getId_inhos_situationCDesc(tblDesc));
		tblDesc.add(getSd_inhos_situationCDesc(tblDesc));
		tblDesc.add(getName_inhos_situationCDesc(tblDesc));
		tblDesc.add(getId_hbsagCDesc(tblDesc));
		tblDesc.add(getSd_hbsagCDesc(tblDesc));
		tblDesc.add(getName_hbsagCDesc(tblDesc));
		tblDesc.add(getId_hcv_abCDesc(tblDesc));
		tblDesc.add(getSd_hcv_abCDesc(tblDesc));
		tblDesc.add(getName_hcv_abCDesc(tblDesc));
		tblDesc.add(getId_hiv_abCDesc(tblDesc));
		tblDesc.add(getSd_hiv_abCDesc(tblDesc));
		tblDesc.add(getName_hiv_abCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cimrfpothertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cimrfpothert",  getId_cimrfpothertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院方式（id）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_transferwayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_transferway",  getId_transferwayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式（id）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院方式（sd）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_transferwayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_transferway",  getSd_transferwayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式（sd）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式（name）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_transferwayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_transferway",  getName_transferwayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式（name）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_socre_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_socre_in",  getDlb_socre_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表（入院）得分入院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日常生活能力评定量表（入院）得分出院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDlb_socre_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dlb_socre_out",  getDlb_socre_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日常生活能力评定量表（入院）得分出院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cipathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cipathstatus",  getId_cipathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床路径状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cipathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cipathstatus",  getName_cipathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床路径状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_using",  getId_ant_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗生素使用目的id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_purpose",  getId_ant_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用目的id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗生素使用方案id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_plan",  getId_ant_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用方案id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联合用药时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_drugcmbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_drugcmb",  getDays_drugcmbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("联合用药时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有传染病报告属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctg_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctg_report",  getId_ctg_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有传染病报告");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特级护理天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_cinurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_cinur",  getDays_cinurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("特级护理天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_levADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_lev",  getId_nur_levCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否出现危重id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hascillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hascill",  getId_hascillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否出现危重id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有非计划二次手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hasupsecsurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hasupsecsur",  getId_hasupsecsurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有非计划二次手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有进入ICU属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_inicuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_inicu",  getId_has_inicuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有进入ICU");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ICU名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_icu",  getName_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 进入ICU时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDate_in_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Date_in_icu",  getDate_in_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("进入ICU时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转成ICU时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDate_out_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Date_out_icu",  getDate_out_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("转成ICU时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_入院与出院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_hosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_hos",  getId_dic_hosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_入院与出院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_术前与术后属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_surgery",  getId_dic_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_术前与术后");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_临床与病理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_ciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_ci",  getId_dic_ciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_临床与病理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主要诊断出院情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_maindi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_maindi_outhos",  getId_maindi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要诊断出院情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主要诊断出院情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_maindi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_maindi_outhos",  getSd_maindi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要诊断出院情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主要诊断出院情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_maindi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_maindi_outhos",  getName_maindi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要诊断出院情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段6属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def6",  getDef6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段6");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段7属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def7",  getDef7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段7");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段8属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def8",  getDef8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段8");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段9属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def9",  getDef9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段9");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def10",  getDef10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案首页主表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案首页主表id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_门诊与出院id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_outpaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_outpa",  getId_dic_outpaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_门诊与出院id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_放射与病理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_radiationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_radiation",  getId_dic_radiationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_放射与病理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抢救情况_抢救属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRescueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rescue",  getRescueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抢救情况_抢救");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抢救情况_成功属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRescue_successADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rescue_success",  getRescue_successCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("抢救情况_成功");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危重病例id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_critical_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_critical_case",  getId_critical_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("危重病例id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疑难病例id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_difficult_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_difficult_case",  getId_difficult_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疑难病例id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * MDT病历id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mdt_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mdt_case",  getId_mdt_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("MDT病历id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 单病种病例id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drgs_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drgs_case",  getId_drgs_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单病种病例id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 时间手术病例id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_time_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_time_case",  getId_time_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间手术病例id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 危重病例编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_critical_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_critical_case",  getSd_critical_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("危重病例编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教学查房病历id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_teaching_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_teaching_case",  getId_teaching_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教学查房病历id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 危重病例名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_critical_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_critical_case",  getName_critical_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("危重病例名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疑难病例编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_difficult_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_difficult_case",  getSd_difficult_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疑难病例编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疑难病例名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_difficult_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_difficult_case",  getName_difficult_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疑难病例名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * MDT病历编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mdt_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mdt_case",  getSd_mdt_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("MDT病历编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * MDT病历名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mdt_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mdt_case",  getName_mdt_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("MDT病历名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单病种病例编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drgs_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drgs_case",  getSd_drgs_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单病种病例编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单病种病例名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drgs_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drgs_case",  getName_drgs_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单病种病例名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间手术病例编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_time_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_time_case",  getSd_time_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间手术病例编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间手术病例名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_time_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_time_case",  getName_time_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间手术病例名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教学查房病历编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_teaching_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_teaching_case",  getSd_teaching_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教学查房病历编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教学查房病历名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_teaching_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_teaching_case",  getName_teaching_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教学查房病历名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_入院与出院编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_hosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_hos",  getSd_dic_hosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_入院与出院编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_入院与出院名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_hosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_hos",  getName_dic_hosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_入院与出院名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_术前与术后编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_surgery",  getSd_dic_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_术前与术后编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_术前与术后名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_surgery",  getName_dic_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_术前与术后名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_临床与病理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_ciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_ci",  getSd_dic_ciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_临床与病理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_门诊与出院编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_outpaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_outpa",  getSd_dic_outpaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_门诊与出院编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_临床与病理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_ciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_ci",  getName_dic_ciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_临床与病理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_门诊与出院名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_outpaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_outpa",  getName_dic_outpaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_门诊与出院名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_放射与病理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_radiationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_radiation",  getSd_dic_radiationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_放射与病理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_放射与病理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_radiationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_radiation",  getName_dic_radiationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_放射与病理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床路径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cipathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cipathstatus",  getSd_cipathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床路径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat",  getSd_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入径情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inpathstatus",  getId_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入径情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inpathstatus",  getSd_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入径情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inpathstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inpathstatus",  getName_inpathstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入径情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_completestatus",  getId_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 完成情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_completestatus",  getSd_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_completestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_completestatus",  getName_completestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_variationstaus",  getId_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 变异情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_variationstaus",  getSd_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_variationstausADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_variationstaus",  getName_variationstausCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退出原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuit_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quit_reason",  getQuit_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退出原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 变异原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVariation_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Variation_reason",  getVariation_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("变异原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_sug_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_sug_using",  getId_ant_sug_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用方案id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_sug_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_sug_plan",  getId_ant_sug_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用方案id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术联合用药时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_sug_drugcmbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_sug_drugcmb",  getDays_sug_drugcmbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术联合用药时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否输液id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_infuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_infu",  getId_has_infuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输液id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否发生输液反应id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infu_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infu_reac",  getId_infu_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输液反应id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院期间是否输血id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_tran",  getId_has_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输血id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否发生输血反应id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tran_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tran_reac",  getId_tran_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输血反应id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有压疮id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_ps",  getId_has_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有压疮id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮分期name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ps_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ps_stage",  getName_ps_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮分期name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否跌倒或坠床id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_fallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_fall",  getId_has_fallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否跌倒或坠床id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院期间是否使用物理约束id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_pc",  getId_has_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否使用物理约束id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物理约束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHours_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hours_pc",  getHours_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("物理约束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生人工气道脱出id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_aaoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_aaout",  getId_has_aaoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生人工气道脱出id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否非预期的重返ICU-id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_inicu_againADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_inicu_again",  getId_has_inicu_againCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的重返ICU-id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否发生围术期死亡id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_death_insugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_death_insug",  getId_has_death_insugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生围术期死亡id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否发生术后猝死id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_death_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_death_aftersug",  getId_has_death_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生术后猝死id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科主任id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dirofdept",  getId_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科主任code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dirofdept",  getSd_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科主任name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dirofdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dirofdept",  getName_dirofdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科主任name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控医师id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qcp_doc",  getId_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质控医师code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qcp_doc",  getSd_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控医师name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_doc",  getName_qcp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控医师name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控护士id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qcp_nur",  getId_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 质控护士code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_qcp_nur",  getSd_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控护士name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_qcp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_qcp_nur",  getName_qcp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控护士name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQc_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qc_date",  getQc_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("质控日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否因同一疾病住院id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_samediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_samedi",  getId_has_samediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否因同一疾病住院id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 抗生素使用情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_using",  getSd_ant_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_using",  getName_ant_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用方案code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_plan",  getSd_ant_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用方案code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用方案name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_plan",  getName_ant_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用方案name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_sug_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_sug_using",  getSd_ant_sug_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_sug_usingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_sug_using",  getName_ant_sug_usingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用方案code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_sug_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_sug_plan",  getSd_ant_sug_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用方案code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术抗生素使用方案name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_sug_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_sug_plan",  getName_ant_sug_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术抗生素使用方案name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否因同一疾病住院code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_samediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_samedi",  getSd_has_samediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否因同一疾病住院code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否因同一疾病住院name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_samediADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_samedi",  getName_has_samediCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否因同一疾病住院name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否输液code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_infuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_infu",  getSd_has_infuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输液code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否输液name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_infuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_infu",  getName_has_infuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输液name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生输液反应code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infu_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infu_reac",  getSd_infu_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输液反应code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生输液反应name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infu_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infu_reac",  getName_infu_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输液反应name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否输血code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_tran",  getSd_has_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输血code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否输血name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_tranADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_tran",  getName_has_tranCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否输血name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生输血反应code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tran_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tran_reac",  getSd_tran_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输血反应code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生输血反应name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tran_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tran_reac",  getName_tran_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生输血反应name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有压疮code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_ps",  getSd_has_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有压疮code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有压疮name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_psADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_ps",  getName_has_psCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有压疮name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否跌倒或坠床code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_fallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_fall",  getSd_has_fallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否跌倒或坠床code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否跌倒或坠床name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_fallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_fall",  getName_has_fallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否跌倒或坠床name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否使用物理约束code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_pc",  getSd_has_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否使用物理约束code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间是否使用物理约束name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_pcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_pc",  getName_has_pcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间是否使用物理约束name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生人工气道脱出code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_aaoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_aaout",  getSd_has_aaoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生人工气道脱出code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生人工气道脱出name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_aaoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_aaout",  getName_has_aaoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生人工气道脱出name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否非预期的重返ICU-code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_inicu_againADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_inicu_again",  getSd_has_inicu_againCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的重返ICU-code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否非预期的重返ICU-name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_inicu_againADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_inicu_again",  getName_has_inicu_againCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的重返ICU-name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生围术期死亡code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_death_insugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_death_insug",  getSd_has_death_insugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生围术期死亡code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生围术期死亡name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_death_insugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_death_insug",  getName_has_death_insugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生围术期死亡name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生术后猝死code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_death_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_death_aftersug",  getSd_has_death_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生术后猝死code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生术后猝死name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_death_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_death_aftersug",  getName_has_death_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否发生术后猝死name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 距上一次住本院时间id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_between_inhosdaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_between_inhosdays",  getId_between_inhosdaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("距上一次住本院时间id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 距上一次住本院时间code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_between_inhosdaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_between_inhosdays",  getSd_between_inhosdaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("距上一次住本院时间code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 距上一次住本院时间name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_between_inhosdaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_between_inhosdays",  getName_between_inhosdaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("距上一次住本院时间name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发生时间id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ps_begintimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ps_begintime",  getId_ps_begintimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生时间id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮发生时间code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ps_begintimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ps_begintime",  getSd_ps_begintimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生时间code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发生时间name 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ps_begintimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ps_begintime",  getName_ps_begintimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生时间name ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮分期id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ps_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ps_stage",  getId_ps_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮分期id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮分期code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ps_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ps_stage",  getSd_ps_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮分期code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fall_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fall_hurtlvl",  getId_fall_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间跌倒或坠床的伤害程度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fall_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fall_hurtlvl",  getSd_fall_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间跌倒或坠床的伤害程度code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fall_hurtlvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fall_hurtlvl",  getName_fall_hurtlvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院期间跌倒或坠床的伤害程度name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒或坠床的原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fall_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fall_reason",  getId_fall_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒或坠床的原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 跌倒或坠床的原因code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fall_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fall_reason",  getSd_fall_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒或坠床的原因code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒或坠床的原因name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fall_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fall_reason",  getName_fall_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("跌倒或坠床的原因name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pc_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc_method",  getId_pc_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物理约束方式code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pc_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pc_method",  getSd_pc_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束方式code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束方式name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pc_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pc_method",  getName_pc_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束方式name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束工具id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pc_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc_tool",  getId_pc_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束工具id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物理约束工具code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pc_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pc_tool",  getSd_pc_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束工具code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束工具name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pc_toolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pc_tool",  getName_pc_toolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束工具name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pc_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pc_reason",  getId_pc_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物理约束原因code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pc_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pc_reason",  getSd_pc_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束原因code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物理约束原因name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pc_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pc_reason",  getName_pc_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物理约束原因name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产科新生儿离院方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_baby_outhos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_baby_outhos_reason",  getId_baby_outhos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科新生儿离院方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产科新生儿离院方式code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_baby_outhos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_baby_outhos_reason",  getSd_baby_outhos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科新生儿离院方式code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产科新生儿离院方式name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_baby_outhos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_baby_outhos_reason",  getName_baby_outhos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科新生儿离院方式name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重返ICU间隔时间id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_between_inicuhoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_between_inicuhours",  getId_between_inicuhoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重返ICU间隔时间id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 重返ICU间隔时间code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_between_inicuhoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_between_inicuhours",  getSd_between_inicuhoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重返ICU间隔时间code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重返ICU间隔时间name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_between_inicuhoursADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_between_inicuhours",  getName_between_inicuhoursCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重返ICU间隔时间name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用目的code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_purpose",  getSd_ant_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用目的code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抗生素使用目的name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_purpose",  getName_ant_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗生素使用目的name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否出现危重code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hascillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hascill",  getSd_hascillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否出现危重code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否出现危重name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hascillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hascill",  getName_hascillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否出现危重name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病例分型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrcasetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrcasetype",  getId_mrcasetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病例分型sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrcasetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrcasetype",  getSd_mrcasetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分型sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病例分型name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrcasetypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrcasetype",  getName_mrcasetypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病例分型name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术后并发症id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sug_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug_complication",  getId_sug_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术后并发症id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术后并发症code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sug_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug_complication",  getSd_sug_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术后并发症code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术后并发症name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sug_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug_complication",  getName_sug_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术后并发症name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_三日确诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dic_confirmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dic_confirmed",  getId_dic_confirmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_三日确诊主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_三日确诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dic_confirmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dic_confirmed",  getSd_dic_confirmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_三日确诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断符合情况_三日确诊名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dic_confirmedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dic_confirmed",  getName_dic_confirmedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断符合情况_三日确诊名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 全血（数量）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_blood",  getAmount_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("全血（数量）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血浆（数量）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_plasmaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_plasma",  getAmount_plasmaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血浆（数量）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血小板（数量）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_plateletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_platelet",  getAmount_plateletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血小板（数量）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 红细胞（数量）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_erythrocyteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_erythrocyte",  getAmount_erythrocyteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("红细胞（数量）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自体回血输（数量）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmount_autolo_transADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amount_autolo_trans",  getAmount_autolo_transCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自体回血输（数量）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他诊断出院情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_otherdi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_otherdi_outhos",  getId_otherdi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他诊断出院情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 其他诊断出院情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_otherdi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_otherdi_outhos",  getSd_otherdi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他诊断出院情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他诊断出院情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_otherdi_outhosADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_otherdi_outhos",  getName_otherdi_outhosCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他诊断出院情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重症监护室名称id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_icu_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_icu_typename",  getId_icu_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症监护室名称id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 重症监护室名称code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_icu_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_icu_typename",  getSd_icu_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症监护室名称code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 重症监护室名称name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_icu_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_icu_typename",  getName_icu_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("重症监护室名称name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时情况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inhos_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inhos_situation",  getId_inhos_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院时情况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院时情况code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inhos_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inhos_situation",  getSd_inhos_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院时情况code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时情况name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inhos_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inhos_situation",  getName_inhos_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院时情况name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HBsAg-id（乙型肝炎表面抗原）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbsagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hbsag",  getId_hbsagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg-id（乙型肝炎表面抗原）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HBsAg-code（乙型肝炎表面抗原）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hbsagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hbsag",  getSd_hbsagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg-code（乙型肝炎表面抗原）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HBsAg-name（乙型肝炎表面抗原）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hbsagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hbsag",  getName_hbsagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HBsAg-name（乙型肝炎表面抗原）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HCV-Ab-id（丙型肝炎抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hcv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hcv_ab",  getId_hcv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HCV-Ab-id（丙型肝炎抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HCV-Ab-code（丙型肝炎抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hcv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hcv_ab",  getSd_hcv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HCV-Ab-code（丙型肝炎抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HCV-Ab-name（丙型肝炎抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hcv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hcv_ab",  getName_hcv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HCV-Ab-name（丙型肝炎抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV-Ab-id（艾滋病抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hiv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hiv_ab",  getId_hiv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV-Ab-id（艾滋病抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HIV-Ab-code（艾滋病抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hiv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hiv_ab",  getSd_hiv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV-Ab-code（艾滋病抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV-Ab-name（艾滋病抗体）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hiv_abADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hiv_ab",  getName_hiv_abCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV-Ab-name（艾滋病抗体）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_code",  getPat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b28","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b28","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransferway_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transferway_code",  getTransferway_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_transferway=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransferway_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transferway_name",  getTransferway_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_transferway=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCipathstatus_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cipathstatus_code",  getCipathstatus_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_cipathstatus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCipathstatus_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cipathstatus_name",  getCipathstatus_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_cipathstatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_using_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_using_code",  getAnt_using_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_ant_using=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_using_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_using_name",  getAnt_using_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_ant_using=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_purpose_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_purpose_code",  getAnt_purpose_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ant_purpose=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_purpose_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_purpose_name",  getAnt_purpose_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_ant_purpose=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_plan_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_plan_code",  getAnt_plan_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_ant_plan=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_plan_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_plan_name",  getAnt_plan_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_ant_plan=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtg_report_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctg_report_code",  getCtg_report_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_ctg_report=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtg_report_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctg_report_name",  getCtg_report_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_ctg_report=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_lev_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_lev_code",  getNur_lev_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_nur_lev=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_lev_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_lev_name",  getNur_lev_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_nur_lev=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHascill_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hascill_code",  getHascill_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_hascill=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHascill_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hascill_name",  getHascill_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_hascill=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasupsecsur_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasupsecsur_code",  getHasupsecsur_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_hasupsecsur=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasupsecsur_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasupsecsur_name",  getHasupsecsur_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_hasupsecsur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_inicu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_inicu_code",  getHas_inicu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_has_inicu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_inicu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_inicu_name",  getHas_inicu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_has_inicu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_hos_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_hos_code",  getDic_hos_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_dic_hos=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_hos_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_hos_name",  getDic_hos_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_dic_hos=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_surgery_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_surgery_code",  getDic_surgery_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_dic_surgery=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_surgery_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_surgery_name",  getDic_surgery_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_dic_surgery=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_ci_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_ci_code",  getDic_ci_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_dic_ci=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_ci_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_ci_name",  getDic_ci_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_dic_ci=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaindi_outhos_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maindi_outhos_name",  getMaindi_outhos_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_maindi_outhos=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMaindi_outhos_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Maindi_outhos_code",  getMaindi_outhos_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_maindi_outhos=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_code",  getGrp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b18","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b18","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b19","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b19","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_outpa_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_outpa_code",  getDic_outpa_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_dic_outpa=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_outpa_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_outpa_name",  getDic_outpa_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_dic_outpa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_radiation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_radiation_code",  getDic_radiation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_dic_radiation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDic_radiation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dic_radiation_name",  getDic_radiation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_dic_radiation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCritical_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Critical_case_code",  getCritical_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_critical_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCritical_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Critical_case_name",  getCritical_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_critical_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDifficult_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Difficult_case_code",  getDifficult_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_difficult_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDifficult_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Difficult_case_name",  getDifficult_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_difficult_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMdt_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mdt_case_code",  getMdt_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_mdt_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMdt_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mdt_case_name",  getMdt_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_mdt_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_case_code",  getDrgs_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_drgs_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrgs_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drgs_case_name",  getDrgs_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_drgs_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_case_code",  getTime_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_time_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_case_name",  getTime_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_time_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeaching_case_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teaching_case_code",  getTeaching_case_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_teaching_case=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeaching_case_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teaching_case_name",  getTeaching_case_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_teaching_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpath_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpath_code",  getInpath_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_inpathstatus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInpath_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inpath_name",  getInpath_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_inpathstatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplete_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complete_code",  getComplete_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_completestatus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplete_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complete_name",  getComplete_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_completestatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVariation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Variation_code",  getVariation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_variationstaus=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVariation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Variation_name",  getVariation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_variationstaus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_sug_using_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_sug_using_code",  getAnt_sug_using_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_ant_sug_using=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_sug_using_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_sug_using_name",  getAnt_sug_using_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_ant_sug_using=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_sug_plan_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_sug_plan_code",  getAnt_sug_plan_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_ant_sug_plan=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_sug_plan_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_sug_plan_name",  getAnt_sug_plan_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_ant_sug_plan=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_infu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_infu_code",  getHas_infu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_has_infu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_infu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_infu_name",  getHas_infu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_has_infu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_reac_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_reac_code",  getInfu_reac_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_infu_reac=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfu_reac_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infu_reac_name",  getInfu_reac_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_infu_reac=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_tran_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_tran_code",  getHas_tran_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_has_tran=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_tran_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_tran_name",  getHas_tran_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_has_tran=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTran_reac_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tran_reac_code",  getTran_reac_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_tran_reac=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTran_reac_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tran_reac_name",  getTran_reac_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_tran_reac=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_ps_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_ps_code",  getHas_ps_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_has_ps=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_ps_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_ps_name",  getHas_ps_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_has_ps=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_fall_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_fall_code",  getHas_fall_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_has_fall=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_fall_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_fall_name",  getHas_fall_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_has_fall=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_pc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_pc_code",  getHas_pc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_has_pc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_pc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_pc_name",  getHas_pc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_has_pc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_aaout_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_aaout_code",  getHas_aaout_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_has_aaout=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_aaout_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_aaout_name",  getHas_aaout_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_has_aaout=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_inicu_again_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_inicu_again_code",  getHas_inicu_again_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_has_inicu_again=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_inicu_again_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_inicu_again_name",  getHas_inicu_again_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_has_inicu_again=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_death_insug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_death_insug_code",  getHas_death_insug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_has_death_insug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_death_insug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_death_insug_name",  getHas_death_insug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_has_death_insug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_death_aftersug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_death_aftersug_code",  getHas_death_aftersug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_has_death_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_death_aftersug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_death_aftersug_name",  getHas_death_aftersug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_has_death_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_samedi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_samedi_code",  getHas_samedi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b48","id_has_samedi=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_samedi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_samedi_name",  getHas_samedi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b48","id_has_samedi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBetween_inhos_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Between_inhos_code",  getBetween_inhos_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b49","id_between_inhosdays=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBetween_inhos_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Between_inhos_name",  getBetween_inhos_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b49","id_between_inhosdays=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPs_begin_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ps_begin_code",  getPs_begin_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b50","id_ps_begintime=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPs_begin_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ps_begin_name",  getPs_begin_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b50","id_ps_begintime=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPs_stage_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ps_stage_code",  getPs_stage_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b51","id_ps_stage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPs_stage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ps_stage_name",  getPs_stage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b51","id_ps_stage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_hurtlvl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_hurtlvl_code",  getFall_hurtlvl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b52","id_fall_hurtlvl=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_hurtlvl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_hurtlvl_name",  getFall_hurtlvl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b52","id_fall_hurtlvl=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_reason_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_reason_code",  getFall_reason_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b53","id_fall_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFall_reason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fall_reason_name",  getFall_reason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b53","id_fall_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_method_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_method_code",  getPc_method_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b54","id_pc_method=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_method_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_method_name",  getPc_method_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b54","id_pc_method=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_tool_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_tool_code",  getPc_tool_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b55","id_pc_tool=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_tool_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_tool_name",  getPc_tool_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b55","id_pc_tool=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_reason_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_reason_code",  getPc_reason_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b56","id_pc_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPc_reason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pc_reason_name",  getPc_reason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b56","id_pc_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBaby_outhos_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Baby_outhos_code",  getBaby_outhos_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b57","id_baby_outhos_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBaby_outhos_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Baby_outhos_name",  getBaby_outhos_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b57","id_baby_outhos_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBetween_inicu_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Between_inicu_code",  getBetween_inicu_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b58","id_between_inicuhours=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBetween_inicu_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Between_inicu_name",  getBetween_inicu_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b58","id_between_inicuhours=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_code",  getSc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b59","id_sug_complication=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_name",  getSc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b59","id_sug_complication=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConfirmed_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Confirmed_code",  getConfirmed_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b60","id_dic_confirmed=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConfirmed_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Confirmed_name",  getConfirmed_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b60","id_dic_confirmed=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtherdi_outhos_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Otherdi_outhos_code",  getOtherdi_outhos_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b61","id_otherdi_outhos=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtherdi_outhos_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Otherdi_outhos_name",  getOtherdi_outhos_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b61","id_otherdi_outhos=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_typename_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_typename_code",  getIcu_typename_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b63","id_icu_typename=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_typename_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_typename_name",  getIcu_typename_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b63","id_icu_typename=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_situation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_situation_code",  getInhos_situation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b62","id_inhos_situation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_situation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_situation_name",  getInhos_situation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b62","id_inhos_situation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_code",  getHbsag_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b64","id_hbsag=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_name",  getHbsag_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b64","id_hbsag=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHcv_ab_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hcv_ab_code",  getHcv_ab_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b65","id_hcv_ab=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHcv_ab_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hcv_ab_name",  getHcv_ab_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b65","id_hcv_ab=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHiv_ab_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hiv_ab_code",  getHiv_ab_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b66","id_hiv_ab=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHiv_ab_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hiv_ab_name",  getHiv_ab_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b66","id_hiv_ab=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cimrfpothertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cimrfpothert");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键ID"); 
		return column;
	}
	/**
	 * 获取患者就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊号"); 
		return column;
	}
	/**
	 * 获取患者id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者id"); 
		return column;
	}
	/**
	 * 获取入院方式（id）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_transferwayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_transferway");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式（id）"); 
		return column;
	}
	/**
	 * 获取入院方式（sd）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_transferwayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_transferway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式（sd）"); 
		return column;
	}
	/**
	 * 获取入院方式（name）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_transferwayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_transferway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式（name）"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表（入院）得分入院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_socre_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_socre_in");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表（入院）得分入院"); 
		return column;
	}
	/**
	 * 获取日常生活能力评定量表（入院）得分出院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDlb_socre_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dlb_socre_out");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日常生活能力评定量表（入院）得分出院"); 
		return column;
	}
	/**
	 * 获取临床路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cipathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cipathstatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床路径"); 
		return column;
	}
	/**
	 * 获取临床路径状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cipathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cipathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床路径状况"); 
		return column;
	}
	/**
	 * 获取抗生素使用情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_using");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用情况id"); 
		return column;
	}
	/**
	 * 获取抗生素使用目的id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_purpose");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用目的id"); 
		return column;
	}
	/**
	 * 获取抗生素使用方案id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_plan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用方案id"); 
		return column;
	}
	/**
	 * 获取联合用药时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_drugcmbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_drugcmb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("联合用药时长"); 
		return column;
	}
	/**
	 * 获取是否有传染病报告表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctg_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctg_report");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有传染病报告"); 
		return column;
	}
	/**
	 * 获取特级护理天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_cinurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_cinur");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("特级护理天数"); 
		return column;
	}
	/**
	 * 获取护理级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_levCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_lev");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理级别"); 
		return column;
	}
	/**
	 * 获取是否出现危重id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hascillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hascill");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否出现危重id"); 
		return column;
	}
	/**
	 * 获取是否有非计划二次手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hasupsecsurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hasupsecsur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有非计划二次手术"); 
		return column;
	}
	/**
	 * 获取是否有进入ICU表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_inicuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_inicu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有进入ICU"); 
		return column;
	}
	/**
	 * 获取ICU名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_icu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU名称"); 
		return column;
	}
	/**
	 * 获取进入ICU时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDate_in_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Date_in_icu");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("进入ICU时间"); 
		return column;
	}
	/**
	 * 获取转成ICU时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDate_out_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Date_out_icu");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转成ICU时间"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_入院与出院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_hosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_hos");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_入院与出院"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_术前与术后表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_surgery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_术前与术后"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_临床与病理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_ciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_ci");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_临床与病理"); 
		return column;
	}
	/**
	 * 获取主要诊断出院情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_maindi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_maindi_outhos");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要诊断出院情况id"); 
		return column;
	}
	/**
	 * 获取主要诊断出院情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_maindi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_maindi_outhos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要诊断出院情况code"); 
		return column;
	}
	/**
	 * 获取主要诊断出院情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_maindi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_maindi_outhos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要诊断出院情况name"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取客户扩展字段6表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def6");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段6"); 
		return column;
	}
	/**
	 * 获取客户扩展字段7表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def7");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段7"); 
		return column;
	}
	/**
	 * 获取客户扩展字段8表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def8");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段8"); 
		return column;
	}
	/**
	 * 获取客户扩展字段9表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def9");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段9"); 
		return column;
	}
	/**
	 * 获取客户扩展字段10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def10");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段10"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取病案首页主表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案首页主表id"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_门诊与出院id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_outpaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_outpa");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_门诊与出院id"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_放射与病理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_radiationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_radiation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_放射与病理id"); 
		return column;
	}
	/**
	 * 获取抢救情况_抢救表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRescueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rescue");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抢救情况_抢救"); 
		return column;
	}
	/**
	 * 获取抢救情况_成功表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRescue_successCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rescue_success");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("抢救情况_成功"); 
		return column;
	}
	/**
	 * 获取危重病例id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_critical_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_critical_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("危重病例id"); 
		return column;
	}
	/**
	 * 获取疑难病例id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_difficult_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_difficult_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疑难病例id"); 
		return column;
	}
	/**
	 * 获取MDT病历id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mdt_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mdt_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("MDT病历id"); 
		return column;
	}
	/**
	 * 获取单病种病例id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drgs_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drgs_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单病种病例id"); 
		return column;
	}
	/**
	 * 获取时间手术病例id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_time_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_time_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间手术病例id"); 
		return column;
	}
	/**
	 * 获取危重病例编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_critical_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_critical_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("危重病例编码"); 
		return column;
	}
	/**
	 * 获取教学查房病历id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_teaching_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_teaching_case");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教学查房病历id"); 
		return column;
	}
	/**
	 * 获取危重病例名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_critical_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_critical_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("危重病例名称"); 
		return column;
	}
	/**
	 * 获取疑难病例编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_difficult_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_difficult_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疑难病例编码"); 
		return column;
	}
	/**
	 * 获取疑难病例名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_difficult_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_difficult_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疑难病例名称"); 
		return column;
	}
	/**
	 * 获取MDT病历编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mdt_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mdt_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("MDT病历编码"); 
		return column;
	}
	/**
	 * 获取MDT病历名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mdt_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mdt_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("MDT病历名称"); 
		return column;
	}
	/**
	 * 获取单病种病例编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drgs_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drgs_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单病种病例编码"); 
		return column;
	}
	/**
	 * 获取单病种病例名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drgs_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drgs_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单病种病例名称"); 
		return column;
	}
	/**
	 * 获取时间手术病例编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_time_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_time_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间手术病例编码"); 
		return column;
	}
	/**
	 * 获取时间手术病例名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_time_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_time_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间手术病例名称"); 
		return column;
	}
	/**
	 * 获取教学查房病历编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_teaching_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_teaching_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教学查房病历编码"); 
		return column;
	}
	/**
	 * 获取教学查房病历名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_teaching_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_teaching_case");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教学查房病历名称"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_入院与出院编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_hosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_hos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_入院与出院编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_入院与出院名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_hosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_hos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_入院与出院名称"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_术前与术后编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_surgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_术前与术后编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_术前与术后名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_surgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_术前与术后名称"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_临床与病理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_ciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_ci");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_临床与病理编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_门诊与出院编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_outpaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_outpa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_门诊与出院编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_临床与病理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_ciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_ci");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_临床与病理名称"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_门诊与出院名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_outpaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_outpa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_门诊与出院名称"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_放射与病理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_radiationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_radiation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_放射与病理编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_放射与病理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_radiationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_radiation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_放射与病理名称"); 
		return column;
	}
	/**
	 * 获取临床路径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cipathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cipathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床路径编码"); 
		return column;
	}
	/**
	 * 获取患者code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者code"); 
		return column;
	}
	/**
	 * 获取患者name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者name"); 
		return column;
	}
	/**
	 * 获取病案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案号"); 
		return column;
	}
	/**
	 * 获取入径情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inpathstatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况id"); 
		return column;
	}
	/**
	 * 获取入径情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inpathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况code"); 
		return column;
	}
	/**
	 * 获取入径情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inpathstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inpathstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入径情况name"); 
		return column;
	}
	/**
	 * 获取完成情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_completestatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况id"); 
		return column;
	}
	/**
	 * 获取完成情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_completestatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况code"); 
		return column;
	}
	/**
	 * 获取完成情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_completestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_completestatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成情况name"); 
		return column;
	}
	/**
	 * 获取变异情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_variationstaus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况id"); 
		return column;
	}
	/**
	 * 获取变异情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_variationstaus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况code"); 
		return column;
	}
	/**
	 * 获取变异情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_variationstausCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_variationstaus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异情况name"); 
		return column;
	}
	/**
	 * 获取退出原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuit_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quit_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退出原因"); 
		return column;
	}
	/**
	 * 获取变异原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVariation_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Variation_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("变异原因"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_sug_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_sug_using");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用情况id"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用方案id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_sug_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_sug_plan");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用方案id"); 
		return column;
	}
	/**
	 * 获取手术联合用药时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_sug_drugcmbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_sug_drugcmb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术联合用药时长"); 
		return column;
	}
	/**
	 * 获取住院期间是否输液id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_infuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_infu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输液id"); 
		return column;
	}
	/**
	 * 获取是否发生输液反应id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infu_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infu_reac");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输液反应id"); 
		return column;
	}
	/**
	 * 获取住院期间是否输血id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_tran");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输血id"); 
		return column;
	}
	/**
	 * 获取是否发生输血反应id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tran_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tran_reac");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输血反应id"); 
		return column;
	}
	/**
	 * 获取是否有压疮id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_ps");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有压疮id"); 
		return column;
	}
	/**
	 * 获取压疮分期name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ps_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ps_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮分期name"); 
		return column;
	}
	/**
	 * 获取住院期间是否跌倒或坠床id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_fallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_fall");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否跌倒或坠床id"); 
		return column;
	}
	/**
	 * 获取住院期间是否使用物理约束id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_pc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否使用物理约束id"); 
		return column;
	}
	/**
	 * 获取物理约束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHours_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hours_pc");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("物理约束时间"); 
		return column;
	}
	/**
	 * 获取是否发生人工气道脱出id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_aaoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_aaout");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生人工气道脱出id"); 
		return column;
	}
	/**
	 * 获取是否非预期的重返ICU-id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_inicu_againCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_inicu_again");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的重返ICU-id"); 
		return column;
	}
	/**
	 * 获取是否发生围术期死亡id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_death_insugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_death_insug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生围术期死亡id"); 
		return column;
	}
	/**
	 * 获取是否发生术后猝死id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_death_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_death_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生术后猝死id"); 
		return column;
	}
	/**
	 * 获取科主任id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dirofdept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任id"); 
		return column;
	}
	/**
	 * 获取科主任code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任code"); 
		return column;
	}
	/**
	 * 获取科主任name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dirofdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dirofdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科主任name"); 
		return column;
	}
	/**
	 * 获取质控医师id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qcp_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师id"); 
		return column;
	}
	/**
	 * 获取质控医师code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qcp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师code"); 
		return column;
	}
	/**
	 * 获取质控医师name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控医师name"); 
		return column;
	}
	/**
	 * 获取质控护士id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qcp_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士id"); 
		return column;
	}
	/**
	 * 获取质控护士code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_qcp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士code"); 
		return column;
	}
	/**
	 * 获取质控护士name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_qcp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_qcp_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控护士name"); 
		return column;
	}
	/**
	 * 获取质控日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQc_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qc_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("质控日期"); 
		return column;
	}
	/**
	 * 获取是否因同一疾病住院id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_samediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_samedi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否因同一疾病住院id"); 
		return column;
	}
	/**
	 * 获取抗生素使用情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_using");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用情况code"); 
		return column;
	}
	/**
	 * 获取抗生素使用情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_using");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用情况name"); 
		return column;
	}
	/**
	 * 获取抗生素使用方案code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用方案code"); 
		return column;
	}
	/**
	 * 获取抗生素使用方案name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用方案name"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_sug_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_sug_using");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用情况code"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_sug_usingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_sug_using");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用情况name"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用方案code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_sug_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_sug_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用方案code"); 
		return column;
	}
	/**
	 * 获取手术抗生素使用方案name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_sug_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_sug_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术抗生素使用方案name"); 
		return column;
	}
	/**
	 * 获取是否因同一疾病住院code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_samediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_samedi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否因同一疾病住院code"); 
		return column;
	}
	/**
	 * 获取是否因同一疾病住院name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_samediCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_samedi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否因同一疾病住院name"); 
		return column;
	}
	/**
	 * 获取住院期间是否输液code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_infuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_infu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输液code"); 
		return column;
	}
	/**
	 * 获取住院期间是否输液name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_infuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_infu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输液name"); 
		return column;
	}
	/**
	 * 获取是否发生输液反应code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infu_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infu_reac");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输液反应code"); 
		return column;
	}
	/**
	 * 获取是否发生输液反应name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infu_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infu_reac");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输液反应name"); 
		return column;
	}
	/**
	 * 获取住院期间是否输血code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_tran");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输血code"); 
		return column;
	}
	/**
	 * 获取住院期间是否输血name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_tranCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_tran");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否输血name"); 
		return column;
	}
	/**
	 * 获取是否发生输血反应code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tran_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tran_reac");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输血反应code"); 
		return column;
	}
	/**
	 * 获取是否发生输血反应name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tran_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tran_reac");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生输血反应name"); 
		return column;
	}
	/**
	 * 获取是否有压疮code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_ps");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有压疮code"); 
		return column;
	}
	/**
	 * 获取是否有压疮name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_psCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_ps");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有压疮name"); 
		return column;
	}
	/**
	 * 获取住院期间是否跌倒或坠床code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_fallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_fall");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否跌倒或坠床code"); 
		return column;
	}
	/**
	 * 获取住院期间是否跌倒或坠床name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_fallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_fall");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否跌倒或坠床name"); 
		return column;
	}
	/**
	 * 获取住院期间是否使用物理约束code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_pc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否使用物理约束code"); 
		return column;
	}
	/**
	 * 获取住院期间是否使用物理约束name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_pcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_pc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间是否使用物理约束name"); 
		return column;
	}
	/**
	 * 获取是否发生人工气道脱出code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_aaoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_aaout");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生人工气道脱出code"); 
		return column;
	}
	/**
	 * 获取是否发生人工气道脱出name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_aaoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_aaout");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生人工气道脱出name"); 
		return column;
	}
	/**
	 * 获取是否非预期的重返ICU-code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_inicu_againCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_inicu_again");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的重返ICU-code"); 
		return column;
	}
	/**
	 * 获取是否非预期的重返ICU-name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_inicu_againCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_inicu_again");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的重返ICU-name"); 
		return column;
	}
	/**
	 * 获取是否发生围术期死亡code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_death_insugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_death_insug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生围术期死亡code"); 
		return column;
	}
	/**
	 * 获取是否发生围术期死亡name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_death_insugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_death_insug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生围术期死亡name"); 
		return column;
	}
	/**
	 * 获取是否发生术后猝死code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_death_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_death_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生术后猝死code"); 
		return column;
	}
	/**
	 * 获取是否发生术后猝死name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_death_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_death_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否发生术后猝死name"); 
		return column;
	}
	/**
	 * 获取距上一次住本院时间id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_between_inhosdaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_between_inhosdays");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("距上一次住本院时间id"); 
		return column;
	}
	/**
	 * 获取距上一次住本院时间code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_between_inhosdaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_between_inhosdays");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("距上一次住本院时间code"); 
		return column;
	}
	/**
	 * 获取距上一次住本院时间name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_between_inhosdaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_between_inhosdays");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("距上一次住本院时间name"); 
		return column;
	}
	/**
	 * 获取压疮发生时间id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ps_begintimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ps_begintime");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生时间id"); 
		return column;
	}
	/**
	 * 获取压疮发生时间code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ps_begintimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ps_begintime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生时间code"); 
		return column;
	}
	/**
	 * 获取压疮发生时间name 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ps_begintimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ps_begintime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生时间name "); 
		return column;
	}
	/**
	 * 获取压疮分期id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ps_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ps_stage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮分期id"); 
		return column;
	}
	/**
	 * 获取压疮分期code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ps_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ps_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮分期code"); 
		return column;
	}
	/**
	 * 获取住院期间跌倒或坠床的伤害程度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fall_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fall_hurtlvl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间跌倒或坠床的伤害程度id"); 
		return column;
	}
	/**
	 * 获取住院期间跌倒或坠床的伤害程度code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fall_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fall_hurtlvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间跌倒或坠床的伤害程度code"); 
		return column;
	}
	/**
	 * 获取住院期间跌倒或坠床的伤害程度name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fall_hurtlvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fall_hurtlvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院期间跌倒或坠床的伤害程度name"); 
		return column;
	}
	/**
	 * 获取跌倒或坠床的原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fall_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fall_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒或坠床的原因id"); 
		return column;
	}
	/**
	 * 获取跌倒或坠床的原因code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fall_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fall_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒或坠床的原因code"); 
		return column;
	}
	/**
	 * 获取跌倒或坠床的原因name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fall_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fall_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("跌倒或坠床的原因name"); 
		return column;
	}
	/**
	 * 获取物理约束方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pc_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc_method");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束方式id"); 
		return column;
	}
	/**
	 * 获取物理约束方式code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pc_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pc_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束方式code"); 
		return column;
	}
	/**
	 * 获取物理约束方式name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pc_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pc_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束方式name"); 
		return column;
	}
	/**
	 * 获取物理约束工具id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pc_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc_tool");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束工具id"); 
		return column;
	}
	/**
	 * 获取物理约束工具code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pc_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pc_tool");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束工具code"); 
		return column;
	}
	/**
	 * 获取物理约束工具name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pc_toolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pc_tool");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束工具name"); 
		return column;
	}
	/**
	 * 获取物理约束原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pc_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pc_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束原因id"); 
		return column;
	}
	/**
	 * 获取物理约束原因code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pc_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pc_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束原因code"); 
		return column;
	}
	/**
	 * 获取物理约束原因name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pc_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pc_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物理约束原因name"); 
		return column;
	}
	/**
	 * 获取产科新生儿离院方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_baby_outhos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_baby_outhos_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科新生儿离院方式id"); 
		return column;
	}
	/**
	 * 获取产科新生儿离院方式code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_baby_outhos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_baby_outhos_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科新生儿离院方式code"); 
		return column;
	}
	/**
	 * 获取产科新生儿离院方式name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_baby_outhos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_baby_outhos_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科新生儿离院方式name"); 
		return column;
	}
	/**
	 * 获取重返ICU间隔时间id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_between_inicuhoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_between_inicuhours");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重返ICU间隔时间id"); 
		return column;
	}
	/**
	 * 获取重返ICU间隔时间code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_between_inicuhoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_between_inicuhours");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重返ICU间隔时间code"); 
		return column;
	}
	/**
	 * 获取重返ICU间隔时间name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_between_inicuhoursCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_between_inicuhours");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重返ICU间隔时间name"); 
		return column;
	}
	/**
	 * 获取抗生素使用目的code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_purpose");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用目的code"); 
		return column;
	}
	/**
	 * 获取抗生素使用目的name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_purpose");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抗生素使用目的name"); 
		return column;
	}
	/**
	 * 获取是否出现危重code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hascillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hascill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否出现危重code"); 
		return column;
	}
	/**
	 * 获取是否出现危重name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hascillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hascill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否出现危重name"); 
		return column;
	}
	/**
	 * 获取病例分型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrcasetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrcasetype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分型id"); 
		return column;
	}
	/**
	 * 获取病例分型sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrcasetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrcasetype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分型sd"); 
		return column;
	}
	/**
	 * 获取病例分型name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrcasetypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrcasetype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病例分型name"); 
		return column;
	}
	/**
	 * 获取手术后并发症id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sug_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug_complication");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术后并发症id"); 
		return column;
	}
	/**
	 * 获取手术后并发症code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sug_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug_complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术后并发症code"); 
		return column;
	}
	/**
	 * 获取手术后并发症name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sug_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug_complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术后并发症name"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_三日确诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dic_confirmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dic_confirmed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_三日确诊主键"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_三日确诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dic_confirmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dic_confirmed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_三日确诊编码"); 
		return column;
	}
	/**
	 * 获取诊断符合情况_三日确诊名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dic_confirmedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dic_confirmed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断符合情况_三日确诊名称"); 
		return column;
	}
	/**
	 * 获取全血（数量）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_blood");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("全血（数量）"); 
		return column;
	}
	/**
	 * 获取血浆（数量）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_plasmaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_plasma");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血浆（数量）"); 
		return column;
	}
	/**
	 * 获取血小板（数量）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_plateletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_platelet");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血小板（数量）"); 
		return column;
	}
	/**
	 * 获取红细胞（数量）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_erythrocyteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_erythrocyte");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("红细胞（数量）"); 
		return column;
	}
	/**
	 * 获取自体回血输（数量）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmount_autolo_transCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amount_autolo_trans");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自体回血输（数量）"); 
		return column;
	}
	/**
	 * 获取其他诊断出院情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_otherdi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_otherdi_outhos");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他诊断出院情况id"); 
		return column;
	}
	/**
	 * 获取其他诊断出院情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_otherdi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_otherdi_outhos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他诊断出院情况code"); 
		return column;
	}
	/**
	 * 获取其他诊断出院情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_otherdi_outhosCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_otherdi_outhos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他诊断出院情况name"); 
		return column;
	}
	/**
	 * 获取重症监护室名称id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_icu_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_icu_typename");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症监护室名称id"); 
		return column;
	}
	/**
	 * 获取重症监护室名称code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_icu_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_icu_typename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症监护室名称code"); 
		return column;
	}
	/**
	 * 获取重症监护室名称name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_icu_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_icu_typename");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("重症监护室名称name"); 
		return column;
	}
	/**
	 * 获取入院时情况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inhos_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inhos_situation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院时情况id"); 
		return column;
	}
	/**
	 * 获取入院时情况code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inhos_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inhos_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院时情况code"); 
		return column;
	}
	/**
	 * 获取入院时情况name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inhos_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inhos_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院时情况name"); 
		return column;
	}
	/**
	 * 获取HBsAg-id（乙型肝炎表面抗原）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbsagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hbsag");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg-id（乙型肝炎表面抗原）"); 
		return column;
	}
	/**
	 * 获取HBsAg-code（乙型肝炎表面抗原）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hbsagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hbsag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg-code（乙型肝炎表面抗原）"); 
		return column;
	}
	/**
	 * 获取HBsAg-name（乙型肝炎表面抗原）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hbsagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hbsag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HBsAg-name（乙型肝炎表面抗原）"); 
		return column;
	}
	/**
	 * 获取HCV-Ab-id（丙型肝炎抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hcv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hcv_ab");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HCV-Ab-id（丙型肝炎抗体）"); 
		return column;
	}
	/**
	 * 获取HCV-Ab-code（丙型肝炎抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hcv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hcv_ab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HCV-Ab-code（丙型肝炎抗体）"); 
		return column;
	}
	/**
	 * 获取HCV-Ab-name（丙型肝炎抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hcv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hcv_ab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HCV-Ab-name（丙型肝炎抗体）"); 
		return column;
	}
	/**
	 * 获取HIV-Ab-id（艾滋病抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hiv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hiv_ab");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV-Ab-id（艾滋病抗体）"); 
		return column;
	}
	/**
	 * 获取HIV-Ab-code（艾滋病抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hiv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hiv_ab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV-Ab-code（艾滋病抗体）"); 
		return column;
	}
	/**
	 * 获取HIV-Ab-name（艾滋病抗体）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hiv_abCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hiv_ab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV-Ab-name（艾滋病抗体）"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransferway_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transferway_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransferway_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transferway_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCipathstatus_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cipathstatus_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCipathstatus_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cipathstatus_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_using_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_using_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_using_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_using_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_purpose_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_purpose_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_purpose_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_purpose_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_plan_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_plan_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_plan_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_plan_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtg_report_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctg_report_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtg_report_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctg_report_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_lev_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_lev_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_lev_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_lev_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHascill_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hascill_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHascill_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hascill_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHasupsecsur_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasupsecsur_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHasupsecsur_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasupsecsur_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_inicu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_inicu_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_inicu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_inicu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_hos_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_hos_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_hos_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_hos_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_surgery_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_surgery_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_surgery_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_surgery_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_ci_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_ci_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_ci_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_ci_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaindi_outhos_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maindi_outhos_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMaindi_outhos_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Maindi_outhos_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_outpa_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_outpa_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_outpa_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_outpa_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_radiation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_radiation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDic_radiation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dic_radiation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCritical_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Critical_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCritical_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Critical_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDifficult_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Difficult_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDifficult_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Difficult_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMdt_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mdt_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMdt_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mdt_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrgs_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drgs_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTime_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTeaching_case_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teaching_case_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTeaching_case_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teaching_case_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInpath_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpath_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInpath_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inpath_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComplete_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complete_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComplete_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complete_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVariation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Variation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVariation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Variation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_sug_using_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_sug_using_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_sug_using_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_sug_using_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_sug_plan_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_sug_plan_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_sug_plan_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_sug_plan_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_infu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_infu_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_infu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_infu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_reac_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_reac_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfu_reac_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infu_reac_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_tran_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_tran_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_tran_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_tran_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTran_reac_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tran_reac_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTran_reac_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tran_reac_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_ps_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_ps_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_ps_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_ps_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_fall_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_fall_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_fall_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_fall_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_pc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_pc_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_pc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_pc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_aaout_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_aaout_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_aaout_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_aaout_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_inicu_again_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_inicu_again_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_inicu_again_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_inicu_again_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_death_insug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_death_insug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_death_insug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_death_insug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_death_aftersug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_death_aftersug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_death_aftersug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_death_aftersug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_samedi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_samedi_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHas_samedi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_samedi_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBetween_inhos_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Between_inhos_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBetween_inhos_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Between_inhos_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPs_begin_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ps_begin_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPs_begin_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ps_begin_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPs_stage_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ps_stage_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPs_stage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ps_stage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_hurtlvl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_hurtlvl_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_hurtlvl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_hurtlvl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_reason_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_reason_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFall_reason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fall_reason_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_method_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_method_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_method_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_method_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_tool_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_tool_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_tool_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_tool_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_reason_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_reason_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPc_reason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pc_reason_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBaby_outhos_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Baby_outhos_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBaby_outhos_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Baby_outhos_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBetween_inicu_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Between_inicu_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBetween_inicu_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Between_inicu_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConfirmed_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Confirmed_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConfirmed_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Confirmed_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtherdi_outhos_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Otherdi_outhos_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtherdi_outhos_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Otherdi_outhos_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_typename_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_typename_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_typename_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_typename_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_situation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_situation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_situation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_situation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHbsag_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHbsag_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHcv_ab_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hcv_ab_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHcv_ab_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hcv_ab_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHiv_ab_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hiv_ab_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHiv_ab_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hiv_ab_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
