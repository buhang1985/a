
package iih.pe.pbd.qrycond.d.desc;

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
 * 查询条件项目 DO 元数据信息
 */
public class QryCondItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pbd.qrycond.d.QryCondItmDO";
	public static final String CLASS_DISPALYNAME = "查询条件项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "PE_PBD_QYR_COND_ITM";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_qry_cond_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public QryCondItmDODesc(){
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
		this.setKeyDesc(getId_qry_cond_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_qry_condADesc(tblDesc));
		this.add(getId_qry_cond_itmADesc(tblDesc));
		this.add(getId_qry_condADesc(tblDesc));
		this.add(getId_condtpADesc(tblDesc));
		this.add(getSd_condtpADesc(tblDesc));
		this.add(getId_operatpADesc(tblDesc));
		this.add(getSd_operatpADesc(tblDesc));
		this.add(getId_valADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_condtpADesc(tblDesc));
		this.add(getFilter_conditonADesc(tblDesc));
		this.add(getFilter_relationADesc(tblDesc));
		this.add(getName_operatpADesc(tblDesc));
		this.add(getFilter_condtpADesc(tblDesc));
		this.add(getName_valADesc(tblDesc));
		this.add(getVal_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_qry_cond_itmCDesc(tblDesc));
		tblDesc.add(getId_qry_cond_itmCDesc(tblDesc));
		tblDesc.add(getId_qry_condCDesc(tblDesc));
		tblDesc.add(getId_condtpCDesc(tblDesc));
		tblDesc.add(getSd_condtpCDesc(tblDesc));
		tblDesc.add(getId_operatpCDesc(tblDesc));
		tblDesc.add(getSd_operatpCDesc(tblDesc));
		tblDesc.add(getId_valCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 查询条件项目ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qry_cond_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qry_cond_itm",  getId_qry_cond_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询条件项目ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询条件ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_qry_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_qry_cond",  getId_qry_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询条件ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 候选条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_condtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_condtp",  getId_condtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("候选条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 候选条件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_condtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_condtp",  getSd_condtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("候选条件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运算关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operatp",  getId_operatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运算关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 运算关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_operatp",  getSd_operatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运算关系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ID值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_val",  getId_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ID值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("值");
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
	 * 候选条件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_condtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_condtp",  getName_condtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("候选条件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_condtp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过滤条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilter_conditonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filter_conditon",  getFilter_conditonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过滤条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_condtp=id_udidoc","ctrl2"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilter_relationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filter_relation",  getFilter_relationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_condtp=id_udidoc","ctrl3"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运算关系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operatpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operatp",  getName_operatpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运算关系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_operatp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 候选条件过滤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFilter_condtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Filter_condtp",  getFilter_condtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("候选条件过滤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_operatp=id_udidoc","ctrl1"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 条件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_valADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_val",  getName_valCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("条件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"PE_PBD_QYR a1b7","id_val=id_qry","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询方案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_code",  getVal_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询方案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"PE_PBD_QYR a1b7","id_val=id_qry","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取查询条件项目ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qry_cond_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qry_cond_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("查询条件项目ID"); 
		return column;
	}
	/**
	 * 获取查询条件ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_qry_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_qry_cond");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查询条件ID"); 
		return column;
	}
	/**
	 * 获取候选条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_condtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_condtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("候选条件"); 
		return column;
	}
	/**
	 * 获取候选条件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_condtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_condtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("候选条件编码"); 
		return column;
	}
	/**
	 * 获取运算关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operatp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运算关系"); 
		return column;
	}
	/**
	 * 获取运算关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_operatp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运算关系编码"); 
		return column;
	}
	/**
	 * 获取ID值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_val");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ID值"); 
		return column;
	}
	/**
	 * 获取值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("值"); 
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
	 * 获取候选条件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_condtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_condtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("候选条件名称"); 
		return column;
	}
	/**
	 * 获取过滤条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilter_conditonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filter_conditon");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过滤条件"); 
		return column;
	}
	/**
	 * 获取扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilter_relationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filter_relation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
		return column;
	}
	/**
	 * 获取运算关系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operatpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operatp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运算关系名称"); 
		return column;
	}
	/**
	 * 获取候选条件过滤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFilter_condtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Filter_condtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("候选条件过滤"); 
		return column;
	}
	/**
	 * 获取条件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_valCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_val");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("条件"); 
		return column;
	}
	/**
	 * 获取查询方案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查询方案编号"); 
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
	
}
