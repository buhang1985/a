
package iih.ci.mr.nu.obsadmcareass.d.desc;

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
public class ObsadmcareassDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.obsadmcareass.d.ObsadmcareassDO";
	public static final String CLASS_DISPALYNAME = "入院护理评估记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_obsadmcareass";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_obsadmcareass";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ObsadmcareassDODesc(){
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
		this.setKeyDesc(getId_obsadmcareassADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_obsadmcareassADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getId_hospitalizewayADesc(tblDesc));
		this.add(getSd_hospitalizewayADesc(tblDesc));
		this.add(getOther_hospitalizewayADesc(tblDesc));
		this.add(getId_educADesc(tblDesc));
		this.add(getId_marryADesc(tblDesc));
		this.add(getPatcontADesc(tblDesc));
		this.add(getMobADesc(tblDesc));
		this.add(getPhoneADesc(tblDesc));
		this.add(getPataddrADesc(tblDesc));
		this.add(getName_chinese_medicineADesc(tblDesc));
		this.add(getName_medicineADesc(tblDesc));
		this.add(getFg_pastmedicADesc(tblDesc));
		this.add(getName_pastmedicADesc(tblDesc));
		this.add(getFg_allergyADesc(tblDesc));
		this.add(getName_allergyADesc(tblDesc));
		this.add(getPaulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getScore_helpmeADesc(tblDesc));
		this.add(getScore_pressuresoreADesc(tblDesc));
		this.add(getScore_falldownADesc(tblDesc));
		this.add(getScore_painADesc(tblDesc));
		this.add(getScore_pipe_slippageADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getEu_mucosaADesc(tblDesc));
		this.add(getEu_den_toothADesc(tblDesc));
		this.add(getEu_eatADesc(tblDesc));
		this.add(getEu_coughADesc(tblDesc));
		this.add(getEu_hobbyADesc(tblDesc));
		this.add(getId_tongueADesc(tblDesc));
		this.add(getSd_tongueADesc(tblDesc));
		this.add(getName_other_tongueADesc(tblDesc));
		this.add(getName_specialtyADesc(tblDesc));
		this.add(getName_nursingADesc(tblDesc));
		this.add(getId_solar_illADesc(tblDesc));
		this.add(getSd_solar_illADesc(tblDesc));
		this.add(getId_tongue_coatADesc(tblDesc));
		this.add(getSd_tongue_coatADesc(tblDesc));
		this.add(getName_other_tonguecoatADesc(tblDesc));
		this.add(getId_emotionADesc(tblDesc));
		this.add(getSd_emotionADesc(tblDesc));
		this.add(getName_other_emotionADesc(tblDesc));
		this.add(getId_complexionADesc(tblDesc));
		this.add(getSd_complexionADesc(tblDesc));
		this.add(getName_other_complexionADesc(tblDesc));
		this.add(getId_morpADesc(tblDesc));
		this.add(getSd_morpADesc(tblDesc));
		this.add(getId_skin_damageADesc(tblDesc));
		this.add(getSd_skin_damageADesc(tblDesc));
		this.add(getName_damagedADesc(tblDesc));
		this.add(getName_pressure_soreADesc(tblDesc));
		this.add(getId_skin_colorADesc(tblDesc));
		this.add(getSd_skin_colorADesc(tblDesc));
		this.add(getName_other_skincolorADesc(tblDesc));
		this.add(getId_languageADesc(tblDesc));
		this.add(getSd_languageADesc(tblDesc));
		this.add(getName_other_languageADesc(tblDesc));
		this.add(getId_breathADesc(tblDesc));
		this.add(getSd_breathADesc(tblDesc));
		this.add(getName_other_breathADesc(tblDesc));
		this.add(getId_coughADesc(tblDesc));
		this.add(getSd_coughADesc(tblDesc));
		this.add(getName_other_eatADesc(tblDesc));
		this.add(getId_hobbyADesc(tblDesc));
		this.add(getSd_hobbyADesc(tblDesc));
		this.add(getName_other_hobbyADesc(tblDesc));
		this.add(getId_eat_habitsADesc(tblDesc));
		this.add(getSd_eat_habitsADesc(tblDesc));
		this.add(getName_other_eathabADesc(tblDesc));
		this.add(getId_thirstyADesc(tblDesc));
		this.add(getSd_thirstyADesc(tblDesc));
		this.add(getId_right_earADesc(tblDesc));
		this.add(getSd_right_earADesc(tblDesc));
		this.add(getId_left_earADesc(tblDesc));
		this.add(getSd_left_earADesc(tblDesc));
		this.add(getId_right_eyeADesc(tblDesc));
		this.add(getSd_right_eyeADesc(tblDesc));
		this.add(getId_left_eyeADesc(tblDesc));
		this.add(getSd_left_eyeADesc(tblDesc));
		this.add(getId_sleepADesc(tblDesc));
		this.add(getSd_sleepADesc(tblDesc));
		this.add(getName_other_sleepADesc(tblDesc));
		this.add(getId_pulse_conditionADesc(tblDesc));
		this.add(getSd_pulse_conditionADesc(tblDesc));
		this.add(getName_other_pulseconADesc(tblDesc));
		this.add(getId_consciousnessADesc(tblDesc));
		this.add(getSd_consciousnessADesc(tblDesc));
		this.add(getName_other_consciousnessADesc(tblDesc));
		this.add(getId_shitADesc(tblDesc));
		this.add(getSd_shitADesc(tblDesc));
		this.add(getName_other_shitADesc(tblDesc));
		this.add(getId_urineADesc(tblDesc));
		this.add(getSd_urineADesc(tblDesc));
		this.add(getName_other_urineADesc(tblDesc));
		this.add(getId_hospitaleducationADesc(tblDesc));
		this.add(getSd_hospitaleducationADesc(tblDesc));
		this.add(getOther_hospitaleducaADesc(tblDesc));
		this.add(getNursingplanADesc(tblDesc));
		this.add(getDt_evaluationADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_hospitalizewayADesc(tblDesc));
		this.add(getName_educADesc(tblDesc));
		this.add(getName_marryADesc(tblDesc));
		this.add(getName_tongueADesc(tblDesc));
		this.add(getName_solar_illADesc(tblDesc));
		this.add(getName_tongue_coatADesc(tblDesc));
		this.add(getName_emotionADesc(tblDesc));
		this.add(getName_complexionADesc(tblDesc));
		this.add(getName_morpADesc(tblDesc));
		this.add(getName_skin_damageADesc(tblDesc));
		this.add(getName_skin_colorADesc(tblDesc));
		this.add(getName_languageADesc(tblDesc));
		this.add(getName_breathADesc(tblDesc));
		this.add(getName_coughADesc(tblDesc));
		this.add(getName_hobbyADesc(tblDesc));
		this.add(getName_eat_habitsADesc(tblDesc));
		this.add(getName_thirstyADesc(tblDesc));
		this.add(getName_right_earADesc(tblDesc));
		this.add(getName_left_earADesc(tblDesc));
		this.add(getName_right_eyeADesc(tblDesc));
		this.add(getName_left_eyeADesc(tblDesc));
		this.add(getName_sleepADesc(tblDesc));
		this.add(getName_pulse_conditionADesc(tblDesc));
		this.add(getName_consciousnessADesc(tblDesc));
		this.add(getName_shitADesc(tblDesc));
		this.add(getName_urineADesc(tblDesc));
		this.add(getName_hospitaleducationADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_obsadmcareassCDesc(tblDesc));
		tblDesc.add(getId_obsadmcareassCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getId_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getSd_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getOther_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getId_educCDesc(tblDesc));
		tblDesc.add(getId_marryCDesc(tblDesc));
		tblDesc.add(getPatcontCDesc(tblDesc));
		tblDesc.add(getMobCDesc(tblDesc));
		tblDesc.add(getPhoneCDesc(tblDesc));
		tblDesc.add(getPataddrCDesc(tblDesc));
		tblDesc.add(getName_chinese_medicineCDesc(tblDesc));
		tblDesc.add(getName_medicineCDesc(tblDesc));
		tblDesc.add(getFg_pastmedicCDesc(tblDesc));
		tblDesc.add(getName_pastmedicCDesc(tblDesc));
		tblDesc.add(getFg_allergyCDesc(tblDesc));
		tblDesc.add(getName_allergyCDesc(tblDesc));
		tblDesc.add(getPaulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getScore_helpmeCDesc(tblDesc));
		tblDesc.add(getScore_pressuresoreCDesc(tblDesc));
		tblDesc.add(getScore_falldownCDesc(tblDesc));
		tblDesc.add(getScore_painCDesc(tblDesc));
		tblDesc.add(getScore_pipe_slippageCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getEu_mucosaCDesc(tblDesc));
		tblDesc.add(getEu_den_toothCDesc(tblDesc));
		tblDesc.add(getEu_eatCDesc(tblDesc));
		tblDesc.add(getEu_coughCDesc(tblDesc));
		tblDesc.add(getEu_hobbyCDesc(tblDesc));
		tblDesc.add(getId_tongueCDesc(tblDesc));
		tblDesc.add(getSd_tongueCDesc(tblDesc));
		tblDesc.add(getName_other_tongueCDesc(tblDesc));
		tblDesc.add(getName_specialtyCDesc(tblDesc));
		tblDesc.add(getName_nursingCDesc(tblDesc));
		tblDesc.add(getId_solar_illCDesc(tblDesc));
		tblDesc.add(getSd_solar_illCDesc(tblDesc));
		tblDesc.add(getId_tongue_coatCDesc(tblDesc));
		tblDesc.add(getSd_tongue_coatCDesc(tblDesc));
		tblDesc.add(getName_other_tonguecoatCDesc(tblDesc));
		tblDesc.add(getId_emotionCDesc(tblDesc));
		tblDesc.add(getSd_emotionCDesc(tblDesc));
		tblDesc.add(getName_other_emotionCDesc(tblDesc));
		tblDesc.add(getId_complexionCDesc(tblDesc));
		tblDesc.add(getSd_complexionCDesc(tblDesc));
		tblDesc.add(getName_other_complexionCDesc(tblDesc));
		tblDesc.add(getId_morpCDesc(tblDesc));
		tblDesc.add(getSd_morpCDesc(tblDesc));
		tblDesc.add(getId_skin_damageCDesc(tblDesc));
		tblDesc.add(getSd_skin_damageCDesc(tblDesc));
		tblDesc.add(getName_damagedCDesc(tblDesc));
		tblDesc.add(getName_pressure_soreCDesc(tblDesc));
		tblDesc.add(getId_skin_colorCDesc(tblDesc));
		tblDesc.add(getSd_skin_colorCDesc(tblDesc));
		tblDesc.add(getName_other_skincolorCDesc(tblDesc));
		tblDesc.add(getId_languageCDesc(tblDesc));
		tblDesc.add(getSd_languageCDesc(tblDesc));
		tblDesc.add(getName_other_languageCDesc(tblDesc));
		tblDesc.add(getId_breathCDesc(tblDesc));
		tblDesc.add(getSd_breathCDesc(tblDesc));
		tblDesc.add(getName_other_breathCDesc(tblDesc));
		tblDesc.add(getId_coughCDesc(tblDesc));
		tblDesc.add(getSd_coughCDesc(tblDesc));
		tblDesc.add(getName_other_eatCDesc(tblDesc));
		tblDesc.add(getId_hobbyCDesc(tblDesc));
		tblDesc.add(getSd_hobbyCDesc(tblDesc));
		tblDesc.add(getName_other_hobbyCDesc(tblDesc));
		tblDesc.add(getId_eat_habitsCDesc(tblDesc));
		tblDesc.add(getSd_eat_habitsCDesc(tblDesc));
		tblDesc.add(getName_other_eathabCDesc(tblDesc));
		tblDesc.add(getId_thirstyCDesc(tblDesc));
		tblDesc.add(getSd_thirstyCDesc(tblDesc));
		tblDesc.add(getId_right_earCDesc(tblDesc));
		tblDesc.add(getSd_right_earCDesc(tblDesc));
		tblDesc.add(getId_left_earCDesc(tblDesc));
		tblDesc.add(getSd_left_earCDesc(tblDesc));
		tblDesc.add(getId_right_eyeCDesc(tblDesc));
		tblDesc.add(getSd_right_eyeCDesc(tblDesc));
		tblDesc.add(getId_left_eyeCDesc(tblDesc));
		tblDesc.add(getSd_left_eyeCDesc(tblDesc));
		tblDesc.add(getId_sleepCDesc(tblDesc));
		tblDesc.add(getSd_sleepCDesc(tblDesc));
		tblDesc.add(getName_other_sleepCDesc(tblDesc));
		tblDesc.add(getId_pulse_conditionCDesc(tblDesc));
		tblDesc.add(getSd_pulse_conditionCDesc(tblDesc));
		tblDesc.add(getName_other_pulseconCDesc(tblDesc));
		tblDesc.add(getId_consciousnessCDesc(tblDesc));
		tblDesc.add(getSd_consciousnessCDesc(tblDesc));
		tblDesc.add(getName_other_consciousnessCDesc(tblDesc));
		tblDesc.add(getId_shitCDesc(tblDesc));
		tblDesc.add(getSd_shitCDesc(tblDesc));
		tblDesc.add(getName_other_shitCDesc(tblDesc));
		tblDesc.add(getId_urineCDesc(tblDesc));
		tblDesc.add(getSd_urineCDesc(tblDesc));
		tblDesc.add(getName_other_urineCDesc(tblDesc));
		tblDesc.add(getId_hospitaleducationCDesc(tblDesc));
		tblDesc.add(getSd_hospitaleducationCDesc(tblDesc));
		tblDesc.add(getOther_hospitaleducaCDesc(tblDesc));
		tblDesc.add(getNursingplanCDesc(tblDesc));
		tblDesc.add(getDt_evaluationCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 产科入院护理评估记录单id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_obsadmcareassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_obsadmcareass",  getId_obsadmcareassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科入院护理评估记录单id");
		attrDesc.setNullable(true);
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
	 * 入院方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalizeway",  getId_hospitalizewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式id");
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
	private IAttrDesc getSd_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hospitalizeway",  getSd_hospitalizewayCDesc(tblDesc), this);
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
	 * 入院方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_hospitalizeway",  getOther_hospitalizewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_educADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_educ",  getId_educCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 婚姻状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marry",  getId_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcont",  getPatcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mob",  getMobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系方式(备用)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Phone",  getPhoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系方式(备用)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家庭地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPataddrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pataddr",  getPataddrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家庭地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chinese_medicineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chinese_medicine",  getName_chinese_medicineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medicineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medicine",  getName_medicineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医");
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
	 * 既往史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pastmedicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pastmedic",  getName_pastmedicCDesc(tblDesc), this);
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
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_allergy",  getName_allergyCDesc(tblDesc), this);
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
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPaulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paulse",  getPaulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
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
	 * 自理能力评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_helpmeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_helpme",  getScore_helpmeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("自理能力评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_pressuresoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pressuresore",  getScore_pressuresoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("压疮评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒/坠床评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_falldownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_falldown",  getScore_falldownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("跌倒/坠床评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pain",  getScore_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("疼痛评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道滑脱评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_pipe_slippageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_pipe_slippage",  getScore_pipe_slippageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("管道滑脱评分");
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
	 * 粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_mucosa",  getEu_mucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 义齿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_den_toothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_den_tooth",  getEu_den_toothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("义齿");
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
	private IAttrDesc getEu_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_eat",  getEu_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("饮食");
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
	private IAttrDesc getEu_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cough",  getEu_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("咳嗽");
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
	private IAttrDesc getEu_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_hobby",  getEu_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("嗜好");
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
	private IAttrDesc getName_other_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_tongue",  getName_other_tongueCDesc(tblDesc), this);
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
	 * 专科情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_specialtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_specialty",  getName_specialtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理要点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursing",  getName_nursingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理要点");
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
	 * 舌苔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tongue_coat",  getId_tongue_coatCDesc(tblDesc), this);
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
	private IAttrDesc getSd_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tongue_coat",  getSd_tongue_coatCDesc(tblDesc), this);
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
	private IAttrDesc getName_other_tonguecoatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_tonguecoat",  getName_other_tonguecoatCDesc(tblDesc), this);
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
	 * 情绪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emotion",  getId_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 情绪编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emotion",  getSd_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_emotion",  getName_other_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪其他");
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
	private IAttrDesc getName_other_complexionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_complexion",  getName_other_complexionCDesc(tblDesc), this);
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
	 * 形态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_morpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_morp",  getId_morpCDesc(tblDesc), this);
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
	private IAttrDesc getSd_morpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_morp",  getSd_morpCDesc(tblDesc), this);
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
	 * 皮肤破损属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_damageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_damage",  getId_skin_damageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤破损");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤破损编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_damageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_damage",  getSd_skin_damageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤破损编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 破损属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_damagedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_damaged",  getName_damagedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("破损");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pressure_soreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pressure_sore",  getName_pressure_soreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤色泽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_color",  getId_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤色泽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤色泽编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_color",  getSd_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤色泽编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 色泽其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_skincolor",  getName_other_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("色泽其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_languageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_language",  getId_languageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 语言编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_languageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_language",  getSd_languageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_languageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_language",  getName_other_languageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸产科属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath",  getId_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸产科");
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
	private IAttrDesc getSd_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath",  getSd_breathCDesc(tblDesc), this);
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
	private IAttrDesc getName_other_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_breath",  getName_other_breathCDesc(tblDesc), this);
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
	 * 咳嗽有属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cough",  getId_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽有");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 咳嗽有编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cough",  getSd_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽有编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食异常属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_eat",  getName_other_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食异常");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好有属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hobby",  getId_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好有");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 嗜好有编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hobby",  getSd_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好有编码");
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
	private IAttrDesc getName_other_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_hobby",  getName_other_hobbyCDesc(tblDesc), this);
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
	 * 饮食习惯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eat_habitsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eat_habits",  getId_eat_habitsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食习惯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食习惯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eat_habitsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eat_habits",  getSd_eat_habitsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食习惯编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食习惯其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_eathabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_eathab",  getName_other_eathabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食习惯其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口渴属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_thirstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_thirsty",  getId_thirstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口渴");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 口渴编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_thirstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_thirsty",  getSd_thirstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口渴编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右耳属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_right_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_right_ear",  getId_right_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右耳");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右耳编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_right_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_right_ear",  getSd_right_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右耳编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左耳属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_left_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_left_ear",  getId_left_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左耳");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左耳编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_left_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_left_ear",  getSd_left_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左耳编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右眼属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_right_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_right_eye",  getId_right_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右眼");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 右眼编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_right_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_right_eye",  getSd_right_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右眼编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左眼属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_left_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_left_eye",  getId_left_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左眼");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 左眼编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_left_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_left_eye",  getSd_left_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左眼编码");
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
	private IAttrDesc getName_other_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_sleep",  getName_other_sleepCDesc(tblDesc), this);
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
	 * 脉象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pulse_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pulse_condition",  getId_pulse_conditionCDesc(tblDesc), this);
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
	private IAttrDesc getSd_pulse_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pulse_condition",  getSd_pulse_conditionCDesc(tblDesc), this);
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
	private IAttrDesc getName_other_pulseconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_pulsecon",  getName_other_pulseconCDesc(tblDesc), this);
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
	 * 神志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_consciousness",  getId_consciousnessCDesc(tblDesc), this);
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
	private IAttrDesc getSd_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_consciousness",  getSd_consciousnessCDesc(tblDesc), this);
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
	 * 神志其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_consciousness",  getName_other_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志其他");
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
	private IAttrDesc getId_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shit",  getId_shitCDesc(tblDesc), this);
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
	private IAttrDesc getSd_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_shit",  getSd_shitCDesc(tblDesc), this);
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
	private IAttrDesc getName_other_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_shit",  getName_other_shitCDesc(tblDesc), this);
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
	private IAttrDesc getId_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_urine",  getId_urineCDesc(tblDesc), this);
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
	private IAttrDesc getSd_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_urine",  getSd_urineCDesc(tblDesc), this);
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
	private IAttrDesc getName_other_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_urine",  getName_other_urineCDesc(tblDesc), this);
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
	 * 入院宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitaleducation",  getId_hospitaleducationCDesc(tblDesc), this);
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
	private IAttrDesc getSd_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hospitaleducation",  getSd_hospitaleducationCDesc(tblDesc), this);
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
	 * 入院宣教其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_hospitaleducaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_hospitaleduca",  getOther_hospitaleducaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教其他");
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
	private IAttrDesc getNursingplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nursingplan",  getNursingplanCDesc(tblDesc), this);
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
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
	 * 入院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hospitalizeway",  getName_hospitalizewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b46","id_hospitalizeway=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_educADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_educ",  getName_educCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b47","id_educ=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_marry",  getName_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b48","id_marry=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_tongue=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_solar_ill=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tongue_coat",  getName_tongue_coatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_tongue_coat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emotionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emotion",  getName_emotionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_emotion=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_complexion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 形态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_morpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_morp",  getName_morpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("形态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_morp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤破损名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_damageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_damage",  getName_skin_damageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤破损名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_skin_damage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤色泽名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_color",  getName_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤色泽名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_skin_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_languageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_language",  getName_languageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_language=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath",  getName_breathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_breath=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 咳嗽有名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_coughADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cough",  getName_coughCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("咳嗽有名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_cough=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 嗜好有名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hobbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hobby",  getName_hobbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("嗜好有名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_hobby=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食习惯名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eat_habitsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eat_habits",  getName_eat_habitsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食习惯名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_eat_habits=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口渴名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_thirstyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_thirsty",  getName_thirstyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口渴名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_thirsty=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右耳听力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_right_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_right_ear",  getName_right_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右耳听力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","id_right_ear=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左耳听力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_left_earADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_left_ear",  getName_left_earCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左耳听力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_left_ear=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右眼视力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_right_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_right_eye",  getName_right_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("右眼视力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_right_eye=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左眼视力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_left_eyeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_left_eye",  getName_left_eyeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("左眼视力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_left_eye=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_sleep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉象名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pulse_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pulse_condition",  getName_pulse_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉象名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_pulse_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神志名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_consciousness",  getName_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_consciousness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shit",  getName_shitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_shit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_urineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_urine",  getName_urineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_urine=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hospitaleducation",  getName_hospitaleducationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","id_hospitaleducation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b45","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取产科入院护理评估记录单id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_obsadmcareassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_obsadmcareass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产科入院护理评估记录单id"); 
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
	 * 获取入院方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalizeway");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式id"); 
		return column;
	}
	/**
	 * 获取入院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hospitalizeway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式编码"); 
		return column;
	}
	/**
	 * 获取入院方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_hospitalizeway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式其他"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_educCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_educ");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取婚姻状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取联系方式(备用)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Phone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系方式(备用)"); 
		return column;
	}
	/**
	 * 获取家庭地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPataddrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pataddr");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家庭地址"); 
		return column;
	}
	/**
	 * 获取中医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chinese_medicineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chinese_medicine");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医"); 
		return column;
	}
	/**
	 * 获取西医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medicineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medicine");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医"); 
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
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pastmedicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pastmedic");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史"); 
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
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_allergy");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPaulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
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
	 * 获取自理能力评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_helpmeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_helpme");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("自理能力评分"); 
		return column;
	}
	/**
	 * 获取压疮评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_pressuresoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pressuresore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("压疮评分"); 
		return column;
	}
	/**
	 * 获取跌倒/坠床评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_falldownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_falldown");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("跌倒/坠床评分"); 
		return column;
	}
	/**
	 * 获取疼痛评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pain");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("疼痛评分"); 
		return column;
	}
	/**
	 * 获取管道滑脱评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_pipe_slippageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_pipe_slippage");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("管道滑脱评分"); 
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
	 * 获取粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_mucosa");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("粘膜"); 
		return column;
	}
	/**
	 * 获取义齿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_den_toothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_den_tooth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("义齿"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_eat");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取咳嗽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cough");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("咳嗽"); 
		return column;
	}
	/**
	 * 获取嗜好表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_hobby");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("嗜好"); 
		return column;
	}
	/**
	 * 获取舌质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tongue");
		column.setLength(20);
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
		column.setLength(50);
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
	private IColumnDesc getName_other_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_tongue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质其他"); 
		return column;
	}
	/**
	 * 获取专科情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_specialtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_specialty");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科情况"); 
		return column;
	}
	/**
	 * 获取护理要点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursing");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理要点"); 
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
	 * 获取舌苔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tongue_coat");
		column.setLength(20);
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
	private IColumnDesc getSd_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tongue_coat");
		column.setLength(50);
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
	private IColumnDesc getName_other_tonguecoatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_tonguecoat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔其他"); 
		return column;
	}
	/**
	 * 获取情绪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emotion");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪"); 
		return column;
	}
	/**
	 * 获取情绪编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emotion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪编码"); 
		return column;
	}
	/**
	 * 获取情绪其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_emotion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪其他"); 
		return column;
	}
	/**
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_complexion");
		column.setLength(20);
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
		column.setLength(50);
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
	private IColumnDesc getName_other_complexionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_complexion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色其他"); 
		return column;
	}
	/**
	 * 获取形态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_morpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_morp");
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
	private IColumnDesc getSd_morpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_morp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态编码"); 
		return column;
	}
	/**
	 * 获取皮肤破损表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_damageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_damage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤破损"); 
		return column;
	}
	/**
	 * 获取皮肤破损编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_damageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_damage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤破损编码"); 
		return column;
	}
	/**
	 * 获取破损表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_damagedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_damaged");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("破损"); 
		return column;
	}
	/**
	 * 获取压疮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pressure_soreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pressure_sore");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮"); 
		return column;
	}
	/**
	 * 获取皮肤色泽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤色泽"); 
		return column;
	}
	/**
	 * 获取皮肤色泽编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤色泽编码"); 
		return column;
	}
	/**
	 * 获取色泽其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_skincolor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("色泽其他"); 
		return column;
	}
	/**
	 * 获取语言表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_languageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_language");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言"); 
		return column;
	}
	/**
	 * 获取语言编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_languageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_language");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言编码"); 
		return column;
	}
	/**
	 * 获取语言其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_languageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_language");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言其他"); 
		return column;
	}
	/**
	 * 获取呼吸产科表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸产科"); 
		return column;
	}
	/**
	 * 获取呼吸编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath");
		column.setLength(50);
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
	private IColumnDesc getName_other_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_breath");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸其他"); 
		return column;
	}
	/**
	 * 获取咳嗽有表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cough");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽有"); 
		return column;
	}
	/**
	 * 获取咳嗽有编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cough");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽有编码"); 
		return column;
	}
	/**
	 * 获取饮食异常表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_eat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食异常"); 
		return column;
	}
	/**
	 * 获取嗜好有表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hobby");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好有"); 
		return column;
	}
	/**
	 * 获取嗜好有编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hobby");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好有编码"); 
		return column;
	}
	/**
	 * 获取嗜好其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_hobby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好其他"); 
		return column;
	}
	/**
	 * 获取饮食习惯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eat_habitsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eat_habits");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食习惯"); 
		return column;
	}
	/**
	 * 获取饮食习惯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eat_habitsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eat_habits");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食习惯编码"); 
		return column;
	}
	/**
	 * 获取饮食习惯其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_eathabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_eathab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食习惯其他"); 
		return column;
	}
	/**
	 * 获取口渴表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_thirstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_thirsty");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口渴"); 
		return column;
	}
	/**
	 * 获取口渴编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_thirstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_thirsty");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口渴编码"); 
		return column;
	}
	/**
	 * 获取右耳表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_right_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_right_ear");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右耳"); 
		return column;
	}
	/**
	 * 获取右耳编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_right_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_right_ear");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右耳编码"); 
		return column;
	}
	/**
	 * 获取左耳表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_left_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_left_ear");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左耳"); 
		return column;
	}
	/**
	 * 获取左耳编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_left_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_left_ear");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左耳编码"); 
		return column;
	}
	/**
	 * 获取右眼表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_right_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_right_eye");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右眼"); 
		return column;
	}
	/**
	 * 获取右眼编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_right_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_right_eye");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右眼编码"); 
		return column;
	}
	/**
	 * 获取左眼表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_left_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_left_eye");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左眼"); 
		return column;
	}
	/**
	 * 获取左眼编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_left_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_left_eye");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左眼编码"); 
		return column;
	}
	/**
	 * 获取睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sleep");
		column.setLength(20);
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
		column.setLength(50);
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
	private IColumnDesc getName_other_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_sleep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠其他"); 
		return column;
	}
	/**
	 * 获取脉象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pulse_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pulse_condition");
		column.setLength(20);
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
	private IColumnDesc getSd_pulse_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pulse_condition");
		column.setLength(50);
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
	private IColumnDesc getName_other_pulseconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_pulsecon");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象其他"); 
		return column;
	}
	/**
	 * 获取神志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_consciousness");
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
	private IColumnDesc getSd_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_consciousness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志编码"); 
		return column;
	}
	/**
	 * 获取神志其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_consciousness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志其他"); 
		return column;
	}
	/**
	 * 获取大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shit");
		column.setLength(20);
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
	private IColumnDesc getSd_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_shit");
		column.setLength(50);
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
	private IColumnDesc getName_other_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_shit");
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
	private IColumnDesc getId_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_urine");
		column.setLength(20);
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
	private IColumnDesc getSd_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_urine");
		column.setLength(50);
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
	private IColumnDesc getName_other_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_urine");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便其他"); 
		return column;
	}
	/**
	 * 获取入院宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitaleducation");
		column.setLength(2000);
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
	private IColumnDesc getSd_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hospitaleducation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教编码"); 
		return column;
	}
	/**
	 * 获取入院宣教其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_hospitaleducaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_hospitaleduca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教其他"); 
		return column;
	}
	/**
	 * 获取护理计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNursingplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nursingplan");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理计划"); 
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
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
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
	 * 获取入院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hospitalizeway");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式名称"); 
		return column;
	}
	/**
	 * 获取文化程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_educCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_educ");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度名称"); 
		return column;
	}
	/**
	 * 获取婚姻状况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_marry");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况名称"); 
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
	 * 获取舌苔名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tongue_coat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔名称"); 
		return column;
	}
	/**
	 * 获取情绪名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emotionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emotion");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪名称"); 
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
	private IColumnDesc getName_morpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_morp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("形态名称"); 
		return column;
	}
	/**
	 * 获取皮肤破损名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_damageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_damage");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤破损名称"); 
		return column;
	}
	/**
	 * 获取皮肤色泽名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_color");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤色泽名称"); 
		return column;
	}
	/**
	 * 获取语言名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_languageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_language");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言名称"); 
		return column;
	}
	/**
	 * 获取呼吸名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸名称"); 
		return column;
	}
	/**
	 * 获取咳嗽有名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_coughCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cough");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("咳嗽有名称"); 
		return column;
	}
	/**
	 * 获取嗜好有名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hobbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hobby");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("嗜好有名称"); 
		return column;
	}
	/**
	 * 获取饮食习惯名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eat_habitsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eat_habits");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食习惯名称"); 
		return column;
	}
	/**
	 * 获取口渴名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_thirstyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_thirsty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口渴名称"); 
		return column;
	}
	/**
	 * 获取右耳听力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_right_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_right_ear");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右耳听力"); 
		return column;
	}
	/**
	 * 获取左耳听力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_left_earCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_left_ear");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左耳听力"); 
		return column;
	}
	/**
	 * 获取右眼视力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_right_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_right_eye");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("右眼视力"); 
		return column;
	}
	/**
	 * 获取左眼视力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_left_eyeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_left_eye");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("左眼视力"); 
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
	 * 获取脉象名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pulse_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pulse_condition");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉象名称"); 
		return column;
	}
	/**
	 * 获取神志名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_consciousness");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志名称"); 
		return column;
	}
	/**
	 * 获取大便名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shit");
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
	private IColumnDesc getName_urineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_urine");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便名称"); 
		return column;
	}
	/**
	 * 获取入院宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hospitaleducation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
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
