
package iih.pe.pitm.pesrvchkprecede.d.desc;

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
 * 体检检查前置关系 DO 元数据信息
 */
public class PeSrvChkPrecedeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pesrvchkprecede.d.PeSrvChkPrecedeDO";
	public static final String CLASS_DISPALYNAME = "体检检查前置关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_pesrvchkprecede";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesrvchkprecede";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSrvChkPrecedeDODesc(){
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
		this.setKeyDesc(getId_pesrvchkprecedeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pesrvchkprecedeADesc(tblDesc));
		this.add(getId_pesrvitem_prevADesc(tblDesc));
		this.add(getId_pesrvitem_depeADesc(tblDesc));
		this.add(getCode_prevADesc(tblDesc));
		this.add(getName_prevADesc(tblDesc));
		this.add(getCode_depeADesc(tblDesc));
		this.add(getName_depeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesrvchkprecedeCDesc(tblDesc));
		tblDesc.add(getId_pesrvchkprecedeCDesc(tblDesc));
		tblDesc.add(getId_pesrvitem_prevCDesc(tblDesc));
		tblDesc.add(getId_pesrvitem_depeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检结果小项检查前置主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvchkprecedeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvchkprecede",  getId_pesrvchkprecedeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果小项检查前置主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检结果-前置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitem_prevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem_prev",  getId_pesrvitem_prevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果-前置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检结果-依赖属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvitem_depeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvitem_depe",  getId_pesrvitem_depeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检结果-依赖");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 前置项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_prevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_prev",  getCode_prevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("前置项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b3","id_pesrvitem_prev=id_pesrvitem","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 前置项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_prevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_prev",  getName_prevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("前置项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b3","id_pesrvitem_prev=id_pesrvitem","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 依赖项目编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_depeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_depe",  getCode_depeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("依赖项目编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b2","id_pesrvitem_depe=id_pesrvitem","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 依赖项目名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_depe",  getName_depeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("依赖项目名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvitem a0b2","id_pesrvitem_depe=id_pesrvitem","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检结果小项检查前置主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvchkprecedeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvchkprecede");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检结果小项检查前置主键标识"); 
		return column;
	}
	/**
	 * 获取体检结果-前置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitem_prevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem_prev");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果-前置"); 
		return column;
	}
	/**
	 * 获取体检结果-依赖表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvitem_depeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvitem_depe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检结果-依赖"); 
		return column;
	}
	/**
	 * 获取前置项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_prevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_prev");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("前置项目编码"); 
		return column;
	}
	/**
	 * 获取前置项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_prevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_prev");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("前置项目名称"); 
		return column;
	}
	/**
	 * 获取依赖项目编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_depeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_depe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("依赖项目编码"); 
		return column;
	}
	/**
	 * 获取依赖项目名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_depe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("依赖项目名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesrvchkprecede");
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
