
package iih.pe.pitm.pesetcopy.d.desc;

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
 * 体检套餐复制 DO 元数据信息
 */
public class PeSetCopyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesetcopy.d.PeSetCopyDO";
	public static final String CLASS_DISPALYNAME = "体检套餐复制";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesetcopy";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSetCopyDODesc(){
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
		this.setKeyDesc(getId_pesetcopyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pesetcopyADesc(tblDesc));
		this.add(getId_fromADesc(tblDesc));
		this.add(getId_toADesc(tblDesc));
		this.add(getCode_fromADesc(tblDesc));
		this.add(getName_fromADesc(tblDesc));
		this.add(getCode_toADesc(tblDesc));
		this.add(getName_toADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesetcopyCDesc(tblDesc));
		tblDesc.add(getId_pesetcopyCDesc(tblDesc));
		tblDesc.add(getId_fromCDesc(tblDesc));
		tblDesc.add(getId_toCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检套餐复制主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesetcopyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesetcopy",  getId_pesetcopyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检套餐复制主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 源套餐ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_from",  getId_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("源套餐ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 目标套餐ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_to",  getId_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标套餐ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_from",  getCode_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvsetdef a0b2","id_from=id_pesrvsetdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检套餐名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_from",  getName_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检套餐名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvsetdef a0b2","id_from=id_pesrvsetdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_to",  getCode_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvsetdef a0b3","id_to=id_pesrvsetdef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检套餐名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_to",  getName_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检套餐名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvsetdef a0b3","id_to=id_pesrvsetdef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检套餐复制主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesetcopyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesetcopy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检套餐复制主键标识"); 
		return column;
	}
	/**
	 * 获取源套餐ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_from");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("源套餐ID"); 
		return column;
	}
	/**
	 * 获取目标套餐ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标套餐ID"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取体检套餐名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检套餐名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取体检套餐名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检套餐名称"); 
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
