
package iih.ci.mrm.healthsystem.d.desc;

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
 * 字段转换 DO 元数据信息
 */
public class FieldContrastDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.healthsystem.d.FieldContrastDO";
	public static final String CLASS_DISPALYNAME = "字段转换";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_field_contrast";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_field_comparison";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public FieldContrastDODesc(){
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
		this.setKeyDesc(getId_field_comparisonADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_field_comparisonADesc(tblDesc));
		this.add(getId_doc_comparisonADesc(tblDesc));
		this.add(getFieldcode_sourceADesc(tblDesc));
		this.add(getFieldname_sourceADesc(tblDesc));
		this.add(getFieldtype_sourceADesc(tblDesc));
		this.add(getFieldcode_goalADesc(tblDesc));
		this.add(getFieldname_goalADesc(tblDesc));
		this.add(getFieldtype_goalADesc(tblDesc));
		this.add(getFieldsize_goalADesc(tblDesc));
		this.add(getFg_id_goalADesc(tblDesc));
		this.add(getFg_null_goalADesc(tblDesc));
		this.add(getInitdata_goalADesc(tblDesc));
		this.add(getId_value_comparisonADesc(tblDesc));
		this.add(getSd_value_comparisonADesc(tblDesc));
		this.add(getName_value_comparisonADesc(tblDesc));
		this.add(getFg_stopADesc(tblDesc));
		this.add(getTransform_modeADesc(tblDesc));
		this.add(getSerial_numberADesc(tblDesc));
		this.add(getTablename_sourceADesc(tblDesc));
		this.add(getValue_codeADesc(tblDesc));
		this.add(getValue_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_field_comparisonCDesc(tblDesc));
		tblDesc.add(getId_field_comparisonCDesc(tblDesc));
		tblDesc.add(getId_doc_comparisonCDesc(tblDesc));
		tblDesc.add(getFieldcode_sourceCDesc(tblDesc));
		tblDesc.add(getFieldname_sourceCDesc(tblDesc));
		tblDesc.add(getFieldtype_sourceCDesc(tblDesc));
		tblDesc.add(getFieldcode_goalCDesc(tblDesc));
		tblDesc.add(getFieldname_goalCDesc(tblDesc));
		tblDesc.add(getFieldtype_goalCDesc(tblDesc));
		tblDesc.add(getFieldsize_goalCDesc(tblDesc));
		tblDesc.add(getFg_id_goalCDesc(tblDesc));
		tblDesc.add(getFg_null_goalCDesc(tblDesc));
		tblDesc.add(getInitdata_goalCDesc(tblDesc));
		tblDesc.add(getId_value_comparisonCDesc(tblDesc));
		tblDesc.add(getSd_value_comparisonCDesc(tblDesc));
		tblDesc.add(getName_value_comparisonCDesc(tblDesc));
		tblDesc.add(getFg_stopCDesc(tblDesc));
		tblDesc.add(getTransform_modeCDesc(tblDesc));
		tblDesc.add(getSerial_numberCDesc(tblDesc));
		tblDesc.add(getTablename_sourceCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 字段转换主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_field_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_field_comparison",  getId_field_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段转换主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 表转换外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_comparison",  getId_doc_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表转换外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 字段编码_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldcode_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldcode_source",  getFieldcode_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段编码_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 字段名称_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldname_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldname_source",  getFieldname_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段名称_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 字段类型_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldtype_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldtype_source",  getFieldtype_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段类型_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 字段编码_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldcode_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldcode_goal",  getFieldcode_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段编码_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 字段名称_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldname_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldname_goal",  getFieldname_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段名称_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 字段类型_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldtype_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldtype_goal",  getFieldtype_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("字段类型_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 字段长度_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFieldsize_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fieldsize_goal",  getFieldsize_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("字段长度_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否主键标识_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_id_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_id_goal",  getFg_id_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否主键标识_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否允许为空_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_null_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_null_goal",  getFg_null_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许为空_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 初始值_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInitdata_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Initdata_goal",  getInitdata_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("初始值_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转换对照外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_value_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_value_comparison",  getId_value_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转换对照外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对照编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_value_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_value_comparison",  getSd_value_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_value_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_value_comparison",  getName_value_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失败是否终止任务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stop",  getFg_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("失败是否终止任务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转换方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTransform_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Transform_mode",  getTransform_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转换方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSerial_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Serial_number",  getSerial_numberCDesc(tblDesc), this);
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
	 * 表名称_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTablename_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tablename_source",  getTablename_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表名称_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_code",  getValue_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_value_contrast a0b3","id_value_comparison=id_value_comparison","sd_value_comparison"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_name",  getValue_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_mrm_value_contrast a0b3","id_value_comparison=id_value_comparison","name_value_comparison"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取字段转换主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_field_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_field_comparison");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("字段转换主键"); 
		return column;
	}
	/**
	 * 获取表转换外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_comparison");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("表转换外键"); 
		return column;
	}
	/**
	 * 获取字段编码_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldcode_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldcode_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段编码_源"); 
		return column;
	}
	/**
	 * 获取字段名称_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldname_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldname_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段名称_源"); 
		return column;
	}
	/**
	 * 获取字段类型_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldtype_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldtype_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段类型_源"); 
		return column;
	}
	/**
	 * 获取字段编码_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldcode_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldcode_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段编码_目标"); 
		return column;
	}
	/**
	 * 获取字段名称_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldname_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldname_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段名称_目标"); 
		return column;
	}
	/**
	 * 获取字段类型_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldtype_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldtype_goal");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("字段类型_目标"); 
		return column;
	}
	/**
	 * 获取字段长度_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFieldsize_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fieldsize_goal");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("字段长度_目标"); 
		return column;
	}
	/**
	 * 获取是否主键标识_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_id_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_id_goal");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否主键标识_目标"); 
		return column;
	}
	/**
	 * 获取是否允许为空_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_null_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_null_goal");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许为空_目标"); 
		return column;
	}
	/**
	 * 获取初始值_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInitdata_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Initdata_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("初始值_目标"); 
		return column;
	}
	/**
	 * 获取转换对照外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_value_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_value_comparison");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转换对照外键"); 
		return column;
	}
	/**
	 * 获取对照编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_value_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_value_comparison");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码"); 
		return column;
	}
	/**
	 * 获取对照名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_value_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_value_comparison");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照名称"); 
		return column;
	}
	/**
	 * 获取失败是否终止任务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stop");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("失败是否终止任务"); 
		return column;
	}
	/**
	 * 获取转换方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTransform_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Transform_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转换方式"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSerial_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Serial_number");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取表名称_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTablename_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tablename_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("表名称_源"); 
		return column;
	}
	/**
	 * 获取对照编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码"); 
		return column;
	}
	/**
	 * 获取对照名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照名称"); 
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
