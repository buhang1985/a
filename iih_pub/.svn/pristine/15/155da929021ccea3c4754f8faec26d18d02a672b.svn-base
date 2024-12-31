
package iih.pis.phk.enguidmodtabdo.d.desc;

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
 * 导诊模块页签配置 DO 元数据信息
 */
public class EnGuidModTabDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pis.phk.enguidmodtabdo.d.EnGuidModTabDO";
	public static final String CLASS_DISPALYNAME = "导诊模块页签配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_guid_mode_tab";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_guidtab";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnGuidModTabDODesc(){
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
		this.setKeyDesc(getId_guidtabADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_guidtabADesc(tblDesc));
		this.add(getId_guidcofADesc(tblDesc));
		this.add(getCode_tabADesc(tblDesc));
		this.add(getName_tabADesc(tblDesc));
		this.add(getImg_tabADesc(tblDesc));
		this.add(getText_tabADesc(tblDesc));
		this.add(getQrysqlADesc(tblDesc));
		this.add(getSeviceADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getName_modADesc(tblDesc));
		this.add(getCode_modADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_guidtabCDesc(tblDesc));
		tblDesc.add(getId_guidtabCDesc(tblDesc));
		tblDesc.add(getId_guidcofCDesc(tblDesc));
		tblDesc.add(getCode_tabCDesc(tblDesc));
		tblDesc.add(getName_tabCDesc(tblDesc));
		tblDesc.add(getImg_tabCDesc(tblDesc));
		tblDesc.add(getText_tabCDesc(tblDesc));
		tblDesc.add(getQrysqlCDesc(tblDesc));
		tblDesc.add(getSeviceCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 页签主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_guidtabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_guidtab",  getId_guidtabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("页签主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导诊配置主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_guidcofADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_guidcof",  getId_guidcofCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导诊配置主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 页签编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_tabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_tab",  getCode_tabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("页签编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 页签名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tab",  getName_tabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("页签名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 页签图片属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImg_tabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Img_tab",  getImg_tabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("页签图片");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 页签文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_tabADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_tab",  getText_tabCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("页签文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 查询sql属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQrysqlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qrysql",  getQrysqlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("查询sql");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调用服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSeviceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sevice",  getSeviceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调用服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模块名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_modADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mod",  getName_modCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模块名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_guid_mod a0b2","id_guidcof=id_guidcof","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模块编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_modADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mod",  getCode_modCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模块编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_guid_mod a0b2","id_guidcof=id_guidcof","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取页签主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_guidtabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_guidtab");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("页签主键"); 
		return column;
	}
	/**
	 * 获取导诊配置主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_guidcofCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_guidcof");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导诊配置主键"); 
		return column;
	}
	/**
	 * 获取页签编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_tabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_tab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("页签编码"); 
		return column;
	}
	/**
	 * 获取页签名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tab");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("页签名称"); 
		return column;
	}
	/**
	 * 获取页签图片表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImg_tabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Img_tab");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("页签图片"); 
		return column;
	}
	/**
	 * 获取页签文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_tabCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_tab");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("页签文本"); 
		return column;
	}
	/**
	 * 获取查询sql表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQrysqlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qrysql");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("查询sql"); 
		return column;
	}
	/**
	 * 获取调用服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSeviceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sevice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调用服务"); 
		return column;
	}
	/**
	 * 获取启用状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用状态"); 
		return column;
	}
	/**
	 * 获取模块名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_modCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mod");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模块名称"); 
		return column;
	}
	/**
	 * 获取模块编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_modCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mod");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模块编码"); 
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
