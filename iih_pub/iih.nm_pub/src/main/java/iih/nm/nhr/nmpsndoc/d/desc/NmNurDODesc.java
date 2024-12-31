
package iih.nm.nhr.nmpsndoc.d.desc;

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
 * 护理人员属性 DO 元数据信息
 */
public class NmNurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nhr.nmpsndoc.d.NmNurDO";
	public static final String CLASS_DISPALYNAME = "护理人员属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NUR";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmNurDODesc(){
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
		this.setKeyDesc(getId_nurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getId_nurtpADesc(tblDesc));
		this.add(getSd_nurtpADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getCode_clothesADesc(tblDesc));
		this.add(getJob_noADesc(tblDesc));
		this.add(getSize_shoeADesc(tblDesc));
		this.add(getYears_nr_befoADesc(tblDesc));
		this.add(getId_nur_levelADesc(tblDesc));
		this.add(getSd_nur_levelADesc(tblDesc));
		this.add(getNo_creditADesc(tblDesc));
		this.add(getDt_inADesc(tblDesc));
		this.add(getDt_outADesc(tblDesc));
		this.add(getId_out_resADesc(tblDesc));
		this.add(getSd_out_resADesc(tblDesc));
		this.add(getNo_bran_partADesc(tblDesc));
		this.add(getFg_attendADesc(tblDesc));
		this.add(getFg_scheduleADesc(tblDesc));
		this.add(getFg_turnADesc(tblDesc));
		this.add(getFg_moveADesc(tblDesc));
		this.add(getFg_unitleaderADesc(tblDesc));
		this.add(getFg_internADesc(tblDesc));
		this.add(getFg_urgencyADesc(tblDesc));
		this.add(getId_stu_orgADesc(tblDesc));
		this.add(getId_intern_batchADesc(tblDesc));
		this.add(getNo_infec_cfnADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_educationADesc(tblDesc));
		this.add(getSd_educationADesc(tblDesc));
		this.add(getId_eng_levelADesc(tblDesc));
		this.add(getSd_eng_levelADesc(tblDesc));
		this.add(getEng_abilityADesc(tblDesc));
		this.add(getId_computer_levelADesc(tblDesc));
		this.add(getSd_computer_levelADesc(tblDesc));
		this.add(getLicensenumADesc(tblDesc));
		this.add(getId_tch_qc1ADesc(tblDesc));
		this.add(getSd_tch_qc1ADesc(tblDesc));
		this.add(getId_tch_qc2ADesc(tblDesc));
		this.add(getSd_tch_qc2ADesc(tblDesc));
		this.add(getId_tch_qc3ADesc(tblDesc));
		this.add(getSd_tch_qc3ADesc(tblDesc));
		this.add(getDt_tch1ADesc(tblDesc));
		this.add(getDt_tch2ADesc(tblDesc));
		this.add(getDt_tch3ADesc(tblDesc));
		this.add(getId_spec_nur1ADesc(tblDesc));
		this.add(getSd_spec_nur1ADesc(tblDesc));
		this.add(getId_spec_nur2ADesc(tblDesc));
		this.add(getSd_spec_nur2ADesc(tblDesc));
		this.add(getId_spec_nur3ADesc(tblDesc));
		this.add(getSd_spec_nur3ADesc(tblDesc));
		this.add(getId_spec_grpADesc(tblDesc));
		this.add(getSd_spec_grpADesc(tblDesc));
		this.add(getSocial_serviceADesc(tblDesc));
		this.add(getPer_pointADesc(tblDesc));
		this.add(getInwork_flagADesc(tblDesc));
		this.add(getInvalid_flagADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getTargetADesc(tblDesc));
		this.add(getPhonebrandADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getName_groupADesc(tblDesc));
		this.add(getPsnnameADesc(tblDesc));
		this.add(getPsncodeADesc(tblDesc));
		this.add(getName_nurtpADesc(tblDesc));
		this.add(getName_nur_levelADesc(tblDesc));
		this.add(getName_out_resADesc(tblDesc));
		this.add(getName_stu_orgADesc(tblDesc));
		this.add(getName_batchADesc(tblDesc));
		this.add(getName_educationADesc(tblDesc));
		this.add(getName_eng_levelADesc(tblDesc));
		this.add(getName_computer_levelADesc(tblDesc));
		this.add(getName_tch_qc1ADesc(tblDesc));
		this.add(getName_tch_qc2ADesc(tblDesc));
		this.add(getName_tch_qc3ADesc(tblDesc));
		this.add(getName_spec_nur1ADesc(tblDesc));
		this.add(getName_spec_nur2ADesc(tblDesc));
		this.add(getName_spec_nur3ADesc(tblDesc));
		this.add(getName_spec_grpADesc(tblDesc));
		this.add(getCode_idtpADesc(tblDesc));
		this.add(getName_idtpADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getName_vativeplaceADesc(tblDesc));
		this.add(getCharacter_nameADesc(tblDesc));
		this.add(getNat_nameADesc(tblDesc));
		this.add(getPolity_nameADesc(tblDesc));
		this.add(getHealth_nameADesc(tblDesc));
		this.add(getMar_nameADesc(tblDesc));
		this.add(getBloodtp_nameADesc(tblDesc));
		this.add(getCountynameADesc(tblDesc));
		this.add(getName_dep_adminADesc(tblDesc));
		this.add(getDep_nameADesc(tblDesc));
		this.add(getName_empdutyADesc(tblDesc));
		this.add(getCode_empdutyADesc(tblDesc));
		this.add(getWktp_nameADesc(tblDesc));
		this.add(getWktp_codeADesc(tblDesc));
		this.add(getEmptitlenameADesc(tblDesc));
		this.add(getName_humantypeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getId_nurtpCDesc(tblDesc));
		tblDesc.add(getSd_nurtpCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getCode_clothesCDesc(tblDesc));
		tblDesc.add(getJob_noCDesc(tblDesc));
		tblDesc.add(getSize_shoeCDesc(tblDesc));
		tblDesc.add(getYears_nr_befoCDesc(tblDesc));
		tblDesc.add(getId_nur_levelCDesc(tblDesc));
		tblDesc.add(getSd_nur_levelCDesc(tblDesc));
		tblDesc.add(getNo_creditCDesc(tblDesc));
		tblDesc.add(getDt_inCDesc(tblDesc));
		tblDesc.add(getDt_outCDesc(tblDesc));
		tblDesc.add(getId_out_resCDesc(tblDesc));
		tblDesc.add(getSd_out_resCDesc(tblDesc));
		tblDesc.add(getNo_bran_partCDesc(tblDesc));
		tblDesc.add(getFg_attendCDesc(tblDesc));
		tblDesc.add(getFg_scheduleCDesc(tblDesc));
		tblDesc.add(getFg_turnCDesc(tblDesc));
		tblDesc.add(getFg_moveCDesc(tblDesc));
		tblDesc.add(getFg_unitleaderCDesc(tblDesc));
		tblDesc.add(getFg_internCDesc(tblDesc));
		tblDesc.add(getFg_urgencyCDesc(tblDesc));
		tblDesc.add(getId_stu_orgCDesc(tblDesc));
		tblDesc.add(getId_intern_batchCDesc(tblDesc));
		tblDesc.add(getNo_infec_cfnCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_educationCDesc(tblDesc));
		tblDesc.add(getSd_educationCDesc(tblDesc));
		tblDesc.add(getId_eng_levelCDesc(tblDesc));
		tblDesc.add(getSd_eng_levelCDesc(tblDesc));
		tblDesc.add(getEng_abilityCDesc(tblDesc));
		tblDesc.add(getId_computer_levelCDesc(tblDesc));
		tblDesc.add(getSd_computer_levelCDesc(tblDesc));
		tblDesc.add(getLicensenumCDesc(tblDesc));
		tblDesc.add(getId_tch_qc1CDesc(tblDesc));
		tblDesc.add(getSd_tch_qc1CDesc(tblDesc));
		tblDesc.add(getId_tch_qc2CDesc(tblDesc));
		tblDesc.add(getSd_tch_qc2CDesc(tblDesc));
		tblDesc.add(getId_tch_qc3CDesc(tblDesc));
		tblDesc.add(getSd_tch_qc3CDesc(tblDesc));
		tblDesc.add(getDt_tch1CDesc(tblDesc));
		tblDesc.add(getDt_tch2CDesc(tblDesc));
		tblDesc.add(getDt_tch3CDesc(tblDesc));
		tblDesc.add(getId_spec_nur1CDesc(tblDesc));
		tblDesc.add(getSd_spec_nur1CDesc(tblDesc));
		tblDesc.add(getId_spec_nur2CDesc(tblDesc));
		tblDesc.add(getSd_spec_nur2CDesc(tblDesc));
		tblDesc.add(getId_spec_nur3CDesc(tblDesc));
		tblDesc.add(getSd_spec_nur3CDesc(tblDesc));
		tblDesc.add(getId_spec_grpCDesc(tblDesc));
		tblDesc.add(getSd_spec_grpCDesc(tblDesc));
		tblDesc.add(getSocial_serviceCDesc(tblDesc));
		tblDesc.add(getPer_pointCDesc(tblDesc));
		tblDesc.add(getInwork_flagCDesc(tblDesc));
		tblDesc.add(getInvalid_flagCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getTargetCDesc(tblDesc));
		tblDesc.add(getPhonebrandCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 护士标识主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士标识主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理人员类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurtp",  getId_nurtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理人员类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理人员类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nurtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nurtp",  getSd_nurtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理人员类别编码");
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
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服装号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_clothesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_clothes",  getCode_clothesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服装号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_no",  getJob_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 鞋号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSize_shoeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Size_shoe",  getSize_shoeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("鞋号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 到院前护龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYears_nr_befoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Years_nr_befo",  getYears_nr_befoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("到院前护龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士层级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_level",  getId_nur_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士层级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士层级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nur_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nur_level",  getSd_nur_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士层级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 学分卡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_creditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_credit",  getNo_creditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("学分卡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 到院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_in",  getDt_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("到院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注销日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_out",  getDt_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("注销日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注销 原因id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_out_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out_res",  getId_out_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注销 原因id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 注销原因编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_out_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_out_res",  getSd_out_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注销原因编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属支部编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_bran_partADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_bran_part",  getNo_bran_partCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属支部编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_attendADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_attend",  getFg_attendCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("考勤标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_scheduleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_schedule",  getFg_scheduleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("排班标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 轮转标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_turnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_turn",  getFg_turnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("轮转标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 机动标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_moveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_move",  getFg_moveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("机动标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科护士长标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_unitleaderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_unitleader",  getFg_unitleaderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("科护士长标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实习生标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_internADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_intern",  getFg_internCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("实习生标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应急护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgency",  getFg_urgencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("应急护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院校ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stu_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stu_org",  getId_stu_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院校ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实习生批次id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intern_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intern_batch",  getId_intern_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实习生批次id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 传染病证书编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_infec_cfnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_infec_cfn",  getNo_infec_cfnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("传染病证书编号");
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
	 * 学历id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_education",  getId_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("学历id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 学历编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_education",  getSd_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("学历编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英语级别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eng_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eng_level",  getId_eng_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英语级别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 英语级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eng_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eng_level",  getSd_eng_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英语级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英语能力描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEng_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eng_ability",  getEng_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英语能力描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计算机等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_computer_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_computer_level",  getId_computer_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计算机等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 计算机等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_computer_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_computer_level",  getSd_computer_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计算机等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执业证号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLicensenumADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Licensenum",  getLicensenumCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执业证号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格id1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tch_qc1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tch_qc1",  getId_tch_qc1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格id1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 带教资格编码1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tch_qc1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tch_qc1",  getSd_tch_qc1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格编码1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格id2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tch_qc2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tch_qc2",  getId_tch_qc2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格id2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 带教资格编码2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tch_qc2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tch_qc2",  getSd_tch_qc2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格编码2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格id3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tch_qc3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tch_qc3",  getId_tch_qc3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格id3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 带教资格编码3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tch_qc3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tch_qc3",  getSd_tch_qc3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格编码3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教准入日期1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_tch1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_tch1",  getDt_tch1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("带教准入日期1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教准入日期2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_tch2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_tch2",  getDt_tch2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("带教准入日期2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教准入日期3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_tch3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_tch3",  getDt_tch3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("带教准入日期3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家级专科护士id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spec_nur1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spec_nur1",  getId_spec_nur1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家级专科护士id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 国家级专科护士编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spec_nur1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spec_nur1",  getSd_spec_nur1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家级专科护士编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 省级专科护士id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spec_nur2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spec_nur2",  getId_spec_nur2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("省级专科护士id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 省级专科护士编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spec_nur2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spec_nur2",  getSd_spec_nur2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("省级专科护士编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地市级专科护士id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spec_nur3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spec_nur3",  getId_spec_nur3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地市级专科护士id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 地市级专科护士编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spec_nur3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spec_nur3",  getSd_spec_nur3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地市级专科护士编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专科小组id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_spec_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_spec_grp",  getId_spec_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科小组id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 专科小组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_spec_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_spec_grp",  getSd_spec_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科小组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 社会任职属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSocial_serviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Social_service",  getSocial_serviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("社会任职");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人特长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPer_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Per_point",  getPer_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人特长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在职状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInwork_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inwork_flag",  getInwork_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在职状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 作废标志 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvalid_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Invalid_flag",  getInvalid_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("作废标志 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前工作部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前工作部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 推送目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTargetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Target",  getTargetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("推送目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手机品牌标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhonebrandADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Phonebrand",  getPhonebrandCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手机品牌标识");
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
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b2","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_group",  getName_groupCDesc(tblDesc), this);
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
	private IAttrDesc getPsnnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psnname",  getPsnnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_psndoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsncodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psncode",  getPsncodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_psndoc=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nurtp",  getName_nurtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_nurtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_level",  getName_nur_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_nur_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_res",  getName_out_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_out_res=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stu_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stu_org",  getName_stu_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_STU_ORG a0b24","id_stu_org=id_stu_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 批次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_batchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_batch",  getName_batchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("批次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_BATCH a0b7","id_intern_batch=id_batch","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_education",  getName_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_education=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 英语级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eng_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eng_level",  getName_eng_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("英语级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_eng_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_computer_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_computer_level",  getName_computer_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_computer_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tch_qc1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tch_qc1",  getName_tch_qc1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_tch_qc1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tch_qc2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tch_qc2",  getName_tch_qc2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_tch_qc2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 带教资格3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tch_qc3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tch_qc3",  getName_tch_qc3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("带教资格3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_tch_qc3=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国家级专科护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spec_nur1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spec_nur1",  getName_spec_nur1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国家级专科护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_spec_nur1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 省级专科护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spec_nur2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spec_nur2",  getName_spec_nur2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("省级专科护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","id_spec_nur2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地址级专科护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spec_nur3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spec_nur3",  getName_spec_nur3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址级专科护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","id_spec_nur3=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专科小组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_spec_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_spec_grp",  getName_spec_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科小组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","id_spec_grp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_idtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_idtp",  getCode_idtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","idtype=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_idtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_idtp",  getName_idtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","idtype=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_vativeplaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_vativeplace",  getName_vativeplaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b39","vativeplace=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharacter_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Character_name",  getCharacter_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","characterrpr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nat_name",  getNat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","nationatily=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPolity_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Polity_name",  getPolity_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","polity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_name",  getHealth_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","health=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMar_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mar_name",  getMar_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","marital=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBloodtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bloodtp_name",  getBloodtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","bloodtype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCountynameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Countyname",  getCountynameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_country a0b15","country=id_countryzone","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_adminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_admin",  getName_dep_adminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b21","id_dep_admin=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_name",  getDep_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b16","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empdutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_empduty",  getName_empdutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_job a0b17","id_empduty=id_job","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_empdutyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_empduty",  getCode_empdutyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_job a0b17","id_empduty=id_job","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWktp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wktp_name",  getWktp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_empwktp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWktp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wktp_code",  getWktp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_empwktp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmptitlenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emptitlename",  getEmptitlenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_emptitle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_humantypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_humantype",  getName_humantypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","humantype=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取护士标识主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士标识主键"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员id"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取护理人员类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理人员类别"); 
		return column;
	}
	/**
	 * 获取护理人员类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nurtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nurtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理人员类别编码"); 
		return column;
	}
	/**
	 * 获取身高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身高"); 
		return column;
	}
	/**
	 * 获取服装号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_clothesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_clothes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服装号"); 
		return column;
	}
	/**
	 * 获取工号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工号"); 
		return column;
	}
	/**
	 * 获取鞋号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSize_shoeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Size_shoe");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("鞋号"); 
		return column;
	}
	/**
	 * 获取到院前护龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYears_nr_befoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Years_nr_befo");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("到院前护龄"); 
		return column;
	}
	/**
	 * 获取护士层级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士层级id"); 
		return column;
	}
	/**
	 * 获取护士层级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nur_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nur_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士层级编码"); 
		return column;
	}
	/**
	 * 获取学分卡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_creditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_credit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("学分卡"); 
		return column;
	}
	/**
	 * 获取到院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_in");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("到院日期"); 
		return column;
	}
	/**
	 * 获取注销日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_out");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("注销日期"); 
		return column;
	}
	/**
	 * 获取注销 原因id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_out_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out_res");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注销 原因id"); 
		return column;
	}
	/**
	 * 获取注销原因编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_out_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_out_res");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注销原因编码"); 
		return column;
	}
	/**
	 * 获取所属支部编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_bran_partCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_bran_part");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属支部编号"); 
		return column;
	}
	/**
	 * 获取考勤标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_attendCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_attend");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("考勤标识"); 
		return column;
	}
	/**
	 * 获取排班标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_scheduleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_schedule");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排班标识"); 
		return column;
	}
	/**
	 * 获取轮转标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_turnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_turn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("轮转标识"); 
		return column;
	}
	/**
	 * 获取机动标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_moveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_move");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("机动标识"); 
		return column;
	}
	/**
	 * 获取科护士长标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_unitleaderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_unitleader");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("科护士长标识"); 
		return column;
	}
	/**
	 * 获取实习生标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_internCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_intern");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实习生标识"); 
		return column;
	}
	/**
	 * 获取应急护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgency");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("应急护士"); 
		return column;
	}
	/**
	 * 获取院校ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stu_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stu_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院校ID"); 
		return column;
	}
	/**
	 * 获取实习生批次id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intern_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intern_batch");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实习生批次id"); 
		return column;
	}
	/**
	 * 获取传染病证书编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_infec_cfnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_infec_cfn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("传染病证书编号"); 
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
	 * 获取学历id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_education");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("学历id"); 
		return column;
	}
	/**
	 * 获取学历编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_education");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("学历编码"); 
		return column;
	}
	/**
	 * 获取英语级别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eng_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eng_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英语级别id"); 
		return column;
	}
	/**
	 * 获取英语级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eng_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eng_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英语级别编码"); 
		return column;
	}
	/**
	 * 获取英语能力描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEng_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eng_ability");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英语能力描述"); 
		return column;
	}
	/**
	 * 获取计算机等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_computer_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_computer_level");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计算机等级id"); 
		return column;
	}
	/**
	 * 获取计算机等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_computer_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_computer_level");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计算机等级"); 
		return column;
	}
	/**
	 * 获取执业证号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLicensenumCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Licensenum");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执业证号"); 
		return column;
	}
	/**
	 * 获取带教资格id1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tch_qc1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tch_qc1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格id1"); 
		return column;
	}
	/**
	 * 获取带教资格编码1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tch_qc1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tch_qc1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格编码1"); 
		return column;
	}
	/**
	 * 获取带教资格id2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tch_qc2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tch_qc2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格id2"); 
		return column;
	}
	/**
	 * 获取带教资格编码2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tch_qc2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tch_qc2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格编码2"); 
		return column;
	}
	/**
	 * 获取带教资格id3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tch_qc3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tch_qc3");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格id3"); 
		return column;
	}
	/**
	 * 获取带教资格编码3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tch_qc3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tch_qc3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格编码3"); 
		return column;
	}
	/**
	 * 获取带教准入日期1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_tch1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_tch1");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("带教准入日期1"); 
		return column;
	}
	/**
	 * 获取带教准入日期2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_tch2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_tch2");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("带教准入日期2"); 
		return column;
	}
	/**
	 * 获取带教准入日期3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_tch3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_tch3");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("带教准入日期3"); 
		return column;
	}
	/**
	 * 获取国家级专科护士id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spec_nur1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spec_nur1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家级专科护士id"); 
		return column;
	}
	/**
	 * 获取国家级专科护士编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spec_nur1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spec_nur1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家级专科护士编码"); 
		return column;
	}
	/**
	 * 获取省级专科护士id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spec_nur2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spec_nur2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("省级专科护士id"); 
		return column;
	}
	/**
	 * 获取省级专科护士编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spec_nur2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spec_nur2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("省级专科护士编码"); 
		return column;
	}
	/**
	 * 获取地市级专科护士id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spec_nur3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spec_nur3");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地市级专科护士id"); 
		return column;
	}
	/**
	 * 获取地市级专科护士编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spec_nur3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spec_nur3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地市级专科护士编码"); 
		return column;
	}
	/**
	 * 获取专科小组id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_spec_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_spec_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科小组id"); 
		return column;
	}
	/**
	 * 获取专科小组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_spec_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_spec_grp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科小组编码"); 
		return column;
	}
	/**
	 * 获取社会任职表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSocial_serviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Social_service");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("社会任职"); 
		return column;
	}
	/**
	 * 获取个人特长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPer_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Per_point");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人特长"); 
		return column;
	}
	/**
	 * 获取在职状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInwork_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inwork_flag");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在职状态"); 
		return column;
	}
	/**
	 * 获取作废标志 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvalid_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Invalid_flag");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("作废标志 "); 
		return column;
	}
	/**
	 * 获取当前工作部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前工作部门"); 
		return column;
	}
	/**
	 * 获取推送目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTargetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Target");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("推送目标"); 
		return column;
	}
	/**
	 * 获取手机品牌标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhonebrandCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Phonebrand");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手机品牌标识"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_group");
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
	private IColumnDesc getPsnnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psnname");
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
	private IColumnDesc getPsncodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psncode");
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
	private IColumnDesc getName_nurtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nurtp");
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
	private IColumnDesc getName_nur_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_level");
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
	private IColumnDesc getName_out_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_res");
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
	private IColumnDesc getName_stu_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stu_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取批次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_batchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_batch");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("批次名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_education");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取英语级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eng_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eng_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("英语级别名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_computer_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_computer_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取带教资格1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tch_qc1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tch_qc1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格1"); 
		return column;
	}
	/**
	 * 获取带教资格2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tch_qc2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tch_qc2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格2"); 
		return column;
	}
	/**
	 * 获取带教资格3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tch_qc3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tch_qc3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("带教资格3"); 
		return column;
	}
	/**
	 * 获取国家级专科护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spec_nur1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spec_nur1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国家级专科护士"); 
		return column;
	}
	/**
	 * 获取省级专科护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spec_nur2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spec_nur2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("省级专科护士"); 
		return column;
	}
	/**
	 * 获取地址级专科护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spec_nur3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spec_nur3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址级专科护士"); 
		return column;
	}
	/**
	 * 获取专科小组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_spec_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_spec_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科小组"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_idtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_idtp");
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
	private IColumnDesc getName_idtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_idtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_vativeplaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_vativeplace");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharacter_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Character_name");
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
	private IColumnDesc getNat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nat_name");
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
	private IColumnDesc getPolity_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Polity_name");
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
	private IColumnDesc getHealth_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_name");
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
	private IColumnDesc getMar_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mar_name");
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
	private IColumnDesc getBloodtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bloodtp_name");
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
	private IColumnDesc getCountynameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Countyname");
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
	private IColumnDesc getName_dep_adminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_admin");
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
	private IColumnDesc getDep_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取职务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empdutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_empduty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职务名称"); 
		return column;
	}
	/**
	 * 获取职务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_empdutyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_empduty");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职务编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWktp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wktp_name");
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
	private IColumnDesc getWktp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wktp_code");
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
	private IColumnDesc getEmptitlenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emptitlename");
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
	private IColumnDesc getName_humantypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_humantype");
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
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
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
