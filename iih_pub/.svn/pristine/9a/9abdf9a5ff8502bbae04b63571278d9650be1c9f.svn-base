package iih.sfda.aer.sfdaaerev.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerev.d.desc.SfdaAerEvDODesc;
import java.math.BigDecimal;

/**
 * 不良上报事件 DO数据 
 * 
 */
public class SfdaAerEvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//事件主键
	public static final String ID_AER_EV= "Id_aer_ev";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//任务外键
	public static final String ID_TASK= "Id_task";
	//是否匿名
	public static final String FG_ISMIT= "Fg_ismit";
	//事件编号
	public static final String CODE_EV= "Code_ev";
	//受害者类型id
	public static final String ID_SFDA_IMPRD_TP= "Id_sfda_imprd_tp";
	//受害者类型编码
	public static final String SD_SFDA_IMPRD_TP= "Sd_sfda_imprd_tp";
	//发现人
	public static final String ID_PSNDOC= "Id_psndoc";
	//发生日期
	public static final String DT_OCCUR= "Dt_occur";
	//发生部门
	public static final String ID_DEP_OCCUR= "Id_dep_occur";
	//发生时间类型id
	public static final String ID_OCCUR_DTTP= "Id_occur_dttp";
	//发生时间类型编码
	public static final String SD_OCCUR_DTTP= "Sd_occur_dttp";
	//发生地点id
	public static final String ID_OCCUR_ADR= "Id_occur_adr";
	//发生地点编码
	public static final String SD_OCCUR_ADR= "Sd_occur_adr";
	//不良事件级别id
	public static final String ID_EV_LVL= "Id_ev_lvl";
	//不良事件级别编码
	public static final String SD_EV_LVL= "Sd_ev_lvl";
	//伤害严重度id
	public static final String ID_HURT_LVL= "Id_hurt_lvl";
	//伤害严重度编码
	public static final String SD_HURT_LVL= "Sd_hurt_lvl";
	//事件经过及详细信息
	public static final String EV_DES= "Ev_des";
	//事件类别id
	public static final String ID_EV_CA= "Id_ev_ca";
	//事件类别编码
	public static final String SD_EV_CA= "Sd_ev_ca";
	//诊断性检查
	public static final String EU_DIAG_TS= "Eu_diag_ts";
	//诊断性检查描述
	public static final String DIAG_TS_DES= "Diag_ts_des";
	//事件发生后的处理id
	public static final String ID_EV_AFHDLE= "Id_ev_afhdle";
	//事件发生后的处理编码
	public static final String SD_EV_AFHDLE= "Sd_ev_afhdle";
	//事件发生后的处理描述
	public static final String EV_AFHDLE_DES= "Ev_afhdle_des";
	//是否通知相关人员
	public static final String EU_NOTIFY_RELPSN= "Eu_notify_relpsn";
	//通知相关人员id
	public static final String ID_NOTIFY_RELPSN= "Id_notify_relpsn";
	//通知相关人员编码
	public static final String SD_NOTIFY_RELPSN= "Sd_notify_relpsn";
	//通知相关人员内容
	public static final String CONTENT_NOTIFY_RELPSN= "Content_notify_relpsn";
	//是否通知家属
	public static final String EU_NOTIFY_FAM= "Eu_notify_fam";
	//通知家属时间
	public static final String DT_NOTIFY_FAM= "Dt_notify_fam";
	//家属书否理解
	public static final String EU_FAM_UD= "Eu_fam_ud";
	//事件涉及类别
	public static final String EU_EV_REFTP= "Eu_ev_reftp";
	//事件状态
	public static final String EV_STATUS= "Ev_status";
	//当前处理节点
	public static final String CURR_NODE= "Curr_node";
	//当前处理者
	public static final String ID_CURRHDL_USER= "Id_currhdl_user";
	//处理期限
	public static final String HDL_LIMT= "Hdl_limt";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//扩展字段4
	public static final String EXT4= "Ext4";
	//扩展字段5
	public static final String EXT5= "Ext5";
	//扩展字段6
	public static final String EXT6= "Ext6";
	//扩展字段7
	public static final String EXT7= "Ext7";
	//扩展字段8
	public static final String EXT8= "Ext8";
	//扩展字段9
	public static final String EXT9= "Ext9";
	//扩展字段10
	public static final String EXT10= "Ext10";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//名称
	public static final String NAME_SFDA_IMPRD_TP= "Name_sfda_imprd_tp";
	//上报人
	public static final String NAME_PSNDOC= "Name_psndoc";
	//发生部门
	public static final String NAME_DEP_OCCUR= "Name_dep_occur";
	//名称
	public static final String NAME_OCCUR_DTTP= "Name_occur_dttp";
	//发生地点
	public static final String NAME_OCCUR_ADR= "Name_occur_adr";
	//名称
	public static final String NAME_EV_LVL= "Name_ev_lvl";
	//标准编码描述
	public static final String DES_EV_LVL= "Des_ev_lvl";
	//名称
	public static final String NAME_HURT_LVL= "Name_hurt_lvl";
	//标准编码描述
	public static final String DES_HURT_LVL= "Des_hurt_lvl";
	//事件类别名称
	public static final String NAME_EV_CA= "Name_ev_ca";
	//事件发生后的处理
	public static final String NAME_EV_AFHDLE= "Name_ev_afhdle";
	//名称
	public static final String NAME_NOTIFY_RELPSN= "Name_notify_relpsn";
	//用户
	public static final String NAME_CURRHDL_USER= "Name_currhdl_user";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 事件主键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件主键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 任务外键
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 任务外键
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 是否匿名
	 * @return FBoolean
	 */
	public FBoolean getFg_ismit() {
		return ((FBoolean) getAttrVal("Fg_ismit"));
	}	
	/**
	 * 是否匿名
	 * @param Fg_ismit
	 */
	public void setFg_ismit(FBoolean Fg_ismit) {
		setAttrVal("Fg_ismit", Fg_ismit);
	}
	/**
	 * 事件编号
	 * @return String
	 */
	public String getCode_ev() {
		return ((String) getAttrVal("Code_ev"));
	}	
	/**
	 * 事件编号
	 * @param Code_ev
	 */
	public void setCode_ev(String Code_ev) {
		setAttrVal("Code_ev", Code_ev);
	}
	/**
	 * 受害者类型id
	 * @return String
	 */
	public String getId_sfda_imprd_tp() {
		return ((String) getAttrVal("Id_sfda_imprd_tp"));
	}	
	/**
	 * 受害者类型id
	 * @param Id_sfda_imprd_tp
	 */
	public void setId_sfda_imprd_tp(String Id_sfda_imprd_tp) {
		setAttrVal("Id_sfda_imprd_tp", Id_sfda_imprd_tp);
	}
	/**
	 * 受害者类型编码
	 * @return String
	 */
	public String getSd_sfda_imprd_tp() {
		return ((String) getAttrVal("Sd_sfda_imprd_tp"));
	}	
	/**
	 * 受害者类型编码
	 * @param Sd_sfda_imprd_tp
	 */
	public void setSd_sfda_imprd_tp(String Sd_sfda_imprd_tp) {
		setAttrVal("Sd_sfda_imprd_tp", Sd_sfda_imprd_tp);
	}
	/**
	 * 发现人
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 发现人
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 发生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_occur() {
		return ((FDateTime) getAttrVal("Dt_occur"));
	}	
	/**
	 * 发生日期
	 * @param Dt_occur
	 */
	public void setDt_occur(FDateTime Dt_occur) {
		setAttrVal("Dt_occur", Dt_occur);
	}
	/**
	 * 发生部门
	 * @return String
	 */
	public String getId_dep_occur() {
		return ((String) getAttrVal("Id_dep_occur"));
	}	
	/**
	 * 发生部门
	 * @param Id_dep_occur
	 */
	public void setId_dep_occur(String Id_dep_occur) {
		setAttrVal("Id_dep_occur", Id_dep_occur);
	}
	/**
	 * 发生时间类型id
	 * @return String
	 */
	public String getId_occur_dttp() {
		return ((String) getAttrVal("Id_occur_dttp"));
	}	
	/**
	 * 发生时间类型id
	 * @param Id_occur_dttp
	 */
	public void setId_occur_dttp(String Id_occur_dttp) {
		setAttrVal("Id_occur_dttp", Id_occur_dttp);
	}
	/**
	 * 发生时间类型编码
	 * @return String
	 */
	public String getSd_occur_dttp() {
		return ((String) getAttrVal("Sd_occur_dttp"));
	}	
	/**
	 * 发生时间类型编码
	 * @param Sd_occur_dttp
	 */
	public void setSd_occur_dttp(String Sd_occur_dttp) {
		setAttrVal("Sd_occur_dttp", Sd_occur_dttp);
	}
	/**
	 * 发生地点id
	 * @return String
	 */
	public String getId_occur_adr() {
		return ((String) getAttrVal("Id_occur_adr"));
	}	
	/**
	 * 发生地点id
	 * @param Id_occur_adr
	 */
	public void setId_occur_adr(String Id_occur_adr) {
		setAttrVal("Id_occur_adr", Id_occur_adr);
	}
	/**
	 * 发生地点编码
	 * @return String
	 */
	public String getSd_occur_adr() {
		return ((String) getAttrVal("Sd_occur_adr"));
	}	
	/**
	 * 发生地点编码
	 * @param Sd_occur_adr
	 */
	public void setSd_occur_adr(String Sd_occur_adr) {
		setAttrVal("Sd_occur_adr", Sd_occur_adr);
	}
	/**
	 * 不良事件级别id
	 * @return String
	 */
	public String getId_ev_lvl() {
		return ((String) getAttrVal("Id_ev_lvl"));
	}	
	/**
	 * 不良事件级别id
	 * @param Id_ev_lvl
	 */
	public void setId_ev_lvl(String Id_ev_lvl) {
		setAttrVal("Id_ev_lvl", Id_ev_lvl);
	}
	/**
	 * 不良事件级别编码
	 * @return String
	 */
	public String getSd_ev_lvl() {
		return ((String) getAttrVal("Sd_ev_lvl"));
	}	
	/**
	 * 不良事件级别编码
	 * @param Sd_ev_lvl
	 */
	public void setSd_ev_lvl(String Sd_ev_lvl) {
		setAttrVal("Sd_ev_lvl", Sd_ev_lvl);
	}
	/**
	 * 伤害严重度id
	 * @return String
	 */
	public String getId_hurt_lvl() {
		return ((String) getAttrVal("Id_hurt_lvl"));
	}	
	/**
	 * 伤害严重度id
	 * @param Id_hurt_lvl
	 */
	public void setId_hurt_lvl(String Id_hurt_lvl) {
		setAttrVal("Id_hurt_lvl", Id_hurt_lvl);
	}
	/**
	 * 伤害严重度编码
	 * @return String
	 */
	public String getSd_hurt_lvl() {
		return ((String) getAttrVal("Sd_hurt_lvl"));
	}	
	/**
	 * 伤害严重度编码
	 * @param Sd_hurt_lvl
	 */
	public void setSd_hurt_lvl(String Sd_hurt_lvl) {
		setAttrVal("Sd_hurt_lvl", Sd_hurt_lvl);
	}
	/**
	 * 事件经过及详细信息
	 * @return String
	 */
	public String getEv_des() {
		return ((String) getAttrVal("Ev_des"));
	}	
	/**
	 * 事件经过及详细信息
	 * @param Ev_des
	 */
	public void setEv_des(String Ev_des) {
		setAttrVal("Ev_des", Ev_des);
	}
	/**
	 * 事件类别id
	 * @return String
	 */
	public String getId_ev_ca() {
		return ((String) getAttrVal("Id_ev_ca"));
	}	
	/**
	 * 事件类别id
	 * @param Id_ev_ca
	 */
	public void setId_ev_ca(String Id_ev_ca) {
		setAttrVal("Id_ev_ca", Id_ev_ca);
	}
	/**
	 * 事件类别编码
	 * @return String
	 */
	public String getSd_ev_ca() {
		return ((String) getAttrVal("Sd_ev_ca"));
	}	
	/**
	 * 事件类别编码
	 * @param Sd_ev_ca
	 */
	public void setSd_ev_ca(String Sd_ev_ca) {
		setAttrVal("Sd_ev_ca", Sd_ev_ca);
	}
	/**
	 * 诊断性检查
	 * @return Integer
	 */
	public Integer getEu_diag_ts() {
		return ((Integer) getAttrVal("Eu_diag_ts"));
	}	
	/**
	 * 诊断性检查
	 * @param Eu_diag_ts
	 */
	public void setEu_diag_ts(Integer Eu_diag_ts) {
		setAttrVal("Eu_diag_ts", Eu_diag_ts);
	}
	/**
	 * 诊断性检查描述
	 * @return String
	 */
	public String getDiag_ts_des() {
		return ((String) getAttrVal("Diag_ts_des"));
	}	
	/**
	 * 诊断性检查描述
	 * @param Diag_ts_des
	 */
	public void setDiag_ts_des(String Diag_ts_des) {
		setAttrVal("Diag_ts_des", Diag_ts_des);
	}
	/**
	 * 事件发生后的处理id
	 * @return String
	 */
	public String getId_ev_afhdle() {
		return ((String) getAttrVal("Id_ev_afhdle"));
	}	
	/**
	 * 事件发生后的处理id
	 * @param Id_ev_afhdle
	 */
	public void setId_ev_afhdle(String Id_ev_afhdle) {
		setAttrVal("Id_ev_afhdle", Id_ev_afhdle);
	}
	/**
	 * 事件发生后的处理编码
	 * @return String
	 */
	public String getSd_ev_afhdle() {
		return ((String) getAttrVal("Sd_ev_afhdle"));
	}	
	/**
	 * 事件发生后的处理编码
	 * @param Sd_ev_afhdle
	 */
	public void setSd_ev_afhdle(String Sd_ev_afhdle) {
		setAttrVal("Sd_ev_afhdle", Sd_ev_afhdle);
	}
	/**
	 * 事件发生后的处理描述
	 * @return String
	 */
	public String getEv_afhdle_des() {
		return ((String) getAttrVal("Ev_afhdle_des"));
	}	
	/**
	 * 事件发生后的处理描述
	 * @param Ev_afhdle_des
	 */
	public void setEv_afhdle_des(String Ev_afhdle_des) {
		setAttrVal("Ev_afhdle_des", Ev_afhdle_des);
	}
	/**
	 * 是否通知相关人员
	 * @return FBoolean
	 */
	public FBoolean getEu_notify_relpsn() {
		return ((FBoolean) getAttrVal("Eu_notify_relpsn"));
	}	
	/**
	 * 是否通知相关人员
	 * @param Eu_notify_relpsn
	 */
	public void setEu_notify_relpsn(FBoolean Eu_notify_relpsn) {
		setAttrVal("Eu_notify_relpsn", Eu_notify_relpsn);
	}
	/**
	 * 通知相关人员id
	 * @return String
	 */
	public String getId_notify_relpsn() {
		return ((String) getAttrVal("Id_notify_relpsn"));
	}	
	/**
	 * 通知相关人员id
	 * @param Id_notify_relpsn
	 */
	public void setId_notify_relpsn(String Id_notify_relpsn) {
		setAttrVal("Id_notify_relpsn", Id_notify_relpsn);
	}
	/**
	 * 通知相关人员编码
	 * @return String
	 */
	public String getSd_notify_relpsn() {
		return ((String) getAttrVal("Sd_notify_relpsn"));
	}	
	/**
	 * 通知相关人员编码
	 * @param Sd_notify_relpsn
	 */
	public void setSd_notify_relpsn(String Sd_notify_relpsn) {
		setAttrVal("Sd_notify_relpsn", Sd_notify_relpsn);
	}
	/**
	 * 通知相关人员内容
	 * @return String
	 */
	public String getContent_notify_relpsn() {
		return ((String) getAttrVal("Content_notify_relpsn"));
	}	
	/**
	 * 通知相关人员内容
	 * @param Content_notify_relpsn
	 */
	public void setContent_notify_relpsn(String Content_notify_relpsn) {
		setAttrVal("Content_notify_relpsn", Content_notify_relpsn);
	}
	/**
	 * 是否通知家属
	 * @return FBoolean
	 */
	public FBoolean getEu_notify_fam() {
		return ((FBoolean) getAttrVal("Eu_notify_fam"));
	}	
	/**
	 * 是否通知家属
	 * @param Eu_notify_fam
	 */
	public void setEu_notify_fam(FBoolean Eu_notify_fam) {
		setAttrVal("Eu_notify_fam", Eu_notify_fam);
	}
	/**
	 * 通知家属时间
	 * @return FDateTime
	 */
	public FDateTime getDt_notify_fam() {
		return ((FDateTime) getAttrVal("Dt_notify_fam"));
	}	
	/**
	 * 通知家属时间
	 * @param Dt_notify_fam
	 */
	public void setDt_notify_fam(FDateTime Dt_notify_fam) {
		setAttrVal("Dt_notify_fam", Dt_notify_fam);
	}
	/**
	 * 家属书否理解
	 * @return Integer
	 */
	public Integer getEu_fam_ud() {
		return ((Integer) getAttrVal("Eu_fam_ud"));
	}	
	/**
	 * 家属书否理解
	 * @param Eu_fam_ud
	 */
	public void setEu_fam_ud(Integer Eu_fam_ud) {
		setAttrVal("Eu_fam_ud", Eu_fam_ud);
	}
	/**
	 * 事件涉及类别
	 * @return FBoolean
	 */
	public FBoolean getEu_ev_reftp() {
		return ((FBoolean) getAttrVal("Eu_ev_reftp"));
	}	
	/**
	 * 事件涉及类别
	 * @param Eu_ev_reftp
	 */
	public void setEu_ev_reftp(FBoolean Eu_ev_reftp) {
		setAttrVal("Eu_ev_reftp", Eu_ev_reftp);
	}
	/**
	 * 事件状态
	 * @return String
	 */
	public String getEv_status() {
		return ((String) getAttrVal("Ev_status"));
	}	
	/**
	 * 事件状态
	 * @param Ev_status
	 */
	public void setEv_status(String Ev_status) {
		setAttrVal("Ev_status", Ev_status);
	}
	/**
	 * 当前处理节点
	 * @return String
	 */
	public String getCurr_node() {
		return ((String) getAttrVal("Curr_node"));
	}	
	/**
	 * 当前处理节点
	 * @param Curr_node
	 */
	public void setCurr_node(String Curr_node) {
		setAttrVal("Curr_node", Curr_node);
	}
	/**
	 * 当前处理者
	 * @return String
	 */
	public String getId_currhdl_user() {
		return ((String) getAttrVal("Id_currhdl_user"));
	}	
	/**
	 * 当前处理者
	 * @param Id_currhdl_user
	 */
	public void setId_currhdl_user(String Id_currhdl_user) {
		setAttrVal("Id_currhdl_user", Id_currhdl_user);
	}
	/**
	 * 处理期限
	 * @return FDouble
	 */
	public FDouble getHdl_limt() {
		return ((FDouble) getAttrVal("Hdl_limt"));
	}	
	/**
	 * 处理期限
	 * @param Hdl_limt
	 */
	public void setHdl_limt(FDouble Hdl_limt) {
		setAttrVal("Hdl_limt", Hdl_limt);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getExt4() {
		return ((String) getAttrVal("Ext4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ext4
	 */
	public void setExt4(String Ext4) {
		setAttrVal("Ext4", Ext4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getExt5() {
		return ((String) getAttrVal("Ext5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ext5
	 */
	public void setExt5(String Ext5) {
		setAttrVal("Ext5", Ext5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getExt6() {
		return ((String) getAttrVal("Ext6"));
	}	
	/**
	 * 扩展字段6
	 * @param Ext6
	 */
	public void setExt6(String Ext6) {
		setAttrVal("Ext6", Ext6);
	}
	/**
	 * 扩展字段7
	 * @return String
	 */
	public String getExt7() {
		return ((String) getAttrVal("Ext7"));
	}	
	/**
	 * 扩展字段7
	 * @param Ext7
	 */
	public void setExt7(String Ext7) {
		setAttrVal("Ext7", Ext7);
	}
	/**
	 * 扩展字段8
	 * @return String
	 */
	public String getExt8() {
		return ((String) getAttrVal("Ext8"));
	}	
	/**
	 * 扩展字段8
	 * @param Ext8
	 */
	public void setExt8(String Ext8) {
		setAttrVal("Ext8", Ext8);
	}
	/**
	 * 扩展字段9
	 * @return String
	 */
	public String getExt9() {
		return ((String) getAttrVal("Ext9"));
	}	
	/**
	 * 扩展字段9
	 * @param Ext9
	 */
	public void setExt9(String Ext9) {
		setAttrVal("Ext9", Ext9);
	}
	/**
	 * 扩展字段10
	 * @return String
	 */
	public String getExt10() {
		return ((String) getAttrVal("Ext10"));
	}	
	/**
	 * 扩展字段10
	 * @param Ext10
	 */
	public void setExt10(String Ext10) {
		setAttrVal("Ext10", Ext10);
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
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sfda_imprd_tp() {
		return ((String) getAttrVal("Name_sfda_imprd_tp"));
	}	
	/**
	 * 名称
	 * @param Name_sfda_imprd_tp
	 */
	public void setName_sfda_imprd_tp(String Name_sfda_imprd_tp) {
		setAttrVal("Name_sfda_imprd_tp", Name_sfda_imprd_tp);
	}
	/**
	 * 上报人
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 上报人
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 发生部门
	 * @return String
	 */
	public String getName_dep_occur() {
		return ((String) getAttrVal("Name_dep_occur"));
	}	
	/**
	 * 发生部门
	 * @param Name_dep_occur
	 */
	public void setName_dep_occur(String Name_dep_occur) {
		setAttrVal("Name_dep_occur", Name_dep_occur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_occur_dttp() {
		return ((String) getAttrVal("Name_occur_dttp"));
	}	
	/**
	 * 名称
	 * @param Name_occur_dttp
	 */
	public void setName_occur_dttp(String Name_occur_dttp) {
		setAttrVal("Name_occur_dttp", Name_occur_dttp);
	}
	/**
	 * 发生地点
	 * @return String
	 */
	public String getName_occur_adr() {
		return ((String) getAttrVal("Name_occur_adr"));
	}	
	/**
	 * 发生地点
	 * @param Name_occur_adr
	 */
	public void setName_occur_adr(String Name_occur_adr) {
		setAttrVal("Name_occur_adr", Name_occur_adr);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ev_lvl() {
		return ((String) getAttrVal("Name_ev_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_ev_lvl
	 */
	public void setName_ev_lvl(String Name_ev_lvl) {
		setAttrVal("Name_ev_lvl", Name_ev_lvl);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getDes_ev_lvl() {
		return ((String) getAttrVal("Des_ev_lvl"));
	}	
	/**
	 * 标准编码描述
	 * @param Des_ev_lvl
	 */
	public void setDes_ev_lvl(String Des_ev_lvl) {
		setAttrVal("Des_ev_lvl", Des_ev_lvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_hurt_lvl() {
		return ((String) getAttrVal("Name_hurt_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_hurt_lvl
	 */
	public void setName_hurt_lvl(String Name_hurt_lvl) {
		setAttrVal("Name_hurt_lvl", Name_hurt_lvl);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getDes_hurt_lvl() {
		return ((String) getAttrVal("Des_hurt_lvl"));
	}	
	/**
	 * 标准编码描述
	 * @param Des_hurt_lvl
	 */
	public void setDes_hurt_lvl(String Des_hurt_lvl) {
		setAttrVal("Des_hurt_lvl", Des_hurt_lvl);
	}
	/**
	 * 事件类别名称
	 * @return String
	 */
	public String getName_ev_ca() {
		return ((String) getAttrVal("Name_ev_ca"));
	}	
	/**
	 * 事件类别名称
	 * @param Name_ev_ca
	 */
	public void setName_ev_ca(String Name_ev_ca) {
		setAttrVal("Name_ev_ca", Name_ev_ca);
	}
	/**
	 * 事件发生后的处理
	 * @return String
	 */
	public String getName_ev_afhdle() {
		return ((String) getAttrVal("Name_ev_afhdle"));
	}	
	/**
	 * 事件发生后的处理
	 * @param Name_ev_afhdle
	 */
	public void setName_ev_afhdle(String Name_ev_afhdle) {
		setAttrVal("Name_ev_afhdle", Name_ev_afhdle);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_notify_relpsn() {
		return ((String) getAttrVal("Name_notify_relpsn"));
	}	
	/**
	 * 名称
	 * @param Name_notify_relpsn
	 */
	public void setName_notify_relpsn(String Name_notify_relpsn) {
		setAttrVal("Name_notify_relpsn", Name_notify_relpsn);
	}
	/**
	 * 用户
	 * @return String
	 */
	public String getName_currhdl_user() {
		return ((String) getAttrVal("Name_currhdl_user"));
	}	
	/**
	 * 用户
	 * @param Name_currhdl_user
	 */
	public void setName_currhdl_user(String Name_currhdl_user) {
		setAttrVal("Name_currhdl_user", Name_currhdl_user);
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
		return "Id_aer_ev";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvDODesc.class);
	}
	
}