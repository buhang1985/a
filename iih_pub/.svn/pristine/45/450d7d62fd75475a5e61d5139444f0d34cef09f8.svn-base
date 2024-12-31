
package iih.ci.rcm.msinjury.d.desc;

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
 * 医疗锐器伤登记表 DO 元数据信息
 */
public class MsInjuryDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.msinjury.d.MsInjuryDO";
	public static final String CLASS_DISPALYNAME = "医疗锐器伤登记表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_rcm_msin";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_msinjury";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MsInjuryDODesc(){
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
		this.setKeyDesc(getId_msinjuryADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_msinjuryADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
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
		this.add(getWorke_ageADesc(tblDesc));
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getInvesttimeADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getInjury_timeADesc(tblDesc));
		this.add(getIs_vaccinated_hbvADesc(tblDesc));
		this.add(getId_time_vahADesc(tblDesc));
		this.add(getSd_time_vahADesc(tblDesc));
		this.add(getName_time_vahADesc(tblDesc));
		this.add(getId_workADesc(tblDesc));
		this.add(getSd_workADesc(tblDesc));
		this.add(getName_workADesc(tblDesc));
		this.add(getId_dam_locADesc(tblDesc));
		this.add(getSd_dam_locADesc(tblDesc));
		this.add(getName_dam_locADesc(tblDesc));
		this.add(getId_sharpADesc(tblDesc));
		this.add(getSd_sharpADesc(tblDesc));
		this.add(getName_sharpADesc(tblDesc));
		this.add(getId_dam_reasonADesc(tblDesc));
		this.add(getSd_dam_reasonADesc(tblDesc));
		this.add(getName_dam_reasonADesc(tblDesc));
		this.add(getInitial_userADesc(tblDesc));
		this.add(getId_sharp_purposeADesc(tblDesc));
		this.add(getSd_sharp_purposeADesc(tblDesc));
		this.add(getName_sharp_purposeADesc(tblDesc));
		this.add(getId_misoperationADesc(tblDesc));
		this.add(getSd_misoperationADesc(tblDesc));
		this.add(getName_misoperationADesc(tblDesc));
		this.add(getId_sharp_bloodADesc(tblDesc));
		this.add(getSd_sharp_bloodADesc(tblDesc));
		this.add(getName_sharp_bloodADesc(tblDesc));
		this.add(getBlood_borne_diseasesADesc(tblDesc));
		this.add(getHbsag_positiveADesc(tblDesc));
		this.add(getPatient_relatedADesc(tblDesc));
		this.add(getId_pat_hbvADesc(tblDesc));
		this.add(getSd_pat_hbvADesc(tblDesc));
		this.add(getName_pat_hbvADesc(tblDesc));
		this.add(getId_pat_hcvADesc(tblDesc));
		this.add(getSd_pat_hcvADesc(tblDesc));
		this.add(getName_pat_hcvADesc(tblDesc));
		this.add(getId_pat_aidsADesc(tblDesc));
		this.add(getSd_pat_aidsADesc(tblDesc));
		this.add(getName_pat_aidsADesc(tblDesc));
		this.add(getId_pat_syphilisADesc(tblDesc));
		this.add(getSd_pat_syphilisADesc(tblDesc));
		this.add(getName_pat_syphilisADesc(tblDesc));
		this.add(getRpr_positiveADesc(tblDesc));
		this.add(getTp_positiveADesc(tblDesc));
		this.add(getId_oper_stepADesc(tblDesc));
		this.add(getSd_oper_stepADesc(tblDesc));
		this.add(getName_oper_stepADesc(tblDesc));
		this.add(getId_wound_treatADesc(tblDesc));
		this.add(getSd_wound_treatADesc(tblDesc));
		this.add(getName_wound_treatADesc(tblDesc));
		this.add(getId_gloveADesc(tblDesc));
		this.add(getSd_gloveADesc(tblDesc));
		this.add(getName_gloveADesc(tblDesc));
		this.add(getId_severity_injuryADesc(tblDesc));
		this.add(getSd_severity_injuryADesc(tblDesc));
		this.add(getName_severity_injuryADesc(tblDesc));
		this.add(getId_sharp_user_handednessADesc(tblDesc));
		this.add(getSd_sharp_user_handednessADesc(tblDesc));
		this.add(getName_sharp_user_handednessADesc(tblDesc));
		this.add(getStaff_lab_examfeeADesc(tblDesc));
		this.add(getPat_lab_examfeeADesc(tblDesc));
		this.add(getStaff_treatfeeADesc(tblDesc));
		this.add(getPat_treatfeeADesc(tblDesc));
		this.add(getOther_expenseADesc(tblDesc));
		this.add(getTotal_costADesc(tblDesc));
		this.add(getDays_off_numADesc(tblDesc));
		this.add(getVictim_processADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getTime_vah_codeADesc(tblDesc));
		this.add(getTime_vah_nameADesc(tblDesc));
		this.add(getWork_codeADesc(tblDesc));
		this.add(getWork_nameADesc(tblDesc));
		this.add(getDam_loc_codeADesc(tblDesc));
		this.add(getDam_loc_nameADesc(tblDesc));
		this.add(getSharp_codeADesc(tblDesc));
		this.add(getSharp_nameADesc(tblDesc));
		this.add(getDam_reason_codeADesc(tblDesc));
		this.add(getDam_reason_nameADesc(tblDesc));
		this.add(getSharp_purpose_codeADesc(tblDesc));
		this.add(getSharp_purpose_nameADesc(tblDesc));
		this.add(getMisoperation_codeADesc(tblDesc));
		this.add(getMisoperation_nameADesc(tblDesc));
		this.add(getSharp_blood_nameADesc(tblDesc));
		this.add(getSharp_blood_codeADesc(tblDesc));
		this.add(getPat_hbv_codeADesc(tblDesc));
		this.add(getPat_hbv_nameADesc(tblDesc));
		this.add(getPat_hcv_codeADesc(tblDesc));
		this.add(getPat_hcv_nameADesc(tblDesc));
		this.add(getPat_aids_nameADesc(tblDesc));
		this.add(getPat_aids_codeADesc(tblDesc));
		this.add(getPat_syphilis_codeADesc(tblDesc));
		this.add(getPat_syphilis_nameADesc(tblDesc));
		this.add(getOper_step_codeADesc(tblDesc));
		this.add(getOper_step_nameADesc(tblDesc));
		this.add(getWound_treat_codeADesc(tblDesc));
		this.add(getWound_treat_nameADesc(tblDesc));
		this.add(getGlove_codeADesc(tblDesc));
		this.add(getGlove_nameADesc(tblDesc));
		this.add(getSeverity_injury_codeADesc(tblDesc));
		this.add(getSeverity_injury_nameADesc(tblDesc));
		this.add(getSharp_user_handedness_codeADesc(tblDesc));
		this.add(getSharp_user_handedness_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_msinjuryCDesc(tblDesc));
		tblDesc.add(getId_msinjuryCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
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
		tblDesc.add(getWorke_ageCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getInvesttimeCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getInjury_timeCDesc(tblDesc));
		tblDesc.add(getIs_vaccinated_hbvCDesc(tblDesc));
		tblDesc.add(getId_time_vahCDesc(tblDesc));
		tblDesc.add(getSd_time_vahCDesc(tblDesc));
		tblDesc.add(getName_time_vahCDesc(tblDesc));
		tblDesc.add(getId_workCDesc(tblDesc));
		tblDesc.add(getSd_workCDesc(tblDesc));
		tblDesc.add(getName_workCDesc(tblDesc));
		tblDesc.add(getId_dam_locCDesc(tblDesc));
		tblDesc.add(getSd_dam_locCDesc(tblDesc));
		tblDesc.add(getName_dam_locCDesc(tblDesc));
		tblDesc.add(getId_sharpCDesc(tblDesc));
		tblDesc.add(getSd_sharpCDesc(tblDesc));
		tblDesc.add(getName_sharpCDesc(tblDesc));
		tblDesc.add(getId_dam_reasonCDesc(tblDesc));
		tblDesc.add(getSd_dam_reasonCDesc(tblDesc));
		tblDesc.add(getName_dam_reasonCDesc(tblDesc));
		tblDesc.add(getInitial_userCDesc(tblDesc));
		tblDesc.add(getId_sharp_purposeCDesc(tblDesc));
		tblDesc.add(getSd_sharp_purposeCDesc(tblDesc));
		tblDesc.add(getName_sharp_purposeCDesc(tblDesc));
		tblDesc.add(getId_misoperationCDesc(tblDesc));
		tblDesc.add(getSd_misoperationCDesc(tblDesc));
		tblDesc.add(getName_misoperationCDesc(tblDesc));
		tblDesc.add(getId_sharp_bloodCDesc(tblDesc));
		tblDesc.add(getSd_sharp_bloodCDesc(tblDesc));
		tblDesc.add(getName_sharp_bloodCDesc(tblDesc));
		tblDesc.add(getBlood_borne_diseasesCDesc(tblDesc));
		tblDesc.add(getHbsag_positiveCDesc(tblDesc));
		tblDesc.add(getPatient_relatedCDesc(tblDesc));
		tblDesc.add(getId_pat_hbvCDesc(tblDesc));
		tblDesc.add(getSd_pat_hbvCDesc(tblDesc));
		tblDesc.add(getName_pat_hbvCDesc(tblDesc));
		tblDesc.add(getId_pat_hcvCDesc(tblDesc));
		tblDesc.add(getSd_pat_hcvCDesc(tblDesc));
		tblDesc.add(getName_pat_hcvCDesc(tblDesc));
		tblDesc.add(getId_pat_aidsCDesc(tblDesc));
		tblDesc.add(getSd_pat_aidsCDesc(tblDesc));
		tblDesc.add(getName_pat_aidsCDesc(tblDesc));
		tblDesc.add(getId_pat_syphilisCDesc(tblDesc));
		tblDesc.add(getSd_pat_syphilisCDesc(tblDesc));
		tblDesc.add(getName_pat_syphilisCDesc(tblDesc));
		tblDesc.add(getRpr_positiveCDesc(tblDesc));
		tblDesc.add(getTp_positiveCDesc(tblDesc));
		tblDesc.add(getId_oper_stepCDesc(tblDesc));
		tblDesc.add(getSd_oper_stepCDesc(tblDesc));
		tblDesc.add(getName_oper_stepCDesc(tblDesc));
		tblDesc.add(getId_wound_treatCDesc(tblDesc));
		tblDesc.add(getSd_wound_treatCDesc(tblDesc));
		tblDesc.add(getName_wound_treatCDesc(tblDesc));
		tblDesc.add(getId_gloveCDesc(tblDesc));
		tblDesc.add(getSd_gloveCDesc(tblDesc));
		tblDesc.add(getName_gloveCDesc(tblDesc));
		tblDesc.add(getId_severity_injuryCDesc(tblDesc));
		tblDesc.add(getSd_severity_injuryCDesc(tblDesc));
		tblDesc.add(getName_severity_injuryCDesc(tblDesc));
		tblDesc.add(getId_sharp_user_handednessCDesc(tblDesc));
		tblDesc.add(getSd_sharp_user_handednessCDesc(tblDesc));
		tblDesc.add(getName_sharp_user_handednessCDesc(tblDesc));
		tblDesc.add(getStaff_lab_examfeeCDesc(tblDesc));
		tblDesc.add(getPat_lab_examfeeCDesc(tblDesc));
		tblDesc.add(getStaff_treatfeeCDesc(tblDesc));
		tblDesc.add(getPat_treatfeeCDesc(tblDesc));
		tblDesc.add(getOther_expenseCDesc(tblDesc));
		tblDesc.add(getTotal_costCDesc(tblDesc));
		tblDesc.add(getDays_off_numCDesc(tblDesc));
		tblDesc.add(getVictim_processCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗锐器伤登记表id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_msinjuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_msinjury",  getId_msinjuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗锐器伤登记表id");
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
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat",  getSd_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
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
	private IAttrDesc getWorke_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Worke_age",  getWorke_ageCDesc(tblDesc), this);
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
	 * 调查时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvesttimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investtime",  getInvesttimeCDesc(tblDesc), this);
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
	 * 受伤时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInjury_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Injury_time",  getInjury_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("受伤时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 被刺伤前是否接种过乙肝疫苗属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_vaccinated_hbvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_vaccinated_hbv",  getIs_vaccinated_hbvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("被刺伤前是否接种过乙肝疫苗");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注射时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_time_vahADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_time_vah",  getId_time_vahCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注射时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 注射时间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_time_vahADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_time_vah",  getSd_time_vahCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注射时间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注射时间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_time_vahADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_time_vah",  getName_time_vahCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注射时间名称");
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
	private IAttrDesc getId_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_work",  getId_workCDesc(tblDesc), this);
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
	private IAttrDesc getSd_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_work",  getSd_workCDesc(tblDesc), this);
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
	private IAttrDesc getName_workADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_work",  getName_workCDesc(tblDesc), this);
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
	 * 伤害发生的地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dam_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dam_loc",  getId_dam_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤害发生的地点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dam_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dam_loc",  getSd_dam_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的地点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害发生的地点名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dam_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dam_loc",  getName_dam_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的地点名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导致伤害发生的锐器物种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sharpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sharp",  getId_sharpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导致伤害发生的锐器物种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导致伤害发生的锐器物种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sharpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sharp",  getSd_sharpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导致伤害发生的锐器物种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导致伤害发生的锐器物种类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sharpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sharp",  getName_sharpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导致伤害发生的锐器物种类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害发生的原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dam_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dam_reason",  getId_dam_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤害发生的原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dam_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dam_reason",  getSd_dam_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害发生的原因名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dam_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dam_reason",  getName_dam_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的原因名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤者是锐器的最初使用者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInitial_userADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Initial_user",  getInitial_userCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受伤者是锐器的最初使用者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 锐器最初是用于什么目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sharp_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sharp_purpose",  getId_sharp_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器最初是用于什么目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 锐器最初是用于什么目的编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sharp_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sharp_purpose",  getSd_sharp_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器最初是用于什么目的编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 锐器最初是用于什么目的名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sharp_purposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sharp_purpose",  getName_sharp_purposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器最初是用于什么目的名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害的发生有无不正确操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_misoperationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_misoperation",  getId_misoperationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害的发生有无不正确操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤害的发生有无不正确操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_misoperationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_misoperation",  getSd_misoperationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害的发生有无不正确操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害的发生有无不正确操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_misoperationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_misoperation",  getName_misoperationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害的发生有无不正确操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否被血污染的锐器物刺伤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sharp_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sharp_blood",  getId_sharp_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否被血污染的锐器物刺伤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否被血污染的锐器物刺伤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sharp_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sharp_blood",  getSd_sharp_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否被血污染的锐器物刺伤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否被血污染的锐器物刺伤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sharp_bloodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sharp_blood",  getName_sharp_bloodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否被血污染的锐器物刺伤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤前是否知道病人有无经血液传播的疾病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_borne_diseasesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_borne_diseases",  getBlood_borne_diseasesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受伤前是否知道病人有无经血液传播的疾病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 乙肝表面抗原阳性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHbsag_positiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hbsag_positive",  getHbsag_positiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("乙肝表面抗原阳性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤是否与病人有关属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatient_relatedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patient_related",  getPatient_relatedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受伤是否与病人有关");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无乙肝属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_hbvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_hbv",  getId_pat_hbvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无乙肝");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有关病人有无乙肝编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_hbvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_hbv",  getSd_pat_hbvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无乙肝编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无乙肝名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_hbvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_hbv",  getName_pat_hbvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无乙肝名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无丙肝属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_hcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_hcv",  getId_pat_hcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无丙肝");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有关病人有无丙肝编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_hcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_hcv",  getSd_pat_hcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无丙肝编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无丙肝名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_hcvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_hcv",  getName_pat_hcvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无丙肝名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无艾滋病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_aidsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_aids",  getId_pat_aidsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无艾滋病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有关病人有无艾滋病编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_aidsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_aids",  getSd_pat_aidsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无艾滋病编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无艾滋病名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_aidsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_aids",  getName_pat_aidsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无艾滋病名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无梅毒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_syphilisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_syphilis",  getId_pat_syphilisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无梅毒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有关病人有无梅毒编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pat_syphilisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat_syphilis",  getSd_pat_syphilisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无梅毒编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有关病人有无梅毒名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_syphilisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_syphilis",  getName_pat_syphilisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("有关病人有无梅毒名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * RPR阳性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRpr_positiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rpr_positive",  getRpr_positiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("RPR阳性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * TP阳性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTp_positiveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tp_positive",  getTp_positiveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("TP阳性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害发生的操作环节属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oper_stepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oper_step",  getId_oper_stepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的操作环节");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤害发生的操作环节编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oper_stepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oper_step",  getSd_oper_stepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的操作环节编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤害发生的操作环节名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oper_stepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oper_step",  getName_oper_stepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤害发生的操作环节名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤后伤口如何处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wound_treatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wound_treat",  getId_wound_treatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤后伤口如何处理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受伤后伤口如何处理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_wound_treatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_wound_treat",  getSd_wound_treatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤后伤口如何处理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤后伤口如何处理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_wound_treatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wound_treat",  getName_wound_treatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤后伤口如何处理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如果受伤部位是手锐器穿透了属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gloveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_glove",  getId_gloveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如果受伤部位是手锐器穿透了");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 如果受伤部位是手锐器穿透了编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_gloveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_glove",  getSd_gloveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如果受伤部位是手锐器穿透了编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 如果受伤部位是手锐器穿透了名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_gloveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_glove",  getName_gloveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("如果受伤部位是手锐器穿透了名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_severity_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_severity_injury",  getId_severity_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受伤程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_severity_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_severity_injury",  getSd_severity_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受伤程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_severity_injuryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_severity_injury",  getName_severity_injuryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受伤程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 锐器使用者是属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sharp_user_handednessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sharp_user_handedness",  getId_sharp_user_handednessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器使用者是");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 锐器使用者是编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sharp_user_handednessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sharp_user_handedness",  getSd_sharp_user_handednessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器使用者是编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 锐器使用者是名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sharp_user_handednessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sharp_user_handedness",  getName_sharp_user_handednessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("锐器使用者是名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 员工实验室检查费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStaff_lab_examfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Staff_lab_examfee",  getStaff_lab_examfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("员工实验室检查费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人实验室检查费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_lab_examfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_lab_examfee",  getPat_lab_examfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("病人实验室检查费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 员工治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStaff_treatfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Staff_treatfee",  getStaff_treatfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("员工治疗费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人治疗费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_treatfeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_treatfee",  getPat_treatfeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("病人治疗费");
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
	private IAttrDesc getOther_expenseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_expense",  getOther_expenseCDesc(tblDesc), this);
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
	 * 总费用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_costADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_cost",  getTotal_costCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总费用");
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
	 * 受害发生的过程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVictim_processADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Victim_process",  getVictim_processCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受害发生的过程");
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b24","id_pat=id_psndoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b24","id_pat=id_psndoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_sex=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_sex=id_udidoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b26","id_dept=id_dep","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b26","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_vah_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_vah_code",  getTime_vah_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_time_vah=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTime_vah_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Time_vah_name",  getTime_vah_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_time_vah=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_code",  getWork_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_work=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWork_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Work_name",  getWork_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_work=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDam_loc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dam_loc_code",  getDam_loc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_dam_loc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDam_loc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dam_loc_name",  getDam_loc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_dam_loc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_code",  getSharp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_sharp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_name",  getSharp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_sharp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDam_reason_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dam_reason_code",  getDam_reason_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_dam_reason=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDam_reason_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dam_reason_name",  getDam_reason_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_dam_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_purpose_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_purpose_code",  getSharp_purpose_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_sharp_purpose=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_purpose_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_purpose_name",  getSharp_purpose_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_sharp_purpose=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMisoperation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Misoperation_code",  getMisoperation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_misoperation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMisoperation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Misoperation_name",  getMisoperation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_misoperation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_blood_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_blood_name",  getSharp_blood_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_sharp_blood=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_blood_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_blood_code",  getSharp_blood_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_sharp_blood=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_hbv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_hbv_code",  getPat_hbv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_pat_hbv=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_hbv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_hbv_name",  getPat_hbv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_pat_hbv=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_hcv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_hcv_code",  getPat_hcv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pat_hcv=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_hcv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_hcv_name",  getPat_hcv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pat_hcv=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_aids_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_aids_name",  getPat_aids_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_pat_aids=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_aids_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_aids_code",  getPat_aids_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_pat_aids=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_syphilis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_syphilis_code",  getPat_syphilis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_pat_syphilis=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_syphilis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_syphilis_name",  getPat_syphilis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_pat_syphilis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_step_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_step_code",  getOper_step_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_oper_step=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOper_step_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Oper_step_name",  getOper_step_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_oper_step=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWound_treat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wound_treat_code",  getWound_treat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_wound_treat=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWound_treat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wound_treat_name",  getWound_treat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_wound_treat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGlove_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Glove_code",  getGlove_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_glove=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGlove_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Glove_name",  getGlove_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_glove=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSeverity_injury_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Severity_injury_code",  getSeverity_injury_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_severity_injury=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSeverity_injury_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Severity_injury_name",  getSeverity_injury_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_severity_injury=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_user_handedness_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_user_handedness_code",  getSharp_user_handedness_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_sharp_user_handedness=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSharp_user_handedness_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sharp_user_handedness_name",  getSharp_user_handedness_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_sharp_user_handedness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗锐器伤登记表id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_msinjuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_msinjury");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗锐器伤登记表id"); 
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
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
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
	private IColumnDesc getWorke_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Worke_age");
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
	 * 获取调查时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvesttimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investtime");
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
	 * 获取受伤时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInjury_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Injury_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受伤时间"); 
		return column;
	}
	/**
	 * 获取被刺伤前是否接种过乙肝疫苗表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_vaccinated_hbvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_vaccinated_hbv");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("被刺伤前是否接种过乙肝疫苗"); 
		return column;
	}
	/**
	 * 获取注射时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_time_vahCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_time_vah");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注射时间"); 
		return column;
	}
	/**
	 * 获取注射时间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_time_vahCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_time_vah");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注射时间编码"); 
		return column;
	}
	/**
	 * 获取注射时间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_time_vahCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_time_vah");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注射时间名称"); 
		return column;
	}
	/**
	 * 获取工作类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_work");
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
	private IColumnDesc getSd_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_work");
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
	private IColumnDesc getName_workCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_work");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作类别名称"); 
		return column;
	}
	/**
	 * 获取伤害发生的地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dam_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dam_loc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的地点"); 
		return column;
	}
	/**
	 * 获取伤害发生的地点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dam_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dam_loc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的地点编码"); 
		return column;
	}
	/**
	 * 获取伤害发生的地点名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dam_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dam_loc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的地点名称"); 
		return column;
	}
	/**
	 * 获取导致伤害发生的锐器物种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sharpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sharp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导致伤害发生的锐器物种类"); 
		return column;
	}
	/**
	 * 获取导致伤害发生的锐器物种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sharpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sharp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导致伤害发生的锐器物种类编码"); 
		return column;
	}
	/**
	 * 获取导致伤害发生的锐器物种类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sharpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sharp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导致伤害发生的锐器物种类名称"); 
		return column;
	}
	/**
	 * 获取伤害发生的原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dam_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dam_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的原因"); 
		return column;
	}
	/**
	 * 获取伤害发生的原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dam_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dam_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的原因编码"); 
		return column;
	}
	/**
	 * 获取伤害发生的原因名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dam_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dam_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的原因名称"); 
		return column;
	}
	/**
	 * 获取受伤者是锐器的最初使用者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInitial_userCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Initial_user");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受伤者是锐器的最初使用者"); 
		return column;
	}
	/**
	 * 获取锐器最初是用于什么目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sharp_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sharp_purpose");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器最初是用于什么目的"); 
		return column;
	}
	/**
	 * 获取锐器最初是用于什么目的编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sharp_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sharp_purpose");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器最初是用于什么目的编码"); 
		return column;
	}
	/**
	 * 获取锐器最初是用于什么目的名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sharp_purposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sharp_purpose");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器最初是用于什么目的名称"); 
		return column;
	}
	/**
	 * 获取伤害的发生有无不正确操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_misoperationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_misoperation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害的发生有无不正确操作"); 
		return column;
	}
	/**
	 * 获取伤害的发生有无不正确操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_misoperationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_misoperation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害的发生有无不正确操作编码"); 
		return column;
	}
	/**
	 * 获取伤害的发生有无不正确操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_misoperationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_misoperation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害的发生有无不正确操作名称"); 
		return column;
	}
	/**
	 * 获取是否被血污染的锐器物刺伤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sharp_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sharp_blood");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否被血污染的锐器物刺伤"); 
		return column;
	}
	/**
	 * 获取是否被血污染的锐器物刺伤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sharp_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sharp_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否被血污染的锐器物刺伤编码"); 
		return column;
	}
	/**
	 * 获取是否被血污染的锐器物刺伤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sharp_bloodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sharp_blood");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否被血污染的锐器物刺伤名称"); 
		return column;
	}
	/**
	 * 获取受伤前是否知道病人有无经血液传播的疾病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlood_borne_diseasesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_borne_diseases");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受伤前是否知道病人有无经血液传播的疾病"); 
		return column;
	}
	/**
	 * 获取乙肝表面抗原阳性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHbsag_positiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hbsag_positive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("乙肝表面抗原阳性"); 
		return column;
	}
	/**
	 * 获取受伤是否与病人有关表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatient_relatedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patient_related");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受伤是否与病人有关"); 
		return column;
	}
	/**
	 * 获取有关病人有无乙肝表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_hbvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_hbv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无乙肝"); 
		return column;
	}
	/**
	 * 获取有关病人有无乙肝编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_hbvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_hbv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无乙肝编码"); 
		return column;
	}
	/**
	 * 获取有关病人有无乙肝名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_hbvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_hbv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无乙肝名称"); 
		return column;
	}
	/**
	 * 获取有关病人有无丙肝表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_hcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_hcv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无丙肝"); 
		return column;
	}
	/**
	 * 获取有关病人有无丙肝编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_hcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_hcv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无丙肝编码"); 
		return column;
	}
	/**
	 * 获取有关病人有无丙肝名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_hcvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_hcv");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无丙肝名称"); 
		return column;
	}
	/**
	 * 获取有关病人有无艾滋病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_aidsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_aids");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无艾滋病"); 
		return column;
	}
	/**
	 * 获取有关病人有无艾滋病编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_aidsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_aids");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无艾滋病编码"); 
		return column;
	}
	/**
	 * 获取有关病人有无艾滋病名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_aidsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_aids");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无艾滋病名称"); 
		return column;
	}
	/**
	 * 获取有关病人有无梅毒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_syphilisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_syphilis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无梅毒"); 
		return column;
	}
	/**
	 * 获取有关病人有无梅毒编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pat_syphilisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat_syphilis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无梅毒编码"); 
		return column;
	}
	/**
	 * 获取有关病人有无梅毒名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_syphilisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_syphilis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("有关病人有无梅毒名称"); 
		return column;
	}
	/**
	 * 获取RPR阳性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRpr_positiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rpr_positive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("RPR阳性"); 
		return column;
	}
	/**
	 * 获取TP阳性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTp_positiveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tp_positive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("TP阳性"); 
		return column;
	}
	/**
	 * 获取伤害发生的操作环节表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oper_stepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oper_step");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的操作环节"); 
		return column;
	}
	/**
	 * 获取伤害发生的操作环节编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oper_stepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oper_step");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的操作环节编码"); 
		return column;
	}
	/**
	 * 获取伤害发生的操作环节名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oper_stepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oper_step");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤害发生的操作环节名称"); 
		return column;
	}
	/**
	 * 获取受伤后伤口如何处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wound_treatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wound_treat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤后伤口如何处理"); 
		return column;
	}
	/**
	 * 获取受伤后伤口如何处理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_wound_treatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_wound_treat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤后伤口如何处理编码"); 
		return column;
	}
	/**
	 * 获取受伤后伤口如何处理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_wound_treatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wound_treat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤后伤口如何处理名称"); 
		return column;
	}
	/**
	 * 获取如果受伤部位是手锐器穿透了表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gloveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_glove");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如果受伤部位是手锐器穿透了"); 
		return column;
	}
	/**
	 * 获取如果受伤部位是手锐器穿透了编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_gloveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_glove");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如果受伤部位是手锐器穿透了编码"); 
		return column;
	}
	/**
	 * 获取如果受伤部位是手锐器穿透了名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_gloveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_glove");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("如果受伤部位是手锐器穿透了名称"); 
		return column;
	}
	/**
	 * 获取受伤程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_severity_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_severity_injury");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤程度"); 
		return column;
	}
	/**
	 * 获取受伤程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_severity_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_severity_injury");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤程度编码"); 
		return column;
	}
	/**
	 * 获取受伤程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_severity_injuryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_severity_injury");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受伤程度名称"); 
		return column;
	}
	/**
	 * 获取锐器使用者是表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sharp_user_handednessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sharp_user_handedness");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器使用者是"); 
		return column;
	}
	/**
	 * 获取锐器使用者是编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sharp_user_handednessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sharp_user_handedness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器使用者是编码"); 
		return column;
	}
	/**
	 * 获取锐器使用者是名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sharp_user_handednessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sharp_user_handedness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("锐器使用者是名称"); 
		return column;
	}
	/**
	 * 获取员工实验室检查费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStaff_lab_examfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Staff_lab_examfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("员工实验室检查费"); 
		return column;
	}
	/**
	 * 获取病人实验室检查费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_lab_examfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_lab_examfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("病人实验室检查费"); 
		return column;
	}
	/**
	 * 获取员工治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStaff_treatfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Staff_treatfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("员工治疗费"); 
		return column;
	}
	/**
	 * 获取病人治疗费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_treatfeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_treatfee");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("病人治疗费"); 
		return column;
	}
	/**
	 * 获取其它费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_expenseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_expense");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("其它费用"); 
		return column;
	}
	/**
	 * 获取总费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_costCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_cost");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总费用"); 
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
	 * 获取受害发生的过程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVictim_processCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Victim_process");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受害发生的过程"); 
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
	private IColumnDesc getTime_vah_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_vah_code");
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
	private IColumnDesc getTime_vah_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Time_vah_name");
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
	private IColumnDesc getWork_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_code");
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
	private IColumnDesc getWork_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Work_name");
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
	private IColumnDesc getDam_loc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dam_loc_code");
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
	private IColumnDesc getDam_loc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dam_loc_name");
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
	private IColumnDesc getSharp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_code");
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
	private IColumnDesc getSharp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_name");
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
	private IColumnDesc getDam_reason_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dam_reason_code");
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
	private IColumnDesc getDam_reason_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dam_reason_name");
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
	private IColumnDesc getSharp_purpose_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_purpose_code");
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
	private IColumnDesc getSharp_purpose_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_purpose_name");
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
	private IColumnDesc getMisoperation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Misoperation_code");
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
	private IColumnDesc getMisoperation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Misoperation_name");
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
	private IColumnDesc getSharp_blood_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_blood_name");
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
	private IColumnDesc getSharp_blood_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_blood_code");
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
	private IColumnDesc getPat_hbv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_hbv_code");
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
	private IColumnDesc getPat_hbv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_hbv_name");
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
	private IColumnDesc getPat_hcv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_hcv_code");
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
	private IColumnDesc getPat_hcv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_hcv_name");
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
	private IColumnDesc getPat_aids_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_aids_name");
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
	private IColumnDesc getPat_aids_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_aids_code");
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
	private IColumnDesc getPat_syphilis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_syphilis_code");
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
	private IColumnDesc getPat_syphilis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_syphilis_name");
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
	private IColumnDesc getOper_step_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_step_code");
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
	private IColumnDesc getOper_step_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Oper_step_name");
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
	private IColumnDesc getWound_treat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wound_treat_code");
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
	private IColumnDesc getWound_treat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wound_treat_name");
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
	private IColumnDesc getGlove_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Glove_code");
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
	private IColumnDesc getGlove_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Glove_name");
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
	private IColumnDesc getSeverity_injury_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Severity_injury_code");
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
	private IColumnDesc getSeverity_injury_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Severity_injury_name");
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
	private IColumnDesc getSharp_user_handedness_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_user_handedness_code");
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
	private IColumnDesc getSharp_user_handedness_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sharp_user_handedness_name");
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
		iBDDataInfoFldMap.put("id","Id_msinjury");
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
