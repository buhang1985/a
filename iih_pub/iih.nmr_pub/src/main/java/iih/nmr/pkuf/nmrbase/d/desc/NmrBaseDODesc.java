
package iih.nmr.pkuf.nmrbase.d.desc;

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
 * 文书基础信息 DO 元数据信息
 */
public class NmrBaseDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.nmrbase.d.NmrBaseDO";
	public static final String CLASS_DISPALYNAME = "文书基础信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_BASE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nmr_base";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmrBaseDODesc(){
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
		this.setKeyDesc(getId_nmr_baseADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nmr_baseADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_owntpADesc(tblDesc));
		this.add(getSd_owntpADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getId_setADesc(tblDesc));
		this.add(getId_funADesc(tblDesc));
		this.add(getFun_codeADesc(tblDesc));
		this.add(getFg_multyADesc(tblDesc));
		this.add(getFg_prnt_singleADesc(tblDesc));
		this.add(getPath_rtpfileADesc(tblDesc));
		this.add(getId_nmr_doccaADesc(tblDesc));
		this.add(getId_classADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_formsADesc(tblDesc));
		this.add(getId_classesADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getDef4ADesc(tblDesc));
		this.add(getDef5ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_owntpADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
		this.add(getName_setADesc(tblDesc));
		this.add(getName_funADesc(tblDesc));
		this.add(getName_nmr_doccaADesc(tblDesc));
		this.add(getName_classADesc(tblDesc));
		this.add(getFullclassnameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nmr_baseCDesc(tblDesc));
		tblDesc.add(getId_nmr_baseCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_owntpCDesc(tblDesc));
		tblDesc.add(getSd_owntpCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getId_setCDesc(tblDesc));
		tblDesc.add(getId_funCDesc(tblDesc));
		tblDesc.add(getFun_codeCDesc(tblDesc));
		tblDesc.add(getFg_multyCDesc(tblDesc));
		tblDesc.add(getFg_prnt_singleCDesc(tblDesc));
		tblDesc.add(getPath_rtpfileCDesc(tblDesc));
		tblDesc.add(getId_nmr_doccaCDesc(tblDesc));
		tblDesc.add(getId_classCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_formsCDesc(tblDesc));
		tblDesc.add(getId_classesCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getDef4CDesc(tblDesc));
		tblDesc.add(getDef5CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 文书主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nmr_baseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nmr_base",  getId_nmr_baseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文书主键标识");
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
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
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_owntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_owntp",  getId_owntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_owntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_owntp",  getSd_owntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据集属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_set",  getId_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据集");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 功能id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fun",  getId_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 功能编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFun_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fun_code",  getFun_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 多次采集属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_multyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_multy",  getFg_multyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("多次采集");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单次打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnt_singleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prnt_single",  getFg_prnt_singleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("单次打印标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报表路径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPath_rtpfileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Path_rtpfile",  getPath_rtpfileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("报表路径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文书分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nmr_doccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nmr_docca",  getId_nmr_doccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文书分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_class",  getId_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_formsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_forms",  getId_formsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元数据组件ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_classesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_classes",  getId_classesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元数据组件ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def1",  getDef1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def2",  getDef2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def3",  getDef3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def4",  getDef4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def5",  getDef5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段5");
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
	 * 所属类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_owntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_owntp",  getName_owntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_owntp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep=id_dep","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_set a0b6","id_set=id_set","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 功能名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_funADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fun",  getName_funCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("功能名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_funcreg a0b7","id_fun=id_fun","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文书分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nmr_doccaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nmr_docca",  getName_nmr_doccaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文书分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NMR_DOCCA a0b8","id_nmr_docca=id_nmr_docca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_classADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_class",  getName_classCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"dm_class a0b9","id_class=id","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 类全路径名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFullclassnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fullclassname",  getFullclassnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("类全路径名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"dm_class a0b9","id_class=id","fullclassname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取文书主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nmr_baseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nmr_base");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("文书主键标识"); 
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
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
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取所属类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_owntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_owntp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型"); 
		return column;
	}
	/**
	 * 获取所属类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_owntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_owntp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型编码"); 
		return column;
	}
	/**
	 * 获取所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属科室"); 
		return column;
	}
	/**
	 * 获取数据集表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_set");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据集"); 
		return column;
	}
	/**
	 * 获取功能id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fun");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能id"); 
		return column;
	}
	/**
	 * 获取功能编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFun_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fun_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能编码"); 
		return column;
	}
	/**
	 * 获取多次采集表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_multyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_multy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("多次采集"); 
		return column;
	}
	/**
	 * 获取单次打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prnt_singleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prnt_single");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("单次打印标识"); 
		return column;
	}
	/**
	 * 获取报表路径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPath_rtpfileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Path_rtpfile");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("报表路径"); 
		return column;
	}
	/**
	 * 获取文书分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nmr_doccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nmr_docca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文书分类"); 
		return column;
	}
	/**
	 * 获取组件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_class");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取表单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_formsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_forms");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("表单ID"); 
		return column;
	}
	/**
	 * 获取元数据组件ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_classesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_classes");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元数据组件ID"); 
		return column;
	}
	/**
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段1"); 
		return column;
	}
	/**
	 * 获取扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def2");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段2"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def3");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def4");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段4"); 
		return column;
	}
	/**
	 * 获取扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def5");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段5"); 
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
	 * 获取所属类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_owntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_owntp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类型名称"); 
		return column;
	}
	/**
	 * 获取所属部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属部门"); 
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
	 * 获取功能名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_funCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fun");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("功能名称"); 
		return column;
	}
	/**
	 * 获取文书分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nmr_doccaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nmr_docca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文书分类名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_classCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_class");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取类全路径名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFullclassnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fullclassname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("类全路径名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
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
