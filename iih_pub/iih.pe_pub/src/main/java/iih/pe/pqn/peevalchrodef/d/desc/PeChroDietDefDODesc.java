
package iih.pe.pqn.peevalchrodef.d.desc;

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
 * 体检慢性病饮食处方定义 DO 元数据信息
 */
public class PeChroDietDefDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pqn.peevalchrodef.d.PeChroDietDefDO";
	public static final String CLASS_DISPALYNAME = "体检慢性病饮食处方定义";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_qn_pechrodietdef";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_pechrodietdef";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeChroDietDefDODesc(){
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
		this.setKeyDesc(getId_pechrodietdefADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peevalchrodefADesc(tblDesc));
		this.add(getId_pechrodietdefADesc(tblDesc));
		this.add(getId_peevalchrodefADesc(tblDesc));
		this.add(getId_penarraterecipeADesc(tblDesc));
		this.add(getCode_dietADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pechrodietdefCDesc(tblDesc));
		tblDesc.add(getId_pechrodietdefCDesc(tblDesc));
		tblDesc.add(getId_peevalchrodefCDesc(tblDesc));
		tblDesc.add(getId_penarraterecipeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检慢性病关联饮食处方定义主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pechrodietdefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pechrodietdef",  getId_pechrodietdefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病关联饮食处方定义主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检慢性病定义ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peevalchrodefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peevalchrodef",  getId_peevalchrodefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检慢性病定义ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检叙述型营养处方ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_penarraterecipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_penarraterecipe",  getId_penarraterecipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检叙述型营养处方ID");
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
	private IAttrDesc getCode_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_diet",  getCode_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_penarraterecipe a4b2","id_penarraterecipe=id_penarraterecipe","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_penarraterecipe a4b2","id_penarraterecipe=id_penarraterecipe","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检慢性病关联饮食处方定义主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pechrodietdefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pechrodietdef");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病关联饮食处方定义主键标识"); 
		return column;
	}
	/**
	 * 获取体检慢性病定义ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peevalchrodefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peevalchrodef");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检慢性病定义ID"); 
		return column;
	}
	/**
	 * 获取体检叙述型营养处方ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_penarraterecipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_penarraterecipe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检叙述型营养处方ID"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_diet");
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
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pechrodietdef");
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
