
package iih.sfda.aer.sfdaaerevmetachysis.d.desc;

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
 * 输血不良反应事件 DO 元数据信息
 */
public class SfdaAerEvMetachysisDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sfda.aer.sfdaaerevmetachysis.d.SfdaAerEvMetachysisDO";
	public static final String CLASS_DISPALYNAME = "输血不良反应事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "SFDA_AER_EV_METACHYSIS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aer_ev_metachysis";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SfdaAerEvMetachysisDODesc(){
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
		this.setKeyDesc(getId_aer_ev_metachysisADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aer_ev_metachysisADesc(tblDesc));
		this.add(getId_aer_evADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getMe_whether_dysADesc(tblDesc));
		this.add(getBl_donor_typeADesc(tblDesc));
		this.add(getBl_donor_codeADesc(tblDesc));
		this.add(getBl_metachysis_dataADesc(tblDesc));
		this.add(getId_kind_bloodADesc(tblDesc));
		this.add(getSd_kind_bloodADesc(tblDesc));
		this.add(getDes_kind_bloodADesc(tblDesc));
		this.add(getOth_kind_bloodADesc(tblDesc));
		this.add(getBl_bad_volumeADesc(tblDesc));
		this.add(getBl_bad_speedADesc(tblDesc));
		this.add(getBl_events_reactionADesc(tblDesc));
		this.add(getId_events_reactionADesc(tblDesc));
		this.add(getSd_events_reactionADesc(tblDesc));
		this.add(getOth_events_reactionADesc(tblDesc));
		this.add(getBl_events_clinicADesc(tblDesc));
		this.add(getBl_events_animalADesc(tblDesc));
		this.add(getBl_events_pulseADesc(tblDesc));
		this.add(getBl_events_systolicADesc(tblDesc));
		this.add(getBl_events_diastolicADesc(tblDesc));
		this.add(getId_occur_timeADesc(tblDesc));
		this.add(getSd_occur_timeADesc(tblDesc));
		this.add(getDes_occur_timeADesc(tblDesc));
		this.add(getBl_me_historyADesc(tblDesc));
		this.add(getId_me_historyADesc(tblDesc));
		this.add(getSd_me_historyADesc(tblDesc));
		this.add(getDes_me_historyADesc(tblDesc));
		this.add(getBl_re_historyADesc(tblDesc));
		this.add(getId_re_historyADesc(tblDesc));
		this.add(getSd_re_historyADesc(tblDesc));
		this.add(getDes_re_historyADesc(tblDesc));
		this.add(getId_pl_teADesc(tblDesc));
		this.add(getSd_pl_teADesc(tblDesc));
		this.add(getDes_pl_teADesc(tblDesc));
		this.add(getOth_pl_teADesc(tblDesc));
		this.add(getId_blood_disADesc(tblDesc));
		this.add(getSd_blood_disADesc(tblDesc));
		this.add(getOth_blood_disADesc(tblDesc));
		this.add(getPat_time_remADesc(tblDesc));
		this.add(getBy_doctorADesc(tblDesc));
		this.add(getBl_nurseADesc(tblDesc));
		this.add(getMe_whether_errorADesc(tblDesc));
		this.add(getId_error_stageADesc(tblDesc));
		this.add(getSd_error_stageADesc(tblDesc));
		this.add(getOth_error_stageADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getCtrl1_kind_bloodADesc(tblDesc));
		this.add(getName_events_reactionADesc(tblDesc));
		this.add(getCtrl1_occur_timeADesc(tblDesc));
		this.add(getName_me_historyADesc(tblDesc));
		this.add(getName_re_historyADesc(tblDesc));
		this.add(getName_pl_teADesc(tblDesc));
		this.add(getName_blood_disADesc(tblDesc));
		this.add(getName_error_stageADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aer_ev_metachysisCDesc(tblDesc));
		tblDesc.add(getId_aer_ev_metachysisCDesc(tblDesc));
		tblDesc.add(getId_aer_evCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getMe_whether_dysCDesc(tblDesc));
		tblDesc.add(getBl_donor_typeCDesc(tblDesc));
		tblDesc.add(getBl_donor_codeCDesc(tblDesc));
		tblDesc.add(getBl_metachysis_dataCDesc(tblDesc));
		tblDesc.add(getId_kind_bloodCDesc(tblDesc));
		tblDesc.add(getSd_kind_bloodCDesc(tblDesc));
		tblDesc.add(getDes_kind_bloodCDesc(tblDesc));
		tblDesc.add(getOth_kind_bloodCDesc(tblDesc));
		tblDesc.add(getBl_bad_volumeCDesc(tblDesc));
		tblDesc.add(getBl_bad_speedCDesc(tblDesc));
		tblDesc.add(getBl_events_reactionCDesc(tblDesc));
		tblDesc.add(getId_events_reactionCDesc(tblDesc));
		tblDesc.add(getSd_events_reactionCDesc(tblDesc));
		tblDesc.add(getOth_events_reactionCDesc(tblDesc));
		tblDesc.add(getBl_events_clinicCDesc(tblDesc));
		tblDesc.add(getBl_events_animalCDesc(tblDesc));
		tblDesc.add(getBl_events_pulseCDesc(tblDesc));
		tblDesc.add(getBl_events_systolicCDesc(tblDesc));
		tblDesc.add(getBl_events_diastolicCDesc(tblDesc));
		tblDesc.add(getId_occur_timeCDesc(tblDesc));
		tblDesc.add(getSd_occur_timeCDesc(tblDesc));
		tblDesc.add(getDes_occur_timeCDesc(tblDesc));
		tblDesc.add(getBl_me_historyCDesc(tblDesc));
		tblDesc.add(getId_me_historyCDesc(tblDesc));
		tblDesc.add(getSd_me_historyCDesc(tblDesc));
		tblDesc.add(getDes_me_historyCDesc(tblDesc));
		tblDesc.add(getBl_re_historyCDesc(tblDesc));
		tblDesc.add(getId_re_historyCDesc(tblDesc));
		tblDesc.add(getSd_re_historyCDesc(tblDesc));
		tblDesc.add(getDes_re_historyCDesc(tblDesc));
		tblDesc.add(getId_pl_teCDesc(tblDesc));
		tblDesc.add(getSd_pl_teCDesc(tblDesc));
		tblDesc.add(getDes_pl_teCDesc(tblDesc));
		tblDesc.add(getOth_pl_teCDesc(tblDesc));
		tblDesc.add(getId_blood_disCDesc(tblDesc));
		tblDesc.add(getSd_blood_disCDesc(tblDesc));
		tblDesc.add(getOth_blood_disCDesc(tblDesc));
		tblDesc.add(getPat_time_remCDesc(tblDesc));
		tblDesc.add(getBy_doctorCDesc(tblDesc));
		tblDesc.add(getBl_nurseCDesc(tblDesc));
		tblDesc.add(getMe_whether_errorCDesc(tblDesc));
		tblDesc.add(getId_error_stageCDesc(tblDesc));
		tblDesc.add(getSd_error_stageCDesc(tblDesc));
		tblDesc.add(getOth_error_stageCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 输血不良反应事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_ev_metachysisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev_metachysis",  getId_aer_ev_metachysisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血不良反应事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aer_evADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aer_ev",  getId_aer_evCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否发生输血不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMe_whether_dysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Me_whether_dys",  getMe_whether_dysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否发生输血不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供血者血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_donor_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_donor_type",  getBl_donor_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供血者血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 供血者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_donor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_donor_code",  getBl_donor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("供血者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_metachysis_dataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_metachysis_data",  getBl_metachysis_dataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("输血日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输用何种血液id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_kind_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_kind_blood",  getId_kind_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输用何种血液id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输用何种血液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_kind_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_kind_blood",  getSd_kind_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输用何种血液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输用何种血液描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_kind_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_kind_blood",  getDes_kind_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输用何种血液描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他输用何种血液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_kind_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_kind_blood",  getOth_kind_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他输用何种血液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血不良反应时输血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_bad_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_bad_volume",  getBl_bad_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血不良反应时输血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血不良反应时输血速度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_bad_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_bad_speed",  getBl_bad_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血不良反应时输血速度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生后引起的输血反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_reaction",  getBl_events_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件发生后引起的输血反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件发生后引起的输血反应id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_events_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_events_reaction",  getId_events_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后引起的输血反应id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 事件发生后引起的输血反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_events_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_events_reaction",  getSd_events_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件发生后引起的输血反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他事件发生后引起的输血反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_events_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_events_reaction",  getOth_events_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他事件发生后引起的输血反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件输血临床表现属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_clinic",  getBl_events_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件输血临床表现");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件输血临床表现体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_animalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_animal",  getBl_events_animalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("事件输血临床表现体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件输血临床表现脉率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_pulse",  getBl_events_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件输血临床表现脉率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件输血临床表现收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_systolicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_systolic",  getBl_events_systolicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件输血临床表现收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件输血临床表现舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_events_diastolicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_events_diastolic",  getBl_events_diastolicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件输血临床表现舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应发生时间id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occur_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occur_time",  getId_occur_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应发生时间id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血反应发生时间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occur_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occur_time",  getSd_occur_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应发生时间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应发生时间描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_occur_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_occur_time",  getDes_occur_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应发生时间描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受血人员输血史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_me_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_me_history",  getBl_me_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("受血人员输血史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受血人员输血史id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_me_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_me_history",  getId_me_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受血人员输血史id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受血人员输血史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_me_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_me_history",  getSd_me_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受血人员输血史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受血人员输血史描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_me_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_me_history",  getDes_me_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受血人员输血史描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_re_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_re_history",  getBl_re_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血反应史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应史id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_re_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_re_history",  getId_re_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应史id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血反应史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_re_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_re_history",  getSd_re_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应史描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_re_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_re_history",  getDes_re_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应史描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液取回放置温度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pl_teADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pl_te",  getId_pl_teCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液取回放置温度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血液取回放置温度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pl_teADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pl_te",  getSd_pl_teCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液取回放置温度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液取回放置温度描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_pl_teADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pl_te",  getDes_pl_teCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("血液取回放置温度描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他温度储存属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_pl_teADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_pl_te",  getOth_pl_teCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他温度储存");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血反应处理id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_dis",  getId_blood_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应处理id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血反应处理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_dis",  getSd_blood_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血反应处理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 遵医嘱给予属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_blood_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_blood_dis",  getOth_blood_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("遵医嘱给予");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者多少分钟缓解属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_time_remADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_time_rem",  getPat_time_remCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者多少分钟缓解");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 经治医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBy_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("By_doctor",  getBy_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("经治医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBl_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bl_nurse",  getBl_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否差错引起不良属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMe_whether_errorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Me_whether_error",  getMe_whether_errorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否差错引起不良");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血事件错误发生阶段id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_error_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_error_stage",  getId_error_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血事件错误发生阶段id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血事件错误发生阶段编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_error_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_error_stage",  getSd_error_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血事件错误发生阶段编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他输血事件错误发生阶段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOth_error_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oth_error_stage",  getOth_error_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他输血事件错误发生阶段");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1_kind_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1_kind_blood",  getCtrl1_kind_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_kind_blood=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_events_reactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_events_reaction",  getName_events_reactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_events_reaction=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCtrl1_occur_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ctrl1_occur_time",  getCtrl1_occur_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_occur_time=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_me_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_me_history",  getName_me_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_me_history=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_re_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_re_history",  getName_re_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_re_history=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pl_teADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pl_te",  getName_pl_teCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_pl_te=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_disADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_dis",  getName_blood_disCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_blood_dis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_error_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_error_stage",  getName_error_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_error_stage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取输血不良反应事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_ev_metachysisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev_metachysis");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血不良反应事件主键"); 
		return column;
	}
	/**
	 * 获取事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aer_evCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aer_ev");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件外键"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取是否发生输血不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMe_whether_dysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Me_whether_dys");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否发生输血不良反应"); 
		return column;
	}
	/**
	 * 获取供血者血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_donor_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_donor_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供血者血型"); 
		return column;
	}
	/**
	 * 获取供血者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_donor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_donor_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("供血者编码"); 
		return column;
	}
	/**
	 * 获取输血日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_metachysis_dataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_metachysis_data");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血日期"); 
		return column;
	}
	/**
	 * 获取输用何种血液id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_kind_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_kind_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输用何种血液id"); 
		return column;
	}
	/**
	 * 获取输用何种血液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_kind_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_kind_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输用何种血液"); 
		return column;
	}
	/**
	 * 获取输用何种血液描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_kind_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_kind_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输用何种血液描述"); 
		return column;
	}
	/**
	 * 获取其他输用何种血液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_kind_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_kind_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他输用何种血液"); 
		return column;
	}
	/**
	 * 获取输血不良反应时输血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_bad_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_bad_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血不良反应时输血量"); 
		return column;
	}
	/**
	 * 获取输血不良反应时输血速度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_bad_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_bad_speed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血不良反应时输血速度"); 
		return column;
	}
	/**
	 * 获取事件发生后引起的输血反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_reaction");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件发生后引起的输血反应"); 
		return column;
	}
	/**
	 * 获取事件发生后引起的输血反应id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_events_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_events_reaction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后引起的输血反应id"); 
		return column;
	}
	/**
	 * 获取事件发生后引起的输血反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_events_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_events_reaction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件发生后引起的输血反应编码"); 
		return column;
	}
	/**
	 * 获取其他事件发生后引起的输血反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_events_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_events_reaction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他事件发生后引起的输血反应"); 
		return column;
	}
	/**
	 * 获取事件输血临床表现表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_clinic");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件输血临床表现"); 
		return column;
	}
	/**
	 * 获取事件输血临床表现体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_animalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_animal");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("事件输血临床表现体温"); 
		return column;
	}
	/**
	 * 获取事件输血临床表现脉率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件输血临床表现脉率"); 
		return column;
	}
	/**
	 * 获取事件输血临床表现收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_systolicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_systolic");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件输血临床表现收缩压"); 
		return column;
	}
	/**
	 * 获取事件输血临床表现舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_events_diastolicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_events_diastolic");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件输血临床表现舒张压"); 
		return column;
	}
	/**
	 * 获取输血反应发生时间id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occur_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occur_time");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应发生时间id"); 
		return column;
	}
	/**
	 * 获取输血反应发生时间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occur_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occur_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应发生时间编码"); 
		return column;
	}
	/**
	 * 获取输血反应发生时间描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_occur_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_occur_time");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应发生时间描述"); 
		return column;
	}
	/**
	 * 获取受血人员输血史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_me_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_me_history");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("受血人员输血史"); 
		return column;
	}
	/**
	 * 获取受血人员输血史id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_me_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_me_history");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受血人员输血史id"); 
		return column;
	}
	/**
	 * 获取受血人员输血史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_me_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_me_history");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受血人员输血史编码"); 
		return column;
	}
	/**
	 * 获取受血人员输血史描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_me_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_me_history");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受血人员输血史描述"); 
		return column;
	}
	/**
	 * 获取输血反应史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_re_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_re_history");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血反应史"); 
		return column;
	}
	/**
	 * 获取输血反应史id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_re_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_re_history");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应史id"); 
		return column;
	}
	/**
	 * 获取输血反应史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_re_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_re_history");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应史编码"); 
		return column;
	}
	/**
	 * 获取输血反应史描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_re_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_re_history");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应史描述"); 
		return column;
	}
	/**
	 * 获取血液取回放置温度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pl_teCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pl_te");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液取回放置温度"); 
		return column;
	}
	/**
	 * 获取血液取回放置温度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pl_teCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pl_te");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液取回放置温度编码"); 
		return column;
	}
	/**
	 * 获取血液取回放置温度描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_pl_teCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pl_te");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("血液取回放置温度描述"); 
		return column;
	}
	/**
	 * 获取其他温度储存表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_pl_teCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_pl_te");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他温度储存"); 
		return column;
	}
	/**
	 * 获取输血反应处理id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_dis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应处理id"); 
		return column;
	}
	/**
	 * 获取输血反应处理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_dis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血反应处理编码"); 
		return column;
	}
	/**
	 * 获取遵医嘱给予表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_blood_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_blood_dis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("遵医嘱给予"); 
		return column;
	}
	/**
	 * 获取患者多少分钟缓解表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_time_remCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_time_rem");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者多少分钟缓解"); 
		return column;
	}
	/**
	 * 获取经治医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBy_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"By_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("经治医师"); 
		return column;
	}
	/**
	 * 获取输血护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBl_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bl_nurse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血护士"); 
		return column;
	}
	/**
	 * 获取是否差错引起不良表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMe_whether_errorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Me_whether_error");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否差错引起不良"); 
		return column;
	}
	/**
	 * 获取输血事件错误发生阶段id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_error_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_error_stage");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血事件错误发生阶段id"); 
		return column;
	}
	/**
	 * 获取输血事件错误发生阶段编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_error_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_error_stage");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血事件错误发生阶段编码"); 
		return column;
	}
	/**
	 * 获取其他输血事件错误发生阶段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOth_error_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oth_error_stage");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他输血事件错误发生阶段"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl1_kind_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1_kind_blood");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_events_reactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_events_reaction");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCtrl1_occur_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ctrl1_occur_time");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_me_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_me_history");
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
	private IColumnDesc getName_re_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_re_history");
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
	private IColumnDesc getName_pl_teCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pl_te");
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
	private IColumnDesc getName_blood_disCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_dis");
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
	private IColumnDesc getName_error_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_error_stage");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
