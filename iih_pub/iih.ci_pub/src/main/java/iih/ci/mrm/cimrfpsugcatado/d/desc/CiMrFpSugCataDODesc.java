
package iih.ci.mrm.cimrfpsugcatado.d.desc;

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
 * 病案编目手术 DO 元数据信息
 */
public class CiMrFpSugCataDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.cimrfpsugcatado.d.CiMrFpSugCataDO";
	public static final String CLASS_DISPALYNAME = "病案编目手术";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_FP_SUG_CATA";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrfpsug";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrFpSugCataDODesc(){
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
		this.setKeyDesc(getId_mrfpsugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mrfpsugADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_mrfpADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_sugADesc(tblDesc));
		this.add(getSd_sugADesc(tblDesc));
		this.add(getName_sugADesc(tblDesc));
		this.add(getId_lvlsugADesc(tblDesc));
		this.add(getSd_lvlsugADesc(tblDesc));
		this.add(getName_lvlsugADesc(tblDesc));
		this.add(getDt_start_sugADesc(tblDesc));
		this.add(getDt_end_sugADesc(tblDesc));
		this.add(getId_emp_sugADesc(tblDesc));
		this.add(getSd_emp_sugADesc(tblDesc));
		this.add(getName_emp_sugADesc(tblDesc));
		this.add(getId_emp_asst1ADesc(tblDesc));
		this.add(getSd_emp_asst1ADesc(tblDesc));
		this.add(getName_emp_asst1ADesc(tblDesc));
		this.add(getId_emp_asst2ADesc(tblDesc));
		this.add(getSd_emp_asst2ADesc(tblDesc));
		this.add(getName_emp_asst2ADesc(tblDesc));
		this.add(getId_emp_anesADesc(tblDesc));
		this.add(getSd_emp_anesADesc(tblDesc));
		this.add(getName_emp_anesADesc(tblDesc));
		this.add(getId_incitpADesc(tblDesc));
		this.add(getSd_incitpADesc(tblDesc));
		this.add(getName_incitpADesc(tblDesc));
		this.add(getId_anestpADesc(tblDesc));
		this.add(getSd_anestpADesc(tblDesc));
		this.add(getName_anestpADesc(tblDesc));
		this.add(getId_incicondiADesc(tblDesc));
		this.add(getSd_incicondiADesc(tblDesc));
		this.add(getName_incicondiADesc(tblDesc));
		this.add(getId_fg_complicationADesc(tblDesc));
		this.add(getName_fg_complicationADesc(tblDesc));
		this.add(getSd_fg_complicationADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_method_sugADesc(tblDesc));
		this.add(getSd_method_sugADesc(tblDesc));
		this.add(getName_method_sugADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getId_class_sugADesc(tblDesc));
		this.add(getSd_class_sugADesc(tblDesc));
		this.add(getName_class_sugADesc(tblDesc));
		this.add(getOperation_dateADesc(tblDesc));
		this.add(getId_attach_sugADesc(tblDesc));
		this.add(getSd_attach_sugADesc(tblDesc));
		this.add(getName_attach_sugADesc(tblDesc));
		this.add(getId_anes_lvlADesc(tblDesc));
		this.add(getSd_anes_lvlADesc(tblDesc));
		this.add(getName_anes_lvlADesc(tblDesc));
		this.add(getId_sug_risklvlADesc(tblDesc));
		this.add(getSd_sug_risklvlADesc(tblDesc));
		this.add(getName_sug_risklvlADesc(tblDesc));
		this.add(getId_ant_beforesugADesc(tblDesc));
		this.add(getSd_ant_beforesugADesc(tblDesc));
		this.add(getName_ant_beforesugADesc(tblDesc));
		this.add(getAnt_usingdaysADesc(tblDesc));
		this.add(getId_has_resugADesc(tblDesc));
		this.add(getSd_has_resugADesc(tblDesc));
		this.add(getName_has_resugADesc(tblDesc));
		this.add(getId_has_anescompADesc(tblDesc));
		this.add(getSd_has_anescompADesc(tblDesc));
		this.add(getName_has_anescompADesc(tblDesc));
		this.add(getId_has_sugleaveADesc(tblDesc));
		this.add(getSd_has_sugleaveADesc(tblDesc));
		this.add(getName_has_sugleaveADesc(tblDesc));
		this.add(getId_has_sugcompADesc(tblDesc));
		this.add(getSd_has_sugcompADesc(tblDesc));
		this.add(getName_has_sugcompADesc(tblDesc));
		this.add(getId_hashem_aftersugADesc(tblDesc));
		this.add(getSd_hashem_aftersugADesc(tblDesc));
		this.add(getName_hashem_aftersugADesc(tblDesc));
		this.add(getId_haswd_aftersugADesc(tblDesc));
		this.add(getSd_haswd_aftersugADesc(tblDesc));
		this.add(getName_haswd_aftersugADesc(tblDesc));
		this.add(getId_hasdvt_aftersugADesc(tblDesc));
		this.add(getSd_hasdvt_aftersugADesc(tblDesc));
		this.add(getName_hasdvt_aftersugADesc(tblDesc));
		this.add(getId_hasmd_aftersugADesc(tblDesc));
		this.add(getSd_hasmd_aftersugADesc(tblDesc));
		this.add(getName_hasmd_aftersugADesc(tblDesc));
		this.add(getId_hasfor_aftersugADesc(tblDesc));
		this.add(getSd_hasfor_aftersugADesc(tblDesc));
		this.add(getName_hasfor_aftersugADesc(tblDesc));
		this.add(getId_haspe_aftersugADesc(tblDesc));
		this.add(getSd_haspe_aftersugADesc(tblDesc));
		this.add(getName_haspe_aftersugADesc(tblDesc));
		this.add(getId_hashema_aftersugADesc(tblDesc));
		this.add(getSd_hashema_aftersugADesc(tblDesc));
		this.add(getName_hashema_aftersugADesc(tblDesc));
		this.add(getId_hashf_aftersugADesc(tblDesc));
		this.add(getSd_hashf_aftersugADesc(tblDesc));
		this.add(getName_hashf_aftersugADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getSug_codeADesc(tblDesc));
		this.add(getSug_nameADesc(tblDesc));
		this.add(getLvlsug_codeADesc(tblDesc));
		this.add(getLvlsug_nameADesc(tblDesc));
		this.add(getEmp_sug_nameADesc(tblDesc));
		this.add(getEmp_sug_codeADesc(tblDesc));
		this.add(getEmp_asst1_nameADesc(tblDesc));
		this.add(getEmp_asst1_codeADesc(tblDesc));
		this.add(getEmp_asst2_nameADesc(tblDesc));
		this.add(getEmp_asst2_codeADesc(tblDesc));
		this.add(getEmp_anes_nameADesc(tblDesc));
		this.add(getEmp_anes_codeADesc(tblDesc));
		this.add(getIncitp_codeADesc(tblDesc));
		this.add(getIncitp_nameADesc(tblDesc));
		this.add(getAnestp_codeADesc(tblDesc));
		this.add(getAnestp_nameADesc(tblDesc));
		this.add(getIncicondi_codeADesc(tblDesc));
		this.add(getIncicondi_nameADesc(tblDesc));
		this.add(getMethod_codeADesc(tblDesc));
		this.add(getMethod_nameADesc(tblDesc));
		this.add(getCode_class_sugADesc(tblDesc));
		this.add(getClass_sug_nameADesc(tblDesc));
		this.add(getAttach_sd_sugADesc(tblDesc));
		this.add(getAttach_name_sugADesc(tblDesc));
		this.add(getAnt_bs_codeADesc(tblDesc));
		this.add(getAnt_bs_nameADesc(tblDesc));
		this.add(getHas_resug_codeADesc(tblDesc));
		this.add(getHas_resug_nameADesc(tblDesc));
		this.add(getHas_anescomp_nameADesc(tblDesc));
		this.add(getHas_anescomp_codeADesc(tblDesc));
		this.add(getHas_sugleave_codeADesc(tblDesc));
		this.add(getHas_sugleave_nameADesc(tblDesc));
		this.add(getHas_sugcomp_codeADesc(tblDesc));
		this.add(getHas_sugcomp_nameADesc(tblDesc));
		this.add(getHashem_codeADesc(tblDesc));
		this.add(getHashem_nameADesc(tblDesc));
		this.add(getHaswd_nameADesc(tblDesc));
		this.add(getHaswd_codeADesc(tblDesc));
		this.add(getHasdvt_nameADesc(tblDesc));
		this.add(getHasdvt_codeADesc(tblDesc));
		this.add(getHasmd_codeADesc(tblDesc));
		this.add(getHasmd_nameADesc(tblDesc));
		this.add(getHasfor_nameADesc(tblDesc));
		this.add(getHasfor_codeADesc(tblDesc));
		this.add(getHaspe_codeADesc(tblDesc));
		this.add(getHaspe_nameADesc(tblDesc));
		this.add(getHashema_nameADesc(tblDesc));
		this.add(getHashema_codeADesc(tblDesc));
		this.add(getHashf_codeADesc(tblDesc));
		this.add(getHashf_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrfpsugCDesc(tblDesc));
		tblDesc.add(getId_mrfpsugCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_mrfpCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_sugCDesc(tblDesc));
		tblDesc.add(getSd_sugCDesc(tblDesc));
		tblDesc.add(getName_sugCDesc(tblDesc));
		tblDesc.add(getId_lvlsugCDesc(tblDesc));
		tblDesc.add(getSd_lvlsugCDesc(tblDesc));
		tblDesc.add(getName_lvlsugCDesc(tblDesc));
		tblDesc.add(getDt_start_sugCDesc(tblDesc));
		tblDesc.add(getDt_end_sugCDesc(tblDesc));
		tblDesc.add(getId_emp_sugCDesc(tblDesc));
		tblDesc.add(getSd_emp_sugCDesc(tblDesc));
		tblDesc.add(getName_emp_sugCDesc(tblDesc));
		tblDesc.add(getId_emp_asst1CDesc(tblDesc));
		tblDesc.add(getSd_emp_asst1CDesc(tblDesc));
		tblDesc.add(getName_emp_asst1CDesc(tblDesc));
		tblDesc.add(getId_emp_asst2CDesc(tblDesc));
		tblDesc.add(getSd_emp_asst2CDesc(tblDesc));
		tblDesc.add(getName_emp_asst2CDesc(tblDesc));
		tblDesc.add(getId_emp_anesCDesc(tblDesc));
		tblDesc.add(getSd_emp_anesCDesc(tblDesc));
		tblDesc.add(getName_emp_anesCDesc(tblDesc));
		tblDesc.add(getId_incitpCDesc(tblDesc));
		tblDesc.add(getSd_incitpCDesc(tblDesc));
		tblDesc.add(getName_incitpCDesc(tblDesc));
		tblDesc.add(getId_anestpCDesc(tblDesc));
		tblDesc.add(getSd_anestpCDesc(tblDesc));
		tblDesc.add(getName_anestpCDesc(tblDesc));
		tblDesc.add(getId_incicondiCDesc(tblDesc));
		tblDesc.add(getSd_incicondiCDesc(tblDesc));
		tblDesc.add(getName_incicondiCDesc(tblDesc));
		tblDesc.add(getId_fg_complicationCDesc(tblDesc));
		tblDesc.add(getName_fg_complicationCDesc(tblDesc));
		tblDesc.add(getSd_fg_complicationCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_method_sugCDesc(tblDesc));
		tblDesc.add(getSd_method_sugCDesc(tblDesc));
		tblDesc.add(getName_method_sugCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getId_class_sugCDesc(tblDesc));
		tblDesc.add(getSd_class_sugCDesc(tblDesc));
		tblDesc.add(getName_class_sugCDesc(tblDesc));
		tblDesc.add(getOperation_dateCDesc(tblDesc));
		tblDesc.add(getId_attach_sugCDesc(tblDesc));
		tblDesc.add(getSd_attach_sugCDesc(tblDesc));
		tblDesc.add(getName_attach_sugCDesc(tblDesc));
		tblDesc.add(getId_anes_lvlCDesc(tblDesc));
		tblDesc.add(getSd_anes_lvlCDesc(tblDesc));
		tblDesc.add(getName_anes_lvlCDesc(tblDesc));
		tblDesc.add(getId_sug_risklvlCDesc(tblDesc));
		tblDesc.add(getSd_sug_risklvlCDesc(tblDesc));
		tblDesc.add(getName_sug_risklvlCDesc(tblDesc));
		tblDesc.add(getId_ant_beforesugCDesc(tblDesc));
		tblDesc.add(getSd_ant_beforesugCDesc(tblDesc));
		tblDesc.add(getName_ant_beforesugCDesc(tblDesc));
		tblDesc.add(getAnt_usingdaysCDesc(tblDesc));
		tblDesc.add(getId_has_resugCDesc(tblDesc));
		tblDesc.add(getSd_has_resugCDesc(tblDesc));
		tblDesc.add(getName_has_resugCDesc(tblDesc));
		tblDesc.add(getId_has_anescompCDesc(tblDesc));
		tblDesc.add(getSd_has_anescompCDesc(tblDesc));
		tblDesc.add(getName_has_anescompCDesc(tblDesc));
		tblDesc.add(getId_has_sugleaveCDesc(tblDesc));
		tblDesc.add(getSd_has_sugleaveCDesc(tblDesc));
		tblDesc.add(getName_has_sugleaveCDesc(tblDesc));
		tblDesc.add(getId_has_sugcompCDesc(tblDesc));
		tblDesc.add(getSd_has_sugcompCDesc(tblDesc));
		tblDesc.add(getName_has_sugcompCDesc(tblDesc));
		tblDesc.add(getId_hashem_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hashem_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hashem_aftersugCDesc(tblDesc));
		tblDesc.add(getId_haswd_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_haswd_aftersugCDesc(tblDesc));
		tblDesc.add(getName_haswd_aftersugCDesc(tblDesc));
		tblDesc.add(getId_hasdvt_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hasdvt_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hasdvt_aftersugCDesc(tblDesc));
		tblDesc.add(getId_hasmd_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hasmd_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hasmd_aftersugCDesc(tblDesc));
		tblDesc.add(getId_hasfor_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hasfor_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hasfor_aftersugCDesc(tblDesc));
		tblDesc.add(getId_haspe_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_haspe_aftersugCDesc(tblDesc));
		tblDesc.add(getName_haspe_aftersugCDesc(tblDesc));
		tblDesc.add(getId_hashema_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hashema_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hashema_aftersugCDesc(tblDesc));
		tblDesc.add(getId_hashf_aftersugCDesc(tblDesc));
		tblDesc.add(getSd_hashf_aftersugCDesc(tblDesc));
		tblDesc.add(getName_hashf_aftersugCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院病案编目手术ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfpsug",  getId_mrfpsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编目手术ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 住院病历首页属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfp",  getId_mrfpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病历首页");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作编码ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug",  getId_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作编码ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术、操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug",  getSd_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug",  getName_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作名称");
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
	 * 手术级别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvlsugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvlsug",  getName_lvlsugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术级别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_start_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_start_sug",  getDt_start_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术及操作开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_sug",  getDt_end_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术、操作结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_sug",  getId_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_sug",  getSd_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_术者名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_sug",  getName_emp_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_术者名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_asst1",  getId_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_asst1",  getSd_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_I助名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_asst1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_asst1",  getName_emp_asst1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_I助名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_asst2",  getId_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_asst2",  getSd_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作医师_II助名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_asst2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_asst2",  getName_emp_asst2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作医师_II助名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_anes",  getId_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉医师编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emp_anes",  getSd_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉医师名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_anesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_anes",  getName_emp_anesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉医师名称");
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
	 * 切口等级名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incitpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incitp",  getName_incitpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口等级名称");
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
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anestpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anestp",  getName_anestpCDesc(tblDesc), this);
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
	 * 切口愈合情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_incicondi",  getId_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 切口愈合情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_incicondi",  getSd_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 切口愈合情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_incicondiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_incicondi",  getName_incicondiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("切口愈合情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有并发症(id)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fg_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fg_complication",  getId_fg_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有并发症(id)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有并发症(name)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fg_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fg_complication",  getName_fg_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有并发症(name)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有并发症(sd)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fg_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fg_complication",  getSd_fg_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有并发症(sd)");
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
	 * 手术方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_method_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_method_sug",  getId_method_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术方式sd属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_method_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_method_sug",  getSd_method_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术方式sd");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_method_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_method_sug",  getName_method_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客户扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_class_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_class_sug",  getId_class_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_class_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_class_sug",  getSd_class_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_class_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_class_sug",  getName_class_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperation_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation_date",  getOperation_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("手术及操作日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作id（附页）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_attach_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_attach_sug",  getId_attach_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作id（附页）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术及操作code（附页）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_attach_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_attach_sug",  getSd_attach_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作code（附页）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术及操作name（附页）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_attach_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_attach_sug",  getName_attach_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术及操作name（附页）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anes_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anes_lvl",  getId_anes_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉等级code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_anes_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anes_lvl",  getSd_anes_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉等级code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉等级name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anes_lvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anes_lvl",  getName_anes_lvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉等级name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术风险等级id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sug_risklvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sug_risklvl",  getId_sug_risklvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术风险等级id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术风险等级code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sug_risklvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sug_risklvl",  getSd_sug_risklvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术风险等级code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术风险等级name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sug_risklvlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sug_risklvl",  getName_sug_risklvlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术风险等级name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术前预防用抗菌药物id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ant_beforesugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant_beforesug",  getId_ant_beforesugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术前预防用抗菌药物id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术前预防用抗菌药物code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ant_beforesugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ant_beforesug",  getSd_ant_beforesugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术前预防用抗菌药物code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术前预防用抗菌药物name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ant_beforesugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ant_beforesug",  getName_ant_beforesugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术前预防用抗菌药物name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洁手术围术期预防用抗菌药物天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_usingdaysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_usingdays",  getAnt_usingdaysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("清洁手术围术期预防用抗菌药物天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否非预期的二次手术id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_resugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_resug",  getId_has_resugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的二次手术id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否非预期的二次手术code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_resugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_resug",  getSd_has_resugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的二次手术code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否非预期的二次手术name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_resugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_resug",  getName_has_resugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否非预期的二次手术name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有麻醉并发症id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_anescompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_anescomp",  getId_has_anescompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有麻醉并发症id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有麻醉并发症code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_anescompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_anescomp",  getSd_has_anescompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有麻醉并发症code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有麻醉并发症name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_anescompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_anescomp",  getName_has_anescompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有麻醉并发症name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有术中异物遗留id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_sugleaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_sugleave",  getId_has_sugleaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有术中异物遗留id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有术中异物遗留code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_sugleaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_sugleave",  getSd_has_sugleaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有术中异物遗留code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有术中异物遗留name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_sugleaveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_sugleave",  getName_has_sugleaveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有术中异物遗留name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有手术并发症id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_has_sugcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_has_sugcomp",  getId_has_sugcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有手术并发症id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否有手术并发症code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_has_sugcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_has_sugcomp",  getSd_has_sugcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有手术并发症code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有手术并发症name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_has_sugcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_has_sugcomp",  getName_has_sugcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否有手术并发症name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后出血或血肿id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hashem_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hashem_aftersug",  getId_hashem_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后出血或血肿id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后出血或血肿code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hashem_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hashem_aftersug",  getSd_hashem_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后出血或血肿code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后出血或血肿name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hashem_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hashem_aftersug",  getName_hashem_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后出血或血肿name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否手术伤口裂开id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_haswd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_haswd_aftersug",  getId_haswd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否手术伤口裂开id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否手术伤口裂开code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_haswd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_haswd_aftersug",  getSd_haswd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否手术伤口裂开code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否手术伤口裂开name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_haswd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_haswd_aftersug",  getName_haswd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否手术伤口裂开name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后深静脉血栓id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hasdvt_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hasdvt_aftersug",  getId_hasdvt_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后深静脉血栓id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后深静脉血栓code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hasdvt_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hasdvt_aftersug",  getSd_hasdvt_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后深静脉血栓code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后深静脉血栓name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hasdvt_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hasdvt_aftersug",  getName_hasdvt_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后深静脉血栓name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后生理/代谢紊乱id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hasmd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hasmd_aftersug",  getId_hasmd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后生理/代谢紊乱id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后生理/代谢紊乱code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hasmd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hasmd_aftersug",  getSd_hasmd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后生理/代谢紊乱code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后生理/代谢紊乱name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hasmd_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hasmd_aftersug",  getName_hasmd_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后生理/代谢紊乱name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后呼吸衰竭id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hasfor_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hasfor_aftersug",  getId_hasfor_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后呼吸衰竭id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后呼吸衰竭code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hasfor_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hasfor_aftersug",  getSd_hasfor_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后呼吸衰竭code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后呼吸衰竭name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hasfor_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hasfor_aftersug",  getName_hasfor_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后呼吸衰竭name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后肺栓塞id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_haspe_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_haspe_aftersug",  getId_haspe_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后肺栓塞id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后肺栓塞code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_haspe_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_haspe_aftersug",  getSd_haspe_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后肺栓塞code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后肺栓塞name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_haspe_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_haspe_aftersug",  getName_haspe_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后肺栓塞name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后败血症id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hashema_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hashema_aftersug",  getId_hashema_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后败血症id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后败血症code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hashema_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hashema_aftersug",  getSd_hashema_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后败血症code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后败血症name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hashema_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hashema_aftersug",  getName_hashema_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后败血症name");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后髋关节骨折id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hashf_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hashf_aftersug",  getId_hashf_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后髋关节骨折id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否术后髋关节骨折code属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hashf_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hashf_aftersug",  getSd_hashf_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后髋关节骨折code");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否术后髋关节骨折name属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hashf_aftersugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hashf_aftersug",  getName_hashf_aftersugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否术后髋关节骨折name");
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
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sug_code",  getSug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b4","id_sug=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sug_name",  getSug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b4","id_sug=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_code",  getLvlsug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_lvlsug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLvlsug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lvlsug_name",  getLvlsug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_lvlsug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sug_name",  getEmp_sug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_emp_sug=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_sug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_sug_code",  getEmp_sug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b6","id_emp_sug=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst1_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst1_name",  getEmp_asst1_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b7","id_emp_asst1=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst1_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst1_code",  getEmp_asst1_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b7","id_emp_asst1=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst2_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst2_name",  getEmp_asst2_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_emp_asst2=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_asst2_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_asst2_code",  getEmp_asst2_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","id_emp_asst2=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_anes_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_anes_name",  getEmp_anes_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_anes=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_anes_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_anes_code",  getEmp_anes_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b9","id_emp_anes=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncitp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incitp_code",  getIncitp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_incitp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncitp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incitp_name",  getIncitp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_incitp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnestp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anestp_code",  getAnestp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_anestp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnestp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anestp_name",  getAnestp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_anestp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncicondi_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incicondi_code",  getIncicondi_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_incicondi=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIncicondi_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Incicondi_name",  getIncicondi_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_incicondi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMethod_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Method_code",  getMethod_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_method_sug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMethod_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Method_name",  getMethod_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_method_sug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_class_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_class_sug",  getCode_class_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_class_sug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClass_sug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Class_sug_name",  getClass_sug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_class_sug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttach_sd_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attach_sd_sug",  getAttach_sd_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CI_MR_FP_SUG a0b18","id_attach_sug=id_mrfpsug","sd_sug"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术、操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAttach_name_sugADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Attach_name_sug",  getAttach_name_sugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术、操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CI_MR_FP_SUG a0b18","id_attach_sug=id_mrfpsug","name_sug"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_bs_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_bs_code",  getAnt_bs_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_ant_beforesug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnt_bs_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ant_bs_name",  getAnt_bs_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_ant_beforesug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_resug_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_resug_code",  getHas_resug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_has_resug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_resug_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_resug_name",  getHas_resug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_has_resug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_anescomp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_anescomp_name",  getHas_anescomp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_has_anescomp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_anescomp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_anescomp_code",  getHas_anescomp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_has_anescomp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_sugleave_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_sugleave_code",  getHas_sugleave_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_has_sugleave=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_sugleave_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_sugleave_name",  getHas_sugleave_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_has_sugleave=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_sugcomp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_sugcomp_code",  getHas_sugcomp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_has_sugcomp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHas_sugcomp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Has_sugcomp_name",  getHas_sugcomp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_has_sugcomp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashem_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashem_code",  getHashem_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_hashem_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashem_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashem_name",  getHashem_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_hashem_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHaswd_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Haswd_name",  getHaswd_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_haswd_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHaswd_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Haswd_code",  getHaswd_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_haswd_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasdvt_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasdvt_name",  getHasdvt_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_hasdvt_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasdvt_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasdvt_code",  getHasdvt_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_hasdvt_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasmd_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasmd_code",  getHasmd_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_hasmd_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasmd_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasmd_name",  getHasmd_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_hasmd_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasfor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasfor_name",  getHasfor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_hasfor_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHasfor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hasfor_code",  getHasfor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_hasfor_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHaspe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Haspe_code",  getHaspe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_haspe_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHaspe_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Haspe_name",  getHaspe_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_haspe_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashema_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashema_name",  getHashema_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_hashema_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashema_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashema_code",  getHashema_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_hashema_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashf_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashf_code",  getHashf_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_hashf_aftersug=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHashf_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hashf_name",  getHashf_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_hashf_aftersug=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院病案编目手术ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfpsug");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院病案编目手术ID"); 
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
	 * 获取住院病历首页表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病历首页"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取患者号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者号"); 
		return column;
	}
	/**
	 * 获取手术、操作编码ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作编码ID"); 
		return column;
	}
	/**
	 * 获取手术、操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作编码"); 
		return column;
	}
	/**
	 * 获取手术、操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作名称"); 
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
	 * 获取手术级别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvlsugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvlsug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术级别名称"); 
		return column;
	}
	/**
	 * 获取手术及操作开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_start_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_start_sug");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术及操作开始时间"); 
		return column;
	}
	/**
	 * 获取手术、操作结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_sug");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术、操作结束时间"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_术者名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_术者名称"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_asst1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_asst1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_I助名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_asst1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_asst1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_I助名称"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_asst2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_asst2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助编码"); 
		return column;
	}
	/**
	 * 获取手术及操作医师_II助名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_asst2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_asst2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作医师_II助名称"); 
		return column;
	}
	/**
	 * 获取麻醉医师表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_anes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师"); 
		return column;
	}
	/**
	 * 获取麻醉医师编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emp_anes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师编码"); 
		return column;
	}
	/**
	 * 获取麻醉医师名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_anesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_anes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉医师名称"); 
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
	 * 获取切口等级名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incitpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incitp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口等级名称"); 
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
	 * 获取麻醉方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anestpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anestp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取切口愈合情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_incicondi");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况"); 
		return column;
	}
	/**
	 * 获取切口愈合情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_incicondi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况编码"); 
		return column;
	}
	/**
	 * 获取切口愈合情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_incicondiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_incicondi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("切口愈合情况名称"); 
		return column;
	}
	/**
	 * 获取是否有并发症(id)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fg_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fg_complication");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有并发症(id)"); 
		return column;
	}
	/**
	 * 获取是否有并发症(name)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fg_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fg_complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有并发症(name)"); 
		return column;
	}
	/**
	 * 获取是否有并发症(sd)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fg_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fg_complication");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有并发症(sd)"); 
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
	 * 获取手术方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_method_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_method_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术方式id"); 
		return column;
	}
	/**
	 * 获取手术方式sd表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_method_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_method_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术方式sd"); 
		return column;
	}
	/**
	 * 获取手术方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_method_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_method_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术方式"); 
		return column;
	}
	/**
	 * 获取客户扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段1"); 
		return column;
	}
	/**
	 * 获取客户扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段2"); 
		return column;
	}
	/**
	 * 获取客户扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段3"); 
		return column;
	}
	/**
	 * 获取客户扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段4"); 
		return column;
	}
	/**
	 * 获取客户扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户扩展字段5"); 
		return column;
	}
	/**
	 * 获取手术类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_class_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_class_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别"); 
		return column;
	}
	/**
	 * 获取手术类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_class_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_class_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别编码"); 
		return column;
	}
	/**
	 * 获取手术类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_class_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_class_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别名称"); 
		return column;
	}
	/**
	 * 获取手术及操作日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperation_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术及操作日期"); 
		return column;
	}
	/**
	 * 获取手术及操作id（附页）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_attach_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_attach_sug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作id（附页）"); 
		return column;
	}
	/**
	 * 获取手术及操作code（附页）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_attach_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_attach_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作code（附页）"); 
		return column;
	}
	/**
	 * 获取手术及操作name（附页）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_attach_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_attach_sug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术及操作name（附页）"); 
		return column;
	}
	/**
	 * 获取麻醉等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anes_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anes_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉等级id"); 
		return column;
	}
	/**
	 * 获取麻醉等级code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anes_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anes_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉等级code"); 
		return column;
	}
	/**
	 * 获取麻醉等级name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anes_lvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anes_lvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉等级name"); 
		return column;
	}
	/**
	 * 获取手术风险等级id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sug_risklvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sug_risklvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术风险等级id"); 
		return column;
	}
	/**
	 * 获取手术风险等级code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sug_risklvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sug_risklvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术风险等级code"); 
		return column;
	}
	/**
	 * 获取手术风险等级name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sug_risklvlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sug_risklvl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术风险等级name"); 
		return column;
	}
	/**
	 * 获取是否术前预防用抗菌药物id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ant_beforesugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant_beforesug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术前预防用抗菌药物id"); 
		return column;
	}
	/**
	 * 获取是否术前预防用抗菌药物code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ant_beforesugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ant_beforesug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术前预防用抗菌药物code"); 
		return column;
	}
	/**
	 * 获取是否术前预防用抗菌药物name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ant_beforesugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ant_beforesug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术前预防用抗菌药物name"); 
		return column;
	}
	/**
	 * 获取清洁手术围术期预防用抗菌药物天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_usingdaysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_usingdays");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("清洁手术围术期预防用抗菌药物天数"); 
		return column;
	}
	/**
	 * 获取是否非预期的二次手术id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_resugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_resug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的二次手术id"); 
		return column;
	}
	/**
	 * 获取是否非预期的二次手术code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_resugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_resug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的二次手术code"); 
		return column;
	}
	/**
	 * 获取是否非预期的二次手术name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_resugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_resug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否非预期的二次手术name"); 
		return column;
	}
	/**
	 * 获取是否有麻醉并发症id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_anescompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_anescomp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有麻醉并发症id"); 
		return column;
	}
	/**
	 * 获取是否有麻醉并发症code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_anescompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_anescomp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有麻醉并发症code"); 
		return column;
	}
	/**
	 * 获取是否有麻醉并发症name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_anescompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_anescomp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有麻醉并发症name"); 
		return column;
	}
	/**
	 * 获取是否有术中异物遗留id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_sugleaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_sugleave");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有术中异物遗留id"); 
		return column;
	}
	/**
	 * 获取是否有术中异物遗留code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_sugleaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_sugleave");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有术中异物遗留code"); 
		return column;
	}
	/**
	 * 获取是否有术中异物遗留name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_sugleaveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_sugleave");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有术中异物遗留name"); 
		return column;
	}
	/**
	 * 获取是否有手术并发症id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_has_sugcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_has_sugcomp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有手术并发症id"); 
		return column;
	}
	/**
	 * 获取是否有手术并发症code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_has_sugcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_has_sugcomp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有手术并发症code"); 
		return column;
	}
	/**
	 * 获取是否有手术并发症name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_has_sugcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_has_sugcomp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否有手术并发症name"); 
		return column;
	}
	/**
	 * 获取是否术后出血或血肿id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hashem_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hashem_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后出血或血肿id"); 
		return column;
	}
	/**
	 * 获取是否术后出血或血肿code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hashem_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hashem_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后出血或血肿code"); 
		return column;
	}
	/**
	 * 获取是否术后出血或血肿name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hashem_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hashem_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后出血或血肿name"); 
		return column;
	}
	/**
	 * 获取是否手术伤口裂开id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_haswd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_haswd_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否手术伤口裂开id"); 
		return column;
	}
	/**
	 * 获取是否手术伤口裂开code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_haswd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_haswd_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否手术伤口裂开code"); 
		return column;
	}
	/**
	 * 获取是否手术伤口裂开name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_haswd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_haswd_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否手术伤口裂开name"); 
		return column;
	}
	/**
	 * 获取是否术后深静脉血栓id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hasdvt_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hasdvt_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后深静脉血栓id"); 
		return column;
	}
	/**
	 * 获取是否术后深静脉血栓code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hasdvt_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hasdvt_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后深静脉血栓code"); 
		return column;
	}
	/**
	 * 获取是否术后深静脉血栓name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hasdvt_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hasdvt_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后深静脉血栓name"); 
		return column;
	}
	/**
	 * 获取是否术后生理/代谢紊乱id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hasmd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hasmd_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后生理/代谢紊乱id"); 
		return column;
	}
	/**
	 * 获取是否术后生理/代谢紊乱code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hasmd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hasmd_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后生理/代谢紊乱code"); 
		return column;
	}
	/**
	 * 获取是否术后生理/代谢紊乱name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hasmd_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hasmd_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后生理/代谢紊乱name"); 
		return column;
	}
	/**
	 * 获取是否术后呼吸衰竭id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hasfor_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hasfor_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后呼吸衰竭id"); 
		return column;
	}
	/**
	 * 获取是否术后呼吸衰竭code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hasfor_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hasfor_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后呼吸衰竭code"); 
		return column;
	}
	/**
	 * 获取是否术后呼吸衰竭name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hasfor_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hasfor_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后呼吸衰竭name"); 
		return column;
	}
	/**
	 * 获取是否术后肺栓塞id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_haspe_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_haspe_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后肺栓塞id"); 
		return column;
	}
	/**
	 * 获取是否术后肺栓塞code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_haspe_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_haspe_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后肺栓塞code"); 
		return column;
	}
	/**
	 * 获取是否术后肺栓塞name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_haspe_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_haspe_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后肺栓塞name"); 
		return column;
	}
	/**
	 * 获取是否术后败血症id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hashema_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hashema_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后败血症id"); 
		return column;
	}
	/**
	 * 获取是否术后败血症code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hashema_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hashema_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后败血症code"); 
		return column;
	}
	/**
	 * 获取是否术后败血症name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hashema_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hashema_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后败血症name"); 
		return column;
	}
	/**
	 * 获取是否术后髋关节骨折id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hashf_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hashf_aftersug");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后髋关节骨折id"); 
		return column;
	}
	/**
	 * 获取是否术后髋关节骨折code表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hashf_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hashf_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后髋关节骨折code"); 
		return column;
	}
	/**
	 * 获取是否术后髋关节骨折name表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hashf_aftersugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hashf_aftersug");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否术后髋关节骨折name"); 
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
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sug_code");
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
	private IColumnDesc getSug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLvlsug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_code");
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
	private IColumnDesc getLvlsug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lvlsug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_sug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_sug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_sug_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst1_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst1_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst1_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst1_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst2_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst2_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_asst2_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_asst2_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_anes_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_anes_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_anes_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_anes_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIncitp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incitp_code");
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
	private IColumnDesc getIncitp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incitp_name");
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
	private IColumnDesc getAnestp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anestp_code");
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
	private IColumnDesc getAnestp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anestp_name");
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
	private IColumnDesc getIncicondi_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incicondi_code");
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
	private IColumnDesc getIncicondi_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Incicondi_name");
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
	private IColumnDesc getMethod_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Method_code");
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
	private IColumnDesc getMethod_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Method_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取手术类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_class_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_class_sug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别编码"); 
		return column;
	}
	/**
	 * 获取手术类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClass_sug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Class_sug_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术类别名称"); 
		return column;
	}
	/**
	 * 获取手术、操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttach_sd_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attach_sd_sug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作编码"); 
		return column;
	}
	/**
	 * 获取手术、操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAttach_name_sugCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Attach_name_sug");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术、操作名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnt_bs_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_bs_code");
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
	private IColumnDesc getAnt_bs_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ant_bs_name");
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
	private IColumnDesc getHas_resug_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_resug_code");
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
	private IColumnDesc getHas_resug_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_resug_name");
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
	private IColumnDesc getHas_anescomp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_anescomp_name");
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
	private IColumnDesc getHas_anescomp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_anescomp_code");
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
	private IColumnDesc getHas_sugleave_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_sugleave_code");
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
	private IColumnDesc getHas_sugleave_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_sugleave_name");
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
	private IColumnDesc getHas_sugcomp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_sugcomp_code");
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
	private IColumnDesc getHas_sugcomp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Has_sugcomp_name");
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
	private IColumnDesc getHashem_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashem_code");
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
	private IColumnDesc getHashem_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashem_name");
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
	private IColumnDesc getHaswd_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Haswd_name");
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
	private IColumnDesc getHaswd_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Haswd_code");
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
	private IColumnDesc getHasdvt_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasdvt_name");
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
	private IColumnDesc getHasdvt_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasdvt_code");
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
	private IColumnDesc getHasmd_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasmd_code");
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
	private IColumnDesc getHasmd_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasmd_name");
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
	private IColumnDesc getHasfor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasfor_name");
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
	private IColumnDesc getHasfor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hasfor_code");
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
	private IColumnDesc getHaspe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Haspe_code");
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
	private IColumnDesc getHaspe_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Haspe_name");
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
	private IColumnDesc getHashema_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashema_name");
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
	private IColumnDesc getHashema_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashema_code");
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
	private IColumnDesc getHashf_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashf_code");
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
	private IColumnDesc getHashf_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hashf_name");
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
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
