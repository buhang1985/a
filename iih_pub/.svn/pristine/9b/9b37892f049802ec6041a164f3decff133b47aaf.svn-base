
package iih.ci.rcm.operinciinfect.d.desc;

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
 * 手术切口感染 DO 元数据信息
 */
public class OperIncInfectDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.operinciinfect.d.OperIncInfectDO";
	public static final String CLASS_DISPALYNAME = "手术切口感染";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_CONTAGION_CARD_INCISION";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_operinciinfect";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OperIncInfectDODesc(){
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
		this.setKeyDesc(getId_operinciinfectADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_operinciinfectADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getOper_qkjcADesc(tblDesc));
		this.add(getSd_oper_qkjcADesc(tblDesc));
		this.add(getName_oper_qkjcADesc(tblDesc));
		this.add(getId_operADesc(tblDesc));
		this.add(getSd_operADesc(tblDesc));
		this.add(getName_operADesc(tblDesc));
		this.add(getDt_startADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getDuration_operADesc(tblDesc));
		this.add(getOper_doctorADesc(tblDesc));
		this.add(getSd_oper_doctorADesc(tblDesc));
		this.add(getName_oper_doctorADesc(tblDesc));
		this.add(getId_oper_typeADesc(tblDesc));
		this.add(getSd_oper_typeADesc(tblDesc));
		this.add(getName_oper_typeADesc(tblDesc));
		this.add(getIncision_countADesc(tblDesc));
		this.add(getId_incision_typeADesc(tblDesc));
		this.add(getSd_incision_typeADesc(tblDesc));
		this.add(getName_incision_typeADesc(tblDesc));
		this.add(getId_anes_methodsADesc(tblDesc));
		this.add(getSd_anes_methodsADesc(tblDesc));
		this.add(getName_anes_methodsADesc(tblDesc));
		this.add(getOper_implantationADesc(tblDesc));
		this.add(getSd_oper_implantationADesc(tblDesc));
		this.add(getName_oper_implantationADesc(tblDesc));
		this.add(getId_asa_scoreADesc(tblDesc));
		this.add(getSd_asa_scoreADesc(tblDesc));
		this.add(getName_asa_scoreADesc(tblDesc));
		this.add(getId_heal_conditionADesc(tblDesc));
		this.add(getSd_heal_conditionADesc(tblDesc));
		this.add(getName_heal_conditionADesc(tblDesc));
		this.add(getOper_lost_bloodADesc(tblDesc));
		this.add(getSd_oper_lost_bloodADesc(tblDesc));
		this.add(getName_oper_lost_bloodADesc(tblDesc));
		this.add(getBlood_loss_volumeADesc(tblDesc));
		this.add(getOper_get_bloodADesc(tblDesc));
		this.add(getSd_oper_get_bloodADesc(tblDesc));
		this.add(getName_oper_get_bloodADesc(tblDesc));
		this.add(getTransfusion_volumeADesc(tblDesc));
		this.add(getId_type_surg_siteinfeADesc(tblDesc));
		this.add(getSd_type_surg_siteinfeADesc(tblDesc));
		this.add(getName_type_surg_siteinfeADesc(tblDesc));
		this.add(getIs_causeinciADesc(tblDesc));
		this.add(getSd_is_causeinicADesc(tblDesc));
		this.add(getName_is_causeinicADesc(tblDesc));
		this.add(getInfection_dateADesc(tblDesc));
		this.add(getOper_infec_partADesc(tblDesc));
		this.add(getSd_oper_infec_partADesc(tblDesc));
		this.add(getName_oper_infec_partADesc(tblDesc));
		this.add(getOther_oper_infec_partADesc(tblDesc));
		this.add(getOper_part_infecADesc(tblDesc));
		this.add(getSd_oper_part_infecADesc(tblDesc));
		this.add(getName_oper_part_infecADesc(tblDesc));
		this.add(getBackup_field1ADesc(tblDesc));
		this.add(getBackup_field2ADesc(tblDesc));
		this.add(getBackup_field3ADesc(tblDesc));
		this.add(getBackup_field4ADesc(tblDesc));
		this.add(getBackup_field5ADesc(tblDesc));
		this.add(getOper_sightglassADesc(tblDesc));
		this.add(getSd_oper_sightglassADesc(tblDesc));
		this.add(getName_oper_sightglassADesc(tblDesc));
		this.add(getTake_anti_beforesurgeryADesc(tblDesc));
		this.add(getSd_take_anti_beforesurgeryADesc(tblDesc));
		this.add(getName_take_anti_beforesurgeryADesc(tblDesc));
		this.add(getLapse_toADesc(tblDesc));
		this.add(getSd_lapse_toADesc(tblDesc));
		this.add(getName_lapse_toADesc(tblDesc));
		this.add(getDt_lapse_toADesc(tblDesc));
		this.add(getOper_drainageADesc(tblDesc));
		this.add(getSd_oper_drainageADesc(tblDesc));
		this.add(getName_oper_drainageADesc(tblDesc));
		this.add(getOper_holeADesc(tblDesc));
		this.add(getSd_oper_holeADesc(tblDesc));
		this.add(getName_oper_holeADesc(tblDesc));
		this.add(getOper_fistulaADesc(tblDesc));
		this.add(getSd_oper_fistulaADesc(tblDesc));
		this.add(getName_oper_fistulaADesc(tblDesc));
		this.add(getPupture_incisionADesc(tblDesc));
		this.add(getSd_pupture_incisionADesc(tblDesc));
		this.add(getName_pupture_incisionADesc(tblDesc));
		this.add(getFat_liquefactionADesc(tblDesc));
		this.add(getSd_fat_liquefactionADesc(tblDesc));
		this.add(getName_fat_liquefactionADesc(tblDesc));
		this.add(getDeepvenous_thrombosisADesc(tblDesc));
		this.add(getSd_deepvenous_thrombosisADesc(tblDesc));
		this.add(getName_deepvenous_thrombosisADesc(tblDesc));
		this.add(getRisk_indexADesc(tblDesc));
		this.add(getFg_feverADesc(tblDesc));
		this.add(getFg_flushADesc(tblDesc));
		this.add(getFg_painADesc(tblDesc));
		this.add(getFg_swellADesc(tblDesc));
		this.add(getFg_intended_open_incisionADesc(tblDesc));
		this.add(getFg_drainADesc(tblDesc));
		this.add(getFg_abscessusADesc(tblDesc));
		this.add(getFg_smear_cultureADesc(tblDesc));
		this.add(getId_di_incisionADesc(tblDesc));
		this.add(getSd_di_incisionADesc(tblDesc));
		this.add(getName_di_incisionADesc(tblDesc));
		this.add(getMemo_di_incisionADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getOper_qkjc_codeADesc(tblDesc));
		this.add(getOper_qkjc_nameADesc(tblDesc));
		this.add(getOper_codeADesc(tblDesc));
		this.add(getOper_nameADesc(tblDesc));
		this.add(getOper_doctor_codeADesc(tblDesc));
		this.add(getOper_doctor_nameADesc(tblDesc));
		this.add(getOper_type_codeADesc(tblDesc));
		this.add(getOper_type_nameADesc(tblDesc));
		this.add(getIncision_type_codeADesc(tblDesc));
		this.add(getIncision_type_nameADesc(tblDesc));
		this.add(getAnes_methods_codeADesc(tblDesc));
		this.add(getAnes_methods_nameADesc(tblDesc));
		this.add(getOper_implantation_codeADesc(tblDesc));
		this.add(getOper_implantation_nameADesc(tblDesc));
		this.add(getAsa_score_codeADesc(tblDesc));
		this.add(getAsa_score_nameADesc(tblDesc));
		this.add(getHeal_condition_codeADesc(tblDesc));
		this.add(getHeal_condition_nameADesc(tblDesc));
		this.add(getOper_lost_blood_codeADesc(tblDesc));
		this.add(getOper_lost_blood_nameADesc(tblDesc));
		this.add(getOper_get_blood_codeADesc(tblDesc));
		this.add(getOper_get_blood_nameADesc(tblDesc));
		this.add(getType_surg_siteinfe_codeADesc(tblDesc));
		this.add(getType_surg_siteinfe_nameADesc(tblDesc));
		this.add(getIs_causeinic_codeADesc(tblDesc));
		this.add(getIs_causeinic_nameADesc(tblDesc));
		this.add(getOper_infec_part_codeADesc(tblDesc));
		this.add(getOper_infec_part_nameADesc(tblDesc));
		this.add(getOper_part_infec_codeADesc(tblDesc));
		this.add(getOper_part_infec_nameADesc(tblDesc));
		this.add(getOper_sightglass_codeADesc(tblDesc));
		this.add(getOper_sightglass_nameADesc(tblDesc));
		this.add(getTake_anti_beforesurgery_codeADesc(tblDesc));
		this.add(getTake_anti_beforesurgery_nameADesc(tblDesc));
		this.add(getLapse_to_codeADesc(tblDesc));
		this.add(getLapse_to_nameADesc(tblDesc));
		this.add(getOper_drainage_codeADesc(tblDesc));
		this.add(getOper_drainage_nameADesc(tblDesc));
		this.add(getOper_hole_codeADesc(tblDesc));
		this.add(getOper_hole_nameADesc(tblDesc));
		this.add(getOper_fistula_codeADesc(tblDesc));
		this.add(getOper_fistula_nameADesc(tblDesc));
		this.add(getPupture_incision_codeADesc(tblDesc));
		this.add(getPupture_incision_nameADesc(tblDesc));
		this.add(getFat_liquefaction_codeADesc(tblDesc));
		this.add(getFat_liquefaction_nameADesc(tblDesc));
		this.add(getDeepvenous_thrombosis_codeADesc(tblDesc));
		this.add(getDeepvenous_thrombosis_nameADesc(tblDesc));
		this.add(getDi_incision_codeADesc(tblDesc));
		this.add(getDi_incision_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_operinciinfectCDesc(tblDesc));
		tblDesc.add(getId_operinciinfectCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getOper_qkjcCDesc(tblDesc));
		tblDesc.add(getSd_oper_qkjcCDesc(tblDesc));
		tblDesc.add(getName_oper_qkjcCDesc(tblDesc));
		tblDesc.add(getId_operCDesc(tblDesc));
		tblDesc.add(getSd_operCDesc(tblDesc));
		tblDesc.add(getName_operCDesc(tblDesc));
		tblDesc.add(getDt_startCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getDuration_operCDesc(tblDesc));
		tblDesc.add(getOper_doctorCDesc(tblDesc));
		tblDesc.add(getSd_oper_doctorCDesc(tblDesc));
		tblDesc.add(getName_oper_doctorCDesc(tblDesc));
		tblDesc.add(getId_oper_typeCDesc(tblDesc));
		tblDesc.add(getSd_oper_typeCDesc(tblDesc));
		tblDesc.add(getName_oper_typeCDesc(tblDesc));
		tblDesc.add(getIncision_countCDesc(tblDesc));
		tblDesc.add(getId_incision_typeCDesc(tblDesc));
		tblDesc.add(getSd_incision_typeCDesc(tblDesc));
		tblDesc.add(getName_incision_typeCDesc(tblDesc));
		tblDesc.add(getId_anes_methodsCDesc(tblDesc));
		tblDesc.add(getSd_anes_methodsCDesc(tblDesc));
		tblDesc.add(getName_anes_methodsCDesc(tblDesc));
		tblDesc.add(getOper_implantationCDesc(tblDesc));
		tblDesc.add(getSd_oper_implantationCDesc(tblDesc));
		tblDesc.add(getName_oper_implantationCDesc(tblDesc));
		tblDesc.add(getId_asa_scoreCDesc(tblDesc));
		tblDesc.add(getSd_asa_scoreCDesc(tblDesc));
		tblDesc.add(getName_asa_scoreCDesc(tblDesc));
		tblDesc.add(getId_heal_conditionCDesc(tblDesc));
		tblDesc.add(getSd_heal_conditionCDesc(tblDesc));
		tblDesc.add(getName_heal_conditionCDesc(tblDesc));
		tblDesc.add(getOper_lost_bloodCDesc(tblDesc));
		tblDesc.add(getSd_oper_lost_bloodCDesc(tblDesc));
		tblDesc.add(getName_oper_lost_bloodCDesc(tblDesc));
		tblDesc.add(getBlood_loss_volumeCDesc(tblDesc));
		tblDesc.add(getOper_get_bloodCDesc(tblDesc));
		tblDesc.add(getSd_oper_get_bloodCDesc(tblDesc));
		tblDesc.add(getName_oper_get_bloodCDesc(tblDesc));
		tblDesc.add(getTransfusion_volumeCDesc(tblDesc));
		tblDesc.add(getId_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getSd_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getName_type_surg_siteinfeCDesc(tblDesc));
		tblDesc.add(getIs_causeinciCDesc(tblDesc));
		tblDesc.add(getSd_is_causeinicCDesc(tblDesc));
		tblDesc.add(getName_is_causeinicCDesc(tblDesc));
		tblDesc.add(getInfection_dateCDesc(tblDesc));
		tblDesc.add(getOper_infec_partCDesc(tblDesc));
		tblDesc.add(getSd_oper_infec_partCDesc(tblDesc));
		tblDesc.add(getName_oper_infec_partCDesc(tblDesc));
		tblDesc.add(getOther_oper_infec_partCDesc(tblDesc));
		tblDesc.add(getOper_part_infecCDesc(tblDesc));
		tblDesc.add(getSd_oper_part_infecCDesc(tblDesc));
		tblDesc.add(getName_oper_part_infecCDesc(tblDesc));
		tblDesc.add(getBackup_field1CDesc(tblDesc));
		tblDesc.add(getBackup_field2CDesc(tblDesc));
		tblDesc.add(getBackup_field3CDesc(tblDesc));
		tblDesc.add(getBackup_field4CDesc(tblDesc));
		tblDesc.add(getBackup_field5CDesc(tblDesc));
		tblDesc.add(getOper_sightglassCDesc(tblDesc));
		tblDesc.add(getSd_oper_sightglassCDesc(tblDesc));
		tblDesc.add(getName_oper_sightglassCDesc(tblDesc));
		tblDesc.add(getTake_anti_beforesurgeryCDesc(tblDesc));
		tblDesc.add(getSd_take_anti_beforesurgeryCDesc(tblDesc));
		tblDesc.add(getName_take_anti_beforesurgeryCDesc(tblDesc));
		tblDesc.add(getLapse_toCDesc(tblDesc));
		tblDesc.add(getSd_lapse_toCDesc(tblDesc));
		tblDesc.add(getName_lapse_toCDesc(tblDesc));
		tblDesc.add(getDt_lapse_toCDesc(tblDesc));
		tblDesc.add(getOper_drainageCDesc(tblDesc));
		tblDesc.add(getSd_oper_drainageCDesc(tblDesc));
		tblDesc.add(getName_oper_drainageCDesc(tblDesc));
		tblDesc.add(getOper_holeCDesc(tblDesc));
		tblDesc.add(getSd_oper_holeCDesc(tblDesc));
		tblDesc.add(getName_oper_holeCDesc(tblDesc));
		tblDesc.add(getOper_fistulaCDesc(tblDesc));
		tblDesc.add(getSd_oper_fistulaCDesc(tblDesc));
		tblDesc.add(getName_oper_fistulaCDesc(tblDesc));
		tblDesc.add(getPupture_incisionCDesc(tblDesc));
		tblDesc.add(getSd_pupture_incisionCDesc(tblDesc));
		tblDesc.add(getName_pupture_incisionCDesc(tblDesc));
		tblDesc.add(getFat_liquefactionCDesc(tblDesc));
		tblDesc.add(getSd_fat_liquefactionCDesc(tblDesc));
		tblDesc.add(getName_fat_liquefactionCDesc(tblDesc));
		tblDesc.add(getDeepvenous_thrombosisCDesc(tblDesc));
		tblDesc.add(getSd_deepvenous_thrombosisCDesc(tblDesc));
		tblDesc.add(getName_deepvenous_thrombosisCDesc(tblDesc));
		tblDesc.add(getRisk_indexCDesc(tblDesc));
		tblDesc.add(getFg_feverCDesc(tblDesc));
		tblDesc.add(getFg_flushCDesc(tblDesc));
		tblDesc.add(getFg_painCDesc(tblDesc));
		tblDesc.add(getFg_swellCDesc(tblDesc));
		tblDesc.add(getFg_intended_open_incisionCDesc(tblDesc));
		tblDesc.add(getFg_drainCDesc(tblDesc));
		tblDesc.add(getFg_abscessusCDesc(tblDesc));
		tblDesc.add(getFg_smear_cultureCDesc(tblDesc));
		tblDesc.add(getId_di_incisionCDesc(tblDesc));
		tblDesc.add(getSd_di_incisionCDesc(tblDesc));
		tblDesc.add(getName_di_incisionCDesc(tblDesc));
		tblDesc.add(getMemo_di_incisionCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术切口感染主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operinciinfectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operinciinfect",  getId_operinciinfectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口感染主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感上报主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalreportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalreport",  getId_hospitalreportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术切口检测属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_qkjcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_qkjc",  getOper_qkjcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口检测");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术切口检测编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_qkjcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_qkjc",  getSd_oper_qkjcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口检测编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术切口名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_qkjcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_qkjc",  getName_oper_qkjcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术切口名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper",  getId_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper",  getSd_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper",  getName_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_startADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start",  getDt_startCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDuration_operADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Duration_oper",  getDuration_operCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_doctor",  getOper_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_doctor",  getSd_oper_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_doctor",  getName_oper_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_type",  getId_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_type",  getSd_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_type",  getName_oper_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口个数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncision_countADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incision_count",  getIncision_countCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("切口个数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incision_type",  getId_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incision_type",  getSd_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incision_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incision_type",  getName_incision_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anes_methods",  getId_anes_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anes_methods",  getSd_anes_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anes_methodsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anes_methods",  getName_anes_methodsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 植入物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_implantationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_implantation",  getOper_implantationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("植入物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 植入物编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_implantationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_implantation",  getSd_oper_implantationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("植入物编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 植入物名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_implantationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_implantation",  getName_oper_implantationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("植入物名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ASA评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_asa_score",  getId_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ASA评分编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_asa_score",  getSd_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ASA评分名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_asa_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_asa_score",  getName_asa_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ASA评分名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 愈合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_heal_condition",  getId_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 愈合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_heal_condition",  getSd_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 愈合情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_heal_conditionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_heal_condition",  getName_heal_conditionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("愈合情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_lost_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_lost_blood",  getOper_lost_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("失血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 失血编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_lost_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_lost_blood",  getSd_oper_lost_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("失血编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_lost_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_lost_blood",  getName_oper_lost_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("失血名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_loss_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_loss_volume",  getBlood_loss_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("失血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_get_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_get_blood",  getOper_get_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_get_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_get_blood",  getSd_oper_get_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_get_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_get_blood",  getName_oper_get_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransfusion_volumeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transfusion_volume",  getTransfusion_volumeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_type_surg_siteinfe",  getId_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_type_surg_siteinfe",  getSd_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_type_surg_siteinfeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_type_surg_siteinfe",  getName_type_surg_siteinfeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引起院内感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_causeinciADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_causeinci",  getIs_causeinciCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引起院内感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引起院内感染编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_is_causeinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_is_causeinic",  getSd_is_causeinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引起院内感染编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引起院内感染名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_causeinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_causeinic",  getName_is_causeinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引起院内感染名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_date",  getInfection_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("感染日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_infec_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_infec_part",  getOper_infec_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术部位感染诊断依据编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_infec_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_infec_part",  getSd_oper_infec_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染诊断依据编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染诊断依据名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_infec_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_infec_part",  getName_oper_infec_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染诊断依据名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染诊断依据其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_oper_infec_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_oper_infec_part",  getOther_oper_infec_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染诊断依据其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_part_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_part_infec",  getOper_part_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术部位感染编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_part_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_part_infec",  getSd_oper_part_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位感染名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_part_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_part_infec",  getName_oper_part_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位感染名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field1",  getBackup_field1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field2",  getBackup_field2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field3",  getBackup_field3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field4",  getBackup_field4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field5",  getBackup_field5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 窥镜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_sightglassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_sightglass",  getOper_sightglassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("窥镜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 窥镜编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_sightglassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_sightglass",  getSd_oper_sightglassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("窥镜编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 窥镜名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_sightglassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_sightglass",  getName_oper_sightglassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("窥镜名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前口服抗生素肠道准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTake_anti_beforesurgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Take_anti_beforesurgery",  getTake_anti_beforesurgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前口服抗生素肠道准备");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前口服抗生素肠道准备编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_take_anti_beforesurgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_take_anti_beforesurgery",  getSd_take_anti_beforesurgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前口服抗生素肠道准备编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前口服抗生素肠道准备名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_take_anti_beforesurgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_take_anti_beforesurgery",  getName_take_anti_beforesurgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前口服抗生素肠道准备名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLapse_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lapse_to",  getLapse_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lapse_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lapse_to",  getSd_lapse_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转归名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lapse_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lapse_to",  getName_lapse_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转归名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转归日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_lapse_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_lapse_to",  getDt_lapse_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("转归日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_drainage",  getOper_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引流编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_drainage",  getSd_oper_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_drainage",  getName_oper_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿孔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_holeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_hole",  getOper_holeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿孔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 穿孔编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_holeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_hole",  getSd_oper_holeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿孔编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 穿孔名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_holeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_hole",  getName_oper_holeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("穿孔名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瘘管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_fistulaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_fistula",  getOper_fistulaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瘘管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 瘘管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_fistulaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_fistula",  getSd_oper_fistulaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瘘管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 瘘管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_fistulaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_fistula",  getName_oper_fistulaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("瘘管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口裂开属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPupture_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pupture_incision",  getPupture_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口裂开");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口裂开编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pupture_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pupture_incision",  getSd_pupture_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口裂开编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口裂开名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pupture_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pupture_incision",  getName_pupture_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口裂开名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脂肪液化属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFat_liquefactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fat_liquefaction",  getFat_liquefactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脂肪液化");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脂肪液化编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fat_liquefactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fat_liquefaction",  getSd_fat_liquefactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脂肪液化编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脂肪液化名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fat_liquefactionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fat_liquefaction",  getName_fat_liquefactionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脂肪液化名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉血栓属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeepvenous_thrombosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deepvenous_thrombosis",  getDeepvenous_thrombosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉血栓");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 深静脉血栓编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deepvenous_thrombosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_deepvenous_thrombosis",  getSd_deepvenous_thrombosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉血栓编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 深静脉血栓名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deepvenous_thrombosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deepvenous_thrombosis",  getName_deepvenous_thrombosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("深静脉血栓名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 危险指数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRisk_indexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Risk_index",  getRisk_indexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("危险指数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发热属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_feverADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fever",  getFg_feverCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("发热");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发红属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_flushADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_flush",  getFg_flushCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("发红");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pain",  getFg_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("疼痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肿胀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_swellADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_swell",  getFg_swellCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("肿胀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有意敞开切口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_intended_open_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_intended_open_incision",  getFg_intended_open_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("有意敞开切口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_drainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_drain",  getFg_drainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引流液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脓肿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_abscessusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_abscessus",  getFg_abscessusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("脓肿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 涂片或培养属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_smear_cultureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_smear_culture",  getFg_smear_cultureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("涂片或培养");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_di_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di_incision",  getId_di_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医生诊断诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_di_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_di_incision",  getSd_di_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生诊断诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生诊断诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_di_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di_incision",  getName_di_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生诊断诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断补充说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMemo_di_incisionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Memo_di_incision",  getMemo_di_incisionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断补充说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_qkjc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_qkjc_code",  getOper_qkjc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","oper_qkjc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_qkjc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_qkjc_name",  getOper_qkjc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","oper_qkjc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_code",  getOper_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b3","id_oper=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_name",  getOper_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b3","id_oper=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_doctor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_doctor_code",  getOper_doctor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","oper_doctor=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_doctor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_doctor_name",  getOper_doctor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","oper_doctor=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_type_code",  getOper_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_oper_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_type_name",  getOper_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_oper_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncision_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incision_type_code",  getIncision_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_incision_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncision_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incision_type_name",  getIncision_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_incision_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnes_methods_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anes_methods_code",  getAnes_methods_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_anes_methods=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnes_methods_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anes_methods_name",  getAnes_methods_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_anes_methods=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_implantation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_implantation_code",  getOper_implantation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","oper_implantation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_implantation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_implantation_name",  getOper_implantation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","oper_implantation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAsa_score_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Asa_score_code",  getAsa_score_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_asa_score=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAsa_score_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Asa_score_name",  getAsa_score_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_asa_score=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeal_condition_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heal_condition_code",  getHeal_condition_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_heal_condition=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeal_condition_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heal_condition_name",  getHeal_condition_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_heal_condition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_lost_blood_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_lost_blood_code",  getOper_lost_blood_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","oper_lost_blood=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_lost_blood_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_lost_blood_name",  getOper_lost_blood_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","oper_lost_blood=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_get_blood_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_get_blood_code",  getOper_get_blood_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","oper_get_blood=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_get_blood_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_get_blood_name",  getOper_get_blood_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","oper_get_blood=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surg_siteinfe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surg_siteinfe_code",  getType_surg_siteinfe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_type_surg_siteinfe=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getType_surg_siteinfe_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type_surg_siteinfe_name",  getType_surg_siteinfe_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_type_surg_siteinfe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_causeinic_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_causeinic_code",  getIs_causeinic_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","is_causeinci=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_causeinic_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_causeinic_name",  getIs_causeinic_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","is_causeinci=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_infec_part_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_infec_part_code",  getOper_infec_part_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","oper_infec_part=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_infec_part_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_infec_part_name",  getOper_infec_part_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","oper_infec_part=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_part_infec_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_part_infec_code",  getOper_part_infec_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","oper_part_infec=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_part_infec_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_part_infec_name",  getOper_part_infec_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","oper_part_infec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_sightglass_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_sightglass_code",  getOper_sightglass_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","oper_sightglass=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_sightglass_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_sightglass_name",  getOper_sightglass_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","oper_sightglass=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTake_anti_beforesurgery_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Take_anti_beforesurgery_code",  getTake_anti_beforesurgery_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","take_anti_beforesurgery=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTake_anti_beforesurgery_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Take_anti_beforesurgery_name",  getTake_anti_beforesurgery_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","take_anti_beforesurgery=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLapse_to_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lapse_to_code",  getLapse_to_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","lapse_to=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLapse_to_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lapse_to_name",  getLapse_to_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","lapse_to=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_drainage_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_drainage_code",  getOper_drainage_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","oper_drainage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_drainage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_drainage_name",  getOper_drainage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","oper_drainage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_hole_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_hole_code",  getOper_hole_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","oper_hole=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_hole_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_hole_name",  getOper_hole_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","oper_hole=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_fistula_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_fistula_code",  getOper_fistula_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","oper_fistula=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_fistula_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_fistula_name",  getOper_fistula_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","oper_fistula=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPupture_incision_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pupture_incision_code",  getPupture_incision_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","pupture_incision=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPupture_incision_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pupture_incision_name",  getPupture_incision_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","pupture_incision=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFat_liquefaction_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fat_liquefaction_code",  getFat_liquefaction_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","fat_liquefaction=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFat_liquefaction_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fat_liquefaction_name",  getFat_liquefaction_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","fat_liquefaction=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeepvenous_thrombosis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deepvenous_thrombosis_code",  getDeepvenous_thrombosis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","deepvenous_thrombosis=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeepvenous_thrombosis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deepvenous_thrombosis_name",  getDeepvenous_thrombosis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","deepvenous_thrombosis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_incision_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_incision_code",  getDi_incision_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b26","id_di_incision=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_incision_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_incision_name",  getDi_incision_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b26","id_di_incision=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术切口感染主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operinciinfectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operinciinfect");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术切口感染主键ID"); 
		return column;
	}
	/**
	 * 获取院感上报主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报主键"); 
		return column;
	}
	/**
	 * 获取手术切口检测表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_qkjcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_qkjc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口检测"); 
		return column;
	}
	/**
	 * 获取手术切口检测编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_qkjcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_qkjc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口检测编码"); 
		return column;
	}
	/**
	 * 获取手术切口名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_qkjcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_qkjc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术切口名称"); 
		return column;
	}
	/**
	 * 获取手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术编码"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_startCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
		return column;
	}
	/**
	 * 获取手术时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDuration_operCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Duration_oper");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术时长"); 
		return column;
	}
	/**
	 * 获取手术医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_doctor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医生"); 
		return column;
	}
	/**
	 * 获取手术医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医生编码"); 
		return column;
	}
	/**
	 * 获取手术医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医生名称"); 
		return column;
	}
	/**
	 * 获取手术类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型"); 
		return column;
	}
	/**
	 * 获取手术类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型编码"); 
		return column;
	}
	/**
	 * 获取手术类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类型名称"); 
		return column;
	}
	/**
	 * 获取切口个数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncision_countCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incision_count");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("切口个数"); 
		return column;
	}
	/**
	 * 获取切口类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incision_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型"); 
		return column;
	}
	/**
	 * 获取切口类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incision_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型编码"); 
		return column;
	}
	/**
	 * 获取切口类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incision_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incision_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口类型名称"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anes_methods");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anes_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取麻醉方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anes_methodsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anes_methods");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取植入物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_implantationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_implantation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("植入物"); 
		return column;
	}
	/**
	 * 获取植入物编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_implantationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_implantation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("植入物编码"); 
		return column;
	}
	/**
	 * 获取植入物名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_implantationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_implantation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("植入物名称"); 
		return column;
	}
	/**
	 * 获取ASA评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_asa_score");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分"); 
		return column;
	}
	/**
	 * 获取ASA评分编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_asa_score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分编码"); 
		return column;
	}
	/**
	 * 获取ASA评分名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_asa_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_asa_score");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分名称"); 
		return column;
	}
	/**
	 * 获取愈合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_heal_condition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况"); 
		return column;
	}
	/**
	 * 获取愈合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_heal_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况编码"); 
		return column;
	}
	/**
	 * 获取愈合情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_heal_conditionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_heal_condition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("愈合情况名称"); 
		return column;
	}
	/**
	 * 获取失血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_lost_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_lost_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("失血"); 
		return column;
	}
	/**
	 * 获取失血编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_lost_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_lost_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("失血编码"); 
		return column;
	}
	/**
	 * 获取失血名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_lost_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_lost_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("失血名称"); 
		return column;
	}
	/**
	 * 获取失血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlood_loss_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_loss_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("失血量"); 
		return column;
	}
	/**
	 * 获取输血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_get_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_get_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血"); 
		return column;
	}
	/**
	 * 获取输血编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_get_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_get_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血编码"); 
		return column;
	}
	/**
	 * 获取输血名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_get_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_get_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血名称"); 
		return column;
	}
	/**
	 * 获取输血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransfusion_volumeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transfusion_volume");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输血量"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_type_surg_siteinfe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_type_surg_siteinfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型编码"); 
		return column;
	}
	/**
	 * 获取手术部位感染类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_type_surg_siteinfeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_type_surg_siteinfe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染类型名称"); 
		return column;
	}
	/**
	 * 获取引起院内感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_causeinciCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_causeinci");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引起院内感染"); 
		return column;
	}
	/**
	 * 获取引起院内感染编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_is_causeinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_is_causeinic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引起院内感染编码"); 
		return column;
	}
	/**
	 * 获取引起院内感染名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_is_causeinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_causeinic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引起院内感染名称"); 
		return column;
	}
	/**
	 * 获取感染日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("感染日期"); 
		return column;
	}
	/**
	 * 获取手术部位感染诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_infec_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_infec_part");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染诊断依据"); 
		return column;
	}
	/**
	 * 获取手术部位感染诊断依据编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_infec_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_infec_part");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染诊断依据编码"); 
		return column;
	}
	/**
	 * 获取手术部位感染诊断依据名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_infec_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_infec_part");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染诊断依据名称"); 
		return column;
	}
	/**
	 * 获取手术部位感染诊断依据其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_oper_infec_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_oper_infec_part");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染诊断依据其它"); 
		return column;
	}
	/**
	 * 获取手术部位感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_part_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_part_infec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染"); 
		return column;
	}
	/**
	 * 获取手术部位感染编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_part_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_part_infec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染编码"); 
		return column;
	}
	/**
	 * 获取手术部位感染名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_part_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_part_infec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位感染名称"); 
		return column;
	}
	/**
	 * 获取备用字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段1"); 
		return column;
	}
	/**
	 * 获取备用字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段2"); 
		return column;
	}
	/**
	 * 获取备用字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field3");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段3"); 
		return column;
	}
	/**
	 * 获取备用字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field4");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段4"); 
		return column;
	}
	/**
	 * 获取备用字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field5");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段5"); 
		return column;
	}
	/**
	 * 获取窥镜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_sightglassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_sightglass");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("窥镜"); 
		return column;
	}
	/**
	 * 获取窥镜编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_sightglassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_sightglass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("窥镜编码"); 
		return column;
	}
	/**
	 * 获取窥镜名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_sightglassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_sightglass");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("窥镜名称"); 
		return column;
	}
	/**
	 * 获取术前口服抗生素肠道准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTake_anti_beforesurgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Take_anti_beforesurgery");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前口服抗生素肠道准备"); 
		return column;
	}
	/**
	 * 获取术前口服抗生素肠道准备编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_take_anti_beforesurgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_take_anti_beforesurgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前口服抗生素肠道准备编码"); 
		return column;
	}
	/**
	 * 获取术前口服抗生素肠道准备名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_take_anti_beforesurgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_take_anti_beforesurgery");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前口服抗生素肠道准备名称"); 
		return column;
	}
	/**
	 * 获取转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLapse_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lapse_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转归"); 
		return column;
	}
	/**
	 * 获取转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lapse_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lapse_to");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转归编码"); 
		return column;
	}
	/**
	 * 获取转归名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lapse_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lapse_to");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转归名称"); 
		return column;
	}
	/**
	 * 获取转归日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_lapse_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_lapse_to");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转归日期"); 
		return column;
	}
	/**
	 * 获取引流表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_drainage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流"); 
		return column;
	}
	/**
	 * 获取引流编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_drainage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流编码"); 
		return column;
	}
	/**
	 * 获取引流名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_drainage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流名称"); 
		return column;
	}
	/**
	 * 获取穿孔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_holeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_hole");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿孔"); 
		return column;
	}
	/**
	 * 获取穿孔编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_holeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_hole");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿孔编码"); 
		return column;
	}
	/**
	 * 获取穿孔名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_holeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_hole");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("穿孔名称"); 
		return column;
	}
	/**
	 * 获取瘘管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_fistulaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_fistula");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瘘管"); 
		return column;
	}
	/**
	 * 获取瘘管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_fistulaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_fistula");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瘘管编码"); 
		return column;
	}
	/**
	 * 获取瘘管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_fistulaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_fistula");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("瘘管名称"); 
		return column;
	}
	/**
	 * 获取切口裂开表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPupture_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pupture_incision");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口裂开"); 
		return column;
	}
	/**
	 * 获取切口裂开编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pupture_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pupture_incision");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口裂开编码"); 
		return column;
	}
	/**
	 * 获取切口裂开名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pupture_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pupture_incision");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口裂开名称"); 
		return column;
	}
	/**
	 * 获取脂肪液化表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFat_liquefactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fat_liquefaction");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脂肪液化"); 
		return column;
	}
	/**
	 * 获取脂肪液化编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fat_liquefactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fat_liquefaction");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脂肪液化编码"); 
		return column;
	}
	/**
	 * 获取脂肪液化名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fat_liquefactionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fat_liquefaction");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脂肪液化名称"); 
		return column;
	}
	/**
	 * 获取深静脉血栓表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeepvenous_thrombosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deepvenous_thrombosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉血栓"); 
		return column;
	}
	/**
	 * 获取深静脉血栓编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deepvenous_thrombosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_deepvenous_thrombosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉血栓编码"); 
		return column;
	}
	/**
	 * 获取深静脉血栓名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deepvenous_thrombosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deepvenous_thrombosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("深静脉血栓名称"); 
		return column;
	}
	/**
	 * 获取危险指数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRisk_indexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Risk_index");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("危险指数"); 
		return column;
	}
	/**
	 * 获取发热表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_feverCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fever");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发热"); 
		return column;
	}
	/**
	 * 获取发红表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_flushCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_flush");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发红"); 
		return column;
	}
	/**
	 * 获取疼痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pain");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("疼痛"); 
		return column;
	}
	/**
	 * 获取肿胀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_swellCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_swell");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("肿胀"); 
		return column;
	}
	/**
	 * 获取有意敞开切口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_intended_open_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_intended_open_incision");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有意敞开切口"); 
		return column;
	}
	/**
	 * 获取引流液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_drainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_drain");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引流液"); 
		return column;
	}
	/**
	 * 获取脓肿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_abscessusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_abscessus");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("脓肿"); 
		return column;
	}
	/**
	 * 获取涂片或培养表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_smear_cultureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_smear_culture");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("涂片或培养"); 
		return column;
	}
	/**
	 * 获取医生诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_di_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di_incision");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生诊断"); 
		return column;
	}
	/**
	 * 获取医生诊断诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_di_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_di_incision");
		column.setLength(400);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生诊断诊断编码"); 
		return column;
	}
	/**
	 * 获取医生诊断诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_di_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di_incision");
		column.setLength(400);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生诊断诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断补充说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMemo_di_incisionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Memo_di_incision");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断补充说明"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_qkjc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_qkjc_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_qkjc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_qkjc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_doctor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_doctor_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_doctor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_doctor_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_type_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_type_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncision_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incision_type_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncision_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incision_type_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnes_methods_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anes_methods_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnes_methods_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anes_methods_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_implantation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_implantation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_implantation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_implantation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAsa_score_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Asa_score_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAsa_score_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Asa_score_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeal_condition_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heal_condition_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeal_condition_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heal_condition_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_lost_blood_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_lost_blood_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_lost_blood_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_lost_blood_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_get_blood_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_get_blood_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_get_blood_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_get_blood_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getType_surg_siteinfe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surg_siteinfe_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getType_surg_siteinfe_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type_surg_siteinfe_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_causeinic_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_causeinic_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_causeinic_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_causeinic_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_infec_part_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_infec_part_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_infec_part_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_infec_part_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_part_infec_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_part_infec_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_part_infec_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_part_infec_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_sightglass_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_sightglass_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_sightglass_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_sightglass_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTake_anti_beforesurgery_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Take_anti_beforesurgery_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTake_anti_beforesurgery_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Take_anti_beforesurgery_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLapse_to_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lapse_to_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLapse_to_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lapse_to_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_drainage_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_drainage_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_drainage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_drainage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_hole_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_hole_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_hole_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_hole_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_fistula_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_fistula_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOper_fistula_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_fistula_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPupture_incision_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pupture_incision_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPupture_incision_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pupture_incision_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFat_liquefaction_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fat_liquefaction_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFat_liquefaction_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fat_liquefaction_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeepvenous_thrombosis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deepvenous_thrombosis_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeepvenous_thrombosis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deepvenous_thrombosis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_incision_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_incision_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_incision_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_incision_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
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
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
		defaultValueMap.put("Is_causeinci","N");
	}
	
}
