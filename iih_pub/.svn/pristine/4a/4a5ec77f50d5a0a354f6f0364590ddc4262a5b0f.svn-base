
package iih.ci.rcm.trackafterexposure.d.desc;

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
 * 暴露后追踪记录登记表 DO 元数据信息
 */
public class TrackAfterExposureDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.trackafterexposure.d.TrackAfterExposureDO";
	public static final String CLASS_DISPALYNAME = "暴露后追踪记录登记表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rcm_trackafexp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_trackafexposure";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TrackAfterExposureDODesc(){
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
		this.setKeyDesc(getId_trackafexposureADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_trackafexposureADesc(tblDesc));
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
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getInvestigatetimeADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getWorkageADesc(tblDesc));
		this.add(getOccurrence_timeADesc(tblDesc));
		this.add(getId_know_pat_infoADesc(tblDesc));
		this.add(getSd_know_pat_infoADesc(tblDesc));
		this.add(getName_know_pat_infoADesc(tblDesc));
		this.add(getPat_instructionADesc(tblDesc));
		this.add(getId_highrisk_situationADesc(tblDesc));
		this.add(getSd_highrisk_situationADesc(tblDesc));
		this.add(getName_highrisk_situationADesc(tblDesc));
		this.add(getHigrisk_other_instrADesc(tblDesc));
		this.add(getId_medicationADesc(tblDesc));
		this.add(getSd_medicationADesc(tblDesc));
		this.add(getName_medicationADesc(tblDesc));
		this.add(getHiv_om_instrADesc(tblDesc));
		this.add(getPat_other_instructionADesc(tblDesc));
		this.add(getId_doct_testdeptADesc(tblDesc));
		this.add(getSd_doct_testdeptADesc(tblDesc));
		this.add(getName_doct_testdeptADesc(tblDesc));
		this.add(getOther_dept_inspectionADesc(tblDesc));
		this.add(getId_doct_hepbADesc(tblDesc));
		this.add(getSd_doct_hepbADesc(tblDesc));
		this.add(getName_doct_hepbADesc(tblDesc));
		this.add(getAntilevel_af_vaccinationADesc(tblDesc));
		this.add(getInspection_dateADesc(tblDesc));
		this.add(getId_doct_pregnancyADesc(tblDesc));
		this.add(getSd_doct_pregnancyADesc(tblDesc));
		this.add(getName_doct_pregnancyADesc(tblDesc));
		this.add(getId_doct_phase_preADesc(tblDesc));
		this.add(getSd_doct_phase_preADesc(tblDesc));
		this.add(getName_doct_phase_preADesc(tblDesc));
		this.add(getOther_instructionADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getKnow_pat_info_codeADesc(tblDesc));
		this.add(getKnow_pat_info_nameADesc(tblDesc));
		this.add(getHighrisk_situation_codeADesc(tblDesc));
		this.add(getHighrisk_situation_nameADesc(tblDesc));
		this.add(getMedication_codeADesc(tblDesc));
		this.add(getMedication_nameADesc(tblDesc));
		this.add(getDoct_testdept_codeADesc(tblDesc));
		this.add(getDoct_testdept_nameADesc(tblDesc));
		this.add(getDoct_hepb_codeADesc(tblDesc));
		this.add(getDoct_hepb_nameADesc(tblDesc));
		this.add(getDoct_pregnancy_codeADesc(tblDesc));
		this.add(getDoct_pregnancy_nameADesc(tblDesc));
		this.add(getDoct_phase_pre_codeADesc(tblDesc));
		this.add(getDoct_phase_pre_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_trackafexposureCDesc(tblDesc));
		tblDesc.add(getId_trackafexposureCDesc(tblDesc));
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
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getInvestigatetimeCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getWorkageCDesc(tblDesc));
		tblDesc.add(getOccurrence_timeCDesc(tblDesc));
		tblDesc.add(getId_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getSd_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getName_know_pat_infoCDesc(tblDesc));
		tblDesc.add(getPat_instructionCDesc(tblDesc));
		tblDesc.add(getId_highrisk_situationCDesc(tblDesc));
		tblDesc.add(getSd_highrisk_situationCDesc(tblDesc));
		tblDesc.add(getName_highrisk_situationCDesc(tblDesc));
		tblDesc.add(getHigrisk_other_instrCDesc(tblDesc));
		tblDesc.add(getId_medicationCDesc(tblDesc));
		tblDesc.add(getSd_medicationCDesc(tblDesc));
		tblDesc.add(getName_medicationCDesc(tblDesc));
		tblDesc.add(getHiv_om_instrCDesc(tblDesc));
		tblDesc.add(getPat_other_instructionCDesc(tblDesc));
		tblDesc.add(getId_doct_testdeptCDesc(tblDesc));
		tblDesc.add(getSd_doct_testdeptCDesc(tblDesc));
		tblDesc.add(getName_doct_testdeptCDesc(tblDesc));
		tblDesc.add(getOther_dept_inspectionCDesc(tblDesc));
		tblDesc.add(getId_doct_hepbCDesc(tblDesc));
		tblDesc.add(getSd_doct_hepbCDesc(tblDesc));
		tblDesc.add(getName_doct_hepbCDesc(tblDesc));
		tblDesc.add(getAntilevel_af_vaccinationCDesc(tblDesc));
		tblDesc.add(getInspection_dateCDesc(tblDesc));
		tblDesc.add(getId_doct_pregnancyCDesc(tblDesc));
		tblDesc.add(getSd_doct_pregnancyCDesc(tblDesc));
		tblDesc.add(getName_doct_pregnancyCDesc(tblDesc));
		tblDesc.add(getId_doct_phase_preCDesc(tblDesc));
		tblDesc.add(getSd_doct_phase_preCDesc(tblDesc));
		tblDesc.add(getName_doct_phase_preCDesc(tblDesc));
		tblDesc.add(getOther_instructionCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 暴露后追踪记录登记表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_trackafexposureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_trackafexposure",  getId_trackafexposureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露后追踪记录登记表主键");
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
	 * 调查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigatetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigatetime",  getInvestigatetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("调查时间");
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
	 * 发生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccurrence_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occurrence_time",  getOccurrence_timeCDesc(tblDesc), this);
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
	 * 病人源说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_instructionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_instruction",  getPat_instructionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人源说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危人群涉及情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_highrisk_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_highrisk_situation",  getId_highrisk_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危人群涉及情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 高危人群涉及情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_highrisk_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_highrisk_situation",  getSd_highrisk_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危人群涉及情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危人群涉及情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_highrisk_situationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_highrisk_situation",  getName_highrisk_situationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危人群涉及情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 高危其他说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHigrisk_other_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Higrisk_other_instr",  getHigrisk_other_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高危其他说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV药物治疗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medication",  getId_medicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV药物治疗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * HIV药物治疗编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medication",  getSd_medicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV药物治疗编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV药物治疗名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medication",  getName_medicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV药物治疗名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * HIV药物治疗其他说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHiv_om_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hiv_om_instr",  getHiv_om_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIV药物治疗其他说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人其他有关说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_other_instructionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_other_instruction",  getPat_other_instructionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人其他有关说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务工作者经过哪个部门检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doct_testdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doct_testdept",  getId_doct_testdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务工作者经过哪个部门检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医务工作者经过哪个部门检查编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_doct_testdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_doct_testdept",  getSd_doct_testdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务工作者经过哪个部门检查编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务工作者经过哪个部门检查名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doct_testdeptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doct_testdept",  getName_doct_testdeptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务工作者经过哪个部门检查名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他检查部门说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_dept_inspectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_dept_inspection",  getOther_dept_inspectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他检查部门说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doct_hepbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doct_hepb",  getId_doct_hepbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_doct_hepbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_doct_hepb",  getSd_doct_hepbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doct_hepbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doct_hepb",  getName_doct_hepbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接种后抗体水平属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAntilevel_af_vaccinationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Antilevel_af_vaccination",  getAntilevel_af_vaccinationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接种后抗体水平");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检验日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInspection_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inspection_date",  getInspection_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("检验日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务人员是否在妊娠期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doct_pregnancyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doct_pregnancy",  getId_doct_pregnancyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务人员是否在妊娠期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医务人员是否在妊娠期编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_doct_pregnancyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_doct_pregnancy",  getSd_doct_pregnancyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医务人员是否在妊娠期编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务人员是否在妊娠期名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doct_pregnancyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doct_pregnancy",  getName_doct_pregnancyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务人员是否在妊娠期名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在妊娠的哪三个月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doct_phase_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doct_phase_pre",  getId_doct_phase_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("在妊娠的哪三个月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 在妊娠的哪三个月编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_doct_phase_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_doct_phase_pre",  getSd_doct_phase_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("在妊娠的哪三个月编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在妊娠的哪三个月名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doct_phase_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doct_phase_pre",  getName_doct_phase_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("在妊娠的哪三个月名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_instructionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_instruction",  getOther_instructionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他说明");
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_pat=id_psndoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_pat=id_psndoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_sex=id_udidoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_sex=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b16","id_dept=id_dep","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b16","id_dept=id_dep","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_know_pat_info=id_udidoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_know_pat_info=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHighrisk_situation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Highrisk_situation_code",  getHighrisk_situation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_highrisk_situation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHighrisk_situation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Highrisk_situation_name",  getHighrisk_situation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_highrisk_situation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedication_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medication_code",  getMedication_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_medication=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedication_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medication_name",  getMedication_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_medication=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_testdept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_testdept_code",  getDoct_testdept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_doct_testdept=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_testdept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_testdept_name",  getDoct_testdept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_doct_testdept=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_hepb_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_hepb_code",  getDoct_hepb_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_doct_hepb=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_hepb_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_hepb_name",  getDoct_hepb_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_doct_hepb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_pregnancy_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_pregnancy_code",  getDoct_pregnancy_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_doct_pregnancy=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_pregnancy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_pregnancy_name",  getDoct_pregnancy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_doct_pregnancy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_phase_pre_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_phase_pre_code",  getDoct_phase_pre_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_doct_phase_pre=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoct_phase_pre_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doct_phase_pre_name",  getDoct_phase_pre_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_doct_phase_pre=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取暴露后追踪记录登记表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_trackafexposureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_trackafexposure");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("暴露后追踪记录登记表主键"); 
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
	 * 获取调查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigatetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigatetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("调查时间"); 
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
	 * 获取发生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccurrence_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occurrence_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发生时间"); 
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
	 * 获取病人源说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_instructionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_instruction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人源说明"); 
		return column;
	}
	/**
	 * 获取高危人群涉及情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_highrisk_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_highrisk_situation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危人群涉及情况"); 
		return column;
	}
	/**
	 * 获取高危人群涉及情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_highrisk_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_highrisk_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危人群涉及情况编码"); 
		return column;
	}
	/**
	 * 获取高危人群涉及情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_highrisk_situationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_highrisk_situation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危人群涉及情况名称"); 
		return column;
	}
	/**
	 * 获取高危其他说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHigrisk_other_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Higrisk_other_instr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("高危其他说明"); 
		return column;
	}
	/**
	 * 获取HIV药物治疗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medication");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV药物治疗"); 
		return column;
	}
	/**
	 * 获取HIV药物治疗编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV药物治疗编码"); 
		return column;
	}
	/**
	 * 获取HIV药物治疗名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV药物治疗名称"); 
		return column;
	}
	/**
	 * 获取HIV药物治疗其他说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHiv_om_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hiv_om_instr");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIV药物治疗其他说明"); 
		return column;
	}
	/**
	 * 获取病人其他有关说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_other_instructionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_other_instruction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人其他有关说明"); 
		return column;
	}
	/**
	 * 获取医务工作者经过哪个部门检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doct_testdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doct_testdept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务工作者经过哪个部门检查"); 
		return column;
	}
	/**
	 * 获取医务工作者经过哪个部门检查编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_doct_testdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_doct_testdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务工作者经过哪个部门检查编码"); 
		return column;
	}
	/**
	 * 获取医务工作者经过哪个部门检查名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doct_testdeptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doct_testdept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务工作者经过哪个部门检查名称"); 
		return column;
	}
	/**
	 * 获取其他检查部门说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_dept_inspectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_dept_inspection");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他检查部门说明"); 
		return column;
	}
	/**
	 * 获取暴露发生前医护工作者是否接种过乙肝疫苗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doct_hepbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doct_hepb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗"); 
		return column;
	}
	/**
	 * 获取暴露发生前医护工作者是否接种过乙肝疫苗编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_doct_hepbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_doct_hepb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗编码"); 
		return column;
	}
	/**
	 * 获取暴露发生前医护工作者是否接种过乙肝疫苗名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doct_hepbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doct_hepb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("暴露发生前医护工作者是否接种过乙肝疫苗名称"); 
		return column;
	}
	/**
	 * 获取接种后抗体水平表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAntilevel_af_vaccinationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Antilevel_af_vaccination");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接种后抗体水平"); 
		return column;
	}
	/**
	 * 获取检验日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInspection_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inspection_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("检验日期"); 
		return column;
	}
	/**
	 * 获取医务人员是否在妊娠期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doct_pregnancyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doct_pregnancy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务人员是否在妊娠期"); 
		return column;
	}
	/**
	 * 获取医务人员是否在妊娠期编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_doct_pregnancyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_doct_pregnancy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医务人员是否在妊娠期编码"); 
		return column;
	}
	/**
	 * 获取医务人员是否在妊娠期名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doct_pregnancyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doct_pregnancy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务人员是否在妊娠期名称"); 
		return column;
	}
	/**
	 * 获取在妊娠的哪三个月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doct_phase_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doct_phase_pre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("在妊娠的哪三个月"); 
		return column;
	}
	/**
	 * 获取在妊娠的哪三个月编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_doct_phase_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_doct_phase_pre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("在妊娠的哪三个月编码"); 
		return column;
	}
	/**
	 * 获取在妊娠的哪三个月名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doct_phase_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doct_phase_pre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("在妊娠的哪三个月名称"); 
		return column;
	}
	/**
	 * 获取其他说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_instructionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_instruction");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他说明"); 
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
	private IColumnDesc getHighrisk_situation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Highrisk_situation_code");
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
	private IColumnDesc getHighrisk_situation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Highrisk_situation_name");
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
	private IColumnDesc getMedication_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medication_code");
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
	private IColumnDesc getMedication_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medication_name");
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
	private IColumnDesc getDoct_testdept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_testdept_code");
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
	private IColumnDesc getDoct_testdept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_testdept_name");
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
	private IColumnDesc getDoct_hepb_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_hepb_code");
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
	private IColumnDesc getDoct_hepb_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_hepb_name");
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
	private IColumnDesc getDoct_pregnancy_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_pregnancy_code");
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
	private IColumnDesc getDoct_pregnancy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_pregnancy_name");
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
	private IColumnDesc getDoct_phase_pre_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_phase_pre_code");
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
	private IColumnDesc getDoct_phase_pre_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doct_phase_pre_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
