
package iih.pe.pwf.perstris.d.desc;

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
 * 体检检查报告 DO 元数据信息
 */
public class PeRstRisDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.perstris.d.PeRstRisDO";
	public static final String CLASS_DISPALYNAME = "体检检查报告";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_wf_perstris";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_perstris";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeRstRisDODesc(){
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
		this.setKeyDesc(getId_perstrisADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_perstrisADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getPatient_idADesc(tblDesc));
		this.add(getIn_patient_noADesc(tblDesc));
		this.add(getVisit_timesADesc(tblDesc));
		this.add(getPatient_nameADesc(tblDesc));
		this.add(getGenderADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getBed_noADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getPacs_patient_idADesc(tblDesc));
		this.add(getAccession_numberADesc(tblDesc));
		this.add(getCheck_noADesc(tblDesc));
		this.add(getTypeADesc(tblDesc));
		this.add(getPositionADesc(tblDesc));
		this.add(getIs_bed_sideADesc(tblDesc));
		this.add(getIs_emergyADesc(tblDesc));
		this.add(getPurposeADesc(tblDesc));
		this.add(getSymptomADesc(tblDesc));
		this.add(getVital_signsADesc(tblDesc));
		this.add(getDiagnosisADesc(tblDesc));
		this.add(getAssociate_test_resultADesc(tblDesc));
		this.add(getContentADesc(tblDesc));
		this.add(getSummaryADesc(tblDesc));
		this.add(getApply_dept_codeADesc(tblDesc));
		this.add(getApply_dept_nameADesc(tblDesc));
		this.add(getApply_doctor_codeADesc(tblDesc));
		this.add(getApply_doctor_nameADesc(tblDesc));
		this.add(getApply_dateADesc(tblDesc));
		this.add(getReport_doctor_codeADesc(tblDesc));
		this.add(getReport_doctor_nameADesc(tblDesc));
		this.add(getReport_dateADesc(tblDesc));
		this.add(getVerify_docotr_codeADesc(tblDesc));
		this.add(getVerify_doctor_nameADesc(tblDesc));
		this.add(getVerify_dateADesc(tblDesc));
		this.add(getStateADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getId_orobsADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getNo_rptobsADesc(tblDesc));
		this.add(getImage_urlADesc(tblDesc));
		this.add(getCode_checkitemADesc(tblDesc));
		this.add(getName_checkitemADesc(tblDesc));
		this.add(getFg_receivedADesc(tblDesc));
		this.add(getDt_receivedADesc(tblDesc));
		this.add(getCode_methodADesc(tblDesc));
		this.add(getName_methodADesc(tblDesc));
		this.add(getGraphic_reportADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_perstrisCDesc(tblDesc));
		tblDesc.add(getId_perstrisCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getPatient_idCDesc(tblDesc));
		tblDesc.add(getIn_patient_noCDesc(tblDesc));
		tblDesc.add(getVisit_timesCDesc(tblDesc));
		tblDesc.add(getPatient_nameCDesc(tblDesc));
		tblDesc.add(getGenderCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getBed_noCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getPacs_patient_idCDesc(tblDesc));
		tblDesc.add(getAccession_numberCDesc(tblDesc));
		tblDesc.add(getCheck_noCDesc(tblDesc));
		tblDesc.add(getTypeCDesc(tblDesc));
		tblDesc.add(getPositionCDesc(tblDesc));
		tblDesc.add(getIs_bed_sideCDesc(tblDesc));
		tblDesc.add(getIs_emergyCDesc(tblDesc));
		tblDesc.add(getPurposeCDesc(tblDesc));
		tblDesc.add(getSymptomCDesc(tblDesc));
		tblDesc.add(getVital_signsCDesc(tblDesc));
		tblDesc.add(getDiagnosisCDesc(tblDesc));
		tblDesc.add(getAssociate_test_resultCDesc(tblDesc));
		tblDesc.add(getContentCDesc(tblDesc));
		tblDesc.add(getSummaryCDesc(tblDesc));
		tblDesc.add(getApply_dept_codeCDesc(tblDesc));
		tblDesc.add(getApply_dept_nameCDesc(tblDesc));
		tblDesc.add(getApply_doctor_codeCDesc(tblDesc));
		tblDesc.add(getApply_doctor_nameCDesc(tblDesc));
		tblDesc.add(getApply_dateCDesc(tblDesc));
		tblDesc.add(getReport_doctor_codeCDesc(tblDesc));
		tblDesc.add(getReport_doctor_nameCDesc(tblDesc));
		tblDesc.add(getReport_dateCDesc(tblDesc));
		tblDesc.add(getVerify_docotr_codeCDesc(tblDesc));
		tblDesc.add(getVerify_doctor_nameCDesc(tblDesc));
		tblDesc.add(getVerify_dateCDesc(tblDesc));
		tblDesc.add(getStateCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getId_orobsCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getNo_rptobsCDesc(tblDesc));
		tblDesc.add(getImage_urlCDesc(tblDesc));
		tblDesc.add(getCode_checkitemCDesc(tblDesc));
		tblDesc.add(getName_checkitemCDesc(tblDesc));
		tblDesc.add(getFg_receivedCDesc(tblDesc));
		tblDesc.add(getDt_receivedCDesc(tblDesc));
		tblDesc.add(getCode_methodCDesc(tblDesc));
		tblDesc.add(getName_methodCDesc(tblDesc));
		tblDesc.add(getGraphic_reportCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检RIS结果主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perstrisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perstris",  getId_perstrisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检RIS结果主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检预约单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单");
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
	private IAttrDesc getPatient_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patient_id",  getPatient_idCDesc(tblDesc), this);
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
	 * 患者住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_patient_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_patient_no",  getIn_patient_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者住院号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者住院次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVisit_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Visit_times",  getVisit_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者住院次数");
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
	private IAttrDesc getPatient_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patient_name",  getPatient_nameCDesc(tblDesc), this);
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
	private IAttrDesc getGenderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gender",  getGenderCDesc(tblDesc), this);
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
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBed_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bed_no",  getBed_noCDesc(tblDesc), this);
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
	 * 医嘱号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PACS系统中患者标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPacs_patient_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pacs_patient_id",  getPacs_patient_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PACS系统中患者标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * PACS系统产生的报告号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAccession_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Accession_number",  getAccession_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("PACS系统产生的报告号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_no",  getCheck_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Type",  getTypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Position",  getPositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否床旁检查标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_bed_sideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_bed_side",  getIs_bed_sideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否床旁检查标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否紧急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_emergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_emergy",  getIs_emergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否紧急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPurposeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Purpose",  getPurposeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSymptomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Symptom",  getSymptomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者生命体征属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVital_signsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vital_signs",  getVital_signsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者生命体征");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者临床诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagnosis",  getDiagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者临床诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 相关检查结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAssociate_test_resultADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Associate_test_result",  getAssociate_test_resultCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("相关检查结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content",  getContentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSummaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Summary",  getSummaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApply_dept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apply_dept_code",  getApply_dept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApply_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apply_dept_name",  getApply_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApply_doctor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apply_doctor_code",  getApply_doctor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApply_doctor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apply_doctor_name",  getApply_doctor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApply_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apply_date",  getApply_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_doctor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_doctor_code",  getReport_doctor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_doctor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_doctor_name",  getReport_doctor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报告医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_date",  getReport_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerify_docotr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verify_docotr_code",  getVerify_docotr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerify_doctor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verify_doctor_name",  getVerify_doctor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVerify_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Verify_date",  getVerify_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("State",  getStateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查申请单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orobsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_orobs",  getId_orobsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查申请单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查申请报告单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_rptobsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_rptobs",  getNo_rptobsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查申请报告单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 图片地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImage_urlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Image_url",  getImage_urlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("图片地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_checkitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_checkitem",  getCode_checkitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_checkitemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_checkitem",  getName_checkitemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消息接收标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_receivedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_received",  getFg_receivedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("消息接收标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消息接收时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_receivedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_received",  getDt_receivedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("消息接收时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_method",  getCode_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查方法名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_methodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_method",  getName_methodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查方法名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 图文报告属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGraphic_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Graphic_report",  getGraphic_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("图文报告");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取体检RIS结果主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perstrisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perstris");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检RIS结果主键标识"); 
		return column;
	}
	/**
	 * 获取体检预约单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatient_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patient_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取患者住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_patient_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_patient_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者住院号"); 
		return column;
	}
	/**
	 * 获取患者住院次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVisit_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Visit_times");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者住院次数"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatient_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patient_name");
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
	private IColumnDesc getGenderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gender");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
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
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBed_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bed_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取医嘱号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱号"); 
		return column;
	}
	/**
	 * 获取PACS系统中患者标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPacs_patient_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pacs_patient_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PACS系统中患者标识"); 
		return column;
	}
	/**
	 * 获取PACS系统产生的报告号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAccession_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Accession_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("PACS系统产生的报告号"); 
		return column;
	}
	/**
	 * 获取申请序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请序号"); 
		return column;
	}
	/**
	 * 获取检查类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查类别"); 
		return column;
	}
	/**
	 * 获取检查部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Position");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查部位"); 
		return column;
	}
	/**
	 * 获取是否床旁检查标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_bed_sideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_bed_side");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否床旁检查标识"); 
		return column;
	}
	/**
	 * 获取是否紧急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_emergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_emergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否紧急标识"); 
		return column;
	}
	/**
	 * 获取检查目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPurposeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Purpose");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查目的"); 
		return column;
	}
	/**
	 * 获取患者症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSymptomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Symptom");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者症状"); 
		return column;
	}
	/**
	 * 获取患者生命体征表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVital_signsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vital_signs");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者生命体征"); 
		return column;
	}
	/**
	 * 获取患者临床诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者临床诊断"); 
		return column;
	}
	/**
	 * 获取相关检查结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAssociate_test_resultCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Associate_test_result");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("相关检查结果"); 
		return column;
	}
	/**
	 * 获取报告内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告内容"); 
		return column;
	}
	/**
	 * 获取医生说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSummaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Summary");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生说明"); 
		return column;
	}
	/**
	 * 获取申请科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApply_dept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apply_dept_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室编码"); 
		return column;
	}
	/**
	 * 获取申请科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApply_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apply_dept_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室名称"); 
		return column;
	}
	/**
	 * 获取申请医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApply_doctor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apply_doctor_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生编码"); 
		return column;
	}
	/**
	 * 获取申请医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApply_doctor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apply_doctor_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生姓名"); 
		return column;
	}
	/**
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApply_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apply_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取报告医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_doctor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_doctor_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告医生编码"); 
		return column;
	}
	/**
	 * 获取报告医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_doctor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_doctor_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报告医生姓名"); 
		return column;
	}
	/**
	 * 获取报告时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告时间"); 
		return column;
	}
	/**
	 * 获取审核医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerify_docotr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verify_docotr_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核医生编码"); 
		return column;
	}
	/**
	 * 获取审核医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerify_doctor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verify_doctor_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核医生姓名"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVerify_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Verify_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"State");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 获取申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单号"); 
		return column;
	}
	/**
	 * 获取检查申请单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orobsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_orobs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查申请单主键"); 
		return column;
	}
	/**
	 * 获取患者就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊"); 
		return column;
	}
	/**
	 * 获取检查申请报告单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_rptobsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_rptobs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查申请报告单号"); 
		return column;
	}
	/**
	 * 获取图片地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImage_urlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Image_url");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("图片地址"); 
		return column;
	}
	/**
	 * 获取检查项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_checkitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_checkitem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查项目编码"); 
		return column;
	}
	/**
	 * 获取检查项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_checkitemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_checkitem");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查项目名称"); 
		return column;
	}
	/**
	 * 获取消息接收标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_receivedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_received");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("消息接收标识"); 
		return column;
	}
	/**
	 * 获取消息接收时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_receivedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_received");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("消息接收时间"); 
		return column;
	}
	/**
	 * 获取检查方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查方法编码"); 
		return column;
	}
	/**
	 * 获取检查方法名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_methodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_method");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查方法名称"); 
		return column;
	}
	/**
	 * 获取图文报告表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGraphic_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Graphic_report");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("图文报告"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_perstris");
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
