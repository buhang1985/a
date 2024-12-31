
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
 * 对照项目 DO 元数据信息
 */
public class ValueContrastDetailDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrm.healthsystem.d.ValueContrastDetailDO";
	public static final String CLASS_DISPALYNAME = "对照项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mrm_value_contrast_detail";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_value_comparison_detail";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ValueContrastDetailDODesc(){
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
		this.setKeyDesc(getId_value_comparison_detailADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_value_comparisonADesc(tblDesc));
		this.add(getId_value_comparison_detailADesc(tblDesc));
		this.add(getId_value_comparisonADesc(tblDesc));
		this.add(getCode_sourceADesc(tblDesc));
		this.add(getValue_sourceADesc(tblDesc));
		this.add(getCode_goalADesc(tblDesc));
		this.add(getValue_goalADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_value_comparison_detailCDesc(tblDesc));
		tblDesc.add(getId_value_comparison_detailCDesc(tblDesc));
		tblDesc.add(getId_value_comparisonCDesc(tblDesc));
		tblDesc.add(getCode_sourceCDesc(tblDesc));
		tblDesc.add(getValue_sourceCDesc(tblDesc));
		tblDesc.add(getCode_goalCDesc(tblDesc));
		tblDesc.add(getValue_goalCDesc(tblDesc));
		tblDesc.add(getSerial_numberCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 对照项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_value_comparison_detailADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_value_comparison_detail",  getId_value_comparison_detailCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照项目主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 对照外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_value_comparisonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_value_comparison",  getId_value_comparisonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("对照外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 项目编码_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_source",  getCode_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目编码_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目名称_源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_source",  getValue_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称_源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目编码_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_goal",  getCode_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目编码_目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目名称_目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue_goalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value_goal",  getValue_goalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目名称_目标");
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
	 * 获取对照项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_value_comparison_detailCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_value_comparison_detail");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("对照项目主键"); 
		return column;
	}
	/**
	 * 获取对照外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_value_comparisonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_value_comparison");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("对照外键"); 
		return column;
	}
	/**
	 * 获取项目编码_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目编码_源"); 
		return column;
	}
	/**
	 * 获取项目名称_源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称_源"); 
		return column;
	}
	/**
	 * 获取项目编码_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目编码_目标"); 
		return column;
	}
	/**
	 * 获取项目名称_目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue_goalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value_goal");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目名称_目标"); 
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
