
package iih.ci.ord.specanti.d.desc;

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
 * 特殊使用级抗菌药物会诊申请 DO 元数据信息
 */
public class SpecAntiConsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.specanti.d.SpecAntiConsDO";
	public static final String CLASS_DISPALYNAME = "特殊使用级抗菌药物会诊申请";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_spec_anti_cons";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_apspecanticons";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SpecAntiConsDODesc(){
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
		this.setKeyDesc(getId_apspecanticonsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_apspecanticonsADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getId_enADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sex_patADesc(tblDesc));
		this.add(getId_didefADesc(tblDesc));
		this.add(getName_didefADesc(tblDesc));
		this.add(getId_diitmADesc(tblDesc));
		this.add(getStr_id_diitmADesc(tblDesc));
		this.add(getStr_code_diitmADesc(tblDesc));
		this.add(getStr_name_diitmADesc(tblDesc));
		this.add(getDes_sympsignADesc(tblDesc));
		this.add(getFg_microbeinspectionADesc(tblDesc));
		this.add(getMicrobeinspectionADesc(tblDesc));
		this.add(getAllerhyhistoryADesc(tblDesc));
		this.add(getDes_ppsADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_emp_titleADesc(tblDesc));
		this.add(getName_emp_titleADesc(tblDesc));
		this.add(getFg_signADesc(tblDesc));
		this.add(getId_su_specconsADesc(tblDesc));
		this.add(getEu_recordADesc(tblDesc));
		this.add(getId_consmdADesc(tblDesc));
		this.add(getSd_consmdADesc(tblDesc));
		this.add(getAdviceADesc(tblDesc));
		this.add(getId_emp_recordADesc(tblDesc));
		this.add(getDt_cons_appADesc(tblDesc));
		this.add(getDt_recordADesc(tblDesc));
		this.add(getDt_consADesc(tblDesc));
		this.add(getId_approve_empADesc(tblDesc));
		this.add(getSd_approve_empADesc(tblDesc));
		this.add(getFg_sign_recordADesc(tblDesc));
		this.add(getFg_approve_clidepADesc(tblDesc));
		this.add(getId_approve_clidepADesc(tblDesc));
		this.add(getSd_approve_clidepADesc(tblDesc));
		this.add(getFg_approve_meddepADesc(tblDesc));
		this.add(getId_approve_meddepADesc(tblDesc));
		this.add(getSd_approve_meddepADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_dep_phyADesc(tblDesc));
		this.add(getId_wg_phyADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getDt_birth_patADesc(tblDesc));
		this.add(getSd_sex_patADesc(tblDesc));
		this.add(getName_sex_patADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getSd_su_specconsADesc(tblDesc));
		this.add(getName_su_specconsADesc(tblDesc));
		this.add(getName_consmdADesc(tblDesc));
		this.add(getName_emp_recordADesc(tblDesc));
		this.add(getName_approve_empADesc(tblDesc));
		this.add(getName_approve_clidepADesc(tblDesc));
		this.add(getName_approve_meddepADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apspecanticonsCDesc(tblDesc));
		tblDesc.add(getId_apspecanticonsCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getId_enCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sex_patCDesc(tblDesc));
		tblDesc.add(getId_didefCDesc(tblDesc));
		tblDesc.add(getName_didefCDesc(tblDesc));
		tblDesc.add(getId_diitmCDesc(tblDesc));
		tblDesc.add(getStr_id_diitmCDesc(tblDesc));
		tblDesc.add(getStr_code_diitmCDesc(tblDesc));
		tblDesc.add(getStr_name_diitmCDesc(tblDesc));
		tblDesc.add(getDes_sympsignCDesc(tblDesc));
		tblDesc.add(getFg_microbeinspectionCDesc(tblDesc));
		tblDesc.add(getMicrobeinspectionCDesc(tblDesc));
		tblDesc.add(getAllerhyhistoryCDesc(tblDesc));
		tblDesc.add(getDes_ppsCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_emp_titleCDesc(tblDesc));
		tblDesc.add(getName_emp_titleCDesc(tblDesc));
		tblDesc.add(getFg_signCDesc(tblDesc));
		tblDesc.add(getId_su_specconsCDesc(tblDesc));
		tblDesc.add(getEu_recordCDesc(tblDesc));
		tblDesc.add(getId_consmdCDesc(tblDesc));
		tblDesc.add(getSd_consmdCDesc(tblDesc));
		tblDesc.add(getAdviceCDesc(tblDesc));
		tblDesc.add(getId_emp_recordCDesc(tblDesc));
		tblDesc.add(getDt_cons_appCDesc(tblDesc));
		tblDesc.add(getDt_recordCDesc(tblDesc));
		tblDesc.add(getDt_consCDesc(tblDesc));
		tblDesc.add(getId_approve_empCDesc(tblDesc));
		tblDesc.add(getSd_approve_empCDesc(tblDesc));
		tblDesc.add(getFg_sign_recordCDesc(tblDesc));
		tblDesc.add(getFg_approve_clidepCDesc(tblDesc));
		tblDesc.add(getId_approve_clidepCDesc(tblDesc));
		tblDesc.add(getSd_approve_clidepCDesc(tblDesc));
		tblDesc.add(getFg_approve_meddepCDesc(tblDesc));
		tblDesc.add(getId_approve_meddepCDesc(tblDesc));
		tblDesc.add(getSd_approve_meddepCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 抗菌药会诊申请ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apspecanticonsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apspecanticons",  getId_apspecanticonsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("抗菌药会诊申请ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_en",  getId_enCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院号");
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex_pat",  getId_sex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef",  getId_didefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断定义ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_didefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_didef",  getName_didefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断子项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diitm",  getId_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断子项");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床诊断明细id拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_id_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_id_diitm",  getStr_id_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断明细id拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断明细编码拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_code_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_code_diitm",  getStr_code_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断明细编码拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床诊断明细名称拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_name_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_name_diitm",  getStr_name_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断明细名称拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_sympsignADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_sympsign",  getDes_sympsignCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否已做微生物检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_microbeinspectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_microbeinspection",  getFg_microbeinspectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否已做微生物检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微生物检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMicrobeinspectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Microbeinspection",  getMicrobeinspectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微生物检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者过敏信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllerhyhistoryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allerhyhistory",  getAllerhyhistoryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者过敏信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_ppsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_pps",  getDes_ppsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请医生ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请医生职称ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_title",  getId_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生职称ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请医生职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_titleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_title",  getName_emp_titleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请医生职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign",  getFg_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("签署标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊申请状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_specconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_speccons",  getId_su_specconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊记录方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_record",  getEu_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("会诊记录方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊方式ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_consmd",  getId_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊方式ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_consmd",  getSd_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊专家意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Advice",  getAdviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊专家意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊意见记录人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_record",  getId_emp_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊意见记录人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cons_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cons_app",  getDt_cons_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("会诊申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊意见记录时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_record",  getDt_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("会诊意见记录时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实际会诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cons",  getDt_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("实际会诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专家会诊结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_approve_emp",  getId_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专家会诊结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 专家会诊结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_approve_emp",  getSd_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专家会诊结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊记录签署标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sign_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign_record",  getFg_sign_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("会诊记录签署标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要科室审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_approve_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_approve_clidep",  getFg_approve_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要科室审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室审批结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_approve_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_approve_clidep",  getId_approve_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室审批结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 科室审批结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_approve_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_approve_clidep",  getSd_approve_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室审批结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需要医务审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_approve_meddepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_approve_meddep",  getFg_approve_meddepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需要医务审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务审批结果ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_approve_meddepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_approve_meddep",  getId_approve_meddepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务审批结果ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医务审批结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_approve_meddepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_approve_meddep",  getSd_approve_meddepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务审批结果编码");
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
	 * 当前就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy",  getId_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b10","id_en=id_ent","id_dep_phy"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前医疗组属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wg_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wg_phy",  getId_wg_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前医疗组");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b10","id_en=id_ent","id_wg_phy"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前护理单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前护理单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b10","id_en=id_ent","id_dep_nur"});
		attrDesc.setRefType(true);
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b11","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birth_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth_pat",  getDt_birth_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b11","id_pat=id_pat","dt_birth"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_pat",  getSd_sex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_sex_pat=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex_pat",  getName_sex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_sex_pat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b13","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_specconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_speccons",  getSd_su_specconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_su_speccons=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_su_specconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_su_speccons",  getName_su_specconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_su_speccons=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_consmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_consmd",  getName_consmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_consmd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_record",  getName_emp_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_emp_record=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_approve_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_approve_emp",  getName_approve_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_approve_emp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_approve_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_approve_clidep",  getName_approve_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_approve_clidep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_approve_meddepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_approve_meddep",  getName_approve_meddepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_approve_meddep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_or_srv a0b19","id_orsrv=id_orsrv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取抗菌药会诊申请ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apspecanticonsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apspecanticons");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("抗菌药会诊申请ID"); 
		return column;
	}
	/**
	 * 获取关联医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联医嘱"); 
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
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_en");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取住院号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院号"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取患者性别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别ID"); 
		return column;
	}
	/**
	 * 获取诊断定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断定义ID"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_didefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_didef");
		column.setLength(120);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取临床诊断子项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断子项"); 
		return column;
	}
	/**
	 * 获取临床诊断明细id拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_id_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_id_diitm");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断明细id拼接"); 
		return column;
	}
	/**
	 * 获取临床诊断明细编码拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_code_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_code_diitm");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断明细编码拼接"); 
		return column;
	}
	/**
	 * 获取临床诊断明细名称拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_name_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_name_diitm");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断明细名称拼接"); 
		return column;
	}
	/**
	 * 获取病情描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_sympsignCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_sympsign");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情描述"); 
		return column;
	}
	/**
	 * 获取是否已做微生物检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_microbeinspectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_microbeinspection");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否已做微生物检查"); 
		return column;
	}
	/**
	 * 获取微生物检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMicrobeinspectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Microbeinspection");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微生物检查"); 
		return column;
	}
	/**
	 * 获取患者过敏信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllerhyhistoryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allerhyhistory");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者过敏信息"); 
		return column;
	}
	/**
	 * 获取用药目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_ppsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_pps");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药目的"); 
		return column;
	}
	/**
	 * 获取申请医生ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生ID"); 
		return column;
	}
	/**
	 * 获取申请医生职称ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_title");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生职称ID"); 
		return column;
	}
	/**
	 * 获取申请医生职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_titleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请医生职称"); 
		return column;
	}
	/**
	 * 获取签署标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("签署标识"); 
		return column;
	}
	/**
	 * 获取会诊申请状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_specconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_speccons");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请状态ID"); 
		return column;
	}
	/**
	 * 获取会诊记录方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_record");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("会诊记录方式"); 
		return column;
	}
	/**
	 * 获取会诊方式ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_consmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊方式ID"); 
		return column;
	}
	/**
	 * 获取会诊方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_consmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊方式编码"); 
		return column;
	}
	/**
	 * 获取会诊专家意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Advice");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊专家意见"); 
		return column;
	}
	/**
	 * 获取会诊意见记录人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_record");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊意见记录人"); 
		return column;
	}
	/**
	 * 获取会诊申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cons_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cons_app");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊申请时间"); 
		return column;
	}
	/**
	 * 获取会诊意见记录时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_record");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊意见记录时间"); 
		return column;
	}
	/**
	 * 获取实际会诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cons");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("实际会诊时间"); 
		return column;
	}
	/**
	 * 获取专家会诊结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_approve_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专家会诊结果ID"); 
		return column;
	}
	/**
	 * 获取专家会诊结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_approve_emp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专家会诊结果编码"); 
		return column;
	}
	/**
	 * 获取会诊记录签署标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sign_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign_record");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊记录签署标志"); 
		return column;
	}
	/**
	 * 获取是否需要科室审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_approve_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_approve_clidep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要科室审批"); 
		return column;
	}
	/**
	 * 获取科室审批结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_approve_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_approve_clidep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室审批结果ID"); 
		return column;
	}
	/**
	 * 获取科室审批结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_approve_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_approve_clidep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室审批结果编码"); 
		return column;
	}
	/**
	 * 获取是否需要医务审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_approve_meddepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_approve_meddep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需要医务审批"); 
		return column;
	}
	/**
	 * 获取医务审批结果ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_approve_meddepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_approve_meddep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务审批结果ID"); 
		return column;
	}
	/**
	 * 获取医务审批结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_approve_meddepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_approve_meddep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务审批结果编码"); 
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
	 * 获取当前就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前就诊科室"); 
		return column;
	}
	/**
	 * 获取当前医疗组表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wg_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wg_phy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前医疗组"); 
		return column;
	}
	/**
	 * 获取当前护理单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前护理单位"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birth_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth_pat");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_pat");
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
	private IColumnDesc getName_sex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex_pat");
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
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
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
	private IColumnDesc getSd_su_specconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_speccons");
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
	private IColumnDesc getName_su_specconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_su_speccons");
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
	private IColumnDesc getName_consmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_consmd");
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
	private IColumnDesc getName_emp_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_record");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_approve_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_approve_emp");
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
	private IColumnDesc getName_approve_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_approve_clidep");
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
	private IColumnDesc getName_approve_meddepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_approve_meddep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取服务项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目名称"); 
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
