
package iih.ci.mr.nu.icupatientcare.d.desc;

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
 * ICU患者护理记录 DO 元数据信息
 */
public class IcuPatientCareDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.icupatientcare.d.IcuPatientCareDO";
	public static final String CLASS_DISPALYNAME = "ICU患者护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_icupatientinfo_rec";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_icupatientcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public IcuPatientCareDODesc(){
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
		this.setKeyDesc(getId_icupatientcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_patinforADesc(tblDesc));
		this.add(getId_icupatientcareADesc(tblDesc));
		this.add(getId_patinforADesc(tblDesc));
		this.add(getPatternADesc(tblDesc));
		this.add(getKposition_situationADesc(tblDesc));
		this.add(getIll_observeanalyseADesc(tblDesc));
		this.add(getAss_gradeADesc(tblDesc));
		this.add(getLeftpupsizeADesc(tblDesc));
		this.add(getRightpupsizeADesc(tblDesc));
		this.add(getCvpADesc(tblDesc));
		this.add(getDamp_amountADesc(tblDesc));
		this.add(getFrequency_timesADesc(tblDesc));
		this.add(getPeepADesc(tblDesc));
		this.add(getTakein_amountADesc(tblDesc));
		this.add(getPasswater_amountADesc(tblDesc));
		this.add(getPaswateroth_amountADesc(tblDesc));
		this.add(getDrain_tube_graduateADesc(tblDesc));
		this.add(getVein_tube_graduateADesc(tblDesc));
		this.add(getIntubate_depthADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getOxygen_potencyADesc(tblDesc));
		this.add(getOxygen_take_potencyADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getSpo2ADesc(tblDesc));
		this.add(getIs_pressADesc(tblDesc));
		this.add(getIs_unobstructeADesc(tblDesc));
		this.add(getIs_replaceADesc(tblDesc));
		this.add(getIs_veincareADesc(tblDesc));
		this.add(getVein_fluidvolumADesc(tblDesc));
		this.add(getVtube_isunobstructeADesc(tblDesc));
		this.add(getIs_changedrugADesc(tblDesc));
		this.add(getAtomizeADesc(tblDesc));
		this.add(getSputumADesc(tblDesc));
		this.add(getIs_oralcareADesc(tblDesc));
		this.add(getIs_perineumcareADesc(tblDesc));
		this.add(getIs_bedbathADesc(tblDesc));
		this.add(getIs_backexpectorateADesc(tblDesc));
		this.add(getIs_vibratexpectorateADesc(tblDesc));
		this.add(getIs_skincareADesc(tblDesc));
		this.add(getMdateADesc(tblDesc));
		this.add(getFill_timeADesc(tblDesc));
		this.add(getMtimeADesc(tblDesc));
		this.add(getIs_breathclearADesc(tblDesc));
		this.add(getIs_skinokADesc(tblDesc));
		this.add(getSputum_amountADesc(tblDesc));
		this.add(getId_senseADesc(tblDesc));
		this.add(getSd_senseADesc(tblDesc));
		this.add(getId_leftpupreflectADesc(tblDesc));
		this.add(getSd_leftpupreflectADesc(tblDesc));
		this.add(getId_rightpupreflectADesc(tblDesc));
		this.add(getSd_rightpupreflectADesc(tblDesc));
		this.add(getId_arti_airway_modeADesc(tblDesc));
		this.add(getSd_arti_airway_modeADesc(tblDesc));
		this.add(getId_left_breath_soundADesc(tblDesc));
		this.add(getSd_left_breath_soundADesc(tblDesc));
		this.add(getId_right_breath_soundADesc(tblDesc));
		this.add(getSd_right_breath_soundADesc(tblDesc));
		this.add(getId_oxygen_takewayADesc(tblDesc));
		this.add(getSd_oxygen_takewayADesc(tblDesc));
		this.add(getId_drain_tube_nameADesc(tblDesc));
		this.add(getSd_drain_tube_nameADesc(tblDesc));
		this.add(getId_drainage_colorADesc(tblDesc));
		this.add(getSd_drainage_colorADesc(tblDesc));
		this.add(getId_vein_tube_nameADesc(tblDesc));
		this.add(getSd_vein_tube_nameADesc(tblDesc));
		this.add(getId_sputum_colorADesc(tblDesc));
		this.add(getSd_sputum_colorADesc(tblDesc));
		this.add(getId_keep_positionADesc(tblDesc));
		this.add(getSd_keep_positionADesc(tblDesc));
		this.add(getId_skin_careADesc(tblDesc));
		this.add(getSd_skin_careADesc(tblDesc));
		this.add(getId_other_careADesc(tblDesc));
		this.add(getSd_other_careADesc(tblDesc));
		this.add(getId_body_positionADesc(tblDesc));
		this.add(getSd_body_positionADesc(tblDesc));
		this.add(getFill_peopleADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_senseADesc(tblDesc));
		this.add(getName_leftpupreflectADesc(tblDesc));
		this.add(getName_rightpupreflectADesc(tblDesc));
		this.add(getName_artiairmodeADesc(tblDesc));
		this.add(getName_leftbthsoundADesc(tblDesc));
		this.add(getName_rightbthsoundADesc(tblDesc));
		this.add(getName_oxygentakewADesc(tblDesc));
		this.add(getName_drain_tubeADesc(tblDesc));
		this.add(getName_drainagecolorADesc(tblDesc));
		this.add(getName_veintubeADesc(tblDesc));
		this.add(getName_sputumcolorADesc(tblDesc));
		this.add(getName_keeppositionADesc(tblDesc));
		this.add(getName_skincareADesc(tblDesc));
		this.add(getName_othercareADesc(tblDesc));
		this.add(getName_body_positionADesc(tblDesc));
		this.add(getName_peopleADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_icupatientcareCDesc(tblDesc));
		tblDesc.add(getId_icupatientcareCDesc(tblDesc));
		tblDesc.add(getId_patinforCDesc(tblDesc));
		tblDesc.add(getPatternCDesc(tblDesc));
		tblDesc.add(getKposition_situationCDesc(tblDesc));
		tblDesc.add(getIll_observeanalyseCDesc(tblDesc));
		tblDesc.add(getAss_gradeCDesc(tblDesc));
		tblDesc.add(getLeftpupsizeCDesc(tblDesc));
		tblDesc.add(getRightpupsizeCDesc(tblDesc));
		tblDesc.add(getCvpCDesc(tblDesc));
		tblDesc.add(getDamp_amountCDesc(tblDesc));
		tblDesc.add(getFrequency_timesCDesc(tblDesc));
		tblDesc.add(getPeepCDesc(tblDesc));
		tblDesc.add(getTakein_amountCDesc(tblDesc));
		tblDesc.add(getPasswater_amountCDesc(tblDesc));
		tblDesc.add(getPaswateroth_amountCDesc(tblDesc));
		tblDesc.add(getDrain_tube_graduateCDesc(tblDesc));
		tblDesc.add(getVein_tube_graduateCDesc(tblDesc));
		tblDesc.add(getIntubate_depthCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getOxygen_potencyCDesc(tblDesc));
		tblDesc.add(getOxygen_take_potencyCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getSpo2CDesc(tblDesc));
		tblDesc.add(getIs_pressCDesc(tblDesc));
		tblDesc.add(getIs_unobstructeCDesc(tblDesc));
		tblDesc.add(getIs_replaceCDesc(tblDesc));
		tblDesc.add(getIs_veincareCDesc(tblDesc));
		tblDesc.add(getVein_fluidvolumCDesc(tblDesc));
		tblDesc.add(getVtube_isunobstructeCDesc(tblDesc));
		tblDesc.add(getIs_changedrugCDesc(tblDesc));
		tblDesc.add(getAtomizeCDesc(tblDesc));
		tblDesc.add(getSputumCDesc(tblDesc));
		tblDesc.add(getIs_oralcareCDesc(tblDesc));
		tblDesc.add(getIs_perineumcareCDesc(tblDesc));
		tblDesc.add(getIs_bedbathCDesc(tblDesc));
		tblDesc.add(getIs_backexpectorateCDesc(tblDesc));
		tblDesc.add(getIs_vibratexpectorateCDesc(tblDesc));
		tblDesc.add(getIs_skincareCDesc(tblDesc));
		tblDesc.add(getMdateCDesc(tblDesc));
		tblDesc.add(getFill_timeCDesc(tblDesc));
		tblDesc.add(getMtimeCDesc(tblDesc));
		tblDesc.add(getIs_breathclearCDesc(tblDesc));
		tblDesc.add(getIs_skinokCDesc(tblDesc));
		tblDesc.add(getSputum_amountCDesc(tblDesc));
		tblDesc.add(getId_senseCDesc(tblDesc));
		tblDesc.add(getSd_senseCDesc(tblDesc));
		tblDesc.add(getId_leftpupreflectCDesc(tblDesc));
		tblDesc.add(getSd_leftpupreflectCDesc(tblDesc));
		tblDesc.add(getId_rightpupreflectCDesc(tblDesc));
		tblDesc.add(getSd_rightpupreflectCDesc(tblDesc));
		tblDesc.add(getId_arti_airway_modeCDesc(tblDesc));
		tblDesc.add(getSd_arti_airway_modeCDesc(tblDesc));
		tblDesc.add(getId_left_breath_soundCDesc(tblDesc));
		tblDesc.add(getSd_left_breath_soundCDesc(tblDesc));
		tblDesc.add(getId_right_breath_soundCDesc(tblDesc));
		tblDesc.add(getSd_right_breath_soundCDesc(tblDesc));
		tblDesc.add(getId_oxygen_takewayCDesc(tblDesc));
		tblDesc.add(getSd_oxygen_takewayCDesc(tblDesc));
		tblDesc.add(getId_drain_tube_nameCDesc(tblDesc));
		tblDesc.add(getSd_drain_tube_nameCDesc(tblDesc));
		tblDesc.add(getId_drainage_colorCDesc(tblDesc));
		tblDesc.add(getSd_drainage_colorCDesc(tblDesc));
		tblDesc.add(getId_vein_tube_nameCDesc(tblDesc));
		tblDesc.add(getSd_vein_tube_nameCDesc(tblDesc));
		tblDesc.add(getId_sputum_colorCDesc(tblDesc));
		tblDesc.add(getSd_sputum_colorCDesc(tblDesc));
		tblDesc.add(getId_keep_positionCDesc(tblDesc));
		tblDesc.add(getSd_keep_positionCDesc(tblDesc));
		tblDesc.add(getId_skin_careCDesc(tblDesc));
		tblDesc.add(getSd_skin_careCDesc(tblDesc));
		tblDesc.add(getId_other_careCDesc(tblDesc));
		tblDesc.add(getSd_other_careCDesc(tblDesc));
		tblDesc.add(getId_body_positionCDesc(tblDesc));
		tblDesc.add(getSd_body_positionCDesc(tblDesc));
		tblDesc.add(getFill_peopleCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * icu患者护理记录单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_icupatientcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_icupatientcare",  getId_icupatientcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("icu患者护理记录单ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patinforADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patinfor",  getId_patinforCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatternADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pattern",  getPatternCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 约束部位情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKposition_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Kposition_situation",  getKposition_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("约束部位情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察及分析属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIll_observeanalyseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ill_observeanalyse",  getIll_observeanalyseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察及分析");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 格拉斯哥评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAss_gradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ass_grade",  getAss_gradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("格拉斯哥评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳孔大小(mm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLeftpupsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Leftpupsize",  getLeftpupsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("左瞳孔大小(mm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔大小(mm)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRightpupsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rightpupsize",  getRightpupsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("右瞳孔大小(mm)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * CVP(cmH2O)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCvpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cvp",  getCvpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("CVP(cmH2O)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮气量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDamp_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Damp_amount",  getDamp_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("潮气量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 频率次(bmp)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrequency_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Frequency_times",  getFrequency_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("频率次(bmp)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PEEP属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Peep",  getPeepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("PEEP");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTakein_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Takein_amount",  getTakein_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("入量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出量(尿)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPasswater_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Passwater_amount",  getPasswater_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出量(尿)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出量(其它)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaswateroth_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paswateroth_amount",  getPaswateroth_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出量(其它)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管刻度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrain_tube_graduateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drain_tube_graduate",  getDrain_tube_graduateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("引流管刻度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉管刻度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVein_tube_graduateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vein_tube_graduate",  getVein_tube_graduateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉管刻度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 插管深度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIntubate_depthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Intubate_depth",  getIntubate_depthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("插管深度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre",  getSys_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre",  getDia_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 氧浓度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxygen_potencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxygen_potency",  getOxygen_potencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("氧浓度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧浓度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOxygen_take_potencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oxygen_take_potency",  getOxygen_take_potencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("吸氧浓度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tem",  getTemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartrate",  getHeartrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * SPO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpo2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Spo2",  getSpo2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("SPO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管是否挤压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_pressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_press",  getIs_pressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引流管是否挤压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管是否通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_unobstructeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_unobstructe",  getIs_unobstructeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引流管是否通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管是否更换属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_replaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_replace",  getIs_replaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引流管是否更换");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否静脉护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_veincareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_veincare",  getIs_veincareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否静脉护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉液量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVein_fluidvolumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vein_fluidvolum",  getVein_fluidvolumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉液量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉管是否畅通属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVtube_isunobstructeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vtube_isunobstructe",  getVtube_isunobstructeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("静脉管是否畅通");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否气切换药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_changedrugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_changedrug",  getIs_changedrugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否气切换药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 雾化属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAtomizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Atomize",  getAtomizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("雾化");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸痰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSputumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sputum",  getSputumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("吸痰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否口腔护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_oralcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_oralcare",  getIs_oralcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否口腔护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否会阴护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_perineumcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_perineumcare",  getIs_perineumcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否会阴护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否床上擦浴属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_bedbathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_bedbath",  getIs_bedbathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否床上擦浴");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否拍背排痰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_backexpectorateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_backexpectorate",  getIs_backexpectorateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否拍背排痰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否振动排痰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_vibratexpectorateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_vibratexpectorate",  getIs_vibratexpectorateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否振动排痰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否皮肤护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_skincareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_skincare",  getIs_skincareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否皮肤护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMdateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mdate",  getMdateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_time",  getFill_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("填报时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mtime",  getMtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸音是否清晰属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_breathclearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_breathclear",  getIs_breathclearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("呼吸音是否清晰");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤是否完好属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_skinokADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_skinok",  getIs_skinokCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("皮肤是否完好");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 痰量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSputum_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sputum_amount",  getSputum_amountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("痰量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sense",  getId_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 神志编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sense",  getSd_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_leftpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_leftpupreflect",  getId_leftpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左瞳孔反射编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_leftpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_leftpupreflect",  getSd_leftpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rightpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rightpupreflect",  getId_rightpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rightpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rightpupreflect",  getSd_rightpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人工气道方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_arti_airway_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_arti_airway_mode",  getId_arti_airway_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人工气道方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人工气道方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_arti_airway_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_arti_airway_mode",  getSd_arti_airway_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人工气道方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左呼吸音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_left_breath_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_left_breath_sound",  getId_left_breath_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左呼吸音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左呼吸音编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_left_breath_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_left_breath_sound",  getSd_left_breath_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左呼吸音编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右呼吸音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_right_breath_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_right_breath_sound",  getId_right_breath_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右呼吸音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右呼吸音编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_right_breath_soundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_right_breath_sound",  getSd_right_breath_soundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右呼吸音编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oxygen_takewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oxygen_takeway",  getId_oxygen_takewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吸氧方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oxygen_takewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oxygen_takeway",  getSd_oxygen_takewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drain_tube_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drain_tube_name",  getId_drain_tube_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流管名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drain_tube_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drain_tube_name",  getSd_drain_tube_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流液颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drainage_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drainage_color",  getId_drainage_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流液颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流液颜色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drainage_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drainage_color",  getSd_drainage_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流液颜色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vein_tube_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vein_tube_name",  getId_vein_tube_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉置管名称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vein_tube_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vein_tube_name",  getSd_vein_tube_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 痰色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sputum_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sputum_color",  getId_sputum_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("痰色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 痰色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sputum_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sputum_color",  getSd_sputum_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("痰色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 约束部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_keep_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_keep_position",  getId_keep_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("约束部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 约束部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_keep_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_keep_position",  getSd_keep_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("约束部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_care",  getId_skin_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_care",  getSd_skin_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_other_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_other_care",  getId_other_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 其它护理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_other_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_other_care",  getSd_other_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它护理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_body_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_body_position",  getId_body_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_body_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_body_position",  getSd_body_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士填报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_peopleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_people",  getFill_peopleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 神志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_senseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sense",  getName_senseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b4","id_sense=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_leftpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_leftpupreflect",  getName_leftpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_leftpupreflect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳孔反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rightpupreflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rightpupreflect",  getName_rightpupreflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右瞳孔反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_rightpupreflect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人工气道方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_artiairmodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_artiairmode",  getName_artiairmodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人工气道方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_arti_airway_mode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左呼吸音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_leftbthsoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_leftbthsound",  getName_leftbthsoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左呼吸音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_left_breath_sound=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右呼吸音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rightbthsoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rightbthsound",  getName_rightbthsoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右呼吸音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_right_breath_sound=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸氧方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oxygentakewADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oxygentakew",  getName_oxygentakewCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸氧方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b10","id_oxygen_takeway=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drain_tubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drain_tube",  getName_drain_tubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b11","id_drain_tube_name=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流液颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drainagecolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drainagecolor",  getName_drainagecolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流液颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b12","id_drainage_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉置管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_veintubeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_veintube",  getName_veintubeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉置管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b13","id_vein_tube_name=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 痰色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sputumcolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sputumcolor",  getName_sputumcolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("痰色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b14","id_sputum_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 约束部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_keeppositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_keepposition",  getName_keeppositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("约束部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b15","id_keep_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤护理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skincareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skincare",  getName_skincareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤护理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b18","id_skin_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它护理项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_othercareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_othercare",  getName_othercareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它护理项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b19","id_other_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_body_positionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_body_position",  getName_body_positionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b23","id_body_position=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peopleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_people",  getName_peopleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b24","fill_people=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取icu患者护理记录单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_icupatientcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_icupatientcare");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("icu患者护理记录单ID"); 
		return column;
	}
	/**
	 * 获取患者信息ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patinforCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patinfor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息ID"); 
		return column;
	}
	/**
	 * 获取模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatternCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pattern");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模式"); 
		return column;
	}
	/**
	 * 获取约束部位情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKposition_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Kposition_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("约束部位情况"); 
		return column;
	}
	/**
	 * 获取病情观察及分析表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIll_observeanalyseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ill_observeanalyse");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察及分析"); 
		return column;
	}
	/**
	 * 获取格拉斯哥评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAss_gradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ass_grade");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("格拉斯哥评分"); 
		return column;
	}
	/**
	 * 获取左瞳孔大小(mm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLeftpupsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Leftpupsize");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("左瞳孔大小(mm)"); 
		return column;
	}
	/**
	 * 获取右瞳孔大小(mm)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRightpupsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rightpupsize");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("右瞳孔大小(mm)"); 
		return column;
	}
	/**
	 * 获取CVP(cmH2O)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCvpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cvp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("CVP(cmH2O)"); 
		return column;
	}
	/**
	 * 获取潮气量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDamp_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Damp_amount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("潮气量"); 
		return column;
	}
	/**
	 * 获取频率次(bmp)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrequency_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Frequency_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("频率次(bmp)"); 
		return column;
	}
	/**
	 * 获取PEEP表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Peep");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("PEEP"); 
		return column;
	}
	/**
	 * 获取入量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTakein_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Takein_amount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("入量"); 
		return column;
	}
	/**
	 * 获取出量(尿)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPasswater_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Passwater_amount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出量(尿)"); 
		return column;
	}
	/**
	 * 获取出量(其它)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaswateroth_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paswateroth_amount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出量(其它)"); 
		return column;
	}
	/**
	 * 获取引流管刻度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrain_tube_graduateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drain_tube_graduate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("引流管刻度"); 
		return column;
	}
	/**
	 * 获取静脉管刻度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVein_tube_graduateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vein_tube_graduate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉管刻度"); 
		return column;
	}
	/**
	 * 获取插管深度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIntubate_depthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Intubate_depth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("插管深度"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取氧浓度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxygen_potencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxygen_potency");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("氧浓度"); 
		return column;
	}
	/**
	 * 获取吸氧浓度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOxygen_take_potencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oxygen_take_potency");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("吸氧浓度"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tem");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartrate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率"); 
		return column;
	}
	/**
	 * 获取SPO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpo2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Spo2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("SPO2"); 
		return column;
	}
	/**
	 * 获取引流管是否挤压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_pressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_press");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引流管是否挤压"); 
		return column;
	}
	/**
	 * 获取引流管是否通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_unobstructeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_unobstructe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引流管是否通畅"); 
		return column;
	}
	/**
	 * 获取引流管是否更换表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_replaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_replace");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引流管是否更换"); 
		return column;
	}
	/**
	 * 获取是否静脉护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_veincareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_veincare");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否静脉护理"); 
		return column;
	}
	/**
	 * 获取静脉液量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVein_fluidvolumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vein_fluidvolum");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉液量"); 
		return column;
	}
	/**
	 * 获取静脉管是否畅通表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVtube_isunobstructeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vtube_isunobstructe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("静脉管是否畅通"); 
		return column;
	}
	/**
	 * 获取是否气切换药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_changedrugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_changedrug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否气切换药"); 
		return column;
	}
	/**
	 * 获取雾化表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAtomizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Atomize");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("雾化"); 
		return column;
	}
	/**
	 * 获取吸痰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSputumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sputum");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("吸痰"); 
		return column;
	}
	/**
	 * 获取是否口腔护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_oralcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_oralcare");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否口腔护理"); 
		return column;
	}
	/**
	 * 获取是否会阴护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_perineumcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_perineumcare");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否会阴护理"); 
		return column;
	}
	/**
	 * 获取是否床上擦浴表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_bedbathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_bedbath");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否床上擦浴"); 
		return column;
	}
	/**
	 * 获取是否拍背排痰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_backexpectorateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_backexpectorate");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否拍背排痰"); 
		return column;
	}
	/**
	 * 获取是否振动排痰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_vibratexpectorateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_vibratexpectorate");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否振动排痰"); 
		return column;
	}
	/**
	 * 获取是否皮肤护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_skincareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_skincare");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否皮肤护理"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMdateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mdate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取填报时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填报时间"); 
		return column;
	}
	/**
	 * 获取时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mtime");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("时间"); 
		return column;
	}
	/**
	 * 获取呼吸音是否清晰表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_breathclearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_breathclear");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("呼吸音是否清晰"); 
		return column;
	}
	/**
	 * 获取皮肤是否完好表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_skinokCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_skinok");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("皮肤是否完好"); 
		return column;
	}
	/**
	 * 获取痰量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSputum_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sputum_amount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("痰量"); 
		return column;
	}
	/**
	 * 获取神志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sense");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志"); 
		return column;
	}
	/**
	 * 获取神志编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sense");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志编码"); 
		return column;
	}
	/**
	 * 获取左瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_leftpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_leftpupreflect");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射"); 
		return column;
	}
	/**
	 * 获取左瞳孔反射编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_leftpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_leftpupreflect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射编码"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rightpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rightpupreflect");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rightpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rightpupreflect");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射编码"); 
		return column;
	}
	/**
	 * 获取人工气道方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_arti_airway_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_arti_airway_mode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人工气道方式"); 
		return column;
	}
	/**
	 * 获取人工气道方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_arti_airway_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_arti_airway_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人工气道方式编码"); 
		return column;
	}
	/**
	 * 获取左呼吸音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_left_breath_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_left_breath_sound");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左呼吸音"); 
		return column;
	}
	/**
	 * 获取左呼吸音编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_left_breath_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_left_breath_sound");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左呼吸音编码"); 
		return column;
	}
	/**
	 * 获取右呼吸音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_right_breath_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_right_breath_sound");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右呼吸音"); 
		return column;
	}
	/**
	 * 获取右呼吸音编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_right_breath_soundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_right_breath_sound");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右呼吸音编码"); 
		return column;
	}
	/**
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oxygen_takewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oxygen_takeway");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式"); 
		return column;
	}
	/**
	 * 获取吸氧方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oxygen_takewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oxygen_takeway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式编码"); 
		return column;
	}
	/**
	 * 获取引流管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drain_tube_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drain_tube_name");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管名称"); 
		return column;
	}
	/**
	 * 获取引流管名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drain_tube_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drain_tube_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管名称编码"); 
		return column;
	}
	/**
	 * 获取引流液颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drainage_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drainage_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流液颜色"); 
		return column;
	}
	/**
	 * 获取引流液颜色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drainage_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drainage_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流液颜色编码"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vein_tube_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vein_tube_name");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称"); 
		return column;
	}
	/**
	 * 获取静脉置管名称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vein_tube_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vein_tube_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称编码"); 
		return column;
	}
	/**
	 * 获取痰色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sputum_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sputum_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("痰色"); 
		return column;
	}
	/**
	 * 获取痰色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sputum_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sputum_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("痰色编码"); 
		return column;
	}
	/**
	 * 获取约束部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_keep_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_keep_position");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("约束部位"); 
		return column;
	}
	/**
	 * 获取约束部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_keep_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_keep_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("约束部位编码"); 
		return column;
	}
	/**
	 * 获取皮肤护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_care");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤护理"); 
		return column;
	}
	/**
	 * 获取皮肤护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_care");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤护理编码"); 
		return column;
	}
	/**
	 * 获取其它护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_other_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_other_care");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它护理"); 
		return column;
	}
	/**
	 * 获取其它护理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_other_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_other_care");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它护理编码"); 
		return column;
	}
	/**
	 * 获取体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_body_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_body_position");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位"); 
		return column;
	}
	/**
	 * 获取体位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_body_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_body_position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位编码"); 
		return column;
	}
	/**
	 * 获取护士填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_peopleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_people");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士填报人"); 
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
	 * 获取神志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_senseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sense");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志"); 
		return column;
	}
	/**
	 * 获取左瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_leftpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_leftpupreflect");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左瞳孔反射"); 
		return column;
	}
	/**
	 * 获取右瞳孔反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rightpupreflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rightpupreflect");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右瞳孔反射"); 
		return column;
	}
	/**
	 * 获取人工气道方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_artiairmodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_artiairmode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人工气道方式"); 
		return column;
	}
	/**
	 * 获取左呼吸音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_leftbthsoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_leftbthsound");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左呼吸音"); 
		return column;
	}
	/**
	 * 获取右呼吸音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rightbthsoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rightbthsound");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右呼吸音"); 
		return column;
	}
	/**
	 * 获取吸氧方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oxygentakewCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oxygentakew");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸氧方式"); 
		return column;
	}
	/**
	 * 获取引流管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drain_tubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drain_tube");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管名称"); 
		return column;
	}
	/**
	 * 获取引流液颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drainagecolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drainagecolor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流液颜色"); 
		return column;
	}
	/**
	 * 获取静脉置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_veintubeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_veintube");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉置管名称"); 
		return column;
	}
	/**
	 * 获取痰色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sputumcolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sputumcolor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("痰色"); 
		return column;
	}
	/**
	 * 获取约束部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_keeppositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_keepposition");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("约束部位"); 
		return column;
	}
	/**
	 * 获取皮肤护理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skincareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skincare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤护理"); 
		return column;
	}
	/**
	 * 获取其它护理项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_othercareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_othercare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它护理项目"); 
		return column;
	}
	/**
	 * 获取体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_body_positionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_body_position");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_peopleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_people");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
	
}
