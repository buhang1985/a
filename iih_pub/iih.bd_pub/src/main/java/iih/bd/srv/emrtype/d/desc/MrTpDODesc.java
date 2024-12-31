
package iih.bd.srv.emrtype.d.desc;

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
 * 医疗记录类型 DO 元数据信息
 */
public class MrTpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.emrtype.d.MrTpDO";
	public static final String CLASS_DISPALYNAME = "医疗记录类型";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrtp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrtp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrTpDODesc(){
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
		this.setKeyDesc(getId_mrtpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCd_stdADesc(tblDesc));
		this.add(getId_data_setADesc(tblDesc));
		this.add(getMr_sign_lvl_cdADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_parentADesc(tblDesc));
		this.add(getInnercodeADesc(tblDesc));
		this.add(getDef_func_edtor_arguADesc(tblDesc));
		this.add(getId_mredADesc(tblDesc));
		this.add(getId_mrfmtpADesc(tblDesc));
		this.add(getSd_mrfmtpADesc(tblDesc));
		this.add(getId_mrtplstmdADesc(tblDesc));
		this.add(getSd_mrtplstmdADesc(tblDesc));
		this.add(getFg_systemADesc(tblDesc));
		this.add(getFg_onlyADesc(tblDesc));
		this.add(getFg_new_pageADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_ownertpADesc(tblDesc));
		this.add(getSd_ownertpADesc(tblDesc));
		this.add(getId_mr_entpADesc(tblDesc));
		this.add(getSd_mr_entpADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCode_setADesc(tblDesc));
		this.add(getName_setADesc(tblDesc));
		this.add(getSign_codeADesc(tblDesc));
		this.add(getSign_nameADesc(tblDesc));
		this.add(getSign_flowtypeADesc(tblDesc));
		this.add(getEmrtp_codeADesc(tblDesc));
		this.add(getEmrtp_nameADesc(tblDesc));
		this.add(getEditor_codeADesc(tblDesc));
		this.add(getEditor_nameADesc(tblDesc));
		this.add(getEmr_dllpathADesc(tblDesc));
		this.add(getEmr_funceditorADesc(tblDesc));
		this.add(getEmr_nameclassADesc(tblDesc));
		this.add(getMrf_codeADesc(tblDesc));
		this.add(getMrf_nameADesc(tblDesc));
		this.add(getTpl_codeADesc(tblDesc));
		this.add(getTpl_nameADesc(tblDesc));
		this.add(getMr_entp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCd_stdCDesc(tblDesc));
		tblDesc.add(getId_data_setCDesc(tblDesc));
		tblDesc.add(getMr_sign_lvl_cdCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_parentCDesc(tblDesc));
		tblDesc.add(getInnercodeCDesc(tblDesc));
		tblDesc.add(getDef_func_edtor_arguCDesc(tblDesc));
		tblDesc.add(getId_mredCDesc(tblDesc));
		tblDesc.add(getId_mrfmtpCDesc(tblDesc));
		tblDesc.add(getSd_mrfmtpCDesc(tblDesc));
		tblDesc.add(getId_mrtplstmdCDesc(tblDesc));
		tblDesc.add(getSd_mrtplstmdCDesc(tblDesc));
		tblDesc.add(getFg_systemCDesc(tblDesc));
		tblDesc.add(getFg_onlyCDesc(tblDesc));
		tblDesc.add(getFg_new_pageCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_ownertpCDesc(tblDesc));
		tblDesc.add(getSd_ownertpCDesc(tblDesc));
		tblDesc.add(getId_mr_entpCDesc(tblDesc));
		tblDesc.add(getSd_mr_entpCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医疗记录类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型");
		attrDesc.setNullable(false);
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
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型国家编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCd_stdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cd_std",  getCd_stdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型国家编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据集ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_data_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_data_set",  getId_data_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历文书审签级别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_sign_lvl_cdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_sign_lvl_cd",  getMr_sign_lvl_cdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历文书审签级别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 五笔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拼音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
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
	 * 父级主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_parent",  getId_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("父级主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 内部编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInnercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Innercode",  getInnercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("内部编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认编辑器启用参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_func_edtor_arguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_func_edtor_argu",  getDef_func_edtor_arguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认编辑器启用参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认对应医疗记录编辑器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mredADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mred",  getId_mredCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认对应医疗记录编辑器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认医疗记录格式类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrfmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrfmtp",  getId_mrfmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认医疗记录格式类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认医疗记录格式类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrfmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrfmtp",  getSd_mrfmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认医疗记录格式类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认医疗记录存储模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtplstmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtplstmd",  getId_mrtplstmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认医疗记录存储模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 默认医疗记录存储模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrtplstmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrtplstmd",  getSd_mrtplstmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("默认医疗记录存储模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 系统标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_systemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_system",  getFg_systemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("系统标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 仅有标记（1 一份，0多分）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_onlyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_only",  getFg_onlyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("仅有标记（1 一份，0多分）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 另起打印标记（1 另起，0 不另起）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_new_pageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_new_page",  getFg_new_pageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("另起打印标记（1 另起，0 不另起）");
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
	 * 所有者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ownertpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ownertp",  getId_ownertpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所有者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所有者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ownertpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ownertp",  getSd_ownertpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所有者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_entp",  getId_mr_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mr_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mr_entp",  getSd_mr_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历就诊类型编码");
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
	 * 数据集编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_set",  getCode_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a0b10","id_data_set=id_set","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据集名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_set",  getName_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_set a0b10","id_data_set=id_set","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_code",  getSign_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b11","mr_sign_lvl_cd=id_reviewtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_name",  getSign_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b11","mr_sign_lvl_cd=id_reviewtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审批流类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSign_flowtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sign_flowtype",  getSign_flowtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审批流类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_reviewtp a0b11","mr_sign_lvl_cd=id_reviewtp","id_flowtype"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmrtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emrtp_code",  getEmrtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b3","id_parent=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmrtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emrtp_name",  getEmrtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b3","id_parent=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEditor_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Editor_code",  getEditor_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEditor_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Editor_name",  getEditor_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * DLL全路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmr_dllpathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emr_dllpath",  getEmr_dllpathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("DLL全路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","dll_path"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器启动函数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmr_funceditorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emr_funceditor",  getEmr_funceditorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器启动函数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","func_editor"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编辑器函数类名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmr_nameclassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emr_nameclass",  getEmr_nameclassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编辑器函数类名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mred a0b4","id_mred=id_mred","name_class"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrf_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrf_code",  getMrf_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_mrfmtp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrf_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrf_name",  getMrf_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_mrfmtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTpl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tpl_code",  getTpl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_mrtplstmd=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tpl_name",  getTpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_mrtplstmd=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_entp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_entp_name",  getMr_entp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_mr_entp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医疗记录类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型"); 
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
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
		return column;
	}
	/**
	 * 获取医疗记录类型国家编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCd_stdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cd_std");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型国家编码"); 
		return column;
	}
	/**
	 * 获取数据集ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_data_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_data_set");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集ID"); 
		return column;
	}
	/**
	 * 获取病历文书审签级别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_sign_lvl_cdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_sign_lvl_cd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历文书审签级别编码"); 
		return column;
	}
	/**
	 * 获取五笔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔"); 
		return column;
	}
	/**
	 * 获取拼音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(30);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
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
	 * 获取父级主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_parent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("父级主键"); 
		return column;
	}
	/**
	 * 获取内部编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInnercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Innercode");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("内部编码"); 
		return column;
	}
	/**
	 * 获取默认编辑器启用参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_func_edtor_arguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_func_edtor_argu");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认编辑器启用参数"); 
		return column;
	}
	/**
	 * 获取默认对应医疗记录编辑器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mredCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mred");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认对应医疗记录编辑器"); 
		return column;
	}
	/**
	 * 获取默认医疗记录格式类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrfmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrfmtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认医疗记录格式类型"); 
		return column;
	}
	/**
	 * 获取默认医疗记录格式类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrfmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrfmtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认医疗记录格式类型编码"); 
		return column;
	}
	/**
	 * 获取默认医疗记录存储模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtplstmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtplstmd");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认医疗记录存储模式"); 
		return column;
	}
	/**
	 * 获取默认医疗记录存储模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrtplstmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrtplstmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("默认医疗记录存储模式编码"); 
		return column;
	}
	/**
	 * 获取系统标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_systemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_system");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("系统标识"); 
		return column;
	}
	/**
	 * 获取仅有标记（1 一份，0多分）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_onlyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_only");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("仅有标记（1 一份，0多分）"); 
		return column;
	}
	/**
	 * 获取另起打印标记（1 另起，0 不另起）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_new_pageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_new_page");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("另起打印标记（1 另起，0 不另起）"); 
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
	 * 获取所有者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ownertpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ownertp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所有者"); 
		return column;
	}
	/**
	 * 获取所有者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ownertpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ownertp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所有者编码"); 
		return column;
	}
	/**
	 * 获取病历就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历就诊类型"); 
		return column;
	}
	/**
	 * 获取病历就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mr_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mr_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历就诊类型编码"); 
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
	 * 获取数据集编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_set");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集编码"); 
		return column;
	}
	/**
	 * 获取数据集名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_set");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_code");
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
	private IColumnDesc getSign_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取审批流类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSign_flowtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sign_flowtype");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审批流类型"); 
		return column;
	}
	/**
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmrtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emrtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmrtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emrtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
		return column;
	}
	/**
	 * 获取编辑器编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEditor_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Editor_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器编码"); 
		return column;
	}
	/**
	 * 获取编辑器名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEditor_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Editor_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器名称"); 
		return column;
	}
	/**
	 * 获取DLL全路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmr_dllpathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emr_dllpath");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("DLL全路径"); 
		return column;
	}
	/**
	 * 获取编辑器启动函数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmr_funceditorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emr_funceditor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器启动函数"); 
		return column;
	}
	/**
	 * 获取编辑器函数类名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmr_nameclassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emr_nameclass");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编辑器函数类名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrf_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrf_code");
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
	private IColumnDesc getMrf_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrf_name");
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
	private IColumnDesc getTpl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tpl_code");
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
	private IColumnDesc getTpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取病历就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_entp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_entp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历就诊类型名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_mrtp");
		iBDDataInfoFldMap.put("pid","Id_parent");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Mnecode");
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
	
}
