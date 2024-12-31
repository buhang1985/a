package iih.sfda.aer.sfdaaerevmnoexpcst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmnoexpcst.d.desc.SfdaAerEvMNoexpCstDODesc;
import java.math.BigDecimal;

/**
 * 非预期心跳停止事件 DO数据 
 * 
 */
public class SfdaAerEvMNoexpCstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//非预期心跳停止主键
	public static final String ID_AER_EV_MNOEXPCST= "Id_aer_ev_mnoexpcst";
	//护理安全事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//病人原有之慢性疾病id
	public static final String ID_PAT_ORIGDIS= "Id_pat_origdis";
	//病人原有之慢性疾病编码
	public static final String SD_PAT_ORIGDIS= "Sd_pat_origdis";
	//病人原有之其他慢性疾病
	public static final String OTH_PAT_ORIGDIS= "Oth_pat_origdis";
	//发生急救事故的直接原因id
	public static final String ID_OCCUR_EMACC_REAS= "Id_occur_emacc_reas";
	//发生急救事故的直接原因编码
	public static final String SD_OCCUR_EMACC_REAS= "Sd_occur_emacc_reas";
	//发生急救事故的其他直接原因
	public static final String OTH_OCCUR_EMACC_REAS= "Oth_occur_emacc_reas";
	//目睹病人心跳停止
	public static final String WIT_PAT_CST= "Wit_pat_cst";
	//有无CPRid
	public static final String ID_HVNO_CPR= "Id_hvno_cpr";
	//有无CPR编码
	public static final String SD_HVNO_CPR= "Sd_hvno_cpr";
	//发生心肺停止是否为医师预期中
	public static final String EU_OCCUR_HLSTOP= "Eu_occur_hlstop";
	//最先被纪录到的心脏节律id
	public static final String ID_FIRT_HTRHY= "Id_firt_htrhy";
	//最先被纪录到的心脏节律编码
	public static final String SD_FIRT_HTRHY= "Sd_firt_htrhy";
	//最先被纪录到的其他心脏节律
	public static final String OTH_FIRT_HTRHY= "Oth_firt_htrhy";
	//是否恢复自发性循环
	public static final String EU_RECO_CYCLIC= "Eu_reco_cyclic";
	//停止CPR的原因id
	public static final String ID_STCPR_REAS= "Id_stcpr_reas";
	//停止CPR的原因编码
	public static final String SD_STCPR_REAS= "Sd_stcpr_reas";
	//急救后最终出院状态id
	public static final String ID_FIN_DISSTUS= "Id_fin_disstus";
	//急救后最终出院状态编码
	public static final String SD_FIN_DISSTUS= "Sd_fin_disstus";
	//急救后总住院日数
	public static final String TOT_IHOSP_NUM= "Tot_ihosp_num";
	//神经学状态id
	public static final String ID_NEUR_STATE= "Id_neur_state";
	//神经学状态编码
	public static final String SD_NEUR_STATE= "Sd_neur_state";
	//神经学状态具体描述
	public static final String NEUR_STATE_DES= "Neur_state_des";
	//请叙述事件经过
	public static final String NARR_EVE_PASS= "Narr_eve_pass";
	//发生本次事件的可能原因
	public static final String OCCUR_POSB_REAS= "Occur_posb_reas";
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
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_PAT_ORIGDIS= "Name_pat_origdis";
	//名称
	public static final String NAME_OCCUR_EMACC_REAS= "Name_occur_emacc_reas";
	//扩展字段1
	public static final String NAME_HVNO_CPR= "Name_hvno_cpr";
	//扩展字段1
	public static final String NAME_FIRT_HTRHY= "Name_firt_htrhy";
	//扩展字段1
	public static final String NAME_STCPR_REAS= "Name_stcpr_reas";
	//名称
	public static final String NAME_FIN_DISSTUS= "Name_fin_disstus";
	//名称
	public static final String NAME_NEUR_STATE= "Name_neur_state";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 非预期心跳停止主键
	 * @return String
	 */
	public String getId_aer_ev_mnoexpcst() {
		return ((String) getAttrVal("Id_aer_ev_mnoexpcst"));
	}	
	/**
	 * 非预期心跳停止主键
	 * @param Id_aer_ev_mnoexpcst
	 */
	public void setId_aer_ev_mnoexpcst(String Id_aer_ev_mnoexpcst) {
		setAttrVal("Id_aer_ev_mnoexpcst", Id_aer_ev_mnoexpcst);
	}
	/**
	 * 护理安全事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 护理安全事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 病人原有之慢性疾病id
	 * @return String
	 */
	public String getId_pat_origdis() {
		return ((String) getAttrVal("Id_pat_origdis"));
	}	
	/**
	 * 病人原有之慢性疾病id
	 * @param Id_pat_origdis
	 */
	public void setId_pat_origdis(String Id_pat_origdis) {
		setAttrVal("Id_pat_origdis", Id_pat_origdis);
	}
	/**
	 * 病人原有之慢性疾病编码
	 * @return String
	 */
	public String getSd_pat_origdis() {
		return ((String) getAttrVal("Sd_pat_origdis"));
	}	
	/**
	 * 病人原有之慢性疾病编码
	 * @param Sd_pat_origdis
	 */
	public void setSd_pat_origdis(String Sd_pat_origdis) {
		setAttrVal("Sd_pat_origdis", Sd_pat_origdis);
	}
	/**
	 * 病人原有之其他慢性疾病
	 * @return String
	 */
	public String getOth_pat_origdis() {
		return ((String) getAttrVal("Oth_pat_origdis"));
	}	
	/**
	 * 病人原有之其他慢性疾病
	 * @param Oth_pat_origdis
	 */
	public void setOth_pat_origdis(String Oth_pat_origdis) {
		setAttrVal("Oth_pat_origdis", Oth_pat_origdis);
	}
	/**
	 * 发生急救事故的直接原因id
	 * @return String
	 */
	public String getId_occur_emacc_reas() {
		return ((String) getAttrVal("Id_occur_emacc_reas"));
	}	
	/**
	 * 发生急救事故的直接原因id
	 * @param Id_occur_emacc_reas
	 */
	public void setId_occur_emacc_reas(String Id_occur_emacc_reas) {
		setAttrVal("Id_occur_emacc_reas", Id_occur_emacc_reas);
	}
	/**
	 * 发生急救事故的直接原因编码
	 * @return String
	 */
	public String getSd_occur_emacc_reas() {
		return ((String) getAttrVal("Sd_occur_emacc_reas"));
	}	
	/**
	 * 发生急救事故的直接原因编码
	 * @param Sd_occur_emacc_reas
	 */
	public void setSd_occur_emacc_reas(String Sd_occur_emacc_reas) {
		setAttrVal("Sd_occur_emacc_reas", Sd_occur_emacc_reas);
	}
	/**
	 * 发生急救事故的其他直接原因
	 * @return String
	 */
	public String getOth_occur_emacc_reas() {
		return ((String) getAttrVal("Oth_occur_emacc_reas"));
	}	
	/**
	 * 发生急救事故的其他直接原因
	 * @param Oth_occur_emacc_reas
	 */
	public void setOth_occur_emacc_reas(String Oth_occur_emacc_reas) {
		setAttrVal("Oth_occur_emacc_reas", Oth_occur_emacc_reas);
	}
	/**
	 * 目睹病人心跳停止
	 * @return String
	 */
	public String getWit_pat_cst() {
		return ((String) getAttrVal("Wit_pat_cst"));
	}	
	/**
	 * 目睹病人心跳停止
	 * @param Wit_pat_cst
	 */
	public void setWit_pat_cst(String Wit_pat_cst) {
		setAttrVal("Wit_pat_cst", Wit_pat_cst);
	}
	/**
	 * 有无CPRid
	 * @return String
	 */
	public String getId_hvno_cpr() {
		return ((String) getAttrVal("Id_hvno_cpr"));
	}	
	/**
	 * 有无CPRid
	 * @param Id_hvno_cpr
	 */
	public void setId_hvno_cpr(String Id_hvno_cpr) {
		setAttrVal("Id_hvno_cpr", Id_hvno_cpr);
	}
	/**
	 * 有无CPR编码
	 * @return String
	 */
	public String getSd_hvno_cpr() {
		return ((String) getAttrVal("Sd_hvno_cpr"));
	}	
	/**
	 * 有无CPR编码
	 * @param Sd_hvno_cpr
	 */
	public void setSd_hvno_cpr(String Sd_hvno_cpr) {
		setAttrVal("Sd_hvno_cpr", Sd_hvno_cpr);
	}
	/**
	 * 发生心肺停止是否为医师预期中
	 * @return Integer
	 */
	public Integer getEu_occur_hlstop() {
		return ((Integer) getAttrVal("Eu_occur_hlstop"));
	}	
	/**
	 * 发生心肺停止是否为医师预期中
	 * @param Eu_occur_hlstop
	 */
	public void setEu_occur_hlstop(Integer Eu_occur_hlstop) {
		setAttrVal("Eu_occur_hlstop", Eu_occur_hlstop);
	}
	/**
	 * 最先被纪录到的心脏节律id
	 * @return String
	 */
	public String getId_firt_htrhy() {
		return ((String) getAttrVal("Id_firt_htrhy"));
	}	
	/**
	 * 最先被纪录到的心脏节律id
	 * @param Id_firt_htrhy
	 */
	public void setId_firt_htrhy(String Id_firt_htrhy) {
		setAttrVal("Id_firt_htrhy", Id_firt_htrhy);
	}
	/**
	 * 最先被纪录到的心脏节律编码
	 * @return String
	 */
	public String getSd_firt_htrhy() {
		return ((String) getAttrVal("Sd_firt_htrhy"));
	}	
	/**
	 * 最先被纪录到的心脏节律编码
	 * @param Sd_firt_htrhy
	 */
	public void setSd_firt_htrhy(String Sd_firt_htrhy) {
		setAttrVal("Sd_firt_htrhy", Sd_firt_htrhy);
	}
	/**
	 * 最先被纪录到的其他心脏节律
	 * @return String
	 */
	public String getOth_firt_htrhy() {
		return ((String) getAttrVal("Oth_firt_htrhy"));
	}	
	/**
	 * 最先被纪录到的其他心脏节律
	 * @param Oth_firt_htrhy
	 */
	public void setOth_firt_htrhy(String Oth_firt_htrhy) {
		setAttrVal("Oth_firt_htrhy", Oth_firt_htrhy);
	}
	/**
	 * 是否恢复自发性循环
	 * @return Integer
	 */
	public Integer getEu_reco_cyclic() {
		return ((Integer) getAttrVal("Eu_reco_cyclic"));
	}	
	/**
	 * 是否恢复自发性循环
	 * @param Eu_reco_cyclic
	 */
	public void setEu_reco_cyclic(Integer Eu_reco_cyclic) {
		setAttrVal("Eu_reco_cyclic", Eu_reco_cyclic);
	}
	/**
	 * 停止CPR的原因id
	 * @return String
	 */
	public String getId_stcpr_reas() {
		return ((String) getAttrVal("Id_stcpr_reas"));
	}	
	/**
	 * 停止CPR的原因id
	 * @param Id_stcpr_reas
	 */
	public void setId_stcpr_reas(String Id_stcpr_reas) {
		setAttrVal("Id_stcpr_reas", Id_stcpr_reas);
	}
	/**
	 * 停止CPR的原因编码
	 * @return String
	 */
	public String getSd_stcpr_reas() {
		return ((String) getAttrVal("Sd_stcpr_reas"));
	}	
	/**
	 * 停止CPR的原因编码
	 * @param Sd_stcpr_reas
	 */
	public void setSd_stcpr_reas(String Sd_stcpr_reas) {
		setAttrVal("Sd_stcpr_reas", Sd_stcpr_reas);
	}
	/**
	 * 急救后最终出院状态id
	 * @return String
	 */
	public String getId_fin_disstus() {
		return ((String) getAttrVal("Id_fin_disstus"));
	}	
	/**
	 * 急救后最终出院状态id
	 * @param Id_fin_disstus
	 */
	public void setId_fin_disstus(String Id_fin_disstus) {
		setAttrVal("Id_fin_disstus", Id_fin_disstus);
	}
	/**
	 * 急救后最终出院状态编码
	 * @return String
	 */
	public String getSd_fin_disstus() {
		return ((String) getAttrVal("Sd_fin_disstus"));
	}	
	/**
	 * 急救后最终出院状态编码
	 * @param Sd_fin_disstus
	 */
	public void setSd_fin_disstus(String Sd_fin_disstus) {
		setAttrVal("Sd_fin_disstus", Sd_fin_disstus);
	}
	/**
	 * 急救后总住院日数
	 * @return Integer
	 */
	public Integer getTot_ihosp_num() {
		return ((Integer) getAttrVal("Tot_ihosp_num"));
	}	
	/**
	 * 急救后总住院日数
	 * @param Tot_ihosp_num
	 */
	public void setTot_ihosp_num(Integer Tot_ihosp_num) {
		setAttrVal("Tot_ihosp_num", Tot_ihosp_num);
	}
	/**
	 * 神经学状态id
	 * @return String
	 */
	public String getId_neur_state() {
		return ((String) getAttrVal("Id_neur_state"));
	}	
	/**
	 * 神经学状态id
	 * @param Id_neur_state
	 */
	public void setId_neur_state(String Id_neur_state) {
		setAttrVal("Id_neur_state", Id_neur_state);
	}
	/**
	 * 神经学状态编码
	 * @return String
	 */
	public String getSd_neur_state() {
		return ((String) getAttrVal("Sd_neur_state"));
	}	
	/**
	 * 神经学状态编码
	 * @param Sd_neur_state
	 */
	public void setSd_neur_state(String Sd_neur_state) {
		setAttrVal("Sd_neur_state", Sd_neur_state);
	}
	/**
	 * 神经学状态具体描述
	 * @return String
	 */
	public String getNeur_state_des() {
		return ((String) getAttrVal("Neur_state_des"));
	}	
	/**
	 * 神经学状态具体描述
	 * @param Neur_state_des
	 */
	public void setNeur_state_des(String Neur_state_des) {
		setAttrVal("Neur_state_des", Neur_state_des);
	}
	/**
	 * 请叙述事件经过
	 * @return String
	 */
	public String getNarr_eve_pass() {
		return ((String) getAttrVal("Narr_eve_pass"));
	}	
	/**
	 * 请叙述事件经过
	 * @param Narr_eve_pass
	 */
	public void setNarr_eve_pass(String Narr_eve_pass) {
		setAttrVal("Narr_eve_pass", Narr_eve_pass);
	}
	/**
	 * 发生本次事件的可能原因
	 * @return String
	 */
	public String getOccur_posb_reas() {
		return ((String) getAttrVal("Occur_posb_reas"));
	}	
	/**
	 * 发生本次事件的可能原因
	 * @param Occur_posb_reas
	 */
	public void setOccur_posb_reas(String Occur_posb_reas) {
		setAttrVal("Occur_posb_reas", Occur_posb_reas);
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
	 * 名称
	 * @return String
	 */
	public String getName_pat_origdis() {
		return ((String) getAttrVal("Name_pat_origdis"));
	}	
	/**
	 * 名称
	 * @param Name_pat_origdis
	 */
	public void setName_pat_origdis(String Name_pat_origdis) {
		setAttrVal("Name_pat_origdis", Name_pat_origdis);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_occur_emacc_reas() {
		return ((String) getAttrVal("Name_occur_emacc_reas"));
	}	
	/**
	 * 名称
	 * @param Name_occur_emacc_reas
	 */
	public void setName_occur_emacc_reas(String Name_occur_emacc_reas) {
		setAttrVal("Name_occur_emacc_reas", Name_occur_emacc_reas);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_hvno_cpr() {
		return ((String) getAttrVal("Name_hvno_cpr"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_hvno_cpr
	 */
	public void setName_hvno_cpr(String Name_hvno_cpr) {
		setAttrVal("Name_hvno_cpr", Name_hvno_cpr);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_firt_htrhy() {
		return ((String) getAttrVal("Name_firt_htrhy"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_firt_htrhy
	 */
	public void setName_firt_htrhy(String Name_firt_htrhy) {
		setAttrVal("Name_firt_htrhy", Name_firt_htrhy);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_stcpr_reas() {
		return ((String) getAttrVal("Name_stcpr_reas"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_stcpr_reas
	 */
	public void setName_stcpr_reas(String Name_stcpr_reas) {
		setAttrVal("Name_stcpr_reas", Name_stcpr_reas);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fin_disstus() {
		return ((String) getAttrVal("Name_fin_disstus"));
	}	
	/**
	 * 名称
	 * @param Name_fin_disstus
	 */
	public void setName_fin_disstus(String Name_fin_disstus) {
		setAttrVal("Name_fin_disstus", Name_fin_disstus);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_neur_state() {
		return ((String) getAttrVal("Name_neur_state"));
	}	
	/**
	 * 名称
	 * @param Name_neur_state
	 */
	public void setName_neur_state(String Name_neur_state) {
		setAttrVal("Name_neur_state", Name_neur_state);
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
		return "Id_aer_ev_mnoexpcst";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_MNOEXPCST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMNoexpCstDODesc.class);
	}
	
}