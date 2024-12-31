
package iih.bd.srv.emrtpl.d.desc;

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
 * 基础数据_医疗服务 DO 元数据信息
 */
public class MrtplFSDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.emrtpl.d.MrtplFSDO";
	public static final String CLASS_DISPALYNAME = "基础数据_医疗服务";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_MRTPL_FS";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_mrtplfs";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrtplFSDODesc(){
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
		this.setKeyDesc(getId_mrtplfsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_mrtplADesc(tblDesc));
		this.add(getId_mrtplfsADesc(tblDesc));
		this.add(getFsADesc(tblDesc));
		this.add(getXmlADesc(tblDesc));
		this.add(getId_mrtplADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mrtplfsCDesc(tblDesc));
		tblDesc.add(getId_mrtplfsCDesc(tblDesc));
		tblDesc.add(getFsCDesc(tblDesc));
		tblDesc.add(getXmlCDesc(tblDesc));
		tblDesc.add(getId_mrtplCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 文件主键ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtplfsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtplfs",  getId_mrtplfsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文件主键ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流数据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fs",  getFsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流数据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板XML内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXmlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xml",  getXmlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板XML内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 模板主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl",  getId_mrtplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取文件主键ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtplfsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtplfs");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("文件主键ID"); 
		return column;
	}
	/**
	 * 获取流数据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fs");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流数据"); 
		return column;
	}
	/**
	 * 获取模板XML内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXmlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xml");
		column.setLength(0);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板XML内容"); 
		return column;
	}
	/**
	 * 获取模板主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板主键"); 
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
