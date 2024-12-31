
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
 * 表转换 DO 元数据信息
 */
public class DocContrastDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.healthsystem.d.DocContrastDO";
	public static final String CLASS_DISPALYNAME = "表转换";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_doc_contrast";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_doc_comparison";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public DocContrastDODesc(){
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
		this.setKeyDesc(getId_doc_comparisonADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_extractdataADesc(tblDesc));
		this.add(getId_doc_comparisonADesc(tblDesc));
		this.add(getId_comparisonADesc(tblDesc));
		this.add(getComparison_typeADesc(tblDesc));
		this.add(getDoccode_sourceADesc(tblDesc));
		this.add(getDocname_sourceADesc(tblDesc));
		this.add(getDoccode_goalADesc(tblDesc));
		this.add(getDocname_goalADesc(tblDesc));
		this.add(getId_extractdataADesc(tblDesc));
		this.add(getCode_doc_comparisonADesc(tblDesc));
		this.add(getName_doc_comparisonADesc(tblDesc));
		this.add(getQuery_typeADesc(tblDesc));
		this.add(getName_tab_goalADesc(tblDesc));
		this.add(getFg_clearADesc(tblDesc));
		this.add(getFg_stopADesc(tblDesc));
		this.add(getQuery_planADesc(tblDesc));
		this.add(getSerial_numberADesc(tblDesc));
		this.add(getCode_extractdataADesc(tblDesc));
		this.add(getName_extractdataADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_doc_comparisonCDesc(tblDesc));
		tblDesc.add(getId_doc_comparisonCDesc(tblDesc));
		tblDesc.add(getId_comparisonCDesc(tblDesc));
		tblDesc.add(getComparison_typeCDesc(tblDesc));
		tblDesc.add(getDoccode_sourceCDesc(tblDesc));
		tblDesc.add(getDocname_sourceCDesc(tblDesc));
		tblDesc.add(getDoccode_goalCDesc(tblDesc));
		tblDesc.add(getDocname_goalCDesc(tblDesc));
		tblDesc.add(getId_extractdataCDesc(tblDesc));
		tblDesc.add(getCode_doc_comparisonCDesc(tblDesc));
		tblDesc.add(getName_doc_comparisonCDesc(tblDesc));
		tblDesc.add(getQuery_typeCDesc(tblDesc));
		tblDesc.add(getName_tab_goalCDesc(tblDesc));
		tblDesc.add(getFg_clearCDesc(tblDesc));
		tblDesc.add(getFg_stopCDesc(tblDesc));
		tblDesc.add(getQuery_planCDesc(tblDesc));
		tblDesc.add(getSerial_numberCDesc(tblDesc));
		tblDesc.add(getCode_extractdataCDesc(tblDesc));
		tblDesc.add(getName_extractdataCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 表转换主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_comparison",  getId_doc_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("表转换主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照外键（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_comparison",  getId_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照外键（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照类型（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComparison_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comparison_type",  getComparison_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照类型（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档编码_源（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoccode_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doccode_source",  getDoccode_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档编码_源（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档名称_源（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDocname_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Docname_source",  getDocname_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档名称_源（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档编码_目标（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDoccode_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Doccode_goal",  getDoccode_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档编码_目标（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文档名称_目标（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDocname_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Docname_goal",  getDocname_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文档名称_目标（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据抽取任务外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_extractdataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_extractdata",  getId_extractdataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据抽取任务外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 转换编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_doc_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_doc_comparison",  getCode_doc_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转换编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转换名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_doc_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doc_comparison",  getName_doc_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("转换名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuery_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Query_type",  getQuery_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标表名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tab_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tab_goal",  getName_tab_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标表名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标表存在时是否清空原有数据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_clearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_clear",  getFg_clearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("目标表存在时是否清空原有数据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 失败时是否终止任务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_stopADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_stop",  getFg_stopCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("失败时是否终止任务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询方案属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuery_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Query_plan",  getQuery_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询方案");
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
	 * 数据抽取任务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_extractdataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_extractdata",  getCode_extractdataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据抽取任务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据抽取任务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_extractdataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_extractdata",  getName_extractdataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据抽取任务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取表转换主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_comparison");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("表转换主键"); 
		return column;
	}
	/**
	 * 获取对照外键（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_comparison");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照外键（废弃）"); 
		return column;
	}
	/**
	 * 获取对照类型（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComparison_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comparison_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照类型（废弃）"); 
		return column;
	}
	/**
	 * 获取文档编码_源（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoccode_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doccode_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档编码_源（废弃）"); 
		return column;
	}
	/**
	 * 获取文档名称_源（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDocname_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Docname_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档名称_源（废弃）"); 
		return column;
	}
	/**
	 * 获取文档编码_目标（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDoccode_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Doccode_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档编码_目标（废弃）"); 
		return column;
	}
	/**
	 * 获取文档名称_目标（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDocname_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Docname_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文档名称_目标（废弃）"); 
		return column;
	}
	/**
	 * 获取数据抽取任务外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_extractdataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_extractdata");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据抽取任务外键"); 
		return column;
	}
	/**
	 * 获取转换编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_doc_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_doc_comparison");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转换编码"); 
		return column;
	}
	/**
	 * 获取转换名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_doc_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doc_comparison");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("转换名称"); 
		return column;
	}
	/**
	 * 获取查询类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuery_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Query_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查询类型"); 
		return column;
	}
	/**
	 * 获取目标表名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tab_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tab_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标表名"); 
		return column;
	}
	/**
	 * 获取目标表存在时是否清空原有数据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_clearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_clear");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("目标表存在时是否清空原有数据"); 
		return column;
	}
	/**
	 * 获取失败时是否终止任务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_stopCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_stop");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("失败时是否终止任务"); 
		return column;
	}
	/**
	 * 获取查询方案表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuery_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Query_plan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查询方案"); 
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
	 * 获取数据抽取任务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_extractdataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_extractdata");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据抽取任务编码"); 
		return column;
	}
	/**
	 * 获取数据抽取任务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_extractdataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_extractdata");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据抽取任务名称"); 
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
