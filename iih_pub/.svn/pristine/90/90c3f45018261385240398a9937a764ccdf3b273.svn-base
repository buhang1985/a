
package iih.nmr.ha.tcho.admissionnursing.d.desc;

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
 * 入院护理评估记录单 DO 元数据信息
 */
public class TchoAdmissionNursingDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.admissionnursing.d.TchoAdmissionNursingDO";
	public static final String CLASS_DISPALYNAME = "入院护理评估记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_HA_TCHO_ADMISSIONNURSING";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ana";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoAdmissionNursingDODesc(){
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
		this.setKeyDesc(getId_anaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_anaADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getName_document_typeADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getId_route_admissionADesc(tblDesc));
		this.add(getSd_route_admissionADesc(tblDesc));
		this.add(getId_way_admissionADesc(tblDesc));
		this.add(getSd_way_admissionADesc(tblDesc));
		this.add(getPain_scoreADesc(tblDesc));
		this.add(getFg_pastmedicADesc(tblDesc));
		this.add(getAllergy_historyedADesc(tblDesc));
		this.add(getFg_allergyADesc(tblDesc));
		this.add(getPast_historyedADesc(tblDesc));
		this.add(getId_solar_illADesc(tblDesc));
		this.add(getSd_solar_illADesc(tblDesc));
		this.add(getFg_unobstructedADesc(tblDesc));
		this.add(getPipescarryedADesc(tblDesc));
		this.add(getFg_carry_pipesADesc(tblDesc));
		this.add(getEast_diagnosisADesc(tblDesc));
		this.add(getWestern_diagnosisADesc(tblDesc));
		this.add(getId_look_statesADesc(tblDesc));
		this.add(getSd_look_statesADesc(tblDesc));
		this.add(getOther_look_statesADesc(tblDesc));
		this.add(getId_complexionADesc(tblDesc));
		this.add(getSd_complexionADesc(tblDesc));
		this.add(getOther_complexionADesc(tblDesc));
		this.add(getId_shapeADesc(tblDesc));
		this.add(getSd_shapeADesc(tblDesc));
		this.add(getOther_shapeADesc(tblDesc));
		this.add(getId_formADesc(tblDesc));
		this.add(getSd_formADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getOther_skinADesc(tblDesc));
		this.add(getId_tongueADesc(tblDesc));
		this.add(getSd_tongueADesc(tblDesc));
		this.add(getOther_tongueADesc(tblDesc));
		this.add(getId_furred_tongueADesc(tblDesc));
		this.add(getSd_furred_tongueADesc(tblDesc));
		this.add(getOther_furred_tongueADesc(tblDesc));
		this.add(getId_voiceADesc(tblDesc));
		this.add(getSd_voiceADesc(tblDesc));
		this.add(getOther_voiceADesc(tblDesc));
		this.add(getId_breatheADesc(tblDesc));
		this.add(getSd_breatheADesc(tblDesc));
		this.add(getOther_breatheADesc(tblDesc));
		this.add(getId_coughADesc(tblDesc));
		this.add(getSd_coughADesc(tblDesc));
		this.add(getOther_coughADesc(tblDesc));
		this.add(getId_cold_heatADesc(tblDesc));
		this.add(getSd_cold_heatADesc(tblDesc));
		this.add(getOther_cold_heatADesc(tblDesc));
		this.add(getId_sweatADesc(tblDesc));
		this.add(getSd_sweatADesc(tblDesc));
		this.add(getOther_sweatADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getOther_dietADesc(tblDesc));
		this.add(getId_sleepADesc(tblDesc));
		this.add(getSd_sleepADesc(tblDesc));
		this.add(getOther_sleepADesc(tblDesc));
		this.add(getId_stoolADesc(tblDesc));
		this.add(getSd_stoolADesc(tblDesc));
		this.add(getOther_stoolADesc(tblDesc));
		this.add(getId_urinateADesc(tblDesc));
		this.add(getSd_urinateADesc(tblDesc));
		this.add(getOther_urinateADesc(tblDesc));
		this.add(getId_hobbyADesc(tblDesc));
		this.add(getSd_hobbyADesc(tblDesc));
		this.add(getOther_hobbyADesc(tblDesc));
		this.add(getId_pulseADesc(tblDesc));
		this.add(getSd_pulseADesc(tblDesc));
		this.add(getOther_pulseADesc(tblDesc));
		this.add(getId_wristADesc(tblDesc));
		this.add(getSd_wristADesc(tblDesc));
		this.add(getOther_wristADesc(tblDesc));
		this.add(getId_selt_careADesc(tblDesc));
		this.add(getSd_selt_careADesc(tblDesc));
		this.add(getId_family_relationADesc(tblDesc));
		this.add(getSd_family_relationADesc(tblDesc));
		this.add(getId_social_adaptabilityADesc(tblDesc));
		this.add(getSd_social_adaptabilityADesc(tblDesc));
		this.add(getId_left_legADesc(tblDesc));
		this.add(getSd_left_legADesc(tblDesc));
		this.add(getId_right_legADesc(tblDesc));
		this.add(getSd_right_legADesc(tblDesc));
		this.add(getId_left_handADesc(tblDesc));
		this.add(getSd_left_handADesc(tblDesc));
		this.add(getId_right_handADesc(tblDesc));
		this.add(getSd_right_handADesc(tblDesc));
		this.add(getId_spineADesc(tblDesc));
		this.add(getSd_spineADesc(tblDesc));
		this.add(getId_etiologyADesc(tblDesc));
		this.add(getSd_etiologyADesc(tblDesc));
		this.add(getOther_etiologyADesc(tblDesc));
		this.add(getId_sick_placeADesc(tblDesc));
		this.add(getSd_sick_placeADesc(tblDesc));
		this.add(getOther_sick_placeADesc(tblDesc));
		this.add(getId_admission_missionADesc(tblDesc));
		this.add(getSd_admission_missionADesc(tblDesc));
		this.add(getNurse_planADesc(tblDesc));
		this.add(getId_emp_evaluationADesc(tblDesc));
		this.add(getDt_evaluationADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getSyndromesADesc(tblDesc));
		this.add(getName_route_admissionADesc(tblDesc));
		this.add(getName_way_admissionADesc(tblDesc));
		this.add(getName_solar_illADesc(tblDesc));
		this.add(getName_look_statesADesc(tblDesc));
		this.add(getName_complexionADesc(tblDesc));
		this.add(getName_shapeADesc(tblDesc));
		this.add(getName_formADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_tongueADesc(tblDesc));
		this.add(getName_furred_tongueADesc(tblDesc));
		this.add(getName_voiceADesc(tblDesc));
		this.add(getName_breatheADesc(tblDesc));
		this.add(getName_coughADesc(tblDesc));
		this.add(getName_cold_heatADesc(tblDesc));
		this.add(getName_sweatADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getName_sleepADesc(tblDesc));
		this.add(getName_stoolADesc(tblDesc));
		this.add(getName_urinateADesc(tblDesc));
		this.add(getName_hobbyADesc(tblDesc));
		this.add(getName_pulseADesc(tblDesc));
		this.add(getName_wristADesc(tblDesc));
		this.add(getName_selt_careADesc(tblDesc));
		this.add(getName_family_relationADesc(tblDesc));
		this.add(getName_social_adaptabilityADesc(tblDesc));
		this.add(getName_left_legADesc(tblDesc));
		this.add(getName_right_legADesc(tblDesc));
		this.add(getName_left_handADesc(tblDesc));
		this.add(getName_right_handADesc(tblDesc));
		this.add(getName_spineADesc(tblDesc));
		this.add(getName_etiologyADesc(tblDesc));
		this.add(getName_sick_placeADesc(tblDesc));
		this.add(getName_admission_missionADesc(tblDesc));
		this.add(getName_emp_evaluationADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_anaCDesc(tblDesc));
		tblDesc.add(getId_anaCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getName_document_typeCDesc(tblDesc));
		tblDesc.add(getName_nationCDesc(tblDesc));
		tblDesc.add(getId_route_admissionCDesc(tblDesc));
		tblDesc.add(getSd_route_admissionCDesc(tblDesc));
		tblDesc.add(getId_way_admissionCDesc(tblDesc));
		tblDesc.add(getSd_way_admissionCDesc(tblDesc));
		tblDesc.add(getPain_scoreCDesc(tblDesc));
		tblDesc.add(getFg_pastmedicCDesc(tblDesc));
		tblDesc.add(getAllergy_historyedCDesc(tblDesc));
		tblDesc.add(getFg_allergyCDesc(tblDesc));
		tblDesc.add(getPast_historyedCDesc(tblDesc));
		tblDesc.add(getId_solar_illCDesc(tblDesc));
		tblDesc.add(getSd_solar_illCDesc(tblDesc));
		tblDesc.add(getFg_unobstructedCDesc(tblDesc));
		tblDesc.add(getPipescarryedCDesc(tblDesc));
		tblDesc.add(getFg_carry_pipesCDesc(tblDesc));
		tblDesc.add(getEast_diagnosisCDesc(tblDesc));
		tblDesc.add(getWestern_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_look_statesCDesc(tblDesc));
		tblDesc.add(getSd_look_statesCDesc(tblDesc));
		tblDesc.add(getOther_look_statesCDesc(tblDesc));
		tblDesc.add(getId_complexionCDesc(tblDesc));
		tblDesc.add(getSd_complexionCDesc(tblDesc));
		tblDesc.add(getOther_complexionCDesc(tblDesc));
		tblDesc.add(getId_shapeCDesc(tblDesc));
		tblDesc.add(getSd_shapeCDesc(tblDesc));
		tblDesc.add(getOther_shapeCDesc(tblDesc));
		tblDesc.add(getId_formCDesc(tblDesc));
		tblDesc.add(getSd_formCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getOther_skinCDesc(tblDesc));
		tblDesc.add(getId_tongueCDesc(tblDesc));
		tblDesc.add(getSd_tongueCDesc(tblDesc));
		tblDesc.add(getOther_tongueCDesc(tblDesc));
		tblDesc.add(getId_furred_tongueCDesc(tblDesc));
		tblDesc.add(getSd_furred_tongueCDesc(tblDesc));
		tblDesc.add(getOther_furred_tongueCDesc(tblDesc));
		tblDesc.add(getId_voiceCDesc(tblDesc));
		tblDesc.add(getSd_voiceCDesc(tblDesc));
		tblDesc.add(getOther_voiceCDesc(tblDesc));
		tblDesc.add(getId_breatheCDesc(tblDesc));
		tblDesc.add(getSd_breatheCDesc(tblDesc));
		tblDesc.add(getOther_breatheCDesc(tblDesc));
		tblDesc.add(getId_coughCDesc(tblDesc));
		tblDesc.add(getSd_coughCDesc(tblDesc));
		tblDesc.add(getOther_coughCDesc(tblDesc));
		tblDesc.add(getId_cold_heatCDesc(tblDesc));
		tblDesc.add(getSd_cold_heatCDesc(tblDesc));
		tblDesc.add(getOther_cold_heatCDesc(tblDesc));
		tblDesc.add(getId_sweatCDesc(tblDesc));
		tblDesc.add(getSd_sweatCDesc(tblDesc));
		tblDesc.add(getOther_sweatCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getOther_dietCDesc(tblDesc));
		tblDesc.add(getId_sleepCDesc(tblDesc));
		tblDesc.add(getSd_sleepCDesc(tblDesc));
		tblDesc.add(getOther_sleepCDesc(tblDesc));
		tblDesc.add(getId_stoolCDesc(tblDesc));
		tblDesc.add(getSd_stoolCDesc(tblDesc));
		tblDesc.add(getOther_stoolCDesc(tblDesc));
		tblDesc.add(getId_urinateCDesc(tblDesc));
		tblDesc.add(getSd_urinateCDesc(tblDesc));
		tblDesc.add(getOther_urinateCDesc(tblDesc));
		tblDesc.add(getId_hobbyCDesc(tblDesc));
		tblDesc.add(getSd_hobbyCDesc(tblDesc));
		tblDesc.add(getOther_hobbyCDesc(tblDesc));
		tblDesc.add(getId_pulseCDesc(tblDesc));
		tblDesc.add(getSd_pulseCDesc(tblDesc));
		tblDesc.add(getOther_pulseCDesc(tblDesc));
		tblDesc.add(getId_wristCDesc(tblDesc));
		tblDesc.add(getSd_wristCDesc(tblDesc));
		tblDesc.add(getOther_wristCDesc(tblDesc));
		tblDesc.add(getId_selt_careCDesc(tblDesc));
		tblDesc.add(getSd_selt_careCDesc(tblDesc));
		tblDesc.add(getId_family_relationCDesc(tblDesc));
		tblDesc.add(getSd_family_relationCDesc(tblDesc));
		tblDesc.add(getId_social_adaptabilityCDesc(tblDesc));
		tblDesc.add(getSd_social_adaptabilityCDesc(tblDesc));
		tblDesc.add(getId_left_legCDesc(tblDesc));
		tblDesc.add(getSd_left_legCDesc(tblDesc));
		tblDesc.add(getId_right_legCDesc(tblDesc));
		tblDesc.add(getSd_right_legCDesc(tblDesc));
		tblDesc.add(getId_left_handCDesc(tblDesc));
		tblDesc.add(getSd_left_handCDesc(tblDesc));
		tblDesc.add(getId_right_handCDesc(tblDesc));
		tblDesc.add(getSd_right_handCDesc(tblDesc));
		tblDesc.add(getId_spineCDesc(tblDesc));
		tblDesc.add(getSd_spineCDesc(tblDesc));
		tblDesc.add(getId_etiologyCDesc(tblDesc));
		tblDesc.add(getSd_etiologyCDesc(tblDesc));
		tblDesc.add(getOther_etiologyCDesc(tblDesc));
		tblDesc.add(getId_sick_placeCDesc(tblDesc));
		tblDesc.add(getSd_sick_placeCDesc(tblDesc));
		tblDesc.add(getOther_sick_placeCDesc(tblDesc));
		tblDesc.add(getId_admission_missionCDesc(tblDesc));
		tblDesc.add(getSd_admission_missionCDesc(tblDesc));
		tblDesc.add(getNurse_planCDesc(tblDesc));
		tblDesc.add(getId_emp_evaluationCDesc(tblDesc));
		tblDesc.add(getDt_evaluationCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getSyndromesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入院护理评估单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ana",  getId_anaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院护理评估单主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_document_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_document_type",  getName_document_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_route_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_route_admission",  getId_route_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_route_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_route_admission",  getSd_route_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_way_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_way_admission",  getId_way_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_way_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_way_admission",  getSd_way_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPain_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pain_score",  getPain_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pastmedicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pastmedic",  getFg_pastmedicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("既往史有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllergy_historyedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allergy_historyed",  getAllergy_historyedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_allergy",  getFg_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("过敏史有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPast_historyedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Past_historyed",  getPast_historyedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发病节气属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_solar_illADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_solar_ill",  getId_solar_illCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发病节气");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发病节气编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_solar_illADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_solar_ill",  getSd_solar_illCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发病节气编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道是否通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_unobstructedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_unobstructed",  getFg_unobstructedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("管道是否通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 携带管道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipescarryedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipescarryed",  getPipescarryedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("携带管道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否携带管道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_carry_pipesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_carry_pipes",  getFg_carry_pipesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否携带管道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断(中医)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEast_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("East_diagnosis",  getEast_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断(中医)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断(西医)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWestern_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Western_diagnosis",  getWestern_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断(西医)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 望神属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_look_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_look_states",  getId_look_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("望神");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 望神编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_look_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_look_states",  getSd_look_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("望神编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 望神其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_look_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_look_states",  getOther_look_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("望神其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_complexionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_complexion",  getId_complexionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 面色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_complexionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_complexion",  getSd_complexionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_complexionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_complexion",  getOther_complexionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shape",  getId_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_shape",  getSd_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_shape",  getOther_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_form",  getId_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 形态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_form",  getSd_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_skin",  getOther_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tongue",  getId_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 舌质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tongue",  getSd_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌质其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_tongue",  getOther_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_furred_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_furred_tongue",  getId_furred_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 舌苔编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_furred_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_furred_tongue",  getSd_furred_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_furred_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_furred_tongue",  getOther_furred_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_voice",  getId_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 语音编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_voice",  getSd_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语音其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_voice",  getOther_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音其他");
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
	private IAttrDesc getId_breatheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breathe",  getId_breatheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breatheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breathe",  getSd_breatheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_breatheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_breathe",  getOther_breatheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 咳嗽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cough",  getId_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 咳嗽编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cough",  getSd_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 咳嗽其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_cough",  getOther_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 寒热属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cold_heatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cold_heat",  getId_cold_heatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("寒热");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 寒热编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cold_heatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cold_heat",  getSd_cold_heatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("寒热编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 寒热其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_cold_heatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_cold_heat",  getOther_cold_heatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("寒热其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 汗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sweatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sweat",  getId_sweatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("汗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 汗编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sweatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sweat",  getSd_sweatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("汗编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 汗其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_sweatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_sweat",  getOther_sweatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("汗其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diet",  getId_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet",  getSd_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_diet",  getOther_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sleep",  getId_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sleep",  getSd_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_sleep",  getOther_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stool",  getId_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stool",  getSd_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_stool",  getOther_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_urinateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_urinate",  getId_urinateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 小便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_urinateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_urinate",  getSd_urinateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_urinateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_urinate",  getOther_urinateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hobby",  getId_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 嗜好编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hobby",  getSd_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_hobby",  getOther_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pulse",  getId_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脉象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pulse",  getSd_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉象其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_pulse",  getOther_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉象其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腕腹属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wristADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wrist",  getId_wristCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腕腹");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 腕腹编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_wristADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_wrist",  getSd_wristCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腕腹编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腕腹其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_wristADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_wrist",  getOther_wristCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腕腹其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生活自理能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_selt_care",  getId_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活自理能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生活自理能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_selt_care",  getSd_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活自理能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_family_relationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_family_relation",  getId_family_relationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 家庭关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_family_relationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_family_relation",  getSd_family_relationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭关系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 社交适应能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_social_adaptabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_social_adaptability",  getId_social_adaptabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("社交适应能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 社交适应能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_social_adaptabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_social_adaptability",  getSd_social_adaptabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("社交适应能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左下肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_left_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_left_leg",  getId_left_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左下肢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左下肢编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_left_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_left_leg",  getSd_left_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左下肢编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右下肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_right_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_right_leg",  getId_right_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右下肢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右下肢编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_right_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_right_leg",  getSd_right_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右下肢编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左上肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_left_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_left_hand",  getId_left_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左上肢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左上肢编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_left_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_left_hand",  getSd_left_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左上肢编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右上肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_right_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_right_hand",  getId_right_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右上肢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右上肢编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_right_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_right_hand",  getSd_right_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右上肢编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脊柱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spine",  getId_spineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脊柱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脊柱编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spine",  getSd_spineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脊柱编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_etiologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_etiology",  getId_etiologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_etiologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_etiology",  getSd_etiologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病因其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_etiologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_etiology",  getOther_etiologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病因其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sick_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sick_place",  getId_sick_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sick_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sick_place",  getSd_sick_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病位其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_sick_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_sick_place",  getOther_sick_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病位其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admission_missionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admission_mission",  getId_admission_missionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院宣教编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_admission_missionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_admission_mission",  getSd_admission_missionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNurse_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nurse_plan",  getNurse_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_evaluationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_evaluation",  getId_emp_evaluationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_evaluationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_evaluation",  getDt_evaluationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估时间");
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
	 * 证型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSyndromesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Syndromes",  getSyndromesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院途径名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_route_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_route_admission",  getName_route_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院途径名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_route_admission=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_way_admissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_way_admission",  getName_way_admissionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_way_admission=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发病节气名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_solar_illADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_solar_ill",  getName_solar_illCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发病节气名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_solar_ill=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 望神名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_look_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_look_states",  getName_look_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("望神名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_look_states=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_complexionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_complexion",  getName_complexionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_complexion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shapeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shape",  getName_shapeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_shape=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_formADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_form",  getName_formCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_form=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌质名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tongue",  getName_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_tongue=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_furred_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_furred_tongue",  getName_furred_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_furred_tongue=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语音名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_voiceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_voice",  getName_voiceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语音名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_voice=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breatheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breathe",  getName_breatheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_breathe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 咳嗽名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cough",  getName_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_cough=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 寒热名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cold_heatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cold_heat",  getName_cold_heatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("寒热名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_cold_heat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 汗名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sweatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sweat",  getName_sweatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("汗名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_sweat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_diet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sleep",  getName_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_sleep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stoolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stool",  getName_stoolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_stool=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_urinateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_urinate",  getName_urinateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_urinate=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hobby",  getName_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_hobby=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉象名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pulse",  getName_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉象名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_pulse=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腕腹名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_wristADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wrist",  getName_wristCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("腕腹名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_wrist=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生活自理能力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_selt_careADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_selt_care",  getName_selt_careCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活自理能力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_selt_care=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭关系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_family_relationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_family_relation",  getName_family_relationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭关系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_family_relation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 社交适应能力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_social_adaptabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_social_adaptability",  getName_social_adaptabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("社交适应能力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_social_adaptability=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左下肢名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_left_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_left_leg",  getName_left_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左下肢名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_left_leg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右下肢名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_right_legADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_right_leg",  getName_right_legCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右下肢名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_right_leg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左上肢名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_left_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_left_hand",  getName_left_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左上肢名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_left_hand=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右上肢名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_right_handADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_right_hand",  getName_right_handCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右上肢名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_right_hand=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脊柱名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spine",  getName_spineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脊柱名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_spine=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病因名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_etiologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_etiology",  getName_etiologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病因名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_etiology=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sick_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sick_place",  getName_sick_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_sick_place=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_admission_missionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_admission_mission",  getName_admission_missionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_admission_mission=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_evaluationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_evaluation",  getName_emp_evaluationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b42","id_emp_evaluation=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取入院护理评估单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ana");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院护理评估单主键"); 
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
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取证件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_document_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_document_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件类型"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取入院途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_route_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_route_admission");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径"); 
		return column;
	}
	/**
	 * 获取入院途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_route_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_route_admission");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径编码"); 
		return column;
	}
	/**
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_way_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_way_admission");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式"); 
		return column;
	}
	/**
	 * 获取入院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_way_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_way_admission");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式编码"); 
		return column;
	}
	/**
	 * 获取疼痛分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPain_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pain_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛分"); 
		return column;
	}
	/**
	 * 获取既往史有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pastmedicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pastmedic");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("既往史有无"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllergy_historyedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allergy_historyed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取过敏史有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_allergy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("过敏史有无"); 
		return column;
	}
	/**
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPast_historyedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Past_historyed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史"); 
		return column;
	}
	/**
	 * 获取发病节气表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_solar_illCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_solar_ill");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发病节气"); 
		return column;
	}
	/**
	 * 获取发病节气编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_solar_illCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_solar_ill");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发病节气编码"); 
		return column;
	}
	/**
	 * 获取管道是否通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_unobstructedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_unobstructed");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("管道是否通畅"); 
		return column;
	}
	/**
	 * 获取携带管道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipescarryedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipescarryed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("携带管道"); 
		return column;
	}
	/**
	 * 获取是否携带管道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_carry_pipesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_carry_pipes");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否携带管道"); 
		return column;
	}
	/**
	 * 获取入院诊断(中医)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEast_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"East_diagnosis");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断(中医)"); 
		return column;
	}
	/**
	 * 获取入院诊断(西医)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWestern_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Western_diagnosis");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断(西医)"); 
		return column;
	}
	/**
	 * 获取望神表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_look_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_look_states");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("望神"); 
		return column;
	}
	/**
	 * 获取望神编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_look_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_look_states");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("望神编码"); 
		return column;
	}
	/**
	 * 获取望神其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_look_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_look_states");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("望神其他"); 
		return column;
	}
	/**
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_complexion");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色"); 
		return column;
	}
	/**
	 * 获取面色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_complexion");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色编码"); 
		return column;
	}
	/**
	 * 获取面色其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_complexion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色其他"); 
		return column;
	}
	/**
	 * 获取体态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shape");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体态"); 
		return column;
	}
	/**
	 * 获取体态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_shape");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体态编码"); 
		return column;
	}
	/**
	 * 获取形态其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_shape");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态其他"); 
		return column;
	}
	/**
	 * 获取形态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_form");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态"); 
		return column;
	}
	/**
	 * 获取形态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_form");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态编码"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤编码"); 
		return column;
	}
	/**
	 * 获取皮肤其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤其他"); 
		return column;
	}
	/**
	 * 获取舌质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tongue");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质"); 
		return column;
	}
	/**
	 * 获取舌质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tongue");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质编码"); 
		return column;
	}
	/**
	 * 获取舌质其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_tongue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质其他"); 
		return column;
	}
	/**
	 * 获取舌苔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_furred_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_furred_tongue");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔"); 
		return column;
	}
	/**
	 * 获取舌苔编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_furred_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_furred_tongue");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔编码"); 
		return column;
	}
	/**
	 * 获取舌苔其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_furred_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_furred_tongue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔其他"); 
		return column;
	}
	/**
	 * 获取语音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_voice");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音"); 
		return column;
	}
	/**
	 * 获取语音编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_voice");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音编码"); 
		return column;
	}
	/**
	 * 获取语音其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_voice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音其他"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breatheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breathe");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取呼吸编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breatheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breathe");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸编码"); 
		return column;
	}
	/**
	 * 获取呼吸其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_breatheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_breathe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸其他"); 
		return column;
	}
	/**
	 * 获取咳嗽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cough");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽"); 
		return column;
	}
	/**
	 * 获取咳嗽编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cough");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽编码"); 
		return column;
	}
	/**
	 * 获取咳嗽其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_cough");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽其他"); 
		return column;
	}
	/**
	 * 获取寒热表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cold_heatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cold_heat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("寒热"); 
		return column;
	}
	/**
	 * 获取寒热编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cold_heatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cold_heat");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("寒热编码"); 
		return column;
	}
	/**
	 * 获取寒热其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_cold_heatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_cold_heat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("寒热其他"); 
		return column;
	}
	/**
	 * 获取汗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sweatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sweat");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("汗"); 
		return column;
	}
	/**
	 * 获取汗编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sweatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sweat");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("汗编码"); 
		return column;
	}
	/**
	 * 获取汗其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_sweatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_sweat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("汗其他"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取饮食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食编码"); 
		return column;
	}
	/**
	 * 获取饮食其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食其他"); 
		return column;
	}
	/**
	 * 获取睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sleep");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠"); 
		return column;
	}
	/**
	 * 获取睡眠编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sleep");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠编码"); 
		return column;
	}
	/**
	 * 获取睡眠其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_sleep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠其他"); 
		return column;
	}
	/**
	 * 获取大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stool");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便"); 
		return column;
	}
	/**
	 * 获取大便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stool");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便编码"); 
		return column;
	}
	/**
	 * 获取大便其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_stool");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便其他"); 
		return column;
	}
	/**
	 * 获取小便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_urinateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_urinate");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便"); 
		return column;
	}
	/**
	 * 获取小便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_urinateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_urinate");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便编码"); 
		return column;
	}
	/**
	 * 获取小便其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_urinateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_urinate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便其他"); 
		return column;
	}
	/**
	 * 获取嗜好表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hobby");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好"); 
		return column;
	}
	/**
	 * 获取嗜好编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hobby");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好编码"); 
		return column;
	}
	/**
	 * 获取嗜好其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_hobby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好其他"); 
		return column;
	}
	/**
	 * 获取脉象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pulse");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象"); 
		return column;
	}
	/**
	 * 获取脉象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pulse");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象编码"); 
		return column;
	}
	/**
	 * 获取脉象其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_pulse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象其他"); 
		return column;
	}
	/**
	 * 获取腕腹表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wristCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wrist");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腕腹"); 
		return column;
	}
	/**
	 * 获取腕腹编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_wristCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_wrist");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腕腹编码"); 
		return column;
	}
	/**
	 * 获取腕腹其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_wristCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_wrist");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腕腹其他"); 
		return column;
	}
	/**
	 * 获取生活自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_selt_care");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活自理能力"); 
		return column;
	}
	/**
	 * 获取生活自理能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_selt_care");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活自理能力编码"); 
		return column;
	}
	/**
	 * 获取家庭关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_family_relationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_family_relation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭关系"); 
		return column;
	}
	/**
	 * 获取家庭关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_family_relationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_family_relation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭关系编码"); 
		return column;
	}
	/**
	 * 获取社交适应能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_social_adaptabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_social_adaptability");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("社交适应能力"); 
		return column;
	}
	/**
	 * 获取社交适应能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_social_adaptabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_social_adaptability");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("社交适应能力编码"); 
		return column;
	}
	/**
	 * 获取左下肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_left_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_left_leg");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左下肢"); 
		return column;
	}
	/**
	 * 获取左下肢编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_left_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_left_leg");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左下肢编码"); 
		return column;
	}
	/**
	 * 获取右下肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_right_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_right_leg");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右下肢"); 
		return column;
	}
	/**
	 * 获取右下肢编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_right_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_right_leg");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右下肢编码"); 
		return column;
	}
	/**
	 * 获取左上肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_left_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_left_hand");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左上肢"); 
		return column;
	}
	/**
	 * 获取左上肢编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_left_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_left_hand");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左上肢编码"); 
		return column;
	}
	/**
	 * 获取右上肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_right_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_right_hand");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右上肢"); 
		return column;
	}
	/**
	 * 获取右上肢编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_right_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_right_hand");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右上肢编码"); 
		return column;
	}
	/**
	 * 获取脊柱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spine");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脊柱"); 
		return column;
	}
	/**
	 * 获取脊柱编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spine");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脊柱编码"); 
		return column;
	}
	/**
	 * 获取病因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_etiologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_etiology");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病因"); 
		return column;
	}
	/**
	 * 获取病因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_etiologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_etiology");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病因编码"); 
		return column;
	}
	/**
	 * 获取病因其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_etiologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_etiology");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病因其他"); 
		return column;
	}
	/**
	 * 获取病位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sick_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sick_place");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病位"); 
		return column;
	}
	/**
	 * 获取病位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sick_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sick_place");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病位编码"); 
		return column;
	}
	/**
	 * 获取病位其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_sick_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_sick_place");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病位其他"); 
		return column;
	}
	/**
	 * 获取入院宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admission_missionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admission_mission");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教"); 
		return column;
	}
	/**
	 * 获取入院宣教编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_admission_missionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_admission_mission");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教编码"); 
		return column;
	}
	/**
	 * 获取护理计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNurse_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nurse_plan");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理计划"); 
		return column;
	}
	/**
	 * 获取评估人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_evaluationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_evaluation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_evaluationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_evaluation");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
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
	 * 获取证型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSyndromesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Syndromes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证型"); 
		return column;
	}
	/**
	 * 获取入院途径名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_route_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_route_admission");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院途径名称"); 
		return column;
	}
	/**
	 * 获取入院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_way_admissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_way_admission");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式名称"); 
		return column;
	}
	/**
	 * 获取发病节气名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_solar_illCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_solar_ill");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发病节气名称"); 
		return column;
	}
	/**
	 * 获取望神名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_look_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_look_states");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("望神名称"); 
		return column;
	}
	/**
	 * 获取面色名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_complexion");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色名称"); 
		return column;
	}
	/**
	 * 获取形态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shapeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shape");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态名称"); 
		return column;
	}
	/**
	 * 获取形态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_formCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_form");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态名称"); 
		return column;
	}
	/**
	 * 获取皮肤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤名称"); 
		return column;
	}
	/**
	 * 获取舌质名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tongue");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质名称"); 
		return column;
	}
	/**
	 * 获取舌苔名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_furred_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_furred_tongue");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔名称"); 
		return column;
	}
	/**
	 * 获取语音名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_voiceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_voice");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语音名称"); 
		return column;
	}
	/**
	 * 获取呼吸名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breatheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breathe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸名称"); 
		return column;
	}
	/**
	 * 获取咳嗽名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cough");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽名称"); 
		return column;
	}
	/**
	 * 获取寒热名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cold_heatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cold_heat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("寒热名称"); 
		return column;
	}
	/**
	 * 获取汗名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sweatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sweat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("汗名称"); 
		return column;
	}
	/**
	 * 获取饮食名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食名称"); 
		return column;
	}
	/**
	 * 获取睡眠名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sleep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠名称"); 
		return column;
	}
	/**
	 * 获取大便名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stoolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stool");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便名称"); 
		return column;
	}
	/**
	 * 获取小便名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_urinateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_urinate");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便名称"); 
		return column;
	}
	/**
	 * 获取嗜好名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hobby");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好名称"); 
		return column;
	}
	/**
	 * 获取脉象名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pulse");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象名称"); 
		return column;
	}
	/**
	 * 获取腕腹名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_wristCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wrist");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("腕腹名称"); 
		return column;
	}
	/**
	 * 获取生活自理能力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_selt_careCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_selt_care");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活自理能力名称"); 
		return column;
	}
	/**
	 * 获取家庭关系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_family_relationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_family_relation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭关系名称"); 
		return column;
	}
	/**
	 * 获取社交适应能力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_social_adaptabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_social_adaptability");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("社交适应能力名称"); 
		return column;
	}
	/**
	 * 获取左下肢名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_left_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_left_leg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左下肢名称"); 
		return column;
	}
	/**
	 * 获取右下肢名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_right_legCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_right_leg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右下肢名称"); 
		return column;
	}
	/**
	 * 获取左上肢名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_left_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_left_hand");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左上肢名称"); 
		return column;
	}
	/**
	 * 获取右上肢名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_right_handCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_right_hand");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右上肢名称"); 
		return column;
	}
	/**
	 * 获取脊柱名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spine");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脊柱名称"); 
		return column;
	}
	/**
	 * 获取病因名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_etiologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_etiology");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病因名称"); 
		return column;
	}
	/**
	 * 获取病位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sick_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sick_place");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病位名称"); 
		return column;
	}
	/**
	 * 获取入院宣教名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_admission_missionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_admission_mission");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教名称"); 
		return column;
	}
	/**
	 * 获取评估人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_evaluationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_evaluation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人姓名"); 
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
