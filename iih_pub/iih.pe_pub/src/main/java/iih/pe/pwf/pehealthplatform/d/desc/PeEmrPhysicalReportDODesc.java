
package iih.pe.pwf.pehealthplatform.d.desc;

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
 * 体检平台健康体检表 DO 元数据信息
 */
public class PeEmrPhysicalReportDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pehealthplatform.d.PeEmrPhysicalReportDO";
	public static final String CLASS_DISPALYNAME = "体检平台健康体检表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "emr_physical_report";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id";
	
	/**
	 * 无参构造函数
	 */
	public PeEmrPhysicalReportDODesc(){
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
		this.setKeyDesc(getIdADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getIdADesc(tblDesc));
		this.add(getPatient_idADesc(tblDesc));
		this.add(getHealth_exam_noADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_numADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getBorn_dateADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getWorking_orgADesc(tblDesc));
		this.add(getBorn_placeADesc(tblDesc));
		this.add(getProvinceADesc(tblDesc));
		this.add(getCityADesc(tblDesc));
		this.add(getCountyADesc(tblDesc));
		this.add(getTownADesc(tblDesc));
		this.add(getVillageADesc(tblDesc));
		this.add(getHouse_numADesc(tblDesc));
		this.add(getPhoneADesc(tblDesc));
		this.add(getMarital_status_codeADesc(tblDesc));
		this.add(getMarital_status_nameADesc(tblDesc));
		this.add(getOccupation_codeADesc(tblDesc));
		this.add(getOccupation_nameADesc(tblDesc));
		this.add(getSmokeADesc(tblDesc));
		this.add(getSmoke_yearADesc(tblDesc));
		this.add(getDrinkADesc(tblDesc));
		this.add(getDrink_yearADesc(tblDesc));
		this.add(getHabbitADesc(tblDesc));
		this.add(getNation_codeADesc(tblDesc));
		this.add(getNation_nameADesc(tblDesc));
		this.add(getBlood_typeADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getDia_codeADesc(tblDesc));
		this.add(getDia_nameADesc(tblDesc));
		this.add(getStart_dtimeADesc(tblDesc));
		this.add(getEnd_dtimeADesc(tblDesc));
		this.add(getExam_summaryADesc(tblDesc));
		this.add(getExam_typeADesc(tblDesc));
		this.add(getExam_nameADesc(tblDesc));
		this.add(getExam_result_codeADesc(tblDesc));
		this.add(getExam_result_nameADesc(tblDesc));
		this.add(getZj_doc_id_numADesc(tblDesc));
		this.add(getZj_doc_nameADesc(tblDesc));
		this.add(getDiag_explanADesc(tblDesc));
		this.add(getFood_guidanceADesc(tblDesc));
		this.add(getSummarize_timeADesc(tblDesc));
		this.add(getNotesADesc(tblDesc));
		this.add(getCheck_doctor_idcardADesc(tblDesc));
		this.add(getCheck_doctorADesc(tblDesc));
		this.add(getCheck_timeADesc(tblDesc));
		this.add(getPrint_timeADesc(tblDesc));
		this.add(getTotal_amountADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getDistrict_codeADesc(tblDesc));
		this.add(getExchange_typeADesc(tblDesc));
		this.add(getSystem_timeADesc(tblDesc));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getIdCDesc(tblDesc));
		tblDesc.add(getIdCDesc(tblDesc));
		tblDesc.add(getPatient_idCDesc(tblDesc));
		tblDesc.add(getHealth_exam_noCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_numCDesc(tblDesc));
		tblDesc.add(getSex_codeCDesc(tblDesc));
		tblDesc.add(getBorn_dateCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getWorking_orgCDesc(tblDesc));
		tblDesc.add(getBorn_placeCDesc(tblDesc));
		tblDesc.add(getProvinceCDesc(tblDesc));
		tblDesc.add(getCityCDesc(tblDesc));
		tblDesc.add(getCountyCDesc(tblDesc));
		tblDesc.add(getTownCDesc(tblDesc));
		tblDesc.add(getVillageCDesc(tblDesc));
		tblDesc.add(getHouse_numCDesc(tblDesc));
		tblDesc.add(getPhoneCDesc(tblDesc));
		tblDesc.add(getMarital_status_codeCDesc(tblDesc));
		tblDesc.add(getMarital_status_nameCDesc(tblDesc));
		tblDesc.add(getOccupation_codeCDesc(tblDesc));
		tblDesc.add(getOccupation_nameCDesc(tblDesc));
		tblDesc.add(getSmokeCDesc(tblDesc));
		tblDesc.add(getSmoke_yearCDesc(tblDesc));
		tblDesc.add(getDrinkCDesc(tblDesc));
		tblDesc.add(getDrink_yearCDesc(tblDesc));
		tblDesc.add(getHabbitCDesc(tblDesc));
		tblDesc.add(getNation_codeCDesc(tblDesc));
		tblDesc.add(getNation_nameCDesc(tblDesc));
		tblDesc.add(getBlood_typeCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getDia_codeCDesc(tblDesc));
		tblDesc.add(getDia_nameCDesc(tblDesc));
		tblDesc.add(getStart_dtimeCDesc(tblDesc));
		tblDesc.add(getEnd_dtimeCDesc(tblDesc));
		tblDesc.add(getExam_summaryCDesc(tblDesc));
		tblDesc.add(getExam_typeCDesc(tblDesc));
		tblDesc.add(getExam_nameCDesc(tblDesc));
		tblDesc.add(getExam_result_codeCDesc(tblDesc));
		tblDesc.add(getExam_result_nameCDesc(tblDesc));
		tblDesc.add(getZj_doc_id_numCDesc(tblDesc));
		tblDesc.add(getZj_doc_nameCDesc(tblDesc));
		tblDesc.add(getDiag_explanCDesc(tblDesc));
		tblDesc.add(getFood_guidanceCDesc(tblDesc));
		tblDesc.add(getSummarize_timeCDesc(tblDesc));
		tblDesc.add(getNotesCDesc(tblDesc));
		tblDesc.add(getCheck_doctor_idcardCDesc(tblDesc));
		tblDesc.add(getCheck_doctorCDesc(tblDesc));
		tblDesc.add(getCheck_timeCDesc(tblDesc));
		tblDesc.add(getPrint_timeCDesc(tblDesc));
		tblDesc.add(getTotal_amountCDesc(tblDesc));
		tblDesc.add(getOrg_codeCDesc(tblDesc));
		tblDesc.add(getOrg_nameCDesc(tblDesc));
		tblDesc.add(getDistrict_codeCDesc(tblDesc));
		tblDesc.add(getExchange_typeCDesc(tblDesc));
		tblDesc.add(getSystem_timeCDesc(tblDesc));
	
		return tblDesc;
	}
	
	/**
	 * 主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id",  getIdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatient_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patient_id",  getPatient_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康体检表编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_exam_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_exam_no",  getHealth_exam_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康体检表编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病人身份证号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_num",  getId_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病人身份证号码");
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
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
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
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBorn_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Born_date",  getBorn_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生日期");
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
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWorking_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Working_org",  getWorking_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工作单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生地属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBorn_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Born_place",  getBorn_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生地");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地-省属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProvinceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Province",  getProvinceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地-省");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地 市属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("City",  getCityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地 市");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地-县属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("County",  getCountyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地-县");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地--乡镇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Town",  getTownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地--乡镇");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地--村属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVillageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Village",  getVillageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地--村");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 居住地址-门牌号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHouse_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("House_num",  getHouse_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("居住地址-门牌号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Phone",  getPhoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状态代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarital_status_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marital_status_code",  getMarital_status_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状态代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarital_status_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marital_status_name",  getMarital_status_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccupation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occupation_code",  getOccupation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam59属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccupation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occupation_name",  getOccupation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam59");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否抽烟属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmokeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smoke",  getSmokeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否抽烟");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 抽烟年数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmoke_yearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smoke_year",  getSmoke_yearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抽烟年数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否喝酒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drink",  getDrinkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否喝酒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 喝酒年数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrink_yearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drink_year",  getDrink_yearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("喝酒年数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人习惯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHabbitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Habbit",  getHabbitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人习惯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_code",  getNation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam60属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nation_name",  getNation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam60");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_type",  getBlood_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height",  getHeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("身高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_code",  getDia_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDia_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_name",  getDia_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStart_dtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Start_dtime",  getStart_dtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnd_dtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("End_dtime",  getEnd_dtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检结论属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_summaryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_summary",  getExam_summaryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检结论");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_type",  getExam_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_name",  getExam_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_result_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_result_code",  getExam_result_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 检查结果名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExam_result_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exam_result_name",  getExam_result_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("检查结果名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检医生身份证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZj_doc_id_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zj_doc_id_num",  getZj_doc_id_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生身份证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getZj_doc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Zj_doc_name",  getZj_doc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病解析属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiag_explanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diag_explan",  getDiag_explanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病解析");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食建议属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFood_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Food_guidance",  getFood_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食建议");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 总检时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSummarize_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Summarize_time",  getSummarize_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("总检时间");
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
	private IAttrDesc getNotesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Notes",  getNotesCDesc(tblDesc), this);
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
	 * 审核医生身份证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_doctor_idcardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_doctor_idcard",  getCheck_doctor_idcardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核医生身份证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCheck_doctorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_doctor",  getCheck_doctorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核医生");
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
	private IAttrDesc getCheck_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Check_time",  getCheck_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrint_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Print_time",  getPrint_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("打印时间");
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
	private IAttrDesc getTotal_amountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_amount",  getTotal_amountCDesc(tblDesc), this);
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
	 * 组织机构编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织机构编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织机构名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织机构名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDistrict_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("District_code",  getDistrict_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交换类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExchange_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Exchange_type",  getExchange_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交换类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间戳属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSystem_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("System_time",  getSystem_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间戳");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键ID"); 
		return column;
	}
	/**
	 * 获取病人ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatient_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patient_id");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人ID"); 
		return column;
	}
	/**
	 * 获取健康体检表编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHealth_exam_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_exam_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康体检表编号"); 
		return column;
	}
	/**
	 * 获取病人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人姓名"); 
		return column;
	}
	/**
	 * 获取病人身份证号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病人身份证号码"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBorn_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Born_date");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取工作单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWorking_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Working_org");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工作单位"); 
		return column;
	}
	/**
	 * 获取出生地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBorn_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Born_place");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生地"); 
		return column;
	}
	/**
	 * 获取居住地-省表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProvinceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Province");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地-省"); 
		return column;
	}
	/**
	 * 获取居住地 市表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"City");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地 市"); 
		return column;
	}
	/**
	 * 获取居住地-县表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCountyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"County");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地-县"); 
		return column;
	}
	/**
	 * 获取居住地--乡镇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Town");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地--乡镇"); 
		return column;
	}
	/**
	 * 获取居住地--村表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVillageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Village");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地--村"); 
		return column;
	}
	/**
	 * 获取居住地址-门牌号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHouse_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"House_num");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("居住地址-门牌号码"); 
		return column;
	}
	/**
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Phone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取婚姻状态代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarital_status_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marital_status_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状态代码"); 
		return column;
	}
	/**
	 * 获取婚姻状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarital_status_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marital_status_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状态"); 
		return column;
	}
	/**
	 * 获取职业代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccupation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occupation_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业代码"); 
		return column;
	}
	/**
	 * 获取displaynam59表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccupation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occupation_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam59"); 
		return column;
	}
	/**
	 * 获取是否抽烟表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmokeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smoke");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否抽烟"); 
		return column;
	}
	/**
	 * 获取抽烟年数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmoke_yearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smoke_year");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("抽烟年数"); 
		return column;
	}
	/**
	 * 获取是否喝酒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drink");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否喝酒"); 
		return column;
	}
	/**
	 * 获取喝酒年数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrink_yearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drink_year");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("喝酒年数"); 
		return column;
	}
	/**
	 * 获取个人习惯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHabbitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Habbit");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人习惯"); 
		return column;
	}
	/**
	 * 获取民族代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族代码"); 
		return column;
	}
	/**
	 * 获取displaynam60表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nation_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam60"); 
		return column;
	}
	/**
	 * 获取血型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlood_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血型"); 
		return column;
	}
	/**
	 * 获取身高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("身高"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取体检诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断编码"); 
		return column;
	}
	/**
	 * 获取体检诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDia_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊断名称"); 
		return column;
	}
	/**
	 * 获取体检开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStart_dtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Start_dtime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检开始时间"); 
		return column;
	}
	/**
	 * 获取体检结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnd_dtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"End_dtime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结束日期"); 
		return column;
	}
	/**
	 * 获取总检结论表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_summaryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_summary");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检结论"); 
		return column;
	}
	/**
	 * 获取检查类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_type");
		column.setLength(8);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查类型"); 
		return column;
	}
	/**
	 * 获取检查类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_name");
		column.setLength(32);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查类型名称"); 
		return column;
	}
	/**
	 * 获取检查结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_result_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_result_code");
		column.setLength(1);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查结果编码"); 
		return column;
	}
	/**
	 * 获取检查结果名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExam_result_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exam_result_name");
		column.setLength(32);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("检查结果名称"); 
		return column;
	}
	/**
	 * 获取总检医生身份证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZj_doc_id_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zj_doc_id_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生身份证号"); 
		return column;
	}
	/**
	 * 获取总检医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getZj_doc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Zj_doc_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检医生"); 
		return column;
	}
	/**
	 * 获取疾病解析表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiag_explanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diag_explan");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病解析"); 
		return column;
	}
	/**
	 * 获取饮食建议表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFood_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Food_guidance");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食建议"); 
		return column;
	}
	/**
	 * 获取总检时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSummarize_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Summarize_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("总检时间"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNotesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Notes");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取审核医生身份证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_doctor_idcardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_doctor_idcard");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核医生身份证号"); 
		return column;
	}
	/**
	 * 获取审核医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_doctorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_doctor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核医生"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCheck_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Check_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取打印时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrint_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Print_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("打印时间"); 
		return column;
	}
	/**
	 * 获取总费用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_amountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_amount");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总费用"); 
		return column;
	}
	/**
	 * 获取组织机构编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织机构编码"); 
		return column;
	}
	/**
	 * 获取组织机构名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织机构名称"); 
		return column;
	}
	/**
	 * 获取行政区划代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDistrict_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"District_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划代码"); 
		return column;
	}
	/**
	 * 获取交换类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExchange_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Exchange_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交换类型"); 
		return column;
	}
	/**
	 * 获取时间戳表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSystem_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"System_time");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间戳"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id");
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
	}
	
}
