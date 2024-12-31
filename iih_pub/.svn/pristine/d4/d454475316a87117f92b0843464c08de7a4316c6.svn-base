
package iih.bd.srv.ortpl.d.desc;

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
 * 医嘱模板与分类关系 DO 元数据信息
 */
public class OrTmplCaRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.ortpl.d.OrTmplCaRelDO";
	public static final String CLASS_DISPALYNAME = "医嘱模板与分类关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_srv_ortmpl_ca_rel";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ortmplcarel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrTmplCaRelDODesc(){
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
		this.setKeyDesc(getId_ortmplcarelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ortmplcarelADesc(tblDesc));
		this.add(getId_ortmplcaADesc(tblDesc));
		this.add(getId_ortmplADesc(tblDesc));
		this.add(getFg_syncADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_ortmplcarelCDesc(tblDesc));
		tblDesc.add(getId_ortmplcarelCDesc(tblDesc));
		tblDesc.add(getId_ortmplcaCDesc(tblDesc));
		tblDesc.add(getId_ortmplCDesc(tblDesc));
		tblDesc.add(getFg_syncCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱模板与分类关系主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ortmplcarelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ortmplcarel",  getId_ortmplcarelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板与分类关系主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱模板分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ortmplcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ortmplca",  getId_ortmplcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医嘱模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ortmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ortmpl",  getId_ortmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 引用标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_syncADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sync",  getFg_syncCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("引用标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱模板与分类关系主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ortmplcarelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ortmplcarel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板与分类关系主键标识"); 
		return column;
	}
	/**
	 * 获取医嘱模板分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ortmplcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ortmplca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板分类"); 
		return column;
	}
	/**
	 * 获取医嘱模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ortmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ortmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱模板"); 
		return column;
	}
	/**
	 * 获取引用标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_syncCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sync");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("引用标识"); 
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
