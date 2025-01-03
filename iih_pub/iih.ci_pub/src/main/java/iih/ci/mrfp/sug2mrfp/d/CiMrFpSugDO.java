package iih.ci.mrfp.sug2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.sug2mrfp.d.desc.CiMrFpSugDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录_住院病历首页_手术 DO数据 
 * 
 */
public class CiMrFpSugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//住院病历首页手术ID
	public static final String ID_MRFPSUG= "Id_mrfpsug";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//住院病历首页
	public static final String ID_MRFP= "Id_mrfp";
	//序号
	public static final String SORTNO= "Sortno";
	//就诊号
	public static final String ID_ENT= "Id_ent";
	//患者号
	public static final String ID_PAT= "Id_pat";
	//手术、操作编码ID
	public static final String ID_SUG= "Id_sug";
	//手术、操作编码
	public static final String SD_SUG= "Sd_sug";
	//手术、操作名称
	public static final String NAME_SUG= "Name_sug";
	//手术级别
	public static final String ID_LVLSUG= "Id_lvlsug";
	//手术级别编码
	public static final String SD_LVLSUG= "Sd_lvlsug";
	//手术级别名称
	public static final String NAME_LVLSUG= "Name_lvlsug";
	//手术及操作开始时间
	public static final String DT_START_SUG= "Dt_start_sug";
	//手术、操作结束时间
	public static final String DT_END_SUG= "Dt_end_sug";
	//手术及操作医师_术者
	public static final String ID_EMP_SUG= "Id_emp_sug";
	//手术及操作医师_术者编码
	public static final String SD_EMP_SUG= "Sd_emp_sug";
	//手术及操作医师_术者名称
	public static final String NAME_EMP_SUG= "Name_emp_sug";
	//手术及操作医师_I助
	public static final String ID_EMP_ASST1= "Id_emp_asst1";
	//手术及操作医师_I助编码
	public static final String SD_EMP_ASST1= "Sd_emp_asst1";
	//手术及操作医师_I助名称
	public static final String NAME_EMP_ASST1= "Name_emp_asst1";
	//手术及操作医师_II助
	public static final String ID_EMP_ASST2= "Id_emp_asst2";
	//手术及操作医师_II助编码
	public static final String SD_EMP_ASST2= "Sd_emp_asst2";
	//手术及操作医师_II助名称
	public static final String NAME_EMP_ASST2= "Name_emp_asst2";
	//麻醉医师
	public static final String ID_EMP_ANES= "Id_emp_anes";
	//麻醉医师编码
	public static final String SD_EMP_ANES= "Sd_emp_anes";
	//麻醉医师名称
	public static final String NAME_EMP_ANES= "Name_emp_anes";
	//切口等级
	public static final String ID_INCITP= "Id_incitp";
	//切口等级编码
	public static final String SD_INCITP= "Sd_incitp";
	//切口等级名称
	public static final String NAME_INCITP= "Name_incitp";
	//麻醉方式
	public static final String ID_ANESTP= "Id_anestp";
	//麻醉方式编码
	public static final String SD_ANESTP= "Sd_anestp";
	//麻醉方式名称
	public static final String NAME_ANESTP= "Name_anestp";
	//切口愈合情况
	public static final String ID_INCICONDI= "Id_incicondi";
	//切口愈合情况编码
	public static final String SD_INCICONDI= "Sd_incicondi";
	//切口愈合情况名称
	public static final String NAME_INCICONDI= "Name_incicondi";
	//是否有并发症(id)
	public static final String ID_FG_COMPLICATION= "Id_fg_complication";
	//是否有并发症(name)
	public static final String NAME_FG_COMPLICATION= "Name_fg_complication";
	//是否有并发症(sd)
	public static final String SD_FG_COMPLICATION= "Sd_fg_complication";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//手术方式id
	public static final String ID_METHOD_SUG= "Id_method_sug";
	//手术方式sd
	public static final String SD_METHOD_SUG= "Sd_method_sug";
	//手术方式
	public static final String NAME_METHOD_SUG= "Name_method_sug";
	//手术类别
	public static final String ID_CLASS_SUG= "Id_class_sug";
	//手术类别编码
	public static final String SD_CLASS_SUG= "Sd_class_sug";
	//手术类别名称
	public static final String NAME_CLASS_SUG= "Name_class_sug";
	//手术及操作日期
	public static final String OPERATION_DATE= "Operation_date";
	//手术及操作id（附页）
	public static final String ID_ATTACH_SUG= "Id_attach_sug";
	//手术及操作code（附页）
	public static final String SD_ATTACH_SUG= "Sd_attach_sug";
	//手术及操作name（附页）
	public static final String NAME_ATTACH_SUG= "Name_attach_sug";
	//麻醉等级id
	public static final String ID_ANES_LVL= "Id_anes_lvl";
	//麻醉等级code
	public static final String SD_ANES_LVL= "Sd_anes_lvl";
	//麻醉等级name
	public static final String NAME_ANES_LVL= "Name_anes_lvl";
	//手术风险等级id
	public static final String ID_SUG_RISKLVL= "Id_sug_risklvl";
	//手术风险等级code
	public static final String SD_SUG_RISKLVL= "Sd_sug_risklvl";
	//手术风险等级name
	public static final String NAME_SUG_RISKLVL= "Name_sug_risklvl";
	//是否术前预防用抗菌药物id
	public static final String ID_ANT_BEFORESUG= "Id_ant_beforesug";
	//是否术前预防用抗菌药物code
	public static final String SD_ANT_BEFORESUG= "Sd_ant_beforesug";
	//是否术前预防用抗菌药物name
	public static final String NAME_ANT_BEFORESUG= "Name_ant_beforesug";
	//清洁手术围术期预防用抗菌药物天数
	public static final String ANT_USINGDAYS= "Ant_usingdays";
	//是否非预期的二次手术id
	public static final String ID_HAS_RESUG= "Id_has_resug";
	//是否非预期的二次手术code
	public static final String SD_HAS_RESUG= "Sd_has_resug";
	//是否非预期的二次手术name
	public static final String NAME_HAS_RESUG= "Name_has_resug";
	//是否有麻醉并发症id
	public static final String ID_HAS_ANESCOMP= "Id_has_anescomp";
	//是否有麻醉并发症code
	public static final String SD_HAS_ANESCOMP= "Sd_has_anescomp";
	//是否有麻醉并发症name
	public static final String NAME_HAS_ANESCOMP= "Name_has_anescomp";
	//是否有术中异物遗留id
	public static final String ID_HAS_SUGLEAVE= "Id_has_sugleave";
	//是否有术中异物遗留code
	public static final String SD_HAS_SUGLEAVE= "Sd_has_sugleave";
	//是否有术中异物遗留name
	public static final String NAME_HAS_SUGLEAVE= "Name_has_sugleave";
	//是否有手术并发症id
	public static final String ID_HAS_SUGCOMP= "Id_has_sugcomp";
	//是否有手术并发症code
	public static final String SD_HAS_SUGCOMP= "Sd_has_sugcomp";
	//是否有手术并发症name
	public static final String NAME_HAS_SUGCOMP= "Name_has_sugcomp";
	//是否术后出血或血肿id
	public static final String ID_HASHEM_AFTERSUG= "Id_hashem_aftersug";
	//是否术后出血或血肿code
	public static final String SD_HASHEM_AFTERSUG= "Sd_hashem_aftersug";
	//是否术后出血或血肿name
	public static final String NAME_HASHEM_AFTERSUG= "Name_hashem_aftersug";
	//是否手术伤口裂开id
	public static final String ID_HASWD_AFTERSUG= "Id_haswd_aftersug";
	//是否手术伤口裂开code
	public static final String SD_HASWD_AFTERSUG= "Sd_haswd_aftersug";
	//是否手术伤口裂开name
	public static final String NAME_HASWD_AFTERSUG= "Name_haswd_aftersug";
	//是否术后深静脉血栓id
	public static final String ID_HASDVT_AFTERSUG= "Id_hasdvt_aftersug";
	//是否术后深静脉血栓code
	public static final String SD_HASDVT_AFTERSUG= "Sd_hasdvt_aftersug";
	//是否术后深静脉血栓name
	public static final String NAME_HASDVT_AFTERSUG= "Name_hasdvt_aftersug";
	//是否术后生理/代谢紊乱id
	public static final String ID_HASMD_AFTERSUG= "Id_hasmd_aftersug";
	//是否术后生理/代谢紊乱code
	public static final String SD_HASMD_AFTERSUG= "Sd_hasmd_aftersug";
	//是否术后生理/代谢紊乱name
	public static final String NAME_HASMD_AFTERSUG= "Name_hasmd_aftersug";
	//是否术后呼吸衰竭id
	public static final String ID_HASFOR_AFTERSUG= "Id_hasfor_aftersug";
	//是否术后呼吸衰竭code
	public static final String SD_HASFOR_AFTERSUG= "Sd_hasfor_aftersug";
	//是否术后呼吸衰竭name
	public static final String NAME_HASFOR_AFTERSUG= "Name_hasfor_aftersug";
	//是否术后肺栓塞id
	public static final String ID_HASPE_AFTERSUG= "Id_haspe_aftersug";
	//是否术后肺栓塞code
	public static final String SD_HASPE_AFTERSUG= "Sd_haspe_aftersug";
	//是否术后肺栓塞name
	public static final String NAME_HASPE_AFTERSUG= "Name_haspe_aftersug";
	//是否术后败血症id
	public static final String ID_HASHEMA_AFTERSUG= "Id_hashema_aftersug";
	//是否术后败血症code
	public static final String SD_HASHEMA_AFTERSUG= "Sd_hashema_aftersug";
	//是否术后败血症name
	public static final String NAME_HASHEMA_AFTERSUG= "Name_hashema_aftersug";
	//是否术后髋关节骨折id
	public static final String ID_HASHF_AFTERSUG= "Id_hashf_aftersug";
	//是否术后髋关节骨折code
	public static final String SD_HASHF_AFTERSUG= "Sd_hashf_aftersug";
	//是否术后髋关节骨折name
	public static final String NAME_HASHF_AFTERSUG= "Name_hashf_aftersug";
	//其他诊断对照
	public static final String ID_HPDI= "Id_hpdi";
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
	//麻醉分级id
	public static final String ID_EXEC_ANES_CLF= "Id_exec_anes_clf";
	//麻醉分级code
	public static final String SD_EXEC_ANES_CLF= "Sd_exec_anes_clf";
	//麻醉分级name
	public static final String NAME_EXEC_ANES_CLF= "Name_exec_anes_clf";
	//主要手术持续时间
	public static final String MAIN_SUG_TIMES= "Main_sug_times";
	//其他手术持续时间
	public static final String OTHER_SUG_TIMES= "Other_sug_times";
	//主要手术标识
	public static final String FG_MAIN_SUG= "Fg_main_sug";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//诊断编码
	public static final String SUG_CODE= "Sug_code";
	//诊断名称
	public static final String SUG_NAME= "Sug_name";
	//编码
	public static final String LVLSUG_CODE= "Lvlsug_code";
	//名称
	public static final String LVLSUG_NAME= "Lvlsug_name";
	//用户名称
	public static final String EMP_SUG_NAME= "Emp_sug_name";
	//用户编码
	public static final String EMP_SUG_CODE= "Emp_sug_code";
	//用户名称
	public static final String EMP_ASST1_NAME= "Emp_asst1_name";
	//用户编码
	public static final String EMP_ASST1_CODE= "Emp_asst1_code";
	//用户名称
	public static final String EMP_ASST2_NAME= "Emp_asst2_name";
	//用户编码
	public static final String EMP_ASST2_CODE= "Emp_asst2_code";
	//用户名称
	public static final String EMP_ANES_NAME= "Emp_anes_name";
	//用户编码
	public static final String EMP_ANES_CODE= "Emp_anes_code";
	//编码
	public static final String INCITP_CODE= "Incitp_code";
	//名称
	public static final String INCITP_NAME= "Incitp_name";
	//编码
	public static final String ANESTP_CODE= "Anestp_code";
	//名称
	public static final String ANESTP_NAME= "Anestp_name";
	//编码
	public static final String INCICONDI_CODE= "Incicondi_code";
	//名称
	public static final String INCICONDI_NAME= "Incicondi_name";
	//编码
	public static final String METHOD_CODE= "Method_code";
	//名称
	public static final String METHOD_NAME= "Method_name";
	//手术类别编码
	public static final String CODE_CLASS_SUG= "Code_class_sug";
	//手术类别名称
	public static final String CLASS_SUG_NAME= "Class_sug_name";
	//手术、操作编码
	public static final String ATTACH_SD_SUG= "Attach_sd_sug";
	//手术、操作名称
	public static final String ATTACH_NAME_SUG= "Attach_name_sug";
	//编码
	public static final String ANT_BS_CODE= "Ant_bs_code";
	//名称
	public static final String ANT_BS_NAME= "Ant_bs_name";
	//编码
	public static final String HAS_RESUG_CODE= "Has_resug_code";
	//名称
	public static final String HAS_RESUG_NAME= "Has_resug_name";
	//名称
	public static final String HAS_ANESCOMP_NAME= "Has_anescomp_name";
	//编码
	public static final String HAS_ANESCOMP_CODE= "Has_anescomp_code";
	//编码
	public static final String HAS_SUGLEAVE_CODE= "Has_sugleave_code";
	//名称
	public static final String HAS_SUGLEAVE_NAME= "Has_sugleave_name";
	//编码
	public static final String HAS_SUGCOMP_CODE= "Has_sugcomp_code";
	//名称
	public static final String HAS_SUGCOMP_NAME= "Has_sugcomp_name";
	//编码
	public static final String HASHEM_CODE= "Hashem_code";
	//名称
	public static final String HASHEM_NAME= "Hashem_name";
	//名称
	public static final String HASWD_NAME= "Haswd_name";
	//编码
	public static final String HASWD_CODE= "Haswd_code";
	//名称
	public static final String HASDVT_NAME= "Hasdvt_name";
	//编码
	public static final String HASDVT_CODE= "Hasdvt_code";
	//编码
	public static final String HASMD_CODE= "Hasmd_code";
	//名称
	public static final String HASMD_NAME= "Hasmd_name";
	//名称
	public static final String HASFOR_NAME= "Hasfor_name";
	//编码
	public static final String HASFOR_CODE= "Hasfor_code";
	//编码
	public static final String HASPE_CODE= "Haspe_code";
	//名称
	public static final String HASPE_NAME= "Haspe_name";
	//名称
	public static final String HASHEMA_NAME= "Hashema_name";
	//编码
	public static final String HASHEMA_CODE= "Hashema_code";
	//编码
	public static final String HASHF_CODE= "Hashf_code";
	//名称
	public static final String HASHF_NAME= "Hashf_name";
	//疾病编码
	public static final String CODE_HPDI= "Code_hpdi";
	//疾病名称
	public static final String NAME_HPDI= "Name_hpdi";
	//编码
	public static final String EXEC_ANES_CLF_CODE= "Exec_anes_clf_code";
	//名称
	public static final String EXEC_ANES_CLF_NAME= "Exec_anes_clf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 住院病历首页手术ID
	 * @return String
	 */
	public String getId_mrfpsug() {
		return ((String) getAttrVal("Id_mrfpsug"));
	}	
	/**
	 * 住院病历首页手术ID
	 * @param Id_mrfpsug
	 */
	public void setId_mrfpsug(String Id_mrfpsug) {
		setAttrVal("Id_mrfpsug", Id_mrfpsug);
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
	 * 住院病历首页
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	/**
	 * 住院病历首页
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者号
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 手术、操作编码ID
	 * @return String
	 */
	public String getId_sug() {
		return ((String) getAttrVal("Id_sug"));
	}	
	/**
	 * 手术、操作编码ID
	 * @param Id_sug
	 */
	public void setId_sug(String Id_sug) {
		setAttrVal("Id_sug", Id_sug);
	}
	/**
	 * 手术、操作编码
	 * @return String
	 */
	public String getSd_sug() {
		return ((String) getAttrVal("Sd_sug"));
	}	
	/**
	 * 手术、操作编码
	 * @param Sd_sug
	 */
	public void setSd_sug(String Sd_sug) {
		setAttrVal("Sd_sug", Sd_sug);
	}
	/**
	 * 手术、操作名称
	 * @return String
	 */
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}	
	/**
	 * 手术、操作名称
	 * @param Name_sug
	 */
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	/**
	 * 手术级别
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	/**
	 * 手术级别编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 手术级别名称
	 * @return String
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	/**
	 * 手术级别名称
	 * @param Name_lvlsug
	 */
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 手术及操作开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start_sug() {
		return ((FDateTime) getAttrVal("Dt_start_sug"));
	}	
	/**
	 * 手术及操作开始时间
	 * @param Dt_start_sug
	 */
	public void setDt_start_sug(FDateTime Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	/**
	 * 手术、操作结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_sug() {
		return ((FDateTime) getAttrVal("Dt_end_sug"));
	}	
	/**
	 * 手术、操作结束时间
	 * @param Dt_end_sug
	 */
	public void setDt_end_sug(FDateTime Dt_end_sug) {
		setAttrVal("Dt_end_sug", Dt_end_sug);
	}
	/**
	 * 手术及操作医师_术者
	 * @return String
	 */
	public String getId_emp_sug() {
		return ((String) getAttrVal("Id_emp_sug"));
	}	
	/**
	 * 手术及操作医师_术者
	 * @param Id_emp_sug
	 */
	public void setId_emp_sug(String Id_emp_sug) {
		setAttrVal("Id_emp_sug", Id_emp_sug);
	}
	/**
	 * 手术及操作医师_术者编码
	 * @return String
	 */
	public String getSd_emp_sug() {
		return ((String) getAttrVal("Sd_emp_sug"));
	}	
	/**
	 * 手术及操作医师_术者编码
	 * @param Sd_emp_sug
	 */
	public void setSd_emp_sug(String Sd_emp_sug) {
		setAttrVal("Sd_emp_sug", Sd_emp_sug);
	}
	/**
	 * 手术及操作医师_术者名称
	 * @return String
	 */
	public String getName_emp_sug() {
		return ((String) getAttrVal("Name_emp_sug"));
	}	
	/**
	 * 手术及操作医师_术者名称
	 * @param Name_emp_sug
	 */
	public void setName_emp_sug(String Name_emp_sug) {
		setAttrVal("Name_emp_sug", Name_emp_sug);
	}
	/**
	 * 手术及操作医师_I助
	 * @return String
	 */
	public String getId_emp_asst1() {
		return ((String) getAttrVal("Id_emp_asst1"));
	}	
	/**
	 * 手术及操作医师_I助
	 * @param Id_emp_asst1
	 */
	public void setId_emp_asst1(String Id_emp_asst1) {
		setAttrVal("Id_emp_asst1", Id_emp_asst1);
	}
	/**
	 * 手术及操作医师_I助编码
	 * @return String
	 */
	public String getSd_emp_asst1() {
		return ((String) getAttrVal("Sd_emp_asst1"));
	}	
	/**
	 * 手术及操作医师_I助编码
	 * @param Sd_emp_asst1
	 */
	public void setSd_emp_asst1(String Sd_emp_asst1) {
		setAttrVal("Sd_emp_asst1", Sd_emp_asst1);
	}
	/**
	 * 手术及操作医师_I助名称
	 * @return String
	 */
	public String getName_emp_asst1() {
		return ((String) getAttrVal("Name_emp_asst1"));
	}	
	/**
	 * 手术及操作医师_I助名称
	 * @param Name_emp_asst1
	 */
	public void setName_emp_asst1(String Name_emp_asst1) {
		setAttrVal("Name_emp_asst1", Name_emp_asst1);
	}
	/**
	 * 手术及操作医师_II助
	 * @return String
	 */
	public String getId_emp_asst2() {
		return ((String) getAttrVal("Id_emp_asst2"));
	}	
	/**
	 * 手术及操作医师_II助
	 * @param Id_emp_asst2
	 */
	public void setId_emp_asst2(String Id_emp_asst2) {
		setAttrVal("Id_emp_asst2", Id_emp_asst2);
	}
	/**
	 * 手术及操作医师_II助编码
	 * @return String
	 */
	public String getSd_emp_asst2() {
		return ((String) getAttrVal("Sd_emp_asst2"));
	}	
	/**
	 * 手术及操作医师_II助编码
	 * @param Sd_emp_asst2
	 */
	public void setSd_emp_asst2(String Sd_emp_asst2) {
		setAttrVal("Sd_emp_asst2", Sd_emp_asst2);
	}
	/**
	 * 手术及操作医师_II助名称
	 * @return String
	 */
	public String getName_emp_asst2() {
		return ((String) getAttrVal("Name_emp_asst2"));
	}	
	/**
	 * 手术及操作医师_II助名称
	 * @param Name_emp_asst2
	 */
	public void setName_emp_asst2(String Name_emp_asst2) {
		setAttrVal("Name_emp_asst2", Name_emp_asst2);
	}
	/**
	 * 麻醉医师
	 * @return String
	 */
	public String getId_emp_anes() {
		return ((String) getAttrVal("Id_emp_anes"));
	}	
	/**
	 * 麻醉医师
	 * @param Id_emp_anes
	 */
	public void setId_emp_anes(String Id_emp_anes) {
		setAttrVal("Id_emp_anes", Id_emp_anes);
	}
	/**
	 * 麻醉医师编码
	 * @return String
	 */
	public String getSd_emp_anes() {
		return ((String) getAttrVal("Sd_emp_anes"));
	}	
	/**
	 * 麻醉医师编码
	 * @param Sd_emp_anes
	 */
	public void setSd_emp_anes(String Sd_emp_anes) {
		setAttrVal("Sd_emp_anes", Sd_emp_anes);
	}
	/**
	 * 麻醉医师名称
	 * @return String
	 */
	public String getName_emp_anes() {
		return ((String) getAttrVal("Name_emp_anes"));
	}	
	/**
	 * 麻醉医师名称
	 * @param Name_emp_anes
	 */
	public void setName_emp_anes(String Name_emp_anes) {
		setAttrVal("Name_emp_anes", Name_emp_anes);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	/**
	 * 切口等级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	/**
	 * 切口等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 切口等级名称
	 * @return String
	 */
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	/**
	 * 切口等级名称
	 * @param Name_incitp
	 */
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	/**
	 * 麻醉方式
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	/**
	 * 麻醉方式名称
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 切口愈合情况
	 * @return String
	 */
	public String getId_incicondi() {
		return ((String) getAttrVal("Id_incicondi"));
	}	
	/**
	 * 切口愈合情况
	 * @param Id_incicondi
	 */
	public void setId_incicondi(String Id_incicondi) {
		setAttrVal("Id_incicondi", Id_incicondi);
	}
	/**
	 * 切口愈合情况编码
	 * @return String
	 */
	public String getSd_incicondi() {
		return ((String) getAttrVal("Sd_incicondi"));
	}	
	/**
	 * 切口愈合情况编码
	 * @param Sd_incicondi
	 */
	public void setSd_incicondi(String Sd_incicondi) {
		setAttrVal("Sd_incicondi", Sd_incicondi);
	}
	/**
	 * 切口愈合情况名称
	 * @return String
	 */
	public String getName_incicondi() {
		return ((String) getAttrVal("Name_incicondi"));
	}	
	/**
	 * 切口愈合情况名称
	 * @param Name_incicondi
	 */
	public void setName_incicondi(String Name_incicondi) {
		setAttrVal("Name_incicondi", Name_incicondi);
	}
	/**
	 * 是否有并发症(id)
	 * @return String
	 */
	public String getId_fg_complication() {
		return ((String) getAttrVal("Id_fg_complication"));
	}	
	/**
	 * 是否有并发症(id)
	 * @param Id_fg_complication
	 */
	public void setId_fg_complication(String Id_fg_complication) {
		setAttrVal("Id_fg_complication", Id_fg_complication);
	}
	/**
	 * 是否有并发症(name)
	 * @return String
	 */
	public String getName_fg_complication() {
		return ((String) getAttrVal("Name_fg_complication"));
	}	
	/**
	 * 是否有并发症(name)
	 * @param Name_fg_complication
	 */
	public void setName_fg_complication(String Name_fg_complication) {
		setAttrVal("Name_fg_complication", Name_fg_complication);
	}
	/**
	 * 是否有并发症(sd)
	 * @return String
	 */
	public String getSd_fg_complication() {
		return ((String) getAttrVal("Sd_fg_complication"));
	}	
	/**
	 * 是否有并发症(sd)
	 * @param Sd_fg_complication
	 */
	public void setSd_fg_complication(String Sd_fg_complication) {
		setAttrVal("Sd_fg_complication", Sd_fg_complication);
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
	 * 手术方式id
	 * @return String
	 */
	public String getId_method_sug() {
		return ((String) getAttrVal("Id_method_sug"));
	}	
	/**
	 * 手术方式id
	 * @param Id_method_sug
	 */
	public void setId_method_sug(String Id_method_sug) {
		setAttrVal("Id_method_sug", Id_method_sug);
	}
	/**
	 * 手术方式sd
	 * @return String
	 */
	public String getSd_method_sug() {
		return ((String) getAttrVal("Sd_method_sug"));
	}	
	/**
	 * 手术方式sd
	 * @param Sd_method_sug
	 */
	public void setSd_method_sug(String Sd_method_sug) {
		setAttrVal("Sd_method_sug", Sd_method_sug);
	}
	/**
	 * 手术方式
	 * @return String
	 */
	public String getName_method_sug() {
		return ((String) getAttrVal("Name_method_sug"));
	}	
	/**
	 * 手术方式
	 * @param Name_method_sug
	 */
	public void setName_method_sug(String Name_method_sug) {
		setAttrVal("Name_method_sug", Name_method_sug);
	}
	/**
	 * 手术类别
	 * @return String
	 */
	public String getId_class_sug() {
		return ((String) getAttrVal("Id_class_sug"));
	}	
	/**
	 * 手术类别
	 * @param Id_class_sug
	 */
	public void setId_class_sug(String Id_class_sug) {
		setAttrVal("Id_class_sug", Id_class_sug);
	}
	/**
	 * 手术类别编码
	 * @return String
	 */
	public String getSd_class_sug() {
		return ((String) getAttrVal("Sd_class_sug"));
	}	
	/**
	 * 手术类别编码
	 * @param Sd_class_sug
	 */
	public void setSd_class_sug(String Sd_class_sug) {
		setAttrVal("Sd_class_sug", Sd_class_sug);
	}
	/**
	 * 手术类别名称
	 * @return String
	 */
	public String getName_class_sug() {
		return ((String) getAttrVal("Name_class_sug"));
	}	
	/**
	 * 手术类别名称
	 * @param Name_class_sug
	 */
	public void setName_class_sug(String Name_class_sug) {
		setAttrVal("Name_class_sug", Name_class_sug);
	}
	/**
	 * 手术及操作日期
	 * @return FDate
	 */
	public FDate getOperation_date() {
		return ((FDate) getAttrVal("Operation_date"));
	}	
	/**
	 * 手术及操作日期
	 * @param Operation_date
	 */
	public void setOperation_date(FDate Operation_date) {
		setAttrVal("Operation_date", Operation_date);
	}
	/**
	 * 手术及操作id（附页）
	 * @return String
	 */
	public String getId_attach_sug() {
		return ((String) getAttrVal("Id_attach_sug"));
	}	
	/**
	 * 手术及操作id（附页）
	 * @param Id_attach_sug
	 */
	public void setId_attach_sug(String Id_attach_sug) {
		setAttrVal("Id_attach_sug", Id_attach_sug);
	}
	/**
	 * 手术及操作code（附页）
	 * @return String
	 */
	public String getSd_attach_sug() {
		return ((String) getAttrVal("Sd_attach_sug"));
	}	
	/**
	 * 手术及操作code（附页）
	 * @param Sd_attach_sug
	 */
	public void setSd_attach_sug(String Sd_attach_sug) {
		setAttrVal("Sd_attach_sug", Sd_attach_sug);
	}
	/**
	 * 手术及操作name（附页）
	 * @return String
	 */
	public String getName_attach_sug() {
		return ((String) getAttrVal("Name_attach_sug"));
	}	
	/**
	 * 手术及操作name（附页）
	 * @param Name_attach_sug
	 */
	public void setName_attach_sug(String Name_attach_sug) {
		setAttrVal("Name_attach_sug", Name_attach_sug);
	}
	/**
	 * 麻醉等级id
	 * @return String
	 */
	public String getId_anes_lvl() {
		return ((String) getAttrVal("Id_anes_lvl"));
	}	
	/**
	 * 麻醉等级id
	 * @param Id_anes_lvl
	 */
	public void setId_anes_lvl(String Id_anes_lvl) {
		setAttrVal("Id_anes_lvl", Id_anes_lvl);
	}
	/**
	 * 麻醉等级code
	 * @return String
	 */
	public String getSd_anes_lvl() {
		return ((String) getAttrVal("Sd_anes_lvl"));
	}	
	/**
	 * 麻醉等级code
	 * @param Sd_anes_lvl
	 */
	public void setSd_anes_lvl(String Sd_anes_lvl) {
		setAttrVal("Sd_anes_lvl", Sd_anes_lvl);
	}
	/**
	 * 麻醉等级name
	 * @return String
	 */
	public String getName_anes_lvl() {
		return ((String) getAttrVal("Name_anes_lvl"));
	}	
	/**
	 * 麻醉等级name
	 * @param Name_anes_lvl
	 */
	public void setName_anes_lvl(String Name_anes_lvl) {
		setAttrVal("Name_anes_lvl", Name_anes_lvl);
	}
	/**
	 * 手术风险等级id
	 * @return String
	 */
	public String getId_sug_risklvl() {
		return ((String) getAttrVal("Id_sug_risklvl"));
	}	
	/**
	 * 手术风险等级id
	 * @param Id_sug_risklvl
	 */
	public void setId_sug_risklvl(String Id_sug_risklvl) {
		setAttrVal("Id_sug_risklvl", Id_sug_risklvl);
	}
	/**
	 * 手术风险等级code
	 * @return String
	 */
	public String getSd_sug_risklvl() {
		return ((String) getAttrVal("Sd_sug_risklvl"));
	}	
	/**
	 * 手术风险等级code
	 * @param Sd_sug_risklvl
	 */
	public void setSd_sug_risklvl(String Sd_sug_risklvl) {
		setAttrVal("Sd_sug_risklvl", Sd_sug_risklvl);
	}
	/**
	 * 手术风险等级name
	 * @return String
	 */
	public String getName_sug_risklvl() {
		return ((String) getAttrVal("Name_sug_risklvl"));
	}	
	/**
	 * 手术风险等级name
	 * @param Name_sug_risklvl
	 */
	public void setName_sug_risklvl(String Name_sug_risklvl) {
		setAttrVal("Name_sug_risklvl", Name_sug_risklvl);
	}
	/**
	 * 是否术前预防用抗菌药物id
	 * @return String
	 */
	public String getId_ant_beforesug() {
		return ((String) getAttrVal("Id_ant_beforesug"));
	}	
	/**
	 * 是否术前预防用抗菌药物id
	 * @param Id_ant_beforesug
	 */
	public void setId_ant_beforesug(String Id_ant_beforesug) {
		setAttrVal("Id_ant_beforesug", Id_ant_beforesug);
	}
	/**
	 * 是否术前预防用抗菌药物code
	 * @return String
	 */
	public String getSd_ant_beforesug() {
		return ((String) getAttrVal("Sd_ant_beforesug"));
	}	
	/**
	 * 是否术前预防用抗菌药物code
	 * @param Sd_ant_beforesug
	 */
	public void setSd_ant_beforesug(String Sd_ant_beforesug) {
		setAttrVal("Sd_ant_beforesug", Sd_ant_beforesug);
	}
	/**
	 * 是否术前预防用抗菌药物name
	 * @return String
	 */
	public String getName_ant_beforesug() {
		return ((String) getAttrVal("Name_ant_beforesug"));
	}	
	/**
	 * 是否术前预防用抗菌药物name
	 * @param Name_ant_beforesug
	 */
	public void setName_ant_beforesug(String Name_ant_beforesug) {
		setAttrVal("Name_ant_beforesug", Name_ant_beforesug);
	}
	/**
	 * 清洁手术围术期预防用抗菌药物天数
	 * @return Integer
	 */
	public Integer getAnt_usingdays() {
		return ((Integer) getAttrVal("Ant_usingdays"));
	}	
	/**
	 * 清洁手术围术期预防用抗菌药物天数
	 * @param Ant_usingdays
	 */
	public void setAnt_usingdays(Integer Ant_usingdays) {
		setAttrVal("Ant_usingdays", Ant_usingdays);
	}
	/**
	 * 是否非预期的二次手术id
	 * @return String
	 */
	public String getId_has_resug() {
		return ((String) getAttrVal("Id_has_resug"));
	}	
	/**
	 * 是否非预期的二次手术id
	 * @param Id_has_resug
	 */
	public void setId_has_resug(String Id_has_resug) {
		setAttrVal("Id_has_resug", Id_has_resug);
	}
	/**
	 * 是否非预期的二次手术code
	 * @return String
	 */
	public String getSd_has_resug() {
		return ((String) getAttrVal("Sd_has_resug"));
	}	
	/**
	 * 是否非预期的二次手术code
	 * @param Sd_has_resug
	 */
	public void setSd_has_resug(String Sd_has_resug) {
		setAttrVal("Sd_has_resug", Sd_has_resug);
	}
	/**
	 * 是否非预期的二次手术name
	 * @return String
	 */
	public String getName_has_resug() {
		return ((String) getAttrVal("Name_has_resug"));
	}	
	/**
	 * 是否非预期的二次手术name
	 * @param Name_has_resug
	 */
	public void setName_has_resug(String Name_has_resug) {
		setAttrVal("Name_has_resug", Name_has_resug);
	}
	/**
	 * 是否有麻醉并发症id
	 * @return String
	 */
	public String getId_has_anescomp() {
		return ((String) getAttrVal("Id_has_anescomp"));
	}	
	/**
	 * 是否有麻醉并发症id
	 * @param Id_has_anescomp
	 */
	public void setId_has_anescomp(String Id_has_anescomp) {
		setAttrVal("Id_has_anescomp", Id_has_anescomp);
	}
	/**
	 * 是否有麻醉并发症code
	 * @return String
	 */
	public String getSd_has_anescomp() {
		return ((String) getAttrVal("Sd_has_anescomp"));
	}	
	/**
	 * 是否有麻醉并发症code
	 * @param Sd_has_anescomp
	 */
	public void setSd_has_anescomp(String Sd_has_anescomp) {
		setAttrVal("Sd_has_anescomp", Sd_has_anescomp);
	}
	/**
	 * 是否有麻醉并发症name
	 * @return String
	 */
	public String getName_has_anescomp() {
		return ((String) getAttrVal("Name_has_anescomp"));
	}	
	/**
	 * 是否有麻醉并发症name
	 * @param Name_has_anescomp
	 */
	public void setName_has_anescomp(String Name_has_anescomp) {
		setAttrVal("Name_has_anescomp", Name_has_anescomp);
	}
	/**
	 * 是否有术中异物遗留id
	 * @return String
	 */
	public String getId_has_sugleave() {
		return ((String) getAttrVal("Id_has_sugleave"));
	}	
	/**
	 * 是否有术中异物遗留id
	 * @param Id_has_sugleave
	 */
	public void setId_has_sugleave(String Id_has_sugleave) {
		setAttrVal("Id_has_sugleave", Id_has_sugleave);
	}
	/**
	 * 是否有术中异物遗留code
	 * @return String
	 */
	public String getSd_has_sugleave() {
		return ((String) getAttrVal("Sd_has_sugleave"));
	}	
	/**
	 * 是否有术中异物遗留code
	 * @param Sd_has_sugleave
	 */
	public void setSd_has_sugleave(String Sd_has_sugleave) {
		setAttrVal("Sd_has_sugleave", Sd_has_sugleave);
	}
	/**
	 * 是否有术中异物遗留name
	 * @return String
	 */
	public String getName_has_sugleave() {
		return ((String) getAttrVal("Name_has_sugleave"));
	}	
	/**
	 * 是否有术中异物遗留name
	 * @param Name_has_sugleave
	 */
	public void setName_has_sugleave(String Name_has_sugleave) {
		setAttrVal("Name_has_sugleave", Name_has_sugleave);
	}
	/**
	 * 是否有手术并发症id
	 * @return String
	 */
	public String getId_has_sugcomp() {
		return ((String) getAttrVal("Id_has_sugcomp"));
	}	
	/**
	 * 是否有手术并发症id
	 * @param Id_has_sugcomp
	 */
	public void setId_has_sugcomp(String Id_has_sugcomp) {
		setAttrVal("Id_has_sugcomp", Id_has_sugcomp);
	}
	/**
	 * 是否有手术并发症code
	 * @return String
	 */
	public String getSd_has_sugcomp() {
		return ((String) getAttrVal("Sd_has_sugcomp"));
	}	
	/**
	 * 是否有手术并发症code
	 * @param Sd_has_sugcomp
	 */
	public void setSd_has_sugcomp(String Sd_has_sugcomp) {
		setAttrVal("Sd_has_sugcomp", Sd_has_sugcomp);
	}
	/**
	 * 是否有手术并发症name
	 * @return String
	 */
	public String getName_has_sugcomp() {
		return ((String) getAttrVal("Name_has_sugcomp"));
	}	
	/**
	 * 是否有手术并发症name
	 * @param Name_has_sugcomp
	 */
	public void setName_has_sugcomp(String Name_has_sugcomp) {
		setAttrVal("Name_has_sugcomp", Name_has_sugcomp);
	}
	/**
	 * 是否术后出血或血肿id
	 * @return String
	 */
	public String getId_hashem_aftersug() {
		return ((String) getAttrVal("Id_hashem_aftersug"));
	}	
	/**
	 * 是否术后出血或血肿id
	 * @param Id_hashem_aftersug
	 */
	public void setId_hashem_aftersug(String Id_hashem_aftersug) {
		setAttrVal("Id_hashem_aftersug", Id_hashem_aftersug);
	}
	/**
	 * 是否术后出血或血肿code
	 * @return String
	 */
	public String getSd_hashem_aftersug() {
		return ((String) getAttrVal("Sd_hashem_aftersug"));
	}	
	/**
	 * 是否术后出血或血肿code
	 * @param Sd_hashem_aftersug
	 */
	public void setSd_hashem_aftersug(String Sd_hashem_aftersug) {
		setAttrVal("Sd_hashem_aftersug", Sd_hashem_aftersug);
	}
	/**
	 * 是否术后出血或血肿name
	 * @return String
	 */
	public String getName_hashem_aftersug() {
		return ((String) getAttrVal("Name_hashem_aftersug"));
	}	
	/**
	 * 是否术后出血或血肿name
	 * @param Name_hashem_aftersug
	 */
	public void setName_hashem_aftersug(String Name_hashem_aftersug) {
		setAttrVal("Name_hashem_aftersug", Name_hashem_aftersug);
	}
	/**
	 * 是否手术伤口裂开id
	 * @return String
	 */
	public String getId_haswd_aftersug() {
		return ((String) getAttrVal("Id_haswd_aftersug"));
	}	
	/**
	 * 是否手术伤口裂开id
	 * @param Id_haswd_aftersug
	 */
	public void setId_haswd_aftersug(String Id_haswd_aftersug) {
		setAttrVal("Id_haswd_aftersug", Id_haswd_aftersug);
	}
	/**
	 * 是否手术伤口裂开code
	 * @return String
	 */
	public String getSd_haswd_aftersug() {
		return ((String) getAttrVal("Sd_haswd_aftersug"));
	}	
	/**
	 * 是否手术伤口裂开code
	 * @param Sd_haswd_aftersug
	 */
	public void setSd_haswd_aftersug(String Sd_haswd_aftersug) {
		setAttrVal("Sd_haswd_aftersug", Sd_haswd_aftersug);
	}
	/**
	 * 是否手术伤口裂开name
	 * @return String
	 */
	public String getName_haswd_aftersug() {
		return ((String) getAttrVal("Name_haswd_aftersug"));
	}	
	/**
	 * 是否手术伤口裂开name
	 * @param Name_haswd_aftersug
	 */
	public void setName_haswd_aftersug(String Name_haswd_aftersug) {
		setAttrVal("Name_haswd_aftersug", Name_haswd_aftersug);
	}
	/**
	 * 是否术后深静脉血栓id
	 * @return String
	 */
	public String getId_hasdvt_aftersug() {
		return ((String) getAttrVal("Id_hasdvt_aftersug"));
	}	
	/**
	 * 是否术后深静脉血栓id
	 * @param Id_hasdvt_aftersug
	 */
	public void setId_hasdvt_aftersug(String Id_hasdvt_aftersug) {
		setAttrVal("Id_hasdvt_aftersug", Id_hasdvt_aftersug);
	}
	/**
	 * 是否术后深静脉血栓code
	 * @return String
	 */
	public String getSd_hasdvt_aftersug() {
		return ((String) getAttrVal("Sd_hasdvt_aftersug"));
	}	
	/**
	 * 是否术后深静脉血栓code
	 * @param Sd_hasdvt_aftersug
	 */
	public void setSd_hasdvt_aftersug(String Sd_hasdvt_aftersug) {
		setAttrVal("Sd_hasdvt_aftersug", Sd_hasdvt_aftersug);
	}
	/**
	 * 是否术后深静脉血栓name
	 * @return String
	 */
	public String getName_hasdvt_aftersug() {
		return ((String) getAttrVal("Name_hasdvt_aftersug"));
	}	
	/**
	 * 是否术后深静脉血栓name
	 * @param Name_hasdvt_aftersug
	 */
	public void setName_hasdvt_aftersug(String Name_hasdvt_aftersug) {
		setAttrVal("Name_hasdvt_aftersug", Name_hasdvt_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱id
	 * @return String
	 */
	public String getId_hasmd_aftersug() {
		return ((String) getAttrVal("Id_hasmd_aftersug"));
	}	
	/**
	 * 是否术后生理/代谢紊乱id
	 * @param Id_hasmd_aftersug
	 */
	public void setId_hasmd_aftersug(String Id_hasmd_aftersug) {
		setAttrVal("Id_hasmd_aftersug", Id_hasmd_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱code
	 * @return String
	 */
	public String getSd_hasmd_aftersug() {
		return ((String) getAttrVal("Sd_hasmd_aftersug"));
	}	
	/**
	 * 是否术后生理/代谢紊乱code
	 * @param Sd_hasmd_aftersug
	 */
	public void setSd_hasmd_aftersug(String Sd_hasmd_aftersug) {
		setAttrVal("Sd_hasmd_aftersug", Sd_hasmd_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱name
	 * @return String
	 */
	public String getName_hasmd_aftersug() {
		return ((String) getAttrVal("Name_hasmd_aftersug"));
	}	
	/**
	 * 是否术后生理/代谢紊乱name
	 * @param Name_hasmd_aftersug
	 */
	public void setName_hasmd_aftersug(String Name_hasmd_aftersug) {
		setAttrVal("Name_hasmd_aftersug", Name_hasmd_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭id
	 * @return String
	 */
	public String getId_hasfor_aftersug() {
		return ((String) getAttrVal("Id_hasfor_aftersug"));
	}	
	/**
	 * 是否术后呼吸衰竭id
	 * @param Id_hasfor_aftersug
	 */
	public void setId_hasfor_aftersug(String Id_hasfor_aftersug) {
		setAttrVal("Id_hasfor_aftersug", Id_hasfor_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭code
	 * @return String
	 */
	public String getSd_hasfor_aftersug() {
		return ((String) getAttrVal("Sd_hasfor_aftersug"));
	}	
	/**
	 * 是否术后呼吸衰竭code
	 * @param Sd_hasfor_aftersug
	 */
	public void setSd_hasfor_aftersug(String Sd_hasfor_aftersug) {
		setAttrVal("Sd_hasfor_aftersug", Sd_hasfor_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭name
	 * @return String
	 */
	public String getName_hasfor_aftersug() {
		return ((String) getAttrVal("Name_hasfor_aftersug"));
	}	
	/**
	 * 是否术后呼吸衰竭name
	 * @param Name_hasfor_aftersug
	 */
	public void setName_hasfor_aftersug(String Name_hasfor_aftersug) {
		setAttrVal("Name_hasfor_aftersug", Name_hasfor_aftersug);
	}
	/**
	 * 是否术后肺栓塞id
	 * @return String
	 */
	public String getId_haspe_aftersug() {
		return ((String) getAttrVal("Id_haspe_aftersug"));
	}	
	/**
	 * 是否术后肺栓塞id
	 * @param Id_haspe_aftersug
	 */
	public void setId_haspe_aftersug(String Id_haspe_aftersug) {
		setAttrVal("Id_haspe_aftersug", Id_haspe_aftersug);
	}
	/**
	 * 是否术后肺栓塞code
	 * @return String
	 */
	public String getSd_haspe_aftersug() {
		return ((String) getAttrVal("Sd_haspe_aftersug"));
	}	
	/**
	 * 是否术后肺栓塞code
	 * @param Sd_haspe_aftersug
	 */
	public void setSd_haspe_aftersug(String Sd_haspe_aftersug) {
		setAttrVal("Sd_haspe_aftersug", Sd_haspe_aftersug);
	}
	/**
	 * 是否术后肺栓塞name
	 * @return String
	 */
	public String getName_haspe_aftersug() {
		return ((String) getAttrVal("Name_haspe_aftersug"));
	}	
	/**
	 * 是否术后肺栓塞name
	 * @param Name_haspe_aftersug
	 */
	public void setName_haspe_aftersug(String Name_haspe_aftersug) {
		setAttrVal("Name_haspe_aftersug", Name_haspe_aftersug);
	}
	/**
	 * 是否术后败血症id
	 * @return String
	 */
	public String getId_hashema_aftersug() {
		return ((String) getAttrVal("Id_hashema_aftersug"));
	}	
	/**
	 * 是否术后败血症id
	 * @param Id_hashema_aftersug
	 */
	public void setId_hashema_aftersug(String Id_hashema_aftersug) {
		setAttrVal("Id_hashema_aftersug", Id_hashema_aftersug);
	}
	/**
	 * 是否术后败血症code
	 * @return String
	 */
	public String getSd_hashema_aftersug() {
		return ((String) getAttrVal("Sd_hashema_aftersug"));
	}	
	/**
	 * 是否术后败血症code
	 * @param Sd_hashema_aftersug
	 */
	public void setSd_hashema_aftersug(String Sd_hashema_aftersug) {
		setAttrVal("Sd_hashema_aftersug", Sd_hashema_aftersug);
	}
	/**
	 * 是否术后败血症name
	 * @return String
	 */
	public String getName_hashema_aftersug() {
		return ((String) getAttrVal("Name_hashema_aftersug"));
	}	
	/**
	 * 是否术后败血症name
	 * @param Name_hashema_aftersug
	 */
	public void setName_hashema_aftersug(String Name_hashema_aftersug) {
		setAttrVal("Name_hashema_aftersug", Name_hashema_aftersug);
	}
	/**
	 * 是否术后髋关节骨折id
	 * @return String
	 */
	public String getId_hashf_aftersug() {
		return ((String) getAttrVal("Id_hashf_aftersug"));
	}	
	/**
	 * 是否术后髋关节骨折id
	 * @param Id_hashf_aftersug
	 */
	public void setId_hashf_aftersug(String Id_hashf_aftersug) {
		setAttrVal("Id_hashf_aftersug", Id_hashf_aftersug);
	}
	/**
	 * 是否术后髋关节骨折code
	 * @return String
	 */
	public String getSd_hashf_aftersug() {
		return ((String) getAttrVal("Sd_hashf_aftersug"));
	}	
	/**
	 * 是否术后髋关节骨折code
	 * @param Sd_hashf_aftersug
	 */
	public void setSd_hashf_aftersug(String Sd_hashf_aftersug) {
		setAttrVal("Sd_hashf_aftersug", Sd_hashf_aftersug);
	}
	/**
	 * 是否术后髋关节骨折name
	 * @return String
	 */
	public String getName_hashf_aftersug() {
		return ((String) getAttrVal("Name_hashf_aftersug"));
	}	
	/**
	 * 是否术后髋关节骨折name
	 * @param Name_hashf_aftersug
	 */
	public void setName_hashf_aftersug(String Name_hashf_aftersug) {
		setAttrVal("Name_hashf_aftersug", Name_hashf_aftersug);
	}
	/**
	 * 其他诊断对照
	 * @return String
	 */
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}	
	/**
	 * 其他诊断对照
	 * @param Id_hpdi
	 */
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
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
	 * 麻醉分级id
	 * @return String
	 */
	public String getId_exec_anes_clf() {
		return ((String) getAttrVal("Id_exec_anes_clf"));
	}	
	/**
	 * 麻醉分级id
	 * @param Id_exec_anes_clf
	 */
	public void setId_exec_anes_clf(String Id_exec_anes_clf) {
		setAttrVal("Id_exec_anes_clf", Id_exec_anes_clf);
	}
	/**
	 * 麻醉分级code
	 * @return String
	 */
	public String getSd_exec_anes_clf() {
		return ((String) getAttrVal("Sd_exec_anes_clf"));
	}	
	/**
	 * 麻醉分级code
	 * @param Sd_exec_anes_clf
	 */
	public void setSd_exec_anes_clf(String Sd_exec_anes_clf) {
		setAttrVal("Sd_exec_anes_clf", Sd_exec_anes_clf);
	}
	/**
	 * 麻醉分级name
	 * @return String
	 */
	public String getName_exec_anes_clf() {
		return ((String) getAttrVal("Name_exec_anes_clf"));
	}	
	/**
	 * 麻醉分级name
	 * @param Name_exec_anes_clf
	 */
	public void setName_exec_anes_clf(String Name_exec_anes_clf) {
		setAttrVal("Name_exec_anes_clf", Name_exec_anes_clf);
	}
	/**
	 * 主要手术持续时间
	 * @return FDouble
	 */
	public FDouble getMain_sug_times() {
		return ((FDouble) getAttrVal("Main_sug_times"));
	}	
	/**
	 * 主要手术持续时间
	 * @param Main_sug_times
	 */
	public void setMain_sug_times(FDouble Main_sug_times) {
		setAttrVal("Main_sug_times", Main_sug_times);
	}
	/**
	 * 其他手术持续时间
	 * @return FDouble
	 */
	public FDouble getOther_sug_times() {
		return ((FDouble) getAttrVal("Other_sug_times"));
	}	
	/**
	 * 其他手术持续时间
	 * @param Other_sug_times
	 */
	public void setOther_sug_times(FDouble Other_sug_times) {
		setAttrVal("Other_sug_times", Other_sug_times);
	}
	/**
	 * 主要手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_main_sug() {
		return ((FBoolean) getAttrVal("Fg_main_sug"));
	}	
	/**
	 * 主要手术标识
	 * @param Fg_main_sug
	 */
	public void setFg_main_sug(FBoolean Fg_main_sug) {
		setAttrVal("Fg_main_sug", Fg_main_sug);
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
	 * 诊断编码
	 * @return String
	 */
	public String getSug_code() {
		return ((String) getAttrVal("Sug_code"));
	}	
	/**
	 * 诊断编码
	 * @param Sug_code
	 */
	public void setSug_code(String Sug_code) {
		setAttrVal("Sug_code", Sug_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getSug_name() {
		return ((String) getAttrVal("Sug_name"));
	}	
	/**
	 * 诊断名称
	 * @param Sug_name
	 */
	public void setSug_name(String Sug_name) {
		setAttrVal("Sug_name", Sug_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getLvlsug_code() {
		return ((String) getAttrVal("Lvlsug_code"));
	}	
	/**
	 * 编码
	 * @param Lvlsug_code
	 */
	public void setLvlsug_code(String Lvlsug_code) {
		setAttrVal("Lvlsug_code", Lvlsug_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getLvlsug_name() {
		return ((String) getAttrVal("Lvlsug_name"));
	}	
	/**
	 * 名称
	 * @param Lvlsug_name
	 */
	public void setLvlsug_name(String Lvlsug_name) {
		setAttrVal("Lvlsug_name", Lvlsug_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_sug_name() {
		return ((String) getAttrVal("Emp_sug_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_sug_name
	 */
	public void setEmp_sug_name(String Emp_sug_name) {
		setAttrVal("Emp_sug_name", Emp_sug_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_sug_code() {
		return ((String) getAttrVal("Emp_sug_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_sug_code
	 */
	public void setEmp_sug_code(String Emp_sug_code) {
		setAttrVal("Emp_sug_code", Emp_sug_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_asst1_name() {
		return ((String) getAttrVal("Emp_asst1_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_asst1_name
	 */
	public void setEmp_asst1_name(String Emp_asst1_name) {
		setAttrVal("Emp_asst1_name", Emp_asst1_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_asst1_code() {
		return ((String) getAttrVal("Emp_asst1_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_asst1_code
	 */
	public void setEmp_asst1_code(String Emp_asst1_code) {
		setAttrVal("Emp_asst1_code", Emp_asst1_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_asst2_name() {
		return ((String) getAttrVal("Emp_asst2_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_asst2_name
	 */
	public void setEmp_asst2_name(String Emp_asst2_name) {
		setAttrVal("Emp_asst2_name", Emp_asst2_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_asst2_code() {
		return ((String) getAttrVal("Emp_asst2_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_asst2_code
	 */
	public void setEmp_asst2_code(String Emp_asst2_code) {
		setAttrVal("Emp_asst2_code", Emp_asst2_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_anes_name() {
		return ((String) getAttrVal("Emp_anes_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_anes_name
	 */
	public void setEmp_anes_name(String Emp_anes_name) {
		setAttrVal("Emp_anes_name", Emp_anes_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getEmp_anes_code() {
		return ((String) getAttrVal("Emp_anes_code"));
	}	
	/**
	 * 用户编码
	 * @param Emp_anes_code
	 */
	public void setEmp_anes_code(String Emp_anes_code) {
		setAttrVal("Emp_anes_code", Emp_anes_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIncitp_code() {
		return ((String) getAttrVal("Incitp_code"));
	}	
	/**
	 * 编码
	 * @param Incitp_code
	 */
	public void setIncitp_code(String Incitp_code) {
		setAttrVal("Incitp_code", Incitp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIncitp_name() {
		return ((String) getAttrVal("Incitp_name"));
	}	
	/**
	 * 名称
	 * @param Incitp_name
	 */
	public void setIncitp_name(String Incitp_name) {
		setAttrVal("Incitp_name", Incitp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnestp_code() {
		return ((String) getAttrVal("Anestp_code"));
	}	
	/**
	 * 编码
	 * @param Anestp_code
	 */
	public void setAnestp_code(String Anestp_code) {
		setAttrVal("Anestp_code", Anestp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnestp_name() {
		return ((String) getAttrVal("Anestp_name"));
	}	
	/**
	 * 名称
	 * @param Anestp_name
	 */
	public void setAnestp_name(String Anestp_name) {
		setAttrVal("Anestp_name", Anestp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIncicondi_code() {
		return ((String) getAttrVal("Incicondi_code"));
	}	
	/**
	 * 编码
	 * @param Incicondi_code
	 */
	public void setIncicondi_code(String Incicondi_code) {
		setAttrVal("Incicondi_code", Incicondi_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIncicondi_name() {
		return ((String) getAttrVal("Incicondi_name"));
	}	
	/**
	 * 名称
	 * @param Incicondi_name
	 */
	public void setIncicondi_name(String Incicondi_name) {
		setAttrVal("Incicondi_name", Incicondi_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMethod_code() {
		return ((String) getAttrVal("Method_code"));
	}	
	/**
	 * 编码
	 * @param Method_code
	 */
	public void setMethod_code(String Method_code) {
		setAttrVal("Method_code", Method_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMethod_name() {
		return ((String) getAttrVal("Method_name"));
	}	
	/**
	 * 名称
	 * @param Method_name
	 */
	public void setMethod_name(String Method_name) {
		setAttrVal("Method_name", Method_name);
	}
	/**
	 * 手术类别编码
	 * @return String
	 */
	public String getCode_class_sug() {
		return ((String) getAttrVal("Code_class_sug"));
	}	
	/**
	 * 手术类别编码
	 * @param Code_class_sug
	 */
	public void setCode_class_sug(String Code_class_sug) {
		setAttrVal("Code_class_sug", Code_class_sug);
	}
	/**
	 * 手术类别名称
	 * @return String
	 */
	public String getClass_sug_name() {
		return ((String) getAttrVal("Class_sug_name"));
	}	
	/**
	 * 手术类别名称
	 * @param Class_sug_name
	 */
	public void setClass_sug_name(String Class_sug_name) {
		setAttrVal("Class_sug_name", Class_sug_name);
	}
	/**
	 * 手术、操作编码
	 * @return String
	 */
	public String getAttach_sd_sug() {
		return ((String) getAttrVal("Attach_sd_sug"));
	}	
	/**
	 * 手术、操作编码
	 * @param Attach_sd_sug
	 */
	public void setAttach_sd_sug(String Attach_sd_sug) {
		setAttrVal("Attach_sd_sug", Attach_sd_sug);
	}
	/**
	 * 手术、操作名称
	 * @return String
	 */
	public String getAttach_name_sug() {
		return ((String) getAttrVal("Attach_name_sug"));
	}	
	/**
	 * 手术、操作名称
	 * @param Attach_name_sug
	 */
	public void setAttach_name_sug(String Attach_name_sug) {
		setAttrVal("Attach_name_sug", Attach_name_sug);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnt_bs_code() {
		return ((String) getAttrVal("Ant_bs_code"));
	}	
	/**
	 * 编码
	 * @param Ant_bs_code
	 */
	public void setAnt_bs_code(String Ant_bs_code) {
		setAttrVal("Ant_bs_code", Ant_bs_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnt_bs_name() {
		return ((String) getAttrVal("Ant_bs_name"));
	}	
	/**
	 * 名称
	 * @param Ant_bs_name
	 */
	public void setAnt_bs_name(String Ant_bs_name) {
		setAttrVal("Ant_bs_name", Ant_bs_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_resug_code() {
		return ((String) getAttrVal("Has_resug_code"));
	}	
	/**
	 * 编码
	 * @param Has_resug_code
	 */
	public void setHas_resug_code(String Has_resug_code) {
		setAttrVal("Has_resug_code", Has_resug_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_resug_name() {
		return ((String) getAttrVal("Has_resug_name"));
	}	
	/**
	 * 名称
	 * @param Has_resug_name
	 */
	public void setHas_resug_name(String Has_resug_name) {
		setAttrVal("Has_resug_name", Has_resug_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_anescomp_name() {
		return ((String) getAttrVal("Has_anescomp_name"));
	}	
	/**
	 * 名称
	 * @param Has_anescomp_name
	 */
	public void setHas_anescomp_name(String Has_anescomp_name) {
		setAttrVal("Has_anescomp_name", Has_anescomp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_anescomp_code() {
		return ((String) getAttrVal("Has_anescomp_code"));
	}	
	/**
	 * 编码
	 * @param Has_anescomp_code
	 */
	public void setHas_anescomp_code(String Has_anescomp_code) {
		setAttrVal("Has_anescomp_code", Has_anescomp_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_sugleave_code() {
		return ((String) getAttrVal("Has_sugleave_code"));
	}	
	/**
	 * 编码
	 * @param Has_sugleave_code
	 */
	public void setHas_sugleave_code(String Has_sugleave_code) {
		setAttrVal("Has_sugleave_code", Has_sugleave_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_sugleave_name() {
		return ((String) getAttrVal("Has_sugleave_name"));
	}	
	/**
	 * 名称
	 * @param Has_sugleave_name
	 */
	public void setHas_sugleave_name(String Has_sugleave_name) {
		setAttrVal("Has_sugleave_name", Has_sugleave_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHas_sugcomp_code() {
		return ((String) getAttrVal("Has_sugcomp_code"));
	}	
	/**
	 * 编码
	 * @param Has_sugcomp_code
	 */
	public void setHas_sugcomp_code(String Has_sugcomp_code) {
		setAttrVal("Has_sugcomp_code", Has_sugcomp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHas_sugcomp_name() {
		return ((String) getAttrVal("Has_sugcomp_name"));
	}	
	/**
	 * 名称
	 * @param Has_sugcomp_name
	 */
	public void setHas_sugcomp_name(String Has_sugcomp_name) {
		setAttrVal("Has_sugcomp_name", Has_sugcomp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHashem_code() {
		return ((String) getAttrVal("Hashem_code"));
	}	
	/**
	 * 编码
	 * @param Hashem_code
	 */
	public void setHashem_code(String Hashem_code) {
		setAttrVal("Hashem_code", Hashem_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHashem_name() {
		return ((String) getAttrVal("Hashem_name"));
	}	
	/**
	 * 名称
	 * @param Hashem_name
	 */
	public void setHashem_name(String Hashem_name) {
		setAttrVal("Hashem_name", Hashem_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHaswd_name() {
		return ((String) getAttrVal("Haswd_name"));
	}	
	/**
	 * 名称
	 * @param Haswd_name
	 */
	public void setHaswd_name(String Haswd_name) {
		setAttrVal("Haswd_name", Haswd_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHaswd_code() {
		return ((String) getAttrVal("Haswd_code"));
	}	
	/**
	 * 编码
	 * @param Haswd_code
	 */
	public void setHaswd_code(String Haswd_code) {
		setAttrVal("Haswd_code", Haswd_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHasdvt_name() {
		return ((String) getAttrVal("Hasdvt_name"));
	}	
	/**
	 * 名称
	 * @param Hasdvt_name
	 */
	public void setHasdvt_name(String Hasdvt_name) {
		setAttrVal("Hasdvt_name", Hasdvt_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHasdvt_code() {
		return ((String) getAttrVal("Hasdvt_code"));
	}	
	/**
	 * 编码
	 * @param Hasdvt_code
	 */
	public void setHasdvt_code(String Hasdvt_code) {
		setAttrVal("Hasdvt_code", Hasdvt_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHasmd_code() {
		return ((String) getAttrVal("Hasmd_code"));
	}	
	/**
	 * 编码
	 * @param Hasmd_code
	 */
	public void setHasmd_code(String Hasmd_code) {
		setAttrVal("Hasmd_code", Hasmd_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHasmd_name() {
		return ((String) getAttrVal("Hasmd_name"));
	}	
	/**
	 * 名称
	 * @param Hasmd_name
	 */
	public void setHasmd_name(String Hasmd_name) {
		setAttrVal("Hasmd_name", Hasmd_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHasfor_name() {
		return ((String) getAttrVal("Hasfor_name"));
	}	
	/**
	 * 名称
	 * @param Hasfor_name
	 */
	public void setHasfor_name(String Hasfor_name) {
		setAttrVal("Hasfor_name", Hasfor_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHasfor_code() {
		return ((String) getAttrVal("Hasfor_code"));
	}	
	/**
	 * 编码
	 * @param Hasfor_code
	 */
	public void setHasfor_code(String Hasfor_code) {
		setAttrVal("Hasfor_code", Hasfor_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHaspe_code() {
		return ((String) getAttrVal("Haspe_code"));
	}	
	/**
	 * 编码
	 * @param Haspe_code
	 */
	public void setHaspe_code(String Haspe_code) {
		setAttrVal("Haspe_code", Haspe_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHaspe_name() {
		return ((String) getAttrVal("Haspe_name"));
	}	
	/**
	 * 名称
	 * @param Haspe_name
	 */
	public void setHaspe_name(String Haspe_name) {
		setAttrVal("Haspe_name", Haspe_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHashema_name() {
		return ((String) getAttrVal("Hashema_name"));
	}	
	/**
	 * 名称
	 * @param Hashema_name
	 */
	public void setHashema_name(String Hashema_name) {
		setAttrVal("Hashema_name", Hashema_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHashema_code() {
		return ((String) getAttrVal("Hashema_code"));
	}	
	/**
	 * 编码
	 * @param Hashema_code
	 */
	public void setHashema_code(String Hashema_code) {
		setAttrVal("Hashema_code", Hashema_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHashf_code() {
		return ((String) getAttrVal("Hashf_code"));
	}	
	/**
	 * 编码
	 * @param Hashf_code
	 */
	public void setHashf_code(String Hashf_code) {
		setAttrVal("Hashf_code", Hashf_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHashf_name() {
		return ((String) getAttrVal("Hashf_name"));
	}	
	/**
	 * 名称
	 * @param Hashf_name
	 */
	public void setHashf_name(String Hashf_name) {
		setAttrVal("Hashf_name", Hashf_name);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getCode_hpdi() {
		return ((String) getAttrVal("Code_hpdi"));
	}	
	/**
	 * 疾病编码
	 * @param Code_hpdi
	 */
	public void setCode_hpdi(String Code_hpdi) {
		setAttrVal("Code_hpdi", Code_hpdi);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName_hpdi() {
		return ((String) getAttrVal("Name_hpdi"));
	}	
	/**
	 * 疾病名称
	 * @param Name_hpdi
	 */
	public void setName_hpdi(String Name_hpdi) {
		setAttrVal("Name_hpdi", Name_hpdi);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getExec_anes_clf_code() {
		return ((String) getAttrVal("Exec_anes_clf_code"));
	}	
	/**
	 * 编码
	 * @param Exec_anes_clf_code
	 */
	public void setExec_anes_clf_code(String Exec_anes_clf_code) {
		setAttrVal("Exec_anes_clf_code", Exec_anes_clf_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getExec_anes_clf_name() {
		return ((String) getAttrVal("Exec_anes_clf_name"));
	}	
	/**
	 * 名称
	 * @param Exec_anes_clf_name
	 */
	public void setExec_anes_clf_name(String Exec_anes_clf_name) {
		setAttrVal("Exec_anes_clf_name", Exec_anes_clf_name);
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
		return "Id_mrfpsug";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_SUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpSugDODesc.class);
	}
	
}