package iih.sfda.aer.sfdaaerevps.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevps.d.desc.SfdaAerEvPsDODesc;
import java.math.BigDecimal;

/**
 * 压疮事件 DO数据 
 * 
 */
public class SfdaAerEvPsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//压疮事件主键
	public static final String ID_AER_EV_PS= "Id_aer_ev_ps";
	//护理安全外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//压疮上报类型id
	public static final String ID_PSRPT_TP= "Id_psrpt_tp";
	//压疮上报类型
	public static final String SD_PSRPT_TP= "Sd_psrpt_tp";
	//压疮评估表id
	public static final String ID_PSASS= "Id_psass";
	//压疮评估表
	public static final String SD_PSASS= "Sd_psass";
	//压疮发生时间
	public static final String DT_OCCUR= "Dt_occur";
	//压疮发现时间
	public static final String DT_FIND= "Dt_find";
	//压疮干预措施id
	public static final String ID_PSIN_MS= "Id_psin_ms";
	//压疮干预措施
	public static final String SD_PSIN_MS= "Sd_psin_ms";
	//压疮其他干预措施
	public static final String OTH_PSIN_MS= "Oth_psin_ms";
	//感知能力id
	public static final String ID_FEEL_PW= "Id_feel_pw";
	//感知能力
	public static final String SD_FEEL_PW= "Sd_feel_pw";
	//感知能力分数
	public static final String OTH_FEEL_PW= "Oth_feel_pw";
	//潮湿度id
	public static final String ID_HMD= "Id_hmd";
	//潮湿度
	public static final String SD_HMD= "Sd_hmd";
	//潮湿度分数
	public static final String OTH_HMD= "Oth_hmd";
	//活动能力id
	public static final String ID_ACT_PW= "Id_act_pw";
	//活动能力
	public static final String SD_ACT_PW= "Sd_act_pw";
	//活动能力分数
	public static final String OTH_ACT_PW= "Oth_act_pw";
	//移动能力id
	public static final String ID_MOVE_PW= "Id_move_pw";
	//移动能力
	public static final String SD_MOVE_PW= "Sd_move_pw";
	//移动能力分数
	public static final String OTH_MOVE_PW= "Oth_move_pw";
	//营养支持id
	public static final String ID_NTR_SPT= "Id_ntr_spt";
	//营养支持
	public static final String SD_NTR_SPT= "Sd_ntr_spt";
	//营养支持分数
	public static final String OTH_NTR_SPT= "Oth_ntr_spt";
	//摩擦力和剪切力id
	public static final String ID_FCEFR= "Id_fcefr";
	//摩擦力和剪切力
	public static final String SD_FCEFR= "Sd_fcefr";
	//摩擦力和剪切力分数
	public static final String OTH_FCEFR= "Oth_fcefr";
	//评分总分
	public static final String TOT_SCORE= "Tot_score";
	//组织灌注氧合id
	public static final String ID_OXY= "Id_oxy";
	//组织灌注氧合
	public static final String SD_OXY= "Sd_oxy";
	//组织灌注氧合分数
	public static final String OTH_OXY= "Oth_oxy";
	//一般情况id
	public static final String ID_GRLC= "Id_grlc";
	//一般情况
	public static final String SD_GRLC= "Sd_grlc";
	//一般情况分数
	public static final String OTH_GRLC= "Oth_grlc";
	//患者压疮来源
	public static final String EU_PS_SUR= "Eu_ps_sur";
	//压疮分期id
	public static final String ID_PS_STG= "Id_ps_stg";
	//压疮分期
	public static final String SD_PS_STG= "Sd_ps_stg";
	//入院前已有压疮来源id
	public static final String ID_OLDPS_SUR= "Id_oldps_sur";
	//入院前已有压疮来源
	public static final String SD_OLDPS_SUR= "Sd_oldps_sur";
	//压疮部位id
	public static final String ID_PS_PTY= "Id_ps_pty";
	//压疮部位
	public static final String SD_PS_PTY= "Sd_ps_pty";
	//压疮其他部位
	public static final String OTH_PS_PTY= "Oth_ps_pty";
	//压疮面积
	public static final String AREA_PS= "Area_ps";
	//压疮性质id
	public static final String ID_PS_NT= "Id_ps_nt";
	//压疮性质
	public static final String SD_PS_NT= "Sd_ps_nt";
	//是否有人看护
	public static final String FG_SMO_WTH= "Fg_smo_wth";
	//是否入住ICU
	public static final String FG_IN_ICU= "Fg_in_icu";
	//是否填报过高危压疮或难免压疮
	public static final String FG_FILL_PS= "Fg_fill_ps";
	//是否手术
	public static final String FG_SUG= "Fg_sug";
	//手术时间
	public static final String DT_SUG= "Dt_sug";
	//术中麻醉id
	public static final String ID_SUG_NRS= "Id_sug_nrs";
	//术中麻醉
	public static final String SD_SUG_NRS= "Sd_sug_nrs";
	//手术体位id
	public static final String ID_SUG_PTY= "Id_sug_pty";
	//手术体位
	public static final String SD_SUG_PTY= "Sd_sug_pty";
	//其他手术体位
	public static final String OTR_SUG_PTY= "Otr_sug_pty";
	//是否请压疮会诊
	public static final String FG_PS_CS= "Fg_ps_cs";
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
	public static final String NAME_PSRPT_TP= "Name_psrpt_tp";
	//名称
	public static final String NAME_PSASS= "Name_psass";
	//名称
	public static final String NAME_PSIN_MS= "Name_psin_ms";
	//名称
	public static final String NAME_FEEL_PW= "Name_feel_pw";
	//名称
	public static final String NAME_HMD= "Name_hmd";
	//名称
	public static final String NAME_ACT_PW= "Name_act_pw";
	//名称
	public static final String NAME_MOVE_PW= "Name_move_pw";
	//名称
	public static final String NAME_NTR_SPT= "Name_ntr_spt";
	//名称
	public static final String NAME_FCEFR= "Name_fcefr";
	//名称
	public static final String NAME_OXY= "Name_oxy";
	//名称
	public static final String NAME_GRLC= "Name_grlc";
	//名称
	public static final String NAME_PS_STG= "Name_ps_stg";
	//名称
	public static final String NAME_OLDPS_SUR= "Name_oldps_sur";
	//名称
	public static final String NAME_PS_PTY= "Name_ps_pty";
	//名称
	public static final String NAME_PS_NT= "Name_ps_nt";
	//名称
	public static final String NAME_SUG_NRS= "Name_sug_nrs";
	//名称
	public static final String NAME_SUG_PTY= "Name_sug_pty";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 压疮事件主键
	 * @return String
	 */
	public String getId_aer_ev_ps() {
		return ((String) getAttrVal("Id_aer_ev_ps"));
	}	
	/**
	 * 压疮事件主键
	 * @param Id_aer_ev_ps
	 */
	public void setId_aer_ev_ps(String Id_aer_ev_ps) {
		setAttrVal("Id_aer_ev_ps", Id_aer_ev_ps);
	}
	/**
	 * 护理安全外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 护理安全外键
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
	 * 压疮上报类型id
	 * @return String
	 */
	public String getId_psrpt_tp() {
		return ((String) getAttrVal("Id_psrpt_tp"));
	}	
	/**
	 * 压疮上报类型id
	 * @param Id_psrpt_tp
	 */
	public void setId_psrpt_tp(String Id_psrpt_tp) {
		setAttrVal("Id_psrpt_tp", Id_psrpt_tp);
	}
	/**
	 * 压疮上报类型
	 * @return String
	 */
	public String getSd_psrpt_tp() {
		return ((String) getAttrVal("Sd_psrpt_tp"));
	}	
	/**
	 * 压疮上报类型
	 * @param Sd_psrpt_tp
	 */
	public void setSd_psrpt_tp(String Sd_psrpt_tp) {
		setAttrVal("Sd_psrpt_tp", Sd_psrpt_tp);
	}
	/**
	 * 压疮评估表id
	 * @return String
	 */
	public String getId_psass() {
		return ((String) getAttrVal("Id_psass"));
	}	
	/**
	 * 压疮评估表id
	 * @param Id_psass
	 */
	public void setId_psass(String Id_psass) {
		setAttrVal("Id_psass", Id_psass);
	}
	/**
	 * 压疮评估表
	 * @return String
	 */
	public String getSd_psass() {
		return ((String) getAttrVal("Sd_psass"));
	}	
	/**
	 * 压疮评估表
	 * @param Sd_psass
	 */
	public void setSd_psass(String Sd_psass) {
		setAttrVal("Sd_psass", Sd_psass);
	}
	/**
	 * 压疮发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_occur() {
		return ((FDateTime) getAttrVal("Dt_occur"));
	}	
	/**
	 * 压疮发生时间
	 * @param Dt_occur
	 */
	public void setDt_occur(FDateTime Dt_occur) {
		setAttrVal("Dt_occur", Dt_occur);
	}
	/**
	 * 压疮发现时间
	 * @return FDateTime
	 */
	public FDateTime getDt_find() {
		return ((FDateTime) getAttrVal("Dt_find"));
	}	
	/**
	 * 压疮发现时间
	 * @param Dt_find
	 */
	public void setDt_find(FDateTime Dt_find) {
		setAttrVal("Dt_find", Dt_find);
	}
	/**
	 * 压疮干预措施id
	 * @return String
	 */
	public String getId_psin_ms() {
		return ((String) getAttrVal("Id_psin_ms"));
	}	
	/**
	 * 压疮干预措施id
	 * @param Id_psin_ms
	 */
	public void setId_psin_ms(String Id_psin_ms) {
		setAttrVal("Id_psin_ms", Id_psin_ms);
	}
	/**
	 * 压疮干预措施
	 * @return String
	 */
	public String getSd_psin_ms() {
		return ((String) getAttrVal("Sd_psin_ms"));
	}	
	/**
	 * 压疮干预措施
	 * @param Sd_psin_ms
	 */
	public void setSd_psin_ms(String Sd_psin_ms) {
		setAttrVal("Sd_psin_ms", Sd_psin_ms);
	}
	/**
	 * 压疮其他干预措施
	 * @return String
	 */
	public String getOth_psin_ms() {
		return ((String) getAttrVal("Oth_psin_ms"));
	}	
	/**
	 * 压疮其他干预措施
	 * @param Oth_psin_ms
	 */
	public void setOth_psin_ms(String Oth_psin_ms) {
		setAttrVal("Oth_psin_ms", Oth_psin_ms);
	}
	/**
	 * 感知能力id
	 * @return String
	 */
	public String getId_feel_pw() {
		return ((String) getAttrVal("Id_feel_pw"));
	}	
	/**
	 * 感知能力id
	 * @param Id_feel_pw
	 */
	public void setId_feel_pw(String Id_feel_pw) {
		setAttrVal("Id_feel_pw", Id_feel_pw);
	}
	/**
	 * 感知能力
	 * @return String
	 */
	public String getSd_feel_pw() {
		return ((String) getAttrVal("Sd_feel_pw"));
	}	
	/**
	 * 感知能力
	 * @param Sd_feel_pw
	 */
	public void setSd_feel_pw(String Sd_feel_pw) {
		setAttrVal("Sd_feel_pw", Sd_feel_pw);
	}
	/**
	 * 感知能力分数
	 * @return Integer
	 */
	public Integer getOth_feel_pw() {
		return ((Integer) getAttrVal("Oth_feel_pw"));
	}	
	/**
	 * 感知能力分数
	 * @param Oth_feel_pw
	 */
	public void setOth_feel_pw(Integer Oth_feel_pw) {
		setAttrVal("Oth_feel_pw", Oth_feel_pw);
	}
	/**
	 * 潮湿度id
	 * @return String
	 */
	public String getId_hmd() {
		return ((String) getAttrVal("Id_hmd"));
	}	
	/**
	 * 潮湿度id
	 * @param Id_hmd
	 */
	public void setId_hmd(String Id_hmd) {
		setAttrVal("Id_hmd", Id_hmd);
	}
	/**
	 * 潮湿度
	 * @return String
	 */
	public String getSd_hmd() {
		return ((String) getAttrVal("Sd_hmd"));
	}	
	/**
	 * 潮湿度
	 * @param Sd_hmd
	 */
	public void setSd_hmd(String Sd_hmd) {
		setAttrVal("Sd_hmd", Sd_hmd);
	}
	/**
	 * 潮湿度分数
	 * @return Integer
	 */
	public Integer getOth_hmd() {
		return ((Integer) getAttrVal("Oth_hmd"));
	}	
	/**
	 * 潮湿度分数
	 * @param Oth_hmd
	 */
	public void setOth_hmd(Integer Oth_hmd) {
		setAttrVal("Oth_hmd", Oth_hmd);
	}
	/**
	 * 活动能力id
	 * @return String
	 */
	public String getId_act_pw() {
		return ((String) getAttrVal("Id_act_pw"));
	}	
	/**
	 * 活动能力id
	 * @param Id_act_pw
	 */
	public void setId_act_pw(String Id_act_pw) {
		setAttrVal("Id_act_pw", Id_act_pw);
	}
	/**
	 * 活动能力
	 * @return String
	 */
	public String getSd_act_pw() {
		return ((String) getAttrVal("Sd_act_pw"));
	}	
	/**
	 * 活动能力
	 * @param Sd_act_pw
	 */
	public void setSd_act_pw(String Sd_act_pw) {
		setAttrVal("Sd_act_pw", Sd_act_pw);
	}
	/**
	 * 活动能力分数
	 * @return Integer
	 */
	public Integer getOth_act_pw() {
		return ((Integer) getAttrVal("Oth_act_pw"));
	}	
	/**
	 * 活动能力分数
	 * @param Oth_act_pw
	 */
	public void setOth_act_pw(Integer Oth_act_pw) {
		setAttrVal("Oth_act_pw", Oth_act_pw);
	}
	/**
	 * 移动能力id
	 * @return String
	 */
	public String getId_move_pw() {
		return ((String) getAttrVal("Id_move_pw"));
	}	
	/**
	 * 移动能力id
	 * @param Id_move_pw
	 */
	public void setId_move_pw(String Id_move_pw) {
		setAttrVal("Id_move_pw", Id_move_pw);
	}
	/**
	 * 移动能力
	 * @return String
	 */
	public String getSd_move_pw() {
		return ((String) getAttrVal("Sd_move_pw"));
	}	
	/**
	 * 移动能力
	 * @param Sd_move_pw
	 */
	public void setSd_move_pw(String Sd_move_pw) {
		setAttrVal("Sd_move_pw", Sd_move_pw);
	}
	/**
	 * 移动能力分数
	 * @return Integer
	 */
	public Integer getOth_move_pw() {
		return ((Integer) getAttrVal("Oth_move_pw"));
	}	
	/**
	 * 移动能力分数
	 * @param Oth_move_pw
	 */
	public void setOth_move_pw(Integer Oth_move_pw) {
		setAttrVal("Oth_move_pw", Oth_move_pw);
	}
	/**
	 * 营养支持id
	 * @return String
	 */
	public String getId_ntr_spt() {
		return ((String) getAttrVal("Id_ntr_spt"));
	}	
	/**
	 * 营养支持id
	 * @param Id_ntr_spt
	 */
	public void setId_ntr_spt(String Id_ntr_spt) {
		setAttrVal("Id_ntr_spt", Id_ntr_spt);
	}
	/**
	 * 营养支持
	 * @return String
	 */
	public String getSd_ntr_spt() {
		return ((String) getAttrVal("Sd_ntr_spt"));
	}	
	/**
	 * 营养支持
	 * @param Sd_ntr_spt
	 */
	public void setSd_ntr_spt(String Sd_ntr_spt) {
		setAttrVal("Sd_ntr_spt", Sd_ntr_spt);
	}
	/**
	 * 营养支持分数
	 * @return Integer
	 */
	public Integer getOth_ntr_spt() {
		return ((Integer) getAttrVal("Oth_ntr_spt"));
	}	
	/**
	 * 营养支持分数
	 * @param Oth_ntr_spt
	 */
	public void setOth_ntr_spt(Integer Oth_ntr_spt) {
		setAttrVal("Oth_ntr_spt", Oth_ntr_spt);
	}
	/**
	 * 摩擦力和剪切力id
	 * @return String
	 */
	public String getId_fcefr() {
		return ((String) getAttrVal("Id_fcefr"));
	}	
	/**
	 * 摩擦力和剪切力id
	 * @param Id_fcefr
	 */
	public void setId_fcefr(String Id_fcefr) {
		setAttrVal("Id_fcefr", Id_fcefr);
	}
	/**
	 * 摩擦力和剪切力
	 * @return String
	 */
	public String getSd_fcefr() {
		return ((String) getAttrVal("Sd_fcefr"));
	}	
	/**
	 * 摩擦力和剪切力
	 * @param Sd_fcefr
	 */
	public void setSd_fcefr(String Sd_fcefr) {
		setAttrVal("Sd_fcefr", Sd_fcefr);
	}
	/**
	 * 摩擦力和剪切力分数
	 * @return Integer
	 */
	public Integer getOth_fcefr() {
		return ((Integer) getAttrVal("Oth_fcefr"));
	}	
	/**
	 * 摩擦力和剪切力分数
	 * @param Oth_fcefr
	 */
	public void setOth_fcefr(Integer Oth_fcefr) {
		setAttrVal("Oth_fcefr", Oth_fcefr);
	}
	/**
	 * 评分总分
	 * @return Integer
	 */
	public Integer getTot_score() {
		return ((Integer) getAttrVal("Tot_score"));
	}	
	/**
	 * 评分总分
	 * @param Tot_score
	 */
	public void setTot_score(Integer Tot_score) {
		setAttrVal("Tot_score", Tot_score);
	}
	/**
	 * 组织灌注氧合id
	 * @return String
	 */
	public String getId_oxy() {
		return ((String) getAttrVal("Id_oxy"));
	}	
	/**
	 * 组织灌注氧合id
	 * @param Id_oxy
	 */
	public void setId_oxy(String Id_oxy) {
		setAttrVal("Id_oxy", Id_oxy);
	}
	/**
	 * 组织灌注氧合
	 * @return String
	 */
	public String getSd_oxy() {
		return ((String) getAttrVal("Sd_oxy"));
	}	
	/**
	 * 组织灌注氧合
	 * @param Sd_oxy
	 */
	public void setSd_oxy(String Sd_oxy) {
		setAttrVal("Sd_oxy", Sd_oxy);
	}
	/**
	 * 组织灌注氧合分数
	 * @return Integer
	 */
	public Integer getOth_oxy() {
		return ((Integer) getAttrVal("Oth_oxy"));
	}	
	/**
	 * 组织灌注氧合分数
	 * @param Oth_oxy
	 */
	public void setOth_oxy(Integer Oth_oxy) {
		setAttrVal("Oth_oxy", Oth_oxy);
	}
	/**
	 * 一般情况id
	 * @return String
	 */
	public String getId_grlc() {
		return ((String) getAttrVal("Id_grlc"));
	}	
	/**
	 * 一般情况id
	 * @param Id_grlc
	 */
	public void setId_grlc(String Id_grlc) {
		setAttrVal("Id_grlc", Id_grlc);
	}
	/**
	 * 一般情况
	 * @return String
	 */
	public String getSd_grlc() {
		return ((String) getAttrVal("Sd_grlc"));
	}	
	/**
	 * 一般情况
	 * @param Sd_grlc
	 */
	public void setSd_grlc(String Sd_grlc) {
		setAttrVal("Sd_grlc", Sd_grlc);
	}
	/**
	 * 一般情况分数
	 * @return Integer
	 */
	public Integer getOth_grlc() {
		return ((Integer) getAttrVal("Oth_grlc"));
	}	
	/**
	 * 一般情况分数
	 * @param Oth_grlc
	 */
	public void setOth_grlc(Integer Oth_grlc) {
		setAttrVal("Oth_grlc", Oth_grlc);
	}
	/**
	 * 患者压疮来源
	 * @return Integer
	 */
	public Integer getEu_ps_sur() {
		return ((Integer) getAttrVal("Eu_ps_sur"));
	}	
	/**
	 * 患者压疮来源
	 * @param Eu_ps_sur
	 */
	public void setEu_ps_sur(Integer Eu_ps_sur) {
		setAttrVal("Eu_ps_sur", Eu_ps_sur);
	}
	/**
	 * 压疮分期id
	 * @return String
	 */
	public String getId_ps_stg() {
		return ((String) getAttrVal("Id_ps_stg"));
	}	
	/**
	 * 压疮分期id
	 * @param Id_ps_stg
	 */
	public void setId_ps_stg(String Id_ps_stg) {
		setAttrVal("Id_ps_stg", Id_ps_stg);
	}
	/**
	 * 压疮分期
	 * @return String
	 */
	public String getSd_ps_stg() {
		return ((String) getAttrVal("Sd_ps_stg"));
	}	
	/**
	 * 压疮分期
	 * @param Sd_ps_stg
	 */
	public void setSd_ps_stg(String Sd_ps_stg) {
		setAttrVal("Sd_ps_stg", Sd_ps_stg);
	}
	/**
	 * 入院前已有压疮来源id
	 * @return String
	 */
	public String getId_oldps_sur() {
		return ((String) getAttrVal("Id_oldps_sur"));
	}	
	/**
	 * 入院前已有压疮来源id
	 * @param Id_oldps_sur
	 */
	public void setId_oldps_sur(String Id_oldps_sur) {
		setAttrVal("Id_oldps_sur", Id_oldps_sur);
	}
	/**
	 * 入院前已有压疮来源
	 * @return String
	 */
	public String getSd_oldps_sur() {
		return ((String) getAttrVal("Sd_oldps_sur"));
	}	
	/**
	 * 入院前已有压疮来源
	 * @param Sd_oldps_sur
	 */
	public void setSd_oldps_sur(String Sd_oldps_sur) {
		setAttrVal("Sd_oldps_sur", Sd_oldps_sur);
	}
	/**
	 * 压疮部位id
	 * @return String
	 */
	public String getId_ps_pty() {
		return ((String) getAttrVal("Id_ps_pty"));
	}	
	/**
	 * 压疮部位id
	 * @param Id_ps_pty
	 */
	public void setId_ps_pty(String Id_ps_pty) {
		setAttrVal("Id_ps_pty", Id_ps_pty);
	}
	/**
	 * 压疮部位
	 * @return String
	 */
	public String getSd_ps_pty() {
		return ((String) getAttrVal("Sd_ps_pty"));
	}	
	/**
	 * 压疮部位
	 * @param Sd_ps_pty
	 */
	public void setSd_ps_pty(String Sd_ps_pty) {
		setAttrVal("Sd_ps_pty", Sd_ps_pty);
	}
	/**
	 * 压疮其他部位
	 * @return String
	 */
	public String getOth_ps_pty() {
		return ((String) getAttrVal("Oth_ps_pty"));
	}	
	/**
	 * 压疮其他部位
	 * @param Oth_ps_pty
	 */
	public void setOth_ps_pty(String Oth_ps_pty) {
		setAttrVal("Oth_ps_pty", Oth_ps_pty);
	}
	/**
	 * 压疮面积
	 * @return FDouble
	 */
	public FDouble getArea_ps() {
		return ((FDouble) getAttrVal("Area_ps"));
	}	
	/**
	 * 压疮面积
	 * @param Area_ps
	 */
	public void setArea_ps(FDouble Area_ps) {
		setAttrVal("Area_ps", Area_ps);
	}
	/**
	 * 压疮性质id
	 * @return String
	 */
	public String getId_ps_nt() {
		return ((String) getAttrVal("Id_ps_nt"));
	}	
	/**
	 * 压疮性质id
	 * @param Id_ps_nt
	 */
	public void setId_ps_nt(String Id_ps_nt) {
		setAttrVal("Id_ps_nt", Id_ps_nt);
	}
	/**
	 * 压疮性质
	 * @return String
	 */
	public String getSd_ps_nt() {
		return ((String) getAttrVal("Sd_ps_nt"));
	}	
	/**
	 * 压疮性质
	 * @param Sd_ps_nt
	 */
	public void setSd_ps_nt(String Sd_ps_nt) {
		setAttrVal("Sd_ps_nt", Sd_ps_nt);
	}
	/**
	 * 是否有人看护
	 * @return Integer
	 */
	public Integer getFg_smo_wth() {
		return ((Integer) getAttrVal("Fg_smo_wth"));
	}	
	/**
	 * 是否有人看护
	 * @param Fg_smo_wth
	 */
	public void setFg_smo_wth(Integer Fg_smo_wth) {
		setAttrVal("Fg_smo_wth", Fg_smo_wth);
	}
	/**
	 * 是否入住ICU
	 * @return Integer
	 */
	public Integer getFg_in_icu() {
		return ((Integer) getAttrVal("Fg_in_icu"));
	}	
	/**
	 * 是否入住ICU
	 * @param Fg_in_icu
	 */
	public void setFg_in_icu(Integer Fg_in_icu) {
		setAttrVal("Fg_in_icu", Fg_in_icu);
	}
	/**
	 * 是否填报过高危压疮或难免压疮
	 * @return Integer
	 */
	public Integer getFg_fill_ps() {
		return ((Integer) getAttrVal("Fg_fill_ps"));
	}	
	/**
	 * 是否填报过高危压疮或难免压疮
	 * @param Fg_fill_ps
	 */
	public void setFg_fill_ps(Integer Fg_fill_ps) {
		setAttrVal("Fg_fill_ps", Fg_fill_ps);
	}
	/**
	 * 是否手术
	 * @return Integer
	 */
	public Integer getFg_sug() {
		return ((Integer) getAttrVal("Fg_sug"));
	}	
	/**
	 * 是否手术
	 * @param Fg_sug
	 */
	public void setFg_sug(Integer Fg_sug) {
		setAttrVal("Fg_sug", Fg_sug);
	}
	/**
	 * 手术时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sug() {
		return ((FDateTime) getAttrVal("Dt_sug"));
	}	
	/**
	 * 手术时间
	 * @param Dt_sug
	 */
	public void setDt_sug(FDateTime Dt_sug) {
		setAttrVal("Dt_sug", Dt_sug);
	}
	/**
	 * 术中麻醉id
	 * @return String
	 */
	public String getId_sug_nrs() {
		return ((String) getAttrVal("Id_sug_nrs"));
	}	
	/**
	 * 术中麻醉id
	 * @param Id_sug_nrs
	 */
	public void setId_sug_nrs(String Id_sug_nrs) {
		setAttrVal("Id_sug_nrs", Id_sug_nrs);
	}
	/**
	 * 术中麻醉
	 * @return String
	 */
	public String getSd_sug_nrs() {
		return ((String) getAttrVal("Sd_sug_nrs"));
	}	
	/**
	 * 术中麻醉
	 * @param Sd_sug_nrs
	 */
	public void setSd_sug_nrs(String Sd_sug_nrs) {
		setAttrVal("Sd_sug_nrs", Sd_sug_nrs);
	}
	/**
	 * 手术体位id
	 * @return String
	 */
	public String getId_sug_pty() {
		return ((String) getAttrVal("Id_sug_pty"));
	}	
	/**
	 * 手术体位id
	 * @param Id_sug_pty
	 */
	public void setId_sug_pty(String Id_sug_pty) {
		setAttrVal("Id_sug_pty", Id_sug_pty);
	}
	/**
	 * 手术体位
	 * @return String
	 */
	public String getSd_sug_pty() {
		return ((String) getAttrVal("Sd_sug_pty"));
	}	
	/**
	 * 手术体位
	 * @param Sd_sug_pty
	 */
	public void setSd_sug_pty(String Sd_sug_pty) {
		setAttrVal("Sd_sug_pty", Sd_sug_pty);
	}
	/**
	 * 其他手术体位
	 * @return String
	 */
	public String getOtr_sug_pty() {
		return ((String) getAttrVal("Otr_sug_pty"));
	}	
	/**
	 * 其他手术体位
	 * @param Otr_sug_pty
	 */
	public void setOtr_sug_pty(String Otr_sug_pty) {
		setAttrVal("Otr_sug_pty", Otr_sug_pty);
	}
	/**
	 * 是否请压疮会诊
	 * @return Integer
	 */
	public Integer getFg_ps_cs() {
		return ((Integer) getAttrVal("Fg_ps_cs"));
	}	
	/**
	 * 是否请压疮会诊
	 * @param Fg_ps_cs
	 */
	public void setFg_ps_cs(Integer Fg_ps_cs) {
		setAttrVal("Fg_ps_cs", Fg_ps_cs);
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
	public String getName_psrpt_tp() {
		return ((String) getAttrVal("Name_psrpt_tp"));
	}	
	/**
	 * 名称
	 * @param Name_psrpt_tp
	 */
	public void setName_psrpt_tp(String Name_psrpt_tp) {
		setAttrVal("Name_psrpt_tp", Name_psrpt_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_psass() {
		return ((String) getAttrVal("Name_psass"));
	}	
	/**
	 * 名称
	 * @param Name_psass
	 */
	public void setName_psass(String Name_psass) {
		setAttrVal("Name_psass", Name_psass);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_psin_ms() {
		return ((String) getAttrVal("Name_psin_ms"));
	}	
	/**
	 * 名称
	 * @param Name_psin_ms
	 */
	public void setName_psin_ms(String Name_psin_ms) {
		setAttrVal("Name_psin_ms", Name_psin_ms);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_feel_pw() {
		return ((String) getAttrVal("Name_feel_pw"));
	}	
	/**
	 * 名称
	 * @param Name_feel_pw
	 */
	public void setName_feel_pw(String Name_feel_pw) {
		setAttrVal("Name_feel_pw", Name_feel_pw);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_hmd() {
		return ((String) getAttrVal("Name_hmd"));
	}	
	/**
	 * 名称
	 * @param Name_hmd
	 */
	public void setName_hmd(String Name_hmd) {
		setAttrVal("Name_hmd", Name_hmd);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_act_pw() {
		return ((String) getAttrVal("Name_act_pw"));
	}	
	/**
	 * 名称
	 * @param Name_act_pw
	 */
	public void setName_act_pw(String Name_act_pw) {
		setAttrVal("Name_act_pw", Name_act_pw);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_move_pw() {
		return ((String) getAttrVal("Name_move_pw"));
	}	
	/**
	 * 名称
	 * @param Name_move_pw
	 */
	public void setName_move_pw(String Name_move_pw) {
		setAttrVal("Name_move_pw", Name_move_pw);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ntr_spt() {
		return ((String) getAttrVal("Name_ntr_spt"));
	}	
	/**
	 * 名称
	 * @param Name_ntr_spt
	 */
	public void setName_ntr_spt(String Name_ntr_spt) {
		setAttrVal("Name_ntr_spt", Name_ntr_spt);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fcefr() {
		return ((String) getAttrVal("Name_fcefr"));
	}	
	/**
	 * 名称
	 * @param Name_fcefr
	 */
	public void setName_fcefr(String Name_fcefr) {
		setAttrVal("Name_fcefr", Name_fcefr);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_oxy() {
		return ((String) getAttrVal("Name_oxy"));
	}	
	/**
	 * 名称
	 * @param Name_oxy
	 */
	public void setName_oxy(String Name_oxy) {
		setAttrVal("Name_oxy", Name_oxy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grlc() {
		return ((String) getAttrVal("Name_grlc"));
	}	
	/**
	 * 名称
	 * @param Name_grlc
	 */
	public void setName_grlc(String Name_grlc) {
		setAttrVal("Name_grlc", Name_grlc);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ps_stg() {
		return ((String) getAttrVal("Name_ps_stg"));
	}	
	/**
	 * 名称
	 * @param Name_ps_stg
	 */
	public void setName_ps_stg(String Name_ps_stg) {
		setAttrVal("Name_ps_stg", Name_ps_stg);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_oldps_sur() {
		return ((String) getAttrVal("Name_oldps_sur"));
	}	
	/**
	 * 名称
	 * @param Name_oldps_sur
	 */
	public void setName_oldps_sur(String Name_oldps_sur) {
		setAttrVal("Name_oldps_sur", Name_oldps_sur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ps_pty() {
		return ((String) getAttrVal("Name_ps_pty"));
	}	
	/**
	 * 名称
	 * @param Name_ps_pty
	 */
	public void setName_ps_pty(String Name_ps_pty) {
		setAttrVal("Name_ps_pty", Name_ps_pty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ps_nt() {
		return ((String) getAttrVal("Name_ps_nt"));
	}	
	/**
	 * 名称
	 * @param Name_ps_nt
	 */
	public void setName_ps_nt(String Name_ps_nt) {
		setAttrVal("Name_ps_nt", Name_ps_nt);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sug_nrs() {
		return ((String) getAttrVal("Name_sug_nrs"));
	}	
	/**
	 * 名称
	 * @param Name_sug_nrs
	 */
	public void setName_sug_nrs(String Name_sug_nrs) {
		setAttrVal("Name_sug_nrs", Name_sug_nrs);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sug_pty() {
		return ((String) getAttrVal("Name_sug_pty"));
	}	
	/**
	 * 名称
	 * @param Name_sug_pty
	 */
	public void setName_sug_pty(String Name_sug_pty) {
		setAttrVal("Name_sug_pty", Name_sug_pty);
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
		return "Id_aer_ev_ps";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_PS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvPsDODesc.class);
	}
	
}