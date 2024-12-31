
package iih.bd.srv.mrtplvst.d.desc;

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
 * 体征模板项目关系 DO 元数据信息
 */
public class BdMrtplVstItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO";
	public static final String CLASS_DISPALYNAME = "体征模板项目关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrtpl_vst_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrtpl_vst_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdMrtplVstItmDODesc(){
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
		this.setKeyDesc(getId_mrtpl_vst_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_mrtpl_vstADesc(tblDesc));
		this.add(getId_mrtpl_vst_itmADesc(tblDesc));
		this.add(getId_mrtpl_vstADesc(tblDesc));
		this.add(getId_mrtpl_vsADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getDef1ADesc(tblDesc));
		this.add(getDef2ADesc(tblDesc));
		this.add(getDef3ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_mrtplvstADesc(tblDesc));
		this.add(getName_mrtplvsADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrtpl_vst_itmCDesc(tblDesc));
		tblDesc.add(getId_mrtpl_vst_itmCDesc(tblDesc));
		tblDesc.add(getId_mrtpl_vstCDesc(tblDesc));
		tblDesc.add(getId_mrtpl_vsCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getDef1CDesc(tblDesc));
		tblDesc.add(getDef2CDesc(tblDesc));
		tblDesc.add(getDef3CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体征模板项目ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpl_vst_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl_vst_itm",  getId_mrtpl_vst_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征模板项目ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpl_vstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl_vst",  getId_mrtpl_vstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体征项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpl_vsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl_vs",  getId_mrtpl_vsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项目");
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
	 * 体征模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrtplvstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrtplvst",  getName_mrtplvstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_vst a1b2","id_mrtpl_vst=id_mrtpl_vst","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体征项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrtplvsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrtplvs",  getName_mrtplvsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl_vs a1b3","id_mrtpl_vs=id_mrtpl_vs","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体征模板项目ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpl_vst_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl_vst_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体征模板项目ID"); 
		return column;
	}
	/**
	 * 获取体征模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpl_vstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl_vst");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征模板"); 
		return column;
	}
	/**
	 * 获取体征项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpl_vsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl_vs");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征项目"); 
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
	 * 获取扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def1");
		column.setLength(110);
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
		column.setLength(110);
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
		column.setLength(110);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扩展字段3"); 
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
	 * 获取体征模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrtplvstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrtplvst");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征模板名称"); 
		return column;
	}
	/**
	 * 获取体征项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrtplvsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrtplvs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体征项目名称"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}