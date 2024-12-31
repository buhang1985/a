
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
 * 对照 DO 元数据信息
 */
public class ValueContrastDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.healthsystem.d.ValueContrastDO";
	public static final String CLASS_DISPALYNAME = "对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_value_contrast";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_value_comparison";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ValueContrastDODesc(){
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
		this.setKeyDesc(getId_value_comparisonADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_value_comparisonADesc(tblDesc));
		this.add(getValue_comparison_codeADesc(tblDesc));
		this.add(getValue_comparison_nameADesc(tblDesc));
		this.add(getSd_value_comparisonADesc(tblDesc));
		this.add(getName_value_comparisonADesc(tblDesc));
		this.add(getId_comparisonADesc(tblDesc));
		this.add(getComparison_code_sourceADesc(tblDesc));
		this.add(getComparison_name_sourceADesc(tblDesc));
		this.add(getComparison_code_goalADesc(tblDesc));
		this.add(getComparison_name_goalADesc(tblDesc));
		this.add(getValue_comparison_explainADesc(tblDesc));
		this.add(getSerial_numberADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_value_comparisonCDesc(tblDesc));
		tblDesc.add(getId_value_comparisonCDesc(tblDesc));
		tblDesc.add(getValue_comparison_codeCDesc(tblDesc));
		tblDesc.add(getValue_comparison_nameCDesc(tblDesc));
		tblDesc.add(getSd_value_comparisonCDesc(tblDesc));
		tblDesc.add(getName_value_comparisonCDesc(tblDesc));
		tblDesc.add(getId_comparisonCDesc(tblDesc));
		tblDesc.add(getComparison_code_sourceCDesc(tblDesc));
		tblDesc.add(getComparison_name_sourceCDesc(tblDesc));
		tblDesc.add(getComparison_code_goalCDesc(tblDesc));
		tblDesc.add(getComparison_name_goalCDesc(tblDesc));
		tblDesc.add(getValue_comparison_explainCDesc(tblDesc));
		tblDesc.add(getSerial_numberCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 对照主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_value_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_value_comparison",  getId_value_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值对照编码（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_comparison_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_comparison_code",  getValue_comparison_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值对照编码（废弃）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值对照名称（废弃）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_comparison_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_comparison_name",  getValue_comparison_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值对照名称（废弃）");
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
	 * 对照分类外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_comparison",  getId_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照分类外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对照编码_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComparison_code_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comparison_code_source",  getComparison_code_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照名称_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComparison_name_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comparison_name_source",  getComparison_name_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照名称_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照编码_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComparison_code_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comparison_code_goal",  getComparison_code_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照编码_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照名称_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComparison_name_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comparison_name_goal",  getComparison_name_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照名称_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_comparison_explainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_comparison_explain",  getValue_comparison_explainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照说明");
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
	 * 获取对照主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_value_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_value_comparison");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对照主键"); 
		return column;
	}
	/**
	 * 获取值对照编码（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_comparison_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_comparison_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值对照编码（废弃）"); 
		return column;
	}
	/**
	 * 获取值对照名称（废弃）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_comparison_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_comparison_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值对照名称（废弃）"); 
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
	 * 获取对照分类外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_comparison");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照分类外键"); 
		return column;
	}
	/**
	 * 获取对照编码_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComparison_code_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comparison_code_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码_源"); 
		return column;
	}
	/**
	 * 获取对照名称_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComparison_name_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comparison_name_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照名称_源"); 
		return column;
	}
	/**
	 * 获取对照编码_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComparison_code_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comparison_code_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照编码_目标"); 
		return column;
	}
	/**
	 * 获取对照名称_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComparison_name_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comparison_name_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照名称_目标"); 
		return column;
	}
	/**
	 * 获取对照说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_comparison_explainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_comparison_explain");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照说明"); 
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
