package iih.sfda.aer.sfdaaerevmetachysis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevmetachysis.d.desc.SfdaAerEvMetachysisDODesc;
import java.math.BigDecimal;

/**
 * 输血不良反应事件 DO数据 
 * 
 */
public class SfdaAerEvMetachysisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//输血不良反应事件主键
	public static final String ID_AER_EV_METACHYSIS= "Id_aer_ev_metachysis";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//是否发生输血不良反应
	public static final String ME_WHETHER_DYS= "Me_whether_dys";
	//供血者血型
	public static final String BL_DONOR_TYPE= "Bl_donor_type";
	//供血者编码
	public static final String BL_DONOR_CODE= "Bl_donor_code";
	//输血日期
	public static final String BL_METACHYSIS_DATA= "Bl_metachysis_data";
	//输用何种血液id
	public static final String ID_KIND_BLOOD= "Id_kind_blood";
	//输用何种血液
	public static final String SD_KIND_BLOOD= "Sd_kind_blood";
	//输用何种血液描述
	public static final String DES_KIND_BLOOD= "Des_kind_blood";
	//其他输用何种血液
	public static final String OTH_KIND_BLOOD= "Oth_kind_blood";
	//输血不良反应时输血量
	public static final String BL_BAD_VOLUME= "Bl_bad_volume";
	//输血不良反应时输血速度
	public static final String BL_BAD_SPEED= "Bl_bad_speed";
	//事件发生后引起的输血反应
	public static final String BL_EVENTS_REACTION= "Bl_events_reaction";
	//事件发生后引起的输血反应id
	public static final String ID_EVENTS_REACTION= "Id_events_reaction";
	//事件发生后引起的输血反应编码
	public static final String SD_EVENTS_REACTION= "Sd_events_reaction";
	//其他事件发生后引起的输血反应
	public static final String OTH_EVENTS_REACTION= "Oth_events_reaction";
	//事件输血临床表现
	public static final String BL_EVENTS_CLINIC= "Bl_events_clinic";
	//事件输血临床表现体温
	public static final String BL_EVENTS_ANIMAL= "Bl_events_animal";
	//事件输血临床表现脉率
	public static final String BL_EVENTS_PULSE= "Bl_events_pulse";
	//事件输血临床表现收缩压
	public static final String BL_EVENTS_SYSTOLIC= "Bl_events_systolic";
	//事件输血临床表现舒张压
	public static final String BL_EVENTS_DIASTOLIC= "Bl_events_diastolic";
	//输血反应发生时间id
	public static final String ID_OCCUR_TIME= "Id_occur_time";
	//输血反应发生时间编码
	public static final String SD_OCCUR_TIME= "Sd_occur_time";
	//输血反应发生时间描述
	public static final String DES_OCCUR_TIME= "Des_occur_time";
	//受血人员输血史
	public static final String BL_ME_HISTORY= "Bl_me_history";
	//受血人员输血史id
	public static final String ID_ME_HISTORY= "Id_me_history";
	//受血人员输血史编码
	public static final String SD_ME_HISTORY= "Sd_me_history";
	//受血人员输血史描述
	public static final String DES_ME_HISTORY= "Des_me_history";
	//输血反应史
	public static final String BL_RE_HISTORY= "Bl_re_history";
	//输血反应史id
	public static final String ID_RE_HISTORY= "Id_re_history";
	//输血反应史编码
	public static final String SD_RE_HISTORY= "Sd_re_history";
	//输血反应史描述
	public static final String DES_RE_HISTORY= "Des_re_history";
	//血液取回放置温度
	public static final String ID_PL_TE= "Id_pl_te";
	//血液取回放置温度编码
	public static final String SD_PL_TE= "Sd_pl_te";
	//血液取回放置温度描述
	public static final String DES_PL_TE= "Des_pl_te";
	//其他温度储存
	public static final String OTH_PL_TE= "Oth_pl_te";
	//输血反应处理id
	public static final String ID_BLOOD_DIS= "Id_blood_dis";
	//输血反应处理编码
	public static final String SD_BLOOD_DIS= "Sd_blood_dis";
	//遵医嘱给予
	public static final String OTH_BLOOD_DIS= "Oth_blood_dis";
	//患者多少分钟缓解
	public static final String PAT_TIME_REM= "Pat_time_rem";
	//经治医师
	public static final String BY_DOCTOR= "By_doctor";
	//输血护士
	public static final String BL_NURSE= "Bl_nurse";
	//是否差错引起不良
	public static final String ME_WHETHER_ERROR= "Me_whether_error";
	//输血事件错误发生阶段id
	public static final String ID_ERROR_STAGE= "Id_error_stage";
	//输血事件错误发生阶段编码
	public static final String SD_ERROR_STAGE= "Sd_error_stage";
	//其他输血事件错误发生阶段
	public static final String OTH_ERROR_STAGE= "Oth_error_stage";
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
	//扩展字段1
	public static final String CTRL1_KIND_BLOOD= "Ctrl1_kind_blood";
	//名称
	public static final String NAME_EVENTS_REACTION= "Name_events_reaction";
	//扩展字段1
	public static final String CTRL1_OCCUR_TIME= "Ctrl1_occur_time";
	//名称
	public static final String NAME_ME_HISTORY= "Name_me_history";
	//名称
	public static final String NAME_RE_HISTORY= "Name_re_history";
	//名称
	public static final String NAME_PL_TE= "Name_pl_te";
	//名称
	public static final String NAME_BLOOD_DIS= "Name_blood_dis";
	//名称
	public static final String NAME_ERROR_STAGE= "Name_error_stage";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 输血不良反应事件主键
	 * @return String
	 */
	public String getId_aer_ev_metachysis() {
		return ((String) getAttrVal("Id_aer_ev_metachysis"));
	}	
	/**
	 * 输血不良反应事件主键
	 * @param Id_aer_ev_metachysis
	 */
	public void setId_aer_ev_metachysis(String Id_aer_ev_metachysis) {
		setAttrVal("Id_aer_ev_metachysis", Id_aer_ev_metachysis);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
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
	 * 是否发生输血不良反应
	 * @return Integer
	 */
	public Integer getMe_whether_dys() {
		return ((Integer) getAttrVal("Me_whether_dys"));
	}	
	/**
	 * 是否发生输血不良反应
	 * @param Me_whether_dys
	 */
	public void setMe_whether_dys(Integer Me_whether_dys) {
		setAttrVal("Me_whether_dys", Me_whether_dys);
	}
	/**
	 * 供血者血型
	 * @return String
	 */
	public String getBl_donor_type() {
		return ((String) getAttrVal("Bl_donor_type"));
	}	
	/**
	 * 供血者血型
	 * @param Bl_donor_type
	 */
	public void setBl_donor_type(String Bl_donor_type) {
		setAttrVal("Bl_donor_type", Bl_donor_type);
	}
	/**
	 * 供血者编码
	 * @return String
	 */
	public String getBl_donor_code() {
		return ((String) getAttrVal("Bl_donor_code"));
	}	
	/**
	 * 供血者编码
	 * @param Bl_donor_code
	 */
	public void setBl_donor_code(String Bl_donor_code) {
		setAttrVal("Bl_donor_code", Bl_donor_code);
	}
	/**
	 * 输血日期
	 * @return FDateTime
	 */
	public FDateTime getBl_metachysis_data() {
		return ((FDateTime) getAttrVal("Bl_metachysis_data"));
	}	
	/**
	 * 输血日期
	 * @param Bl_metachysis_data
	 */
	public void setBl_metachysis_data(FDateTime Bl_metachysis_data) {
		setAttrVal("Bl_metachysis_data", Bl_metachysis_data);
	}
	/**
	 * 输用何种血液id
	 * @return String
	 */
	public String getId_kind_blood() {
		return ((String) getAttrVal("Id_kind_blood"));
	}	
	/**
	 * 输用何种血液id
	 * @param Id_kind_blood
	 */
	public void setId_kind_blood(String Id_kind_blood) {
		setAttrVal("Id_kind_blood", Id_kind_blood);
	}
	/**
	 * 输用何种血液
	 * @return String
	 */
	public String getSd_kind_blood() {
		return ((String) getAttrVal("Sd_kind_blood"));
	}	
	/**
	 * 输用何种血液
	 * @param Sd_kind_blood
	 */
	public void setSd_kind_blood(String Sd_kind_blood) {
		setAttrVal("Sd_kind_blood", Sd_kind_blood);
	}
	/**
	 * 输用何种血液描述
	 * @return String
	 */
	public String getDes_kind_blood() {
		return ((String) getAttrVal("Des_kind_blood"));
	}	
	/**
	 * 输用何种血液描述
	 * @param Des_kind_blood
	 */
	public void setDes_kind_blood(String Des_kind_blood) {
		setAttrVal("Des_kind_blood", Des_kind_blood);
	}
	/**
	 * 其他输用何种血液
	 * @return String
	 */
	public String getOth_kind_blood() {
		return ((String) getAttrVal("Oth_kind_blood"));
	}	
	/**
	 * 其他输用何种血液
	 * @param Oth_kind_blood
	 */
	public void setOth_kind_blood(String Oth_kind_blood) {
		setAttrVal("Oth_kind_blood", Oth_kind_blood);
	}
	/**
	 * 输血不良反应时输血量
	 * @return Integer
	 */
	public Integer getBl_bad_volume() {
		return ((Integer) getAttrVal("Bl_bad_volume"));
	}	
	/**
	 * 输血不良反应时输血量
	 * @param Bl_bad_volume
	 */
	public void setBl_bad_volume(Integer Bl_bad_volume) {
		setAttrVal("Bl_bad_volume", Bl_bad_volume);
	}
	/**
	 * 输血不良反应时输血速度
	 * @return Integer
	 */
	public Integer getBl_bad_speed() {
		return ((Integer) getAttrVal("Bl_bad_speed"));
	}	
	/**
	 * 输血不良反应时输血速度
	 * @param Bl_bad_speed
	 */
	public void setBl_bad_speed(Integer Bl_bad_speed) {
		setAttrVal("Bl_bad_speed", Bl_bad_speed);
	}
	/**
	 * 事件发生后引起的输血反应
	 * @return Integer
	 */
	public Integer getBl_events_reaction() {
		return ((Integer) getAttrVal("Bl_events_reaction"));
	}	
	/**
	 * 事件发生后引起的输血反应
	 * @param Bl_events_reaction
	 */
	public void setBl_events_reaction(Integer Bl_events_reaction) {
		setAttrVal("Bl_events_reaction", Bl_events_reaction);
	}
	/**
	 * 事件发生后引起的输血反应id
	 * @return String
	 */
	public String getId_events_reaction() {
		return ((String) getAttrVal("Id_events_reaction"));
	}	
	/**
	 * 事件发生后引起的输血反应id
	 * @param Id_events_reaction
	 */
	public void setId_events_reaction(String Id_events_reaction) {
		setAttrVal("Id_events_reaction", Id_events_reaction);
	}
	/**
	 * 事件发生后引起的输血反应编码
	 * @return String
	 */
	public String getSd_events_reaction() {
		return ((String) getAttrVal("Sd_events_reaction"));
	}	
	/**
	 * 事件发生后引起的输血反应编码
	 * @param Sd_events_reaction
	 */
	public void setSd_events_reaction(String Sd_events_reaction) {
		setAttrVal("Sd_events_reaction", Sd_events_reaction);
	}
	/**
	 * 其他事件发生后引起的输血反应
	 * @return String
	 */
	public String getOth_events_reaction() {
		return ((String) getAttrVal("Oth_events_reaction"));
	}	
	/**
	 * 其他事件发生后引起的输血反应
	 * @param Oth_events_reaction
	 */
	public void setOth_events_reaction(String Oth_events_reaction) {
		setAttrVal("Oth_events_reaction", Oth_events_reaction);
	}
	/**
	 * 事件输血临床表现
	 * @return String
	 */
	public String getBl_events_clinic() {
		return ((String) getAttrVal("Bl_events_clinic"));
	}	
	/**
	 * 事件输血临床表现
	 * @param Bl_events_clinic
	 */
	public void setBl_events_clinic(String Bl_events_clinic) {
		setAttrVal("Bl_events_clinic", Bl_events_clinic);
	}
	/**
	 * 事件输血临床表现体温
	 * @return FDouble
	 */
	public FDouble getBl_events_animal() {
		return ((FDouble) getAttrVal("Bl_events_animal"));
	}	
	/**
	 * 事件输血临床表现体温
	 * @param Bl_events_animal
	 */
	public void setBl_events_animal(FDouble Bl_events_animal) {
		setAttrVal("Bl_events_animal", Bl_events_animal);
	}
	/**
	 * 事件输血临床表现脉率
	 * @return Integer
	 */
	public Integer getBl_events_pulse() {
		return ((Integer) getAttrVal("Bl_events_pulse"));
	}	
	/**
	 * 事件输血临床表现脉率
	 * @param Bl_events_pulse
	 */
	public void setBl_events_pulse(Integer Bl_events_pulse) {
		setAttrVal("Bl_events_pulse", Bl_events_pulse);
	}
	/**
	 * 事件输血临床表现收缩压
	 * @return Integer
	 */
	public Integer getBl_events_systolic() {
		return ((Integer) getAttrVal("Bl_events_systolic"));
	}	
	/**
	 * 事件输血临床表现收缩压
	 * @param Bl_events_systolic
	 */
	public void setBl_events_systolic(Integer Bl_events_systolic) {
		setAttrVal("Bl_events_systolic", Bl_events_systolic);
	}
	/**
	 * 事件输血临床表现舒张压
	 * @return Integer
	 */
	public Integer getBl_events_diastolic() {
		return ((Integer) getAttrVal("Bl_events_diastolic"));
	}	
	/**
	 * 事件输血临床表现舒张压
	 * @param Bl_events_diastolic
	 */
	public void setBl_events_diastolic(Integer Bl_events_diastolic) {
		setAttrVal("Bl_events_diastolic", Bl_events_diastolic);
	}
	/**
	 * 输血反应发生时间id
	 * @return String
	 */
	public String getId_occur_time() {
		return ((String) getAttrVal("Id_occur_time"));
	}	
	/**
	 * 输血反应发生时间id
	 * @param Id_occur_time
	 */
	public void setId_occur_time(String Id_occur_time) {
		setAttrVal("Id_occur_time", Id_occur_time);
	}
	/**
	 * 输血反应发生时间编码
	 * @return String
	 */
	public String getSd_occur_time() {
		return ((String) getAttrVal("Sd_occur_time"));
	}	
	/**
	 * 输血反应发生时间编码
	 * @param Sd_occur_time
	 */
	public void setSd_occur_time(String Sd_occur_time) {
		setAttrVal("Sd_occur_time", Sd_occur_time);
	}
	/**
	 * 输血反应发生时间描述
	 * @return String
	 */
	public String getDes_occur_time() {
		return ((String) getAttrVal("Des_occur_time"));
	}	
	/**
	 * 输血反应发生时间描述
	 * @param Des_occur_time
	 */
	public void setDes_occur_time(String Des_occur_time) {
		setAttrVal("Des_occur_time", Des_occur_time);
	}
	/**
	 * 受血人员输血史
	 * @return Integer
	 */
	public Integer getBl_me_history() {
		return ((Integer) getAttrVal("Bl_me_history"));
	}	
	/**
	 * 受血人员输血史
	 * @param Bl_me_history
	 */
	public void setBl_me_history(Integer Bl_me_history) {
		setAttrVal("Bl_me_history", Bl_me_history);
	}
	/**
	 * 受血人员输血史id
	 * @return String
	 */
	public String getId_me_history() {
		return ((String) getAttrVal("Id_me_history"));
	}	
	/**
	 * 受血人员输血史id
	 * @param Id_me_history
	 */
	public void setId_me_history(String Id_me_history) {
		setAttrVal("Id_me_history", Id_me_history);
	}
	/**
	 * 受血人员输血史编码
	 * @return String
	 */
	public String getSd_me_history() {
		return ((String) getAttrVal("Sd_me_history"));
	}	
	/**
	 * 受血人员输血史编码
	 * @param Sd_me_history
	 */
	public void setSd_me_history(String Sd_me_history) {
		setAttrVal("Sd_me_history", Sd_me_history);
	}
	/**
	 * 受血人员输血史描述
	 * @return String
	 */
	public String getDes_me_history() {
		return ((String) getAttrVal("Des_me_history"));
	}	
	/**
	 * 受血人员输血史描述
	 * @param Des_me_history
	 */
	public void setDes_me_history(String Des_me_history) {
		setAttrVal("Des_me_history", Des_me_history);
	}
	/**
	 * 输血反应史
	 * @return Integer
	 */
	public Integer getBl_re_history() {
		return ((Integer) getAttrVal("Bl_re_history"));
	}	
	/**
	 * 输血反应史
	 * @param Bl_re_history
	 */
	public void setBl_re_history(Integer Bl_re_history) {
		setAttrVal("Bl_re_history", Bl_re_history);
	}
	/**
	 * 输血反应史id
	 * @return String
	 */
	public String getId_re_history() {
		return ((String) getAttrVal("Id_re_history"));
	}	
	/**
	 * 输血反应史id
	 * @param Id_re_history
	 */
	public void setId_re_history(String Id_re_history) {
		setAttrVal("Id_re_history", Id_re_history);
	}
	/**
	 * 输血反应史编码
	 * @return String
	 */
	public String getSd_re_history() {
		return ((String) getAttrVal("Sd_re_history"));
	}	
	/**
	 * 输血反应史编码
	 * @param Sd_re_history
	 */
	public void setSd_re_history(String Sd_re_history) {
		setAttrVal("Sd_re_history", Sd_re_history);
	}
	/**
	 * 输血反应史描述
	 * @return String
	 */
	public String getDes_re_history() {
		return ((String) getAttrVal("Des_re_history"));
	}	
	/**
	 * 输血反应史描述
	 * @param Des_re_history
	 */
	public void setDes_re_history(String Des_re_history) {
		setAttrVal("Des_re_history", Des_re_history);
	}
	/**
	 * 血液取回放置温度
	 * @return String
	 */
	public String getId_pl_te() {
		return ((String) getAttrVal("Id_pl_te"));
	}	
	/**
	 * 血液取回放置温度
	 * @param Id_pl_te
	 */
	public void setId_pl_te(String Id_pl_te) {
		setAttrVal("Id_pl_te", Id_pl_te);
	}
	/**
	 * 血液取回放置温度编码
	 * @return String
	 */
	public String getSd_pl_te() {
		return ((String) getAttrVal("Sd_pl_te"));
	}	
	/**
	 * 血液取回放置温度编码
	 * @param Sd_pl_te
	 */
	public void setSd_pl_te(String Sd_pl_te) {
		setAttrVal("Sd_pl_te", Sd_pl_te);
	}
	/**
	 * 血液取回放置温度描述
	 * @return Integer
	 */
	public Integer getDes_pl_te() {
		return ((Integer) getAttrVal("Des_pl_te"));
	}	
	/**
	 * 血液取回放置温度描述
	 * @param Des_pl_te
	 */
	public void setDes_pl_te(Integer Des_pl_te) {
		setAttrVal("Des_pl_te", Des_pl_te);
	}
	/**
	 * 其他温度储存
	 * @return String
	 */
	public String getOth_pl_te() {
		return ((String) getAttrVal("Oth_pl_te"));
	}	
	/**
	 * 其他温度储存
	 * @param Oth_pl_te
	 */
	public void setOth_pl_te(String Oth_pl_te) {
		setAttrVal("Oth_pl_te", Oth_pl_te);
	}
	/**
	 * 输血反应处理id
	 * @return String
	 */
	public String getId_blood_dis() {
		return ((String) getAttrVal("Id_blood_dis"));
	}	
	/**
	 * 输血反应处理id
	 * @param Id_blood_dis
	 */
	public void setId_blood_dis(String Id_blood_dis) {
		setAttrVal("Id_blood_dis", Id_blood_dis);
	}
	/**
	 * 输血反应处理编码
	 * @return String
	 */
	public String getSd_blood_dis() {
		return ((String) getAttrVal("Sd_blood_dis"));
	}	
	/**
	 * 输血反应处理编码
	 * @param Sd_blood_dis
	 */
	public void setSd_blood_dis(String Sd_blood_dis) {
		setAttrVal("Sd_blood_dis", Sd_blood_dis);
	}
	/**
	 * 遵医嘱给予
	 * @return String
	 */
	public String getOth_blood_dis() {
		return ((String) getAttrVal("Oth_blood_dis"));
	}	
	/**
	 * 遵医嘱给予
	 * @param Oth_blood_dis
	 */
	public void setOth_blood_dis(String Oth_blood_dis) {
		setAttrVal("Oth_blood_dis", Oth_blood_dis);
	}
	/**
	 * 患者多少分钟缓解
	 * @return Integer
	 */
	public Integer getPat_time_rem() {
		return ((Integer) getAttrVal("Pat_time_rem"));
	}	
	/**
	 * 患者多少分钟缓解
	 * @param Pat_time_rem
	 */
	public void setPat_time_rem(Integer Pat_time_rem) {
		setAttrVal("Pat_time_rem", Pat_time_rem);
	}
	/**
	 * 经治医师
	 * @return String
	 */
	public String getBy_doctor() {
		return ((String) getAttrVal("By_doctor"));
	}	
	/**
	 * 经治医师
	 * @param By_doctor
	 */
	public void setBy_doctor(String By_doctor) {
		setAttrVal("By_doctor", By_doctor);
	}
	/**
	 * 输血护士
	 * @return String
	 */
	public String getBl_nurse() {
		return ((String) getAttrVal("Bl_nurse"));
	}	
	/**
	 * 输血护士
	 * @param Bl_nurse
	 */
	public void setBl_nurse(String Bl_nurse) {
		setAttrVal("Bl_nurse", Bl_nurse);
	}
	/**
	 * 是否差错引起不良
	 * @return Integer
	 */
	public Integer getMe_whether_error() {
		return ((Integer) getAttrVal("Me_whether_error"));
	}	
	/**
	 * 是否差错引起不良
	 * @param Me_whether_error
	 */
	public void setMe_whether_error(Integer Me_whether_error) {
		setAttrVal("Me_whether_error", Me_whether_error);
	}
	/**
	 * 输血事件错误发生阶段id
	 * @return String
	 */
	public String getId_error_stage() {
		return ((String) getAttrVal("Id_error_stage"));
	}	
	/**
	 * 输血事件错误发生阶段id
	 * @param Id_error_stage
	 */
	public void setId_error_stage(String Id_error_stage) {
		setAttrVal("Id_error_stage", Id_error_stage);
	}
	/**
	 * 输血事件错误发生阶段编码
	 * @return String
	 */
	public String getSd_error_stage() {
		return ((String) getAttrVal("Sd_error_stage"));
	}	
	/**
	 * 输血事件错误发生阶段编码
	 * @param Sd_error_stage
	 */
	public void setSd_error_stage(String Sd_error_stage) {
		setAttrVal("Sd_error_stage", Sd_error_stage);
	}
	/**
	 * 其他输血事件错误发生阶段
	 * @return String
	 */
	public String getOth_error_stage() {
		return ((String) getAttrVal("Oth_error_stage"));
	}	
	/**
	 * 其他输血事件错误发生阶段
	 * @param Oth_error_stage
	 */
	public void setOth_error_stage(String Oth_error_stage) {
		setAttrVal("Oth_error_stage", Oth_error_stage);
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
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1_kind_blood() {
		return ((String) getAttrVal("Ctrl1_kind_blood"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1_kind_blood
	 */
	public void setCtrl1_kind_blood(String Ctrl1_kind_blood) {
		setAttrVal("Ctrl1_kind_blood", Ctrl1_kind_blood);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_events_reaction() {
		return ((String) getAttrVal("Name_events_reaction"));
	}	
	/**
	 * 名称
	 * @param Name_events_reaction
	 */
	public void setName_events_reaction(String Name_events_reaction) {
		setAttrVal("Name_events_reaction", Name_events_reaction);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1_occur_time() {
		return ((String) getAttrVal("Ctrl1_occur_time"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1_occur_time
	 */
	public void setCtrl1_occur_time(String Ctrl1_occur_time) {
		setAttrVal("Ctrl1_occur_time", Ctrl1_occur_time);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_me_history() {
		return ((String) getAttrVal("Name_me_history"));
	}	
	/**
	 * 名称
	 * @param Name_me_history
	 */
	public void setName_me_history(String Name_me_history) {
		setAttrVal("Name_me_history", Name_me_history);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_re_history() {
		return ((String) getAttrVal("Name_re_history"));
	}	
	/**
	 * 名称
	 * @param Name_re_history
	 */
	public void setName_re_history(String Name_re_history) {
		setAttrVal("Name_re_history", Name_re_history);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pl_te() {
		return ((String) getAttrVal("Name_pl_te"));
	}	
	/**
	 * 名称
	 * @param Name_pl_te
	 */
	public void setName_pl_te(String Name_pl_te) {
		setAttrVal("Name_pl_te", Name_pl_te);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_blood_dis() {
		return ((String) getAttrVal("Name_blood_dis"));
	}	
	/**
	 * 名称
	 * @param Name_blood_dis
	 */
	public void setName_blood_dis(String Name_blood_dis) {
		setAttrVal("Name_blood_dis", Name_blood_dis);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_error_stage() {
		return ((String) getAttrVal("Name_error_stage"));
	}	
	/**
	 * 名称
	 * @param Name_error_stage
	 */
	public void setName_error_stage(String Name_error_stage) {
		setAttrVal("Name_error_stage", Name_error_stage);
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
		return "Id_aer_ev_metachysis";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_METACHYSIS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvMetachysisDODesc.class);
	}
	
}