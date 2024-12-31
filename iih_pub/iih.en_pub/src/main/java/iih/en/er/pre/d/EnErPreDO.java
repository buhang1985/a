package iih.en.er.pre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.er.pre.d.desc.EnErPreDODesc;
import java.math.BigDecimal;

/**
 * 急诊预检 DO数据 
 * 
 */
public class EnErPreDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预检主键
	public static final String ID_ERPRE= "Id_erpre";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//组织id
	public static final String ID_ORG= "Id_org";
	//预检码
	public static final String CODE= "Code";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//第一次就诊id
	public static final String ID_ENT_FST= "Id_ent_fst";
	//最后一次就诊id
	public static final String ID_ENT_LAST= "Id_ent_last";
	//三无人员标志
	public static final String FG_NONPERSON= "Fg_nonperson";
	//来院时间
	public static final String DT_ENTRY= "Dt_entry";
	//来院方式id
	public static final String ID_COME_WAY= "Id_come_way";
	//来院方式编码
	public static final String SD_COME_WAY= "Sd_come_way";
	//陪送人员ids
	public static final String IDS_COMPANION= "Ids_companion";
	//陪送人员编码
	public static final String SDS_COMPANION= "Sds_companion";
	//流行病学史标志
	public static final String EU_CHK_EQIDEMIC= "Eu_chk_eqidemic";
	//检查询问ids
	public static final String IDS_CHK_NOTE= "Ids_chk_note";
	//检查询问编码
	public static final String SDS_CHK_NOTE= "Sds_chk_note";
	//采集生命体征时间
	public static final String DT_PICK_VS= "Dt_pick_vs";
	//呼吸状态ids
	public static final String ID_BREATH_STATE= "Id_breath_state";
	//呼吸状态编码
	public static final String SD_BREATH_STATE= "Sd_breath_state";
	//主诉描述
	public static final String DES_CMPT= "Des_cmpt";
	//检伤分类id
	public static final String ID_TRIAGE_CA= "Id_triage_ca";
	//检伤主诉id
	public static final String ID_TRIAGE_CMPT= "Id_triage_cmpt";
	//检伤判定id
	public static final String ID_TRIAGE_RES= "Id_triage_res";
	//分级编码_自动
	public static final String SD_SCALE_AUTO= "Sd_scale_auto";
	//分级编码_手动
	public static final String SD_SCALE_HM= "Sd_scale_hm";
	//分级编码_主诉判定
	public static final String SD_SCALE_CMPT= "Sd_scale_cmpt";
	//分诊科室id
	public static final String ID_DEP_TO= "Id_dep_to";
	//绿色通道标志
	public static final String FG_GREEN_CHANNEL= "Fg_green_channel";
	//绿色通道症状ids
	public static final String IDS_GREEN_CHANNEL_SYM= "Ids_green_channel_sym";
	//绿色通道症状编码
	public static final String SDS_GREEN_CHANNEL_SYM= "Sds_green_channel_sym";
	//分诊去向
	public static final String SD_TRIAGE_TO= "Sd_triage_to";
	//预检人员id
	public static final String ID_EMP_PRE= "Id_emp_pre";
	//结束时间
	public static final String DT_END= "Dt_end";
	//状态
	public static final String SD_STATUS= "Sd_status";
	//留观就诊id
	public static final String ID_ENT_IP= "Id_ent_ip";
	//留观预检状态
	public static final String SD_STATUS_IP= "Sd_status_ip";
	//留观结束时间
	public static final String DT_END_IP= "Dt_end_ip";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//拒绝标志
	public static final String FG_REFUSE_EXA= "Fg_refuse_exa";
	//来院方式名称
	public static final String NAME_COME_WAY= "Name_come_way";
	//陪送人员名称
	public static final String NAMES_COMPANION= "Names_companion";
	//检查询问名称
	public static final String NAMES_CHK_NOTE= "Names_chk_note";
	//呼吸状态名称
	public static final String NAME_BREATH_STATE= "Name_breath_state";
	//检伤分类名称
	public static final String NAME_TRIAGE_CA= "Name_triage_ca";
	//检伤主诉名称
	public static final String NAME_TRIAGE_CMPT= "Name_triage_cmpt";
	//检伤判定名称
	public static final String NAME_TRIAGE_RES= "Name_triage_res";
	//分诊科室名称
	public static final String NAME_DEP_TO= "Name_dep_to";
	//分诊科室编码
	public static final String CODE_DEP_TO= "Code_dep_to";
	//绿色通道名称
	public static final String NAMES_GREEN_CHANNEL= "Names_green_channel";
	//预检人员姓名
	public static final String NAME_EMP_PRE= "Name_emp_pre";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预检主键
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}	
	/**
	 * 预检主键
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 预检码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 预检码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 第一次就诊id
	 * @return String
	 */
	public String getId_ent_fst() {
		return ((String) getAttrVal("Id_ent_fst"));
	}	
	/**
	 * 第一次就诊id
	 * @param Id_ent_fst
	 */
	public void setId_ent_fst(String Id_ent_fst) {
		setAttrVal("Id_ent_fst", Id_ent_fst);
	}
	/**
	 * 最后一次就诊id
	 * @return String
	 */
	public String getId_ent_last() {
		return ((String) getAttrVal("Id_ent_last"));
	}	
	/**
	 * 最后一次就诊id
	 * @param Id_ent_last
	 */
	public void setId_ent_last(String Id_ent_last) {
		setAttrVal("Id_ent_last", Id_ent_last);
	}
	/**
	 * 三无人员标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}	
	/**
	 * 三无人员标志
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
	}
	/**
	 * 来院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 来院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 来院方式id
	 * @return String
	 */
	public String getId_come_way() {
		return ((String) getAttrVal("Id_come_way"));
	}	
	/**
	 * 来院方式id
	 * @param Id_come_way
	 */
	public void setId_come_way(String Id_come_way) {
		setAttrVal("Id_come_way", Id_come_way);
	}
	/**
	 * 来院方式编码
	 * @return String
	 */
	public String getSd_come_way() {
		return ((String) getAttrVal("Sd_come_way"));
	}	
	/**
	 * 来院方式编码
	 * @param Sd_come_way
	 */
	public void setSd_come_way(String Sd_come_way) {
		setAttrVal("Sd_come_way", Sd_come_way);
	}
	/**
	 * 陪送人员ids
	 * @return String
	 */
	public String getIds_companion() {
		return ((String) getAttrVal("Ids_companion"));
	}	
	/**
	 * 陪送人员ids
	 * @param Ids_companion
	 */
	public void setIds_companion(String Ids_companion) {
		setAttrVal("Ids_companion", Ids_companion);
	}
	/**
	 * 陪送人员编码
	 * @return String
	 */
	public String getSds_companion() {
		return ((String) getAttrVal("Sds_companion"));
	}	
	/**
	 * 陪送人员编码
	 * @param Sds_companion
	 */
	public void setSds_companion(String Sds_companion) {
		setAttrVal("Sds_companion", Sds_companion);
	}
	/**
	 * 流行病学史标志
	 * @return String
	 */
	public String getEu_chk_eqidemic() {
		return ((String) getAttrVal("Eu_chk_eqidemic"));
	}	
	/**
	 * 流行病学史标志
	 * @param Eu_chk_eqidemic
	 */
	public void setEu_chk_eqidemic(String Eu_chk_eqidemic) {
		setAttrVal("Eu_chk_eqidemic", Eu_chk_eqidemic);
	}
	/**
	 * 检查询问ids
	 * @return String
	 */
	public String getIds_chk_note() {
		return ((String) getAttrVal("Ids_chk_note"));
	}	
	/**
	 * 检查询问ids
	 * @param Ids_chk_note
	 */
	public void setIds_chk_note(String Ids_chk_note) {
		setAttrVal("Ids_chk_note", Ids_chk_note);
	}
	/**
	 * 检查询问编码
	 * @return String
	 */
	public String getSds_chk_note() {
		return ((String) getAttrVal("Sds_chk_note"));
	}	
	/**
	 * 检查询问编码
	 * @param Sds_chk_note
	 */
	public void setSds_chk_note(String Sds_chk_note) {
		setAttrVal("Sds_chk_note", Sds_chk_note);
	}
	/**
	 * 采集生命体征时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pick_vs() {
		return ((FDateTime) getAttrVal("Dt_pick_vs"));
	}	
	/**
	 * 采集生命体征时间
	 * @param Dt_pick_vs
	 */
	public void setDt_pick_vs(FDateTime Dt_pick_vs) {
		setAttrVal("Dt_pick_vs", Dt_pick_vs);
	}
	/**
	 * 呼吸状态ids
	 * @return String
	 */
	public String getId_breath_state() {
		return ((String) getAttrVal("Id_breath_state"));
	}	
	/**
	 * 呼吸状态ids
	 * @param Id_breath_state
	 */
	public void setId_breath_state(String Id_breath_state) {
		setAttrVal("Id_breath_state", Id_breath_state);
	}
	/**
	 * 呼吸状态编码
	 * @return String
	 */
	public String getSd_breath_state() {
		return ((String) getAttrVal("Sd_breath_state"));
	}	
	/**
	 * 呼吸状态编码
	 * @param Sd_breath_state
	 */
	public void setSd_breath_state(String Sd_breath_state) {
		setAttrVal("Sd_breath_state", Sd_breath_state);
	}
	/**
	 * 主诉描述
	 * @return String
	 */
	public String getDes_cmpt() {
		return ((String) getAttrVal("Des_cmpt"));
	}	
	/**
	 * 主诉描述
	 * @param Des_cmpt
	 */
	public void setDes_cmpt(String Des_cmpt) {
		setAttrVal("Des_cmpt", Des_cmpt);
	}
	/**
	 * 检伤分类id
	 * @return String
	 */
	public String getId_triage_ca() {
		return ((String) getAttrVal("Id_triage_ca"));
	}	
	/**
	 * 检伤分类id
	 * @param Id_triage_ca
	 */
	public void setId_triage_ca(String Id_triage_ca) {
		setAttrVal("Id_triage_ca", Id_triage_ca);
	}
	/**
	 * 检伤主诉id
	 * @return String
	 */
	public String getId_triage_cmpt() {
		return ((String) getAttrVal("Id_triage_cmpt"));
	}	
	/**
	 * 检伤主诉id
	 * @param Id_triage_cmpt
	 */
	public void setId_triage_cmpt(String Id_triage_cmpt) {
		setAttrVal("Id_triage_cmpt", Id_triage_cmpt);
	}
	/**
	 * 检伤判定id
	 * @return String
	 */
	public String getId_triage_res() {
		return ((String) getAttrVal("Id_triage_res"));
	}	
	/**
	 * 检伤判定id
	 * @param Id_triage_res
	 */
	public void setId_triage_res(String Id_triage_res) {
		setAttrVal("Id_triage_res", Id_triage_res);
	}
	/**
	 * 分级编码_自动
	 * @return String
	 */
	public String getSd_scale_auto() {
		return ((String) getAttrVal("Sd_scale_auto"));
	}	
	/**
	 * 分级编码_自动
	 * @param Sd_scale_auto
	 */
	public void setSd_scale_auto(String Sd_scale_auto) {
		setAttrVal("Sd_scale_auto", Sd_scale_auto);
	}
	/**
	 * 分级编码_手动
	 * @return String
	 */
	public String getSd_scale_hm() {
		return ((String) getAttrVal("Sd_scale_hm"));
	}	
	/**
	 * 分级编码_手动
	 * @param Sd_scale_hm
	 */
	public void setSd_scale_hm(String Sd_scale_hm) {
		setAttrVal("Sd_scale_hm", Sd_scale_hm);
	}
	/**
	 * 分级编码_主诉判定
	 * @return String
	 */
	public String getSd_scale_cmpt() {
		return ((String) getAttrVal("Sd_scale_cmpt"));
	}	
	/**
	 * 分级编码_主诉判定
	 * @param Sd_scale_cmpt
	 */
	public void setSd_scale_cmpt(String Sd_scale_cmpt) {
		setAttrVal("Sd_scale_cmpt", Sd_scale_cmpt);
	}
	/**
	 * 分诊科室id
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}	
	/**
	 * 分诊科室id
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 绿色通道标志
	 * @return FBoolean
	 */
	public FBoolean getFg_green_channel() {
		return ((FBoolean) getAttrVal("Fg_green_channel"));
	}	
	/**
	 * 绿色通道标志
	 * @param Fg_green_channel
	 */
	public void setFg_green_channel(FBoolean Fg_green_channel) {
		setAttrVal("Fg_green_channel", Fg_green_channel);
	}
	/**
	 * 绿色通道症状ids
	 * @return String
	 */
	public String getIds_green_channel_sym() {
		return ((String) getAttrVal("Ids_green_channel_sym"));
	}	
	/**
	 * 绿色通道症状ids
	 * @param Ids_green_channel_sym
	 */
	public void setIds_green_channel_sym(String Ids_green_channel_sym) {
		setAttrVal("Ids_green_channel_sym", Ids_green_channel_sym);
	}
	/**
	 * 绿色通道症状编码
	 * @return String
	 */
	public String getSds_green_channel_sym() {
		return ((String) getAttrVal("Sds_green_channel_sym"));
	}	
	/**
	 * 绿色通道症状编码
	 * @param Sds_green_channel_sym
	 */
	public void setSds_green_channel_sym(String Sds_green_channel_sym) {
		setAttrVal("Sds_green_channel_sym", Sds_green_channel_sym);
	}
	/**
	 * 分诊去向
	 * @return String
	 */
	public String getSd_triage_to() {
		return ((String) getAttrVal("Sd_triage_to"));
	}	
	/**
	 * 分诊去向
	 * @param Sd_triage_to
	 */
	public void setSd_triage_to(String Sd_triage_to) {
		setAttrVal("Sd_triage_to", Sd_triage_to);
	}
	/**
	 * 预检人员id
	 * @return String
	 */
	public String getId_emp_pre() {
		return ((String) getAttrVal("Id_emp_pre"));
	}	
	/**
	 * 预检人员id
	 * @param Id_emp_pre
	 */
	public void setId_emp_pre(String Id_emp_pre) {
		setAttrVal("Id_emp_pre", Id_emp_pre);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 留观就诊id
	 * @return String
	 */
	public String getId_ent_ip() {
		return ((String) getAttrVal("Id_ent_ip"));
	}	
	/**
	 * 留观就诊id
	 * @param Id_ent_ip
	 */
	public void setId_ent_ip(String Id_ent_ip) {
		setAttrVal("Id_ent_ip", Id_ent_ip);
	}
	/**
	 * 留观预检状态
	 * @return String
	 */
	public String getSd_status_ip() {
		return ((String) getAttrVal("Sd_status_ip"));
	}	
	/**
	 * 留观预检状态
	 * @param Sd_status_ip
	 */
	public void setSd_status_ip(String Sd_status_ip) {
		setAttrVal("Sd_status_ip", Sd_status_ip);
	}
	/**
	 * 留观结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_ip() {
		return ((FDateTime) getAttrVal("Dt_end_ip"));
	}	
	/**
	 * 留观结束时间
	 * @param Dt_end_ip
	 */
	public void setDt_end_ip(FDateTime Dt_end_ip) {
		setAttrVal("Dt_end_ip", Dt_end_ip);
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
	 * 拒绝标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refuse_exa() {
		return ((FBoolean) getAttrVal("Fg_refuse_exa"));
	}	
	/**
	 * 拒绝标志
	 * @param Fg_refuse_exa
	 */
	public void setFg_refuse_exa(FBoolean Fg_refuse_exa) {
		setAttrVal("Fg_refuse_exa", Fg_refuse_exa);
	}
	/**
	 * 来院方式名称
	 * @return String
	 */
	public String getName_come_way() {
		return ((String) getAttrVal("Name_come_way"));
	}	
	/**
	 * 来院方式名称
	 * @param Name_come_way
	 */
	public void setName_come_way(String Name_come_way) {
		setAttrVal("Name_come_way", Name_come_way);
	}
	/**
	 * 陪送人员名称
	 * @return String
	 */
	public String getNames_companion() {
		return ((String) getAttrVal("Names_companion"));
	}	
	/**
	 * 陪送人员名称
	 * @param Names_companion
	 */
	public void setNames_companion(String Names_companion) {
		setAttrVal("Names_companion", Names_companion);
	}
	/**
	 * 检查询问名称
	 * @return String
	 */
	public String getNames_chk_note() {
		return ((String) getAttrVal("Names_chk_note"));
	}	
	/**
	 * 检查询问名称
	 * @param Names_chk_note
	 */
	public void setNames_chk_note(String Names_chk_note) {
		setAttrVal("Names_chk_note", Names_chk_note);
	}
	/**
	 * 呼吸状态名称
	 * @return String
	 */
	public String getName_breath_state() {
		return ((String) getAttrVal("Name_breath_state"));
	}	
	/**
	 * 呼吸状态名称
	 * @param Name_breath_state
	 */
	public void setName_breath_state(String Name_breath_state) {
		setAttrVal("Name_breath_state", Name_breath_state);
	}
	/**
	 * 检伤分类名称
	 * @return String
	 */
	public String getName_triage_ca() {
		return ((String) getAttrVal("Name_triage_ca"));
	}	
	/**
	 * 检伤分类名称
	 * @param Name_triage_ca
	 */
	public void setName_triage_ca(String Name_triage_ca) {
		setAttrVal("Name_triage_ca", Name_triage_ca);
	}
	/**
	 * 检伤主诉名称
	 * @return String
	 */
	public String getName_triage_cmpt() {
		return ((String) getAttrVal("Name_triage_cmpt"));
	}	
	/**
	 * 检伤主诉名称
	 * @param Name_triage_cmpt
	 */
	public void setName_triage_cmpt(String Name_triage_cmpt) {
		setAttrVal("Name_triage_cmpt", Name_triage_cmpt);
	}
	/**
	 * 检伤判定名称
	 * @return String
	 */
	public String getName_triage_res() {
		return ((String) getAttrVal("Name_triage_res"));
	}	
	/**
	 * 检伤判定名称
	 * @param Name_triage_res
	 */
	public void setName_triage_res(String Name_triage_res) {
		setAttrVal("Name_triage_res", Name_triage_res);
	}
	/**
	 * 分诊科室名称
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}	
	/**
	 * 分诊科室名称
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	/**
	 * 分诊科室编码
	 * @return String
	 */
	public String getCode_dep_to() {
		return ((String) getAttrVal("Code_dep_to"));
	}	
	/**
	 * 分诊科室编码
	 * @param Code_dep_to
	 */
	public void setCode_dep_to(String Code_dep_to) {
		setAttrVal("Code_dep_to", Code_dep_to);
	}
	/**
	 * 绿色通道名称
	 * @return String
	 */
	public String getNames_green_channel() {
		return ((String) getAttrVal("Names_green_channel"));
	}	
	/**
	 * 绿色通道名称
	 * @param Names_green_channel
	 */
	public void setNames_green_channel(String Names_green_channel) {
		setAttrVal("Names_green_channel", Names_green_channel);
	}
	/**
	 * 预检人员姓名
	 * @return String
	 */
	public String getName_emp_pre() {
		return ((String) getAttrVal("Name_emp_pre"));
	}	
	/**
	 * 预检人员姓名
	 * @param Name_emp_pre
	 */
	public void setName_emp_pre(String Name_emp_pre) {
		setAttrVal("Name_emp_pre", Name_emp_pre);
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
		return "Id_erpre";
	}
	
	@Override
	public String getTableName() {	  
		return "EN_ERPRE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnErPreDODesc.class);
	}
	
}