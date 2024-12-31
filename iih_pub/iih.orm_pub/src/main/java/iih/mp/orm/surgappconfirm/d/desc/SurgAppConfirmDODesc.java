
package iih.mp.orm.surgappconfirm.d.desc;

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
 * 手术申请单确认 DO 元数据信息
 */
public class SurgAppConfirmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.orm.surgappconfirm.d.SurgAppConfirmDO";
	public static final String CLASS_DISPALYNAME = "手术申请单确认";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MP_ORM_APP_SUG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_apopcf";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SurgAppConfirmDODesc(){
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
		this.setKeyDesc(getId_apopcfADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_apopcfADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_or_prADesc(tblDesc));
		this.add(getId_apopADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getId_diADesc(tblDesc));
		this.add(getStr_id_diitmADesc(tblDesc));
		this.add(getStr_code_diADesc(tblDesc));
		this.add(getStr_name_diADesc(tblDesc));
		this.add(getDt_apopADesc(tblDesc));
		this.add(getDt_b_planADesc(tblDesc));
		this.add(getDt_e_planADesc(tblDesc));
		this.add(getSugplandateADesc(tblDesc));
		this.add(getId_lvlsugADesc(tblDesc));
		this.add(getSd_lvlsugADesc(tblDesc));
		this.add(getId_anestpADesc(tblDesc));
		this.add(getSd_anestpADesc(tblDesc));
		this.add(getId_incitpADesc(tblDesc));
		this.add(getSd_incitpADesc(tblDesc));
		this.add(getId_incihealtpADesc(tblDesc));
		this.add(getSd_incihealtpADesc(tblDesc));
		this.add(getId_surgical_siteADesc(tblDesc));
		this.add(getSd_surgical_siteADesc(tblDesc));
		this.add(getFg_allergyADesc(tblDesc));
		this.add(getFg_newADesc(tblDesc));
		this.add(getFg_pathoADesc(tblDesc));
		this.add(getId_grdasptADesc(tblDesc));
		this.add(getSd_grdasptADesc(tblDesc));
		this.add(getId_su_opADesc(tblDesc));
		this.add(getSd_su_opADesc(tblDesc));
		this.add(getAnnouncementsADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getQuan_bt_palnADesc(tblDesc));
		this.add(getFg_selfADesc(tblDesc));
		this.add(getReplantADesc(tblDesc));
		this.add(getId_sugbodyADesc(tblDesc));
		this.add(getSd_sugbodyADesc(tblDesc));
		this.add(getId_specialreqADesc(tblDesc));
		this.add(getId_specialinstrumentADesc(tblDesc));
		this.add(getSpecialdesADesc(tblDesc));
		this.add(getId_asaADesc(tblDesc));
		this.add(getSd_asaADesc(tblDesc));
		this.add(getFg_er_sugADesc(tblDesc));
		this.add(getFg_xq_sugADesc(tblDesc));
		this.add(getFg_zq_sugADesc(tblDesc));
		this.add(getFg_prnADesc(tblDesc));
		this.add(getFg_daysugADesc(tblDesc));
		this.add(getId_diitmafADesc(tblDesc));
		this.add(getId_staticADesc(tblDesc));
		this.add(getCnt_prnADesc(tblDesc));
		this.add(getId_optADesc(tblDesc));
		this.add(getNum_optADesc(tblDesc));
		this.add(getStat_apopADesc(tblDesc));
		this.add(getId_dept_appADesc(tblDesc));
		this.add(getId_dept_execADesc(tblDesc));
		this.add(getId_emp_confADesc(tblDesc));
		this.add(getDt_confADesc(tblDesc));
		this.add(getDt_arv_dctADesc(tblDesc));
		this.add(getDt_arv_patADesc(tblDesc));
		this.add(getDt_lv_patADesc(tblDesc));
		this.add(getDt_st_atsADesc(tblDesc));
		this.add(getDt_ed_atsADesc(tblDesc));
		this.add(getDt_st_opADesc(tblDesc));
		this.add(getDt_ed_opADesc(tblDesc));
		this.add(getFg_pat_outADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getCode_entADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getCode_orADesc(tblDesc));
		this.add(getContent_orADesc(tblDesc));
		this.add(getLvlsug_codeADesc(tblDesc));
		this.add(getLvlsug_nameADesc(tblDesc));
		this.add(getAne_codeADesc(tblDesc));
		this.add(getAne_nameADesc(tblDesc));
		this.add(getInci_codeADesc(tblDesc));
		this.add(getInci_nameADesc(tblDesc));
		this.add(getInciheal_codeADesc(tblDesc));
		this.add(getInciheal_nameADesc(tblDesc));
		this.add(getName_surgical_siteADesc(tblDesc));
		this.add(getCode_surgical_siteADesc(tblDesc));
		this.add(getGrdaspt_codeADesc(tblDesc));
		this.add(getGrdaspt_nameADesc(tblDesc));
		this.add(getSu_op_codeADesc(tblDesc));
		this.add(getSu_op_nameADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getSugbody_codeADesc(tblDesc));
		this.add(getSugbody_nameADesc(tblDesc));
		this.add(getSpecialreq_codeADesc(tblDesc));
		this.add(getSpecialreq_nameADesc(tblDesc));
		this.add(getSpecialinstrument_codeADesc(tblDesc));
		this.add(getSpecialinstrument_nameADesc(tblDesc));
		this.add(getAsa_nameADesc(tblDesc));
		this.add(getDiaf_codeADesc(tblDesc));
		this.add(getDiaf_nameADesc(tblDesc));
		this.add(getOpt_codeADesc(tblDesc));
		this.add(getOpt_nameADesc(tblDesc));
		this.add(getDep_app_codeADesc(tblDesc));
		this.add(getDep_app_nameADesc(tblDesc));
		this.add(getDep_exec_codeADesc(tblDesc));
		this.add(getDep_exec_nameADesc(tblDesc));
		this.add(getEmp_conf_codeADesc(tblDesc));
		this.add(getEmp_conf_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apopcfCDesc(tblDesc));
		tblDesc.add(getId_apopcfCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_or_prCDesc(tblDesc));
		tblDesc.add(getId_apopCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getId_diCDesc(tblDesc));
		tblDesc.add(getStr_id_diitmCDesc(tblDesc));
		tblDesc.add(getStr_code_diCDesc(tblDesc));
		tblDesc.add(getStr_name_diCDesc(tblDesc));
		tblDesc.add(getDt_apopCDesc(tblDesc));
		tblDesc.add(getDt_b_planCDesc(tblDesc));
		tblDesc.add(getDt_e_planCDesc(tblDesc));
		tblDesc.add(getSugplandateCDesc(tblDesc));
		tblDesc.add(getId_lvlsugCDesc(tblDesc));
		tblDesc.add(getSd_lvlsugCDesc(tblDesc));
		tblDesc.add(getId_anestpCDesc(tblDesc));
		tblDesc.add(getSd_anestpCDesc(tblDesc));
		tblDesc.add(getId_incitpCDesc(tblDesc));
		tblDesc.add(getSd_incitpCDesc(tblDesc));
		tblDesc.add(getId_incihealtpCDesc(tblDesc));
		tblDesc.add(getSd_incihealtpCDesc(tblDesc));
		tblDesc.add(getId_surgical_siteCDesc(tblDesc));
		tblDesc.add(getSd_surgical_siteCDesc(tblDesc));
		tblDesc.add(getFg_allergyCDesc(tblDesc));
		tblDesc.add(getFg_newCDesc(tblDesc));
		tblDesc.add(getFg_pathoCDesc(tblDesc));
		tblDesc.add(getId_grdasptCDesc(tblDesc));
		tblDesc.add(getSd_grdasptCDesc(tblDesc));
		tblDesc.add(getId_su_opCDesc(tblDesc));
		tblDesc.add(getSd_su_opCDesc(tblDesc));
		tblDesc.add(getAnnouncementsCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getQuan_bt_palnCDesc(tblDesc));
		tblDesc.add(getFg_selfCDesc(tblDesc));
		tblDesc.add(getReplantCDesc(tblDesc));
		tblDesc.add(getId_sugbodyCDesc(tblDesc));
		tblDesc.add(getSd_sugbodyCDesc(tblDesc));
		tblDesc.add(getId_specialreqCDesc(tblDesc));
		tblDesc.add(getId_specialinstrumentCDesc(tblDesc));
		tblDesc.add(getSpecialdesCDesc(tblDesc));
		tblDesc.add(getId_asaCDesc(tblDesc));
		tblDesc.add(getSd_asaCDesc(tblDesc));
		tblDesc.add(getFg_er_sugCDesc(tblDesc));
		tblDesc.add(getFg_xq_sugCDesc(tblDesc));
		tblDesc.add(getFg_zq_sugCDesc(tblDesc));
		tblDesc.add(getFg_prnCDesc(tblDesc));
		tblDesc.add(getFg_daysugCDesc(tblDesc));
		tblDesc.add(getId_diitmafCDesc(tblDesc));
		tblDesc.add(getId_staticCDesc(tblDesc));
		tblDesc.add(getCnt_prnCDesc(tblDesc));
		tblDesc.add(getId_optCDesc(tblDesc));
		tblDesc.add(getNum_optCDesc(tblDesc));
		tblDesc.add(getStat_apopCDesc(tblDesc));
		tblDesc.add(getId_dept_appCDesc(tblDesc));
		tblDesc.add(getId_dept_execCDesc(tblDesc));
		tblDesc.add(getId_emp_confCDesc(tblDesc));
		tblDesc.add(getDt_confCDesc(tblDesc));
		tblDesc.add(getDt_arv_dctCDesc(tblDesc));
		tblDesc.add(getDt_arv_patCDesc(tblDesc));
		tblDesc.add(getDt_lv_patCDesc(tblDesc));
		tblDesc.add(getDt_st_atsCDesc(tblDesc));
		tblDesc.add(getDt_ed_atsCDesc(tblDesc));
		tblDesc.add(getDt_st_opCDesc(tblDesc));
		tblDesc.add(getDt_ed_opCDesc(tblDesc));
		tblDesc.add(getFg_pat_outCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术申请单确认主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apopcfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apopcf",  getId_apopcfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请单确认主键标识");
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
	 * 执行计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_or_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or_pr",  getId_or_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apop",  getId_apopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请单号");
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
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di",  getId_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 临床诊断明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_id_diitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_id_diitm",  getStr_id_diitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床诊断明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_code_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_code_di",  getStr_code_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码拼接");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称拼接属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStr_name_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Str_name_di",  getStr_name_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称拼接");
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
	private IAttrDesc getDt_apopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_apop",  getDt_apopCDesc(tblDesc), this);
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
	 * 计划开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_b_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b_plan",  getDt_b_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("计划开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_e_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e_plan",  getDt_e_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("计划结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugplandateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugplandate",  getSugplandateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("计划手术日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lvlsug",  getId_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lvlsug",  getSd_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别编码");
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
	private IAttrDesc getId_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anestp",  getId_anestpCDesc(tblDesc), this);
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
	private IAttrDesc getSd_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anestp",  getSd_anestpCDesc(tblDesc), this);
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
	 * 切口等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incitp",  getId_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incitp",  getSd_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口愈合等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incihealtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incihealtp",  getId_incihealtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口愈合等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incihealtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incihealtp",  getSd_incihealtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_surgical_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_surgical_site",  getId_surgical_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_surgical_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_surgical_site",  getSd_surgical_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物过敏标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_allergy",  getFg_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("药物过敏标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否开展新手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_new",  getFg_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否开展新手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 冰冻病理标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pathoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_patho",  getFg_pathoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("冰冻病理标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 无菌程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grdasptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grdaspt",  getId_grdasptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("无菌程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 无菌程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_grdasptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_grdaspt",  getSd_grdasptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("无菌程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术申请状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_op",  getId_su_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术申请状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_op",  getSd_su_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注意事项属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnnouncementsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Announcements",  getAnnouncementsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注意事项");
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
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_bt_palnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_bt_paln",  getQuan_bt_palnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("输血量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自体输血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_selfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_self",  getFg_selfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("自体输血");
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
	private IAttrDesc getReplantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Replant",  getReplantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("植入物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sugbodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sugbody",  getId_sugbodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sugbodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sugbody",  getSd_sugbodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊用物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_specialreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_specialreq",  getId_specialreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊用物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特殊仪器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_specialinstrumentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_specialinstrument",  getId_specialinstrumentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊仪器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特殊准备属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialdesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialdes",  getSpecialdesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊准备");
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
	private IAttrDesc getId_asaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_asa",  getId_asaCDesc(tblDesc), this);
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
	private IAttrDesc getSd_asaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_asa",  getSd_asaCDesc(tblDesc), this);
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
	 * 急症手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_er_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_er_sug",  getFg_er_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急症手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 限期手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_xq_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_xq_sug",  getFg_xq_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("限期手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 择期手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_zq_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_zq_sug",  getFg_zq_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("择期手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prn",  getFg_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日间手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_daysugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_daysug",  getFg_daysugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("日间手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diitmafADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diitmaf",  getId_diitmafCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后诊断ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 统计类别ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_staticADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_static",  getId_staticCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("统计类别ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCnt_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cnt_prn",  getCnt_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("打印次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opt",  getId_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 台次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_opt",  getNum_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("台次");
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
	private IAttrDesc getStat_apopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stat_apop",  getStat_apopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dept_appADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept_app",  getId_dept_appCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 执行科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dept_execADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept_exec",  getId_dept_execCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前确认人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_conf",  getId_emp_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前确认人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前确认时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_conf",  getDt_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("术前确认时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生到达时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_arv_dctADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_arv_dct",  getDt_arv_dctCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医生到达时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者到达时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_arv_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_arv_pat",  getDt_arv_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("患者到达时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者离开时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_lv_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_lv_pat",  getDt_lv_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("患者离开时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_st_atsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st_ats",  getDt_st_atsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("麻醉开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_ed_atsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ed_ats",  getDt_ed_atsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("麻醉结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_st_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_st_op",  getDt_st_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_ed_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ed_op",  getDt_ed_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊患者标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pat_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pat_out",  getFg_pat_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("门诊患者标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 加急标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("加急标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
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
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_code",  getPat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b25","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b25","id_pat=id_pat","name"});
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
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b25","id_pat=id_pat","code_amr_ip"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ent",  getCode_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b24","id_ent=id_ent","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b24","id_ent=id_ent","id_entp"});
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
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b24","id_ent=id_ent","code_entp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_or",  getCode_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a0b4","id_or=id_or","code_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_or",  getContent_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a0b4","id_or=id_or","content_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_code",  getLvlsug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_lvlsug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_name",  getLvlsug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_lvlsug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAne_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ane_code",  getAne_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_anestp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAne_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ane_name",  getAne_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_anestp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInci_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inci_code",  getInci_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_incitp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口等级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInci_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inci_name",  getInci_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_incitp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口愈合等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInciheal_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inciheal_code",  getInciheal_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_incihealtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口愈合等级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInciheal_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inciheal_name",  getInciheal_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合等级名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_incihealtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_surgical_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_surgical_site",  getName_surgical_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_surgical_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_surgical_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_surgical_site",  getCode_surgical_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_surgical_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 无菌程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrdaspt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grdaspt_code",  getGrdaspt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("无菌程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_grdaspt=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 无菌程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrdaspt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grdaspt_name",  getGrdaspt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("无菌程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_grdaspt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术申请状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSu_op_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Su_op_code",  getSu_op_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_su_op=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术申请状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSu_op_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Su_op_name",  getSu_op_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_su_op=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b10","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b10","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugbody_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugbody_code",  getSugbody_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_sugbody=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSugbody_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sugbody_name",  getSugbody_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_sugbody=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用物编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialreq_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialreq_code",  getSpecialreq_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用物编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a0b21","id_specialreq=id_mmom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用物名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialreq_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialreq_name",  getSpecialreq_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用物名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a0b21","id_specialreq=id_mmom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仪器编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialinstrument_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialinstrument_code",  getSpecialinstrument_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仪器编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a0b22","id_specialinstrument=id_mmom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仪器名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecialinstrument_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Specialinstrument_name",  getSpecialinstrument_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("仪器名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a0b22","id_specialinstrument=id_mmom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAsa_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Asa_name",  getAsa_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_asa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiaf_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diaf_code",  getDiaf_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b12","id_diitmaf=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiaf_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diaf_name",  getDiaf_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b12","id_diitmaf=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术台编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opt_code",  getOpt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术台编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_opt a0b14","id_opt=id_opt","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术台名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOpt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Opt_name",  getOpt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术台名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_opt a0b14","id_opt=id_opt","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_app_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_app_code",  getDep_app_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dept_app=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_app_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_app_name",  getDep_app_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b15","id_dept_app=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_exec_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_exec_code",  getDep_exec_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b16","id_dept_exec=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_exec_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_exec_name",  getDep_exec_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b16","id_dept_exec=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前确认人人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_conf_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_conf_code",  getEmp_conf_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前确认人人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_emp_conf=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前确认人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_conf_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_conf_name",  getEmp_conf_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前确认人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","id_emp_conf=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术申请单确认主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apopcfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apopcf");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术申请单确认主键标识"); 
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
	 * 获取执行计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_or_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or_pr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行计划"); 
		return column;
	}
	/**
	 * 获取申请单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apop");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单ID"); 
		return column;
	}
	/**
	 * 获取手术申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请单号"); 
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
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取临床诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断"); 
		return column;
	}
	/**
	 * 获取临床诊断明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_id_diitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_id_diitm");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床诊断明细"); 
		return column;
	}
	/**
	 * 获取诊断编码拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_code_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_code_di");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码拼接"); 
		return column;
	}
	/**
	 * 获取诊断名称拼接表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStr_name_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Str_name_di");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称拼接"); 
		return column;
	}
	/**
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_apop");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取计划开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_b_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b_plan");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划开始时间"); 
		return column;
	}
	/**
	 * 获取计划结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_e_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e_plan");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划结束时间"); 
		return column;
	}
	/**
	 * 获取计划手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugplandateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugplandate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划手术日期"); 
		return column;
	}
	/**
	 * 获取手术级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lvlsug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别"); 
		return column;
	}
	/**
	 * 获取手术级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lvlsug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别编码"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anestp");
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
	private IColumnDesc getSd_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anestp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取切口等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incitp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级"); 
		return column;
	}
	/**
	 * 获取切口等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incitp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级编码"); 
		return column;
	}
	/**
	 * 获取切口愈合等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incihealtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incihealtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合等级"); 
		return column;
	}
	/**
	 * 获取切口愈合等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incihealtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incihealtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合等级编码"); 
		return column;
	}
	/**
	 * 获取手术部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_surgical_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_surgical_site");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位"); 
		return column;
	}
	/**
	 * 获取手术部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_surgical_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_surgical_site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位编码"); 
		return column;
	}
	/**
	 * 获取药物过敏标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_allergy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药物过敏标志"); 
		return column;
	}
	/**
	 * 获取是否开展新手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_new");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否开展新手术"); 
		return column;
	}
	/**
	 * 获取冰冻病理标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pathoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_patho");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("冰冻病理标识"); 
		return column;
	}
	/**
	 * 获取无菌程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grdasptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grdaspt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("无菌程度"); 
		return column;
	}
	/**
	 * 获取无菌程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_grdasptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_grdaspt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("无菌程度编码"); 
		return column;
	}
	/**
	 * 获取手术申请状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请状态"); 
		return column;
	}
	/**
	 * 获取手术申请状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请状态编码"); 
		return column;
	}
	/**
	 * 获取注意事项表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnnouncementsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Announcements");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注意事项"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取输血量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_bt_palnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_bt_paln");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("输血量"); 
		return column;
	}
	/**
	 * 获取自体输血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_selfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_self");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("自体输血"); 
		return column;
	}
	/**
	 * 获取植入物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReplantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Replant");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("植入物"); 
		return column;
	}
	/**
	 * 获取体位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sugbodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sugbody");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位"); 
		return column;
	}
	/**
	 * 获取体位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sugbodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sugbody");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位编码"); 
		return column;
	}
	/**
	 * 获取特殊用物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_specialreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_specialreq");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊用物"); 
		return column;
	}
	/**
	 * 获取特殊仪器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_specialinstrumentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_specialinstrument");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊仪器"); 
		return column;
	}
	/**
	 * 获取特殊准备表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialdesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialdes");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊准备"); 
		return column;
	}
	/**
	 * 获取ASA评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_asaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_asa");
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
	private IColumnDesc getSd_asaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_asa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ASA评分编码"); 
		return column;
	}
	/**
	 * 获取急症手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_er_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_er_sug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急症手术"); 
		return column;
	}
	/**
	 * 获取限期手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_xq_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_xq_sug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("限期手术"); 
		return column;
	}
	/**
	 * 获取择期手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_zq_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_zq_sug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("择期手术"); 
		return column;
	}
	/**
	 * 获取打印标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印标志"); 
		return column;
	}
	/**
	 * 获取日间手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_daysugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_daysug");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日间手术"); 
		return column;
	}
	/**
	 * 获取术后诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diitmafCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diitmaf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后诊断ID"); 
		return column;
	}
	/**
	 * 获取统计类别ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_staticCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_static");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("统计类别ID"); 
		return column;
	}
	/**
	 * 获取打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCnt_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cnt_prn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印次数"); 
		return column;
	}
	/**
	 * 获取手术间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术间"); 
		return column;
	}
	/**
	 * 获取台次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_opt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("台次"); 
		return column;
	}
	/**
	 * 获取状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStat_apopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stat_apop");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("状态"); 
		return column;
	}
	/**
	 * 获取申请科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dept_appCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept_app");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室"); 
		return column;
	}
	/**
	 * 获取执行科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dept_execCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept_exec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室"); 
		return column;
	}
	/**
	 * 获取术前确认人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_conf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前确认人"); 
		return column;
	}
	/**
	 * 获取术前确认时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_conf");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术前确认时间"); 
		return column;
	}
	/**
	 * 获取医生到达时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_arv_dctCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_arv_dct");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医生到达时间"); 
		return column;
	}
	/**
	 * 获取患者到达时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_arv_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_arv_pat");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者到达时间"); 
		return column;
	}
	/**
	 * 获取患者离开时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_lv_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_lv_pat");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者离开时间"); 
		return column;
	}
	/**
	 * 获取麻醉开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_st_atsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st_ats");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("麻醉开始时间"); 
		return column;
	}
	/**
	 * 获取麻醉结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_ed_atsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ed_ats");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("麻醉结束时间"); 
		return column;
	}
	/**
	 * 获取手术开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_st_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_st_op");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术开始时间"); 
		return column;
	}
	/**
	 * 获取手术结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_ed_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ed_op");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术结束时间"); 
		return column;
	}
	/**
	 * 获取门诊患者标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pat_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pat_out");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("门诊患者标志"); 
		return column;
	}
	/**
	 * 获取加急标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("加急标识"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
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
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_code");
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
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
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
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ent");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取医嘱编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱编码"); 
		return column;
	}
	/**
	 * 获取医嘱内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱内容"); 
		return column;
	}
	/**
	 * 获取手术级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLvlsug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别编码"); 
		return column;
	}
	/**
	 * 获取手术级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLvlsug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别名称"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAne_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ane_code");
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
	private IColumnDesc getAne_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ane_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取切口等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInci_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inci_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级编码"); 
		return column;
	}
	/**
	 * 获取切口等级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInci_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inci_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级名称"); 
		return column;
	}
	/**
	 * 获取切口愈合等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInciheal_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inciheal_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合等级编码"); 
		return column;
	}
	/**
	 * 获取切口愈合等级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInciheal_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inciheal_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合等级名称"); 
		return column;
	}
	/**
	 * 获取手术部位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_surgical_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_surgical_site");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位名称"); 
		return column;
	}
	/**
	 * 获取手术部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_surgical_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_surgical_site");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术部位编码"); 
		return column;
	}
	/**
	 * 获取无菌程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrdaspt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grdaspt_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("无菌程度编码"); 
		return column;
	}
	/**
	 * 获取无菌程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrdaspt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grdaspt_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("无菌程度名称"); 
		return column;
	}
	/**
	 * 获取手术申请状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSu_op_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Su_op_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请状态编码"); 
		return column;
	}
	/**
	 * 获取手术申请状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSu_op_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Su_op_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请状态名称"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
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
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取体位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugbody_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugbody_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位编码"); 
		return column;
	}
	/**
	 * 获取体位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSugbody_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sugbody_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体位名称"); 
		return column;
	}
	/**
	 * 获取用物编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialreq_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialreq_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用物编码"); 
		return column;
	}
	/**
	 * 获取用物名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialreq_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialreq_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用物名称"); 
		return column;
	}
	/**
	 * 获取仪器编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialinstrument_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialinstrument_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仪器编码"); 
		return column;
	}
	/**
	 * 获取仪器名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecialinstrument_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Specialinstrument_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("仪器名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAsa_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Asa_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取术后诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiaf_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diaf_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后诊断编码"); 
		return column;
	}
	/**
	 * 获取术后诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiaf_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diaf_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后诊断名称"); 
		return column;
	}
	/**
	 * 获取手术台编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opt_code");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术台编码"); 
		return column;
	}
	/**
	 * 获取手术台名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOpt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Opt_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术台名称"); 
		return column;
	}
	/**
	 * 获取申请科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_app_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_app_code");
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
	private IColumnDesc getDep_app_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_app_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室名称"); 
		return column;
	}
	/**
	 * 获取执行科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_exec_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_exec_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室编码"); 
		return column;
	}
	/**
	 * 获取执行科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_exec_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_exec_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室名称"); 
		return column;
	}
	/**
	 * 获取术前确认人人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_conf_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_conf_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前确认人人员编码"); 
		return column;
	}
	/**
	 * 获取术前确认人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_conf_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_conf_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前确认人姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_apopcf");
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
