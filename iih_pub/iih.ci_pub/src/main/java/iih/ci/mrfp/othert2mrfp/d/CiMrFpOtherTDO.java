package iih.ci.mrfp.othert2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.othert2mrfp.d.desc.CiMrFpOtherTDODesc;
import java.math.BigDecimal;

/**
 * 病案首页 附页 DO数据 
 * 
 */
public class CiMrFpOtherTDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键ID
	public static final String ID_CIMRFPOTHERT= "Id_cimrfpothert";
	//患者就诊号
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//入院方式（id）
	public static final String ID_TRANSFERWAY= "Id_transferway";
	//入院方式（sd）
	public static final String SD_TRANSFERWAY= "Sd_transferway";
	//入院方式（name）
	public static final String NAME_TRANSFERWAY= "Name_transferway";
	//日常生活能力评定量表（入院）得分入院
	public static final String DLB_SOCRE_IN= "Dlb_socre_in";
	//日常生活能力评定量表（入院）得分出院
	public static final String DLB_SOCRE_OUT= "Dlb_socre_out";
	//临床路径
	public static final String ID_CIPATHSTATUS= "Id_cipathstatus";
	//临床路径状况
	public static final String NAME_CIPATHSTATUS= "Name_cipathstatus";
	//抗生素使用情况id
	public static final String ID_ANT_USING= "Id_ant_using";
	//抗生素使用目的id
	public static final String ID_ANT_PURPOSE= "Id_ant_purpose";
	//抗生素使用方案id
	public static final String ID_ANT_PLAN= "Id_ant_plan";
	//联合用药时长
	public static final String DAYS_DRUGCMB= "Days_drugcmb";
	//是否有传染病报告
	public static final String ID_CTG_REPORT= "Id_ctg_report";
	//特级护理天数
	public static final String DAYS_CINUR= "Days_cinur";
	//护理级别
	public static final String ID_NUR_LEV= "Id_nur_lev";
	//是否出现危重id
	public static final String ID_HASCILL= "Id_hascill";
	//是否有非计划二次手术
	public static final String ID_HASUPSECSUR= "Id_hasupsecsur";
	//是否有进入ICU
	public static final String ID_HAS_INICU= "Id_has_inicu";
	//ICU名称
	public static final String NAME_ICU= "Name_icu";
	//进入ICU时间
	public static final String DATE_IN_ICU= "Date_in_icu";
	//转成ICU时间
	public static final String DATE_OUT_ICU= "Date_out_icu";
	//诊断符合情况_入院与出院
	public static final String ID_DIC_HOS= "Id_dic_hos";
	//诊断符合情况_术前与术后
	public static final String ID_DIC_SURGERY= "Id_dic_surgery";
	//诊断符合情况_临床与病理
	public static final String ID_DIC_CI= "Id_dic_ci";
	//主要诊断出院情况id
	public static final String ID_MAINDI_OUTHOS= "Id_maindi_outhos";
	//主要诊断出院情况code
	public static final String SD_MAINDI_OUTHOS= "Sd_maindi_outhos";
	//主要诊断出院情况name
	public static final String NAME_MAINDI_OUTHOS= "Name_maindi_outhos";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//病案首页主表id
	public static final String ID_MRTP= "Id_mrtp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//诊断符合情况_门诊与出院id
	public static final String ID_DIC_OUTPA= "Id_dic_outpa";
	//诊断符合情况_放射与病理id
	public static final String ID_DIC_RADIATION= "Id_dic_radiation";
	//抢救情况_抢救
	public static final String RESCUE= "Rescue";
	//抢救情况_成功
	public static final String RESCUE_SUCCESS= "Rescue_success";
	//危重病例id
	public static final String ID_CRITICAL_CASE= "Id_critical_case";
	//疑难病例id
	public static final String ID_DIFFICULT_CASE= "Id_difficult_case";
	//MDT病历id
	public static final String ID_MDT_CASE= "Id_mdt_case";
	//单病种病例id
	public static final String ID_DRGS_CASE= "Id_drgs_case";
	//时间手术病例id
	public static final String ID_TIME_CASE= "Id_time_case";
	//危重病例编码
	public static final String SD_CRITICAL_CASE= "Sd_critical_case";
	//教学查房病历id
	public static final String ID_TEACHING_CASE= "Id_teaching_case";
	//危重病例名称
	public static final String NAME_CRITICAL_CASE= "Name_critical_case";
	//疑难病例编码
	public static final String SD_DIFFICULT_CASE= "Sd_difficult_case";
	//疑难病例名称
	public static final String NAME_DIFFICULT_CASE= "Name_difficult_case";
	//MDT病历编码
	public static final String SD_MDT_CASE= "Sd_mdt_case";
	//MDT病历名称
	public static final String NAME_MDT_CASE= "Name_mdt_case";
	//单病种病例编码
	public static final String SD_DRGS_CASE= "Sd_drgs_case";
	//单病种病例名称
	public static final String NAME_DRGS_CASE= "Name_drgs_case";
	//时间手术病例编码
	public static final String SD_TIME_CASE= "Sd_time_case";
	//时间手术病例名称
	public static final String NAME_TIME_CASE= "Name_time_case";
	//教学查房病历编码
	public static final String SD_TEACHING_CASE= "Sd_teaching_case";
	//教学查房病历名称
	public static final String NAME_TEACHING_CASE= "Name_teaching_case";
	//诊断符合情况_入院与出院编码
	public static final String SD_DIC_HOS= "Sd_dic_hos";
	//诊断符合情况_入院与出院名称
	public static final String NAME_DIC_HOS= "Name_dic_hos";
	//诊断符合情况_术前与术后编码
	public static final String SD_DIC_SURGERY= "Sd_dic_surgery";
	//诊断符合情况_术前与术后名称
	public static final String NAME_DIC_SURGERY= "Name_dic_surgery";
	//诊断符合情况_临床与病理编码
	public static final String SD_DIC_CI= "Sd_dic_ci";
	//诊断符合情况_门诊与出院编码
	public static final String SD_DIC_OUTPA= "Sd_dic_outpa";
	//诊断符合情况_临床与病理名称
	public static final String NAME_DIC_CI= "Name_dic_ci";
	//诊断符合情况_门诊与出院名称
	public static final String NAME_DIC_OUTPA= "Name_dic_outpa";
	//诊断符合情况_放射与病理编码
	public static final String SD_DIC_RADIATION= "Sd_dic_radiation";
	//诊断符合情况_放射与病理名称
	public static final String NAME_DIC_RADIATION= "Name_dic_radiation";
	//临床路径编码
	public static final String SD_CIPATHSTATUS= "Sd_cipathstatus";
	//患者code
	public static final String SD_PAT= "Sd_pat";
	//患者name
	public static final String NAME_PAT= "Name_pat";
	//病案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//入径情况id
	public static final String ID_INPATHSTATUS= "Id_inpathstatus";
	//入径情况code
	public static final String SD_INPATHSTATUS= "Sd_inpathstatus";
	//入径情况name
	public static final String NAME_INPATHSTATUS= "Name_inpathstatus";
	//完成情况id
	public static final String ID_COMPLETESTATUS= "Id_completestatus";
	//完成情况code
	public static final String SD_COMPLETESTATUS= "Sd_completestatus";
	//完成情况name
	public static final String NAME_COMPLETESTATUS= "Name_completestatus";
	//变异情况id
	public static final String ID_VARIATIONSTAUS= "Id_variationstaus";
	//变异情况code
	public static final String SD_VARIATIONSTAUS= "Sd_variationstaus";
	//变异情况name
	public static final String NAME_VARIATIONSTAUS= "Name_variationstaus";
	//退出原因
	public static final String QUIT_REASON= "Quit_reason";
	//变异原因
	public static final String VARIATION_REASON= "Variation_reason";
	//手术抗生素使用情况id
	public static final String ID_ANT_SUG_USING= "Id_ant_sug_using";
	//手术抗生素使用方案id
	public static final String ID_ANT_SUG_PLAN= "Id_ant_sug_plan";
	//手术联合用药时长
	public static final String DAYS_SUG_DRUGCMB= "Days_sug_drugcmb";
	//住院期间是否输液id
	public static final String ID_HAS_INFU= "Id_has_infu";
	//是否发生输液反应id
	public static final String ID_INFU_REAC= "Id_infu_reac";
	//住院期间是否输血id
	public static final String ID_HAS_TRAN= "Id_has_tran";
	//是否发生输血反应id
	public static final String ID_TRAN_REAC= "Id_tran_reac";
	//是否有压疮id
	public static final String ID_HAS_PS= "Id_has_ps";
	//压疮分期name
	public static final String NAME_PS_STAGE= "Name_ps_stage";
	//住院期间是否跌倒或坠床id
	public static final String ID_HAS_FALL= "Id_has_fall";
	//住院期间是否使用物理约束id
	public static final String ID_HAS_PC= "Id_has_pc";
	//物理约束时间
	public static final String HOURS_PC= "Hours_pc";
	//是否发生人工气道脱出id
	public static final String ID_HAS_AAOUT= "Id_has_aaout";
	//是否非预期的重返ICU-id
	public static final String ID_HAS_INICU_AGAIN= "Id_has_inicu_again";
	//是否发生围术期死亡id
	public static final String ID_HAS_DEATH_INSUG= "Id_has_death_insug";
	//是否发生术后猝死id
	public static final String ID_HAS_DEATH_AFTERSUG= "Id_has_death_aftersug";
	//科主任id
	public static final String ID_DIROFDEPT= "Id_dirofdept";
	//科主任code
	public static final String SD_DIROFDEPT= "Sd_dirofdept";
	//科主任name
	public static final String NAME_DIROFDEPT= "Name_dirofdept";
	//质控医师id
	public static final String ID_QCP_DOC= "Id_qcp_doc";
	//质控医师code
	public static final String SD_QCP_DOC= "Sd_qcp_doc";
	//质控医师name
	public static final String NAME_QCP_DOC= "Name_qcp_doc";
	//质控护士id
	public static final String ID_QCP_NUR= "Id_qcp_nur";
	//质控护士code
	public static final String SD_QCP_NUR= "Sd_qcp_nur";
	//质控护士name
	public static final String NAME_QCP_NUR= "Name_qcp_nur";
	//质控日期
	public static final String QC_DATE= "Qc_date";
	//是否因同一疾病住院id
	public static final String ID_HAS_SAMEDI= "Id_has_samedi";
	//抗生素使用情况code
	public static final String SD_ANT_USING= "Sd_ant_using";
	//抗生素使用情况name
	public static final String NAME_ANT_USING= "Name_ant_using";
	//抗生素使用方案code
	public static final String SD_ANT_PLAN= "Sd_ant_plan";
	//抗生素使用方案name
	public static final String NAME_ANT_PLAN= "Name_ant_plan";
	//手术抗生素使用情况code
	public static final String SD_ANT_SUG_USING= "Sd_ant_sug_using";
	//手术抗生素使用情况name
	public static final String NAME_ANT_SUG_USING= "Name_ant_sug_using";
	//手术抗生素使用方案code
	public static final String SD_ANT_SUG_PLAN= "Sd_ant_sug_plan";
	//手术抗生素使用方案name
	public static final String NAME_ANT_SUG_PLAN= "Name_ant_sug_plan";
	//是否因同一疾病住院code
	public static final String SD_HAS_SAMEDI= "Sd_has_samedi";
	//是否因同一疾病住院name
	public static final String NAME_HAS_SAMEDI= "Name_has_samedi";
	//住院期间是否输液code
	public static final String SD_HAS_INFU= "Sd_has_infu";
	//住院期间是否输液name
	public static final String NAME_HAS_INFU= "Name_has_infu";
	//是否发生输液反应code
	public static final String SD_INFU_REAC= "Sd_infu_reac";
	//是否发生输液反应name
	public static final String NAME_INFU_REAC= "Name_infu_reac";
	//住院期间是否输血code
	public static final String SD_HAS_TRAN= "Sd_has_tran";
	//住院期间是否输血name
	public static final String NAME_HAS_TRAN= "Name_has_tran";
	//是否发生输血反应code
	public static final String SD_TRAN_REAC= "Sd_tran_reac";
	//是否发生输血反应name
	public static final String NAME_TRAN_REAC= "Name_tran_reac";
	//是否有压疮code
	public static final String SD_HAS_PS= "Sd_has_ps";
	//是否有压疮name
	public static final String NAME_HAS_PS= "Name_has_ps";
	//住院期间是否跌倒或坠床code
	public static final String SD_HAS_FALL= "Sd_has_fall";
	//住院期间是否跌倒或坠床name
	public static final String NAME_HAS_FALL= "Name_has_fall";
	//住院期间是否使用物理约束code
	public static final String SD_HAS_PC= "Sd_has_pc";
	//住院期间是否使用物理约束name
	public static final String NAME_HAS_PC= "Name_has_pc";
	//是否发生人工气道脱出code
	public static final String SD_HAS_AAOUT= "Sd_has_aaout";
	//是否发生人工气道脱出name
	public static final String NAME_HAS_AAOUT= "Name_has_aaout";
	//是否非预期的重返ICU-code
	public static final String SD_HAS_INICU_AGAIN= "Sd_has_inicu_again";
	//是否非预期的重返ICU-name
	public static final String NAME_HAS_INICU_AGAIN= "Name_has_inicu_again";
	//是否发生围术期死亡code
	public static final String SD_HAS_DEATH_INSUG= "Sd_has_death_insug";
	//是否发生围术期死亡name
	public static final String NAME_HAS_DEATH_INSUG= "Name_has_death_insug";
	//是否发生术后猝死code
	public static final String SD_HAS_DEATH_AFTERSUG= "Sd_has_death_aftersug";
	//是否发生术后猝死name
	public static final String NAME_HAS_DEATH_AFTERSUG= "Name_has_death_aftersug";
	//距上一次住本院时间id
	public static final String ID_BETWEEN_INHOSDAYS= "Id_between_inhosdays";
	//距上一次住本院时间code
	public static final String SD_BETWEEN_INHOSDAYS= "Sd_between_inhosdays";
	//距上一次住本院时间name
	public static final String NAME_BETWEEN_INHOSDAYS= "Name_between_inhosdays";
	//压疮发生时间id
	public static final String ID_PS_BEGINTIME= "Id_ps_begintime";
	//压疮发生时间code
	public static final String SD_PS_BEGINTIME= "Sd_ps_begintime";
	//压疮发生时间name 
	public static final String NAME_PS_BEGINTIME= "Name_ps_begintime";
	//压疮分期id
	public static final String ID_PS_STAGE= "Id_ps_stage";
	//压疮分期code
	public static final String SD_PS_STAGE= "Sd_ps_stage";
	//住院期间跌倒或坠床的伤害程度id
	public static final String ID_FALL_HURTLVL= "Id_fall_hurtlvl";
	//住院期间跌倒或坠床的伤害程度code
	public static final String SD_FALL_HURTLVL= "Sd_fall_hurtlvl";
	//住院期间跌倒或坠床的伤害程度name
	public static final String NAME_FALL_HURTLVL= "Name_fall_hurtlvl";
	//跌倒或坠床的原因id
	public static final String ID_FALL_REASON= "Id_fall_reason";
	//跌倒或坠床的原因code
	public static final String SD_FALL_REASON= "Sd_fall_reason";
	//跌倒或坠床的原因name
	public static final String NAME_FALL_REASON= "Name_fall_reason";
	//物理约束方式id
	public static final String ID_PC_METHOD= "Id_pc_method";
	//物理约束方式code
	public static final String SD_PC_METHOD= "Sd_pc_method";
	//物理约束方式name
	public static final String NAME_PC_METHOD= "Name_pc_method";
	//物理约束工具id
	public static final String ID_PC_TOOL= "Id_pc_tool";
	//物理约束工具code
	public static final String SD_PC_TOOL= "Sd_pc_tool";
	//物理约束工具name
	public static final String NAME_PC_TOOL= "Name_pc_tool";
	//物理约束原因id
	public static final String ID_PC_REASON= "Id_pc_reason";
	//物理约束原因code
	public static final String SD_PC_REASON= "Sd_pc_reason";
	//物理约束原因name
	public static final String NAME_PC_REASON= "Name_pc_reason";
	//产科新生儿离院方式id
	public static final String ID_BABY_OUTHOS_REASON= "Id_baby_outhos_reason";
	//产科新生儿离院方式code
	public static final String SD_BABY_OUTHOS_REASON= "Sd_baby_outhos_reason";
	//产科新生儿离院方式name
	public static final String NAME_BABY_OUTHOS_REASON= "Name_baby_outhos_reason";
	//重返ICU间隔时间id
	public static final String ID_BETWEEN_INICUHOURS= "Id_between_inicuhours";
	//重返ICU间隔时间code
	public static final String SD_BETWEEN_INICUHOURS= "Sd_between_inicuhours";
	//重返ICU间隔时间name
	public static final String NAME_BETWEEN_INICUHOURS= "Name_between_inicuhours";
	//抗生素使用目的code
	public static final String SD_ANT_PURPOSE= "Sd_ant_purpose";
	//抗生素使用目的name
	public static final String NAME_ANT_PURPOSE= "Name_ant_purpose";
	//是否出现危重code
	public static final String SD_HASCILL= "Sd_hascill";
	//是否出现危重name
	public static final String NAME_HASCILL= "Name_hascill";
	//病例分型id
	public static final String ID_MRCASETYPE= "Id_mrcasetype";
	//病例分型sd
	public static final String SD_MRCASETYPE= "Sd_mrcasetype";
	//病例分型name
	public static final String NAME_MRCASETYPE= "Name_mrcasetype";
	//手术后并发症id
	public static final String ID_SUG_COMPLICATION= "Id_sug_complication";
	//手术后并发症code
	public static final String SD_SUG_COMPLICATION= "Sd_sug_complication";
	//手术后并发症name
	public static final String NAME_SUG_COMPLICATION= "Name_sug_complication";
	//诊断符合情况_三日确诊主键
	public static final String ID_DIC_CONFIRMED= "Id_dic_confirmed";
	//诊断符合情况_三日确诊编码
	public static final String SD_DIC_CONFIRMED= "Sd_dic_confirmed";
	//诊断符合情况_三日确诊名称
	public static final String NAME_DIC_CONFIRMED= "Name_dic_confirmed";
	//全血（数量）
	public static final String AMOUNT_BLOOD= "Amount_blood";
	//血浆（数量）
	public static final String AMOUNT_PLASMA= "Amount_plasma";
	//血小板（数量）
	public static final String AMOUNT_PLATELET= "Amount_platelet";
	//红细胞（数量）
	public static final String AMOUNT_ERYTHROCYTE= "Amount_erythrocyte";
	//自体回血输（数量）
	public static final String AMOUNT_AUTOLO_TRANS= "Amount_autolo_trans";
	//其他诊断出院情况id
	public static final String ID_OTHERDI_OUTHOS= "Id_otherdi_outhos";
	//其他诊断出院情况code
	public static final String SD_OTHERDI_OUTHOS= "Sd_otherdi_outhos";
	//其他诊断出院情况name
	public static final String NAME_OTHERDI_OUTHOS= "Name_otherdi_outhos";
	//重症监护室名称id
	public static final String ID_ICU_TYPENAME= "Id_icu_typename";
	//重症监护室名称code
	public static final String SD_ICU_TYPENAME= "Sd_icu_typename";
	//重症监护室名称name
	public static final String NAME_ICU_TYPENAME= "Name_icu_typename";
	//入院时情况id
	public static final String ID_INHOS_SITUATION= "Id_inhos_situation";
	//入院时情况code
	public static final String SD_INHOS_SITUATION= "Sd_inhos_situation";
	//入院时情况name
	public static final String NAME_INHOS_SITUATION= "Name_inhos_situation";
	//HBsAg-id（乙型肝炎表面抗原）
	public static final String ID_HBSAG= "Id_hbsag";
	//HBsAg-code（乙型肝炎表面抗原）
	public static final String SD_HBSAG= "Sd_hbsag";
	//HBsAg-name（乙型肝炎表面抗原）
	public static final String NAME_HBSAG= "Name_hbsag";
	//HCV-Ab-id（丙型肝炎抗体）
	public static final String ID_HCV_AB= "Id_hcv_ab";
	//HCV-Ab-code（丙型肝炎抗体）
	public static final String SD_HCV_AB= "Sd_hcv_ab";
	//HCV-Ab-name（丙型肝炎抗体）
	public static final String NAME_HCV_AB= "Name_hcv_ab";
	//HIV-Ab-id（艾滋病抗体）
	public static final String ID_HIV_AB= "Id_hiv_ab";
	//HIV-Ab-code（艾滋病抗体）
	public static final String SD_HIV_AB= "Sd_hiv_ab";
	//HIV-Ab-name（艾滋病抗体）
	public static final String NAME_HIV_AB= "Name_hiv_ab";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//编码
	public static final String TRANSFERWAY_CODE= "Transferway_code";
	//名称
	public static final String TRANSFERWAY_NAME= "Transferway_name";
	//编码
	public static final String CIPATHSTATUS_CODE= "Cipathstatus_code";
	//名称
	public static final String CIPATHSTATUS_NAME= "Cipathstatus_name";
	//编码
	public static final String ANT_USING_CODE= "Ant_using_code";
	//名称
	public static final String ANT_USING_NAME= "Ant_using_name";
	//编码
	public static final String ANT_PURPOSE_CODE= "Ant_purpose_code";
	//名称
	public static final String ANT_PURPOSE_NAME= "Ant_purpose_name";
	//编码
	public static final String ANT_PLAN_CODE= "Ant_plan_code";
	//名称
	public static final String ANT_PLAN_NAME= "Ant_plan_name";
	//编码
	public static final String CTG_REPORT_CODE= "Ctg_report_code";
	//名称
	public static final String CTG_REPORT_NAME= "Ctg_report_name";
	//编码
	public static final String NUR_LEV_CODE= "Nur_lev_code";
	//名称
	public static final String NUR_LEV_NAME= "Nur_lev_name";
	//编码
	public static final String HASCILL_CODE= "Hascill_code";
	//名称
	public static final String HASCILL_NAME= "Hascill_name";
	//编码
	public static final String HASUPSECSUR_CODE= "Hasupsecsur_code";
	//名称
	public static final String HASUPSECSUR_NAME= "Hasupsecsur_name";
	//编码
	public static final String HAS_INICU_CODE= "Has_inicu_code";
	//名称
	public static final String HAS_INICU_NAME= "Has_inicu_name";
	//编码
	public static final String DIC_HOS_CODE= "Dic_hos_code";
	//名称
	public static final String DIC_HOS_NAME= "Dic_hos_name";
	//编码
	public static final String DIC_SURGERY_CODE= "Dic_surgery_code";
	//名称
	public static final String DIC_SURGERY_NAME= "Dic_surgery_name";
	//编码
	public static final String DIC_CI_CODE= "Dic_ci_code";
	//名称
	public static final String DIC_CI_NAME= "Dic_ci_name";
	//名称
	public static final String MAINDI_OUTHOS_NAME= "Maindi_outhos_name";
	//编码
	public static final String MAINDI_OUTHOS_CODE= "Maindi_outhos_code";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String DIC_OUTPA_CODE= "Dic_outpa_code";
	//名称
	public static final String DIC_OUTPA_NAME= "Dic_outpa_name";
	//编码
	public static final String DIC_RADIATION_CODE= "Dic_radiation_code";
	//名称
	public static final String DIC_RADIATION_NAME= "Dic_radiation_name";
	//编码
	public static final String CRITICAL_CASE_CODE= "Critical_case_code";
	//名称
	public static final String CRITICAL_CASE_NAME= "Critical_case_name";
	//编码
	public static final String DIFFICULT_CASE_CODE= "Difficult_case_code";
	//名称
	public static final String DIFFICULT_CASE_NAME= "Difficult_case_name";
	//编码
	public static final String MDT_CASE_CODE= "Mdt_case_code";
	//名称
	public static final String MDT_CASE_NAME= "Mdt_case_name";
	//编码
	public static final String DRGS_CASE_CODE= "Drgs_case_code";
	//名称
	public static final String DRGS_CASE_NAME= "Drgs_case_name";
	//编码
	public static final String TIME_CASE_CODE= "Time_case_code";
	//名称
	public static final String TIME_CASE_NAME= "Time_case_name";
	//编码
	public static final String TEACHING_CASE_CODE= "Teaching_case_code";
	//名称
	public static final String TEACHING_CASE_NAME= "Teaching_case_name";
	//编码
	public static final String INPATH_CODE= "Inpath_code";
	//名称
	public static final String INPATH_NAME= "Inpath_name";
	//编码
	public static final String COMPLETE_CODE= "Complete_code";
	//名称
	public static final String COMPLETE_NAME= "Complete_name";
	//编码
	public static final String VARIATION_CODE= "Variation_code";
	//名称
	public static final String VARIATION_NAME= "Variation_name";
	//编码
	public static final String ANT_SUG_USING_CODE= "Ant_sug_using_code";
	//名称
	public static final String ANT_SUG_USING_NAME= "Ant_sug_using_name";
	//编码
	public static final String ANT_SUG_PLAN_CODE= "Ant_sug_plan_code";
	//名称
	public static final String ANT_SUG_PLAN_NAME= "Ant_sug_plan_name";
	//编码
	public static final String HAS_INFU_CODE= "Has_infu_code";
	//名称
	public static final String HAS_INFU_NAME= "Has_infu_name";
	//编码
	public static final String INFU_REAC_CODE= "Infu_reac_code";
	//名称
	public static final String INFU_REAC_NAME= "Infu_reac_name";
	//编码
	public static final String HAS_TRAN_CODE= "Has_tran_code";
	//名称
	public static final String HAS_TRAN_NAME= "Has_tran_name";
	//编码
	public static final String TRAN_REAC_CODE= "Tran_reac_code";
	//名称
	public static final String TRAN_REAC_NAME= "Tran_reac_name";
	//编码
	public static final String HAS_PS_CODE= "Has_ps_code";
	//名称
	public static final String HAS_PS_NAME= "Has_ps_name";
	//编码
	public static final String HAS_FALL_CODE= "Has_fall_code";
	//名称
	public static final String HAS_FALL_NAME= "Has_fall_name";
	//编码
	public static final String HAS_PC_CODE= "Has_pc_code";
	//名称
	public static final String HAS_PC_NAME= "Has_pc_name";
	//编码
	public static final String HAS_AAOUT_CODE= "Has_aaout_code";
	//名称
	public static final String HAS_AAOUT_NAME= "Has_aaout_name";
	//编码
	public static final String HAS_INICU_AGAIN_CODE= "Has_inicu_again_code";
	//名称
	public static final String HAS_INICU_AGAIN_NAME= "Has_inicu_again_name";
	//编码
	public static final String HAS_DEATH_INSUG_CODE= "Has_death_insug_code";
	//名称
	public static final String HAS_DEATH_INSUG_NAME= "Has_death_insug_name";
	//编码
	public static final String HAS_DEATH_AFTERSUG_CODE= "Has_death_aftersug_code";
	//名称
	public static final String HAS_DEATH_AFTERSUG_NAME= "Has_death_aftersug_name";
	//编码
	public static final String HAS_SAMEDI_CODE= "Has_samedi_code";
	//名称
	public static final String HAS_SAMEDI_NAME= "Has_samedi_name";
	//编码
	public static final String BETWEEN_INHOS_CODE= "Between_inhos_code";
	//名称
	public static final String BETWEEN_INHOS_NAME= "Between_inhos_name";
	//编码
	public static final String PS_BEGIN_CODE= "Ps_begin_code";
	//名称
	public static final String PS_BEGIN_NAME= "Ps_begin_name";
	//编码
	public static final String PS_STAGE_CODE= "Ps_stage_code";
	//名称
	public static final String PS_STAGE_NAME= "Ps_stage_name";
	//编码
	public static final String FALL_HURTLVL_CODE= "Fall_hurtlvl_code";
	//名称
	public static final String FALL_HURTLVL_NAME= "Fall_hurtlvl_name";
	//编码
	public static final String FALL_REASON_CODE= "Fall_reason_code";
	//名称
	public static final String FALL_REASON_NAME= "Fall_reason_name";
	//编码
	public static final String PC_METHOD_CODE= "Pc_method_code";
	//名称
	public static final String PC_METHOD_NAME= "Pc_method_name";
	//编码
	public static final String PC_TOOL_CODE= "Pc_tool_code";
	//名称
	public static final String PC_TOOL_NAME= "Pc_tool_name";
	//编码
	public static final String PC_REASON_CODE= "Pc_reason_code";
	//名称
	public static final String PC_REASON_NAME= "Pc_reason_name";
	//编码
	public static final String BABY_OUTHOS_CODE= "Baby_outhos_code";
	//名称
	public static final String BABY_OUTHOS_NAME= "Baby_outhos_name";
	//编码
	public static final String BETWEEN_INICU_CODE= "Between_inicu_code";
	//名称
	public static final String BETWEEN_INICU_NAME= "Between_inicu_name";
	//编码
	public static final String SC_CODE= "Sc_code";
	//名称
	public static final String SC_NAME= "Sc_name";
	//编码
	public static final String CONFIRMED_CODE= "Confirmed_code";
	//名称
	public static final String CONFIRMED_NAME= "Confirmed_name";
	//编码
	public static final String OTHERDI_OUTHOS_CODE= "Otherdi_outhos_code";
	//名称
	public static final String OTHERDI_OUTHOS_NAME= "Otherdi_outhos_name";
	//编码
	public static final String ICU_TYPENAME_CODE= "Icu_typename_code";
	//名称
	public static final String ICU_TYPENAME_NAME= "Icu_typename_name";
	//编码
	public static final String INHOS_SITUATION_CODE= "Inhos_situation_code";
	//名称
	public static final String INHOS_SITUATION_NAME= "Inhos_situation_name";
	//编码
	public static final String HBSAG_CODE= "Hbsag_code";
	//名称
	public static final String HBSAG_NAME= "Hbsag_name";
	//编码
	public static final String HCV_AB_CODE= "Hcv_ab_code";
	//名称
	public static final String HCV_AB_NAME= "Hcv_ab_name";
	//编码
	public static final String HIV_AB_CODE= "Hiv_ab_code";
	//名称
	public static final String HIV_AB_NAME= "Hiv_ab_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键ID
	 * @return String
	 */
	public String getId_cimrfpothert() {
		return ((String) getAttrVal("Id_cimrfpothert"));
	}	
	/**
	 * 主键ID
	 * @param Id_cimrfpothert
	 */
	public void setId_cimrfpothert(String Id_cimrfpothert) {
		setAttrVal("Id_cimrfpothert", Id_cimrfpothert);
	}
	/**
	 * 患者就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 入院方式（id）
	 * @return String
	 */
	public String getId_transferway() {
		return ((String) getAttrVal("Id_transferway"));
	}	
	/**
	 * 入院方式（id）
	 * @param Id_transferway
	 */
	public void setId_transferway(String Id_transferway) {
		setAttrVal("Id_transferway", Id_transferway);
	}
	/**
	 * 入院方式（sd）
	 * @return String
	 */
	public String getSd_transferway() {
		return ((String) getAttrVal("Sd_transferway"));
	}	
	/**
	 * 入院方式（sd）
	 * @param Sd_transferway
	 */
	public void setSd_transferway(String Sd_transferway) {
		setAttrVal("Sd_transferway", Sd_transferway);
	}
	/**
	 * 入院方式（name）
	 * @return String
	 */
	public String getName_transferway() {
		return ((String) getAttrVal("Name_transferway"));
	}	
	/**
	 * 入院方式（name）
	 * @param Name_transferway
	 */
	public void setName_transferway(String Name_transferway) {
		setAttrVal("Name_transferway", Name_transferway);
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @return String
	 */
	public String getDlb_socre_in() {
		return ((String) getAttrVal("Dlb_socre_in"));
	}	
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @param Dlb_socre_in
	 */
	public void setDlb_socre_in(String Dlb_socre_in) {
		setAttrVal("Dlb_socre_in", Dlb_socre_in);
	}
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @return String
	 */
	public String getDlb_socre_out() {
		return ((String) getAttrVal("Dlb_socre_out"));
	}	
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @param Dlb_socre_out
	 */
	public void setDlb_socre_out(String Dlb_socre_out) {
		setAttrVal("Dlb_socre_out", Dlb_socre_out);
	}
	/**
	 * 临床路径
	 * @return String
	 */
	public String getId_cipathstatus() {
		return ((String) getAttrVal("Id_cipathstatus"));
	}	
	/**
	 * 临床路径
	 * @param Id_cipathstatus
	 */
	public void setId_cipathstatus(String Id_cipathstatus) {
		setAttrVal("Id_cipathstatus", Id_cipathstatus);
	}
	/**
	 * 临床路径状况
	 * @return String
	 */
	public String getName_cipathstatus() {
		return ((String) getAttrVal("Name_cipathstatus"));
	}	
	/**
	 * 临床路径状况
	 * @param Name_cipathstatus
	 */
	public void setName_cipathstatus(String Name_cipathstatus) {
		setAttrVal("Name_cipathstatus", Name_cipathstatus);
	}
	/**
	 * 抗生素使用情况id
	 * @return String
	 */
	public String getId_ant_using() {
		return ((String) getAttrVal("Id_ant_using"));
	}	
	/**
	 * 抗生素使用情况id
	 * @param Id_ant_using
	 */
	public void setId_ant_using(String Id_ant_using) {
		setAttrVal("Id_ant_using", Id_ant_using);
	}
	/**
	 * 抗生素使用目的id
	 * @return String
	 */
	public String getId_ant_purpose() {
		return ((String) getAttrVal("Id_ant_purpose"));
	}	
	/**
	 * 抗生素使用目的id
	 * @param Id_ant_purpose
	 */
	public void setId_ant_purpose(String Id_ant_purpose) {
		setAttrVal("Id_ant_purpose", Id_ant_purpose);
	}
	/**
	 * 抗生素使用方案id
	 * @return String
	 */
	public String getId_ant_plan() {
		return ((String) getAttrVal("Id_ant_plan"));
	}	
	/**
	 * 抗生素使用方案id
	 * @param Id_ant_plan
	 */
	public void setId_ant_plan(String Id_ant_plan) {
		setAttrVal("Id_ant_plan", Id_ant_plan);
	}
	/**
	 * 联合用药时长
	 * @return Integer
	 */
	public Integer getDays_drugcmb() {
		return ((Integer) getAttrVal("Days_drugcmb"));
	}	
	/**
	 * 联合用药时长
	 * @param Days_drugcmb
	 */
	public void setDays_drugcmb(Integer Days_drugcmb) {
		setAttrVal("Days_drugcmb", Days_drugcmb);
	}
	/**
	 * 是否有传染病报告
	 * @return String
	 */
	public String getId_ctg_report() {
		return ((String) getAttrVal("Id_ctg_report"));
	}	
	/**
	 * 是否有传染病报告
	 * @param Id_ctg_report
	 */
	public void setId_ctg_report(String Id_ctg_report) {
		setAttrVal("Id_ctg_report", Id_ctg_report);
	}
	/**
	 * 特级护理天数
	 * @return Integer
	 */
	public Integer getDays_cinur() {
		return ((Integer) getAttrVal("Days_cinur"));
	}	
	/**
	 * 特级护理天数
	 * @param Days_cinur
	 */
	public void setDays_cinur(Integer Days_cinur) {
		setAttrVal("Days_cinur", Days_cinur);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getId_nur_lev() {
		return ((String) getAttrVal("Id_nur_lev"));
	}	
	/**
	 * 护理级别
	 * @param Id_nur_lev
	 */
	public void setId_nur_lev(String Id_nur_lev) {
		setAttrVal("Id_nur_lev", Id_nur_lev);
	}
	/**
	 * 是否出现危重id
	 * @return String
	 */
	public String getId_hascill() {
		return ((String) getAttrVal("Id_hascill"));
	}	
	/**
	 * 是否出现危重id
	 * @param Id_hascill
	 */
	public void setId_hascill(String Id_hascill) {
		setAttrVal("Id_hascill", Id_hascill);
	}
	/**
	 * 是否有非计划二次手术
	 * @return String
	 */
	public String getId_hasupsecsur() {
		return ((String) getAttrVal("Id_hasupsecsur"));
	}	
	/**
	 * 是否有非计划二次手术
	 * @param Id_hasupsecsur
	 */
	public void setId_hasupsecsur(String Id_hasupsecsur) {
		setAttrVal("Id_hasupsecsur", Id_hasupsecsur);
	}
	/**
	 * 是否有进入ICU
	 * @return String
	 */
	public String getId_has_inicu() {
		return ((String) getAttrVal("Id_has_inicu"));
	}	
	/**
	 * 是否有进入ICU
	 * @param Id_has_inicu
	 */
	public void setId_has_inicu(String Id_has_inicu) {
		setAttrVal("Id_has_inicu", Id_has_inicu);
	}
	/**
	 * ICU名称
	 * @return String
	 */
	public String getName_icu() {
		return ((String) getAttrVal("Name_icu"));
	}	
	/**
	 * ICU名称
	 * @param Name_icu
	 */
	public void setName_icu(String Name_icu) {
		setAttrVal("Name_icu", Name_icu);
	}
	/**
	 * 进入ICU时间
	 * @return FDateTime
	 */
	public FDateTime getDate_in_icu() {
		return ((FDateTime) getAttrVal("Date_in_icu"));
	}	
	/**
	 * 进入ICU时间
	 * @param Date_in_icu
	 */
	public void setDate_in_icu(FDateTime Date_in_icu) {
		setAttrVal("Date_in_icu", Date_in_icu);
	}
	/**
	 * 转成ICU时间
	 * @return FDateTime
	 */
	public FDateTime getDate_out_icu() {
		return ((FDateTime) getAttrVal("Date_out_icu"));
	}	
	/**
	 * 转成ICU时间
	 * @param Date_out_icu
	 */
	public void setDate_out_icu(FDateTime Date_out_icu) {
		setAttrVal("Date_out_icu", Date_out_icu);
	}
	/**
	 * 诊断符合情况_入院与出院
	 * @return String
	 */
	public String getId_dic_hos() {
		return ((String) getAttrVal("Id_dic_hos"));
	}	
	/**
	 * 诊断符合情况_入院与出院
	 * @param Id_dic_hos
	 */
	public void setId_dic_hos(String Id_dic_hos) {
		setAttrVal("Id_dic_hos", Id_dic_hos);
	}
	/**
	 * 诊断符合情况_术前与术后
	 * @return String
	 */
	public String getId_dic_surgery() {
		return ((String) getAttrVal("Id_dic_surgery"));
	}	
	/**
	 * 诊断符合情况_术前与术后
	 * @param Id_dic_surgery
	 */
	public void setId_dic_surgery(String Id_dic_surgery) {
		setAttrVal("Id_dic_surgery", Id_dic_surgery);
	}
	/**
	 * 诊断符合情况_临床与病理
	 * @return String
	 */
	public String getId_dic_ci() {
		return ((String) getAttrVal("Id_dic_ci"));
	}	
	/**
	 * 诊断符合情况_临床与病理
	 * @param Id_dic_ci
	 */
	public void setId_dic_ci(String Id_dic_ci) {
		setAttrVal("Id_dic_ci", Id_dic_ci);
	}
	/**
	 * 主要诊断出院情况id
	 * @return String
	 */
	public String getId_maindi_outhos() {
		return ((String) getAttrVal("Id_maindi_outhos"));
	}	
	/**
	 * 主要诊断出院情况id
	 * @param Id_maindi_outhos
	 */
	public void setId_maindi_outhos(String Id_maindi_outhos) {
		setAttrVal("Id_maindi_outhos", Id_maindi_outhos);
	}
	/**
	 * 主要诊断出院情况code
	 * @return String
	 */
	public String getSd_maindi_outhos() {
		return ((String) getAttrVal("Sd_maindi_outhos"));
	}	
	/**
	 * 主要诊断出院情况code
	 * @param Sd_maindi_outhos
	 */
	public void setSd_maindi_outhos(String Sd_maindi_outhos) {
		setAttrVal("Sd_maindi_outhos", Sd_maindi_outhos);
	}
	/**
	 * 主要诊断出院情况name
	 * @return String
	 */
	public String getName_maindi_outhos() {
		return ((String) getAttrVal("Name_maindi_outhos"));
	}	
	/**
	 * 主要诊断出院情况name
	 * @param Name_maindi_outhos
	 */
	public void setName_maindi_outhos(String Name_maindi_outhos) {
		setAttrVal("Name_maindi_outhos", Name_maindi_outhos);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 病案首页主表id
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 病案首页主表id
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 诊断符合情况_门诊与出院id
	 * @return String
	 */
	public String getId_dic_outpa() {
		return ((String) getAttrVal("Id_dic_outpa"));
	}	
	/**
	 * 诊断符合情况_门诊与出院id
	 * @param Id_dic_outpa
	 */
	public void setId_dic_outpa(String Id_dic_outpa) {
		setAttrVal("Id_dic_outpa", Id_dic_outpa);
	}
	/**
	 * 诊断符合情况_放射与病理id
	 * @return String
	 */
	public String getId_dic_radiation() {
		return ((String) getAttrVal("Id_dic_radiation"));
	}	
	/**
	 * 诊断符合情况_放射与病理id
	 * @param Id_dic_radiation
	 */
	public void setId_dic_radiation(String Id_dic_radiation) {
		setAttrVal("Id_dic_radiation", Id_dic_radiation);
	}
	/**
	 * 抢救情况_抢救
	 * @return Integer
	 */
	public Integer getRescue() {
		return ((Integer) getAttrVal("Rescue"));
	}	
	/**
	 * 抢救情况_抢救
	 * @param Rescue
	 */
	public void setRescue(Integer Rescue) {
		setAttrVal("Rescue", Rescue);
	}
	/**
	 * 抢救情况_成功
	 * @return Integer
	 */
	public Integer getRescue_success() {
		return ((Integer) getAttrVal("Rescue_success"));
	}	
	/**
	 * 抢救情况_成功
	 * @param Rescue_success
	 */
	public void setRescue_success(Integer Rescue_success) {
		setAttrVal("Rescue_success", Rescue_success);
	}
	/**
	 * 危重病例id
	 * @return String
	 */
	public String getId_critical_case() {
		return ((String) getAttrVal("Id_critical_case"));
	}	
	/**
	 * 危重病例id
	 * @param Id_critical_case
	 */
	public void setId_critical_case(String Id_critical_case) {
		setAttrVal("Id_critical_case", Id_critical_case);
	}
	/**
	 * 疑难病例id
	 * @return String
	 */
	public String getId_difficult_case() {
		return ((String) getAttrVal("Id_difficult_case"));
	}	
	/**
	 * 疑难病例id
	 * @param Id_difficult_case
	 */
	public void setId_difficult_case(String Id_difficult_case) {
		setAttrVal("Id_difficult_case", Id_difficult_case);
	}
	/**
	 * MDT病历id
	 * @return String
	 */
	public String getId_mdt_case() {
		return ((String) getAttrVal("Id_mdt_case"));
	}	
	/**
	 * MDT病历id
	 * @param Id_mdt_case
	 */
	public void setId_mdt_case(String Id_mdt_case) {
		setAttrVal("Id_mdt_case", Id_mdt_case);
	}
	/**
	 * 单病种病例id
	 * @return String
	 */
	public String getId_drgs_case() {
		return ((String) getAttrVal("Id_drgs_case"));
	}	
	/**
	 * 单病种病例id
	 * @param Id_drgs_case
	 */
	public void setId_drgs_case(String Id_drgs_case) {
		setAttrVal("Id_drgs_case", Id_drgs_case);
	}
	/**
	 * 时间手术病例id
	 * @return String
	 */
	public String getId_time_case() {
		return ((String) getAttrVal("Id_time_case"));
	}	
	/**
	 * 时间手术病例id
	 * @param Id_time_case
	 */
	public void setId_time_case(String Id_time_case) {
		setAttrVal("Id_time_case", Id_time_case);
	}
	/**
	 * 危重病例编码
	 * @return String
	 */
	public String getSd_critical_case() {
		return ((String) getAttrVal("Sd_critical_case"));
	}	
	/**
	 * 危重病例编码
	 * @param Sd_critical_case
	 */
	public void setSd_critical_case(String Sd_critical_case) {
		setAttrVal("Sd_critical_case", Sd_critical_case);
	}
	/**
	 * 教学查房病历id
	 * @return String
	 */
	public String getId_teaching_case() {
		return ((String) getAttrVal("Id_teaching_case"));
	}	
	/**
	 * 教学查房病历id
	 * @param Id_teaching_case
	 */
	public void setId_teaching_case(String Id_teaching_case) {
		setAttrVal("Id_teaching_case", Id_teaching_case);
	}
	/**
	 * 危重病例名称
	 * @return String
	 */
	public String getName_critical_case() {
		return ((String) getAttrVal("Name_critical_case"));
	}	
	/**
	 * 危重病例名称
	 * @param Name_critical_case
	 */
	public void setName_critical_case(String Name_critical_case) {
		setAttrVal("Name_critical_case", Name_critical_case);
	}
	/**
	 * 疑难病例编码
	 * @return String
	 */
	public String getSd_difficult_case() {
		return ((String) getAttrVal("Sd_difficult_case"));
	}	
	/**
	 * 疑难病例编码
	 * @param Sd_difficult_case
	 */
	public void setSd_difficult_case(String Sd_difficult_case) {
		setAttrVal("Sd_difficult_case", Sd_difficult_case);
	}
	/**
	 * 疑难病例名称
	 * @return String
	 */
	public String getName_difficult_case() {
		return ((String) getAttrVal("Name_difficult_case"));
	}	
	/**
	 * 疑难病例名称
	 * @param Name_difficult_case
	 */
	public void setName_difficult_case(String Name_difficult_case) {
		setAttrVal("Name_difficult_case", Name_difficult_case);
	}
	/**
	 * MDT病历编码
	 * @return String
	 */
	public String getSd_mdt_case() {
		return ((String) getAttrVal("Sd_mdt_case"));
	}	
	/**
	 * MDT病历编码
	 * @param Sd_mdt_case
	 */
	public void setSd_mdt_case(String Sd_mdt_case) {
		setAttrVal("Sd_mdt_case", Sd_mdt_case);
	}
	/**
	 * MDT病历名称
	 * @return String
	 */
	public String getName_mdt_case() {
		return ((String) getAttrVal("Name_mdt_case"));
	}	
	/**
	 * MDT病历名称
	 * @param Name_mdt_case
	 */
	public void setName_mdt_case(String Name_mdt_case) {
		setAttrVal("Name_mdt_case", Name_mdt_case);
	}
	/**
	 * 单病种病例编码
	 * @return String
	 */
	public String getSd_drgs_case() {
		return ((String) getAttrVal("Sd_drgs_case"));
	}	
	/**
	 * 单病种病例编码
	 * @param Sd_drgs_case
	 */
	public void setSd_drgs_case(String Sd_drgs_case) {
		setAttrVal("Sd_drgs_case", Sd_drgs_case);
	}
	/**
	 * 单病种病例名称
	 * @return String
	 */
	public String getName_drgs_case() {
		return ((String) getAttrVal("Name_drgs_case"));
	}	
	/**
	 * 单病种病例名称
	 * @param Name_drgs_case
	 */
	public void setName_drgs_case(String Name_drgs_case) {
		setAttrVal("Name_drgs_case", Name_drgs_case);
	}
	/**
	 * 时间手术病例编码
	 * @return String
	 */
	public String getSd_time_case() {
		return ((String) getAttrVal("Sd_time_case"));
	}	
	/**
	 * 时间手术病例编码
	 * @param Sd_time_case
	 */
	public void setSd_time_case(String Sd_time_case) {
		setAttrVal("Sd_time_case", Sd_time_case);
	}
	/**
	 * 时间手术病例名称
	 * @return String
	 */
	public String getName_time_case() {
		return ((String) getAttrVal("Name_time_case"));
	}	
	/**
	 * 时间手术病例名称
	 * @param Name_time_case
	 */
	public void setName_time_case(String Name_time_case) {
		setAttrVal("Name_time_case", Name_time_case);
	}
	/**
	 * 教学查房病历编码
	 * @return String
	 */
	public String getSd_teaching_case() {
		return ((String) getAttrVal("Sd_teaching_case"));
	}	
	/**
	 * 教学查房病历编码
	 * @param Sd_teaching_case
	 */
	public void setSd_teaching_case(String Sd_teaching_case) {
		setAttrVal("Sd_teaching_case", Sd_teaching_case);
	}
	/**
	 * 教学查房病历名称
	 * @return String
	 */
	public String getName_teaching_case() {
		return ((String) getAttrVal("Name_teaching_case"));
	}	
	/**
	 * 教学查房病历名称
	 * @param Name_teaching_case
	 */
	public void setName_teaching_case(String Name_teaching_case) {
		setAttrVal("Name_teaching_case", Name_teaching_case);
	}
	/**
	 * 诊断符合情况_入院与出院编码
	 * @return String
	 */
	public String getSd_dic_hos() {
		return ((String) getAttrVal("Sd_dic_hos"));
	}	
	/**
	 * 诊断符合情况_入院与出院编码
	 * @param Sd_dic_hos
	 */
	public void setSd_dic_hos(String Sd_dic_hos) {
		setAttrVal("Sd_dic_hos", Sd_dic_hos);
	}
	/**
	 * 诊断符合情况_入院与出院名称
	 * @return String
	 */
	public String getName_dic_hos() {
		return ((String) getAttrVal("Name_dic_hos"));
	}	
	/**
	 * 诊断符合情况_入院与出院名称
	 * @param Name_dic_hos
	 */
	public void setName_dic_hos(String Name_dic_hos) {
		setAttrVal("Name_dic_hos", Name_dic_hos);
	}
	/**
	 * 诊断符合情况_术前与术后编码
	 * @return String
	 */
	public String getSd_dic_surgery() {
		return ((String) getAttrVal("Sd_dic_surgery"));
	}	
	/**
	 * 诊断符合情况_术前与术后编码
	 * @param Sd_dic_surgery
	 */
	public void setSd_dic_surgery(String Sd_dic_surgery) {
		setAttrVal("Sd_dic_surgery", Sd_dic_surgery);
	}
	/**
	 * 诊断符合情况_术前与术后名称
	 * @return String
	 */
	public String getName_dic_surgery() {
		return ((String) getAttrVal("Name_dic_surgery"));
	}	
	/**
	 * 诊断符合情况_术前与术后名称
	 * @param Name_dic_surgery
	 */
	public void setName_dic_surgery(String Name_dic_surgery) {
		setAttrVal("Name_dic_surgery", Name_dic_surgery);
	}
	/**
	 * 诊断符合情况_临床与病理编码
	 * @return String
	 */
	public String getSd_dic_ci() {
		return ((String) getAttrVal("Sd_dic_ci"));
	}	
	/**
	 * 诊断符合情况_临床与病理编码
	 * @param Sd_dic_ci
	 */
	public void setSd_dic_ci(String Sd_dic_ci) {
		setAttrVal("Sd_dic_ci", Sd_dic_ci);
	}
	/**
	 * 诊断符合情况_门诊与出院编码
	 * @return String
	 */
	public String getSd_dic_outpa() {
		return ((String) getAttrVal("Sd_dic_outpa"));
	}	
	/**
	 * 诊断符合情况_门诊与出院编码
	 * @param Sd_dic_outpa
	 */
	public void setSd_dic_outpa(String Sd_dic_outpa) {
		setAttrVal("Sd_dic_outpa", Sd_dic_outpa);
	}
	/**
	 * 诊断符合情况_临床与病理名称
	 * @return String
	 */
	public String getName_dic_ci() {
		return ((String) getAttrVal("Name_dic_ci"));
	}	
	/**
	 * 诊断符合情况_临床与病理名称
	 * @param Name_dic_ci
	 */
	public void setName_dic_ci(String Name_dic_ci) {
		setAttrVal("Name_dic_ci", Name_dic_ci);
	}
	/**
	 * 诊断符合情况_门诊与出院名称
	 * @return String
	 */
	public String getName_dic_outpa() {
		return ((String) getAttrVal("Name_dic_outpa"));
	}	
	/**
	 * 诊断符合情况_门诊与出院名称
	 * @param Name_dic_outpa
	 */
	public void setName_dic_outpa(String Name_dic_outpa) {
		setAttrVal("Name_dic_outpa", Name_dic_outpa);
	}
	/**
	 * 诊断符合情况_放射与病理编码
	 * @return String
	 */
	public String getSd_dic_radiation() {
		return ((String) getAttrVal("Sd_dic_radiation"));
	}	
	/**
	 * 诊断符合情况_放射与病理编码
	 * @param Sd_dic_radiation
	 */
	public void setSd_dic_radiation(String Sd_dic_radiation) {
		setAttrVal("Sd_dic_radiation", Sd_dic_radiation);
	}
	/**
	 * 诊断符合情况_放射与病理名称
	 * @return String
	 */
	public String getName_dic_radiation() {
		return ((String) getAttrVal("Name_dic_radiation"));
	}	
	/**
	 * 诊断符合情况_放射与病理名称
	 * @param Name_dic_radiation
	 */
	public void setName_dic_radiation(String Name_dic_radiation) {
		setAttrVal("Name_dic_radiation", Name_dic_radiation);
	}
	/**
	 * 临床路径编码
	 * @return String
	 */
	public String getSd_cipathstatus() {
		return ((String) getAttrVal("Sd_cipathstatus"));
	}	
	/**
	 * 临床路径编码
	 * @param Sd_cipathstatus
	 */
	public void setSd_cipathstatus(String Sd_cipathstatus) {
		setAttrVal("Sd_cipathstatus", Sd_cipathstatus);
	}
	/**
	 * 患者code
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 患者code
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者name
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者name
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 入径情况id
	 * @return String
	 */
	public String getId_inpathstatus() {
		return ((String) getAttrVal("Id_inpathstatus"));
	}	
	/**
	 * 入径情况id
	 * @param Id_inpathstatus
	 */
	public void setId_inpathstatus(String Id_inpathstatus) {
		setAttrVal("Id_inpathstatus", Id_inpathstatus);
	}
	/**
	 * 入径情况code
	 * @return String
	 */
	public String getSd_inpathstatus() {
		return ((String) getAttrVal("Sd_inpathstatus"));
	}	
	/**
	 * 入径情况code
	 * @param Sd_inpathstatus
	 */
	public void setSd_inpathstatus(String Sd_inpathstatus) {
		setAttrVal("Sd_inpathstatus", Sd_inpathstatus);
	}
	/**
	 * 入径情况name
	 * @return String
	 */
	public String getName_inpathstatus() {
		return ((String) getAttrVal("Name_inpathstatus"));
	}	
	/**
	 * 入径情况name
	 * @param Name_inpathstatus
	 */
	public void setName_inpathstatus(String Name_inpathstatus) {
		setAttrVal("Name_inpathstatus", Name_inpathstatus);
	}
	/**
	 * 完成情况id
	 * @return String
	 */
	public String getId_completestatus() {
		return ((String) getAttrVal("Id_completestatus"));
	}	
	/**
	 * 完成情况id
	 * @param Id_completestatus
	 */
	public void setId_completestatus(String Id_completestatus) {
		setAttrVal("Id_completestatus", Id_completestatus);
	}
	/**
	 * 完成情况code
	 * @return String
	 */
	public String getSd_completestatus() {
		return ((String) getAttrVal("Sd_completestatus"));
	}	
	/**
	 * 完成情况code
	 * @param Sd_completestatus
	 */
	public void setSd_completestatus(String Sd_completestatus) {
		setAttrVal("Sd_completestatus", Sd_completestatus);
	}
	/**
	 * 完成情况name
	 * @return String
	 */
	public String getName_completestatus() {
		return ((String) getAttrVal("Name_completestatus"));
	}	
	/**
	 * 完成情况name
	 * @param Name_completestatus
	 */
	public void setName_completestatus(String Name_completestatus) {
		setAttrVal("Name_completestatus", Name_completestatus);
	}
	/**
	 * 变异情况id
	 * @return String
	 */
	public String getId_variationstaus() {
		return ((String) getAttrVal("Id_variationstaus"));
	}	
	/**
	 * 变异情况id
	 * @param Id_variationstaus
	 */
	public void setId_variationstaus(String Id_variationstaus) {
		setAttrVal("Id_variationstaus", Id_variationstaus);
	}
	/**
	 * 变异情况code
	 * @return String
	 */
	public String getSd_variationstaus() {
		return ((String) getAttrVal("Sd_variationstaus"));
	}	
	/**
	 * 变异情况code
	 * @param Sd_variationstaus
	 */
	public void setSd_variationstaus(String Sd_variationstaus) {
		setAttrVal("Sd_variationstaus", Sd_variationstaus);
	}
	/**
	 * 变异情况name
	 * @return String
	 */
	public String getName_variationstaus() {
		return ((String) getAttrVal("Name_variationstaus"));
	}	
	/**
	 * 变异情况name
	 * @param Name_variationstaus
	 */
	public void setName_variationstaus(String Name_variationstaus) {
		setAttrVal("Name_variationstaus", Name_variationstaus);
	}
	/**
	 * 退出原因
	 * @return String
	 */
	public String getQuit_reason() {
		return ((String) getAttrVal("Quit_reason"));
	}	
	/**
	 * 退出原因
	 * @param Quit_reason
	 */
	public void setQuit_reason(String Quit_reason) {
		setAttrVal("Quit_reason", Quit_reason);
	}
	/**
	 * 变异原因
	 * @return String
	 */
	public String getVariation_reason() {
		return ((String) getAttrVal("Variation_reason"));
	}	
	/**
	 * 变异原因
	 * @param Variation_reason
	 */
	public void setVariation_reason(String Variation_reason) {
		setAttrVal("Variation_reason", Variation_reason);
	}
	/**
	 * 手术抗生素使用情况id
	 * @return String
	 */
	public String getId_ant_sug_using() {
		return ((String) getAttrVal("Id_ant_sug_using"));
	}	
	/**
	 * 手术抗生素使用情况id
	 * @param Id_ant_sug_using
	 */
	public void setId_ant_sug_using(String Id_ant_sug_using) {
		setAttrVal("Id_ant_sug_using", Id_ant_sug_using);
	}
	/**
	 * 手术抗生素使用方案id
	 * @return String
	 */
	public String getId_ant_sug_plan() {
		return ((String) getAttrVal("Id_ant_sug_plan"));
	}	
	/**
	 * 手术抗生素使用方案id
	 * @param Id_ant_sug_plan
	 */
	public void setId_ant_sug_plan(String Id_ant_sug_plan) {
		setAttrVal("Id_ant_sug_plan", Id_ant_sug_plan);
	}
	/**
	 * 手术联合用药时长
	 * @return Integer
	 */
	public Integer getDays_sug_drugcmb() {
		return ((Integer) getAttrVal("Days_sug_drugcmb"));
	}	
	/**
	 * 手术联合用药时长
	 * @param Days_sug_drugcmb
	 */
	public void setDays_sug_drugcmb(Integer Days_sug_drugcmb) {
		setAttrVal("Days_sug_drugcmb", Days_sug_drugcmb);
	}
	/**
	 * 住院期间是否输液id
	 * @return String
	 */
	public String getId_has_infu() {
		return ((String) getAttrVal("Id_has_infu"));
	}	
	/**
	 * 住院期间是否输液id
	 * @param Id_has_infu
	 */
	public void setId_has_infu(String Id_has_infu) {
		setAttrVal("Id_has_infu", Id_has_infu);
	}
	/**
	 * 是否发生输液反应id
	 * @return String
	 */
	public String getId_infu_reac() {
		return ((String) getAttrVal("Id_infu_reac"));
	}	
	/**
	 * 是否发生输液反应id
	 * @param Id_infu_reac
	 */
	public void setId_infu_reac(String Id_infu_reac) {
		setAttrVal("Id_infu_reac", Id_infu_reac);
	}
	/**
	 * 住院期间是否输血id
	 * @return String
	 */
	public String getId_has_tran() {
		return ((String) getAttrVal("Id_has_tran"));
	}	
	/**
	 * 住院期间是否输血id
	 * @param Id_has_tran
	 */
	public void setId_has_tran(String Id_has_tran) {
		setAttrVal("Id_has_tran", Id_has_tran);
	}
	/**
	 * 是否发生输血反应id
	 * @return String
	 */
	public String getId_tran_reac() {
		return ((String) getAttrVal("Id_tran_reac"));
	}	
	/**
	 * 是否发生输血反应id
	 * @param Id_tran_reac
	 */
	public void setId_tran_reac(String Id_tran_reac) {
		setAttrVal("Id_tran_reac", Id_tran_reac);
	}
	/**
	 * 是否有压疮id
	 * @return String
	 */
	public String getId_has_ps() {
		return ((String) getAttrVal("Id_has_ps"));
	}	
	/**
	 * 是否有压疮id
	 * @param Id_has_ps
	 */
	public void setId_has_ps(String Id_has_ps) {
		setAttrVal("Id_has_ps", Id_has_ps);
	}
	/**
	 * 压疮分期name
	 * @return String
	 */
	public String getName_ps_stage() {
		return ((String) getAttrVal("Name_ps_stage"));
	}	
	/**
	 * 压疮分期name
	 * @param Name_ps_stage
	 */
	public void setName_ps_stage(String Name_ps_stage) {
		setAttrVal("Name_ps_stage", Name_ps_stage);
	}
	/**
	 * 住院期间是否跌倒或坠床id
	 * @return String
	 */
	public String getId_has_fall() {
		return ((String) getAttrVal("Id_has_fall"));
	}	
	/**
	 * 住院期间是否跌倒或坠床id
	 * @param Id_has_fall
	 */
	public void setId_has_fall(String Id_has_fall) {
		setAttrVal("Id_has_fall", Id_has_fall);
	}
	/**
	 * 住院期间是否使用物理约束id
	 * @return String
	 */
	public String getId_has_pc() {
		return ((String) getAttrVal("Id_has_pc"));
	}	
	/**
	 * 住院期间是否使用物理约束id
	 * @param Id_has_pc
	 */
	public void setId_has_pc(String Id_has_pc) {
		setAttrVal("Id_has_pc", Id_has_pc);
	}
	/**
	 * 物理约束时间
	 * @return Integer
	 */
	public Integer getHours_pc() {
		return ((Integer) getAttrVal("Hours_pc"));
	}	
	/**
	 * 物理约束时间
	 * @param Hours_pc
	 */
	public void setHours_pc(Integer Hours_pc) {
		setAttrVal("Hours_pc", Hours_pc);
	}
	/**
	 * 是否发生人工气道脱出id
	 * @return String
	 */
	public String getId_has_aaout() {
		return ((String) getAttrVal("Id_has_aaout"));
	}	
	/**
	 * 是否发生人工气道脱出id
	 * @param Id_has_aaout
	 */
	public void setId_has_aaout(String Id_has_aaout) {
		setAttrVal("Id_has_aaout", Id_has_aaout);
	}
	/**
	 * 是否非预期的重返ICU-id
	 * @return String
	 */
	public String getId_has_inicu_again() {
		return ((String) getAttrVal("Id_has_inicu_again"));
	}	
	/**
	 * 是否非预期的重返ICU-id
	 * @param Id_has_inicu_again
	 */
	public void setId_has_inicu_again(String Id_has_inicu_again) {
		setAttrVal("Id_has_inicu_again", Id_has_inicu_again);
	}
	/**
	 * 是否发生围术期死亡id
	 * @return String
	 */
	public String getId_has_death_insug() {
		return ((String) getAttrVal("Id_has_death_insug"));
	}	
	/**
	 * 是否发生围术期死亡id
	 * @param Id_has_death_insug
	 */
	public void setId_has_death_insug(String Id_has_death_insug) {
		setAttrVal("Id_has_death_insug", Id_has_death_insug);
	}
	/**
	 * 是否发生术后猝死id
	 * @return String
	 */
	public String getId_has_death_aftersug() {
		return ((String) getAttrVal("Id_has_death_aftersug"));
	}	
	/**
	 * 是否发生术后猝死id
	 * @param Id_has_death_aftersug
	 */
	public void setId_has_death_aftersug(String Id_has_death_aftersug) {
		setAttrVal("Id_has_death_aftersug", Id_has_death_aftersug);
	}
	/**
	 * 科主任id
	 * @return String
	 */
	public String getId_dirofdept() {
		return ((String) getAttrVal("Id_dirofdept"));
	}	
	/**
	 * 科主任id
	 * @param Id_dirofdept
	 */
	public void setId_dirofdept(String Id_dirofdept) {
		setAttrVal("Id_dirofdept", Id_dirofdept);
	}
	/**
	 * 科主任code
	 * @return String
	 */
	public String getSd_dirofdept() {
		return ((String) getAttrVal("Sd_dirofdept"));
	}	
	/**
	 * 科主任code
	 * @param Sd_dirofdept
	 */
	public void setSd_dirofdept(String Sd_dirofdept) {
		setAttrVal("Sd_dirofdept", Sd_dirofdept);
	}
	/**
	 * 科主任name
	 * @return String
	 */
	public String getName_dirofdept() {
		return ((String) getAttrVal("Name_dirofdept"));
	}	
	/**
	 * 科主任name
	 * @param Name_dirofdept
	 */
	public void setName_dirofdept(String Name_dirofdept) {
		setAttrVal("Name_dirofdept", Name_dirofdept);
	}
	/**
	 * 质控医师id
	 * @return String
	 */
	public String getId_qcp_doc() {
		return ((String) getAttrVal("Id_qcp_doc"));
	}	
	/**
	 * 质控医师id
	 * @param Id_qcp_doc
	 */
	public void setId_qcp_doc(String Id_qcp_doc) {
		setAttrVal("Id_qcp_doc", Id_qcp_doc);
	}
	/**
	 * 质控医师code
	 * @return String
	 */
	public String getSd_qcp_doc() {
		return ((String) getAttrVal("Sd_qcp_doc"));
	}	
	/**
	 * 质控医师code
	 * @param Sd_qcp_doc
	 */
	public void setSd_qcp_doc(String Sd_qcp_doc) {
		setAttrVal("Sd_qcp_doc", Sd_qcp_doc);
	}
	/**
	 * 质控医师name
	 * @return String
	 */
	public String getName_qcp_doc() {
		return ((String) getAttrVal("Name_qcp_doc"));
	}	
	/**
	 * 质控医师name
	 * @param Name_qcp_doc
	 */
	public void setName_qcp_doc(String Name_qcp_doc) {
		setAttrVal("Name_qcp_doc", Name_qcp_doc);
	}
	/**
	 * 质控护士id
	 * @return String
	 */
	public String getId_qcp_nur() {
		return ((String) getAttrVal("Id_qcp_nur"));
	}	
	/**
	 * 质控护士id
	 * @param Id_qcp_nur
	 */
	public void setId_qcp_nur(String Id_qcp_nur) {
		setAttrVal("Id_qcp_nur", Id_qcp_nur);
	}
	/**
	 * 质控护士code
	 * @return String
	 */
	public String getSd_qcp_nur() {
		return ((String) getAttrVal("Sd_qcp_nur"));
	}	
	/**
	 * 质控护士code
	 * @param Sd_qcp_nur
	 */
	public void setSd_qcp_nur(String Sd_qcp_nur) {
		setAttrVal("Sd_qcp_nur", Sd_qcp_nur);
	}
	/**
	 * 质控护士name
	 * @return String
	 */
	public String getName_qcp_nur() {
		return ((String) getAttrVal("Name_qcp_nur"));
	}	
	/**
	 * 质控护士name
	 * @param Name_qcp_nur
	 */
	public void setName_qcp_nur(String Name_qcp_nur) {
		setAttrVal("Name_qcp_nur", Name_qcp_nur);
	}
	/**
	 * 质控日期
	 * @return FDate
	 */
	public FDate getQc_date() {
		return ((FDate) getAttrVal("Qc_date"));
	}	
	/**
	 * 质控日期
	 * @param Qc_date
	 */
	public void setQc_date(FDate Qc_date) {
		setAttrVal("Qc_date", Qc_date);
	}
	/**
	 * 是否因同一疾病住院id
	 * @return String
	 */
	public String getId_has_samedi() {
		return ((String) getAttrVal("Id_has_samedi"));
	}	
	/**
	 * 是否因同一疾病住院id
	 * @param Id_has_samedi
	 */
	public void setId_has_samedi(String Id_has_samedi) {
		setAttrVal("Id_has_samedi", Id_has_samedi);
	}
	/**
	 * 抗生素使用情况code
	 * @return String
	 */
	public String getSd_ant_using() {
		return ((String) getAttrVal("Sd_ant_using"));
	}	
	/**
	 * 抗生素使用情况code
	 * @param Sd_ant_using
	 */
	public void setSd_ant_using(String Sd_ant_using) {
		setAttrVal("Sd_ant_using", Sd_ant_using);
	}
	/**
	 * 抗生素使用情况name
	 * @return String
	 */
	public String getName_ant_using() {
		return ((String) getAttrVal("Name_ant_using"));
	}	
	/**
	 * 抗生素使用情况name
	 * @param Name_ant_using
	 */
	public void setName_ant_using(String Name_ant_using) {
		setAttrVal("Name_ant_using", Name_ant_using);
	}
	/**
	 * 抗生素使用方案code
	 * @return String
	 */
	public String getSd_ant_plan() {
		return ((String) getAttrVal("Sd_ant_plan"));
	}	
	/**
	 * 抗生素使用方案code
	 * @param Sd_ant_plan
	 */
	public void setSd_ant_plan(String Sd_ant_plan) {
		setAttrVal("Sd_ant_plan", Sd_ant_plan);
	}
	/**
	 * 抗生素使用方案name
	 * @return String
	 */
	public String getName_ant_plan() {
		return ((String) getAttrVal("Name_ant_plan"));
	}	
	/**
	 * 抗生素使用方案name
	 * @param Name_ant_plan
	 */
	public void setName_ant_plan(String Name_ant_plan) {
		setAttrVal("Name_ant_plan", Name_ant_plan);
	}
	/**
	 * 手术抗生素使用情况code
	 * @return String
	 */
	public String getSd_ant_sug_using() {
		return ((String) getAttrVal("Sd_ant_sug_using"));
	}	
	/**
	 * 手术抗生素使用情况code
	 * @param Sd_ant_sug_using
	 */
	public void setSd_ant_sug_using(String Sd_ant_sug_using) {
		setAttrVal("Sd_ant_sug_using", Sd_ant_sug_using);
	}
	/**
	 * 手术抗生素使用情况name
	 * @return String
	 */
	public String getName_ant_sug_using() {
		return ((String) getAttrVal("Name_ant_sug_using"));
	}	
	/**
	 * 手术抗生素使用情况name
	 * @param Name_ant_sug_using
	 */
	public void setName_ant_sug_using(String Name_ant_sug_using) {
		setAttrVal("Name_ant_sug_using", Name_ant_sug_using);
	}
	/**
	 * 手术抗生素使用方案code
	 * @return String
	 */
	public String getSd_ant_sug_plan() {
		return ((String) getAttrVal("Sd_ant_sug_plan"));
	}	
	/**
	 * 手术抗生素使用方案code
	 * @param Sd_ant_sug_plan
	 */
	public void setSd_ant_sug_plan(String Sd_ant_sug_plan) {
		setAttrVal("Sd_ant_sug_plan", Sd_ant_sug_plan);
	}
	/**
	 * 手术抗生素使用方案name
	 * @return String
	 */
	public String getName_ant_sug_plan() {
		return ((String) getAttrVal("Name_ant_sug_plan"));
	}	
	/**
	 * 手术抗生素使用方案name
	 * @param Name_ant_sug_plan
	 */
	public void setName_ant_sug_plan(String Name_ant_sug_plan) {
		setAttrVal("Name_ant_sug_plan", Name_ant_sug_plan);
	}
	/**
	 * 是否因同一疾病住院code
	 * @return String
	 */
	public String getSd_has_samedi() {
		return ((String) getAttrVal("Sd_has_samedi"));
	}	
	/**
	 * 是否因同一疾病住院code
	 * @param Sd_has_samedi
	 */
	public void setSd_has_samedi(String Sd_has_samedi) {
		setAttrVal("Sd_has_samedi", Sd_has_samedi);
	}
	/**
	 * 是否因同一疾病住院name
	 * @return String
	 */
	public String getName_has_samedi() {
		return ((String) getAttrVal("Name_has_samedi"));
	}	
	/**
	 * 是否因同一疾病住院name
	 * @param Name_has_samedi
	 */
	public void setName_has_samedi(String Name_has_samedi) {
		setAttrVal("Name_has_samedi", Name_has_samedi);
	}
	/**
	 * 住院期间是否输液code
	 * @return String
	 */
	public String getSd_has_infu() {
		return ((String) getAttrVal("Sd_has_infu"));
	}	
	/**
	 * 住院期间是否输液code
	 * @param Sd_has_infu
	 */
	public void setSd_has_infu(String Sd_has_infu) {
		setAttrVal("Sd_has_infu", Sd_has_infu);
	}
	/**
	 * 住院期间是否输液name
	 * @return String
	 */
	public String getName_has_infu() {
		return ((String) getAttrVal("Name_has_infu"));
	}	
	/**
	 * 住院期间是否输液name
	 * @param Name_has_infu
	 */
	public void setName_has_infu(String Name_has_infu) {
		setAttrVal("Name_has_infu", Name_has_infu);
	}
	/**
	 * 是否发生输液反应code
	 * @return String
	 */
	public String getSd_infu_reac() {
		return ((String) getAttrVal("Sd_infu_reac"));
	}	
	/**
	 * 是否发生输液反应code
	 * @param Sd_infu_reac
	 */
	public void setSd_infu_reac(String Sd_infu_reac) {
		setAttrVal("Sd_infu_reac", Sd_infu_reac);
	}
	/**
	 * 是否发生输液反应name
	 * @return String
	 */
	public String getName_infu_reac() {
		return ((String) getAttrVal("Name_infu_reac"));
	}	
	/**
	 * 是否发生输液反应name
	 * @param Name_infu_reac
	 */
	public void setName_infu_reac(String Name_infu_reac) {
		setAttrVal("Name_infu_reac", Name_infu_reac);
	}
	/**
	 * 住院期间是否输血code
	 * @return String
	 */
	public String getSd_has_tran() {
		return ((String) getAttrVal("Sd_has_tran"));
	}	
	/**
	 * 住院期间是否输血code
	 * @param Sd_has_tran
	 */
	public void setSd_has_tran(String Sd_has_tran) {
		setAttrVal("Sd_has_tran", Sd_has_tran);
	}
	/**
	 * 住院期间是否输血name
	 * @return String
	 */
	public String getName_has_tran() {
		return ((String) getAttrVal("Name_has_tran"));
	}	
	/**
	 * 住院期间是否输血name
	 * @param Name_has_tran
	 */
	public void setName_has_tran(String Name_has_tran) {
		setAttrVal("Name_has_tran", Name_has_tran);
	}
	/**
	 * 是否发生输血反应code
	 * @return String
	 */
	public String getSd_tran_reac() {
		return ((String) getAttrVal("Sd_tran_reac"));
	}	
	/**
	 * 是否发生输血反应code
	 * @param Sd_tran_reac
	 */
	public void setSd_tran_reac(String Sd_tran_reac) {
		setAttrVal("Sd_tran_reac", Sd_tran_reac);
	}
	/**
	 * 是否发生输血反应name
	 * @return String
	 */
	public String getName_tran_reac() {
		return ((String) getAttrVal("Name_tran_reac"));
	}	
	/**
	 * 是否发生输血反应name
	 * @param Name_tran_reac
	 */
	public void setName_tran_reac(String Name_tran_reac) {
		setAttrVal("Name_tran_reac", Name_tran_reac);
	}
	/**
	 * 是否有压疮code
	 * @return String
	 */
	public String getSd_has_ps() {
		return ((String) getAttrVal("Sd_has_ps"));
	}	
	/**
	 * 是否有压疮code
	 * @param Sd_has_ps
	 */
	public void setSd_has_ps(String Sd_has_ps) {
		setAttrVal("Sd_has_ps", Sd_has_ps);
	}
	/**
	 * 是否有压疮name
	 * @return String
	 */
	public String getName_has_ps() {
		return ((String) getAttrVal("Name_has_ps"));
	}	
	/**
	 * 是否有压疮name
	 * @param Name_has_ps
	 */
	public void setName_has_ps(String Name_has_ps) {
		setAttrVal("Name_has_ps", Name_has_ps);
	}
	/**
	 * 住院期间是否跌倒或坠床code
	 * @return String
	 */
	public String getSd_has_fall() {
		return ((String) getAttrVal("Sd_has_fall"));
	}	
	/**
	 * 住院期间是否跌倒或坠床code
	 * @param Sd_has_fall
	 */
	public void setSd_has_fall(String Sd_has_fall) {
		setAttrVal("Sd_has_fall", Sd_has_fall);
	}
	/**
	 * 住院期间是否跌倒或坠床name
	 * @return String
	 */
	public String getName_has_fall() {
		return ((String) getAttrVal("Name_has_fall"));
	}	
	/**
	 * 住院期间是否跌倒或坠床name
	 * @param Name_has_fall
	 */
	public void setName_has_fall(String Name_has_fall) {
		setAttrVal("Name_has_fall", Name_has_fall);
	}
	/**
	 * 住院期间是否使用物理约束code
	 * @return String
	 */
	public String getSd_has_pc() {
		return ((String) getAttrVal("Sd_has_pc"));
	}	
	/**
	 * 住院期间是否使用物理约束code
	 * @param Sd_has_pc
	 */
	public void setSd_has_pc(String Sd_has_pc) {
		setAttrVal("Sd_has_pc", Sd_has_pc);
	}
	/**
	 * 住院期间是否使用物理约束name
	 * @return String
	 */
	public String getName_has_pc() {
		return ((String) getAttrVal("Name_has_pc"));
	}	
	/**
	 * 住院期间是否使用物理约束name
	 * @param Name_has_pc
	 */
	public void setName_has_pc(String Name_has_pc) {
		setAttrVal("Name_has_pc", Name_has_pc);
	}
	/**
	 * 是否发生人工气道脱出code
	 * @return String
	 */
	public String getSd_has_aaout() {
		return ((String) getAttrVal("Sd_has_aaout"));
	}	
	/**
	 * 是否发生人工气道脱出code
	 * @param Sd_has_aaout
	 */
	public void setSd_has_aaout(String Sd_has_aaout) {
		setAttrVal("Sd_has_aaout", Sd_has_aaout);
	}
	/**
	 * 是否发生人工气道脱出name
	 * @return String
	 */
	public String getName_has_aaout() {
		return ((String) getAttrVal("Name_has_aaout"));
	}	
	/**
	 * 是否发生人工气道脱出name
	 * @param Name_has_aaout
	 */
	public void setName_has_aaout(String Name_has_aaout) {
		setAttrVal("Name_has_aaout", Name_has_aaout);
	}
	/**
	 * 是否非预期的重返ICU-code
	 * @return String
	 */
	public String getSd_has_inicu_again() {
		return ((String) getAttrVal("Sd_has_inicu_again"));
	}	
	/**
	 * 是否非预期的重返ICU-code
	 * @param Sd_has_inicu_again
	 */
	public void setSd_has_inicu_again(String Sd_has_inicu_again) {
		setAttrVal("Sd_has_inicu_again", Sd_has_inicu_again);
	}
	/**
	 * 是否非预期的重返ICU-name
	 * @return String
	 */
	public String getName_has_inicu_again() {
		return ((String) getAttrVal("Name_has_inicu_again"));
	}	
	/**
	 * 是否非预期的重返ICU-name
	 * @param Name_has_inicu_again
	 */
	public void setName_has_inicu_again(String Name_has_inicu_again) {
		setAttrVal("Name_has_inicu_again", Name_has_inicu_again);
	}
	/**
	 * 是否发生围术期死亡code
	 * @return String
	 */
	public String getSd_has_death_insug() {
		return ((String) getAttrVal("Sd_has_death_insug"));
	}	
	/**
	 * 是否发生围术期死亡code
	 * @param Sd_has_death_insug
	 */
	public void setSd_has_death_insug(String Sd_has_death_insug) {
		setAttrVal("Sd_has_death_insug", Sd_has_death_insug);
	}
	/**
	 * 是否发生围术期死亡name
	 * @return String
	 */
	public String getName_has_death_insug() {
		return ((String) getAttrVal("Name_has_death_insug"));
	}	
	/**
	 * 是否发生围术期死亡name
	 * @param Name_has_death_insug
	 */
	public void setName_has_death_insug(String Name_has_death_insug) {
		setAttrVal("Name_has_death_insug", Name_has_death_insug);
	}
	/**
	 * 是否发生术后猝死code
	 * @return String
	 */
	public String getSd_has_death_aftersug() {
		return ((String) getAttrVal("Sd_has_death_aftersug"));
	}	
	/**
	 * 是否发生术后猝死code
	 * @param Sd_has_death_aftersug
	 */
	public void setSd_has_death_aftersug(String Sd_has_death_aftersug) {
		setAttrVal("Sd_has_death_aftersug", Sd_has_death_aftersug);
	}
	/**
	 * 是否发生术后猝死name
	 * @return String
	 */
	public String getName_has_death_aftersug() {
		return ((String) getAttrVal("Name_has_death_aftersug"));
	}	
	/**
	 * 是否发生术后猝死name
	 * @param Name_has_death_aftersug
	 */
	public void setName_has_death_aftersug(String Name_has_death_aftersug) {
		setAttrVal("Name_has_death_aftersug", Name_has_death_aftersug);
	}
	/**
	 * 距上一次住本院时间id
	 * @return String
	 */
	public String getId_between_inhosdays() {
		return ((String) getAttrVal("Id_between_inhosdays"));
	}	
	/**
	 * 距上一次住本院时间id
	 * @param Id_between_inhosdays
	 */
	public void setId_between_inhosdays(String Id_between_inhosdays) {
		setAttrVal("Id_between_inhosdays", Id_between_inhosdays);
	}
	/**
	 * 距上一次住本院时间code
	 * @return String
	 */
	public String getSd_between_inhosdays() {
		return ((String) getAttrVal("Sd_between_inhosdays"));
	}	
	/**
	 * 距上一次住本院时间code
	 * @param Sd_between_inhosdays
	 */
	public void setSd_between_inhosdays(String Sd_between_inhosdays) {
		setAttrVal("Sd_between_inhosdays", Sd_between_inhosdays);
	}
	/**
	 * 距上一次住本院时间name
	 * @return String
	 */
	public String getName_between_inhosdays() {
		return ((String) getAttrVal("Name_between_inhosdays"));
	}	
	/**
	 * 距上一次住本院时间name
	 * @param Name_between_inhosdays
	 */
	public void setName_between_inhosdays(String Name_between_inhosdays) {
		setAttrVal("Name_between_inhosdays", Name_between_inhosdays);
	}
	/**
	 * 压疮发生时间id
	 * @return String
	 */
	public String getId_ps_begintime() {
		return ((String) getAttrVal("Id_ps_begintime"));
	}	
	/**
	 * 压疮发生时间id
	 * @param Id_ps_begintime
	 */
	public void setId_ps_begintime(String Id_ps_begintime) {
		setAttrVal("Id_ps_begintime", Id_ps_begintime);
	}
	/**
	 * 压疮发生时间code
	 * @return String
	 */
	public String getSd_ps_begintime() {
		return ((String) getAttrVal("Sd_ps_begintime"));
	}	
	/**
	 * 压疮发生时间code
	 * @param Sd_ps_begintime
	 */
	public void setSd_ps_begintime(String Sd_ps_begintime) {
		setAttrVal("Sd_ps_begintime", Sd_ps_begintime);
	}
	/**
	 * 压疮发生时间name 
	 * @return String
	 */
	public String getName_ps_begintime() {
		return ((String) getAttrVal("Name_ps_begintime"));
	}	
	/**
	 * 压疮发生时间name 
	 * @param Name_ps_begintime
	 */
	public void setName_ps_begintime(String Name_ps_begintime) {
		setAttrVal("Name_ps_begintime", Name_ps_begintime);
	}
	/**
	 * 压疮分期id
	 * @return String
	 */
	public String getId_ps_stage() {
		return ((String) getAttrVal("Id_ps_stage"));
	}	
	/**
	 * 压疮分期id
	 * @param Id_ps_stage
	 */
	public void setId_ps_stage(String Id_ps_stage) {
		setAttrVal("Id_ps_stage", Id_ps_stage);
	}
	/**
	 * 压疮分期code
	 * @return String
	 */
	public String getSd_ps_stage() {
		return ((String) getAttrVal("Sd_ps_stage"));
	}	
	/**
	 * 压疮分期code
	 * @param Sd_ps_stage
	 */
	public void setSd_ps_stage(String Sd_ps_stage) {
		setAttrVal("Sd_ps_stage", Sd_ps_stage);
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度id
	 * @return String
	 */
	public String getId_fall_hurtlvl() {
		return ((String) getAttrVal("Id_fall_hurtlvl"));
	}	
	/**
	 * 住院期间跌倒或坠床的伤害程度id
	 * @param Id_fall_hurtlvl
	 */
	public void setId_fall_hurtlvl(String Id_fall_hurtlvl) {
		setAttrVal("Id_fall_hurtlvl", Id_fall_hurtlvl);
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度code
	 * @return String
	 */
	public String getSd_fall_hurtlvl() {
		return ((String) getAttrVal("Sd_fall_hurtlvl"));
	}	
	/**
	 * 住院期间跌倒或坠床的伤害程度code
	 * @param Sd_fall_hurtlvl
	 */
	public void setSd_fall_hurtlvl(String Sd_fall_hurtlvl) {
		setAttrVal("Sd_fall_hurtlvl", Sd_fall_hurtlvl);
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度name
	 * @return String
	 */
	public String getName_fall_hurtlvl() {
		return ((String) getAttrVal("Name_fall_hurtlvl"));
	}	
	/**
	 * 住院期间跌倒或坠床的伤害程度name
	 * @param Name_fall_hurtlvl
	 */
	public void setName_fall_hurtlvl(String Name_fall_hurtlvl) {
		setAttrVal("Name_fall_hurtlvl", Name_fall_hurtlvl);
	}
	/**
	 * 跌倒或坠床的原因id
	 * @return String
	 */
	public String getId_fall_reason() {
		return ((String) getAttrVal("Id_fall_reason"));
	}	
	/**
	 * 跌倒或坠床的原因id
	 * @param Id_fall_reason
	 */
	public void setId_fall_reason(String Id_fall_reason) {
		setAttrVal("Id_fall_reason", Id_fall_reason);
	}
	/**
	 * 跌倒或坠床的原因code
	 * @return String
	 */
	public String getSd_fall_reason() {
		return ((String) getAttrVal("Sd_fall_reason"));
	}	
	/**
	 * 跌倒或坠床的原因code
	 * @param Sd_fall_reason
	 */
	public void setSd_fall_reason(String Sd_fall_reason) {
		setAttrVal("Sd_fall_reason", Sd_fall_reason);
	}
	/**
	 * 跌倒或坠床的原因name
	 * @return String
	 */
	public String getName_fall_reason() {
		return ((String) getAttrVal("Name_fall_reason"));
	}	
	/**
	 * 跌倒或坠床的原因name
	 * @param Name_fall_reason
	 */
	public void setName_fall_reason(String Name_fall_reason) {
		setAttrVal("Name_fall_reason", Name_fall_reason);
	}
	/**
	 * 物理约束方式id
	 * @return String
	 */
	public String getId_pc_method() {
		return ((String) getAttrVal("Id_pc_method"));
	}	
	/**
	 * 物理约束方式id
	 * @param Id_pc_method
	 */
	public void setId_pc_method(String Id_pc_method) {
		setAttrVal("Id_pc_method", Id_pc_method);
	}
	/**
	 * 物理约束方式code
	 * @return String
	 */
	public String getSd_pc_method() {
		return ((String) getAttrVal("Sd_pc_method"));
	}	
	/**
	 * 物理约束方式code
	 * @param Sd_pc_method
	 */
	public void setSd_pc_method(String Sd_pc_method) {
		setAttrVal("Sd_pc_method", Sd_pc_method);
	}
	/**
	 * 物理约束方式name
	 * @return String
	 */
	public String getName_pc_method() {
		return ((String) getAttrVal("Name_pc_method"));
	}	
	/**
	 * 物理约束方式name
	 * @param Name_pc_method
	 */
	public void setName_pc_method(String Name_pc_method) {
		setAttrVal("Name_pc_method", Name_pc_method);
	}
	/**
	 * 物理约束工具id
	 * @return String
	 */
	public String getId_pc_tool() {
		return ((String) getAttrVal("Id_pc_tool"));
	}	
	/**
	 * 物理约束工具id
	 * @param Id_pc_tool
	 */
	public void setId_pc_tool(String Id_pc_tool) {
		setAttrVal("Id_pc_tool", Id_pc_tool);
	}
	/**
	 * 物理约束工具code
	 * @return String
	 */
	public String getSd_pc_tool() {
		return ((String) getAttrVal("Sd_pc_tool"));
	}	
	/**
	 * 物理约束工具code
	 * @param Sd_pc_tool
	 */
	public void setSd_pc_tool(String Sd_pc_tool) {
		setAttrVal("Sd_pc_tool", Sd_pc_tool);
	}
	/**
	 * 物理约束工具name
	 * @return String
	 */
	public String getName_pc_tool() {
		return ((String) getAttrVal("Name_pc_tool"));
	}	
	/**
	 * 物理约束工具name
	 * @param Name_pc_tool
	 */
	public void setName_pc_tool(String Name_pc_tool) {
		setAttrVal("Name_pc_tool", Name_pc_tool);
	}
	/**
	 * 物理约束原因id
	 * @return String
	 */
	public String getId_pc_reason() {
		return ((String) getAttrVal("Id_pc_reason"));
	}	
	/**
	 * 物理约束原因id
	 * @param Id_pc_reason
	 */
	public void setId_pc_reason(String Id_pc_reason) {
		setAttrVal("Id_pc_reason", Id_pc_reason);
	}
	/**
	 * 物理约束原因code
	 * @return String
	 */
	public String getSd_pc_reason() {
		return ((String) getAttrVal("Sd_pc_reason"));
	}	
	/**
	 * 物理约束原因code
	 * @param Sd_pc_reason
	 */
	public void setSd_pc_reason(String Sd_pc_reason) {
		setAttrVal("Sd_pc_reason", Sd_pc_reason);
	}
	/**
	 * 物理约束原因name
	 * @return String
	 */
	public String getName_pc_reason() {
		return ((String) getAttrVal("Name_pc_reason"));
	}	
	/**
	 * 物理约束原因name
	 * @param Name_pc_reason
	 */
	public void setName_pc_reason(String Name_pc_reason) {
		setAttrVal("Name_pc_reason", Name_pc_reason);
	}
	/**
	 * 产科新生儿离院方式id
	 * @return String
	 */
	public String getId_baby_outhos_reason() {
		return ((String) getAttrVal("Id_baby_outhos_reason"));
	}	
	/**
	 * 产科新生儿离院方式id
	 * @param Id_baby_outhos_reason
	 */
	public void setId_baby_outhos_reason(String Id_baby_outhos_reason) {
		setAttrVal("Id_baby_outhos_reason", Id_baby_outhos_reason);
	}
	/**
	 * 产科新生儿离院方式code
	 * @return String
	 */
	public String getSd_baby_outhos_reason() {
		return ((String) getAttrVal("Sd_baby_outhos_reason"));
	}	
	/**
	 * 产科新生儿离院方式code
	 * @param Sd_baby_outhos_reason
	 */
	public void setSd_baby_outhos_reason(String Sd_baby_outhos_reason) {
		setAttrVal("Sd_baby_outhos_reason", Sd_baby_outhos_reason);
	}
	/**
	 * 产科新生儿离院方式name
	 * @return String
	 */
	public String getName_baby_outhos_reason() {
		return ((String) getAttrVal("Name_baby_outhos_reason"));
	}	
	/**
	 * 产科新生儿离院方式name
	 * @param Name_baby_outhos_reason
	 */
	public void setName_baby_outhos_reason(String Name_baby_outhos_reason) {
		setAttrVal("Name_baby_outhos_reason", Name_baby_outhos_reason);
	}
	/**
	 * 重返ICU间隔时间id
	 * @return String
	 */
	public String getId_between_inicuhours() {
		return ((String) getAttrVal("Id_between_inicuhours"));
	}	
	/**
	 * 重返ICU间隔时间id
	 * @param Id_between_inicuhours
	 */
	public void setId_between_inicuhours(String Id_between_inicuhours) {
		setAttrVal("Id_between_inicuhours", Id_between_inicuhours);
	}
	/**
	 * 重返ICU间隔时间code
	 * @return String
	 */
	public String getSd_between_inicuhours() {
		return ((String) getAttrVal("Sd_between_inicuhours"));
	}	
	/**
	 * 重返ICU间隔时间code
	 * @param Sd_between_inicuhours
	 */
	public void setSd_between_inicuhours(String Sd_between_inicuhours) {
		setAttrVal("Sd_between_inicuhours", Sd_between_inicuhours);
	}
	/**
	 * 重返ICU间隔时间name
	 * @return String
	 */
	public String getName_between_inicuhours() {
		return ((String) getAttrVal("Name_between_inicuhours"));
	}	
	/**
	 * 重返ICU间隔时间name
	 * @param Name_between_inicuhours
	 */
	public void setName_between_inicuhours(String Name_between_inicuhours) {
		setAttrVal("Name_between_inicuhours", Name_between_inicuhours);
	}
	/**
	 * 抗生素使用目的code
	 * @return String
	 */
	public String getSd_ant_purpose() {
		return ((String) getAttrVal("Sd_ant_purpose"));
	}	
	/**
	 * 抗生素使用目的code
	 * @param Sd_ant_purpose
	 */
	public void setSd_ant_purpose(String Sd_ant_purpose) {
		setAttrVal("Sd_ant_purpose", Sd_ant_purpose);
	}
	/**
	 * 抗生素使用目的name
	 * @return String
	 */
	public String getName_ant_purpose() {
		return ((String) getAttrVal("Name_ant_purpose"));
	}	
	/**
	 * 抗生素使用目的name
	 * @param Name_ant_purpose
	 */
	public void setName_ant_purpose(String Name_ant_purpose) {
		setAttrVal("Name_ant_purpose", Name_ant_purpose);
	}
	/**
	 * 是否出现危重code
	 * @return String
	 */
	public String getSd_hascill() {
		return ((String) getAttrVal("Sd_hascill"));
	}	
	/**
	 * 是否出现危重code
	 * @param Sd_hascill
	 */
	public void setSd_hascill(String Sd_hascill) {
		setAttrVal("Sd_hascill", Sd_hascill);
	}
	/**
	 * 是否出现危重name
	 * @return String
	 */
	public String getName_hascill() {
		return ((String) getAttrVal("Name_hascill"));
	}	
	/**
	 * 是否出现危重name
	 * @param Name_hascill
	 */
	public void setName_hascill(String Name_hascill) {
		setAttrVal("Name_hascill", Name_hascill);
	}
	/**
	 * 病例分型id
	 * @return String
	 */
	public String getId_mrcasetype() {
		return ((String) getAttrVal("Id_mrcasetype"));
	}	
	/**
	 * 病例分型id
	 * @param Id_mrcasetype
	 */
	public void setId_mrcasetype(String Id_mrcasetype) {
		setAttrVal("Id_mrcasetype", Id_mrcasetype);
	}
	/**
	 * 病例分型sd
	 * @return String
	 */
	public String getSd_mrcasetype() {
		return ((String) getAttrVal("Sd_mrcasetype"));
	}	
	/**
	 * 病例分型sd
	 * @param Sd_mrcasetype
	 */
	public void setSd_mrcasetype(String Sd_mrcasetype) {
		setAttrVal("Sd_mrcasetype", Sd_mrcasetype);
	}
	/**
	 * 病例分型name
	 * @return String
	 */
	public String getName_mrcasetype() {
		return ((String) getAttrVal("Name_mrcasetype"));
	}	
	/**
	 * 病例分型name
	 * @param Name_mrcasetype
	 */
	public void setName_mrcasetype(String Name_mrcasetype) {
		setAttrVal("Name_mrcasetype", Name_mrcasetype);
	}
	/**
	 * 手术后并发症id
	 * @return String
	 */
	public String getId_sug_complication() {
		return ((String) getAttrVal("Id_sug_complication"));
	}	
	/**
	 * 手术后并发症id
	 * @param Id_sug_complication
	 */
	public void setId_sug_complication(String Id_sug_complication) {
		setAttrVal("Id_sug_complication", Id_sug_complication);
	}
	/**
	 * 手术后并发症code
	 * @return String
	 */
	public String getSd_sug_complication() {
		return ((String) getAttrVal("Sd_sug_complication"));
	}	
	/**
	 * 手术后并发症code
	 * @param Sd_sug_complication
	 */
	public void setSd_sug_complication(String Sd_sug_complication) {
		setAttrVal("Sd_sug_complication", Sd_sug_complication);
	}
	/**
	 * 手术后并发症name
	 * @return String
	 */
	public String getName_sug_complication() {
		return ((String) getAttrVal("Name_sug_complication"));
	}	
	/**
	 * 手术后并发症name
	 * @param Name_sug_complication
	 */
	public void setName_sug_complication(String Name_sug_complication) {
		setAttrVal("Name_sug_complication", Name_sug_complication);
	}
	/**
	 * 诊断符合情况_三日确诊主键
	 * @return String
	 */
	public String getId_dic_confirmed() {
		return ((String) getAttrVal("Id_dic_confirmed"));
	}	
	/**
	 * 诊断符合情况_三日确诊主键
	 * @param Id_dic_confirmed
	 */
	public void setId_dic_confirmed(String Id_dic_confirmed) {
		setAttrVal("Id_dic_confirmed", Id_dic_confirmed);
	}
	/**
	 * 诊断符合情况_三日确诊编码
	 * @return String
	 */
	public String getSd_dic_confirmed() {
		return ((String) getAttrVal("Sd_dic_confirmed"));
	}	
	/**
	 * 诊断符合情况_三日确诊编码
	 * @param Sd_dic_confirmed
	 */
	public void setSd_dic_confirmed(String Sd_dic_confirmed) {
		setAttrVal("Sd_dic_confirmed", Sd_dic_confirmed);
	}
	/**
	 * 诊断符合情况_三日确诊名称
	 * @return String
	 */
	public String getName_dic_confirmed() {
		return ((String) getAttrVal("Name_dic_confirmed"));
	}	
	/**
	 * 诊断符合情况_三日确诊名称
	 * @param Name_dic_confirmed
	 */
	public void setName_dic_confirmed(String Name_dic_confirmed) {
		setAttrVal("Name_dic_confirmed", Name_dic_confirmed);
	}
	/**
	 * 全血（数量）
	 * @return FDouble
	 */
	public FDouble getAmount_blood() {
		return ((FDouble) getAttrVal("Amount_blood"));
	}	
	/**
	 * 全血（数量）
	 * @param Amount_blood
	 */
	public void setAmount_blood(FDouble Amount_blood) {
		setAttrVal("Amount_blood", Amount_blood);
	}
	/**
	 * 血浆（数量）
	 * @return FDouble
	 */
	public FDouble getAmount_plasma() {
		return ((FDouble) getAttrVal("Amount_plasma"));
	}	
	/**
	 * 血浆（数量）
	 * @param Amount_plasma
	 */
	public void setAmount_plasma(FDouble Amount_plasma) {
		setAttrVal("Amount_plasma", Amount_plasma);
	}
	/**
	 * 血小板（数量）
	 * @return FDouble
	 */
	public FDouble getAmount_platelet() {
		return ((FDouble) getAttrVal("Amount_platelet"));
	}	
	/**
	 * 血小板（数量）
	 * @param Amount_platelet
	 */
	public void setAmount_platelet(FDouble Amount_platelet) {
		setAttrVal("Amount_platelet", Amount_platelet);
	}
	/**
	 * 红细胞（数量）
	 * @return FDouble
	 */
	public FDouble getAmount_erythrocyte() {
		return ((FDouble) getAttrVal("Amount_erythrocyte"));
	}	
	/**
	 * 红细胞（数量）
	 * @param Amount_erythrocyte
	 */
	public void setAmount_erythrocyte(FDouble Amount_erythrocyte) {
		setAttrVal("Amount_erythrocyte", Amount_erythrocyte);
	}
	/**
	 * 自体回血输（数量）
	 * @return FDouble
	 */
	public FDouble getAmount_autolo_trans() {
		return ((FDouble) getAttrVal("Amount_autolo_trans"));
	}	
	/**
	 * 自体回血输（数量）
	 * @param Amount_autolo_trans
	 */
	public void setAmount_autolo_trans(FDouble Amount_autolo_trans) {
		setAttrVal("Amount_autolo_trans", Amount_autolo_trans);
	}
	/**
	 * 其他诊断出院情况id
	 * @return String
	 */
	public String getId_otherdi_outhos() {
		return ((String) getAttrVal("Id_otherdi_outhos"));
	}	
	/**
	 * 其他诊断出院情况id
	 * @param Id_otherdi_outhos
	 */
	public void setId_otherdi_outhos(String Id_otherdi_outhos) {
		setAttrVal("Id_otherdi_outhos", Id_otherdi_outhos);
	}
	/**
	 * 其他诊断出院情况code
	 * @return String
	 */
	public String getSd_otherdi_outhos() {
		return ((String) getAttrVal("Sd_otherdi_outhos"));
	}	
	/**
	 * 其他诊断出院情况code
	 * @param Sd_otherdi_outhos
	 */
	public void setSd_otherdi_outhos(String Sd_otherdi_outhos) {
		setAttrVal("Sd_otherdi_outhos", Sd_otherdi_outhos);
	}
	/**
	 * 其他诊断出院情况name
	 * @return String
	 */
	public String getName_otherdi_outhos() {
		return ((String) getAttrVal("Name_otherdi_outhos"));
	}	
	/**
	 * 其他诊断出院情况name
	 * @param Name_otherdi_outhos
	 */
	public void setName_otherdi_outhos(String Name_otherdi_outhos) {
		setAttrVal("Name_otherdi_outhos", Name_otherdi_outhos);
	}
	/**
	 * 重症监护室名称id
	 * @return String
	 */
	public String getId_icu_typename() {
		return ((String) getAttrVal("Id_icu_typename"));
	}	
	/**
	 * 重症监护室名称id
	 * @param Id_icu_typename
	 */
	public void setId_icu_typename(String Id_icu_typename) {
		setAttrVal("Id_icu_typename", Id_icu_typename);
	}
	/**
	 * 重症监护室名称code
	 * @return String
	 */
	public String getSd_icu_typename() {
		return ((String) getAttrVal("Sd_icu_typename"));
	}	
	/**
	 * 重症监护室名称code
	 * @param Sd_icu_typename
	 */
	public void setSd_icu_typename(String Sd_icu_typename) {
		setAttrVal("Sd_icu_typename", Sd_icu_typename);
	}
	/**
	 * 重症监护室名称name
	 * @return String
	 */
	public String getName_icu_typename() {
		return ((String) getAttrVal("Name_icu_typename"));
	}	
	/**
	 * 重症监护室名称name
	 * @param Name_icu_typename
	 */
	public void setName_icu_typename(String Name_icu_typename) {
		setAttrVal("Name_icu_typename", Name_icu_typename);
	}
	/**
	 * 入院时情况id
	 * @return String
	 */
	public String getId_inhos_situation() {
		return ((String) getAttrVal("Id_inhos_situation"));
	}	
	/**
	 * 入院时情况id
	 * @param Id_inhos_situation
	 */
	public void setId_inhos_situation(String Id_inhos_situation) {
		setAttrVal("Id_inhos_situation", Id_inhos_situation);
	}
	/**
	 * 入院时情况code
	 * @return String
	 */
	public String getSd_inhos_situation() {
		return ((String) getAttrVal("Sd_inhos_situation"));
	}	
	/**
	 * 入院时情况code
	 * @param Sd_inhos_situation
	 */
	public void setSd_inhos_situation(String Sd_inhos_situation) {
		setAttrVal("Sd_inhos_situation", Sd_inhos_situation);
	}
	/**
	 * 入院时情况name
	 * @return String
	 */
	public String getName_inhos_situation() {
		return ((String) getAttrVal("Name_inhos_situation"));
	}	
	/**
	 * 入院时情况name
	 * @param Name_inhos_situation
	 */
	public void setName_inhos_situation(String Name_inhos_situation) {
		setAttrVal("Name_inhos_situation", Name_inhos_situation);
	}
	/**
	 * HBsAg-id（乙型肝炎表面抗原）
	 * @return String
	 */
	public String getId_hbsag() {
		return ((String) getAttrVal("Id_hbsag"));
	}	
	/**
	 * HBsAg-id（乙型肝炎表面抗原）
	 * @param Id_hbsag
	 */
	public void setId_hbsag(String Id_hbsag) {
		setAttrVal("Id_hbsag", Id_hbsag);
	}
	/**
	 * HBsAg-code（乙型肝炎表面抗原）
	 * @return String
	 */
	public String getSd_hbsag() {
		return ((String) getAttrVal("Sd_hbsag"));
	}	
	/**
	 * HBsAg-code（乙型肝炎表面抗原）
	 * @param Sd_hbsag
	 */
	public void setSd_hbsag(String Sd_hbsag) {
		setAttrVal("Sd_hbsag", Sd_hbsag);
	}
	/**
	 * HBsAg-name（乙型肝炎表面抗原）
	 * @return String
	 */
	public String getName_hbsag() {
		return ((String) getAttrVal("Name_hbsag"));
	}	
	/**
	 * HBsAg-name（乙型肝炎表面抗原）
	 * @param Name_hbsag
	 */
	public void setName_hbsag(String Name_hbsag) {
		setAttrVal("Name_hbsag", Name_hbsag);
	}
	/**
	 * HCV-Ab-id（丙型肝炎抗体）
	 * @return String
	 */
	public String getId_hcv_ab() {
		return ((String) getAttrVal("Id_hcv_ab"));
	}	
	/**
	 * HCV-Ab-id（丙型肝炎抗体）
	 * @param Id_hcv_ab
	 */
	public void setId_hcv_ab(String Id_hcv_ab) {
		setAttrVal("Id_hcv_ab", Id_hcv_ab);
	}
	/**
	 * HCV-Ab-code（丙型肝炎抗体）
	 * @return String
	 */
	public String getSd_hcv_ab() {
		return ((String) getAttrVal("Sd_hcv_ab"));
	}	
	/**
	 * HCV-Ab-code（丙型肝炎抗体）
	 * @param Sd_hcv_ab
	 */
	public void setSd_hcv_ab(String Sd_hcv_ab) {
		setAttrVal("Sd_hcv_ab", Sd_hcv_ab);
	}
	/**
	 * HCV-Ab-name（丙型肝炎抗体）
	 * @return String
	 */
	public String getName_hcv_ab() {
		return ((String) getAttrVal("Name_hcv_ab"));
	}	
	/**
	 * HCV-Ab-name（丙型肝炎抗体）
	 * @param Name_hcv_ab
	 */
	public void setName_hcv_ab(String Name_hcv_ab) {
		setAttrVal("Name_hcv_ab", Name_hcv_ab);
	}
	/**
	 * HIV-Ab-id（艾滋病抗体）
	 * @return String
	 */
	public String getId_hiv_ab() {
		return ((String) getAttrVal("Id_hiv_ab"));
	}	
	/**
	 * HIV-Ab-id（艾滋病抗体）
	 * @param Id_hiv_ab
	 */
	public void setId_hiv_ab(String Id_hiv_ab) {
		setAttrVal("Id_hiv_ab", Id_hiv_ab);
	}
	/**
	 * HIV-Ab-code（艾滋病抗体）
	 * @return String
	 */
	public String getSd_hiv_ab() {
		return ((String) getAttrVal("Sd_hiv_ab"));
	}	
	/**
	 * HIV-Ab-code（艾滋病抗体）
	 * @param Sd_hiv_ab
	 */
	public void setSd_hiv_ab(String Sd_hiv_ab) {
		setAttrVal("Sd_hiv_ab", Sd_hiv_ab);
	}
	/**
	 * HIV-Ab-name（艾滋病抗体）
	 * @return String
	 */
	public String getName_hiv_ab() {
		return ((String) getAttrVal("Name_hiv_ab"));
	}	
	/**
	 * HIV-Ab-name（艾滋病抗体）
	 * @param Name_hiv_ab
	 */
	public void setName_hiv_ab(String Name_hiv_ab) {
		setAttrVal("Name_hiv_ab", Name_hiv_ab);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTransferway_code() {
		return ((String) getAttrVal("Transferway_code"));
	}	
	/**
	 * 编码
	 * @param Transferway_code
	 */
	public void setTransferway_code(String Transferway_code) {
		setAttrVal("Transferway_code", Transferway_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTransferway_name() {
		return ((String) getAttrVal("Transferway_name"));
	}	
	/**
	 * 名称
	 * @param Transferway_name
	 */
	public void setTransferway_name(String Transferway_name) {
		setAttrVal("Transferway_name", Transferway_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCipathstatus_code() {
		return ((String) getAttrVal("Cipathstatus_code"));
	}	
	/**
	 * 编码
	 * @param Cipathstatus_code
	 */
	public void setCipathstatus_code(String Cipathstatus_code) {
		setAttrVal("Cipathstatus_code", Cipathstatus_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCipathstatus_name() {
		return ((String) getAttrVal("Cipathstatus_name"));
	}	
	/**
	 * 名称
	 * @param Cipathstatus_name
	 */
	public void setCipathstatus_name(String Cipathstatus_name) {
		setAttrVal("Cipathstatus_name", Cipathstatus_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_using_code() {
		return ((String) getAttrVal("Ant_using_code"));
	}	
	/**
	 * 编码
	 * @param Ant_using_code
	 */
	public void setAnt_using_code(String Ant_using_code) {
		setAttrVal("Ant_using_code", Ant_using_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_using_name() {
		return ((String) getAttrVal("Ant_using_name"));
	}	
	/**
	 * 名称
	 * @param Ant_using_name
	 */
	public void setAnt_using_name(String Ant_using_name) {
		setAttrVal("Ant_using_name", Ant_using_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_purpose_code() {
		return ((String) getAttrVal("Ant_purpose_code"));
	}	
	/**
	 * 编码
	 * @param Ant_purpose_code
	 */
	public void setAnt_purpose_code(String Ant_purpose_code) {
		setAttrVal("Ant_purpose_code", Ant_purpose_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_purpose_name() {
		return ((String) getAttrVal("Ant_purpose_name"));
	}	
	/**
	 * 名称
	 * @param Ant_purpose_name
	 */
	public void setAnt_purpose_name(String Ant_purpose_name) {
		setAttrVal("Ant_purpose_name", Ant_purpose_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_plan_code() {
		return ((String) getAttrVal("Ant_plan_code"));
	}	
	/**
	 * 编码
	 * @param Ant_plan_code
	 */
	public void setAnt_plan_code(String Ant_plan_code) {
		setAttrVal("Ant_plan_code", Ant_plan_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_plan_name() {
		return ((String) getAttrVal("Ant_plan_name"));
	}	
	/**
	 * 名称
	 * @param Ant_plan_name
	 */
	public void setAnt_plan_name(String Ant_plan_name) {
		setAttrVal("Ant_plan_name", Ant_plan_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCtg_report_code() {
		return ((String) getAttrVal("Ctg_report_code"));
	}	
	/**
	 * 编码
	 * @param Ctg_report_code
	 */
	public void setCtg_report_code(String Ctg_report_code) {
		setAttrVal("Ctg_report_code", Ctg_report_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCtg_report_name() {
		return ((String) getAttrVal("Ctg_report_name"));
	}	
	/**
	 * 名称
	 * @param Ctg_report_name
	 */
	public void setCtg_report_name(String Ctg_report_name) {
		setAttrVal("Ctg_report_name", Ctg_report_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getNur_lev_code() {
		return ((String) getAttrVal("Nur_lev_code"));
	}	
	/**
	 * 编码
	 * @param Nur_lev_code
	 */
	public void setNur_lev_code(String Nur_lev_code) {
		setAttrVal("Nur_lev_code", Nur_lev_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNur_lev_name() {
		return ((String) getAttrVal("Nur_lev_name"));
	}	
	/**
	 * 名称
	 * @param Nur_lev_name
	 */
	public void setNur_lev_name(String Nur_lev_name) {
		setAttrVal("Nur_lev_name", Nur_lev_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHascill_code() {
		return ((String) getAttrVal("Hascill_code"));
	}	
	/**
	 * 编码
	 * @param Hascill_code
	 */
	public void setHascill_code(String Hascill_code) {
		setAttrVal("Hascill_code", Hascill_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHascill_name() {
		return ((String) getAttrVal("Hascill_name"));
	}	
	/**
	 * 名称
	 * @param Hascill_name
	 */
	public void setHascill_name(String Hascill_name) {
		setAttrVal("Hascill_name", Hascill_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHasupsecsur_code() {
		return ((String) getAttrVal("Hasupsecsur_code"));
	}	
	/**
	 * 编码
	 * @param Hasupsecsur_code
	 */
	public void setHasupsecsur_code(String Hasupsecsur_code) {
		setAttrVal("Hasupsecsur_code", Hasupsecsur_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHasupsecsur_name() {
		return ((String) getAttrVal("Hasupsecsur_name"));
	}	
	/**
	 * 名称
	 * @param Hasupsecsur_name
	 */
	public void setHasupsecsur_name(String Hasupsecsur_name) {
		setAttrVal("Hasupsecsur_name", Hasupsecsur_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_inicu_code() {
		return ((String) getAttrVal("Has_inicu_code"));
	}	
	/**
	 * 编码
	 * @param Has_inicu_code
	 */
	public void setHas_inicu_code(String Has_inicu_code) {
		setAttrVal("Has_inicu_code", Has_inicu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_inicu_name() {
		return ((String) getAttrVal("Has_inicu_name"));
	}	
	/**
	 * 名称
	 * @param Has_inicu_name
	 */
	public void setHas_inicu_name(String Has_inicu_name) {
		setAttrVal("Has_inicu_name", Has_inicu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDic_hos_code() {
		return ((String) getAttrVal("Dic_hos_code"));
	}	
	/**
	 * 编码
	 * @param Dic_hos_code
	 */
	public void setDic_hos_code(String Dic_hos_code) {
		setAttrVal("Dic_hos_code", Dic_hos_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDic_hos_name() {
		return ((String) getAttrVal("Dic_hos_name"));
	}	
	/**
	 * 名称
	 * @param Dic_hos_name
	 */
	public void setDic_hos_name(String Dic_hos_name) {
		setAttrVal("Dic_hos_name", Dic_hos_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDic_surgery_code() {
		return ((String) getAttrVal("Dic_surgery_code"));
	}	
	/**
	 * 编码
	 * @param Dic_surgery_code
	 */
	public void setDic_surgery_code(String Dic_surgery_code) {
		setAttrVal("Dic_surgery_code", Dic_surgery_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDic_surgery_name() {
		return ((String) getAttrVal("Dic_surgery_name"));
	}	
	/**
	 * 名称
	 * @param Dic_surgery_name
	 */
	public void setDic_surgery_name(String Dic_surgery_name) {
		setAttrVal("Dic_surgery_name", Dic_surgery_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDic_ci_code() {
		return ((String) getAttrVal("Dic_ci_code"));
	}	
	/**
	 * 编码
	 * @param Dic_ci_code
	 */
	public void setDic_ci_code(String Dic_ci_code) {
		setAttrVal("Dic_ci_code", Dic_ci_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDic_ci_name() {
		return ((String) getAttrVal("Dic_ci_name"));
	}	
	/**
	 * 名称
	 * @param Dic_ci_name
	 */
	public void setDic_ci_name(String Dic_ci_name) {
		setAttrVal("Dic_ci_name", Dic_ci_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMaindi_outhos_name() {
		return ((String) getAttrVal("Maindi_outhos_name"));
	}	
	/**
	 * 名称
	 * @param Maindi_outhos_name
	 */
	public void setMaindi_outhos_name(String Maindi_outhos_name) {
		setAttrVal("Maindi_outhos_name", Maindi_outhos_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMaindi_outhos_code() {
		return ((String) getAttrVal("Maindi_outhos_code"));
	}	
	/**
	 * 编码
	 * @param Maindi_outhos_code
	 */
	public void setMaindi_outhos_code(String Maindi_outhos_code) {
		setAttrVal("Maindi_outhos_code", Maindi_outhos_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDic_outpa_code() {
		return ((String) getAttrVal("Dic_outpa_code"));
	}	
	/**
	 * 编码
	 * @param Dic_outpa_code
	 */
	public void setDic_outpa_code(String Dic_outpa_code) {
		setAttrVal("Dic_outpa_code", Dic_outpa_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDic_outpa_name() {
		return ((String) getAttrVal("Dic_outpa_name"));
	}	
	/**
	 * 名称
	 * @param Dic_outpa_name
	 */
	public void setDic_outpa_name(String Dic_outpa_name) {
		setAttrVal("Dic_outpa_name", Dic_outpa_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDic_radiation_code() {
		return ((String) getAttrVal("Dic_radiation_code"));
	}	
	/**
	 * 编码
	 * @param Dic_radiation_code
	 */
	public void setDic_radiation_code(String Dic_radiation_code) {
		setAttrVal("Dic_radiation_code", Dic_radiation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDic_radiation_name() {
		return ((String) getAttrVal("Dic_radiation_name"));
	}	
	/**
	 * 名称
	 * @param Dic_radiation_name
	 */
	public void setDic_radiation_name(String Dic_radiation_name) {
		setAttrVal("Dic_radiation_name", Dic_radiation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCritical_case_code() {
		return ((String) getAttrVal("Critical_case_code"));
	}	
	/**
	 * 编码
	 * @param Critical_case_code
	 */
	public void setCritical_case_code(String Critical_case_code) {
		setAttrVal("Critical_case_code", Critical_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCritical_case_name() {
		return ((String) getAttrVal("Critical_case_name"));
	}	
	/**
	 * 名称
	 * @param Critical_case_name
	 */
	public void setCritical_case_name(String Critical_case_name) {
		setAttrVal("Critical_case_name", Critical_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDifficult_case_code() {
		return ((String) getAttrVal("Difficult_case_code"));
	}	
	/**
	 * 编码
	 * @param Difficult_case_code
	 */
	public void setDifficult_case_code(String Difficult_case_code) {
		setAttrVal("Difficult_case_code", Difficult_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDifficult_case_name() {
		return ((String) getAttrVal("Difficult_case_name"));
	}	
	/**
	 * 名称
	 * @param Difficult_case_name
	 */
	public void setDifficult_case_name(String Difficult_case_name) {
		setAttrVal("Difficult_case_name", Difficult_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMdt_case_code() {
		return ((String) getAttrVal("Mdt_case_code"));
	}	
	/**
	 * 编码
	 * @param Mdt_case_code
	 */
	public void setMdt_case_code(String Mdt_case_code) {
		setAttrVal("Mdt_case_code", Mdt_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMdt_case_name() {
		return ((String) getAttrVal("Mdt_case_name"));
	}	
	/**
	 * 名称
	 * @param Mdt_case_name
	 */
	public void setMdt_case_name(String Mdt_case_name) {
		setAttrVal("Mdt_case_name", Mdt_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrgs_case_code() {
		return ((String) getAttrVal("Drgs_case_code"));
	}	
	/**
	 * 编码
	 * @param Drgs_case_code
	 */
	public void setDrgs_case_code(String Drgs_case_code) {
		setAttrVal("Drgs_case_code", Drgs_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrgs_case_name() {
		return ((String) getAttrVal("Drgs_case_name"));
	}	
	/**
	 * 名称
	 * @param Drgs_case_name
	 */
	public void setDrgs_case_name(String Drgs_case_name) {
		setAttrVal("Drgs_case_name", Drgs_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTime_case_code() {
		return ((String) getAttrVal("Time_case_code"));
	}	
	/**
	 * 编码
	 * @param Time_case_code
	 */
	public void setTime_case_code(String Time_case_code) {
		setAttrVal("Time_case_code", Time_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTime_case_name() {
		return ((String) getAttrVal("Time_case_name"));
	}	
	/**
	 * 名称
	 * @param Time_case_name
	 */
	public void setTime_case_name(String Time_case_name) {
		setAttrVal("Time_case_name", Time_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTeaching_case_code() {
		return ((String) getAttrVal("Teaching_case_code"));
	}	
	/**
	 * 编码
	 * @param Teaching_case_code
	 */
	public void setTeaching_case_code(String Teaching_case_code) {
		setAttrVal("Teaching_case_code", Teaching_case_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTeaching_case_name() {
		return ((String) getAttrVal("Teaching_case_name"));
	}	
	/**
	 * 名称
	 * @param Teaching_case_name
	 */
	public void setTeaching_case_name(String Teaching_case_name) {
		setAttrVal("Teaching_case_name", Teaching_case_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInpath_code() {
		return ((String) getAttrVal("Inpath_code"));
	}	
	/**
	 * 编码
	 * @param Inpath_code
	 */
	public void setInpath_code(String Inpath_code) {
		setAttrVal("Inpath_code", Inpath_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInpath_name() {
		return ((String) getAttrVal("Inpath_name"));
	}	
	/**
	 * 名称
	 * @param Inpath_name
	 */
	public void setInpath_name(String Inpath_name) {
		setAttrVal("Inpath_name", Inpath_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getComplete_code() {
		return ((String) getAttrVal("Complete_code"));
	}	
	/**
	 * 编码
	 * @param Complete_code
	 */
	public void setComplete_code(String Complete_code) {
		setAttrVal("Complete_code", Complete_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getComplete_name() {
		return ((String) getAttrVal("Complete_name"));
	}	
	/**
	 * 名称
	 * @param Complete_name
	 */
	public void setComplete_name(String Complete_name) {
		setAttrVal("Complete_name", Complete_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getVariation_code() {
		return ((String) getAttrVal("Variation_code"));
	}	
	/**
	 * 编码
	 * @param Variation_code
	 */
	public void setVariation_code(String Variation_code) {
		setAttrVal("Variation_code", Variation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getVariation_name() {
		return ((String) getAttrVal("Variation_name"));
	}	
	/**
	 * 名称
	 * @param Variation_name
	 */
	public void setVariation_name(String Variation_name) {
		setAttrVal("Variation_name", Variation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_sug_using_code() {
		return ((String) getAttrVal("Ant_sug_using_code"));
	}	
	/**
	 * 编码
	 * @param Ant_sug_using_code
	 */
	public void setAnt_sug_using_code(String Ant_sug_using_code) {
		setAttrVal("Ant_sug_using_code", Ant_sug_using_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_sug_using_name() {
		return ((String) getAttrVal("Ant_sug_using_name"));
	}	
	/**
	 * 名称
	 * @param Ant_sug_using_name
	 */
	public void setAnt_sug_using_name(String Ant_sug_using_name) {
		setAttrVal("Ant_sug_using_name", Ant_sug_using_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_sug_plan_code() {
		return ((String) getAttrVal("Ant_sug_plan_code"));
	}	
	/**
	 * 编码
	 * @param Ant_sug_plan_code
	 */
	public void setAnt_sug_plan_code(String Ant_sug_plan_code) {
		setAttrVal("Ant_sug_plan_code", Ant_sug_plan_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_sug_plan_name() {
		return ((String) getAttrVal("Ant_sug_plan_name"));
	}	
	/**
	 * 名称
	 * @param Ant_sug_plan_name
	 */
	public void setAnt_sug_plan_name(String Ant_sug_plan_name) {
		setAttrVal("Ant_sug_plan_name", Ant_sug_plan_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_infu_code() {
		return ((String) getAttrVal("Has_infu_code"));
	}	
	/**
	 * 编码
	 * @param Has_infu_code
	 */
	public void setHas_infu_code(String Has_infu_code) {
		setAttrVal("Has_infu_code", Has_infu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_infu_name() {
		return ((String) getAttrVal("Has_infu_name"));
	}	
	/**
	 * 名称
	 * @param Has_infu_name
	 */
	public void setHas_infu_name(String Has_infu_name) {
		setAttrVal("Has_infu_name", Has_infu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfu_reac_code() {
		return ((String) getAttrVal("Infu_reac_code"));
	}	
	/**
	 * 编码
	 * @param Infu_reac_code
	 */
	public void setInfu_reac_code(String Infu_reac_code) {
		setAttrVal("Infu_reac_code", Infu_reac_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfu_reac_name() {
		return ((String) getAttrVal("Infu_reac_name"));
	}	
	/**
	 * 名称
	 * @param Infu_reac_name
	 */
	public void setInfu_reac_name(String Infu_reac_name) {
		setAttrVal("Infu_reac_name", Infu_reac_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_tran_code() {
		return ((String) getAttrVal("Has_tran_code"));
	}	
	/**
	 * 编码
	 * @param Has_tran_code
	 */
	public void setHas_tran_code(String Has_tran_code) {
		setAttrVal("Has_tran_code", Has_tran_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_tran_name() {
		return ((String) getAttrVal("Has_tran_name"));
	}	
	/**
	 * 名称
	 * @param Has_tran_name
	 */
	public void setHas_tran_name(String Has_tran_name) {
		setAttrVal("Has_tran_name", Has_tran_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTran_reac_code() {
		return ((String) getAttrVal("Tran_reac_code"));
	}	
	/**
	 * 编码
	 * @param Tran_reac_code
	 */
	public void setTran_reac_code(String Tran_reac_code) {
		setAttrVal("Tran_reac_code", Tran_reac_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTran_reac_name() {
		return ((String) getAttrVal("Tran_reac_name"));
	}	
	/**
	 * 名称
	 * @param Tran_reac_name
	 */
	public void setTran_reac_name(String Tran_reac_name) {
		setAttrVal("Tran_reac_name", Tran_reac_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_ps_code() {
		return ((String) getAttrVal("Has_ps_code"));
	}	
	/**
	 * 编码
	 * @param Has_ps_code
	 */
	public void setHas_ps_code(String Has_ps_code) {
		setAttrVal("Has_ps_code", Has_ps_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_ps_name() {
		return ((String) getAttrVal("Has_ps_name"));
	}	
	/**
	 * 名称
	 * @param Has_ps_name
	 */
	public void setHas_ps_name(String Has_ps_name) {
		setAttrVal("Has_ps_name", Has_ps_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_fall_code() {
		return ((String) getAttrVal("Has_fall_code"));
	}	
	/**
	 * 编码
	 * @param Has_fall_code
	 */
	public void setHas_fall_code(String Has_fall_code) {
		setAttrVal("Has_fall_code", Has_fall_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_fall_name() {
		return ((String) getAttrVal("Has_fall_name"));
	}	
	/**
	 * 名称
	 * @param Has_fall_name
	 */
	public void setHas_fall_name(String Has_fall_name) {
		setAttrVal("Has_fall_name", Has_fall_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_pc_code() {
		return ((String) getAttrVal("Has_pc_code"));
	}	
	/**
	 * 编码
	 * @param Has_pc_code
	 */
	public void setHas_pc_code(String Has_pc_code) {
		setAttrVal("Has_pc_code", Has_pc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_pc_name() {
		return ((String) getAttrVal("Has_pc_name"));
	}	
	/**
	 * 名称
	 * @param Has_pc_name
	 */
	public void setHas_pc_name(String Has_pc_name) {
		setAttrVal("Has_pc_name", Has_pc_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_aaout_code() {
		return ((String) getAttrVal("Has_aaout_code"));
	}	
	/**
	 * 编码
	 * @param Has_aaout_code
	 */
	public void setHas_aaout_code(String Has_aaout_code) {
		setAttrVal("Has_aaout_code", Has_aaout_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_aaout_name() {
		return ((String) getAttrVal("Has_aaout_name"));
	}	
	/**
	 * 名称
	 * @param Has_aaout_name
	 */
	public void setHas_aaout_name(String Has_aaout_name) {
		setAttrVal("Has_aaout_name", Has_aaout_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_inicu_again_code() {
		return ((String) getAttrVal("Has_inicu_again_code"));
	}	
	/**
	 * 编码
	 * @param Has_inicu_again_code
	 */
	public void setHas_inicu_again_code(String Has_inicu_again_code) {
		setAttrVal("Has_inicu_again_code", Has_inicu_again_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_inicu_again_name() {
		return ((String) getAttrVal("Has_inicu_again_name"));
	}	
	/**
	 * 名称
	 * @param Has_inicu_again_name
	 */
	public void setHas_inicu_again_name(String Has_inicu_again_name) {
		setAttrVal("Has_inicu_again_name", Has_inicu_again_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_death_insug_code() {
		return ((String) getAttrVal("Has_death_insug_code"));
	}	
	/**
	 * 编码
	 * @param Has_death_insug_code
	 */
	public void setHas_death_insug_code(String Has_death_insug_code) {
		setAttrVal("Has_death_insug_code", Has_death_insug_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_death_insug_name() {
		return ((String) getAttrVal("Has_death_insug_name"));
	}	
	/**
	 * 名称
	 * @param Has_death_insug_name
	 */
	public void setHas_death_insug_name(String Has_death_insug_name) {
		setAttrVal("Has_death_insug_name", Has_death_insug_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_death_aftersug_code() {
		return ((String) getAttrVal("Has_death_aftersug_code"));
	}	
	/**
	 * 编码
	 * @param Has_death_aftersug_code
	 */
	public void setHas_death_aftersug_code(String Has_death_aftersug_code) {
		setAttrVal("Has_death_aftersug_code", Has_death_aftersug_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_death_aftersug_name() {
		return ((String) getAttrVal("Has_death_aftersug_name"));
	}	
	/**
	 * 名称
	 * @param Has_death_aftersug_name
	 */
	public void setHas_death_aftersug_name(String Has_death_aftersug_name) {
		setAttrVal("Has_death_aftersug_name", Has_death_aftersug_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_samedi_code() {
		return ((String) getAttrVal("Has_samedi_code"));
	}	
	/**
	 * 编码
	 * @param Has_samedi_code
	 */
	public void setHas_samedi_code(String Has_samedi_code) {
		setAttrVal("Has_samedi_code", Has_samedi_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_samedi_name() {
		return ((String) getAttrVal("Has_samedi_name"));
	}	
	/**
	 * 名称
	 * @param Has_samedi_name
	 */
	public void setHas_samedi_name(String Has_samedi_name) {
		setAttrVal("Has_samedi_name", Has_samedi_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBetween_inhos_code() {
		return ((String) getAttrVal("Between_inhos_code"));
	}	
	/**
	 * 编码
	 * @param Between_inhos_code
	 */
	public void setBetween_inhos_code(String Between_inhos_code) {
		setAttrVal("Between_inhos_code", Between_inhos_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBetween_inhos_name() {
		return ((String) getAttrVal("Between_inhos_name"));
	}	
	/**
	 * 名称
	 * @param Between_inhos_name
	 */
	public void setBetween_inhos_name(String Between_inhos_name) {
		setAttrVal("Between_inhos_name", Between_inhos_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPs_begin_code() {
		return ((String) getAttrVal("Ps_begin_code"));
	}	
	/**
	 * 编码
	 * @param Ps_begin_code
	 */
	public void setPs_begin_code(String Ps_begin_code) {
		setAttrVal("Ps_begin_code", Ps_begin_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPs_begin_name() {
		return ((String) getAttrVal("Ps_begin_name"));
	}	
	/**
	 * 名称
	 * @param Ps_begin_name
	 */
	public void setPs_begin_name(String Ps_begin_name) {
		setAttrVal("Ps_begin_name", Ps_begin_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPs_stage_code() {
		return ((String) getAttrVal("Ps_stage_code"));
	}	
	/**
	 * 编码
	 * @param Ps_stage_code
	 */
	public void setPs_stage_code(String Ps_stage_code) {
		setAttrVal("Ps_stage_code", Ps_stage_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPs_stage_name() {
		return ((String) getAttrVal("Ps_stage_name"));
	}	
	/**
	 * 名称
	 * @param Ps_stage_name
	 */
	public void setPs_stage_name(String Ps_stage_name) {
		setAttrVal("Ps_stage_name", Ps_stage_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFall_hurtlvl_code() {
		return ((String) getAttrVal("Fall_hurtlvl_code"));
	}	
	/**
	 * 编码
	 * @param Fall_hurtlvl_code
	 */
	public void setFall_hurtlvl_code(String Fall_hurtlvl_code) {
		setAttrVal("Fall_hurtlvl_code", Fall_hurtlvl_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFall_hurtlvl_name() {
		return ((String) getAttrVal("Fall_hurtlvl_name"));
	}	
	/**
	 * 名称
	 * @param Fall_hurtlvl_name
	 */
	public void setFall_hurtlvl_name(String Fall_hurtlvl_name) {
		setAttrVal("Fall_hurtlvl_name", Fall_hurtlvl_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFall_reason_code() {
		return ((String) getAttrVal("Fall_reason_code"));
	}	
	/**
	 * 编码
	 * @param Fall_reason_code
	 */
	public void setFall_reason_code(String Fall_reason_code) {
		setAttrVal("Fall_reason_code", Fall_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFall_reason_name() {
		return ((String) getAttrVal("Fall_reason_name"));
	}	
	/**
	 * 名称
	 * @param Fall_reason_name
	 */
	public void setFall_reason_name(String Fall_reason_name) {
		setAttrVal("Fall_reason_name", Fall_reason_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPc_method_code() {
		return ((String) getAttrVal("Pc_method_code"));
	}	
	/**
	 * 编码
	 * @param Pc_method_code
	 */
	public void setPc_method_code(String Pc_method_code) {
		setAttrVal("Pc_method_code", Pc_method_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPc_method_name() {
		return ((String) getAttrVal("Pc_method_name"));
	}	
	/**
	 * 名称
	 * @param Pc_method_name
	 */
	public void setPc_method_name(String Pc_method_name) {
		setAttrVal("Pc_method_name", Pc_method_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPc_tool_code() {
		return ((String) getAttrVal("Pc_tool_code"));
	}	
	/**
	 * 编码
	 * @param Pc_tool_code
	 */
	public void setPc_tool_code(String Pc_tool_code) {
		setAttrVal("Pc_tool_code", Pc_tool_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPc_tool_name() {
		return ((String) getAttrVal("Pc_tool_name"));
	}	
	/**
	 * 名称
	 * @param Pc_tool_name
	 */
	public void setPc_tool_name(String Pc_tool_name) {
		setAttrVal("Pc_tool_name", Pc_tool_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPc_reason_code() {
		return ((String) getAttrVal("Pc_reason_code"));
	}	
	/**
	 * 编码
	 * @param Pc_reason_code
	 */
	public void setPc_reason_code(String Pc_reason_code) {
		setAttrVal("Pc_reason_code", Pc_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPc_reason_name() {
		return ((String) getAttrVal("Pc_reason_name"));
	}	
	/**
	 * 名称
	 * @param Pc_reason_name
	 */
	public void setPc_reason_name(String Pc_reason_name) {
		setAttrVal("Pc_reason_name", Pc_reason_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBaby_outhos_code() {
		return ((String) getAttrVal("Baby_outhos_code"));
	}	
	/**
	 * 编码
	 * @param Baby_outhos_code
	 */
	public void setBaby_outhos_code(String Baby_outhos_code) {
		setAttrVal("Baby_outhos_code", Baby_outhos_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBaby_outhos_name() {
		return ((String) getAttrVal("Baby_outhos_name"));
	}	
	/**
	 * 名称
	 * @param Baby_outhos_name
	 */
	public void setBaby_outhos_name(String Baby_outhos_name) {
		setAttrVal("Baby_outhos_name", Baby_outhos_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBetween_inicu_code() {
		return ((String) getAttrVal("Between_inicu_code"));
	}	
	/**
	 * 编码
	 * @param Between_inicu_code
	 */
	public void setBetween_inicu_code(String Between_inicu_code) {
		setAttrVal("Between_inicu_code", Between_inicu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBetween_inicu_name() {
		return ((String) getAttrVal("Between_inicu_name"));
	}	
	/**
	 * 名称
	 * @param Between_inicu_name
	 */
	public void setBetween_inicu_name(String Between_inicu_name) {
		setAttrVal("Between_inicu_name", Between_inicu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSc_code() {
		return ((String) getAttrVal("Sc_code"));
	}	
	/**
	 * 编码
	 * @param Sc_code
	 */
	public void setSc_code(String Sc_code) {
		setAttrVal("Sc_code", Sc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSc_name() {
		return ((String) getAttrVal("Sc_name"));
	}	
	/**
	 * 名称
	 * @param Sc_name
	 */
	public void setSc_name(String Sc_name) {
		setAttrVal("Sc_name", Sc_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getConfirmed_code() {
		return ((String) getAttrVal("Confirmed_code"));
	}	
	/**
	 * 编码
	 * @param Confirmed_code
	 */
	public void setConfirmed_code(String Confirmed_code) {
		setAttrVal("Confirmed_code", Confirmed_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getConfirmed_name() {
		return ((String) getAttrVal("Confirmed_name"));
	}	
	/**
	 * 名称
	 * @param Confirmed_name
	 */
	public void setConfirmed_name(String Confirmed_name) {
		setAttrVal("Confirmed_name", Confirmed_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOtherdi_outhos_code() {
		return ((String) getAttrVal("Otherdi_outhos_code"));
	}	
	/**
	 * 编码
	 * @param Otherdi_outhos_code
	 */
	public void setOtherdi_outhos_code(String Otherdi_outhos_code) {
		setAttrVal("Otherdi_outhos_code", Otherdi_outhos_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOtherdi_outhos_name() {
		return ((String) getAttrVal("Otherdi_outhos_name"));
	}	
	/**
	 * 名称
	 * @param Otherdi_outhos_name
	 */
	public void setOtherdi_outhos_name(String Otherdi_outhos_name) {
		setAttrVal("Otherdi_outhos_name", Otherdi_outhos_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIcu_typename_code() {
		return ((String) getAttrVal("Icu_typename_code"));
	}	
	/**
	 * 编码
	 * @param Icu_typename_code
	 */
	public void setIcu_typename_code(String Icu_typename_code) {
		setAttrVal("Icu_typename_code", Icu_typename_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIcu_typename_name() {
		return ((String) getAttrVal("Icu_typename_name"));
	}	
	/**
	 * 名称
	 * @param Icu_typename_name
	 */
	public void setIcu_typename_name(String Icu_typename_name) {
		setAttrVal("Icu_typename_name", Icu_typename_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInhos_situation_code() {
		return ((String) getAttrVal("Inhos_situation_code"));
	}	
	/**
	 * 编码
	 * @param Inhos_situation_code
	 */
	public void setInhos_situation_code(String Inhos_situation_code) {
		setAttrVal("Inhos_situation_code", Inhos_situation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInhos_situation_name() {
		return ((String) getAttrVal("Inhos_situation_name"));
	}	
	/**
	 * 名称
	 * @param Inhos_situation_name
	 */
	public void setInhos_situation_name(String Inhos_situation_name) {
		setAttrVal("Inhos_situation_name", Inhos_situation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHbsag_code() {
		return ((String) getAttrVal("Hbsag_code"));
	}	
	/**
	 * 编码
	 * @param Hbsag_code
	 */
	public void setHbsag_code(String Hbsag_code) {
		setAttrVal("Hbsag_code", Hbsag_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHbsag_name() {
		return ((String) getAttrVal("Hbsag_name"));
	}	
	/**
	 * 名称
	 * @param Hbsag_name
	 */
	public void setHbsag_name(String Hbsag_name) {
		setAttrVal("Hbsag_name", Hbsag_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHcv_ab_code() {
		return ((String) getAttrVal("Hcv_ab_code"));
	}	
	/**
	 * 编码
	 * @param Hcv_ab_code
	 */
	public void setHcv_ab_code(String Hcv_ab_code) {
		setAttrVal("Hcv_ab_code", Hcv_ab_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHcv_ab_name() {
		return ((String) getAttrVal("Hcv_ab_name"));
	}	
	/**
	 * 名称
	 * @param Hcv_ab_name
	 */
	public void setHcv_ab_name(String Hcv_ab_name) {
		setAttrVal("Hcv_ab_name", Hcv_ab_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHiv_ab_code() {
		return ((String) getAttrVal("Hiv_ab_code"));
	}	
	/**
	 * 编码
	 * @param Hiv_ab_code
	 */
	public void setHiv_ab_code(String Hiv_ab_code) {
		setAttrVal("Hiv_ab_code", Hiv_ab_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHiv_ab_name() {
		return ((String) getAttrVal("Hiv_ab_name"));
	}	
	/**
	 * 名称
	 * @param Hiv_ab_name
	 */
	public void setHiv_ab_name(String Hiv_ab_name) {
		setAttrVal("Hiv_ab_name", Hiv_ab_name);
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
		return "Id_cimrfpothert";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_OTHER_T";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpOtherTDODesc.class);
	}
	
}