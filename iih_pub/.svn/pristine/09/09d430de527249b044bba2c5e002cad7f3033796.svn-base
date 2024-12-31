
package iih.ci.rcm.liqexpcontact.d.desc;

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
 * 血液/体液暴露接触登记表 DO 元数据信息
 */
public class LiqExpContactDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.liqexpcontact.d.LiqExpContactDO";
	public static final String CLASS_DISPALYNAME = "血液/体液暴露接触登记表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rcm_liqexpcon";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_liqexpcon";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public LiqExpContactDODesc(){
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
		this.setKeyDesc(getId_liqexpconADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_liqexpconADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getSd_deptADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
		this.add(getWorkageADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getInvesttimeADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getInjury_timeADesc(tblDesc));
		this.add(getId_work_typeADesc(tblDesc));
		this.add(getSd_work_typeADesc(tblDesc));
		this.add(getName_work_typeADesc(tblDesc));
		this.add(getId_exposure_locADesc(tblDesc));
		this.add(getSd_exposure_locADesc(tblDesc));
		this.add(getName_exposure_locADesc(tblDesc));
		this.add(getId_know_pat_infoADesc(tblDesc));
		this.add(getSd_know_pat_infoADesc(tblDesc));
		this.add(getName_know_pat_infoADesc(tblDesc));
		this.add(getId_bodyfluidADesc(tblDesc));
		this.add(getSd_bodyfluidADesc(tblDesc));
		this.add(getName_bodyfluidADesc(tblDesc));
		this.add(getOther_bodyfluid_instructionADesc(tblDesc));
		this.add(getId_exposed_areaADesc(tblDesc));
		this.add(getSd_exposed_areaADesc(tblDesc));
		this.add(getName_exposed_areaADesc(tblDesc));
		this.add(getOther_exposed_area_instrADesc(tblDesc));
		this.add(getId_blood_bodyfluidADesc(tblDesc));
		this.add(getSd_blood_bodyfluidADesc(tblDesc));
		this.add(getName_blood_bodyfluidADesc(tblDesc));
		this.add(getId_protect_applianceADesc(tblDesc));
		this.add(getSd_protect_applianceADesc(tblDesc));
		this.add(getName_protect_applianceADesc(tblDesc));
		this.add(getOther_work_clothes_instrADesc(tblDesc));
		this.add(getOther_protect_tool_instrADesc(tblDesc));
		this.add(getId_blood_contADesc(tblDesc));
		this.add(getSd_blood_contADesc(tblDesc));
		this.add(getName_blood_contADesc(tblDesc));
		this.add(getId_expos_reasonADesc(tblDesc));
		this.add(getSd_expos_reasonADesc(tblDesc));
		this.add(getName_expos_reasonADesc(tblDesc));
		this.add(getEquip_type_manuADesc(tblDesc));
		this.add(getId_time_contADesc(tblDesc));
		this.add(getSd_time_contADesc(tblDesc));
		this.add(getName_time_contADesc(tblDesc));
		this.add(getId_quant_contADesc(tblDesc));
		this.add(getSd_quant_contADesc(tblDesc));
		this.add(getName_quant_contADesc(tblDesc));
		this.add(getId_max_areaADesc(tblDesc));
		this.add(getSd_max_areaADesc(tblDesc));
		this.add(getName_max_areaADesc(tblDesc));
		this.add(getId_mid_areaADesc(tblDesc));
		this.add(getSd_mid_areaADesc(tblDesc));
		this.add(getName_mid_areaADesc(tblDesc));
		this.add(getId_min_areaADesc(tblDesc));
		this.add(getSd_min_areaADesc(tblDesc));
		this.add(getName_min_areaADesc(tblDesc));
		this.add(getExposure_situationADesc(tblDesc));
		this.add(getId_opt_avoidADesc(tblDesc));
		this.add(getSd_opt_avoidADesc(tblDesc));
		this.add(getName_opt_avoidADesc(tblDesc));
		this.add(getExplain_opt_avoidADesc(tblDesc));
		this.add(getMedical_staff_lab_exam_feeADesc(tblDesc));
		this.add(getPat_exam_costADesc(tblDesc));
		this.add(getPreve_treatment_feeADesc(tblDesc));
		this.add(getPat_treatment_feeADesc(tblDesc));
		this.add(getService_costADesc(tblDesc));
		this.add(getOther_costADesc(tblDesc));
		this.add(getTotal_costADesc(tblDesc));
		this.add(getId_reportADesc(tblDesc));
		this.add(getSd_reportADesc(tblDesc));
		this.add(getName_reportADesc(tblDesc));
		this.add(getDays_off_numADesc(tblDesc));
		this.add(getRestrict_worke_dayADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getWork_type_codeADesc(tblDesc));
		this.add(getWork_type_nameADesc(tblDesc));
		this.add(getExposure_loc_codeADesc(tblDesc));
		this.add(getExposure_loc_nameADesc(tblDesc));
		this.add(getKnow_pat_info_codeADesc(tblDesc));
		this.add(getKnow_pat_info_nameADesc(tblDesc));
		this.add(getBodyfluid_codeADesc(tblDesc));
		this.add(getBodyfluid_nameADesc(tblDesc));
		this.add(getExposed_area_codeADesc(tblDesc));
		this.add(getExposed_area_nameADesc(tblDesc));
		this.add(getBlood_bodyfluid_codeADesc(tblDesc));
		this.add(getBlood_bodyfluid_nameADesc(tblDesc));
		this.add(getProtect_appliance_codeADesc(tblDesc));
		this.add(getProtect_appliance_nameADesc(tblDesc));
		this.add(getBlood_cont_codeADesc(tblDesc));
		this.add(getBlood_cont_nameADesc(tblDesc));
		this.add(getExpos_reason_codeADesc(tblDesc));
		this.add(getExpos_reason_nameADesc(tblDesc));
		this.add(getTime_cont_codeADesc(tblDesc));
		this.add(getTime_cont_nameADesc(tblDesc));
		this.add(getQuant_cont_codeADesc(tblDesc));
		this.add(getQuant_cont_nameADesc(tblDesc));
		this.add(getMax_area_codeADesc(tblDesc));
		this.add(getMax_area_nameADesc(tblDesc));
		this.add(getMid_area_codeADesc(tblDesc));
		this.add(getMid_area_nameADesc(tblDesc));
		this.add(getMin_area_nameADesc(tblDesc));
		this.add(getMin_area_codeADesc(tblDesc));
		this.add(getOpt_avoid_codeADesc(tblDesc));
		this.add(getOpt_avoid_nameADesc(tblDesc));
		this.add(getReport_codeADesc(tblDesc));
		this.add(getReport_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_liqexpconCDesc(tblDesc));
		tblDesc.add(getId_liqexpconCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getSd_deptCDesc(tblDesc));
		tblDesc.add(getName_deptCDesc(tblDesc));
		tblDesc.add(getWorkageCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getInvesttimeCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getInjury_timeCDesc(tblDesc));
		tblDesc.add(getId_work_typeCDesc(tblDesc));
		tblDesc.add(getSd_work_typeCDesc(tblDesc));
		tblDesc.add(getName_work_typeCDesc(tblDesc));
		tblDesc.add(getId_exposure_locCDesc(tblDesc));
		tblDesc.add(getSd_exposure_locCDesc(tblDesc));
		tblDesc.add(getName_exposure_locCDesc(tblDesc));
		tblDesc.add(getId_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getSd_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getName_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getId_bodyfluidCDesc(tblDesc));
		tblDesc.add(getSd_bodyfluidCDesc(tblDesc));
		tblDesc.add(getName_bodyfluidCDesc(tblDesc));
		tblDesc.add(getOther_bodyfluid_instructionCDesc(tblDesc));
		tblDesc.add(getId_exposed_areaCDesc(tblDesc));
		tblDesc.add(getSd_exposed_areaCDesc(tblDesc));
		tblDesc.add(getName_exposed_areaCDesc(tblDesc));
		tblDesc.add(getOther_exposed_area_instrCDesc(tblDesc));
		tblDesc.add(getId_blood_bodyfluidCDesc(tblDesc));
		tblDesc.add(getSd_blood_bodyfluidCDesc(tblDesc));
		tblDesc.add(getName_blood_bodyfluidCDesc(tblDesc));
		tblDesc.add(getId_protect_applianceCDesc(tblDesc));
		tblDesc.add(getSd_protect_applianceCDesc(tblDesc));
		tblDesc.add(getName_protect_applianceCDesc(tblDesc));
		tblDesc.add(getOther_work_clothes_instrCDesc(tblDesc));
		tblDesc.add(getOther_protect_tool_instrCDesc(tblDesc));
		tblDesc.add(getId_blood_contCDesc(tblDesc));
		tblDesc.add(getSd_blood_contCDesc(tblDesc));
		tblDesc.add(getName_blood_contCDesc(tblDesc));
		tblDesc.add(getId_expos_reasonCDesc(tblDesc));
		tblDesc.add(getSd_expos_reasonCDesc(tblDesc));
		tblDesc.add(getName_expos_reasonCDesc(tblDesc));
		tblDesc.add(getEquip_type_manuCDesc(tblDesc));
		tblDesc.add(getId_time_contCDesc(tblDesc));
		tblDesc.add(getSd_time_contCDesc(tblDesc));
		tblDesc.add(getName_time_contCDesc(tblDesc));
		tblDesc.add(getId_quant_contCDesc(tblDesc));
		tblDesc.add(getSd_quant_contCDesc(tblDesc));
		tblDesc.add(getName_quant_contCDesc(tblDesc));
		tblDesc.add(getId_max_areaCDesc(tblDesc));
		tblDesc.add(getSd_max_areaCDesc(tblDesc));
		tblDesc.add(getName_max_areaCDesc(tblDesc));
		tblDesc.add(getId_mid_areaCDesc(tblDesc));
		tblDesc.add(getSd_mid_areaCDesc(tblDesc));
		tblDesc.add(getName_mid_areaCDesc(tblDesc));
		tblDesc.add(getId_min_areaCDesc(tblDesc));
		tblDesc.add(getSd_min_areaCDesc(tblDesc));
		tblDesc.add(getName_min_areaCDesc(tblDesc));
		tblDesc.add(getExposure_situationCDesc(tblDesc));
		tblDesc.add(getId_opt_avoidCDesc(tblDesc));
		tblDesc.add(getSd_opt_avoidCDesc(tblDesc));
		tblDesc.add(getName_opt_avoidCDesc(tblDesc));
		tblDesc.add(getExplain_opt_avoidCDesc(tblDesc));
		tblDesc.add(getMedical_staff_lab_exam_feeCDesc(tblDesc));
		tblDesc.add(getPat_exam_costCDesc(tblDesc));
		tblDesc.add(getPreve_treatment_feeCDesc(tblDesc));
		tblDesc.add(getPat_treatment_feeCDesc(tblDesc));
		tblDesc.add(getService_costCDesc(tblDesc));
		tblDesc.add(getOther_costCDesc(tblDesc));
		tblDesc.add(getTotal_costCDesc(tblDesc));
		tblDesc.add(getId_reportCDesc(tblDesc));
		tblDesc.add(getSd_reportCDesc(tblDesc));
		tblDesc.add(getName_reportCDesc(tblDesc));
		tblDesc.add(getDays_off_numCDesc(tblDesc));
		tblDesc.add(getRestrict_worke_dayCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 暴露接触登记表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_liqexpconADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_liqexpcon",  getId_liqexpconCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露接触登记表主键");
		attrDesc.setNullable(false);
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 姓名编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat",  getSd_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名名称");
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
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dept",  getSd_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorkageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Workage",  getWorkageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("工龄");
		attrDesc.setNullable(true);
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查表时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvesttimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investtime",  getInvesttimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("调查表时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 发生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInjury_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Injury_time",  getInjury_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发生时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_work_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_work_type",  getId_work_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 工作类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_work_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_work_type",  getSd_work_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_work_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_work_type",  getName_work_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露发生的地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exposure_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exposure_loc",  getId_exposure_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生的地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露发生的地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_exposure_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_exposure_loc",  getSd_exposure_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生的地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露发生的地点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_exposure_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_exposure_loc",  getName_exposure_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生的地点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否知道病人源情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_know_pat_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_know_pat_info",  getId_know_pat_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否知道病人源情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否知道病人源情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_know_pat_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_know_pat_info",  getSd_know_pat_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否知道病人源情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否知道病人源情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_know_pat_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_know_pat_info",  getName_know_pat_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否知道病人源情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 涉及体液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bodyfluid",  getId_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("涉及体液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 涉及体液编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bodyfluid",  getSd_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("涉及体液编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 涉及体液编码名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bodyfluid",  getName_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("涉及体液编码名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它体液说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_bodyfluid_instructionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_bodyfluid_instruction",  getOther_bodyfluid_instructionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它体液说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exposed_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exposed_area",  getId_exposed_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_exposed_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_exposed_area",  getSd_exposed_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_exposed_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_exposed_area",  getName_exposed_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露部位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它暴露部位说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_exposed_area_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_exposed_area_instr",  getOther_exposed_area_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它暴露部位说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液/体液属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_bodyfluid",  getId_blood_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液/体液");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血液/体液编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_bodyfluid",  getSd_blood_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液/体液编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液/体液名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_bodyfluidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_bodyfluid",  getName_blood_bodyfluidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液/体液名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保护用具属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_protect_applianceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_protect_appliance",  getId_protect_applianceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保护用具");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 保护用具编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_protect_applianceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_protect_appliance",  getSd_protect_applianceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保护用具编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保护用具名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_protect_applianceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_protect_appliance",  getName_protect_applianceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保护用具名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它工作服的说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_work_clothes_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_work_clothes_instr",  getOther_work_clothes_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它工作服的说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它保护工具的说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_protect_tool_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_protect_tool_instr",  getOther_protect_tool_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它保护工具的说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体液是否受血液污染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_cont",  getId_blood_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体液是否受血液污染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体液是否受血液污染编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_cont",  getSd_blood_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体液是否受血液污染编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体液是否受血液污染名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_cont",  getName_blood_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体液是否受血液污染名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 造成暴露接触的原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_expos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_expos_reason",  getId_expos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("造成暴露接触的原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 造成暴露接触的原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_expos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_expos_reason",  getSd_expos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("造成暴露接触的原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 造成暴露接触的原因名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_expos_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_expos_reason",  getName_expos_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("造成暴露接触的原因名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如果是设备故障请详细说明设备类型和生产厂商属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEquip_type_manuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Equip_type_manu",  getEquip_type_manuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如果是设备故障请详细说明设备类型和生产厂商");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_time_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_time_cont",  getId_time_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液或体液接触皮肤或粘膜多长时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_time_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_time_cont",  getSd_time_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液或体液接触皮肤或粘膜多长时间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_time_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_time_cont",  getName_time_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血液或体液接触皮肤或粘膜多长时间名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_quant_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_quant_cont",  getId_quant_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大约有多少血液或体液接触皮肤和粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_quant_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_quant_cont",  getSd_quant_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大约有多少血液或体液接触皮肤和粘膜编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_quant_contADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_quant_cont",  getName_quant_contCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大约有多少血液或体液接触皮肤和粘膜名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量最大的区域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_max_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_max_area",  getId_max_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最大的区域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露量最大的区域编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_max_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_max_area",  getSd_max_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最大的区域编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量最大的区域名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_max_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_max_area",  getName_max_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最大的区域名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量中等的区域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mid_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mid_area",  getId_mid_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量中等的区域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露量中等的区域编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mid_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mid_area",  getSd_mid_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量中等的区域编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量中等的区域名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mid_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mid_area",  getName_mid_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量中等的区域名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量最小的区域属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_min_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_min_area",  getId_min_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最小的区域");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露量最小的区域编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_min_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_min_area",  getSd_min_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最小的区域编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露量最小的区域名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_min_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_min_area",  getName_min_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露量最小的区域名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请描述引起暴露的情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExposure_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exposure_situation",  getExposure_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请描述引起暴露的情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opt_avoidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opt_avoid",  getId_opt_avoidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有其它任何的选择来预防此事件发生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opt_avoidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_opt_avoid",  getSd_opt_avoidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有其它任何的选择来预防此事件发生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_opt_avoidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_opt_avoid",  getName_opt_avoidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有其它任何的选择来预防此事件发生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防此事件发生说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExplain_opt_avoidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Explain_opt_avoid",  getExplain_opt_avoidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防此事件发生说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务人员实验室检查费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedical_staff_lab_exam_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medical_staff_lab_exam_fee",  getMedical_staff_lab_exam_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医务人员实验室检查费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人实验室检查费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_exam_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_exam_cost",  getPat_exam_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("病人实验室检查费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务人员预防性治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreve_treatment_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preve_treatment_fee",  getPreve_treatment_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("医务人员预防性治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人预防性治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_treatment_feeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_treatment_fee",  getPat_treatment_feeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("病人预防性治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getService_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Service_cost",  getService_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("服务费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_cost",  getOther_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("其它费用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用总额属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_cost",  getTotal_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("费用总额");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 该事故是否已经向主管部门报告属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_report",  getId_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("该事故是否已经向主管部门报告");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 该事故是否已经向主管部门报告编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_report",  getSd_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("该事故是否已经向主管部门报告编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 该事故是否已经向主管部门报告名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_report",  getName_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("该事故是否已经向主管部门报告名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离岗天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_off_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_off_num",  getDays_off_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("离岗天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限制工作天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRestrict_worke_dayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Restrict_worke_day",  getRestrict_worke_dayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("限制工作天数");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_code",  getGrp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b2","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
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
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b3","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_code",  getPat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_pat=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b23","id_pat=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_name",  getSex_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_name",  getDept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b25","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b25","id_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_type_code",  getWork_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_work_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_type_name",  getWork_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_work_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExposure_loc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exposure_loc_code",  getExposure_loc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_exposure_loc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExposure_loc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exposure_loc_name",  getExposure_loc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_exposure_loc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKnow_pat_info_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Know_pat_info_code",  getKnow_pat_info_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_know_pat_info=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKnow_pat_info_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Know_pat_info_name",  getKnow_pat_info_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_know_pat_info=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBodyfluid_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bodyfluid_code",  getBodyfluid_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bodyfluid=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBodyfluid_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bodyfluid_name",  getBodyfluid_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bodyfluid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExposed_area_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exposed_area_code",  getExposed_area_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_exposed_area=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExposed_area_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exposed_area_name",  getExposed_area_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_exposed_area=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_bodyfluid_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_bodyfluid_code",  getBlood_bodyfluid_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_blood_bodyfluid=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_bodyfluid_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_bodyfluid_name",  getBlood_bodyfluid_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_blood_bodyfluid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProtect_appliance_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Protect_appliance_code",  getProtect_appliance_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_protect_appliance=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProtect_appliance_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Protect_appliance_name",  getProtect_appliance_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_protect_appliance=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_cont_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_cont_code",  getBlood_cont_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_blood_cont=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_cont_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_cont_name",  getBlood_cont_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_blood_cont=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExpos_reason_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Expos_reason_code",  getExpos_reason_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_expos_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExpos_reason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Expos_reason_name",  getExpos_reason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_expos_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_cont_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_cont_code",  getTime_cont_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_time_cont=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_cont_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_cont_name",  getTime_cont_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_time_cont=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuant_cont_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quant_cont_code",  getQuant_cont_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_quant_cont=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuant_cont_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quant_cont_name",  getQuant_cont_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_quant_cont=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMax_area_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Max_area_code",  getMax_area_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_max_area=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMax_area_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Max_area_name",  getMax_area_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_max_area=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMid_area_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mid_area_code",  getMid_area_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mid_area=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMid_area_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mid_area_name",  getMid_area_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_mid_area=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMin_area_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Min_area_name",  getMin_area_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_min_area=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMin_area_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Min_area_code",  getMin_area_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_min_area=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpt_avoid_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opt_avoid_code",  getOpt_avoid_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_opt_avoid=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpt_avoid_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opt_avoid_name",  getOpt_avoid_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_opt_avoid=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_code",  getReport_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_report=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_name",  getReport_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_report=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取暴露接触登记表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_liqexpconCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_liqexpcon");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("暴露接触登记表主键"); 
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
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名编码"); 
		return column;
	}
	/**
	 * 获取姓名名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名名称"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别名称"); 
		return column;
	}
	/**
	 * 获取科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室"); 
		return column;
	}
	/**
	 * 获取科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室编码"); 
		return column;
	}
	/**
	 * 获取科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室名称"); 
		return column;
	}
	/**
	 * 获取工龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorkageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Workage");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("工龄"); 
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
	 * 获取调查表时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvesttimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调查表时间"); 
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
	 * 获取发生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInjury_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Injury_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发生时间"); 
		return column;
	}
	/**
	 * 获取工作类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_work_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_work_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作类别"); 
		return column;
	}
	/**
	 * 获取工作类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_work_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_work_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作类别编码"); 
		return column;
	}
	/**
	 * 获取工作类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_work_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_work_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作类别名称"); 
		return column;
	}
	/**
	 * 获取暴露发生的地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exposure_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exposure_loc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生的地点"); 
		return column;
	}
	/**
	 * 获取暴露发生的地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_exposure_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_exposure_loc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生的地点编码"); 
		return column;
	}
	/**
	 * 获取暴露发生的地点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_exposure_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_exposure_loc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生的地点名称"); 
		return column;
	}
	/**
	 * 获取是否知道病人源情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_know_pat_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_know_pat_info");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否知道病人源情况"); 
		return column;
	}
	/**
	 * 获取是否知道病人源情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_know_pat_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_know_pat_info");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否知道病人源情况编码"); 
		return column;
	}
	/**
	 * 获取是否知道病人源情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_know_pat_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_know_pat_info");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否知道病人源情况名称"); 
		return column;
	}
	/**
	 * 获取涉及体液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bodyfluid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("涉及体液"); 
		return column;
	}
	/**
	 * 获取涉及体液编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bodyfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("涉及体液编码"); 
		return column;
	}
	/**
	 * 获取涉及体液编码名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bodyfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("涉及体液编码名称"); 
		return column;
	}
	/**
	 * 获取其它体液说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_bodyfluid_instructionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_bodyfluid_instruction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它体液说明"); 
		return column;
	}
	/**
	 * 获取暴露部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exposed_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exposed_area");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露部位"); 
		return column;
	}
	/**
	 * 获取暴露部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_exposed_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_exposed_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露部位编码"); 
		return column;
	}
	/**
	 * 获取暴露部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_exposed_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_exposed_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露部位名称"); 
		return column;
	}
	/**
	 * 获取其它暴露部位说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_exposed_area_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_exposed_area_instr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它暴露部位说明"); 
		return column;
	}
	/**
	 * 获取血液/体液表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_bodyfluid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液/体液"); 
		return column;
	}
	/**
	 * 获取血液/体液编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_bodyfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液/体液编码"); 
		return column;
	}
	/**
	 * 获取血液/体液名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_bodyfluidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_bodyfluid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液/体液名称"); 
		return column;
	}
	/**
	 * 获取保护用具表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_protect_applianceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_protect_appliance");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保护用具"); 
		return column;
	}
	/**
	 * 获取保护用具编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_protect_applianceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_protect_appliance");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保护用具编码"); 
		return column;
	}
	/**
	 * 获取保护用具名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_protect_applianceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_protect_appliance");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保护用具名称"); 
		return column;
	}
	/**
	 * 获取其它工作服的说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_work_clothes_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_work_clothes_instr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它工作服的说明"); 
		return column;
	}
	/**
	 * 获取其它保护工具的说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_protect_tool_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_protect_tool_instr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它保护工具的说明"); 
		return column;
	}
	/**
	 * 获取体液是否受血液污染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_cont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体液是否受血液污染"); 
		return column;
	}
	/**
	 * 获取体液是否受血液污染编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体液是否受血液污染编码"); 
		return column;
	}
	/**
	 * 获取体液是否受血液污染名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体液是否受血液污染名称"); 
		return column;
	}
	/**
	 * 获取造成暴露接触的原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_expos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_expos_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("造成暴露接触的原因"); 
		return column;
	}
	/**
	 * 获取造成暴露接触的原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_expos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_expos_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("造成暴露接触的原因编码"); 
		return column;
	}
	/**
	 * 获取造成暴露接触的原因名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_expos_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_expos_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("造成暴露接触的原因名称"); 
		return column;
	}
	/**
	 * 获取如果是设备故障请详细说明设备类型和生产厂商表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEquip_type_manuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Equip_type_manu");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如果是设备故障请详细说明设备类型和生产厂商"); 
		return column;
	}
	/**
	 * 获取血液或体液接触皮肤或粘膜多长时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_time_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_time_cont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液或体液接触皮肤或粘膜多长时间"); 
		return column;
	}
	/**
	 * 获取血液或体液接触皮肤或粘膜多长时间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_time_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_time_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液或体液接触皮肤或粘膜多长时间编码"); 
		return column;
	}
	/**
	 * 获取血液或体液接触皮肤或粘膜多长时间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_time_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_time_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血液或体液接触皮肤或粘膜多长时间名称"); 
		return column;
	}
	/**
	 * 获取大约有多少血液或体液接触皮肤和粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_quant_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_quant_cont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大约有多少血液或体液接触皮肤和粘膜"); 
		return column;
	}
	/**
	 * 获取大约有多少血液或体液接触皮肤和粘膜编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_quant_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_quant_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大约有多少血液或体液接触皮肤和粘膜编码"); 
		return column;
	}
	/**
	 * 获取大约有多少血液或体液接触皮肤和粘膜名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_quant_contCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_quant_cont");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大约有多少血液或体液接触皮肤和粘膜名称"); 
		return column;
	}
	/**
	 * 获取暴露量最大的区域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_max_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_max_area");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最大的区域"); 
		return column;
	}
	/**
	 * 获取暴露量最大的区域编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_max_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_max_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最大的区域编码"); 
		return column;
	}
	/**
	 * 获取暴露量最大的区域名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_max_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_max_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最大的区域名称"); 
		return column;
	}
	/**
	 * 获取暴露量中等的区域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mid_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mid_area");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量中等的区域"); 
		return column;
	}
	/**
	 * 获取暴露量中等的区域编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mid_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mid_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量中等的区域编码"); 
		return column;
	}
	/**
	 * 获取暴露量中等的区域名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mid_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mid_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量中等的区域名称"); 
		return column;
	}
	/**
	 * 获取暴露量最小的区域表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_min_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_min_area");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最小的区域"); 
		return column;
	}
	/**
	 * 获取暴露量最小的区域编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_min_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_min_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最小的区域编码"); 
		return column;
	}
	/**
	 * 获取暴露量最小的区域名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_min_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_min_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露量最小的区域名称"); 
		return column;
	}
	/**
	 * 获取请描述引起暴露的情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExposure_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exposure_situation");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请描述引起暴露的情况"); 
		return column;
	}
	/**
	 * 获取是否有其它任何的选择来预防此事件发生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opt_avoidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opt_avoid");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有其它任何的选择来预防此事件发生"); 
		return column;
	}
	/**
	 * 获取是否有其它任何的选择来预防此事件发生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opt_avoidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_opt_avoid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有其它任何的选择来预防此事件发生编码"); 
		return column;
	}
	/**
	 * 获取是否有其它任何的选择来预防此事件发生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_opt_avoidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_opt_avoid");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有其它任何的选择来预防此事件发生名称"); 
		return column;
	}
	/**
	 * 获取预防此事件发生说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExplain_opt_avoidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Explain_opt_avoid");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防此事件发生说明"); 
		return column;
	}
	/**
	 * 获取医务人员实验室检查费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedical_staff_lab_exam_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medical_staff_lab_exam_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医务人员实验室检查费用"); 
		return column;
	}
	/**
	 * 获取病人实验室检查费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_exam_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_exam_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("病人实验室检查费用"); 
		return column;
	}
	/**
	 * 获取医务人员预防性治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreve_treatment_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preve_treatment_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("医务人员预防性治疗费"); 
		return column;
	}
	/**
	 * 获取病人预防性治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_treatment_feeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_treatment_fee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("病人预防性治疗费"); 
		return column;
	}
	/**
	 * 获取服务费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getService_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Service_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("服务费用"); 
		return column;
	}
	/**
	 * 获取其它费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其它费用"); 
		return column;
	}
	/**
	 * 获取费用总额表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("费用总额"); 
		return column;
	}
	/**
	 * 获取该事故是否已经向主管部门报告表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_report");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("该事故是否已经向主管部门报告"); 
		return column;
	}
	/**
	 * 获取该事故是否已经向主管部门报告编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_report");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("该事故是否已经向主管部门报告编码"); 
		return column;
	}
	/**
	 * 获取该事故是否已经向主管部门报告名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_report");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("该事故是否已经向主管部门报告名称"); 
		return column;
	}
	/**
	 * 获取离岗天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_off_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_off_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("离岗天数"); 
		return column;
	}
	/**
	 * 获取限制工作天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRestrict_worke_dayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Restrict_worke_day");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("限制工作天数"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
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
	private IColumnDesc getGrp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_code");
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
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
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
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
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
	private IColumnDesc getSex_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_name");
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
	private IColumnDesc getDept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_name");
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
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWork_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_type_code");
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
	private IColumnDesc getWork_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_type_name");
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
	private IColumnDesc getExposure_loc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exposure_loc_code");
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
	private IColumnDesc getExposure_loc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exposure_loc_name");
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
	private IColumnDesc getKnow_pat_info_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Know_pat_info_code");
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
	private IColumnDesc getKnow_pat_info_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Know_pat_info_name");
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
	private IColumnDesc getBodyfluid_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bodyfluid_code");
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
	private IColumnDesc getBodyfluid_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bodyfluid_name");
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
	private IColumnDesc getExposed_area_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exposed_area_code");
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
	private IColumnDesc getExposed_area_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exposed_area_name");
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
	private IColumnDesc getBlood_bodyfluid_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_bodyfluid_code");
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
	private IColumnDesc getBlood_bodyfluid_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_bodyfluid_name");
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
	private IColumnDesc getProtect_appliance_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Protect_appliance_code");
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
	private IColumnDesc getProtect_appliance_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Protect_appliance_name");
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
	private IColumnDesc getBlood_cont_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_cont_code");
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
	private IColumnDesc getBlood_cont_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_cont_name");
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
	private IColumnDesc getExpos_reason_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Expos_reason_code");
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
	private IColumnDesc getExpos_reason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Expos_reason_name");
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
	private IColumnDesc getTime_cont_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_cont_code");
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
	private IColumnDesc getTime_cont_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_cont_name");
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
	private IColumnDesc getQuant_cont_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quant_cont_code");
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
	private IColumnDesc getQuant_cont_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quant_cont_name");
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
	private IColumnDesc getMax_area_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Max_area_code");
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
	private IColumnDesc getMax_area_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Max_area_name");
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
	private IColumnDesc getMid_area_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mid_area_code");
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
	private IColumnDesc getMid_area_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mid_area_name");
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
	private IColumnDesc getMin_area_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Min_area_name");
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
	private IColumnDesc getMin_area_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Min_area_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpt_avoid_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opt_avoid_code");
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
	private IColumnDesc getOpt_avoid_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opt_avoid_name");
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
	private IColumnDesc getReport_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_code");
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
	private IColumnDesc getReport_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_name");
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
		iBDDataInfoFldMap.put("id","Id_liqexpcon");
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
