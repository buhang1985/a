package iih.nmr.pkuf.surgpathandover.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.surgpathandover.d.desc.SurgPatHandoverDODesc;
import java.math.BigDecimal;

/**
 * 手术患者交接记录单 DO数据 
 * 
 */
public class SurgPatHandoverDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//记录单主键
	public static final String ID_SURGPAT= "Id_surgpat";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//床号
	public static final String NAME_BED= "Name_bed";
	//录入人员
	public static final String ID_SIGN= "Id_sign";
	//录入日期
	public static final String DT_CREATE= "Dt_create";
	//护士签名
	public static final String ID_NUR= "Id_nur";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//诊断ID(通用)
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	//诊断(通用)
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	//接病人时间
	public static final String DT_RECE= "Dt_rece";
	//拟行手术名称
	public static final String ID_OPERATION= "Id_operation";
	//术前手术部位标识
	public static final String ID_PREO_MARK= "Id_preo_mark";
	//术前手术部位标识编码
	public static final String SD_PREO_MARK= "Sd_preo_mark";
	//术前手术部位
	public static final String ID_PREO_SITE= "Id_preo_site";
	//术前手术部位编码
	public static final String SD_PREO_SITE= "Sd_preo_site";
	//术前意识
	public static final String ID_PREO_CONSCIOUS= "Id_preo_conscious";
	//术前意识编码
	public static final String SD_PREO_CONSCIOUS= "Sd_preo_conscious";
	//术前T
	public static final String PREO_T= "Preo_t";
	//术前P
	public static final String PREO_P= "Preo_p";
	//术前R
	public static final String PREO_R= "Preo_r";
	//术前SPO2
	public static final String PREO_SPO2= "Preo_spo2";
	//术前收缩压
	public static final String PREO_INT_SBP= "Preo_int_sbp";
	//术前舒张压
	public static final String PREO_INT_DBP= "Preo_int_dbp";
	//术前准备
	public static final String ID_PREPAR= "Id_prepar";
	//术前准备编码
	public static final String SD_PREPAR= "Sd_prepar";
	//术前留置管路
	public static final String ID_PREO_PIPE= "Id_preo_pipe";
	//术前留置管路编码
	public static final String SD_PREO_PIPE= "Sd_preo_pipe";
	//术前留置管路通畅情况
	public static final String ID_PREO_UNOB_PIP= "Id_preo_unob_pip";
	//术前留置管路通畅情况编码
	public static final String SD_PREO_UNOB_PIP= "Sd_preo_unob_pip";
	//术前携带物品
	public static final String ID_PREO_ARTICLES= "Id_preo_articles";
	//术前携带物品编码
	public static final String SD_PREO_ARTICLES= "Sd_preo_articles";
	//术前药品信息
	public static final String PREO_DRUG_INFORM= "Preo_drug_inform";
	//术前过敏试验
	public static final String ID_PREO_ALLER= "Id_preo_aller";
	//术前过敏试验编码
	public static final String SD_PREO_ALLER= "Sd_preo_aller";
	//术前批号
	public static final String PREO_BATCH= "Preo_batch";
	//术前携带物品其它
	public static final String PREO_GOODS_OTH= "Preo_goods_oth";
	//术前过敏史
	public static final String ID_PREO_HIS_ALLER= "Id_preo_his_aller";
	//术前过敏史编码
	public static final String SD_PREO_HIS_ALLER= "Sd_preo_his_aller";
	//术前过敏史情况
	public static final String PREO_SIT_ALLER= "Preo_sit_aller";
	//术前输液
	public static final String ID_PREO_INFUS= "Id_preo_infus";
	//术前输液编码
	public static final String SD_PREO_INFUS= "Sd_preo_infus";
	//术前输液情况
	public static final String PREO_INFUS_SIT= "Preo_infus_sit";
	//术前输液通畅情况
	public static final String ID_PREO_INFUS_UNOB= "Id_preo_infus_unob";
	//术前输液通畅情况编码
	public static final String SD_PREO_INFUS_UNOB= "Sd_preo_infus_unob";
	//术前输液工具
	public static final String ID_PREO_INFUS_TOOL= "Id_preo_infus_tool";
	//术前输液工具编码
	public static final String SD_PREO_INFUS_TOOL= "Sd_preo_infus_tool";
	//术前输液工具其它
	public static final String PREO_TOOL_OTH= "Preo_tool_oth";
	//术前皮肤
	public static final String ID_PREO_SKIN= "Id_preo_skin";
	//术前皮肤编码
	public static final String SD_PREO_SKIN= "Sd_preo_skin";
	//术前分期
	public static final String PREO_STAGES= "Preo_stages";
	//术前部位
	public static final String PREO_POSITION= "Preo_position";
	//术前特殊交接
	public static final String PREO_SPE_HAND= "Preo_spe_hand";
	//术前科室护士
	public static final String ID_PREO_NUR= "Id_preo_nur";
	//患者/家属
	public static final String FAMI_PAT= "Fami_pat";
	//术前手术室护士
	public static final String ID_PREO_OPER_NUR= "Id_preo_oper_nur";
	//入手术室时间
	public static final String DT_ENTER= "Dt_enter";
	//术中意识
	public static final String ID_INTRA_CONSCIOUS= "Id_intra_conscious";
	//术中意识编码
	public static final String SD_INTRA_CONSCIOUS= "Sd_intra_conscious";
	//术中携带物品
	public static final String ID_INTRA_ARTICLES= "Id_intra_articles";
	//术中携带物品编码
	public static final String SD_INTRA_ARTICLES= "Sd_intra_articles";
	//术中携带物品其它
	public static final String INTRA_ARTICLES_OTH= "Intra_articles_oth";
	//术中手术部位标识
	public static final String ID_INTRA_MARK= "Id_intra_mark";
	//术中手术部位标识编码
	public static final String SD_INTRA_MARK= "Sd_intra_mark";
	//术中手术部位
	public static final String ID_INTRA_SITE= "Id_intra_site";
	//术中手术部位编码
	public static final String SD_INTRA_SITE= "Sd_intra_site";
	//术中手术部位其它
	public static final String INTRA_SITE_OTH= "Intra_site_oth";
	//术中留置管路
	public static final String ID_INTRA_PIPE= "Id_intra_pipe";
	//术中留置管路编码
	public static final String SD_INTRA_PIPE= "Sd_intra_pipe";
	//术中留置管路通畅情况
	public static final String ID_INTRA_UNOB_PIP= "Id_intra_unob_pip";
	//术中留置管路通畅情况编码
	public static final String SD_INTRA_UNOB_PIP= "Sd_intra_unob_pip";
	//术中皮肤
	public static final String ID_INTRA_SKIN= "Id_intra_skin";
	//术中皮肤编码
	public static final String SD_INTRA_SKIN= "Sd_intra_skin";
	//术中分期
	public static final String INTRA_STAGES= "Intra_stages";
	//术中部位
	public static final String INTRA_POSITION= "Intra_position";
	//术中T
	public static final String INTRA_T= "Intra_t";
	//术中P
	public static final String INTRA_P= "Intra_p";
	//术中R
	public static final String INTRA_R= "Intra_r";
	//术中SPO2
	public static final String INTRA_SPO2= "Intra_spo2";
	//术中收缩压
	public static final String INTRA_INT_SBPS= "Intra_int_sbps";
	//术中舒张压
	public static final String INTRA_INT_DBPS= "Intra_int_dbps";
	//手术结束时间
	public static final String DT_OPER_END= "Dt_oper_end";
	//术中麻醉医师
	public static final String ID_ANESTHES= "Id_anesthes";
	//手术医生
	public static final String ID_SURGEON= "Id_surgeon";
	//术中手术室护士
	public static final String ID_INTRA_OPER_NUR= "Id_intra_oper_nur";
	//术后送回
	public static final String ID_SEND_BAKE= "Id_send_bake";
	//术后送回编码
	public static final String SD_SEND_BAKE= "Sd_send_bake";
	//术后送回时间
	public static final String DT_SEND= "Dt_send";
	//术后T
	public static final String POS_T= "Pos_t";
	//术后P
	public static final String POS_P= "Pos_p";
	//术后R
	public static final String POS_R= "Pos_r";
	//术后SPO2
	public static final String POS_SPO2= "Pos_spo2";
	//术后收缩压
	public static final String POS_INT_SBPS= "Pos_int_sbps";
	//术后舒张压
	public static final String POS_INT_DBPS= "Pos_int_dbps";
	//病人情况
	public static final String ID_PAT_CONDITION= "Id_pat_condition";
	//病人情况编码
	public static final String SD_PAT_CONDITION= "Sd_pat_condition";
	//术后输液
	public static final String ID_POS_INFUS= "Id_pos_infus";
	//术后输液编码
	public static final String SD_POS_INFUS= "Sd_pos_infus";
	//术后输液情况
	public static final String POS_INFUS_SIT= "Pos_infus_sit";
	//术后输液通畅情况
	public static final String ID_POS_INFUS_UNOB= "Id_pos_infus_unob";
	//术后输液通畅情况编码
	public static final String SD_POS_INFUS_UNOB= "Sd_pos_infus_unob";
	//术前留置管路情况
	public static final String PREO_PIPE_COND= "Preo_pipe_cond";
	//术中留置管路情况
	public static final String INTRA_PIPE_COND= "Intra_pipe_cond";
	//术后输液工具
	public static final String ID_POS_INFUS_TOOL= "Id_pos_infus_tool";
	//术后输液工具编码
	public static final String SD_POS_INFUS_TOOL= "Sd_pos_infus_tool";
	//术后输液工具其它
	public static final String POS_TOOL_OTH= "Pos_tool_oth";
	//带回药品
	public static final String BRING_DRUG= "Bring_drug";
	//术后携带物品
	public static final String ID_POS_ARTICLES= "Id_pos_articles";
	//术后携带物品编码
	public static final String SD_POS_ARTICLES= "Sd_pos_articles";
	//术后携带物品其它
	public static final String POS_ARTICLES_OTH= "Pos_articles_oth";
	//标本份数
	public static final String NUM_SPECIMEN= "Num_specimen";
	//术后引流管
	public static final String ID_POS_TUBE= "Id_pos_tube";
	//术后引流管编码
	public static final String SD_POS_TUBE= "Sd_pos_tube";
	//术后引流管情况
	public static final String POS_TUBE_SIT= "Pos_tube_sit";
	//术后引流管通畅情况
	public static final String ID_POS_TUBE_UNOB= "Id_pos_tube_unob";
	//术后引流管通畅情况编码
	public static final String SD_POS_TUBE_UNOB= "Sd_pos_tube_unob";
	//术后切口敷料
	public static final String ID_INCI_DRES= "Id_inci_dres";
	//术后切口敷料编码
	public static final String SD_INCI_DRES= "Sd_inci_dres";
	//术后皮肤
	public static final String ID_POS_SKIN= "Id_pos_skin";
	//术后皮肤编码
	public static final String SD_POS_SKIN= "Sd_pos_skin";
	//术后分期
	public static final String POS_STAGES= "Pos_stages";
	//术后部位
	public static final String POS_POSITION= "Pos_position";
	//术后特殊交接
	public static final String POS_SPE_HAND= "Pos_spe_hand";
	//术后手术室护士签名
	public static final String ID_OPER_POS_NUR= "Id_oper_pos_nur";
	//术后麻醉医师签名
	public static final String ID_POS_ANESTHES= "Id_pos_anesthes";
	//接收医生签名
	public static final String ID_RECEIV_DOC= "Id_receiv_doc";
	//术后接收护士签名
	public static final String ID_RECEIV_NUR= "Id_receiv_nur";
	//术前分期选项
	public static final String ID_PREO_BY_STAGES= "Id_preo_by_stages";
	//术前分期选项编码
	public static final String SD_PREO_BY_STAGES= "Sd_preo_by_stages";
	//术中分期选项
	public static final String ID_INTER_BY_STAGES= "Id_inter_by_stages";
	//术中分期选项编码
	public static final String SD_INTER_BY_STAGES= "Sd_inter_by_stages";
	//术后分期选项
	public static final String ID_POS_BY_STAGES= "Id_pos_by_stages";
	//术后分期选项编码
	public static final String SD_POS_BY_STAGES= "Sd_pos_by_stages";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_SIGN= "Name_sign";
	//姓名
	public static final String NAME_NUR= "Name_nur";
	//服务名称
	public static final String NAME_OPERATION= "Name_operation";
	//名称
	public static final String NAME_PREO_MARK= "Name_preo_mark";
	//名称
	public static final String NAME_PREO_SITE= "Name_preo_site";
	//名称
	public static final String NAME_PREO_CONSCIOUS= "Name_preo_conscious";
	//名称
	public static final String NAME_PREPAR= "Name_prepar";
	//名称
	public static final String NAME_PREO_PIPE= "Name_preo_pipe";
	//名称
	public static final String NAME_PREO_UNOB_PIP= "Name_preo_unob_pip";
	//名称
	public static final String NAME_PREO_ARTICLES= "Name_preo_articles";
	//名称
	public static final String NAME_PREO_ALLER= "Name_preo_aller";
	//名称
	public static final String NAME_PREO_HIS_ALLER= "Name_preo_his_aller";
	//名称
	public static final String NAME_PREO_INFUS= "Name_preo_infus";
	//名称
	public static final String NAME_PREO_INFUS_UNOB= "Name_preo_infus_unob";
	//名称
	public static final String NAME_PREO_INFUS_TOOL= "Name_preo_infus_tool";
	//名称
	public static final String NAME_PREO_SKIN= "Name_preo_skin";
	//姓名
	public static final String NAME_PREO_NUR= "Name_preo_nur";
	//姓名
	public static final String NAME_PREO_OPER_NUR= "Name_preo_oper_nur";
	//名称
	public static final String NAME_INTRA_CONSCIOUS= "Name_intra_conscious";
	//名称
	public static final String NAME_INTRA_ARTICLES= "Name_intra_articles";
	//名称
	public static final String NAME_INTRA_MARK= "Name_intra_mark";
	//名称
	public static final String NAME_INTRA_SITE= "Name_intra_site";
	//名称
	public static final String NAME_INTRA_PIPE= "Name_intra_pipe";
	//名称
	public static final String NAME_INTRA_UNOB_PIP= "Name_intra_unob_pip";
	//名称
	public static final String NAME_INTRA_SKIN= "Name_intra_skin";
	//姓名
	public static final String NAME_ANESTHES= "Name_anesthes";
	//姓名
	public static final String NAME_SURGEON= "Name_surgeon";
	//姓名
	public static final String NAME_INTRA_OPER_NUR= "Name_intra_oper_nur";
	//名称
	public static final String NAME_SEND_BAKE= "Name_send_bake";
	//名称
	public static final String NAME_PAT_CONDITION= "Name_pat_condition";
	//名称
	public static final String NAME_POS_INFUS= "Name_pos_infus";
	//名称
	public static final String NAME_POS_INFUS_UNOB= "Name_pos_infus_unob";
	//名称
	public static final String NAME_POS_INFUS_TOOL= "Name_pos_infus_tool";
	//名称
	public static final String NAME_POS_ARTICLES= "Name_pos_articles";
	//名称
	public static final String NAME_POS_TUBE= "Name_pos_tube";
	//名称
	public static final String NAME_POS_TUBE_UNOB= "Name_pos_tube_unob";
	//名称
	public static final String NAME_INCI_DRES= "Name_inci_dres";
	//名称
	public static final String NAME_POS_SKIN= "Name_pos_skin";
	//姓名
	public static final String NAME_OPER_POS_NUR= "Name_oper_pos_nur";
	//姓名
	public static final String NAME_POS_ANESTHES= "Name_pos_anesthes";
	//姓名
	public static final String NAME_RECEIV_DOC= "Name_receiv_doc";
	//姓名
	public static final String NAME_RECEIV_NUR= "Name_receiv_nur";
	//名称
	public static final String NAME_PREO_BY_STAGES= "Name_preo_by_stages";
	//名称
	public static final String NAME_INTER_BY_STAGES= "Name_inter_by_stages";
	//名称
	public static final String NAME_POS_BY_STAGES= "Name_pos_by_stages";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 记录单主键
	 * @return String
	 */
	public String getId_surgpat() {
		return ((String) getAttrVal("Id_surgpat"));
	}	
	/**
	 * 记录单主键
	 * @param Id_surgpat
	 */
	public void setId_surgpat(String Id_surgpat) {
		setAttrVal("Id_surgpat", Id_surgpat);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 录入人员
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * 录入日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 录入日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护士签名
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 诊断ID(通用)
	 * @return String
	 */
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	/**
	 * 诊断ID(通用)
	 * @param Id_diagnosis
	 */
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	/**
	 * 诊断(通用)
	 * @return String
	 */
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	/**
	 * 诊断(通用)
	 * @param Name_diagnosis
	 */
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	/**
	 * 接病人时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rece() {
		return ((FDateTime) getAttrVal("Dt_rece"));
	}	
	/**
	 * 接病人时间
	 * @param Dt_rece
	 */
	public void setDt_rece(FDateTime Dt_rece) {
		setAttrVal("Dt_rece", Dt_rece);
	}
	/**
	 * 拟行手术名称
	 * @return String
	 */
	public String getId_operation() {
		return ((String) getAttrVal("Id_operation"));
	}	
	/**
	 * 拟行手术名称
	 * @param Id_operation
	 */
	public void setId_operation(String Id_operation) {
		setAttrVal("Id_operation", Id_operation);
	}
	/**
	 * 术前手术部位标识
	 * @return String
	 */
	public String getId_preo_mark() {
		return ((String) getAttrVal("Id_preo_mark"));
	}	
	/**
	 * 术前手术部位标识
	 * @param Id_preo_mark
	 */
	public void setId_preo_mark(String Id_preo_mark) {
		setAttrVal("Id_preo_mark", Id_preo_mark);
	}
	/**
	 * 术前手术部位标识编码
	 * @return String
	 */
	public String getSd_preo_mark() {
		return ((String) getAttrVal("Sd_preo_mark"));
	}	
	/**
	 * 术前手术部位标识编码
	 * @param Sd_preo_mark
	 */
	public void setSd_preo_mark(String Sd_preo_mark) {
		setAttrVal("Sd_preo_mark", Sd_preo_mark);
	}
	/**
	 * 术前手术部位
	 * @return String
	 */
	public String getId_preo_site() {
		return ((String) getAttrVal("Id_preo_site"));
	}	
	/**
	 * 术前手术部位
	 * @param Id_preo_site
	 */
	public void setId_preo_site(String Id_preo_site) {
		setAttrVal("Id_preo_site", Id_preo_site);
	}
	/**
	 * 术前手术部位编码
	 * @return String
	 */
	public String getSd_preo_site() {
		return ((String) getAttrVal("Sd_preo_site"));
	}	
	/**
	 * 术前手术部位编码
	 * @param Sd_preo_site
	 */
	public void setSd_preo_site(String Sd_preo_site) {
		setAttrVal("Sd_preo_site", Sd_preo_site);
	}
	/**
	 * 术前意识
	 * @return String
	 */
	public String getId_preo_conscious() {
		return ((String) getAttrVal("Id_preo_conscious"));
	}	
	/**
	 * 术前意识
	 * @param Id_preo_conscious
	 */
	public void setId_preo_conscious(String Id_preo_conscious) {
		setAttrVal("Id_preo_conscious", Id_preo_conscious);
	}
	/**
	 * 术前意识编码
	 * @return String
	 */
	public String getSd_preo_conscious() {
		return ((String) getAttrVal("Sd_preo_conscious"));
	}	
	/**
	 * 术前意识编码
	 * @param Sd_preo_conscious
	 */
	public void setSd_preo_conscious(String Sd_preo_conscious) {
		setAttrVal("Sd_preo_conscious", Sd_preo_conscious);
	}
	/**
	 * 术前T
	 * @return FDouble
	 */
	public FDouble getPreo_t() {
		return ((FDouble) getAttrVal("Preo_t"));
	}	
	/**
	 * 术前T
	 * @param Preo_t
	 */
	public void setPreo_t(FDouble Preo_t) {
		setAttrVal("Preo_t", Preo_t);
	}
	/**
	 * 术前P
	 * @return Integer
	 */
	public Integer getPreo_p() {
		return ((Integer) getAttrVal("Preo_p"));
	}	
	/**
	 * 术前P
	 * @param Preo_p
	 */
	public void setPreo_p(Integer Preo_p) {
		setAttrVal("Preo_p", Preo_p);
	}
	/**
	 * 术前R
	 * @return Integer
	 */
	public Integer getPreo_r() {
		return ((Integer) getAttrVal("Preo_r"));
	}	
	/**
	 * 术前R
	 * @param Preo_r
	 */
	public void setPreo_r(Integer Preo_r) {
		setAttrVal("Preo_r", Preo_r);
	}
	/**
	 * 术前SPO2
	 * @return FDouble
	 */
	public FDouble getPreo_spo2() {
		return ((FDouble) getAttrVal("Preo_spo2"));
	}	
	/**
	 * 术前SPO2
	 * @param Preo_spo2
	 */
	public void setPreo_spo2(FDouble Preo_spo2) {
		setAttrVal("Preo_spo2", Preo_spo2);
	}
	/**
	 * 术前收缩压
	 * @return Integer
	 */
	public Integer getPreo_int_sbp() {
		return ((Integer) getAttrVal("Preo_int_sbp"));
	}	
	/**
	 * 术前收缩压
	 * @param Preo_int_sbp
	 */
	public void setPreo_int_sbp(Integer Preo_int_sbp) {
		setAttrVal("Preo_int_sbp", Preo_int_sbp);
	}
	/**
	 * 术前舒张压
	 * @return Integer
	 */
	public Integer getPreo_int_dbp() {
		return ((Integer) getAttrVal("Preo_int_dbp"));
	}	
	/**
	 * 术前舒张压
	 * @param Preo_int_dbp
	 */
	public void setPreo_int_dbp(Integer Preo_int_dbp) {
		setAttrVal("Preo_int_dbp", Preo_int_dbp);
	}
	/**
	 * 术前准备
	 * @return String
	 */
	public String getId_prepar() {
		return ((String) getAttrVal("Id_prepar"));
	}	
	/**
	 * 术前准备
	 * @param Id_prepar
	 */
	public void setId_prepar(String Id_prepar) {
		setAttrVal("Id_prepar", Id_prepar);
	}
	/**
	 * 术前准备编码
	 * @return String
	 */
	public String getSd_prepar() {
		return ((String) getAttrVal("Sd_prepar"));
	}	
	/**
	 * 术前准备编码
	 * @param Sd_prepar
	 */
	public void setSd_prepar(String Sd_prepar) {
		setAttrVal("Sd_prepar", Sd_prepar);
	}
	/**
	 * 术前留置管路
	 * @return String
	 */
	public String getId_preo_pipe() {
		return ((String) getAttrVal("Id_preo_pipe"));
	}	
	/**
	 * 术前留置管路
	 * @param Id_preo_pipe
	 */
	public void setId_preo_pipe(String Id_preo_pipe) {
		setAttrVal("Id_preo_pipe", Id_preo_pipe);
	}
	/**
	 * 术前留置管路编码
	 * @return String
	 */
	public String getSd_preo_pipe() {
		return ((String) getAttrVal("Sd_preo_pipe"));
	}	
	/**
	 * 术前留置管路编码
	 * @param Sd_preo_pipe
	 */
	public void setSd_preo_pipe(String Sd_preo_pipe) {
		setAttrVal("Sd_preo_pipe", Sd_preo_pipe);
	}
	/**
	 * 术前留置管路通畅情况
	 * @return String
	 */
	public String getId_preo_unob_pip() {
		return ((String) getAttrVal("Id_preo_unob_pip"));
	}	
	/**
	 * 术前留置管路通畅情况
	 * @param Id_preo_unob_pip
	 */
	public void setId_preo_unob_pip(String Id_preo_unob_pip) {
		setAttrVal("Id_preo_unob_pip", Id_preo_unob_pip);
	}
	/**
	 * 术前留置管路通畅情况编码
	 * @return String
	 */
	public String getSd_preo_unob_pip() {
		return ((String) getAttrVal("Sd_preo_unob_pip"));
	}	
	/**
	 * 术前留置管路通畅情况编码
	 * @param Sd_preo_unob_pip
	 */
	public void setSd_preo_unob_pip(String Sd_preo_unob_pip) {
		setAttrVal("Sd_preo_unob_pip", Sd_preo_unob_pip);
	}
	/**
	 * 术前携带物品
	 * @return String
	 */
	public String getId_preo_articles() {
		return ((String) getAttrVal("Id_preo_articles"));
	}	
	/**
	 * 术前携带物品
	 * @param Id_preo_articles
	 */
	public void setId_preo_articles(String Id_preo_articles) {
		setAttrVal("Id_preo_articles", Id_preo_articles);
	}
	/**
	 * 术前携带物品编码
	 * @return String
	 */
	public String getSd_preo_articles() {
		return ((String) getAttrVal("Sd_preo_articles"));
	}	
	/**
	 * 术前携带物品编码
	 * @param Sd_preo_articles
	 */
	public void setSd_preo_articles(String Sd_preo_articles) {
		setAttrVal("Sd_preo_articles", Sd_preo_articles);
	}
	/**
	 * 术前药品信息
	 * @return String
	 */
	public String getPreo_drug_inform() {
		return ((String) getAttrVal("Preo_drug_inform"));
	}	
	/**
	 * 术前药品信息
	 * @param Preo_drug_inform
	 */
	public void setPreo_drug_inform(String Preo_drug_inform) {
		setAttrVal("Preo_drug_inform", Preo_drug_inform);
	}
	/**
	 * 术前过敏试验
	 * @return String
	 */
	public String getId_preo_aller() {
		return ((String) getAttrVal("Id_preo_aller"));
	}	
	/**
	 * 术前过敏试验
	 * @param Id_preo_aller
	 */
	public void setId_preo_aller(String Id_preo_aller) {
		setAttrVal("Id_preo_aller", Id_preo_aller);
	}
	/**
	 * 术前过敏试验编码
	 * @return String
	 */
	public String getSd_preo_aller() {
		return ((String) getAttrVal("Sd_preo_aller"));
	}	
	/**
	 * 术前过敏试验编码
	 * @param Sd_preo_aller
	 */
	public void setSd_preo_aller(String Sd_preo_aller) {
		setAttrVal("Sd_preo_aller", Sd_preo_aller);
	}
	/**
	 * 术前批号
	 * @return String
	 */
	public String getPreo_batch() {
		return ((String) getAttrVal("Preo_batch"));
	}	
	/**
	 * 术前批号
	 * @param Preo_batch
	 */
	public void setPreo_batch(String Preo_batch) {
		setAttrVal("Preo_batch", Preo_batch);
	}
	/**
	 * 术前携带物品其它
	 * @return String
	 */
	public String getPreo_goods_oth() {
		return ((String) getAttrVal("Preo_goods_oth"));
	}	
	/**
	 * 术前携带物品其它
	 * @param Preo_goods_oth
	 */
	public void setPreo_goods_oth(String Preo_goods_oth) {
		setAttrVal("Preo_goods_oth", Preo_goods_oth);
	}
	/**
	 * 术前过敏史
	 * @return String
	 */
	public String getId_preo_his_aller() {
		return ((String) getAttrVal("Id_preo_his_aller"));
	}	
	/**
	 * 术前过敏史
	 * @param Id_preo_his_aller
	 */
	public void setId_preo_his_aller(String Id_preo_his_aller) {
		setAttrVal("Id_preo_his_aller", Id_preo_his_aller);
	}
	/**
	 * 术前过敏史编码
	 * @return String
	 */
	public String getSd_preo_his_aller() {
		return ((String) getAttrVal("Sd_preo_his_aller"));
	}	
	/**
	 * 术前过敏史编码
	 * @param Sd_preo_his_aller
	 */
	public void setSd_preo_his_aller(String Sd_preo_his_aller) {
		setAttrVal("Sd_preo_his_aller", Sd_preo_his_aller);
	}
	/**
	 * 术前过敏史情况
	 * @return String
	 */
	public String getPreo_sit_aller() {
		return ((String) getAttrVal("Preo_sit_aller"));
	}	
	/**
	 * 术前过敏史情况
	 * @param Preo_sit_aller
	 */
	public void setPreo_sit_aller(String Preo_sit_aller) {
		setAttrVal("Preo_sit_aller", Preo_sit_aller);
	}
	/**
	 * 术前输液
	 * @return String
	 */
	public String getId_preo_infus() {
		return ((String) getAttrVal("Id_preo_infus"));
	}	
	/**
	 * 术前输液
	 * @param Id_preo_infus
	 */
	public void setId_preo_infus(String Id_preo_infus) {
		setAttrVal("Id_preo_infus", Id_preo_infus);
	}
	/**
	 * 术前输液编码
	 * @return String
	 */
	public String getSd_preo_infus() {
		return ((String) getAttrVal("Sd_preo_infus"));
	}	
	/**
	 * 术前输液编码
	 * @param Sd_preo_infus
	 */
	public void setSd_preo_infus(String Sd_preo_infus) {
		setAttrVal("Sd_preo_infus", Sd_preo_infus);
	}
	/**
	 * 术前输液情况
	 * @return String
	 */
	public String getPreo_infus_sit() {
		return ((String) getAttrVal("Preo_infus_sit"));
	}	
	/**
	 * 术前输液情况
	 * @param Preo_infus_sit
	 */
	public void setPreo_infus_sit(String Preo_infus_sit) {
		setAttrVal("Preo_infus_sit", Preo_infus_sit);
	}
	/**
	 * 术前输液通畅情况
	 * @return String
	 */
	public String getId_preo_infus_unob() {
		return ((String) getAttrVal("Id_preo_infus_unob"));
	}	
	/**
	 * 术前输液通畅情况
	 * @param Id_preo_infus_unob
	 */
	public void setId_preo_infus_unob(String Id_preo_infus_unob) {
		setAttrVal("Id_preo_infus_unob", Id_preo_infus_unob);
	}
	/**
	 * 术前输液通畅情况编码
	 * @return String
	 */
	public String getSd_preo_infus_unob() {
		return ((String) getAttrVal("Sd_preo_infus_unob"));
	}	
	/**
	 * 术前输液通畅情况编码
	 * @param Sd_preo_infus_unob
	 */
	public void setSd_preo_infus_unob(String Sd_preo_infus_unob) {
		setAttrVal("Sd_preo_infus_unob", Sd_preo_infus_unob);
	}
	/**
	 * 术前输液工具
	 * @return String
	 */
	public String getId_preo_infus_tool() {
		return ((String) getAttrVal("Id_preo_infus_tool"));
	}	
	/**
	 * 术前输液工具
	 * @param Id_preo_infus_tool
	 */
	public void setId_preo_infus_tool(String Id_preo_infus_tool) {
		setAttrVal("Id_preo_infus_tool", Id_preo_infus_tool);
	}
	/**
	 * 术前输液工具编码
	 * @return String
	 */
	public String getSd_preo_infus_tool() {
		return ((String) getAttrVal("Sd_preo_infus_tool"));
	}	
	/**
	 * 术前输液工具编码
	 * @param Sd_preo_infus_tool
	 */
	public void setSd_preo_infus_tool(String Sd_preo_infus_tool) {
		setAttrVal("Sd_preo_infus_tool", Sd_preo_infus_tool);
	}
	/**
	 * 术前输液工具其它
	 * @return String
	 */
	public String getPreo_tool_oth() {
		return ((String) getAttrVal("Preo_tool_oth"));
	}	
	/**
	 * 术前输液工具其它
	 * @param Preo_tool_oth
	 */
	public void setPreo_tool_oth(String Preo_tool_oth) {
		setAttrVal("Preo_tool_oth", Preo_tool_oth);
	}
	/**
	 * 术前皮肤
	 * @return String
	 */
	public String getId_preo_skin() {
		return ((String) getAttrVal("Id_preo_skin"));
	}	
	/**
	 * 术前皮肤
	 * @param Id_preo_skin
	 */
	public void setId_preo_skin(String Id_preo_skin) {
		setAttrVal("Id_preo_skin", Id_preo_skin);
	}
	/**
	 * 术前皮肤编码
	 * @return String
	 */
	public String getSd_preo_skin() {
		return ((String) getAttrVal("Sd_preo_skin"));
	}	
	/**
	 * 术前皮肤编码
	 * @param Sd_preo_skin
	 */
	public void setSd_preo_skin(String Sd_preo_skin) {
		setAttrVal("Sd_preo_skin", Sd_preo_skin);
	}
	/**
	 * 术前分期
	 * @return String
	 */
	public String getPreo_stages() {
		return ((String) getAttrVal("Preo_stages"));
	}	
	/**
	 * 术前分期
	 * @param Preo_stages
	 */
	public void setPreo_stages(String Preo_stages) {
		setAttrVal("Preo_stages", Preo_stages);
	}
	/**
	 * 术前部位
	 * @return String
	 */
	public String getPreo_position() {
		return ((String) getAttrVal("Preo_position"));
	}	
	/**
	 * 术前部位
	 * @param Preo_position
	 */
	public void setPreo_position(String Preo_position) {
		setAttrVal("Preo_position", Preo_position);
	}
	/**
	 * 术前特殊交接
	 * @return String
	 */
	public String getPreo_spe_hand() {
		return ((String) getAttrVal("Preo_spe_hand"));
	}	
	/**
	 * 术前特殊交接
	 * @param Preo_spe_hand
	 */
	public void setPreo_spe_hand(String Preo_spe_hand) {
		setAttrVal("Preo_spe_hand", Preo_spe_hand);
	}
	/**
	 * 术前科室护士
	 * @return String
	 */
	public String getId_preo_nur() {
		return ((String) getAttrVal("Id_preo_nur"));
	}	
	/**
	 * 术前科室护士
	 * @param Id_preo_nur
	 */
	public void setId_preo_nur(String Id_preo_nur) {
		setAttrVal("Id_preo_nur", Id_preo_nur);
	}
	/**
	 * 患者/家属
	 * @return String
	 */
	public String getFami_pat() {
		return ((String) getAttrVal("Fami_pat"));
	}	
	/**
	 * 患者/家属
	 * @param Fami_pat
	 */
	public void setFami_pat(String Fami_pat) {
		setAttrVal("Fami_pat", Fami_pat);
	}
	/**
	 * 术前手术室护士
	 * @return String
	 */
	public String getId_preo_oper_nur() {
		return ((String) getAttrVal("Id_preo_oper_nur"));
	}	
	/**
	 * 术前手术室护士
	 * @param Id_preo_oper_nur
	 */
	public void setId_preo_oper_nur(String Id_preo_oper_nur) {
		setAttrVal("Id_preo_oper_nur", Id_preo_oper_nur);
	}
	/**
	 * 入手术室时间
	 * @return FDateTime
	 */
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}	
	/**
	 * 入手术室时间
	 * @param Dt_enter
	 */
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	/**
	 * 术中意识
	 * @return String
	 */
	public String getId_intra_conscious() {
		return ((String) getAttrVal("Id_intra_conscious"));
	}	
	/**
	 * 术中意识
	 * @param Id_intra_conscious
	 */
	public void setId_intra_conscious(String Id_intra_conscious) {
		setAttrVal("Id_intra_conscious", Id_intra_conscious);
	}
	/**
	 * 术中意识编码
	 * @return String
	 */
	public String getSd_intra_conscious() {
		return ((String) getAttrVal("Sd_intra_conscious"));
	}	
	/**
	 * 术中意识编码
	 * @param Sd_intra_conscious
	 */
	public void setSd_intra_conscious(String Sd_intra_conscious) {
		setAttrVal("Sd_intra_conscious", Sd_intra_conscious);
	}
	/**
	 * 术中携带物品
	 * @return String
	 */
	public String getId_intra_articles() {
		return ((String) getAttrVal("Id_intra_articles"));
	}	
	/**
	 * 术中携带物品
	 * @param Id_intra_articles
	 */
	public void setId_intra_articles(String Id_intra_articles) {
		setAttrVal("Id_intra_articles", Id_intra_articles);
	}
	/**
	 * 术中携带物品编码
	 * @return String
	 */
	public String getSd_intra_articles() {
		return ((String) getAttrVal("Sd_intra_articles"));
	}	
	/**
	 * 术中携带物品编码
	 * @param Sd_intra_articles
	 */
	public void setSd_intra_articles(String Sd_intra_articles) {
		setAttrVal("Sd_intra_articles", Sd_intra_articles);
	}
	/**
	 * 术中携带物品其它
	 * @return String
	 */
	public String getIntra_articles_oth() {
		return ((String) getAttrVal("Intra_articles_oth"));
	}	
	/**
	 * 术中携带物品其它
	 * @param Intra_articles_oth
	 */
	public void setIntra_articles_oth(String Intra_articles_oth) {
		setAttrVal("Intra_articles_oth", Intra_articles_oth);
	}
	/**
	 * 术中手术部位标识
	 * @return String
	 */
	public String getId_intra_mark() {
		return ((String) getAttrVal("Id_intra_mark"));
	}	
	/**
	 * 术中手术部位标识
	 * @param Id_intra_mark
	 */
	public void setId_intra_mark(String Id_intra_mark) {
		setAttrVal("Id_intra_mark", Id_intra_mark);
	}
	/**
	 * 术中手术部位标识编码
	 * @return String
	 */
	public String getSd_intra_mark() {
		return ((String) getAttrVal("Sd_intra_mark"));
	}	
	/**
	 * 术中手术部位标识编码
	 * @param Sd_intra_mark
	 */
	public void setSd_intra_mark(String Sd_intra_mark) {
		setAttrVal("Sd_intra_mark", Sd_intra_mark);
	}
	/**
	 * 术中手术部位
	 * @return String
	 */
	public String getId_intra_site() {
		return ((String) getAttrVal("Id_intra_site"));
	}	
	/**
	 * 术中手术部位
	 * @param Id_intra_site
	 */
	public void setId_intra_site(String Id_intra_site) {
		setAttrVal("Id_intra_site", Id_intra_site);
	}
	/**
	 * 术中手术部位编码
	 * @return String
	 */
	public String getSd_intra_site() {
		return ((String) getAttrVal("Sd_intra_site"));
	}	
	/**
	 * 术中手术部位编码
	 * @param Sd_intra_site
	 */
	public void setSd_intra_site(String Sd_intra_site) {
		setAttrVal("Sd_intra_site", Sd_intra_site);
	}
	/**
	 * 术中手术部位其它
	 * @return String
	 */
	public String getIntra_site_oth() {
		return ((String) getAttrVal("Intra_site_oth"));
	}	
	/**
	 * 术中手术部位其它
	 * @param Intra_site_oth
	 */
	public void setIntra_site_oth(String Intra_site_oth) {
		setAttrVal("Intra_site_oth", Intra_site_oth);
	}
	/**
	 * 术中留置管路
	 * @return String
	 */
	public String getId_intra_pipe() {
		return ((String) getAttrVal("Id_intra_pipe"));
	}	
	/**
	 * 术中留置管路
	 * @param Id_intra_pipe
	 */
	public void setId_intra_pipe(String Id_intra_pipe) {
		setAttrVal("Id_intra_pipe", Id_intra_pipe);
	}
	/**
	 * 术中留置管路编码
	 * @return String
	 */
	public String getSd_intra_pipe() {
		return ((String) getAttrVal("Sd_intra_pipe"));
	}	
	/**
	 * 术中留置管路编码
	 * @param Sd_intra_pipe
	 */
	public void setSd_intra_pipe(String Sd_intra_pipe) {
		setAttrVal("Sd_intra_pipe", Sd_intra_pipe);
	}
	/**
	 * 术中留置管路通畅情况
	 * @return String
	 */
	public String getId_intra_unob_pip() {
		return ((String) getAttrVal("Id_intra_unob_pip"));
	}	
	/**
	 * 术中留置管路通畅情况
	 * @param Id_intra_unob_pip
	 */
	public void setId_intra_unob_pip(String Id_intra_unob_pip) {
		setAttrVal("Id_intra_unob_pip", Id_intra_unob_pip);
	}
	/**
	 * 术中留置管路通畅情况编码
	 * @return String
	 */
	public String getSd_intra_unob_pip() {
		return ((String) getAttrVal("Sd_intra_unob_pip"));
	}	
	/**
	 * 术中留置管路通畅情况编码
	 * @param Sd_intra_unob_pip
	 */
	public void setSd_intra_unob_pip(String Sd_intra_unob_pip) {
		setAttrVal("Sd_intra_unob_pip", Sd_intra_unob_pip);
	}
	/**
	 * 术中皮肤
	 * @return String
	 */
	public String getId_intra_skin() {
		return ((String) getAttrVal("Id_intra_skin"));
	}	
	/**
	 * 术中皮肤
	 * @param Id_intra_skin
	 */
	public void setId_intra_skin(String Id_intra_skin) {
		setAttrVal("Id_intra_skin", Id_intra_skin);
	}
	/**
	 * 术中皮肤编码
	 * @return String
	 */
	public String getSd_intra_skin() {
		return ((String) getAttrVal("Sd_intra_skin"));
	}	
	/**
	 * 术中皮肤编码
	 * @param Sd_intra_skin
	 */
	public void setSd_intra_skin(String Sd_intra_skin) {
		setAttrVal("Sd_intra_skin", Sd_intra_skin);
	}
	/**
	 * 术中分期
	 * @return String
	 */
	public String getIntra_stages() {
		return ((String) getAttrVal("Intra_stages"));
	}	
	/**
	 * 术中分期
	 * @param Intra_stages
	 */
	public void setIntra_stages(String Intra_stages) {
		setAttrVal("Intra_stages", Intra_stages);
	}
	/**
	 * 术中部位
	 * @return String
	 */
	public String getIntra_position() {
		return ((String) getAttrVal("Intra_position"));
	}	
	/**
	 * 术中部位
	 * @param Intra_position
	 */
	public void setIntra_position(String Intra_position) {
		setAttrVal("Intra_position", Intra_position);
	}
	/**
	 * 术中T
	 * @return FDouble
	 */
	public FDouble getIntra_t() {
		return ((FDouble) getAttrVal("Intra_t"));
	}	
	/**
	 * 术中T
	 * @param Intra_t
	 */
	public void setIntra_t(FDouble Intra_t) {
		setAttrVal("Intra_t", Intra_t);
	}
	/**
	 * 术中P
	 * @return Integer
	 */
	public Integer getIntra_p() {
		return ((Integer) getAttrVal("Intra_p"));
	}	
	/**
	 * 术中P
	 * @param Intra_p
	 */
	public void setIntra_p(Integer Intra_p) {
		setAttrVal("Intra_p", Intra_p);
	}
	/**
	 * 术中R
	 * @return Integer
	 */
	public Integer getIntra_r() {
		return ((Integer) getAttrVal("Intra_r"));
	}	
	/**
	 * 术中R
	 * @param Intra_r
	 */
	public void setIntra_r(Integer Intra_r) {
		setAttrVal("Intra_r", Intra_r);
	}
	/**
	 * 术中SPO2
	 * @return FDouble
	 */
	public FDouble getIntra_spo2() {
		return ((FDouble) getAttrVal("Intra_spo2"));
	}	
	/**
	 * 术中SPO2
	 * @param Intra_spo2
	 */
	public void setIntra_spo2(FDouble Intra_spo2) {
		setAttrVal("Intra_spo2", Intra_spo2);
	}
	/**
	 * 术中收缩压
	 * @return Integer
	 */
	public Integer getIntra_int_sbps() {
		return ((Integer) getAttrVal("Intra_int_sbps"));
	}	
	/**
	 * 术中收缩压
	 * @param Intra_int_sbps
	 */
	public void setIntra_int_sbps(Integer Intra_int_sbps) {
		setAttrVal("Intra_int_sbps", Intra_int_sbps);
	}
	/**
	 * 术中舒张压
	 * @return Integer
	 */
	public Integer getIntra_int_dbps() {
		return ((Integer) getAttrVal("Intra_int_dbps"));
	}	
	/**
	 * 术中舒张压
	 * @param Intra_int_dbps
	 */
	public void setIntra_int_dbps(Integer Intra_int_dbps) {
		setAttrVal("Intra_int_dbps", Intra_int_dbps);
	}
	/**
	 * 手术结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper_end() {
		return ((FDateTime) getAttrVal("Dt_oper_end"));
	}	
	/**
	 * 手术结束时间
	 * @param Dt_oper_end
	 */
	public void setDt_oper_end(FDateTime Dt_oper_end) {
		setAttrVal("Dt_oper_end", Dt_oper_end);
	}
	/**
	 * 术中麻醉医师
	 * @return String
	 */
	public String getId_anesthes() {
		return ((String) getAttrVal("Id_anesthes"));
	}	
	/**
	 * 术中麻醉医师
	 * @param Id_anesthes
	 */
	public void setId_anesthes(String Id_anesthes) {
		setAttrVal("Id_anesthes", Id_anesthes);
	}
	/**
	 * 手术医生
	 * @return String
	 */
	public String getId_surgeon() {
		return ((String) getAttrVal("Id_surgeon"));
	}	
	/**
	 * 手术医生
	 * @param Id_surgeon
	 */
	public void setId_surgeon(String Id_surgeon) {
		setAttrVal("Id_surgeon", Id_surgeon);
	}
	/**
	 * 术中手术室护士
	 * @return String
	 */
	public String getId_intra_oper_nur() {
		return ((String) getAttrVal("Id_intra_oper_nur"));
	}	
	/**
	 * 术中手术室护士
	 * @param Id_intra_oper_nur
	 */
	public void setId_intra_oper_nur(String Id_intra_oper_nur) {
		setAttrVal("Id_intra_oper_nur", Id_intra_oper_nur);
	}
	/**
	 * 术后送回
	 * @return String
	 */
	public String getId_send_bake() {
		return ((String) getAttrVal("Id_send_bake"));
	}	
	/**
	 * 术后送回
	 * @param Id_send_bake
	 */
	public void setId_send_bake(String Id_send_bake) {
		setAttrVal("Id_send_bake", Id_send_bake);
	}
	/**
	 * 术后送回编码
	 * @return String
	 */
	public String getSd_send_bake() {
		return ((String) getAttrVal("Sd_send_bake"));
	}	
	/**
	 * 术后送回编码
	 * @param Sd_send_bake
	 */
	public void setSd_send_bake(String Sd_send_bake) {
		setAttrVal("Sd_send_bake", Sd_send_bake);
	}
	/**
	 * 术后送回时间
	 * @return FDateTime
	 */
	public FDateTime getDt_send() {
		return ((FDateTime) getAttrVal("Dt_send"));
	}	
	/**
	 * 术后送回时间
	 * @param Dt_send
	 */
	public void setDt_send(FDateTime Dt_send) {
		setAttrVal("Dt_send", Dt_send);
	}
	/**
	 * 术后T
	 * @return FDouble
	 */
	public FDouble getPos_t() {
		return ((FDouble) getAttrVal("Pos_t"));
	}	
	/**
	 * 术后T
	 * @param Pos_t
	 */
	public void setPos_t(FDouble Pos_t) {
		setAttrVal("Pos_t", Pos_t);
	}
	/**
	 * 术后P
	 * @return Integer
	 */
	public Integer getPos_p() {
		return ((Integer) getAttrVal("Pos_p"));
	}	
	/**
	 * 术后P
	 * @param Pos_p
	 */
	public void setPos_p(Integer Pos_p) {
		setAttrVal("Pos_p", Pos_p);
	}
	/**
	 * 术后R
	 * @return Integer
	 */
	public Integer getPos_r() {
		return ((Integer) getAttrVal("Pos_r"));
	}	
	/**
	 * 术后R
	 * @param Pos_r
	 */
	public void setPos_r(Integer Pos_r) {
		setAttrVal("Pos_r", Pos_r);
	}
	/**
	 * 术后SPO2
	 * @return FDouble
	 */
	public FDouble getPos_spo2() {
		return ((FDouble) getAttrVal("Pos_spo2"));
	}	
	/**
	 * 术后SPO2
	 * @param Pos_spo2
	 */
	public void setPos_spo2(FDouble Pos_spo2) {
		setAttrVal("Pos_spo2", Pos_spo2);
	}
	/**
	 * 术后收缩压
	 * @return Integer
	 */
	public Integer getPos_int_sbps() {
		return ((Integer) getAttrVal("Pos_int_sbps"));
	}	
	/**
	 * 术后收缩压
	 * @param Pos_int_sbps
	 */
	public void setPos_int_sbps(Integer Pos_int_sbps) {
		setAttrVal("Pos_int_sbps", Pos_int_sbps);
	}
	/**
	 * 术后舒张压
	 * @return Integer
	 */
	public Integer getPos_int_dbps() {
		return ((Integer) getAttrVal("Pos_int_dbps"));
	}	
	/**
	 * 术后舒张压
	 * @param Pos_int_dbps
	 */
	public void setPos_int_dbps(Integer Pos_int_dbps) {
		setAttrVal("Pos_int_dbps", Pos_int_dbps);
	}
	/**
	 * 病人情况
	 * @return String
	 */
	public String getId_pat_condition() {
		return ((String) getAttrVal("Id_pat_condition"));
	}	
	/**
	 * 病人情况
	 * @param Id_pat_condition
	 */
	public void setId_pat_condition(String Id_pat_condition) {
		setAttrVal("Id_pat_condition", Id_pat_condition);
	}
	/**
	 * 病人情况编码
	 * @return String
	 */
	public String getSd_pat_condition() {
		return ((String) getAttrVal("Sd_pat_condition"));
	}	
	/**
	 * 病人情况编码
	 * @param Sd_pat_condition
	 */
	public void setSd_pat_condition(String Sd_pat_condition) {
		setAttrVal("Sd_pat_condition", Sd_pat_condition);
	}
	/**
	 * 术后输液
	 * @return String
	 */
	public String getId_pos_infus() {
		return ((String) getAttrVal("Id_pos_infus"));
	}	
	/**
	 * 术后输液
	 * @param Id_pos_infus
	 */
	public void setId_pos_infus(String Id_pos_infus) {
		setAttrVal("Id_pos_infus", Id_pos_infus);
	}
	/**
	 * 术后输液编码
	 * @return String
	 */
	public String getSd_pos_infus() {
		return ((String) getAttrVal("Sd_pos_infus"));
	}	
	/**
	 * 术后输液编码
	 * @param Sd_pos_infus
	 */
	public void setSd_pos_infus(String Sd_pos_infus) {
		setAttrVal("Sd_pos_infus", Sd_pos_infus);
	}
	/**
	 * 术后输液情况
	 * @return String
	 */
	public String getPos_infus_sit() {
		return ((String) getAttrVal("Pos_infus_sit"));
	}	
	/**
	 * 术后输液情况
	 * @param Pos_infus_sit
	 */
	public void setPos_infus_sit(String Pos_infus_sit) {
		setAttrVal("Pos_infus_sit", Pos_infus_sit);
	}
	/**
	 * 术后输液通畅情况
	 * @return String
	 */
	public String getId_pos_infus_unob() {
		return ((String) getAttrVal("Id_pos_infus_unob"));
	}	
	/**
	 * 术后输液通畅情况
	 * @param Id_pos_infus_unob
	 */
	public void setId_pos_infus_unob(String Id_pos_infus_unob) {
		setAttrVal("Id_pos_infus_unob", Id_pos_infus_unob);
	}
	/**
	 * 术后输液通畅情况编码
	 * @return String
	 */
	public String getSd_pos_infus_unob() {
		return ((String) getAttrVal("Sd_pos_infus_unob"));
	}	
	/**
	 * 术后输液通畅情况编码
	 * @param Sd_pos_infus_unob
	 */
	public void setSd_pos_infus_unob(String Sd_pos_infus_unob) {
		setAttrVal("Sd_pos_infus_unob", Sd_pos_infus_unob);
	}
	/**
	 * 术前留置管路情况
	 * @return String
	 */
	public String getPreo_pipe_cond() {
		return ((String) getAttrVal("Preo_pipe_cond"));
	}	
	/**
	 * 术前留置管路情况
	 * @param Preo_pipe_cond
	 */
	public void setPreo_pipe_cond(String Preo_pipe_cond) {
		setAttrVal("Preo_pipe_cond", Preo_pipe_cond);
	}
	/**
	 * 术中留置管路情况
	 * @return String
	 */
	public String getIntra_pipe_cond() {
		return ((String) getAttrVal("Intra_pipe_cond"));
	}	
	/**
	 * 术中留置管路情况
	 * @param Intra_pipe_cond
	 */
	public void setIntra_pipe_cond(String Intra_pipe_cond) {
		setAttrVal("Intra_pipe_cond", Intra_pipe_cond);
	}
	/**
	 * 术后输液工具
	 * @return String
	 */
	public String getId_pos_infus_tool() {
		return ((String) getAttrVal("Id_pos_infus_tool"));
	}	
	/**
	 * 术后输液工具
	 * @param Id_pos_infus_tool
	 */
	public void setId_pos_infus_tool(String Id_pos_infus_tool) {
		setAttrVal("Id_pos_infus_tool", Id_pos_infus_tool);
	}
	/**
	 * 术后输液工具编码
	 * @return String
	 */
	public String getSd_pos_infus_tool() {
		return ((String) getAttrVal("Sd_pos_infus_tool"));
	}	
	/**
	 * 术后输液工具编码
	 * @param Sd_pos_infus_tool
	 */
	public void setSd_pos_infus_tool(String Sd_pos_infus_tool) {
		setAttrVal("Sd_pos_infus_tool", Sd_pos_infus_tool);
	}
	/**
	 * 术后输液工具其它
	 * @return String
	 */
	public String getPos_tool_oth() {
		return ((String) getAttrVal("Pos_tool_oth"));
	}	
	/**
	 * 术后输液工具其它
	 * @param Pos_tool_oth
	 */
	public void setPos_tool_oth(String Pos_tool_oth) {
		setAttrVal("Pos_tool_oth", Pos_tool_oth);
	}
	/**
	 * 带回药品
	 * @return String
	 */
	public String getBring_drug() {
		return ((String) getAttrVal("Bring_drug"));
	}	
	/**
	 * 带回药品
	 * @param Bring_drug
	 */
	public void setBring_drug(String Bring_drug) {
		setAttrVal("Bring_drug", Bring_drug);
	}
	/**
	 * 术后携带物品
	 * @return String
	 */
	public String getId_pos_articles() {
		return ((String) getAttrVal("Id_pos_articles"));
	}	
	/**
	 * 术后携带物品
	 * @param Id_pos_articles
	 */
	public void setId_pos_articles(String Id_pos_articles) {
		setAttrVal("Id_pos_articles", Id_pos_articles);
	}
	/**
	 * 术后携带物品编码
	 * @return String
	 */
	public String getSd_pos_articles() {
		return ((String) getAttrVal("Sd_pos_articles"));
	}	
	/**
	 * 术后携带物品编码
	 * @param Sd_pos_articles
	 */
	public void setSd_pos_articles(String Sd_pos_articles) {
		setAttrVal("Sd_pos_articles", Sd_pos_articles);
	}
	/**
	 * 术后携带物品其它
	 * @return String
	 */
	public String getPos_articles_oth() {
		return ((String) getAttrVal("Pos_articles_oth"));
	}	
	/**
	 * 术后携带物品其它
	 * @param Pos_articles_oth
	 */
	public void setPos_articles_oth(String Pos_articles_oth) {
		setAttrVal("Pos_articles_oth", Pos_articles_oth);
	}
	/**
	 * 标本份数
	 * @return Integer
	 */
	public Integer getNum_specimen() {
		return ((Integer) getAttrVal("Num_specimen"));
	}	
	/**
	 * 标本份数
	 * @param Num_specimen
	 */
	public void setNum_specimen(Integer Num_specimen) {
		setAttrVal("Num_specimen", Num_specimen);
	}
	/**
	 * 术后引流管
	 * @return String
	 */
	public String getId_pos_tube() {
		return ((String) getAttrVal("Id_pos_tube"));
	}	
	/**
	 * 术后引流管
	 * @param Id_pos_tube
	 */
	public void setId_pos_tube(String Id_pos_tube) {
		setAttrVal("Id_pos_tube", Id_pos_tube);
	}
	/**
	 * 术后引流管编码
	 * @return String
	 */
	public String getSd_pos_tube() {
		return ((String) getAttrVal("Sd_pos_tube"));
	}	
	/**
	 * 术后引流管编码
	 * @param Sd_pos_tube
	 */
	public void setSd_pos_tube(String Sd_pos_tube) {
		setAttrVal("Sd_pos_tube", Sd_pos_tube);
	}
	/**
	 * 术后引流管情况
	 * @return String
	 */
	public String getPos_tube_sit() {
		return ((String) getAttrVal("Pos_tube_sit"));
	}	
	/**
	 * 术后引流管情况
	 * @param Pos_tube_sit
	 */
	public void setPos_tube_sit(String Pos_tube_sit) {
		setAttrVal("Pos_tube_sit", Pos_tube_sit);
	}
	/**
	 * 术后引流管通畅情况
	 * @return String
	 */
	public String getId_pos_tube_unob() {
		return ((String) getAttrVal("Id_pos_tube_unob"));
	}	
	/**
	 * 术后引流管通畅情况
	 * @param Id_pos_tube_unob
	 */
	public void setId_pos_tube_unob(String Id_pos_tube_unob) {
		setAttrVal("Id_pos_tube_unob", Id_pos_tube_unob);
	}
	/**
	 * 术后引流管通畅情况编码
	 * @return String
	 */
	public String getSd_pos_tube_unob() {
		return ((String) getAttrVal("Sd_pos_tube_unob"));
	}	
	/**
	 * 术后引流管通畅情况编码
	 * @param Sd_pos_tube_unob
	 */
	public void setSd_pos_tube_unob(String Sd_pos_tube_unob) {
		setAttrVal("Sd_pos_tube_unob", Sd_pos_tube_unob);
	}
	/**
	 * 术后切口敷料
	 * @return String
	 */
	public String getId_inci_dres() {
		return ((String) getAttrVal("Id_inci_dres"));
	}	
	/**
	 * 术后切口敷料
	 * @param Id_inci_dres
	 */
	public void setId_inci_dres(String Id_inci_dres) {
		setAttrVal("Id_inci_dres", Id_inci_dres);
	}
	/**
	 * 术后切口敷料编码
	 * @return String
	 */
	public String getSd_inci_dres() {
		return ((String) getAttrVal("Sd_inci_dres"));
	}	
	/**
	 * 术后切口敷料编码
	 * @param Sd_inci_dres
	 */
	public void setSd_inci_dres(String Sd_inci_dres) {
		setAttrVal("Sd_inci_dres", Sd_inci_dres);
	}
	/**
	 * 术后皮肤
	 * @return String
	 */
	public String getId_pos_skin() {
		return ((String) getAttrVal("Id_pos_skin"));
	}	
	/**
	 * 术后皮肤
	 * @param Id_pos_skin
	 */
	public void setId_pos_skin(String Id_pos_skin) {
		setAttrVal("Id_pos_skin", Id_pos_skin);
	}
	/**
	 * 术后皮肤编码
	 * @return String
	 */
	public String getSd_pos_skin() {
		return ((String) getAttrVal("Sd_pos_skin"));
	}	
	/**
	 * 术后皮肤编码
	 * @param Sd_pos_skin
	 */
	public void setSd_pos_skin(String Sd_pos_skin) {
		setAttrVal("Sd_pos_skin", Sd_pos_skin);
	}
	/**
	 * 术后分期
	 * @return String
	 */
	public String getPos_stages() {
		return ((String) getAttrVal("Pos_stages"));
	}	
	/**
	 * 术后分期
	 * @param Pos_stages
	 */
	public void setPos_stages(String Pos_stages) {
		setAttrVal("Pos_stages", Pos_stages);
	}
	/**
	 * 术后部位
	 * @return String
	 */
	public String getPos_position() {
		return ((String) getAttrVal("Pos_position"));
	}	
	/**
	 * 术后部位
	 * @param Pos_position
	 */
	public void setPos_position(String Pos_position) {
		setAttrVal("Pos_position", Pos_position);
	}
	/**
	 * 术后特殊交接
	 * @return String
	 */
	public String getPos_spe_hand() {
		return ((String) getAttrVal("Pos_spe_hand"));
	}	
	/**
	 * 术后特殊交接
	 * @param Pos_spe_hand
	 */
	public void setPos_spe_hand(String Pos_spe_hand) {
		setAttrVal("Pos_spe_hand", Pos_spe_hand);
	}
	/**
	 * 术后手术室护士签名
	 * @return String
	 */
	public String getId_oper_pos_nur() {
		return ((String) getAttrVal("Id_oper_pos_nur"));
	}	
	/**
	 * 术后手术室护士签名
	 * @param Id_oper_pos_nur
	 */
	public void setId_oper_pos_nur(String Id_oper_pos_nur) {
		setAttrVal("Id_oper_pos_nur", Id_oper_pos_nur);
	}
	/**
	 * 术后麻醉医师签名
	 * @return String
	 */
	public String getId_pos_anesthes() {
		return ((String) getAttrVal("Id_pos_anesthes"));
	}	
	/**
	 * 术后麻醉医师签名
	 * @param Id_pos_anesthes
	 */
	public void setId_pos_anesthes(String Id_pos_anesthes) {
		setAttrVal("Id_pos_anesthes", Id_pos_anesthes);
	}
	/**
	 * 接收医生签名
	 * @return String
	 */
	public String getId_receiv_doc() {
		return ((String) getAttrVal("Id_receiv_doc"));
	}	
	/**
	 * 接收医生签名
	 * @param Id_receiv_doc
	 */
	public void setId_receiv_doc(String Id_receiv_doc) {
		setAttrVal("Id_receiv_doc", Id_receiv_doc);
	}
	/**
	 * 术后接收护士签名
	 * @return String
	 */
	public String getId_receiv_nur() {
		return ((String) getAttrVal("Id_receiv_nur"));
	}	
	/**
	 * 术后接收护士签名
	 * @param Id_receiv_nur
	 */
	public void setId_receiv_nur(String Id_receiv_nur) {
		setAttrVal("Id_receiv_nur", Id_receiv_nur);
	}
	/**
	 * 术前分期选项
	 * @return String
	 */
	public String getId_preo_by_stages() {
		return ((String) getAttrVal("Id_preo_by_stages"));
	}	
	/**
	 * 术前分期选项
	 * @param Id_preo_by_stages
	 */
	public void setId_preo_by_stages(String Id_preo_by_stages) {
		setAttrVal("Id_preo_by_stages", Id_preo_by_stages);
	}
	/**
	 * 术前分期选项编码
	 * @return String
	 */
	public String getSd_preo_by_stages() {
		return ((String) getAttrVal("Sd_preo_by_stages"));
	}	
	/**
	 * 术前分期选项编码
	 * @param Sd_preo_by_stages
	 */
	public void setSd_preo_by_stages(String Sd_preo_by_stages) {
		setAttrVal("Sd_preo_by_stages", Sd_preo_by_stages);
	}
	/**
	 * 术中分期选项
	 * @return String
	 */
	public String getId_inter_by_stages() {
		return ((String) getAttrVal("Id_inter_by_stages"));
	}	
	/**
	 * 术中分期选项
	 * @param Id_inter_by_stages
	 */
	public void setId_inter_by_stages(String Id_inter_by_stages) {
		setAttrVal("Id_inter_by_stages", Id_inter_by_stages);
	}
	/**
	 * 术中分期选项编码
	 * @return String
	 */
	public String getSd_inter_by_stages() {
		return ((String) getAttrVal("Sd_inter_by_stages"));
	}	
	/**
	 * 术中分期选项编码
	 * @param Sd_inter_by_stages
	 */
	public void setSd_inter_by_stages(String Sd_inter_by_stages) {
		setAttrVal("Sd_inter_by_stages", Sd_inter_by_stages);
	}
	/**
	 * 术后分期选项
	 * @return String
	 */
	public String getId_pos_by_stages() {
		return ((String) getAttrVal("Id_pos_by_stages"));
	}	
	/**
	 * 术后分期选项
	 * @param Id_pos_by_stages
	 */
	public void setId_pos_by_stages(String Id_pos_by_stages) {
		setAttrVal("Id_pos_by_stages", Id_pos_by_stages);
	}
	/**
	 * 术后分期选项编码
	 * @return String
	 */
	public String getSd_pos_by_stages() {
		return ((String) getAttrVal("Sd_pos_by_stages"));
	}	
	/**
	 * 术后分期选项编码
	 * @param Sd_pos_by_stages
	 */
	public void setSd_pos_by_stages(String Sd_pos_by_stages) {
		setAttrVal("Sd_pos_by_stages", Sd_pos_by_stages);
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
	 * 姓名
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 姓名
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	/**
	 * 服务名称
	 * @param Name_operation
	 */
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_mark() {
		return ((String) getAttrVal("Name_preo_mark"));
	}	
	/**
	 * 名称
	 * @param Name_preo_mark
	 */
	public void setName_preo_mark(String Name_preo_mark) {
		setAttrVal("Name_preo_mark", Name_preo_mark);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_site() {
		return ((String) getAttrVal("Name_preo_site"));
	}	
	/**
	 * 名称
	 * @param Name_preo_site
	 */
	public void setName_preo_site(String Name_preo_site) {
		setAttrVal("Name_preo_site", Name_preo_site);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_conscious() {
		return ((String) getAttrVal("Name_preo_conscious"));
	}	
	/**
	 * 名称
	 * @param Name_preo_conscious
	 */
	public void setName_preo_conscious(String Name_preo_conscious) {
		setAttrVal("Name_preo_conscious", Name_preo_conscious);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_prepar() {
		return ((String) getAttrVal("Name_prepar"));
	}	
	/**
	 * 名称
	 * @param Name_prepar
	 */
	public void setName_prepar(String Name_prepar) {
		setAttrVal("Name_prepar", Name_prepar);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_pipe() {
		return ((String) getAttrVal("Name_preo_pipe"));
	}	
	/**
	 * 名称
	 * @param Name_preo_pipe
	 */
	public void setName_preo_pipe(String Name_preo_pipe) {
		setAttrVal("Name_preo_pipe", Name_preo_pipe);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_unob_pip() {
		return ((String) getAttrVal("Name_preo_unob_pip"));
	}	
	/**
	 * 名称
	 * @param Name_preo_unob_pip
	 */
	public void setName_preo_unob_pip(String Name_preo_unob_pip) {
		setAttrVal("Name_preo_unob_pip", Name_preo_unob_pip);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_articles() {
		return ((String) getAttrVal("Name_preo_articles"));
	}	
	/**
	 * 名称
	 * @param Name_preo_articles
	 */
	public void setName_preo_articles(String Name_preo_articles) {
		setAttrVal("Name_preo_articles", Name_preo_articles);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_aller() {
		return ((String) getAttrVal("Name_preo_aller"));
	}	
	/**
	 * 名称
	 * @param Name_preo_aller
	 */
	public void setName_preo_aller(String Name_preo_aller) {
		setAttrVal("Name_preo_aller", Name_preo_aller);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_his_aller() {
		return ((String) getAttrVal("Name_preo_his_aller"));
	}	
	/**
	 * 名称
	 * @param Name_preo_his_aller
	 */
	public void setName_preo_his_aller(String Name_preo_his_aller) {
		setAttrVal("Name_preo_his_aller", Name_preo_his_aller);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_infus() {
		return ((String) getAttrVal("Name_preo_infus"));
	}	
	/**
	 * 名称
	 * @param Name_preo_infus
	 */
	public void setName_preo_infus(String Name_preo_infus) {
		setAttrVal("Name_preo_infus", Name_preo_infus);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_infus_unob() {
		return ((String) getAttrVal("Name_preo_infus_unob"));
	}	
	/**
	 * 名称
	 * @param Name_preo_infus_unob
	 */
	public void setName_preo_infus_unob(String Name_preo_infus_unob) {
		setAttrVal("Name_preo_infus_unob", Name_preo_infus_unob);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_infus_tool() {
		return ((String) getAttrVal("Name_preo_infus_tool"));
	}	
	/**
	 * 名称
	 * @param Name_preo_infus_tool
	 */
	public void setName_preo_infus_tool(String Name_preo_infus_tool) {
		setAttrVal("Name_preo_infus_tool", Name_preo_infus_tool);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_skin() {
		return ((String) getAttrVal("Name_preo_skin"));
	}	
	/**
	 * 名称
	 * @param Name_preo_skin
	 */
	public void setName_preo_skin(String Name_preo_skin) {
		setAttrVal("Name_preo_skin", Name_preo_skin);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_preo_nur() {
		return ((String) getAttrVal("Name_preo_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_preo_nur
	 */
	public void setName_preo_nur(String Name_preo_nur) {
		setAttrVal("Name_preo_nur", Name_preo_nur);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_preo_oper_nur() {
		return ((String) getAttrVal("Name_preo_oper_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_preo_oper_nur
	 */
	public void setName_preo_oper_nur(String Name_preo_oper_nur) {
		setAttrVal("Name_preo_oper_nur", Name_preo_oper_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_conscious() {
		return ((String) getAttrVal("Name_intra_conscious"));
	}	
	/**
	 * 名称
	 * @param Name_intra_conscious
	 */
	public void setName_intra_conscious(String Name_intra_conscious) {
		setAttrVal("Name_intra_conscious", Name_intra_conscious);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_articles() {
		return ((String) getAttrVal("Name_intra_articles"));
	}	
	/**
	 * 名称
	 * @param Name_intra_articles
	 */
	public void setName_intra_articles(String Name_intra_articles) {
		setAttrVal("Name_intra_articles", Name_intra_articles);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_mark() {
		return ((String) getAttrVal("Name_intra_mark"));
	}	
	/**
	 * 名称
	 * @param Name_intra_mark
	 */
	public void setName_intra_mark(String Name_intra_mark) {
		setAttrVal("Name_intra_mark", Name_intra_mark);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_site() {
		return ((String) getAttrVal("Name_intra_site"));
	}	
	/**
	 * 名称
	 * @param Name_intra_site
	 */
	public void setName_intra_site(String Name_intra_site) {
		setAttrVal("Name_intra_site", Name_intra_site);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_pipe() {
		return ((String) getAttrVal("Name_intra_pipe"));
	}	
	/**
	 * 名称
	 * @param Name_intra_pipe
	 */
	public void setName_intra_pipe(String Name_intra_pipe) {
		setAttrVal("Name_intra_pipe", Name_intra_pipe);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_unob_pip() {
		return ((String) getAttrVal("Name_intra_unob_pip"));
	}	
	/**
	 * 名称
	 * @param Name_intra_unob_pip
	 */
	public void setName_intra_unob_pip(String Name_intra_unob_pip) {
		setAttrVal("Name_intra_unob_pip", Name_intra_unob_pip);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_intra_skin() {
		return ((String) getAttrVal("Name_intra_skin"));
	}	
	/**
	 * 名称
	 * @param Name_intra_skin
	 */
	public void setName_intra_skin(String Name_intra_skin) {
		setAttrVal("Name_intra_skin", Name_intra_skin);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_anesthes() {
		return ((String) getAttrVal("Name_anesthes"));
	}	
	/**
	 * 姓名
	 * @param Name_anesthes
	 */
	public void setName_anesthes(String Name_anesthes) {
		setAttrVal("Name_anesthes", Name_anesthes);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_surgeon() {
		return ((String) getAttrVal("Name_surgeon"));
	}	
	/**
	 * 姓名
	 * @param Name_surgeon
	 */
	public void setName_surgeon(String Name_surgeon) {
		setAttrVal("Name_surgeon", Name_surgeon);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_intra_oper_nur() {
		return ((String) getAttrVal("Name_intra_oper_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_intra_oper_nur
	 */
	public void setName_intra_oper_nur(String Name_intra_oper_nur) {
		setAttrVal("Name_intra_oper_nur", Name_intra_oper_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_send_bake() {
		return ((String) getAttrVal("Name_send_bake"));
	}	
	/**
	 * 名称
	 * @param Name_send_bake
	 */
	public void setName_send_bake(String Name_send_bake) {
		setAttrVal("Name_send_bake", Name_send_bake);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pat_condition() {
		return ((String) getAttrVal("Name_pat_condition"));
	}	
	/**
	 * 名称
	 * @param Name_pat_condition
	 */
	public void setName_pat_condition(String Name_pat_condition) {
		setAttrVal("Name_pat_condition", Name_pat_condition);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_infus() {
		return ((String) getAttrVal("Name_pos_infus"));
	}	
	/**
	 * 名称
	 * @param Name_pos_infus
	 */
	public void setName_pos_infus(String Name_pos_infus) {
		setAttrVal("Name_pos_infus", Name_pos_infus);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_infus_unob() {
		return ((String) getAttrVal("Name_pos_infus_unob"));
	}	
	/**
	 * 名称
	 * @param Name_pos_infus_unob
	 */
	public void setName_pos_infus_unob(String Name_pos_infus_unob) {
		setAttrVal("Name_pos_infus_unob", Name_pos_infus_unob);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_infus_tool() {
		return ((String) getAttrVal("Name_pos_infus_tool"));
	}	
	/**
	 * 名称
	 * @param Name_pos_infus_tool
	 */
	public void setName_pos_infus_tool(String Name_pos_infus_tool) {
		setAttrVal("Name_pos_infus_tool", Name_pos_infus_tool);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_articles() {
		return ((String) getAttrVal("Name_pos_articles"));
	}	
	/**
	 * 名称
	 * @param Name_pos_articles
	 */
	public void setName_pos_articles(String Name_pos_articles) {
		setAttrVal("Name_pos_articles", Name_pos_articles);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_tube() {
		return ((String) getAttrVal("Name_pos_tube"));
	}	
	/**
	 * 名称
	 * @param Name_pos_tube
	 */
	public void setName_pos_tube(String Name_pos_tube) {
		setAttrVal("Name_pos_tube", Name_pos_tube);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_tube_unob() {
		return ((String) getAttrVal("Name_pos_tube_unob"));
	}	
	/**
	 * 名称
	 * @param Name_pos_tube_unob
	 */
	public void setName_pos_tube_unob(String Name_pos_tube_unob) {
		setAttrVal("Name_pos_tube_unob", Name_pos_tube_unob);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_inci_dres() {
		return ((String) getAttrVal("Name_inci_dres"));
	}	
	/**
	 * 名称
	 * @param Name_inci_dres
	 */
	public void setName_inci_dres(String Name_inci_dres) {
		setAttrVal("Name_inci_dres", Name_inci_dres);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_skin() {
		return ((String) getAttrVal("Name_pos_skin"));
	}	
	/**
	 * 名称
	 * @param Name_pos_skin
	 */
	public void setName_pos_skin(String Name_pos_skin) {
		setAttrVal("Name_pos_skin", Name_pos_skin);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_oper_pos_nur() {
		return ((String) getAttrVal("Name_oper_pos_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_oper_pos_nur
	 */
	public void setName_oper_pos_nur(String Name_oper_pos_nur) {
		setAttrVal("Name_oper_pos_nur", Name_oper_pos_nur);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pos_anesthes() {
		return ((String) getAttrVal("Name_pos_anesthes"));
	}	
	/**
	 * 姓名
	 * @param Name_pos_anesthes
	 */
	public void setName_pos_anesthes(String Name_pos_anesthes) {
		setAttrVal("Name_pos_anesthes", Name_pos_anesthes);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_receiv_doc() {
		return ((String) getAttrVal("Name_receiv_doc"));
	}	
	/**
	 * 姓名
	 * @param Name_receiv_doc
	 */
	public void setName_receiv_doc(String Name_receiv_doc) {
		setAttrVal("Name_receiv_doc", Name_receiv_doc);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_receiv_nur() {
		return ((String) getAttrVal("Name_receiv_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_receiv_nur
	 */
	public void setName_receiv_nur(String Name_receiv_nur) {
		setAttrVal("Name_receiv_nur", Name_receiv_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preo_by_stages() {
		return ((String) getAttrVal("Name_preo_by_stages"));
	}	
	/**
	 * 名称
	 * @param Name_preo_by_stages
	 */
	public void setName_preo_by_stages(String Name_preo_by_stages) {
		setAttrVal("Name_preo_by_stages", Name_preo_by_stages);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_inter_by_stages() {
		return ((String) getAttrVal("Name_inter_by_stages"));
	}	
	/**
	 * 名称
	 * @param Name_inter_by_stages
	 */
	public void setName_inter_by_stages(String Name_inter_by_stages) {
		setAttrVal("Name_inter_by_stages", Name_inter_by_stages);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos_by_stages() {
		return ((String) getAttrVal("Name_pos_by_stages"));
	}	
	/**
	 * 名称
	 * @param Name_pos_by_stages
	 */
	public void setName_pos_by_stages(String Name_pos_by_stages) {
		setAttrVal("Name_pos_by_stages", Name_pos_by_stages);
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
		return "Id_surgpat";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_SURGPATHANDOVER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgPatHandoverDODesc.class);
	}
	
}