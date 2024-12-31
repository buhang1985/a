
package iih.bd.srv.medvalidate.d.desc;

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
 * 基础数据错误信息物品表 DO 元数据信息
 */
public class BDErrorInfoItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.medvalidate.d.BDErrorInfoItemDO";
	public static final String CLASS_DISPALYNAME = "基础数据错误信息物品表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_errorinfo_item";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_errorinfo_item";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BDErrorInfoItemDODesc(){
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
		this.setKeyDesc(getId_errorinfo_itemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_errorinfoADesc(tblDesc));
		this.add(getId_errorinfo_itemADesc(tblDesc));
		this.add(getId_errorinfoADesc(tblDesc));
		this.add(getId_itemADesc(tblDesc));
		this.add(getName_itemADesc(tblDesc));
		this.add(getError_infoADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_errorinfo_itemCDesc(tblDesc));
		tblDesc.add(getId_errorinfo_itemCDesc(tblDesc));
		tblDesc.add(getId_errorinfoCDesc(tblDesc));
		tblDesc.add(getId_itemCDesc(tblDesc));
		tblDesc.add(getName_itemCDesc(tblDesc));
		tblDesc.add(getError_infoCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 校验关系表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_errorinfo_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_errorinfo_item",  getId_errorinfo_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("校验关系表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_errorinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_errorinfo",  getId_errorinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_item",  getId_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_item",  getName_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 错误信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getError_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Error_info",  getError_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("错误信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取校验关系表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_errorinfo_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_errorinfo_item");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("校验关系表主键"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_errorinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_errorinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取服务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_item");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务ID"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_item");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取错误信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getError_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Error_info");
		column.setLength(1024);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("错误信息"); 
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
	
}
