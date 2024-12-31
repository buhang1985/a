
package iih.bd.bs.ctmitfrel.d.desc;

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
 * 客开接口实现关系 DO 元数据信息
 */
public class CtmItfRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.bs.ctmitfrel.d.CtmItfRelDO";
	public static final String CLASS_DISPALYNAME = "客开接口实现关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_itf_ctm_rel";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ctmitfrel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CtmItfRelDODesc(){
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
		this.setKeyDesc(getId_ctmitfrelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_ctmitfrelADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_ctmitfADesc(tblDesc));
		this.add(getDllname_itfADesc(tblDesc));
		this.add(getClassname_itfADesc(tblDesc));
		this.add(getId_ctmimplADesc(tblDesc));
		this.add(getEu_impltypeADesc(tblDesc));
		this.add(getDllname_implADesc(tblDesc));
		this.add(getModulename_implADesc(tblDesc));
		this.add(getClassname_implADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getNote_ctmitfADesc(tblDesc));
		this.add(getName_itfADesc(tblDesc));
		this.add(getCode_itfADesc(tblDesc));
		this.add(getName_implADesc(tblDesc));
		this.add(getCode_implADesc(tblDesc));
		this.add(getNote_implADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ctmitfrelCDesc(tblDesc));
		tblDesc.add(getId_ctmitfrelCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_ctmitfCDesc(tblDesc));
		tblDesc.add(getDllname_itfCDesc(tblDesc));
		tblDesc.add(getClassname_itfCDesc(tblDesc));
		tblDesc.add(getId_ctmimplCDesc(tblDesc));
		tblDesc.add(getEu_impltypeCDesc(tblDesc));
		tblDesc.add(getDllname_implCDesc(tblDesc));
		tblDesc.add(getModulename_implCDesc(tblDesc));
		tblDesc.add(getClassname_implCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 客开接口实现关系主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctmitfrelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctmitfrel",  getId_ctmitfrelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开接口实现关系主键");
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
	 * 客开接口主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctmitfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctmitf",  getId_ctmitfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开接口主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 接口动态库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDllname_itfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dllname_itf",  getDllname_itfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口动态库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口全类名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClassname_itfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Classname_itf",  getClassname_itfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口全类名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 客开实现主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ctmimplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ctmimpl",  getId_ctmimplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客开实现主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实现类类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_impltypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_impltype",  getEu_impltypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 实现类动态库名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDllname_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dllname_impl",  getDllname_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类动态库名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实现模块名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModulename_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modulename_impl",  getModulename_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现模块名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实现类全类名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getClassname_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Classname_impl",  getClassname_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类全类名");
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
	 * 接口备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_ctmitfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_ctmitf",  getNote_ctmitfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_itf_ctm a0b4","id_ctmitf=id_ctmitf","note"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_itfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_itf",  getName_itfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_itf_ctm a0b4","id_ctmitf=id_ctmitf","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接口编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_itfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_itf",  getCode_itfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接口编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_itf_ctm a0b4","id_ctmitf=id_ctmitf","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实现类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_impl",  getName_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_ctm_impl a0b5","id_ctmimpl=id_ctmimpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实现类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_impl",  getCode_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_ctm_impl a0b5","id_ctmimpl=id_ctmimpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 实现类备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_implADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_impl",  getNote_implCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("实现类备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_ctm_impl a0b5","id_ctmimpl=id_ctmimpl","note"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取客开接口实现关系主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctmitfrelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctmitfrel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("客开接口实现关系主键"); 
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
	 * 获取客开接口主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctmitfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctmitf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开接口主键"); 
		return column;
	}
	/**
	 * 获取接口动态库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDllname_itfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dllname_itf");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口动态库名称"); 
		return column;
	}
	/**
	 * 获取接口全类名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClassname_itfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Classname_itf");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口全类名"); 
		return column;
	}
	/**
	 * 获取客开实现主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ctmimplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ctmimpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客开实现主键"); 
		return column;
	}
	/**
	 * 获取实现类类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_impltypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_impltype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类类型"); 
		return column;
	}
	/**
	 * 获取实现类动态库名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDllname_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dllname_impl");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类动态库名称"); 
		return column;
	}
	/**
	 * 获取实现模块名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModulename_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modulename_impl");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现模块名称"); 
		return column;
	}
	/**
	 * 获取实现类全类名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getClassname_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Classname_impl");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类全类名"); 
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
	 * 获取接口备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_ctmitfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_ctmitf");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口备注"); 
		return column;
	}
	/**
	 * 获取接口名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_itfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_itf");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口名称"); 
		return column;
	}
	/**
	 * 获取接口编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_itfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_itf");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接口编码"); 
		return column;
	}
	/**
	 * 获取实现类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_impl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类名称"); 
		return column;
	}
	/**
	 * 获取实现类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_impl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类编码"); 
		return column;
	}
	/**
	 * 获取实现类备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_implCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_impl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("实现类备注"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_ctmitfrel");
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
